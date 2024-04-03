package org.mockito.internal;

import j$.util.function.Function;
import java.util.Arrays;
import java.util.List;
import org.mockito.InOrder;
import org.mockito.MockSettings;
import org.mockito.MockedConstruction;
import org.mockito.MockedStatic;
import org.mockito.MockingDetails;
import org.mockito.exceptions.misusing.NotAMockException;
import org.mockito.internal.creation.MockSettingsImpl;
import org.mockito.internal.exceptions.Reporter;
import org.mockito.internal.invocation.InvocationMatcher;
import org.mockito.internal.invocation.finder.VerifiableInvocationsFinder;
import org.mockito.internal.listeners.VerificationStartedNotifier;
import org.mockito.internal.progress.MockingProgress;
import org.mockito.internal.progress.ThreadSafeMockingProgress;
import org.mockito.internal.stubbing.DefaultLenientStubber;
import org.mockito.internal.stubbing.InvocationContainerImpl;
import org.mockito.internal.stubbing.OngoingStubbingImpl;
import org.mockito.internal.stubbing.StubberImpl;
import org.mockito.internal.util.DefaultMockingDetails;
import org.mockito.internal.util.MockUtil;
import org.mockito.internal.verification.MockAwareVerificationMode;
import org.mockito.internal.verification.VerificationDataImpl;
import org.mockito.internal.verification.VerificationModeFactory;
import org.mockito.internal.verification.api.InOrderContext;
import org.mockito.internal.verification.api.VerificationDataInOrderImpl;
import org.mockito.invocation.Invocation;
import org.mockito.invocation.MatchableInvocation;
import org.mockito.mock.MockCreationSettings;
import org.mockito.plugins.MockMaker;
import org.mockito.quality.Strictness;
import org.mockito.stubbing.LenientStubber;
import org.mockito.stubbing.OngoingStubbing;
import org.mockito.stubbing.Stubber;
import org.mockito.verification.VerificationMode;
import t30.a;

