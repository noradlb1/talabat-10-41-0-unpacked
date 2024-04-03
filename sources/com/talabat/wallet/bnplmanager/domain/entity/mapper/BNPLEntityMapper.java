package com.talabat.wallet.bnplmanager.domain.entity.mapper;

import com.talabat.mapper.ModelMappingIntegrationKt;
import com.talabat.talabatcommon.extentions.BooleanKt;
import com.talabat.wallet.bnplmanager.data.remote.dto.BNPLEligibilityRemoteDto;
import com.talabat.wallet.bnplmanager.data.remote.dto.BNPLEligibilityRemoteResultDto;
import com.talabat.wallet.bnplmanager.data.remote.dto.BNPLInstallmentRemoteDto;
import com.talabat.wallet.bnplmanager.data.remote.dto.BNPLInstallmentsRemoteDto;
import com.talabat.wallet.bnplmanager.data.remote.dto.BNPLInstallmentsRemoteResultDto;
import com.talabat.wallet.bnplmanager.data.remote.dto.BNPLPaymentStatus;
import com.talabat.wallet.bnplmanager.data.remote.dto.BNPLPlanRemoteDto;
import com.talabat.wallet.bnplmanager.data.remote.dto.BNPLPlansRemoteDto;
import com.talabat.wallet.bnplmanager.data.remote.dto.BNPLPlansRemoteResultDto;
import com.talabat.wallet.bnplmanager.data.remote.dto.response.BNPLOrderPaymentRemoteDto;
import com.talabat.wallet.bnplmanager.data.remote.dto.response.BNPLOrderPaymentRemoteResultDto;
import com.talabat.wallet.bnplmanager.domain.entity.BNPLEligibilityDetail;
import com.talabat.wallet.bnplmanager.domain.entity.BNPLInstallments;
import com.talabat.wallet.bnplmanager.domain.entity.BNPLOrderPaymentError;
import com.talabat.wallet.bnplmanager.domain.entity.BNPLOrderPaymentStatus;
import com.talabat.wallet.bnplmanager.domain.entity.BNPLPlan;
import com.talabat.wallet.bnplmanager.domain.entity.BNPLValidationError;
import com.talabat.wallet.bnplmanager.domain.entity.InstallmentDetail;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\tJ\u0010\u0010\n\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\fJ\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0010¨\u0006\u0011"}, d2 = {"Lcom/talabat/wallet/bnplmanager/domain/entity/mapper/BNPLEntityMapper;", "", "()V", "mapToBNPLEligibilityDetail", "Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLEligibilityDetail;", "response", "Lcom/talabat/wallet/bnplmanager/data/remote/dto/BNPLEligibilityRemoteDto;", "mapToBNPLInstallments", "Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLInstallments;", "Lcom/talabat/wallet/bnplmanager/data/remote/dto/BNPLInstallmentsRemoteDto;", "mapToBNPLOrderPaymentStatus", "Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLOrderPaymentStatus;", "Lcom/talabat/wallet/bnplmanager/data/remote/dto/response/BNPLOrderPaymentRemoteDto;", "mapToBNPLPlans", "", "Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLPlan;", "Lcom/talabat/wallet/bnplmanager/data/remote/dto/BNPLPlansRemoteDto;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BNPLEntityMapper {
    @NotNull
    public static final BNPLEntityMapper INSTANCE = new BNPLEntityMapper();

    private BNPLEntityMapper() {
    }

    @NotNull
    public final BNPLEligibilityDetail mapToBNPLEligibilityDetail(@Nullable BNPLEligibilityRemoteDto bNPLEligibilityRemoteDto) {
        BNPLEligibilityRemoteResultDto bNPLEligibilityRemoteResultDto;
        if (bNPLEligibilityRemoteDto == null || (bNPLEligibilityRemoteResultDto = bNPLEligibilityRemoteDto.getBNPLEligibilityRemoteResultDto()) == null) {
            return new BNPLEligibilityDetail((BNPLValidationError) null, false, false, 7, (DefaultConstructorMarker) null);
        }
        return new BNPLEligibilityDetail((BNPLValidationError) ModelMappingIntegrationKt.parseFromNullable(new BNPLValidationError((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null), bNPLEligibilityRemoteResultDto.getBNPLValidationError()), BooleanKt.orTrue(bNPLEligibilityRemoteResultDto.isHideBNPLPaymentMethod()), BooleanKt.orFalse(bNPLEligibilityRemoteResultDto.isBNPLEligible()));
    }

    @NotNull
    public final BNPLInstallments mapToBNPLInstallments(@Nullable BNPLInstallmentsRemoteDto bNPLInstallmentsRemoteDto) {
        BNPLInstallmentsRemoteResultDto bNPLInstallmentsRemoteResultDto;
        List<BNPLInstallmentRemoteDto> bNPLInstallments;
        ArrayList arrayList = new ArrayList();
        if (!(bNPLInstallmentsRemoteDto == null || (bNPLInstallmentsRemoteResultDto = bNPLInstallmentsRemoteDto.getBNPLInstallmentsRemoteResultDto()) == null || (bNPLInstallments = bNPLInstallmentsRemoteResultDto.getBNPLInstallments()) == null)) {
            for (BNPLInstallmentRemoteDto parseFromNullable : bNPLInstallments) {
                arrayList.add(ModelMappingIntegrationKt.parseFromNullable(new InstallmentDetail(), parseFromNullable));
            }
        }
        BNPLInstallments bNPLInstallments2 = new BNPLInstallments();
        bNPLInstallments2.setInstallments(arrayList);
        return bNPLInstallments2;
    }

    @NotNull
    public final BNPLOrderPaymentStatus mapToBNPLOrderPaymentStatus(@Nullable BNPLOrderPaymentRemoteDto bNPLOrderPaymentRemoteDto) {
        BNPLOrderPaymentRemoteResultDto bNPLOrderPaymentRemoteResultDto;
        Integer paymentStatus;
        if (bNPLOrderPaymentRemoteDto == null || (bNPLOrderPaymentRemoteResultDto = bNPLOrderPaymentRemoteDto.getBNPLOrderPaymentRemoteResultDto()) == null || (paymentStatus = bNPLOrderPaymentRemoteResultDto.getPaymentStatus()) == null) {
            return new BNPLOrderPaymentStatus(false, (BNPLOrderPaymentError) null, true, 3, (DefaultConstructorMarker) null);
        }
        int intValue = paymentStatus.intValue();
        BNPLPaymentStatus.Companion companion = BNPLPaymentStatus.Companion;
        if (companion.getBNPLPaymentStatus(Integer.valueOf(intValue)) == BNPLPaymentStatus.SUCCESS) {
            return new BNPLOrderPaymentStatus(true, (BNPLOrderPaymentError) null, false, 6, (DefaultConstructorMarker) null);
        }
        if (companion.getBNPLPaymentStatus(Integer.valueOf(intValue)) == BNPLPaymentStatus.FAILURE) {
            return new BNPLOrderPaymentStatus(false, (BNPLOrderPaymentError) ModelMappingIntegrationKt.parseFromNullable(new BNPLOrderPaymentError((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null), bNPLOrderPaymentRemoteDto.getBNPLOrderPaymentRemoteResultDto().getBNPLOrderPaymentErrorRemoteDto()), false, 4, (DefaultConstructorMarker) null);
        }
        return new BNPLOrderPaymentStatus(false, (BNPLOrderPaymentError) null, true, 3, (DefaultConstructorMarker) null);
    }

    @NotNull
    public final List<BNPLPlan> mapToBNPLPlans(@Nullable BNPLPlansRemoteDto bNPLPlansRemoteDto) {
        BNPLPlansRemoteResultDto bNPLPlansRemoteResultDto;
        List<BNPLPlanRemoteDto> bNPLPlans;
        ArrayList arrayList = new ArrayList();
        if (!(bNPLPlansRemoteDto == null || (bNPLPlansRemoteResultDto = bNPLPlansRemoteDto.getBNPLPlansRemoteResultDto()) == null || (bNPLPlans = bNPLPlansRemoteResultDto.getBNPLPlans()) == null)) {
            for (BNPLPlanRemoteDto parseFromNullable : bNPLPlans) {
                arrayList.add(ModelMappingIntegrationKt.parseFromNullable(new BNPLPlan((String) null, (String) null, (String) null, (String) null, 0, 0, 0, 127, (DefaultConstructorMarker) null), parseFromNullable));
            }
        }
        return arrayList;
    }
}
