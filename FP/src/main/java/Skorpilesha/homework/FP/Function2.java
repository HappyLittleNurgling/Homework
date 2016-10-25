package Skorpilesha.homework.FP;


/**
 * An abstract class for function of two parameters
 * @param <T>
 *     type of returned value
 * @param <U>
 *     type of first parameter
 * @param <V>
 *     type of second parameter
 */
public abstract class Function2 <T, U, V> {
    /**
     * Applies function to given parameters
     * @param param1
     * first parameter
     * @param param2
     * second parameter
     * @return
     * returns an object of class T
     */
    public abstract T apply (U param1, V param2);

    /**
     * This method gets an object of V class and creates a Function1-class object, which is basically what this Function2 would look like
     * if the second parameter is fixed to the given value
     * @param param2
     * second parameter, which is to be fixed
     * @return
     * returns a Function1<T, U>-class object
     */
    public Function1<T, U> bind2 (final V param2) {
        return new Function1<T, U>() {
            public V storedParam2 = param2;
            @Override
            public T apply(U parameter) {
                return Function2.this.apply(parameter, storedParam2);
            }
        };
    }

    /**
     * completely similar to the previous method, but binds first parameter instead
     */
    public Function1<T, V> bind1 (final U param1) {
        return new Function1<T, V>() {
            public U storedParam1 = param1;
            @Override
            public T apply(V parameter) {
                return Function2.this.apply(storedParam1, parameter);
            }
        };
    }

    /**
     * gets a function g(T) and returns a function, which is g(f(U, V))
     * @param g
     * the second function, is an istance of Function1<S, T>, where
     * @param <S>
     *     is a desired type of returned value
     * @return
     * returns Function2<S, U, V>
     */
    public <S> Function2<S, U, V> compose (final Function1<S, T> g) {
        return new Function2<S, U, V>() {
            @Override
            public S apply(U param1, V param2) {
                return g.apply(Function2.this.apply(param1, param2));
            }
        };
    }

    /**
     * Makes this function a composition of two Function1-s
     * @return
     * returns a Function1<Function1<T, V>, U>
     */
    public Function1<Function1<T, V>, U> curry () {
        return new Function1<Function1<T, V>, U>() {
            @Override
            public Function1<T, V> apply(U parameter) {
                return Function2.this.bind1(parameter);
            }
        };
    }
}