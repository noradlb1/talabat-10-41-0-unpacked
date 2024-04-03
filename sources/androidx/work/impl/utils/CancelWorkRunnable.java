package androidx.work.impl.utils;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import androidx.work.Operation;
import androidx.work.WorkInfo;
import androidx.work.impl.OperationImpl;
import androidx.work.impl.Scheduler;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.WorkSpecDao;
import java.util.LinkedList;
import java.util.UUID;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class CancelWorkRunnable implements Runnable {
    private final OperationImpl mOperation = new OperationImpl();

    public static CancelWorkRunnable forAll(@NonNull final WorkManagerImpl workManagerImpl) {
        return new CancelWorkRunnable() {
            @WorkerThread
            public void c() {
                WorkDatabase workDatabase = WorkManagerImpl.this.getWorkDatabase();
                workDatabase.beginTransaction();
                try {
                    for (String a11 : workDatabase.workSpecDao().getAllUnfinishedWork()) {
                        a(WorkManagerImpl.this, a11);
                    }
                    new PreferenceUtils(WorkManagerImpl.this.getWorkDatabase()).setLastCancelAllTimeMillis(System.currentTimeMillis());
                    workDatabase.setTransactionSuccessful();
                } finally {
                    workDatabase.endTransaction();
                }
            }
        };
    }

    public static CancelWorkRunnable forId(@NonNull final UUID uuid, @NonNull final WorkManagerImpl workManagerImpl) {
        return new CancelWorkRunnable() {
            /* JADX INFO: finally extract failed */
            @WorkerThread
            public void c() {
                WorkDatabase workDatabase = WorkManagerImpl.this.getWorkDatabase();
                workDatabase.beginTransaction();
                try {
                    a(WorkManagerImpl.this, uuid.toString());
                    workDatabase.setTransactionSuccessful();
                    workDatabase.endTransaction();
                    b(WorkManagerImpl.this);
                } catch (Throwable th2) {
                    workDatabase.endTransaction();
                    throw th2;
                }
            }
        };
    }

    public static CancelWorkRunnable forName(@NonNull final String str, @NonNull final WorkManagerImpl workManagerImpl, final boolean z11) {
        return new CancelWorkRunnable() {
            /* JADX INFO: finally extract failed */
            @WorkerThread
            public void c() {
                WorkDatabase workDatabase = WorkManagerImpl.this.getWorkDatabase();
                workDatabase.beginTransaction();
                try {
                    for (String a11 : workDatabase.workSpecDao().getUnfinishedWorkWithName(str)) {
                        a(WorkManagerImpl.this, a11);
                    }
                    workDatabase.setTransactionSuccessful();
                    workDatabase.endTransaction();
                    if (z11) {
                        b(WorkManagerImpl.this);
                    }
                } catch (Throwable th2) {
                    workDatabase.endTransaction();
                    throw th2;
                }
            }
        };
    }

    public static CancelWorkRunnable forTag(@NonNull final String str, @NonNull final WorkManagerImpl workManagerImpl) {
        return new CancelWorkRunnable() {
            /* JADX INFO: finally extract failed */
            @WorkerThread
            public void c() {
                WorkDatabase workDatabase = WorkManagerImpl.this.getWorkDatabase();
                workDatabase.beginTransaction();
                try {
                    for (String a11 : workDatabase.workSpecDao().getUnfinishedWorkWithTag(str)) {
                        a(WorkManagerImpl.this, a11);
                    }
                    workDatabase.setTransactionSuccessful();
                    workDatabase.endTransaction();
                    b(WorkManagerImpl.this);
                } catch (Throwable th2) {
                    workDatabase.endTransaction();
                    throw th2;
                }
            }
        };
    }

    private void iterativelyCancelWorkAndDependents(WorkDatabase workDatabase, String str) {
        WorkSpecDao workSpecDao = workDatabase.workSpecDao();
        DependencyDao dependencyDao = workDatabase.dependencyDao();
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        while (!linkedList.isEmpty()) {
            String str2 = (String) linkedList.remove();
            WorkInfo.State state = workSpecDao.getState(str2);
            if (!(state == WorkInfo.State.SUCCEEDED || state == WorkInfo.State.FAILED)) {
                workSpecDao.setState(WorkInfo.State.CANCELLED, str2);
            }
            linkedList.addAll(dependencyDao.getDependentWorkIds(str2));
        }
    }

    public void a(WorkManagerImpl workManagerImpl, String str) {
        iterativelyCancelWorkAndDependents(workManagerImpl.getWorkDatabase(), str);
        workManagerImpl.getProcessor().stopAndCancelWork(str);
        for (Scheduler cancel : workManagerImpl.getSchedulers()) {
            cancel.cancel(str);
        }
    }

    public void b(WorkManagerImpl workManagerImpl) {
        Schedulers.schedule(workManagerImpl.getConfiguration(), workManagerImpl.getWorkDatabase(), workManagerImpl.getSchedulers());
    }

    public abstract void c();

    public Operation getOperation() {
        return this.mOperation;
    }

    public void run() {
        try {
            c();
            this.mOperation.setState(Operation.SUCCESS);
        } catch (Throwable th2) {
            this.mOperation.setState(new Operation.State.FAILURE(th2));
        }
    }
}
