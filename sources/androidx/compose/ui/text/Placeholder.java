package androidx.compose.ui.text;

import androidx.compose.runtime.Immutable;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Immutable
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B \u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0002\u0010\u0007J1\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u001c\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u001c\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000e\u0010\t\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0019"}, d2 = {"Landroidx/compose/ui/text/Placeholder;", "", "width", "Landroidx/compose/ui/unit/TextUnit;", "height", "placeholderVerticalAlign", "Landroidx/compose/ui/text/PlaceholderVerticalAlign;", "(JJILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getHeight-XSAIIZE", "()J", "J", "getPlaceholderVerticalAlign-J6kI3mc", "()I", "I", "getWidth-XSAIIZE", "copy", "copy-K8Q-__8", "(JJI)Landroidx/compose/ui/text/Placeholder;", "equals", "", "other", "hashCode", "", "toString", "", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Placeholder {
    private final long height;
    private final int placeholderVerticalAlign;
    private final long width;

    private Placeholder(long j11, long j12, int i11) {
        this.width = j11;
        this.height = j12;
        this.placeholderVerticalAlign = i11;
        if (!(!TextUnitKt.m5677isUnspecifiedR2X_6o(j11))) {
            throw new IllegalArgumentException("width cannot be TextUnit.Unspecified".toString());
        } else if (!(!TextUnitKt.m5677isUnspecifiedR2X_6o(j12))) {
            throw new IllegalArgumentException("height cannot be TextUnit.Unspecified".toString());
        }
    }

    public /* synthetic */ Placeholder(long j11, long j12, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, j12, i11);
    }

    /* renamed from: copy-K8Q-__8$default  reason: not valid java name */
    public static /* synthetic */ Placeholder m4964copyK8Q__8$default(Placeholder placeholder, long j11, long j12, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            j11 = placeholder.width;
        }
        long j13 = j11;
        if ((i12 & 2) != 0) {
            j12 = placeholder.height;
        }
        long j14 = j12;
        if ((i12 & 4) != 0) {
            i11 = placeholder.placeholderVerticalAlign;
        }
        return placeholder.m4965copyK8Q__8(j13, j14, i11);
    }

    @NotNull
    /* renamed from: copy-K8Q-__8  reason: not valid java name */
    public final Placeholder m4965copyK8Q__8(long j11, long j12, int i11) {
        return new Placeholder(j11, j12, i11, (DefaultConstructorMarker) null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Placeholder)) {
            return false;
        }
        Placeholder placeholder = (Placeholder) obj;
        if (TextUnit.m5656equalsimpl0(this.width, placeholder.width) && TextUnit.m5656equalsimpl0(this.height, placeholder.height) && PlaceholderVerticalAlign.m4972equalsimpl0(this.placeholderVerticalAlign, placeholder.placeholderVerticalAlign)) {
            return true;
        }
        return false;
    }

    /* renamed from: getHeight-XSAIIZE  reason: not valid java name */
    public final long m4966getHeightXSAIIZE() {
        return this.height;
    }

    /* renamed from: getPlaceholderVerticalAlign-J6kI3mc  reason: not valid java name */
    public final int m4967getPlaceholderVerticalAlignJ6kI3mc() {
        return this.placeholderVerticalAlign;
    }

    /* renamed from: getWidth-XSAIIZE  reason: not valid java name */
    public final long m4968getWidthXSAIIZE() {
        return this.width;
    }

    public int hashCode() {
        return (((TextUnit.m5660hashCodeimpl(this.width) * 31) + TextUnit.m5660hashCodeimpl(this.height)) * 31) + PlaceholderVerticalAlign.m4973hashCodeimpl(this.placeholderVerticalAlign);
    }

    @NotNull
    public String toString() {
        return "Placeholder(width=" + TextUnit.m5666toStringimpl(this.width) + ", height=" + TextUnit.m5666toStringimpl(this.height) + ", placeholderVerticalAlign=" + PlaceholderVerticalAlign.m4974toStringimpl(this.placeholderVerticalAlign) + ')';
    }
}
