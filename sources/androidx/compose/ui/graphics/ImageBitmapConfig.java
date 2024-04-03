package androidx.compose.ui.graphics;

import androidx.compose.runtime.Immutable;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Immutable
@JvmInline
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0014\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0005J\u000f\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0001\u0002ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/graphics/ImageBitmapConfig;", "", "value", "", "constructor-impl", "(I)I", "getValue", "()I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ImageBitmapConfig {
    /* access modifiers changed from: private */
    public static final int Alpha8 = m3083constructorimpl(1);
    /* access modifiers changed from: private */
    public static final int Argb8888 = m3083constructorimpl(0);
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final int F16 = m3083constructorimpl(3);
    /* access modifiers changed from: private */
    public static final int Gpu = m3083constructorimpl(4);
    /* access modifiers changed from: private */
    public static final int Rgb565 = m3083constructorimpl(2);
    private final int value;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u001c\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000f\u0010\u0006\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/graphics/ImageBitmapConfig$Companion;", "", "()V", "Alpha8", "Landroidx/compose/ui/graphics/ImageBitmapConfig;", "getAlpha8-_sVssgQ", "()I", "I", "Argb8888", "getArgb8888-_sVssgQ", "F16", "getF16-_sVssgQ", "Gpu", "getGpu-_sVssgQ", "Rgb565", "getRgb565-_sVssgQ", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getAlpha8-_sVssgQ  reason: not valid java name */
        public final int m3089getAlpha8_sVssgQ() {
            return ImageBitmapConfig.Alpha8;
        }

        /* renamed from: getArgb8888-_sVssgQ  reason: not valid java name */
        public final int m3090getArgb8888_sVssgQ() {
            return ImageBitmapConfig.Argb8888;
        }

        /* renamed from: getF16-_sVssgQ  reason: not valid java name */
        public final int m3091getF16_sVssgQ() {
            return ImageBitmapConfig.F16;
        }

        /* renamed from: getGpu-_sVssgQ  reason: not valid java name */
        public final int m3092getGpu_sVssgQ() {
            return ImageBitmapConfig.Gpu;
        }

        /* renamed from: getRgb565-_sVssgQ  reason: not valid java name */
        public final int m3093getRgb565_sVssgQ() {
            return ImageBitmapConfig.Rgb565;
        }
    }

    private /* synthetic */ ImageBitmapConfig(int i11) {
        this.value = i11;
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ ImageBitmapConfig m3082boximpl(int i11) {
        return new ImageBitmapConfig(i11);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m3083constructorimpl(int i11) {
        return i11;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m3084equalsimpl(int i11, Object obj) {
        return (obj instanceof ImageBitmapConfig) && i11 == ((ImageBitmapConfig) obj).m3088unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m3085equalsimpl0(int i11, int i12) {
        return i11 == i12;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m3086hashCodeimpl(int i11) {
        return i11;
    }

    @NotNull
    /* renamed from: toString-impl  reason: not valid java name */
    public static String m3087toStringimpl(int i11) {
        if (m3085equalsimpl0(i11, Argb8888)) {
            return "Argb8888";
        }
        if (m3085equalsimpl0(i11, Alpha8)) {
            return "Alpha8";
        }
        if (m3085equalsimpl0(i11, Rgb565)) {
            return "Rgb565";
        }
        if (m3085equalsimpl0(i11, F16)) {
            return "F16";
        }
        if (m3085equalsimpl0(i11, Gpu)) {
            return "Gpu";
        }
        return "Unknown";
    }

    public boolean equals(Object obj) {
        return m3084equalsimpl(this.value, obj);
    }

    public final int getValue() {
        return this.value;
    }

    public int hashCode() {
        return m3086hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m3087toStringimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m3088unboximpl() {
        return this.value;
    }
}
