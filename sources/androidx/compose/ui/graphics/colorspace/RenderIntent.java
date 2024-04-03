package androidx.compose.ui.graphics.colorspace;

import androidx.compose.runtime.Immutable;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Immutable
@JvmInline
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0014\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0001\u0002\u0001\u00020\u0003ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/RenderIntent;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class RenderIntent {
    /* access modifiers changed from: private */
    public static final int Absolute = m3325constructorimpl(3);
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final int Perceptual = m3325constructorimpl(0);
    /* access modifiers changed from: private */
    public static final int Relative = m3325constructorimpl(1);
    /* access modifiers changed from: private */
    public static final int Saturation = m3325constructorimpl(2);
    private final int value;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u001c\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000e"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/RenderIntent$Companion;", "", "()V", "Absolute", "Landroidx/compose/ui/graphics/colorspace/RenderIntent;", "getAbsolute-uksYyKA", "()I", "I", "Perceptual", "getPerceptual-uksYyKA", "Relative", "getRelative-uksYyKA", "Saturation", "getSaturation-uksYyKA", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getAbsolute-uksYyKA  reason: not valid java name */
        public final int m3331getAbsoluteuksYyKA() {
            return RenderIntent.Absolute;
        }

        /* renamed from: getPerceptual-uksYyKA  reason: not valid java name */
        public final int m3332getPerceptualuksYyKA() {
            return RenderIntent.Perceptual;
        }

        /* renamed from: getRelative-uksYyKA  reason: not valid java name */
        public final int m3333getRelativeuksYyKA() {
            return RenderIntent.Relative;
        }

        /* renamed from: getSaturation-uksYyKA  reason: not valid java name */
        public final int m3334getSaturationuksYyKA() {
            return RenderIntent.Saturation;
        }
    }

    private /* synthetic */ RenderIntent(int i11) {
        this.value = i11;
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ RenderIntent m3324boximpl(int i11) {
        return new RenderIntent(i11);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m3325constructorimpl(int i11) {
        return i11;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m3326equalsimpl(int i11, Object obj) {
        return (obj instanceof RenderIntent) && i11 == ((RenderIntent) obj).m3330unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m3327equalsimpl0(int i11, int i12) {
        return i11 == i12;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m3328hashCodeimpl(int i11) {
        return i11;
    }

    @NotNull
    /* renamed from: toString-impl  reason: not valid java name */
    public static String m3329toStringimpl(int i11) {
        if (m3327equalsimpl0(i11, Perceptual)) {
            return "Perceptual";
        }
        if (m3327equalsimpl0(i11, Relative)) {
            return "Relative";
        }
        if (m3327equalsimpl0(i11, Saturation)) {
            return ExifInterface.TAG_SATURATION;
        }
        if (m3327equalsimpl0(i11, Absolute)) {
            return "Absolute";
        }
        return "Unknown";
    }

    public boolean equals(Object obj) {
        return m3326equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m3328hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m3329toStringimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m3330unboximpl() {
        return this.value;
    }
}
