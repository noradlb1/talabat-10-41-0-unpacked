package com.huawei.location.lite.common.log;

import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import java.text.SimpleDateFormat;
import java.util.Locale;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class FB {
    private int FB;
    private long LW = 0;
    private String Vw = "Location";
    private boolean dC;

    /* renamed from: yn  reason: collision with root package name */
    private final StringBuilder f50146yn = new StringBuilder();

    public FB(int i11, String str, boolean z11) {
        this.FB = i11;
        if (str != null) {
            this.Vw = str;
        }
        this.LW = System.currentTimeMillis();
        this.dC = z11;
    }

    public String Vw() {
        StringBuilder sb2 = new StringBuilder();
        yn(sb2);
        return sb2.toString();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        yn(sb2);
        sb2.append(' ');
        sb2.append(this.f50146yn.toString());
        return sb2.toString();
    }

    public <T> FB yn(T t11) {
        this.f50146yn.append(t11);
        return this;
    }

    public String yn() {
        return ' ' + this.f50146yn.toString();
    }

    private StringBuilder yn(StringBuilder sb2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault());
        sb2.append('[');
        sb2.append(simpleDateFormat.format(Long.valueOf(this.LW)));
        sb2.append(' ');
        int i11 = this.FB;
        sb2.append(i11 != 3 ? i11 != 4 ? i11 != 5 ? i11 != 6 ? String.valueOf(i11) : ExifInterface.LONGITUDE_EAST : ExifInterface.LONGITUDE_WEST : "I" : "D");
        sb2.append('/');
        sb2.append(this.Vw);
        sb2.append(AbstractJsonLexerKt.END_LIST);
        if (!this.dC) {
            sb2.append("[m]");
        }
        return sb2;
    }

    public FB yn(Throwable th2) {
        this.f50146yn.append(10);
        this.f50146yn.append(Log.getStackTraceString(th2));
        return this;
    }
}
