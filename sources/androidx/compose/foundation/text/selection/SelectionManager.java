package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusChangedModifierKt;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.platform.ClipboardManager;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.TextToolbarStatus;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import com.huawei.hms.flutter.map.constants.Param;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import m0.x1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001b\u0010f\u001a\u00020L2\u0006\u0010g\u001a\u00020\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bh\u0010\"J'\u0010i\u001a\u0004\u0018\u00010\u00162\u0006\u0010j\u001a\u00020\u000f2\u0006\u0010k\u001a\u00020\u0016H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bl\u0010mJ\r\u0010n\u001a\u00020LH\u0000¢\u0006\u0002\boJ\u0017\u0010p\u001a\u0004\u0018\u00010q2\u0006\u0010r\u001a\u00020sH\u0000¢\u0006\u0002\btJ\b\u0010u\u001a\u00020vH\u0002J\u000f\u0010w\u001a\u0004\u0018\u00010xH\u0000¢\u0006\u0002\byJ\u000e\u0010z\u001a\u00020{2\u0006\u0010|\u001a\u00020?J\r\u0010}\u001a\u00020LH\u0000¢\u0006\u0002\b~J\u0006\u0010\u001a\u00020LJ\u000f\u0010\u0001\u001a\u00020\u000fH\u0000¢\u0006\u0003\b\u0001JA\u0010\u0001\u001a\u001f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0012\u0012\u0010\u0012\u0005\u0012\u00030\u0001\u0012\u0004\u0012\u00020\u00070\u00010\u00012\b\u0010\u0001\u001a\u00030\u00012\t\u0010\u0001\u001a\u0004\u0018\u00010\u0007H\u0000¢\u0006\u0003\b\u0001J\u000f\u0010\u0001\u001a\u00020LH\u0000¢\u0006\u0003\b\u0001J2\u0010\u0001\u001a\u00020L2\u0006\u0010g\u001a\u00020\u00162\u0006\u0010|\u001a\u00020?2\b\u0010\u0001\u001a\u00030\u0001H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\t\u0010\u0001\u001a\u00020LH\u0002JE\u0010\u0001\u001a\u00020?2\u0006\u0010Y\u001a\u00020\u00162\u0006\u0010/\u001a\u00020\u00162\t\u0010\u0001\u001a\u0004\u0018\u00010\u00162\u0006\u0010|\u001a\u00020?2\b\u0010\u0001\u001a\u00030\u0001H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J<\u0010\u0001\u001a\u00020?2\t\u0010\u0001\u001a\u0004\u0018\u00010\u00162\b\u0010Q\u001a\u0004\u0018\u00010\u00162\u0006\u0010|\u001a\u00020?2\b\u0010\u0001\u001a\u00030\u0001H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0003\b\u0001J\t\u0010\u0001\u001a\u00020LH\u0002J0\u0010\u0001\u001a\u00020L*\u00030\u00012\u0013\u0010\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020L0KH@ø\u0001\u0000ø\u0001\u0000¢\u0006\u0003\u0010\u0001J\u001d\u0010\u0001\u001a\u00020G*\u00020G2\u000e\u0010\u0001\u001a\t\u0012\u0004\u0012\u00020L0\u0001H\u0002R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR(\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R8\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u00168F@BX\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR4\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00168@@BX\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b#\u0010\u001d\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R4\u0010$\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00168@@BX\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b'\u0010\u001d\u001a\u0004\b%\u0010 \"\u0004\b&\u0010\"R/\u0010)\u001a\u0004\u0018\u00010(2\b\u0010\u0015\u001a\u0004\u0018\u00010(8F@BX\u0002¢\u0006\u0012\n\u0004\b.\u0010\u001d\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R8\u0010/\u001a\u0004\u0018\u00010\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u00168F@BX\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b2\u0010\u001d\u001a\u0004\b0\u0010\u0019\"\u0004\b1\u0010\u001bR\u001a\u00103\u001a\u000204X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001c\u00109\u001a\u0004\u0018\u00010:X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R+\u0010@\u001a\u00020?2\u0006\u0010\u0015\u001a\u00020?8F@FX\u0002¢\u0006\u0012\n\u0004\bE\u0010\u001d\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u0011\u0010F\u001a\u00020G8F¢\u0006\u0006\u001a\u0004\bH\u0010IR(\u0010J\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020L0KX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u0019\u0010Q\u001a\u0004\u0018\u00010\u0016X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0002\n\u0000R(\u0010R\u001a\u0004\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u00078F@FX\u000e¢\u0006\f\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010W\u001a\u00020?8BX\u0004¢\u0006\u0006\u001a\u0004\bX\u0010BR8\u0010Y\u001a\u0004\u0018\u00010\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u00168F@BX\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b\\\u0010\u001d\u001a\u0004\bZ\u0010\u0019\"\u0004\b[\u0010\u001bR\u001c\u0010]\u001a\u0004\u0018\u00010^X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\u001a\u0010c\u001a\u00020?X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010B\"\u0004\be\u0010D\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/text/selection/SelectionManager;", "", "selectionRegistrar", "Landroidx/compose/foundation/text/selection/SelectionRegistrarImpl;", "(Landroidx/compose/foundation/text/selection/SelectionRegistrarImpl;)V", "_selection", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/foundation/text/selection/Selection;", "clipboardManager", "Landroidx/compose/ui/platform/ClipboardManager;", "getClipboardManager", "()Landroidx/compose/ui/platform/ClipboardManager;", "setClipboardManager", "(Landroidx/compose/ui/platform/ClipboardManager;)V", "value", "Landroidx/compose/ui/layout/LayoutCoordinates;", "containerLayoutCoordinates", "getContainerLayoutCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "setContainerLayoutCoordinates", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "<set-?>", "Landroidx/compose/ui/geometry/Offset;", "currentDragPosition", "getCurrentDragPosition-_m7T9-E", "()Landroidx/compose/ui/geometry/Offset;", "setCurrentDragPosition-_kEHs6E", "(Landroidx/compose/ui/geometry/Offset;)V", "currentDragPosition$delegate", "Landroidx/compose/runtime/MutableState;", "dragBeginPosition", "getDragBeginPosition-F1C5BW0$foundation_release", "()J", "setDragBeginPosition-k-4lQ0M", "(J)V", "dragBeginPosition$delegate", "dragTotalDistance", "getDragTotalDistance-F1C5BW0$foundation_release", "setDragTotalDistance-k-4lQ0M", "dragTotalDistance$delegate", "Landroidx/compose/foundation/text/Handle;", "draggingHandle", "getDraggingHandle", "()Landroidx/compose/foundation/text/Handle;", "setDraggingHandle", "(Landroidx/compose/foundation/text/Handle;)V", "draggingHandle$delegate", "endHandlePosition", "getEndHandlePosition-_m7T9-E", "setEndHandlePosition-_kEHs6E", "endHandlePosition$delegate", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "getFocusRequester", "()Landroidx/compose/ui/focus/FocusRequester;", "setFocusRequester", "(Landroidx/compose/ui/focus/FocusRequester;)V", "hapticFeedBack", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "getHapticFeedBack", "()Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "setHapticFeedBack", "(Landroidx/compose/ui/hapticfeedback/HapticFeedback;)V", "", "hasFocus", "getHasFocus", "()Z", "setHasFocus", "(Z)V", "hasFocus$delegate", "modifier", "Landroidx/compose/ui/Modifier;", "getModifier", "()Landroidx/compose/ui/Modifier;", "onSelectionChange", "Lkotlin/Function1;", "", "getOnSelectionChange", "()Lkotlin/jvm/functions/Function1;", "setOnSelectionChange", "(Lkotlin/jvm/functions/Function1;)V", "previousPosition", "selection", "getSelection", "()Landroidx/compose/foundation/text/selection/Selection;", "setSelection", "(Landroidx/compose/foundation/text/selection/Selection;)V", "shouldShowMagnifier", "getShouldShowMagnifier", "startHandlePosition", "getStartHandlePosition-_m7T9-E", "setStartHandlePosition-_kEHs6E", "startHandlePosition$delegate", "textToolbar", "Landroidx/compose/ui/platform/TextToolbar;", "getTextToolbar", "()Landroidx/compose/ui/platform/TextToolbar;", "setTextToolbar", "(Landroidx/compose/ui/platform/TextToolbar;)V", "touchMode", "getTouchMode", "setTouchMode", "contextMenuOpenAdjustment", "position", "contextMenuOpenAdjustment-k-4lQ0M", "convertToContainerCoordinates", "layoutCoordinates", "offset", "convertToContainerCoordinates-Q7Q5hAU", "(Landroidx/compose/ui/layout/LayoutCoordinates;J)Landroidx/compose/ui/geometry/Offset;", "copy", "copy$foundation_release", "getAnchorSelectable", "Landroidx/compose/foundation/text/selection/Selectable;", "anchor", "Landroidx/compose/foundation/text/selection/Selection$AnchorInfo;", "getAnchorSelectable$foundation_release", "getContentRect", "Landroidx/compose/ui/geometry/Rect;", "getSelectedText", "Landroidx/compose/ui/text/AnnotatedString;", "getSelectedText$foundation_release", "handleDragObserver", "Landroidx/compose/foundation/text/TextDragObserver;", "isStartHandle", "hideSelectionToolbar", "hideSelectionToolbar$foundation_release", "onRelease", "requireContainerCoordinates", "requireContainerCoordinates$foundation_release", "selectAll", "Lkotlin/Pair;", "", "", "selectableId", "previousSelection", "selectAll$foundation_release", "showSelectionToolbar", "showSelectionToolbar$foundation_release", "startSelection", "adjustment", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "startSelection-9KIMszo", "(JZLandroidx/compose/foundation/text/selection/SelectionAdjustment;)V", "updateHandleOffsets", "updateSelection", "previousHandlePosition", "updateSelection-3R_-tFg$foundation_release", "(JJLandroidx/compose/ui/geometry/Offset;ZLandroidx/compose/foundation/text/selection/SelectionAdjustment;)Z", "newPosition", "updateSelection-RHHTvR4$foundation_release", "updateSelectionToolbarPosition", "detectNonConsumingTap", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "onTap", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onClearSelectionRequested", "block", "Lkotlin/Function0;", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SelectionManager {
    @NotNull
    private final MutableState<Selection> _selection = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
    @Nullable
    private ClipboardManager clipboardManager;
    @Nullable
    private LayoutCoordinates containerLayoutCoordinates;
    @NotNull
    private final MutableState currentDragPosition$delegate;
    @NotNull
    private final MutableState dragBeginPosition$delegate;
    @NotNull
    private final MutableState dragTotalDistance$delegate;
    @NotNull
    private final MutableState draggingHandle$delegate;
    @NotNull
    private final MutableState endHandlePosition$delegate;
    @NotNull
    private FocusRequester focusRequester = new FocusRequester();
    @Nullable
    private HapticFeedback hapticFeedBack;
    @NotNull
    private final MutableState hasFocus$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, (SnapshotMutationPolicy) null, 2, (Object) null);
    @NotNull
    private Function1<? super Selection, Unit> onSelectionChange = SelectionManager$onSelectionChange$1.INSTANCE;
    @Nullable
    private Offset previousPosition;
    /* access modifiers changed from: private */
    @NotNull
    public final SelectionRegistrarImpl selectionRegistrar;
    @NotNull
    private final MutableState startHandlePosition$delegate;
    @Nullable
    private TextToolbar textToolbar;
    private boolean touchMode = true;

    public SelectionManager(@NotNull SelectionRegistrarImpl selectionRegistrarImpl) {
        Intrinsics.checkNotNullParameter(selectionRegistrarImpl, "selectionRegistrar");
        this.selectionRegistrar = selectionRegistrarImpl;
        Offset.Companion companion = Offset.Companion;
        this.dragBeginPosition$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m2665boximpl(companion.m2692getZeroF1C5BW0()), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.dragTotalDistance$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m2665boximpl(companion.m2692getZeroF1C5BW0()), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.startHandlePosition$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.endHandlePosition$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.draggingHandle$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.currentDragPosition$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        selectionRegistrarImpl.setOnPositionChangeCallback$foundation_release(new Function1<Long, Unit>(this) {

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ SelectionManager f3704g;

            {
                this.f3704g = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Number) obj).longValue());
                return Unit.INSTANCE;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
                r0 = r0.getStart();
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void invoke(long r6) {
                /*
                    r5 = this;
                    androidx.compose.foundation.text.selection.SelectionManager r0 = r5.f3704g
                    androidx.compose.foundation.text.selection.Selection r0 = r0.getSelection()
                    r1 = 1
                    r2 = 0
                    if (r0 == 0) goto L_0x001a
                    androidx.compose.foundation.text.selection.Selection$AnchorInfo r0 = r0.getStart()
                    if (r0 == 0) goto L_0x001a
                    long r3 = r0.getSelectableId()
                    int r0 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
                    if (r0 != 0) goto L_0x001a
                    r0 = r1
                    goto L_0x001b
                L_0x001a:
                    r0 = r2
                L_0x001b:
                    if (r0 != 0) goto L_0x0037
                    androidx.compose.foundation.text.selection.SelectionManager r0 = r5.f3704g
                    androidx.compose.foundation.text.selection.Selection r0 = r0.getSelection()
                    if (r0 == 0) goto L_0x0034
                    androidx.compose.foundation.text.selection.Selection$AnchorInfo r0 = r0.getEnd()
                    if (r0 == 0) goto L_0x0034
                    long r3 = r0.getSelectableId()
                    int r6 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
                    if (r6 != 0) goto L_0x0034
                    goto L_0x0035
                L_0x0034:
                    r1 = r2
                L_0x0035:
                    if (r1 == 0) goto L_0x0041
                L_0x0037:
                    androidx.compose.foundation.text.selection.SelectionManager r6 = r5.f3704g
                    r6.updateHandleOffsets()
                    androidx.compose.foundation.text.selection.SelectionManager r6 = r5.f3704g
                    r6.updateSelectionToolbarPosition()
                L_0x0041:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionManager.AnonymousClass1.invoke(long):void");
            }
        });
        selectionRegistrarImpl.setOnSelectionUpdateStartCallback$foundation_release(new Function3<LayoutCoordinates, Offset, SelectionAdjustment, Unit>(this) {

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ SelectionManager f3705g;

            {
                this.f3705g = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                m1014invoked4ec7I((LayoutCoordinates) obj, ((Offset) obj2).m2686unboximpl(), (SelectionAdjustment) obj3);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke-d-4ec7I  reason: not valid java name */
            public final void m1014invoked4ec7I(@NotNull LayoutCoordinates layoutCoordinates, long j11, @NotNull SelectionAdjustment selectionAdjustment) {
                Intrinsics.checkNotNullParameter(layoutCoordinates, "layoutCoordinates");
                Intrinsics.checkNotNullParameter(selectionAdjustment, "selectionMode");
                Offset r32 = this.f3705g.m999convertToContainerCoordinatesQ7Q5hAU(layoutCoordinates, j11);
                if (r32 != null) {
                    this.f3705g.m1005startSelection9KIMszo(r32.m2686unboximpl(), false, selectionAdjustment);
                    this.f3705g.getFocusRequester().requestFocus();
                    this.f3705g.hideSelectionToolbar$foundation_release();
                }
            }
        });
        selectionRegistrarImpl.setOnSelectionUpdateSelectAll$foundation_release(new Function1<Long, Unit>(this) {

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ SelectionManager f3706g;

            {
                this.f3706g = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Number) obj).longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j11) {
                SelectionManager selectionManager = this.f3706g;
                Pair<Selection, Map<Long, Selection>> selectAll$foundation_release = selectionManager.selectAll$foundation_release(j11, selectionManager.getSelection());
                Selection component1 = selectAll$foundation_release.component1();
                Map component2 = selectAll$foundation_release.component2();
                if (!Intrinsics.areEqual((Object) component1, (Object) this.f3706g.getSelection())) {
                    this.f3706g.selectionRegistrar.setSubselections(component2);
                    this.f3706g.getOnSelectionChange().invoke(component1);
                }
                this.f3706g.getFocusRequester().requestFocus();
                this.f3706g.hideSelectionToolbar$foundation_release();
            }
        });
        selectionRegistrarImpl.setOnSelectionUpdateCallback$foundation_release(new Function5<LayoutCoordinates, Offset, Offset, Boolean, SelectionAdjustment, Boolean>(this) {

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ SelectionManager f3707g;

            {
                this.f3707g = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
                return m1015invoke5iVPX68((LayoutCoordinates) obj, ((Offset) obj2).m2686unboximpl(), ((Offset) obj3).m2686unboximpl(), ((Boolean) obj4).booleanValue(), (SelectionAdjustment) obj5);
            }

            @NotNull
            /* renamed from: invoke-5iVPX68  reason: not valid java name */
            public final Boolean m1015invoke5iVPX68(@NotNull LayoutCoordinates layoutCoordinates, long j11, long j12, boolean z11, @NotNull SelectionAdjustment selectionAdjustment) {
                Intrinsics.checkNotNullParameter(layoutCoordinates, "layoutCoordinates");
                Intrinsics.checkNotNullParameter(selectionAdjustment, "selectionMode");
                return Boolean.valueOf(this.f3707g.m1013updateSelectionRHHTvR4$foundation_release(this.f3707g.m999convertToContainerCoordinatesQ7Q5hAU(layoutCoordinates, j11), this.f3707g.m999convertToContainerCoordinatesQ7Q5hAU(layoutCoordinates, j12), z11, selectionAdjustment));
            }
        });
        selectionRegistrarImpl.setOnSelectionUpdateEndCallback$foundation_release(new Function0<Unit>(this) {

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ SelectionManager f3708g;

            {
                this.f3708g = r1;
            }

            public final void invoke() {
                this.f3708g.showSelectionToolbar$foundation_release();
                this.f3708g.setDraggingHandle((Handle) null);
                this.f3708g.m1000setCurrentDragPosition_kEHs6E((Offset) null);
            }
        });
        selectionRegistrarImpl.setOnSelectableChangeCallback$foundation_release(new Function1<Long, Unit>(this) {

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ SelectionManager f3709g;

            {
                this.f3709g = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Number) obj).longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j11) {
                if (this.f3709g.selectionRegistrar.getSubselections().containsKey(Long.valueOf(j11))) {
                    this.f3709g.onRelease();
                    this.f3709g.setSelection((Selection) null);
                }
            }
        });
        selectionRegistrarImpl.setAfterSelectableUnsubscribe$foundation_release(new Function1<Long, Unit>(this) {

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ SelectionManager f3710g;

            {
                this.f3710g = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Number) obj).longValue());
                return Unit.INSTANCE;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
                r0 = r0.getStart();
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void invoke(long r6) {
                /*
                    r5 = this;
                    androidx.compose.foundation.text.selection.SelectionManager r0 = r5.f3710g
                    androidx.compose.foundation.text.selection.Selection r0 = r0.getSelection()
                    r1 = 1
                    r2 = 0
                    if (r0 == 0) goto L_0x001a
                    androidx.compose.foundation.text.selection.Selection$AnchorInfo r0 = r0.getStart()
                    if (r0 == 0) goto L_0x001a
                    long r3 = r0.getSelectableId()
                    int r0 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
                    if (r0 != 0) goto L_0x001a
                    r0 = r1
                    goto L_0x001b
                L_0x001a:
                    r0 = r2
                L_0x001b:
                    if (r0 != 0) goto L_0x0037
                    androidx.compose.foundation.text.selection.SelectionManager r0 = r5.f3710g
                    androidx.compose.foundation.text.selection.Selection r0 = r0.getSelection()
                    if (r0 == 0) goto L_0x0034
                    androidx.compose.foundation.text.selection.Selection$AnchorInfo r0 = r0.getEnd()
                    if (r0 == 0) goto L_0x0034
                    long r3 = r0.getSelectableId()
                    int r6 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
                    if (r6 != 0) goto L_0x0034
                    goto L_0x0035
                L_0x0034:
                    r1 = r2
                L_0x0035:
                    if (r1 == 0) goto L_0x0042
                L_0x0037:
                    androidx.compose.foundation.text.selection.SelectionManager r6 = r5.f3710g
                    r7 = 0
                    r6.m1004setStartHandlePosition_kEHs6E(r7)
                    androidx.compose.foundation.text.selection.SelectionManager r6 = r5.f3710g
                    r6.m1003setEndHandlePosition_kEHs6E(r7)
                L_0x0042:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionManager.AnonymousClass7.invoke(long):void");
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: convertToContainerCoordinates-Q7Q5hAU  reason: not valid java name */
    public final Offset m999convertToContainerCoordinatesQ7Q5hAU(LayoutCoordinates layoutCoordinates, long j11) {
        LayoutCoordinates layoutCoordinates2 = this.containerLayoutCoordinates;
        if (layoutCoordinates2 == null || !layoutCoordinates2.isAttached()) {
            return null;
        }
        return Offset.m2665boximpl(requireContainerCoordinates$foundation_release().m4474localPositionOfR5De75A(layoutCoordinates, j11));
    }

    /* access modifiers changed from: private */
    public final Object detectNonConsumingTap(PointerInputScope pointerInputScope, Function1<? super Offset, Unit> function1, Continuation<? super Unit> continuation) {
        Object forEachGesture = ForEachGestureKt.forEachGesture(pointerInputScope, new SelectionManager$detectNonConsumingTap$2(function1, (Continuation<? super SelectionManager$detectNonConsumingTap$2>) null), continuation);
        return forEachGesture == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? forEachGesture : Unit.INSTANCE;
    }

    private final Rect getContentRect() {
        LayoutCoordinates layoutCoordinates;
        LayoutCoordinates layoutCoordinates2;
        Selection selection = getSelection();
        if (selection == null) {
            return Rect.Companion.getZero();
        }
        Selectable anchorSelectable$foundation_release = getAnchorSelectable$foundation_release(selection.getStart());
        Selectable anchorSelectable$foundation_release2 = getAnchorSelectable$foundation_release(selection.getEnd());
        if (anchorSelectable$foundation_release == null || (layoutCoordinates = anchorSelectable$foundation_release.getLayoutCoordinates()) == null) {
            return Rect.Companion.getZero();
        }
        if (anchorSelectable$foundation_release2 == null || (layoutCoordinates2 = anchorSelectable$foundation_release2.getLayoutCoordinates()) == null) {
            return Rect.Companion.getZero();
        }
        LayoutCoordinates layoutCoordinates3 = this.containerLayoutCoordinates;
        if (layoutCoordinates3 == null || !layoutCoordinates3.isAttached()) {
            return Rect.Companion.getZero();
        }
        long r62 = layoutCoordinates3.m4474localPositionOfR5De75A(layoutCoordinates, anchorSelectable$foundation_release.m961getHandlePositiondBAh8RU(selection, true));
        long r82 = layoutCoordinates3.m4474localPositionOfR5De75A(layoutCoordinates2, anchorSelectable$foundation_release2.m961getHandlePositiondBAh8RU(selection, false));
        long r63 = layoutCoordinates3.m4475localToRootMKHz9U(r62);
        long r83 = layoutCoordinates3.m4475localToRootMKHz9U(r82);
        float min = Math.min(Offset.m2676getXimpl(r63), Offset.m2676getXimpl(r83));
        float max = Math.max(Offset.m2676getXimpl(r63), Offset.m2676getXimpl(r83));
        long r13 = layoutCoordinates3.m4474localPositionOfR5De75A(layoutCoordinates, OffsetKt.Offset(0.0f, anchorSelectable$foundation_release.getBoundingBox(selection.getStart().getOffset()).getTop()));
        long r02 = layoutCoordinates3.m4474localPositionOfR5De75A(layoutCoordinates2, OffsetKt.Offset(0.0f, anchorSelectable$foundation_release2.getBoundingBox(selection.getEnd().getOffset()).getTop()));
        return new Rect(min, Math.min(Offset.m2677getYimpl(layoutCoordinates3.m4475localToRootMKHz9U(r13)), Offset.m2677getYimpl(layoutCoordinates3.m4475localToRootMKHz9U(r02))), max, Math.max(Offset.m2677getYimpl(r63), Offset.m2677getYimpl(r83)) + ((float) (((double) SelectionHandlesKt.getHandleHeight()) * 4.0d)));
    }

    private final boolean getShouldShowMagnifier() {
        return getDraggingHandle() != null;
    }

    private final Modifier onClearSelectionRequested(Modifier modifier, Function0<Unit> function0) {
        return getHasFocus() ? SuspendingPointerInputFilterKt.pointerInput(modifier, (Object) Unit.INSTANCE, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new SelectionManager$onClearSelectionRequested$1(this, function0, (Continuation<? super SelectionManager$onClearSelectionRequested$1>) null)) : modifier;
    }

    /* access modifiers changed from: private */
    /* renamed from: setCurrentDragPosition-_kEHs6E  reason: not valid java name */
    public final void m1000setCurrentDragPosition_kEHs6E(Offset offset) {
        this.currentDragPosition$delegate.setValue(offset);
    }

    /* access modifiers changed from: private */
    /* renamed from: setDragBeginPosition-k-4lQ0M  reason: not valid java name */
    public final void m1001setDragBeginPositionk4lQ0M(long j11) {
        this.dragBeginPosition$delegate.setValue(Offset.m2665boximpl(j11));
    }

    /* access modifiers changed from: private */
    /* renamed from: setDragTotalDistance-k-4lQ0M  reason: not valid java name */
    public final void m1002setDragTotalDistancek4lQ0M(long j11) {
        this.dragTotalDistance$delegate.setValue(Offset.m2665boximpl(j11));
    }

    /* access modifiers changed from: private */
    public final void setDraggingHandle(Handle handle) {
        this.draggingHandle$delegate.setValue(handle);
    }

    /* access modifiers changed from: private */
    /* renamed from: setEndHandlePosition-_kEHs6E  reason: not valid java name */
    public final void m1003setEndHandlePosition_kEHs6E(Offset offset) {
        this.endHandlePosition$delegate.setValue(offset);
    }

    /* access modifiers changed from: private */
    /* renamed from: setStartHandlePosition-_kEHs6E  reason: not valid java name */
    public final void m1004setStartHandlePosition_kEHs6E(Offset offset) {
        this.startHandlePosition$delegate.setValue(offset);
    }

    /* access modifiers changed from: private */
    /* renamed from: startSelection-9KIMszo  reason: not valid java name */
    public final void m1005startSelection9KIMszo(long j11, boolean z11, SelectionAdjustment selectionAdjustment) {
        m1012updateSelection3R_tFg$foundation_release(j11, j11, (Offset) null, z11, selectionAdjustment);
    }

    /* access modifiers changed from: private */
    public final void updateHandleOffsets() {
        Selectable selectable;
        Selectable selectable2;
        LayoutCoordinates layoutCoordinates;
        LayoutCoordinates layoutCoordinates2;
        Offset offset;
        Selection.AnchorInfo end;
        Selection.AnchorInfo start;
        Selection selection = getSelection();
        LayoutCoordinates layoutCoordinates3 = this.containerLayoutCoordinates;
        Offset offset2 = null;
        if (selection == null || (start = selection.getStart()) == null) {
            selectable = null;
        } else {
            selectable = getAnchorSelectable$foundation_release(start);
        }
        if (selection == null || (end = selection.getEnd()) == null) {
            selectable2 = null;
        } else {
            selectable2 = getAnchorSelectable$foundation_release(end);
        }
        if (selectable != null) {
            layoutCoordinates = selectable.getLayoutCoordinates();
        } else {
            layoutCoordinates = null;
        }
        if (selectable2 != null) {
            layoutCoordinates2 = selectable2.getLayoutCoordinates();
        } else {
            layoutCoordinates2 = null;
        }
        if (selection == null || layoutCoordinates3 == null || !layoutCoordinates3.isAttached() || layoutCoordinates == null || layoutCoordinates2 == null) {
            m1004setStartHandlePosition_kEHs6E((Offset) null);
            m1003setEndHandlePosition_kEHs6E((Offset) null);
            return;
        }
        long r72 = layoutCoordinates3.m4474localPositionOfR5De75A(layoutCoordinates, selectable.m961getHandlePositiondBAh8RU(selection, true));
        long r32 = layoutCoordinates3.m4474localPositionOfR5De75A(layoutCoordinates2, selectable2.m961getHandlePositiondBAh8RU(selection, false));
        Rect visibleBounds = SelectionManagerKt.visibleBounds(layoutCoordinates3);
        if (SelectionManagerKt.m1022containsInclusiveUv8p0NA(visibleBounds, r72)) {
            offset = Offset.m2665boximpl(r72);
        } else {
            offset = null;
        }
        m1004setStartHandlePosition_kEHs6E(offset);
        if (SelectionManagerKt.m1022containsInclusiveUv8p0NA(visibleBounds, r32)) {
            offset2 = Offset.m2665boximpl(r32);
        }
        m1003setEndHandlePosition_kEHs6E(offset2);
    }

    /* access modifiers changed from: private */
    public final void updateSelectionToolbarPosition() {
        TextToolbarStatus textToolbarStatus;
        if (getHasFocus()) {
            TextToolbar textToolbar2 = this.textToolbar;
            if (textToolbar2 != null) {
                textToolbarStatus = textToolbar2.getStatus();
            } else {
                textToolbarStatus = null;
            }
            if (textToolbarStatus == TextToolbarStatus.Shown) {
                showSelectionToolbar$foundation_release();
            }
        }
    }

    /* renamed from: contextMenuOpenAdjustment-k-4lQ0M  reason: not valid java name */
    public final void m1006contextMenuOpenAdjustmentk4lQ0M(long j11) {
        boolean z11;
        Selection selection = getSelection();
        if (selection != null) {
            z11 = TextRange.m5032getCollapsedimpl(selection.m964toTextRanged9O1mEE());
        } else {
            z11 = true;
        }
        if (z11) {
            m1005startSelection9KIMszo(j11, true, SelectionAdjustment.Companion.getWord());
        }
    }

    public final void copy$foundation_release() {
        ClipboardManager clipboardManager2;
        AnnotatedString selectedText$foundation_release = getSelectedText$foundation_release();
        if (selectedText$foundation_release != null && (clipboardManager2 = this.clipboardManager) != null) {
            clipboardManager2.setText(selectedText$foundation_release);
        }
    }

    @Nullable
    public final Selectable getAnchorSelectable$foundation_release(@NotNull Selection.AnchorInfo anchorInfo) {
        Intrinsics.checkNotNullParameter(anchorInfo, Param.ANCHOR);
        return this.selectionRegistrar.getSelectableMap$foundation_release().get(Long.valueOf(anchorInfo.getSelectableId()));
    }

    @Nullable
    public final ClipboardManager getClipboardManager() {
        return this.clipboardManager;
    }

    @Nullable
    public final LayoutCoordinates getContainerLayoutCoordinates() {
        return this.containerLayoutCoordinates;
    }

    @Nullable
    /* renamed from: getCurrentDragPosition-_m7T9-E  reason: not valid java name */
    public final Offset m1007getCurrentDragPosition_m7T9E() {
        return (Offset) this.currentDragPosition$delegate.getValue();
    }

    /* renamed from: getDragBeginPosition-F1C5BW0$foundation_release  reason: not valid java name */
    public final long m1008getDragBeginPositionF1C5BW0$foundation_release() {
        return ((Offset) this.dragBeginPosition$delegate.getValue()).m2686unboximpl();
    }

    /* renamed from: getDragTotalDistance-F1C5BW0$foundation_release  reason: not valid java name */
    public final long m1009getDragTotalDistanceF1C5BW0$foundation_release() {
        return ((Offset) this.dragTotalDistance$delegate.getValue()).m2686unboximpl();
    }

    @Nullable
    public final Handle getDraggingHandle() {
        return (Handle) this.draggingHandle$delegate.getValue();
    }

    @Nullable
    /* renamed from: getEndHandlePosition-_m7T9-E  reason: not valid java name */
    public final Offset m1010getEndHandlePosition_m7T9E() {
        return (Offset) this.endHandlePosition$delegate.getValue();
    }

    @NotNull
    public final FocusRequester getFocusRequester() {
        return this.focusRequester;
    }

    @Nullable
    public final HapticFeedback getHapticFeedBack() {
        return this.hapticFeedBack;
    }

    public final boolean getHasFocus() {
        return ((Boolean) this.hasFocus$delegate.getValue()).booleanValue();
    }

    @NotNull
    public final Modifier getModifier() {
        Modifier modifier = Modifier.Companion;
        Modifier onKeyEvent = KeyInputModifierKt.onKeyEvent(FocusableKt.focusable$default(FocusChangedModifierKt.onFocusChanged(FocusRequesterModifierKt.focusRequester(OnGloballyPositionedModifierKt.onGloballyPositioned(onClearSelectionRequested(modifier, new SelectionManager$modifier$1(this)), new SelectionManager$modifier$2(this)), this.focusRequester), new SelectionManager$modifier$3(this)), false, (MutableInteractionSource) null, 3, (Object) null), new SelectionManager$modifier$4(this));
        if (getShouldShowMagnifier()) {
            modifier = SelectionManager_androidKt.selectionMagnifier(modifier, this);
        }
        return onKeyEvent.then(modifier);
    }

    @NotNull
    public final Function1<Selection, Unit> getOnSelectionChange() {
        return this.onSelectionChange;
    }

    @Nullable
    public final AnnotatedString getSelectedText$foundation_release() {
        AnnotatedString plus;
        List<Selectable> sort = this.selectionRegistrar.sort(requireContainerCoordinates$foundation_release());
        Selection selection = getSelection();
        AnnotatedString annotatedString = null;
        if (selection == null) {
            return null;
        }
        int size = sort.size();
        for (int i11 = 0; i11 < size; i11++) {
            Selectable selectable = sort.get(i11);
            if (selectable.getSelectableId() == selection.getStart().getSelectableId() || selectable.getSelectableId() == selection.getEnd().getSelectableId() || annotatedString != null) {
                AnnotatedString currentSelectedText = SelectionManagerKt.getCurrentSelectedText(selectable, selection);
                if (!(annotatedString == null || (plus = annotatedString.plus(currentSelectedText)) == null)) {
                    currentSelectedText = plus;
                }
                if ((selectable.getSelectableId() == selection.getEnd().getSelectableId() && !selection.getHandlesCrossed()) || (selectable.getSelectableId() == selection.getStart().getSelectableId() && selection.getHandlesCrossed())) {
                    return currentSelectedText;
                }
                annotatedString = currentSelectedText;
            }
        }
        return annotatedString;
    }

    @Nullable
    public final Selection getSelection() {
        return this._selection.getValue();
    }

    @Nullable
    /* renamed from: getStartHandlePosition-_m7T9-E  reason: not valid java name */
    public final Offset m1011getStartHandlePosition_m7T9E() {
        return (Offset) this.startHandlePosition$delegate.getValue();
    }

    @Nullable
    public final TextToolbar getTextToolbar() {
        return this.textToolbar;
    }

    public final boolean getTouchMode() {
        return this.touchMode;
    }

    @NotNull
    public final TextDragObserver handleDragObserver(boolean z11) {
        return new SelectionManager$handleDragObserver$1(this, z11);
    }

    public final void hideSelectionToolbar$foundation_release() {
        TextToolbarStatus textToolbarStatus;
        TextToolbar textToolbar2;
        if (getHasFocus()) {
            TextToolbar textToolbar3 = this.textToolbar;
            if (textToolbar3 != null) {
                textToolbarStatus = textToolbar3.getStatus();
            } else {
                textToolbarStatus = null;
            }
            if (textToolbarStatus == TextToolbarStatus.Shown && (textToolbar2 = this.textToolbar) != null) {
                textToolbar2.hide();
            }
        }
    }

    public final void onRelease() {
        this.selectionRegistrar.setSubselections(MapsKt__MapsKt.emptyMap());
        hideSelectionToolbar$foundation_release();
        if (getSelection() != null) {
            this.onSelectionChange.invoke(null);
            HapticFeedback hapticFeedback = this.hapticFeedBack;
            if (hapticFeedback != null) {
                hapticFeedback.m3558performHapticFeedbackCdsT49E(HapticFeedbackType.Companion.m3567getTextHandleMove5zf0vsI());
            }
        }
    }

    @NotNull
    public final LayoutCoordinates requireContainerCoordinates$foundation_release() {
        boolean z11;
        LayoutCoordinates layoutCoordinates = this.containerLayoutCoordinates;
        if (layoutCoordinates != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        } else if (layoutCoordinates.isAttached()) {
            return layoutCoordinates;
        } else {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    @NotNull
    public final Pair<Selection, Map<Long, Selection>> selectAll$foundation_release(long j11, @Nullable Selection selection) {
        HapticFeedback hapticFeedback;
        Selection selection2;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        List<Selectable> sort = this.selectionRegistrar.sort(requireContainerCoordinates$foundation_release());
        int size = sort.size();
        Selection selection3 = null;
        for (int i11 = 0; i11 < size; i11++) {
            Selectable selectable = sort.get(i11);
            if (selectable.getSelectableId() == j11) {
                selection2 = selectable.getSelectAllSelection();
            } else {
                selection2 = null;
            }
            if (selection2 != null) {
                linkedHashMap.put(Long.valueOf(selectable.getSelectableId()), selection2);
            }
            selection3 = SelectionManagerKt.merge(selection3, selection2);
        }
        if (!Intrinsics.areEqual((Object) selection3, (Object) selection) && (hapticFeedback = this.hapticFeedBack) != null) {
            hapticFeedback.m3558performHapticFeedbackCdsT49E(HapticFeedbackType.Companion.m3567getTextHandleMove5zf0vsI());
        }
        return new Pair<>(selection3, linkedHashMap);
    }

    public final void setClipboardManager(@Nullable ClipboardManager clipboardManager2) {
        this.clipboardManager = clipboardManager2;
    }

    public final void setContainerLayoutCoordinates(@Nullable LayoutCoordinates layoutCoordinates) {
        Offset offset;
        this.containerLayoutCoordinates = layoutCoordinates;
        if (getHasFocus() && getSelection() != null) {
            if (layoutCoordinates != null) {
                offset = Offset.m2665boximpl(LayoutCoordinatesKt.positionInWindow(layoutCoordinates));
            } else {
                offset = null;
            }
            if (!Intrinsics.areEqual((Object) this.previousPosition, (Object) offset)) {
                this.previousPosition = offset;
                updateHandleOffsets();
                updateSelectionToolbarPosition();
            }
        }
    }

    public final void setFocusRequester(@NotNull FocusRequester focusRequester2) {
        Intrinsics.checkNotNullParameter(focusRequester2, "<set-?>");
        this.focusRequester = focusRequester2;
    }

    public final void setHapticFeedBack(@Nullable HapticFeedback hapticFeedback) {
        this.hapticFeedBack = hapticFeedback;
    }

    public final void setHasFocus(boolean z11) {
        this.hasFocus$delegate.setValue(Boolean.valueOf(z11));
    }

    public final void setOnSelectionChange(@NotNull Function1<? super Selection, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.onSelectionChange = function1;
    }

    public final void setSelection(@Nullable Selection selection) {
        this._selection.setValue(selection);
        if (selection != null) {
            updateHandleOffsets();
        }
    }

    public final void setTextToolbar(@Nullable TextToolbar textToolbar2) {
        this.textToolbar = textToolbar2;
    }

    public final void setTouchMode(boolean z11) {
        this.touchMode = z11;
    }

    public final void showSelectionToolbar$foundation_release() {
        TextToolbar textToolbar2;
        if (getHasFocus() && getSelection() != null && (textToolbar2 = this.textToolbar) != null) {
            x1.a(textToolbar2, getContentRect(), new SelectionManager$showSelectionToolbar$1$1(this), (Function0) null, (Function0) null, (Function0) null, 28, (Object) null);
        }
    }

    /* renamed from: updateSelection-3R_-tFg$foundation_release  reason: not valid java name */
    public final boolean m1012updateSelection3R_tFg$foundation_release(long j11, long j12, @Nullable Offset offset, boolean z11, @NotNull SelectionAdjustment selectionAdjustment) {
        Handle handle;
        Offset offset2;
        Intrinsics.checkNotNullParameter(selectionAdjustment, "adjustment");
        if (z11) {
            handle = Handle.SelectionStart;
        } else {
            handle = Handle.SelectionEnd;
        }
        setDraggingHandle(handle);
        if (z11) {
            offset2 = Offset.m2665boximpl(j11);
        } else {
            offset2 = Offset.m2665boximpl(j12);
        }
        m1000setCurrentDragPosition_kEHs6E(offset2);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        List<Selectable> sort = this.selectionRegistrar.sort(requireContainerCoordinates$foundation_release());
        int size = sort.size();
        Selection selection = null;
        int i11 = 0;
        boolean z12 = false;
        while (i11 < size) {
            Selectable selectable = sort.get(i11);
            int i12 = i11;
            Selection selection2 = selection;
            Pair<Selection, Boolean> r12 = selectable.m963updateSelectionqCDeeow(j11, j12, offset, z11, requireContainerCoordinates$foundation_release(), selectionAdjustment, this.selectionRegistrar.getSubselections().get(Long.valueOf(selectable.getSelectableId())));
            Selection component1 = r12.component1();
            boolean booleanValue = r12.component2().booleanValue();
            if (z12 || booleanValue) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (component1 != null) {
                linkedHashMap.put(Long.valueOf(selectable.getSelectableId()), component1);
            }
            selection = SelectionManagerKt.merge(selection2, component1);
            i11 = i12 + 1;
        }
        Selection selection3 = selection;
        if (!Intrinsics.areEqual((Object) selection3, (Object) getSelection())) {
            HapticFeedback hapticFeedback = this.hapticFeedBack;
            if (hapticFeedback != null) {
                hapticFeedback.m3558performHapticFeedbackCdsT49E(HapticFeedbackType.Companion.m3567getTextHandleMove5zf0vsI());
            }
            this.selectionRegistrar.setSubselections(linkedHashMap);
            this.onSelectionChange.invoke(selection3);
        }
        return z12;
    }

    /* renamed from: updateSelection-RHHTvR4$foundation_release  reason: not valid java name */
    public final boolean m1013updateSelectionRHHTvR4$foundation_release(@Nullable Offset offset, @Nullable Offset offset2, boolean z11, @NotNull SelectionAdjustment selectionAdjustment) {
        Selection selection;
        long j11;
        Offset offset3;
        long j12;
        Intrinsics.checkNotNullParameter(selectionAdjustment, "adjustment");
        if (offset == null || (selection = getSelection()) == null) {
            return false;
        }
        if (z11) {
            j11 = selection.getEnd().getSelectableId();
        } else {
            j11 = selection.getStart().getSelectableId();
        }
        Selectable selectable = this.selectionRegistrar.getSelectableMap$foundation_release().get(Long.valueOf(j11));
        if (selectable == null) {
            offset3 = null;
        } else {
            LayoutCoordinates layoutCoordinates = selectable.getLayoutCoordinates();
            Intrinsics.checkNotNull(layoutCoordinates);
            offset3 = m999convertToContainerCoordinatesQ7Q5hAU(layoutCoordinates, SelectionHandlesKt.m982getAdjustedCoordinatesk4lQ0M(selectable.m961getHandlePositiondBAh8RU(selection, !z11)));
        }
        if (offset3 == null) {
            return false;
        }
        long r02 = offset3.m2686unboximpl();
        if (z11) {
            j12 = offset.m2686unboximpl();
        } else {
            j12 = r02;
        }
        if (!z11) {
            r02 = offset.m2686unboximpl();
        }
        return m1012updateSelection3R_tFg$foundation_release(j12, r02, offset2, z11, selectionAdjustment);
    }
}
