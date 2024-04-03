package androidx.work;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class DelegatingWorkerFactory extends WorkerFactory {
    private static final String TAG = Logger.tagWithPrefix("DelegatingWkrFctry");
    private final List<WorkerFactory> mFactories = new CopyOnWriteArrayList();

    public final void addFactory(@NonNull WorkerFactory workerFactory) {
        this.mFactories.add(workerFactory);
    }

    @Nullable
    public final ListenableWorker createWorker(@NonNull Context context, @NonNull String str, @NonNull WorkerParameters workerParameters) {
        for (WorkerFactory createWorker : this.mFactories) {
            try {
                ListenableWorker createWorker2 = createWorker.createWorker(context, str, workerParameters);
                if (createWorker2 != null) {
                    return createWorker2;
                }
            } catch (Throwable th2) {
                String format = String.format("Unable to instantiate a ListenableWorker (%s)", new Object[]{str});
                Logger.get().error(TAG, format, th2);
                throw th2;
            }
        }
        return null;
    }
}
