package com.adyen.checkout.ui.internal.common.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class Operation<I, O> {
    private final Throwable mError;
    private final I mInput;
    private final O mOutput;
    private final boolean mRunning;

    public interface Listener<I, O> {
        void onComplete(@NonNull I i11, @NonNull O o11);

        void onError(@NonNull I i11, @Nullable O o11, @NonNull Throwable th2);

        void onRunning(@NonNull I i11);
    }

    public static abstract class SimpleListener<I, O> implements Listener<I, O> {
        public void onComplete(@NonNull I i11, @NonNull O o11) {
        }

        public void onError(@NonNull I i11, @Nullable O o11, @NonNull Throwable th2) {
        }

        public void onRunning(@NonNull I i11) {
        }
    }

    private Operation(@NonNull I i11, @Nullable O o11, boolean z11, @Nullable Throwable th2) {
        this.mInput = i11;
        this.mOutput = o11;
        this.mRunning = z11;
        this.mError = th2;
    }

    @NonNull
    public static <I, O> Operation<I, O> complete(@NonNull I i11, @NonNull O o11) {
        return new Operation<>(i11, o11, false, (Throwable) null);
    }

    @NonNull
    public static <I, O> Operation<I, O> error(@NonNull I i11, @Nullable O o11, @NonNull Throwable th2) {
        return new Operation<>(i11, o11, false, th2);
    }

    @NonNull
    public static <I, O> Operation<I, O> running(@NonNull I i11) {
        return new Operation<>(i11, (Object) null, true, (Throwable) null);
    }

    public void dispatchCurrentState(@NonNull Listener<I, O> listener) {
        if (this.mRunning) {
            listener.onRunning(this.mInput);
            return;
        }
        O o11 = this.mOutput;
        if (o11 == null || this.mError != null) {
            Throwable th2 = this.mError;
            if (th2 != null) {
                listener.onError(this.mInput, o11, th2);
                return;
            }
            throw new IllegalStateException("Operation is in unknown state.");
        }
        listener.onComplete(this.mInput, o11);
    }

    @Nullable
    public Throwable getError() {
        return this.mError;
    }

    @NonNull
    public I getInput() {
        return this.mInput;
    }

    @Nullable
    public O getOutput() {
        return this.mOutput;
    }

    public boolean isRunning() {
        return this.mRunning;
    }
}
