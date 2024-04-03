package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.gms.common.R;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.StringResourceValueReader;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import javax.annotation.concurrent.GuardedBy;

@KeepForSdk
@Deprecated
public final class GoogleServices {
    private static final Object zza = new Object();
    @GuardedBy("lock")
    @Nullable
    private static GoogleServices zzb;
    @Nullable
    private final String zzc;
    private final Status zzd;
    private final boolean zze;
    private final boolean zzf;

    @KeepForSdk
    @VisibleForTesting
    public GoogleServices(Context context) {
        boolean z11;
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("google_app_measurement_enable", TypedValues.Custom.S_INT, resources.getResourcePackageName(R.string.common_google_play_services_unknown_issue));
        boolean z12 = true;
        if (identifier != 0) {
            int integer = resources.getInteger(identifier);
            if (integer != 0) {
                z11 = false;
            } else {
                z11 = true;
            }
            z12 = integer == 0 ? false : z12;
            this.zzf = z11;
        } else {
            this.zzf = false;
        }
        this.zze = z12;
        String zzb2 = zzah.zzb(context);
        zzb2 = zzb2 == null ? new StringResourceValueReader(context).getString("google_app_id") : zzb2;
        if (TextUtils.isEmpty(zzb2)) {
            this.zzd = new Status(10, "Missing google app id value from from string resources with name google_app_id.");
            this.zzc = null;
            return;
        }
        this.zzc = zzb2;
        this.zzd = Status.RESULT_SUCCESS;
    }

    @KeepForSdk
    @VisibleForTesting
    public GoogleServices(String str, boolean z11) {
        this.zzc = str;
        this.zzd = Status.RESULT_SUCCESS;
        this.zze = z11;
        this.zzf = !z11;
    }

    @KeepForSdk
    private static GoogleServices checkInitialized(String str) {
        GoogleServices googleServices;
        synchronized (zza) {
            googleServices = zzb;
            if (googleServices == null) {
                throw new IllegalStateException("Initialize must be called before " + str + RealDiscoveryConfigurationRepository.VERSION_DELIMETER);
            }
        }
        return googleServices;
    }

    @KeepForSdk
    @VisibleForTesting
    public static void clearInstanceForTest() {
        synchronized (zza) {
            zzb = null;
        }
    }

    @KeepForSdk
    @Nullable
    public static String getGoogleAppId() {
        return checkInitialized("getGoogleAppId").zzc;
    }

    @NonNull
    @KeepForSdk
    public static Status initialize(@NonNull Context context) {
        Status status;
        Preconditions.checkNotNull(context, "Context must not be null.");
        synchronized (zza) {
            if (zzb == null) {
                zzb = new GoogleServices(context);
            }
            status = zzb.zzd;
        }
        return status;
    }

    @KeepForSdk
    public static boolean isMeasurementEnabled() {
        GoogleServices checkInitialized = checkInitialized("isMeasurementEnabled");
        if (!checkInitialized.zzd.isSuccess() || !checkInitialized.zze) {
            return false;
        }
        return true;
    }

    @KeepForSdk
    public static boolean isMeasurementExplicitlyDisabled() {
        return checkInitialized("isMeasurementExplicitlyDisabled").zzf;
    }

    @KeepForSdk
    @VisibleForTesting
    public Status checkGoogleAppId(String str) {
        String str2 = this.zzc;
        if (str2 == null || str2.equals(str)) {
            return Status.RESULT_SUCCESS;
        }
        String str3 = this.zzc;
        return new Status(10, "Initialize was called with two different Google App IDs.  Only the first app ID will be used: '" + str3 + "'.");
    }

    @ResultIgnorabilityUnspecified
    @NonNull
    @KeepForSdk
    public static Status initialize(@NonNull Context context, @NonNull String str, boolean z11) {
        Preconditions.checkNotNull(context, "Context must not be null.");
        Preconditions.checkNotEmpty(str, "App ID must be nonempty.");
        synchronized (zza) {
            GoogleServices googleServices = zzb;
            if (googleServices != null) {
                Status checkGoogleAppId = googleServices.checkGoogleAppId(str);
                return checkGoogleAppId;
            }
            GoogleServices googleServices2 = new GoogleServices(str, z11);
            zzb = googleServices2;
            Status status = googleServices2.zzd;
            return status;
        }
    }
}
