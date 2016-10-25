package Skorpilesha.homework.FP;

/**
 *
 * @param <T>
 *     An abstract class for one-parametered predicate
 *     extends Function1<Boolean, T> for obvious reason
 */
public abstract class Predicate<T> extends Function1<Boolean, T> {
    /**
     * method and, which allows to get a conjunction of two predicates
     * @param second
     * second predicate
     * @return
     *returns an anonimous Predicate
     */
    public Predicate<T> and (final Predicate<T> second) {
        return new Predicate<T>() {
            @Override
            public Boolean apply(T parameter) {
                return Predicate.this.apply(parameter) && second.apply(parameter);
            }
        };
    }
    /**
     * method or, which allows to get a disjunction of two predicates
     * @param second
     * second predicate
     * @return
     *returns an anonimous Predicate
     */
    public Predicate<T> or (final Predicate<T> second) {
        return new Predicate<T>() {
            @Override
            public Boolean apply(T parameter) {
                return Predicate.this.apply(parameter) || second.apply(parameter);
            }
        };
    }
    /**
     * method not, which allows to get a predicate, opposite to the current one
     * @return
     *returns an anonimous Predicate
     */
    public Predicate<T> not () {
        return new Predicate<T>() {
            @Override
            public Boolean apply(T parameter) {
                return !Predicate.this.apply(parameter);
            }
        };
    }

    /**
     * Static parameter, a predicate, which gets any object and returns true
     */
    public static final Predicate<Object> ALWAYS_TRUE = new Predicate<Object>() {
        @Override
        public Boolean apply(Object parameter) {
            return true;
        }
    };
    /**
     * Static parameter, a predicate, which gets any object and returns false
     */
    public static final Predicate<Object> ALWAYS_FALSE = new Predicate<Object>() {
        @Override
        public Boolean apply(Object parameter) {
            return false;
        }
    };
}

