package com.instabug.library.invocation.invoker;

import android.content.Context;
import android.net.Uri;
import com.instabug.library.Instabug;
import com.instabug.library.internal.storage.AttachmentsUtility;
import com.instabug.library.util.InstabugSDKLogger;
import java.io.File;

class s implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f51395b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ t f51396c;

    public s(t tVar, String str) {
        this.f51396c = tVar;
        this.f51395b = str;
    }

    public void run() {
        Context applicationContext = Instabug.getApplicationContext();
        File file = new File(this.f51395b);
        InstabugSDKLogger.d("IBG-Core", "Creating new Uri for screenshot: " + file + " {" + file.getPath() + "}");
        Uri newFileAttachmentUri = AttachmentsUtility.getNewFileAttachmentUri(applicationContext, Uri.fromFile(file));
        if (this.f51396c.f51399c != null) {
            this.f51396c.f51399c.a(newFileAttachmentUri);
        }
    }
}
