package androidx.work.impl.model;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.arch.core.util.Function;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.room.Relation;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.Logger;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@Entity(indices = {@Index({"schedule_requested_at"}), @Index({"period_start_time"})})
public final class WorkSpec {
    public static final long SCHEDULE_NOT_REQUESTED_YET = -1;
    private static final String TAG = Logger.tagWithPrefix("WorkSpec");
    public static final Function<List<WorkInfoPojo>, List<WorkInfo>> WORK_INFO_MAPPER = new Function<List<WorkInfoPojo>, List<WorkInfo>>() {
        public List<WorkInfo> apply(List<WorkInfoPojo> list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (WorkInfoPojo workInfo : list) {
                arrayList.add(workInfo.toWorkInfo());
            }
            return arrayList;
        }
    };
    @ColumnInfo(name = "backoff_delay_duration")
    public long backoffDelayDuration;
    @ColumnInfo(name = "backoff_policy")
    @NonNull
    public BackoffPolicy backoffPolicy;
    @NonNull
    @Embedded
    public Constraints constraints;
    @ColumnInfo(name = "run_in_foreground")
    public boolean expedited;
    @ColumnInfo(name = "flex_duration")
    public long flexDuration;
    @ColumnInfo(name = "id")
    @NonNull
    @PrimaryKey

    /* renamed from: id  reason: collision with root package name */
    public String f38092id;
    @ColumnInfo(name = "initial_delay")
    public long initialDelay;
    @ColumnInfo(name = "input")
    @NonNull
    public Data input;
    @ColumnInfo(name = "input_merger_class_name")
    public String inputMergerClassName;
    @ColumnInfo(name = "interval_duration")
    public long intervalDuration;
    @ColumnInfo(name = "minimum_retention_duration")
    public long minimumRetentionDuration;
    @ColumnInfo(name = "out_of_quota_policy")
    @NonNull
    public OutOfQuotaPolicy outOfQuotaPolicy;
    @ColumnInfo(name = "output")
    @NonNull
    public Data output;
    @ColumnInfo(name = "period_start_time")
    public long periodStartTime;
    @ColumnInfo(name = "run_attempt_count")
    @IntRange(from = 0)
    public int runAttemptCount;
    @ColumnInfo(name = "schedule_requested_at")
    public long scheduleRequestedAt;
    @ColumnInfo(name = "state")
    @NonNull
    public WorkInfo.State state = WorkInfo.State.ENQUEUED;
    @ColumnInfo(name = "worker_class_name")
    @NonNull
    public String workerClassName;

    public static class IdAndState {
        @ColumnInfo(name = "id")

