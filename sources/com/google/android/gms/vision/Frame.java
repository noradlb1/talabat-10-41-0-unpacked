package com.google.android.gms.vision;

import android.graphics.Bitmap;
import android.graphics.Color;
import java.nio.ByteBuffer;

public class Frame {
    public static final int ROTATION_0 = 0;
    public static final int ROTATION_180 = 2;
    public static final int ROTATION_270 = 3;
    public static final int ROTATION_90 = 1;
    private Metadata zzao;
    /* access modifiers changed from: private */
    public ByteBuffer zzap;
    /* access modifiers changed from: private */
    public Bitmap zzaq;

    public static class Builder {
        private Frame zzas = new Frame();

        public Frame build() {
            if (this.zzas.zzap != null || this.zzas.zzaq != null) {
                return this.zzas;
            }
            throw new IllegalStateException("Missing image data.  Call either setBitmap or setImageData to specify the image");
        }

        public Builder setBitmap(Bitmap bitmap) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            Bitmap unused = this.zzas.zzaq = bitmap;
            Metadata metadata = this.zzas.getMetadata();
            int unused2 = metadata.width = width;
            int unused3 = metadata.height = height;
            return this;
        }

        public Builder setId(int i11) {
            int unused = this.zzas.getMetadata().f44511id = i11;
            return this;
        }

        public Builder setImageData(ByteBuffer byteBuffer, int i11, int i12, int i13) {
            if (byteBuffer == null) {
                throw new IllegalArgumentException("Null image data supplied.");
            } else if (byteBuffer.capacity() < i11 * i12) {
                throw new IllegalArgumentException("Invalid image data size.");
            } else if (i13 == 16 || i13 == 17 || i13 == 842094169) {
                ByteBuffer unused = this.zzas.zzap = byteBuffer;
                Metadata metadata = this.zzas.getMetadata();
                int unused2 = metadata.width = i11;
                int unused3 = metadata.height = i12;
                int unused4 = metadata.format = i13;
                return this;
            } else {
                StringBuilder sb2 = new StringBuilder(37);
                sb2.append("Unsupported image format: ");
                sb2.append(i13);
                throw new IllegalArgumentException(sb2.toString());
            }
        }

        public Builder setRotation(int i11) {
            int unused = this.zzas.getMetadata().rotation = i11;
            return this;
        }

        public Builder setTimestampMillis(long j11) {
            long unused = this.zzas.getMetadata().zzar = j11;
            return this;
        }
    }

    private Frame() {
        this.zzao = new Metadata();
        this.zzap = null;
        this.zzaq = null;
    }

    public Bitmap getBitmap() {
        return this.zzaq;
    }

    public ByteBuffer getGrayscaleImageData() {
        Bitmap bitmap = this.zzaq;
        if (bitmap == null) {
            return this.zzap;
        }
        int width = bitmap.getWidth();
        int height = this.zzaq.getHeight();
        int i11 = width * height;
        int[] iArr = new int[i11];
        this.zzaq.getPixels(iArr, 0, width, 0, 0, width, height);
        byte[] bArr = new byte[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            bArr[i12] = (byte) ((int) ((((float) Color.red(iArr[i12])) * 0.299f) + (((float) Color.green(iArr[i12])) * 0.587f) + (((float) Color.blue(iArr[i12])) * 0.114f)));
        }
        return ByteBuffer.wrap(bArr);
    }

    public Metadata getMetadata() {
        return this.zzao;
    }

    public static class Metadata {
        /* access modifiers changed from: private */
        public int format = -1;
        /* access modifiers changed from: private */
        public int height;
        /* access modifiers changed from: private */

        /* renamed from: id  reason: collision with root package name */
        public int f44511id;
        /* access modifiers changed from: private */
        public int rotation;
        /* access modifiers changed from: private */
        public int width;
        /* access modifiers changed from: private */
        public long zzar;

        public Metadata() {
        }

        public int getFormat() {
            return this.format;
        }

        public int getHeight() {
            return this.height;
        }

        public int getId() {
            return this.f44511id;
        }

        public int getRotation() {
            return this.rotation;
        }

        public long getTimestampMillis() {
            return this.zzar;
        }

        public int getWidth() {
            return this.width;
        }

        public final void zzd() {
            if (this.rotation % 2 != 0) {
                int i11 = this.width;
                this.width = this.height;
                this.height = i11;
            }
            this.rotation = 0;
        }

        public Metadata(Metadata metadata) {
            this.width = metadata.getWidth();
            this.height = metadata.getHeight();
            this.f44511id = metadata.getId();
            this.zzar = metadata.getTimestampMillis();
            this.rotation = metadata.getRotation();
        }
    }
}
