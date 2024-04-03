package androidx.compose.ui.graphics;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaceKt;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.Connector;
import androidx.compose.ui.graphics.colorspace.Rgb;
import com.checkout.frames.utils.constants.CountryPickerScreenConstants;
import com.checkout.frames.utils.constants.UnderlineConstants;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.UnsignedKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.ws.WebSocketProtocol;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

@Immutable
@JvmInline
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 :2\u00020\u0001:\u0001:B\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u001d\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001e\u0010\u000bJ\u0010\u0010\u001f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b \u0010\u000bJ\u0010\u0010!\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\"\u0010\u000bJ\u0010\u0010#\u001a\u00020\u0007H\u0002¢\u0006\u0004\b$\u0010\u000bJ\u0010\u0010%\u001a\u00020\u0010H\u0002¢\u0006\u0004\b&\u0010\u0013J\u001e\u0010'\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0010ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b(\u0010)J@\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0017\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u0007H\u0007ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b+\u0010,J\u001a\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b0\u00101J\u0010\u00102\u001a\u000203HÖ\u0001¢\u0006\u0004\b4\u00105J\u000f\u00106\u001a\u000207H\u0016¢\u0006\u0004\b8\u00109R\u001a\u0010\u0006\u001a\u00020\u00078FX\u0004¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078FX\u0004¢\u0006\f\u0012\u0004\b\r\u0010\t\u001a\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u00108FX\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\t\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u00078FX\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\t\u001a\u0004\b\u0016\u0010\u000bR\u001a\u0010\u0017\u001a\u00020\u00078FX\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\t\u001a\u0004\b\u0019\u0010\u000bR\u001c\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001b\u0001\u0002ø\u0001\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006;"}, d2 = {"Landroidx/compose/ui/graphics/Color;", "", "value", "Lkotlin/ULong;", "constructor-impl", "(J)J", "alpha", "", "getAlpha$annotations", "()V", "getAlpha-impl", "(J)F", "blue", "getBlue$annotations", "getBlue-impl", "colorSpace", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "getColorSpace$annotations", "getColorSpace-impl", "(J)Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "green", "getGreen$annotations", "getGreen-impl", "red", "getRed$annotations", "getRed-impl", "getValue-s-VKNKU", "()J", "J", "component1", "component1-impl", "component2", "component2-impl", "component3", "component3-impl", "component4", "component4-impl", "component5", "component5-impl", "convert", "convert-vNxB06k", "(JLandroidx/compose/ui/graphics/colorspace/ColorSpace;)J", "copy", "copy-wmQWz5c", "(JFFFF)J", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Color {
    /* access modifiers changed from: private */
    public static final long Black = ColorKt.Color((long) CountryPickerScreenConstants.focusedBorderColor);
    /* access modifiers changed from: private */
    public static final long Blue = ColorKt.Color(4278190335L);
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final long Cyan = ColorKt.Color(4278255615L);
    /* access modifiers changed from: private */
    public static final long DarkGray = ColorKt.Color(4282664004L);
    /* access modifiers changed from: private */
    public static final long Gray = ColorKt.Color((long) UnderlineConstants.focusedUnderlineColor);
    /* access modifiers changed from: private */
    public static final long Green = ColorKt.Color(4278255360L);
    /* access modifiers changed from: private */
    public static final long LightGray = ColorKt.Color(4291611852L);
    /* access modifiers changed from: private */
    public static final long Magenta = ColorKt.Color(4294902015L);
    /* access modifiers changed from: private */
    public static final long Red = ColorKt.Color((long) UnderlineConstants.errorUnderlineColor);
    /* access modifiers changed from: private */
    public static final long Transparent = ColorKt.Color(0);
    /* access modifiers changed from: private */
    public static final long Unspecified = ColorKt.Color(0.0f, 0.0f, 0.0f, 0.0f, ColorSpaces.INSTANCE.getUnspecified$ui_graphics_release());
    /* access modifiers changed from: private */
    public static final long White = ColorKt.Color(4294967295L);
    /* access modifiers changed from: private */
    public static final long Yellow = ColorKt.Color(4294967040L);
    private final long value;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JB\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/2\u0006\u00101\u001a\u00020/2\b\b\u0002\u00102\u001a\u00020/2\b\b\u0002\u00103\u001a\u000204ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b5\u00106J(\u00107\u001a\u00020/2\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020/2\u0006\u0010;\u001a\u00020/2\u0006\u0010<\u001a\u00020/H\u0002JB\u0010=\u001a\u00020\u00042\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/2\u0006\u0010>\u001a\u00020/2\b\b\u0002\u00102\u001a\u00020/2\b\b\u0002\u00103\u001a\u000204ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b?\u00106J(\u0010@\u001a\u00020/2\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020/2\u0006\u0010;\u001a\u00020/2\u0006\u0010A\u001a\u00020/H\u0002R'\u0010\u0003\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R'\u0010\t\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\u0007R'\u0010\f\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\r\u0010\u0002\u001a\u0004\b\u000e\u0010\u0007R'\u0010\u000f\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0010\u0010\u0002\u001a\u0004\b\u0011\u0010\u0007R'\u0010\u0012\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0013\u0010\u0002\u001a\u0004\b\u0014\u0010\u0007R'\u0010\u0015\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0016\u0010\u0002\u001a\u0004\b\u0017\u0010\u0007R'\u0010\u0018\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0019\u0010\u0002\u001a\u0004\b\u001a\u0010\u0007R'\u0010\u001b\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u001c\u0010\u0002\u001a\u0004\b\u001d\u0010\u0007R'\u0010\u001e\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u001f\u0010\u0002\u001a\u0004\b \u0010\u0007R'\u0010!\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\"\u0010\u0002\u001a\u0004\b#\u0010\u0007R'\u0010$\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b%\u0010\u0002\u001a\u0004\b&\u0010\u0007R'\u0010'\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b(\u0010\u0002\u001a\u0004\b)\u0010\u0007R'\u0010*\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b+\u0010\u0002\u001a\u0004\b,\u0010\u0007\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006B"}, d2 = {"Landroidx/compose/ui/graphics/Color$Companion;", "", "()V", "Black", "Landroidx/compose/ui/graphics/Color;", "getBlack-0d7_KjU$annotations", "getBlack-0d7_KjU", "()J", "J", "Blue", "getBlue-0d7_KjU$annotations", "getBlue-0d7_KjU", "Cyan", "getCyan-0d7_KjU$annotations", "getCyan-0d7_KjU", "DarkGray", "getDarkGray-0d7_KjU$annotations", "getDarkGray-0d7_KjU", "Gray", "getGray-0d7_KjU$annotations", "getGray-0d7_KjU", "Green", "getGreen-0d7_KjU$annotations", "getGreen-0d7_KjU", "LightGray", "getLightGray-0d7_KjU$annotations", "getLightGray-0d7_KjU", "Magenta", "getMagenta-0d7_KjU$annotations", "getMagenta-0d7_KjU", "Red", "getRed-0d7_KjU$annotations", "getRed-0d7_KjU", "Transparent", "getTransparent-0d7_KjU$annotations", "getTransparent-0d7_KjU", "Unspecified", "getUnspecified-0d7_KjU$annotations", "getUnspecified-0d7_KjU", "White", "getWhite-0d7_KjU$annotations", "getWhite-0d7_KjU", "Yellow", "getYellow-0d7_KjU$annotations", "getYellow-0d7_KjU", "hsl", "hue", "", "saturation", "lightness", "alpha", "colorSpace", "Landroidx/compose/ui/graphics/colorspace/Rgb;", "hsl-JlNiLsg", "(FFFFLandroidx/compose/ui/graphics/colorspace/Rgb;)J", "hslToRgbComponent", "n", "", "h", "s", "l", "hsv", "value", "hsv-JlNiLsg", "hsvToRgbComponent", "v", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Stable
        /* renamed from: getBlack-0d7_KjU$annotations  reason: not valid java name */
        public static /* synthetic */ void m2930getBlack0d7_KjU$annotations() {
        }

        @Stable
        /* renamed from: getBlue-0d7_KjU$annotations  reason: not valid java name */
        public static /* synthetic */ void m2931getBlue0d7_KjU$annotations() {
        }

        @Stable
        /* renamed from: getCyan-0d7_KjU$annotations  reason: not valid java name */
        public static /* synthetic */ void m2932getCyan0d7_KjU$annotations() {
        }

        @Stable
        /* renamed from: getDarkGray-0d7_KjU$annotations  reason: not valid java name */
        public static /* synthetic */ void m2933getDarkGray0d7_KjU$annotations() {
        }

        @Stable
        /* renamed from: getGray-0d7_KjU$annotations  reason: not valid java name */
        public static /* synthetic */ void m2934getGray0d7_KjU$annotations() {
        }

        @Stable
        /* renamed from: getGreen-0d7_KjU$annotations  reason: not valid java name */
        public static /* synthetic */ void m2935getGreen0d7_KjU$annotations() {
        }

        @Stable
        /* renamed from: getLightGray-0d7_KjU$annotations  reason: not valid java name */
        public static /* synthetic */ void m2936getLightGray0d7_KjU$annotations() {
        }

        @Stable
        /* renamed from: getMagenta-0d7_KjU$annotations  reason: not valid java name */
        public static /* synthetic */ void m2937getMagenta0d7_KjU$annotations() {
        }

        @Stable
        /* renamed from: getRed-0d7_KjU$annotations  reason: not valid java name */
        public static /* synthetic */ void m2938getRed0d7_KjU$annotations() {
        }

        @Stable
        /* renamed from: getTransparent-0d7_KjU$annotations  reason: not valid java name */
        public static /* synthetic */ void m2939getTransparent0d7_KjU$annotations() {
        }

        @Stable
        /* renamed from: getUnspecified-0d7_KjU$annotations  reason: not valid java name */
        public static /* synthetic */ void m2940getUnspecified0d7_KjU$annotations() {
        }

        @Stable
        /* renamed from: getWhite-0d7_KjU$annotations  reason: not valid java name */
        public static /* synthetic */ void m2941getWhite0d7_KjU$annotations() {
        }

        @Stable
        /* renamed from: getYellow-0d7_KjU$annotations  reason: not valid java name */
        public static /* synthetic */ void m2942getYellow0d7_KjU$annotations() {
        }

        /* renamed from: hsl-JlNiLsg$default  reason: not valid java name */
        public static /* synthetic */ long m2943hslJlNiLsg$default(Companion companion, float f11, float f12, float f13, float f14, Rgb rgb, int i11, Object obj) {
            if ((i11 & 8) != 0) {
                f14 = 1.0f;
            }
            float f15 = f14;
            if ((i11 & 16) != 0) {
                rgb = ColorSpaces.INSTANCE.getSrgb();
            }
            return companion.m2958hslJlNiLsg(f11, f12, f13, f15, rgb);
        }

        private final float hslToRgbComponent(int i11, float f11, float f12, float f13) {
            float f14 = (((float) i11) + (f11 / 30.0f)) % 12.0f;
            return f13 - ((f12 * Math.min(f13, 1.0f - f13)) * Math.max(-1.0f, Math.min(f14 - ((float) 3), Math.min(((float) 9) - f14, 1.0f))));
        }

        /* renamed from: hsv-JlNiLsg$default  reason: not valid java name */
        public static /* synthetic */ long m2944hsvJlNiLsg$default(Companion companion, float f11, float f12, float f13, float f14, Rgb rgb, int i11, Object obj) {
            if ((i11 & 8) != 0) {
                f14 = 1.0f;
            }
            float f15 = f14;
            if ((i11 & 16) != 0) {
                rgb = ColorSpaces.INSTANCE.getSrgb();
            }
            return companion.m2959hsvJlNiLsg(f11, f12, f13, f15, rgb);
        }

        private final float hsvToRgbComponent(int i11, float f11, float f12, float f13) {
            float f14 = (((float) i11) + (f11 / 60.0f)) % 6.0f;
            return f13 - ((f12 * f13) * Math.max(0.0f, Math.min(f14, Math.min(((float) 4) - f14, 1.0f))));
        }

        /* renamed from: getBlack-0d7_KjU  reason: not valid java name */
        public final long m2945getBlack0d7_KjU() {
            return Color.Black;
        }

        /* renamed from: getBlue-0d7_KjU  reason: not valid java name */
        public final long m2946getBlue0d7_KjU() {
            return Color.Blue;
        }

        /* renamed from: getCyan-0d7_KjU  reason: not valid java name */
        public final long m2947getCyan0d7_KjU() {
            return Color.Cyan;
        }

        /* renamed from: getDarkGray-0d7_KjU  reason: not valid java name */
        public final long m2948getDarkGray0d7_KjU() {
            return Color.DarkGray;
        }

        /* renamed from: getGray-0d7_KjU  reason: not valid java name */
        public final long m2949getGray0d7_KjU() {
            return Color.Gray;
        }

        /* renamed from: getGreen-0d7_KjU  reason: not valid java name */
        public final long m2950getGreen0d7_KjU() {
            return Color.Green;
        }

        /* renamed from: getLightGray-0d7_KjU  reason: not valid java name */
        public final long m2951getLightGray0d7_KjU() {
            return Color.LightGray;
        }

        /* renamed from: getMagenta-0d7_KjU  reason: not valid java name */
        public final long m2952getMagenta0d7_KjU() {
            return Color.Magenta;
        }

        /* renamed from: getRed-0d7_KjU  reason: not valid java name */
        public final long m2953getRed0d7_KjU() {
            return Color.Red;
        }

        /* renamed from: getTransparent-0d7_KjU  reason: not valid java name */
        public final long m2954getTransparent0d7_KjU() {
            return Color.Transparent;
        }

        /* renamed from: getUnspecified-0d7_KjU  reason: not valid java name */
        public final long m2955getUnspecified0d7_KjU() {
            return Color.Unspecified;
        }

        /* renamed from: getWhite-0d7_KjU  reason: not valid java name */
        public final long m2956getWhite0d7_KjU() {
            return Color.White;
        }

        /* renamed from: getYellow-0d7_KjU  reason: not valid java name */
        public final long m2957getYellow0d7_KjU() {
            return Color.Yellow;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0031, code lost:
            if (r0 != false) goto L_0x0035;
         */
        /* renamed from: hsl-JlNiLsg  reason: not valid java name */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final long m2958hslJlNiLsg(float r6, float r7, float r8, float r9, @org.jetbrains.annotations.NotNull androidx.compose.ui.graphics.colorspace.Rgb r10) {
            /*
                r5 = this;
                java.lang.String r0 = "colorSpace"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
                r0 = 0
                int r1 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
                r2 = 1
                r3 = 0
                if (r1 > 0) goto L_0x0014
                r1 = 1135869952(0x43b40000, float:360.0)
                int r1 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
                if (r1 > 0) goto L_0x0014
                r1 = r2
                goto L_0x0015
            L_0x0014:
                r1 = r3
            L_0x0015:
                if (r1 == 0) goto L_0x0034
                int r1 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
                r4 = 1065353216(0x3f800000, float:1.0)
                if (r1 > 0) goto L_0x0023
                int r1 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
                if (r1 > 0) goto L_0x0023
                r1 = r2
                goto L_0x0024
            L_0x0023:
                r1 = r3
            L_0x0024:
                if (r1 == 0) goto L_0x0034
                int r0 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
                if (r0 > 0) goto L_0x0030
                int r0 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
                if (r0 > 0) goto L_0x0030
                r0 = r2
                goto L_0x0031
            L_0x0030:
                r0 = r3
            L_0x0031:
                if (r0 == 0) goto L_0x0034
                goto L_0x0035
            L_0x0034:
                r2 = r3
            L_0x0035:
                if (r2 == 0) goto L_0x004b
                float r0 = r5.hslToRgbComponent(r3, r6, r7, r8)
                r1 = 8
                float r1 = r5.hslToRgbComponent(r1, r6, r7, r8)
                r2 = 4
                float r6 = r5.hslToRgbComponent(r2, r6, r7, r8)
                long r6 = androidx.compose.ui.graphics.ColorKt.Color(r0, r1, r6, r9, r10)
                return r6
            L_0x004b:
                java.lang.StringBuilder r9 = new java.lang.StringBuilder
                r9.<init>()
                java.lang.String r10 = "HSL ("
                r9.append(r10)
                r9.append(r6)
                java.lang.String r6 = ", "
                r9.append(r6)
                r9.append(r7)
                r9.append(r6)
                r9.append(r8)
                java.lang.String r6 = ") must be in range (0..360, 0..1, 0..1)"
                r9.append(r6)
                java.lang.String r6 = r9.toString()
                java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
                java.lang.String r6 = r6.toString()
                r7.<init>(r6)
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.Color.Companion.m2958hslJlNiLsg(float, float, float, float, androidx.compose.ui.graphics.colorspace.Rgb):long");
        }

        /* renamed from: hsv-JlNiLsg  reason: not valid java name */
        public final long m2959hsvJlNiLsg(float f11, float f12, float f13, float f14, @NotNull Rgb rgb) {
            boolean z11;
            boolean z12;
            boolean z13;
            Intrinsics.checkNotNullParameter(rgb, "colorSpace");
            boolean z14 = false;
            if (0.0f > f11 || f11 > 360.0f) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11) {
                if (0.0f > f12 || f12 > 1.0f) {
                    z12 = false;
                } else {
                    z12 = true;
                }
                if (z12) {
                    if (0.0f > f13 || f13 > 1.0f) {
                        z13 = false;
                    } else {
                        z13 = true;
                    }
                    if (z13) {
                        z14 = true;
                    }
                }
            }
            if (z14) {
                return ColorKt.Color(hsvToRgbComponent(5, f11, f12, f13), hsvToRgbComponent(3, f11, f12, f13), hsvToRgbComponent(1, f11, f12, f13), f14, rgb);
            }
            throw new IllegalArgumentException(("HSV (" + f11 + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + f12 + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + f13 + ") must be in range (0..360, 0..1, 0..1)").toString());
        }
    }

    private /* synthetic */ Color(long j11) {
        this.value = j11;
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ Color m2909boximpl(long j11) {
        return new Color(j11);
    }

    @Stable
    /* renamed from: component1-impl  reason: not valid java name */
    public static final float m2910component1impl(long j11) {
        return m2925getRedimpl(j11);
    }

    @Stable
    /* renamed from: component2-impl  reason: not valid java name */
    public static final float m2911component2impl(long j11) {
        return m2924getGreenimpl(j11);
    }

    @Stable
    /* renamed from: component3-impl  reason: not valid java name */
    public static final float m2912component3impl(long j11) {
        return m2922getBlueimpl(j11);
    }

    @Stable
    /* renamed from: component4-impl  reason: not valid java name */
    public static final float m2913component4impl(long j11) {
        return m2921getAlphaimpl(j11);
    }

    @NotNull
    @Stable
    /* renamed from: component5-impl  reason: not valid java name */
    public static final ColorSpace m2914component5impl(long j11) {
        return m2923getColorSpaceimpl(j11);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m2915constructorimpl(long j11) {
        return j11;
    }

    /* renamed from: convert-vNxB06k  reason: not valid java name */
    public static final long m2916convertvNxB06k(long j11, @NotNull ColorSpace colorSpace) {
        Intrinsics.checkNotNullParameter(colorSpace, "colorSpace");
        if (Intrinsics.areEqual((Object) colorSpace, (Object) m2923getColorSpaceimpl(j11))) {
            return j11;
        }
        Connector r02 = ColorSpaceKt.m3319connectYBCOT_4$default(m2923getColorSpaceimpl(j11), colorSpace, 0, 2, (Object) null);
        float[] r42 = ColorKt.m2966getComponents8_81llA(j11);
        r02.transform(r42);
        return ColorKt.Color(r42[0], r42[1], r42[2], r42[3], colorSpace);
    }

    @Stable
    /* renamed from: copy-wmQWz5c  reason: not valid java name */
    public static final long m2917copywmQWz5c(long j11, float f11, float f12, float f13, float f14) {
        return ColorKt.Color(f12, f13, f14, f11, m2923getColorSpaceimpl(j11));
    }

    /* renamed from: copy-wmQWz5c$default  reason: not valid java name */
    public static /* synthetic */ long m2918copywmQWz5c$default(long j11, float f11, float f12, float f13, float f14, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = m2921getAlphaimpl(j11);
        }
        float f15 = f11;
        if ((i11 & 2) != 0) {
            f12 = m2925getRedimpl(j11);
        }
        float f16 = f12;
        if ((i11 & 4) != 0) {
            f13 = m2924getGreenimpl(j11);
        }
        float f17 = f13;
        if ((i11 & 8) != 0) {
            f14 = m2922getBlueimpl(j11);
        }
        return m2917copywmQWz5c(j11, f15, f16, f17, f14);
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m2919equalsimpl(long j11, Object obj) {
        return (obj instanceof Color) && j11 == ((Color) obj).m2929unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m2920equalsimpl0(long j11, long j12) {
        return j11 == j12;
    }

    @Stable
    public static /* synthetic */ void getAlpha$annotations() {
    }

    /* renamed from: getAlpha-impl  reason: not valid java name */
    public static final float m2921getAlphaimpl(long j11) {
        float f11;
        float f12;
        if (ULong.m6501constructorimpl(63 & j11) == 0) {
            f12 = (float) UnsignedKt.ulongToDouble(ULong.m6501constructorimpl(ULong.m6501constructorimpl(j11 >>> 56) & 255));
            f11 = 255.0f;
        } else {
            f12 = (float) UnsignedKt.ulongToDouble(ULong.m6501constructorimpl(ULong.m6501constructorimpl(j11 >>> 6) & 1023));
            f11 = 1023.0f;
        }
        return f12 / f11;
    }

    @Stable
    public static /* synthetic */ void getBlue$annotations() {
    }

    /* renamed from: getBlue-impl  reason: not valid java name */
    public static final float m2922getBlueimpl(long j11) {
        if (ULong.m6501constructorimpl(63 & j11) == 0) {
            return ((float) UnsignedKt.ulongToDouble(ULong.m6501constructorimpl(ULong.m6501constructorimpl(j11 >>> 32) & 255))) / 255.0f;
        }
        return Float16.m3030toFloatimpl(Float16.m3014constructorimpl((short) ((int) ULong.m6501constructorimpl(ULong.m6501constructorimpl(j11 >>> 16) & WebSocketProtocol.PAYLOAD_SHORT_MAX))));
    }

    @Stable
    public static /* synthetic */ void getColorSpace$annotations() {
    }

    @NotNull
    /* renamed from: getColorSpace-impl  reason: not valid java name */
    public static final ColorSpace m2923getColorSpaceimpl(long j11) {
        return ColorSpaces.INSTANCE.getColorSpacesArray$ui_graphics_release()[(int) ULong.m6501constructorimpl(j11 & 63)];
    }

    @Stable
    public static /* synthetic */ void getGreen$annotations() {
    }

    /* renamed from: getGreen-impl  reason: not valid java name */
    public static final float m2924getGreenimpl(long j11) {
        if (ULong.m6501constructorimpl(63 & j11) == 0) {
            return ((float) UnsignedKt.ulongToDouble(ULong.m6501constructorimpl(ULong.m6501constructorimpl(j11 >>> 40) & 255))) / 255.0f;
        }
        return Float16.m3030toFloatimpl(Float16.m3014constructorimpl((short) ((int) ULong.m6501constructorimpl(ULong.m6501constructorimpl(j11 >>> 32) & WebSocketProtocol.PAYLOAD_SHORT_MAX))));
    }

    @Stable
    public static /* synthetic */ void getRed$annotations() {
    }

    /* renamed from: getRed-impl  reason: not valid java name */
    public static final float m2925getRedimpl(long j11) {
        if (ULong.m6501constructorimpl(63 & j11) == 0) {
            return ((float) UnsignedKt.ulongToDouble(ULong.m6501constructorimpl(ULong.m6501constructorimpl(j11 >>> 48) & 255))) / 255.0f;
        }
        return Float16.m3030toFloatimpl(Float16.m3014constructorimpl((short) ((int) ULong.m6501constructorimpl(ULong.m6501constructorimpl(j11 >>> 48) & WebSocketProtocol.PAYLOAD_SHORT_MAX))));
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m2926hashCodeimpl(long j11) {
        return ULong.m6513hashCodeimpl(j11);
    }

    @NotNull
    /* renamed from: toString-impl  reason: not valid java name */
    public static String m2927toStringimpl(long j11) {
        return "Color(" + m2925getRedimpl(j11) + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + m2924getGreenimpl(j11) + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + m2922getBlueimpl(j11) + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + m2921getAlphaimpl(j11) + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + m2923getColorSpaceimpl(j11).getName() + ')';
    }

    public boolean equals(Object obj) {
        return m2919equalsimpl(this.value, obj);
    }

    /* renamed from: getValue-s-VKNKU  reason: not valid java name */
    public final long m2928getValuesVKNKU() {
        return this.value;
    }

    public int hashCode() {
        return m2926hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m2927toStringimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m2929unboximpl() {
        return this.value;
    }
}
