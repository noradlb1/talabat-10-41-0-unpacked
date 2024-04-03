package androidx.compose.ui.graphics;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.Offset;
import com.checkout.frames.utils.constants.CountryPickerScreenConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Immutable
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB&\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0002\u0010\bJ1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR'\u0010\u0002\u001a\u00020\u00038\u0006X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\u0010\u0012\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\u000fR'\u0010\u0004\u001a\u00020\u00058\u0006X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\u0010\u0012\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\u000f\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001e"}, d2 = {"Landroidx/compose/ui/graphics/Shadow;", "", "color", "Landroidx/compose/ui/graphics/Color;", "offset", "Landroidx/compose/ui/geometry/Offset;", "blurRadius", "", "(JJFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBlurRadius$annotations", "()V", "getBlurRadius", "()F", "getColor-0d7_KjU$annotations", "getColor-0d7_KjU", "()J", "J", "getOffset-F1C5BW0$annotations", "getOffset-F1C5BW0", "copy", "copy-qcb84PM", "(JJF)Landroidx/compose/ui/graphics/Shadow;", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Shadow {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final Shadow None = new Shadow(0, 0, 0.0f, 7, (DefaultConstructorMarker) null);
    private final float blurRadius;
    private final long color;
    private final long offset;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/ui/graphics/Shadow$Companion;", "", "()V", "None", "Landroidx/compose/ui/graphics/Shadow;", "getNone$annotations", "getNone", "()Landroidx/compose/ui/graphics/Shadow;", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Stable
        public static /* synthetic */ void getNone$annotations() {
        }

        @NotNull
        public final Shadow getNone() {
            return Shadow.None;
        }
    }

    private Shadow(long j11, long j12, float f11) {
        this.color = j11;
        this.offset = j12;
        this.blurRadius = f11;
    }

    public /* synthetic */ Shadow(long j11, long j12, float f11, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, j12, f11);
    }

    /* renamed from: copy-qcb84PM$default  reason: not valid java name */
    public static /* synthetic */ Shadow m3226copyqcb84PM$default(Shadow shadow, long j11, long j12, float f11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            j11 = shadow.color;
        }
        long j13 = j11;
        if ((i11 & 2) != 0) {
            j12 = shadow.offset;
        }
        long j14 = j12;
        if ((i11 & 4) != 0) {
            f11 = shadow.blurRadius;
        }
        return shadow.m3229copyqcb84PM(j13, j14, f11);
    }

    @Stable
    public static /* synthetic */ void getBlurRadius$annotations() {
    }

    @Stable
    /* renamed from: getColor-0d7_KjU$annotations  reason: not valid java name */
    public static /* synthetic */ void m3227getColor0d7_KjU$annotations() {
    }

    @Stable
    /* renamed from: getOffset-F1C5BW0$annotations  reason: not valid java name */
    public static /* synthetic */ void m3228getOffsetF1C5BW0$annotations() {
    }

    @NotNull
    /* renamed from: copy-qcb84PM  reason: not valid java name */
    public final Shadow m3229copyqcb84PM(long j11, long j12, float f11) {
        return new Shadow(j11, j12, f11, (DefaultConstructorMarker) null);
    }

    public boolean equals(@Nullable Object obj) {
        boolean z11;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Shadow)) {
            return false;
        }
        Shadow shadow = (Shadow) obj;
        if (!Color.m2920equalsimpl0(this.color, shadow.color) || !Offset.m2673equalsimpl0(this.offset, shadow.offset)) {
            return false;
        }
        if (this.blurRadius == shadow.blurRadius) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            return false;
        }
        return true;
    }

    public final float getBlurRadius() {
        return this.blurRadius;
    }

    /* renamed from: getColor-0d7_KjU  reason: not valid java name */
    public final long m3230getColor0d7_KjU() {
        return this.color;
    }

    /* renamed from: getOffset-F1C5BW0  reason: not valid java name */
    public final long m3231getOffsetF1C5BW0() {
        return this.offset;
    }

    public int hashCode() {
        return (((Color.m2926hashCodeimpl(this.color) * 31) + Offset.m2678hashCodeimpl(this.offset)) * 31) + Float.floatToIntBits(this.blurRadius);
    }

    @NotNull
    public String toString() {
        return "Shadow(color=" + Color.m2927toStringimpl(this.color) + ", offset=" + Offset.m2684toStringimpl(this.offset) + ", blurRadius=" + this.blurRadius + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Shadow(long j11, long j12, float f11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? ColorKt.Color((long) CountryPickerScreenConstants.focusedBorderColor) : j11, (i11 & 2) != 0 ? Offset.Companion.m2692getZeroF1C5BW0() : j12, (i11 & 4) != 0 ? 0.0f : f11, (DefaultConstructorMarker) null);
    }
}
