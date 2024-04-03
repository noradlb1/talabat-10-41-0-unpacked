package com.talabat.offering.presentation.viewmodel.mapper;

import com.talabat.offering.domain.entities.OTPData;
import com.talabat.offering.presentation.displaymodel.OTPDisplayModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\n"}, d2 = {"Lcom/talabat/offering/presentation/viewmodel/mapper/SendOTPDisplayModelMapper;", "", "()V", "mapOTPDisplayData", "Lcom/talabat/offering/presentation/displaymodel/OTPDisplayModel;", "otpData", "Lcom/talabat/offering/domain/entities/OTPData;", "mobileNumber", "", "mapOTPVerificationDisplayData", "com_talabat_NewArchi_Offering_Offering"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SendOTPDisplayModelMapper {
    @NotNull
    public static final SendOTPDisplayModelMapper INSTANCE = new SendOTPDisplayModelMapper();

    private SendOTPDisplayModelMapper() {
    }

    @NotNull
    public final OTPDisplayModel mapOTPDisplayData(@NotNull OTPData oTPData, @NotNull String str) {
        Intrinsics.checkNotNullParameter(oTPData, "otpData");
        Intrinsics.checkNotNullParameter(str, "mobileNumber");
        if (Intrinsics.areEqual((Object) oTPData.isSuccess(), (Object) Boolean.TRUE)) {
            return new OTPDisplayModel.OTPData(oTPData.getRequestId(), oTPData.getDuration(), oTPData.getOtpLength(), str);
        }
        return new OTPDisplayModel.OTPFailData(oTPData.getErrorsMsg());
    }

    @NotNull
    public final OTPDisplayModel mapOTPVerificationDisplayData(@NotNull OTPData oTPData) {
        Intrinsics.checkNotNullParameter(oTPData, "otpData");
        if (Intrinsics.areEqual((Object) oTPData.isSuccess(), (Object) Boolean.TRUE)) {
            return new OTPDisplayModel.OTPVerified();
        }
        return new OTPDisplayModel.OTPFailData(oTPData.getErrorsMsg());
    }
}
