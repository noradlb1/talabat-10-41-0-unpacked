package com.google.android.gms.location;

import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.internal.location.zzdh;

public interface Geofence {
    public static final int GEOFENCE_TRANSITION_DWELL = 4;
    public static final int GEOFENCE_TRANSITION_ENTER = 1;
    public static final int GEOFENCE_TRANSITION_EXIT = 2;
    public static final long NEVER_EXPIRE = -1;

    public static final class Builder {
        private String zza = null;
        @TransitionTypes
        private int zzb = 0;
        private long zzc = Long.MIN_VALUE;
        private short zzd = -1;
        private double zze;
        private double zzf;
        private float zzg;
        private int zzh = 0;
        private int zzi = -1;

        @NonNull
        public Geofence build() {
            if (this.zza != null) {
                int i11 = this.zzb;
                if (i11 == 0) {
                    throw new IllegalArgumentException("Transitions types not set.");
                } else if ((i11 & 4) != 0 && this.zzi < 0) {
                    throw new IllegalArgumentException("Non-negative loitering delay needs to be set when transition types include GEOFENCE_TRANSITION_DWELL.");
                } else if (this.zzc == Long.MIN_VALUE) {
                    throw new IllegalArgumentException("Expiration not set.");
                } else if (this.zzd == -1) {
                    throw new IllegalArgumentException("Geofence region not set.");
                } else if (this.zzh >= 0) {
                    return new zzdh(this.zza, this.zzb, 1, this.zze, this.zzf, this.zzg, this.zzc, this.zzh, this.zzi);
                } else {
                    throw new IllegalArgumentException("Notification responsiveness should be nonnegative.");
                }
            } else {
                throw new IllegalArgumentException("Request ID not set.");
            }
        }

        @NonNull
        public Builder setCircularRegion(@FloatRange(from = -90.0d, to = 90.0d) double d11, @FloatRange(from = -180.0d, to = 180.0d) double d12, @FloatRange(from = 0.0d, fromInclusive = false) float f11) {
            boolean z11;
            boolean z12;
            boolean z13 = false;
            if (d11 < -90.0d || d11 > 90.0d) {
                z11 = false;
            } else {
                z11 = true;
            }
            Preconditions.checkArgument(z11, "Invalid latitude: " + d11);
            if (d12 < -180.0d || d12 > 180.0d) {
                z12 = false;
            } else {
                z12 = true;
            }
            Preconditions.checkArgument(z12, "Invalid longitude: " + d12);
            if (f11 > 0.0f) {
                z13 = true;
            }
            Preconditions.checkArgument(z13, "Invalid radius: " + f11);
            this.zzd = 1;
            this.zze = d11;
            this.zzf = d12;
            this.zzg = f11;
            return this;
        }

        @NonNull
        public Builder setExpirationDuration(long j11) {
            if (j11 < 0) {
                this.zzc = -1;
            } else {
                this.zzc = DefaultClock.getInstance().elapsedRealtime() + j11;
            }
            return this;
        }

        @NonNull
        public Builder setLoiteringDelay(int i11) {
            this.zzi = i11;
            return this;
        }

        @NonNull
        public Builder setNotificationResponsiveness(@IntRange(from = 0) int i11) {
            this.zzh = i11;
            return this;
        }

        @NonNull
        public Builder setRequestId(@NonNull String str) {
            this.zza = (String) Preconditions.checkNotNull(str, "Request ID can't be set to null");
            return this;
        }

        @NonNull
        public Builder setTransitionTypes(@TransitionTypes int i11) {
            this.zzb = i11;
            return this;
        }
    }

    public @interface GeofenceTransition {
    }

    public @interface TransitionTypes {
    }

    long getExpirationTime();

    double getLatitude();

    int getLoiteringDelay();

    double getLongitude();

    int getNotificationResponsiveness();

    float getRadius();

    @NonNull
    String getRequestId();

    @TransitionTypes
    int getTransitionTypes();
}
