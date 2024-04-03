package com.google.firebase.appindexing.internal;

import android.util.Log;
import com.google.firebase.appindexing.FirebaseAppIndex;

public final class zzw {
    public static int zza(String str) {
        if (zzb(3)) {
            return Log.d(FirebaseAppIndex.APP_INDEXING_API_TAG, str);
        }
        return 0;
    }

    public static boolean zzb(int i11) {
        if (Log.isLoggable(FirebaseAppIndex.APP_INDEXING_API_TAG, i11)) {
            return true;
        }
        return Log.isLoggable(FirebaseAppIndex.APP_INDEXING_API_TAG, i11);
    }
}
