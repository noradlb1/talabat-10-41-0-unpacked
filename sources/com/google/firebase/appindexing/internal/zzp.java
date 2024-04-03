package com.google.firebase.appindexing.internal;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.appindexing.FirebaseAppIndex;
import com.google.firebase.appindexing.FirebaseAppIndexingInvalidArgumentException;
import com.google.firebase.appindexing.Indexable;

public final class zzp extends FirebaseAppIndex {
    @VisibleForTesting
    final zzo zza;
    @NonNull
    private final GoogleApi<?> zzb;
    @NonNull
    private final Context zzc;

    public zzp(@NonNull Context context) {
        zzj zzj = new zzj(context);
        this.zzb = zzj;
        this.zzc = context;
        this.zza = new zzo(zzj);
    }

    public final Task<Void> remove(String... strArr) {
        return this.zza.zza(new zzz(3, (Thing[]) null, strArr, (String[]) null, (zzc) null, (String) null, (String) null));
    }

    public final Task<Void> removeAll() {
        return this.zza.zza(new zzz(4, (Thing[]) null, (String[]) null, (String[]) null, (zzc) null, (String) null, (String) null));
    }

    public final Task<Void> update(Indexable... indexableArr) {
        Thing[] thingArr;
        if (indexableArr == null) {
            thingArr = null;
        } else {
            try {
                int length = indexableArr.length;
                Thing[] thingArr2 = new Thing[length];
                System.arraycopy(indexableArr, 0, thingArr2, 0, length);
                thingArr = thingArr2;
            } catch (ArrayStoreException unused) {
                return Tasks.forException(new FirebaseAppIndexingInvalidArgumentException("Custom Indexable-objects are not allowed. Please use the 'Indexables'-class for creating the objects."));
            }
        }
        if (thingArr == null) {
            return Tasks.forException(new FirebaseAppIndexingInvalidArgumentException("Indexables cannot be null."));
        }
        return this.zza.zza(new zzz(1, thingArr, (String[]) null, (String[]) null, (zzc) null, (String) null, (String) null));
    }
}
