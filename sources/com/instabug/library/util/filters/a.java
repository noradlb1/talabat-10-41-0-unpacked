package com.instabug.library.util.filters;

import android.annotation.SuppressLint;
import com.instabug.library.internal.storage.cache.db.userAttribute.UserAttributeCacheManager;

class a implements Filter {
    @SuppressLint({"ERADICATE_RETURN_NOT_NULLABLE"})
    /* renamed from: a */
    public String apply(String str) {
        if (UserAttributeCacheManager.getType(str) == 1) {
            return null;
        }
        return str;
    }
}
