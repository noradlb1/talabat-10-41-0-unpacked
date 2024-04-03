package com.talabat.userandlocation.otp.data.remote.impl;

import com.talabat.userandlocation.otp.data.remote.RequestOtpRemoteDataSource;
import com.talabat.userandlocation.otp.data.remote.api.GetOtpResponse;
import com.talabat.userandlocation.otp.data.remote.api.GetOtpResult;
import com.talabat.userandlocation.otp.data.remote.api.OtpApi;
import com.talabat.userandlocation.otp.data.remote.dto.RequestOtpDto;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import lx.a;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J&\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/talabat/userandlocation/otp/data/remote/impl/RequestOtpRemoteDataSourceImpl;", "Lcom/talabat/userandlocation/otp/data/remote/RequestOtpRemoteDataSource;", "otpApi", "Lcom/talabat/userandlocation/otp/data/remote/api/OtpApi;", "(Lcom/talabat/userandlocation/otp/data/remote/api/OtpApi;)V", "requestOtp", "Lio/reactivex/Single;", "Lcom/talabat/userandlocation/otp/data/remote/dto/RequestOtpDto;", "countryCode", "", "mobileNumber", "", "deviceId", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RequestOtpRemoteDataSourceImpl implements RequestOtpRemoteDataSource {
    @NotNull
    private final OtpApi otpApi;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[GetOtpResult.Status.values().length];
            iArr[GetOtpResult.Status.PASS.ordinal()] = 1;
            iArr[GetOtpResult.Status.FAILED_TO_INSERT_OTP.ordinal()] = 2;
            iArr[GetOtpResult.Status.PHONE_VALIDATION_ERROR.ordinal()] = 3;
            iArr[GetOtpResult.Status.ERROR_MAX_RETRY.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public RequestOtpRemoteDataSourceImpl(@NotNull OtpApi otpApi2) {
        Intrinsics.checkNotNullParameter(otpApi2, "otpApi");
        this.otpApi = otpApi2;
    }

    /* access modifiers changed from: private */
    /* renamed from: requestOtp$lambda-0  reason: not valid java name */
    public static final RequestOtpDto m5936requestOtp$lambda0(GetOtpResponse getOtpResponse) {
        int i11;
        GetOtpResult.Status status;
        int i12;
        RequestOtpDto.Status status2;
        String str;
        Integer remainingRequests;
        Intrinsics.checkNotNullParameter(getOtpResponse, "it");
        GetOtpResult result = getOtpResponse.getResult();
        if (result == null || (remainingRequests = result.getRemainingRequests()) == null) {
            i11 = 0;
        } else {
            i11 = remainingRequests.intValue();
        }
        GetOtpResult result2 = getOtpResponse.getResult();
        if (result2 != null) {
            status = result2.getStatus();
        } else {
            status = null;
        }
        if (status == null) {
            i12 = -1;
        } else {
            i12 = WhenMappings.$EnumSwitchMapping$0[status.ordinal()];
        }
        if (i12 == -1) {
            status2 = RequestOtpDto.Status.NULL_STATUS;
        } else if (i12 == 1) {
            status2 = RequestOtpDto.Status.PASS;
        } else if (i12 == 2) {
            status2 = RequestOtpDto.Status.FAILED_TO_INSERT_OTP;
        } else if (i12 == 3) {
            status2 = RequestOtpDto.Status.PHONE_VALIDATION_ERROR;
        } else if (i12 == 4) {
            status2 = RequestOtpDto.Status.ERROR_MAX_RETRY;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        GetOtpResult result3 = getOtpResponse.getResult();
        if (result3 == null || (str = result3.getMessage()) == null) {
            str = "";
        }
        return new RequestOtpDto(i11, status2, str);
    }

    @NotNull
    public Single<RequestOtpDto> requestOtp(int i11, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "mobileNumber");
        Intrinsics.checkNotNullParameter(str2, "deviceId");
        Single<R> map = this.otpApi.getOtp(i11, str, str2).map(new a());
        Intrinsics.checkNotNullExpressionValue(map, "otpApi\n            .getO…          )\n            }");
        return map;
    }
}
