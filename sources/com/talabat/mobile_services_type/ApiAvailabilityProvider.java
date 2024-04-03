package com.talabat.mobile_services_type;

import com.google.android.gms.common.GoogleApiAvailability;
import com.huawei.hms.api.HuaweiApiAvailability;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001f\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\b¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/talabat/mobile_services_type/ApiAvailabilityProvider;", "", "()V", "googleApiAvailability", "Lcom/google/android/gms/common/GoogleApiAvailability;", "getGoogleApiAvailability", "()Lcom/google/android/gms/common/GoogleApiAvailability;", "huaweiApiAvailability", "Lcom/huawei/hms/api/HuaweiApiAvailability;", "kotlin.jvm.PlatformType", "getHuaweiApiAvailability$annotations", "getHuaweiApiAvailability", "()Lcom/huawei/hms/api/HuaweiApiAvailability;", "mobile_services_type_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ApiAvailabilityProvider {
    @NotNull
    private final GoogleApiAvailability googleApiAvailability;
    private final HuaweiApiAvailability huaweiApiAvailability = HuaweiApiAvailability.getInstance();

    public ApiAvailabilityProvider() {
        GoogleApiAvailability instance = GoogleApiAvailability.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance()");
        this.googleApiAvailability = instance;
    }

    public static /* synthetic */ void getHuaweiApiAvailability$annotations() {
    }

    @NotNull
    public final GoogleApiAvailability getGoogleApiAvailability() {
        return this.googleApiAvailability;
    }

    public final HuaweiApiAvailability getHuaweiApiAvailability() {
        return this.huaweiApiAvailability;
    }
}
