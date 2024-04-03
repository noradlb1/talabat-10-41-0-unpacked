package com.instabug.apm.networkinterception.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.networkv2.BodyBufferHelper;
import com.instabug.library.util.InstabugSDKLogger;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Objects;
import vb.a;

public class b extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    private long f45557a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f45558b = -1;

    /* renamed from: c  reason: collision with root package name */
    private boolean f45559c = false;

    /* renamed from: d  reason: collision with root package name */
    private final InputStream f45560d;

    /* renamed from: e  reason: collision with root package name */
    private final a f45561e;

    /* renamed from: f  reason: collision with root package name */
    private final StringBuffer f45562f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f45563g;

    public b(InputStream inputStream, a aVar, boolean z11) {
        this.f45560d = inputStream;
        this.f45561e = aVar;
        this.f45562f = new StringBuffer();
        this.f45563g = z11;
    }

    private void a(int i11) {
        if (b()) {
            BodyBufferHelper.clear(this.f45562f);
        } else {
            this.f45562f.append((char) i11);
        }
    }

    private void a(byte[] bArr) {
        if (b()) {
            BodyBufferHelper.clear(this.f45562f);
        } else {
            this.f45562f.append(new String(bArr, Charset.forName("UTF-8")).trim());
        }
    }

    private boolean b() {
        return this.f45563g || BodyBufferHelper.isBodySizeAllowed(this.f45557a);
    }

    @Nullable
    public String a() {
        String str;
        try {
            boolean z11 = this.f45563g;
            long j11 = this.f45557a;
            StringBuffer stringBuffer = this.f45562f;
            Objects.requireNonNull(stringBuffer);
            return BodyBufferHelper.generateBodyMsg(z11, j11, new a(stringBuffer));
        } catch (OutOfMemoryError e11) {
            th = e11;
            str = "OOM error while getting a string response body from a string buffer";
            InstabugCore.reportError(th, str);
            InstabugSDKLogger.e("APMCountableInputStream", str, th);
            return null;
        } catch (Throwable th2) {
            th = th2;
            str = "Error while getting a string response body from a string buffer";
            InstabugSDKLogger.e("APMCountableInputStream", str, th);
            return null;
        }
    }

    public void a(boolean z11) {
        this.f45563g = z11;
    }

    public void mark(int i11) {
        this.f45560d.mark(i11);
        this.f45558b = (int) this.f45557a;
    }

    public int read() {
        int read = this.f45560d.read();
        if (read != -1) {
            this.f45557a++;
        } else if (!this.f45559c) {
            this.f45559c = true;
            this.f45561e.a(this.f45557a);
        }
        a(read);
        return read;
    }

    public int read(@NonNull byte[] bArr, int i11, int i12) {
        int read = this.f45560d.read(bArr, i11, i12);
        if (read != -1) {
            this.f45557a += (long) read;
        } else if (!this.f45559c) {
            this.f45559c = true;
            this.f45561e.a(this.f45557a);
        }
        a(bArr);
        return read;
    }

    public void reset() {
        if (!this.f45560d.markSupported()) {
            throw new IOException("Mark not supported");
        } else if (this.f45558b != -1) {
            this.f45560d.reset();
            this.f45557a = (long) this.f45558b;
        } else {
            throw new IOException("Mark not set");
        }
    }

    public long skip(long j11) {
        long skip = this.f45560d.skip(j11);
        this.f45557a += skip;
        return skip;
    }
}
