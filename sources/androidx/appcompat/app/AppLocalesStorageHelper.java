package androidx.appcompat.app;

import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.util.Xml;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDelegate;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;
import org.xmlpull.v1.XmlSerializer;

class AppLocalesStorageHelper {

    public static class SerialExecutor implements Executor {

        /* renamed from: b  reason: collision with root package name */
        public final Queue<Runnable> f603b = new ArrayDeque();

        /* renamed from: c  reason: collision with root package name */
        public final Executor f604c;

        /* renamed from: d  reason: collision with root package name */
        public Runnable f605d;
        private final Object mLock = new Object();

        public SerialExecutor(Executor executor) {
            this.f604c = executor;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$execute$0(Runnable runnable) {
            try {
                runnable.run();
            } finally {
                b();
            }
        }

        public void b() {
            synchronized (this.mLock) {
                Runnable poll = this.f603b.poll();
                this.f605d = poll;
                if (poll != null) {
                    this.f604c.execute(poll);
                }
            }
        }

        public void execute(Runnable runnable) {
            synchronized (this.mLock) {
                this.f603b.add(new c(this, runnable));
                if (this.f605d == null) {
                    b();
                }
            }
        }
    }

    public static class ThreadPerTaskExecutor implements Executor {
        public void execute(Runnable runnable) {
            new Thread(runnable).start();
        }
    }

    private AppLocalesStorageHelper() {
    }

    public static void a(@NonNull Context context, @NonNull String str) {
        if (str.equals("")) {
            context.deleteFile("androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");
            return;
        }
        try {
            FileOutputStream openFileOutput = context.openFileOutput("androidx.appcompat.app.AppCompatDelegate.application_locales_record_file", 0);
            XmlSerializer newSerializer = Xml.newSerializer();
            try {
                newSerializer.setOutput(openFileOutput, (String) null);
                newSerializer.startDocument("UTF-8", Boolean.TRUE);
                newSerializer.startTag((String) null, "locales");
                newSerializer.attribute((String) null, "application_locales", str);
                newSerializer.endTag((String) null, "locales");
                newSerializer.endDocument();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Storing App Locales : app-locales: ");
                sb2.append(str);
                sb2.append(" persisted successfully.");
                if (openFileOutput == null) {
                    return;
                }
            } catch (Exception e11) {
                Log.w("AppLocalesStorageHelper", "Storing App Locales : Failed to persist app-locales: " + str, e11);
                if (openFileOutput == null) {
                    return;
                }
            } catch (Throwable th2) {
                if (openFileOutput != null) {
                    try {
                        openFileOutput.close();
                    } catch (IOException unused) {
                    }
                }
                throw th2;
            }
            try {
                openFileOutput.close();
            } catch (IOException unused2) {
            }
        } catch (FileNotFoundException unused3) {
            Log.w("AppLocalesStorageHelper", String.format("Storing App Locales : FileNotFoundException: Cannot open file %s for writing ", new Object[]{"androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"}));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0041, code lost:
        if (r3 != null) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x004e, code lost:
        if (r3 == null) goto L_0x0051;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String b(@androidx.annotation.NonNull android.content.Context r9) {
        /*
            java.lang.String r0 = "AppLocalesStorageHelper"
            java.lang.String r1 = "androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"
            java.lang.String r2 = ""
            java.io.FileInputStream r3 = r9.openFileInput(r1)     // Catch:{ FileNotFoundException -> 0x006f }
            org.xmlpull.v1.XmlPullParser r4 = android.util.Xml.newPullParser()     // Catch:{ IOException | XmlPullParserException -> 0x0049 }
            java.lang.String r5 = "UTF-8"
            r4.setInput(r3, r5)     // Catch:{ IOException | XmlPullParserException -> 0x0049 }
            int r5 = r4.getDepth()     // Catch:{ IOException | XmlPullParserException -> 0x0049 }
        L_0x0017:
            int r6 = r4.next()     // Catch:{ IOException | XmlPullParserException -> 0x0049 }
            r7 = 1
            if (r6 == r7) goto L_0x0041
            r7 = 3
            if (r6 != r7) goto L_0x0027
            int r8 = r4.getDepth()     // Catch:{ IOException | XmlPullParserException -> 0x0049 }
            if (r8 <= r5) goto L_0x0041
        L_0x0027:
            if (r6 == r7) goto L_0x0017
            r7 = 4
            if (r6 != r7) goto L_0x002d
            goto L_0x0017
        L_0x002d:
            java.lang.String r6 = r4.getName()     // Catch:{ IOException | XmlPullParserException -> 0x0049 }
            java.lang.String r7 = "locales"
            boolean r6 = r6.equals(r7)     // Catch:{ IOException | XmlPullParserException -> 0x0049 }
            if (r6 == 0) goto L_0x0017
            java.lang.String r5 = "application_locales"
            r6 = 0
            java.lang.String r0 = r4.getAttributeValue(r6, r5)     // Catch:{ IOException | XmlPullParserException -> 0x0049 }
            r2 = r0
        L_0x0041:
            if (r3 == 0) goto L_0x0051
        L_0x0043:
            r3.close()     // Catch:{ IOException -> 0x0051 }
            goto L_0x0051
        L_0x0047:
            r9 = move-exception
            goto L_0x0069
        L_0x0049:
            java.lang.String r4 = "Reading app Locales : Unable to parse through file :androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"
            android.util.Log.w(r0, r4)     // Catch:{ all -> 0x0047 }
            if (r3 == 0) goto L_0x0051
            goto L_0x0043
        L_0x0051:
            boolean r0 = r2.isEmpty()
            if (r0 != 0) goto L_0x0065
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r0 = "Reading app Locales : Locales read from file: androidx.appcompat.app.AppCompatDelegate.application_locales_record_file , appLocales: "
            r9.append(r0)
            r9.append(r2)
            goto L_0x0068
        L_0x0065:
            r9.deleteFile(r1)
        L_0x0068:
            return r2
        L_0x0069:
            if (r3 == 0) goto L_0x006e
            r3.close()     // Catch:{ IOException -> 0x006e }
        L_0x006e:
            throw r9
        L_0x006f:
            java.lang.String r9 = "Reading app Locales : Locales record file not found: androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"
            android.util.Log.w(r0, r9)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppLocalesStorageHelper.b(android.content.Context):java.lang.String");
    }

    public static void c(Context context) {
        if (Build.VERSION.SDK_INT >= 33) {
            ComponentName componentName = new ComponentName(context, "androidx.appcompat.app.AppLocalesMetadataHolderService");
            if (context.getPackageManager().getComponentEnabledSetting(componentName) != 1) {
                if (AppCompatDelegate.getApplicationLocales().isEmpty()) {
                    String b11 = b(context);
                    Object systemService = context.getSystemService("locale");
                    if (systemService != null) {
                        AppCompatDelegate.Api33Impl.b(systemService, AppCompatDelegate.Api24Impl.a(b11));
                    }
                }
                context.getPackageManager().setComponentEnabledSetting(componentName, 1, 1);
            }
        }
    }
}
