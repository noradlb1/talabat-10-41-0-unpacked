package com.instabug.library.internal.storage.operation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.threading.PoolProvider;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

public class WriteStateToFileDiskOperation implements DiskOperation<Uri, Context> {
    /* access modifiers changed from: private */
    public final File file;
    /* access modifiers changed from: private */
    public final String stringState;

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ DiskOperationCallback f51116b;

        public a(DiskOperationCallback diskOperationCallback) {
            this.f51116b = diskOperationCallback;
        }

        @SuppressLint({"RESOURCE_LEAK"})
        private void a() throws Throwable {
            if (!WriteStateToFileDiskOperation.this.file.createNewFile()) {
                InstabugSDKLogger.v("IBG-Core", "State file" + WriteStateToFileDiskOperation.this.file.getAbsolutePath() + "already exists");
            }
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(WriteStateToFileDiskOperation.this.file, false), Charset.forName("UTF8"));
            outputStreamWriter.write(WriteStateToFileDiskOperation.this.stringState);
            outputStreamWriter.close();
        }

        public void run() {
            try {
                a();
            } catch (Throwable th2) {
                InstabugSDKLogger.e("IBG-Core", "Error while writing state file" + th2.getMessage());
                if (this.f51116b != null) {
                    this.f51116b.onFailure(th2);
                }
            }
            DiskOperationCallback diskOperationCallback = this.f51116b;
            if (diskOperationCallback != null) {
                diskOperationCallback.onSuccess(Uri.fromFile(WriteStateToFileDiskOperation.this.file));
            }
        }
    }

    public WriteStateToFileDiskOperation(File file2, String str) {
        this.stringState = str;
        this.file = file2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0053 A[SYNTHETIC, Splitter:B:17:0x0053] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized android.net.Uri execute(android.content.Context r3) throws java.io.IOException {
        /*
            r2 = this;
            monitor-enter(r2)
            java.io.File r3 = r2.file     // Catch:{ all -> 0x0057 }
            boolean r3 = r3.createNewFile()     // Catch:{ all -> 0x0057 }
            if (r3 != 0) goto L_0x002a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0057 }
            r3.<init>()     // Catch:{ all -> 0x0057 }
            java.lang.String r0 = "State file: "
            r3.append(r0)     // Catch:{ all -> 0x0057 }
            java.io.File r0 = r2.file     // Catch:{ all -> 0x0057 }
            java.lang.String r0 = r0.getAbsolutePath()     // Catch:{ all -> 0x0057 }
            r3.append(r0)     // Catch:{ all -> 0x0057 }
            java.lang.String r0 = "already exists"
            r3.append(r0)     // Catch:{ all -> 0x0057 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0057 }
            java.lang.String r0 = "IBG-Core"
            com.instabug.library.util.InstabugSDKLogger.v(r0, r3)     // Catch:{ all -> 0x0057 }
        L_0x002a:
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ all -> 0x004f }
            java.io.File r0 = r2.file     // Catch:{ all -> 0x004f }
            r1 = 0
            r3.<init>(r0, r1)     // Catch:{ all -> 0x004f }
            java.io.OutputStreamWriter r0 = new java.io.OutputStreamWriter     // Catch:{ all -> 0x004f }
            java.lang.String r1 = "UTF8"
            java.nio.charset.Charset r1 = java.nio.charset.Charset.forName(r1)     // Catch:{ all -> 0x004f }
            r0.<init>(r3, r1)     // Catch:{ all -> 0x004f }
            java.lang.String r3 = r2.stringState     // Catch:{ all -> 0x004d }
            r0.write(r3)     // Catch:{ all -> 0x004d }
            r0.close()     // Catch:{ all -> 0x0057 }
            java.io.File r3 = r2.file     // Catch:{ all -> 0x0057 }
            android.net.Uri r3 = android.net.Uri.fromFile(r3)     // Catch:{ all -> 0x0057 }
            monitor-exit(r2)
            return r3
        L_0x004d:
            r3 = move-exception
            goto L_0x0051
        L_0x004f:
            r3 = move-exception
            r0 = 0
        L_0x0051:
            if (r0 == 0) goto L_0x0056
            r0.close()     // Catch:{ all -> 0x0057 }
        L_0x0056:
            throw r3     // Catch:{ all -> 0x0057 }
        L_0x0057:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.internal.storage.operation.WriteStateToFileDiskOperation.execute(android.content.Context):android.net.Uri");
    }

    public void executeAsync(Context context, @Nullable DiskOperationCallback<Uri> diskOperationCallback) {
        PoolProvider.postIOTask(new a(diskOperationCallback));
    }
}
