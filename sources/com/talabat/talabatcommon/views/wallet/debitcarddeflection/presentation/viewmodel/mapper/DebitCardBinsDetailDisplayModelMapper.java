package com.talabat.talabatcommon.views.wallet.debitcarddeflection.presentation.viewmodel.mapper;

import buisnessmodels.tokenisation.TokenisationCreditCard;
import com.talabat.talabatcommon.extentions.StringUtils;
import com.talabat.talabatcommon.views.wallet.benefitmanager.domain.entity.BenefitBin;
import com.talabat.talabatcommon.views.wallet.benefitmanager.domain.entity.BenefitBinsDetail;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.viewModel.DeflectionInfoDisplayModel;
import com.talabat.talabatcommon.views.wallet.debitcarddeflection.presentation.displaymodel.DebitCardBinVerificationDisplayModel;
import com.talabat.talabatcommon.views.wallet.debitcarddeflection.presentation.displaymodel.DebitCardBinsDetailDisplayModel;
import com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.entity.QPayDeflectionBin;
import com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.entity.QPayDeflectionBinDetail;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00042\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/debitcarddeflection/presentation/viewmodel/mapper/DebitCardBinsDetailDisplayModelMapper;", "", "()V", "BIN_DELIMITER", "", "formatBinsToRequiredInput", "cardList", "", "Lbuisnessmodels/tokenisation/TokenisationCreditCard;", "mapBenefitVerificationDisplayModel", "Lcom/talabat/talabatcommon/views/wallet/debitcarddeflection/presentation/displaymodel/DebitCardBinVerificationDisplayModel;", "benefitBinsDetail", "Lcom/talabat/talabatcommon/views/wallet/benefitmanager/domain/entity/BenefitBinsDetail;", "mapDeflectionInfoDisplayModel", "Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/viewModel/DeflectionInfoDisplayModel;", "mapQPayVerificationDisplayModel", "qPayDeflectionBinDetail", "Lcom/talabat/talabatcommon/views/wallet/qpaydeflection/domain/entity/QPayDeflectionBinDetail;", "mapToBenefitBinsDetailDisplayModel", "Lcom/talabat/talabatcommon/views/wallet/debitcarddeflection/presentation/displaymodel/DebitCardBinsDetailDisplayModel;", "mapToQPayBinsDetailDisplayModel", "qPayBinsDetail", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DebitCardBinsDetailDisplayModelMapper {
    @NotNull
    private static final String BIN_DELIMITER = ",";
    @NotNull
    public static final DebitCardBinsDetailDisplayModelMapper INSTANCE = new DebitCardBinsDetailDisplayModelMapper();

    private DebitCardBinsDetailDisplayModelMapper() {
    }

    @NotNull
    public final String formatBinsToRequiredInput(@Nullable List<? extends TokenisationCreditCard> list) {
        String empty = StringUtils.empty(StringCompanionObject.INSTANCE);
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        for (TokenisationCreditCard tokenisationCreditCard : list) {
            empty = empty + tokenisationCreditCard.binNumber + ",";
        }
        return empty;
    }

    @NotNull
    public final DebitCardBinVerificationDisplayModel mapBenefitVerificationDisplayModel(@NotNull BenefitBinsDetail benefitBinsDetail) {
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
        if (z11) {
            return DebitCardBinVerificationDisplayModel.ShowBenefitAddCardDeflection.INSTANCE;
        }
        return DebitCardBinVerificationDisplayModel.ShowDefaultAddCardViews.INSTANCE;
    }

    @NotNull
    public final DebitCardBinVerificationDisplayModel mapDeflectionInfoDisplayModel(@NotNull DeflectionInfoDisplayModel deflectionInfoDisplayModel) {
        Intrinsics.checkNotNullParameter(deflectionInfoDisplayModel, "benefitBinsDetail");
        if (Intrinsics.areEqual((Object) deflectionInfoDisplayModel, (Object) DeflectionInfoDisplayModel.Hidden.INSTANCE)) {
            return DebitCardBinVerificationDisplayModel.ShowDefaultAddCardViews.INSTANCE;
        }
        if (deflectionInfoDisplayModel instanceof DeflectionInfoDisplayModel.ShowBahrainBenefit) {
            return DebitCardBinVerificationDisplayModel.ShowBenefitAddCardDeflection.INSTANCE;
        }
        if (deflectionInfoDisplayModel instanceof DeflectionInfoDisplayModel.ShowQPay) {
            return DebitCardBinVerificationDisplayModel.ShowQPayAddCardDeflection.INSTANCE;
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public final DebitCardBinVerificationDisplayModel mapQPayVerificationDisplayModel(@NotNull QPayDeflectionBinDetail qPayDeflectionBinDetail) {
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
        if (z11) {
            return DebitCardBinVerificationDisplayModel.ShowQPayAddCardDeflection.INSTANCE;
        }
        return DebitCardBinVerificationDisplayModel.ShowDefaultAddCardViews.INSTANCE;
    }

    @NotNull
    public final DebitCardBinsDetailDisplayModel mapToBenefitBinsDetailDisplayModel(@NotNull BenefitBinsDetail benefitBinsDetail) {
        Intrinsics.checkNotNullParameter(benefitBinsDetail, "benefitBinsDetail");
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
        return new DebitCardBinsDetailDisplayModel.ShowDebitCardBinsInfo(CollectionsKt___CollectionsKt.toSet(arrayList2));
    }

    @NotNull
    public final DebitCardBinsDetailDisplayModel mapToQPayBinsDetailDisplayModel(@NotNull QPayDeflectionBinDetail qPayDeflectionBinDetail) {
        Intrinsics.checkNotNullParameter(qPayDeflectionBinDetail, "qPayBinsDetail");
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
        return new DebitCardBinsDetailDisplayModel.ShowDebitCardBinsInfo(CollectionsKt___CollectionsKt.toSet(arrayList2));
    }
}
