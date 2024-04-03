package androidx.compose.material;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000¤\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u001a\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\b\b\u0002\u0010\u001b\u001a\u00020\u00112\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u00112\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*H\u0007¢\u0006\u0002\u0010+\u001a\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\b\b\u0002\u0010\u001b\u001a\u00020\u00112\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u00112\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*H\u0007¢\u0006\u0002\u0010,\u001aÄ\u0001\u0010-\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0011\u0010.\u001a\r\u0012\u0004\u0012\u00020\t0\u0016¢\u0006\u0002\b\u00172\u0019\u0010\u0018\u001a\u0015\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\r¢\u0006\u0002\b\u00172\u0013\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0013\u0010/\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0013\u00100\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0006\u0010\"\u001a\u00020\u00112\u0006\u00101\u001a\u0002022\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\t0\r2\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\t0\u0016¢\u0006\u0002\b\u00172\u0006\u00106\u001a\u000207H\u0001ø\u0001\u0000¢\u0006\u0002\u00108\u001aU\u00109\u001a\u00020$2\u0006\u0010:\u001a\u00020$2\u0006\u0010;\u001a\u00020$2\u0006\u0010<\u001a\u00020$2\u0006\u0010=\u001a\u00020$2\u0006\u0010>\u001a\u00020$2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u0002022\u0006\u00106\u001a\u000207H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bB\u0010C\u001aE\u0010D\u001a\u00020$2\u0006\u0010E\u001a\u00020$2\u0006\u0010F\u001a\u00020$2\u0006\u0010G\u001a\u00020$2\u0006\u0010H\u001a\u00020$2\u0006\u0010I\u001a\u00020$2\u0006\u0010?\u001a\u00020@H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bJ\u0010K\u001a)\u0010L\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010M\u001a\u0002042\u0006\u00106\u001a\u000207H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bN\u0010O\u001a|\u0010P\u001a\u00020\t*\u00020Q2\u0006\u0010R\u001a\u00020$2\u0006\u0010S\u001a\u00020$2\b\u0010T\u001a\u0004\u0018\u00010U2\b\u0010V\u001a\u0004\u0018\u00010U2\u0006\u0010W\u001a\u00020U2\b\u0010X\u001a\u0004\u0018\u00010U2\b\u0010Y\u001a\u0004\u0018\u00010U2\u0006\u0010Z\u001a\u00020U2\u0006\u00101\u001a\u0002022\u0006\u0010\"\u001a\u00020\u00112\u0006\u0010A\u001a\u0002022\u0006\u0010[\u001a\u00020\\2\u0006\u00106\u001a\u000207H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0013\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0019\u0010\u0005\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0006\u0010\u0007\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006]"}, d2 = {"BorderId", "", "OutlinedTextFieldInnerPadding", "Landroidx/compose/ui/unit/Dp;", "F", "OutlinedTextFieldTopPadding", "getOutlinedTextFieldTopPadding", "()F", "OutlinedTextField", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "label", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "placeholder", "leadingIcon", "trailingIcon", "isError", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "maxLines", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material/TextFieldColors;", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "OutlinedTextFieldLayout", "textField", "leading", "trailing", "animationProgress", "", "onLabelMeasured", "Landroidx/compose/ui/geometry/Size;", "border", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZFLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;II)V", "calculateHeight", "leadingPlaceableHeight", "trailingPlaceableHeight", "textFieldPlaceableHeight", "labelPlaceableHeight", "placeholderPlaceableHeight", "constraints", "Landroidx/compose/ui/unit/Constraints;", "density", "calculateHeight-zUg2_y0", "(IIIIIJFLandroidx/compose/foundation/layout/PaddingValues;)I", "calculateWidth", "leadingPlaceableWidth", "trailingPlaceableWidth", "textFieldPlaceableWidth", "labelPlaceableWidth", "placeholderPlaceableWidth", "calculateWidth-VsPV1Ek", "(IIIIIJ)I", "outlineCutout", "labelSize", "outlineCutout-12SF9DM", "(Landroidx/compose/ui/Modifier;JLandroidx/compose/foundation/layout/PaddingValues;)Landroidx/compose/ui/Modifier;", "place", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "height", "width", "leadingPlaceable", "Landroidx/compose/ui/layout/Placeable;", "trailingPlaceable", "textFieldPlaceable", "labelPlaceable", "placeholderPlaceable", "borderPlaceable", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class OutlinedTextFieldKt {
    @NotNull
    public static final String BorderId = "border";
    /* access modifiers changed from: private */
    public static final float OutlinedTextFieldInnerPadding = Dp.m5478constructorimpl((float) 4);
    private static final float OutlinedTextFieldTopPadding = Dp.m5478constructorimpl((float) 8);

    /* JADX WARNING: Code restructure failed: missing block: B:140:0x01ae, code lost:
        if (r7.changed((java.lang.Object) r83) != false) goto L_0x01b5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x014d  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0152  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x016c  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0171  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0188  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x019e  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x01a4  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x01b8  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x01c0  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x01c5  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x01dd  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x01e4  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x01ff  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x0206  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x021f  */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x0233  */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x023b  */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x0251  */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x026d  */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x0296  */
    /* JADX WARNING: Removed duplicated region for block: B:295:0x05ac  */
    /* JADX WARNING: Removed duplicated region for block: B:297:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0134  */
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void OutlinedTextField(@org.jetbrains.annotations.NotNull java.lang.String r70, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r71, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r72, boolean r73, boolean r74, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.TextStyle r75, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r76, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r77, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r78, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r79, boolean r80, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.input.VisualTransformation r81, @org.jetbrains.annotations.Nullable androidx.compose.foundation.text.KeyboardOptions r82, @org.jetbrains.annotations.Nullable androidx.compose.foundation.text.KeyboardActions r83, boolean r84, int r85, @org.jetbrains.annotations.Nullable androidx.compose.foundation.interaction.MutableInteractionSource r86, @org.jetbrains.annotations.Nullable androidx.compose.ui.graphics.Shape r87, @org.jetbrains.annotations.Nullable androidx.compose.material.TextFieldColors r88, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r89, int r90, int r91, int r92) {
        /*
            r15 = r70
            r12 = r71
            r10 = r90
            r9 = r91
            r8 = r92
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "onValueChange"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r0 = -2099955827(0xffffffff82d5378d, float:-3.1329422E-37)
            r1 = r89
            androidx.compose.runtime.Composer r7 = r1.startRestartGroup(r0)
            r0 = r8 & 1
            if (r0 == 0) goto L_0x0024
            r0 = r10 | 6
            goto L_0x0034
        L_0x0024:
            r0 = r10 & 14
            if (r0 != 0) goto L_0x0033
            boolean r0 = r7.changed((java.lang.Object) r15)
            if (r0 == 0) goto L_0x0030
            r0 = 4
            goto L_0x0031
        L_0x0030:
            r0 = 2
        L_0x0031:
            r0 = r0 | r10
            goto L_0x0034
        L_0x0033:
            r0 = r10
        L_0x0034:
            r3 = r8 & 2
            if (r3 == 0) goto L_0x003b
            r0 = r0 | 48
            goto L_0x004b
        L_0x003b:
            r3 = r10 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x004b
            boolean r3 = r7.changed((java.lang.Object) r12)
            if (r3 == 0) goto L_0x0048
            r3 = 32
            goto L_0x004a
        L_0x0048:
            r3 = 16
        L_0x004a:
            r0 = r0 | r3
        L_0x004b:
            r3 = r8 & 4
            if (r3 == 0) goto L_0x0052
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x0065
        L_0x0052:
            r13 = r10 & 896(0x380, float:1.256E-42)
            if (r13 != 0) goto L_0x0065
            r13 = r72
            boolean r14 = r7.changed((java.lang.Object) r13)
            if (r14 == 0) goto L_0x0061
            r14 = 256(0x100, float:3.59E-43)
            goto L_0x0063
        L_0x0061:
            r14 = 128(0x80, float:1.794E-43)
        L_0x0063:
            r0 = r0 | r14
            goto L_0x0067
        L_0x0065:
            r13 = r72
        L_0x0067:
            r14 = r8 & 8
            r16 = 2048(0x800, float:2.87E-42)
            r17 = 1024(0x400, float:1.435E-42)
            if (r14 == 0) goto L_0x0072
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x0086
        L_0x0072:
            r1 = r10 & 7168(0x1c00, float:1.0045E-41)
            if (r1 != 0) goto L_0x0086
            r1 = r73
            boolean r18 = r7.changed((boolean) r1)
            if (r18 == 0) goto L_0x0081
            r18 = r16
            goto L_0x0083
        L_0x0081:
            r18 = r17
        L_0x0083:
            r0 = r0 | r18
            goto L_0x0088
        L_0x0086:
            r1 = r73
        L_0x0088:
            r18 = r8 & 16
            r19 = 16384(0x4000, float:2.2959E-41)
            r64 = 57344(0xe000, float:8.0356E-41)
            r20 = 8192(0x2000, float:1.14794E-41)
            if (r18 == 0) goto L_0x0098
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            r2 = r74
            goto L_0x00ab
        L_0x0098:
            r21 = r10 & r64
            r2 = r74
            if (r21 != 0) goto L_0x00ab
            boolean r22 = r7.changed((boolean) r2)
            if (r22 == 0) goto L_0x00a7
            r22 = r19
            goto L_0x00a9
        L_0x00a7:
            r22 = r20
        L_0x00a9:
            r0 = r0 | r22
        L_0x00ab:
            r22 = 458752(0x70000, float:6.42848E-40)
            r22 = r10 & r22
            r23 = 131072(0x20000, float:1.83671E-40)
            if (r22 != 0) goto L_0x00c7
            r22 = r8 & 32
            r4 = r75
            if (r22 != 0) goto L_0x00c2
            boolean r24 = r7.changed((java.lang.Object) r4)
            if (r24 == 0) goto L_0x00c2
            r24 = r23
            goto L_0x00c4
        L_0x00c2:
            r24 = 65536(0x10000, float:9.18355E-41)
        L_0x00c4:
            r0 = r0 | r24
            goto L_0x00c9
        L_0x00c7:
            r4 = r75
        L_0x00c9:
            r24 = r8 & 64
            r65 = 3670016(0x380000, float:5.142788E-39)
            if (r24 == 0) goto L_0x00d6
            r25 = 1572864(0x180000, float:2.204052E-39)
            r0 = r0 | r25
            r5 = r76
            goto L_0x00e9
        L_0x00d6:
            r25 = r10 & r65
            r5 = r76
            if (r25 != 0) goto L_0x00e9
            boolean r26 = r7.changed((java.lang.Object) r5)
            if (r26 == 0) goto L_0x00e5
            r26 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e7
        L_0x00e5:
            r26 = 524288(0x80000, float:7.34684E-40)
        L_0x00e7:
            r0 = r0 | r26
        L_0x00e9:
            r6 = r8 & 128(0x80, float:1.794E-43)
            if (r6 == 0) goto L_0x00f4
            r27 = 12582912(0xc00000, float:1.7632415E-38)
            r0 = r0 | r27
            r11 = r77
            goto L_0x0109
        L_0x00f4:
            r27 = 29360128(0x1c00000, float:7.052966E-38)
            r27 = r10 & r27
            r11 = r77
            if (r27 != 0) goto L_0x0109
            boolean r28 = r7.changed((java.lang.Object) r11)
            if (r28 == 0) goto L_0x0105
            r28 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0107
        L_0x0105:
            r28 = 4194304(0x400000, float:5.877472E-39)
        L_0x0107:
            r0 = r0 | r28
        L_0x0109:
            r1 = r8 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0114
            r28 = 100663296(0x6000000, float:2.4074124E-35)
            r0 = r0 | r28
            r2 = r78
            goto L_0x0129
        L_0x0114:
            r28 = 234881024(0xe000000, float:1.5777218E-30)
            r28 = r10 & r28
            r2 = r78
            if (r28 != 0) goto L_0x0129
            boolean r28 = r7.changed((java.lang.Object) r2)
            if (r28 == 0) goto L_0x0125
            r28 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0127
        L_0x0125:
            r28 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0127:
            r0 = r0 | r28
        L_0x0129:
            r2 = r8 & 512(0x200, float:7.175E-43)
            if (r2 == 0) goto L_0x0134
            r28 = 805306368(0x30000000, float:4.656613E-10)
            r0 = r0 | r28
            r4 = r79
            goto L_0x0149
        L_0x0134:
            r28 = 1879048192(0x70000000, float:1.58456325E29)
            r28 = r10 & r28
            r4 = r79
            if (r28 != 0) goto L_0x0149
            boolean r28 = r7.changed((java.lang.Object) r4)
            if (r28 == 0) goto L_0x0145
            r28 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0147
        L_0x0145:
            r28 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0147:
            r0 = r0 | r28
        L_0x0149:
            r4 = r8 & 1024(0x400, float:1.435E-42)
            if (r4 == 0) goto L_0x0152
            r21 = r9 | 6
            r5 = r80
            goto L_0x0168
        L_0x0152:
            r28 = r9 & 14
            r5 = r80
            if (r28 != 0) goto L_0x0166
            boolean r28 = r7.changed((boolean) r5)
            if (r28 == 0) goto L_0x0161
            r21 = 4
            goto L_0x0163
        L_0x0161:
            r21 = 2
        L_0x0163:
            r21 = r9 | r21
            goto L_0x0168
        L_0x0166:
            r21 = r9
        L_0x0168:
            r5 = r8 & 2048(0x800, float:2.87E-42)
            if (r5 == 0) goto L_0x0171
            r21 = r21 | 48
            r11 = r81
            goto L_0x0184
        L_0x0171:
            r28 = r9 & 112(0x70, float:1.57E-43)
            r11 = r81
            if (r28 != 0) goto L_0x0184
            boolean r28 = r7.changed((java.lang.Object) r11)
            if (r28 == 0) goto L_0x0180
            r25 = 32
            goto L_0x0182
        L_0x0180:
            r25 = 16
        L_0x0182:
            r21 = r21 | r25
        L_0x0184:
            r11 = r9 & 896(0x380, float:1.256E-42)
            if (r11 != 0) goto L_0x019e
            r11 = r8 & 4096(0x1000, float:5.74E-42)
            if (r11 != 0) goto L_0x0197
            r11 = r82
            boolean r22 = r7.changed((java.lang.Object) r11)
            if (r22 == 0) goto L_0x0199
            r26 = 256(0x100, float:3.59E-43)
            goto L_0x019b
        L_0x0197:
            r11 = r82
        L_0x0199:
            r26 = 128(0x80, float:1.794E-43)
        L_0x019b:
            r21 = r21 | r26
            goto L_0x01a0
        L_0x019e:
            r11 = r82
        L_0x01a0:
            r11 = r9 & 7168(0x1c00, float:1.0045E-41)
            if (r11 != 0) goto L_0x01b8
            r11 = r8 & 8192(0x2000, float:1.14794E-41)
            if (r11 != 0) goto L_0x01b1
            r11 = r83
            boolean r22 = r7.changed((java.lang.Object) r11)
            if (r22 == 0) goto L_0x01b3
            goto L_0x01b5
        L_0x01b1:
            r11 = r83
        L_0x01b3:
            r16 = r17
        L_0x01b5:
            r21 = r21 | r16
            goto L_0x01ba
        L_0x01b8:
            r11 = r83
        L_0x01ba:
            r11 = r21
            r12 = r8 & 16384(0x4000, float:2.2959E-41)
            if (r12 == 0) goto L_0x01c5
            r11 = r11 | 24576(0x6000, float:3.4438E-41)
            r13 = r84
            goto L_0x01d6
        L_0x01c5:
            r16 = r9 & r64
            r13 = r84
            if (r16 != 0) goto L_0x01d6
            boolean r16 = r7.changed((boolean) r13)
            if (r16 == 0) goto L_0x01d2
            goto L_0x01d4
        L_0x01d2:
            r19 = r20
        L_0x01d4:
            r11 = r11 | r19
        L_0x01d6:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r8 & r16
            if (r16 == 0) goto L_0x01e4
            r17 = 196608(0x30000, float:2.75506E-40)
            r11 = r11 | r17
            r13 = r85
            goto L_0x01f9
        L_0x01e4:
            r17 = 458752(0x70000, float:6.42848E-40)
            r17 = r9 & r17
            r13 = r85
            if (r17 != 0) goto L_0x01f9
            boolean r17 = r7.changed((int) r13)
            if (r17 == 0) goto L_0x01f5
            r17 = r23
            goto L_0x01f7
        L_0x01f5:
            r17 = 65536(0x10000, float:9.18355E-41)
        L_0x01f7:
            r11 = r11 | r17
        L_0x01f9:
            r17 = 65536(0x10000, float:9.18355E-41)
            r17 = r8 & r17
            if (r17 == 0) goto L_0x0206
            r19 = 1572864(0x180000, float:2.204052E-39)
            r11 = r11 | r19
            r13 = r86
            goto L_0x0219
        L_0x0206:
            r19 = r9 & r65
            r13 = r86
            if (r19 != 0) goto L_0x0219
            boolean r19 = r7.changed((java.lang.Object) r13)
            if (r19 == 0) goto L_0x0215
            r19 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x0217
        L_0x0215:
            r19 = 524288(0x80000, float:7.34684E-40)
        L_0x0217:
            r11 = r11 | r19
        L_0x0219:
            r19 = 29360128(0x1c00000, float:7.052966E-38)
            r19 = r9 & r19
            if (r19 != 0) goto L_0x0233
            r19 = r8 & r23
            r13 = r87
            if (r19 != 0) goto L_0x022e
            boolean r19 = r7.changed((java.lang.Object) r13)
            if (r19 == 0) goto L_0x022e
            r19 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0230
        L_0x022e:
            r19 = 4194304(0x400000, float:5.877472E-39)
        L_0x0230:
            r11 = r11 | r19
            goto L_0x0235
        L_0x0233:
            r13 = r87
        L_0x0235:
            r19 = 234881024(0xe000000, float:1.5777218E-30)
            r19 = r9 & r19
            if (r19 != 0) goto L_0x0251
            r19 = 262144(0x40000, float:3.67342E-40)
            r19 = r8 & r19
            r9 = r88
            if (r19 != 0) goto L_0x024c
            boolean r19 = r7.changed((java.lang.Object) r9)
            if (r19 == 0) goto L_0x024c
            r19 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x024e
        L_0x024c:
            r19 = 33554432(0x2000000, float:9.403955E-38)
        L_0x024e:
            r11 = r11 | r19
            goto L_0x0253
        L_0x0251:
            r9 = r88
        L_0x0253:
            r19 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r9 = r0 & r19
            r13 = 306783378(0x12492492, float:6.3469493E-28)
            if (r9 != r13) goto L_0x0296
            r9 = 191739611(0xb6db6db, float:4.5782105E-32)
            r9 = r9 & r11
            r13 = 38347922(0x2492492, float:1.4777643E-37)
            if (r9 != r13) goto L_0x0296
            boolean r9 = r7.getSkipping()
            if (r9 != 0) goto L_0x026d
            goto L_0x0296
        L_0x026d:
            r7.skipToGroupEnd()
            r3 = r72
            r4 = r73
            r5 = r74
            r6 = r75
            r8 = r77
            r9 = r78
            r10 = r79
            r11 = r80
            r12 = r81
            r13 = r82
            r14 = r83
            r15 = r84
            r16 = r85
            r17 = r86
            r18 = r87
            r19 = r88
            r31 = r7
            r7 = r76
            goto L_0x05a5
        L_0x0296:
            r7.startDefaults()
            r9 = r10 & 1
            if (r9 == 0) goto L_0x02f1
            boolean r9 = r7.getDefaultsInvalid()
            if (r9 == 0) goto L_0x02a4
            goto L_0x02f1
        L_0x02a4:
            r7.skipToGroupEnd()
            r1 = r8 & 32
            if (r1 == 0) goto L_0x02af
            r1 = -458753(0xfffffffffff8ffff, float:NaN)
            r0 = r0 & r1
        L_0x02af:
            r1 = r8 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x02b5
            r11 = r11 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x02b5:
            r1 = r8 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L_0x02bb
            r11 = r11 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x02bb:
            r1 = r8 & r23
            if (r1 == 0) goto L_0x02c3
            r1 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r11 = r11 & r1
        L_0x02c3:
            r1 = 262144(0x40000, float:3.67342E-40)
            r1 = r1 & r8
            if (r1 == 0) goto L_0x02cc
            r1 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r11 = r11 & r1
        L_0x02cc:
            r19 = r72
            r12 = r73
            r20 = r74
            r10 = r75
            r66 = r76
            r21 = r77
            r22 = r78
            r23 = r79
            r9 = r80
            r24 = r81
            r25 = r82
            r26 = r83
            r27 = r84
            r67 = r85
            r28 = r86
            r6 = r87
            r5 = r88
            r1 = r11
            goto L_0x0434
        L_0x02f1:
            if (r3 == 0) goto L_0x02f6
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            goto L_0x02f8
        L_0x02f6:
            r3 = r72
        L_0x02f8:
            if (r14 == 0) goto L_0x02fc
            r9 = 1
            goto L_0x02fe
        L_0x02fc:
            r9 = r73
        L_0x02fe:
            if (r18 == 0) goto L_0x0302
            r14 = 0
            goto L_0x0304
        L_0x0302:
            r14 = r74
        L_0x0304:
            r18 = r8 & 32
            if (r18 == 0) goto L_0x0318
            androidx.compose.runtime.ProvidableCompositionLocal r13 = androidx.compose.material.TextKt.getLocalTextStyle()
            java.lang.Object r13 = r7.consume(r13)
            androidx.compose.ui.text.TextStyle r13 = (androidx.compose.ui.text.TextStyle) r13
            r18 = -458753(0xfffffffffff8ffff, float:NaN)
            r0 = r0 & r18
            goto L_0x031a
        L_0x0318:
            r13 = r75
        L_0x031a:
            if (r24 == 0) goto L_0x031f
            r66 = 0
            goto L_0x0321
        L_0x031f:
            r66 = r76
        L_0x0321:
            if (r6 == 0) goto L_0x0325
            r6 = 0
            goto L_0x0327
        L_0x0325:
            r6 = r77
        L_0x0327:
            if (r1 == 0) goto L_0x032b
            r1 = 0
            goto L_0x032d
        L_0x032b:
            r1 = r78
        L_0x032d:
            if (r2 == 0) goto L_0x0331
            r2 = 0
            goto L_0x0333
        L_0x0331:
            r2 = r79
        L_0x0333:
            if (r4 == 0) goto L_0x0337
            r4 = 0
            goto L_0x0339
        L_0x0337:
            r4 = r80
        L_0x0339:
            if (r5 == 0) goto L_0x0342
            androidx.compose.ui.text.input.VisualTransformation$Companion r5 = androidx.compose.ui.text.input.VisualTransformation.Companion
            androidx.compose.ui.text.input.VisualTransformation r5 = r5.getNone()
            goto L_0x0344
        L_0x0342:
            r5 = r81
        L_0x0344:
            r10 = r8 & 4096(0x1000, float:5.74E-42)
            if (r10 == 0) goto L_0x0351
            androidx.compose.foundation.text.KeyboardOptions$Companion r10 = androidx.compose.foundation.text.KeyboardOptions.Companion
            androidx.compose.foundation.text.KeyboardOptions r10 = r10.getDefault()
            r11 = r11 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x0353
        L_0x0351:
            r10 = r82
        L_0x0353:
            r72 = r0
            r0 = r8 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x0362
            androidx.compose.foundation.text.KeyboardActions$Companion r0 = androidx.compose.foundation.text.KeyboardActions.Companion
            androidx.compose.foundation.text.KeyboardActions r0 = r0.getDefault()
            r11 = r11 & -7169(0xffffffffffffe3ff, float:NaN)
            goto L_0x0364
        L_0x0362:
            r0 = r83
        L_0x0364:
            if (r12 == 0) goto L_0x0368
            r12 = 0
            goto L_0x036a
        L_0x0368:
            r12 = r84
        L_0x036a:
            if (r16 == 0) goto L_0x0372
            r16 = 2147483647(0x7fffffff, float:NaN)
            r67 = r16
            goto L_0x0374
        L_0x0372:
            r67 = r85
        L_0x0374:
            r73 = r0
            if (r17 == 0) goto L_0x0399
            r0 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r7.startReplaceableGroup(r0)
            java.lang.Object r0 = r7.rememberedValue()
            androidx.compose.runtime.Composer$Companion r16 = androidx.compose.runtime.Composer.Companion
            r74 = r1
            java.lang.Object r1 = r16.getEmpty()
            if (r0 != r1) goto L_0x0393
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r7.updateRememberedValue(r0)
        L_0x0393:
            r7.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = (androidx.compose.foundation.interaction.MutableInteractionSource) r0
            goto L_0x039d
        L_0x0399:
            r74 = r1
            r0 = r86
        L_0x039d:
            r1 = r8 & r23
            if (r1 == 0) goto L_0x03b4
            androidx.compose.material.MaterialTheme r1 = androidx.compose.material.MaterialTheme.INSTANCE
            r75 = r0
            r0 = 6
            androidx.compose.material.Shapes r0 = r1.getShapes(r7, r0)
            androidx.compose.foundation.shape.CornerBasedShape r0 = r0.getSmall()
            r1 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r1 = r1 & r11
            r11 = r1
            goto L_0x03b8
        L_0x03b4:
            r75 = r0
            r0 = r87
        L_0x03b8:
            r1 = 262144(0x40000, float:3.67342E-40)
            r1 = r1 & r8
            if (r1 == 0) goto L_0x0417
            androidx.compose.material.TextFieldDefaults r16 = androidx.compose.material.TextFieldDefaults.INSTANCE
            r17 = 0
            r19 = 0
            r21 = 0
            r23 = 0
            r25 = 0
            r27 = 0
            r29 = 0
            r31 = 0
            r33 = 0
            r35 = 0
            r37 = 0
            r39 = 0
            r41 = 0
            r43 = 0
            r45 = 0
            r47 = 0
            r49 = 0
            r51 = 0
            r53 = 0
            r55 = 0
            r57 = 0
            r60 = 0
            r61 = 0
            r62 = 48
            r63 = 2097151(0x1fffff, float:2.938734E-39)
            r59 = r7
            androidx.compose.material.TextFieldColors r1 = r16.m1438outlinedTextFieldColorsdx8h9Zs(r17, r19, r21, r23, r25, r27, r29, r31, r33, r35, r37, r39, r41, r43, r45, r47, r49, r51, r53, r55, r57, r59, r60, r61, r62, r63)
            r16 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r11 = r11 & r16
            r26 = r73
            r22 = r74
            r28 = r75
            r23 = r2
            r19 = r3
            r24 = r5
            r21 = r6
            r25 = r10
            r27 = r12
            r10 = r13
            r20 = r14
            r6 = r0
            r5 = r1
            r12 = r9
            r1 = r11
            goto L_0x0431
        L_0x0417:
            r26 = r73
            r22 = r74
            r28 = r75
            r23 = r2
            r19 = r3
            r24 = r5
            r21 = r6
            r25 = r10
            r1 = r11
            r27 = r12
            r10 = r13
            r20 = r14
            r5 = r88
            r6 = r0
            r12 = r9
        L_0x0431:
            r0 = r72
            r9 = r4
        L_0x0434:
            r7.endDefaults()
            r2 = 1961394975(0x74e8831f, float:1.4737211E32)
            r7.startReplaceableGroup(r2)
            long r2 = r10.m5056getColor0d7_KjU()
            androidx.compose.ui.graphics.Color$Companion r4 = androidx.compose.ui.graphics.Color.Companion
            long r13 = r4.m2955getUnspecified0d7_KjU()
            int r4 = (r2 > r13 ? 1 : (r2 == r13 ? 0 : -1))
            if (r4 == 0) goto L_0x044d
            r13 = 1
            goto L_0x044e
        L_0x044d:
            r13 = 0
        L_0x044e:
            if (r13 == 0) goto L_0x0451
            goto L_0x0468
        L_0x0451:
            int r2 = r0 >> 9
            r2 = r2 & 14
            int r3 = r1 >> 21
            r3 = r3 & 112(0x70, float:1.57E-43)
            r2 = r2 | r3
            androidx.compose.runtime.State r2 = r5.textColor(r12, r7, r2)
            java.lang.Object r2 = r2.getValue()
            androidx.compose.ui.graphics.Color r2 = (androidx.compose.ui.graphics.Color) r2
            long r2 = r2.m2929unboximpl()
        L_0x0468:
            r30 = r2
            r7.endReplaceableGroup()
            androidx.compose.ui.text.TextStyle r2 = new androidx.compose.ui.text.TextStyle
            r29 = r2
            r32 = 0
            r34 = 0
            r35 = 0
            r36 = 0
            r37 = 0
            r38 = 0
            r39 = 0
            r41 = 0
            r42 = 0
            r43 = 0
            r44 = 0
            r46 = 0
            r47 = 0
            r48 = 0
            r49 = 0
            r50 = 0
            r52 = 0
            r53 = 262142(0x3fffe, float:3.67339E-40)
            r54 = 0
            r29.<init>((long) r30, (long) r32, (androidx.compose.ui.text.font.FontWeight) r34, (androidx.compose.ui.text.font.FontStyle) r35, (androidx.compose.ui.text.font.FontSynthesis) r36, (androidx.compose.ui.text.font.FontFamily) r37, (java.lang.String) r38, (long) r39, (androidx.compose.ui.text.style.BaselineShift) r41, (androidx.compose.ui.text.style.TextGeometricTransform) r42, (androidx.compose.ui.text.intl.LocaleList) r43, (long) r44, (androidx.compose.ui.text.style.TextDecoration) r46, (androidx.compose.ui.graphics.Shadow) r47, (androidx.compose.ui.text.style.TextAlign) r48, (androidx.compose.ui.text.style.TextDirection) r49, (long) r50, (androidx.compose.ui.text.style.TextIndent) r52, (int) r53, (kotlin.jvm.internal.DefaultConstructorMarker) r54)
            androidx.compose.ui.text.TextStyle r29 = r10.merge((androidx.compose.ui.text.TextStyle) r2)
            if (r66 == 0) goto L_0x04bc
            r2 = 0
            float r3 = OutlinedTextFieldTopPadding
            r4 = 0
            r11 = 0
            r13 = 13
            r14 = 0
            r76 = r19
            r77 = r2
            r78 = r3
            r79 = r4
            r80 = r11
            r81 = r13
            r82 = r14
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.PaddingKt.m490paddingqDBjuR0$default(r76, r77, r78, r79, r80, r81, r82)
            goto L_0x04be
        L_0x04bc:
            r2 = r19
        L_0x04be:
            int r3 = r0 >> 9
            r3 = r3 & 14
            int r4 = r1 >> 21
            r4 = r4 & 112(0x70, float:1.57E-43)
            r3 = r3 | r4
            androidx.compose.runtime.State r3 = r5.backgroundColor(r12, r7, r3)
            java.lang.Object r3 = r3.getValue()
            androidx.compose.ui.graphics.Color r3 = (androidx.compose.ui.graphics.Color) r3
            long r13 = r3.m2929unboximpl()
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.BackgroundKt.m176backgroundbw27NRU(r2, r13, r6)
            androidx.compose.material.TextFieldDefaults r3 = androidx.compose.material.TextFieldDefaults.INSTANCE
            float r11 = r3.m1435getMinWidthD9Ej5fM()
            float r3 = r3.m1434getMinHeightD9Ej5fM()
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.m542defaultMinSizeVpY3zN4(r2, r11, r3)
            androidx.compose.ui.graphics.SolidColor r3 = new androidx.compose.ui.graphics.SolidColor
            r13 = r3
            r11 = r1 & 14
            r4 = r4 | r11
            androidx.compose.runtime.State r4 = r5.cursorColor(r9, r7, r4)
            java.lang.Object r4 = r4.getValue()
            androidx.compose.ui.graphics.Color r4 = (androidx.compose.ui.graphics.Color) r4
            r87 = r10
            long r10 = r4.m2929unboximpl()
            r4 = 0
            r3.<init>(r10, r4)
            r11 = 0
            androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$2 r3 = new androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$2
            r72 = r3
            r73 = r70
            r74 = r12
            r75 = r27
            r76 = r24
            r77 = r28
            r78 = r9
            r79 = r66
            r80 = r21
            r81 = r22
            r82 = r23
            r83 = r5
            r84 = r0
            r85 = r1
            r86 = r6
            r72.<init>(r73, r74, r75, r76, r77, r78, r79, r80, r81, r82, r83, r84, r85, r86)
            r4 = 986454116(0x3acc1864, float:0.0015571234)
            r10 = 1
            androidx.compose.runtime.internal.ComposableLambda r14 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r7, r4, r10, r3)
            r3 = r0 & 14
            r4 = r0 & 112(0x70, float:1.57E-43)
            r3 = r3 | r4
            r4 = r0 & 7168(0x1c00, float:1.0045E-41)
            r3 = r3 | r4
            r0 = r0 & r64
            r0 = r0 | r3
            int r3 = r1 << 12
            r4 = r3 & r65
            r0 = r0 | r4
            int r4 = androidx.compose.foundation.text.KeyboardActions.$stable
            int r4 = r4 << 21
            r0 = r0 | r4
            r4 = 29360128(0x1c00000, float:7.052966E-38)
            r4 = r4 & r3
            r0 = r0 | r4
            r4 = 234881024(0xe000000, float:1.5777218E-30)
            r4 = r4 & r3
            r0 = r0 | r4
            r4 = 1879048192(0x70000000, float:1.58456325E29)
            r3 = r3 & r4
            r16 = r0 | r3
            int r0 = r1 >> 3
            r0 = r0 & 14
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            int r1 = r1 >> 12
            r1 = r1 & 896(0x380, float:1.256E-42)
            r17 = r0 | r1
            r18 = 2048(0x800, float:2.87E-42)
            r0 = r70
            r1 = r71
            r3 = r12
            r4 = r20
            r30 = r5
            r5 = r29
            r29 = r6
            r6 = r25
            r31 = r7
            r7 = r26
            r8 = r27
            r32 = r9
            r9 = r67
            r33 = r87
            r10 = r24
            r34 = r12
            r12 = r28
            r15 = r31
            androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField((java.lang.String) r0, (kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit>) r1, (androidx.compose.ui.Modifier) r2, (boolean) r3, (boolean) r4, (androidx.compose.ui.text.TextStyle) r5, (androidx.compose.foundation.text.KeyboardOptions) r6, (androidx.compose.foundation.text.KeyboardActions) r7, (boolean) r8, (int) r9, (androidx.compose.ui.text.input.VisualTransformation) r10, (kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit>) r11, (androidx.compose.foundation.interaction.MutableInteractionSource) r12, (androidx.compose.ui.graphics.Brush) r13, (kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r14, (androidx.compose.runtime.Composer) r15, (int) r16, (int) r17, (int) r18)
            r3 = r19
            r5 = r20
            r8 = r21
            r9 = r22
            r10 = r23
            r12 = r24
            r13 = r25
            r14 = r26
            r15 = r27
            r17 = r28
            r18 = r29
            r19 = r30
            r11 = r32
            r6 = r33
            r4 = r34
            r7 = r66
            r16 = r67
        L_0x05a5:
            androidx.compose.runtime.ScopeUpdateScope r2 = r31.endRestartGroup()
            if (r2 != 0) goto L_0x05ac
            goto L_0x05c7
        L_0x05ac:
            androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$3 r1 = new androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$3
            r0 = r1
            r68 = r1
            r1 = r70
            r69 = r2
            r2 = r71
            r20 = r90
            r21 = r91
            r22 = r92
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            r1 = r68
            r0 = r69
            r0.updateScope(r1)
        L_0x05c7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField(java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material.TextFieldColors, androidx.compose.runtime.Composer, int, int, int):void");
    }

    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    @Composable
    public static final void OutlinedTextFieldLayout(@NotNull Modifier modifier, @NotNull Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function3, @Nullable Function2<? super Composer, ? super Integer, Unit> function22, @Nullable Function2<? super Composer, ? super Integer, Unit> function23, @Nullable Function2<? super Composer, ? super Integer, Unit> function24, boolean z11, float f11, @NotNull Function1<? super Size, Unit> function1, @NotNull Function2<? super Composer, ? super Integer, Unit> function25, @NotNull PaddingValues paddingValues, @Nullable Composer composer, int i11, int i12) {
        int i13;
        int i14;
        int i15;
        Modifier modifier2 = modifier;
        Function2<? super Composer, ? super Integer, Unit> function26 = function2;
        Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function32 = function3;
        Function2<? super Composer, ? super Integer, Unit> function27 = function22;
        Function2<? super Composer, ? super Integer, Unit> function28 = function23;
        Function2<? super Composer, ? super Integer, Unit> function29 = function24;
        boolean z12 = z11;
        float f12 = f11;
        Function1<? super Size, Unit> function12 = function1;
        Function2<? super Composer, ? super Integer, Unit> function210 = function25;
        PaddingValues paddingValues2 = paddingValues;
        int i16 = i11;
        Intrinsics.checkNotNullParameter(modifier2, "modifier");
        Intrinsics.checkNotNullParameter(function26, "textField");
        Intrinsics.checkNotNullParameter(function12, "onLabelMeasured");
        Intrinsics.checkNotNullParameter(function210, BorderId);
        Intrinsics.checkNotNullParameter(paddingValues2, "paddingValues");
        Composer startRestartGroup = composer.startRestartGroup(-2049536174);
        if ((i16 & 14) == 0) {
            i13 = (startRestartGroup.changed((Object) modifier2) ? 4 : 2) | i16;
        } else {
            i13 = i16;
        }
        if ((i16 & 112) == 0) {
            i13 |= startRestartGroup.changed((Object) function26) ? 32 : 16;
        }
        if ((i16 & 896) == 0) {
            i13 |= startRestartGroup.changed((Object) function32) ? 256 : 128;
        }
        if ((i16 & 7168) == 0) {
            i13 |= startRestartGroup.changed((Object) function27) ? 2048 : 1024;
        }
        if ((57344 & i16) == 0) {
            i13 |= startRestartGroup.changed((Object) function28) ? 16384 : 8192;
        }
        if ((458752 & i16) == 0) {
            i13 |= startRestartGroup.changed((Object) function29) ? 131072 : 65536;
        }
        if ((3670016 & i16) == 0) {
            i13 |= startRestartGroup.changed(z12) ? 1048576 : 524288;
        }
        if ((29360128 & i16) == 0) {
            i13 |= startRestartGroup.changed(f12) ? 8388608 : 4194304;
        }
        if ((234881024 & i16) == 0) {
            i13 |= startRestartGroup.changed((Object) function12) ? 67108864 : 33554432;
        }
        if ((1879048192 & i16) == 0) {
            i13 |= startRestartGroup.changed((Object) function210) ? 536870912 : 268435456;
        }
        if ((i12 & 14) == 0) {
            i14 = i12 | (startRestartGroup.changed((Object) paddingValues2) ? 4 : 2);
        } else {
            i14 = i12;
        }
        if ((i13 & 1533916891) == 306783378 && (i14 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            Function2<? super Composer, ? super Integer, Unit> function211 = function27;
        } else {
            Object[] objArr = {function12, Boolean.valueOf(z11), Float.valueOf(f11), paddingValues2};
            startRestartGroup.startReplaceableGroup(-568225417);
            int i17 = 0;
            boolean z13 = false;
            for (int i18 = 4; i17 < i18; i18 = 4) {
                z13 |= startRestartGroup.changed(objArr[i17]);
                i17++;
            }
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z13 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new OutlinedTextFieldMeasurePolicy(function12, z12, f12, paddingValues2);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            OutlinedTextFieldMeasurePolicy outlinedTextFieldMeasurePolicy = (OutlinedTextFieldMeasurePolicy) rememberedValue;
            LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            startRestartGroup.startReplaceableGroup(-1323940314);
            Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection2 = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion = ComposeUiNode.Companion;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier);
            int i19 = ((((i13 << 3) & 112) << 9) & 7168) | 6;
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
            Composer r22 = Updater.m2536constructorimpl(startRestartGroup);
            Updater.m2543setimpl(r22, outlinedTextFieldMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m2543setimpl(r22, density, companion.getSetDensity());
            Updater.m2543setimpl(r22, layoutDirection2, companion.getSetLayoutDirection());
            Updater.m2543setimpl(r22, viewConfiguration, companion.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, Integer.valueOf((i19 >> 3) & 112));
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(118153609);
            if (((i19 >> 9) & 14 & 11) != 2 || !startRestartGroup.getSkipping()) {
                function210.invoke(startRestartGroup, Integer.valueOf((i13 >> 27) & 14));
                startRestartGroup.startReplaceableGroup(1169914108);
                if (function28 != null) {
                    Modifier then = LayoutIdKt.layoutId(Modifier.Companion, "Leading").then(TextFieldImplKt.getIconDefaultSizeModifier());
                    Alignment center = Alignment.Companion.getCenter();
                    startRestartGroup.startReplaceableGroup(733328855);
                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, startRestartGroup, 6);
                    startRestartGroup.startReplaceableGroup(-1323940314);
                    Density density2 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection3 = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration2 = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    Function0<ComposeUiNode> constructor2 = companion.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(then);
                    if (!(startRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.getInserting()) {
                        startRestartGroup.createNode(constructor2);
                    } else {
                        startRestartGroup.useNode();
                    }
                    startRestartGroup.disableReusing();
                    Composer r23 = Updater.m2536constructorimpl(startRestartGroup);
                    Updater.m2543setimpl(r23, rememberBoxMeasurePolicy, companion.getSetMeasurePolicy());
                    Updater.m2543setimpl(r23, density2, companion.getSetDensity());
                    Updater.m2543setimpl(r23, layoutDirection3, companion.getSetLayoutDirection());
                    Updater.m2543setimpl(r23, viewConfiguration2, companion.getSetViewConfiguration());
                    startRestartGroup.enableReusing();
                    materializerOf2.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
                    startRestartGroup.startReplaceableGroup(2058660585);
                    startRestartGroup.startReplaceableGroup(-2137368960);
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    startRestartGroup.startReplaceableGroup(1691709354);
                    function28.invoke(startRestartGroup, Integer.valueOf((i13 >> 12) & 14));
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endNode();
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                }
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.startReplaceableGroup(1169914393);
                if (function29 != null) {
                    Modifier then2 = LayoutIdKt.layoutId(Modifier.Companion, "Trailing").then(TextFieldImplKt.getIconDefaultSizeModifier());
                    Alignment center2 = Alignment.Companion.getCenter();
                    startRestartGroup.startReplaceableGroup(733328855);
                    MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(center2, false, startRestartGroup, 6);
                    startRestartGroup.startReplaceableGroup(-1323940314);
                    Density density3 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection4 = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration3 = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    Function0<ComposeUiNode> constructor3 = companion.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf3 = LayoutKt.materializerOf(then2);
                    if (!(startRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.getInserting()) {
                        startRestartGroup.createNode(constructor3);
                    } else {
                        startRestartGroup.useNode();
                    }
                    startRestartGroup.disableReusing();
                    Composer r12 = Updater.m2536constructorimpl(startRestartGroup);
                    Updater.m2543setimpl(r12, rememberBoxMeasurePolicy2, companion.getSetMeasurePolicy());
                    Updater.m2543setimpl(r12, density3, companion.getSetDensity());
                    Updater.m2543setimpl(r12, layoutDirection4, companion.getSetLayoutDirection());
                    Updater.m2543setimpl(r12, viewConfiguration3, companion.getSetViewConfiguration());
                    startRestartGroup.enableReusing();
                    materializerOf3.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
                    startRestartGroup.startReplaceableGroup(2058660585);
                    startRestartGroup.startReplaceableGroup(-2137368960);
                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                    startRestartGroup.startReplaceableGroup(-1351586719);
                    function29.invoke(startRestartGroup, Integer.valueOf((i13 >> 15) & 14));
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endNode();
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                }
                startRestartGroup.endReplaceableGroup();
                float calculateStartPadding = PaddingKt.calculateStartPadding(paddingValues2, layoutDirection);
                float calculateEndPadding = PaddingKt.calculateEndPadding(paddingValues2, layoutDirection);
                Modifier.Companion companion2 = Modifier.Companion;
                if (function28 != null) {
                    i15 = 0;
                    calculateStartPadding = Dp.m5478constructorimpl(RangesKt___RangesKt.coerceAtLeast(Dp.m5478constructorimpl(calculateStartPadding - TextFieldImplKt.getHorizontalIconPadding()), Dp.m5478constructorimpl((float) 0)));
                } else {
                    i15 = 0;
                }
                float f13 = calculateStartPadding;
                if (function29 != null) {
                    calculateEndPadding = Dp.m5478constructorimpl(RangesKt___RangesKt.coerceAtLeast(Dp.m5478constructorimpl(calculateEndPadding - TextFieldImplKt.getHorizontalIconPadding()), Dp.m5478constructorimpl((float) i15)));
                }
                Modifier r24 = PaddingKt.m490paddingqDBjuR0$default(companion2, f13, 0.0f, calculateEndPadding, 0.0f, 10, (Object) null);
                startRestartGroup.startReplaceableGroup(1169915404);
                if (function32 != null) {
                    function32.invoke(LayoutIdKt.layoutId(companion2, "Hint").then(r24), startRestartGroup, Integer.valueOf((i13 >> 3) & 112));
                }
                startRestartGroup.endReplaceableGroup();
                Modifier then3 = LayoutIdKt.layoutId(companion2, "TextField").then(r24);
                startRestartGroup.startReplaceableGroup(733328855);
                Alignment.Companion companion3 = Alignment.Companion;
                MeasurePolicy rememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(companion3.getTopStart(), true, startRestartGroup, 48);
                startRestartGroup.startReplaceableGroup(-1323940314);
                Density density4 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection5 = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration4 = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                Function0<ComposeUiNode> constructor4 = companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf4 = LayoutKt.materializerOf(then3);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor4);
                } else {
                    startRestartGroup.useNode();
                }
                startRestartGroup.disableReusing();
                Composer r13 = Updater.m2536constructorimpl(startRestartGroup);
                Updater.m2543setimpl(r13, rememberBoxMeasurePolicy3, companion.getSetMeasurePolicy());
                Updater.m2543setimpl(r13, density4, companion.getSetDensity());
                Updater.m2543setimpl(r13, layoutDirection5, companion.getSetLayoutDirection());
                Updater.m2543setimpl(r13, viewConfiguration4, companion.getSetViewConfiguration());
                startRestartGroup.enableReusing();
                materializerOf4.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                startRestartGroup.startReplaceableGroup(-2137368960);
                BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                startRestartGroup.startReplaceableGroup(-1205597937);
                function2.invoke(startRestartGroup, Integer.valueOf((i13 >> 3) & 14));
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                Function2<? super Composer, ? super Integer, Unit> function212 = function22;
                if (function212 != null) {
                    Modifier layoutId = LayoutIdKt.layoutId(companion2, "Label");
                    startRestartGroup.startReplaceableGroup(733328855);
                    MeasurePolicy rememberBoxMeasurePolicy4 = BoxKt.rememberBoxMeasurePolicy(companion3.getTopStart(), false, startRestartGroup, 0);
                    startRestartGroup.startReplaceableGroup(-1323940314);
                    Density density5 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection6 = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration5 = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    Function0<ComposeUiNode> constructor5 = companion.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf5 = LayoutKt.materializerOf(layoutId);
                    if (!(startRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.getInserting()) {
                        startRestartGroup.createNode(constructor5);
                    } else {
                        startRestartGroup.useNode();
                    }
                    startRestartGroup.disableReusing();
                    Composer r14 = Updater.m2536constructorimpl(startRestartGroup);
                    Updater.m2543setimpl(r14, rememberBoxMeasurePolicy4, companion.getSetMeasurePolicy());
                    Updater.m2543setimpl(r14, density5, companion.getSetDensity());
                    Updater.m2543setimpl(r14, layoutDirection6, companion.getSetLayoutDirection());
                    Updater.m2543setimpl(r14, viewConfiguration5, companion.getSetViewConfiguration());
                    startRestartGroup.enableReusing();
                    materializerOf5.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
                    startRestartGroup.startReplaceableGroup(2058660585);
                    startRestartGroup.startReplaceableGroup(-2137368960);
                    startRestartGroup.startReplaceableGroup(-55131805);
                    function212.invoke(startRestartGroup, Integer.valueOf((i13 >> 9) & 14));
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endNode();
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                }
            } else {
                startRestartGroup.skipToGroupEnd();
                Function2<? super Composer, ? super Integer, Unit> function213 = function2;
                Function2<? super Composer, ? super Integer, Unit> function214 = function22;
            }
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new OutlinedTextFieldKt$OutlinedTextFieldLayout$2(modifier, function2, function3, function22, function23, function24, z11, f11, function1, function25, paddingValues, i11, i12));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: calculateHeight-zUg2_y0  reason: not valid java name */
    public static final int m1318calculateHeightzUg2_y0(int i11, int i12, int i13, int i14, int i15, long j11, float f11, PaddingValues paddingValues) {
        return Math.max(Constraints.m5423getMinHeightimpl(j11), Math.max(i11, Math.max(i12, MathKt__MathJVMKt.roundToInt(((float) Math.max(i13, i15)) + (paddingValues.m496calculateBottomPaddingD9Ej5fM() * f11) + Math.max(paddingValues.m499calculateTopPaddingD9Ej5fM() * f11, ((float) i14) / 2.0f)))));
    }

    /* access modifiers changed from: private */
    /* renamed from: calculateWidth-VsPV1Ek  reason: not valid java name */
    public static final int m1319calculateWidthVsPV1Ek(int i11, int i12, int i13, int i14, int i15, long j11) {
        return Math.max(i11 + Math.max(i13, Math.max(i14, i15)) + i12, Constraints.m5424getMinWidthimpl(j11));
    }

    public static final float getOutlinedTextFieldTopPadding() {
        return OutlinedTextFieldTopPadding;
    }

    @NotNull
    /* renamed from: outlineCutout-12SF9DM  reason: not valid java name */
    public static final Modifier m1320outlineCutout12SF9DM(@NotNull Modifier modifier, long j11, @NotNull PaddingValues paddingValues) {
        Intrinsics.checkNotNullParameter(modifier, "$this$outlineCutout");
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        return DrawModifierKt.drawWithContent(modifier, new OutlinedTextFieldKt$outlineCutout$1(j11, paddingValues));
    }

    /* access modifiers changed from: private */
    public static final void place(Placeable.PlacementScope placementScope, int i11, int i12, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, Placeable placeable5, Placeable placeable6, float f11, boolean z11, float f12, LayoutDirection layoutDirection, PaddingValues paddingValues) {
        int i13;
        int i14;
        float f13;
        int i15 = i11;
        int roundToInt = MathKt__MathJVMKt.roundToInt(paddingValues.m499calculateTopPaddingD9Ej5fM() * f12);
        int roundToInt2 = MathKt__MathJVMKt.roundToInt(PaddingKt.calculateStartPadding(paddingValues, layoutDirection) * f12);
        float horizontalIconPadding = TextFieldImplKt.getHorizontalIconPadding() * f12;
        if (placeable != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, Alignment.Companion.getCenterVertically().align(placeable.getHeight(), i15), 0.0f, 4, (Object) null);
        }
        if (placeable2 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, i12 - placeable2.getWidth(), Alignment.Companion.getCenterVertically().align(placeable2.getHeight(), i15), 0.0f, 4, (Object) null);
        }
        if (placeable4 != null) {
            if (z11) {
                i14 = Alignment.Companion.getCenterVertically().align(placeable4.getHeight(), i15);
            } else {
                i14 = roundToInt;
            }
            float f14 = ((float) 1) - f11;
            float height = (((float) i14) * f14) - (((float) (placeable4.getHeight() / 2)) * f11);
            if (placeable == null) {
                f13 = 0.0f;
            } else {
                f13 = f14 * (((float) TextFieldImplKt.widthOrZero(placeable)) - horizontalIconPadding);
            }
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable4, MathKt__MathJVMKt.roundToInt(f13) + roundToInt2, MathKt__MathJVMKt.roundToInt(height), 0.0f, 4, (Object) null);
        }
        if (z11) {
            i13 = Alignment.Companion.getCenterVertically().align(placeable3.getHeight(), i15);
        } else {
            i13 = roundToInt;
        }
        Placeable.PlacementScope placementScope2 = placementScope;
        Placeable placeable7 = placeable3;
        Placeable.PlacementScope.placeRelative$default(placementScope2, placeable7, TextFieldImplKt.widthOrZero(placeable), Math.max(i13, TextFieldImplKt.heightOrZero(placeable4) / 2), 0.0f, 4, (Object) null);
        if (placeable5 != null) {
            if (z11) {
                roundToInt = Alignment.Companion.getCenterVertically().align(placeable5.getHeight(), i15);
            }
            Placeable.PlacementScope placementScope3 = placementScope;
            Placeable placeable8 = placeable5;
            Placeable.PlacementScope.placeRelative$default(placementScope3, placeable8, TextFieldImplKt.widthOrZero(placeable), roundToInt, 0.0f, 4, (Object) null);
        }
        Placeable.PlacementScope.m4529place70tqf50$default(placementScope, placeable6, IntOffset.Companion.m5606getZeronOccac(), 0.0f, 2, (Object) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:140:0x01ae, code lost:
        if (r7.changed((java.lang.Object) r83) != false) goto L_0x01b5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x014d  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0152  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x016c  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0171  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0188  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x019e  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x01a4  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x01b8  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x01c0  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x01c5  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x01dd  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x01e4  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x01ff  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x0206  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x021f  */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x0233  */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x023b  */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x0251  */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x026d  */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x0296  */
    /* JADX WARNING: Removed duplicated region for block: B:295:0x05c9  */
    /* JADX WARNING: Removed duplicated region for block: B:297:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0134  */
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void OutlinedTextField(@org.jetbrains.annotations.NotNull androidx.compose.ui.text.input.TextFieldValue r70, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit> r71, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r72, boolean r73, boolean r74, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.TextStyle r75, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r76, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r77, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r78, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r79, boolean r80, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.input.VisualTransformation r81, @org.jetbrains.annotations.Nullable androidx.compose.foundation.text.KeyboardOptions r82, @org.jetbrains.annotations.Nullable androidx.compose.foundation.text.KeyboardActions r83, boolean r84, int r85, @org.jetbrains.annotations.Nullable androidx.compose.foundation.interaction.MutableInteractionSource r86, @org.jetbrains.annotations.Nullable androidx.compose.ui.graphics.Shape r87, @org.jetbrains.annotations.Nullable androidx.compose.material.TextFieldColors r88, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r89, int r90, int r91, int r92) {
        /*
            r15 = r70
            r12 = r71
            r10 = r90
            r9 = r91
            r8 = r92
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "onValueChange"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r0 = -288998816(0xffffffffeec63a60, float:-3.0674301E28)
            r1 = r89
            androidx.compose.runtime.Composer r7 = r1.startRestartGroup(r0)
            r0 = r8 & 1
            if (r0 == 0) goto L_0x0024
            r0 = r10 | 6
            goto L_0x0034
        L_0x0024:
            r0 = r10 & 14
            if (r0 != 0) goto L_0x0033
            boolean r0 = r7.changed((java.lang.Object) r15)
            if (r0 == 0) goto L_0x0030
            r0 = 4
            goto L_0x0031
        L_0x0030:
            r0 = 2
        L_0x0031:
            r0 = r0 | r10
            goto L_0x0034
        L_0x0033:
            r0 = r10
        L_0x0034:
            r3 = r8 & 2
            if (r3 == 0) goto L_0x003b
            r0 = r0 | 48
            goto L_0x004b
        L_0x003b:
            r3 = r10 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x004b
            boolean r3 = r7.changed((java.lang.Object) r12)
            if (r3 == 0) goto L_0x0048
            r3 = 32
            goto L_0x004a
        L_0x0048:
            r3 = 16
        L_0x004a:
            r0 = r0 | r3
        L_0x004b:
            r3 = r8 & 4
            if (r3 == 0) goto L_0x0052
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x0065
        L_0x0052:
            r13 = r10 & 896(0x380, float:1.256E-42)
            if (r13 != 0) goto L_0x0065
            r13 = r72
            boolean r14 = r7.changed((java.lang.Object) r13)
            if (r14 == 0) goto L_0x0061
            r14 = 256(0x100, float:3.59E-43)
            goto L_0x0063
        L_0x0061:
            r14 = 128(0x80, float:1.794E-43)
        L_0x0063:
            r0 = r0 | r14
            goto L_0x0067
        L_0x0065:
            r13 = r72
        L_0x0067:
            r14 = r8 & 8
            r16 = 2048(0x800, float:2.87E-42)
            r17 = 1024(0x400, float:1.435E-42)
            if (r14 == 0) goto L_0x0072
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x0086
        L_0x0072:
            r1 = r10 & 7168(0x1c00, float:1.0045E-41)
            if (r1 != 0) goto L_0x0086
            r1 = r73
            boolean r18 = r7.changed((boolean) r1)
            if (r18 == 0) goto L_0x0081
            r18 = r16
            goto L_0x0083
        L_0x0081:
            r18 = r17
        L_0x0083:
            r0 = r0 | r18
            goto L_0x0088
        L_0x0086:
            r1 = r73
        L_0x0088:
            r18 = r8 & 16
            r19 = 16384(0x4000, float:2.2959E-41)
            r64 = 57344(0xe000, float:8.0356E-41)
            r20 = 8192(0x2000, float:1.14794E-41)
            if (r18 == 0) goto L_0x0098
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            r2 = r74
            goto L_0x00ab
        L_0x0098:
            r21 = r10 & r64
            r2 = r74
            if (r21 != 0) goto L_0x00ab
            boolean r22 = r7.changed((boolean) r2)
            if (r22 == 0) goto L_0x00a7
            r22 = r19
            goto L_0x00a9
        L_0x00a7:
            r22 = r20
        L_0x00a9:
            r0 = r0 | r22
        L_0x00ab:
            r22 = 458752(0x70000, float:6.42848E-40)
            r22 = r10 & r22
            r23 = 131072(0x20000, float:1.83671E-40)
            if (r22 != 0) goto L_0x00c7
            r22 = r8 & 32
            r4 = r75
            if (r22 != 0) goto L_0x00c2
            boolean r24 = r7.changed((java.lang.Object) r4)
            if (r24 == 0) goto L_0x00c2
            r24 = r23
            goto L_0x00c4
        L_0x00c2:
            r24 = 65536(0x10000, float:9.18355E-41)
        L_0x00c4:
            r0 = r0 | r24
            goto L_0x00c9
        L_0x00c7:
            r4 = r75
        L_0x00c9:
            r24 = r8 & 64
            r65 = 3670016(0x380000, float:5.142788E-39)
            if (r24 == 0) goto L_0x00d6
            r25 = 1572864(0x180000, float:2.204052E-39)
            r0 = r0 | r25
            r5 = r76
            goto L_0x00e9
        L_0x00d6:
            r25 = r10 & r65
            r5 = r76
            if (r25 != 0) goto L_0x00e9
            boolean r26 = r7.changed((java.lang.Object) r5)
            if (r26 == 0) goto L_0x00e5
            r26 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e7
        L_0x00e5:
            r26 = 524288(0x80000, float:7.34684E-40)
        L_0x00e7:
            r0 = r0 | r26
        L_0x00e9:
            r6 = r8 & 128(0x80, float:1.794E-43)
            if (r6 == 0) goto L_0x00f4
            r27 = 12582912(0xc00000, float:1.7632415E-38)
            r0 = r0 | r27
            r11 = r77
            goto L_0x0109
        L_0x00f4:
            r27 = 29360128(0x1c00000, float:7.052966E-38)
            r27 = r10 & r27
            r11 = r77
            if (r27 != 0) goto L_0x0109
            boolean r28 = r7.changed((java.lang.Object) r11)
            if (r28 == 0) goto L_0x0105
            r28 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0107
        L_0x0105:
            r28 = 4194304(0x400000, float:5.877472E-39)
        L_0x0107:
            r0 = r0 | r28
        L_0x0109:
            r1 = r8 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0114
            r28 = 100663296(0x6000000, float:2.4074124E-35)
            r0 = r0 | r28
            r2 = r78
            goto L_0x0129
        L_0x0114:
            r28 = 234881024(0xe000000, float:1.5777218E-30)
            r28 = r10 & r28
            r2 = r78
            if (r28 != 0) goto L_0x0129
            boolean r28 = r7.changed((java.lang.Object) r2)
            if (r28 == 0) goto L_0x0125
            r28 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0127
        L_0x0125:
            r28 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0127:
            r0 = r0 | r28
        L_0x0129:
            r2 = r8 & 512(0x200, float:7.175E-43)
            if (r2 == 0) goto L_0x0134
            r28 = 805306368(0x30000000, float:4.656613E-10)
            r0 = r0 | r28
            r4 = r79
            goto L_0x0149
        L_0x0134:
            r28 = 1879048192(0x70000000, float:1.58456325E29)
            r28 = r10 & r28
            r4 = r79
            if (r28 != 0) goto L_0x0149
            boolean r28 = r7.changed((java.lang.Object) r4)
            if (r28 == 0) goto L_0x0145
            r28 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0147
        L_0x0145:
            r28 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0147:
            r0 = r0 | r28
        L_0x0149:
            r4 = r8 & 1024(0x400, float:1.435E-42)
            if (r4 == 0) goto L_0x0152
            r21 = r9 | 6
            r5 = r80
            goto L_0x0168
        L_0x0152:
            r28 = r9 & 14
            r5 = r80
            if (r28 != 0) goto L_0x0166
            boolean r28 = r7.changed((boolean) r5)
            if (r28 == 0) goto L_0x0161
            r21 = 4
            goto L_0x0163
        L_0x0161:
            r21 = 2
        L_0x0163:
            r21 = r9 | r21
            goto L_0x0168
        L_0x0166:
            r21 = r9
        L_0x0168:
            r5 = r8 & 2048(0x800, float:2.87E-42)
            if (r5 == 0) goto L_0x0171
            r21 = r21 | 48
            r11 = r81
            goto L_0x0184
        L_0x0171:
            r28 = r9 & 112(0x70, float:1.57E-43)
            r11 = r81
            if (r28 != 0) goto L_0x0184
            boolean r28 = r7.changed((java.lang.Object) r11)
            if (r28 == 0) goto L_0x0180
            r25 = 32
            goto L_0x0182
        L_0x0180:
            r25 = 16
        L_0x0182:
            r21 = r21 | r25
        L_0x0184:
            r11 = r9 & 896(0x380, float:1.256E-42)
            if (r11 != 0) goto L_0x019e
            r11 = r8 & 4096(0x1000, float:5.74E-42)
            if (r11 != 0) goto L_0x0197
            r11 = r82
            boolean r22 = r7.changed((java.lang.Object) r11)
            if (r22 == 0) goto L_0x0199
            r26 = 256(0x100, float:3.59E-43)
            goto L_0x019b
        L_0x0197:
            r11 = r82
        L_0x0199:
            r26 = 128(0x80, float:1.794E-43)
        L_0x019b:
            r21 = r21 | r26
            goto L_0x01a0
        L_0x019e:
            r11 = r82
        L_0x01a0:
            r11 = r9 & 7168(0x1c00, float:1.0045E-41)
            if (r11 != 0) goto L_0x01b8
            r11 = r8 & 8192(0x2000, float:1.14794E-41)
            if (r11 != 0) goto L_0x01b1
            r11 = r83
            boolean r22 = r7.changed((java.lang.Object) r11)
            if (r22 == 0) goto L_0x01b3
            goto L_0x01b5
        L_0x01b1:
            r11 = r83
        L_0x01b3:
            r16 = r17
        L_0x01b5:
            r21 = r21 | r16
            goto L_0x01ba
        L_0x01b8:
            r11 = r83
        L_0x01ba:
            r11 = r21
            r12 = r8 & 16384(0x4000, float:2.2959E-41)
            if (r12 == 0) goto L_0x01c5
            r11 = r11 | 24576(0x6000, float:3.4438E-41)
            r13 = r84
            goto L_0x01d6
        L_0x01c5:
            r16 = r9 & r64
            r13 = r84
            if (r16 != 0) goto L_0x01d6
            boolean r16 = r7.changed((boolean) r13)
            if (r16 == 0) goto L_0x01d2
            goto L_0x01d4
        L_0x01d2:
            r19 = r20
        L_0x01d4:
            r11 = r11 | r19
        L_0x01d6:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r8 & r16
            if (r16 == 0) goto L_0x01e4
            r17 = 196608(0x30000, float:2.75506E-40)
            r11 = r11 | r17
            r13 = r85
            goto L_0x01f9
        L_0x01e4:
            r17 = 458752(0x70000, float:6.42848E-40)
            r17 = r9 & r17
            r13 = r85
            if (r17 != 0) goto L_0x01f9
            boolean r17 = r7.changed((int) r13)
            if (r17 == 0) goto L_0x01f5
            r17 = r23
            goto L_0x01f7
        L_0x01f5:
            r17 = 65536(0x10000, float:9.18355E-41)
        L_0x01f7:
            r11 = r11 | r17
        L_0x01f9:
            r17 = 65536(0x10000, float:9.18355E-41)
            r17 = r8 & r17
            if (r17 == 0) goto L_0x0206
            r19 = 1572864(0x180000, float:2.204052E-39)
            r11 = r11 | r19
            r13 = r86
            goto L_0x0219
        L_0x0206:
            r19 = r9 & r65
            r13 = r86
            if (r19 != 0) goto L_0x0219
            boolean r19 = r7.changed((java.lang.Object) r13)
            if (r19 == 0) goto L_0x0215
            r19 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x0217
        L_0x0215:
            r19 = 524288(0x80000, float:7.34684E-40)
        L_0x0217:
            r11 = r11 | r19
        L_0x0219:
            r19 = 29360128(0x1c00000, float:7.052966E-38)
            r19 = r9 & r19
            if (r19 != 0) goto L_0x0233
            r19 = r8 & r23
            r13 = r87
            if (r19 != 0) goto L_0x022e
            boolean r19 = r7.changed((java.lang.Object) r13)
            if (r19 == 0) goto L_0x022e
            r19 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0230
        L_0x022e:
            r19 = 4194304(0x400000, float:5.877472E-39)
        L_0x0230:
            r11 = r11 | r19
            goto L_0x0235
        L_0x0233:
            r13 = r87
        L_0x0235:
            r19 = 234881024(0xe000000, float:1.5777218E-30)
            r19 = r9 & r19
            if (r19 != 0) goto L_0x0251
            r19 = 262144(0x40000, float:3.67342E-40)
            r19 = r8 & r19
            r9 = r88
            if (r19 != 0) goto L_0x024c
            boolean r19 = r7.changed((java.lang.Object) r9)
            if (r19 == 0) goto L_0x024c
            r19 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x024e
        L_0x024c:
            r19 = 33554432(0x2000000, float:9.403955E-38)
        L_0x024e:
            r11 = r11 | r19
            goto L_0x0253
        L_0x0251:
            r9 = r88
        L_0x0253:
            r19 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r9 = r0 & r19
            r13 = 306783378(0x12492492, float:6.3469493E-28)
            if (r9 != r13) goto L_0x0296
            r9 = 191739611(0xb6db6db, float:4.5782105E-32)
            r9 = r9 & r11
            r13 = 38347922(0x2492492, float:1.4777643E-37)
            if (r9 != r13) goto L_0x0296
            boolean r9 = r7.getSkipping()
            if (r9 != 0) goto L_0x026d
            goto L_0x0296
        L_0x026d:
            r7.skipToGroupEnd()
            r3 = r72
            r4 = r73
            r5 = r74
            r6 = r75
            r8 = r77
            r9 = r78
            r10 = r79
            r11 = r80
            r12 = r81
            r13 = r82
            r14 = r83
            r15 = r84
            r16 = r85
            r17 = r86
            r18 = r87
            r19 = r88
            r31 = r7
            r7 = r76
            goto L_0x05c2
        L_0x0296:
            r7.startDefaults()
            r9 = r10 & 1
            if (r9 == 0) goto L_0x02f1
            boolean r9 = r7.getDefaultsInvalid()
            if (r9 == 0) goto L_0x02a4
            goto L_0x02f1
        L_0x02a4:
            r7.skipToGroupEnd()
            r1 = r8 & 32
            if (r1 == 0) goto L_0x02af
            r1 = -458753(0xfffffffffff8ffff, float:NaN)
            r0 = r0 & r1
        L_0x02af:
            r1 = r8 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x02b5
            r11 = r11 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x02b5:
            r1 = r8 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L_0x02bb
            r11 = r11 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x02bb:
            r1 = r8 & r23
            if (r1 == 0) goto L_0x02c3
            r1 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r11 = r11 & r1
        L_0x02c3:
            r1 = 262144(0x40000, float:3.67342E-40)
            r1 = r1 & r8
            if (r1 == 0) goto L_0x02cc
            r1 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r11 = r11 & r1
        L_0x02cc:
            r19 = r72
            r12 = r73
            r20 = r74
            r10 = r75
            r66 = r76
            r21 = r77
            r22 = r78
            r23 = r79
            r9 = r80
            r24 = r81
            r25 = r82
            r26 = r83
            r27 = r84
            r67 = r85
            r28 = r86
            r6 = r87
            r5 = r88
            r1 = r11
            goto L_0x0451
        L_0x02f1:
            if (r3 == 0) goto L_0x02f6
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            goto L_0x02f8
        L_0x02f6:
            r3 = r72
        L_0x02f8:
            if (r14 == 0) goto L_0x02fc
            r9 = 1
            goto L_0x02fe
        L_0x02fc:
            r9 = r73
        L_0x02fe:
            if (r18 == 0) goto L_0x0302
            r14 = 0
            goto L_0x0304
        L_0x0302:
            r14 = r74
        L_0x0304:
            r18 = r8 & 32
            if (r18 == 0) goto L_0x0318
            androidx.compose.runtime.ProvidableCompositionLocal r13 = androidx.compose.material.TextKt.getLocalTextStyle()
            java.lang.Object r13 = r7.consume(r13)
            androidx.compose.ui.text.TextStyle r13 = (androidx.compose.ui.text.TextStyle) r13
            r18 = -458753(0xfffffffffff8ffff, float:NaN)
            r0 = r0 & r18
            goto L_0x031a
        L_0x0318:
            r13 = r75
        L_0x031a:
            if (r24 == 0) goto L_0x031f
            r66 = 0
            goto L_0x0321
        L_0x031f:
            r66 = r76
        L_0x0321:
            if (r6 == 0) goto L_0x0325
            r6 = 0
            goto L_0x0327
        L_0x0325:
            r6 = r77
        L_0x0327:
            if (r1 == 0) goto L_0x032b
            r1 = 0
            goto L_0x032d
        L_0x032b:
            r1 = r78
        L_0x032d:
            if (r2 == 0) goto L_0x0331
            r2 = 0
            goto L_0x0333
        L_0x0331:
            r2 = r79
        L_0x0333:
            if (r4 == 0) goto L_0x0337
            r4 = 0
            goto L_0x0339
        L_0x0337:
            r4 = r80
        L_0x0339:
            if (r5 == 0) goto L_0x0342
            androidx.compose.ui.text.input.VisualTransformation$Companion r5 = androidx.compose.ui.text.input.VisualTransformation.Companion
            androidx.compose.ui.text.input.VisualTransformation r5 = r5.getNone()
            goto L_0x0344
        L_0x0342:
            r5 = r81
        L_0x0344:
            r10 = r8 & 4096(0x1000, float:5.74E-42)
            if (r10 == 0) goto L_0x0351
            androidx.compose.foundation.text.KeyboardOptions$Companion r10 = androidx.compose.foundation.text.KeyboardOptions.Companion
            androidx.compose.foundation.text.KeyboardOptions r10 = r10.getDefault()
            r11 = r11 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x0353
        L_0x0351:
            r10 = r82
        L_0x0353:
            r72 = r0
            r0 = r8 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x0383
            androidx.compose.foundation.text.KeyboardActions r0 = new androidx.compose.foundation.text.KeyboardActions
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r24 = 0
            r25 = 63
            r26 = 0
            r73 = r0
            r74 = r18
            r75 = r19
            r76 = r20
            r77 = r21
            r78 = r22
            r79 = r24
            r80 = r25
            r81 = r26
            r73.<init>(r74, r75, r76, r77, r78, r79, r80, r81)
            r11 = r11 & -7169(0xffffffffffffe3ff, float:NaN)
            goto L_0x0385
        L_0x0383:
            r0 = r83
        L_0x0385:
            if (r12 == 0) goto L_0x0389
            r12 = 0
            goto L_0x038b
        L_0x0389:
            r12 = r84
        L_0x038b:
            if (r16 == 0) goto L_0x0393
            r16 = 2147483647(0x7fffffff, float:NaN)
            r67 = r16
            goto L_0x0395
        L_0x0393:
            r67 = r85
        L_0x0395:
            r73 = r0
            if (r17 == 0) goto L_0x03ba
            r0 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r7.startReplaceableGroup(r0)
            java.lang.Object r0 = r7.rememberedValue()
            androidx.compose.runtime.Composer$Companion r16 = androidx.compose.runtime.Composer.Companion
            r74 = r1
            java.lang.Object r1 = r16.getEmpty()
            if (r0 != r1) goto L_0x03b4
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r7.updateRememberedValue(r0)
        L_0x03b4:
            r7.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = (androidx.compose.foundation.interaction.MutableInteractionSource) r0
            goto L_0x03be
        L_0x03ba:
            r74 = r1
            r0 = r86
        L_0x03be:
            r1 = r8 & r23
            if (r1 == 0) goto L_0x03d1
            androidx.compose.material.TextFieldDefaults r1 = androidx.compose.material.TextFieldDefaults.INSTANCE
            r75 = r0
            r0 = 6
            androidx.compose.ui.graphics.Shape r0 = r1.getOutlinedTextFieldShape(r7, r0)
            r1 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r1 = r1 & r11
            r11 = r1
            goto L_0x03d5
        L_0x03d1:
            r75 = r0
            r0 = r87
        L_0x03d5:
            r1 = 262144(0x40000, float:3.67342E-40)
            r1 = r1 & r8
            if (r1 == 0) goto L_0x0434
            androidx.compose.material.TextFieldDefaults r16 = androidx.compose.material.TextFieldDefaults.INSTANCE
            r17 = 0
            r19 = 0
            r21 = 0
            r23 = 0
            r25 = 0
            r27 = 0
            r29 = 0
            r31 = 0
            r33 = 0
            r35 = 0
            r37 = 0
            r39 = 0
            r41 = 0
            r43 = 0
            r45 = 0
            r47 = 0
            r49 = 0
            r51 = 0
            r53 = 0
            r55 = 0
            r57 = 0
            r60 = 0
            r61 = 0
            r62 = 48
            r63 = 2097151(0x1fffff, float:2.938734E-39)
            r59 = r7
            androidx.compose.material.TextFieldColors r1 = r16.m1438outlinedTextFieldColorsdx8h9Zs(r17, r19, r21, r23, r25, r27, r29, r31, r33, r35, r37, r39, r41, r43, r45, r47, r49, r51, r53, r55, r57, r59, r60, r61, r62, r63)
            r16 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r11 = r11 & r16
            r26 = r73
            r22 = r74
            r28 = r75
            r23 = r2
            r19 = r3
            r24 = r5
            r21 = r6
            r25 = r10
            r27 = r12
            r10 = r13
            r20 = r14
            r6 = r0
            r5 = r1
            r12 = r9
            r1 = r11
            goto L_0x044e
        L_0x0434:
            r26 = r73
            r22 = r74
            r28 = r75
            r23 = r2
            r19 = r3
            r24 = r5
            r21 = r6
            r25 = r10
            r1 = r11
            r27 = r12
            r10 = r13
            r20 = r14
            r5 = r88
            r6 = r0
            r12 = r9
        L_0x044e:
            r0 = r72
            r9 = r4
        L_0x0451:
            r7.endDefaults()
            r2 = 1961402586(0x74e8a0da, float:1.4744572E32)
            r7.startReplaceableGroup(r2)
            long r2 = r10.m5056getColor0d7_KjU()
            androidx.compose.ui.graphics.Color$Companion r4 = androidx.compose.ui.graphics.Color.Companion
            long r13 = r4.m2955getUnspecified0d7_KjU()
            int r4 = (r2 > r13 ? 1 : (r2 == r13 ? 0 : -1))
            if (r4 == 0) goto L_0x046a
            r13 = 1
            goto L_0x046b
        L_0x046a:
            r13 = 0
        L_0x046b:
            if (r13 == 0) goto L_0x046e
            goto L_0x0485
        L_0x046e:
            int r2 = r0 >> 9
            r2 = r2 & 14
            int r3 = r1 >> 21
            r3 = r3 & 112(0x70, float:1.57E-43)
            r2 = r2 | r3
            androidx.compose.runtime.State r2 = r5.textColor(r12, r7, r2)
            java.lang.Object r2 = r2.getValue()
            androidx.compose.ui.graphics.Color r2 = (androidx.compose.ui.graphics.Color) r2
            long r2 = r2.m2929unboximpl()
        L_0x0485:
            r30 = r2
            r7.endReplaceableGroup()
            androidx.compose.ui.text.TextStyle r2 = new androidx.compose.ui.text.TextStyle
            r29 = r2
            r32 = 0
            r34 = 0
            r35 = 0
            r36 = 0
            r37 = 0
            r38 = 0
            r39 = 0
            r41 = 0
            r42 = 0
            r43 = 0
            r44 = 0
            r46 = 0
            r47 = 0
            r48 = 0
            r49 = 0
            r50 = 0
            r52 = 0
            r53 = 262142(0x3fffe, float:3.67339E-40)
            r54 = 0
            r29.<init>((long) r30, (long) r32, (androidx.compose.ui.text.font.FontWeight) r34, (androidx.compose.ui.text.font.FontStyle) r35, (androidx.compose.ui.text.font.FontSynthesis) r36, (androidx.compose.ui.text.font.FontFamily) r37, (java.lang.String) r38, (long) r39, (androidx.compose.ui.text.style.BaselineShift) r41, (androidx.compose.ui.text.style.TextGeometricTransform) r42, (androidx.compose.ui.text.intl.LocaleList) r43, (long) r44, (androidx.compose.ui.text.style.TextDecoration) r46, (androidx.compose.ui.graphics.Shadow) r47, (androidx.compose.ui.text.style.TextAlign) r48, (androidx.compose.ui.text.style.TextDirection) r49, (long) r50, (androidx.compose.ui.text.style.TextIndent) r52, (int) r53, (kotlin.jvm.internal.DefaultConstructorMarker) r54)
            androidx.compose.ui.text.TextStyle r29 = r10.merge((androidx.compose.ui.text.TextStyle) r2)
            if (r66 == 0) goto L_0x04d9
            r2 = 0
            float r3 = OutlinedTextFieldTopPadding
            r4 = 0
            r11 = 0
            r13 = 13
            r14 = 0
            r76 = r19
            r77 = r2
            r78 = r3
            r79 = r4
            r80 = r11
            r81 = r13
            r82 = r14
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.PaddingKt.m490paddingqDBjuR0$default(r76, r77, r78, r79, r80, r81, r82)
            goto L_0x04db
        L_0x04d9:
            r2 = r19
        L_0x04db:
            int r3 = r0 >> 9
            r3 = r3 & 14
            int r4 = r1 >> 21
            r4 = r4 & 112(0x70, float:1.57E-43)
            r3 = r3 | r4
            androidx.compose.runtime.State r3 = r5.backgroundColor(r12, r7, r3)
            java.lang.Object r3 = r3.getValue()
            androidx.compose.ui.graphics.Color r3 = (androidx.compose.ui.graphics.Color) r3
            long r13 = r3.m2929unboximpl()
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.BackgroundKt.m176backgroundbw27NRU(r2, r13, r6)
            androidx.compose.material.TextFieldDefaults r3 = androidx.compose.material.TextFieldDefaults.INSTANCE
            float r11 = r3.m1435getMinWidthD9Ej5fM()
            float r3 = r3.m1434getMinHeightD9Ej5fM()
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.m542defaultMinSizeVpY3zN4(r2, r11, r3)
            androidx.compose.ui.graphics.SolidColor r3 = new androidx.compose.ui.graphics.SolidColor
            r13 = r3
            r11 = r1 & 14
            r4 = r4 | r11
            androidx.compose.runtime.State r4 = r5.cursorColor(r9, r7, r4)
            java.lang.Object r4 = r4.getValue()
            androidx.compose.ui.graphics.Color r4 = (androidx.compose.ui.graphics.Color) r4
            r87 = r10
            long r10 = r4.m2929unboximpl()
            r4 = 0
            r3.<init>(r10, r4)
            r11 = 0
            androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$5 r3 = new androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$5
            r72 = r3
            r73 = r70
            r74 = r12
            r75 = r27
            r76 = r24
            r77 = r28
            r78 = r9
            r79 = r66
            r80 = r21
            r81 = r22
            r82 = r23
            r83 = r5
            r84 = r0
            r85 = r1
            r86 = r6
            r72.<init>(r73, r74, r75, r76, r77, r78, r79, r80, r81, r82, r83, r84, r85, r86)
            r4 = -1219079113(0xffffffffb7565437, float:-1.2775002E-5)
            r10 = 1
            androidx.compose.runtime.internal.ComposableLambda r14 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r7, r4, r10, r3)
            r3 = r0 & 14
            r4 = r0 & 112(0x70, float:1.57E-43)
            r3 = r3 | r4
            r4 = r0 & 7168(0x1c00, float:1.0045E-41)
            r3 = r3 | r4
            r0 = r0 & r64
            r0 = r0 | r3
            int r3 = r1 << 12
            r4 = r3 & r65
            r0 = r0 | r4
            int r4 = androidx.compose.foundation.text.KeyboardActions.$stable
            int r4 = r4 << 21
            r0 = r0 | r4
            r4 = 29360128(0x1c00000, float:7.052966E-38)
            r4 = r4 & r3
            r0 = r0 | r4
            r4 = 234881024(0xe000000, float:1.5777218E-30)
            r4 = r4 & r3
            r0 = r0 | r4
            r4 = 1879048192(0x70000000, float:1.58456325E29)
            r3 = r3 & r4
            r16 = r0 | r3
            int r0 = r1 >> 3
            r0 = r0 & 14
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            int r1 = r1 >> 12
            r1 = r1 & 896(0x380, float:1.256E-42)
            r17 = r0 | r1
            r18 = 2048(0x800, float:2.87E-42)
            r0 = r70
            r1 = r71
            r3 = r12
            r4 = r20
            r30 = r5
            r5 = r29
            r29 = r6
            r6 = r25
            r31 = r7
            r7 = r26
            r8 = r27
            r32 = r9
            r9 = r67
            r33 = r87
            r10 = r24
            r34 = r12
            r12 = r28
            r15 = r31
            androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField((androidx.compose.ui.text.input.TextFieldValue) r0, (kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit>) r1, (androidx.compose.ui.Modifier) r2, (boolean) r3, (boolean) r4, (androidx.compose.ui.text.TextStyle) r5, (androidx.compose.foundation.text.KeyboardOptions) r6, (androidx.compose.foundation.text.KeyboardActions) r7, (boolean) r8, (int) r9, (androidx.compose.ui.text.input.VisualTransformation) r10, (kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit>) r11, (androidx.compose.foundation.interaction.MutableInteractionSource) r12, (androidx.compose.ui.graphics.Brush) r13, (kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r14, (androidx.compose.runtime.Composer) r15, (int) r16, (int) r17, (int) r18)
            r3 = r19
            r5 = r20
            r8 = r21
            r9 = r22
            r10 = r23
            r12 = r24
            r13 = r25
            r14 = r26
            r15 = r27
            r17 = r28
            r18 = r29
            r19 = r30
            r11 = r32
            r6 = r33
            r4 = r34
            r7 = r66
            r16 = r67
        L_0x05c2:
            androidx.compose.runtime.ScopeUpdateScope r2 = r31.endRestartGroup()
            if (r2 != 0) goto L_0x05c9
            goto L_0x05e4
        L_0x05c9:
            androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$6 r1 = new androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$6
            r0 = r1
            r68 = r1
            r1 = r70
            r69 = r2
            r2 = r71
            r20 = r90
            r21 = r91
            r22 = r92
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            r1 = r68
            r0 = r69
            r0.updateScope(r1)
        L_0x05e4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField(androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material.TextFieldColors, androidx.compose.runtime.Composer, int, int, int):void");
    }
}
