package org.mockito.plugins;

import j$.util.Optional;
import j$.util.function.Function;
import java.util.List;
import org.mockito.MockedConstruction;
import org.mockito.invocation.MockHandler;
import org.mockito.mock.MockCreationSettings;

public interface MockMaker {

    public interface ConstructionMockControl<T> {
        void disable();

        void enable();

        List<T> getMocks();

        Class<T> getType();
    }

    public interface StaticMockControl<T> {
        void disable();

        void enable();

        Class<T> getType();
    }

    public interface TypeMockability {
        boolean mockable();

        String nonMockableReason();
    }

    void clearAllCaches();

    <T> ConstructionMockControl<T> createConstructionMock(Class<T> cls, Function<MockedConstruction.Context, MockCreationSettings<T>> function, Function<MockedConstruction.Context, MockHandler<T>> function2, MockedConstruction.MockInitializer<T> mockInitializer);

    <T> T createMock(MockCreationSettings<T> mockCreationSettings, MockHandler mockHandler);

    <T> Optional<T> createSpy(MockCreationSettings<T> mockCreationSettings, MockHandler mockHandler, T t11);

    <T> StaticMockControl<T> createStaticMock(Class<T> cls, MockCreationSettings<T> mockCreationSettings, MockHandler mockHandler);

    MockHandler getHandler(Object obj);

    TypeMockability isTypeMockable(Class<?> cls);

    void resetMock(Object obj, MockHandler mockHandler, MockCreationSettings mockCreationSettings);
}
