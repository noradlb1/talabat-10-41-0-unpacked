package com.google.android.exoplayer2.video;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
import o8.a;
import org.checkerframework.dataflow.qual.Pure;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public final class ColorInfo implements Bundleable {
    public static final Bundleable.Creator<ColorInfo> CREATOR = new a();
    private static final String FIELD_COLOR_RANGE = Util.intToStringMaxRadix(1);
    private static final String FIELD_COLOR_SPACE = Util.intToStringMaxRadix(0);
    private static final String FIELD_COLOR_TRANSFER = Util.intToStringMaxRadix(2);
    private static final String FIELD_HDR_STATIC_INFO = Util.intToStringMaxRadix(3);
    public static final ColorInfo SDR_BT709_LIMITED = new ColorInfo(1, 2, 3, (byte[]) null);
    public final int colorRange;
    public final int colorSpace;
    public final int colorTransfer;
    private int hashCode;
    @Nullable
    public final byte[] hdrStaticInfo;

    public ColorInfo(int i11, int i12, int i13, @Nullable byte[] bArr) {
        this.colorSpace = i11;
        this.colorRange = i12;
        this.colorTransfer = i13;
        this.hdrStaticInfo = bArr;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r1 = r1.colorTransfer;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isTransferHdr(@androidx.annotation.Nullable com.google.android.exoplayer2.video.ColorInfo r1) {
        /*
            if (r1 == 0) goto L_0x000c
            int r1 = r1.colorTransfer
            r0 = -1
            if (r1 == r0) goto L_0x000c
            r0 = 3
            if (r1 == r0) goto L_0x000c
            r1 = 1
            goto L_0x000d
        L_0x000c:
            r1 = 0
        L_0x000d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.video.ColorInfo.isTransferHdr(com.google.android.exoplayer2.video.ColorInfo):boolean");
    }

    @Pure
    public static int isoColorPrimariesToColorSpace(int i11) {
        if (i11 == 1) {
            return 1;
        }
        if (i11 != 9) {
            return (i11 == 4 || i11 == 5 || i11 == 6 || i11 == 7) ? 2 : -1;
        }
        return 6;
    }

    @Pure
    public static int isoTransferCharacteristicsToColorTransfer(int i11) {
        if (i11 == 1) {
            return 3;
        }
        if (i11 == 16) {
            return 6;
        }
        if (i11 != 18) {
            return (i11 == 6 || i11 == 7) ? 3 : -1;
        }
        return 7;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ ColorInfo lambda$static$0(Bundle bundle) {
        return new ColorInfo(bundle.getInt(FIELD_COLOR_SPACE, -1), bundle.getInt(FIELD_COLOR_RANGE, -1), bundle.getInt(FIELD_COLOR_TRANSFER, -1), bundle.getByteArray(FIELD_HDR_STATIC_INFO));
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ColorInfo.class != obj.getClass()) {
            return false;
        }
        ColorInfo colorInfo = (ColorInfo) obj;
        if (this.colorSpace == colorInfo.colorSpace && this.colorRange == colorInfo.colorRange && this.colorTransfer == colorInfo.colorTransfer && Arrays.equals(this.hdrStaticInfo, colorInfo.hdrStaticInfo)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = ((((((527 + this.colorSpace) * 31) + this.colorRange) * 31) + this.colorTransfer) * 31) + Arrays.hashCode(this.hdrStaticInfo);
        }
        return this.hashCode;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(FIELD_COLOR_SPACE, this.colorSpace);
        bundle.putInt(FIELD_COLOR_RANGE, this.colorRange);
        bundle.putInt(FIELD_COLOR_TRANSFER, this.colorTransfer);
        bundle.putByteArray(FIELD_HDR_STATIC_INFO, this.hdrStaticInfo);
        return bundle;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("ColorInfo(");
        sb2.append(this.colorSpace);
        sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
        sb2.append(this.colorRange);
        sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
        sb2.append(this.colorTransfer);
        sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
        sb2.append(this.hdrStaticInfo != null);
        sb2.append(")");
        return sb2.toString();
    }
}
