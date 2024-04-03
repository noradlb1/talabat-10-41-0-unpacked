package com.bumptech.glide.gifdecoder;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.common.base.Ascii;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class GifHeaderParser {
    static final int DEFAULT_FRAME_DELAY = 10;
    private static final int DESCRIPTOR_MASK_INTERLACE_FLAG = 64;
    private static final int DESCRIPTOR_MASK_LCT_FLAG = 128;
    private static final int DESCRIPTOR_MASK_LCT_SIZE = 7;
    private static final int EXTENSION_INTRODUCER = 33;
    private static final int GCE_DISPOSAL_METHOD_SHIFT = 2;
    private static final int GCE_MASK_DISPOSAL_METHOD = 28;
    private static final int GCE_MASK_TRANSPARENT_COLOR_FLAG = 1;
    private static final int IMAGE_SEPARATOR = 44;
    private static final int LABEL_APPLICATION_EXTENSION = 255;
    private static final int LABEL_COMMENT_EXTENSION = 254;
    private static final int LABEL_GRAPHIC_CONTROL_EXTENSION = 249;
    private static final int LABEL_PLAIN_TEXT_EXTENSION = 1;
    private static final int LSD_MASK_GCT_FLAG = 128;
    private static final int LSD_MASK_GCT_SIZE = 7;
    private static final int MASK_INT_LOWEST_BYTE = 255;
    private static final int MAX_BLOCK_SIZE = 256;
    static final int MIN_FRAME_DELAY = 2;
    private static final String TAG = "GifHeaderParser";
    private static final int TRAILER = 59;
    private final byte[] block = new byte[256];
    private int blockSize = 0;
    private GifHeader header;
    private ByteBuffer rawData;

    private boolean err() {
        return this.header.status != 0;
    }

    private int read() {
        try {
            return this.rawData.get() & 255;
        } catch (Exception unused) {
            this.header.status = 1;
            return 0;
        }
    }

    private void readBitmap() {
        boolean z11;
        this.header.currentFrame.f44183ix = readShort();
        this.header.currentFrame.f44184iy = readShort();
        this.header.currentFrame.f44182iw = readShort();
        this.header.currentFrame.f44181ih = readShort();
        int read = read();
        boolean z12 = false;
        if ((read & 128) != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        int pow = (int) Math.pow(2.0d, (double) ((read & 7) + 1));
        GifFrame gifFrame = this.header.currentFrame;
        if ((read & 64) != 0) {
            z12 = true;
        }
        gifFrame.interlace = z12;
        if (z11) {
            gifFrame.lct = readColorTable(pow);
        } else {
            gifFrame.lct = null;
        }
        this.header.currentFrame.bufferFrameStart = this.rawData.position();
        skipImageData();
        if (!err()) {
            GifHeader gifHeader = this.header;
            gifHeader.frameCount++;
            gifHeader.frames.add(gifHeader.currentFrame);
        }
    }

    private void readBlock() {
        int read = read();
        this.blockSize = read;
        if (read > 0) {
            int i11 = 0;
            int i12 = 0;
            while (true) {
                try {
                    int i13 = this.blockSize;
                    if (i11 < i13) {
                        i12 = i13 - i11;
                        this.rawData.get(this.block, i11, i12);
                        i11 += i12;
                    } else {
                        return;
                    }
                } catch (Exception unused) {
                    if (Log.isLoggable(TAG, 3)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Error Reading Block n: ");
                        sb2.append(i11);
                        sb2.append(" count: ");
                        sb2.append(i12);
                        sb2.append(" blockSize: ");
                        sb2.append(this.blockSize);
                    }
                    this.header.status = 1;
                    return;
                }
            }
        }
    }

    @Nullable
    private int[] readColorTable(int i11) {
        byte[] bArr = new byte[(i11 * 3)];
        int[] iArr = null;
        try {
            this.rawData.get(bArr);
            iArr = new int[256];
            int i12 = 0;
            int i13 = 0;
            while (i12 < i11) {
                int i14 = i13 + 1;
                int i15 = i14 + 1;
                int i16 = i15 + 1;
                int i17 = i12 + 1;
                iArr[i12] = ((bArr[i13] & 255) << Ascii.DLE) | -16777216 | ((bArr[i14] & 255) << 8) | (bArr[i15] & 255);
                i13 = i16;
                i12 = i17;
            }
        } catch (BufferUnderflowException unused) {
            Log.isLoggable(TAG, 3);
            this.header.status = 1;
        }
        return iArr;
    }

    private void readContents() {
        readContents(Integer.MAX_VALUE);
    }

    private void readGraphicControlExt() {
        read();
        int read = read();
        GifFrame gifFrame = this.header.currentFrame;
        int i11 = (read & 28) >> 2;
        gifFrame.dispose = i11;
        boolean z11 = true;
        if (i11 == 0) {
            gifFrame.dispose = 1;
        }
        if ((read & 1) == 0) {
            z11 = false;
        }
        gifFrame.transparency = z11;
        int readShort = readShort();
        if (readShort < 2) {
            readShort = 10;
        }
        GifFrame gifFrame2 = this.header.currentFrame;
        gifFrame2.delay = readShort * 10;
        gifFrame2.transIndex = read();
        read();
    }

    private void readHeader() {
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 0; i11 < 6; i11++) {
            sb2.append((char) read());
        }
        if (!sb2.toString().startsWith("GIF")) {
            this.header.status = 1;
            return;
        }
        readLSD();
        if (this.header.gctFlag && !err()) {
            GifHeader gifHeader = this.header;
            gifHeader.gct = readColorTable(gifHeader.gctSize);
            GifHeader gifHeader2 = this.header;
            gifHeader2.bgColor = gifHeader2.gct[gifHeader2.bgIndex];
        }
    }

    private void readLSD() {
        boolean z11;
        this.header.width = readShort();
        this.header.height = readShort();
        int read = read();
        GifHeader gifHeader = this.header;
        if ((read & 128) != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        gifHeader.gctFlag = z11;
        gifHeader.gctSize = (int) Math.pow(2.0d, (double) ((read & 7) + 1));
        this.header.bgIndex = read();
        this.header.pixelAspect = read();
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void readNetscapeExt() {
        /*
            r3 = this;
        L_0x0000:
            r3.readBlock()
            byte[] r0 = r3.block
            r1 = 0
            byte r1 = r0[r1]
            r2 = 1
            if (r1 != r2) goto L_0x001b
            byte r1 = r0[r2]
            r1 = r1 & 255(0xff, float:3.57E-43)
            r2 = 2
            byte r0 = r0[r2]
            r0 = r0 & 255(0xff, float:3.57E-43)
            com.bumptech.glide.gifdecoder.GifHeader r2 = r3.header
            int r0 = r0 << 8
            r0 = r0 | r1
            r2.loopCount = r0
        L_0x001b:
            int r0 = r3.blockSize
            if (r0 <= 0) goto L_0x0025
            boolean r0 = r3.err()
            if (r0 == 0) goto L_0x0000
        L_0x0025:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.gifdecoder.GifHeaderParser.readNetscapeExt():void");
    }

    private int readShort() {
        return this.rawData.getShort();
    }

    private void reset() {
        this.rawData = null;
        Arrays.fill(this.block, (byte) 0);
        this.header = new GifHeader();
        this.blockSize = 0;
    }

    private void skip() {
        int read;
        do {
            read = read();
            this.rawData.position(Math.min(this.rawData.position() + read, this.rawData.limit()));
        } while (read > 0);
    }

    private void skipImageData() {
        read();
        skip();
    }

    public void clear() {
        this.rawData = null;
        this.header = null;
    }

    public boolean isAnimated() {
        readHeader();
        if (!err()) {
            readContents(2);
        }
        if (this.header.frameCount > 1) {
            return true;
        }
        return false;
    }

    @NonNull
    public GifHeader parseHeader() {
        if (this.rawData == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        } else if (err()) {
            return this.header;
        } else {
            readHeader();
            if (!err()) {
                readContents();
                GifHeader gifHeader = this.header;
                if (gifHeader.frameCount < 0) {
                    gifHeader.status = 1;
                }
            }
            return this.header;
        }
    }

    public GifHeaderParser setData(@NonNull ByteBuffer byteBuffer) {
        reset();
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.rawData = asReadOnlyBuffer;
        asReadOnlyBuffer.position(0);
        this.rawData.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }

    private void readContents(int i11) {
        boolean z11 = false;
        while (!z11 && !err() && this.header.frameCount <= i11) {
            int read = read();
            if (read == 33) {
                int read2 = read();
                if (read2 == 1) {
                    skip();
                } else if (read2 == LABEL_GRAPHIC_CONTROL_EXTENSION) {
                    this.header.currentFrame = new GifFrame();
                    readGraphicControlExt();
                } else if (read2 == LABEL_COMMENT_EXTENSION) {
                    skip();
                } else if (read2 != 255) {
                    skip();
                } else {
                    readBlock();
                    StringBuilder sb2 = new StringBuilder();
                    for (int i12 = 0; i12 < 11; i12++) {
                        sb2.append((char) this.block[i12]);
                    }
                    if (sb2.toString().equals("NETSCAPE2.0")) {
                        readNetscapeExt();
                    } else {
                        skip();
                    }
                }
            } else if (read == 44) {
                GifHeader gifHeader = this.header;
                if (gifHeader.currentFrame == null) {
                    gifHeader.currentFrame = new GifFrame();
                }
                readBitmap();
            } else if (read != 59) {
                this.header.status = 1;
            } else {
                z11 = true;
            }
        }
    }

    public GifHeaderParser setData(@Nullable byte[] bArr) {
        if (bArr != null) {
            setData(ByteBuffer.wrap(bArr));
        } else {
            this.rawData = null;
            this.header.status = 2;
        }
        return this;
    }
}
