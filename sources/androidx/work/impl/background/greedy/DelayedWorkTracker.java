package androidx.work.impl.background.greedy;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import androidx.work.RunnableScheduler;
import androidx.work.impl.model.WorkSpec;
import java.util.HashMap;
import java.util.Map;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class DelayedWorkTracker {

    /* renamed from: b  reason: collision with root package name */
    public static final String f38032b = Logger.tagWithPrefix("DelayedWorkTracker");

    /* renamed from: a  reason: collision with root package name */
    public final GreedyScheduler f38033a;
    private final RunnableScheduler mRunnableScheduler;
    private final Map<String, Runnable> mRunnables = new HashMap();

    public DelayedWorkTracker(@NonNull GreedyScheduler greedyScheduler, @NonNull RunnableScheduler runnableScheduler) {
        this.f38033a = greedyScheduler;
        this.mRunnableScheduler = runnableScheduler;
    }

    public void schedule(@NonNull final WorkSpec workSpec) {
        Runnable remove = this.mRunnables.remove(workSpec.f38092id);
        if (remove != null) {
            this.mRunnableScheduler.cancel(remove);
        }
        AnonymousClass1 r02 = new Runnable() {
            public void run() {
                Logger.get().debug(DelayedWorkTracker.f38032b, String.format("Scheduling work %s", new Object[]{workSpec.f38092id}), new Throwable[0]);
                DelayedWorkTracker.this.f38033a.schedule(workSpec);
            }
        };
        this.mRunnables.put(workSpec.f38092id, r02);
        long currentTimeMillis = System.currentTimeMillis();
        this.mRunnableScheduler.scheduleWithDelay(workSpec.calculateNextRunTime() - currentTimeMillis, r02);
    }

    public void unschedule(@NonNull String str) {
        Runnable remove = this.mRunnables.remove(str);
        if (remove != null) {
            this.mRunnableScheduler.cancel(remove);
        }
    }
}
