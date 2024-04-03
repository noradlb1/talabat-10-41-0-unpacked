package androidx.work;

import android.net.Uri;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.room.ColumnInfo;
import j$.time.Duration;
import java.util.concurrent.TimeUnit;

public final class Constraints {
    public static final Constraints NONE = new Builder().build();
    @ColumnInfo(name = "content_uri_triggers")
    private ContentUriTriggers mContentUriTriggers = new ContentUriTriggers();
    @ColumnInfo(name = "required_network_type")
    private NetworkType mRequiredNetworkType = NetworkType.NOT_REQUIRED;
    @ColumnInfo(name = "requires_battery_not_low")
    private boolean mRequiresBatteryNotLow;
    @ColumnInfo(name = "requires_charging")
    private boolean mRequiresCharging;
    @ColumnInfo(name = "requires_device_idle")
    private boolean mRequiresDeviceIdle;
    @ColumnInfo(name = "requires_storage_not_low")
    private boolean mRequiresStorageNotLow;
    @ColumnInfo(name = "trigger_content_update_delay")
    private long mTriggerContentUpdateDelay = -1;
    @ColumnInfo(name = "trigger_max_content_delay")
    private long mTriggerMaxContentDelay = -1;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        public boolean f37980a = false;

        /* renamed from: b  reason: collision with root package name */
        public boolean f37981b = false;

        /* renamed from: c  reason: collision with root package name */
        public NetworkType f37982c = NetworkType.NOT_REQUIRED;

        /* renamed from: d  reason: collision with root package name */
        public boolean f37983d = false;

        /* renamed from: e  reason: collision with root package name */
        public boolean f37984e = false;

        /* renamed from: f  reason: collision with root package name */
        public long f37985f = -1;

        /* renamed from: g  reason: collision with root package name */
        public long f37986g = -1;

        /* renamed from: h  reason: collision with root package name */
        public ContentUriTriggers f37987h = new ContentUriTriggers();

        public Builder() {
        }

        @RequiresApi(24)
        @NonNull
        public Builder addContentUriTrigger(@NonNull Uri uri, boolean z11) {
            this.f37987h.add(uri, z11);
            return this;
        }

        @NonNull
        public Constraints build() {
            return new Constraints(this);
        }

        @NonNull
        public Builder setRequiredNetworkType(@NonNull NetworkType networkType) {
            this.f37982c = networkType;
            return this;
        }

        @NonNull
        public Builder setRequiresBatteryNotLow(boolean z11) {
            this.f37983d = z11;
            return this;
        }

        @NonNull
        public Builder setRequiresCharging(boolean z11) {
            this.f37980a = z11;
            return this;
        }

        @RequiresApi(23)
        @NonNull
        public Builder setRequiresDeviceIdle(boolean z11) {
            this.f37981b = z11;
            return this;
        }

        @NonNull
        public Builder setRequiresStorageNotLow(boolean z11) {
            this.f37984e = z11;
            return this;
        }

        @RequiresApi(24)
        @NonNull
        public Builder setTriggerContentMaxDelay(long j11, @NonNull TimeUnit timeUnit) {
            this.f37986g = timeUnit.toMillis(j11);
            return this;
        }

        @RequiresApi(24)
        @NonNull
        public Builder setTriggerContentUpdateDelay(long j11, @NonNull TimeUnit timeUnit) {
            this.f37985f = timeUnit.toMillis(j11);
            return this;
        }

        @RequiresApi(26)
        @NonNull
        public Builder setTriggerContentMaxDelay(Duration duration) {
            this.f37986g = duration.toMillis();
            return this;
        }

