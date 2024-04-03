package androidx.compose.foundation.text;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.TextRange;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\b\u0001\u0018\u0000 12\u00020\u0001:\u00011B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J%\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020(H\u0000¢\u0006\u0002\b)J\u001b\u0010*\u001a\u00020(2\u0006\u0010+\u001a\u00020\u001dø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b,\u0010-J&\u0010.\u001a\u00020$2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020(2\u0006\u00100\u001a\u00020(R+\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00068F@BX\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR+\u0010\u0010\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00068F@FX\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0011\u0010\u000b\"\u0004\b\u0012\u0010\rR+\u0010\u0014\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00048F@FX\u0002¢\u0006\u0012\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R%\u0010\u001c\u001a\u00020\u001dX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00062"}, d2 = {"Landroidx/compose/foundation/text/TextFieldScrollerPosition;", "", "()V", "initialOrientation", "Landroidx/compose/foundation/gestures/Orientation;", "initial", "", "(Landroidx/compose/foundation/gestures/Orientation;F)V", "<set-?>", "maximum", "getMaximum", "()F", "setMaximum", "(F)V", "maximum$delegate", "Landroidx/compose/runtime/MutableState;", "offset", "getOffset", "setOffset", "offset$delegate", "orientation", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "setOrientation", "(Landroidx/compose/foundation/gestures/Orientation;)V", "orientation$delegate", "previousCursorRect", "Landroidx/compose/ui/geometry/Rect;", "previousSelection", "Landroidx/compose/ui/text/TextRange;", "getPreviousSelection-d9O1mEE", "()J", "setPreviousSelection-5zc-tL8", "(J)V", "J", "coerceOffset", "", "cursorStart", "cursorEnd", "containerSize", "", "coerceOffset$foundation_release", "getOffsetToFollow", "selection", "getOffsetToFollow-5zc-tL8", "(J)I", "update", "cursorRect", "textFieldSize", "Companion", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Stable
public final class TextFieldScrollerPosition {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final Saver<TextFieldScrollerPosition, Object> Saver = ListSaverKt.listSaver(TextFieldScrollerPosition$Companion$Saver$1.INSTANCE, TextFieldScrollerPosition$Companion$Saver$2.INSTANCE);
    @NotNull
    private final MutableState maximum$delegate;
    @NotNull
    private final MutableState offset$delegate;
    @NotNull
    private final MutableState orientation$delegate;
    @NotNull
    private Rect previousCursorRect;
    private long previousSelection;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/foundation/text/TextFieldScrollerPosition$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/text/TextFieldScrollerPosition;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Saver<TextFieldScrollerPosition, Object> getSaver() {
            return TextFieldScrollerPosition.Saver;
        }
    }

    public TextFieldScrollerPosition(@NotNull Orientation orientation, float f11) {
        Intrinsics.checkNotNullParameter(orientation, "initialOrientation");
        this.offset$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(f11), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.maximum$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.previousCursorRect = Rect.Companion.getZero();
        this.previousSelection = TextRange.Companion.m5043getZerod9O1mEE();
        this.orientation$delegate = SnapshotStateKt.mutableStateOf(orientation, SnapshotStateKt.structuralEqualityPolicy());
    }

    private final void setMaximum(float f11) {
        this.maximum$delegate.setValue(Float.valueOf(f11));
    }

    public final void coerceOffset$foundation_release(float f11, float f12, int i11) {
        float f13;
        int i12;
        float offset = getOffset();
        float f14 = (float) i11;
        float f15 = offset + f14;
        if (f12 > f15 || (f11 < offset && f12 - f11 > f14)) {
            f13 = f12 - f15;
        } else if (i12 >= 0 || f12 - f11 > f14) {
            f13 = 0.0f;
        } else {
            f13 = f11 - offset;
        }
        setOffset(getOffset() + f13);
    }

    public final float getMaximum() {
        return ((Number) this.maximum$delegate.getValue()).floatValue();
    }

    public final float getOffset() {
        return ((Number) this.offset$delegate.getValue()).floatValue();
    }

    /* renamed from: getOffsetToFollow-5zc-tL8  reason: not valid java name */
    public final int m918getOffsetToFollow5zctL8(long j11) {
        if (TextRange.m5038getStartimpl(j11) != TextRange.m5038getStartimpl(this.previousSelection)) {
            return TextRange.m5038getStartimpl(j11);
        }
        if (TextRange.m5033getEndimpl(j11) != TextRange.m5033getEndimpl(this.previousSelection)) {
            return TextRange.m5033getEndimpl(j11);
        }
        return TextRange.m5036getMinimpl(j11);
    }

    @NotNull
    public final Orientation getOrientation() {
        return (Orientation) this.orientation$delegate.getValue();
    }

    /* renamed from: getPreviousSelection-d9O1mEE  reason: not valid java name */
    public final long m919getPreviousSelectiond9O1mEE() {
        return this.previousSelection;
    }

    public final void setOffset(float f11) {
        this.offset$delegate.setValue(Float.valueOf(f11));
    }

    public final void setOrientation(@NotNull Orientation orientation) {
        Intrinsics.checkNotNullParameter(orientation, "<set-?>");
        this.orientation$delegate.setValue(orientation);
    }

    /* renamed from: setPreviousSelection-5zc-tL8  reason: not valid java name */
    public final void m920setPreviousSelection5zctL8(long j11) {
        this.previousSelection = j11;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0035, code lost:
        if (r0 == false) goto L_0x0037;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void update(@org.jetbrains.annotations.NotNull androidx.compose.foundation.gestures.Orientation r5, @org.jetbrains.annotations.NotNull androidx.compose.ui.geometry.Rect r6, int r7, int r8) {
        /*
            r4 = this;
            java.lang.String r0 = "orientation"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "cursorRect"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            int r8 = r8 - r7
            float r8 = (float) r8
            r4.setMaximum(r8)
            float r0 = r6.getLeft()
            androidx.compose.ui.geometry.Rect r1 = r4.previousCursorRect
            float r1 = r1.getLeft()
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0021
            r0 = r1
            goto L_0x0022
        L_0x0021:
            r0 = r2
        L_0x0022:
            if (r0 == 0) goto L_0x0037
            float r0 = r6.getTop()
            androidx.compose.ui.geometry.Rect r3 = r4.previousCursorRect
            float r3 = r3.getTop()
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 != 0) goto L_0x0034
            r0 = r1
            goto L_0x0035
        L_0x0034:
            r0 = r2
        L_0x0035:
            if (r0 != 0) goto L_0x0058
        L_0x0037:
            androidx.compose.foundation.gestures.Orientation r0 = androidx.compose.foundation.gestures.Orientation.Vertical
            if (r5 != r0) goto L_0x003c
            goto L_0x003d
        L_0x003c:
            r1 = r2
        L_0x003d:
            if (r1 == 0) goto L_0x0044
            float r5 = r6.getTop()
            goto L_0x0048
        L_0x0044:
            float r5 = r6.getLeft()
        L_0x0048:
            if (r1 == 0) goto L_0x004f
            float r0 = r6.getBottom()
            goto L_0x0053
        L_0x004f:
            float r0 = r6.getRight()
        L_0x0053:
            r4.coerceOffset$foundation_release(r5, r0, r7)
            r4.previousCursorRect = r6
        L_0x0058:
            float r5 = r4.getOffset()
            r6 = 0
            float r5 = kotlin.ranges.RangesKt___RangesKt.coerceIn((float) r5, (float) r6, (float) r8)
            r4.setOffset(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.TextFieldScrollerPosition.update(androidx.compose.foundation.gestures.Orientation, androidx.compose.ui.geometry.Rect, int, int):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TextFieldScrollerPosition(Orientation orientation, float f11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(orientation, (i11 & 2) != 0 ? 0.0f : f11);
    }

    public TextFieldScrollerPosition() {
        this(Orientation.Vertical, 0.0f, 2, (DefaultConstructorMarker) null);
    }
}
