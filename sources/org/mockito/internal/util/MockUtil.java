package org.mockito.internal.util;

import j$.util.function.Function;
import org.mockito.MockedConstruction;
import org.mockito.Mockito;
import org.mockito.exceptions.misusing.NotAMockException;
import org.mockito.internal.configuration.plugins.Plugins;
import org.mockito.internal.creation.settings.CreationSettings;
import org.mockito.internal.handler.MockHandlerFactory;
import org.mockito.internal.stubbing.InvocationContainerImpl;
import org.mockito.internal.util.reflection.LenientCopyTool;
import org.mockito.invocation.MockHandler;
import org.mockito.mock.MockCreationSettings;
import org.mockito.mock.MockName;
import org.mockito.plugins.MockMaker;
import org.mockito.plugins.MockResolver;
import y30.a;
import y30.b;

public class MockUtil {
    private static final MockMaker mockMaker = Plugins.getMockMaker();

    private MockUtil() {
    }

    public static boolean areSameMocks(Object obj, Object obj2) {
        return obj == obj2 || resolve(obj) == resolve(obj2);
    }

    public static void clearAllCaches() {
        mockMaker.clearAllCaches();
    }

    public static <T> MockMaker.ConstructionMockControl<T> createConstructionMock(Class<T> cls, Function<MockedConstruction.Context, MockCreationSettings<T>> function, MockedConstruction.MockInitializer<T> mockInitializer) {
        return mockMaker.createConstructionMock(cls, function, new a(function), mockInitializer);
    }

    public static <T> T createMock(MockCreationSettings<T> mockCreationSettings) {
        MockHandler<T> createMockHandler = MockHandlerFactory.createMockHandler(mockCreationSettings);
        Object spiedInstance = mockCreationSettings.getSpiedInstance();
        if (spiedInstance != null) {
            return mockMaker.createSpy(mockCreationSettings, createMockHandler, spiedInstance).orElseGet(new b(mockCreationSettings, createMockHandler, spiedInstance));
        }
        return mockMaker.createMock(mockCreationSettings, createMockHandler);
    }

    public static <T> MockMaker.StaticMockControl<T> createStaticMock(Class<T> cls, MockCreationSettings<T> mockCreationSettings) {
        return mockMaker.createStaticMock(cls, mockCreationSettings, MockHandlerFactory.createMockHandler(mockCreationSettings));
    }

    public static InvocationContainerImpl getInvocationContainer(Object obj) {
        return (InvocationContainerImpl) getMockHandler(obj).getInvocationContainer();
    }

    public static MockHandler<?> getMockHandler(Object obj) {
        if (obj != null) {
            Object resolve = resolve(obj);
            MockHandler<?> handler = mockMaker.getHandler(resolve);
            if (handler != null) {
                return handler;
            }
            throw new NotAMockException("Argument should be a mock, but is: " + resolve.getClass());
        }
        throw new NotAMockException("Argument should be a mock, but is null!");
    }

    public static MockName getMockName(Object obj) {
        return getMockHandler(obj).getMockSettings().getMockName();
    }

    public static MockCreationSettings getMockSettings(Object obj) {
        return getMockHandler(obj).getMockSettings();
    }

    public static boolean isMock(Object obj) {
        if (obj == null) {
            return false;
        }
        if (mockMaker.getHandler(resolve(obj)) != null) {
            return true;
        }
        return false;
    }

    public static boolean isSpy(Object obj) {
        if (!isMock(obj) || getMockSettings(obj).getDefaultAnswer() != Mockito.CALLS_REAL_METHODS) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Object lambda$createMock$0(MockCreationSettings mockCreationSettings, MockHandler mockHandler, Object obj) {
        Object createMock = mockMaker.createMock(mockCreationSettings, mockHandler);
        new LenientCopyTool().copyToMock(obj, createMock);
        return createMock;
    }

    public static void maybeRedefineMockName(Object obj, String str) {
        MockName mockName = getMockName(obj);
        MockCreationSettings<?> mockSettings = getMockHandler(obj).getMockSettings();
        if (mockName.isDefault() && (mockSettings instanceof CreationSettings)) {
            ((CreationSettings) mockSettings).setMockName(new MockNameImpl(str));
        }
    }

    public static void resetMock(Object obj) {
        MockCreationSettings<?> mockSettings = getMockHandler(obj).getMockSettings();
        MockHandler<?> createMockHandler = MockHandlerFactory.createMockHandler(mockSettings);
        mockMaker.resetMock(resolve(obj), createMockHandler, mockSettings);
    }

    private static Object resolve(Object obj) {
        if (obj instanceof Class) {
            return obj;
        }
        for (MockResolver resolve : Plugins.getMockResolvers()) {
            obj = resolve.resolve(obj);
        }
        return obj;
    }

    public static MockMaker.TypeMockability typeMockabilityOf(Class<?> cls) {
        return mockMaker.isTypeMockable(cls);
    }
}
