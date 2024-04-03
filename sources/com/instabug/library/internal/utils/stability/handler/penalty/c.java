package com.instabug.library.internal.utils.stability.handler.penalty;

import androidx.annotation.NonNull;

public class c implements PenaltyHandler {
    public int getPenaltyType() {
        return 0;
    }

    public void handle(@NonNull Exception exc) {
    }
}
