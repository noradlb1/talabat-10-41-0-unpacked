package org.mockito;

import java.lang.reflect.Constructor;
import java.util.List;

public interface MockedConstruction<T> extends ScopedMock {

    public interface Context {
        List<?> arguments();

        Constructor<?> constructor();

        int getCount();
    }

    public interface MockInitializer<T> {
        void prepare(T t11, Context context) throws Throwable;
    }

    List<T> constructed();
}