        /* renamed from: id  reason: collision with root package name */
        public String f38093id;
        @ColumnInfo(name = "state")
        public WorkInfo.State state;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof IdAndState)) {
                return false;
            }
            IdAndState idAndState = (IdAndState) obj;
            if (this.state != idAndState.state) {
                return false;
            }
            return this.f38093id.equals(idAndState.f38093id);
        }

        public int hashCode() {
            return (this.f38093id.hashCode() * 31) + this.state.hashCode();
        }
    }

    public static class WorkInfoPojo {
        @ColumnInfo(name = "id")

        /* renamed from: id  reason: collision with root package name */
        public String f38094id;
        @ColumnInfo(name = "output")
        public Data output;
        @Relation(entity = WorkProgress.class, entityColumn = "work_spec_id", parentColumn = "id", projection = {"progress"})
        public List<Data> progress;
        @ColumnInfo(name = "run_attempt_count")
        public int runAttemptCount;
        @ColumnInfo(name = "state")
        public WorkInfo.State state;
        @Relation(entity = WorkTag.class, entityColumn = "work_spec_id", parentColumn = "id", projection = {"tag"})
        public List<String> tags;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof WorkInfoPojo)) {
                return false;
            }
            WorkInfoPojo workInfoPojo = (WorkInfoPojo) obj;
            if (this.runAttemptCount != workInfoPojo.runAttemptCount) {
                return false;
            }
            String str = this.f38094id;
            if (str == null ? workInfoPojo.f38094id != null : !str.equals(workInfoPojo.f38094id)) {
                return false;
            }
            if (this.state != workInfoPojo.state) {
                return false;
            }
            Data data = this.output;
            if (data == null ? workInfoPojo.output != null : !data.equals(workInfoPojo.output)) {
                return false;
            }
            List<String> list = this.tags;
            if (list == null ? workInfoPojo.tags != null : !list.equals(workInfoPojo.tags)) {
                return false;
            }
            List<Data> list2 = this.progress;
            List<Data> list3 = workInfoPojo.progress;
            if (list2 != null) {
                return list2.equals(list3);
            }
            if (list3 == null) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i11;
            int i12;
            int i13;
            int i14;
            String str = this.f38094id;
            int i15 = 0;
            if (str != null) {
                i11 = str.hashCode();
            } else {
                i11 = 0;
            }
            int i16 = i11 * 31;
            WorkInfo.State state2 = this.state;
            if (state2 != null) {
                i12 = state2.hashCode();
            } else {
                i12 = 0;
            }
            int i17 = (i16 + i12) * 31;
            Data data = this.output;
            if (data != null) {
                i13 = data.hashCode();
            } else {
                i13 = 0;
            }
            int i18 = (((i17 + i13) * 31) + this.runAttemptCount) * 31;
            List<String> list = this.tags;
            if (list != null) {
                i14 = list.hashCode();
            } else {
                i14 = 0;
            }
            int i19 = (i18 + i14) * 31;
            List<Data> list2 = this.progress;
            if (list2 != null) {
                i15 = list2.hashCode();
            }
            return i19 + i15;
        }

        @NonNull
        public WorkInfo toWorkInfo() {
            Data data;
            List<Data> list = this.progress;
            if (list == null || list.isEmpty()) {
                data = Data.EMPTY;
            } else {
                data = this.progress.get(0);
            }
            return new WorkInfo(UUID.fromString(this.f38094id), this.state, this.output, this.tags, data, this.runAttemptCount);
        }
    }

    public WorkSpec(@NonNull String str, @NonNull String str2) {
        Data data = Data.EMPTY;
        this.input = data;
        this.output = data;
        this.constraints = Constraints.NONE;
        this.backoffPolicy = BackoffPolicy.EXPONENTIAL;
        this.backoffDelayDuration = 30000;
        this.scheduleRequestedAt = -1;
        this.outOfQuotaPolicy = OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST;
        this.f38092id = str;
        this.workerClassName = str2;
    }

    public long calculateNextRunTime() {
        long j11;
        long j12;
        boolean z11 = false;
        if (isBackedOff()) {
            if (this.backoffPolicy == BackoffPolicy.LINEAR) {
                z11 = true;
            }
            if (z11) {
                j12 = this.backoffDelayDuration * ((long) this.runAttemptCount);
            } else {
                j12 = (long) Math.scalb((float) this.backoffDelayDuration, this.runAttemptCount - 1);
            }
            return this.periodStartTime + Math.min(WorkRequest.MAX_BACKOFF_MILLIS, j12);
        }
        long j13 = 0;
        if (isPeriodic()) {
            long currentTimeMillis = System.currentTimeMillis();
            long j14 = this.periodStartTime;
            if (j14 == 0) {
                j11 = currentTimeMillis + this.initialDelay;
            } else {
                j11 = j14;
            }
            long j15 = this.flexDuration;
            long j16 = this.intervalDuration;
            if (j15 != j16) {
                z11 = true;
            }
            if (z11) {
                if (j14 == 0) {
                    j13 = j15 * -1;
                }
                return j11 + j16 + j13;
            }
            if (j14 != 0) {
                j13 = j16;
            }
            return j11 + j13;
        }
        long j17 = this.periodStartTime;
        if (j17 == 0) {
            j17 = System.currentTimeMillis();
        }
        return j17 + this.initialDelay;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || WorkSpec.class != obj.getClass()) {
            return false;
        }
        WorkSpec workSpec = (WorkSpec) obj;
        if (this.initialDelay != workSpec.initialDelay || this.intervalDuration != workSpec.intervalDuration || this.flexDuration != workSpec.flexDuration || this.runAttemptCount != workSpec.runAttemptCount || this.backoffDelayDuration != workSpec.backoffDelayDuration || this.periodStartTime != workSpec.periodStartTime || this.minimumRetentionDuration != workSpec.minimumRetentionDuration || this.scheduleRequestedAt != workSpec.scheduleRequestedAt || this.expedited != workSpec.expedited || !this.f38092id.equals(workSpec.f38092id) || this.state != workSpec.state || !this.workerClassName.equals(workSpec.workerClassName)) {
            return false;
        }
        String str = this.inputMergerClassName;
        if (str == null ? workSpec.inputMergerClassName != null : !str.equals(workSpec.inputMergerClassName)) {
            return false;
        }
        if (!this.input.equals(workSpec.input) || !this.output.equals(workSpec.output) || !this.constraints.equals(workSpec.constraints) || this.backoffPolicy != workSpec.backoffPolicy) {
            return false;
        }
        if (this.outOfQuotaPolicy == workSpec.outOfQuotaPolicy) {
            return true;
        }
        return false;
    }

    public boolean hasConstraints() {
        return !Constraints.NONE.equals(this.constraints);
    }

    public int hashCode() {
        int i11;
        int hashCode = ((((this.f38092id.hashCode() * 31) + this.state.hashCode()) * 31) + this.workerClassName.hashCode()) * 31;
        String str = this.inputMergerClassName;
        if (str != null) {
            i11 = str.hashCode();
        } else {
            i11 = 0;
        }
        long j11 = this.initialDelay;
        long j12 = this.intervalDuration;
        long j13 = this.flexDuration;
        long j14 = this.backoffDelayDuration;
        long j15 = this.periodStartTime;
        long j16 = this.minimumRetentionDuration;
        long j17 = this.scheduleRequestedAt;
        return ((((((((((((((((((((((((((((hashCode + i11) * 31) + this.input.hashCode()) * 31) + this.output.hashCode()) * 31) + ((int) (j11 ^ (j11 >>> 32)))) * 31) + ((int) (j12 ^ (j12 >>> 32)))) * 31) + ((int) (j13 ^ (j13 >>> 32)))) * 31) + this.constraints.hashCode()) * 31) + this.runAttemptCount) * 31) + this.backoffPolicy.hashCode()) * 31) + ((int) (j14 ^ (j14 >>> 32)))) * 31) + ((int) (j15 ^ (j15 >>> 32)))) * 31) + ((int) (j16 ^ (j16 >>> 32)))) * 31) + ((int) (j17 ^ (j17 >>> 32)))) * 31) + (this.expedited ? 1 : 0)) * 31) + this.outOfQuotaPolicy.hashCode();
    }

    public boolean isBackedOff() {
        return this.state == WorkInfo.State.ENQUEUED && this.runAttemptCount > 0;
    }

    public boolean isPeriodic() {
        return this.intervalDuration != 0;
    }

    public void setBackoffDelayDuration(long j11) {
        if (j11 > WorkRequest.MAX_BACKOFF_MILLIS) {
            Logger.get().warning(TAG, "Backoff delay duration exceeds maximum value", new Throwable[0]);
            j11 = 18000000;
        }
        if (j11 < 10000) {
            Logger.get().warning(TAG, "Backoff delay duration less than minimum value", new Throwable[0]);
            j11 = 10000;
        }
        this.backoffDelayDuration = j11;
    }

    public void setPeriodic(long j11) {
        if (j11 < PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS) {
            Logger.get().warning(TAG, String.format("Interval duration lesser than minimum allowed value; Changed to %s", new Object[]{Long.valueOf(PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS)}), new Throwable[0]);
            j11 = 900000;
        }
        setPeriodic(j11, j11);
    }

    @NonNull
    public String toString() {
        return "{WorkSpec: " + this.f38092id + "}";
    }

    public void setPeriodic(long j11, long j12) {
        if (j11 < PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS) {
            Logger.get().warning(TAG, String.format("Interval duration lesser than minimum allowed value; Changed to %s", new Object[]{Long.valueOf(PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS)}), new Throwable[0]);
            j11 = 900000;
        }
        if (j12 < 300000) {
            Logger.get().warning(TAG, String.format("Flex duration lesser than minimum allowed value; Changed to %s", new Object[]{300000L}), new Throwable[0]);
            j12 = 300000;
        }
        if (j12 > j11) {
            Logger.get().warning(TAG, String.format("Flex duration greater than interval duration; Changed to %s", new Object[]{Long.valueOf(j11)}), new Throwable[0]);
            j12 = j11;
        }
        this.intervalDuration = j11;
        this.flexDuration = j12;
    }

    public WorkSpec(@NonNull WorkSpec workSpec) {
        Data data = Data.EMPTY;
        this.input = data;
        this.output = data;
        this.constraints = Constraints.NONE;
        this.backoffPolicy = BackoffPolicy.EXPONENTIAL;
        this.backoffDelayDuration = 30000;
        this.scheduleRequestedAt = -1;
        this.outOfQuotaPolicy = OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST;
        this.f38092id = workSpec.f38092id;
        this.workerClassName = workSpec.workerClassName;
        this.state = workSpec.state;
        this.inputMergerClassName = workSpec.inputMergerClassName;
        this.input = new Data(workSpec.input);
        this.output = new Data(workSpec.output);
        this.initialDelay = workSpec.initialDelay;
        this.intervalDuration = workSpec.intervalDuration;
        this.flexDuration = workSpec.flexDuration;
        this.constraints = new Constraints(workSpec.constraints);
        this.runAttemptCount = workSpec.runAttemptCount;
        this.backoffPolicy = workSpec.backoffPolicy;
        this.backoffDelayDuration = workSpec.backoffDelayDuration;
        this.periodStartTime = workSpec.periodStartTime;
        this.minimumRetentionDuration = workSpec.minimumRetentionDuration;
        this.scheduleRequestedAt = workSpec.scheduleRequestedAt;
        this.expedited = workSpec.expedited;
        this.outOfQuotaPolicy = workSpec.outOfQuotaPolicy;
    }
}
