package com.instabug.library.internal.storage.cache.user;

import androidx.annotation.NonNull;
import com.instabug.library.Feature;
import com.instabug.library.e0;
import com.instabug.library.model.j;

public class UserCacheManager {
    private static long getLastSeen(@NonNull String str) {
        j a11 = a.a(str);
        if (a11 != null) {
            return a11.a();
        }
        return 0;
    }

    public static int getUserSessionCount(@NonNull String str) {
        j a11 = a.a(str);
        if (a11 != null) {
            return a11.b();
        }
        return 0;
    }

    public static void insertIfNotExists(String str, int i11) {
        if (a.a(str) == null && e0.c().b((Object) Feature.INSTABUG) == Feature.State.ENABLED) {
            insertUser(str, i11);
        }
    }

    public static void insertUser(@NonNull String str, int i11) {
        a.a(new j(str, i11, getLastSeen(str)));
    }

    public static void updateLastSeen(@NonNull String str, long j11) {
        a.b(new j(str, getUserSessionCount(str), j11));
    }

    public static void updateSessionCount(@NonNull String str, int i11) {
        a.b(new j(str, i11, getLastSeen(str)));
    }
}
