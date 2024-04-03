package com.instabug.library.util.filters;

import android.annotation.SuppressLint;
import com.instabug.library.internal.storage.cache.db.userAttribute.UserAttributeCacheManager;
import com.instabug.library.util.filters.actions.b;

class g implements b {
    @SuppressLint({"ERADICATE_RETURN_NOT_NULLABLE"})
    /* renamed from: a */
    public String apply(String str) {
        if (str == null) {
            return null;
        }
        return UserAttributeCacheManager.retrieve(str);
    }
}
