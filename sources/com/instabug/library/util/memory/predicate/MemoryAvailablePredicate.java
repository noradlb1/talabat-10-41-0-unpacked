package com.instabug.library.util.memory.predicate;

import android.content.Context;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.memory.MemoryUtils;

public abstract class MemoryAvailablePredicate extends Predicate {
    public boolean b(long j11) {
        Context a11 = a();
        if (a11 == null) {
            InstabugSDKLogger.w("MemoryAvailablePredicate", "isMemoryAvailable is returning false due to a null context reference");
            return false;
        } else if (j11 < MemoryUtils.getFreeMemory(a11)) {
            return true;
        } else {
            return false;
        }
    }
}
