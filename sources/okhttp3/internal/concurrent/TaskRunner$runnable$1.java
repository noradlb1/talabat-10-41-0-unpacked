package okhttp3.internal.concurrent;

import java.util.logging.Level;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"okhttp3/internal/concurrent/TaskRunner$runnable$1", "Ljava/lang/Runnable;", "run", "", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TaskRunner$runnable$1 implements Runnable {
    final /* synthetic */ TaskRunner this$0;

    public TaskRunner$runnable$1(TaskRunner taskRunner) {
        this.this$0 = taskRunner;
    }

    public void run() {
        Task awaitTaskToRun;
        long j11;
        while (true) {
            TaskRunner taskRunner = this.this$0;
            synchronized (taskRunner) {
                awaitTaskToRun = taskRunner.awaitTaskToRun();
            }
            if (awaitTaskToRun != null) {
                TaskQueue queue$okhttp = awaitTaskToRun.getQueue$okhttp();
                Intrinsics.checkNotNull(queue$okhttp);
                TaskRunner taskRunner2 = this.this$0;
                boolean isLoggable = TaskRunner.Companion.getLogger().isLoggable(Level.FINE);
                if (isLoggable) {
                    j11 = queue$okhttp.getTaskRunner$okhttp().getBackend().nanoTime();
                    TaskLoggerKt.log(awaitTaskToRun, queue$okhttp, "starting");
                } else {
                    j11 = -1;
                }
                try {
                    taskRunner2.runTask(awaitTaskToRun);
                    Unit unit = Unit.INSTANCE;
                    if (isLoggable) {
                        TaskLoggerKt.log(awaitTaskToRun, queue$okhttp, Intrinsics.stringPlus("finished run in ", TaskLoggerKt.formatDuration(queue$okhttp.getTaskRunner$okhttp().getBackend().nanoTime() - j11)));
                    }
                } catch (Throwable th2) {
                    if (isLoggable) {
                        TaskLoggerKt.log(awaitTaskToRun, queue$okhttp, Intrinsics.stringPlus("failed a run in ", TaskLoggerKt.formatDuration(queue$okhttp.getTaskRunner$okhttp().getBackend().nanoTime() - j11)));
                    }
                    throw th2;
                }
            } else {
                return;
            }
        }
    }
}
