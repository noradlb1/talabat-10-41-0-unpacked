package com.instabug.library.internal.utils.stability.handler.penalty;

import androidx.annotation.NonNull;

public class a implements PenaltyHandler {
    public int getPenaltyType() {
        return 2;
    }

    public void handle(@NonNull Exception exc) {
        throw new RuntimeException(exc);
    }
}
