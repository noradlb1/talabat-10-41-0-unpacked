package com.talabat.userandlocation.otp.data.impl;

import com.talabat.application.device.id.domain.DeviceIdProvider;
import com.talabat.observability.ObservabilityManager;
import com.talabat.userandlocation.otp.data.remote.RequestOtpRemoteDataSource;
import com.talabat.userandlocation.otp.data.remote.dto.RequestOtpDto;
import com.talabat.userandlocation.otp.domain.repo.RequestOtpRepository;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kx.a;
import kx.b;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/talabat/userandlocation/otp/data/impl/RequestOtpRepositoryImpl;", "Lcom/talabat/userandlocation/otp/domain/repo/RequestOtpRepository;", "requestOtpRemoteDataSource", "Lcom/talabat/userandlocation/otp/data/remote/RequestOtpRemoteDataSource;", "deviceIdProvider", "Lcom/talabat/application/device/id/domain/DeviceIdProvider;", "(Lcom/talabat/userandlocation/otp/data/remote/RequestOtpRemoteDataSource;Lcom/talabat/application/device/id/domain/DeviceIdProvider;)V", "requestOtp", "Lio/reactivex/Single;", "Lcom/talabat/userandlocation/otp/domain/repo/RequestOtpRepository$RequestOtpResult;", "countryCode", "", "mobileNumber", "", "trackError", "", "it", "", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RequestOtpRepositoryImpl implements RequestOtpRepository {
    @NotNull
    private final DeviceIdProvider deviceIdProvider;
    @NotNull
    private final RequestOtpRemoteDataSource requestOtpRemoteDataSource;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RequestOtpDto.Status.values().length];
            iArr[RequestOtpDto.Status.PASS.ordinal()] = 1;
            iArr[RequestOtpDto.Status.FAILED_TO_INSERT_OTP.ordinal()] = 2;
            iArr[RequestOtpDto.Status.PHONE_VALIDATION_ERROR.ordinal()] = 3;
            iArr[RequestOtpDto.Status.ERROR_MAX_RETRY.ordinal()] = 4;
            iArr[RequestOtpDto.Status.NULL_STATUS.ordinal()] = 5;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public RequestOtpRepositoryImpl(@NotNull RequestOtpRemoteDataSource requestOtpRemoteDataSource2, @NotNull DeviceIdProvider deviceIdProvider2) {
        Intrinsics.checkNotNullParameter(requestOtpRemoteDataSource2, "requestOtpRemoteDataSource");
        Intrinsics.checkNotNullParameter(deviceIdProvider2, "deviceIdProvider");
        this.requestOtpRemoteDataSource = requestOtpRemoteDataSource2;
        this.deviceIdProvider = deviceIdProvider2;
    }

    /* access modifiers changed from: private */
    /* renamed from: requestOtp$lambda-0  reason: not valid java name */
    public static final void m5934requestOtp$lambda0(RequestOtpRepositoryImpl requestOtpRepositoryImpl, Throwable th2) {
        Intrinsics.checkNotNullParameter(requestOtpRepositoryImpl, "this$0");
        Intrinsics.checkNotNullExpressionValue(th2, "it");
        requestOtpRepositoryImpl.trackError(th2);
    }

    /* access modifiers changed from: private */
    /* renamed from: requestOtp$lambda-1  reason: not valid java name */
    public static final RequestOtpRepository.RequestOtpResult m5935requestOtp$lambda1(RequestOtpDto requestOtpDto) {
        RequestOtpRepository.RequestOtpResult requestOtpResult;
        Intrinsics.checkNotNullParameter(requestOtpDto, "it");
        int i11 = WhenMappings.$EnumSwitchMapping$0[requestOtpDto.getStatus().ordinal()];
        if (i11 == 1) {
            requestOtpResult = new RequestOtpRepository.RequestOtpResult.Success(requestOtpDto.getMessage(), requestOtpDto.getRemainingRequests());
        } else if (i11 == 2) {
            requestOtpResult = new RequestOtpRepository.RequestOtpResult.FailedToRequestOtp(requestOtpDto.getMessage());
        } else if (i11 == 3) {
            requestOtpResult = new RequestOtpRepository.RequestOtpResult.MobileNumberValidationError(requestOtpDto.getMessage());
        } else if (i11 == 4) {
            requestOtpResult = new RequestOtpRepository.RequestOtpResult.MaxRequestsReached(requestOtpDto.getMessage());
        } else if (i11 == 5) {
            return RequestOtpRepository.RequestOtpResult.UnknownResult.INSTANCE;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return requestOtpResult;
    }

    private final void trackError(Throwable th2) {
        String message = th2.getMessage();
        if (message == null) {
            message = "";
        }
        ObservabilityManager.trackUnExpectedScenario("RequestOtpRepositoryError", MapsKt__MapsJVMKt.mapOf(TuplesKt.to("errorMessage", message)));
    }

    @NotNull
    public Single<RequestOtpRepository.RequestOtpResult> requestOtp(int i11, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "mobileNumber");
        Single<R> map = this.requestOtpRemoteDataSource.requestOtp(i11, str, this.deviceIdProvider.getId()).doOnError(new a(this)).map(new b());
        Intrinsics.checkNotNullExpressionValue(map, "requestOtpRemoteDataSour…          }\n            }");
        return map;
    }
}
