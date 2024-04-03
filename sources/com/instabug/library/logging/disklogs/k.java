package com.instabug.library.logging.disklogs;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.library.internal.orchestrator.ActionsOrchestrator;
import com.instabug.library.internal.storage.operation.DiskOperation;
import com.instabug.library.internal.storage.operation.DiskOperationCallback;
import com.instabug.library.util.memory.MemoryGuard;
import com.instabug.library.util.memory.MemoryUtils;
import com.instabug.library.util.memory.predicate.MemoryNotLowPredicate;
import com.instabug.library.util.memory.predicate.StringMemoryAvailablePredicate;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class k implements DiskOperation {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final File f51486a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public String f51487b;

    public k(@NonNull File file, @NonNull String str) {
        this.f51486a = file;
        this.f51487b = str;
    }

    /* renamed from: a */
    public Uri execute(@Nullable Context context) throws IOException {
        try {
            a(this.f51487b, context);
        } catch (IOException e11) {
            Log.e("IBG-Core", "Error while writing logsto disk: ", e11);
        }
        return Uri.fromFile(this.f51486a);
    }

    /* renamed from: a */
    public void executeAsync(Context context, @Nullable DiskOperationCallback diskOperationCallback) {
        ActionsOrchestrator.obtainOrchestrator().addWorkerThreadAction(new i(this, context, diskOperationCallback)).orchestrate();
    }

    /* access modifiers changed from: private */
    public void a(String str, @Nullable Context context) throws IOException {
        if (context == null) {
            Log.e("IBG-Core", "Couldn't write logs to disk due to null context");
        } else if (!MemoryUtils.isLowMemory(context)) {
            FileOutputStream fileOutputStream = new FileOutputStream(this.f51486a, true);
            try {
                MemoryGuard.from(context).withPredicates(new MemoryNotLowPredicate(), new StringMemoryAvailablePredicate(str)).forOperation("writing logs file").doAction(new j(this, str, fileOutputStream));
            } finally {
                fileOutputStream.close();
            }
        } else {
            Log.e("IBG-Core", "Couldn't write logs to disk due to low memory");
        }
    }
}
