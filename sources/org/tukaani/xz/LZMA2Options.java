package org.tukaani.xz;

import java.io.IOException;
import java.io.InputStream;

public class LZMA2Options extends FilterOptions {
    public static final int DICT_SIZE_DEFAULT = 8388608;
    public static final int DICT_SIZE_MAX = 805306368;
    public static final int DICT_SIZE_MIN = 4096;
    public static final int LC_DEFAULT = 3;
    public static final int LC_LP_MAX = 4;
    public static final int LP_DEFAULT = 0;
    public static final int MF_BT4 = 20;
    public static final int MF_HC4 = 4;
    public static final int MODE_FAST = 1;
    public static final int MODE_NORMAL = 2;
    public static final int MODE_UNCOMPRESSED = 0;
    public static final int NICE_LEN_MAX = 273;
    public static final int NICE_LEN_MIN = 8;
    public static final int PB_DEFAULT = 2;
    public static final int PB_MAX = 4;
    public static final int PRESET_DEFAULT = 6;
    public static final int PRESET_MAX = 9;
    public static final int PRESET_MIN = 0;
    private static final int[] presetToDepthLimit = {4, 8, 24, 48};
    private static final int[] presetToDictSize = {262144, 1048576, 2097152, 4194304, 4194304, 8388608, 8388608, 16777216, 33554432, 67108864};
    private int depthLimit;
    private int dictSize;

    /* renamed from: lc  reason: collision with root package name */
    private int f63403lc;

    /* renamed from: lp  reason: collision with root package name */
    private int f63404lp;

    /* renamed from: mf  reason: collision with root package name */
    private int f63405mf;
    private int mode;
    private int niceLen;

    /* renamed from: pb  reason: collision with root package name */
    private int f63406pb;
    private byte[] presetDict = null;

    public LZMA2Options() {
        try {
            setPreset(6);
        } catch (UnsupportedOptionsException unused) {
            throw new RuntimeException();
        }
    }

    public LZMA2Options(int i11) throws UnsupportedOptionsException {
        setPreset(i11);
    }

    public LZMA2Options(int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) throws UnsupportedOptionsException {
        setDictSize(i11);
        setLcLp(i12, i13);
        setPb(i14);
        setMode(i15);
        setNiceLen(i16);
        setMatchFinder(i17);
        setDepthLimit(i18);
    }

    public FilterEncoder a() {
        return new LZMA2Encoder(this);
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new RuntimeException();
        }
    }

    public int getDecoderMemoryUsage() {
        int i11 = this.dictSize - 1;
        int i12 = i11 | (i11 >>> 2);
        int i13 = i12 | (i12 >>> 3);
        int i14 = i13 | (i13 >>> 4);
        int i15 = i14 | (i14 >>> 8);
        return LZMA2InputStream.getMemoryUsage((i15 | (i15 >>> 16)) + 1);
    }

    public int getDepthLimit() {
        return this.depthLimit;
    }

    public int getDictSize() {
        return this.dictSize;
    }

    public int getEncoderMemoryUsage() {
        return this.mode == 0 ? UncompressedLZMA2OutputStream.a() : LZMA2OutputStream.a(this);
    }

    public InputStream getInputStream(InputStream inputStream, ArrayCache arrayCache) throws IOException {
        return new LZMA2InputStream(inputStream, this.dictSize, this.presetDict, arrayCache);
    }

    public int getLc() {
        return this.f63403lc;
    }

    public int getLp() {
        return this.f63404lp;
    }

    public int getMatchFinder() {
        return this.f63405mf;
    }

    public int getMode() {
        return this.mode;
    }

    public int getNiceLen() {
        return this.niceLen;
    }

    public FinishableOutputStream getOutputStream(FinishableOutputStream finishableOutputStream, ArrayCache arrayCache) {
        return this.mode == 0 ? new UncompressedLZMA2OutputStream(finishableOutputStream, arrayCache) : new LZMA2OutputStream(finishableOutputStream, this, arrayCache);
    }

    public int getPb() {
        return this.f63406pb;
    }

    public byte[] getPresetDict() {
        return this.presetDict;
    }

    public void setDepthLimit(int i11) throws UnsupportedOptionsException {
        if (i11 >= 0) {
            this.depthLimit = i11;
            return;
        }
        throw new UnsupportedOptionsException("Depth limit cannot be negative: " + i11);
    }

    public void setDictSize(int i11) throws UnsupportedOptionsException {
        if (i11 < 4096) {
            throw new UnsupportedOptionsException("LZMA2 dictionary size must be at least 4 KiB: " + i11 + " B");
        } else if (i11 <= 805306368) {
            this.dictSize = i11;
        } else {
            throw new UnsupportedOptionsException("LZMA2 dictionary size must not exceed 768 MiB: " + i11 + " B");
        }
    }

    public void setLc(int i11) throws UnsupportedOptionsException {
        setLcLp(i11, this.f63404lp);
    }

    public void setLcLp(int i11, int i12) throws UnsupportedOptionsException {
        if (i11 < 0 || i12 < 0 || i11 > 4 || i12 > 4 || i11 + i12 > 4) {
            throw new UnsupportedOptionsException("lc + lp must not exceed 4: " + i11 + " + " + i12);
        }
        this.f63403lc = i11;
        this.f63404lp = i12;
    }

    public void setLp(int i11) throws UnsupportedOptionsException {
        setLcLp(this.f63403lc, i11);
    }

    public void setMatchFinder(int i11) throws UnsupportedOptionsException {
        if (i11 == 4 || i11 == 20) {
            this.f63405mf = i11;
            return;
        }
        throw new UnsupportedOptionsException("Unsupported match finder: " + i11);
    }

    public void setMode(int i11) throws UnsupportedOptionsException {
        if (i11 < 0 || i11 > 2) {
            throw new UnsupportedOptionsException("Unsupported compression mode: " + i11);
        }
        this.mode = i11;
    }

    public void setNiceLen(int i11) throws UnsupportedOptionsException {
        if (i11 < 8) {
            throw new UnsupportedOptionsException("Minimum nice length of matches is 8 bytes: " + i11);
        } else if (i11 <= 273) {
            this.niceLen = i11;
        } else {
            throw new UnsupportedOptionsException("Maximum nice length of matches is 273: " + i11);
        }
    }

    public void setPb(int i11) throws UnsupportedOptionsException {
        if (i11 < 0 || i11 > 4) {
            throw new UnsupportedOptionsException("pb must not exceed 4: " + i11);
        }
        this.f63406pb = i11;
    }

    public void setPreset(int i11) throws UnsupportedOptionsException {
        if (i11 < 0 || i11 > 9) {
            throw new UnsupportedOptionsException("Unsupported preset: " + i11);
        }
        this.f63403lc = 3;
        this.f63404lp = 0;
        this.f63406pb = 2;
        this.dictSize = presetToDictSize[i11];
        if (i11 <= 3) {
            this.mode = 1;
            this.f63405mf = 4;
            this.niceLen = i11 <= 1 ? 128 : NICE_LEN_MAX;
            this.depthLimit = presetToDepthLimit[i11];
            return;
        }
        this.mode = 2;
        this.f63405mf = 20;
        this.niceLen = i11 == 4 ? 16 : i11 == 5 ? 32 : 64;
        this.depthLimit = 0;
    }

    public void setPresetDict(byte[] bArr) {
        this.presetDict = bArr;
    }
}
