package com.talabat.talabatcommon.feature.vouchers.loyalty.domain;

import androidx.annotation.VisibleForTesting;
import buisnessmodels.Cart;
import com.facebook.internal.NativeProtocol;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.featureflag.domain.flags.rewards.RewardsFeatureFlagConstants;
import com.talabat.core.flutter.channels.impl.data.tpro.TProChannelCallbackImpl;
import com.talabat.talabatcommon.feature.vouchers.loyalty.model.request.MyPossibleVouchersRequestModel;
import com.talabat.talabatcommon.feature.vouchers.loyalty.model.response.SubscriptionRestriction;
import com.talabat.talabatcommon.feature.vouchers.loyalty.repository.VoucherRepository;
import com.talabat.talabatcommon.feature.vouchers.loyalty.tracking.GrowthTrackerConstants;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.ApplyVoucherViewHolderDisplayModel;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.DisabledReason;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.DiscountType;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherDisplayModel;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.VoucherFailures;
import com.talabat.talabatcore.functional.Either;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import library.talabat.mvp.login.domain.repository.CustomerRepository;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0002\u0010\rJ\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0007J#\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u00140\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\fH\u0007J\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u001bH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/talabat/talabatcommon/feature/vouchers/loyalty/domain/GetMyPossibleVouchersUseCase;", "", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "customerRepository", "Llibrary/talabat/mvp/login/domain/repository/CustomerRepository;", "voucherRepository", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/repository/VoucherRepository;", "funWithFlags", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "isTProEnabled", "Lkotlin/Function0;", "", "(Lkotlinx/coroutines/CoroutineDispatcher;Llibrary/talabat/mvp/login/domain/repository/CustomerRepository;Lcom/talabat/talabatcommon/feature/vouchers/loyalty/repository/VoucherRepository;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;Lkotlin/jvm/functions/Function0;)V", "filterByRestrictions", "", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherDisplayModel;", "vouchers", "invoke", "Lkotlinx/coroutines/flow/Flow;", "Lcom/talabat/talabatcore/functional/Either;", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/VoucherFailures;", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/ApplyVoucherViewHolderDisplayModel;", "params", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/request/MyPossibleVouchersRequestModel;", "isFreeDeliveryTypeVouchersApplicable", "moveFreeDeliveryTypeVouchersToEndAndDisable", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetMyPossibleVouchersUseCase {
    /* access modifiers changed from: private */
    @NotNull
    public final CustomerRepository customerRepository;
    @NotNull
    private final CoroutineDispatcher dispatcher;
    @NotNull
    private final ITalabatFeatureFlag funWithFlags;
    @NotNull
    private final Function0<Boolean> isTProEnabled;
    /* access modifiers changed from: private */
    @NotNull
    public final VoucherRepository voucherRepository;

    public GetMyPossibleVouchersUseCase(@NotNull CoroutineDispatcher coroutineDispatcher, @NotNull CustomerRepository customerRepository2, @NotNull VoucherRepository voucherRepository2, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(customerRepository2, "customerRepository");
        Intrinsics.checkNotNullParameter(voucherRepository2, "voucherRepository");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "funWithFlags");
        Intrinsics.checkNotNullParameter(function0, TProChannelCallbackImpl.IS_PRO_ENABLED_VALUE_KEY);
        this.dispatcher = coroutineDispatcher;
        this.customerRepository = customerRepository2;
        this.voucherRepository = voucherRepository2;
        this.funWithFlags = iTalabatFeatureFlag;
        this.isTProEnabled = function0;
    }

    /* access modifiers changed from: private */
    public static final boolean moveFreeDeliveryTypeVouchersToEndAndDisable$isFreeDeliveryType(VoucherDisplayModel voucherDisplayModel) {
        return ArraysKt___ArraysKt.contains((T[]) new DiscountType[]{DiscountType.DELIVERY_PERCENTAGE, DiscountType.FLAT_DELIVERY}, voucherDisplayModel.getVoucherData().getDiscountType());
    }

    @NotNull
    @VisibleForTesting
    public final List<VoucherDisplayModel> filterByRestrictions(@NotNull List<VoucherDisplayModel> list) {
        boolean z11;
        Intrinsics.checkNotNullParameter(list, GrowthTrackerConstants.VOUCHERS_FEATURE_NAME);
        if (ITalabatFeatureFlag.DefaultImpls.getFeatureFlag$default(this.funWithFlags, RewardsFeatureFlagConstants.CAN_SHOW_PRO_NON_PRO_REWARDS, false, 2, (Object) null)) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (Object next : list) {
            if (((VoucherDisplayModel) next).getSubscriptionRestriction() == SubscriptionRestriction.UNRESTRICTED) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                arrayList.add(next);
            }
        }
        return CollectionsKt___CollectionsKt.toMutableList(arrayList);
    }

    @NotNull
    public final Flow<Either<VoucherFailures, ApplyVoucherViewHolderDisplayModel>> invoke(@NotNull MyPossibleVouchersRequestModel myPossibleVouchersRequestModel) {
        Intrinsics.checkNotNullParameter(myPossibleVouchersRequestModel, NativeProtocol.WEB_DIALOG_PARAMS);
        return FlowKt.flowOn(FlowKt.flow(new GetMyPossibleVouchersUseCase$invoke$1(this, myPossibleVouchersRequestModel, (Continuation<? super GetMyPossibleVouchersUseCase$invoke$1>) null)), this.dispatcher);
    }

    @VisibleForTesting
    public final boolean isFreeDeliveryTypeVouchersApplicable() {
        return !(Cart.getInstance().getDeliveryChargesForDiscountedTier() == 0.0f);
    }

    @NotNull
    @VisibleForTesting
    public final List<VoucherDisplayModel> moveFreeDeliveryTypeVouchersToEndAndDisable(@NotNull List<VoucherDisplayModel> list) {
        DisabledReason disabledReason;
        Intrinsics.checkNotNullParameter(list, GrowthTrackerConstants.VOUCHERS_FEATURE_NAME);
        List sortedWith = CollectionsKt___CollectionsKt.sortedWith(list, new GetMyPossibleVouchersUseCase$moveFreeDeliveryTypeVouchersToEndAndDisable$$inlined$sortedBy$1());
        if (this.isTProEnabled.invoke().booleanValue()) {
            disabledReason = DisabledReason.T_PRO;
        } else {
            disabledReason = DisabledReason.VENDOR;
        }
        ArrayList<VoucherDisplayModel> arrayList = new ArrayList<>();
        for (Object next : sortedWith) {
            if (moveFreeDeliveryTypeVouchersToEndAndDisable$isFreeDeliveryType((VoucherDisplayModel) next)) {
                arrayList.add(next);
            }
        }
        for (VoucherDisplayModel disabledReason2 : arrayList) {
            disabledReason2.setDisabledReason(disabledReason);
        }
        return CollectionsKt___CollectionsKt.toMutableList(sortedWith);
    }
}
