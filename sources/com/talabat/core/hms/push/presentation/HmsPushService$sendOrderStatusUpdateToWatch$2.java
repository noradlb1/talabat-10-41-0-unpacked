package com.talabat.core.hms.push.presentation;

import com.talabat.core.wearable.huawei.domain.TalabatHuaweiWatch;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.core.hms.push.presentation.HmsPushService$sendOrderStatusUpdateToWatch$2", f = "HmsPushService.kt", i = {}, l = {94}, m = "invokeSuspend", n = {}, s = {})
public final class HmsPushService$sendOrderStatusUpdateToWatch$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f55946h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ HmsPushService f55947i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f55948j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HmsPushService$sendOrderStatusUpdateToWatch$2(HmsPushService hmsPushService, String str, Continuation<? super HmsPushService$sendOrderStatusUpdateToWatch$2> continuation) {
        super(2, continuation);
        this.f55947i = hmsPushService;
        this.f55948j = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        HmsPushService$sendOrderStatusUpdateToWatch$2 hmsPushService$sendOrderStatusUpdateToWatch$2 = new HmsPushService$sendOrderStatusUpdateToWatch$2(this.f55947i, this.f55948j, continuation);
        hmsPushService$sendOrderStatusUpdateToWatch$2.L$0 = obj;
        return hmsPushService$sendOrderStatusUpdateToWatch$2;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((HmsPushService$sendOrderStatusUpdateToWatch$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f55946h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            HmsPushService hmsPushService = this.f55947i;
            String str = this.f55948j;
            Result.Companion companion = Result.Companion;
            TalabatHuaweiWatch talabatHuaweiWatch = hmsPushService.getTalabatHuaweiWatch();
            Intrinsics.checkNotNullExpressionValue(str, "message");
            this.f55946h = 1;
            if (talabatHuaweiWatch.send(str, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.m6329constructorimpl(ResultKt.createFailure(th2));
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Result.m6329constructorimpl(Unit.INSTANCE);
        return Unit.INSTANCE;
    }
}
