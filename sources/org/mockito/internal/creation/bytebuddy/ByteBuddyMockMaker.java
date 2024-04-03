package org.mockito.internal.creation.bytebuddy;

import j$.util.Optional;
import j$.util.function.Function;
import org.mockito.MockedConstruction;
import org.mockito.internal.exceptions.Reporter;
import org.mockito.invocation.MockHandler;
import org.mockito.mock.MockCreationSettings;
import org.mockito.plugins.MockMaker;

public class ByteBuddyMockMaker implements ClassCreatingMockMaker {
    private final SubclassByteBuddyMockMaker subclassByteBuddyMockMaker;

    public ByteBuddyMockMaker() {
        try {
            this.subclassByteBuddyMockMaker = new SubclassByteBuddyMockMaker();
        } catch (NoClassDefFoundError e11) {
            Reporter.missingByteBuddyDependency(e11);
            throw e11;
        }
    }

    public void clearAllCaches() {
        this.subclassByteBuddyMockMaker.clearAllCaches();
    }

    public <T> MockMaker.ConstructionMockControl<T> createConstructionMock(Class<T> cls, Function<MockedConstruction.Context, MockCreationSettings<T>> function, Function<MockedConstruction.Context, MockHandler<T>> function2, MockedConstruction.MockInitializer<T> mockInitializer) {
        return this.subclassByteBuddyMockMaker.createConstructionMock(cls, function, function2, mockInitializer);
    }

    public <T> T createMock(MockCreationSettings<T> mockCreationSettings, MockHandler mockHandler) {
        return this.subclassByteBuddyMockMaker.createMock(mockCreationSettings, mockHandler);
    }

    public <T> Class<? extends T> createMockType(MockCreationSettings<T> mockCreationSettings) {
        return this.subclassByteBuddyMockMaker.createMockType(mockCreationSettings);
    }

    public <T> Optional<T> createSpy(MockCreationSettings<T> mockCreationSettings, MockHandler mockHandler, T t11) {
        return this.subclassByteBuddyMockMaker.createSpy(mockCreationSettings, mockHandler, t11);
    }

    public <T> MockMaker.StaticMockControl<T> createStaticMock(Class<T> cls, MockCreationSettings<T> mockCreationSettings, MockHandler mockHandler) {
        return this.subclassByteBuddyMockMaker.createStaticMock(cls, mockCreationSettings, mockHandler);
    }

    public MockHandler getHandler(Object obj) {
        return this.subclassByteBuddyMockMaker.getHandler(obj);
    }

    public MockMaker.TypeMockability isTypeMockable(Class<?> cls) {
        return this.subclassByteBuddyMockMaker.isTypeMockable(cls);
    }

    public void resetMock(Object obj, MockHandler mockHandler, MockCreationSettings mockCreationSettings) {
        this.subclassByteBuddyMockMaker.resetMock(obj, mockHandler, mockCreationSettings);
    }
}
