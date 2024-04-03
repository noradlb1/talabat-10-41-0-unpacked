package com.instabug.library.util.memory.predicate;

import android.content.Context;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.memory.MemoryUtils;

public class MemoryNotLowPredicate extends Predicate {
    public boolean check() {
        Context a11 = a();
        if (a11 != null) {
            return !MemoryUtils.isLowMemory(a11);
        }
        InstabugSDKLogger.w("IBG-Core", "MemoryNotLow Predicate is returning false due to a null context reference");
        return false;
    }
}
