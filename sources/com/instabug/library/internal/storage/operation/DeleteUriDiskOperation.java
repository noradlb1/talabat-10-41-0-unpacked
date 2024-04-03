package com.instabug.library.internal.storage.operation;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.instabug.library.util.threading.PoolProvider;
import java.io.File;

public class DeleteUriDiskOperation implements DiskOperation<Boolean, Void> {
    private final Uri uri;

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ DiskOperationCallback f51112b;

        public a(DiskOperationCallback diskOperationCallback) {
            this.f51112b = diskOperationCallback;
        }

        public void run() {
            try {
                boolean a11 = DeleteUriDiskOperation.this.delete();
                DiskOperationCallback diskOperationCallback = this.f51112b;
                if (diskOperationCallback != null) {
                    diskOperationCallback.onSuccess(Boolean.valueOf(a11));
                }
            } catch (Throwable th2) {
                DiskOperationCallback diskOperationCallback2 = this.f51112b;
                if (diskOperationCallback2 != null) {
                    diskOperationCallback2.onFailure(th2);
                }
            }
        }
    }

    public DeleteUriDiskOperation(Uri uri2) {
        this.uri = uri2;
    }

    /* access modifiers changed from: private */
    public boolean delete() {
        Uri uri2 = this.uri;
        return (uri2 == null || uri2.getPath() == null || !new File(this.uri.getPath()).delete()) ? false : true;
    }

    public synchronized Boolean execute(@Nullable Void voidR) {
        return Boolean.valueOf(delete());
    }

    public void executeAsync(@Nullable Void voidR, @Nullable DiskOperationCallback<Boolean> diskOperationCallback) {
        PoolProvider.postIOTask(new a(diskOperationCallback));
    }
}
