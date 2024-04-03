package androidx.work;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.work.WorkRequest;
import j$.time.Duration;
import java.util.concurrent.TimeUnit;

public final class PeriodicWorkRequest extends WorkRequest {
    @SuppressLint({"MinMaxConstant"})
    public static final long MIN_PERIODIC_FLEX_MILLIS = 300000;
    @SuppressLint({"MinMaxConstant"})
    public static final long MIN_PERIODIC_INTERVAL_MILLIS = 900000;

    public PeriodicWorkRequest(Builder builder) {
        super(builder.f37996b, builder.f37997c, builder.f37998d);
    }

    public static final class Builder extends WorkRequest.Builder<Builder, PeriodicWorkRequest> {
        public Builder(@NonNull Class<? extends ListenableWorker> cls, long j11, @NonNull TimeUnit timeUnit) {
            super(cls);
            this.f37997c.setPeriodic(timeUnit.toMillis(j11));
        }

        @NonNull
        /* renamed from: c */
        public PeriodicWorkRequest a() {
            if (this.f37995a && this.f37997c.constraints.requiresDeviceIdle()) {
                throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job");
            } else if (!this.f37997c.expedited) {
                return new PeriodicWorkRequest(this);
            } else {
                throw new IllegalArgumentException("PeriodicWorkRequests cannot be expedited");
            }
        }

        @NonNull
        /* renamed from: d */
        public Builder b() {
            return this;
        }

        @RequiresApi(26)
        public Builder(@NonNull Class<? extends ListenableWorker> cls, @NonNull Duration duration) {
            super(cls);
            this.f37997c.setPeriodic(duration.toMillis());
        }

        public Builder(@NonNull Class<? extends ListenableWorker> cls, long j11, @NonNull TimeUnit timeUnit, long j12, @NonNull TimeUnit timeUnit2) {
            super(cls);
            this.f37997c.setPeriodic(timeUnit.toMillis(j11), timeUnit2.toMillis(j12));
        }

        @RequiresApi(26)
        public Builder(@NonNull Class<? extends ListenableWorker> cls, @NonNull Duration duration, @NonNull Duration duration2) {
            super(cls);
            this.f37997c.setPeriodic(duration.toMillis(), duration2.toMillis());
        }
    }
}
