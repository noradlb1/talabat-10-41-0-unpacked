package androidx.compose.ui.graphics;

import androidx.compose.runtime.Immutable;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Immutable
@JvmInline
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0014\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0001\u0002\u0001\u00020\u0003ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/graphics/BlendMode;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BlendMode {
    /* access modifiers changed from: private */
    public static final int Clear = m2824constructorimpl(0);
    /* access modifiers changed from: private */
    public static final int Color = m2824constructorimpl(27);
    /* access modifiers changed from: private */
    public static final int ColorBurn = m2824constructorimpl(19);
    /* access modifiers changed from: private */
    public static final int ColorDodge = m2824constructorimpl(18);
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final int Darken = m2824constructorimpl(16);
    /* access modifiers changed from: private */
    public static final int Difference = m2824constructorimpl(22);
    /* access modifiers changed from: private */
    public static final int Dst = m2824constructorimpl(2);
    /* access modifiers changed from: private */
    public static final int DstAtop = m2824constructorimpl(10);
    /* access modifiers changed from: private */
    public static final int DstIn = m2824constructorimpl(6);
    /* access modifiers changed from: private */
    public static final int DstOut = m2824constructorimpl(8);
    /* access modifiers changed from: private */
    public static final int DstOver = m2824constructorimpl(4);
    /* access modifiers changed from: private */
    public static final int Exclusion = m2824constructorimpl(23);
    /* access modifiers changed from: private */
    public static final int Hardlight = m2824constructorimpl(20);
    /* access modifiers changed from: private */
    public static final int Hue = m2824constructorimpl(25);
    /* access modifiers changed from: private */
    public static final int Lighten = m2824constructorimpl(17);
    /* access modifiers changed from: private */
    public static final int Luminosity = m2824constructorimpl(28);
    /* access modifiers changed from: private */
    public static final int Modulate = m2824constructorimpl(13);
    /* access modifiers changed from: private */
    public static final int Multiply = m2824constructorimpl(24);
    /* access modifiers changed from: private */
    public static final int Overlay = m2824constructorimpl(15);
    /* access modifiers changed from: private */
    public static final int Plus = m2824constructorimpl(12);
    /* access modifiers changed from: private */
    public static final int Saturation = m2824constructorimpl(26);
    /* access modifiers changed from: private */
    public static final int Screen = m2824constructorimpl(14);
    /* access modifiers changed from: private */
    public static final int Softlight = m2824constructorimpl(21);
    /* access modifiers changed from: private */
    public static final int Src = m2824constructorimpl(1);
    /* access modifiers changed from: private */
    public static final int SrcAtop = m2824constructorimpl(9);
    /* access modifiers changed from: private */
    public static final int SrcIn = m2824constructorimpl(5);
    /* access modifiers changed from: private */
    public static final int SrcOut = m2824constructorimpl(7);
    /* access modifiers changed from: private */
    public static final int SrcOver = m2824constructorimpl(3);
    /* access modifiers changed from: private */
    public static final int Xor = m2824constructorimpl(11);
    private final int value;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b<\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u001c\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0010\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0011\u0010\u0006R\u001c\u0010\u0012\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0013\u0010\u0006R\u001c\u0010\u0014\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0015\u0010\u0006R\u001c\u0010\u0016\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0017\u0010\u0006R\u001c\u0010\u0018\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0019\u0010\u0006R\u001c\u0010\u001a\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u001b\u0010\u0006R\u001c\u0010\u001c\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u001d\u0010\u0006R\u001c\u0010\u001e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u001f\u0010\u0006R\u001c\u0010 \u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b!\u0010\u0006R\u001c\u0010\"\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b#\u0010\u0006R\u001c\u0010$\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b%\u0010\u0006R\u001c\u0010&\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b'\u0010\u0006R\u001c\u0010(\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b)\u0010\u0006R\u001c\u0010*\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b+\u0010\u0006R\u001c\u0010,\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b-\u0010\u0006R\u001c\u0010.\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b/\u0010\u0006R\u001c\u00100\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b1\u0010\u0006R\u001c\u00102\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b3\u0010\u0006R\u001c\u00104\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b5\u0010\u0006R\u001c\u00106\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b7\u0010\u0006R\u001c\u00108\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b9\u0010\u0006R\u001c\u0010:\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b;\u0010\u0006R\u001c\u0010<\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b=\u0010\u0006R\u001c\u0010>\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b?\u0010\u0006\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006@"}, d2 = {"Landroidx/compose/ui/graphics/BlendMode$Companion;", "", "()V", "Clear", "Landroidx/compose/ui/graphics/BlendMode;", "getClear-0nO6VwU", "()I", "I", "Color", "getColor-0nO6VwU", "ColorBurn", "getColorBurn-0nO6VwU", "ColorDodge", "getColorDodge-0nO6VwU", "Darken", "getDarken-0nO6VwU", "Difference", "getDifference-0nO6VwU", "Dst", "getDst-0nO6VwU", "DstAtop", "getDstAtop-0nO6VwU", "DstIn", "getDstIn-0nO6VwU", "DstOut", "getDstOut-0nO6VwU", "DstOver", "getDstOver-0nO6VwU", "Exclusion", "getExclusion-0nO6VwU", "Hardlight", "getHardlight-0nO6VwU", "Hue", "getHue-0nO6VwU", "Lighten", "getLighten-0nO6VwU", "Luminosity", "getLuminosity-0nO6VwU", "Modulate", "getModulate-0nO6VwU", "Multiply", "getMultiply-0nO6VwU", "Overlay", "getOverlay-0nO6VwU", "Plus", "getPlus-0nO6VwU", "Saturation", "getSaturation-0nO6VwU", "Screen", "getScreen-0nO6VwU", "Softlight", "getSoftlight-0nO6VwU", "Src", "getSrc-0nO6VwU", "SrcAtop", "getSrcAtop-0nO6VwU", "SrcIn", "getSrcIn-0nO6VwU", "SrcOut", "getSrcOut-0nO6VwU", "SrcOver", "getSrcOver-0nO6VwU", "Xor", "getXor-0nO6VwU", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getClear-0nO6VwU  reason: not valid java name */
        public final int m2830getClear0nO6VwU() {
            return BlendMode.Clear;
        }

        /* renamed from: getColor-0nO6VwU  reason: not valid java name */
        public final int m2831getColor0nO6VwU() {
            return BlendMode.Color;
        }

        /* renamed from: getColorBurn-0nO6VwU  reason: not valid java name */
        public final int m2832getColorBurn0nO6VwU() {
            return BlendMode.ColorBurn;
        }

        /* renamed from: getColorDodge-0nO6VwU  reason: not valid java name */
        public final int m2833getColorDodge0nO6VwU() {
            return BlendMode.ColorDodge;
        }

        /* renamed from: getDarken-0nO6VwU  reason: not valid java name */
        public final int m2834getDarken0nO6VwU() {
            return BlendMode.Darken;
        }

        /* renamed from: getDifference-0nO6VwU  reason: not valid java name */
        public final int m2835getDifference0nO6VwU() {
            return BlendMode.Difference;
        }

        /* renamed from: getDst-0nO6VwU  reason: not valid java name */
        public final int m2836getDst0nO6VwU() {
            return BlendMode.Dst;
        }

        /* renamed from: getDstAtop-0nO6VwU  reason: not valid java name */
        public final int m2837getDstAtop0nO6VwU() {
            return BlendMode.DstAtop;
        }

        /* renamed from: getDstIn-0nO6VwU  reason: not valid java name */
        public final int m2838getDstIn0nO6VwU() {
            return BlendMode.DstIn;
        }

        /* renamed from: getDstOut-0nO6VwU  reason: not valid java name */
        public final int m2839getDstOut0nO6VwU() {
            return BlendMode.DstOut;
        }

        /* renamed from: getDstOver-0nO6VwU  reason: not valid java name */
        public final int m2840getDstOver0nO6VwU() {
            return BlendMode.DstOver;
        }

        /* renamed from: getExclusion-0nO6VwU  reason: not valid java name */
        public final int m2841getExclusion0nO6VwU() {
            return BlendMode.Exclusion;
        }

        /* renamed from: getHardlight-0nO6VwU  reason: not valid java name */
        public final int m2842getHardlight0nO6VwU() {
            return BlendMode.Hardlight;
        }

        /* renamed from: getHue-0nO6VwU  reason: not valid java name */
        public final int m2843getHue0nO6VwU() {
            return BlendMode.Hue;
        }

        /* renamed from: getLighten-0nO6VwU  reason: not valid java name */
        public final int m2844getLighten0nO6VwU() {
            return BlendMode.Lighten;
        }

        /* renamed from: getLuminosity-0nO6VwU  reason: not valid java name */
        public final int m2845getLuminosity0nO6VwU() {
            return BlendMode.Luminosity;
        }

        /* renamed from: getModulate-0nO6VwU  reason: not valid java name */
        public final int m2846getModulate0nO6VwU() {
            return BlendMode.Modulate;
        }

        /* renamed from: getMultiply-0nO6VwU  reason: not valid java name */
        public final int m2847getMultiply0nO6VwU() {
            return BlendMode.Multiply;
        }

        /* renamed from: getOverlay-0nO6VwU  reason: not valid java name */
        public final int m2848getOverlay0nO6VwU() {
            return BlendMode.Overlay;
        }

        /* renamed from: getPlus-0nO6VwU  reason: not valid java name */
        public final int m2849getPlus0nO6VwU() {
            return BlendMode.Plus;
        }

        /* renamed from: getSaturation-0nO6VwU  reason: not valid java name */
        public final int m2850getSaturation0nO6VwU() {
            return BlendMode.Saturation;
        }

        /* renamed from: getScreen-0nO6VwU  reason: not valid java name */
        public final int m2851getScreen0nO6VwU() {
            return BlendMode.Screen;
        }

        /* renamed from: getSoftlight-0nO6VwU  reason: not valid java name */
        public final int m2852getSoftlight0nO6VwU() {
            return BlendMode.Softlight;
        }

        /* renamed from: getSrc-0nO6VwU  reason: not valid java name */
        public final int m2853getSrc0nO6VwU() {
            return BlendMode.Src;
        }

        /* renamed from: getSrcAtop-0nO6VwU  reason: not valid java name */
        public final int m2854getSrcAtop0nO6VwU() {
            return BlendMode.SrcAtop;
        }

        /* renamed from: getSrcIn-0nO6VwU  reason: not valid java name */
        public final int m2855getSrcIn0nO6VwU() {
            return BlendMode.SrcIn;
        }

        /* renamed from: getSrcOut-0nO6VwU  reason: not valid java name */
        public final int m2856getSrcOut0nO6VwU() {
            return BlendMode.SrcOut;
        }

        /* renamed from: getSrcOver-0nO6VwU  reason: not valid java name */
        public final int m2857getSrcOver0nO6VwU() {
            return BlendMode.SrcOver;
        }

        /* renamed from: getXor-0nO6VwU  reason: not valid java name */
        public final int m2858getXor0nO6VwU() {
            return BlendMode.Xor;
        }
    }

    private /* synthetic */ BlendMode(int i11) {
        this.value = i11;
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ BlendMode m2823boximpl(int i11) {
        return new BlendMode(i11);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m2824constructorimpl(int i11) {
        return i11;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m2825equalsimpl(int i11, Object obj) {
        return (obj instanceof BlendMode) && i11 == ((BlendMode) obj).m2829unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m2826equalsimpl0(int i11, int i12) {
        return i11 == i12;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m2827hashCodeimpl(int i11) {
        return i11;
    }

    @NotNull
    /* renamed from: toString-impl  reason: not valid java name */
    public static String m2828toStringimpl(int i11) {
        if (m2826equalsimpl0(i11, Clear)) {
            return "Clear";
        }
        if (m2826equalsimpl0(i11, Src)) {
            return "Src";
        }
        if (m2826equalsimpl0(i11, Dst)) {
            return "Dst";
        }
        if (m2826equalsimpl0(i11, SrcOver)) {
            return "SrcOver";
        }
        if (m2826equalsimpl0(i11, DstOver)) {
            return "DstOver";
        }
        if (m2826equalsimpl0(i11, SrcIn)) {
            return "SrcIn";
        }
        if (m2826equalsimpl0(i11, DstIn)) {
            return "DstIn";
        }
        if (m2826equalsimpl0(i11, SrcOut)) {
            return "SrcOut";
        }
        if (m2826equalsimpl0(i11, DstOut)) {
            return "DstOut";
        }
        if (m2826equalsimpl0(i11, SrcAtop)) {
            return "SrcAtop";
        }
        if (m2826equalsimpl0(i11, DstAtop)) {
            return "DstAtop";
        }
        if (m2826equalsimpl0(i11, Xor)) {
            return "Xor";
        }
        if (m2826equalsimpl0(i11, Plus)) {
            return "Plus";
        }
        if (m2826equalsimpl0(i11, Modulate)) {
            return "Modulate";
        }
        if (m2826equalsimpl0(i11, Screen)) {
            return "Screen";
        }
        if (m2826equalsimpl0(i11, Overlay)) {
            return "Overlay";
        }
        if (m2826equalsimpl0(i11, Darken)) {
            return "Darken";
        }
        if (m2826equalsimpl0(i11, Lighten)) {
            return "Lighten";
        }
        if (m2826equalsimpl0(i11, ColorDodge)) {
            return "ColorDodge";
        }
        if (m2826equalsimpl0(i11, ColorBurn)) {
            return "ColorBurn";
        }
        if (m2826equalsimpl0(i11, Hardlight)) {
            return "HardLight";
        }
        if (m2826equalsimpl0(i11, Softlight)) {
            return "Softlight";
        }
        if (m2826equalsimpl0(i11, Difference)) {
            return "Difference";
        }
        if (m2826equalsimpl0(i11, Exclusion)) {
            return "Exclusion";
        }
        if (m2826equalsimpl0(i11, Multiply)) {
            return "Multiply";
        }
        if (m2826equalsimpl0(i11, Hue)) {
            return "Hue";
        }
        if (m2826equalsimpl0(i11, Saturation)) {
            return ExifInterface.TAG_SATURATION;
        }
        if (m2826equalsimpl0(i11, Color)) {
            return "Color";
        }
        if (m2826equalsimpl0(i11, Luminosity)) {
            return "Luminosity";
        }
        return "Unknown";
    }

    public boolean equals(Object obj) {
        return m2825equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m2827hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m2828toStringimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m2829unboximpl() {
        return this.value;
    }
}
