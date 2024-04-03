package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\u0002\u0010\tJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J(\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0006H\u0016J \u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\n\u0010\u001d\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J_\u0010 \u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0004\u0012\u00020\u00150!2\u0006\u0010\"\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u00112\b\u0010$\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0013H\u0016ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b)\u0010*R\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006+"}, d2 = {"Landroidx/compose/foundation/text/selection/MultiWidgetSelectionDelegate;", "Landroidx/compose/foundation/text/selection/Selectable;", "selectableId", "", "coordinatesCallback", "Lkotlin/Function0;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "layoutResultCallback", "Landroidx/compose/ui/text/TextLayoutResult;", "(JLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "getSelectableId", "()J", "getBoundingBox", "Landroidx/compose/ui/geometry/Rect;", "offset", "", "getHandlePosition", "Landroidx/compose/ui/geometry/Offset;", "selection", "Landroidx/compose/foundation/text/selection/Selection;", "isStartHandle", "", "getHandlePosition-dBAh8RU", "(Landroidx/compose/foundation/text/selection/Selection;Z)J", "getLayoutCoordinates", "getRangeOfLineContaining", "Landroidx/compose/ui/text/TextRange;", "getRangeOfLineContaining--jx7JFs", "(I)J", "getSelectAllSelection", "getText", "Landroidx/compose/ui/text/AnnotatedString;", "updateSelection", "Lkotlin/Pair;", "startHandlePosition", "endHandlePosition", "previousHandlePosition", "containerLayoutCoordinates", "adjustment", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "previousSelection", "updateSelection-qCDeeow", "(JJLandroidx/compose/ui/geometry/Offset;ZLandroidx/compose/ui/layout/LayoutCoordinates;Landroidx/compose/foundation/text/selection/SelectionAdjustment;Landroidx/compose/foundation/text/selection/Selection;)Lkotlin/Pair;", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MultiWidgetSelectionDelegate implements Selectable {
    @NotNull
    private final Function0<LayoutCoordinates> coordinatesCallback;
    @NotNull
    private final Function0<TextLayoutResult> layoutResultCallback;
    private final long selectableId;

    public MultiWidgetSelectionDelegate(long j11, @NotNull Function0<? extends LayoutCoordinates> function0, @NotNull Function0<TextLayoutResult> function02) {
        Intrinsics.checkNotNullParameter(function0, "coordinatesCallback");
        Intrinsics.checkNotNullParameter(function02, "layoutResultCallback");
        this.selectableId = j11;
        this.coordinatesCallback = function0;
        this.layoutResultCallback = function02;
    }

    @NotNull
    public Rect getBoundingBox(int i11) {
        TextLayoutResult invoke = this.layoutResultCallback.invoke();
        if (invoke == null) {
            return Rect.Companion.getZero();
        }
        int length = invoke.getLayoutInput().getText().length();
        if (length < 1) {
            return Rect.Companion.getZero();
        }
        return invoke.getBoundingBox(RangesKt___RangesKt.coerceIn(i11, 0, length - 1));
    }

    /* renamed from: getHandlePosition-dBAh8RU  reason: not valid java name */
    public long m953getHandlePositiondBAh8RU(@NotNull Selection selection, boolean z11) {
        Selection.AnchorInfo anchorInfo;
        Intrinsics.checkNotNullParameter(selection, "selection");
        if ((z11 && selection.getStart().getSelectableId() != getSelectableId()) || (!z11 && selection.getEnd().getSelectableId() != getSelectableId())) {
            return Offset.Companion.m2692getZeroF1C5BW0();
        }
        if (getLayoutCoordinates() == null) {
            return Offset.Companion.m2692getZeroF1C5BW0();
        }
        TextLayoutResult invoke = this.layoutResultCallback.invoke();
        if (invoke == null) {
            return Offset.Companion.m2692getZeroF1C5BW0();
        }
        if (z11) {
            anchorInfo = selection.getStart();
        } else {
            anchorInfo = selection.getEnd();
        }
        return TextSelectionDelegateKt.getSelectionHandleCoordinates(invoke, anchorInfo.getOffset(), z11, selection.getHandlesCrossed());
    }

    @Nullable
    public LayoutCoordinates getLayoutCoordinates() {
        LayoutCoordinates invoke = this.coordinatesCallback.invoke();
        if (invoke == null || !invoke.isAttached()) {
            return null;
        }
        return invoke;
    }

    /* renamed from: getRangeOfLineContaining--jx7JFs  reason: not valid java name */
    public long m954getRangeOfLineContainingjx7JFs(int i11) {
        TextLayoutResult invoke = this.layoutResultCallback.invoke();
        if (invoke == null) {
            return TextRange.Companion.m5043getZerod9O1mEE();
        }
        int length = invoke.getLayoutInput().getText().length();
        if (length < 1) {
            return TextRange.Companion.m5043getZerod9O1mEE();
        }
        int lineForOffset = invoke.getLineForOffset(RangesKt___RangesKt.coerceIn(i11, 0, length - 1));
        return TextRangeKt.TextRange(invoke.getLineStart(lineForOffset), invoke.getLineEnd(lineForOffset, true));
    }

    @Nullable
    public Selection getSelectAllSelection() {
        TextLayoutResult invoke = this.layoutResultCallback.invoke();
        if (invoke == null) {
            return null;
        }
        return MultiWidgetSelectionDelegateKt.m957getAssembledSelectionInfovJH6DeI(TextRangeKt.TextRange(0, invoke.getLayoutInput().getText().length()), false, getSelectableId(), invoke);
    }

    public long getSelectableId() {
        return this.selectableId;
    }

    @NotNull
    public AnnotatedString getText() {
        TextLayoutResult invoke = this.layoutResultCallback.invoke();
        if (invoke == null) {
            return new AnnotatedString("", (List) null, (List) null, 6, (DefaultConstructorMarker) null);
        }
        return invoke.getLayoutInput().getText();
    }

    @NotNull
    /* renamed from: updateSelection-qCDeeow  reason: not valid java name */
    public Pair<Selection, Boolean> m955updateSelectionqCDeeow(long j11, long j12, @Nullable Offset offset, boolean z11, @NotNull LayoutCoordinates layoutCoordinates, @NotNull SelectionAdjustment selectionAdjustment, @Nullable Selection selection) {
        boolean z12;
        Offset offset2;
        LayoutCoordinates layoutCoordinates2 = layoutCoordinates;
        Intrinsics.checkNotNullParameter(layoutCoordinates2, "containerLayoutCoordinates");
        Intrinsics.checkNotNullParameter(selectionAdjustment, "adjustment");
        if (selection == null || (getSelectableId() == selection.getStart().getSelectableId() && getSelectableId() == selection.getEnd().getSelectableId())) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z12) {
            LayoutCoordinates layoutCoordinates3 = getLayoutCoordinates();
            if (layoutCoordinates3 == null) {
                return new Pair<>(null, Boolean.FALSE);
            }
            TextLayoutResult invoke = this.layoutResultCallback.invoke();
            if (invoke == null) {
                return new Pair<>(null, Boolean.FALSE);
            }
            long r02 = layoutCoordinates2.m4474localPositionOfR5De75A(layoutCoordinates3, Offset.Companion.m2692getZeroF1C5BW0());
            long r42 = Offset.m2680minusMKHz9U(j11, r02);
            long r62 = Offset.m2680minusMKHz9U(j12, r02);
            if (offset != null) {
                offset2 = Offset.m2665boximpl(Offset.m2680minusMKHz9U(offset.m2686unboximpl(), r02));
            } else {
                offset2 = null;
            }
            return MultiWidgetSelectionDelegateKt.m959getTextSelectionInfoyM0VcXU(invoke, r42, r62, offset2, getSelectableId(), selectionAdjustment, selection, z11);
        }
        throw new IllegalArgumentException("The given previousSelection doesn't belong to this selectable.".toString());
    }
}
