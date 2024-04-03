package com.instabug.library.util.filters;

import android.util.Pair;
import com.instabug.library.internal.storage.cache.db.userAttribute.UserAttributeCacheManager;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.StringUtility;
import com.instabug.library.util.filters.actions.a;

class e implements a {
    /* renamed from: a */
    public void apply(Pair pair) {
        if (pair != null) {
            Object obj = pair.second;
            if (obj == null) {
                InstabugSDKLogger.e("IBG-Core", "Passed null value to UserAttribute key: " + ((String) pair.first) + ".Ignoring this attribute.");
                return;
            }
            UserAttributeCacheManager.insert((String) pair.first, StringUtility.trimString((String) obj));
        }
    }
}
