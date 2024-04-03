package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TextFieldState;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.IntSize;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a%\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\b\u001a%\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\r\u0010\u000e\u001a\u0014\u0010\u000f\u001a\u00020\u0003*\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"TextFieldSelectionHandle", "", "isStartHandle", "", "direction", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "manager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "(ZLandroidx/compose/ui/text/style/ResolvedTextDirection;Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Landroidx/compose/runtime/Composer;I)V", "calculateSelectionMagnifierCenterAndroid", "Landroidx/compose/ui/geometry/Offset;", "magnifierSize", "Landroidx/compose/ui/unit/IntSize;", "calculateSelectionMagnifierCenterAndroid-O0kMr_c", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;J)J", "isSelectionHandleInVisibleBound", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class TextFieldSelectionManagerKt {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Handle.values().length];
            iArr[Handle.Cursor.ordinal()] = 1;
            iArr[Handle.SelectionStart.ordinal()] = 2;
            iArr[Handle.SelectionEnd.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void TextFieldSelectionHandle(boolean z11, @NotNull ResolvedTextDirection resolvedTextDirection, @NotNull TextFieldSelectionManager textFieldSelectionManager, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(resolvedTextDirection, HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION);
        Intrinsics.checkNotNullParameter(textFieldSelectionManager, "manager");
        Composer startRestartGroup = composer.startRestartGroup(-1344558920);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1344558920, i11, -1, "androidx.compose.foundation.text.selection.TextFieldSelectionHandle (TextFieldSelectionManager.kt:806)");
        }
        Boolean valueOf = Boolean.valueOf(z11);
        startRestartGroup.startReplaceableGroup(511388516);
        boolean changed = startRestartGroup.changed((Object) valueOf) | startRestartGroup.changed((Object) textFieldSelectionManager);
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = textFieldSelectionManager.handleDragObserver$foundation_release(z11);
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        TextDragObserver textDragObserver = (TextDragObserver) rememberedValue;
        int i12 = i11 << 3;
        AndroidSelectionHandles_androidKt.m944SelectionHandle8fL75g(textFieldSelectionManager.m1051getHandlePositiontuRUvjQ$foundation_release(z11), z11, resolvedTextDirection, TextRange.m5037getReversedimpl(textFieldSelectionManager.getValue$foundation_release().m5234getSelectiond9O1mEE()), SuspendingPointerInputFilterKt.pointerInput((Modifier) Modifier.Companion, (Object) textDragObserver, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new TextFieldSelectionManagerKt$TextFieldSelectionHandle$1(textDragObserver, (Continuation<? super TextFieldSelectionManagerKt$TextFieldSelectionHandle$1>) null)), (Function2<? super Composer, ? super Integer, Unit>) null, startRestartGroup, (i12 & 112) | 196608 | (i12 & 896));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TextFieldSelectionManagerKt$TextFieldSelectionHandle$2(z11, resolvedTextDirection, textFieldSelectionManager, i11));
        }
    }

    /* renamed from: calculateSelectionMagnifierCenterAndroid-O0kMr_c  reason: not valid java name */
    public static final long m1065calculateSelectionMagnifierCenterAndroidO0kMr_c(@NotNull TextFieldSelectionManager textFieldSelectionManager, long j11) {
        boolean z11;
        int i11;
        int i12;
        TextLayoutResultProxy layoutResult;
        TextLayoutResult value;
        LayoutCoordinates layoutCoordinates;
        TextLayoutResultProxy layoutResult2;
        LayoutCoordinates innerTextFieldCoordinates;
        boolean z12;
        TextFieldSelectionManager textFieldSelectionManager2 = textFieldSelectionManager;
        Intrinsics.checkNotNullParameter(textFieldSelectionManager, "manager");
        if (textFieldSelectionManager.getValue$foundation_release().getText().length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return Offset.Companion.m2691getUnspecifiedF1C5BW0();
        }
        Handle draggingHandle = textFieldSelectionManager.getDraggingHandle();
        if (draggingHandle == null) {
            i11 = -1;
        } else {
            i11 = WhenMappings.$EnumSwitchMapping$0[draggingHandle.ordinal()];
        }
        if (i11 == -1) {
            return Offset.Companion.m2691getUnspecifiedF1C5BW0();
        }
        if (i11 == 1 || i11 == 2) {
            i12 = TextRange.m5038getStartimpl(textFieldSelectionManager.getValue$foundation_release().m5234getSelectiond9O1mEE());
        } else if (i11 == 3) {
            i12 = TextRange.m5033getEndimpl(textFieldSelectionManager.getValue$foundation_release().m5234getSelectiond9O1mEE());
        } else {
            throw new NoWhenBranchMatchedException();
        }
        int coerceIn = RangesKt___RangesKt.coerceIn(textFieldSelectionManager.getOffsetMapping$foundation_release().originalToTransformed(i12), (ClosedRange<Integer>) StringsKt__StringsKt.getIndices(textFieldSelectionManager.getValue$foundation_release().getText()));
        TextFieldState state$foundation_release = textFieldSelectionManager.getState$foundation_release();
        if (state$foundation_release == null || (layoutResult = state$foundation_release.getLayoutResult()) == null || (value = layoutResult.getValue()) == null) {
            return Offset.Companion.m2691getUnspecifiedF1C5BW0();
        }
        long r62 = value.getBoundingBox(coerceIn).m2706getCenterF1C5BW0();
        TextFieldState state$foundation_release2 = textFieldSelectionManager.getState$foundation_release();
        if (state$foundation_release2 == null || (layoutCoordinates = state$foundation_release2.getLayoutCoordinates()) == null) {
            return Offset.Companion.m2691getUnspecifiedF1C5BW0();
        }
        TextFieldState state$foundation_release3 = textFieldSelectionManager.getState$foundation_release();
        if (state$foundation_release3 == null || (layoutResult2 = state$foundation_release3.getLayoutResult()) == null || (innerTextFieldCoordinates = layoutResult2.getInnerTextFieldCoordinates()) == null) {
            return Offset.Companion.m2691getUnspecifiedF1C5BW0();
        }
        Offset r102 = textFieldSelectionManager.m1049getCurrentDragPosition_m7T9E();
        if (r102 == null) {
            return Offset.Companion.m2691getUnspecifiedF1C5BW0();
        }
        float r103 = Offset.m2676getXimpl(innerTextFieldCoordinates.m4474localPositionOfR5De75A(layoutCoordinates, r102.m2686unboximpl()));
        int lineForOffset = value.getLineForOffset(coerceIn);
        int lineStart = value.getLineStart(lineForOffset);
        int lineEnd = value.getLineEnd(lineForOffset, true);
        if (TextRange.m5038getStartimpl(textFieldSelectionManager.getValue$foundation_release().m5234getSelectiond9O1mEE()) > TextRange.m5033getEndimpl(textFieldSelectionManager.getValue$foundation_release().m5234getSelectiond9O1mEE())) {
            z12 = true;
        } else {
            z12 = false;
        }
        float horizontalPosition = TextSelectionDelegateKt.getHorizontalPosition(value, lineStart, true, z12);
        float horizontalPosition2 = TextSelectionDelegateKt.getHorizontalPosition(value, lineEnd, false, z12);
        float coerceIn2 = RangesKt___RangesKt.coerceIn(r103, Math.min(horizontalPosition, horizontalPosition2), Math.max(horizontalPosition, horizontalPosition2));
        if (Math.abs(r103 - coerceIn2) > ((float) (IntSize.m5638getWidthimpl(j11) / 2))) {
            return Offset.Companion.m2691getUnspecifiedF1C5BW0();
        }
        return layoutCoordinates.m4474localPositionOfR5De75A(innerTextFieldCoordinates, OffsetKt.Offset(coerceIn2, Offset.m2677getYimpl(r62)));
    }

    public static final boolean isSelectionHandleInVisibleBound(@NotNull TextFieldSelectionManager textFieldSelectionManager, boolean z11) {
        LayoutCoordinates layoutCoordinates;
        Rect visibleBounds;
        Intrinsics.checkNotNullParameter(textFieldSelectionManager, "<this>");
        TextFieldState state$foundation_release = textFieldSelectionManager.getState$foundation_release();
        if (state$foundation_release == null || (layoutCoordinates = state$foundation_release.getLayoutCoordinates()) == null || (visibleBounds = SelectionManagerKt.visibleBounds(layoutCoordinates)) == null) {
            return false;
        }
        return SelectionManagerKt.m1022containsInclusiveUv8p0NA(visibleBounds, textFieldSelectionManager.m1051getHandlePositiontuRUvjQ$foundation_release(z11));
    }
}
