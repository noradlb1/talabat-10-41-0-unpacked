package com.talabat.feature.walletaddcard.presentation.channel;

import com.talabat.card_tokenization.CardTokenizationPlugin;
import com.talabat.feature.walletaddcard.domain.model.BankCard;
import com.talabat.feature.walletaddcard.domain.usecase.GetCardTokenUseCase;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
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
@DebugMetadata(c = "com.talabat.feature.walletaddcard.presentation.channel.WalletMethodCallHandler$generateCardToken$1", f = "WalletMethodCallHandler.kt", i = {}, l = {56}, m = "invokeSuspend", n = {}, s = {})
public final class WalletMethodCallHandler$generateCardToken$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public Object f59436h;

    /* renamed from: i  reason: collision with root package name */
    public int f59437i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ MethodCall f59438j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f59439k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ WalletMethodCallHandler f59440l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletMethodCallHandler$generateCardToken$1(MethodCall methodCall, MethodChannel.Result result, WalletMethodCallHandler walletMethodCallHandler, Continuation<? super WalletMethodCallHandler$generateCardToken$1> continuation) {
        super(2, continuation);
        this.f59438j = methodCall;
        this.f59439k = result;
        this.f59440l = walletMethodCallHandler;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WalletMethodCallHandler$generateCardToken$1(this.f59438j, this.f59439k, this.f59440l, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WalletMethodCallHandler$generateCardToken$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        MethodChannel.Result result;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f59437i;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Object argument = this.f59438j.argument("cardNumber");
            Intrinsics.checkNotNull(argument);
            Object argument2 = this.f59438j.argument("expiryDate");
            Intrinsics.checkNotNull(argument2);
            Object argument3 = this.f59438j.argument(CardTokenizationPlugin.ARG_CVV_KEY);
            Intrinsics.checkNotNull(argument3);
            BankCard bankCard = new BankCard((String) argument, (String) argument2, (String) argument3);
            MethodChannel.Result result2 = this.f59439k;
            GetCardTokenUseCase access$getGetCardTokenUseCase$p = this.f59440l.getCardTokenUseCase;
            this.f59436h = result2;
            this.f59437i = 1;
            Object invoke = access$getGetCardTokenUseCase$p.invoke(bankCard, this);
            if (invoke == coroutine_suspended) {
                return coroutine_suspended;
            }
            result = result2;
            obj = invoke;
        } else if (i11 == 1) {
            result = (MethodChannel.Result) this.f59436h;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        result.success(obj);
        return Unit.INSTANCE;
    }
}
