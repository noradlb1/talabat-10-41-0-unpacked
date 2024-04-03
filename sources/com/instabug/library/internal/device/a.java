package com.instabug.library.internal.device;

import android.os.Build;
import com.instabug.library.util.InstabugSDKLogger;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;

public abstract class a {
    public static boolean a() {
        String str = Build.TAGS;
        if (str == null || !str.contains("test-keys")) {
            return false;
        }
        return true;
    }

    public static boolean b() {
        try {
            return new File("/system/app/Superuser.apk").exists();
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean c() {
        ArrayList arrayList = new ArrayList();
        try {
            Process exec = Runtime.getRuntime().exec(new String[]{"/system/xbin/which", "su"});
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream(), Charset.forName("UTF-8")));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    InstabugSDKLogger.v("IBG-Core", "SHELL --> Line received: " + readLine);
                    arrayList.add(readLine);
                } catch (Exception unused) {
                    exec.destroy();
                } catch (Throwable th2) {
                    exec.destroy();
                    try {
                        bufferedReader.close();
                    } catch (IOException unused2) {
                    }
                    throw th2;
                }
            }
            exec.destroy();
            try {
                bufferedReader.close();
            } catch (IOException unused3) {
            }
            InstabugSDKLogger.v("IBG-Core", "SHELL --> Full response was: " + arrayList);
            if (arrayList.size() != 0) {
                return true;
            }
            return false;
        } catch (Exception unused4) {
            return false;
        }
    }

    public static boolean d() {
        return a() || b() || c();
    }
}
