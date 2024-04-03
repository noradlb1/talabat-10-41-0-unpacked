package androidx.work;

import android.annotation.SuppressLint;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.work.WorkInfo;
import androidx.work.impl.model.WorkSpec;
import j$.time.Duration;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public abstract class WorkRequest {
    public static final long DEFAULT_BACKOFF_DELAY_MILLIS = 30000;
    @SuppressLint({"MinMaxConstant"})
    public static final long MAX_BACKOFF_MILLIS = 18000000;
    @SuppressLint({"MinMaxConstant"})
    public static final long MIN_BACKOFF_MILLIS = 10000;
    @NonNull
    private UUID mId;
    @NonNull
    private Set<String> mTags;
    @NonNull
    private WorkSpec mWorkSpec;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public WorkRequest(@NonNull UUID uuid, @NonNull WorkSpec workSpec, @NonNull Set<String> set) {
        this.mId = uuid;
        this.mWorkSpec = workSpec;
        this.mTags = set;
    }

    @NonNull
    public UUID getId() {
        return this.mId;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public String getStringId() {
        return this.mId.toString();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Set<String> getTags() {
        return this.mTags;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public WorkSpec getWorkSpec() {
        return this.mWorkSpec;
    }

    public static abstract class Builder<B extends Builder<?, ?>, W extends WorkRequest> {

        /* renamed from: a  reason: collision with root package name */
        public boolean f37995a = false;

        /* renamed from: b  reason: collision with root package name */
        public UUID f37996b = UUID.randomUUID();

        /* renamed from: c  reason: collision with root package name */
        public WorkSpec f37997c;

        /* renamed from: d  reason: collision with root package name */
        public Set<String> f37998d = new HashSet();

        /* renamed from: e  reason: collision with root package name */
        public Class<? extends ListenableWorker> f37999e;

        public Builder(@NonNull Class<? extends ListenableWorker> cls) {
            this.f37999e = cls;
            this.f37997c = new WorkSpec(this.f37996b.toString(), cls.getName());
            addTag(cls.getName());
        }

        @NonNull
        public abstract W a();

        @NonNull
        public final B addTag(@NonNull String str) {
            this.f37998d.add(str);
            return b();
        }

        @NonNull
        public abstract B b();

        @NonNull
        public final W build() {
            boolean z11;
            W a11 = a();
            Constraints constraints = this.f37997c.constraints;
            if ((Build.VERSION.SDK_INT < 24 || !constraints.hasContentUriTriggers()) && !constraints.requiresBatteryNotLow() && !constraints.requiresCharging() && !constraints.requiresDeviceIdle()) {
                z11 = false;
            } else {
                z11 = true;
            }
            WorkSpec workSpec = this.f37997c;
            if (workSpec.expedited) {
                if (z11) {
                    throw new IllegalArgumentException("Expedited jobs only support network and storage constraints");
                } else if (workSpec.initialDelay > 0) {
                    throw new IllegalArgumentException("Expedited jobs cannot be delayed");
                }
            }
            this.f37996b = UUID.randomUUID();
            WorkSpec workSpec2 = new WorkSpec(this.f37997c);
            this.f37997c = workSpec2;
            workSpec2.f38092id = this.f37996b.toString();
            return a11;
        }

        @NonNull
        public final B keepResultsForAtLeast(long j11, @NonNull TimeUnit timeUnit) {
            this.f37997c.minimumRetentionDuration = timeUnit.toMillis(j11);
            return b();
        }

        @NonNull
        public final B setBackoffCriteria(@NonNull BackoffPolicy backoffPolicy, long j11, @NonNull TimeUnit timeUnit) {
            this.f37995a = true;
            WorkSpec workSpec = this.f37997c;
            workSpec.backoffPolicy = backoffPolicy;
            workSpec.setBackoffDelayDuration(timeUnit.toMillis(j11));
            return b();
        }

        @NonNull
        public final B setConstraints(@NonNull Constraints constraints) {
            this.f37997c.constraints = constraints;
            return b();
        }

        @SuppressLint({"MissingGetterMatchingBuilder"})
        @NonNull
        public B setExpedited(@NonNull OutOfQuotaPolicy outOfQuotaPolicy) {
            WorkSpec workSpec = this.f37997c;
            workSpec.expedited = true;
            workSpec.outOfQuotaPolicy = outOfQuotaPolicy;
            return b();
        }

        @NonNull
        public B setInitialDelay(long j11, @NonNull TimeUnit timeUnit) {
            this.f37997c.initialDelay = timeUnit.toMillis(j11);
            if (Long.MAX_VALUE - System.currentTimeMillis() > this.f37997c.initialDelay) {
                return b();
            }
            throw new IllegalArgumentException("The given initial delay is too large and will cause an overflow!");
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @VisibleForTesting
        @NonNull
        public final B setInitialRunAttemptCount(int i11) {
            this.f37997c.runAttemptCount = i11;
            return b();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @VisibleForTesting
        @NonNull
        public final B setInitialState(@NonNull WorkInfo.State state) {
            this.f37997c.state = state;
            return b();
        }

        @NonNull
        public final B setInputData(@NonNull Data data) {
            this.f37997c.input = data;
            return b();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @VisibleForTesting
        @NonNull
        public final B setPeriodStartTime(long j11, @NonNull TimeUnit timeUnit) {
            this.f37997c.periodStartTime = timeUnit.toMillis(j11);
            return b();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @VisibleForTesting
        @NonNull
        public final B setScheduleRequestedAt(long j11, @NonNull TimeUnit timeUnit) {
            this.f37997c.scheduleRequestedAt = timeUnit.toMillis(j11);
            return b();
        }

        @RequiresApi(26)
        @NonNull
        public final B keepResultsForAtLeast(@NonNull Duration duration) {
            this.f37997c.minimumRetentionDuration = duration.toMillis();
            return b();
        }

        @RequiresApi(26)
        @NonNull
        public final B setBackoffCriteria(@NonNull BackoffPolicy backoffPolicy, @NonNull Duration duration) {
            this.f37995a = true;
            WorkSpec workSpec = this.f37997c;
            workSpec.backoffPolicy = backoffPolicy;
            workSpec.setBackoffDelayDuration(duration.toMillis());
            return b();
        }

        @RequiresApi(26)
        @NonNull
        public B setInitialDelay(@NonNull Duration duration) {
            this.f37997c.initialDelay = duration.toMillis();
            if (Long.MAX_VALUE - System.currentTimeMillis() > this.f37997c.initialDelay) {
                return b();
            }
            throw new IllegalArgumentException("The given initial delay is too large and will cause an overflow!");
        }
    }
}
