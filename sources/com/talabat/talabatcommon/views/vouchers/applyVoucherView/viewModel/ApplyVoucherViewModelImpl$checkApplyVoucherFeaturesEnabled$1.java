package com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel;

import com.talabat.talabatcommon.views.vouchers.applyVoucherView.ApplyVoucherOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.ApplyVoucherViewModelImpl$checkApplyVoucherFeaturesEnabled$1", f = "ApplyVoucherViewModelImpl.kt", i = {1, 2, 2}, l = {168, 170, 171}, m = "invokeSuspend", n = {"isBasketVouchersFeatureEnabled", "isBasketVouchersFeatureEnabled", "isTmartVouchersFeatureEnabled"}, s = {"Z$0", "Z$0", "Z$1"})
public final class ApplyVoucherViewModelImpl$checkApplyVoucherFeaturesEnabled$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public boolean f11793h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f11794i;

    /* renamed from: j  reason: collision with root package name */
    public int f11795j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ ApplyVoucherViewModelImpl f11796k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ ApplyVoucherOwner f11797l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ApplyVoucherViewModelImpl$checkApplyVoucherFeaturesEnabled$1(ApplyVoucherViewModelImpl applyVoucherViewModelImpl, ApplyVoucherOwner applyVoucherOwner, Continuation<? super ApplyVoucherViewModelImpl$checkApplyVoucherFeaturesEnabled$1> continuation) {
        super(2, continuation);
        this.f11796k = applyVoucherViewModelImpl;
        this.f11797l = applyVoucherOwner;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ApplyVoucherViewModelImpl$checkApplyVoucherFeaturesEnabled$1(this.f11796k, this.f11797l, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ApplyVoucherViewModelImpl$checkApplyVoucherFeaturesEnabled$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0071 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0072  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.f11795j
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x002b
            if (r1 == r4) goto L_0x0027
            if (r1 == r3) goto L_0x0021
            if (r1 != r2) goto L_0x0019
            boolean r0 = r6.f11794i
            boolean r1 = r6.f11793h
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0074
        L_0x0019:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0021:
            boolean r1 = r6.f11793h
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0059
        L_0x0027:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x003d
        L_0x002b:
            kotlin.ResultKt.throwOnFailure(r7)
            com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.ApplyVoucherViewModelImpl r7 = r6.f11796k
            com.talabat.talabatcommon.feature.vouchers.loyalty.domain.IsBasketVouchersFeatureEnabledUseCase r7 = r7.isBasketVouchersFeatureEnabledUseCase
            r6.f11795j = r4
            java.lang.Object r7 = r7.invoke(r6)
            if (r7 != r0) goto L_0x003d
            return r0
        L_0x003d:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.ApplyVoucherViewModelImpl r1 = r6.f11796k
            com.talabat.talabatcommon.feature.vouchers.loyalty.domain.IsTmartVouchersFeatureEnabledUseCase r1 = r1.isTmartVouchersFeatureEnabledUseCase
            com.talabat.talabatcommon.views.vouchers.applyVoucherView.ApplyVoucherOwner r4 = r6.f11797l
            r6.f11793h = r7
            r6.f11795j = r3
            java.lang.Object r1 = r1.invoke(r4, r6)
            if (r1 != r0) goto L_0x0056
            return r0
        L_0x0056:
            r5 = r1
            r1 = r7
            r7 = r5
        L_0x0059:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.ApplyVoucherViewModelImpl r3 = r6.f11796k
            com.talabat.talabatcommon.feature.vouchers.loyalty.domain.IsVoucherCodesFeatureEnabledUseCase r3 = r3.isVoucherCodesFeatureEnabledUseCase
            r6.f11793h = r1
            r6.f11794i = r7
            r6.f11795j = r2
            java.lang.Object r2 = r3.invoke(r6)
            if (r2 != r0) goto L_0x0072
            return r0
        L_0x0072:
            r0 = r7
            r7 = r2
        L_0x0074:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            buisnessmodels.Cart r2 = buisnessmodels.Cart.getInstance()
            boolean r2 = r2.isPickup()
            com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.ApplyVoucherViewModelImpl$checkApplyVoucherFeaturesEnabled$1$isLoyaltyVoucherEnabled$1 r3 = new com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.ApplyVoucherViewModelImpl$checkApplyVoucherFeaturesEnabled$1$isLoyaltyVoucherEnabled$1
            com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.ApplyVoucherViewModelImpl r4 = r6.f11796k
            r3.<init>(r4, r0, r1)
            com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.ApplyVoucherViewModelImpl r0 = r6.f11796k
            com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.ApplyVouchersViewStates$EnableVouchersFeature r1 = new com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.ApplyVouchersViewStates$EnableVouchersFeature
            java.lang.Object r3 = r3.invoke()
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.ApplyVoucherViewModelImpl r4 = r6.f11796k
            boolean r4 = r4.isDarkStore()
            r1.<init>(r3, r7, r4, r2)
            r0.updateViewState(r1)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.ApplyVoucherViewModelImpl$checkApplyVoucherFeaturesEnabled$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
