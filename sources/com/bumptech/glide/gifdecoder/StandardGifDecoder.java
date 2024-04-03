package com.bumptech.glide.gifdecoder;

import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.gifdecoder.GifDecoder;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;

public class StandardGifDecoder implements GifDecoder {
    private static final int BYTES_PER_INTEGER = 4;
    @ColorInt
    private static final int COLOR_TRANSPARENT_BLACK = 0;
    private static final int INITIAL_FRAME_POINTER = -1;
    private static final int MASK_INT_LOWEST_BYTE = 255;
    private static final int MAX_STACK_SIZE = 4096;
    private static final int NULL_CODE = -1;
    private static final String TAG = "StandardGifDecoder";
    @ColorInt
    private int[] act;
    @NonNull
    private Bitmap.Config bitmapConfig;
    private final GifDecoder.BitmapProvider bitmapProvider;
    private byte[] block;
    private int downsampledHeight;
    private int downsampledWidth;
    private int framePointer;
    private GifHeader header;
    @Nullable
    private Boolean isFirstFrameTransparent;
    private byte[] mainPixels;
    @ColorInt
    private int[] mainScratch;
    private GifHeaderParser parser;
    @ColorInt
    private final int[] pct;
    private byte[] pixelStack;
    private short[] prefix;
    private Bitmap previousImage;
    private ByteBuffer rawData;
    private int sampleSize;
    private boolean savePrevious;
    private int status;
    private byte[] suffix;

    public StandardGifDecoder(@NonNull GifDecoder.BitmapProvider bitmapProvider2, GifHeader gifHeader, ByteBuffer byteBuffer) {
        this(bitmapProvider2, gifHeader, byteBuffer, 1);
    }

    @ColorInt
    private int averageColorsNear(int i11, int i12, int i13) {
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        for (int i19 = i11; i19 < this.sampleSize + i11; i19++) {
            byte[] bArr = this.mainPixels;
            if (i19 >= bArr.length || i19 >= i12) {
                break;
            }
            int i21 = this.act[bArr[i19] & 255];
            if (i21 != 0) {
                i14 += (i21 >> 24) & 255;
                i15 += (i21 >> 16) & 255;
                i16 += (i21 >> 8) & 255;
                i17 += i21 & 255;
                i18++;
            }
        }
        int i22 = i11 + i13;
        for (int i23 = i22; i23 < this.sampleSize + i22; i23++) {
            byte[] bArr2 = this.mainPixels;
            if (i23 >= bArr2.length || i23 >= i12) {
                break;
            }
            int i24 = this.act[bArr2[i23] & 255];
            if (i24 != 0) {
                i14 += (i24 >> 24) & 255;
                i15 += (i24 >> 16) & 255;
                i16 += (i24 >> 8) & 255;
                i17 += i24 & 255;
                i18++;
            }
        }
        if (i18 == 0) {
            return 0;
        }
        return ((i14 / i18) << 24) | ((i15 / i18) << 16) | ((i16 / i18) << 8) | (i17 / i18);
    }

