package com.talabat.core.hms.location.data.exceptions;

import android.app.Activity;
import android.app.PendingIntent;
import com.talabat.location.domain.exception.ResolvableApiException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/talabat/core/hms/location/data/exceptions/HmsResolvableApiException;", "Lcom/talabat/location/domain/exception/ResolvableApiException;", "statusCode", "", "huaweiResolvableApiException", "Lcom/huawei/hms/common/ResolvableApiException;", "(ILcom/huawei/hms/common/ResolvableApiException;)V", "resolution", "Landroid/app/PendingIntent;", "getResolution", "()Landroid/app/PendingIntent;", "getStatusCode", "()I", "startResolutionForResult", "", "activity", "Landroid/app/Activity;", "requestCheckSettings", "com_talabat_core_hms_location_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HmsResolvableApiException extends ResolvableApiException {
    @NotNull
    private final com.huawei.hms.common.ResolvableApiException huaweiResolvableApiException;
    @NotNull
    private final PendingIntent resolution;
    private final int statusCode;

    public HmsResolvableApiException(int i11, @NotNull com.huawei.hms.common.ResolvableApiException resolvableApiException) {
        Intrinsics.checkNotNullParameter(resolvableApiException, "huaweiResolvableApiException");
        this.statusCode = i11;
        this.huaweiResolvableApiException = resolvableApiException;
        PendingIntent resolution2 = resolvableApiException.getResolution();
        Intrinsics.checkNotNullExpressionValue(resolution2, "huaweiResolvableApiException.resolution");
        this.resolution = resolution2;
    }

    @NotNull
    public PendingIntent getResolution() {
        return this.resolution;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public void startResolutionForResult(@NotNull Activity activity, int i11) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.huaweiResolvableApiException.startResolutionForResult(activity, i11);
    }
}
