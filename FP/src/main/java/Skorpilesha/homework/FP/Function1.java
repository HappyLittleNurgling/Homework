package Skorpilesha.homework.FP;

/**
 * Created by Юзер on 17.10.2016.
 */
public abstract class Function1 <T, U> {
    public abstract T apply (U parameter);
    public <V> Function1<V, U> compose (final Function1<V, T> g) {
        return new Function1<V, U> () {
            public V apply(U parameter) {
                return g.apply(Function1.this.apply(parameter));
            }
        };
    }

}