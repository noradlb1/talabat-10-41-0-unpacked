package org.mockito;

import j$.util.function.Function;
import org.mockito.MockedConstruction;
import org.mockito.internal.MockitoCore;
import org.mockito.internal.creation.MockSettingsImpl;
import org.mockito.internal.framework.DefaultMockitoFramework;
import org.mockito.internal.session.DefaultMockitoSessionBuilder;
import org.mockito.internal.verification.VerificationModeFactory;
import org.mockito.session.MockitoSessionBuilder;
import org.mockito.stubbing.Answer;
import org.mockito.stubbing.LenientStubber;
import org.mockito.stubbing.OngoingStubbing;
import org.mockito.stubbing.Stubber;
import org.mockito.verification.After;
import org.mockito.verification.Timeout;
import org.mockito.verification.VerificationAfterDelay;
import org.mockito.verification.VerificationMode;
import org.mockito.verification.VerificationWithTimeout;
import s30.b;
import s30.c;
import s30.d;
import s30.e;
import s30.f;
import s30.g;
import s30.h;

@CheckReturnValue
public class Mockito extends ArgumentMatchers {
    public static final Answer<Object> CALLS_REAL_METHODS = Answers.CALLS_REAL_METHODS;
    public static final Answer<Object> RETURNS_DEEP_STUBS = Answers.RETURNS_DEEP_STUBS;
    public static final Answer<Object> RETURNS_DEFAULTS = Answers.RETURNS_DEFAULTS;
    public static final Answer<Object> RETURNS_MOCKS = Answers.RETURNS_MOCKS;
    public static final Answer<Object> RETURNS_SELF = Answers.RETURNS_SELF;
    public static final Answer<Object> RETURNS_SMART_NULLS = Answers.RETURNS_SMART_NULLS;

    /* renamed from: a  reason: collision with root package name */
    public static final MockitoCore f24024a = new MockitoCore();

    public static VerificationAfterDelay after(long j11) {
        return new After(j11, VerificationModeFactory.times(1));
    }

    public static VerificationMode atLeast(int i11) {
        return VerificationModeFactory.atLeast(i11);
    }

    public static VerificationMode atLeastOnce() {
        return VerificationModeFactory.atLeastOnce();
    }

    public static VerificationMode atMost(int i11) {
        return VerificationModeFactory.atMost(i11);
    }

    public static VerificationMode atMostOnce() {
        return VerificationModeFactory.atMostOnce();
    }

    public static VerificationMode calls(int i11) {
        return VerificationModeFactory.calls(i11);
    }

    public static void clearAllCaches() {
        f24024a.clearAllCaches();
    }

    public static <T> void clearInvocations(T... tArr) {
        f24024a.clearInvocations(tArr);
    }

    public static VerificationMode description(String str) {
        return times(1).description(str);
    }

    public static Stubber doAnswer(Answer answer) {
        return f24024a.stubber().doAnswer(answer);
    }

    public static Stubber doCallRealMethod() {
        return f24024a.stubber().doCallRealMethod();
    }

    public static Stubber doNothing() {
        return f24024a.stubber().doNothing();
    }

    public static Stubber doReturn(Object obj) {
        return f24024a.stubber().doReturn(obj);
    }

    public static Stubber doThrow(Throwable... thArr) {
        return f24024a.stubber().doThrow(thArr);
    }

    public static MockitoFramework framework() {
        return new DefaultMockitoFramework();
    }

    public static Object[] ignoreStubs(Object... objArr) {
        return f24024a.ignoreStubs(objArr);
    }

