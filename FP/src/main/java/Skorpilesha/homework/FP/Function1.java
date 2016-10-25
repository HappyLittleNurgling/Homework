package Skorpilesha.homework.FP;

/**
 * An abstract class for function of one parameter
 * @param <T>
 *     the type of returned value
 * @param <U>
 *     the type of parameter
 */
public abstract class Function1 <T, U> {
    /**
     * Applies the function to the given
     * @param parameter
     * which is a U-class object
     * @return
     * returns a T-class object
     */
    public abstract T apply (U parameter);

    /**
     * gets a function g(T) and returns a new function, which is equal to g(f(U))
     * @param g
     * the second function which returns an object of class
     * @param <V>
     * @return
     * returns a Function1<V, U>
     */
    public <V> Function1<V, U> compose (final Function1<V, T> g) {
        return new Function1<V, U> () {
            public V apply(U parameter) {
                return g.apply(Function1.this.apply(parameter));
            }
        };
    }

}