package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
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
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u0002\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\n0\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\b\b\u0002\u0010\u001c\u001a\u00020\u00122\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u00122\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+H\u0007¢\u0006\u0002\u0010,\u001a\u0002\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020-2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\n0\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\b\b\u0002\u0010\u001c\u001a\u00020\u00122\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u00122\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+H\u0007¢\u0006\u0002\u0010.\u001a\u0001\u0010/\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0011\u00100\u001a\r\u0012\u0004\u0012\u00020\n0\u0017¢\u0006\u0002\b\u00182\u0013\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0019\u0010\u0019\u001a\u0015\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\n\u0018\u00010\u000e¢\u0006\u0002\b\u00182\u0013\u00101\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0013\u00102\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0006\u0010#\u001a\u00020\u00122\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206H\u0001¢\u0006\u0002\u00107\u001a]\u00108\u001a\u00020%2\u0006\u00109\u001a\u00020%2\u0006\u0010:\u001a\u00020\u00122\u0006\u0010;\u001a\u00020%2\u0006\u0010<\u001a\u00020%2\u0006\u0010=\u001a\u00020%2\u0006\u0010>\u001a\u00020%2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u0002042\u0006\u00105\u001a\u000206H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bB\u0010C\u001aE\u0010D\u001a\u00020%2\u0006\u0010E\u001a\u00020%2\u0006\u0010F\u001a\u00020%2\u0006\u0010G\u001a\u00020%2\u0006\u0010H\u001a\u00020%2\u0006\u0010I\u001a\u00020%2\u0006\u0010?\u001a\u00020@H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bJ\u0010K\u001a\u0014\u0010L\u001a\u00020\u0010*\u00020\u00102\u0006\u0010M\u001a\u00020NH\u0000\u001at\u0010O\u001a\u00020\n*\u00020P2\u0006\u0010Q\u001a\u00020%2\u0006\u0010R\u001a\u00020%2\u0006\u0010S\u001a\u00020T2\b\u0010U\u001a\u0004\u0018\u00010T2\b\u0010V\u001a\u0004\u0018\u00010T2\b\u0010W\u001a\u0004\u0018\u00010T2\b\u0010X\u001a\u0004\u0018\u00010T2\u0006\u0010#\u001a\u00020\u00122\u0006\u0010Y\u001a\u00020%2\u0006\u0010Z\u001a\u00020%2\u0006\u00103\u001a\u0002042\u0006\u0010A\u001a\u000204H\u0002\u001aZ\u0010[\u001a\u00020\n*\u00020P2\u0006\u0010Q\u001a\u00020%2\u0006\u0010R\u001a\u00020%2\u0006\u0010\\\u001a\u00020T2\b\u0010V\u001a\u0004\u0018\u00010T2\b\u0010W\u001a\u0004\u0018\u00010T2\b\u0010X\u001a\u0004\u0018\u00010T2\u0006\u0010#\u001a\u00020\u00122\u0006\u0010A\u001a\u0002042\u0006\u00105\u001a\u000206H\u0002\"\u0019\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0002\u0010\u0003\"\u0019\u0010\u0005\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0006\u0010\u0003\"\u0019\u0010\u0007\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\b\u0010\u0003\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006]"}, d2 = {"FirstBaselineOffset", "Landroidx/compose/ui/unit/Dp;", "getFirstBaselineOffset", "()F", "F", "TextFieldBottomPadding", "getTextFieldBottomPadding", "TextFieldTopPadding", "getTextFieldTopPadding", "TextField", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "label", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "placeholder", "leadingIcon", "trailingIcon", "isError", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "maxLines", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material/TextFieldColors;", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "TextFieldLayout", "textField", "leading", "trailing", "animationProgress", "", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)V", "calculateHeight", "textFieldHeight", "hasLabel", "labelBaseline", "leadingHeight", "trailingHeight", "placeholderHeight", "constraints", "Landroidx/compose/ui/unit/Constraints;", "density", "calculateHeight-O3s9Psw", "(IZIIIIJFLandroidx/compose/foundation/layout/PaddingValues;)I", "calculateWidth", "leadingWidth", "trailingWidth", "textFieldWidth", "labelWidth", "placeholderWidth", "calculateWidth-VsPV1Ek", "(IIIIIJ)I", "drawIndicatorLine", "indicatorBorder", "Landroidx/compose/foundation/BorderStroke;", "placeWithLabel", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "width", "height", "textfieldPlaceable", "Landroidx/compose/ui/layout/Placeable;", "labelPlaceable", "placeholderPlaceable", "leadingPlaceable", "trailingPlaceable", "labelEndPosition", "textPosition", "placeWithoutLabel", "textPlaceable", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class TextFieldKt {
    private static final float FirstBaselineOffset = Dp.m5478constructorimpl((float) 20);
    private static final float TextFieldBottomPadding = Dp.m5478constructorimpl((float) 10);
    private static final float TextFieldTopPadding = Dp.m5478constructorimpl((float) 4);

    /* JADX WARNING: Code restructure failed: missing block: B:140:0x01ae, code lost:
        if (r7.changed((java.lang.Object) r84) != false) goto L_0x01b5;
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
    /* JADX WARNING: Removed duplicated region for block: B:291:0x05ea  */
    /* JADX WARNING: Removed duplicated region for block: B:293:? A[RETURN, SYNTHETIC] */
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
    public static final void TextField(@org.jetbrains.annotations.NotNull java.lang.String r71, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r72, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r73, boolean r74, boolean r75, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.TextStyle r76, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r77, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r78, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r79, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r80, boolean r81, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.input.VisualTransformation r82, @org.jetbrains.annotations.Nullable androidx.compose.foundation.text.KeyboardOptions r83, @org.jetbrains.annotations.Nullable androidx.compose.foundation.text.KeyboardActions r84, boolean r85, int r86, @org.jetbrains.annotations.Nullable androidx.compose.foundation.interaction.MutableInteractionSource r87, @org.jetbrains.annotations.Nullable androidx.compose.ui.graphics.Shape r88, @org.jetbrains.annotations.Nullable androidx.compose.material.TextFieldColors r89, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r90, int r91, int r92, int r93) {
        /*
            r15 = r71
            r12 = r72
            r10 = r91
            r9 = r92
            r8 = r93
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "onValueChange"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r0 = -1690895095(0xffffffff9b36fd09, float:-1.5136447E-22)
            r1 = r90
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
            r13 = r73
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
            r13 = r73
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
            r1 = r74
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
            r1 = r74
        L_0x0088:
            r18 = r8 & 16
            r19 = 16384(0x4000, float:2.2959E-41)
            r64 = 57344(0xe000, float:8.0356E-41)
            r20 = 8192(0x2000, float:1.14794E-41)
            if (r18 == 0) goto L_0x0098
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            r2 = r75
            goto L_0x00ab
        L_0x0098:
            r21 = r10 & r64
            r2 = r75
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
            r4 = r76
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
            r4 = r76
        L_0x00c9:
            r24 = r8 & 64
            r65 = 3670016(0x380000, float:5.142788E-39)
            if (r24 == 0) goto L_0x00d6
            r25 = 1572864(0x180000, float:2.204052E-39)
            r0 = r0 | r25
            r5 = r77
            goto L_0x00e9
        L_0x00d6:
            r25 = r10 & r65
            r5 = r77
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
            r11 = r78
            goto L_0x0109
        L_0x00f4:
            r27 = 29360128(0x1c00000, float:7.052966E-38)
            r27 = r10 & r27
            r11 = r78
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
            r2 = r79
            goto L_0x0129
        L_0x0114:
            r28 = 234881024(0xe000000, float:1.5777218E-30)
            r28 = r10 & r28
            r2 = r79
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
            r4 = r80
            goto L_0x0149
        L_0x0134:
            r28 = 1879048192(0x70000000, float:1.58456325E29)
            r28 = r10 & r28
            r4 = r80
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
            r5 = r81
            goto L_0x0168
        L_0x0152:
            r28 = r9 & 14
            r5 = r81
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
            r11 = r82
            goto L_0x0184
        L_0x0171:
            r28 = r9 & 112(0x70, float:1.57E-43)
            r11 = r82
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
            r11 = r83
            boolean r22 = r7.changed((java.lang.Object) r11)
            if (r22 == 0) goto L_0x0199
            r26 = 256(0x100, float:3.59E-43)
            goto L_0x019b
        L_0x0197:
            r11 = r83
        L_0x0199:
            r26 = 128(0x80, float:1.794E-43)
        L_0x019b:
            r21 = r21 | r26
            goto L_0x01a0
        L_0x019e:
            r11 = r83
        L_0x01a0:
            r11 = r9 & 7168(0x1c00, float:1.0045E-41)
            if (r11 != 0) goto L_0x01b8
            r11 = r8 & 8192(0x2000, float:1.14794E-41)
            if (r11 != 0) goto L_0x01b1
            r11 = r84
            boolean r22 = r7.changed((java.lang.Object) r11)
            if (r22 == 0) goto L_0x01b3
            goto L_0x01b5
        L_0x01b1:
            r11 = r84
        L_0x01b3:
            r16 = r17
        L_0x01b5:
            r21 = r21 | r16
            goto L_0x01ba
        L_0x01b8:
            r11 = r84
        L_0x01ba:
            r11 = r21
            r12 = r8 & 16384(0x4000, float:2.2959E-41)
            if (r12 == 0) goto L_0x01c5
            r11 = r11 | 24576(0x6000, float:3.4438E-41)
            r13 = r85
            goto L_0x01d6
        L_0x01c5:
            r16 = r9 & r64
            r13 = r85
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
            r13 = r86
            goto L_0x01f9
        L_0x01e4:
            r17 = 458752(0x70000, float:6.42848E-40)
            r17 = r9 & r17
            r13 = r86
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
            r13 = r87
            goto L_0x0219
        L_0x0206:
            r19 = r9 & r65
            r13 = r87
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
            r13 = r88
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
            r13 = r88
        L_0x0235:
            r19 = 234881024(0xe000000, float:1.5777218E-30)
            r19 = r9 & r19
            if (r19 != 0) goto L_0x0251
            r19 = 262144(0x40000, float:3.67342E-40)
            r19 = r8 & r19
            r9 = r89
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
            r9 = r89
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
            r3 = r73
            r4 = r74
            r5 = r75
            r6 = r76
            r8 = r78
            r9 = r79
            r10 = r80
            r11 = r81
            r12 = r82
            r13 = r83
            r14 = r84
            r15 = r85
            r16 = r86
            r17 = r87
            r18 = r88
            r19 = r89
            r32 = r7
            r7 = r77
            goto L_0x05e3
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
            r12 = r73
            r10 = r74
            r19 = r75
            r9 = r76
            r67 = r77
            r20 = r78
            r21 = r79
            r22 = r80
            r6 = r81
            r23 = r82
            r24 = r83
            r25 = r84
            r26 = r85
            r68 = r86
            r27 = r87
            r4 = r88
            r3 = r89
            r1 = r11
            goto L_0x0475
        L_0x02f1:
            if (r3 == 0) goto L_0x02f6
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            goto L_0x02f8
        L_0x02f6:
            r3 = r73
        L_0x02f8:
            if (r14 == 0) goto L_0x02fc
            r9 = 1
            goto L_0x02fe
        L_0x02fc:
            r9 = r74
        L_0x02fe:
            if (r18 == 0) goto L_0x0302
            r14 = 0
            goto L_0x0304
        L_0x0302:
            r14 = r75
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
            r13 = r76
        L_0x031a:
            if (r24 == 0) goto L_0x031f
            r67 = 0
            goto L_0x0321
        L_0x031f:
            r67 = r77
        L_0x0321:
            if (r6 == 0) goto L_0x0325
            r6 = 0
            goto L_0x0327
        L_0x0325:
            r6 = r78
        L_0x0327:
            if (r1 == 0) goto L_0x032b
            r1 = 0
            goto L_0x032d
        L_0x032b:
            r1 = r79
        L_0x032d:
            if (r2 == 0) goto L_0x0331
            r2 = 0
            goto L_0x0333
        L_0x0331:
            r2 = r80
        L_0x0333:
            if (r4 == 0) goto L_0x0337
            r4 = 0
            goto L_0x0339
        L_0x0337:
            r4 = r81
        L_0x0339:
            if (r5 == 0) goto L_0x0342
            androidx.compose.ui.text.input.VisualTransformation$Companion r5 = androidx.compose.ui.text.input.VisualTransformation.Companion
            androidx.compose.ui.text.input.VisualTransformation r5 = r5.getNone()
            goto L_0x0344
        L_0x0342:
            r5 = r82
        L_0x0344:
            r10 = r8 & 4096(0x1000, float:5.74E-42)
            if (r10 == 0) goto L_0x0351
            androidx.compose.foundation.text.KeyboardOptions$Companion r10 = androidx.compose.foundation.text.KeyboardOptions.Companion
            androidx.compose.foundation.text.KeyboardOptions r10 = r10.getDefault()
            r11 = r11 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x0353
        L_0x0351:
            r10 = r83
        L_0x0353:
            r73 = r0
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
            r74 = r0
            r75 = r18
            r76 = r19
            r77 = r20
            r78 = r21
            r79 = r22
            r80 = r24
            r81 = r25
            r82 = r26
            r74.<init>(r75, r76, r77, r78, r79, r80, r81, r82)
            r11 = r11 & -7169(0xffffffffffffe3ff, float:NaN)
            goto L_0x0385
        L_0x0383:
            r0 = r84
        L_0x0385:
            if (r12 == 0) goto L_0x0389
            r12 = 0
            goto L_0x038b
        L_0x0389:
            r12 = r85
        L_0x038b:
            if (r16 == 0) goto L_0x0393
            r16 = 2147483647(0x7fffffff, float:NaN)
            r68 = r16
            goto L_0x0395
        L_0x0393:
            r68 = r86
        L_0x0395:
            r74 = r0
            if (r17 == 0) goto L_0x03ba
            r0 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r7.startReplaceableGroup(r0)
            java.lang.Object r0 = r7.rememberedValue()
            androidx.compose.runtime.Composer$Companion r16 = androidx.compose.runtime.Composer.Companion
            r75 = r1
            java.lang.Object r1 = r16.getEmpty()
            if (r0 != r1) goto L_0x03b4
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r7.updateRememberedValue(r0)
        L_0x03b4:
            r7.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = (androidx.compose.foundation.interaction.MutableInteractionSource) r0
            goto L_0x03be
        L_0x03ba:
            r75 = r1
            r0 = r87
        L_0x03be:
            r1 = r8 & r23
            if (r1 == 0) goto L_0x03f6
            androidx.compose.material.MaterialTheme r1 = androidx.compose.material.MaterialTheme.INSTANCE
            r76 = r0
            r0 = 6
            androidx.compose.material.Shapes r0 = r1.getShapes(r7, r0)
            androidx.compose.foundation.shape.CornerBasedShape r0 = r0.getSmall()
            r1 = 0
            r16 = 0
            androidx.compose.foundation.shape.CornerSize r17 = androidx.compose.foundation.shape.CornerSizeKt.getZeroCornerSize()
            androidx.compose.foundation.shape.CornerSize r18 = androidx.compose.foundation.shape.CornerSizeKt.getZeroCornerSize()
            r19 = 3
            r20 = 0
            r77 = r0
            r78 = r1
            r79 = r16
            r80 = r17
            r81 = r18
            r82 = r19
            r83 = r20
            androidx.compose.foundation.shape.CornerBasedShape r0 = androidx.compose.foundation.shape.CornerBasedShape.copy$default(r77, r78, r79, r80, r81, r82, r83)
            r1 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r1 = r1 & r11
            r11 = r1
            goto L_0x03fa
        L_0x03f6:
            r76 = r0
            r0 = r88
        L_0x03fa:
            r1 = 262144(0x40000, float:3.67342E-40)
            r1 = r1 & r8
            if (r1 == 0) goto L_0x0459
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
            androidx.compose.material.TextFieldColors r1 = r16.m1440textFieldColorsdx8h9Zs(r17, r19, r21, r23, r25, r27, r29, r31, r33, r35, r37, r39, r41, r43, r45, r47, r49, r51, r53, r55, r57, r59, r60, r61, r62, r63)
            r16 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r11 = r11 & r16
            r25 = r74
            r21 = r75
            r27 = r76
            r22 = r2
            r23 = r5
            r20 = r6
            r24 = r10
            r26 = r12
            r19 = r14
            r12 = r3
            r6 = r4
            r10 = r9
            r9 = r13
            r4 = r0
            r3 = r1
            r1 = r11
            goto L_0x0473
        L_0x0459:
            r25 = r74
            r21 = r75
            r27 = r76
            r22 = r2
            r23 = r5
            r20 = r6
            r24 = r10
            r1 = r11
            r26 = r12
            r19 = r14
            r12 = r3
            r6 = r4
            r10 = r9
            r9 = r13
            r3 = r89
            r4 = r0
        L_0x0473:
            r0 = r73
        L_0x0475:
            r7.endDefaults()
            r2 = -833027444(0xffffffffce59028c, float:-9.102057E8)
            r7.startReplaceableGroup(r2)
            long r13 = r9.m5056getColor0d7_KjU()
            androidx.compose.ui.graphics.Color$Companion r2 = androidx.compose.ui.graphics.Color.Companion
            long r16 = r2.m2955getUnspecified0d7_KjU()
            int r2 = (r13 > r16 ? 1 : (r13 == r16 ? 0 : -1))
            if (r2 == 0) goto L_0x048f
            r66 = 1
            goto L_0x0491
        L_0x048f:
            r66 = 0
        L_0x0491:
            if (r66 == 0) goto L_0x0494
            goto L_0x04ab
        L_0x0494:
            int r2 = r0 >> 9
            r2 = r2 & 14
            int r5 = r1 >> 21
            r5 = r5 & 112(0x70, float:1.57E-43)
            r2 = r2 | r5
            androidx.compose.runtime.State r2 = r3.textColor(r10, r7, r2)
            java.lang.Object r2 = r2.getValue()
            androidx.compose.ui.graphics.Color r2 = (androidx.compose.ui.graphics.Color) r2
            long r13 = r2.m2929unboximpl()
        L_0x04ab:
            r29 = r13
            r7.endReplaceableGroup()
            androidx.compose.ui.text.TextStyle r2 = new androidx.compose.ui.text.TextStyle
            r28 = r2
            r31 = 0
            r33 = 0
            r34 = 0
            r35 = 0
            r36 = 0
            r37 = 0
            r38 = 0
            r40 = 0
            r41 = 0
            r42 = 0
            r43 = 0
            r45 = 0
            r46 = 0
            r47 = 0
            r48 = 0
            r49 = 0
            r51 = 0
            r52 = 262142(0x3fffe, float:3.67339E-40)
            r53 = 0
            r28.<init>((long) r29, (long) r31, (androidx.compose.ui.text.font.FontWeight) r33, (androidx.compose.ui.text.font.FontStyle) r34, (androidx.compose.ui.text.font.FontSynthesis) r35, (androidx.compose.ui.text.font.FontFamily) r36, (java.lang.String) r37, (long) r38, (androidx.compose.ui.text.style.BaselineShift) r40, (androidx.compose.ui.text.style.TextGeometricTransform) r41, (androidx.compose.ui.text.intl.LocaleList) r42, (long) r43, (androidx.compose.ui.text.style.TextDecoration) r45, (androidx.compose.ui.graphics.Shadow) r46, (androidx.compose.ui.text.style.TextAlign) r47, (androidx.compose.ui.text.style.TextDirection) r48, (long) r49, (androidx.compose.ui.text.style.TextIndent) r51, (int) r52, (kotlin.jvm.internal.DefaultConstructorMarker) r53)
            androidx.compose.ui.text.TextStyle r5 = r9.merge((androidx.compose.ui.text.TextStyle) r2)
            androidx.compose.material.TextFieldDefaults r2 = androidx.compose.material.TextFieldDefaults.INSTANCE
            int r11 = r0 >> 9
            r11 = r11 & 14
            int r13 = r1 >> 21
            r14 = r13 & 112(0x70, float:1.57E-43)
            r11 = r11 | r14
            androidx.compose.runtime.State r11 = r3.backgroundColor(r10, r7, r11)
            java.lang.Object r11 = r11.getValue()
            androidx.compose.ui.graphics.Color r11 = (androidx.compose.ui.graphics.Color) r11
            r87 = r9
            long r8 = r11.m2929unboximpl()
            androidx.compose.ui.Modifier r8 = androidx.compose.foundation.BackgroundKt.m176backgroundbw27NRU(r12, r8, r4)
            r9 = 0
            r11 = 0
            r13 = 48
            r16 = 0
            r73 = r2
            r74 = r8
            r75 = r10
            r76 = r6
            r77 = r27
            r78 = r3
            r79 = r9
            r80 = r11
            r81 = r13
            r82 = r16
            androidx.compose.ui.Modifier r8 = androidx.compose.material.TextFieldDefaults.m1428indicatorLinegv0btCI$default(r73, r74, r75, r76, r77, r78, r79, r80, r81, r82)
            float r9 = r2.m1435getMinWidthD9Ej5fM()
            float r2 = r2.m1434getMinHeightD9Ej5fM()
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.m542defaultMinSizeVpY3zN4(r8, r9, r2)
            androidx.compose.ui.graphics.SolidColor r8 = new androidx.compose.ui.graphics.SolidColor
            r13 = r8
            r9 = r1 & 14
            r9 = r9 | r14
            androidx.compose.runtime.State r9 = r3.cursorColor(r6, r7, r9)
            java.lang.Object r9 = r9.getValue()
            androidx.compose.ui.graphics.Color r9 = (androidx.compose.ui.graphics.Color) r9
            r28 = r12
            long r11 = r9.m2929unboximpl()
            r9 = 0
            r8.<init>(r11, r9)
            r11 = 0
            androidx.compose.material.TextFieldKt$TextField$2 r8 = new androidx.compose.material.TextFieldKt$TextField$2
            r73 = r8
            r74 = r71
            r76 = r26
            r77 = r23
            r78 = r27
            r79 = r6
            r80 = r67
            r81 = r20
            r82 = r21
            r83 = r22
            r84 = r3
            r85 = r0
            r86 = r1
            r73.<init>(r74, r75, r76, r77, r78, r79, r80, r81, r82, r83, r84, r85, r86)
            r9 = -1994363936(0xffffffff89206be0, float:-1.9310022E-33)
            r12 = 1
            androidx.compose.runtime.internal.ComposableLambda r14 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r7, r9, r12, r8)
            r8 = r0 & 14
            r9 = r0 & 112(0x70, float:1.57E-43)
            r8 = r8 | r9
            r9 = r0 & 7168(0x1c00, float:1.0045E-41)
            r8 = r8 | r9
            r0 = r0 & r64
            r0 = r0 | r8
            int r8 = r1 << 12
            r9 = r8 & r65
            r0 = r0 | r9
            int r9 = androidx.compose.foundation.text.KeyboardActions.$stable
            int r9 = r9 << 21
            r0 = r0 | r9
            r9 = 29360128(0x1c00000, float:7.052966E-38)
            r9 = r9 & r8
            r0 = r0 | r9
            r9 = 234881024(0xe000000, float:1.5777218E-30)
            r9 = r9 & r8
            r0 = r0 | r9
            r9 = 1879048192(0x70000000, float:1.58456325E29)
            r8 = r8 & r9
            r16 = r0 | r8
            int r0 = r1 >> 3
            r0 = r0 & 14
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            int r1 = r1 >> 12
            r1 = r1 & 896(0x380, float:1.256E-42)
            r17 = r0 | r1
            r18 = 2048(0x800, float:2.87E-42)
            r0 = r71
            r1 = r72
            r29 = r3
            r3 = r10
            r30 = r4
            r4 = r19
            r31 = r6
            r6 = r24
            r32 = r7
            r7 = r25
            r8 = r26
            r33 = r87
            r9 = r68
            r34 = r10
            r10 = r23
            r12 = r27
            r15 = r32
            androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField((java.lang.String) r0, (kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit>) r1, (androidx.compose.ui.Modifier) r2, (boolean) r3, (boolean) r4, (androidx.compose.ui.text.TextStyle) r5, (androidx.compose.foundation.text.KeyboardOptions) r6, (androidx.compose.foundation.text.KeyboardActions) r7, (boolean) r8, (int) r9, (androidx.compose.ui.text.input.VisualTransformation) r10, (kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit>) r11, (androidx.compose.foundation.interaction.MutableInteractionSource) r12, (androidx.compose.ui.graphics.Brush) r13, (kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r14, (androidx.compose.runtime.Composer) r15, (int) r16, (int) r17, (int) r18)
            r5 = r19
            r8 = r20
            r9 = r21
            r10 = r22
            r12 = r23
            r13 = r24
            r14 = r25
            r15 = r26
            r17 = r27
            r3 = r28
            r19 = r29
            r18 = r30
            r11 = r31
            r6 = r33
            r4 = r34
            r7 = r67
            r16 = r68
        L_0x05e3:
            androidx.compose.runtime.ScopeUpdateScope r2 = r32.endRestartGroup()
            if (r2 != 0) goto L_0x05ea
            goto L_0x0605
        L_0x05ea:
            androidx.compose.material.TextFieldKt$TextField$3 r1 = new androidx.compose.material.TextFieldKt$TextField$3
            r0 = r1
            r69 = r1
            r1 = r71
            r70 = r2
            r2 = r72
            r20 = r91
            r21 = r92
            r22 = r93
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            r1 = r69
            r0 = r70
            r0.updateScope(r1)
        L_0x0605:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldKt.TextField(java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material.TextFieldColors, androidx.compose.runtime.Composer, int, int, int):void");
    }

    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    @Composable
    public static final void TextFieldLayout(@NotNull Modifier modifier, @NotNull Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Function2<? super Composer, ? super Integer, Unit> function22, @Nullable Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function3, @Nullable Function2<? super Composer, ? super Integer, Unit> function23, @Nullable Function2<? super Composer, ? super Integer, Unit> function24, boolean z11, float f11, @NotNull PaddingValues paddingValues, @Nullable Composer composer, int i11) {
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i21;
        int i22;
        Modifier modifier2 = modifier;
        Function2<? super Composer, ? super Integer, Unit> function25 = function2;
        Function2<? super Composer, ? super Integer, Unit> function26 = function22;
        Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function32 = function3;
        Function2<? super Composer, ? super Integer, Unit> function27 = function23;
        Function2<? super Composer, ? super Integer, Unit> function28 = function24;
        boolean z12 = z11;
        float f12 = f11;
        PaddingValues paddingValues2 = paddingValues;
        int i23 = i11;
        Intrinsics.checkNotNullParameter(modifier2, "modifier");
        Intrinsics.checkNotNullParameter(function25, "textField");
        Intrinsics.checkNotNullParameter(paddingValues2, "paddingValues");
        Composer startRestartGroup = composer.startRestartGroup(-2112507061);
        if ((i23 & 14) == 0) {
            if (startRestartGroup.changed((Object) modifier2)) {
                i22 = 4;
            } else {
                i22 = 2;
            }
            i12 = i22 | i23;
        } else {
            i12 = i23;
        }
        if ((i23 & 112) == 0) {
            if (startRestartGroup.changed((Object) function25)) {
                i21 = 32;
            } else {
                i21 = 16;
            }
            i12 |= i21;
        }
        if ((i23 & 896) == 0) {
            if (startRestartGroup.changed((Object) function26)) {
                i19 = 256;
            } else {
                i19 = 128;
            }
            i12 |= i19;
        }
        if ((i23 & 7168) == 0) {
            if (startRestartGroup.changed((Object) function32)) {
                i18 = 2048;
            } else {
                i18 = 1024;
            }
            i12 |= i18;
        }
        if ((57344 & i23) == 0) {
            if (startRestartGroup.changed((Object) function27)) {
                i17 = 16384;
            } else {
                i17 = 8192;
            }
            i12 |= i17;
        }
        if ((458752 & i23) == 0) {
            if (startRestartGroup.changed((Object) function28)) {
                i16 = 131072;
            } else {
                i16 = 65536;
            }
            i12 |= i16;
        }
        if ((3670016 & i23) == 0) {
            if (startRestartGroup.changed(z12)) {
                i15 = 1048576;
            } else {
                i15 = 524288;
            }
            i12 |= i15;
        }
        if ((29360128 & i23) == 0) {
            if (startRestartGroup.changed(f12)) {
                i14 = 8388608;
            } else {
                i14 = 4194304;
            }
            i12 |= i14;
        }
        if ((234881024 & i23) == 0) {
            if (startRestartGroup.changed((Object) paddingValues2)) {
                i13 = 67108864;
            } else {
                i13 = 33554432;
            }
            i12 |= i13;
        }
        if ((191739611 & i12) != 38347922 || !startRestartGroup.getSkipping()) {
            Boolean valueOf = Boolean.valueOf(z11);
            Float valueOf2 = Float.valueOf(f11);
            startRestartGroup.startReplaceableGroup(1618982084);
            boolean changed = startRestartGroup.changed((Object) valueOf) | startRestartGroup.changed((Object) valueOf2) | startRestartGroup.changed((Object) paddingValues2);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new TextFieldMeasurePolicy(z12, f12, paddingValues2);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            TextFieldMeasurePolicy textFieldMeasurePolicy = (TextFieldMeasurePolicy) rememberedValue;
            LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            startRestartGroup.startReplaceableGroup(-1323940314);
            Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection2 = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion = ComposeUiNode.Companion;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier);
            int i24 = ((((i12 << 3) & 112) << 9) & 7168) | 6;
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
            Updater.m2543setimpl(r22, textFieldMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m2543setimpl(r22, density, companion.getSetDensity());
            Updater.m2543setimpl(r22, layoutDirection2, companion.getSetLayoutDirection());
            Updater.m2543setimpl(r22, viewConfiguration, companion.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, Integer.valueOf((i24 >> 3) & 112));
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(642667778);
            if (((i24 >> 9) & 14 & 11) != 2 || !startRestartGroup.getSkipping()) {
                startRestartGroup.startReplaceableGroup(254816194);
                if (function27 != null) {
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
                    Composer r12 = Updater.m2536constructorimpl(startRestartGroup);
                    Updater.m2543setimpl(r12, rememberBoxMeasurePolicy, companion.getSetMeasurePolicy());
                    Updater.m2543setimpl(r12, density2, companion.getSetDensity());
                    Updater.m2543setimpl(r12, layoutDirection3, companion.getSetLayoutDirection());
                    Updater.m2543setimpl(r12, viewConfiguration2, companion.getSetViewConfiguration());
                    startRestartGroup.enableReusing();
                    materializerOf2.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
                    startRestartGroup.startReplaceableGroup(2058660585);
                    startRestartGroup.startReplaceableGroup(-2137368960);
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    startRestartGroup.startReplaceableGroup(822730659);
                    function27.invoke(startRestartGroup, Integer.valueOf((i12 >> 12) & 14));
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endNode();
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                }
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.startReplaceableGroup(254816479);
                if (function28 != null) {
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
                    Composer r14 = Updater.m2536constructorimpl(startRestartGroup);
                    Updater.m2543setimpl(r14, rememberBoxMeasurePolicy2, companion.getSetMeasurePolicy());
                    Updater.m2543setimpl(r14, density3, companion.getSetDensity());
                    Updater.m2543setimpl(r14, layoutDirection4, companion.getSetLayoutDirection());
                    Updater.m2543setimpl(r14, viewConfiguration3, companion.getSetViewConfiguration());
                    startRestartGroup.enableReusing();
                    materializerOf3.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
                    startRestartGroup.startReplaceableGroup(2058660585);
                    startRestartGroup.startReplaceableGroup(-2137368960);
                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                    startRestartGroup.startReplaceableGroup(-1007916070);
                    function28.invoke(startRestartGroup, Integer.valueOf((i12 >> 15) & 14));
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
                if (function27 != null) {
                    calculateStartPadding = Dp.m5478constructorimpl(RangesKt___RangesKt.coerceAtLeast(Dp.m5478constructorimpl(calculateStartPadding - TextFieldImplKt.getHorizontalIconPadding()), Dp.m5478constructorimpl((float) 0)));
                }
                float f13 = calculateStartPadding;
                if (function28 != null) {
                    calculateEndPadding = Dp.m5478constructorimpl(RangesKt___RangesKt.coerceAtLeast(Dp.m5478constructorimpl(calculateEndPadding - TextFieldImplKt.getHorizontalIconPadding()), Dp.m5478constructorimpl((float) 0)));
                }
                Modifier r13 = PaddingKt.m490paddingqDBjuR0$default(companion2, f13, 0.0f, calculateEndPadding, 0.0f, 10, (Object) null);
                startRestartGroup.startReplaceableGroup(254817490);
                if (function32 != null) {
                    function32.invoke(LayoutIdKt.layoutId(companion2, "Hint").then(r13), startRestartGroup, Integer.valueOf((i12 >> 6) & 112));
                }
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.startReplaceableGroup(254817619);
                if (function26 != null) {
                    Modifier then3 = LayoutIdKt.layoutId(companion2, "Label").then(r13);
                    startRestartGroup.startReplaceableGroup(733328855);
                    MeasurePolicy rememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, startRestartGroup, 0);
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
                    Composer r82 = Updater.m2536constructorimpl(startRestartGroup);
                    Updater.m2543setimpl(r82, rememberBoxMeasurePolicy3, companion.getSetMeasurePolicy());
                    Updater.m2543setimpl(r82, density4, companion.getSetDensity());
                    Updater.m2543setimpl(r82, layoutDirection5, companion.getSetLayoutDirection());
                    Updater.m2543setimpl(r82, viewConfiguration4, companion.getSetViewConfiguration());
                    startRestartGroup.enableReusing();
                    materializerOf4.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
                    startRestartGroup.startReplaceableGroup(2058660585);
                    startRestartGroup.startReplaceableGroup(-2137368960);
                    BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                    startRestartGroup.startReplaceableGroup(1319246300);
                    function26.invoke(startRestartGroup, Integer.valueOf((i12 >> 6) & 14));
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endNode();
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                }
                startRestartGroup.endReplaceableGroup();
                Modifier then4 = LayoutIdKt.layoutId(companion2, "TextField").then(r13);
                startRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy rememberBoxMeasurePolicy4 = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), true, startRestartGroup, 48);
                startRestartGroup.startReplaceableGroup(-1323940314);
                Density density5 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection6 = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration5 = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                Function0<ComposeUiNode> constructor5 = companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf5 = LayoutKt.materializerOf(then4);
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
                Composer r122 = Updater.m2536constructorimpl(startRestartGroup);
                Updater.m2543setimpl(r122, rememberBoxMeasurePolicy4, companion.getSetMeasurePolicy());
                Updater.m2543setimpl(r122, density5, companion.getSetDensity());
                Updater.m2543setimpl(r122, layoutDirection6, companion.getSetLayoutDirection());
                Updater.m2543setimpl(r122, viewConfiguration5, companion.getSetViewConfiguration());
                startRestartGroup.enableReusing();
                materializerOf5.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                startRestartGroup.startReplaceableGroup(-2137368960);
                BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                startRestartGroup.startReplaceableGroup(-2048931960);
                function2.invoke(startRestartGroup, Integer.valueOf((i12 >> 3) & 14));
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
            } else {
                startRestartGroup.skipToGroupEnd();
                Function2<? super Composer, ? super Integer, Unit> function29 = function2;
            }
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TextFieldKt$TextFieldLayout$2(modifier, function2, function22, function3, function23, function24, z11, f11, paddingValues, i11));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: calculateHeight-O3s9Psw  reason: not valid java name */
    public static final int m1452calculateHeightO3s9Psw(int i11, boolean z11, int i12, int i13, int i14, int i15, long j11, float f11, PaddingValues paddingValues) {
        float f12;
        float f13 = TextFieldTopPadding * f11;
        float r12 = paddingValues.m499calculateTopPaddingD9Ej5fM() * f11;
        float r11 = paddingValues.m496calculateBottomPaddingD9Ej5fM() * f11;
        int max = Math.max(i11, i15);
        if (z11) {
            f12 = ((float) i12) + f13 + ((float) max) + r11;
        } else {
            f12 = r12 + ((float) max) + r11;
        }
        return Math.max(MathKt__MathJVMKt.roundToInt(f12), Math.max(Math.max(i13, i14), Constraints.m5423getMinHeightimpl(j11)));
    }

    /* access modifiers changed from: private */
    /* renamed from: calculateWidth-VsPV1Ek  reason: not valid java name */
    public static final int m1453calculateWidthVsPV1Ek(int i11, int i12, int i13, int i14, int i15, long j11) {
        return Math.max(i11 + Math.max(i13, Math.max(i14, i15)) + i12, Constraints.m5424getMinWidthimpl(j11));
    }

    @NotNull
    public static final Modifier drawIndicatorLine(@NotNull Modifier modifier, @NotNull BorderStroke borderStroke) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(borderStroke, "indicatorBorder");
        return DrawModifierKt.drawWithContent(modifier, new TextFieldKt$drawIndicatorLine$1(borderStroke.m190getWidthD9Ej5fM(), borderStroke));
    }

    public static final float getFirstBaselineOffset() {
        return FirstBaselineOffset;
    }

    public static final float getTextFieldBottomPadding() {
        return TextFieldBottomPadding;
    }

    public static final float getTextFieldTopPadding() {
        return TextFieldTopPadding;
    }

    /* access modifiers changed from: private */
    public static final void placeWithLabel(Placeable.PlacementScope placementScope, int i11, int i12, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, Placeable placeable5, boolean z11, int i13, int i14, float f11, float f12) {
        int i15;
        int i16 = i12;
        if (placeable4 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable4, 0, Alignment.Companion.getCenterVertically().align(placeable4.getHeight(), i16), 0.0f, 4, (Object) null);
        }
        if (placeable5 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable5, i11 - placeable5.getWidth(), Alignment.Companion.getCenterVertically().align(placeable5.getHeight(), i16), 0.0f, 4, (Object) null);
        }
        if (placeable2 != null) {
            if (z11) {
                i15 = Alignment.Companion.getCenterVertically().align(placeable2.getHeight(), i16);
            } else {
                i15 = MathKt__MathJVMKt.roundToInt(TextFieldImplKt.getTextFieldPadding() * f12);
            }
            int roundToInt = i15 - MathKt__MathJVMKt.roundToInt(((float) (i15 - i13)) * f11);
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, TextFieldImplKt.widthOrZero(placeable4), roundToInt, 0.0f, 4, (Object) null);
        }
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, TextFieldImplKt.widthOrZero(placeable4), i14, 0.0f, 4, (Object) null);
        if (placeable3 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, TextFieldImplKt.widthOrZero(placeable4), i14, 0.0f, 4, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public static final void placeWithoutLabel(Placeable.PlacementScope placementScope, int i11, int i12, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, boolean z11, float f11, PaddingValues paddingValues) {
        int i13;
        int i14 = i12;
        int roundToInt = MathKt__MathJVMKt.roundToInt(paddingValues.m499calculateTopPaddingD9Ej5fM() * f11);
        if (placeable3 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, 0, Alignment.Companion.getCenterVertically().align(placeable3.getHeight(), i14), 0.0f, 4, (Object) null);
        }
        if (placeable4 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable4, i11 - placeable4.getWidth(), Alignment.Companion.getCenterVertically().align(placeable4.getHeight(), i14), 0.0f, 4, (Object) null);
        }
        if (z11) {
            i13 = Alignment.Companion.getCenterVertically().align(placeable.getHeight(), i14);
        } else {
            i13 = roundToInt;
        }
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, TextFieldImplKt.widthOrZero(placeable3), i13, 0.0f, 4, (Object) null);
        if (placeable2 != null) {
            if (z11) {
                roundToInt = Alignment.Companion.getCenterVertically().align(placeable2.getHeight(), i14);
            }
            Placeable.PlacementScope placementScope2 = placementScope;
            Placeable placeable5 = placeable2;
            Placeable.PlacementScope.placeRelative$default(placementScope2, placeable5, TextFieldImplKt.widthOrZero(placeable3), roundToInt, 0.0f, 4, (Object) null);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:140:0x01ae, code lost:
        if (r7.changed((java.lang.Object) r84) != false) goto L_0x01b5;
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
    /* JADX WARNING: Removed duplicated region for block: B:291:0x05c5  */
    /* JADX WARNING: Removed duplicated region for block: B:293:? A[RETURN, SYNTHETIC] */
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
    public static final void TextField(@org.jetbrains.annotations.NotNull androidx.compose.ui.text.input.TextFieldValue r71, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit> r72, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r73, boolean r74, boolean r75, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.TextStyle r76, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r77, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r78, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r79, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r80, boolean r81, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.input.VisualTransformation r82, @org.jetbrains.annotations.Nullable androidx.compose.foundation.text.KeyboardOptions r83, @org.jetbrains.annotations.Nullable androidx.compose.foundation.text.KeyboardActions r84, boolean r85, int r86, @org.jetbrains.annotations.Nullable androidx.compose.foundation.interaction.MutableInteractionSource r87, @org.jetbrains.annotations.Nullable androidx.compose.ui.graphics.Shape r88, @org.jetbrains.annotations.Nullable androidx.compose.material.TextFieldColors r89, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r90, int r91, int r92, int r93) {
        /*
            r15 = r71
            r12 = r72
            r10 = r91
            r9 = r92
            r8 = r93
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "onValueChange"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r0 = -1576622884(0xffffffffa206a4dc, float:-1.8247662E-18)
            r1 = r90
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
            r13 = r73
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
            r13 = r73
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
            r1 = r74
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
            r1 = r74
        L_0x0088:
            r18 = r8 & 16
            r19 = 16384(0x4000, float:2.2959E-41)
            r64 = 57344(0xe000, float:8.0356E-41)
            r20 = 8192(0x2000, float:1.14794E-41)
            if (r18 == 0) goto L_0x0098
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            r2 = r75
            goto L_0x00ab
        L_0x0098:
            r21 = r10 & r64
            r2 = r75
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
            r4 = r76
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
            r4 = r76
        L_0x00c9:
            r24 = r8 & 64
            r65 = 3670016(0x380000, float:5.142788E-39)
            if (r24 == 0) goto L_0x00d6
            r25 = 1572864(0x180000, float:2.204052E-39)
            r0 = r0 | r25
            r5 = r77
            goto L_0x00e9
        L_0x00d6:
            r25 = r10 & r65
            r5 = r77
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
            r11 = r78
            goto L_0x0109
        L_0x00f4:
            r27 = 29360128(0x1c00000, float:7.052966E-38)
            r27 = r10 & r27
            r11 = r78
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
            r2 = r79
            goto L_0x0129
        L_0x0114:
            r28 = 234881024(0xe000000, float:1.5777218E-30)
            r28 = r10 & r28
            r2 = r79
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
            r4 = r80
            goto L_0x0149
        L_0x0134:
            r28 = 1879048192(0x70000000, float:1.58456325E29)
            r28 = r10 & r28
            r4 = r80
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
            r5 = r81
            goto L_0x0168
        L_0x0152:
            r28 = r9 & 14
            r5 = r81
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
            r11 = r82
            goto L_0x0184
        L_0x0171:
            r28 = r9 & 112(0x70, float:1.57E-43)
            r11 = r82
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
            r11 = r83
            boolean r22 = r7.changed((java.lang.Object) r11)
            if (r22 == 0) goto L_0x0199
            r26 = 256(0x100, float:3.59E-43)
            goto L_0x019b
        L_0x0197:
            r11 = r83
        L_0x0199:
            r26 = 128(0x80, float:1.794E-43)
        L_0x019b:
            r21 = r21 | r26
            goto L_0x01a0
        L_0x019e:
            r11 = r83
        L_0x01a0:
            r11 = r9 & 7168(0x1c00, float:1.0045E-41)
            if (r11 != 0) goto L_0x01b8
            r11 = r8 & 8192(0x2000, float:1.14794E-41)
            if (r11 != 0) goto L_0x01b1
            r11 = r84
            boolean r22 = r7.changed((java.lang.Object) r11)
            if (r22 == 0) goto L_0x01b3
            goto L_0x01b5
        L_0x01b1:
            r11 = r84
        L_0x01b3:
            r16 = r17
        L_0x01b5:
            r21 = r21 | r16
            goto L_0x01ba
        L_0x01b8:
            r11 = r84
        L_0x01ba:
            r11 = r21
            r12 = r8 & 16384(0x4000, float:2.2959E-41)
            if (r12 == 0) goto L_0x01c5
            r11 = r11 | 24576(0x6000, float:3.4438E-41)
            r13 = r85
            goto L_0x01d6
        L_0x01c5:
            r16 = r9 & r64
            r13 = r85
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
            r13 = r86
            goto L_0x01f9
        L_0x01e4:
            r17 = 458752(0x70000, float:6.42848E-40)
            r17 = r9 & r17
            r13 = r86
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
            r13 = r87
            goto L_0x0219
        L_0x0206:
            r19 = r9 & r65
            r13 = r87
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
            r13 = r88
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
            r13 = r88
        L_0x0235:
            r19 = 234881024(0xe000000, float:1.5777218E-30)
            r19 = r9 & r19
            if (r19 != 0) goto L_0x0251
            r19 = 262144(0x40000, float:3.67342E-40)
            r19 = r8 & r19
            r9 = r89
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
            r9 = r89
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
            r3 = r73
            r4 = r74
            r5 = r75
            r6 = r76
            r8 = r78
            r9 = r79
            r10 = r80
            r11 = r81
            r12 = r82
            r13 = r83
            r14 = r84
            r15 = r85
            r16 = r86
            r17 = r87
            r18 = r88
            r19 = r89
            r32 = r7
            r7 = r77
            goto L_0x05be
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
            r12 = r73
            r10 = r74
            r19 = r75
            r9 = r76
            r67 = r77
            r20 = r78
            r21 = r79
            r22 = r80
            r6 = r81
            r23 = r82
            r24 = r83
            r25 = r84
            r26 = r85
            r68 = r86
            r27 = r87
            r4 = r88
            r3 = r89
            r1 = r11
            goto L_0x0450
        L_0x02f1:
            if (r3 == 0) goto L_0x02f6
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            goto L_0x02f8
        L_0x02f6:
            r3 = r73
        L_0x02f8:
            if (r14 == 0) goto L_0x02fc
            r9 = 1
            goto L_0x02fe
        L_0x02fc:
            r9 = r74
        L_0x02fe:
            if (r18 == 0) goto L_0x0302
            r14 = 0
            goto L_0x0304
        L_0x0302:
            r14 = r75
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
            r13 = r76
        L_0x031a:
            if (r24 == 0) goto L_0x031f
            r67 = 0
            goto L_0x0321
        L_0x031f:
            r67 = r77
        L_0x0321:
            if (r6 == 0) goto L_0x0325
            r6 = 0
            goto L_0x0327
        L_0x0325:
            r6 = r78
        L_0x0327:
            if (r1 == 0) goto L_0x032b
            r1 = 0
            goto L_0x032d
        L_0x032b:
            r1 = r79
        L_0x032d:
            if (r2 == 0) goto L_0x0331
            r2 = 0
            goto L_0x0333
        L_0x0331:
            r2 = r80
        L_0x0333:
            if (r4 == 0) goto L_0x0337
            r4 = 0
            goto L_0x0339
        L_0x0337:
            r4 = r81
        L_0x0339:
            if (r5 == 0) goto L_0x0342
            androidx.compose.ui.text.input.VisualTransformation$Companion r5 = androidx.compose.ui.text.input.VisualTransformation.Companion
            androidx.compose.ui.text.input.VisualTransformation r5 = r5.getNone()
            goto L_0x0344
        L_0x0342:
            r5 = r82
        L_0x0344:
            r10 = r8 & 4096(0x1000, float:5.74E-42)
            if (r10 == 0) goto L_0x0351
            androidx.compose.foundation.text.KeyboardOptions$Companion r10 = androidx.compose.foundation.text.KeyboardOptions.Companion
            androidx.compose.foundation.text.KeyboardOptions r10 = r10.getDefault()
            r11 = r11 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x0353
        L_0x0351:
            r10 = r83
        L_0x0353:
            r73 = r0
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
            r74 = r0
            r75 = r18
            r76 = r19
            r77 = r20
            r78 = r21
            r79 = r22
            r80 = r24
            r81 = r25
            r82 = r26
            r74.<init>(r75, r76, r77, r78, r79, r80, r81, r82)
            r11 = r11 & -7169(0xffffffffffffe3ff, float:NaN)
            goto L_0x0385
        L_0x0383:
            r0 = r84
        L_0x0385:
            if (r12 == 0) goto L_0x0389
            r12 = 0
            goto L_0x038b
        L_0x0389:
            r12 = r85
        L_0x038b:
            if (r16 == 0) goto L_0x0393
            r16 = 2147483647(0x7fffffff, float:NaN)
            r68 = r16
            goto L_0x0395
        L_0x0393:
            r68 = r86
        L_0x0395:
            r74 = r0
            if (r17 == 0) goto L_0x03ba
            r0 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r7.startReplaceableGroup(r0)
            java.lang.Object r0 = r7.rememberedValue()
            androidx.compose.runtime.Composer$Companion r16 = androidx.compose.runtime.Composer.Companion
            r75 = r1
            java.lang.Object r1 = r16.getEmpty()
            if (r0 != r1) goto L_0x03b4
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r7.updateRememberedValue(r0)
        L_0x03b4:
            r7.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = (androidx.compose.foundation.interaction.MutableInteractionSource) r0
            goto L_0x03be
        L_0x03ba:
            r75 = r1
            r0 = r87
        L_0x03be:
            r1 = r8 & r23
            if (r1 == 0) goto L_0x03d1
            androidx.compose.material.TextFieldDefaults r1 = androidx.compose.material.TextFieldDefaults.INSTANCE
            r76 = r0
            r0 = 6
            androidx.compose.ui.graphics.Shape r0 = r1.getTextFieldShape(r7, r0)
            r1 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r1 = r1 & r11
            r11 = r1
            goto L_0x03d5
        L_0x03d1:
            r76 = r0
            r0 = r88
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
            androidx.compose.material.TextFieldColors r1 = r16.m1440textFieldColorsdx8h9Zs(r17, r19, r21, r23, r25, r27, r29, r31, r33, r35, r37, r39, r41, r43, r45, r47, r49, r51, r53, r55, r57, r59, r60, r61, r62, r63)
            r16 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r11 = r11 & r16
            r25 = r74
            r21 = r75
            r27 = r76
            r22 = r2
            r23 = r5
            r20 = r6
            r24 = r10
            r26 = r12
            r19 = r14
            r12 = r3
            r6 = r4
            r10 = r9
            r9 = r13
            r4 = r0
            r3 = r1
            r1 = r11
            goto L_0x044e
        L_0x0434:
            r25 = r74
            r21 = r75
            r27 = r76
            r22 = r2
            r23 = r5
            r20 = r6
            r24 = r10
            r1 = r11
            r26 = r12
            r19 = r14
            r12 = r3
            r6 = r4
            r10 = r9
            r9 = r13
            r3 = r89
            r4 = r0
        L_0x044e:
            r0 = r73
        L_0x0450:
            r7.endDefaults()
            r2 = -833020145(0xffffffffce591f0f, float:-9.1067283E8)
            r7.startReplaceableGroup(r2)
            long r13 = r9.m5056getColor0d7_KjU()
            androidx.compose.ui.graphics.Color$Companion r2 = androidx.compose.ui.graphics.Color.Companion
            long r16 = r2.m2955getUnspecified0d7_KjU()
            int r2 = (r13 > r16 ? 1 : (r13 == r16 ? 0 : -1))
            if (r2 == 0) goto L_0x046a
            r66 = 1
            goto L_0x046c
        L_0x046a:
            r66 = 0
        L_0x046c:
            if (r66 == 0) goto L_0x046f
            goto L_0x0486
        L_0x046f:
            int r2 = r0 >> 9
            r2 = r2 & 14
            int r5 = r1 >> 21
            r5 = r5 & 112(0x70, float:1.57E-43)
            r2 = r2 | r5
            androidx.compose.runtime.State r2 = r3.textColor(r10, r7, r2)
            java.lang.Object r2 = r2.getValue()
            androidx.compose.ui.graphics.Color r2 = (androidx.compose.ui.graphics.Color) r2
            long r13 = r2.m2929unboximpl()
        L_0x0486:
            r29 = r13
            r7.endReplaceableGroup()
            androidx.compose.ui.text.TextStyle r2 = new androidx.compose.ui.text.TextStyle
            r28 = r2
            r31 = 0
            r33 = 0
            r34 = 0
            r35 = 0
            r36 = 0
            r37 = 0
            r38 = 0
            r40 = 0
            r41 = 0
            r42 = 0
            r43 = 0
            r45 = 0
            r46 = 0
            r47 = 0
            r48 = 0
            r49 = 0
            r51 = 0
            r52 = 262142(0x3fffe, float:3.67339E-40)
            r53 = 0
            r28.<init>((long) r29, (long) r31, (androidx.compose.ui.text.font.FontWeight) r33, (androidx.compose.ui.text.font.FontStyle) r34, (androidx.compose.ui.text.font.FontSynthesis) r35, (androidx.compose.ui.text.font.FontFamily) r36, (java.lang.String) r37, (long) r38, (androidx.compose.ui.text.style.BaselineShift) r40, (androidx.compose.ui.text.style.TextGeometricTransform) r41, (androidx.compose.ui.text.intl.LocaleList) r42, (long) r43, (androidx.compose.ui.text.style.TextDecoration) r45, (androidx.compose.ui.graphics.Shadow) r46, (androidx.compose.ui.text.style.TextAlign) r47, (androidx.compose.ui.text.style.TextDirection) r48, (long) r49, (androidx.compose.ui.text.style.TextIndent) r51, (int) r52, (kotlin.jvm.internal.DefaultConstructorMarker) r53)
            androidx.compose.ui.text.TextStyle r5 = r9.merge((androidx.compose.ui.text.TextStyle) r2)
            androidx.compose.material.TextFieldDefaults r2 = androidx.compose.material.TextFieldDefaults.INSTANCE
            int r11 = r0 >> 9
            r11 = r11 & 14
            int r13 = r1 >> 21
            r14 = r13 & 112(0x70, float:1.57E-43)
            r11 = r11 | r14
            androidx.compose.runtime.State r11 = r3.backgroundColor(r10, r7, r11)
            java.lang.Object r11 = r11.getValue()
            androidx.compose.ui.graphics.Color r11 = (androidx.compose.ui.graphics.Color) r11
            r87 = r9
            long r8 = r11.m2929unboximpl()
            androidx.compose.ui.Modifier r8 = androidx.compose.foundation.BackgroundKt.m176backgroundbw27NRU(r12, r8, r4)
            r9 = 0
            r11 = 0
            r13 = 48
            r16 = 0
            r73 = r2
            r74 = r8
            r75 = r10
            r76 = r6
            r77 = r27
            r78 = r3
            r79 = r9
            r80 = r11
            r81 = r13
            r82 = r16
            androidx.compose.ui.Modifier r8 = androidx.compose.material.TextFieldDefaults.m1428indicatorLinegv0btCI$default(r73, r74, r75, r76, r77, r78, r79, r80, r81, r82)
            float r9 = r2.m1435getMinWidthD9Ej5fM()
            float r2 = r2.m1434getMinHeightD9Ej5fM()
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.m542defaultMinSizeVpY3zN4(r8, r9, r2)
            androidx.compose.ui.graphics.SolidColor r8 = new androidx.compose.ui.graphics.SolidColor
            r13 = r8
            r9 = r1 & 14
            r9 = r9 | r14
            androidx.compose.runtime.State r9 = r3.cursorColor(r6, r7, r9)
            java.lang.Object r9 = r9.getValue()
            androidx.compose.ui.graphics.Color r9 = (androidx.compose.ui.graphics.Color) r9
            r28 = r12
            long r11 = r9.m2929unboximpl()
            r9 = 0
            r8.<init>(r11, r9)
            r11 = 0
            androidx.compose.material.TextFieldKt$TextField$5 r8 = new androidx.compose.material.TextFieldKt$TextField$5
            r73 = r8
            r74 = r71
            r76 = r26
            r77 = r23
            r78 = r27
            r79 = r6
            r80 = r67
            r81 = r20
            r82 = r21
            r83 = r22
            r84 = r3
            r85 = r0
            r86 = r1
            r73.<init>(r74, r75, r76, r77, r78, r79, r80, r81, r82, r83, r84, r85, r86)
            r9 = -2078585677(0xffffffff841b4cb3, float:-1.8255381E-36)
            r12 = 1
            androidx.compose.runtime.internal.ComposableLambda r14 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r7, r9, r12, r8)
            r8 = r0 & 14
            r9 = r0 & 112(0x70, float:1.57E-43)
            r8 = r8 | r9
            r9 = r0 & 7168(0x1c00, float:1.0045E-41)
            r8 = r8 | r9
            r0 = r0 & r64
            r0 = r0 | r8
            int r8 = r1 << 12
            r9 = r8 & r65
            r0 = r0 | r9
            int r9 = androidx.compose.foundation.text.KeyboardActions.$stable
            int r9 = r9 << 21
            r0 = r0 | r9
            r9 = 29360128(0x1c00000, float:7.052966E-38)
            r9 = r9 & r8
            r0 = r0 | r9
            r9 = 234881024(0xe000000, float:1.5777218E-30)
            r9 = r9 & r8
            r0 = r0 | r9
            r9 = 1879048192(0x70000000, float:1.58456325E29)
            r8 = r8 & r9
            r16 = r0 | r8
            int r0 = r1 >> 3
            r0 = r0 & 14
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            int r1 = r1 >> 12
            r1 = r1 & 896(0x380, float:1.256E-42)
            r17 = r0 | r1
            r18 = 2048(0x800, float:2.87E-42)
            r0 = r71
            r1 = r72
            r29 = r3
            r3 = r10
            r30 = r4
            r4 = r19
            r31 = r6
            r6 = r24
            r32 = r7
            r7 = r25
            r8 = r26
            r33 = r87
            r9 = r68
            r34 = r10
            r10 = r23
            r12 = r27
            r15 = r32
            androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField((androidx.compose.ui.text.input.TextFieldValue) r0, (kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit>) r1, (androidx.compose.ui.Modifier) r2, (boolean) r3, (boolean) r4, (androidx.compose.ui.text.TextStyle) r5, (androidx.compose.foundation.text.KeyboardOptions) r6, (androidx.compose.foundation.text.KeyboardActions) r7, (boolean) r8, (int) r9, (androidx.compose.ui.text.input.VisualTransformation) r10, (kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit>) r11, (androidx.compose.foundation.interaction.MutableInteractionSource) r12, (androidx.compose.ui.graphics.Brush) r13, (kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r14, (androidx.compose.runtime.Composer) r15, (int) r16, (int) r17, (int) r18)
            r5 = r19
            r8 = r20
            r9 = r21
            r10 = r22
            r12 = r23
            r13 = r24
            r14 = r25
            r15 = r26
            r17 = r27
            r3 = r28
            r19 = r29
            r18 = r30
            r11 = r31
            r6 = r33
            r4 = r34
            r7 = r67
            r16 = r68
        L_0x05be:
            androidx.compose.runtime.ScopeUpdateScope r2 = r32.endRestartGroup()
            if (r2 != 0) goto L_0x05c5
            goto L_0x05e0
        L_0x05c5:
            androidx.compose.material.TextFieldKt$TextField$6 r1 = new androidx.compose.material.TextFieldKt$TextField$6
            r0 = r1
            r69 = r1
            r1 = r71
            r70 = r2
            r2 = r72
            r20 = r91
            r21 = r92
            r22 = r93
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            r1 = r69
            r0 = r70
            r0.updateScope(r1)
        L_0x05e0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldKt.TextField(androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material.TextFieldColors, androidx.compose.runtime.Composer, int, int, int):void");
    }
}