public class MockitoCore {
    private void assertMocksNotEmpty(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            throw Reporter.mocksHaveToBePassedToVerifyNoMoreInteractions();
        }
    }

    private void assertNotStubOnlyMock(Object obj) {
        if (MockUtil.getMockHandler(obj).getMockSettings().isStubOnly()) {
            throw Reporter.stubPassedToVerify(obj);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ MockCreationSettings lambda$mockConstruction$0(Function function, Class cls, MockedConstruction.Context context) {
        MockSettings mockSettings = (MockSettings) function.apply(context);
        Class<MockSettingsImpl> cls2 = MockSettingsImpl.class;
        if (cls2.isInstance(mockSettings)) {
            return cls2.cast(mockSettings).build(cls);
        }
        throw new IllegalArgumentException("Unexpected implementation of '" + mockSettings.getClass().getCanonicalName() + "'\nAt the moment, you cannot provide your own implementations of that class.");
    }

    public void clearAllCaches() {
        MockUtil.clearAllCaches();
    }

    public <T> void clearInvocations(T... tArr) {
        MockingProgress mockingProgress = ThreadSafeMockingProgress.mockingProgress();
        mockingProgress.validateState();
        mockingProgress.reset();
        mockingProgress.resetOngoingStubbing();
        for (T invocationContainer : tArr) {
            MockUtil.getInvocationContainer(invocationContainer).clearInvocations();
        }
    }

    public Invocation getLastInvocation() {
        List<Invocation> registeredInvocations = ((OngoingStubbingImpl) ThreadSafeMockingProgress.mockingProgress().pullOngoingStubbing()).getRegisteredInvocations();
        return registeredInvocations.get(registeredInvocations.size() - 1);
    }

    public Object[] ignoreStubs(Object... objArr) {
        for (Object invocationContainer : objArr) {
            for (Invocation next : MockUtil.getInvocationContainer(invocationContainer).getInvocations()) {
                if (next.stubInfo() != null) {
                    next.ignoreForVerification();
                }
            }
        }
        return objArr;
    }

    public InOrder inOrder(Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            throw Reporter.mocksHaveToBePassedWhenCreatingInOrder();
        }
        int length = objArr.length;
        int i11 = 0;
        while (i11 < length) {
            Object obj = objArr[i11];
            if (obj == null) {
                throw Reporter.nullPassedWhenCreatingInOrder();
            } else if (MockUtil.isMock(obj)) {
                assertNotStubOnlyMock(obj);
                i11++;
            } else {
                throw Reporter.notAMockPassedWhenCreatingInOrder();
            }
        }
        return new InOrderImpl(Arrays.asList(objArr));
    }

    public boolean isTypeMockable(Class<?> cls) {
        return MockUtil.typeMockabilityOf(cls).mockable();
    }

    public LenientStubber lenient() {
        return new DefaultLenientStubber();
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [java.lang.Class, java.lang.Class<T>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> T mock(java.lang.Class<T> r3, org.mockito.MockSettings r4) {
        /*
            r2 = this;
            boolean r0 = r4 instanceof org.mockito.internal.creation.MockSettingsImpl
            if (r0 == 0) goto L_0x0016
            org.mockito.internal.creation.MockSettingsImpl r4 = (org.mockito.internal.creation.MockSettingsImpl) r4
            org.mockito.mock.MockCreationSettings r3 = r4.build(r3)
            java.lang.Object r4 = org.mockito.internal.util.MockUtil.createMock(r3)
            org.mockito.internal.progress.MockingProgress r0 = org.mockito.internal.progress.ThreadSafeMockingProgress.mockingProgress()
            r0.mockingStarted((java.lang.Object) r4, (org.mockito.mock.MockCreationSettings) r3)
            return r4
        L_0x0016:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Unexpected implementation of '"
            r0.append(r1)
            java.lang.Class r4 = r4.getClass()
            java.lang.String r4 = r4.getCanonicalName()
            r0.append(r4)
            java.lang.String r4 = "'\nAt the moment, you cannot provide your own implementations of that class."
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mockito.internal.MockitoCore.mock(java.lang.Class, org.mockito.MockSettings):java.lang.Object");
    }

    public <T> MockedConstruction<T> mockConstruction(Class<T> cls, Function<MockedConstruction.Context, ? extends MockSettings> function, MockedConstruction.MockInitializer<T> mockInitializer) {
        MockMaker.ConstructionMockControl<T> createConstructionMock = MockUtil.createConstructionMock(cls, new a(function, cls), mockInitializer);
        createConstructionMock.enable();
        return new MockedConstructionImpl(createConstructionMock);
    }

    public <T> MockedStatic<T> mockStatic(Class<T> cls, MockSettings mockSettings) {
        Class<MockSettingsImpl> cls2 = MockSettingsImpl.class;
        if (cls2.isInstance(mockSettings)) {
            MockCreationSettings<T2> buildStatic = cls2.cast(mockSettings).buildStatic(cls);
            MockMaker.StaticMockControl<T2> createStaticMock = MockUtil.createStaticMock(cls, buildStatic);
            createStaticMock.enable();
            ThreadSafeMockingProgress.mockingProgress().mockingStarted((Class<?>) cls, (MockCreationSettings) buildStatic);
            return new MockedStaticImpl(createStaticMock);
        }
        throw new IllegalArgumentException("Unexpected implementation of '" + mockSettings.getClass().getCanonicalName() + "'\nAt the moment, you cannot provide your own implementations of that class.");
    }

    public MockingDetails mockingDetails(Object obj) {
        return new DefaultMockingDetails(obj);
    }

    public <T> void reset(T... tArr) {
        MockingProgress mockingProgress = ThreadSafeMockingProgress.mockingProgress();
        mockingProgress.validateState();
        mockingProgress.reset();
        mockingProgress.resetOngoingStubbing();
        for (T resetMock : tArr) {
            MockUtil.resetMock(resetMock);
        }
    }

    public Stubber stubber() {
        return stubber((Strictness) null);
    }

    public void validateMockitoUsage() {
        ThreadSafeMockingProgress.mockingProgress().validateState();
    }

    public <T> T verify(T t11, VerificationMode verificationMode) {
        if (t11 != null) {
            MockingDetails mockingDetails = mockingDetails(t11);
            if (mockingDetails.isMock()) {
                assertNotStubOnlyMock(t11);
                T notifyVerificationStarted = VerificationStartedNotifier.notifyVerificationStarted(mockingDetails.getMockHandler().getMockSettings().getVerificationStartedListeners(), mockingDetails);
                MockingProgress mockingProgress = ThreadSafeMockingProgress.mockingProgress();
                mockingProgress.verificationStarted(new MockAwareVerificationMode(notifyVerificationStarted, mockingProgress.maybeVerifyLazily(verificationMode), mockingProgress.verificationListeners()));
                return notifyVerificationStarted;
            }
            throw Reporter.notAMockPassedToVerify(t11.getClass());
        }
        throw Reporter.nullPassedToVerify();
    }

    public void verifyNoInteractions(Object... objArr) {
        assertMocksNotEmpty(objArr);
        ThreadSafeMockingProgress.mockingProgress().validateState();
        int length = objArr.length;
        int i11 = 0;
        while (i11 < length) {
            Object obj = objArr[i11];
            if (obj != null) {
                try {
                    InvocationContainerImpl invocationContainer = MockUtil.getInvocationContainer(obj);
                    assertNotStubOnlyMock(obj);
                    VerificationModeFactory.noInteractions().verify(new VerificationDataImpl(invocationContainer, (InvocationMatcher) null));
                    i11++;
                } catch (NotAMockException unused) {
                    throw Reporter.notAMockPassedToVerifyNoMoreInteractions();
                }
            } else {
                throw Reporter.nullPassedToVerifyNoMoreInteractions();
            }
        }
    }

    public void verifyNoMoreInteractions(Object... objArr) {
        assertMocksNotEmpty(objArr);
        ThreadSafeMockingProgress.mockingProgress().validateState();
        int length = objArr.length;
        int i11 = 0;
        while (i11 < length) {
            Object obj = objArr[i11];
            if (obj != null) {
                try {
                    InvocationContainerImpl invocationContainer = MockUtil.getInvocationContainer(obj);
                    assertNotStubOnlyMock(obj);
                    VerificationModeFactory.noMoreInteractions().verify(new VerificationDataImpl(invocationContainer, (InvocationMatcher) null));
                    i11++;
                } catch (NotAMockException unused) {
                    throw Reporter.notAMockPassedToVerifyNoMoreInteractions();
                }
            } else {
                throw Reporter.nullPassedToVerifyNoMoreInteractions();
            }
        }
    }

    public void verifyNoMoreInteractionsInOrder(List<Object> list, InOrderContext inOrderContext) {
        ThreadSafeMockingProgress.mockingProgress().validateState();
        VerificationModeFactory.noMoreInteractions().verifyInOrder(new VerificationDataInOrderImpl(inOrderContext, VerifiableInvocationsFinder.find(list), (MatchableInvocation) null));
    }

    public <T> OngoingStubbing<T> when(T t11) {
        MockingProgress mockingProgress = ThreadSafeMockingProgress.mockingProgress();
        mockingProgress.stubbingStarted();
        OngoingStubbing<?> pullOngoingStubbing = mockingProgress.pullOngoingStubbing();
        if (pullOngoingStubbing != null) {
            return pullOngoingStubbing;
        }
        mockingProgress.reset();
        throw Reporter.missingMethodInvocation();
    }

    public Stubber stubber(Strictness strictness) {
        MockingProgress mockingProgress = ThreadSafeMockingProgress.mockingProgress();
        mockingProgress.stubbingStarted();
        mockingProgress.resetOngoingStubbing();
        return new StubberImpl(strictness);
    }
}
