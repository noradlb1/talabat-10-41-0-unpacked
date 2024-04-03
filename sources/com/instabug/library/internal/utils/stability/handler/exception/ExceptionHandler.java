package com.instabug.library.internal.utils.stability.handler.exception;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.library.internal.utils.stability.execution.Executable;
import com.instabug.library.internal.utils.stability.execution.ReturnableExecutable;
import com.instabug.library.internal.utils.stability.handler.penalty.PenaltyHandler;
import com.instabug.library.internal.utils.stability.handler.penalty.a;
import com.instabug.library.internal.utils.stability.handler.penalty.b;
import com.instabug.library.internal.utils.stability.handler.penalty.c;

public final class ExceptionHandler {
    private static final String TAG = "ExceptionHandler";
    @NonNull
    private PenaltyHandler penaltyHandler = new c();

    public void execute(@NonNull Executable executable) {
        try {
            executable.execute();
        } catch (Exception e11) {
            this.penaltyHandler.handle(e11);
        }
    }

    @Nullable
    public <T> T executeAndGet(@NonNull ReturnableExecutable<T> returnableExecutable) {
        try {
            return returnableExecutable.execute();
        } catch (Exception e11) {
            this.penaltyHandler.handle(e11);
            return null;
        }
    }

    @NonNull
    public ExceptionHandler withPenalty(@NonNull PenaltyHandler penaltyHandler2) {
        this.penaltyHandler = penaltyHandler2;
        return this;
    }

    @NonNull
    public ExceptionHandler withPenaltyDeath() {
        this.penaltyHandler = new a();
        return this;
    }

    @NonNull
    public ExceptionHandler withPenaltyLog() {
        this.penaltyHandler = new b(TAG);
        return this;
    }

    @NonNull
    public ExceptionHandler withPenaltySwallow() {
        this.penaltyHandler = new c();
        return this;
    }

    @NonNull
    public ExceptionHandler withPenaltyLog(@NonNull String str) {
        this.penaltyHandler = new b(str);
        return this;
    }

    @NonNull
    public <T> T executeAndGet(@NonNull ReturnableExecutable<T> returnableExecutable, @NonNull T t11) {
        try {
            T execute = returnableExecutable.execute();
            return execute != null ? execute : t11;
        } catch (Exception e11) {
            this.penaltyHandler.handle(e11);
            return t11;
        }
    }
}
