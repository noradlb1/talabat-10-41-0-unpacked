package androidx.work.impl.utils;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.Data;
import androidx.work.Logger;
import androidx.work.ProgressUpdater;
import androidx.work.WorkInfo;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.WorkProgress;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.UUID;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class WorkProgressUpdater implements ProgressUpdater {

    /* renamed from: c  reason: collision with root package name */
    public static final String f38165c = Logger.tagWithPrefix("WorkProgressUpdater");

    /* renamed from: a  reason: collision with root package name */
    public final WorkDatabase f38166a;

    /* renamed from: b  reason: collision with root package name */
    public final TaskExecutor f38167b;

    public WorkProgressUpdater(@NonNull WorkDatabase workDatabase, @NonNull TaskExecutor taskExecutor) {
        this.f38166a = workDatabase;
        this.f38167b = taskExecutor;
    }

    @NonNull
    public ListenableFuture<Void> updateProgress(@NonNull Context context, @NonNull final UUID uuid, @NonNull final Data data) {
        final SettableFuture create = SettableFuture.create();
        this.f38167b.executeOnBackgroundThread(new Runnable() {
            public void run() {
                String uuid = uuid.toString();
                Logger logger = Logger.get();
                String str = WorkProgressUpdater.f38165c;
                logger.debug(str, String.format("Updating progress for %s (%s)", new Object[]{uuid, data}), new Throwable[0]);
                WorkProgressUpdater.this.f38166a.beginTransaction();
                try {
                    WorkSpec workSpec = WorkProgressUpdater.this.f38166a.workSpecDao().getWorkSpec(uuid);
                    if (workSpec != null) {
                        if (workSpec.state == WorkInfo.State.RUNNING) {
                            WorkProgressUpdater.this.f38166a.workProgressDao().insert(new WorkProgress(uuid, data));
                        } else {
                            Logger.get().warning(str, String.format("Ignoring setProgressAsync(...). WorkSpec (%s) is not in a RUNNING state.", new Object[]{uuid}), new Throwable[0]);
                        }
                        create.set(null);
                        WorkProgressUpdater.this.f38166a.setTransactionSuccessful();
                        WorkProgressUpdater.this.f38166a.endTransaction();
                        return;
                    }
                    throw new IllegalStateException("Calls to setProgressAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
                } catch (Throwable th2) {
                    WorkProgressUpdater.this.f38166a.endTransaction();
                    throw th2;
                }
            }
        });
        return create;
    }
}
