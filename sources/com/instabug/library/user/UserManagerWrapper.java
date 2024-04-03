package com.instabug.library.user;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.library.internal.storage.cache.db.InstabugDBInsertionListener;

public class UserManagerWrapper {
    @Nullable
    public static String getEmailForBugReport() {
        return f.e();
    }

    @NonNull
    public static String getIdentifiedUserEmail() {
        return f.h();
    }

    public static void getUUIDAsync(@NonNull InstabugDBInsertionListener<String> instabugDBInsertionListener) {
        f.a((InstabugDBInsertionListener) instabugDBInsertionListener);
    }

    public static String getUserEmail() {
        return f.n();
    }

    public static String getUserName() {
        return f.o();
    }

    public static String getUserUUID() {
        return f.k();
    }
}
