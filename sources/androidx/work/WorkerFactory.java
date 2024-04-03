package androidx.work;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

public abstract class WorkerFactory {
    private static final String TAG = Logger.tagWithPrefix("WorkerFactory");

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static WorkerFactory getDefaultWorkerFactory() {
        return new WorkerFactory() {
            @Nullable
            public ListenableWorker createWorker(@NonNull Context context, @NonNull String str, @NonNull WorkerParameters workerParameters) {
                return null;
            }
        };
    }

    @Nullable
    public abstract ListenableWorker createWorker(@NonNull Context context, @NonNull String str, @NonNull WorkerParameters workerParameters);

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final ListenableWorker createWorkerWithDefaultFallback(@NonNull Context context, @NonNull String str, @NonNull WorkerParameters workerParameters) {
        Class<? extends U> cls;
        ListenableWorker createWorker = createWorker(context, str, workerParameters);
        if (createWorker == null) {
            try {
                cls = Class.forName(str).asSubclass(ListenableWorker.class);
            } catch (Throwable th2) {
                Logger logger = Logger.get();
                String str2 = TAG;
                logger.error(str2, "Invalid class: " + str, th2);
                cls = null;
            }
            if (cls != null) {
                try {
                    createWorker = (ListenableWorker) cls.getDeclaredConstructor(new Class[]{Context.class, WorkerParameters.class}).newInstance(new Object[]{context, workerParameters});
                } catch (Throwable th3) {
                    Logger logger2 = Logger.get();
                    String str3 = TAG;
                    logger2.error(str3, "Could not instantiate " + str, th3);
                }
            }
        }
        if (createWorker == null || !createWorker.isUsed()) {
            return createWorker;
        }
        throw new IllegalStateException(String.format("WorkerFactory (%s) returned an instance of a ListenableWorker (%s) which has already been invoked. createWorker() must always return a new instance of a ListenableWorker.", new Object[]{getClass().getName(), str}));
    }
}
