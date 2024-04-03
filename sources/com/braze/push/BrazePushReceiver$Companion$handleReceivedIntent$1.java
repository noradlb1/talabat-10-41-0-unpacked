package com.braze.push;

import android.content.Context;
import android.content.Intent;
import com.braze.push.BrazePushReceiver;
import kotlin.Metadata;
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
@DebugMetadata(c = "com.braze.push.BrazePushReceiver$Companion$handleReceivedIntent$1", f = "BrazePushReceiver.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class BrazePushReceiver$Companion$handleReceivedIntent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f43865h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Context f43866i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Intent f43867j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BrazePushReceiver$Companion$handleReceivedIntent$1(Context context, Intent intent, Continuation<? super BrazePushReceiver$Companion$handleReceivedIntent$1> continuation) {
        super(2, continuation);
        this.f43866i = context;
        this.f43867j = intent;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new BrazePushReceiver$Companion$handleReceivedIntent$1(this.f43866i, this.f43867j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((BrazePushReceiver$Companion$handleReceivedIntent$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f43865h == 0) {
            ResultKt.throwOnFailure(obj);
            BrazePushReceiver.Companion companion = BrazePushReceiver.Companion;
            Context applicationContext = this.f43866i.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
            companion.handlePush(applicationContext, this.f43867j);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
