package skorpilesha.homework;

import org.junit.Test;
import org.omg.PortableInterceptor.Interceptor;

import java.util.function.Function;

import static org.junit.Assert.*;

public class MaybeTest {
    @Test
    public void isPresent() throws Exception {
        assertTrue(Maybe.just(new Integer(3)).isPresent() && !Maybe.nothing().isPresent());
    }

    @Test
    public void get() throws Exception {
        assertTrue(3 == Maybe.just(new Integer(3)).get());
        try {
            Maybe.nothing().get();
        } catch (MaybeNoContentException e) {
            return;
        }
        throw new Exception("get from an empty Maybe is not an exception!");
    }

    @Test
    public void set() throws Exception {
        Maybe<Integer> testSubject = Maybe.just(new Integer(3));
        testSubject.set(5);
        assertTrue(testSubject.isPresent() && testSubject.get() == 5);
    }

    @Test
    public void just() throws Exception {
        Maybe<Integer> testSubject = Maybe.just(new Integer(3));
    }

    @Test
    public void nothing() throws Exception {
        Maybe<Integer> testSubject = Maybe.nothing();
    }

    @Test
    public void map() throws Exception {
        Function<Integer, String> intToString = new Function<Integer, String>() {
            @Override public String apply(Integer from) {
                return from.toString();
            }
        };
        assertTrue(Maybe.just(new Integer(3)).map(intToString).get().equals("3"));
    }
}