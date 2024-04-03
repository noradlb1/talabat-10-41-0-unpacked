package com.instabug.library.internal.storage.cache.db.migrations;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.NonNull;
import com.instabug.library.Instabug;
import com.instabug.library.internal.storage.AttachmentManager;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.util.InstabugSDKLogger;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.io.File;

@Instrumented
public class j implements c {
    private void b(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            InstabugSDKLogger.d("IBG-Core", "clearBugsAndCrashesTables");
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.CrashEntry.DELETE_ALL);
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.BugEntry.DELETE_ALL);
        }
    }

    public void a(SQLiteDatabase sQLiteDatabase) {
        InstabugSDKLogger.d("IBG-Core", "migration 20_21");
        if (Instabug.getApplicationContext() != null) {
            b(sQLiteDatabase);
            a(Instabug.getApplicationContext());
        }
    }

    private void a(@NonNull Context context) {
        InstabugSDKLogger.d("IBG-Core", "clearInstabugAttachmentDirectory started");
        File attachmentDirectory = AttachmentManager.getAttachmentDirectory(context);
        if (attachmentDirectory != null) {
            AttachmentManager.deleteRecursive(attachmentDirectory);
            InstabugSDKLogger.d("IBG-Core", "clearInstabugAttachmentDirectory finished");
        }
    }
}
