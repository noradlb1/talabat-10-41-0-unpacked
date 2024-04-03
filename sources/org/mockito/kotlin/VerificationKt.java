package org.mockito.kotlin;

import com.instabug.library.model.session.config.SessionsConfigParameter;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.mockito.ArgumentMatchers;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.kotlin.internal.CreateInstanceKt;
import org.mockito.verification.VerificationAfterDelay;
import org.mockito.verification.VerificationMode;
import org.mockito.verification.VerificationWithTimeout;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u0006\u0010\b\u001a\u00020\u0005\u001a\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0007\u001a\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0007\u001a0\u0010\r\u001a\u0002H\u000e\"\n\b\u0000\u0010\u000e\u0018\u0001*\u00020\u000f2\u0014\b\b\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u00020\u00120\u0011H\b¢\u0006\u0002\u0010\u0013\u001a%\u0010\u0014\u001a\u00020\u0012\"\u0004\b\u0000\u0010\u000e2\u0012\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u000e0\u0016\"\u0002H\u000e¢\u0006\u0002\u0010\u0017\u001a\u000e\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0019\u001a'\u0010\u001a\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u00162\u0012\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u0016\"\u00020\u000f¢\u0006\u0002\u0010\u001b\u001a\u001f\u0010\u001c\u001a\u00020\u001d2\u0012\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u0016\"\u00020\u000f¢\u0006\u0002\u0010\u001e\u001a;\u0010\u001c\u001a\u00020\u00122\u0012\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u0016\"\u00020\u000f2\u0017\u0010\u001f\u001a\u0013\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b H\b¢\u0006\u0002\u0010!\u001a\u0006\u0010\"\u001a\u00020\u0005\u001a\u0006\u0010#\u001a\u00020\u0005\u001a\u000e\u0010$\u001a\u00020%2\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u000e\u0010&\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u0019\u0010'\u001a\u0002H\u000e\"\u0004\b\u0000\u0010\u000e2\u0006\u0010(\u001a\u0002H\u000e¢\u0006\u0002\u0010)\u001a!\u0010'\u001a\u0002H\u000e\"\u0004\b\u0000\u0010\u000e2\u0006\u0010(\u001a\u0002H\u000e2\u0006\u0010*\u001a\u00020\u0005¢\u0006\u0002\u0010+\u001aM\u0010,\u001a\u00020\u0012\"\u0004\b\u0000\u0010\u000e2\u0006\u0010(\u001a\u0002H\u000e2\u0006\u0010*\u001a\u00020\u00052'\u0010-\u001a#\b\u0001\u0012\u0004\u0012\u0002H\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120/\u0012\u0006\u0012\u0004\u0018\u00010\u000f0.¢\u0006\u0002\b ø\u0001\u0000¢\u0006\u0002\u00100\u001aE\u0010,\u001a\u00020\u0012\"\u0004\b\u0000\u0010\u000e2\u0006\u0010(\u001a\u0002H\u000e2'\u0010-\u001a#\b\u0001\u0012\u0004\u0012\u0002H\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120/\u0012\u0006\u0012\u0004\u0018\u00010\u000f0.¢\u0006\u0002\b ø\u0001\u0000¢\u0006\u0002\u00101\u001a\u001f\u00102\u001a\u00020\u00122\u0012\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u0016\"\u00020\u000f¢\u0006\u0002\u0010\u0017\u001a%\u00103\u001a\u00020\u0012\"\u0004\b\u0000\u0010\u000e2\u0012\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u000e0\u0016\"\u0002H\u000e¢\u0006\u0002\u0010\u0017\u001a7\u0010\u001c\u001a\u00020\u0012\"\u0004\b\u0000\u0010\u000e*\u0002H\u000e2\u001d\u00104\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000e05\u0012\u0004\u0012\u00020\u000f0\u0011¢\u0006\u0002\b H\b¢\u0006\u0002\u00106\u0002\u0004\n\u0002\b\u0019¨\u00067"}, d2 = {"after", "Lorg/mockito/verification/VerificationAfterDelay;", "millis", "", "atLeast", "Lorg/mockito/verification/VerificationMode;", "numInvocations", "", "atLeastOnce", "atMost", "maxNumberOfInvocations", "calls", "wantedNumberOfInvocations", "check", "T", "", "predicate", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "clearInvocations", "mocks", "", "([Ljava/lang/Object;)V", "description", "", "ignoreStubs", "([Ljava/lang/Object;)[Ljava/lang/Object;", "inOrder", "Lorg/mockito/InOrder;", "([Ljava/lang/Object;)Lorg/mockito/InOrder;", "evaluation", "Lkotlin/ExtensionFunctionType;", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "never", "only", "timeout", "Lorg/mockito/verification/VerificationWithTimeout;", "times", "verify", "mock", "(Ljava/lang/Object;)Ljava/lang/Object;", "mode", "(Ljava/lang/Object;Lorg/mockito/verification/VerificationMode;)Ljava/lang/Object;", "verifyBlocking", "f", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "(Ljava/lang/Object;Lorg/mockito/verification/VerificationMode;Lkotlin/jvm/functions/Function2;)V", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "verifyNoInteractions", "verifyNoMoreInteractions", "block", "Lorg/mockito/kotlin/InOrderOnType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "mockito-kotlin"}, k = 2, mv = {1, 1, 15})
public final class VerificationKt {
    @NotNull
    public static final VerificationAfterDelay after(long j11) {
        VerificationAfterDelay after = Mockito.after(j11);
        if (after == null) {
            Intrinsics.throwNpe();
        }
        return after;
    }

    @NotNull
    public static final VerificationMode atLeast(int i11) {
        VerificationMode atLeast = Mockito.atLeast(i11);
        if (atLeast == null) {
            Intrinsics.throwNpe();
        }
        return atLeast;
    }

    @NotNull
    public static final VerificationMode atLeastOnce() {
        VerificationMode atLeastOnce = Mockito.atLeastOnce();
        if (atLeastOnce == null) {
            Intrinsics.throwNpe();
        }
        return atLeastOnce;
    }

    @NotNull
    public static final VerificationMode atMost(int i11) {
        VerificationMode atMost = Mockito.atMost(i11);
        if (atMost == null) {
            Intrinsics.throwNpe();
        }
        return atMost;
    }

    @NotNull
    public static final VerificationMode calls(int i11) {
        VerificationMode calls = Mockito.calls(i11);
        if (calls == null) {
            Intrinsics.throwNpe();
        }
        return calls;
    }

    @NotNull
    public static final /* synthetic */ <T> T check(@NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        T argThat = ArgumentMatchers.argThat(new VerificationKt$check$1(function1));
        if (argThat != null) {
            return argThat;
        }
        Intrinsics.reifiedOperationMarker(4, "T");
        return CreateInstanceKt.createInstance(Reflection.getOrCreateKotlinClass(Object.class));
    }

    public static final <T> void clearInvocations(@NotNull T... tArr) {
        Intrinsics.checkParameterIsNotNull(tArr, "mocks");
        Mockito.clearInvocations(Arrays.copyOf(tArr, tArr.length));
    }

    @NotNull
    public static final VerificationMode description(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "description");
        VerificationMode description = Mockito.description(str);
        Intrinsics.checkExpressionValueIsNotNull(description, "Mockito.description(description)");
        return description;
    }

    @NotNull
    public static final Object[] ignoreStubs(@NotNull Object... objArr) {
        Intrinsics.checkParameterIsNotNull(objArr, "mocks");
        Object[] ignoreStubs = Mockito.ignoreStubs(Arrays.copyOf(objArr, objArr.length));
        if (ignoreStubs == null) {
            Intrinsics.throwNpe();
        }
        return ignoreStubs;
    }

    @NotNull
    public static final InOrder inOrder(@NotNull Object... objArr) {
        Intrinsics.checkParameterIsNotNull(objArr, "mocks");
        InOrder inOrder = Mockito.inOrder(Arrays.copyOf(objArr, objArr.length));
        if (inOrder == null) {
            Intrinsics.throwNpe();
        }
        return inOrder;
    }

    @NotNull
    public static final VerificationMode never() {
        VerificationMode never = Mockito.never();
        if (never == null) {
            Intrinsics.throwNpe();
        }
        return never;
    }

    @NotNull
    public static final VerificationMode only() {
        VerificationMode only = Mockito.only();
        if (only == null) {
            Intrinsics.throwNpe();
        }
        return only;
    }

    @NotNull
    public static final VerificationWithTimeout timeout(long j11) {
        VerificationWithTimeout timeout = Mockito.timeout(j11);
        if (timeout == null) {
            Intrinsics.throwNpe();
        }
        return timeout;
    }

    @NotNull
    public static final VerificationMode times(int i11) {
        VerificationMode times = Mockito.times(i11);
        if (times == null) {
            Intrinsics.throwNpe();
        }
        return times;
    }

    public static final <T> T verify(T t11) {
        T verify = Mockito.verify(t11);
        if (verify == null) {
            Intrinsics.throwNpe();
        }
        return verify;
    }

    public static final <T> void verifyBlocking(T t11, @NotNull Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.checkParameterIsNotNull(function2, "f");
        Object unused = BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new VerificationKt$verifyBlocking$1(function2, Mockito.verify(t11), (Continuation) null), 1, (Object) null);
    }

    public static final void verifyNoInteractions(@NotNull Object... objArr) {
        Intrinsics.checkParameterIsNotNull(objArr, "mocks");
        Mockito.verifyNoInteractions(Arrays.copyOf(objArr, objArr.length));
    }

    public static final <T> void verifyNoMoreInteractions(@NotNull T... tArr) {
        Intrinsics.checkParameterIsNotNull(tArr, "mocks");
        Mockito.verifyNoMoreInteractions(Arrays.copyOf(tArr, tArr.length));
    }

    public static final void inOrder(@NotNull Object[] objArr, @NotNull Function1<? super InOrder, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(objArr, "mocks");
        Intrinsics.checkParameterIsNotNull(function1, "evaluation");
        InOrder inOrder = Mockito.inOrder(Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkExpressionValueIsNotNull(inOrder, "Mockito.inOrder(*mocks)");
        function1.invoke(inOrder);
    }

    public static final <T> T verify(T t11, @NotNull VerificationMode verificationMode) {
        Intrinsics.checkParameterIsNotNull(verificationMode, SessionsConfigParameter.SYNC_MODE);
        T verify = Mockito.verify(t11, verificationMode);
        if (verify == null) {
            Intrinsics.throwNpe();
        }
        return verify;
    }

    public static final <T> void inOrder(T t11, @NotNull Function1<? super InOrderOnType<T>, ? extends Object> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "block");
        function1.invoke(new InOrderOnType(t11));
    }

    public static final <T> void verifyBlocking(T t11, @NotNull VerificationMode verificationMode, @NotNull Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.checkParameterIsNotNull(verificationMode, SessionsConfigParameter.SYNC_MODE);
        Intrinsics.checkParameterIsNotNull(function2, "f");
        Object unused = BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new VerificationKt$verifyBlocking$2(function2, Mockito.verify(t11, verificationMode), (Continuation) null), 1, (Object) null);
    }
}
