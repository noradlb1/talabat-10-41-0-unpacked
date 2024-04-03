package com.instabug.library.internal.utils.stability.handler.penalty;

import androidx.annotation.NonNull;
import com.instabug.library.util.InstabugSDKLogger;

public class b implements PenaltyHandler {
    public b(@NonNull String str) {
    }

    public int getPenaltyType() {
        return 1;
    }

    public void handle(@NonNull Exception exc) {
        InstabugSDKLogger.e("IBG-Core", exc.getClass().getSimpleName(), exc);
    }
}
