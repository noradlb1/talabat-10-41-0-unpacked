package com.instabug.library.internal.storage.executor;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.instabug.library.internal.storage.operation.DiskOperation;
import com.instabug.library.internal.storage.operation.DiskOperationCallback;
import java.io.IOException;

public class WriteOperationExecutor {
    private final Context context;
    private final DiskOperation<Uri, Context> operation;

    public WriteOperationExecutor(@NonNull Context context2, DiskOperation<Uri, Context> diskOperation) {
        this.context = context2;
        this.operation = diskOperation;
    }

    public Uri execute() throws IOException {
        return this.operation.execute(this.context);
    }

    public void executeAsync(DiskOperationCallback<Uri> diskOperationCallback) {
        this.operation.executeAsync(this.context, diskOperationCallback);
    }
}
