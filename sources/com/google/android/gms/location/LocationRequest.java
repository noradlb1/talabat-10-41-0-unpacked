package com.google.android.gms.location;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.WorkSource;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import com.facebook.AuthenticationTokenClaims;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.WorkSourceUtil;
import com.google.android.gms.internal.location.zzd;
import com.google.android.gms.internal.location.zzdj;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.commons.lang3.time.DateUtils;
import org.checkerframework.dataflow.qual.Pure;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

@SafeParcelable.Class(creator = "LocationRequestCreator")
@SafeParcelable.Reserved({4, 5, 1000})
public final class LocationRequest extends AbstractSafeParcelable implements ReflectedParcelable {
    @NonNull
    public static final Parcelable.Creator<LocationRequest> CREATOR = new zzx();
    @Deprecated
    public static final int PRIORITY_BALANCED_POWER_ACCURACY = 102;
    @Deprecated
    public static final int PRIORITY_HIGH_ACCURACY = 100;
    @Deprecated
    public static final int PRIORITY_LOW_POWER = 104;
    @Deprecated
    public static final int PRIORITY_NO_POWER = 105;
    @SafeParcelable.Field(defaultValueUnchecked = "Priority.PRIORITY_BALANCED_POWER_ACCURACY", getter = "getPriority", id = 1)
    private int zza;
    @SafeParcelable.Field(defaultValue = "3600000", getter = "getIntervalMillis", id = 2)
    private long zzb;
    @SafeParcelable.Field(defaultValue = "600000", getter = "getMinUpdateIntervalMillis", id = 3)
    private long zzc;
    @SafeParcelable.Field(defaultValue = "0", getter = "getMaxUpdateDelayMillis", id = 8)
    private long zzd;
    @SafeParcelable.Field(defaultValueUnchecked = "Long.MAX_VALUE", getter = "getDurationMillis", id = 10)
    private long zze;
    @SafeParcelable.Field(defaultValueUnchecked = "Integer.MAX_VALUE", getter = "getMaxUpdates", id = 6)
    private int zzf;
    @SafeParcelable.Field(defaultValue = "0", getter = "getMinUpdateDistanceMeters", id = 7)
    private float zzg;
    @SafeParcelable.Field(defaultValue = "false", getter = "isWaitForAccurateLocation", id = 9)
    private boolean zzh;
    @SafeParcelable.Field(defaultValueUnchecked = "-1", getter = "getMaxUpdateAgeMillis", id = 11)
    private long zzi;
    @SafeParcelable.Field(defaultValueUnchecked = "Granularity.GRANULARITY_PERMISSION_LEVEL", getter = "getGranularity", id = 12)
    private final int zzj;
    @SafeParcelable.Field(defaultValueUnchecked = "ThrottleBehavior.THROTTLE_BACKGROUND", getter = "getThrottleBehavior", id = 13)
    private final int zzk;
    @SafeParcelable.Field(getter = "getModuleId", id = 14)
    @Nullable
    private final String zzl;
    @SafeParcelable.Field(defaultValue = "false", getter = "isBypass", id = 15)
    private final boolean zzm;
    @SafeParcelable.Field(defaultValueUnchecked = "new android.os.WorkSource()", getter = "getWorkSource", id = 16)
    private final WorkSource zzn;
    @SafeParcelable.Field(getter = "getImpersonation", id = 17)
    @Nullable
    private final zzd zzo;

