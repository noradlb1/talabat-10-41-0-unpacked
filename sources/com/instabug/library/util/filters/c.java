package com.instabug.library.util.filters;

import android.annotation.SuppressLint;
import android.util.Pair;
import com.instabug.library.internal.storage.cache.db.userAttribute.UserAttributeCacheManager;

class c implements Filter {
    @SuppressLint({"ERADICATE_RETURN_NOT_NULLABLE"})
    /* renamed from: a */
    public Pair apply(Pair pair) {
        if (UserAttributeCacheManager.getType((String) pair.first) == 1) {
            return null;
        }
        return pair;
    }
}
