package org.mockito.internal.creation.bytebuddy;

import j$.util.Optional;
import j$.util.function.Function;
import org.mockito.MockedConstruction;
import org.mockito.creation.instance.Instantiator;
import org.mockito.internal.exceptions.Reporter;
import org.mockito.invocation.MockHandler;
import org.mockito.mock.MockCreationSettings;
import org.mockito.plugins.InlineMockMaker;
import org.mockito.plugins.MockMaker;

public class InlineByteBuddyMockMaker implements ClassCreatingMockMaker, InlineMockMaker, Instantiator {
    private final InlineDelegateByteBuddyMockMaker inlineDelegateByteBuddyMockMaker;

    public InlineByteBuddyMockMaker() {
        try {
            this.inlineDelegateByteBuddyMockMaker = new InlineDelegateByteBuddyMockMaker();
        } catch (NoClassDefFoundError e11) {
            Reporter.missingByteBuddyDependency(e11);
            throw e11;
        }
    }

    public void clearAllCaches() {
        this.inlineDelegateByteBuddyMockMaker.clearAllCaches();
    }

    public void clearAllMocks() {
        this.inlineDelegateByteBuddyMockMaker.clearAllMocks();
    }

    public void clearMock(Object obj) {
        this.inlineDelegateByteBuddyMockMaker.clearMock(obj);
    }

    public <T> MockMaker.ConstructionMockControl<T> createConstructionMock(Class<T> cls, Function<MockedConstruction.Context, MockCreationSettings<T>> function, Function<MockedConstruction.Context, MockHandler<T>> function2, MockedConstruction.MockInitializer<T> mockInitializer) {
        return this.inlineDelegateByteBuddyMockMaker.createConstructionMock(cls, function, function2, mockInitializer);
    }

    public <T> T createMock(MockCreationSettings<T> mockCreationSettings, MockHandler mockHandler) {
        return this.inlineDelegateByteBuddyMockMaker.createMock(mockCreationSettings, mockHandler);
    }

    public <T> Class<? extends T> createMockType(MockCreationSettings<T> mockCreationSettings) {
        return this.inlineDelegateByteBuddyMockMaker.createMockType(mockCreationSettings);
    }

    public <T> Optional<T> createSpy(MockCreationSettings<T> mockCreationSettings, MockHandler mockHandler, T t11) {
        return this.inlineDelegateByteBuddyMockMaker.createSpy(mockCreationSettings, mockHandler, t11);
    }

    public <T> MockMaker.StaticMockControl<T> createStaticMock(Class<T> cls, MockCreationSettings<T> mockCreationSettings, MockHandler mockHandler) {
        return this.inlineDelegateByteBuddyMockMaker.createStaticMock(cls, mockCreationSettings, mockHandler);
    }

    public MockHandler getHandler(Object obj) {
        return this.inlineDelegateByteBuddyMockMaker.getHandler(obj);
    }

    public MockMaker.TypeMockability isTypeMockable(Class<?> cls) {
        return this.inlineDelegateByteBuddyMockMaker.isTypeMockable(cls);
    }

    public <T> T newInstance(Class<T> cls) {
        return this.inlineDelegateByteBuddyMockMaker.newInstance(cls);
    }

    public void resetMock(Object obj, MockHandler mockHandler, MockCreationSettings mockCreationSettings) {
        this.inlineDelegateByteBuddyMockMaker.resetMock(obj, mockHandler, mockCreationSettings);
    }
}
