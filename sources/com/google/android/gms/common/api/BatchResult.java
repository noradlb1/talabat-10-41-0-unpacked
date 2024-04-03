package com.google.android.gms.common.api;

import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.util.concurrent.TimeUnit;

public final class BatchResult implements Result {
    private final Status zaa;
    private final PendingResult[] zab;

    public BatchResult(Status status, PendingResult[] pendingResultArr) {
        this.zaa = status;
        this.zab = pendingResultArr;
    }

    @NonNull
    public Status getStatus() {
        return this.zaa;
    }

    @ResultIgnorabilityUnspecified
    @NonNull
    public <R extends Result> R take(@NonNull BatchResultToken<R> batchResultToken) {
        boolean z11;
        if (batchResultToken.mId < this.zab.length) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11, "The result token does not belong to this batch");
        return this.zab[batchResultToken.mId].await(0, TimeUnit.MILLISECONDS);
    }
}
