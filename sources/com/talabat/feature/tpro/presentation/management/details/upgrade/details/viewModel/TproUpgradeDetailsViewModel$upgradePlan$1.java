package com.talabat.feature.tpro.presentation.management.details.upgrade.details.viewModel;

import com.talabat.feature.subscriptions.domain.model.SubscriptionPaymentStatus;
import com.talabat.feature.subscriptions.domain.usecase.UpgradeSubscriptionPlanUseCase;
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
@DebugMetadata(c = "com.talabat.feature.tpro.presentation.management.details.upgrade.details.viewModel.TproUpgradeDetailsViewModel$upgradePlan$1", f = "TproUpgradeDetailsViewModel.kt", i = {}, l = {33}, m = "invokeSuspend", n = {}, s = {})
public final class TproUpgradeDetailsViewModel$upgradePlan$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f59329h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ TproUpgradeDetailsViewModel f59330i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f59331j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f59332k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ String f59333l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TproUpgradeDetailsViewModel$upgradePlan$1(TproUpgradeDetailsViewModel tproUpgradeDetailsViewModel, String str, String str2, String str3, Continuation<? super TproUpgradeDetailsViewModel$upgradePlan$1> continuation) {
        super(2, continuation);
        this.f59330i = tproUpgradeDetailsViewModel;
        this.f59331j = str;
        this.f59332k = str2;
        this.f59333l = str3;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TproUpgradeDetailsViewModel$upgradePlan$1(this.f59330i, this.f59331j, this.f59332k, this.f59333l, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TproUpgradeDetailsViewModel$upgradePlan$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f59329h;
        boolean z11 = true;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            UpgradeSubscriptionPlanUseCase access$getUpgradePlanUseCase$p = this.f59330i.upgradePlanUseCase;
            UpgradeSubscriptionPlanUseCase.Params params = new UpgradeSubscriptionPlanUseCase.Params(this.f59331j, this.f59332k, this.f59333l);
            this.f59329h = 1;
            obj = access$getUpgradePlanUseCase$p.invoke(params, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        SubscriptionPaymentStatus subscriptionPaymentStatus = (SubscriptionPaymentStatus) obj;
        String redirectURL = subscriptionPaymentStatus.getResult().getRedirectURL();
        if (redirectURL != null && !StringsKt__StringsJVMKt.isBlank(redirectURL)) {
            z11 = false;
        }
        if (!z11) {
            this.f59330i._verification3ds.postValue(subscriptionPaymentStatus.getResult().getRedirectURL());
        } else if (subscriptionPaymentStatus.getResult().isSubscribed()) {
            this.f59330i.updateCustomerInfo();
        } else {
            this.f59330i._upgradeResult.postValue(null);
        }
        return Unit.INSTANCE;
    }
}
