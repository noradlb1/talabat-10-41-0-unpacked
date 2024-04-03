package com.instabug.library.internal.utils.stability.handler.penalty;

import androidx.annotation.NonNull;

public interface PenaltyHandler {
    int getPenaltyType();

    void handle(@NonNull Exception exc);
}
