package Skorpilesha.homework.FP;

import javafx.util.Pair;

public abstract class Function2 <T, U, V> {
    public abstract T apply (U param1, V param2);
    public Function1<T, U> bind2 (final V param2) {
        return new Function1<T, U>() {
            public V storedParam2 = param2;
            @Override
            public T apply(U parameter) {
                return Function2.this.apply(parameter, storedParam2);
            }
        };
    }
    public Function1<T, V> bind1 (final U param1) {
        return new Function1<T, V>() {
            public U storedParam1 = param1;
            @Override
            public T apply(V parameter) {
                return Function2.this.apply(storedParam1, parameter);
            }
        };
    }
    public <S> Function2<S, U, V> compose (final Function1<S, T> g) {
        return new Function2<S, U, V>() {
            @Override
            public S apply(U param1, V param2) {
                return g.apply(Function2.this.apply(param1, param2));
            }
        };
    }
    public Function1<Function1<T, V>, U> curry () {
        return new Function1<Function1<T, V>, U>() {
            @Override
            public Function1<T, V> apply(U parameter) {
                return Function2.this.bind1(parameter);
            }
        };
    }
}