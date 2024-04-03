package com.uxcam.internals;

public class by {
    public static String a() {
        String str;
        int i11 = gm.f13452a;
        StringBuilder sb2 = new StringBuilder();
        try {
            str = ia.f13617c.getFilesDir().getPath();
        } catch (Exception unused) {
            gu.a("tag").getClass();
            str = null;
        }
        sb2.append(str);
        sb2.append("/");
        sb2.append("UXCam");
        return sb2.toString();
    }

    public static String b() {
        int i11 = gm.f13452a;
        return "video.mp4";
    }

    public static String c() {
        return a() + "/" + gm.f13453b + "/";
    }

    public static String d() {
        return gm.C ? "data.zip" : "data.txt";
    }

    public static boolean a(String str) {
        return str.startsWith("video") || str.startsWith("screen");
    }
}
