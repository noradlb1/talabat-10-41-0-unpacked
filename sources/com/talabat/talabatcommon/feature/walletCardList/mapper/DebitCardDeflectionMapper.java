package com.talabat.talabatcommon.feature.walletCardList.mapper;

import com.talabat.talabatcommon.views.wallet.benefitmanager.domain.entity.BenefitBin;
import com.talabat.talabatcommon.views.wallet.benefitmanager.domain.entity.BenefitBinsDetail;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.viewModel.DeflectionInfoDisplayModel;
import com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.entity.QPayDeflectionBin;
import com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.entity.QPayDeflectionBinDetail;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/talabat/talabatcommon/feature/walletCardList/mapper/DebitCardDeflectionMapper;", "", "()V", "mapBenefitBinsDetailToDeflectionInfoDisplayModel", "Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/viewModel/DeflectionInfoDisplayModel;", "benefitBinsDetail", "Lcom/talabat/talabatcommon/views/wallet/benefitmanager/domain/entity/BenefitBinsDetail;", "mapQPayDeflectionBinDetailToDeflectionInfoDisplayModel", "qPayDeflectionBinDetail", "Lcom/talabat/talabatcommon/views/wallet/qpaydeflection/domain/entity/QPayDeflectionBinDetail;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DebitCardDeflectionMapper {
    @NotNull
    public static final DebitCardDeflectionMapper INSTANCE = new DebitCardDeflectionMapper();

    private DebitCardDeflectionMapper() {
    }

    @NotNull
    public final DeflectionInfoDisplayModel mapBenefitBinsDetailToDeflectionInfoDisplayModel(@NotNull BenefitBinsDetail benefitBinsDetail) {
        Intrinsics.checkNotNullParameter(benefitBinsDetail, "benefitBinsDetail");
        Iterable binsDetails = benefitBinsDetail.getBinsDetails();
        boolean z11 = false;
        if (!(binsDetails instanceof Collection) || !((Collection) binsDetails).isEmpty()) {
            Iterator it = binsDetails.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((BenefitBin) it.next()).isBenefitBin()) {
                        z11 = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        if (!z11) {
            return DeflectionInfoDisplayModel.Hidden.INSTANCE;
        }
        ArrayList<BenefitBin> arrayList = new ArrayList<>();
        for (Object next : benefitBinsDetail.getBinsDetails()) {
            if (((BenefitBin) next).isBenefitBin()) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
        for (BenefitBin binNumber : arrayList) {
            arrayList2.add(binNumber.getBinNumber());
        }
        return new DeflectionInfoDisplayModel.ShowBahrainBenefit(CollectionsKt___CollectionsKt.toSet(arrayList2));
    }

    @NotNull
    public final DeflectionInfoDisplayModel mapQPayDeflectionBinDetailToDeflectionInfoDisplayModel(@NotNull QPayDeflectionBinDetail qPayDeflectionBinDetail) {
        Intrinsics.checkNotNullParameter(qPayDeflectionBinDetail, "qPayDeflectionBinDetail");
        Iterable binsDetails = qPayDeflectionBinDetail.getBinsDetails();
        boolean z11 = false;
        if (!(binsDetails instanceof Collection) || !((Collection) binsDetails).isEmpty()) {
            Iterator it = binsDetails.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((QPayDeflectionBin) it.next()).isQPayBin()) {
                        z11 = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        if (!z11) {
            return DeflectionInfoDisplayModel.Hidden.INSTANCE;
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
        return new DeflectionInfoDisplayModel.ShowQPay(CollectionsKt___CollectionsKt.toSet(arrayList2));
    }
}
