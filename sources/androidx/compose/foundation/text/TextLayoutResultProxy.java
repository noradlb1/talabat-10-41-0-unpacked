package androidx.compose.foundation.text;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.TextLayoutResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017J%\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u001aø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b \u0010!J\u0019\u0010\"\u001a\u00020\u001a*\u00020\u001aH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b#\u0010$J\u0019\u0010%\u001a\u00020\u001a*\u00020\u001aH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b&\u0010$R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006'"}, d2 = {"Landroidx/compose/foundation/text/TextLayoutResultProxy;", "", "value", "Landroidx/compose/ui/text/TextLayoutResult;", "(Landroidx/compose/ui/text/TextLayoutResult;)V", "decorationBoxCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getDecorationBoxCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "setDecorationBoxCoordinates", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "innerTextFieldCoordinates", "getInnerTextFieldCoordinates", "setInnerTextFieldCoordinates", "getValue", "()Landroidx/compose/ui/text/TextLayoutResult;", "getLineEnd", "", "lineIndex", "visibleEnd", "", "getLineForVerticalPosition", "vertical", "", "getOffsetForPosition", "position", "Landroidx/compose/ui/geometry/Offset;", "coerceInVisibleBounds", "getOffsetForPosition-3MmeM6k", "(JZ)I", "isPositionOnText", "offset", "isPositionOnText-k-4lQ0M", "(J)Z", "coercedInVisibleBoundsOfInputText", "coercedInVisibleBoundsOfInputText-MK-Hz9U", "(J)J", "relativeToInputText", "relativeToInputText-MK-Hz9U", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TextLayoutResultProxy {
    @Nullable
    private LayoutCoordinates decorationBoxCoordinates;
    @Nullable
    private LayoutCoordinates innerTextFieldCoordinates;
    @NotNull
    private final TextLayoutResult value;

    public TextLayoutResultProxy(@NotNull TextLayoutResult textLayoutResult) {
        Intrinsics.checkNotNullParameter(textLayoutResult, "value");
        this.value = textLayoutResult;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001c, code lost:
        if (r2 == null) goto L_0x001e;
     */
    /* renamed from: coercedInVisibleBoundsOfInputText-MK-Hz9U  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final long m931coercedInVisibleBoundsOfInputTextMKHz9U(long r6) {
        /*
            r5 = this;
            androidx.compose.ui.layout.LayoutCoordinates r0 = r5.innerTextFieldCoordinates
            if (r0 == 0) goto L_0x001e
            boolean r1 = r0.isAttached()
            if (r1 == 0) goto L_0x0016
            androidx.compose.ui.layout.LayoutCoordinates r1 = r5.decorationBoxCoordinates
            r2 = 0
            if (r1 == 0) goto L_0x001c
            r3 = 0
            r4 = 2
            androidx.compose.ui.geometry.Rect r2 = j0.b.c(r1, r0, r3, r4, r2)
            goto L_0x001c
        L_0x0016:
            androidx.compose.ui.geometry.Rect$Companion r0 = androidx.compose.ui.geometry.Rect.Companion
            androidx.compose.ui.geometry.Rect r2 = r0.getZero()
        L_0x001c:
            if (r2 != 0) goto L_0x0024
        L_0x001e:
            androidx.compose.ui.geometry.Rect$Companion r0 = androidx.compose.ui.geometry.Rect.Companion
            androidx.compose.ui.geometry.Rect r2 = r0.getZero()
        L_0x0024:
            long r6 = androidx.compose.foundation.text.TextLayoutResultProxyKt.m937coerceIn3MmeM6k(r6, r2)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.TextLayoutResultProxy.m931coercedInVisibleBoundsOfInputTextMKHz9U(long):long");
    }

    public static /* synthetic */ int getLineEnd$default(TextLayoutResultProxy textLayoutResultProxy, int i11, boolean z11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            z11 = false;
        }
        return textLayoutResultProxy.getLineEnd(i11, z11);
    }

    /* renamed from: getOffsetForPosition-3MmeM6k$default  reason: not valid java name */
    public static /* synthetic */ int m932getOffsetForPosition3MmeM6k$default(TextLayoutResultProxy textLayoutResultProxy, long j11, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = true;
        }
        return textLayoutResultProxy.m934getOffsetForPosition3MmeM6k(j11, z11);
    }

    /* renamed from: relativeToInputText-MK-Hz9U  reason: not valid java name */
    private final long m933relativeToInputTextMKHz9U(long j11) {
        Offset offset;
        long j12;
        LayoutCoordinates layoutCoordinates = this.innerTextFieldCoordinates;
        if (layoutCoordinates == null) {
            return j11;
        }
        LayoutCoordinates layoutCoordinates2 = this.decorationBoxCoordinates;
        if (layoutCoordinates2 != null) {
            if (!layoutCoordinates.isAttached() || !layoutCoordinates2.isAttached()) {
                j12 = j11;
            } else {
                j12 = layoutCoordinates.m4474localPositionOfR5De75A(layoutCoordinates2, j11);
            }
            offset = Offset.m2665boximpl(j12);
        } else {
            offset = null;
        }
        if (offset != null) {
            return offset.m2686unboximpl();
        }
        return j11;
    }

    @Nullable
    public final LayoutCoordinates getDecorationBoxCoordinates() {
        return this.decorationBoxCoordinates;
    }

    @Nullable
    public final LayoutCoordinates getInnerTextFieldCoordinates() {
        return this.innerTextFieldCoordinates;
    }

    public final int getLineEnd(int i11, boolean z11) {
        return this.value.getLineEnd(i11, z11);
    }

    public final int getLineForVerticalPosition(float f11) {
        return this.value.getLineForVerticalPosition(Offset.m2677getYimpl(m933relativeToInputTextMKHz9U(m931coercedInVisibleBoundsOfInputTextMKHz9U(OffsetKt.Offset(0.0f, f11)))));
    }

    /* renamed from: getOffsetForPosition-3MmeM6k  reason: not valid java name */
    public final int m934getOffsetForPosition3MmeM6k(long j11, boolean z11) {
        if (z11) {
            j11 = m931coercedInVisibleBoundsOfInputTextMKHz9U(j11);
        }
        return this.value.m5013getOffsetForPositionk4lQ0M(m933relativeToInputTextMKHz9U(j11));
    }

    @NotNull
    public final TextLayoutResult getValue() {
        return this.value;
    }

    /* renamed from: isPositionOnText-k-4lQ0M  reason: not valid java name */
    public final boolean m935isPositionOnTextk4lQ0M(long j11) {
        long r42 = m933relativeToInputTextMKHz9U(m931coercedInVisibleBoundsOfInputTextMKHz9U(j11));
        int lineForVerticalPosition = this.value.getLineForVerticalPosition(Offset.m2677getYimpl(r42));
        if (Offset.m2676getXimpl(r42) < this.value.getLineLeft(lineForVerticalPosition) || Offset.m2676getXimpl(r42) > this.value.getLineRight(lineForVerticalPosition)) {
            return false;
        }
        return true;
    }

    public final void setDecorationBoxCoordinates(@Nullable LayoutCoordinates layoutCoordinates) {
        this.decorationBoxCoordinates = layoutCoordinates;
    }

    public final void setInnerTextFieldCoordinates(@Nullable LayoutCoordinates layoutCoordinates) {
        this.innerTextFieldCoordinates = layoutCoordinates;
    }
}