    /* JADX WARNING: Illegal instructions before constructor call */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public LocationRequest() {
        /*
            r23 = this;
            r0 = r23
            android.os.WorkSource r1 = new android.os.WorkSource
            r21 = r1
            r1.<init>()
            r1 = 102(0x66, float:1.43E-43)
            r2 = 3600000(0x36ee80, double:1.7786363E-317)
            r4 = 600000(0x927c0, double:2.964394E-318)
            r6 = 0
            r8 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r10 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r12 = 2147483647(0x7fffffff, float:NaN)
            r13 = 0
            r14 = 1
            r15 = 3600000(0x36ee80, double:1.7786363E-317)
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r22 = 0
            r0.<init>(r1, r2, r4, r6, r8, r10, r12, r13, r14, r15, r17, r18, r19, r20, r21, r22)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.location.LocationRequest.<init>():void");
    }

    @NonNull
    @Deprecated
    public static LocationRequest create() {
        WorkSource workSource = r1;
        WorkSource workSource2 = new WorkSource();
        return new LocationRequest(102, DateUtils.MILLIS_PER_HOUR, AuthenticationTokenClaims.MAX_TIME_SINCE_TOKEN_ISSUED, 0, Long.MAX_VALUE, Long.MAX_VALUE, Integer.MAX_VALUE, 0.0f, true, DateUtils.MILLIS_PER_HOUR, 0, 0, (String) null, false, workSource, (zzd) null);
    }

    private static String zzf(long j11) {
        if (j11 == Long.MAX_VALUE) {
            return "∞";
        }
        return zzdj.zza(j11);
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof LocationRequest) {
            LocationRequest locationRequest = (LocationRequest) obj;
            if (this.zza == locationRequest.zza && ((isPassive() || this.zzb == locationRequest.zzb) && this.zzc == locationRequest.zzc && isBatched() == locationRequest.isBatched() && ((!isBatched() || this.zzd == locationRequest.zzd) && this.zze == locationRequest.zze && this.zzf == locationRequest.zzf && this.zzg == locationRequest.zzg && this.zzh == locationRequest.zzh && this.zzj == locationRequest.zzj && this.zzk == locationRequest.zzk && this.zzm == locationRequest.zzm && this.zzn.equals(locationRequest.zzn) && Objects.equal(this.zzl, locationRequest.zzl) && Objects.equal(this.zzo, locationRequest.zzo)))) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Pure
    public long getDurationMillis() {
        return this.zze;
    }

    @Deprecated
    @Pure
    public long getExpirationTime() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j11 = this.zze;
        long j12 = elapsedRealtime + j11;
        if (((elapsedRealtime ^ j12) & (j11 ^ j12)) < 0) {
            return Long.MAX_VALUE;
        }
        return j12;
    }

    @Deprecated
    @Pure
    public long getFastestInterval() {
        return getMinUpdateIntervalMillis();
    }

    @Pure
    public int getGranularity() {
        return this.zzj;
    }

    @Deprecated
    @Pure
    public long getInterval() {
        return getIntervalMillis();
    }

    @Pure
    public long getIntervalMillis() {
        return this.zzb;
    }

    @Pure
    public long getMaxUpdateAgeMillis() {
        return this.zzi;
    }

    @Pure
    public long getMaxUpdateDelayMillis() {
        return this.zzd;
    }

    @Pure
    public int getMaxUpdates() {
        return this.zzf;
    }

    @Deprecated
    @Pure
    public long getMaxWaitTime() {
        return Math.max(this.zzd, this.zzb);
    }

    @Pure
    public float getMinUpdateDistanceMeters() {
        return this.zzg;
    }

    @Pure
    public long getMinUpdateIntervalMillis() {
        return this.zzc;
    }

    @Deprecated
    @Pure
    public int getNumUpdates() {
        return getMaxUpdates();
    }

    @Pure
    public int getPriority() {
        return this.zza;
    }

    @Deprecated
    @Pure
    public float getSmallestDisplacement() {
        return getMinUpdateDistanceMeters();
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza), Long.valueOf(this.zzb), Long.valueOf(this.zzc), this.zzn);
    }

    @Pure
    public boolean isBatched() {
        long j11 = this.zzd;
        return j11 > 0 && (j11 >> 1) >= this.zzb;
    }

    @Deprecated
    @Pure
    public boolean isFastestIntervalExplicitlySet() {
        return true;
    }

    @Pure
    public boolean isPassive() {
        return this.zza == 105;
    }

    public boolean isWaitForAccurateLocation() {
        return this.zzh;
    }

    @NonNull
    @Deprecated
    public LocationRequest setExpirationDuration(long j11) {
        boolean z11;
        if (j11 > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11, "durationMillis must be greater than 0");
        this.zze = j11;
        return this;
    }

    @NonNull
    @Deprecated
    public LocationRequest setExpirationTime(long j11) {
        this.zze = Math.max(1, j11 - SystemClock.elapsedRealtime());
        return this;
    }

    @NonNull
    @Deprecated
    public LocationRequest setFastestInterval(long j11) {
        boolean z11;
        if (j11 >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11, "illegal fastest interval: %d", Long.valueOf(j11));
        this.zzc = j11;
        return this;
    }

    @NonNull
    @Deprecated
    public LocationRequest setInterval(long j11) {
        boolean z11;
        if (j11 >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11, "intervalMillis must be greater than or equal to 0");
        long j12 = this.zzc;
        long j13 = this.zzb;
        if (j12 == j13 / 6) {
            this.zzc = j11 / 6;
        }
        if (this.zzi == j13) {
            this.zzi = j11;
        }
        this.zzb = j11;
        return this;
    }

    @NonNull
    @Deprecated
    public LocationRequest setMaxWaitTime(long j11) {
        boolean z11;
        if (j11 >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11, "illegal max wait time: %d", Long.valueOf(j11));
        this.zzd = j11;
        return this;
    }

    @NonNull
    @Deprecated
    public LocationRequest setNumUpdates(int i11) {
        if (i11 > 0) {
            this.zzf = i11;
            return this;
        }
        throw new IllegalArgumentException("invalid numUpdates: " + i11);
    }

    @NonNull
    @Deprecated
    public LocationRequest setPriority(int i11) {
        zzae.zza(i11);
        this.zza = i11;
        return this;
    }

    @NonNull
    @Deprecated
    public LocationRequest setSmallestDisplacement(float f11) {
        if (f11 >= 0.0f) {
            this.zzg = f11;
            return this;
        }
        throw new IllegalArgumentException("invalid displacement: " + f11);
    }

    @NonNull
    @Deprecated
    public LocationRequest setWaitForAccurateLocation(boolean z11) {
        this.zzh = z11;
        return this;
    }

    @NonNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Request[");
        if (isPassive()) {
            sb2.append(zzae.zzb(this.zza));
        } else {
            sb2.append("@");
            if (isBatched()) {
                zzdj.zzb(this.zzb, sb2);
                sb2.append("/");
                zzdj.zzb(this.zzd, sb2);
            } else {
                zzdj.zzb(this.zzb, sb2);
            }
            sb2.append(" ");
            sb2.append(zzae.zzb(this.zza));
        }
        if (isPassive() || this.zzc != this.zzb) {
            sb2.append(", minUpdateInterval=");
            sb2.append(zzf(this.zzc));
        }
        if (((double) this.zzg) > 0.0d) {
            sb2.append(", minUpdateDistance=");
            sb2.append(this.zzg);
        }
        if (!isPassive() ? this.zzi != this.zzb : this.zzi != Long.MAX_VALUE) {
            sb2.append(", maxUpdateAge=");
            sb2.append(zzf(this.zzi));
        }
        if (this.zze != Long.MAX_VALUE) {
            sb2.append(", duration=");
            zzdj.zzb(this.zze, sb2);
        }
        if (this.zzf != Integer.MAX_VALUE) {
            sb2.append(", maxUpdates=");
            sb2.append(this.zzf);
        }
        if (this.zzk != 0) {
            sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
            sb2.append(zzai.zza(this.zzk));
        }
        if (this.zzj != 0) {
            sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
            sb2.append(zzo.zzb(this.zzj));
        }
        if (this.zzh) {
            sb2.append(", waitForAccurateLocation");
        }
        if (this.zzm) {
            sb2.append(", bypass");
        }
        if (this.zzl != null) {
            sb2.append(", moduleId=");
            sb2.append(this.zzl);
        }
        if (!WorkSourceUtil.isEmpty(this.zzn)) {
            sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
            sb2.append(this.zzn);
        }
        if (this.zzo != null) {
            sb2.append(", impersonation=");
            sb2.append(this.zzo);
        }
        sb2.append(AbstractJsonLexerKt.END_LIST);
        return sb2.toString();
    }

    public void writeToParcel(@NonNull Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, getPriority());
        SafeParcelWriter.writeLong(parcel, 2, getIntervalMillis());
        SafeParcelWriter.writeLong(parcel, 3, getMinUpdateIntervalMillis());
        SafeParcelWriter.writeInt(parcel, 6, getMaxUpdates());
        SafeParcelWriter.writeFloat(parcel, 7, getMinUpdateDistanceMeters());
        SafeParcelWriter.writeLong(parcel, 8, getMaxUpdateDelayMillis());
        SafeParcelWriter.writeBoolean(parcel, 9, isWaitForAccurateLocation());
        SafeParcelWriter.writeLong(parcel, 10, getDurationMillis());
        SafeParcelWriter.writeLong(parcel, 11, getMaxUpdateAgeMillis());
        SafeParcelWriter.writeInt(parcel, 12, getGranularity());
        SafeParcelWriter.writeInt(parcel, 13, this.zzk);
        SafeParcelWriter.writeString(parcel, 14, this.zzl, false);
        SafeParcelWriter.writeBoolean(parcel, 15, this.zzm);
        SafeParcelWriter.writeParcelable(parcel, 16, this.zzn, i11, false);
        SafeParcelWriter.writeParcelable(parcel, 17, this.zzo, i11, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Pure
    public final int zza() {
        return this.zzk;
    }

    @NonNull
    @Pure
    public final WorkSource zzb() {
        return this.zzn;
    }

    @Nullable
    @Pure
    public final zzd zzc() {
        return this.zzo;
    }

    @Deprecated
    @Nullable
    @Pure
    public final String zzd() {
        return this.zzl;
    }

    @Pure
    public final boolean zze() {
        return this.zzm;
    }

    public static final class Builder {
        public static final long IMPLICIT_MAX_UPDATE_AGE = -1;
        public static final long IMPLICIT_MIN_UPDATE_INTERVAL = -1;
        private int zza;
        private long zzb;
        private long zzc;
        private long zzd;
        private long zze;
        private int zzf;
        private float zzg;
        private boolean zzh;
        private long zzi;
        private int zzj;
        private int zzk;
        @Nullable
        private String zzl;
        private boolean zzm;
        @Nullable
        private WorkSource zzn;
        @Nullable
        private zzd zzo;

        public Builder(int i11, long j11) {
            Preconditions.checkArgument(j11 >= 0, "intervalMillis must be greater than or equal to 0");
            zzae.zza(i11);
            this.zza = i11;
            this.zzb = j11;
            this.zzc = -1;
            this.zzd = 0;
            this.zze = Long.MAX_VALUE;
            this.zzf = Integer.MAX_VALUE;
            this.zzg = 0.0f;
            this.zzh = true;
            this.zzi = -1;
            this.zzj = 0;
            this.zzk = 0;
            this.zzl = null;
            this.zzm = false;
            this.zzn = null;
            this.zzo = null;
        }

        @NonNull
        public LocationRequest build() {
            long j11;
            int i11 = this.zza;
            long j12 = this.zzb;
            long j13 = this.zzc;
            if (j13 == -1) {
                j13 = j12;
            } else if (i11 != 105) {
                j13 = Math.min(j13, j12);
            }
            long max = Math.max(this.zzd, this.zzb);
            long j14 = this.zze;
            int i12 = this.zzf;
            float f11 = this.zzg;
            boolean z11 = this.zzh;
            long j15 = this.zzi;
            if (j15 == -1) {
                j11 = this.zzb;
            } else {
                j11 = j15;
            }
            int i13 = this.zzj;
            int i14 = this.zzk;
            String str = this.zzl;
            boolean z12 = this.zzm;
            WorkSource workSource = r7;
            WorkSource workSource2 = new WorkSource(this.zzn);
            return new LocationRequest(i11, j12, j13, max, Long.MAX_VALUE, j14, i12, f11, z11, j11, i13, i14, str, z12, workSource, this.zzo);
        }

        @NonNull
        public Builder setDurationMillis(long j11) {
            boolean z11;
            if (j11 > 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            Preconditions.checkArgument(z11, "durationMillis must be greater than 0");
            this.zze = j11;
            return this;
        }

        @NonNull
        public Builder setGranularity(int i11) {
            zzo.zza(i11);
            this.zzj = i11;
            return this;
        }

        @NonNull
        public Builder setIntervalMillis(long j11) {
            boolean z11;
            if (j11 >= 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            Preconditions.checkArgument(z11, "intervalMillis must be greater than or equal to 0");
            this.zzb = j11;
            return this;
        }

        @NonNull
        public Builder setMaxUpdateAgeMillis(long j11) {
            boolean z11 = true;
            if (j11 != -1 && j11 < 0) {
                z11 = false;
            }
            Preconditions.checkArgument(z11, "maxUpdateAgeMillis must be greater than or equal to 0, or IMPLICIT_MAX_UPDATE_AGE");
            this.zzi = j11;
            return this;
        }

        @NonNull
        public Builder setMaxUpdateDelayMillis(long j11) {
            boolean z11;
            if (j11 >= 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            Preconditions.checkArgument(z11, "maxUpdateDelayMillis must be greater than or equal to 0");
            this.zzd = j11;
            return this;
        }

        @NonNull
        public Builder setMaxUpdates(int i11) {
            boolean z11;
            if (i11 > 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            Preconditions.checkArgument(z11, "maxUpdates must be greater than 0");
            this.zzf = i11;
            return this;
        }

        @NonNull
        public Builder setMinUpdateDistanceMeters(float f11) {
            boolean z11;
            if (f11 >= 0.0f) {
                z11 = true;
            } else {
                z11 = false;
            }
            Preconditions.checkArgument(z11, "minUpdateDistanceMeters must be greater than or equal to 0");
            this.zzg = f11;
            return this;
        }

        @NonNull
        public Builder setMinUpdateIntervalMillis(long j11) {
            boolean z11 = true;
            if (j11 != -1 && j11 < 0) {
                z11 = false;
            }
            Preconditions.checkArgument(z11, "minUpdateIntervalMillis must be greater than or equal to 0, or IMPLICIT_MIN_UPDATE_INTERVAL");
            this.zzc = j11;
            return this;
        }

        @NonNull
        public Builder setPriority(int i11) {
            zzae.zza(i11);
            this.zza = i11;
            return this;
        }

        @NonNull
        public Builder setWaitForAccurateLocation(boolean z11) {
            this.zzh = z11;
            return this;
        }

        @RequiresPermission(anyOf = {"android.permission.WRITE_SECURE_SETTINGS", "android.permission.LOCATION_BYPASS"})
        @NonNull
        public final Builder zza(boolean z11) {
            this.zzm = z11;
            return this;
        }

        @NonNull
        @Deprecated
        public final Builder zzb(@Nullable String str) {
            if (Build.VERSION.SDK_INT < 30) {
                this.zzl = str;
            }
            return this;
        }

        @NonNull
        public final Builder zzc(int i11) {
            boolean z11;
            int i12;
            if (i11 == 0 || i11 == 1) {
                i12 = i11;
                z11 = true;
            } else {
                i12 = 2;
                if (i11 == 2) {
                    z11 = true;
                    i11 = 2;
                } else {
                    i12 = i11;
                    z11 = false;
                }
            }
            Preconditions.checkArgument(z11, "throttle behavior %d must be a ThrottleBehavior.THROTTLE_* constant", Integer.valueOf(i11));
            this.zzk = i12;
            return this;
        }

        @RequiresPermission("android.permission.UPDATE_DEVICE_STATS")
        @NonNull
        public final Builder zzd(@Nullable WorkSource workSource) {
            this.zzn = workSource;
            return this;
        }

        public Builder(long j11) {
            Preconditions.checkArgument(j11 >= 0, "intervalMillis must be greater than or equal to 0");
            this.zzb = j11;
            this.zza = 102;
            this.zzc = -1;
            this.zzd = 0;
            this.zze = Long.MAX_VALUE;
            this.zzf = Integer.MAX_VALUE;
            this.zzg = 0.0f;
            this.zzh = true;
            this.zzi = -1;
            this.zzj = 0;
            this.zzk = 0;
            this.zzl = null;
            this.zzm = false;
            this.zzn = null;
            this.zzo = null;
        }

        public Builder(@NonNull LocationRequest locationRequest) {
            this.zza = locationRequest.getPriority();
            this.zzb = locationRequest.getIntervalMillis();
            this.zzc = locationRequest.getMinUpdateIntervalMillis();
            this.zzd = locationRequest.getMaxUpdateDelayMillis();
            this.zze = locationRequest.getDurationMillis();
            this.zzf = locationRequest.getMaxUpdates();
            this.zzg = locationRequest.getMinUpdateDistanceMeters();
            this.zzh = locationRequest.isWaitForAccurateLocation();
            this.zzi = locationRequest.getMaxUpdateAgeMillis();
            this.zzj = locationRequest.getGranularity();
            this.zzk = locationRequest.zza();
            this.zzl = locationRequest.zzd();
            this.zzm = locationRequest.zze();
            this.zzn = locationRequest.zzb();
            this.zzo = locationRequest.zzc();
        }
    }

    @SafeParcelable.Constructor
    public LocationRequest(@SafeParcelable.Param(id = 1) int i11, @SafeParcelable.Param(id = 2) long j11, @SafeParcelable.Param(id = 3) long j12, @SafeParcelable.Param(id = 8) long j13, @SafeParcelable.RemovedParam(defaultValueUnchecked = "Long.MAX_VALUE", id = 5) long j14, @SafeParcelable.Param(id = 10) long j15, @SafeParcelable.Param(id = 6) int i12, @SafeParcelable.Param(id = 7) float f11, @SafeParcelable.Param(id = 9) boolean z11, @SafeParcelable.Param(id = 11) long j16, @SafeParcelable.Param(id = 12) int i13, @SafeParcelable.Param(id = 13) int i14, @SafeParcelable.Param(id = 14) @Nullable String str, @SafeParcelable.Param(id = 15) boolean z12, @SafeParcelable.Param(id = 16) WorkSource workSource, @SafeParcelable.Param(id = 17) @Nullable zzd zzd2) {
        long j17;
        this.zza = i11;
        long j18 = j11;
        this.zzb = j18;
        this.zzc = j12;
        this.zzd = j13;
        if (j14 == Long.MAX_VALUE) {
            j17 = j15;
        } else {
            j17 = Math.min(Math.max(1, j14 - SystemClock.elapsedRealtime()), j15);
        }
        this.zze = j17;
        this.zzf = i12;
        this.zzg = f11;
        this.zzh = z11;
        this.zzi = j16 != -1 ? j16 : j18;
        this.zzj = i13;
        this.zzk = i14;
        this.zzl = str;
        this.zzm = z12;
        this.zzn = workSource;
        this.zzo = zzd2;
    }
}
