package androidx.work.impl.background.systemjob;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.PersistableBundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.work.Logger;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import androidx.work.impl.Scheduler;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.utils.IdGenerator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

@RequiresApi(23)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SystemJobScheduler implements Scheduler {
    private static final String TAG = Logger.tagWithPrefix("SystemJobScheduler");
    private final Context mContext;
    private final JobScheduler mJobScheduler;
    private final SystemJobInfoConverter mSystemJobInfoConverter;
    private final WorkManagerImpl mWorkManager;

    public SystemJobScheduler(@NonNull Context context, @NonNull WorkManagerImpl workManagerImpl) {
        this(context, workManagerImpl, (JobScheduler) context.getSystemService("jobscheduler"), new SystemJobInfoConverter(context));
    }

    public static void cancelAll(@NonNull Context context) {
        List<JobInfo> pendingJobs;
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (jobScheduler != null && (pendingJobs = getPendingJobs(context, jobScheduler)) != null && !pendingJobs.isEmpty()) {
            for (JobInfo id2 : pendingJobs) {
                cancelJobById(jobScheduler, id2.getId());
            }
        }
    }

    private static void cancelJobById(@NonNull JobScheduler jobScheduler, int i11) {
        try {
            jobScheduler.cancel(i11);
        } catch (Throwable th2) {
            Logger.get().error(TAG, String.format(Locale.getDefault(), "Exception while trying to cancel job (%d)", new Object[]{Integer.valueOf(i11)}), th2);
        }
    }

    @Nullable
    private static List<Integer> getPendingJobIds(@NonNull Context context, @NonNull JobScheduler jobScheduler, @NonNull String str) {
        List<JobInfo> pendingJobs = getPendingJobs(context, jobScheduler);
        if (pendingJobs == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(2);
        for (JobInfo next : pendingJobs) {
            if (str.equals(getWorkSpecIdFromJobInfo(next))) {
                arrayList.add(Integer.valueOf(next.getId()));
            }
        }
        return arrayList;
    }

    @Nullable
    private static List<JobInfo> getPendingJobs(@NonNull Context context, @NonNull JobScheduler jobScheduler) {
        List<JobInfo> list;
        try {
            list = jobScheduler.getAllPendingJobs();
        } catch (Throwable th2) {
            Logger.get().error(TAG, "getAllPendingJobs() is not reliable on this device.", th2);
            list = null;
        }
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        ComponentName componentName = new ComponentName(context, SystemJobService.class);
        for (JobInfo next : list) {
            if (componentName.equals(next.getService())) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    @Nullable
    private static String getWorkSpecIdFromJobInfo(@NonNull JobInfo jobInfo) {
        PersistableBundle extras = jobInfo.getExtras();
        if (extras == null) {
            return null;
        }
        try {
            if (extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                return extras.getString("EXTRA_WORK_SPEC_ID");
            }
            return null;
        } catch (NullPointerException unused) {
            return null;
        }
    }

    public static boolean reconcileJobs(@NonNull Context context, @NonNull WorkManagerImpl workManagerImpl) {
        int i11;
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        List<JobInfo> pendingJobs = getPendingJobs(context, jobScheduler);
        List<String> workSpecIds = workManagerImpl.getWorkDatabase().systemIdInfoDao().getWorkSpecIds();
        boolean z11 = false;
        if (pendingJobs != null) {
            i11 = pendingJobs.size();
        } else {
            i11 = 0;
        }
        HashSet hashSet = new HashSet(i11);
        if (pendingJobs != null && !pendingJobs.isEmpty()) {
            for (JobInfo next : pendingJobs) {
                String workSpecIdFromJobInfo = getWorkSpecIdFromJobInfo(next);
                if (!TextUtils.isEmpty(workSpecIdFromJobInfo)) {
                    hashSet.add(workSpecIdFromJobInfo);
                } else {
                    cancelJobById(jobScheduler, next.getId());
                }
            }
        }
        Iterator<String> it = workSpecIds.iterator();
        while (true) {
            if (it.hasNext()) {
                if (!hashSet.contains(it.next())) {
                    Logger.get().debug(TAG, "Reconciling jobs", new Throwable[0]);
                    z11 = true;
                    break;
                }
            } else {
                break;
            }
        }
        if (z11) {
            WorkDatabase workDatabase = workManagerImpl.getWorkDatabase();
            workDatabase.beginTransaction();
            try {
                WorkSpecDao workSpecDao = workDatabase.workSpecDao();
                for (String markWorkSpecScheduled : workSpecIds) {
                    workSpecDao.markWorkSpecScheduled(markWorkSpecScheduled, -1);
                }
                workDatabase.setTransactionSuccessful();
            } finally {
                workDatabase.endTransaction();
            }
        }
        return z11;
    }

    public void cancel(@NonNull String str) {
        List<Integer> pendingJobIds = getPendingJobIds(this.mContext, this.mJobScheduler, str);
        if (pendingJobIds != null && !pendingJobIds.isEmpty()) {
            for (Integer intValue : pendingJobIds) {
                cancelJobById(this.mJobScheduler, intValue.intValue());
            }
            this.mWorkManager.getWorkDatabase().systemIdInfoDao().removeSystemIdInfo(str);
        }
    }

    public boolean hasLimitedSchedulingSlots() {
        return true;
    }

    /* JADX INFO: finally extract failed */
    public void schedule(@NonNull WorkSpec... workSpecArr) {
        int i11;
        List<Integer> pendingJobIds;
        int i12;
        WorkDatabase workDatabase = this.mWorkManager.getWorkDatabase();
        IdGenerator idGenerator = new IdGenerator(workDatabase);
        int length = workSpecArr.length;
        int i13 = 0;
        while (i13 < length) {
            WorkSpec workSpec = workSpecArr[i13];
            workDatabase.beginTransaction();
            try {
                WorkSpec workSpec2 = workDatabase.workSpecDao().getWorkSpec(workSpec.f38092id);
                if (workSpec2 == null) {
                    Logger.get().warning(TAG, "Skipping scheduling " + workSpec.f38092id + " because it's no longer in the DB", new Throwable[0]);
                    workDatabase.setTransactionSuccessful();
                } else if (workSpec2.state != WorkInfo.State.ENQUEUED) {
                    Logger.get().warning(TAG, "Skipping scheduling " + workSpec.f38092id + " because it is no longer enqueued", new Throwable[0]);
                    workDatabase.setTransactionSuccessful();
                } else {
                    SystemIdInfo systemIdInfo = workDatabase.systemIdInfoDao().getSystemIdInfo(workSpec.f38092id);
                    if (systemIdInfo != null) {
                        i11 = systemIdInfo.systemId;
                    } else {
                        i11 = idGenerator.nextJobSchedulerIdWithRange(this.mWorkManager.getConfiguration().getMinJobSchedulerId(), this.mWorkManager.getConfiguration().getMaxJobSchedulerId());
                    }
                    if (systemIdInfo == null) {
                        this.mWorkManager.getWorkDatabase().systemIdInfoDao().insertSystemIdInfo(new SystemIdInfo(workSpec.f38092id, i11));
                    }
                    scheduleInternal(workSpec, i11);
                    if (Build.VERSION.SDK_INT == 23 && (pendingJobIds = getPendingJobIds(this.mContext, this.mJobScheduler, workSpec.f38092id)) != null) {
                        int indexOf = pendingJobIds.indexOf(Integer.valueOf(i11));
                        if (indexOf >= 0) {
                            pendingJobIds.remove(indexOf);
                        }
                        if (!pendingJobIds.isEmpty()) {
                            i12 = pendingJobIds.get(0).intValue();
                        } else {
                            i12 = idGenerator.nextJobSchedulerIdWithRange(this.mWorkManager.getConfiguration().getMinJobSchedulerId(), this.mWorkManager.getConfiguration().getMaxJobSchedulerId());
                        }
                        scheduleInternal(workSpec, i12);
                    }
                    workDatabase.setTransactionSuccessful();
                }
                workDatabase.endTransaction();
                i13++;
            } catch (Throwable th2) {
                workDatabase.endTransaction();
                throw th2;
            }
        }
    }

    @VisibleForTesting
    public void scheduleInternal(WorkSpec workSpec, int i11) {
        int i12;
        JobInfo a11 = this.mSystemJobInfoConverter.a(workSpec, i11);
        Logger logger = Logger.get();
        String str = TAG;
        logger.debug(str, String.format("Scheduling work ID %s Job ID %s", new Object[]{workSpec.f38092id, Integer.valueOf(i11)}), new Throwable[0]);
        try {
            if (this.mJobScheduler.schedule(a11) == 0) {
                Logger.get().warning(str, String.format("Unable to schedule work ID %s", new Object[]{workSpec.f38092id}), new Throwable[0]);
                if (workSpec.expedited && workSpec.outOfQuotaPolicy == OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST) {
                    workSpec.expedited = false;
                    Logger.get().debug(str, String.format("Scheduling a non-expedited job (work ID %s)", new Object[]{workSpec.f38092id}), new Throwable[0]);
                    scheduleInternal(workSpec, i11);
                }
            }
        } catch (IllegalStateException e11) {
            List<JobInfo> pendingJobs = getPendingJobs(this.mContext, this.mJobScheduler);
            if (pendingJobs != null) {
                i12 = pendingJobs.size();
            } else {
                i12 = 0;
            }
            String format = String.format(Locale.getDefault(), "JobScheduler 100 job limit exceeded.  We count %d WorkManager jobs in JobScheduler; we have %d tracked jobs in our DB; our Configuration limit is %d.", new Object[]{Integer.valueOf(i12), Integer.valueOf(this.mWorkManager.getWorkDatabase().workSpecDao().getScheduledWork().size()), Integer.valueOf(this.mWorkManager.getConfiguration().getMaxSchedulerLimit())});
            Logger.get().error(TAG, format, new Throwable[0]);
            throw new IllegalStateException(format, e11);
        } catch (Throwable th2) {
            Logger.get().error(TAG, String.format("Unable to schedule %s", new Object[]{workSpec}), th2);
        }
    }

    @VisibleForTesting
    public SystemJobScheduler(Context context, WorkManagerImpl workManagerImpl, JobScheduler jobScheduler, SystemJobInfoConverter systemJobInfoConverter) {
        this.mContext = context;
        this.mWorkManager = workManagerImpl;
        this.mJobScheduler = jobScheduler;
        this.mSystemJobInfoConverter = systemJobInfoConverter;
    }
}