        @RequiresApi(26)
        @NonNull
        public Builder setTriggerContentUpdateDelay(Duration duration) {
            this.f37985f = duration.toMillis();
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder(@NonNull Constraints constraints) {
            boolean z11 = false;
            this.f37980a = constraints.requiresCharging();
            int i11 = Build.VERSION.SDK_INT;
            this.f37981b = constraints.requiresDeviceIdle() ? true : z11;
            this.f37982c = constraints.getRequiredNetworkType();
            this.f37983d = constraints.requiresBatteryNotLow();
            this.f37984e = constraints.requiresStorageNotLow();
            if (i11 >= 24) {
                this.f37985f = constraints.getTriggerContentUpdateDelay();
                this.f37986g = constraints.getTriggerMaxContentDelay();
                this.f37987h = constraints.getContentUriTriggers();
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Constraints() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Constraints.class != obj.getClass()) {
            return false;
        }
        Constraints constraints = (Constraints) obj;
        if (this.mRequiresCharging == constraints.mRequiresCharging && this.mRequiresDeviceIdle == constraints.mRequiresDeviceIdle && this.mRequiresBatteryNotLow == constraints.mRequiresBatteryNotLow && this.mRequiresStorageNotLow == constraints.mRequiresStorageNotLow && this.mTriggerContentUpdateDelay == constraints.mTriggerContentUpdateDelay && this.mTriggerMaxContentDelay == constraints.mTriggerMaxContentDelay && this.mRequiredNetworkType == constraints.mRequiredNetworkType) {
            return this.mContentUriTriggers.equals(constraints.mContentUriTriggers);
        }
        return false;
    }

    @RequiresApi(24)
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ContentUriTriggers getContentUriTriggers() {
        return this.mContentUriTriggers;
    }

    @NonNull
    public NetworkType getRequiredNetworkType() {
        return this.mRequiredNetworkType;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public long getTriggerContentUpdateDelay() {
        return this.mTriggerContentUpdateDelay;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public long getTriggerMaxContentDelay() {
        return this.mTriggerMaxContentDelay;
    }

    @RequiresApi(24)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean hasContentUriTriggers() {
        return this.mContentUriTriggers.size() > 0;
    }

    public int hashCode() {
        long j11 = this.mTriggerContentUpdateDelay;
        long j12 = this.mTriggerMaxContentDelay;
        return (((((((((((((this.mRequiredNetworkType.hashCode() * 31) + (this.mRequiresCharging ? 1 : 0)) * 31) + (this.mRequiresDeviceIdle ? 1 : 0)) * 31) + (this.mRequiresBatteryNotLow ? 1 : 0)) * 31) + (this.mRequiresStorageNotLow ? 1 : 0)) * 31) + ((int) (j11 ^ (j11 >>> 32)))) * 31) + ((int) (j12 ^ (j12 >>> 32)))) * 31) + this.mContentUriTriggers.hashCode();
    }

    public boolean requiresBatteryNotLow() {
        return this.mRequiresBatteryNotLow;
    }

    public boolean requiresCharging() {
        return this.mRequiresCharging;
    }

    @RequiresApi(23)
    public boolean requiresDeviceIdle() {
        return this.mRequiresDeviceIdle;
    }

    public boolean requiresStorageNotLow() {
        return this.mRequiresStorageNotLow;
    }

    @RequiresApi(24)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setContentUriTriggers(@Nullable ContentUriTriggers contentUriTriggers) {
        this.mContentUriTriggers = contentUriTriggers;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setRequiredNetworkType(@NonNull NetworkType networkType) {
        this.mRequiredNetworkType = networkType;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setRequiresBatteryNotLow(boolean z11) {
        this.mRequiresBatteryNotLow = z11;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setRequiresCharging(boolean z11) {
        this.mRequiresCharging = z11;
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setRequiresDeviceIdle(boolean z11) {
        this.mRequiresDeviceIdle = z11;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setRequiresStorageNotLow(boolean z11) {
        this.mRequiresStorageNotLow = z11;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setTriggerContentUpdateDelay(long j11) {
        this.mTriggerContentUpdateDelay = j11;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setTriggerMaxContentDelay(long j11) {
        this.mTriggerMaxContentDelay = j11;
    }

    public Constraints(Builder builder) {
        this.mRequiresCharging = builder.f37980a;
        int i11 = Build.VERSION.SDK_INT;
        this.mRequiresDeviceIdle = builder.f37981b;
        this.mRequiredNetworkType = builder.f37982c;
        this.mRequiresBatteryNotLow = builder.f37983d;
        this.mRequiresStorageNotLow = builder.f37984e;
        if (i11 >= 24) {
            this.mContentUriTriggers = builder.f37987h;
            this.mTriggerContentUpdateDelay = builder.f37985f;
            this.mTriggerMaxContentDelay = builder.f37986g;
        }
    }

    public Constraints(@NonNull Constraints constraints) {
        this.mRequiresCharging = constraints.mRequiresCharging;
        this.mRequiresDeviceIdle = constraints.mRequiresDeviceIdle;
        this.mRequiredNetworkType = constraints.mRequiredNetworkType;
        this.mRequiresBatteryNotLow = constraints.mRequiresBatteryNotLow;
        this.mRequiresStorageNotLow = constraints.mRequiresStorageNotLow;
        this.mContentUriTriggers = constraints.mContentUriTriggers;
    }
}
