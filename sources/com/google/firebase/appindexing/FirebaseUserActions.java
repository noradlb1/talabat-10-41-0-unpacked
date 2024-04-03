package com.google.firebase.appindexing;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.firebase.appindexing.internal.zzt;
import java.lang.ref.WeakReference;
import javax.annotation.concurrent.GuardedBy;

public abstract class FirebaseUserActions {
    @NonNull
    public static final String APP_INDEXING_API_TAG = "FirebaseUserActions";
    @GuardedBy("FirebaseUserActions.class")
    private static WeakReference<FirebaseUserActions> zza;

    @NonNull
    public static synchronized FirebaseUserActions getInstance(@NonNull Context context) {
        FirebaseUserActions firebaseUserActions;
        synchronized (FirebaseUserActions.class) {
            Preconditions.checkNotNull(context);
            WeakReference<FirebaseUserActions> weakReference = zza;
            if (weakReference == null) {
                firebaseUserActions = null;
            } else {
                firebaseUserActions = weakReference.get();
            }
            if (firebaseUserActions != null) {
                return firebaseUserActions;
            }
            zzt zzt = new zzt(context.getApplicationContext());
            zza = new WeakReference<>(zzt);
            return zzt;
        }
    }

    @NonNull
    public abstract Task<Void> end(@NonNull Action action);

    @NonNull
    public abstract Task<Void> start(@NonNull Action action);
}
