package com.huawei.hms.base.log;

import android.os.Process;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import java.text.SimpleDateFormat;
import java.util.Locale;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private final StringBuilder f48073a = new StringBuilder();

    /* renamed from: b  reason: collision with root package name */
    private String f48074b;

    /* renamed from: c  reason: collision with root package name */
    private String f48075c = "HMS";

    /* renamed from: d  reason: collision with root package name */
    private int f48076d;

    /* renamed from: e  reason: collision with root package name */
    private long f48077e = 0;

    /* renamed from: f  reason: collision with root package name */
    private long f48078f = 0;

    /* renamed from: g  reason: collision with root package name */
    private String f48079g;

    /* renamed from: h  reason: collision with root package name */
    private int f48080h;

    /* renamed from: i  reason: collision with root package name */
    private int f48081i;

    /* renamed from: j  reason: collision with root package name */
    private int f48082j;

    public e(int i11, String str, int i12, String str2) {
        this.f48082j = i11;
        this.f48074b = str;
        this.f48076d = i12;
        if (str2 != null) {
            this.f48075c = str2;
        }
        b();
    }

    public static String a(int i11) {
        if (i11 == 3) {
            return "D";
        }
        if (i11 == 4) {
            return "I";
        }
        if (i11 != 5) {
            return i11 != 6 ? String.valueOf(i11) : ExifInterface.LONGITUDE_EAST;
        }
        return ExifInterface.LONGITUDE_WEST;
    }

    private e b() {
        this.f48077e = System.currentTimeMillis();
        Thread currentThread = Thread.currentThread();
        this.f48078f = currentThread.getId();
        this.f48080h = Process.myPid();
        StackTraceElement[] stackTrace = currentThread.getStackTrace();
        int length = stackTrace.length;
        int i11 = this.f48082j;
        if (length > i11) {
            StackTraceElement stackTraceElement = stackTrace[i11];
            this.f48079g = stackTraceElement.getFileName();
            this.f48081i = stackTraceElement.getLineNumber();
        }
        return this;
    }

    public String c() {
        StringBuilder sb2 = new StringBuilder();
        b(sb2);
        return sb2.toString();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        b(sb2);
        a(sb2);
        return sb2.toString();
    }

    public <T> e a(T t11) {
        this.f48073a.append(t11);
        return this;
    }

    public e a(Throwable th2) {
        a(10).a(Log.getStackTraceString(th2));
        return this;
    }

    public String a() {
        StringBuilder sb2 = new StringBuilder();
        a(sb2);
        return sb2.toString();
    }

    private StringBuilder a(StringBuilder sb2) {
        sb2.append(' ');
        sb2.append(this.f48073a.toString());
        return sb2;
    }

    private StringBuilder b(StringBuilder sb2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault());
        sb2.append('[');
        sb2.append(simpleDateFormat.format(Long.valueOf(this.f48077e)));
        String a11 = a(this.f48076d);
        sb2.append(' ');
        sb2.append(a11);
        sb2.append('/');
        sb2.append(this.f48075c);
        sb2.append('/');
        sb2.append(this.f48074b);
        sb2.append(' ');
        sb2.append(this.f48080h);
        sb2.append(AbstractJsonLexerKt.COLON);
        sb2.append(this.f48078f);
        sb2.append(' ');
        sb2.append(this.f48079g);
        sb2.append(AbstractJsonLexerKt.COLON);
        sb2.append(this.f48081i);
        sb2.append(AbstractJsonLexerKt.END_LIST);
        return sb2;
    }
}
