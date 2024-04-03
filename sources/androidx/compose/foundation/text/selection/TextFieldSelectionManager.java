package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.HandleState;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TextFieldCursorKt;
import androidx.compose.foundation.text.TextFieldState;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.foundation.text.UndoManager;
import androidx.compose.foundation.text.ValidatingOffsetMappingKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.platform.ClipboardManager;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.TextToolbarStatus;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextFieldValueKt;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.instabug.library.model.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u001b\u0010e\u001a\u00020B2\u0006\u0010f\u001a\u00020\fø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bg\u0010hJ\u0017\u0010i\u001a\u00020B2\b\b\u0002\u0010j\u001a\u00020!H\u0000¢\u0006\u0002\bkJ%\u0010l\u001a\u00020?2\u0006\u0010m\u001a\u00020n2\u0006\u0010o\u001a\u00020pH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bq\u0010rJ\r\u0010s\u001a\u00020TH\u0000¢\u0006\u0002\btJ\r\u0010u\u001a\u00020BH\u0000¢\u0006\u0002\bvJ\u001f\u0010w\u001a\u00020B2\n\b\u0002\u0010f\u001a\u0004\u0018\u00010\fH\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\bxJ\r\u0010y\u001a\u00020BH\u0000¢\u0006\u0002\bzJ\r\u0010{\u001a\u00020BH\u0000¢\u0006\u0002\b|J\b\u0010}\u001a\u00020~H\u0002J$\u0010\u001a\u00020\f2\b\u0010\u0001\u001a\u00030\u0001H\u0000ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J$\u0010\u0001\u001a\u00020\f2\u0007\u0010\u0001\u001a\u00020!H\u0000ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u0018\u0010\u0001\u001a\u00020T2\u0007\u0010\u0001\u001a\u00020!H\u0000¢\u0006\u0003\b\u0001J\u000f\u0010\u0001\u001a\u00020BH\u0000¢\u0006\u0003\b\u0001J\u000f\u0010\u0001\u001a\u00020!H\u0000¢\u0006\u0003\b\u0001J\u000f\u0010\u0001\u001a\u00020BH\u0000¢\u0006\u0003\b\u0001J\u000f\u0010\u0001\u001a\u00020BH\u0000¢\u0006\u0003\b\u0001J\u0013\u0010\u0001\u001a\u00020B2\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u000f\u0010\u0001\u001a\u00020BH\u0000¢\u0006\u0003\b\u0001J6\u0010\u0001\u001a\u00020B2\u0006\u0010Y\u001a\u00020?2\u0007\u0010\u0001\u001a\u00020\u00152\u0007\u0010\u0001\u001a\u00020\u00152\u0007\u0010\u0001\u001a\u00020!2\b\u0010\u0001\u001a\u00030\u0001H\u0002R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR8\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f8F@BX\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0004\n\u0002\u0010\u0016R\u0019\u0010\u0017\u001a\u00020\fX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0018R\u0019\u0010\u0019\u001a\u00020\fX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0018R/\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u000b\u001a\u0004\u0018\u00010\u001a8F@BX\u0002¢\u0006\u0012\n\u0004\b \u0010\u0013\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR+\u0010\"\u001a\u00020!2\u0006\u0010\u000b\u001a\u00020!8F@FX\u0002¢\u0006\u0012\n\u0004\b'\u0010\u0013\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001c\u0010.\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0014\u00104\u001a\u000205X\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u001a\u00108\u001a\u000209X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u000e\u0010>\u001a\u00020?X\u000e¢\u0006\u0002\n\u0000R&\u0010@\u001a\u000e\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020B0AX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001c\u0010G\u001a\u0004\u0018\u00010HX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u001c\u0010M\u001a\u0004\u0018\u00010NX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u0014\u0010S\u001a\u00020TX\u0004¢\u0006\b\n\u0000\u001a\u0004\bU\u0010VR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bW\u0010XR+\u0010Y\u001a\u00020?2\u0006\u0010\u000b\u001a\u00020?8@@@X\u0002¢\u0006\u0012\n\u0004\b^\u0010\u0013\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u001a\u0010_\u001a\u00020`X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010b\"\u0004\bc\u0010d\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "", "undoManager", "Landroidx/compose/foundation/text/UndoManager;", "(Landroidx/compose/foundation/text/UndoManager;)V", "clipboardManager", "Landroidx/compose/ui/platform/ClipboardManager;", "getClipboardManager$foundation_release", "()Landroidx/compose/ui/platform/ClipboardManager;", "setClipboardManager$foundation_release", "(Landroidx/compose/ui/platform/ClipboardManager;)V", "<set-?>", "Landroidx/compose/ui/geometry/Offset;", "currentDragPosition", "getCurrentDragPosition-_m7T9-E", "()Landroidx/compose/ui/geometry/Offset;", "setCurrentDragPosition-_kEHs6E", "(Landroidx/compose/ui/geometry/Offset;)V", "currentDragPosition$delegate", "Landroidx/compose/runtime/MutableState;", "dragBeginOffsetInText", "", "Ljava/lang/Integer;", "dragBeginPosition", "J", "dragTotalDistance", "Landroidx/compose/foundation/text/Handle;", "draggingHandle", "getDraggingHandle", "()Landroidx/compose/foundation/text/Handle;", "setDraggingHandle", "(Landroidx/compose/foundation/text/Handle;)V", "draggingHandle$delegate", "", "editable", "getEditable", "()Z", "setEditable", "(Z)V", "editable$delegate", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "getFocusRequester", "()Landroidx/compose/ui/focus/FocusRequester;", "setFocusRequester", "(Landroidx/compose/ui/focus/FocusRequester;)V", "hapticFeedBack", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "getHapticFeedBack", "()Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "setHapticFeedBack", "(Landroidx/compose/ui/hapticfeedback/HapticFeedback;)V", "mouseSelectionObserver", "Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "getMouseSelectionObserver$foundation_release", "()Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "getOffsetMapping$foundation_release", "()Landroidx/compose/ui/text/input/OffsetMapping;", "setOffsetMapping$foundation_release", "(Landroidx/compose/ui/text/input/OffsetMapping;)V", "oldValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "", "getOnValueChange$foundation_release", "()Lkotlin/jvm/functions/Function1;", "setOnValueChange$foundation_release", "(Lkotlin/jvm/functions/Function1;)V", "state", "Landroidx/compose/foundation/text/TextFieldState;", "getState$foundation_release", "()Landroidx/compose/foundation/text/TextFieldState;", "setState$foundation_release", "(Landroidx/compose/foundation/text/TextFieldState;)V", "textToolbar", "Landroidx/compose/ui/platform/TextToolbar;", "getTextToolbar", "()Landroidx/compose/ui/platform/TextToolbar;", "setTextToolbar", "(Landroidx/compose/ui/platform/TextToolbar;)V", "touchSelectionObserver", "Landroidx/compose/foundation/text/TextDragObserver;", "getTouchSelectionObserver$foundation_release", "()Landroidx/compose/foundation/text/TextDragObserver;", "getUndoManager", "()Landroidx/compose/foundation/text/UndoManager;", "value", "getValue$foundation_release", "()Landroidx/compose/ui/text/input/TextFieldValue;", "setValue$foundation_release", "(Landroidx/compose/ui/text/input/TextFieldValue;)V", "value$delegate", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "getVisualTransformation$foundation_release", "()Landroidx/compose/ui/text/input/VisualTransformation;", "setVisualTransformation$foundation_release", "(Landroidx/compose/ui/text/input/VisualTransformation;)V", "contextMenuOpenAdjustment", "position", "contextMenuOpenAdjustment-k-4lQ0M", "(J)V", "copy", "cancelSelection", "copy$foundation_release", "createTextFieldValue", "annotatedString", "Landroidx/compose/ui/text/AnnotatedString;", "selection", "Landroidx/compose/ui/text/TextRange;", "createTextFieldValue-FDrldGo", "(Landroidx/compose/ui/text/AnnotatedString;J)Landroidx/compose/ui/text/input/TextFieldValue;", "cursorDragObserver", "cursorDragObserver$foundation_release", "cut", "cut$foundation_release", "deselect", "deselect-_kEHs6E$foundation_release", "enterSelectionMode", "enterSelectionMode$foundation_release", "exitSelectionMode", "exitSelectionMode$foundation_release", "getContentRect", "Landroidx/compose/ui/geometry/Rect;", "getCursorPosition", "density", "Landroidx/compose/ui/unit/Density;", "getCursorPosition-tuRUvjQ$foundation_release", "(Landroidx/compose/ui/unit/Density;)J", "getHandlePosition", "isStartHandle", "getHandlePosition-tuRUvjQ$foundation_release", "(Z)J", "handleDragObserver", "handleDragObserver$foundation_release", "hideSelectionToolbar", "hideSelectionToolbar$foundation_release", "isTextChanged", "isTextChanged$foundation_release", "paste", "paste$foundation_release", "selectAll", "selectAll$foundation_release", "setHandleState", "handleState", "Landroidx/compose/foundation/text/HandleState;", "showSelectionToolbar", "showSelectionToolbar$foundation_release", "updateSelection", "transformedStartOffset", "transformedEndOffset", "adjustment", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TextFieldSelectionManager {
    @Nullable
    private ClipboardManager clipboardManager;
    @NotNull
    private final MutableState currentDragPosition$delegate;
    /* access modifiers changed from: private */
    @Nullable
    public Integer dragBeginOffsetInText;
    /* access modifiers changed from: private */
    public long dragBeginPosition;
    /* access modifiers changed from: private */
    public long dragTotalDistance;
    @NotNull
    private final MutableState draggingHandle$delegate;
    @NotNull
    private final MutableState editable$delegate;
    @Nullable
    private FocusRequester focusRequester;
    @Nullable
    private HapticFeedback hapticFeedBack;
    @NotNull
    private final MouseSelectionObserver mouseSelectionObserver;
    @NotNull
    private OffsetMapping offsetMapping;
    @NotNull
    private TextFieldValue oldValue;
    @NotNull
    private Function1<? super TextFieldValue, Unit> onValueChange;
    @Nullable
    private TextFieldState state;
    @Nullable
    private TextToolbar textToolbar;
    @NotNull
    private final TextDragObserver touchSelectionObserver;
    @Nullable
    private final UndoManager undoManager;
    @NotNull
    private final MutableState value$delegate;
    @NotNull
    private VisualTransformation visualTransformation;

    public TextFieldSelectionManager() {
        this((UndoManager) null, 1, (DefaultConstructorMarker) null);
    }

    public TextFieldSelectionManager(@Nullable UndoManager undoManager2) {
        this.undoManager = undoManager2;
        this.offsetMapping = ValidatingOffsetMappingKt.getValidatingEmptyOffsetMappingIdentity();
        this.onValueChange = TextFieldSelectionManager$onValueChange$1.INSTANCE;
        this.value$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue((String) null, 0, (TextRange) null, 7, (DefaultConstructorMarker) null), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.visualTransformation = VisualTransformation.Companion.getNone();
        this.editable$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, (SnapshotMutationPolicy) null, 2, (Object) null);
        Offset.Companion companion = Offset.Companion;
        this.dragBeginPosition = companion.m2692getZeroF1C5BW0();
        this.dragTotalDistance = companion.m2692getZeroF1C5BW0();
        this.draggingHandle$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.currentDragPosition$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.oldValue = new TextFieldValue((String) null, 0, (TextRange) null, 7, (DefaultConstructorMarker) null);
        this.touchSelectionObserver = new TextFieldSelectionManager$touchSelectionObserver$1(this);
        this.mouseSelectionObserver = new TextFieldSelectionManager$mouseSelectionObserver$1(this);
    }

    public static /* synthetic */ void copy$foundation_release$default(TextFieldSelectionManager textFieldSelectionManager, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = true;
        }
        textFieldSelectionManager.copy$foundation_release(z11);
    }

    /* access modifiers changed from: private */
    /* renamed from: createTextFieldValue-FDrldGo  reason: not valid java name */
    public final TextFieldValue m1044createTextFieldValueFDrldGo(AnnotatedString annotatedString, long j11) {
        return new TextFieldValue(annotatedString, j11, (TextRange) null, 4, (DefaultConstructorMarker) null);
    }

    /* renamed from: deselect-_kEHs6E$foundation_release$default  reason: not valid java name */
    public static /* synthetic */ void m1045deselect_kEHs6E$foundation_release$default(TextFieldSelectionManager textFieldSelectionManager, Offset offset, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            offset = null;
        }
        textFieldSelectionManager.m1048deselect_kEHs6E$foundation_release(offset);
    }

    private final Rect getContentRect() {
        long j11;
        long j12;
        float f11;
        LayoutCoordinates layoutCoordinates;
        float f12;
        TextLayoutResult value;
        Rect cursorRect;
        LayoutCoordinates layoutCoordinates2;
        float f13;
        TextLayoutResult value2;
        Rect cursorRect2;
        LayoutCoordinates layoutCoordinates3;
        LayoutCoordinates layoutCoordinates4;
        TextFieldState textFieldState = this.state;
        if (textFieldState == null) {
            return Rect.Companion.getZero();
        }
        if (textFieldState == null || (layoutCoordinates4 = textFieldState.getLayoutCoordinates()) == null) {
            j11 = Offset.Companion.m2692getZeroF1C5BW0();
        } else {
            j11 = layoutCoordinates4.m4475localToRootMKHz9U(m1051getHandlePositiontuRUvjQ$foundation_release(true));
        }
        TextFieldState textFieldState2 = this.state;
        if (textFieldState2 == null || (layoutCoordinates3 = textFieldState2.getLayoutCoordinates()) == null) {
            j12 = Offset.Companion.m2692getZeroF1C5BW0();
        } else {
            j12 = layoutCoordinates3.m4475localToRootMKHz9U(m1051getHandlePositiontuRUvjQ$foundation_release(false));
        }
        TextFieldState textFieldState3 = this.state;
        float f14 = 0.0f;
        if (textFieldState3 == null || (layoutCoordinates2 = textFieldState3.getLayoutCoordinates()) == null) {
            f11 = 0.0f;
        } else {
            TextLayoutResultProxy layoutResult = textFieldState.getLayoutResult();
            if (layoutResult == null || (value2 = layoutResult.getValue()) == null || (cursorRect2 = value2.getCursorRect(RangesKt___RangesKt.coerceIn(TextRange.m5038getStartimpl(getValue$foundation_release().m5234getSelectiond9O1mEE()), 0, Math.max(0, getValue$foundation_release().getText().length() - 1)))) == null) {
                f13 = 0.0f;
            } else {
                f13 = cursorRect2.getTop();
            }
            f11 = Offset.m2677getYimpl(layoutCoordinates2.m4475localToRootMKHz9U(OffsetKt.Offset(0.0f, f13)));
        }
        TextFieldState textFieldState4 = this.state;
        if (!(textFieldState4 == null || (layoutCoordinates = textFieldState4.getLayoutCoordinates()) == null)) {
            TextLayoutResultProxy layoutResult2 = textFieldState.getLayoutResult();
            if (layoutResult2 == null || (value = layoutResult2.getValue()) == null || (cursorRect = value.getCursorRect(RangesKt___RangesKt.coerceIn(TextRange.m5033getEndimpl(getValue$foundation_release().m5234getSelectiond9O1mEE()), 0, Math.max(0, getValue$foundation_release().getText().length() - 1)))) == null) {
                f12 = 0.0f;
            } else {
                f12 = cursorRect.getTop();
            }
            f14 = Offset.m2677getYimpl(layoutCoordinates.m4475localToRootMKHz9U(OffsetKt.Offset(0.0f, f12)));
        }
        return new Rect(Math.min(Offset.m2676getXimpl(j11), Offset.m2676getXimpl(j12)), Math.min(f11, f14), Math.max(Offset.m2676getXimpl(j11), Offset.m2676getXimpl(j12)), Math.max(Offset.m2677getYimpl(j11), Offset.m2677getYimpl(j12)) + (Dp.m5478constructorimpl((float) 25) * textFieldState.getTextDelegate().getDensity().getDensity()));
    }

    /* access modifiers changed from: private */
    /* renamed from: setCurrentDragPosition-_kEHs6E  reason: not valid java name */
    public final void m1046setCurrentDragPosition_kEHs6E(Offset offset) {
        this.currentDragPosition$delegate.setValue(offset);
    }

    /* access modifiers changed from: private */
    public final void setDraggingHandle(Handle handle) {
        this.draggingHandle$delegate.setValue(handle);
    }

    private final void setHandleState(HandleState handleState) {
        TextFieldState textFieldState = this.state;
        if (textFieldState != null) {
            textFieldState.setHandleState(handleState);
        }
    }

    /* access modifiers changed from: private */
    public final void updateSelection(TextFieldValue textFieldValue, int i11, int i12, boolean z11, SelectionAdjustment selectionAdjustment) {
        TextLayoutResult textLayoutResult;
        TextLayoutResultProxy layoutResult;
        long TextRange = TextRangeKt.TextRange(this.offsetMapping.originalToTransformed(TextRange.m5038getStartimpl(textFieldValue.m5234getSelectiond9O1mEE())), this.offsetMapping.originalToTransformed(TextRange.m5033getEndimpl(textFieldValue.m5234getSelectiond9O1mEE())));
        TextFieldState textFieldState = this.state;
        TextRange textRange = null;
        if (textFieldState == null || (layoutResult = textFieldState.getLayoutResult()) == null) {
            textLayoutResult = null;
        } else {
            textLayoutResult = layoutResult.getValue();
        }
        if (!TextRange.m5032getCollapsedimpl(TextRange)) {
            textRange = TextRange.m5026boximpl(TextRange);
        }
        long r12 = TextFieldSelectionDelegateKt.m1041getTextFieldSelectionbb3KNj8(textLayoutResult, i11, i12, textRange, z11, selectionAdjustment);
        long TextRange2 = TextRangeKt.TextRange(this.offsetMapping.transformedToOriginal(TextRange.m5038getStartimpl(r12)), this.offsetMapping.transformedToOriginal(TextRange.m5033getEndimpl(r12)));
        if (!TextRange.m5031equalsimpl0(TextRange2, textFieldValue.m5234getSelectiond9O1mEE())) {
            HapticFeedback hapticFeedback = this.hapticFeedBack;
            if (hapticFeedback != null) {
                hapticFeedback.m3558performHapticFeedbackCdsT49E(HapticFeedbackType.Companion.m3567getTextHandleMove5zf0vsI());
            }
            this.onValueChange.invoke(m1044createTextFieldValueFDrldGo(textFieldValue.getAnnotatedString(), TextRange2));
            TextFieldState textFieldState2 = this.state;
            if (textFieldState2 != null) {
                textFieldState2.setShowSelectionHandleStart(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(this, true));
            }
            TextFieldState textFieldState3 = this.state;
            if (textFieldState3 != null) {
                textFieldState3.setShowSelectionHandleEnd(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(this, false));
            }
        }
    }

    /* renamed from: contextMenuOpenAdjustment-k-4lQ0M  reason: not valid java name */
    public final void m1047contextMenuOpenAdjustmentk4lQ0M(long j11) {
        TextLayoutResultProxy layoutResult;
        TextFieldState textFieldState = this.state;
        if (textFieldState != null && (layoutResult = textFieldState.getLayoutResult()) != null) {
            int r102 = TextLayoutResultProxy.m932getOffsetForPosition3MmeM6k$default(layoutResult, j11, false, 2, (Object) null);
            if (!TextRange.m5029containsimpl(getValue$foundation_release().m5234getSelectiond9O1mEE(), r102)) {
                updateSelection(getValue$foundation_release(), r102, r102, false, SelectionAdjustment.Companion.getWord());
            }
        }
    }

    public final void copy$foundation_release(boolean z11) {
        if (!TextRange.m5032getCollapsedimpl(getValue$foundation_release().m5234getSelectiond9O1mEE())) {
            ClipboardManager clipboardManager2 = this.clipboardManager;
            if (clipboardManager2 != null) {
                clipboardManager2.setText(TextFieldValueKt.getSelectedText(getValue$foundation_release()));
            }
            if (z11) {
                int r42 = TextRange.m5035getMaximpl(getValue$foundation_release().m5234getSelectiond9O1mEE());
                this.onValueChange.invoke(m1044createTextFieldValueFDrldGo(getValue$foundation_release().getAnnotatedString(), TextRangeKt.TextRange(r42, r42)));
                setHandleState(HandleState.None);
            }
        }
    }

    @NotNull
    public final TextDragObserver cursorDragObserver$foundation_release() {
        return new TextFieldSelectionManager$cursorDragObserver$1(this);
    }

    public final void cut$foundation_release() {
        if (!TextRange.m5032getCollapsedimpl(getValue$foundation_release().m5234getSelectiond9O1mEE())) {
            ClipboardManager clipboardManager2 = this.clipboardManager;
            if (clipboardManager2 != null) {
                clipboardManager2.setText(TextFieldValueKt.getSelectedText(getValue$foundation_release()));
            }
            AnnotatedString plus = TextFieldValueKt.getTextBeforeSelection(getValue$foundation_release(), getValue$foundation_release().getText().length()).plus(TextFieldValueKt.getTextAfterSelection(getValue$foundation_release(), getValue$foundation_release().getText().length()));
            int r12 = TextRange.m5036getMinimpl(getValue$foundation_release().m5234getSelectiond9O1mEE());
            this.onValueChange.invoke(m1044createTextFieldValueFDrldGo(plus, TextRangeKt.TextRange(r12, r12)));
            setHandleState(HandleState.None);
            UndoManager undoManager2 = this.undoManager;
            if (undoManager2 != null) {
                undoManager2.forceNextSnapshot();
            }
        }
    }

    /* renamed from: deselect-_kEHs6E$foundation_release  reason: not valid java name */
    public final void m1048deselect_kEHs6E$foundation_release(@Nullable Offset offset) {
        HandleState handleState;
        boolean z11;
        TextLayoutResultProxy textLayoutResultProxy;
        int i11;
        if (!TextRange.m5032getCollapsedimpl(getValue$foundation_release().m5234getSelectiond9O1mEE())) {
            TextFieldState textFieldState = this.state;
            if (textFieldState != null) {
                textLayoutResultProxy = textFieldState.getLayoutResult();
            } else {
                textLayoutResultProxy = null;
            }
            TextLayoutResultProxy textLayoutResultProxy2 = textLayoutResultProxy;
            if (offset == null || textLayoutResultProxy2 == null) {
                i11 = TextRange.m5035getMaximpl(getValue$foundation_release().m5234getSelectiond9O1mEE());
            } else {
                i11 = this.offsetMapping.transformedToOriginal(TextLayoutResultProxy.m932getOffsetForPosition3MmeM6k$default(textLayoutResultProxy2, offset.m2686unboximpl(), false, 2, (Object) null));
            }
            this.onValueChange.invoke(TextFieldValue.m5229copy3r_uNRQ$default(getValue$foundation_release(), (AnnotatedString) null, TextRangeKt.TextRange(i11), (TextRange) null, 5, (Object) null));
        }
        if (offset != null) {
            if (getValue$foundation_release().getText().length() > 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                handleState = HandleState.Cursor;
                setHandleState(handleState);
                hideSelectionToolbar$foundation_release();
            }
        }
        handleState = HandleState.None;
        setHandleState(handleState);
        hideSelectionToolbar$foundation_release();
    }

    public final void enterSelectionMode$foundation_release() {
        FocusRequester focusRequester2;
        TextFieldState textFieldState = this.state;
        boolean z11 = false;
        if (textFieldState != null && !textFieldState.getHasFocus()) {
            z11 = true;
        }
        if (z11 && (focusRequester2 = this.focusRequester) != null) {
            focusRequester2.requestFocus();
        }
        this.oldValue = getValue$foundation_release();
        TextFieldState textFieldState2 = this.state;
        if (textFieldState2 != null) {
            textFieldState2.setShowFloatingToolbar(true);
        }
        setHandleState(HandleState.Selection);
    }

    public final void exitSelectionMode$foundation_release() {
        TextFieldState textFieldState = this.state;
        if (textFieldState != null) {
            textFieldState.setShowFloatingToolbar(false);
        }
        setHandleState(HandleState.None);
    }

    @Nullable
    public final ClipboardManager getClipboardManager$foundation_release() {
        return this.clipboardManager;
    }

    @Nullable
    /* renamed from: getCurrentDragPosition-_m7T9-E  reason: not valid java name */
    public final Offset m1049getCurrentDragPosition_m7T9E() {
        return (Offset) this.currentDragPosition$delegate.getValue();
    }

    /* renamed from: getCursorPosition-tuRUvjQ$foundation_release  reason: not valid java name */
    public final long m1050getCursorPositiontuRUvjQ$foundation_release(@NotNull Density density) {
        TextLayoutResultProxy textLayoutResultProxy;
        Intrinsics.checkNotNullParameter(density, State.KEY_DENSITY);
        int originalToTransformed = this.offsetMapping.originalToTransformed(TextRange.m5038getStartimpl(getValue$foundation_release().m5234getSelectiond9O1mEE()));
        TextFieldState textFieldState = this.state;
        if (textFieldState != null) {
            textLayoutResultProxy = textFieldState.getLayoutResult();
        } else {
            textLayoutResultProxy = null;
        }
        Intrinsics.checkNotNull(textLayoutResultProxy);
        TextLayoutResult value = textLayoutResultProxy.getValue();
        Rect cursorRect = value.getCursorRect(RangesKt___RangesKt.coerceIn(originalToTransformed, 0, value.getLayoutInput().getText().length()));
        return OffsetKt.Offset(cursorRect.getLeft() + (density.m5447toPx0680j_4(TextFieldCursorKt.getDefaultCursorThickness()) / ((float) 2)), cursorRect.getBottom());
    }

    @Nullable
    public final Handle getDraggingHandle() {
        return (Handle) this.draggingHandle$delegate.getValue();
    }

    public final boolean getEditable() {
        return ((Boolean) this.editable$delegate.getValue()).booleanValue();
    }

    @Nullable
    public final FocusRequester getFocusRequester() {
        return this.focusRequester;
    }

    /* renamed from: getHandlePosition-tuRUvjQ$foundation_release  reason: not valid java name */
    public final long m1051getHandlePositiontuRUvjQ$foundation_release(boolean z11) {
        int i11;
        TextLayoutResultProxy textLayoutResultProxy;
        long r02 = getValue$foundation_release().m5234getSelectiond9O1mEE();
        if (z11) {
            i11 = TextRange.m5038getStartimpl(r02);
        } else {
            i11 = TextRange.m5033getEndimpl(r02);
        }
        TextFieldState textFieldState = this.state;
        if (textFieldState != null) {
            textLayoutResultProxy = textFieldState.getLayoutResult();
        } else {
            textLayoutResultProxy = null;
        }
        Intrinsics.checkNotNull(textLayoutResultProxy);
        return TextSelectionDelegateKt.getSelectionHandleCoordinates(textLayoutResultProxy.getValue(), this.offsetMapping.originalToTransformed(i11), z11, TextRange.m5037getReversedimpl(getValue$foundation_release().m5234getSelectiond9O1mEE()));
    }

    @Nullable
    public final HapticFeedback getHapticFeedBack() {
        return this.hapticFeedBack;
    }

    @NotNull
    public final MouseSelectionObserver getMouseSelectionObserver$foundation_release() {
        return this.mouseSelectionObserver;
    }

    @NotNull
    public final OffsetMapping getOffsetMapping$foundation_release() {
        return this.offsetMapping;
    }

    @NotNull
    public final Function1<TextFieldValue, Unit> getOnValueChange$foundation_release() {
        return this.onValueChange;
    }

    @Nullable
    public final TextFieldState getState$foundation_release() {
        return this.state;
    }

    @Nullable
    public final TextToolbar getTextToolbar() {
        return this.textToolbar;
    }

    @NotNull
    public final TextDragObserver getTouchSelectionObserver$foundation_release() {
        return this.touchSelectionObserver;
    }

    @Nullable
    public final UndoManager getUndoManager() {
        return this.undoManager;
    }

    @NotNull
    public final TextFieldValue getValue$foundation_release() {
        return (TextFieldValue) this.value$delegate.getValue();
    }

    @NotNull
    public final VisualTransformation getVisualTransformation$foundation_release() {
        return this.visualTransformation;
    }

    @NotNull
    public final TextDragObserver handleDragObserver$foundation_release(boolean z11) {
        return new TextFieldSelectionManager$handleDragObserver$1(this, z11);
    }

    public final void hideSelectionToolbar$foundation_release() {
        TextToolbarStatus textToolbarStatus;
        TextToolbar textToolbar2;
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

    public final boolean isTextChanged$foundation_release() {
        return !Intrinsics.areEqual((Object) this.oldValue.getText(), (Object) getValue$foundation_release().getText());
    }

    public final void paste$foundation_release() {
        AnnotatedString text;
        ClipboardManager clipboardManager2 = this.clipboardManager;
        if (clipboardManager2 != null && (text = clipboardManager2.getText()) != null) {
            AnnotatedString plus = TextFieldValueKt.getTextBeforeSelection(getValue$foundation_release(), getValue$foundation_release().getText().length()).plus(text).plus(TextFieldValueKt.getTextAfterSelection(getValue$foundation_release(), getValue$foundation_release().getText().length()));
            int r22 = TextRange.m5036getMinimpl(getValue$foundation_release().m5234getSelectiond9O1mEE()) + text.length();
            this.onValueChange.invoke(m1044createTextFieldValueFDrldGo(plus, TextRangeKt.TextRange(r22, r22)));
            setHandleState(HandleState.None);
            UndoManager undoManager2 = this.undoManager;
            if (undoManager2 != null) {
                undoManager2.forceNextSnapshot();
            }
        }
    }

    public final void selectAll$foundation_release() {
        TextFieldValue r02 = m1044createTextFieldValueFDrldGo(getValue$foundation_release().getAnnotatedString(), TextRangeKt.TextRange(0, getValue$foundation_release().getText().length()));
        this.onValueChange.invoke(r02);
        this.oldValue = TextFieldValue.m5229copy3r_uNRQ$default(this.oldValue, (AnnotatedString) null, r02.m5234getSelectiond9O1mEE(), (TextRange) null, 5, (Object) null);
        TextFieldState textFieldState = this.state;
        if (textFieldState != null) {
            textFieldState.setShowFloatingToolbar(true);
        }
    }

    public final void setClipboardManager$foundation_release(@Nullable ClipboardManager clipboardManager2) {
        this.clipboardManager = clipboardManager2;
    }

    public final void setEditable(boolean z11) {
        this.editable$delegate.setValue(Boolean.valueOf(z11));
    }

    public final void setFocusRequester(@Nullable FocusRequester focusRequester2) {
        this.focusRequester = focusRequester2;
    }

    public final void setHapticFeedBack(@Nullable HapticFeedback hapticFeedback) {
        this.hapticFeedBack = hapticFeedback;
    }

    public final void setOffsetMapping$foundation_release(@NotNull OffsetMapping offsetMapping2) {
        Intrinsics.checkNotNullParameter(offsetMapping2, "<set-?>");
        this.offsetMapping = offsetMapping2;
    }

    public final void setOnValueChange$foundation_release(@NotNull Function1<? super TextFieldValue, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.onValueChange = function1;
    }

    public final void setState$foundation_release(@Nullable TextFieldState textFieldState) {
        this.state = textFieldState;
    }

    public final void setTextToolbar(@Nullable TextToolbar textToolbar2) {
        this.textToolbar = textToolbar2;
    }

    public final void setValue$foundation_release(@NotNull TextFieldValue textFieldValue) {
        Intrinsics.checkNotNullParameter(textFieldValue, "<set-?>");
        this.value$delegate.setValue(textFieldValue);
    }

    public final void setVisualTransformation$foundation_release(@NotNull VisualTransformation visualTransformation2) {
        Intrinsics.checkNotNullParameter(visualTransformation2, "<set-?>");
        this.visualTransformation = visualTransformation2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void showSelectionToolbar$foundation_release() {
        /*
            r9 = this;
            androidx.compose.ui.text.input.VisualTransformation r0 = r9.visualTransformation
            boolean r0 = r0 instanceof androidx.compose.ui.text.input.PasswordVisualTransformation
            androidx.compose.ui.text.input.TextFieldValue r1 = r9.getValue$foundation_release()
            long r1 = r1.m5234getSelectiond9O1mEE()
            boolean r1 = androidx.compose.ui.text.TextRange.m5032getCollapsedimpl(r1)
            r2 = 0
            if (r1 != 0) goto L_0x001c
            if (r0 != 0) goto L_0x001c
            androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$copy$1 r1 = new androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$copy$1
            r1.<init>(r9)
            r5 = r1
            goto L_0x001d
        L_0x001c:
            r5 = r2
        L_0x001d:
            androidx.compose.ui.text.input.TextFieldValue r1 = r9.getValue$foundation_release()
            long r3 = r1.m5234getSelectiond9O1mEE()
            boolean r1 = androidx.compose.ui.text.TextRange.m5032getCollapsedimpl(r3)
            if (r1 != 0) goto L_0x003a
            boolean r1 = r9.getEditable()
            if (r1 == 0) goto L_0x003a
            if (r0 != 0) goto L_0x003a
            androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$cut$1 r0 = new androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$cut$1
            r0.<init>(r9)
            r7 = r0
            goto L_0x003b
        L_0x003a:
            r7 = r2
        L_0x003b:
            boolean r0 = r9.getEditable()
            if (r0 == 0) goto L_0x0054
            androidx.compose.ui.platform.ClipboardManager r0 = r9.clipboardManager
            if (r0 == 0) goto L_0x004a
            androidx.compose.ui.text.AnnotatedString r0 = r0.getText()
            goto L_0x004b
        L_0x004a:
            r0 = r2
        L_0x004b:
            if (r0 == 0) goto L_0x0054
            androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$paste$1 r0 = new androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$paste$1
            r0.<init>(r9)
            r6 = r0
            goto L_0x0055
        L_0x0054:
            r6 = r2
        L_0x0055:
            androidx.compose.ui.text.input.TextFieldValue r0 = r9.getValue$foundation_release()
            long r0 = r0.m5234getSelectiond9O1mEE()
            int r0 = androidx.compose.ui.text.TextRange.m5034getLengthimpl(r0)
            androidx.compose.ui.text.input.TextFieldValue r1 = r9.getValue$foundation_release()
            java.lang.String r1 = r1.getText()
            int r1 = r1.length()
            if (r0 == r1) goto L_0x0074
            androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$selectAll$1 r2 = new androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$selectAll$1
            r2.<init>(r9)
        L_0x0074:
            r8 = r2
            androidx.compose.ui.platform.TextToolbar r3 = r9.textToolbar
            if (r3 == 0) goto L_0x0080
            androidx.compose.ui.geometry.Rect r4 = r9.getContentRect()
            r3.showMenu(r4, r5, r6, r7, r8)
        L_0x0080:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.TextFieldSelectionManager.showSelectionToolbar$foundation_release():void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TextFieldSelectionManager(UndoManager undoManager2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : undoManager2);
    }
}
