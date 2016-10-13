package skorpilesha.homework;

import java.util.function.Function;

public class Maybe<T>{
    private boolean hasContent;
    private T content;
    public Boolean isPresent(){
        return hasContent;
    }
    public T get() throws MaybeNoContentException{
        if (isPresent()){
            return content;
        } else {
            throw new MaybeNoContentException("No content!");
        }
    }
    public void set(T newContent){
        hasContent = true;
        content = newContent;
    }
    public void reset(){
        hasContent = false;
        content = null;
    }
    public Maybe(){
        hasContent = false;
        content = null;
    }
    public Maybe(T newContent) {
        content = newContent;
        hasContent = true;
    }
    public static <T> Maybe<T> just (T newContent) {
        return new Maybe<T>(newContent);
    }
    public static <T> Maybe<T> nothing () {
        return new Maybe<T>();
    }
    public <U> Maybe<U> map(Function<T, U> mapper) throws MaybeNoContentException{
        if (isPresent())
            return Maybe.just(mapper.apply(get()));
        else
            return Maybe.nothing();
    }
}