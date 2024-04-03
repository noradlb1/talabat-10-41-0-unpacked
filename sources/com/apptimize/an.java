package com.apptimize;

import android.content.Context;
import android.os.Process;
import android.os.StrictMode;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public abstract class an {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f41194a = "an";

    public static class a extends an {

        /* renamed from: a  reason: collision with root package name */
        private final File f41195a;

        /* renamed from: b  reason: collision with root package name */
        private FileOutputStream f41196b;

        /* renamed from: c  reason: collision with root package name */
        private int f41197c = 0;

        public a(Context context, String str) {
            StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
            try {
                this.f41195a = new File(context.getFilesDir(), str);
            } finally {
                StrictMode.setThreadPolicy(allowThreadDiskWrites);
            }
        }

        public void a() throws IOException {
            if (this.f41196b != null) {
                this.f41197c++;
                return;
            }
            StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.f41195a);
                this.f41196b = fileOutputStream;
                fileOutputStream.getChannel().lock();
                new OutputStreamWriter(this.f41196b).write(String.valueOf(Process.myPid()));
            } finally {
                StrictMode.setThreadPolicy(allowThreadDiskWrites);
            }
        }

        public void b() throws IOException {
            if (this.f41196b == null) {
                bo.b(an.f41194a, "Process lock released when not acquired");
                return;
            }
            int i11 = this.f41197c;
            if (i11 > 0) {
                this.f41197c = i11 - 1;
                return;
            }
            StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
            try {
                this.f41196b.close();
                this.f41196b = null;
            } finally {
                StrictMode.setThreadPolicy(allowThreadDiskWrites);
            }
        }
    }

    public static class b extends an {
        public void a() {
        }

        public void b() {
        }
    }

    public abstract void a() throws IOException;

    public abstract void b() throws IOException;
}
