package com.talabat.location.domain.exception;

import android.app.Activity;
import android.app.PendingIntent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/talabat/location/domain/exception/ResolvableApiException;", "Lcom/talabat/location/domain/exception/ApiException;", "()V", "resolution", "Landroid/app/PendingIntent;", "getResolution", "()Landroid/app/PendingIntent;", "startResolutionForResult", "", "activity", "Landroid/app/Activity;", "requestCheckSettings", "", "com_talabat_core_location_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class ResolvableApiException extends ApiException {
    @NotNull
    public abstract PendingIntent getResolution();

    public abstract void startResolutionForResult(@NotNull Activity activity, int i11);
}