    private void copyCopyIntoScratchRobust(GifFrame gifFrame) {
        boolean z11;
        boolean z12;
        int i11;
        int i12;
        boolean z13;
        int i13;
        int i14;
        int i15;
        GifFrame gifFrame2 = gifFrame;
        int[] iArr = this.mainScratch;
        int i16 = gifFrame2.f44181ih;
        int i17 = this.sampleSize;
        int i18 = i16 / i17;
        int i19 = gifFrame2.f44184iy / i17;
        int i21 = gifFrame2.f44182iw / i17;
        int i22 = gifFrame2.f44183ix / i17;
        if (this.framePointer == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        int i23 = this.downsampledWidth;
        int i24 = this.downsampledHeight;
        byte[] bArr = this.mainPixels;
        int[] iArr2 = this.act;
        Boolean bool = this.isFirstFrameTransparent;
        int i25 = 8;
        int i26 = 0;
        int i27 = 0;
        int i28 = 1;
        while (i27 < i18) {
            Boolean bool2 = bool;
            if (gifFrame2.interlace) {
                if (i26 >= i18) {
                    int i29 = i28 + 1;
                    i11 = i18;
                    if (i29 == 2) {
                        i26 = 4;
                    } else if (i29 == 3) {
                        i25 = 4;
                        i28 = i29;
                        i26 = 2;
                    } else if (i29 == 4) {
                        i28 = i29;
                        i26 = 1;
                        i25 = 2;
                    }
                    i28 = i29;
                } else {
                    i11 = i18;
                }
                i12 = i26 + i25;
            } else {
                i11 = i18;
                i12 = i26;
                i26 = i27;
            }
            int i31 = i26 + i19;
            if (i17 == 1) {
                z13 = true;
            } else {
                z13 = false;
            }
            if (i31 < i24) {
                int i32 = i31 * i23;
                int i33 = i32 + i22;
                int i34 = i33 + i21;
                int i35 = i32 + i23;
                if (i35 < i34) {
                    i34 = i35;
                }
                i13 = i12;
                int i36 = i27 * i17 * gifFrame2.f44182iw;
                if (z13) {
                    int i37 = i33;
                    while (i37 < i34) {
                        int i38 = i19;
                        int i39 = iArr2[bArr[i36] & 255];
                        if (i39 != 0) {
                            iArr[i37] = i39;
                        } else if (z11 && bool2 == null) {
                            bool2 = Boolean.TRUE;
                        }
                        i36 += i17;
                        i37++;
                        i19 = i38;
                    }
                } else {
                    i15 = i19;
                    int i41 = ((i34 - i33) * i17) + i36;
                    int i42 = i33;
                    while (true) {
                        i14 = i21;
                        if (i42 >= i34) {
                            break;
                        }
                        int averageColorsNear = averageColorsNear(i36, i41, gifFrame2.f44182iw);
                        if (averageColorsNear != 0) {
                            iArr[i42] = averageColorsNear;
                        } else if (z11 && bool2 == null) {
                            bool2 = Boolean.TRUE;
                        }
                        i36 += i17;
                        i42++;
                        i21 = i14;
                    }
                    bool = bool2;
                    i27++;
                    i19 = i15;
                    i18 = i11;
                    i21 = i14;
                    i26 = i13;
                }
            } else {
                i13 = i12;
            }
            i15 = i19;
            i14 = i21;
            bool = bool2;
            i27++;
            i19 = i15;
            i18 = i11;
            i21 = i14;
            i26 = i13;
        }
        Boolean bool3 = bool;
        if (this.isFirstFrameTransparent == null) {
            if (bool3 == null) {
                z12 = false;
            } else {
                z12 = bool3.booleanValue();
            }
            this.isFirstFrameTransparent = Boolean.valueOf(z12);
        }
    }

    private void copyIntoScratchFast(GifFrame gifFrame) {
        boolean z11;
        boolean z12;
        GifFrame gifFrame2 = gifFrame;
        int[] iArr = this.mainScratch;
        int i11 = gifFrame2.f44181ih;
        int i12 = gifFrame2.f44184iy;
        int i13 = gifFrame2.f44182iw;
        int i14 = gifFrame2.f44183ix;
        if (this.framePointer == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        int i15 = this.downsampledWidth;
        byte[] bArr = this.mainPixels;
        int[] iArr2 = this.act;
        int i16 = 0;
        byte b11 = -1;
        while (i16 < i11) {
            int i17 = (i16 + i12) * i15;
            int i18 = i17 + i14;
            int i19 = i18 + i13;
            int i21 = i17 + i15;
            if (i21 < i19) {
                i19 = i21;
            }
            int i22 = gifFrame2.f44182iw * i16;
            int i23 = i18;
            while (i23 < i19) {
                byte b12 = bArr[i22];
                int i24 = i11;
                byte b13 = b12 & 255;
                if (b13 != b11) {
                    int i25 = iArr2[b13];
                    if (i25 != 0) {
                        iArr[i23] = i25;
                    } else {
                        b11 = b12;
                    }
                }
                i22++;
                i23++;
                GifFrame gifFrame3 = gifFrame;
                i11 = i24;
            }
            int i26 = i11;
            i16++;
            gifFrame2 = gifFrame;
        }
        Boolean bool = this.isFirstFrameTransparent;
        if ((bool == null || !bool.booleanValue()) && (this.isFirstFrameTransparent != null || !z11 || b11 == -1)) {
            z12 = false;
        } else {
            z12 = true;
        }
        this.isFirstFrameTransparent = Boolean.valueOf(z12);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r26v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v14, resolved type: byte} */
    /* JADX WARNING: Incorrect type for immutable var: ssa=short, code=int, for r7v13, types: [short] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void decodeBitmapData(com.bumptech.glide.gifdecoder.GifFrame r29) {
        /*
            r28 = this;
            r0 = r28
            r1 = r29
            if (r1 == 0) goto L_0x000d
            java.nio.ByteBuffer r2 = r0.rawData
            int r3 = r1.bufferFrameStart
            r2.position(r3)
        L_0x000d:
            if (r1 != 0) goto L_0x0016
            com.bumptech.glide.gifdecoder.GifHeader r1 = r0.header
            int r2 = r1.width
            int r1 = r1.height
            goto L_0x001a
        L_0x0016:
            int r2 = r1.f44182iw
            int r1 = r1.f44181ih
        L_0x001a:
            int r2 = r2 * r1
            byte[] r1 = r0.mainPixels
            if (r1 == 0) goto L_0x0022
            int r1 = r1.length
            if (r1 >= r2) goto L_0x002a
        L_0x0022:
            com.bumptech.glide.gifdecoder.GifDecoder$BitmapProvider r1 = r0.bitmapProvider
            byte[] r1 = r1.obtainByteArray(r2)
            r0.mainPixels = r1
        L_0x002a:
            byte[] r1 = r0.mainPixels
            short[] r3 = r0.prefix
            r4 = 4096(0x1000, float:5.74E-42)
            if (r3 != 0) goto L_0x0036
            short[] r3 = new short[r4]
            r0.prefix = r3
        L_0x0036:
            short[] r3 = r0.prefix
            byte[] r5 = r0.suffix
            if (r5 != 0) goto L_0x0040
            byte[] r5 = new byte[r4]
            r0.suffix = r5
        L_0x0040:
            byte[] r5 = r0.suffix
            byte[] r6 = r0.pixelStack
            if (r6 != 0) goto L_0x004c
            r6 = 4097(0x1001, float:5.741E-42)
            byte[] r6 = new byte[r6]
            r0.pixelStack = r6
        L_0x004c:
            byte[] r6 = r0.pixelStack
            int r7 = r28.readByte()
            r8 = 1
            int r9 = r8 << r7
            int r10 = r9 + 1
            int r11 = r9 + 2
            int r7 = r7 + r8
            int r12 = r8 << r7
            int r12 = r12 - r8
            r13 = 0
            r14 = r13
        L_0x005f:
            if (r14 >= r9) goto L_0x0069
            r3[r14] = r13
            byte r15 = (byte) r14
            r5[r14] = r15
            int r14 = r14 + 1
            goto L_0x005f
        L_0x0069:
            byte[] r14 = r0.block
            r15 = -1
            r23 = r7
            r21 = r11
            r24 = r12
            r16 = r13
            r17 = r16
            r18 = r17
            r19 = r18
            r20 = r19
            r25 = r20
            r26 = r25
            r22 = r15
        L_0x0082:
            if (r13 >= r2) goto L_0x014a
            if (r16 != 0) goto L_0x0093
            int r16 = r28.readBlock()
            if (r16 > 0) goto L_0x0091
            r3 = 3
            r0.status = r3
            goto L_0x014a
        L_0x0091:
            r17 = 0
        L_0x0093:
            byte r4 = r14[r17]
            r4 = r4 & 255(0xff, float:3.57E-43)
            int r4 = r4 << r18
            int r19 = r19 + r4
            int r18 = r18 + 8
            int r17 = r17 + 1
            int r16 = r16 + -1
            r4 = r18
            r8 = r21
            r0 = r22
            r15 = r23
            r22 = r7
            r7 = r26
        L_0x00ad:
            if (r4 < r15) goto L_0x0134
            r23 = r11
            r11 = r19 & r24
            int r19 = r19 >> r15
            int r4 = r4 - r15
            if (r11 != r9) goto L_0x00c1
            r24 = r12
            r15 = r22
            r8 = r23
            r11 = r8
            r0 = -1
            goto L_0x00ad
        L_0x00c1:
            if (r11 != r10) goto L_0x00d7
            r18 = r4
            r26 = r7
            r21 = r8
            r7 = r22
            r11 = r23
            r4 = 4096(0x1000, float:5.74E-42)
            r8 = 1
            r22 = r0
            r23 = r15
            r15 = -1
            goto L_0x0146
        L_0x00d7:
            r26 = r4
            r4 = -1
            if (r0 != r4) goto L_0x00eb
            byte r0 = r5[r11]
            r1[r20] = r0
            int r20 = r20 + 1
            int r13 = r13 + 1
            r0 = r11
            r7 = r0
            r11 = r23
            r4 = r26
            goto L_0x00ad
        L_0x00eb:
            if (r11 < r8) goto L_0x00f4
            byte r7 = (byte) r7
            r6[r25] = r7
            int r25 = r25 + 1
            r7 = r0
            goto L_0x00f5
        L_0x00f4:
            r7 = r11
        L_0x00f5:
            if (r7 < r9) goto L_0x0100
            byte r21 = r5[r7]
            r6[r25] = r21
            int r25 = r25 + 1
            short r7 = r3[r7]
            goto L_0x00f5
        L_0x0100:
            byte r7 = r5[r7]
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r4 = (byte) r7
            r1[r20] = r4
        L_0x0107:
            int r20 = r20 + 1
            int r13 = r13 + 1
            if (r25 <= 0) goto L_0x0114
            int r25 = r25 + -1
            byte r27 = r6[r25]
            r1[r20] = r27
            goto L_0x0107
        L_0x0114:
            r27 = r6
            r6 = 4096(0x1000, float:5.74E-42)
            if (r8 >= r6) goto L_0x012b
            short r0 = (short) r0
            r3[r8] = r0
            r5[r8] = r4
            int r8 = r8 + 1
            r0 = r8 & r24
            if (r0 != 0) goto L_0x012b
            if (r8 >= r6) goto L_0x012b
            int r15 = r15 + 1
            int r24 = r24 + r8
        L_0x012b:
            r0 = r11
            r11 = r23
            r4 = r26
            r6 = r27
            goto L_0x00ad
        L_0x0134:
            r26 = r4
            r21 = r8
            r23 = r15
            r18 = r26
            r4 = 4096(0x1000, float:5.74E-42)
            r8 = 1
            r15 = -1
            r26 = r7
            r7 = r22
            r22 = r0
        L_0x0146:
            r0 = r28
            goto L_0x0082
        L_0x014a:
            r13 = r20
            r0 = 0
            java.util.Arrays.fill(r1, r13, r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.gifdecoder.StandardGifDecoder.decodeBitmapData(com.bumptech.glide.gifdecoder.GifFrame):void");
    }

    @NonNull
    private GifHeaderParser getHeaderParser() {
        if (this.parser == null) {
            this.parser = new GifHeaderParser();
        }
        return this.parser;
    }

    private Bitmap getNextBitmap() {
        Bitmap.Config config;
        Boolean bool = this.isFirstFrameTransparent;
        if (bool == null || bool.booleanValue()) {
            config = Bitmap.Config.ARGB_8888;
        } else {
            config = this.bitmapConfig;
        }
        Bitmap obtain = this.bitmapProvider.obtain(this.downsampledWidth, this.downsampledHeight, config);
        obtain.setHasAlpha(true);
        return obtain;
    }

    private int readBlock() {
        int readByte = readByte();
        if (readByte <= 0) {
            return readByte;
        }
        ByteBuffer byteBuffer = this.rawData;
        byteBuffer.get(this.block, 0, Math.min(readByte, byteBuffer.remaining()));
        return readByte;
    }

    private int readByte() {
        return this.rawData.get() & 255;
    }

    private Bitmap setPixels(GifFrame gifFrame, GifFrame gifFrame2) {
        int i11;
        int i12;
        Bitmap bitmap;
        int[] iArr = this.mainScratch;
        int i13 = 0;
        if (gifFrame2 == null) {
            Bitmap bitmap2 = this.previousImage;
            if (bitmap2 != null) {
                this.bitmapProvider.release(bitmap2);
            }
            this.previousImage = null;
            Arrays.fill(iArr, 0);
        }
        if (gifFrame2 != null && gifFrame2.dispose == 3 && this.previousImage == null) {
            Arrays.fill(iArr, 0);
        }
        if (gifFrame2 != null && (i12 = gifFrame2.dispose) > 0) {
            if (i12 == 2) {
                if (!gifFrame.transparency) {
                    GifHeader gifHeader = this.header;
                    int i14 = gifHeader.bgColor;
                    if (gifFrame.lct == null || gifHeader.bgIndex != gifFrame.transIndex) {
                        i13 = i14;
                    }
                }
                int i15 = gifFrame2.f44181ih;
                int i16 = this.sampleSize;
                int i17 = i15 / i16;
                int i18 = gifFrame2.f44184iy / i16;
                int i19 = gifFrame2.f44182iw / i16;
                int i21 = gifFrame2.f44183ix / i16;
                int i22 = this.downsampledWidth;
                int i23 = (i18 * i22) + i21;
                int i24 = (i17 * i22) + i23;
                while (i23 < i24) {
                    int i25 = i23 + i19;
                    for (int i26 = i23; i26 < i25; i26++) {
                        iArr[i26] = i13;
                    }
                    i23 += this.downsampledWidth;
                }
            } else if (i12 == 3 && (bitmap = this.previousImage) != null) {
                int i27 = this.downsampledWidth;
                bitmap.getPixels(iArr, 0, i27, 0, 0, i27, this.downsampledHeight);
            }
        }
        decodeBitmapData(gifFrame);
        if (gifFrame.interlace || this.sampleSize != 1) {
            copyCopyIntoScratchRobust(gifFrame);
        } else {
            copyIntoScratchFast(gifFrame);
        }
        if (this.savePrevious && ((i11 = gifFrame.dispose) == 0 || i11 == 1)) {
            if (this.previousImage == null) {
                this.previousImage = getNextBitmap();
            }
            Bitmap bitmap3 = this.previousImage;
            int i28 = this.downsampledWidth;
            bitmap3.setPixels(iArr, 0, i28, 0, 0, i28, this.downsampledHeight);
        }
        Bitmap nextBitmap = getNextBitmap();
        int i29 = this.downsampledWidth;
        nextBitmap.setPixels(iArr, 0, i29, 0, 0, i29, this.downsampledHeight);
        return nextBitmap;
    }

    public void advance() {
        this.framePointer = (this.framePointer + 1) % this.header.frameCount;
    }

    public void clear() {
        this.header = null;
        byte[] bArr = this.mainPixels;
        if (bArr != null) {
            this.bitmapProvider.release(bArr);
        }
        int[] iArr = this.mainScratch;
        if (iArr != null) {
            this.bitmapProvider.release(iArr);
        }
        Bitmap bitmap = this.previousImage;
        if (bitmap != null) {
            this.bitmapProvider.release(bitmap);
        }
        this.previousImage = null;
        this.rawData = null;
        this.isFirstFrameTransparent = null;
        byte[] bArr2 = this.block;
        if (bArr2 != null) {
            this.bitmapProvider.release(bArr2);
        }
    }

    public int getByteSize() {
        return this.rawData.limit() + this.mainPixels.length + (this.mainScratch.length * 4);
    }

    public int getCurrentFrameIndex() {
        return this.framePointer;
    }

    @NonNull
    public ByteBuffer getData() {
        return this.rawData;
    }

    public int getDelay(int i11) {
        if (i11 >= 0) {
            GifHeader gifHeader = this.header;
            if (i11 < gifHeader.frameCount) {
                return gifHeader.frames.get(i11).delay;
            }
        }
        return -1;
    }

    public int getFrameCount() {
        return this.header.frameCount;
    }

    public int getHeight() {
        return this.header.height;
    }

    @Deprecated
    public int getLoopCount() {
        int i11 = this.header.loopCount;
        if (i11 == -1) {
            return 1;
        }
        return i11;
    }

    public int getNetscapeLoopCount() {
        return this.header.loopCount;
    }

    public int getNextDelay() {
        int i11;
        if (this.header.frameCount <= 0 || (i11 = this.framePointer) < 0) {
            return 0;
        }
        return getDelay(i11);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00ce, code lost:
        return null;
     */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized android.graphics.Bitmap getNextFrame() {
        /*
            r8 = this;
            monitor-enter(r8)
            com.bumptech.glide.gifdecoder.GifHeader r0 = r8.header     // Catch:{ all -> 0x00cf }
            int r0 = r0.frameCount     // Catch:{ all -> 0x00cf }
            r1 = 3
            r2 = 1
            if (r0 <= 0) goto L_0x000d
            int r0 = r8.framePointer     // Catch:{ all -> 0x00cf }
            if (r0 >= 0) goto L_0x0032
        L_0x000d:
            java.lang.String r0 = TAG     // Catch:{ all -> 0x00cf }
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x00cf }
            if (r0 == 0) goto L_0x0030
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00cf }
            r0.<init>()     // Catch:{ all -> 0x00cf }
            java.lang.String r3 = "Unable to decode frame, frameCount="
            r0.append(r3)     // Catch:{ all -> 0x00cf }
            com.bumptech.glide.gifdecoder.GifHeader r3 = r8.header     // Catch:{ all -> 0x00cf }
            int r3 = r3.frameCount     // Catch:{ all -> 0x00cf }
            r0.append(r3)     // Catch:{ all -> 0x00cf }
            java.lang.String r3 = ", framePointer="
            r0.append(r3)     // Catch:{ all -> 0x00cf }
            int r3 = r8.framePointer     // Catch:{ all -> 0x00cf }
            r0.append(r3)     // Catch:{ all -> 0x00cf }
        L_0x0030:
            r8.status = r2     // Catch:{ all -> 0x00cf }
        L_0x0032:
            int r0 = r8.status     // Catch:{ all -> 0x00cf }
            r3 = 0
            if (r0 == r2) goto L_0x00b6
            r4 = 2
            if (r0 != r4) goto L_0x003c
            goto L_0x00b6
        L_0x003c:
            r0 = 0
            r8.status = r0     // Catch:{ all -> 0x00cf }
            byte[] r5 = r8.block     // Catch:{ all -> 0x00cf }
            if (r5 != 0) goto L_0x004d
            com.bumptech.glide.gifdecoder.GifDecoder$BitmapProvider r5 = r8.bitmapProvider     // Catch:{ all -> 0x00cf }
            r6 = 255(0xff, float:3.57E-43)
            byte[] r5 = r5.obtainByteArray(r6)     // Catch:{ all -> 0x00cf }
            r8.block = r5     // Catch:{ all -> 0x00cf }
        L_0x004d:
            com.bumptech.glide.gifdecoder.GifHeader r5 = r8.header     // Catch:{ all -> 0x00cf }
            java.util.List<com.bumptech.glide.gifdecoder.GifFrame> r5 = r5.frames     // Catch:{ all -> 0x00cf }
            int r6 = r8.framePointer     // Catch:{ all -> 0x00cf }
            java.lang.Object r5 = r5.get(r6)     // Catch:{ all -> 0x00cf }
            com.bumptech.glide.gifdecoder.GifFrame r5 = (com.bumptech.glide.gifdecoder.GifFrame) r5     // Catch:{ all -> 0x00cf }
            int r6 = r8.framePointer     // Catch:{ all -> 0x00cf }
            int r6 = r6 - r2
            if (r6 < 0) goto L_0x0069
            com.bumptech.glide.gifdecoder.GifHeader r7 = r8.header     // Catch:{ all -> 0x00cf }
            java.util.List<com.bumptech.glide.gifdecoder.GifFrame> r7 = r7.frames     // Catch:{ all -> 0x00cf }
            java.lang.Object r6 = r7.get(r6)     // Catch:{ all -> 0x00cf }
            com.bumptech.glide.gifdecoder.GifFrame r6 = (com.bumptech.glide.gifdecoder.GifFrame) r6     // Catch:{ all -> 0x00cf }
            goto L_0x006a
        L_0x0069:
            r6 = r3
        L_0x006a:
            int[] r7 = r5.lct     // Catch:{ all -> 0x00cf }
            if (r7 == 0) goto L_0x006f
            goto L_0x0073
        L_0x006f:
            com.bumptech.glide.gifdecoder.GifHeader r7 = r8.header     // Catch:{ all -> 0x00cf }
            int[] r7 = r7.gct     // Catch:{ all -> 0x00cf }
        L_0x0073:
            r8.act = r7     // Catch:{ all -> 0x00cf }
            if (r7 != 0) goto L_0x0092
            java.lang.String r0 = TAG     // Catch:{ all -> 0x00cf }
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x00cf }
            if (r0 == 0) goto L_0x008e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00cf }
            r0.<init>()     // Catch:{ all -> 0x00cf }
            java.lang.String r1 = "No valid color table found for frame #"
            r0.append(r1)     // Catch:{ all -> 0x00cf }
            int r1 = r8.framePointer     // Catch:{ all -> 0x00cf }
            r0.append(r1)     // Catch:{ all -> 0x00cf }
        L_0x008e:
            r8.status = r2     // Catch:{ all -> 0x00cf }
            monitor-exit(r8)
            return r3
        L_0x0092:
            boolean r1 = r5.transparency     // Catch:{ all -> 0x00cf }
            if (r1 == 0) goto L_0x00b0
            int[] r1 = r8.pct     // Catch:{ all -> 0x00cf }
            int r2 = r7.length     // Catch:{ all -> 0x00cf }
            java.lang.System.arraycopy(r7, r0, r1, r0, r2)     // Catch:{ all -> 0x00cf }
            int[] r1 = r8.pct     // Catch:{ all -> 0x00cf }
            r8.act = r1     // Catch:{ all -> 0x00cf }
            int r2 = r5.transIndex     // Catch:{ all -> 0x00cf }
            r1[r2] = r0     // Catch:{ all -> 0x00cf }
            int r0 = r5.dispose     // Catch:{ all -> 0x00cf }
            if (r0 != r4) goto L_0x00b0
            int r0 = r8.framePointer     // Catch:{ all -> 0x00cf }
            if (r0 != 0) goto L_0x00b0
            java.lang.Boolean r0 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x00cf }
            r8.isFirstFrameTransparent = r0     // Catch:{ all -> 0x00cf }
        L_0x00b0:
            android.graphics.Bitmap r0 = r8.setPixels(r5, r6)     // Catch:{ all -> 0x00cf }
            monitor-exit(r8)
            return r0
        L_0x00b6:
            java.lang.String r0 = TAG     // Catch:{ all -> 0x00cf }
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x00cf }
            if (r0 == 0) goto L_0x00cd
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00cf }
            r0.<init>()     // Catch:{ all -> 0x00cf }
            java.lang.String r1 = "Unable to decode frame, status="
            r0.append(r1)     // Catch:{ all -> 0x00cf }
            int r1 = r8.status     // Catch:{ all -> 0x00cf }
            r0.append(r1)     // Catch:{ all -> 0x00cf }
        L_0x00cd:
            monitor-exit(r8)
            return r3
        L_0x00cf:
            r0 = move-exception
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.gifdecoder.StandardGifDecoder.getNextFrame():android.graphics.Bitmap");
    }

    public int getStatus() {
        return this.status;
    }

    public int getTotalIterationCount() {
        int i11 = this.header.loopCount;
        if (i11 == -1) {
            return 1;
        }
        if (i11 == 0) {
            return 0;
        }
        return i11 + 1;
    }

    public int getWidth() {
        return this.header.width;
    }

    public int read(@Nullable InputStream inputStream, int i11) {
        if (inputStream != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i11 > 0 ? i11 + 4096 : 16384);
                byte[] bArr = new byte[16384];
                while (true) {
                    int read = inputStream.read(bArr, 0, 16384);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byteArrayOutputStream.flush();
                read(byteArrayOutputStream.toByteArray());
            } catch (IOException e11) {
                Log.w(TAG, "Error reading data from stream", e11);
            }
        } else {
            this.status = 2;
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e12) {
                Log.w(TAG, "Error closing stream", e12);
            }
        }
        return this.status;
    }

    public void resetFrameIndex() {
        this.framePointer = -1;
    }

    public synchronized void setData(@NonNull GifHeader gifHeader, @NonNull byte[] bArr) {
        setData(gifHeader, ByteBuffer.wrap(bArr));
    }

    public void setDefaultBitmapConfig(@NonNull Bitmap.Config config) {
        if (config == Bitmap.Config.ARGB_8888 || config == Bitmap.Config.RGB_565) {
            this.bitmapConfig = config;
            return;
        }
        throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + Bitmap.Config.ARGB_8888 + " or " + Bitmap.Config.RGB_565);
    }

    public StandardGifDecoder(@NonNull GifDecoder.BitmapProvider bitmapProvider2, GifHeader gifHeader, ByteBuffer byteBuffer, int i11) {
        this(bitmapProvider2);
        setData(gifHeader, byteBuffer, i11);
    }

    public synchronized void setData(@NonNull GifHeader gifHeader, @NonNull ByteBuffer byteBuffer) {
        setData(gifHeader, byteBuffer, 1);
    }

    public StandardGifDecoder(@NonNull GifDecoder.BitmapProvider bitmapProvider2) {
        this.pct = new int[256];
        this.bitmapConfig = Bitmap.Config.ARGB_8888;
        this.bitmapProvider = bitmapProvider2;
        this.header = new GifHeader();
    }

    public synchronized void setData(@NonNull GifHeader gifHeader, @NonNull ByteBuffer byteBuffer, int i11) {
        if (i11 > 0) {
            int highestOneBit = Integer.highestOneBit(i11);
            this.status = 0;
            this.header = gifHeader;
            this.framePointer = -1;
            ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
            this.rawData = asReadOnlyBuffer;
            asReadOnlyBuffer.position(0);
            this.rawData.order(ByteOrder.LITTLE_ENDIAN);
            this.savePrevious = false;
            Iterator<GifFrame> it = gifHeader.frames.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().dispose == 3) {
                        this.savePrevious = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            this.sampleSize = highestOneBit;
            int i12 = gifHeader.width;
            this.downsampledWidth = i12 / highestOneBit;
            int i13 = gifHeader.height;
            this.downsampledHeight = i13 / highestOneBit;
            this.mainPixels = this.bitmapProvider.obtainByteArray(i12 * i13);
            this.mainScratch = this.bitmapProvider.obtainIntArray(this.downsampledWidth * this.downsampledHeight);
        } else {
            throw new IllegalArgumentException("Sample size must be >=0, not: " + i11);
        }
    }

    public synchronized int read(@Nullable byte[] bArr) {
        GifHeader parseHeader = getHeaderParser().setData(bArr).parseHeader();
        this.header = parseHeader;
        if (bArr != null) {
            setData(parseHeader, bArr);
        }
        return this.status;
    }
}
