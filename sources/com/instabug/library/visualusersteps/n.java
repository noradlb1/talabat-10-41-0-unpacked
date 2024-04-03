package com.instabug.library.visualusersteps;

import android.content.Context;
import com.instabug.library.Instabug;
import com.instabug.library.util.InstabugSDKLogger;
import java.io.File;
import java.util.concurrent.Callable;

class n implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String[] f52177b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ p f52178c;

    public n(p pVar, String[] strArr) {
        this.f52178c = pVar;
        this.f52177b = strArr;
    }

    /* renamed from: a */
    public Boolean call() {
        Context applicationContext = Instabug.getApplicationContext();
        if (applicationContext != null) {
            File visualUserStepsDirectory = VisualUserStepsHelper.getVisualUserStepsDirectory(applicationContext);
            if (visualUserStepsDirectory.exists()) {
                String[] list = visualUserStepsDirectory.list();
                if (list != null) {
                    for (String f11 : list) {
                        boolean unused = this.f52178c.a(f11);
                    }
                }
                if (visualUserStepsDirectory.delete()) {
                    this.f52177b[0] = "VisualUserStep screenshot directory {" + visualUserStepsDirectory + "} deleted";
                    InstabugSDKLogger.v("IBG-Core", this.f52177b[0]);
                    return Boolean.TRUE;
                }
                this.f52177b[0] = "Couldn't delete directory " + visualUserStepsDirectory + ". Something went wrong";
            } else {
                this.f52177b[0] = "Couldn't execute deleteFile(). Directory does not exist";
            }
        } else {
            this.f52177b[0] = "Couldn't execute deleteFile(). Context is null";
        }
        return Boolean.FALSE;
    }
}
