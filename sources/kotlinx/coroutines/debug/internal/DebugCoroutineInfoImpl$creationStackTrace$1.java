package kotlinx.coroutines.debug.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H@"}, d2 = {"Lkotlin/sequences/SequenceScope;", "Ljava/lang/StackTraceElement;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl$creationStackTrace$1", f = "DebugCoroutineInfoImpl.kt", i = {}, l = {75}, m = "invokeSuspend", n = {}, s = {})
public final class DebugCoroutineInfoImpl$creationStackTrace$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super StackTraceElement>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f25397h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ DebugCoroutineInfoImpl f25398i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ StackTraceFrame f25399j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DebugCoroutineInfoImpl$creationStackTrace$1(DebugCoroutineInfoImpl debugCoroutineInfoImpl, StackTraceFrame stackTraceFrame, Continuation<? super DebugCoroutineInfoImpl$creationStackTrace$1> continuation) {
        super(2, continuation);
        this.f25398i = debugCoroutineInfoImpl;
        this.f25399j = stackTraceFrame;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        DebugCoroutineInfoImpl$creationStackTrace$1 debugCoroutineInfoImpl$creationStackTrace$1 = new DebugCoroutineInfoImpl$creationStackTrace$1(this.f25398i, this.f25399j, continuation);
        debugCoroutineInfoImpl$creationStackTrace$1.L$0 = obj;
        return debugCoroutineInfoImpl$creationStackTrace$1;
    }

    @Nullable
    public final Object invoke(@NotNull SequenceScope<? super StackTraceElement> sequenceScope, @Nullable Continuation<? super Unit> continuation) {
        return ((DebugCoroutineInfoImpl$creationStackTrace$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f25397h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            DebugCoroutineInfoImpl debugCoroutineInfoImpl = this.f25398i;
            CoroutineStackFrame callerFrame = this.f25399j.getCallerFrame();
            this.f25397h = 1;
            if (debugCoroutineInfoImpl.yieldFrames((SequenceScope) this.L$0, callerFrame, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
