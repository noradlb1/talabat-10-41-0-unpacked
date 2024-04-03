package com.google.firebase.appindexing;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.firebase.appindexing.internal.zzp;
import java.lang.ref.WeakReference;
import javax.annotation.concurrent.GuardedBy;

public abstract class FirebaseAppIndex {
    @NonNull
    public static final String ACTION_UPDATE_INDEX = "com.google.firebase.appindexing.UPDATE_INDEX";
    @NonNull
    public static final String APP_INDEXING_API_TAG = "FirebaseAppIndex";
    @NonNull
    public static final String EXTRA_UPDATE_INDEX_REASON = "com.google.firebase.appindexing.extra.REASON";
    public static final int EXTRA_UPDATE_INDEX_REASON_REBUILD = 1;
    public static final int EXTRA_UPDATE_INDEX_REASON_REFRESH = 2;
    @GuardedBy("FirebaseAppIndex.class")
    private static WeakReference<FirebaseAppIndex> zza;

    @NonNull
    public static synchronized FirebaseAppIndex getInstance(@NonNull Context context) {
        FirebaseAppIndex firebaseAppIndex;
        synchronized (FirebaseAppIndex.class) {
            Preconditions.checkNotNull(context);
            WeakReference<FirebaseAppIndex> weakReference = zza;
            if (weakReference == null) {
                firebaseAppIndex = null;
            } else {
                firebaseAppIndex = weakReference.get();
            }
            if (firebaseAppIndex != null) {
                return firebaseAppIndex;
            }
            zzp zzp = new zzp(context.getApplicationContext());
            zza = new WeakReference<>(zzp);
            return zzp;
        }
    }

    @NonNull
    public abstract Task<Void> remove(@NonNull String... strArr);

    @NonNull
    public abstract Task<Void> removeAll();

    @NonNull
    public abstract Task<Void> update(@NonNull Indexable... indexableArr);
}
