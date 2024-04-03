package androidx.compose.foundation.text;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.input.EditProcessor;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputSession;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.instabug.library.model.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006Jo\u0010c\u001a\u0002092\u0006\u0010]\u001a\u00020^2\u0006\u0010d\u001a\u00020^2\u0006\u0010e\u001a\u00020f2\u0006\u0010g\u001a\u00020\u00102\u0006\u0010h\u001a\u00020i2\u0006\u0010j\u001a\u00020k2\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u000209072\u0006\u0010l\u001a\u00020m2\u0006\u0010n\u001a\u00020o2\u0006\u0010p\u001a\u00020qø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\br\u0010sR+\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR+\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u00108F@FX\u0002¢\u0006\u0012\n\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u0010@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R(\u0010(\u001a\u0004\u0018\u00010'2\b\u0010&\u001a\u0004\u0018\u00010'8F@FX\u000e¢\u0006\f\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0016\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010'0.X\u0004¢\u0006\u0002\n\u0000R4\u00100\u001a\u00020/2\u0006\u0010\u0007\u001a\u00020/8F@FX\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b5\u0010\u000f\u001a\u0004\b1\u00102\"\u0004\b3\u00104R \u00106\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020907ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u001d\u0010<\u001a\u000e\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020907¢\u0006\b\n\u0000\u001a\u0004\b>\u0010;R\u001a\u0010?\u001a\u000e\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020907X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010@\u001a\u00020A¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u0011\u0010F\u001a\u00020G¢\u0006\b\n\u0000\u001a\u0004\bH\u0010IR+\u0010J\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u00108F@FX\u0002¢\u0006\u0012\n\u0004\bM\u0010\u000f\u001a\u0004\bK\u0010\u0013\"\u0004\bL\u0010\u0015R\u001a\u0010N\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\u0013\"\u0004\bP\u0010\u0015R+\u0010Q\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u00108F@FX\u0002¢\u0006\u0012\n\u0004\bT\u0010\u000f\u001a\u0004\bR\u0010\u0013\"\u0004\bS\u0010\u0015R+\u0010U\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u00108F@FX\u0002¢\u0006\u0012\n\u0004\bX\u0010\u000f\u001a\u0004\bV\u0010\u0013\"\u0004\bW\u0010\u0015R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\u001c\u0010]\u001a\u0004\u0018\u00010^X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010`\"\u0004\ba\u0010b\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006t"}, d2 = {"Landroidx/compose/foundation/text/TextFieldState;", "", "textDelegate", "Landroidx/compose/foundation/text/TextDelegate;", "recomposeScope", "Landroidx/compose/runtime/RecomposeScope;", "(Landroidx/compose/foundation/text/TextDelegate;Landroidx/compose/runtime/RecomposeScope;)V", "<set-?>", "Landroidx/compose/foundation/text/HandleState;", "handleState", "getHandleState", "()Landroidx/compose/foundation/text/HandleState;", "setHandleState", "(Landroidx/compose/foundation/text/HandleState;)V", "handleState$delegate", "Landroidx/compose/runtime/MutableState;", "", "hasFocus", "getHasFocus", "()Z", "setHasFocus", "(Z)V", "hasFocus$delegate", "inputSession", "Landroidx/compose/ui/text/input/TextInputSession;", "getInputSession", "()Landroidx/compose/ui/text/input/TextInputSession;", "setInputSession", "(Landroidx/compose/ui/text/input/TextInputSession;)V", "isLayoutResultStale", "keyboardActionRunner", "Landroidx/compose/foundation/text/KeyboardActionRunner;", "layoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getLayoutCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "setLayoutCoordinates", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "value", "Landroidx/compose/foundation/text/TextLayoutResultProxy;", "layoutResult", "getLayoutResult", "()Landroidx/compose/foundation/text/TextLayoutResultProxy;", "setLayoutResult", "(Landroidx/compose/foundation/text/TextLayoutResultProxy;)V", "layoutResultState", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/ui/unit/Dp;", "minHeightForSingleLineField", "getMinHeightForSingleLineField-D9Ej5fM", "()F", "setMinHeightForSingleLineField-0680j_4", "(F)V", "minHeightForSingleLineField$delegate", "onImeActionPerformed", "Lkotlin/Function1;", "Landroidx/compose/ui/text/input/ImeAction;", "", "getOnImeActionPerformed", "()Lkotlin/jvm/functions/Function1;", "onValueChange", "Landroidx/compose/ui/text/input/TextFieldValue;", "getOnValueChange", "onValueChangeOriginal", "processor", "Landroidx/compose/ui/text/input/EditProcessor;", "getProcessor", "()Landroidx/compose/ui/text/input/EditProcessor;", "getRecomposeScope", "()Landroidx/compose/runtime/RecomposeScope;", "selectionPaint", "Landroidx/compose/ui/graphics/Paint;", "getSelectionPaint", "()Landroidx/compose/ui/graphics/Paint;", "showCursorHandle", "getShowCursorHandle", "setShowCursorHandle", "showCursorHandle$delegate", "showFloatingToolbar", "getShowFloatingToolbar", "setShowFloatingToolbar", "showSelectionHandleEnd", "getShowSelectionHandleEnd", "setShowSelectionHandleEnd", "showSelectionHandleEnd$delegate", "showSelectionHandleStart", "getShowSelectionHandleStart", "setShowSelectionHandleStart", "showSelectionHandleStart$delegate", "getTextDelegate", "()Landroidx/compose/foundation/text/TextDelegate;", "setTextDelegate", "(Landroidx/compose/foundation/text/TextDelegate;)V", "untransformedText", "Landroidx/compose/ui/text/AnnotatedString;", "getUntransformedText", "()Landroidx/compose/ui/text/AnnotatedString;", "setUntransformedText", "(Landroidx/compose/ui/text/AnnotatedString;)V", "update", "visualText", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "softWrap", "density", "Landroidx/compose/ui/unit/Density;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "focusManager", "Landroidx/compose/ui/focus/FocusManager;", "selectionBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "update-fnh65Uc", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;ZLandroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/text/KeyboardActions;Landroidx/compose/ui/focus/FocusManager;J)V", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TextFieldState {
    @NotNull
    private final MutableState handleState$delegate;
    @NotNull
    private final MutableState hasFocus$delegate;
    @Nullable
    private TextInputSession inputSession;
    private boolean isLayoutResultStale;
    /* access modifiers changed from: private */
    @NotNull
    public final KeyboardActionRunner keyboardActionRunner;
    @Nullable
    private LayoutCoordinates layoutCoordinates;
    @NotNull
    private final MutableState<TextLayoutResultProxy> layoutResultState;
    @NotNull
    private final MutableState minHeightForSingleLineField$delegate;
    @NotNull
    private final Function1<ImeAction, Unit> onImeActionPerformed;
    @NotNull
    private final Function1<TextFieldValue, Unit> onValueChange;
    /* access modifiers changed from: private */
    @NotNull
    public Function1<? super TextFieldValue, Unit> onValueChangeOriginal;
    @NotNull
    private final EditProcessor processor = new EditProcessor();
    @NotNull
    private final RecomposeScope recomposeScope;
    @NotNull
    private final Paint selectionPaint;
    @NotNull
    private final MutableState showCursorHandle$delegate;
    private boolean showFloatingToolbar;
    @NotNull
    private final MutableState showSelectionHandleEnd$delegate;
    @NotNull
    private final MutableState showSelectionHandleStart$delegate;
    @NotNull
    private TextDelegate textDelegate;
    @Nullable
    private AnnotatedString untransformedText;

    public TextFieldState(@NotNull TextDelegate textDelegate2, @NotNull RecomposeScope recomposeScope2) {
        Intrinsics.checkNotNullParameter(textDelegate2, "textDelegate");
        Intrinsics.checkNotNullParameter(recomposeScope2, "recomposeScope");
        this.textDelegate = textDelegate2;
        this.recomposeScope = recomposeScope2;
        Boolean bool = Boolean.FALSE;
        this.hasFocus$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.minHeightForSingleLineField$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Dp.m5476boximpl(Dp.m5478constructorimpl((float) 0)), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.layoutResultState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.handleState$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(HandleState.None, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.showSelectionHandleStart$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.showSelectionHandleEnd$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.showCursorHandle$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.isLayoutResultStale = true;
        this.keyboardActionRunner = new KeyboardActionRunner();
        this.onValueChangeOriginal = TextFieldState$onValueChangeOriginal$1.INSTANCE;
        this.onValueChange = new TextFieldState$onValueChange$1(this);
        this.onImeActionPerformed = new TextFieldState$onImeActionPerformed$1(this);
        this.selectionPaint = AndroidPaint_androidKt.Paint();
    }

    @NotNull
    public final HandleState getHandleState() {
        return (HandleState) this.handleState$delegate.getValue();
    }

    public final boolean getHasFocus() {
        return ((Boolean) this.hasFocus$delegate.getValue()).booleanValue();
    }

    @Nullable
    public final TextInputSession getInputSession() {
        return this.inputSession;
    }

    @Nullable
    public final LayoutCoordinates getLayoutCoordinates() {
        return this.layoutCoordinates;
    }

    @Nullable
    public final TextLayoutResultProxy getLayoutResult() {
        return this.layoutResultState.getValue();
    }

    /* renamed from: getMinHeightForSingleLineField-D9Ej5fM  reason: not valid java name */
    public final float m926getMinHeightForSingleLineFieldD9Ej5fM() {
        return ((Dp) this.minHeightForSingleLineField$delegate.getValue()).m5492unboximpl();
    }

    @NotNull
    public final Function1<ImeAction, Unit> getOnImeActionPerformed() {
        return this.onImeActionPerformed;
    }

    @NotNull
    public final Function1<TextFieldValue, Unit> getOnValueChange() {
        return this.onValueChange;
    }

    @NotNull
    public final EditProcessor getProcessor() {
        return this.processor;
    }

    @NotNull
    public final RecomposeScope getRecomposeScope() {
        return this.recomposeScope;
    }

    @NotNull
    public final Paint getSelectionPaint() {
        return this.selectionPaint;
    }

    public final boolean getShowCursorHandle() {
        return ((Boolean) this.showCursorHandle$delegate.getValue()).booleanValue();
    }

    public final boolean getShowFloatingToolbar() {
        return this.showFloatingToolbar;
    }

    public final boolean getShowSelectionHandleEnd() {
        return ((Boolean) this.showSelectionHandleEnd$delegate.getValue()).booleanValue();
    }

    public final boolean getShowSelectionHandleStart() {
        return ((Boolean) this.showSelectionHandleStart$delegate.getValue()).booleanValue();
    }

    @NotNull
    public final TextDelegate getTextDelegate() {
        return this.textDelegate;
    }

    @Nullable
    public final AnnotatedString getUntransformedText() {
        return this.untransformedText;
    }

    public final boolean isLayoutResultStale() {
        return this.isLayoutResultStale;
    }

    public final void setHandleState(@NotNull HandleState handleState) {
        Intrinsics.checkNotNullParameter(handleState, "<set-?>");
        this.handleState$delegate.setValue(handleState);
    }

    public final void setHasFocus(boolean z11) {
        this.hasFocus$delegate.setValue(Boolean.valueOf(z11));
    }

    public final void setInputSession(@Nullable TextInputSession textInputSession) {
        this.inputSession = textInputSession;
    }

    public final void setLayoutCoordinates(@Nullable LayoutCoordinates layoutCoordinates2) {
        this.layoutCoordinates = layoutCoordinates2;
    }

    public final void setLayoutResult(@Nullable TextLayoutResultProxy textLayoutResultProxy) {
        this.layoutResultState.setValue(textLayoutResultProxy);
        this.isLayoutResultStale = false;
    }

    /* renamed from: setMinHeightForSingleLineField-0680j_4  reason: not valid java name */
    public final void m927setMinHeightForSingleLineField0680j_4(float f11) {
        this.minHeightForSingleLineField$delegate.setValue(Dp.m5476boximpl(f11));
    }

    public final void setShowCursorHandle(boolean z11) {
        this.showCursorHandle$delegate.setValue(Boolean.valueOf(z11));
    }

    public final void setShowFloatingToolbar(boolean z11) {
        this.showFloatingToolbar = z11;
    }

    public final void setShowSelectionHandleEnd(boolean z11) {
        this.showSelectionHandleEnd$delegate.setValue(Boolean.valueOf(z11));
    }

    public final void setShowSelectionHandleStart(boolean z11) {
        this.showSelectionHandleStart$delegate.setValue(Boolean.valueOf(z11));
    }

    public final void setTextDelegate(@NotNull TextDelegate textDelegate2) {
        Intrinsics.checkNotNullParameter(textDelegate2, "<set-?>");
        this.textDelegate = textDelegate2;
    }

    public final void setUntransformedText(@Nullable AnnotatedString annotatedString) {
        this.untransformedText = annotatedString;
    }

    /* renamed from: update-fnh65Uc  reason: not valid java name */
    public final void m928updatefnh65Uc(@NotNull AnnotatedString annotatedString, @NotNull AnnotatedString annotatedString2, @NotNull TextStyle textStyle, boolean z11, @NotNull Density density, @NotNull FontFamily.Resolver resolver, @NotNull Function1<? super TextFieldValue, Unit> function1, @NotNull KeyboardActions keyboardActions, @NotNull FocusManager focusManager, long j11) {
        AnnotatedString annotatedString3 = annotatedString;
        Function1<? super TextFieldValue, Unit> function12 = function1;
        KeyboardActions keyboardActions2 = keyboardActions;
        FocusManager focusManager2 = focusManager;
        Intrinsics.checkNotNullParameter(annotatedString3, "untransformedText");
        AnnotatedString annotatedString4 = annotatedString2;
        Intrinsics.checkNotNullParameter(annotatedString4, "visualText");
        TextStyle textStyle2 = textStyle;
        Intrinsics.checkNotNullParameter(textStyle2, "textStyle");
        Density density2 = density;
        Intrinsics.checkNotNullParameter(density2, State.KEY_DENSITY);
        FontFamily.Resolver resolver2 = resolver;
        Intrinsics.checkNotNullParameter(resolver2, "fontFamilyResolver");
        Intrinsics.checkNotNullParameter(function12, "onValueChange");
        Intrinsics.checkNotNullParameter(keyboardActions2, "keyboardActions");
        Intrinsics.checkNotNullParameter(focusManager2, "focusManager");
        this.onValueChangeOriginal = function12;
        this.selectionPaint.m3136setColor8_81llA(j11);
        KeyboardActionRunner keyboardActionRunner2 = this.keyboardActionRunner;
        keyboardActionRunner2.setKeyboardActions(keyboardActions2);
        keyboardActionRunner2.setFocusManager(focusManager2);
        keyboardActionRunner2.setInputSession(this.inputSession);
        this.untransformedText = annotatedString3;
        TextDelegate r12 = CoreTextKt.m845updateTextDelegatex_uQXYA$default(this.textDelegate, annotatedString4, textStyle2, density2, resolver2, z11, 0, 0, CollectionsKt__CollectionsKt.emptyList(), 192, (Object) null);
        if (this.textDelegate != r12) {
            this.isLayoutResultStale = true;
        }
        this.textDelegate = r12;
    }
}
