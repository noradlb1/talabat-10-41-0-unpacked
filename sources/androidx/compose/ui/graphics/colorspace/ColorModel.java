package androidx.compose.ui.graphics.colorspace;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import l.a;
import org.jetbrains.annotations.NotNull;

@Immutable
@JvmInline
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0014\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u000bJ\u000f\u0010\u0013\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0006\u001a\u00020\u00078FX\u0004¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0001\u0002\u0001\u00020\u0003ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/ColorModel;", "", "packedValue", "", "constructor-impl", "(J)J", "componentCount", "", "getComponentCount$annotations", "()V", "getComponentCount-impl", "(J)I", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ColorModel {
    /* access modifiers changed from: private */
    public static final long Cmyk;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final long Lab;
    /* access modifiers changed from: private */
    public static final long Rgb;
    /* access modifiers changed from: private */
    public static final long Xyz;
    private final long packedValue;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u001c\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000e"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/ColorModel$Companion;", "", "()V", "Cmyk", "Landroidx/compose/ui/graphics/colorspace/ColorModel;", "getCmyk-xdoWZVw", "()J", "J", "Lab", "getLab-xdoWZVw", "Rgb", "getRgb-xdoWZVw", "Xyz", "getXyz-xdoWZVw", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getCmyk-xdoWZVw  reason: not valid java name */
        public final long m3313getCmykxdoWZVw() {
            return ColorModel.Cmyk;
        }

        /* renamed from: getLab-xdoWZVw  reason: not valid java name */
        public final long m3314getLabxdoWZVw() {
            return ColorModel.Lab;
        }

        /* renamed from: getRgb-xdoWZVw  reason: not valid java name */
        public final long m3315getRgbxdoWZVw() {
            return ColorModel.Rgb;
        }

        /* renamed from: getXyz-xdoWZVw  reason: not valid java name */
        public final long m3316getXyzxdoWZVw() {
            return ColorModel.Xyz;
        }
    }

    static {
        long j11 = (long) 3;
        long j12 = j11 << 32;
        Rgb = m3306constructorimpl((((long) 0) & 4294967295L) | j12);
        Xyz = m3306constructorimpl((((long) 1) & 4294967295L) | j12);
        Lab = m3306constructorimpl(j12 | (((long) 2) & 4294967295L));
        Cmyk = m3306constructorimpl((j11 & 4294967295L) | (((long) 4) << 32));
    }

    private /* synthetic */ ColorModel(long j11) {
        this.packedValue = j11;
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ ColorModel m3305boximpl(long j11) {
        return new ColorModel(j11);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m3306constructorimpl(long j11) {
        return j11;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m3307equalsimpl(long j11, Object obj) {
        return (obj instanceof ColorModel) && j11 == ((ColorModel) obj).m3312unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m3308equalsimpl0(long j11, long j12) {
        return j11 == j12;
    }

    @Stable
    public static /* synthetic */ void getComponentCount$annotations() {
    }

    /* renamed from: getComponentCount-impl  reason: not valid java name */
    public static final int m3309getComponentCountimpl(long j11) {
        return (int) (j11 >> 32);
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m3310hashCodeimpl(long j11) {
        return a.a(j11);
    }

    @NotNull
    /* renamed from: toString-impl  reason: not valid java name */
    public static String m3311toStringimpl(long j11) {
        if (m3308equalsimpl0(j11, Rgb)) {
            return "Rgb";
        }
        if (m3308equalsimpl0(j11, Xyz)) {
            return "Xyz";
        }
        if (m3308equalsimpl0(j11, Lab)) {
            return "Lab";
        }
        if (m3308equalsimpl0(j11, Cmyk)) {
            return "Cmyk";
        }
        return "Unknown";
    }

    public boolean equals(Object obj) {
        return m3307equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m3310hashCodeimpl(this.packedValue);
    }

    @NotNull
    public String toString() {
        return m3311toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m3312unboximpl() {
        return this.packedValue;
    }
}
