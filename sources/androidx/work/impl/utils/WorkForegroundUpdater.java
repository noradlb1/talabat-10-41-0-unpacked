package androidx.work.impl.utils;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.ForegroundInfo;
import androidx.work.ForegroundUpdater;
import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.foreground.ForegroundProcessor;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.UUID;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class WorkForegroundUpdater implements ForegroundUpdater {
    private static final String TAG = Logger.tagWithPrefix("WMFgUpdater");

    /* renamed from: a  reason: collision with root package name */
    public final ForegroundProcessor f38158a;

    /* renamed from: b  reason: collision with root package name */
    public final WorkSpecDao f38159b;
    private final TaskExecutor mTaskExecutor;

    public WorkForegroundUpdater(@NonNull WorkDatabase workDatabase, @NonNull ForegroundProcessor foregroundProcessor, @NonNull TaskExecutor taskExecutor) {
        this.f38158a = foregroundProcessor;
        this.mTaskExecutor = taskExecutor;
        this.f38159b = workDatabase.workSpecDao();
    }

    @NonNull
    public ListenableFuture<Void> setForegroundAsync(@NonNull Context context, @NonNull UUID uuid, @NonNull ForegroundInfo foregroundInfo) {
        SettableFuture create = SettableFuture.create();
        final SettableFuture settableFuture = create;
        final UUID uuid2 = uuid;
        final ForegroundInfo foregroundInfo2 = foregroundInfo;
        final Context context2 = context;
        this.mTaskExecutor.executeOnBackgroundThread(new Runnable() {
            public void run() {
                try {
                    if (!settableFuture.isCancelled()) {
                        String uuid = uuid2.toString();
                        WorkInfo.State state = WorkForegroundUpdater.this.f38159b.getState(uuid);
                        if (state == null || state.isFinished()) {
                            throw new IllegalStateException("Calls to setForegroundAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
                        }
                        WorkForegroundUpdater.this.f38158a.startForeground(uuid, foregroundInfo2);
                        context2.startService(SystemForegroundDispatcher.createNotifyIntent(context2, uuid, foregroundInfo2));
                    }
                    settableFuture.set(null);
                } catch (Throwable th2) {
                    settableFuture.setException(th2);
                }
            }
        });
        return create;
    }
}
