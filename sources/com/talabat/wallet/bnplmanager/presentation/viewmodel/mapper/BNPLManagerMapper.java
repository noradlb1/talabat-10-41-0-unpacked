package com.talabat.wallet.bnplmanager.presentation.viewmodel.mapper;

import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.talabatcommon.model.wallet.WalletCardDisplayModel;
import com.talabat.talabatcommon.utils.CurrencyFormatter;
import com.talabat.talabatcommon.utils.DateUtils;
import com.talabat.talabatnavigation.tLife.TLifeNavigationActions;
import com.talabat.wallet.bnplmanager.data.remote.dto.request.BNPLCardDetail;
import com.talabat.wallet.bnplmanager.domain.entity.BNPLInstallments;
import com.talabat.wallet.bnplmanager.domain.entity.BNPLOrderPaymentStatus;
import com.talabat.wallet.bnplmanager.domain.entity.BNPLPaymentDetailsDisplayModel;
import com.talabat.wallet.bnplmanager.domain.entity.BNPLPlan;
import com.talabat.wallet.bnplmanager.domain.entity.InstallmentDetail;
import com.talabat.wallet.bnplmanager.presentation.displaymodel.BNPLOrderPaymentState;
import com.talabat.wallet.bnplmanager.presentation.displaymodel.BNPLPaymentDetailsState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ.\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016¨\u0006\u0017"}, d2 = {"Lcom/talabat/wallet/bnplmanager/presentation/viewmodel/mapper/BNPLManagerMapper;", "", "()V", "mapToBNPLCardDetail", "Lcom/talabat/wallet/bnplmanager/data/remote/dto/request/BNPLCardDetail;", "cardModel", "Lcom/talabat/talabatcommon/model/wallet/WalletCardDisplayModel;", "mapToBNPLOrderPlacementState", "Lcom/talabat/wallet/bnplmanager/presentation/displaymodel/BNPLOrderPaymentState;", "response", "Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLOrderPaymentStatus;", "mapToBNPLPaymentDetailsDisplayModel", "Lcom/talabat/wallet/bnplmanager/presentation/displaymodel/BNPLPaymentDetailsState;", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "amount", "", "installmentsDetail", "Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLInstallments;", "plan", "Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLPlan;", "dateFormat", "", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BNPLManagerMapper {
    @NotNull
    public static final BNPLManagerMapper INSTANCE = new BNPLManagerMapper();

    private BNPLManagerMapper() {
    }

    @NotNull
    public final BNPLCardDetail mapToBNPLCardDetail(@Nullable WalletCardDisplayModel walletCardDisplayModel) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7 = null;
        if (walletCardDisplayModel != null) {
            str = walletCardDisplayModel.getTokenId();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        if (walletCardDisplayModel != null) {
            str2 = walletCardDisplayModel.getCard4Digits();
        } else {
            str2 = null;
        }
        if (str2 == null) {
            str2 = "";
        }
        if (walletCardDisplayModel != null) {
            str3 = walletCardDisplayModel.getExpiryMonth();
        } else {
            str3 = null;
        }
        if (str3 == null) {
            str3 = "";
        }
        if (walletCardDisplayModel != null) {
            str4 = walletCardDisplayModel.getExpiryYear();
        } else {
            str4 = null;
        }
        if (str4 == null) {
            str4 = "";
        }
        String str8 = str3 + BNPLManagerMapperKt.YEAR_PREFIX + str4;
        if (walletCardDisplayModel != null) {
            str5 = walletCardDisplayModel.getCardType();
        } else {
            str5 = null;
        }
        if (str5 == null) {
            str5 = "";
        }
        if (walletCardDisplayModel != null) {
            str7 = walletCardDisplayModel.getBinNumber();
        }
        if (str7 == null) {
            str6 = "";
        } else {
            str6 = str7;
        }
        return new BNPLCardDetail(str, str2, str8, str5, str6);
    }

    @NotNull
    public final BNPLOrderPaymentState mapToBNPLOrderPlacementState(@NotNull BNPLOrderPaymentStatus bNPLOrderPaymentStatus) {
        Intrinsics.checkNotNullParameter(bNPLOrderPaymentStatus, "response");
        if (bNPLOrderPaymentStatus.isServerError()) {
            return BNPLOrderPaymentState.ServerError.INSTANCE;
        }
        if (bNPLOrderPaymentStatus.isOrderPaymentSuccessful()) {
            return BNPLOrderPaymentState.BNPLPaymentSuccess.INSTANCE;
        }
        return new BNPLOrderPaymentState.BNPLPaymentError(bNPLOrderPaymentStatus.getOrderPaymentError());
    }

    @NotNull
    public final BNPLPaymentDetailsState mapToBNPLPaymentDetailsDisplayModel(@NotNull LocationConfigurationRepository locationConfigurationRepository, float f11, @NotNull BNPLInstallments bNPLInstallments, @NotNull BNPLPlan bNPLPlan, @NotNull String str) {
        String str2;
        Intrinsics.checkNotNullParameter(locationConfigurationRepository, "locationConfigurationRepository");
        Intrinsics.checkNotNullParameter(bNPLInstallments, "installmentsDetail");
        Intrinsics.checkNotNullParameter(bNPLPlan, TLifeNavigationActions.EXTRA_PLAN);
        Intrinsics.checkNotNullParameter(str, "dateFormat");
        if (bNPLInstallments.isServerError()) {
            return BNPLPaymentDetailsState.ServerError.INSTANCE;
        }
        BNPLPaymentDetailsDisplayModel bNPLPaymentDetailsDisplayModel = new BNPLPaymentDetailsDisplayModel();
        InstallmentDetail installmentDetail = (InstallmentDetail) CollectionsKt___CollectionsKt.getOrNull(bNPLInstallments.getInstallments(), 0);
        if (installmentDetail != null) {
            str2 = installmentDetail.getPaymentDate();
        } else {
            str2 = null;
        }
        if (str2 == null) {
            str2 = "";
        }
        CurrencyFormatter.Companion companion = CurrencyFormatter.Companion;
        bNPLPaymentDetailsDisplayModel.setOrderAmount(companion.formatAmount(locationConfigurationRepository, f11, true));
        bNPLPaymentDetailsDisplayModel.setInstallmentDetailList(bNPLInstallments.getInstallments());
        bNPLPaymentDetailsDisplayModel.setDueDate(DateUtils.Companion.getLocalizedFormattedDateString(str2, str));
        bNPLPaymentDetailsDisplayModel.setDueToday(companion.formatAmount(locationConfigurationRepository, 0.0f, true));
        if (bNPLPlan.getPaymentCycles() > 0) {
            bNPLPaymentDetailsDisplayModel.setInstallmentAmount(companion.formatAmount(locationConfigurationRepository, f11 / ((float) bNPLPlan.getPaymentCycles()), true));
        }
        return new BNPLPaymentDetailsState.BNPLPaymentDetailsSuccess(bNPLPaymentDetailsDisplayModel);
    }
}
