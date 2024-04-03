package com.instabug.apm.networkinterception.utils;

import androidx.annotation.Nullable;
import com.instabug.library.networkv2.BodyBufferHelper;
import com.instabug.library.util.InstabugSDKLogger;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Objects;
import vb.a;

public class c extends OutputStream {

    /* renamed from: a  reason: collision with root package name */
    private final OutputStream f45564a;

    /* renamed from: b  reason: collision with root package name */
    private final StringBuffer f45565b;

    /* renamed from: c  reason: collision with root package name */
    private Long f45566c = 0L;

    /* renamed from: d  reason: collision with root package name */
    private boolean f45567d;

    public c(OutputStream outputStream, boolean z11) {
        this.f45564a = outputStream;
        this.f45565b = new StringBuffer();
        this.f45567d = z11;
    }

    private void a(int i11) {
        if (c()) {
            BodyBufferHelper.clear(this.f45565b);
        } else {
            this.f45565b.append((char) i11);
        }
    }

    private void a(byte[] bArr) {
        if (c()) {
            BodyBufferHelper.clear(this.f45565b);
        } else {
            this.f45565b.append(new String(bArr, Charset.forName("UTF-8")).trim());
        }
    }

    private boolean c() {
        return this.f45567d || BodyBufferHelper.isBodySizeAllowed(this.f45566c.longValue());
    }

    @Nullable
    public String a() {
        try {
            boolean z11 = this.f45567d;
            long longValue = this.f45566c.longValue();
            StringBuffer stringBuffer = this.f45565b;
            Objects.requireNonNull(stringBuffer);
            return BodyBufferHelper.generateBodyMsg(z11, longValue, new a(stringBuffer));
        } catch (OutOfMemoryError e11) {
            InstabugSDKLogger.e("IBG-APM", e11.getMessage() != null ? e11.getMessage() : "Couldn't allocate enough memory to read request body", e11);
            return null;
        } catch (Exception e12) {
            InstabugSDKLogger.e("IBG-APM", e12.getMessage() != null ? e12.getMessage() : "Couldn't read request body", e12);
            return null;
        }
    }

    public void a(boolean z11) {
        this.f45567d = z11;
    }

    public Long b() {
        return this.f45566c;
    }

    public void close() {
        String str;
        Throwable e11;
        try {
            this.f45564a.close();
        } catch (OutOfMemoryError e12) {
            e11 = e12;
            if (e11.getMessage() == null) {
                str = "Couldn't allocate enough memory to close the outputStream";
                InstabugSDKLogger.e("IBG-APM", str, e11);
            }
            str = e11.getMessage();
            InstabugSDKLogger.e("IBG-APM", str, e11);
        } catch (Exception e13) {
            e11 = e13;
            if (e11.getMessage() == null) {
                str = "Couldn't close the outputStream";
                InstabugSDKLogger.e("IBG-APM", str, e11);
            }
            str = e11.getMessage();
            InstabugSDKLogger.e("IBG-APM", str, e11);
        }
    }

    public void write(int i11) {
        String str;
        try {
            this.f45564a.write(i11);
            this.f45566c = Long.valueOf(this.f45566c.longValue() + 1);
            a(i11);
        } catch (OutOfMemoryError e11) {
            if (e11.getMessage() != null) {
                str = e11.getMessage();
            } else {
                str = "Couldn't allocate enough memory to write " + i11 + " bytes";
            }
            InstabugSDKLogger.e("IBG-APM", str, e11);
        } catch (Exception e12) {
            InstabugSDKLogger.e("IBG-APM", e12.getMessage() != null ? e12.getMessage() : "Couldn't write body bytes", e12);
        }
    }

    public void write(byte[] bArr, int i11, int i12) {
        String str;
        try {
            this.f45564a.write(bArr, i11, i12);
            this.f45566c = Long.valueOf(this.f45566c.longValue() + ((long) i12));
            a(bArr);
        } catch (OutOfMemoryError e11) {
            if (e11.getMessage() != null) {
                str = e11.getMessage();
            } else {
                str = "Couldn't allocate enough memory to write " + bArr.length + " bytes";
            }
            InstabugSDKLogger.e("IBG-APM", str, e11);
        } catch (Exception e12) {
            InstabugSDKLogger.e("IBG-APM", e12.getMessage() != null ? e12.getMessage() : "Couldn't write body byte array", e12);
        }
    }
}
