package com.instabug.library.logging.disklogs;

import android.util.Log;
import com.instabug.library.diagnostics.IBGDiagnostics;
import com.instabug.library.encryption.EncryptionManager;
import com.instabug.library.util.memory.Action;
import java.io.FileOutputStream;

class j implements Action {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f51484a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FileOutputStream f51485b;

    public j(k kVar, String str, FileOutputStream fileOutputStream) {
        this.f51484a = str;
        this.f51485b = fileOutputStream;
    }

    public void onAffirmed() throws Throwable {
        String encryptWithStaticKey = EncryptionManager.encryptWithStaticKey(this.f51484a);
        if (encryptWithStaticKey != null) {
            this.f51485b.write(encryptWithStaticKey.getBytes("UTF-8"));
            this.f51485b.write(EncryptionManager.LINE_FEED.getBytes("UTF-8"));
            return;
        }
        IBGDiagnostics.reportNonFatal(new Exception("Error writing logs exception"), "Couldn't write logs to file due to error in encryption");
    }

    public void onDenied() throws Throwable {
        Log.e("IBG-Core", "Couldn't write logs to disk due to low memory");
    }
}
