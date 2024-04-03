package com.talabat.core.flutter.channels.data.tpro;

import com.talabat.core.flutter.channels.domain.tpro.TProChannelCallback;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
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
@DebugMetadata(c = "com.talabat.core.flutter.channels.data.tpro.TproMethodChannel$onMethodCall$2", f = "TproMethodChannel.kt", i = {}, l = {48}, m = "invokeSuspend", n = {}, s = {})
public final class TproMethodChannel$onMethodCall$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f55903h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ TproMethodChannel f55904i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ MethodCall f55905j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f55906k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TproMethodChannel$onMethodCall$2(TproMethodChannel tproMethodChannel, MethodCall methodCall, MethodChannel.Result result, Continuation<? super TproMethodChannel$onMethodCall$2> continuation) {
        super(2, continuation);
        this.f55904i = tproMethodChannel;
        this.f55905j = methodCall;
        this.f55906k = result;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TproMethodChannel$onMethodCall$2(this.f55904i, this.f55905j, this.f55906k, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TproMethodChannel$onMethodCall$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f55903h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            TProChannelCallback access$getCallback$p = this.f55904i.callback;
            Object obj2 = this.f55905j.arguments;
            this.f55903h = 1;
            if (access$getCallback$p.updateProStatus(obj2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.f55906k.success((Object) null);
        return Unit.INSTANCE;
    }
}
