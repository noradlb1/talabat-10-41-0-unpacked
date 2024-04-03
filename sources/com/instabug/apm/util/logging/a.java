package com.instabug.apm.util.logging;

import androidx.annotation.NonNull;
import com.instabug.library.internal.utils.stability.handler.penalty.PenaltyHandler;

public class a implements PenaltyHandler {

    /* renamed from: a  reason: collision with root package name */
    private final com.instabug.apm.logger.internal.a f45588a;

    public a(@NonNull com.instabug.apm.logger.internal.a aVar) {
        this.f45588a = aVar;
    }

    public int getPenaltyType() {
        return 1;
    }

    public void handle(@NonNull Exception exc) {
        this.f45588a.a(exc.getMessage() == null ? "An Exception has occurred" : exc.getMessage(), exc);
    }
}