    public static InOrder inOrder(Object... objArr) {
        return f24024a.inOrder(objArr);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$mockConstruction$3(Object obj, MockedConstruction.Context context) throws Throwable {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ MockSettings lambda$mockConstruction$4(MockSettings mockSettings, MockedConstruction.Context context) {
        return mockSettings;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$mockConstruction$5(Object obj, MockedConstruction.Context context) throws Throwable {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ MockSettings lambda$mockConstruction$6(MockSettings mockSettings, MockedConstruction.Context context) {
        return mockSettings;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ MockSettings lambda$mockConstructionWithAnswer$0(Answer[] answerArr, Answer answer, MockedConstruction.Context context) {
        if (context.getCount() == 1 || answerArr.length == 0) {
            return withSettings().defaultAnswer(answer);
        }
        if (context.getCount() >= answerArr.length) {
            return withSettings().defaultAnswer(answerArr[answerArr.length - 1]);
        }
        return withSettings().defaultAnswer(answerArr[context.getCount() - 2]);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$mockConstructionWithAnswer$1(Object obj, MockedConstruction.Context context) throws Throwable {
    }

    public static LenientStubber lenient() {
        return f24024a.lenient();
    }

    public static <T> T mock(Class<T> cls) {
        return mock(cls, withSettings());
    }

    public static <T> MockedConstruction<T> mockConstruction(Class<T> cls) {
        return mockConstruction(cls, (Function<MockedConstruction.Context, MockSettings>) new b(), new c());
    }

    public static <T> MockedConstruction<T> mockConstructionWithAnswer(Class<T> cls, Answer answer, Answer... answerArr) {
        return mockConstruction(cls, (Function<MockedConstruction.Context, MockSettings>) new g(answerArr, answer), new h());
    }

    public static <T> MockedStatic<T> mockStatic(Class<T> cls) {
        return mockStatic(cls, withSettings());
    }

    public static MockingDetails mockingDetails(Object obj) {
        return f24024a.mockingDetails(obj);
    }

    public static MockitoSessionBuilder mockitoSession() {
        return new DefaultMockitoSessionBuilder();
    }

    public static VerificationMode never() {
        return times(0);
    }

    public static VerificationMode only() {
        return VerificationModeFactory.only();
    }

    public static <T> void reset(T... tArr) {
        f24024a.reset(tArr);
    }

    public static <T> T spy(T t11) {
        return f24024a.mock(t11.getClass(), withSettings().spiedInstance(t11).defaultAnswer(CALLS_REAL_METHODS));
    }

    public static VerificationWithTimeout timeout(long j11) {
        return new Timeout(j11, VerificationModeFactory.times(1));
    }

    public static VerificationMode times(int i11) {
        return VerificationModeFactory.times(i11);
    }

    public static void validateMockitoUsage() {
        f24024a.validateMockitoUsage();
    }

    public static <T> T verify(T t11) {
        return f24024a.verify(t11, times(1));
    }

    public static void verifyNoInteractions(Object... objArr) {
        f24024a.verifyNoInteractions(objArr);
    }

    public static void verifyNoMoreInteractions(Object... objArr) {
        f24024a.verifyNoMoreInteractions(objArr);
    }

    public static <T> OngoingStubbing<T> when(T t11) {
        return f24024a.when(t11);
    }

    public static MockSettings withSettings() {
        return new MockSettingsImpl().defaultAnswer(RETURNS_DEFAULTS);
    }

    public static Stubber doReturn(Object obj, Object... objArr) {
        return f24024a.stubber().doReturn(obj, objArr);
    }

    public static Stubber doThrow(Class<? extends Throwable> cls) {
        return f24024a.stubber().doThrow(cls);
    }

    public static <T> T mock(Class<T> cls, String str) {
        return mock(cls, withSettings().name(str).defaultAnswer(RETURNS_DEFAULTS));
    }

    public static <T> MockedConstruction<T> mockConstruction(Class<T> cls, MockedConstruction.MockInitializer<T> mockInitializer) {
        return mockConstruction(cls, withSettings(), mockInitializer);
    }

    public static <T> MockedStatic<T> mockStatic(Class<T> cls, Answer answer) {
        return mockStatic(cls, withSettings().defaultAnswer(answer));
    }

    public static <T> T verify(T t11, VerificationMode verificationMode) {
        return f24024a.verify(t11, verificationMode);
    }

    public static Stubber doThrow(Class<? extends Throwable> cls, Class<? extends Throwable>... clsArr) {
        return f24024a.stubber().doThrow(cls, clsArr);
    }

    public static <T> T mock(Class<T> cls, Answer answer) {
        return mock(cls, withSettings().defaultAnswer(answer));
    }

    public static <T> MockedConstruction<T> mockConstruction(Class<T> cls, MockSettings mockSettings) {
        return mockConstruction(cls, (Function<MockedConstruction.Context, MockSettings>) new d(mockSettings));
    }

    public static <T> MockedStatic<T> mockStatic(Class<T> cls, String str) {
        return mockStatic(cls, withSettings().name(str));
    }

    public static <T> T mock(Class<T> cls, MockSettings mockSettings) {
        return f24024a.mock(cls, mockSettings);
    }

    public static <T> MockedConstruction<T> mockConstruction(Class<T> cls, Function<MockedConstruction.Context, MockSettings> function) {
        return mockConstruction(cls, function, new f());
    }

    public static <T> MockedStatic<T> mockStatic(Class<T> cls, MockSettings mockSettings) {
        return f24024a.mockStatic(cls, mockSettings);
    }

    public static <T> MockedConstruction<T> mockConstruction(Class<T> cls, MockSettings mockSettings, MockedConstruction.MockInitializer<T> mockInitializer) {
        return mockConstruction(cls, (Function<MockedConstruction.Context, MockSettings>) new e(mockSettings), mockInitializer);
    }

    public static <T> T spy(Class<T> cls) {
        return f24024a.mock(cls, withSettings().useConstructor(new Object[0]).defaultAnswer(CALLS_REAL_METHODS));
    }

    public static <T> MockedConstruction<T> mockConstruction(Class<T> cls, Function<MockedConstruction.Context, MockSettings> function, MockedConstruction.MockInitializer<T> mockInitializer) {
        return f24024a.mockConstruction(cls, function, mockInitializer);
    }
}
