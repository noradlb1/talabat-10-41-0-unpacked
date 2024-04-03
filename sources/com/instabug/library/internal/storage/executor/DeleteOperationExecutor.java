package com.instabug.library.internal.storage.executor;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.library.internal.storage.operation.DiskOperation;
import com.instabug.library.internal.storage.operation.DiskOperationCallback;
import java.io.IOException;

public class DeleteOperationExecutor {
    private final DiskOperation<Boolean, Void> operation;

    public DeleteOperationExecutor(@NonNull DiskOperation<Boolean, Void> diskOperation) {
        this.operation = diskOperation;
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public boolean execute() throws IOException {
        return this.operation.execute(null).booleanValue();
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public void executeAsync(@Nullable DiskOperationCallback<Boolean> diskOperationCallback) {
        this.operation.executeAsync(null, diskOperationCallback);
    }
}
