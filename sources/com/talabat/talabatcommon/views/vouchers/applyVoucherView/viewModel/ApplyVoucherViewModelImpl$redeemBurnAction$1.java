package com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel;

import com.talabat.core.tracking.data.events.rewards.RedeemEventParams;
import com.talabat.talabatcommon.feature.vouchers.loyalty.data.RedeemTrackData;
import com.talabat.talabatcommon.feature.vouchers.loyalty.model.request.RedeemBurnItemRequestModel;
import com.talabat.talabatcommon.feature.vouchers.loyalty.model.response.SubscriptionRestriction;
import com.talabat.talabatcommon.feature.vouchers.loyalty.tracking.GrowthTracker;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.ApplyVoucherOwner;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.Bounds;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.DisabledReason;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.DiscountType;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.LoyaltyBurnOptionType;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.RedeemSourceType;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherData;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherDisplayModel;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherOptionType;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherType;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.ApplyVouchersViewStates;
import com.talabat.talabatcommon.views.vouchers.models.ConfirmationDisplayModel;
import com.talabat.talabatcore.functional.Either;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.ApplyVoucherViewModelImpl$redeemBurnAction$1", f = "ApplyVoucherViewModelImpl.kt", i = {}, l = {353}, m = "invokeSuspend", n = {}, s = {})
public final class ApplyVoucherViewModelImpl$redeemBurnAction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f11846h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ RedeemSourceType f11847i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ ApplyVoucherViewModelImpl f11848j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ VoucherDisplayModel f11849k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ LoyaltyBurnOptionType f11850l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ RedeemTrackData f11851m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ ApplyVoucherOwner f11852n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ApplyVoucherViewModelImpl$redeemBurnAction$1(RedeemSourceType redeemSourceType, ApplyVoucherViewModelImpl applyVoucherViewModelImpl, VoucherDisplayModel voucherDisplayModel, LoyaltyBurnOptionType loyaltyBurnOptionType, RedeemTrackData redeemTrackData, ApplyVoucherOwner applyVoucherOwner, Continuation<? super ApplyVoucherViewModelImpl$redeemBurnAction$1> continuation) {
        super(2, continuation);
        this.f11847i = redeemSourceType;
        this.f11848j = applyVoucherViewModelImpl;
        this.f11849k = voucherDisplayModel;
        this.f11850l = loyaltyBurnOptionType;
        this.f11851m = redeemTrackData;
        this.f11852n = applyVoucherOwner;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ApplyVoucherViewModelImpl$redeemBurnAction$1(this.f11847i, this.f11848j, this.f11849k, this.f11850l, this.f11851m, this.f11852n, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ApplyVoucherViewModelImpl$redeemBurnAction$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        final RedeemEventParams.ScreenType screenType;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f11846h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.f11847i == RedeemSourceType.BASKET) {
                screenType = RedeemEventParams.ScreenType.CART;
            } else {
                screenType = RedeemEventParams.ScreenType.REWARD;
            }
            ApplyVoucherViewModelImpl applyVoucherViewModelImpl = this.f11848j;
            Flow access$onFlowActionCompleted = applyVoucherViewModelImpl.onFlowActionCompleted(applyVoucherViewModelImpl.onFlowActionStarted(applyVoucherViewModelImpl.redeemBurnItem.invoke(new RedeemBurnItemRequestModel(this.f11849k.getId(), this.f11850l, this.f11847i, this.f11851m, (VoucherOptionType) null, 16, (DefaultConstructorMarker) null))));
            final ApplyVoucherOwner applyVoucherOwner = this.f11852n;
            final VoucherDisplayModel voucherDisplayModel = this.f11849k;
            final ApplyVoucherViewModelImpl applyVoucherViewModelImpl2 = this.f11848j;
            AnonymousClass1 r32 = new FlowCollector() {
                @Nullable
                public final Object emit(@NotNull Either<? extends VoucherFailures, ConfirmationDisplayModel> either, @NotNull Continuation<? super Unit> continuation) {
                    final ApplyVoucherOwner applyVoucherOwner = applyVoucherOwner;
                    final VoucherDisplayModel voucherDisplayModel = voucherDisplayModel;
                    final RedeemEventParams.ScreenType screenType = screenType;
                    final ApplyVoucherViewModelImpl applyVoucherViewModelImpl = applyVoucherViewModelImpl2;
                    AnonymousClass1 r72 = new Function1<VoucherFailures, Unit>() {
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((VoucherFailures) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(@NotNull VoucherFailures voucherFailures) {
                            Intrinsics.checkNotNullParameter(voucherFailures, "it");
                            GrowthTracker growthTracker = GrowthTracker.INSTANCE;
                            String screenName = applyVoucherOwner.getScreenName();
                            String title = voucherDisplayModel.getVoucherData().getTitle();
                            String localizedMessage = voucherFailures.getLocalizedMessage();
                            if (localizedMessage == null) {
                                localizedMessage = "N/A";
                            }
                            growthTracker.onRedeemVoucherFailed(screenName, title, localizedMessage, screenType, voucherDisplayModel.getId());
                            applyVoucherViewModelImpl.updateViewState(new ApplyVouchersViewStates.ApplyVouchersFailure(voucherFailures));
                        }
                    };
                    final ApplyVoucherOwner applyVoucherOwner2 = applyVoucherOwner;
                    final VoucherDisplayModel voucherDisplayModel2 = voucherDisplayModel;
                    final RedeemEventParams.ScreenType screenType2 = screenType;
                    final ApplyVoucherViewModelImpl applyVoucherViewModelImpl2 = applyVoucherViewModelImpl2;
                    Object either2 = either.either(r72, new Function1<ConfirmationDisplayModel, Unit>() {
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((ConfirmationDisplayModel) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(@NotNull ConfirmationDisplayModel confirmationDisplayModel) {
                            Intrinsics.checkNotNullParameter(confirmationDisplayModel, "it");
                            GrowthTracker.INSTANCE.onRedeemPointsCompleted(applyVoucherOwner2.getScreenName(), "", voucherDisplayModel2.getVoucherData().getTitle(), screenType2, confirmationDisplayModel.getCustomerVoucherId());
                            applyVoucherViewModelImpl2.updateViewState(new ApplyVouchersViewStates.RedeemVoucherDone(VoucherDisplayModel.copy$default(voucherDisplayModel2, confirmationDisplayModel.getCustomerVoucherId(), (String) null, (String) null, false, (VoucherType) null, VoucherData.copy$default(voucherDisplayModel2.getVoucherData(), confirmationDisplayModel.getCustomerVoucherId(), (String) null, 0, 0.0f, (DiscountType) null, 0.0f, 0.0f, (Bounds) null, (VoucherOptionType) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, 131070, (Object) null), (DisabledReason) null, (SubscriptionRestriction) null, (String) null, 478, (Object) null)));
                        }
                    });
                    if (either2 == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        return either2;
                    }
                    return Unit.INSTANCE;
                }
            };
            this.f11846h = 1;
            if (access$onFlowActionCompleted.collect(r32, this) == coroutine_suspended) {
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
