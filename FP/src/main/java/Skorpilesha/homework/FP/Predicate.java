package Skorpilesha.homework.FP;

public abstract class Predicate<T> extends Function1<Boolean, T> {
    public Predicate<T> and (final Predicate<T> second) {
        return new Predicate<T>() {
            @Override
            public Boolean apply(T parameter) {
                return Predicate.this.apply(parameter) && second.apply(parameter);
            }
        };
    }
    public Predicate<T> or (final Predicate<T> second) {
        return new Predicate<T>() {
            @Override
            public Boolean apply(T parameter) {
                return Predicate.this.apply(parameter) || second.apply(parameter);
            }
        };
    }
    public Predicate<T> not () {
        return new Predicate<T>() {
            @Override
            public Boolean apply(T parameter) {
                return !Predicate.this.apply(parameter);
            }
        };
    }
    public static final Predicate<Object> ALWAYS_TRUE = new Predicate<Object>() {
        @Override
        public Boolean apply(Object parameter) {
            return true;
        }
    };
    public static final Predicate<Object> ALWAYS_FALSE = new Predicate<Object>() {
        @Override
        public Boolean apply(Object parameter) {
            return false;
        }
    };
}

