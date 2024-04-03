package androidx.compose.foundation.text;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.relocation.BringIntoViewRequester;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.foundation.text.selection.TextFieldSelectionManagerKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.text.input.TextInputSession;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import com.google.android.exoplayer2.RendererCapabilities;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aä\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00132\b\b\u0002\u0010\u001b\u001a\u00020\u001323\b\u0002\u0010\u001c\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u001d¢\u0006\u0002\b\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u001eH\u0001¢\u0006\u0002\u0010\"\u001a0\u0010#\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010$\u001a\u00020%2\u0011\u0010&\u001a\r\u0012\u0004\u0012\u00020\u00010\u001d¢\u0006\u0002\b\u001eH\u0003¢\u0006\u0002\u0010'\u001a\u001d\u0010(\u001a\u00020\u00012\u0006\u0010$\u001a\u00020%2\u0006\u0010)\u001a\u00020\u0013H\u0003¢\u0006\u0002\u0010*\u001a\u0015\u0010+\u001a\u00020\u00012\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0002\u0010,\u001a(\u0010-\u001a\u00020\u00012\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H\u0002\u001a\u0010\u00102\u001a\u00020\u00012\u0006\u00100\u001a\u000201H\u0002\u001a \u00103\u001a\u00020\u00012\u0006\u00100\u001a\u0002012\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u0013H\u0002\u001a5\u00107\u001a\u00020\u0001*\u0002082\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\r2\u0006\u0010<\u001a\u00020=H@ø\u0001\u0000¢\u0006\u0002\u0010>\u001a\u001c\u0010?\u001a\u00020\u0007*\u00020\u00072\u0006\u00100\u001a\u0002012\u0006\u0010$\u001a\u00020%H\u0002\u0002\u0004\n\u0002\b\u0019¨\u0006@"}, d2 = {"CoreTextField", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "onTextLayout", "Landroidx/compose/ui/text/TextLayoutResult;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "softWrap", "", "maxLines", "", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "enabled", "readOnly", "decorationBox", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ParameterName;", "name", "innerTextField", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;ZILandroidx/compose/ui/text/input/ImeOptions;Landroidx/compose/foundation/text/KeyboardActions;ZZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "CoreTextFieldRootBox", "manager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "content", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "SelectionToolbarAndHandles", "show", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;ZLandroidx/compose/runtime/Composer;I)V", "TextFieldCursorHandle", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Landroidx/compose/runtime/Composer;I)V", "notifyTextInputServiceOnFocusChange", "textInputService", "Landroidx/compose/ui/text/input/TextInputService;", "state", "Landroidx/compose/foundation/text/TextFieldState;", "onBlur", "tapToFocus", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "allowKeyboard", "bringSelectionEndIntoView", "Landroidx/compose/foundation/relocation/BringIntoViewRequester;", "textDelegate", "Landroidx/compose/foundation/text/TextDelegate;", "textLayoutResult", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "(Landroidx/compose/foundation/relocation/BringIntoViewRequester;Landroidx/compose/ui/text/input/TextFieldValue;Landroidx/compose/foundation/text/TextDelegate;Landroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/text/input/OffsetMapping;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "previewKeyEventToDeselectOnBack", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class CoreTextFieldKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r26v0, resolved type: kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r47v1, resolved type: androidx.compose.runtime.saveable.Saver<androidx.compose.foundation.text.TextFieldScrollerPosition, java.lang.Object>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r26v1, resolved type: kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r26v2, resolved type: kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r26v3, resolved type: kotlin.jvm.functions.Function3<kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r26v4, resolved type: kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r26v5, resolved type: kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0164  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x016c  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x016f  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0188  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x018b  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x01a5  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x01a8  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x01c0  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x01c5  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x01f2  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0212  */
    /* JADX WARNING: Removed duplicated region for block: B:299:0x0755  */
    /* JADX WARNING: Removed duplicated region for block: B:301:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0135  */
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]]")
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void CoreTextField(@org.jetbrains.annotations.NotNull androidx.compose.ui.text.input.TextFieldValue r44, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit> r45, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r46, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.TextStyle r47, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.input.VisualTransformation r48, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r49, @org.jetbrains.annotations.Nullable androidx.compose.foundation.interaction.MutableInteractionSource r50, @org.jetbrains.annotations.Nullable androidx.compose.ui.graphics.Brush r51, boolean r52, int r53, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.input.ImeOptions r54, @org.jetbrains.annotations.Nullable androidx.compose.foundation.text.KeyboardActions r55, boolean r56, boolean r57, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r58, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r59, int r60, int r61, int r62) {
        /*
            r15 = r44
            r14 = r45
            r13 = r60
            r12 = r61
            r11 = r62
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "onValueChange"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = 109313709(0x683fead, float:4.9650936E-35)
            r1 = r59
            androidx.compose.runtime.Composer r10 = r1.startRestartGroup(r0)
            r1 = r11 & 1
            if (r1 == 0) goto L_0x0024
            r1 = r13 | 6
            goto L_0x0034
        L_0x0024:
            r1 = r13 & 14
            if (r1 != 0) goto L_0x0033
            boolean r1 = r10.changed((java.lang.Object) r15)
            if (r1 == 0) goto L_0x0030
            r1 = 4
            goto L_0x0031
        L_0x0030:
            r1 = 2
        L_0x0031:
            r1 = r1 | r13
            goto L_0x0034
        L_0x0033:
            r1 = r13
        L_0x0034:
            r4 = r11 & 2
            if (r4 == 0) goto L_0x003b
            r1 = r1 | 48
            goto L_0x004b
        L_0x003b:
            r4 = r13 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x004b
            boolean r4 = r10.changed((java.lang.Object) r14)
            if (r4 == 0) goto L_0x0048
            r4 = 32
            goto L_0x004a
        L_0x0048:
            r4 = 16
        L_0x004a:
            r1 = r1 | r4
        L_0x004b:
            r4 = r11 & 4
            if (r4 == 0) goto L_0x0052
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x0066
        L_0x0052:
            r9 = r13 & 896(0x380, float:1.256E-42)
            if (r9 != 0) goto L_0x0066
            r9 = r46
            boolean r16 = r10.changed((java.lang.Object) r9)
            if (r16 == 0) goto L_0x0061
            r16 = 256(0x100, float:3.59E-43)
            goto L_0x0063
        L_0x0061:
            r16 = 128(0x80, float:1.794E-43)
        L_0x0063:
            r1 = r1 | r16
            goto L_0x0068
        L_0x0066:
            r9 = r46
        L_0x0068:
            r16 = r11 & 8
            r17 = 2048(0x800, float:2.87E-42)
            r18 = 1024(0x400, float:1.435E-42)
            if (r16 == 0) goto L_0x0073
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x0087
        L_0x0073:
            r2 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r2 != 0) goto L_0x0087
            r2 = r47
            boolean r19 = r10.changed((java.lang.Object) r2)
            if (r19 == 0) goto L_0x0082
            r19 = r17
            goto L_0x0084
        L_0x0082:
            r19 = r18
        L_0x0084:
            r1 = r1 | r19
            goto L_0x0089
        L_0x0087:
            r2 = r47
        L_0x0089:
            r19 = r11 & 16
            r20 = 16384(0x4000, float:2.2959E-41)
            r21 = 8192(0x2000, float:1.14794E-41)
            if (r19 == 0) goto L_0x0096
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r5 = r48
            goto L_0x00ac
        L_0x0096:
            r22 = 57344(0xe000, float:8.0356E-41)
            r22 = r13 & r22
            r5 = r48
            if (r22 != 0) goto L_0x00ac
            boolean r23 = r10.changed((java.lang.Object) r5)
            if (r23 == 0) goto L_0x00a8
            r23 = r20
            goto L_0x00aa
        L_0x00a8:
            r23 = r21
        L_0x00aa:
            r1 = r1 | r23
        L_0x00ac:
            r23 = r11 & 32
            if (r23 == 0) goto L_0x00b7
            r24 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r24
            r6 = r49
            goto L_0x00cc
        L_0x00b7:
            r24 = 458752(0x70000, float:6.42848E-40)
            r24 = r13 & r24
            r6 = r49
            if (r24 != 0) goto L_0x00cc
            boolean r25 = r10.changed((java.lang.Object) r6)
            if (r25 == 0) goto L_0x00c8
            r25 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00ca
        L_0x00c8:
            r25 = 65536(0x10000, float:9.18355E-41)
        L_0x00ca:
            r1 = r1 | r25
        L_0x00cc:
            r25 = r11 & 64
            if (r25 == 0) goto L_0x00d7
            r26 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r26
            r7 = r50
            goto L_0x00ec
        L_0x00d7:
            r26 = 3670016(0x380000, float:5.142788E-39)
            r26 = r13 & r26
            r7 = r50
            if (r26 != 0) goto L_0x00ec
            boolean r27 = r10.changed((java.lang.Object) r7)
            if (r27 == 0) goto L_0x00e8
            r27 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00ea
        L_0x00e8:
            r27 = 524288(0x80000, float:7.34684E-40)
        L_0x00ea:
            r1 = r1 | r27
        L_0x00ec:
            r27 = 29360128(0x1c00000, float:7.052966E-38)
            r27 = r13 & r27
            if (r27 != 0) goto L_0x0108
            r8 = r11 & 128(0x80, float:1.794E-43)
            if (r8 != 0) goto L_0x0101
            r8 = r51
            boolean r28 = r10.changed((java.lang.Object) r8)
            if (r28 == 0) goto L_0x0103
            r28 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0105
        L_0x0101:
            r8 = r51
        L_0x0103:
            r28 = 4194304(0x400000, float:5.877472E-39)
        L_0x0105:
            r1 = r1 | r28
            goto L_0x010a
        L_0x0108:
            r8 = r51
        L_0x010a:
            r3 = r11 & 256(0x100, float:3.59E-43)
            if (r3 == 0) goto L_0x0115
            r29 = 100663296(0x6000000, float:2.4074124E-35)
            r1 = r1 | r29
            r0 = r52
            goto L_0x012a
        L_0x0115:
            r29 = 234881024(0xe000000, float:1.5777218E-30)
            r29 = r13 & r29
            r0 = r52
            if (r29 != 0) goto L_0x012a
            boolean r30 = r10.changed((boolean) r0)
            if (r30 == 0) goto L_0x0126
            r30 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0128
        L_0x0126:
            r30 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0128:
            r1 = r1 | r30
        L_0x012a:
            r0 = r11 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x0135
            r30 = 805306368(0x30000000, float:4.656613E-10)
            r1 = r1 | r30
            r2 = r53
            goto L_0x014a
        L_0x0135:
            r30 = 1879048192(0x70000000, float:1.58456325E29)
            r30 = r13 & r30
            r2 = r53
            if (r30 != 0) goto L_0x014a
            boolean r30 = r10.changed((int) r2)
            if (r30 == 0) goto L_0x0146
            r30 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0148
        L_0x0146:
            r30 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0148:
            r1 = r1 | r30
        L_0x014a:
            r30 = r12 & 14
            if (r30 != 0) goto L_0x0164
            r2 = r11 & 1024(0x400, float:1.435E-42)
            if (r2 != 0) goto L_0x015d
            r2 = r54
            boolean r30 = r10.changed((java.lang.Object) r2)
            if (r30 == 0) goto L_0x015f
            r30 = 4
            goto L_0x0161
        L_0x015d:
            r2 = r54
        L_0x015f:
            r30 = 2
        L_0x0161:
            r30 = r12 | r30
            goto L_0x0168
        L_0x0164:
            r2 = r54
            r30 = r12
        L_0x0168:
            r2 = r11 & 2048(0x800, float:2.87E-42)
            if (r2 == 0) goto L_0x016f
            r30 = r30 | 48
            goto L_0x0182
        L_0x016f:
            r31 = r12 & 112(0x70, float:1.57E-43)
            r5 = r55
            if (r31 != 0) goto L_0x0182
            boolean r31 = r10.changed((java.lang.Object) r5)
            if (r31 == 0) goto L_0x017e
            r22 = 32
            goto L_0x0180
        L_0x017e:
            r22 = 16
        L_0x0180:
            r30 = r30 | r22
        L_0x0182:
            r5 = r30
            r6 = r11 & 4096(0x1000, float:5.74E-42)
            if (r6 == 0) goto L_0x018b
            r5 = r5 | 384(0x180, float:5.38E-43)
            goto L_0x019f
        L_0x018b:
            r7 = r12 & 896(0x380, float:1.256E-42)
            if (r7 != 0) goto L_0x019f
            r7 = r56
            boolean r22 = r10.changed((boolean) r7)
            if (r22 == 0) goto L_0x019a
            r26 = 256(0x100, float:3.59E-43)
            goto L_0x019c
        L_0x019a:
            r26 = 128(0x80, float:1.794E-43)
        L_0x019c:
            r5 = r5 | r26
            goto L_0x01a1
        L_0x019f:
            r7 = r56
        L_0x01a1:
            r7 = r11 & 8192(0x2000, float:1.14794E-41)
            if (r7 == 0) goto L_0x01a8
            r5 = r5 | 3072(0xc00, float:4.305E-42)
            goto L_0x01ba
        L_0x01a8:
            r8 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x01ba
            r8 = r57
            boolean r22 = r10.changed((boolean) r8)
            if (r22 == 0) goto L_0x01b5
            goto L_0x01b7
        L_0x01b5:
            r17 = r18
        L_0x01b7:
            r5 = r5 | r17
            goto L_0x01bc
        L_0x01ba:
            r8 = r57
        L_0x01bc:
            r8 = r11 & 16384(0x4000, float:2.2959E-41)
            if (r8 == 0) goto L_0x01c5
            r5 = r5 | 24576(0x6000, float:3.4438E-41)
            r9 = r58
            goto L_0x01d9
        L_0x01c5:
            r17 = 57344(0xe000, float:8.0356E-41)
            r17 = r12 & r17
            r9 = r58
            if (r17 != 0) goto L_0x01d9
            boolean r17 = r10.changed((java.lang.Object) r9)
            if (r17 == 0) goto L_0x01d5
            goto L_0x01d7
        L_0x01d5:
            r20 = r21
        L_0x01d7:
            r5 = r5 | r20
        L_0x01d9:
            r17 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r9 = r1 & r17
            r12 = 306783378(0x12492492, float:6.3469493E-28)
            if (r9 != r12) goto L_0x0212
            r9 = 46811(0xb6db, float:6.5596E-41)
            r9 = r9 & r5
            r12 = 9362(0x2492, float:1.3119E-41)
            if (r9 != r12) goto L_0x0212
            boolean r9 = r10.getSkipping()
            if (r9 != 0) goto L_0x01f2
            goto L_0x0212
        L_0x01f2:
            r10.skipToGroupEnd()
            r3 = r46
            r4 = r47
            r5 = r48
            r6 = r49
            r7 = r50
            r8 = r51
            r9 = r52
            r11 = r54
            r12 = r55
            r13 = r56
            r14 = r57
            r15 = r58
            r1 = r10
            r10 = r53
            goto L_0x074e
        L_0x0212:
            r10.startDefaults()
            r9 = r13 & 1
            if (r9 == 0) goto L_0x026b
            boolean r9 = r10.getDefaultsInvalid()
            if (r9 == 0) goto L_0x0220
            goto L_0x026b
        L_0x0220:
            r10.skipToGroupEnd()
            r0 = r11 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x022b
            r0 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r1 = r1 & r0
        L_0x022b:
            r0 = r11 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x024e
            r0 = r5 & -15
            r14 = r46
            r19 = r47
            r13 = r48
            r21 = r49
            r12 = r50
            r22 = r51
            r23 = r52
            r9 = r53
            r8 = r54
            r24 = r55
            r7 = r56
            r25 = r57
            r26 = r58
            r2 = r0
            goto L_0x031a
        L_0x024e:
            r14 = r46
            r19 = r47
            r13 = r48
            r21 = r49
            r12 = r50
            r22 = r51
            r23 = r52
            r9 = r53
            r8 = r54
            r24 = r55
            r7 = r56
            r25 = r57
            r26 = r58
            r2 = r5
            goto L_0x031a
        L_0x026b:
            if (r4 == 0) goto L_0x0270
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            goto L_0x0272
        L_0x0270:
            r4 = r46
        L_0x0272:
            if (r16 == 0) goto L_0x027b
            androidx.compose.ui.text.TextStyle$Companion r9 = androidx.compose.ui.text.TextStyle.Companion
            androidx.compose.ui.text.TextStyle r9 = r9.getDefault()
            goto L_0x027d
        L_0x027b:
            r9 = r47
        L_0x027d:
            if (r19 == 0) goto L_0x0286
            androidx.compose.ui.text.input.VisualTransformation$Companion r16 = androidx.compose.ui.text.input.VisualTransformation.Companion
            androidx.compose.ui.text.input.VisualTransformation r16 = r16.getNone()
            goto L_0x0288
        L_0x0286:
            r16 = r48
        L_0x0288:
            if (r23 == 0) goto L_0x028d
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$1 r18 = androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$1.INSTANCE
            goto L_0x028f
        L_0x028d:
            r18 = r49
        L_0x028f:
            if (r25 == 0) goto L_0x0294
            r19 = 0
            goto L_0x0296
        L_0x0294:
            r19 = r50
        L_0x0296:
            r12 = r11 & 128(0x80, float:1.794E-43)
            if (r12 == 0) goto L_0x02ad
            androidx.compose.ui.graphics.SolidColor r12 = new androidx.compose.ui.graphics.SolidColor
            androidx.compose.ui.graphics.Color$Companion r21 = androidx.compose.ui.graphics.Color.Companion
            long r13 = r21.m2955getUnspecified0d7_KjU()
            r46 = r4
            r4 = 0
            r12.<init>(r13, r4)
            r4 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r1 = r1 & r4
            goto L_0x02b1
        L_0x02ad:
            r46 = r4
            r12 = r51
        L_0x02b1:
            if (r3 == 0) goto L_0x02b5
            r3 = 1
            goto L_0x02b7
        L_0x02b5:
            r3 = r52
        L_0x02b7:
            if (r0 == 0) goto L_0x02bd
            r0 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x02bf
        L_0x02bd:
            r0 = r53
        L_0x02bf:
            r4 = r11 & 1024(0x400, float:1.435E-42)
            if (r4 == 0) goto L_0x02cc
            androidx.compose.ui.text.input.ImeOptions$Companion r4 = androidx.compose.ui.text.input.ImeOptions.Companion
            androidx.compose.ui.text.input.ImeOptions r4 = r4.getDefault()
            r5 = r5 & -15
            goto L_0x02ce
        L_0x02cc:
            r4 = r54
        L_0x02ce:
            if (r2 == 0) goto L_0x02d7
            androidx.compose.foundation.text.KeyboardActions$Companion r2 = androidx.compose.foundation.text.KeyboardActions.Companion
            androidx.compose.foundation.text.KeyboardActions r2 = r2.getDefault()
            goto L_0x02d9
        L_0x02d7:
            r2 = r55
        L_0x02d9:
            if (r6 == 0) goto L_0x02dd
            r6 = 1
            goto L_0x02df
        L_0x02dd:
            r6 = r56
        L_0x02df:
            if (r7 == 0) goto L_0x02e3
            r7 = 0
            goto L_0x02e5
        L_0x02e3:
            r7 = r57
        L_0x02e5:
            if (r8 == 0) goto L_0x0302
            androidx.compose.foundation.text.ComposableSingletons$CoreTextFieldKt r8 = androidx.compose.foundation.text.ComposableSingletons$CoreTextFieldKt.INSTANCE
            kotlin.jvm.functions.Function3 r8 = r8.m840getLambda1$foundation_release()
            r14 = r46
            r24 = r2
            r23 = r3
            r2 = r5
            r25 = r7
            r26 = r8
            r22 = r12
            r13 = r16
            r21 = r18
            r12 = r19
            r8 = r4
            goto L_0x0316
        L_0x0302:
            r14 = r46
            r26 = r58
            r24 = r2
            r23 = r3
            r8 = r4
            r2 = r5
            r25 = r7
            r22 = r12
            r13 = r16
            r21 = r18
            r12 = r19
        L_0x0316:
            r7 = r6
            r19 = r9
            r9 = r0
        L_0x031a:
            r10.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x032b
            java.lang.String r0 = "androidx.compose.foundation.text.CoreTextField (CoreTextField.kt:176)"
            r3 = 109313709(0x683fead, float:4.9650936E-35)
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r1, r2, r0)
        L_0x032b:
            androidx.compose.ui.focus.FocusRequester r0 = new androidx.compose.ui.focus.FocusRequester
            r0.<init>()
            r1 = -55013261(0xfffffffffcb89073, float:-7.666499E36)
            r10.startReplaceableGroup(r1)
            if (r7 == 0) goto L_0x0347
            if (r25 == 0) goto L_0x033b
            goto L_0x0347
        L_0x033b:
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalTextInputService()
            java.lang.Object r1 = r10.consume(r1)
            androidx.compose.ui.text.input.TextInputService r1 = (androidx.compose.ui.text.input.TextInputService) r1
            r4 = r1
            goto L_0x0348
        L_0x0347:
            r4 = 0
        L_0x0348:
            r10.endReplaceableGroup()
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r1 = r10.consume(r1)
            r18 = r1
            androidx.compose.ui.unit.Density r18 = (androidx.compose.ui.unit.Density) r18
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalFontFamilyResolver()
            java.lang.Object r1 = r10.consume(r1)
            androidx.compose.ui.text.font.FontFamily$Resolver r1 = (androidx.compose.ui.text.font.FontFamily.Resolver) r1
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.foundation.text.selection.TextSelectionColorsKt.getLocalTextSelectionColors()
            java.lang.Object r3 = r10.consume(r3)
            androidx.compose.foundation.text.selection.TextSelectionColors r3 = (androidx.compose.foundation.text.selection.TextSelectionColors) r3
            long r5 = r3.m1073getBackgroundColor0d7_KjU()
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalFocusManager()
            java.lang.Object r3 = r10.consume(r3)
            androidx.compose.ui.focus.FocusManager r3 = (androidx.compose.ui.focus.FocusManager) r3
            r11 = 1
            if (r9 != r11) goto L_0x0386
            if (r23 != 0) goto L_0x0386
            boolean r11 = r8.getSingleLine()
            if (r11 == 0) goto L_0x0386
            r11 = 1
            goto L_0x0387
        L_0x0386:
            r11 = 0
        L_0x0387:
            if (r11 == 0) goto L_0x038c
            androidx.compose.foundation.gestures.Orientation r11 = androidx.compose.foundation.gestures.Orientation.Horizontal
            goto L_0x038e
        L_0x038c:
            androidx.compose.foundation.gestures.Orientation r11 = androidx.compose.foundation.gestures.Orientation.Vertical
        L_0x038e:
            r27 = r9
            r16 = r14
            r14 = 1
            java.lang.Object[] r9 = new java.lang.Object[r14]
            r14 = 0
            r9[r14] = r11
            androidx.compose.foundation.text.TextFieldScrollerPosition$Companion r14 = androidx.compose.foundation.text.TextFieldScrollerPosition.Companion
            androidx.compose.runtime.saveable.Saver r14 = r14.getSaver()
            r29 = 0
            r30 = r2
            r2 = 1157296644(0x44faf204, float:2007.563)
            r10.startReplaceableGroup(r2)
            boolean r2 = r10.changed((java.lang.Object) r11)
            r58 = r7
            java.lang.Object r7 = r10.rememberedValue()
            if (r2 != 0) goto L_0x03bc
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r7 != r2) goto L_0x03c4
        L_0x03bc:
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$scrollerPosition$1$1 r7 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$scrollerPosition$1$1
            r7.<init>(r11)
            r10.updateRememberedValue(r7)
        L_0x03c4:
            r10.endReplaceableGroup()
            r2 = r7
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            r7 = 72
            r11 = 4
            r46 = r9
            r47 = r14
            r48 = r29
            r49 = r2
            r50 = r10
            r51 = r7
            r52 = r11
            java.lang.Object r2 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r46, r47, (java.lang.String) r48, r49, (androidx.compose.runtime.Composer) r50, (int) r51, (int) r52)
            r7 = r2
            androidx.compose.foundation.text.TextFieldScrollerPosition r7 = (androidx.compose.foundation.text.TextFieldScrollerPosition) r7
            r2 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r10.startReplaceableGroup(r2)
            boolean r2 = r10.changed((java.lang.Object) r15)
            boolean r9 = r10.changed((java.lang.Object) r13)
            r2 = r2 | r9
            java.lang.Object r9 = r10.rememberedValue()
            if (r2 != 0) goto L_0x0402
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r9 != r2) goto L_0x0400
            goto L_0x0402
        L_0x0400:
            r14 = r12
            goto L_0x0421
        L_0x0402:
            androidx.compose.ui.text.AnnotatedString r2 = r44.getAnnotatedString()
            androidx.compose.ui.text.input.TransformedText r2 = androidx.compose.foundation.text.ValidatingOffsetMappingKt.filterWithValidation(r13, r2)
            androidx.compose.ui.text.TextRange r9 = r44.m5233getCompositionMzsxiRA()
            r14 = r12
            if (r9 == 0) goto L_0x041d
            long r11 = r9.m5042unboximpl()
            androidx.compose.foundation.text.TextFieldDelegate$Companion r9 = androidx.compose.foundation.text.TextFieldDelegate.Companion
            androidx.compose.ui.text.input.TransformedText r9 = r9.m909applyCompositionDecoration72CqOWE(r11, r2)
            if (r9 != 0) goto L_0x041e
        L_0x041d:
            r9 = r2
        L_0x041e:
            r10.updateRememberedValue(r9)
        L_0x0421:
            r10.endReplaceableGroup()
            r2 = r9
            androidx.compose.ui.text.input.TransformedText r2 = (androidx.compose.ui.text.input.TransformedText) r2
            androidx.compose.ui.text.AnnotatedString r9 = r2.getText()
            androidx.compose.ui.text.input.OffsetMapping r11 = r2.getOffsetMapping()
            r29 = r14
            r12 = 0
            androidx.compose.runtime.RecomposeScope r14 = androidx.compose.runtime.ComposablesKt.getCurrentRecomposeScope(r10, r12)
            r12 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r10.startReplaceableGroup(r12)
            java.lang.Object r12 = r10.rememberedValue()
            androidx.compose.runtime.Composer$Companion r32 = androidx.compose.runtime.Composer.Companion
            r33 = r7
            java.lang.Object r7 = r32.getEmpty()
            if (r12 != r7) goto L_0x0477
            androidx.compose.foundation.text.TextFieldState r12 = new androidx.compose.foundation.text.TextFieldState
            androidx.compose.foundation.text.TextDelegate r7 = new androidx.compose.foundation.text.TextDelegate
            r34 = 0
            r35 = 0
            r36 = 0
            r37 = 148(0x94, float:2.07E-43)
            r38 = 0
            r46 = r7
            r47 = r9
            r48 = r19
            r49 = r34
            r50 = r23
            r51 = r35
            r52 = r18
            r53 = r1
            r54 = r36
            r55 = r37
            r56 = r38
            r46.<init>(r47, r48, r49, r50, r51, r52, r53, r54, r55, r56)
            r12.<init>(r7, r14)
            r10.updateRememberedValue(r12)
        L_0x0477:
            r10.endReplaceableGroup()
            r7 = r12
            androidx.compose.foundation.text.TextFieldState r7 = (androidx.compose.foundation.text.TextFieldState) r7
            androidx.compose.ui.text.AnnotatedString r12 = r44.getAnnotatedString()
            r46 = r7
            r47 = r12
            r48 = r9
            r49 = r19
            r50 = r23
            r51 = r18
            r52 = r1
            r53 = r45
            r54 = r24
            r55 = r3
            r56 = r5
            r46.m928updatefnh65Uc(r47, r48, r49, r50, r51, r52, r53, r54, r55, r56)
            androidx.compose.ui.text.input.EditProcessor r1 = r7.getProcessor()
            androidx.compose.ui.text.input.TextInputSession r3 = r7.getInputSession()
            r1.reset(r15, r3)
            r1 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r10.startReplaceableGroup(r1)
            java.lang.Object r1 = r10.rememberedValue()
            java.lang.Object r3 = r32.getEmpty()
            if (r1 != r3) goto L_0x04c0
            androidx.compose.foundation.text.UndoManager r1 = new androidx.compose.foundation.text.UndoManager
            r3 = 0
            r5 = 0
            r6 = 1
            r1.<init>(r5, r6, r3)
            r10.updateRememberedValue(r1)
        L_0x04c0:
            r10.endReplaceableGroup()
            androidx.compose.foundation.text.UndoManager r1 = (androidx.compose.foundation.text.UndoManager) r1
            r5 = 0
            r3 = 2
            r9 = 0
            r46 = r1
            r47 = r44
            r48 = r5
            r50 = r3
            r51 = r9
            androidx.compose.foundation.text.UndoManager.snapshotIfNeeded$default(r46, r47, r48, r50, r51)
            r3 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r10.startReplaceableGroup(r3)
            java.lang.Object r3 = r10.rememberedValue()
            java.lang.Object r5 = r32.getEmpty()
            if (r3 != r5) goto L_0x04ee
            androidx.compose.foundation.text.selection.TextFieldSelectionManager r3 = new androidx.compose.foundation.text.selection.TextFieldSelectionManager
            r3.<init>(r1)
            r10.updateRememberedValue(r3)
        L_0x04ee:
            r10.endReplaceableGroup()
            r14 = r3
            androidx.compose.foundation.text.selection.TextFieldSelectionManager r14 = (androidx.compose.foundation.text.selection.TextFieldSelectionManager) r14
            r14.setOffsetMapping$foundation_release(r11)
            r14.setVisualTransformation$foundation_release(r13)
            kotlin.jvm.functions.Function1 r3 = r7.getOnValueChange()
            r14.setOnValueChange$foundation_release(r3)
            r14.setState$foundation_release(r7)
            r14.setValue$foundation_release(r15)
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalClipboardManager()
            java.lang.Object r3 = r10.consume(r3)
            androidx.compose.ui.platform.ClipboardManager r3 = (androidx.compose.ui.platform.ClipboardManager) r3
            r14.setClipboardManager$foundation_release(r3)
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalTextToolbar()
            java.lang.Object r3 = r10.consume(r3)
            androidx.compose.ui.platform.TextToolbar r3 = (androidx.compose.ui.platform.TextToolbar) r3
            r14.setTextToolbar(r3)
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalHapticFeedback()
            java.lang.Object r3 = r10.consume(r3)
            androidx.compose.ui.hapticfeedback.HapticFeedback r3 = (androidx.compose.ui.hapticfeedback.HapticFeedback) r3
            r14.setHapticFeedBack(r3)
            r14.setFocusRequester(r0)
            r3 = r25 ^ 1
            r14.setEditable(r3)
            r3 = 773894976(0x2e20b340, float:3.6538994E-11)
            r10.startReplaceableGroup(r3)
            r3 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r10.startReplaceableGroup(r3)
            java.lang.Object r3 = r10.rememberedValue()
            java.lang.Object r5 = r32.getEmpty()
            if (r3 != r5) goto L_0x055b
            kotlin.coroutines.EmptyCoroutineContext r3 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            kotlinx.coroutines.CoroutineScope r3 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r3, r10)
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r5 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r5.<init>(r3)
            r10.updateRememberedValue(r5)
            r3 = r5
        L_0x055b:
            r10.endReplaceableGroup()
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r3 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r3
            kotlinx.coroutines.CoroutineScope r3 = r3.getCoroutineScope()
            r10.endReplaceableGroup()
            r5 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r10.startReplaceableGroup(r5)
            java.lang.Object r5 = r10.rememberedValue()
            java.lang.Object r6 = r32.getEmpty()
            if (r5 != r6) goto L_0x057e
            androidx.compose.foundation.relocation.BringIntoViewRequester r5 = androidx.compose.foundation.relocation.BringIntoViewRequesterKt.BringIntoViewRequester()
            r10.updateRememberedValue(r5)
        L_0x057e:
            r10.endReplaceableGroup()
            r31 = r5
            androidx.compose.foundation.relocation.BringIntoViewRequester r31 = (androidx.compose.foundation.relocation.BringIntoViewRequester) r31
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$focusModifier$1 r6 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$focusModifier$1
            r46 = r6
            r47 = r7
            r48 = r4
            r49 = r44
            r50 = r8
            r51 = r14
            r52 = r3
            r53 = r31
            r54 = r11
            r46.<init>(r47, r48, r49, r50, r51, r52, r53, r54)
            r9 = r58
            r12 = r29
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.text.TextFieldGestureModifiersKt.textFieldFocusModifier(r5, r9, r0, r12, r6)
            r6 = -55008775(0xfffffffffcb8a1f9, float:-7.6693425E36)
            r10.startReplaceableGroup(r6)
            r6 = 8
            if (r9 == 0) goto L_0x05bd
            if (r25 != 0) goto L_0x05bd
            r57 = r3
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$2 r3 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$2
            r3.<init>(r7)
            androidx.compose.runtime.EffectsKt.DisposableEffect((java.lang.Object) r7, (kotlin.jvm.functions.Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult>) r3, (androidx.compose.runtime.Composer) r10, (int) r6)
            goto L_0x05bf
        L_0x05bd:
            r57 = r3
        L_0x05bf:
            r10.endReplaceableGroup()
            boolean r3 = androidx.compose.foundation.text.TouchMode_androidKt.isInTouchMode()
            if (r3 == 0) goto L_0x05f1
            androidx.compose.foundation.text.TextDragObserver r3 = r14.getTouchSelectionObserver$foundation_release()
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.text.TextFieldGestureModifiersKt.longPressDragGestureFilter(r5, r3, r9)
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$1 r6 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$1
            r46 = r6
            r47 = r7
            r48 = r0
            r49 = r25
            r50 = r14
            r51 = r11
            r46.<init>(r47, r48, r49, r50, r51)
            androidx.compose.ui.Modifier r6 = androidx.compose.foundation.text.TextFieldPressGestureFilterKt.tapPressTextFieldModifier(r5, r12, r9, r6)
            androidx.compose.ui.Modifier r3 = r6.then(r3)
            r59 = r1
            r17 = r4
            r29 = r12
            r4 = 0
            goto L_0x060a
        L_0x05f1:
            androidx.compose.foundation.text.selection.MouseSelectionObserver r3 = r14.getMouseSelectionObserver$foundation_release()
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.text.TextFieldGestureModifiersKt.mouseDragGestureDetector(r5, r3, r9)
            androidx.compose.ui.input.pointer.PointerIcon r6 = androidx.compose.foundation.text.TextPointerIcon_androidKt.getTextPointerIcon()
            r59 = r1
            r17 = r4
            r29 = r12
            r1 = 0
            r4 = 0
            r12 = 2
            androidx.compose.ui.Modifier r3 = androidx.compose.ui.input.pointer.PointerIconKt.pointerHoverIcon$default(r3, r6, r4, r12, r1)
        L_0x060a:
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$drawModifier$1 r1 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$drawModifier$1
            r1.<init>(r7, r15, r11)
            androidx.compose.ui.Modifier r12 = androidx.compose.ui.draw.DrawModifierKt.drawBehind(r5, r1)
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$onPositionedModifier$1 r1 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$onPositionedModifier$1
            r1.<init>(r7, r9, r14)
            androidx.compose.ui.Modifier r28 = androidx.compose.ui.layout.OnGloballyPositionedModifierKt.onGloballyPositioned(r5, r1)
            boolean r1 = r13 instanceof androidx.compose.ui.text.input.PasswordVisualTransformation
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1 r6 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1
            r46 = r6
            r47 = r8
            r48 = r2
            r49 = r44
            r50 = r9
            r51 = r1
            r52 = r25
            r53 = r7
            r54 = r11
            r55 = r14
            r56 = r0
            r46.<init>(r47, r48, r49, r50, r51, r52, r53, r54, r55, r56)
            r0 = 1
            androidx.compose.ui.Modifier r1 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics(r5, r0, r6)
            if (r9 == 0) goto L_0x0644
            if (r25 != 0) goto L_0x0644
            r0 = 1
            goto L_0x0645
        L_0x0644:
            r0 = r4
        L_0x0645:
            r46 = r5
            r47 = r7
            r48 = r44
            r49 = r11
            r50 = r22
            r51 = r0
            androidx.compose.ui.Modifier r32 = androidx.compose.foundation.text.TextFieldCursorKt.cursor(r46, r47, r48, r49, r50, r51)
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3 r0 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3
            r0.<init>(r14)
            r2 = 8
            androidx.compose.runtime.EffectsKt.DisposableEffect((java.lang.Object) r14, (kotlin.jvm.functions.Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult>) r0, (androidx.compose.runtime.Composer) r10, (int) r2)
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4 r0 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4
            r2 = r17
            r0.<init>(r2, r7, r15, r8)
            r2 = r30 & 14
            androidx.compose.runtime.EffectsKt.DisposableEffect((java.lang.Object) r8, (kotlin.jvm.functions.Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult>) r0, (androidx.compose.runtime.Composer) r10, (int) r2)
            kotlin.jvm.functions.Function1 r0 = r7.getOnValueChange()
            r2 = r25 ^ 1
            r6 = r27
            r15 = 1
            if (r6 != r15) goto L_0x0679
            r17 = r15
            goto L_0x067b
        L_0x0679:
            r17 = r4
        L_0x067b:
            r46 = r5
            r47 = r7
            r48 = r14
            r49 = r44
            r50 = r0
            r51 = r2
            r52 = r17
            r53 = r11
            r54 = r59
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.text.TextFieldKeyInputKt.textFieldKeyInput(r46, r47, r48, r49, r50, r51, r52, r53, r54)
            r2 = r57
            r11 = r16
            androidx.compose.ui.Modifier r2 = r11.then(r2)
            androidx.compose.ui.Modifier r2 = previewKeyEventToDeselectOnBack(r2, r7, r14)
            androidx.compose.ui.Modifier r0 = r2.then(r0)
            r15 = r29
            r2 = r33
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.text.TextFieldScrollKt.textFieldScrollable(r0, r2, r15, r9)
            androidx.compose.ui.Modifier r0 = r0.then(r3)
            androidx.compose.ui.Modifier r0 = r0.then(r1)
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$decorationBoxModifier$1 r1 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$decorationBoxModifier$1
            r1.<init>(r7)
            androidx.compose.ui.Modifier r3 = androidx.compose.ui.layout.OnGloballyPositionedModifierKt.onGloballyPositioned(r0, r1)
            if (r9 == 0) goto L_0x06cb
            boolean r0 = r7.getHasFocus()
            if (r0 == 0) goto L_0x06cb
            boolean r0 = androidx.compose.foundation.text.TouchMode_androidKt.isInTouchMode()
            if (r0 == 0) goto L_0x06cb
            r16 = 1
            goto L_0x06cd
        L_0x06cb:
            r16 = r4
        L_0x06cd:
            if (r16 == 0) goto L_0x06d6
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt.textFieldMagnifier(r5, r14)
            r17 = r0
            goto L_0x06d8
        L_0x06d6:
            r17 = r5
        L_0x06d8:
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5 r5 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5
            r0 = r5
            r1 = r26
            r27 = r2
            r2 = r30
            r4 = r3
            r3 = r7
            r7 = r4
            r4 = r6
            r39 = r5
            r5 = r19
            r29 = r6
            r6 = r27
            r27 = r9
            r9 = r7
            r7 = r44
            r30 = r8
            r8 = r13
            r40 = r9
            r9 = r32
            r41 = r10
            r10 = r12
            r32 = r11
            r11 = r28
            r20 = r15
            r15 = 1
            r12 = r17
            r28 = r13
            r13 = r31
            r46 = r14
            r31 = r32
            r15 = r16
            r16 = r25
            r17 = r21
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            r0 = -1885146845(0xffffffff8fa2f123, float:-1.6067316E-29)
            r2 = r39
            r1 = r41
            r3 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r1, r0, r3, r2)
            r2 = 448(0x1c0, float:6.28E-43)
            r3 = r46
            r4 = r40
            CoreTextFieldRootBox(r4, r3, r0, r1, r2)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0734
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0734:
            r4 = r19
            r7 = r20
            r6 = r21
            r8 = r22
            r9 = r23
            r12 = r24
            r14 = r25
            r15 = r26
            r13 = r27
            r5 = r28
            r10 = r29
            r11 = r30
            r3 = r31
        L_0x074e:
            androidx.compose.runtime.ScopeUpdateScope r2 = r1.endRestartGroup()
            if (r2 != 0) goto L_0x0755
            goto L_0x0770
        L_0x0755:
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$6 r1 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$6
            r0 = r1
            r42 = r1
            r1 = r44
            r43 = r2
            r2 = r45
            r16 = r60
            r17 = r61
            r18 = r62
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            r1 = r42
            r0 = r43
            r0.updateScope(r1)
        L_0x0770:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField(androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.input.VisualTransformation, kotlin.jvm.functions.Function1, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Brush, boolean, int, androidx.compose.ui.text.input.ImeOptions, androidx.compose.foundation.text.KeyboardActions, boolean, boolean, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* access modifiers changed from: private */
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    @Composable
    public static final void CoreTextFieldRootBox(Modifier modifier, TextFieldSelectionManager textFieldSelectionManager, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i11) {
        Composer startRestartGroup = composer.startRestartGroup(-20551815);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-20551815, i11, -1, "androidx.compose.foundation.text.CoreTextFieldRootBox (CoreTextField.kt:637)");
        }
        int i12 = (i11 & 14) | RendererCapabilities.MODE_SUPPORT_MASK;
        startRestartGroup.startReplaceableGroup(733328855);
        int i13 = i12 >> 3;
        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), true, startRestartGroup, (i13 & 112) | (i13 & 14));
        startRestartGroup.startReplaceableGroup(-1323940314);
        Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion = ComposeUiNode.Companion;
        Function0<ComposeUiNode> constructor = companion.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier);
        int i14 = ((((i12 << 3) & 112) << 9) & 7168) | 6;
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
            startRestartGroup.createNode(constructor);
        } else {
            startRestartGroup.useNode();
        }
        startRestartGroup.disableReusing();
        Composer r72 = Updater.m2536constructorimpl(startRestartGroup);
        Updater.m2543setimpl(r72, rememberBoxMeasurePolicy, companion.getSetMeasurePolicy());
        Updater.m2543setimpl(r72, density, companion.getSetDensity());
        Updater.m2543setimpl(r72, layoutDirection, companion.getSetLayoutDirection());
        Updater.m2543setimpl(r72, viewConfiguration, companion.getSetViewConfiguration());
        startRestartGroup.enableReusing();
        materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, Integer.valueOf((i14 >> 3) & 112));
        startRestartGroup.startReplaceableGroup(2058660585);
        startRestartGroup.startReplaceableGroup(-2137368960);
        if (((i14 >> 9) & 14 & 11) != 2 || !startRestartGroup.getSkipping()) {
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            startRestartGroup.startReplaceableGroup(1524757375);
            if (((((i12 >> 6) & 112) | 6) & 81) != 16 || !startRestartGroup.getSkipping()) {
                ContextMenu_androidKt.ContextMenuArea(textFieldSelectionManager, function2, startRestartGroup, ((i11 >> 3) & 112) | 8);
            } else {
                startRestartGroup.skipToGroupEnd();
            }
            startRestartGroup.endReplaceableGroup();
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new CoreTextFieldKt$CoreTextFieldRootBox$2(modifier, textFieldSelectionManager, function2, i11));
        }
    }

    /* access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void SelectionToolbarAndHandles(TextFieldSelectionManager textFieldSelectionManager, boolean z11, Composer composer, int i11) {
        boolean z12;
        TextLayoutResultProxy layoutResult;
        TextLayoutResult value;
        boolean z13;
        Composer startRestartGroup = composer.startRestartGroup(626339208);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(626339208, i11, -1, "androidx.compose.foundation.text.SelectionToolbarAndHandles (CoreTextField.kt:960)");
        }
        if (z11) {
            TextFieldState state$foundation_release = textFieldSelectionManager.getState$foundation_release();
            TextLayoutResult textLayoutResult = null;
            boolean z14 = true;
            if (!(state$foundation_release == null || (layoutResult = state$foundation_release.getLayoutResult()) == null || (value = layoutResult.getValue()) == null)) {
                TextFieldState state$foundation_release2 = textFieldSelectionManager.getState$foundation_release();
                if (state$foundation_release2 != null) {
                    z13 = state$foundation_release2.isLayoutResultStale();
                } else {
                    z13 = true;
                }
                if (!z13) {
                    textLayoutResult = value;
                }
            }
            if (textLayoutResult != null) {
                if (!TextRange.m5032getCollapsedimpl(textFieldSelectionManager.getValue$foundation_release().m5234getSelectiond9O1mEE())) {
                    int originalToTransformed = textFieldSelectionManager.getOffsetMapping$foundation_release().originalToTransformed(TextRange.m5038getStartimpl(textFieldSelectionManager.getValue$foundation_release().m5234getSelectiond9O1mEE()));
                    int originalToTransformed2 = textFieldSelectionManager.getOffsetMapping$foundation_release().originalToTransformed(TextRange.m5033getEndimpl(textFieldSelectionManager.getValue$foundation_release().m5234getSelectiond9O1mEE()));
                    ResolvedTextDirection bidiRunDirection = textLayoutResult.getBidiRunDirection(originalToTransformed);
                    ResolvedTextDirection bidiRunDirection2 = textLayoutResult.getBidiRunDirection(Math.max(originalToTransformed2 - 1, 0));
                    startRestartGroup.startReplaceableGroup(-498393098);
                    TextFieldState state$foundation_release3 = textFieldSelectionManager.getState$foundation_release();
                    if (state$foundation_release3 == null || !state$foundation_release3.getShowSelectionHandleStart()) {
                        z12 = false;
                    } else {
                        z12 = true;
                    }
                    if (z12) {
                        TextFieldSelectionManagerKt.TextFieldSelectionHandle(true, bidiRunDirection, textFieldSelectionManager, startRestartGroup, 518);
                    }
                    startRestartGroup.endReplaceableGroup();
                    TextFieldState state$foundation_release4 = textFieldSelectionManager.getState$foundation_release();
                    if (state$foundation_release4 == null || !state$foundation_release4.getShowSelectionHandleEnd()) {
                        z14 = false;
                    }
                    if (z14) {
                        TextFieldSelectionManagerKt.TextFieldSelectionHandle(false, bidiRunDirection2, textFieldSelectionManager, startRestartGroup, 518);
                    }
                }
                TextFieldState state$foundation_release5 = textFieldSelectionManager.getState$foundation_release();
                if (state$foundation_release5 != null) {
                    if (textFieldSelectionManager.isTextChanged$foundation_release()) {
                        state$foundation_release5.setShowFloatingToolbar(false);
                    }
                    if (state$foundation_release5.getHasFocus()) {
                        if (state$foundation_release5.getShowFloatingToolbar()) {
                            textFieldSelectionManager.showSelectionToolbar$foundation_release();
                        } else {
                            textFieldSelectionManager.hideSelectionToolbar$foundation_release();
                        }
                    }
                }
            }
        } else {
            textFieldSelectionManager.hideSelectionToolbar$foundation_release();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new CoreTextFieldKt$SelectionToolbarAndHandles$2(textFieldSelectionManager, z11, i11));
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void TextFieldCursorHandle(@NotNull TextFieldSelectionManager textFieldSelectionManager, @Nullable Composer composer, int i11) {
        boolean z11;
        Intrinsics.checkNotNullParameter(textFieldSelectionManager, "manager");
        Composer startRestartGroup = composer.startRestartGroup(-1436003720);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1436003720, i11, -1, "androidx.compose.foundation.text.TextFieldCursorHandle (CoreTextField.kt:1003)");
        }
        TextFieldState state$foundation_release = textFieldSelectionManager.getState$foundation_release();
        if (state$foundation_release == null || !state$foundation_release.getShowCursorHandle()) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            startRestartGroup.startReplaceableGroup(1157296644);
            boolean changed = startRestartGroup.changed((Object) textFieldSelectionManager);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = textFieldSelectionManager.cursorDragObserver$foundation_release();
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            TextDragObserver textDragObserver = (TextDragObserver) rememberedValue;
            long r52 = textFieldSelectionManager.m1050getCursorPositiontuRUvjQ$foundation_release((Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity()));
            Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput((Modifier) Modifier.Companion, (Object) textDragObserver, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new CoreTextFieldKt$TextFieldCursorHandle$1(textDragObserver, (Continuation<? super CoreTextFieldKt$TextFieldCursorHandle$1>) null));
            Offset r42 = Offset.m2665boximpl(r52);
            startRestartGroup.startReplaceableGroup(1157296644);
            boolean changed2 = startRestartGroup.changed((Object) r42);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new CoreTextFieldKt$TextFieldCursorHandle$2$1(r52);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceableGroup();
            AndroidCursorHandle_androidKt.m824CursorHandleULxng0E(r52, SemanticsModifierKt.semantics$default(pointerInput, false, (Function1) rememberedValue2, 1, (Object) null), (Function2<? super Composer, ? super Integer, Unit>) null, startRestartGroup, RendererCapabilities.MODE_SUPPORT_MASK);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new CoreTextFieldKt$TextFieldCursorHandle$3(textFieldSelectionManager, i11));
        }
    }

    @Nullable
    public static final Object bringSelectionEndIntoView(@NotNull BringIntoViewRequester bringIntoViewRequester, @NotNull TextFieldValue textFieldValue, @NotNull TextDelegate textDelegate, @NotNull TextLayoutResult textLayoutResult, @NotNull OffsetMapping offsetMapping, @NotNull Continuation<? super Unit> continuation) {
        Rect rect;
        int originalToTransformed = offsetMapping.originalToTransformed(TextRange.m5035getMaximpl(textFieldValue.m5234getSelectiond9O1mEE()));
        if (originalToTransformed < textLayoutResult.getLayoutInput().getText().length()) {
            rect = textLayoutResult.getBoundingBox(originalToTransformed);
        } else if (originalToTransformed != 0) {
            rect = textLayoutResult.getBoundingBox(originalToTransformed - 1);
        } else {
            rect = new Rect(0.0f, 0.0f, 1.0f, (float) IntSize.m5637getHeightimpl(TextFieldDelegateKt.computeSizeForDefaultText$default(textDelegate.getStyle(), textDelegate.getDensity(), textDelegate.getFontFamilyResolver(), (String) null, 0, 24, (Object) null)));
        }
        Object bringIntoView = bringIntoViewRequester.bringIntoView(rect, continuation);
        if (bringIntoView == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return bringIntoView;
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void notifyTextInputServiceOnFocusChange(TextInputService textInputService, TextFieldState textFieldState, TextFieldValue textFieldValue, ImeOptions imeOptions) {
        if (textFieldState.getHasFocus()) {
            textFieldState.setInputSession(TextFieldDelegate.Companion.onFocus$foundation_release(textInputService, textFieldValue, textFieldState.getProcessor(), imeOptions, textFieldState.getOnValueChange(), textFieldState.getOnImeActionPerformed()));
            return;
        }
        onBlur(textFieldState);
    }

    /* access modifiers changed from: private */
    public static final void onBlur(TextFieldState textFieldState) {
        TextInputSession inputSession = textFieldState.getInputSession();
        if (inputSession != null) {
            TextFieldDelegate.Companion.onBlur$foundation_release(inputSession, textFieldState.getProcessor(), textFieldState.getOnValueChange());
        }
        textFieldState.setInputSession((TextInputSession) null);
    }

    private static final Modifier previewKeyEventToDeselectOnBack(Modifier modifier, TextFieldState textFieldState, TextFieldSelectionManager textFieldSelectionManager) {
        return KeyInputModifierKt.onPreviewKeyEvent(modifier, new CoreTextFieldKt$previewKeyEventToDeselectOnBack$1(textFieldState, textFieldSelectionManager));
    }

    /* access modifiers changed from: private */
    public static final void tapToFocus(TextFieldState textFieldState, FocusRequester focusRequester, boolean z11) {
        TextInputSession inputSession;
        if (!textFieldState.getHasFocus()) {
            focusRequester.requestFocus();
        } else if (z11 && (inputSession = textFieldState.getInputSession()) != null) {
            inputSession.showSoftwareKeyboard();
        }
    }
}
