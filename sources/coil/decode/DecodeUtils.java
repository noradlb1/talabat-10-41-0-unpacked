package coil.decode;

import androidx.annotation.Px;
import coil.size.OriginalSize;
import coil.size.PixelSize;
import coil.size.Scale;
import coil.size.Size;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSource;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J8\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u000f\u001a\u00020\u000e2\b\b\u0001\u0010\u0010\u001a\u00020\u000e2\b\b\u0001\u0010\u0011\u001a\u00020\u000e2\b\b\u0001\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J(\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J8\u0010\u0019\u001a\u00020\u001a2\b\b\u0001\u0010\u000f\u001a\u00020\u001a2\b\b\u0001\u0010\u0010\u001a\u00020\u001a2\b\b\u0001\u0010\u0011\u001a\u00020\u001a2\b\b\u0001\u0010\u0012\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J8\u0010\u0019\u001a\u00020\u001b2\b\b\u0001\u0010\u000f\u001a\u00020\u001b2\b\b\u0001\u0010\u0010\u001a\u00020\u001b2\b\b\u0001\u0010\u0011\u001a\u00020\u001b2\b\b\u0001\u0010\u0012\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J8\u0010\u0019\u001a\u00020\u001a2\b\b\u0001\u0010\u000f\u001a\u00020\u000e2\b\b\u0001\u0010\u0010\u001a\u00020\u000e2\b\b\u0001\u0010\u0011\u001a\u00020\u000e2\b\b\u0001\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0010\u0010 \u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0010\u0010!\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0010\u0010\"\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0010\u0010#\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcoil/decode/DecodeUtils;", "", "()V", "GIF_HEADER_87A", "Lokio/ByteString;", "GIF_HEADER_89A", "HEIF_HEADER_FTYP", "HEIF_HEADER_HEVC", "HEIF_HEADER_HEVX", "HEIF_HEADER_MSF1", "WEBP_HEADER_RIFF", "WEBP_HEADER_VPX8", "WEBP_HEADER_WEBP", "calculateInSampleSize", "", "srcWidth", "srcHeight", "dstWidth", "dstHeight", "scale", "Lcoil/size/Scale;", "computePixelSize", "Lcoil/size/PixelSize;", "dstSize", "Lcoil/size/Size;", "computeSizeMultiplier", "", "", "isAnimatedHeif", "", "source", "Lokio/BufferedSource;", "isAnimatedWebP", "isGif", "isHeif", "isWebP", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DecodeUtils {
    @NotNull
    private static final ByteString GIF_HEADER_87A;
    @NotNull
    private static final ByteString GIF_HEADER_89A;
    @NotNull
    private static final ByteString HEIF_HEADER_FTYP;
    @NotNull
    private static final ByteString HEIF_HEADER_HEVC;
    @NotNull
    private static final ByteString HEIF_HEADER_HEVX;
    @NotNull
    private static final ByteString HEIF_HEADER_MSF1;
    @NotNull
    public static final DecodeUtils INSTANCE = new DecodeUtils();
    @NotNull
    private static final ByteString WEBP_HEADER_RIFF;
    @NotNull
    private static final ByteString WEBP_HEADER_VPX8;
    @NotNull
    private static final ByteString WEBP_HEADER_WEBP;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Scale.values().length];
            iArr[Scale.FILL.ordinal()] = 1;
            iArr[Scale.FIT.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        ByteString.Companion companion = ByteString.Companion;
        GIF_HEADER_87A = companion.encodeUtf8("GIF87a");
        GIF_HEADER_89A = companion.encodeUtf8("GIF89a");
        WEBP_HEADER_RIFF = companion.encodeUtf8("RIFF");
        WEBP_HEADER_WEBP = companion.encodeUtf8("WEBP");
        WEBP_HEADER_VPX8 = companion.encodeUtf8("VP8X");
        HEIF_HEADER_FTYP = companion.encodeUtf8("ftyp");
        HEIF_HEADER_MSF1 = companion.encodeUtf8("msf1");
        HEIF_HEADER_HEVC = companion.encodeUtf8("hevc");
        HEIF_HEADER_HEVX = companion.encodeUtf8("hevx");
    }

    private DecodeUtils() {
    }

    @JvmStatic
    public static final int calculateInSampleSize(@Px int i11, @Px int i12, @Px int i13, @Px int i14, @NotNull Scale scale) {
        Intrinsics.checkNotNullParameter(scale, "scale");
        int coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(Integer.highestOneBit(i11 / i13), 1);
        int coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(Integer.highestOneBit(i12 / i14), 1);
        int i15 = WhenMappings.$EnumSwitchMapping$0[scale.ordinal()];
        if (i15 == 1) {
            return Math.min(coerceAtLeast, coerceAtLeast2);
        }
        if (i15 == 2) {
            return Math.max(coerceAtLeast, coerceAtLeast2);
        }
        throw new NoWhenBranchMatchedException();
    }

    @JvmStatic
    @NotNull
    public static final PixelSize computePixelSize(int i11, int i12, @NotNull Size size, @NotNull Scale scale) {
        Intrinsics.checkNotNullParameter(size, "dstSize");
        Intrinsics.checkNotNullParameter(scale, "scale");
        if (size instanceof OriginalSize) {
            return new PixelSize(i11, i12);
        }
        if (size instanceof PixelSize) {
            PixelSize pixelSize = (PixelSize) size;
            double computeSizeMultiplier = computeSizeMultiplier(i11, i12, pixelSize.getWidth(), pixelSize.getHeight(), scale);
            return new PixelSize(MathKt__MathJVMKt.roundToInt(((double) i11) * computeSizeMultiplier), MathKt__MathJVMKt.roundToInt(computeSizeMultiplier * ((double) i12)));
        }
        throw new NoWhenBranchMatchedException();
    }

    @JvmStatic
    public static final double computeSizeMultiplier(@Px int i11, @Px int i12, @Px int i13, @Px int i14, @NotNull Scale scale) {
        Intrinsics.checkNotNullParameter(scale, "scale");
        double d11 = ((double) i13) / ((double) i11);
        double d12 = ((double) i14) / ((double) i12);
        int i15 = WhenMappings.$EnumSwitchMapping$0[scale.ordinal()];
        if (i15 == 1) {
            return Math.max(d11, d12);
        }
        if (i15 == 2) {
            return Math.min(d11, d12);
        }
        throw new NoWhenBranchMatchedException();
    }

    @JvmStatic
    public static final boolean isAnimatedHeif(@NotNull BufferedSource bufferedSource) {
        Intrinsics.checkNotNullParameter(bufferedSource, "source");
        if (!isHeif(bufferedSource) || (!bufferedSource.rangeEquals(8, HEIF_HEADER_MSF1) && !bufferedSource.rangeEquals(8, HEIF_HEADER_HEVC) && !bufferedSource.rangeEquals(8, HEIF_HEADER_HEVX))) {
            return false;
        }
        return true;
    }

    @JvmStatic
    public static final boolean isAnimatedWebP(@NotNull BufferedSource bufferedSource) {
        Intrinsics.checkNotNullParameter(bufferedSource, "source");
        if (!isWebP(bufferedSource) || !bufferedSource.rangeEquals(12, WEBP_HEADER_VPX8) || !bufferedSource.request(17) || ((byte) (bufferedSource.getBuffer().getByte(16) & 2)) <= 0) {
            return false;
        }
        return true;
    }

    @JvmStatic
    public static final boolean isGif(@NotNull BufferedSource bufferedSource) {
        Intrinsics.checkNotNullParameter(bufferedSource, "source");
        if (bufferedSource.rangeEquals(0, GIF_HEADER_89A) || bufferedSource.rangeEquals(0, GIF_HEADER_87A)) {
            return true;
        }
        return false;
    }

    @JvmStatic
    public static final boolean isHeif(@NotNull BufferedSource bufferedSource) {
        Intrinsics.checkNotNullParameter(bufferedSource, "source");
        return bufferedSource.rangeEquals(4, HEIF_HEADER_FTYP);
    }

    @JvmStatic
    public static final boolean isWebP(@NotNull BufferedSource bufferedSource) {
        Intrinsics.checkNotNullParameter(bufferedSource, "source");
        if (!bufferedSource.rangeEquals(0, WEBP_HEADER_RIFF) || !bufferedSource.rangeEquals(8, WEBP_HEADER_WEBP)) {
            return false;
        }
        return true;
    }

    @JvmStatic
    public static final float computeSizeMultiplier(@Px float f11, @Px float f12, @Px float f13, @Px float f14, @NotNull Scale scale) {
        Intrinsics.checkNotNullParameter(scale, "scale");
        float f15 = f13 / f11;
        float f16 = f14 / f12;
        int i11 = WhenMappings.$EnumSwitchMapping$0[scale.ordinal()];
        if (i11 == 1) {
            return Math.max(f15, f16);
        }
        if (i11 == 2) {
            return Math.min(f15, f16);
        }
        throw new NoWhenBranchMatchedException();
    }

    @JvmStatic
    public static final double computeSizeMultiplier(@Px double d11, @Px double d12, @Px double d13, @Px double d14, @NotNull Scale scale) {
        Intrinsics.checkNotNullParameter(scale, "scale");
        double d15 = d13 / d11;
        double d16 = d14 / d12;
        int i11 = WhenMappings.$EnumSwitchMapping$0[scale.ordinal()];
        if (i11 == 1) {
            return Math.max(d15, d16);
        }
        if (i11 == 2) {
            return Math.min(d15, d16);
        }
        throw new NoWhenBranchMatchedException();
    }
}
