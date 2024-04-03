package com.instabug.library.internal.storage.executor;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import com.instabug.library.internal.storage.operation.DiskOperation;
import com.instabug.library.internal.storage.operation.DiskOperationCallback;
import java.io.IOException;

public class ReadOperationExecutor {
    private final DiskOperation<String, Void> operation;

    public ReadOperationExecutor(@NonNull DiskOperation<String, Void> diskOperation) {
        this.operation = diskOperation;
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public String execute() throws IOException {
        return this.operation.execute(null);
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public void executeAsync(DiskOperationCallback<String> diskOperationCallback) {
        this.operation.executeAsync(null, diskOperationCallback);
    }
}
