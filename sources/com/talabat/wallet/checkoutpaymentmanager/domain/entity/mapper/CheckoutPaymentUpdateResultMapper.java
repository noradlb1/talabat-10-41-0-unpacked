package com.talabat.wallet.checkoutpaymentmanager.domain.entity.mapper;

import com.talabat.talabatcommon.views.wallet.benefitmanager.domain.entity.BenefitBin;
import com.talabat.talabatcommon.views.wallet.benefitmanager.domain.entity.BenefitBinsDetail;
import com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.entity.QPayDeflectionBin;
import com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.entity.QPayDeflectionBinDetail;
import com.talabat.wallet.checkoutpaymentmanager.domain.entity.CheckoutPaymentUpdateResult;
import com.talabat.wallet.knetStatusManager.domain.entity.KNetStatusResult;
import com.talabat.wallet.qPayManager.domain.entity.QPayStatus;
import java.util.ArrayList;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011¨\u0006\u0012"}, d2 = {"Lcom/talabat/wallet/checkoutpaymentmanager/domain/entity/mapper/CheckoutPaymentUpdateResultMapper;", "", "()V", "mapBenefitBinsToCheckoutPaymentUpdateResult", "Lcom/talabat/wallet/checkoutpaymentmanager/domain/entity/CheckoutPaymentUpdateResult;", "benefitBinsDetail", "Lcom/talabat/talabatcommon/views/wallet/benefitmanager/domain/entity/BenefitBinsDetail;", "mapKNetStatusToCheckoutPaymentUpdateResult", "kNetStatusResult", "Lcom/talabat/wallet/knetStatusManager/domain/entity/KNetStatusResult;", "mapQPayBinsToCheckoutPaymentUpdateResult", "qPayDeflectionBinDetail", "Lcom/talabat/talabatcommon/views/wallet/qpaydeflection/domain/entity/QPayDeflectionBinDetail;", "isQPayServiceDown", "", "mapQPayStatusToCheckoutPaymentUpdateResult", "qPayStatus", "Lcom/talabat/wallet/qPayManager/domain/entity/QPayStatus;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CheckoutPaymentUpdateResultMapper {
    @NotNull
    public static final CheckoutPaymentUpdateResultMapper INSTANCE = new CheckoutPaymentUpdateResultMapper();

    private CheckoutPaymentUpdateResultMapper() {
    }

    @NotNull
    public final CheckoutPaymentUpdateResult mapBenefitBinsToCheckoutPaymentUpdateResult(@NotNull BenefitBinsDetail benefitBinsDetail) {
        Intrinsics.checkNotNullParameter(benefitBinsDetail, "benefitBinsDetail");
        Set mutableSetOf = SetsKt__SetsKt.mutableSetOf(new String());
        if (benefitBinsDetail.getBinsDetails().isEmpty()) {
            return CheckoutPaymentUpdateResult.DefaultPaymentMethod.INSTANCE;
        }
        for (BenefitBin next : benefitBinsDetail.getBinsDetails()) {
            if (next.isBenefitBin()) {
                mutableSetOf.add(next.getBinNumber());
            }
        }
        return new CheckoutPaymentUpdateResult.BenefitBinsInfo(mutableSetOf, benefitBinsDetail.getBenefitCardDeflectionExpiryDate());
    }

    @NotNull
    public final CheckoutPaymentUpdateResult mapKNetStatusToCheckoutPaymentUpdateResult(@NotNull KNetStatusResult kNetStatusResult) {
        Intrinsics.checkNotNullParameter(kNetStatusResult, "kNetStatusResult");
        if (Intrinsics.areEqual((Object) kNetStatusResult, (Object) KNetStatusResult.KNetIsAvailable.INSTANCE)) {
            return CheckoutPaymentUpdateResult.KNetIsAvailable.INSTANCE;
        }
        if (Intrinsics.areEqual((Object) kNetStatusResult, (Object) KNetStatusResult.KNetIsUnAvailable.INSTANCE)) {
            return CheckoutPaymentUpdateResult.KNetIsUnAvailable.INSTANCE;
        }
        if (Intrinsics.areEqual((Object) kNetStatusResult, (Object) KNetStatusResult.UnAvailableKNetCheck.INSTANCE)) {
            return CheckoutPaymentUpdateResult.DefaultPaymentMethod.INSTANCE;
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public final CheckoutPaymentUpdateResult mapQPayBinsToCheckoutPaymentUpdateResult(@NotNull QPayDeflectionBinDetail qPayDeflectionBinDetail, boolean z11) {
        Intrinsics.checkNotNullParameter(qPayDeflectionBinDetail, "qPayDeflectionBinDetail");
        if (z11) {
            return CheckoutPaymentUpdateResult.QPayIsDown.INSTANCE;
        }
        if (qPayDeflectionBinDetail.getBinsDetails().isEmpty()) {
            return CheckoutPaymentUpdateResult.DefaultPaymentMethod.INSTANCE;
        }
        ArrayList<QPayDeflectionBin> arrayList = new ArrayList<>();
        for (Object next : qPayDeflectionBinDetail.getBinsDetails()) {
            if (((QPayDeflectionBin) next).isQPayBin()) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
        for (QPayDeflectionBin binNumber : arrayList) {
            arrayList2.add(binNumber.getBinNumber());
        }
        return new CheckoutPaymentUpdateResult.QPayBinsInfo(CollectionsKt___CollectionsKt.toSet(arrayList2), qPayDeflectionBinDetail.getQPayBinDeflectionExpiryDate());
    }

    @NotNull
    public final CheckoutPaymentUpdateResult mapQPayStatusToCheckoutPaymentUpdateResult(@NotNull QPayStatus qPayStatus) {
        Intrinsics.checkNotNullParameter(qPayStatus, "qPayStatus");
        if (Intrinsics.areEqual((Object) qPayStatus, (Object) QPayStatus.QPayIsAvailable.INSTANCE)) {
            return CheckoutPaymentUpdateResult.QPayIsAvailable.INSTANCE;
        }
        if (Intrinsics.areEqual((Object) qPayStatus, (Object) QPayStatus.QPayIsUnAvailable.INSTANCE)) {
            return CheckoutPaymentUpdateResult.QPayIsNotAvailable.INSTANCE;
        }
        throw new NoWhenBranchMatchedException();
    }
}
