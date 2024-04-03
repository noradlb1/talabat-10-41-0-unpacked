package com.uxcam.internals;

import android.content.Context;
import java.io.File;

public class dc {

    /* renamed from: a  reason: collision with root package name */
    public Context f13188a;

    public dc(Context context) {
        this.f13188a = context;
    }

    public void a() {
        File file;
        try {
            File[] listFiles = new File(by.c()).listFiles(new db(this));
            if (listFiles == null || listFiles.length <= 0) {
                file = null;
            } else {
                file = listFiles[0];
            }
            if (file != null) {
                int i11 = gm.f13452a;
                new ae().b(this.f13188a, file);
            }
        } catch (Exception unused) {
            gu.a("dc").getClass();
        }
    }
}
