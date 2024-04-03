package com.instabug.library.internal.video;

import com.instabug.library.internal.storage.AttachmentManager;
import com.instabug.library.util.InstabugSDKLogger;
import java.io.File;
import java.io.IOException;

class g implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f51225b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ h f51226c;

    public g(h hVar, int i11) {
        this.f51226c = hVar;
        this.f51225b = i11;
    }

    public void run() {
        File file = new File(this.f51226c.f51231e);
        try {
            File startTrim = InstabugVideoUtils.startTrim(file, AttachmentManager.getAutoScreenRecordingFile(this.f51226c.f51227a), this.f51225b);
            InstabugSDKLogger.v("IBG-Core", "Recorded video file size after trim: " + (startTrim.length() / 1024) + " KB");
            InternalAutoScreenRecorderHelper.getInstance().setAutoScreenRecordingFile(startTrim);
        } catch (IOException | IllegalArgumentException e11) {
            e11.printStackTrace();
            InternalAutoScreenRecorderHelper.getInstance().setAutoScreenRecordingFile(file);
        }
        this.f51226c.f51228b.b();
    }
}
