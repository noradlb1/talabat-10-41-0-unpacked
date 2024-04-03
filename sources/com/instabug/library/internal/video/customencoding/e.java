package com.instabug.library.internal.video.customencoding;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Looper;
import android.view.Surface;
import androidx.annotation.Nullable;
import com.instabug.library.util.InstabugSDKLogger;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Objects;

@TargetApi(21)
abstract class e implements g {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private String f51153a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private MediaCodec f51154b;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public d f51155c;

    /* renamed from: d  reason: collision with root package name */
    private MediaCodec.Callback f51156d = new c(this);

    public e(@Nullable String str) {
        this.f51153a = str;
    }

    private MediaCodec a(String str) throws IOException {
        try {
            String str2 = this.f51153a;
            if (str2 != null) {
                return MediaCodec.createByCodecName(str2);
            }
        } catch (IOException | IllegalArgumentException e11) {
            InstabugSDKLogger.e("IBG-Core", "Create MediaCodec by name '" + this.f51153a + "' failure! " + e11.getMessage());
        }
        return MediaCodec.createEncoderByType(str);
    }

    public abstract MediaFormat b();

    @Nullable
    public final ByteBuffer b(int i11) {
        return f().getOutputBuffer(i11);
    }

    public void d() {
        MediaCodec mediaCodec = this.f51154b;
        if (mediaCodec != null) {
            mediaCodec.release();
            this.f51154b = null;
        }
    }

    public void d(MediaCodec mediaCodec) {
    }

    public void e() {
        MediaCodec mediaCodec = this.f51154b;
        if (mediaCodec != null) {
            mediaCodec.stop();
        }
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public final MediaCodec f() {
        MediaCodec mediaCodec = this.f51154b;
        Objects.requireNonNull(mediaCodec, "doesn't prepare()");
        return mediaCodec;
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public void c() throws IOException {
        if (Looper.myLooper() == null || Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("should run in a HandlerThread");
        } else if (this.f51154b == null) {
            MediaFormat b11 = b();
            MediaCodec a11 = a(b11.getString("mime"));
            try {
                if (this.f51155c != null) {
                    a11.setCallback(this.f51156d);
                }
                a11.configure(b11, (Surface) null, (MediaCrypto) null, 1);
                d(a11);
                a11.start();
                this.f51154b = a11;
            } catch (Exception e11) {
                InstabugSDKLogger.e("IBG-Core", "Configure codec failure!\n  with format" + b11, e11);
                throw e11;
            }
        } else {
            throw new IllegalStateException("prepared!");
        }
    }

    public void e(d dVar) {
        if (this.f51154b == null) {
            this.f51155c = dVar;
            return;
        }
        throw new IllegalStateException("mEncoder is not null");
    }

    @Nullable
    public final ByteBuffer a(int i11) {
        return f().getInputBuffer(i11);
    }

    public final void a(int i11, int i12, int i13, long j11, int i14) {
        f().queueInputBuffer(i11, i12, i13, j11, i14);
    }

    public final void c(int i11) {
        f().releaseOutputBuffer(i11, false);
    }
}
