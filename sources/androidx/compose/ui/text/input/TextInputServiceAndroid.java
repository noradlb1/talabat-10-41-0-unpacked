package androidx.compose.ui.text.input;

import android.graphics.Rect;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.compose.ui.text.TextRange;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0000\u0018\u00002\u00020\u0001:\u0001>B\u000f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020,J\b\u0010-\u001a\u00020\u001cH\u0016J\u0006\u0010.\u001a\u00020\u000fJ\u0010\u0010/\u001a\u00020\u001c2\u0006\u00100\u001a\u000201H\u0017J\b\u00102\u001a\u00020\u001cH\u0002J\u0010\u00103\u001a\u00020\u001c2\u0006\u00104\u001a\u00020\u000fH\u0002J\b\u00105\u001a\u00020\u001cH\u0016JI\u00106\u001a\u00020\u001c2\u0006\u00107\u001a\u00020 2\u0006\u0010\u0016\u001a\u00020\u00172\u0018\u0010\u0018\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a\u0012\u0004\u0012\u00020\u001c0\u00192\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001c0\u0019H\u0016ø\u0001\u0000J\b\u00108\u001a\u00020\u001cH\u0016J\u0011\u00109\u001a\u00020\u001cH@ø\u0001\u0000¢\u0006\u0002\u0010:J\u001a\u0010;\u001a\u00020\u001c2\b\u0010<\u001a\u0004\u0018\u00010 2\u0006\u0010=\u001a\u00020 H\u0016R\u001b\u0010\b\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R \u0010\u0018\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a\u0012\u0004\u0012\u00020\u001c0\u0019X\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001c0\u0019X\u000eø\u0001\u0000¢\u0006\u0002\n\u0000R\u001e\u0010!\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020 @BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(\u0002\u0004\n\u0002\b\u0019¨\u0006?"}, d2 = {"Landroidx/compose/ui/text/input/TextInputServiceAndroid;", "Landroidx/compose/ui/text/input/PlatformTextInputService;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "inputMethodManager", "Landroidx/compose/ui/text/input/InputMethodManager;", "(Landroid/view/View;Landroidx/compose/ui/text/input/InputMethodManager;)V", "baseInputConnection", "Landroid/view/inputmethod/BaseInputConnection;", "getBaseInputConnection", "()Landroid/view/inputmethod/BaseInputConnection;", "baseInputConnection$delegate", "Lkotlin/Lazy;", "editorHasFocus", "", "focusedRect", "Landroid/graphics/Rect;", "ics", "", "Ljava/lang/ref/WeakReference;", "Landroidx/compose/ui/text/input/RecordingInputConnection;", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "onEditCommand", "Lkotlin/Function1;", "", "Landroidx/compose/ui/text/input/EditCommand;", "", "onImeActionPerformed", "Landroidx/compose/ui/text/input/ImeAction;", "<set-?>", "Landroidx/compose/ui/text/input/TextFieldValue;", "state", "getState$ui_release", "()Landroidx/compose/ui/text/input/TextFieldValue;", "textInputCommandChannel", "Lkotlinx/coroutines/channels/Channel;", "Landroidx/compose/ui/text/input/TextInputServiceAndroid$TextInputCommand;", "getView", "()Landroid/view/View;", "createInputConnection", "Landroid/view/inputmethod/InputConnection;", "outAttrs", "Landroid/view/inputmethod/EditorInfo;", "hideSoftwareKeyboard", "isEditorFocused", "notifyFocusedRect", "rect", "Landroidx/compose/ui/geometry/Rect;", "restartInputImmediately", "setKeyboardVisibleImmediately", "visible", "showSoftwareKeyboard", "startInput", "value", "stopInput", "textInputCommandEventLoop", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateState", "oldValue", "newValue", "TextInputCommand", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TextInputServiceAndroid implements PlatformTextInputService {
    @NotNull
    private final Lazy baseInputConnection$delegate;
    private boolean editorHasFocus;
    @Nullable
    private Rect focusedRect;
    /* access modifiers changed from: private */
    @NotNull
    public List<WeakReference<RecordingInputConnection>> ics;
    @NotNull
    private ImeOptions imeOptions;
    @NotNull
    private final InputMethodManager inputMethodManager;
    /* access modifiers changed from: private */
    @NotNull
    public Function1<? super List<? extends EditCommand>, Unit> onEditCommand;
    /* access modifiers changed from: private */
    @NotNull
    public Function1<? super ImeAction, Unit> onImeActionPerformed;
    @NotNull
    private TextFieldValue state;
    @NotNull
    private final Channel<TextInputCommand> textInputCommandChannel;
    @NotNull
    private final View view;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/text/input/TextInputServiceAndroid$TextInputCommand;", "", "(Ljava/lang/String;I)V", "StartInput", "StopInput", "ShowKeyboard", "HideKeyboard", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public enum TextInputCommand {
        StartInput,
        StopInput,
        ShowKeyboard,
        HideKeyboard
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TextInputCommand.values().length];
            iArr[TextInputCommand.StartInput.ordinal()] = 1;
            iArr[TextInputCommand.StopInput.ordinal()] = 2;
            iArr[TextInputCommand.ShowKeyboard.ordinal()] = 3;
            iArr[TextInputCommand.HideKeyboard.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public TextInputServiceAndroid(@NotNull View view2, @NotNull InputMethodManager inputMethodManager2) {
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(inputMethodManager2, "inputMethodManager");
        this.view = view2;
        this.inputMethodManager = inputMethodManager2;
        this.onEditCommand = TextInputServiceAndroid$onEditCommand$1.INSTANCE;
        this.onImeActionPerformed = TextInputServiceAndroid$onImeActionPerformed$1.INSTANCE;
        this.state = new TextFieldValue("", TextRange.Companion.m5043getZerod9O1mEE(), (TextRange) null, 4, (DefaultConstructorMarker) null);
        this.imeOptions = ImeOptions.Companion.getDefault();
        this.ics = new ArrayList();
        this.baseInputConnection$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new TextInputServiceAndroid$baseInputConnection$2(this));
        this.textInputCommandChannel = ChannelKt.Channel$default(Integer.MAX_VALUE, (BufferOverflow) null, (Function1) null, 6, (Object) null);
    }

    /* access modifiers changed from: private */
    public final BaseInputConnection getBaseInputConnection() {
        return (BaseInputConnection) this.baseInputConnection$delegate.getValue();
    }

    private final void restartInputImmediately() {
        this.inputMethodManager.restartInput(this.view);
    }

    private final void setKeyboardVisibleImmediately(boolean z11) {
        if (z11) {
            this.inputMethodManager.showSoftInput(this.view);
        } else {
            this.inputMethodManager.hideSoftInputFromWindow(this.view.getWindowToken());
        }
    }

    private static final void textInputCommandEventLoop$applyToState(TextInputCommand textInputCommand, Ref.ObjectRef<Boolean> objectRef, Ref.ObjectRef<Boolean> objectRef2) {
        int i11 = WhenMappings.$EnumSwitchMapping$0[textInputCommand.ordinal()];
        boolean z11 = true;
        if (i11 == 1) {
            T t11 = Boolean.TRUE;
            objectRef.element = t11;
            objectRef2.element = t11;
        } else if (i11 == 2) {
            T t12 = Boolean.FALSE;
            objectRef.element = t12;
            objectRef2.element = t12;
        } else if ((i11 == 3 || i11 == 4) && !Intrinsics.areEqual((Object) objectRef.element, (Object) Boolean.FALSE)) {
            if (textInputCommand != TextInputCommand.ShowKeyboard) {
                z11 = false;
            }
            objectRef2.element = Boolean.valueOf(z11);
        }
    }

    @Nullable
    public final InputConnection createInputConnection(@NotNull EditorInfo editorInfo) {
        Intrinsics.checkNotNullParameter(editorInfo, "outAttrs");
        if (!this.editorHasFocus) {
            return null;
        }
        TextInputServiceAndroid_androidKt.update(editorInfo, this.imeOptions, this.state);
        RecordingInputConnection recordingInputConnection = new RecordingInputConnection(this.state, new TextInputServiceAndroid$createInputConnection$1(this), this.imeOptions.getAutoCorrect());
        this.ics.add(new WeakReference(recordingInputConnection));
        return recordingInputConnection;
    }

    @NotNull
    public final TextFieldValue getState$ui_release() {
        return this.state;
    }

    @NotNull
    public final View getView() {
        return this.view;
    }

    public void hideSoftwareKeyboard() {
        this.textInputCommandChannel.m7820trySendJP2dKIU(TextInputCommand.HideKeyboard);
    }

    public final boolean isEditorFocused() {
        return this.editorHasFocus;
    }

    @Deprecated(message = "This method should not be called, used BringIntoViewRequester instead.")
    public void notifyFocusedRect(@NotNull androidx.compose.ui.geometry.Rect rect) {
        Rect rect2;
        Intrinsics.checkNotNullParameter(rect, "rect");
        this.focusedRect = new Rect(MathKt__MathJVMKt.roundToInt(rect.getLeft()), MathKt__MathJVMKt.roundToInt(rect.getTop()), MathKt__MathJVMKt.roundToInt(rect.getRight()), MathKt__MathJVMKt.roundToInt(rect.getBottom()));
        if (this.ics.isEmpty() && (rect2 = this.focusedRect) != null) {
            this.view.requestRectangleOnScreen(new Rect(rect2));
        }
    }

    public void showSoftwareKeyboard() {
        this.textInputCommandChannel.m7820trySendJP2dKIU(TextInputCommand.ShowKeyboard);
    }

    public void startInput(@NotNull TextFieldValue textFieldValue, @NotNull ImeOptions imeOptions2, @NotNull Function1<? super List<? extends EditCommand>, Unit> function1, @NotNull Function1<? super ImeAction, Unit> function12) {
        Intrinsics.checkNotNullParameter(textFieldValue, "value");
        Intrinsics.checkNotNullParameter(imeOptions2, "imeOptions");
        Intrinsics.checkNotNullParameter(function1, "onEditCommand");
        Intrinsics.checkNotNullParameter(function12, "onImeActionPerformed");
        this.editorHasFocus = true;
        this.state = textFieldValue;
        this.imeOptions = imeOptions2;
        this.onEditCommand = function1;
        this.onImeActionPerformed = function12;
        this.textInputCommandChannel.m7820trySendJP2dKIU(TextInputCommand.StartInput);
    }

    public void stopInput() {
        this.editorHasFocus = false;
        this.onEditCommand = TextInputServiceAndroid$stopInput$1.INSTANCE;
        this.onImeActionPerformed = TextInputServiceAndroid$stopInput$2.INSTANCE;
        this.focusedRect = null;
        this.textInputCommandChannel.m7820trySendJP2dKIU(TextInputCommand.StopInput);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0050 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object textInputCommandEventLoop(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof androidx.compose.ui.text.input.TextInputServiceAndroid$textInputCommandEventLoop$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            androidx.compose.ui.text.input.TextInputServiceAndroid$textInputCommandEventLoop$1 r0 = (androidx.compose.ui.text.input.TextInputServiceAndroid$textInputCommandEventLoop$1) r0
            int r1 = r0.f10219l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f10219l = r1
            goto L_0x0018
        L_0x0013:
            androidx.compose.ui.text.input.TextInputServiceAndroid$textInputCommandEventLoop$1 r0 = new androidx.compose.ui.text.input.TextInputServiceAndroid$textInputCommandEventLoop$1
            r0.<init>(r8, r9)
        L_0x0018:
            java.lang.Object r9 = r0.f10217j
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f10219l
            r3 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            java.lang.Object r2 = r0.f10216i
            kotlinx.coroutines.channels.ChannelIterator r2 = (kotlinx.coroutines.channels.ChannelIterator) r2
            java.lang.Object r4 = r0.f10215h
            androidx.compose.ui.text.input.TextInputServiceAndroid r4 = (androidx.compose.ui.text.input.TextInputServiceAndroid) r4
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0051
        L_0x0031:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r9)
            kotlinx.coroutines.channels.Channel<androidx.compose.ui.text.input.TextInputServiceAndroid$TextInputCommand> r9 = r8.textInputCommandChannel
            kotlinx.coroutines.channels.ChannelIterator r9 = r9.iterator()
            r4 = r8
            r2 = r9
        L_0x0044:
            r0.f10215h = r4
            r0.f10216i = r2
            r0.f10219l = r3
            java.lang.Object r9 = r2.hasNext(r0)
            if (r9 != r1) goto L_0x0051
            return r1
        L_0x0051:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L_0x00bd
            java.lang.Object r9 = r2.next()
            androidx.compose.ui.text.input.TextInputServiceAndroid$TextInputCommand r9 = (androidx.compose.ui.text.input.TextInputServiceAndroid.TextInputCommand) r9
            android.view.View r5 = r4.view
            boolean r5 = r5.isFocused()
            if (r5 != 0) goto L_0x0074
        L_0x0067:
            kotlinx.coroutines.channels.Channel<androidx.compose.ui.text.input.TextInputServiceAndroid$TextInputCommand> r9 = r4.textInputCommandChannel
            java.lang.Object r9 = r9.m7818tryReceivePtdJZtk()
            boolean r9 = kotlinx.coroutines.channels.ChannelResult.m7809isSuccessimpl(r9)
            if (r9 != 0) goto L_0x0067
            goto L_0x0044
        L_0x0074:
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            kotlin.jvm.internal.Ref$ObjectRef r6 = new kotlin.jvm.internal.Ref$ObjectRef
            r6.<init>()
        L_0x007e:
            if (r9 == 0) goto L_0x0090
            textInputCommandEventLoop$applyToState(r9, r5, r6)
            kotlinx.coroutines.channels.Channel<androidx.compose.ui.text.input.TextInputServiceAndroid$TextInputCommand> r9 = r4.textInputCommandChannel
            java.lang.Object r9 = r9.m7818tryReceivePtdJZtk()
            java.lang.Object r9 = kotlinx.coroutines.channels.ChannelResult.m7804getOrNullimpl(r9)
            androidx.compose.ui.text.input.TextInputServiceAndroid$TextInputCommand r9 = (androidx.compose.ui.text.input.TextInputServiceAndroid.TextInputCommand) r9
            goto L_0x007e
        L_0x0090:
            T r9 = r5.element
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r7)
            if (r9 == 0) goto L_0x009f
            r4.restartInputImmediately()
        L_0x009f:
            T r9 = r6.element
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            if (r9 == 0) goto L_0x00ac
            boolean r9 = r9.booleanValue()
            r4.setKeyboardVisibleImmediately(r9)
        L_0x00ac:
            T r9 = r5.element
            r5 = 0
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r5)
            if (r9 == 0) goto L_0x0044
            r4.restartInputImmediately()
            goto L_0x0044
        L_0x00bd:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.input.TextInputServiceAndroid.textInputCommandEventLoop(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public void updateState(@Nullable TextFieldValue textFieldValue, @NotNull TextFieldValue textFieldValue2) {
        boolean z11;
        int i11;
        int i12;
        Intrinsics.checkNotNullParameter(textFieldValue2, "newValue");
        boolean z12 = true;
        if (!TextRange.m5031equalsimpl0(this.state.m5234getSelectiond9O1mEE(), textFieldValue2.m5234getSelectiond9O1mEE()) || !Intrinsics.areEqual((Object) this.state.m5233getCompositionMzsxiRA(), (Object) textFieldValue2.m5233getCompositionMzsxiRA())) {
            z11 = true;
        } else {
            z11 = false;
        }
        this.state = textFieldValue2;
        int size = this.ics.size();
        for (int i13 = 0; i13 < size; i13++) {
            RecordingInputConnection recordingInputConnection = (RecordingInputConnection) this.ics.get(i13).get();
            if (recordingInputConnection != null) {
                recordingInputConnection.setMTextFieldValue$ui_release(textFieldValue2);
            }
        }
        if (!Intrinsics.areEqual((Object) textFieldValue, (Object) textFieldValue2)) {
            if (textFieldValue == null || (Intrinsics.areEqual((Object) textFieldValue.getText(), (Object) textFieldValue2.getText()) && (!TextRange.m5031equalsimpl0(textFieldValue.m5234getSelectiond9O1mEE(), textFieldValue2.m5234getSelectiond9O1mEE()) || Intrinsics.areEqual((Object) textFieldValue.m5233getCompositionMzsxiRA(), (Object) textFieldValue2.m5233getCompositionMzsxiRA())))) {
                z12 = false;
            }
            if (z12) {
                restartInputImmediately();
                return;
            }
            int size2 = this.ics.size();
            for (int i14 = 0; i14 < size2; i14++) {
                RecordingInputConnection recordingInputConnection2 = (RecordingInputConnection) this.ics.get(i14).get();
                if (recordingInputConnection2 != null) {
                    recordingInputConnection2.updateInputState(this.state, this.inputMethodManager, this.view);
                }
            }
        } else if (z11) {
            InputMethodManager inputMethodManager2 = this.inputMethodManager;
            View view2 = this.view;
            int r62 = TextRange.m5036getMinimpl(textFieldValue2.m5234getSelectiond9O1mEE());
            int r72 = TextRange.m5035getMaximpl(textFieldValue2.m5234getSelectiond9O1mEE());
            TextRange r11 = this.state.m5233getCompositionMzsxiRA();
            if (r11 != null) {
                i11 = TextRange.m5036getMinimpl(r11.m5042unboximpl());
            } else {
                i11 = -1;
            }
            TextRange r112 = this.state.m5233getCompositionMzsxiRA();
            if (r112 != null) {
                i12 = TextRange.m5035getMaximpl(r112.m5042unboximpl());
            } else {
                i12 = -1;
            }
            inputMethodManager2.updateSelection(view2, r62, r72, i11, i12);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TextInputServiceAndroid(@org.jetbrains.annotations.NotNull android.view.View r4) {
        /*
            r3 = this;
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            androidx.compose.ui.text.input.InputMethodManagerImpl r0 = new androidx.compose.ui.text.input.InputMethodManagerImpl
            android.content.Context r1 = r4.getContext()
            java.lang.String r2 = "view.context"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            r0.<init>(r1)
            r3.<init>(r4, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.input.TextInputServiceAndroid.<init>(android.view.View):void");
    }
}
