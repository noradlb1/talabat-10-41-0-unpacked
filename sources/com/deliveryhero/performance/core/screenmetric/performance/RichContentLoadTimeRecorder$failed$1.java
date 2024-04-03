package com.deliveryhero.performance.core.screenmetric.performance;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.deliveryhero.performance.core.screenmetric.performance.RichContentLoadTimeRecorder$failed$1", f = "RichContentLoadTimeRecorder.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class RichContentLoadTimeRecorder$failed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f30362h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ RichContentLoadTimeRecorder f30363i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f30364j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RichContentLoadTimeRecorder$failed$1(RichContentLoadTimeRecorder richContentLoadTimeRecorder, String str, Continuation<? super RichContentLoadTimeRecorder$failed$1> continuation) {
        super(2, continuation);
        this.f30363i = richContentLoadTimeRecorder;
        this.f30364j = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new RichContentLoadTimeRecorder$failed$1(this.f30363i, this.f30364j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((RichContentLoadTimeRecorder$failed$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f30362h == 0) {
            ResultKt.throwOnFailure(obj);
            RichContentLoadTimeRecorder richContentLoadTimeRecorder = this.f30363i;
            String access$findKey = richContentLoadTimeRecorder.findKey(richContentLoadTimeRecorder.metrics, this.f30364j);
            if (access$findKey == null) {
                return Unit.INSTANCE;
            }
            this.f30363i.metrics.remove(access$findKey);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
