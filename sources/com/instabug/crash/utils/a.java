package com.instabug.crash.utils;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.WorkerThread;
import com.instabug.crash.CrashReporting;
import com.instabug.crash.cache.b;
import com.instabug.library.Instabug;
import com.instabug.library.diagnostics.IBGDiagnostics;
import com.instabug.library.internal.storage.DiskUtils;
import com.instabug.library.internal.storage.cache.AttachmentsDbHelper;
import com.instabug.library.internal.storage.operation.DeleteUriDiskOperation;
import com.instabug.library.model.Attachment;
import com.instabug.library.util.FileUtils;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.threading.PoolProvider;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public abstract class a {
    public static synchronized void a() {
        boolean z11;
        synchronized (a.class) {
            List<File> stateFiles = FileUtils.getStateFiles("files:anr_state:");
            if (!stateFiles.isEmpty()) {
                InstabugSDKLogger.v("IBG-CR", "Found " + stateFiles.size() + " stale ANR state files on disk, cleaning ...");
                List a11 = com.instabug.anr.cache.a.a();
                for (File next : stateFiles) {
                    try {
                        Iterator it = a11.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z11 = false;
                                break;
                            }
                            String str = (String) it.next();
                            if (str != null) {
                                z11 = true;
                                if (str.contains(next.getName().substring(next.getName().indexOf(CrashReporting.ANR_STATE) + 9 + 1))) {
                                    break;
                                }
                            }
                        }
                        if (!z11) {
                            if (next.delete()) {
                                InstabugSDKLogger.v("IBG-CR", "file " + next.getName() + " is deleted");
                            } else {
                                InstabugSDKLogger.v("IBG-CR", "file " + next.getName() + " is not deleted");
                            }
                        }
                    } catch (Exception e11) {
                        InstabugSDKLogger.e("IBG-CR", "Error: " + e11.getMessage() + " while cleaning stale ANR state files");
                        IBGDiagnostics.reportNonFatal(e11, "can't clean Stale ANR State Files");
                    }
                }
            }
        }
    }

    @WorkerThread
    public static synchronized void b() {
        boolean z11;
        synchronized (a.class) {
            List<File> stateFiles = FileUtils.getStateFiles("files:crash_state:");
            if (!stateFiles.isEmpty()) {
                InstabugSDKLogger.v("IBG-CR", "Found " + stateFiles.size() + " stale crash state files on disk, cleaning ...");
                List c11 = b.c();
                for (File next : stateFiles) {
                    try {
                        Iterator it = c11.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z11 = false;
                                break;
                            }
                            z11 = true;
                            if (((String) it.next()).contains(next.getName().substring(next.getName().indexOf("crash_state") + 11 + 1))) {
                                break;
                            }
                        }
                        if (!z11) {
                            if (next.delete()) {
                                InstabugSDKLogger.v("IBG-CR", "file " + next.getName() + " is deleted");
                            } else {
                                InstabugSDKLogger.v("IBG-CR", "file " + next.getName() + " is not deleted");
                            }
                        }
                    } catch (Exception e11) {
                        InstabugSDKLogger.e("IBG-CR", "Error: " + e11.getMessage() + " while cleaning stale ANR state files");
                        IBGDiagnostics.reportNonFatal(e11, "can't clean Stale Crashes State Files");
                    }
                }
            }
        }
    }

    public static synchronized void c() {
        synchronized (a.class) {
            PoolProvider.postIOTask(new hc.a());
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void d() {
        if (Instabug.getApplicationContext() != null) {
            List a11 = b.a(Instabug.getApplicationContext());
            while (a11.size() > 0) {
                com.instabug.crash.models.a aVar = (com.instabug.crash.models.a) a11.get(0);
                if (!(aVar.h() == null || aVar.h().getUri() == null)) {
                    a(aVar.h().getUri());
                }
                a(aVar);
                if (aVar.e() != null) {
                    b.a(aVar.e());
                }
                a11.remove(0);
            }
        }
    }

    @WorkerThread
    public static synchronized void a(Uri uri) {
        synchronized (a.class) {
            Context applicationContext = Instabug.getApplicationContext();
            if (applicationContext != null) {
                try {
                    DiskUtils.with(applicationContext).deleteOperation(new DeleteUriDiskOperation(uri)).execute();
                } catch (Exception | OutOfMemoryError e11) {
                    IBGDiagnostics.reportNonFatal(e11, "crash state file couldn't be removed");
                }
            }
        }
        return;
    }

    @WorkerThread
    public static synchronized void a(com.instabug.crash.models.a aVar) {
        synchronized (a.class) {
            for (Attachment attachment : aVar.a()) {
                if (!(attachment.getLocalPath() == null || attachment.getName() == null)) {
                    new File(attachment.getLocalPath()).delete();
                    if (attachment.getId() != -1) {
                        AttachmentsDbHelper.delete(attachment.getId());
                    } else if (aVar.e() != null) {
                        AttachmentsDbHelper.delete(attachment.getName(), aVar.e());
                    } else {
                        InstabugSDKLogger.e("CrashCleanupUtils", "Couldn't delete attachments: crash.getId() is null");
                    }
                }
            }
        }
    }
}
