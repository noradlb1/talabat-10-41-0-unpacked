package androidx.compose.ui.window;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\\\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001aX\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00060\f¢\u0006\u0002\b\u0010H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012\u001aD\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00060\f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0015\u001a(\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00022\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00060\f¢\u0006\u0002\b\u0010H\u0001¢\u0006\u0002\u0010\u0018\u001a+\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u001b2\u0013\b\b\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00060\f¢\u0006\u0002\b\u0010H\b¢\u0006\u0002\u0010\u001c\u001a\u001a\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0002\u001a\f\u0010\"\u001a\u00020\u001e*\u00020 H\u0000\u001a\f\u0010#\u001a\u00020$*\u00020%H\u0002\"\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006&"}, d2 = {"LocalPopupTestTag", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "", "getLocalPopupTestTag", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "Popup", "", "alignment", "Landroidx/compose/ui/Alignment;", "offset", "Landroidx/compose/ui/unit/IntOffset;", "onDismissRequest", "Lkotlin/Function0;", "properties", "Landroidx/compose/ui/window/PopupProperties;", "content", "Landroidx/compose/runtime/Composable;", "Popup-K5zGePQ", "(Landroidx/compose/ui/Alignment;JLkotlin/jvm/functions/Function0;Landroidx/compose/ui/window/PopupProperties;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "popupPositionProvider", "Landroidx/compose/ui/window/PopupPositionProvider;", "(Landroidx/compose/ui/window/PopupPositionProvider;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/window/PopupProperties;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "PopupTestTag", "tag", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "SimpleStack", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "isPopupLayout", "", "view", "Landroid/view/View;", "testTag", "isFlagSecureEnabled", "toIntBounds", "Landroidx/compose/ui/unit/IntRect;", "Landroid/graphics/Rect;", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class AndroidPopup_androidKt {
    @NotNull
    private static final ProvidableCompositionLocal<String> LocalPopupTestTag = CompositionLocalKt.compositionLocalOf$default((SnapshotMutationPolicy) null, AndroidPopup_androidKt$LocalPopupTestTag$1.INSTANCE, 1, (Object) null);

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0188  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x020c  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0218  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x021c  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0272  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0280  */
    /* JADX WARNING: Removed duplicated region for block: B:83:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void Popup(@org.jetbrains.annotations.NotNull androidx.compose.ui.window.PopupPositionProvider r27, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function0<kotlin.Unit> r28, @org.jetbrains.annotations.Nullable androidx.compose.ui.window.PopupProperties r29, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r31, int r32, int r33) {
        /*
            r11 = r27
            r12 = r30
            r13 = r32
            java.lang.String r0 = "popupPositionProvider"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r0 = -830247068(0xffffffffce836f64, float:-1.1025577E9)
            r1 = r31
            androidx.compose.runtime.Composer r14 = r1.startRestartGroup(r0)
            r1 = r33 & 1
            if (r1 == 0) goto L_0x0020
            r1 = r13 | 6
            goto L_0x0030
        L_0x0020:
            r1 = r13 & 14
            if (r1 != 0) goto L_0x002f
            boolean r1 = r14.changed((java.lang.Object) r11)
            if (r1 == 0) goto L_0x002c
            r1 = 4
            goto L_0x002d
        L_0x002c:
            r1 = 2
        L_0x002d:
            r1 = r1 | r13
            goto L_0x0030
        L_0x002f:
            r1 = r13
        L_0x0030:
            r2 = r33 & 2
            if (r2 == 0) goto L_0x0037
            r1 = r1 | 48
            goto L_0x004a
        L_0x0037:
            r3 = r13 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x004a
            r3 = r28
            boolean r4 = r14.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0046
            r4 = 32
            goto L_0x0048
        L_0x0046:
            r4 = 16
        L_0x0048:
            r1 = r1 | r4
            goto L_0x004c
        L_0x004a:
            r3 = r28
        L_0x004c:
            r4 = r13 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x0065
            r4 = r33 & 4
            if (r4 != 0) goto L_0x005f
            r4 = r29
            boolean r5 = r14.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0061
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x0063
        L_0x005f:
            r4 = r29
        L_0x0061:
            r5 = 128(0x80, float:1.794E-43)
        L_0x0063:
            r1 = r1 | r5
            goto L_0x0067
        L_0x0065:
            r4 = r29
        L_0x0067:
            r5 = r33 & 8
            if (r5 == 0) goto L_0x006e
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x007e
        L_0x006e:
            r5 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r5 != 0) goto L_0x007e
            boolean r5 = r14.changed((java.lang.Object) r12)
            if (r5 == 0) goto L_0x007b
            r5 = 2048(0x800, float:2.87E-42)
            goto L_0x007d
        L_0x007b:
            r5 = 1024(0x400, float:1.435E-42)
        L_0x007d:
            r1 = r1 | r5
        L_0x007e:
            r5 = r1 & 5851(0x16db, float:8.199E-42)
            r6 = 1170(0x492, float:1.64E-42)
            if (r5 != r6) goto L_0x0092
            boolean r5 = r14.getSkipping()
            if (r5 != 0) goto L_0x008b
            goto L_0x0092
        L_0x008b:
            r14.skipToGroupEnd()
            r2 = r3
            r3 = r4
            goto L_0x0279
        L_0x0092:
            r14.startDefaults()
            r5 = r13 & 1
            if (r5 == 0) goto L_0x00aa
            boolean r5 = r14.getDefaultsInvalid()
            if (r5 == 0) goto L_0x00a0
            goto L_0x00aa
        L_0x00a0:
            r14.skipToGroupEnd()
            r2 = r33 & 4
            if (r2 == 0) goto L_0x00d0
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x00d0
        L_0x00aa:
            if (r2 == 0) goto L_0x00ad
            r3 = 0
        L_0x00ad:
            r2 = r33 & 4
            if (r2 == 0) goto L_0x00d0
            androidx.compose.ui.window.PopupProperties r2 = new androidx.compose.ui.window.PopupProperties
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 63
            r24 = 0
            r16 = r2
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24)
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
            r10 = r1
            r17 = r2
            r16 = r3
            goto L_0x00d5
        L_0x00d0:
            r10 = r1
            r16 = r3
            r17 = r4
        L_0x00d5:
            r14.endDefaults()
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x00e4
            r1 = -1
            java.lang.String r2 = "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:219)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r10, r1, r2)
        L_0x00e4:
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalView()
            java.lang.Object r0 = r14.consume(r0)
            r8 = r0
            android.view.View r8 = (android.view.View) r8
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r0 = r14.consume(r0)
            r9 = r0
            androidx.compose.ui.unit.Density r9 = (androidx.compose.ui.unit.Density) r9
            androidx.compose.runtime.ProvidableCompositionLocal<java.lang.String> r0 = LocalPopupTestTag
            java.lang.Object r0 = r14.consume(r0)
            r18 = r0
            java.lang.String r18 = (java.lang.String) r18
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            java.lang.Object r0 = r14.consume(r0)
            androidx.compose.ui.unit.LayoutDirection r0 = (androidx.compose.ui.unit.LayoutDirection) r0
            r7 = 0
            androidx.compose.runtime.CompositionContext r6 = androidx.compose.runtime.ComposablesKt.rememberCompositionContext(r14, r7)
            int r1 = r10 >> 9
            r1 = r1 & 14
            androidx.compose.runtime.State r5 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r12, r14, r1)
            java.lang.Object[] r1 = new java.lang.Object[r7]
            r2 = 0
            r3 = 0
            androidx.compose.ui.window.AndroidPopup_androidKt$Popup$popupId$1 r4 = androidx.compose.ui.window.AndroidPopup_androidKt$Popup$popupId$1.INSTANCE
            r19 = 3080(0xc08, float:4.316E-42)
            r20 = 6
            r15 = r5
            r5 = r14
            r25 = r6
            r6 = r19
            r7 = r20
            java.lang.Object r1 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r1, r2, (java.lang.String) r3, r4, (androidx.compose.runtime.Composer) r5, (int) r6, (int) r7)
            r7 = r1
            java.util.UUID r7 = (java.util.UUID) r7
            r1 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r14.startReplaceableGroup(r1)
            java.lang.Object r1 = r14.rememberedValue()
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r1 != r2) goto L_0x0188
            androidx.compose.ui.window.PopupLayout r6 = new androidx.compose.ui.window.PopupLayout
            java.lang.String r1 = "popupId"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r1)
            r19 = 0
            r20 = 128(0x80, float:1.794E-43)
            r21 = 0
            r5 = r0
            r0 = r6
            r1 = r16
            r2 = r17
            r3 = r18
            r4 = r8
            r8 = r5
            r5 = r9
            r9 = r6
            r6 = r27
            r28 = r8
            r8 = r19
            r26 = r9
            r9 = r20
            r19 = r10
            r10 = r21
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            androidx.compose.ui.window.AndroidPopup_androidKt$Popup$popupLayout$1$1$1 r0 = new androidx.compose.ui.window.AndroidPopup_androidKt$Popup$popupLayout$1$1$1
            r1 = r26
            r0.<init>(r1, r15)
            r2 = 1302892335(0x4da88f2f, float:3.53494496E8)
            r3 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambdaInstance(r2, r3, r0)
            r2 = r25
            r1.setContent(r2, r0)
            r14.updateRememberedValue(r1)
            goto L_0x018c
        L_0x0188:
            r28 = r0
            r19 = r10
        L_0x018c:
            r14.endReplaceableGroup()
            androidx.compose.ui.window.PopupLayout r1 = (androidx.compose.ui.window.PopupLayout) r1
            androidx.compose.ui.window.AndroidPopup_androidKt$Popup$2 r0 = new androidx.compose.ui.window.AndroidPopup_androidKt$Popup$2
            r4 = r0
            r5 = r1
            r6 = r16
            r7 = r17
            r8 = r18
            r9 = r28
            r4.<init>(r5, r6, r7, r8, r9)
            r2 = 8
            androidx.compose.runtime.EffectsKt.DisposableEffect((java.lang.Object) r1, (kotlin.jvm.functions.Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult>) r0, (androidx.compose.runtime.Composer) r14, (int) r2)
            androidx.compose.ui.window.AndroidPopup_androidKt$Popup$3 r0 = new androidx.compose.ui.window.AndroidPopup_androidKt$Popup$3
            r4 = r0
            r4.<init>(r5, r6, r7, r8, r9)
            r2 = 0
            androidx.compose.runtime.EffectsKt.SideEffect(r0, r14, r2)
            androidx.compose.ui.window.AndroidPopup_androidKt$Popup$4 r0 = new androidx.compose.ui.window.AndroidPopup_androidKt$Popup$4
            r0.<init>(r1, r11)
            r3 = r19 & 14
            androidx.compose.runtime.EffectsKt.DisposableEffect((java.lang.Object) r11, (kotlin.jvm.functions.Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult>) r0, (androidx.compose.runtime.Composer) r14, (int) r3)
            androidx.compose.ui.window.AndroidPopup_androidKt$Popup$5 r0 = new androidx.compose.ui.window.AndroidPopup_androidKt$Popup$5
            r3 = 0
            r0.<init>(r1, r3)
            r3 = 72
            androidx.compose.runtime.EffectsKt.LaunchedEffect((java.lang.Object) r1, (kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r0, (androidx.compose.runtime.Composer) r14, (int) r3)
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.window.AndroidPopup_androidKt$Popup$7 r3 = new androidx.compose.ui.window.AndroidPopup_androidKt$Popup$7
            r3.<init>(r1)
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.layout.OnGloballyPositionedModifierKt.onGloballyPositioned(r0, r3)
            androidx.compose.ui.window.AndroidPopup_androidKt$Popup$8 r3 = new androidx.compose.ui.window.AndroidPopup_androidKt$Popup$8
            r4 = r28
            r3.<init>(r1, r4)
            r1 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r14.startReplaceableGroup(r1)
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r1 = r14.consume(r1)
            androidx.compose.ui.unit.Density r1 = (androidx.compose.ui.unit.Density) r1
            androidx.compose.runtime.ProvidableCompositionLocal r4 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            java.lang.Object r4 = r14.consume(r4)
            androidx.compose.ui.unit.LayoutDirection r4 = (androidx.compose.ui.unit.LayoutDirection) r4
            androidx.compose.runtime.ProvidableCompositionLocal r5 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            java.lang.Object r5 = r14.consume(r5)
            androidx.compose.ui.platform.ViewConfiguration r5 = (androidx.compose.ui.platform.ViewConfiguration) r5
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r7 = r6.getConstructor()
            kotlin.jvm.functions.Function3 r0 = androidx.compose.ui.layout.LayoutKt.materializerOf(r0)
            androidx.compose.runtime.Applier r8 = r14.getApplier()
            boolean r8 = r8 instanceof androidx.compose.runtime.Applier
            if (r8 != 0) goto L_0x020f
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x020f:
            r14.startReusableNode()
            boolean r8 = r14.getInserting()
            if (r8 == 0) goto L_0x021c
            r14.createNode(r7)
            goto L_0x021f
        L_0x021c:
            r14.useNode()
        L_0x021f:
            r14.disableReusing()
            androidx.compose.runtime.Composer r7 = androidx.compose.runtime.Updater.m2536constructorimpl(r14)
            kotlin.jvm.functions.Function2 r8 = r6.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r7, r3, r8)
            kotlin.jvm.functions.Function2 r3 = r6.getSetDensity()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r7, r1, r3)
            kotlin.jvm.functions.Function2 r1 = r6.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r7, r4, r1)
            kotlin.jvm.functions.Function2 r1 = r6.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r7, r5, r1)
            r14.enableReusing()
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m2527constructorimpl(r14)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m2526boximpl(r1)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.invoke(r1, r14, r2)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r14.startReplaceableGroup(r0)
            r0 = 2085825549(0x7c532c0d, float:4.3858724E36)
            r14.startReplaceableGroup(r0)
            r14.endReplaceableGroup()
            r14.endReplaceableGroup()
            r14.endNode()
            r14.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0275
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0275:
            r2 = r16
            r3 = r17
        L_0x0279:
            androidx.compose.runtime.ScopeUpdateScope r7 = r14.endRestartGroup()
            if (r7 != 0) goto L_0x0280
            goto L_0x0291
        L_0x0280:
            androidx.compose.ui.window.AndroidPopup_androidKt$Popup$9 r8 = new androidx.compose.ui.window.AndroidPopup_androidKt$Popup$9
            r0 = r8
            r1 = r27
            r4 = r30
            r5 = r32
            r6 = r33
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r7.updateScope(r8)
        L_0x0291:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.window.AndroidPopup_androidKt.Popup(androidx.compose.ui.window.PopupPositionProvider, kotlin.jvm.functions.Function0, androidx.compose.ui.window.PopupProperties, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: Popup$lambda-1  reason: not valid java name */
    public static final Function2<Composer, Integer, Unit> m5727Popup$lambda1(State<? extends Function2<? super Composer, ? super Integer, Unit>> state) {
        return (Function2) state.getValue();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: androidx.compose.ui.window.AlignmentOffsetPositionProvider} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0170  */
    /* JADX WARNING: Removed duplicated region for block: B:96:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    @androidx.compose.runtime.Composable
    /* renamed from: Popup-K5zGePQ  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m5728PopupK5zGePQ(@org.jetbrains.annotations.Nullable androidx.compose.ui.Alignment r24, long r25, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function0<kotlin.Unit> r27, @org.jetbrains.annotations.Nullable androidx.compose.ui.window.PopupProperties r28, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r30, int r31, int r32) {
        /*
            r7 = r29
            r8 = r31
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r0 = 295309329(0x119a1011, float:2.4306818E-28)
            r1 = r30
            androidx.compose.runtime.Composer r9 = r1.startRestartGroup(r0)
            r1 = r32 & 1
            if (r1 == 0) goto L_0x001c
            r2 = r8 | 6
            r3 = r2
            r2 = r24
            goto L_0x0030
        L_0x001c:
            r2 = r8 & 14
            if (r2 != 0) goto L_0x002d
            r2 = r24
            boolean r3 = r9.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x002a
            r3 = 4
            goto L_0x002b
        L_0x002a:
            r3 = 2
        L_0x002b:
            r3 = r3 | r8
            goto L_0x0030
        L_0x002d:
            r2 = r24
            r3 = r8
        L_0x0030:
            r4 = r32 & 2
            if (r4 == 0) goto L_0x0037
            r3 = r3 | 48
            goto L_0x004a
        L_0x0037:
            r5 = r8 & 112(0x70, float:1.57E-43)
            if (r5 != 0) goto L_0x004a
            r5 = r25
            boolean r10 = r9.changed((long) r5)
            if (r10 == 0) goto L_0x0046
            r10 = 32
            goto L_0x0048
        L_0x0046:
            r10 = 16
        L_0x0048:
            r3 = r3 | r10
            goto L_0x004c
        L_0x004a:
            r5 = r25
        L_0x004c:
            r10 = r32 & 4
            if (r10 == 0) goto L_0x0053
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x0066
        L_0x0053:
            r11 = r8 & 896(0x380, float:1.256E-42)
            if (r11 != 0) goto L_0x0066
            r11 = r27
            boolean r12 = r9.changed((java.lang.Object) r11)
            if (r12 == 0) goto L_0x0062
            r12 = 256(0x100, float:3.59E-43)
            goto L_0x0064
        L_0x0062:
            r12 = 128(0x80, float:1.794E-43)
        L_0x0064:
            r3 = r3 | r12
            goto L_0x0068
        L_0x0066:
            r11 = r27
        L_0x0068:
            r12 = r8 & 7168(0x1c00, float:1.0045E-41)
            if (r12 != 0) goto L_0x0081
            r12 = r32 & 8
            if (r12 != 0) goto L_0x007b
            r12 = r28
            boolean r13 = r9.changed((java.lang.Object) r12)
            if (r13 == 0) goto L_0x007d
            r13 = 2048(0x800, float:2.87E-42)
            goto L_0x007f
        L_0x007b:
            r12 = r28
        L_0x007d:
            r13 = 1024(0x400, float:1.435E-42)
        L_0x007f:
            r3 = r3 | r13
            goto L_0x0083
        L_0x0081:
            r12 = r28
        L_0x0083:
            r13 = r32 & 16
            if (r13 == 0) goto L_0x008a
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009c
        L_0x008a:
            r13 = 57344(0xe000, float:8.0356E-41)
            r13 = r13 & r8
            if (r13 != 0) goto L_0x009c
            boolean r13 = r9.changed((java.lang.Object) r7)
            if (r13 == 0) goto L_0x0099
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009b
        L_0x0099:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x009b:
            r3 = r3 | r13
        L_0x009c:
            r13 = 46811(0xb6db, float:6.5596E-41)
            r13 = r13 & r3
            r14 = 9362(0x2492, float:1.3119E-41)
            if (r13 != r14) goto L_0x00b4
            boolean r13 = r9.getSkipping()
            if (r13 != 0) goto L_0x00ab
            goto L_0x00b4
        L_0x00ab:
            r9.skipToGroupEnd()
            r1 = r2
            r2 = r5
            r4 = r11
            r5 = r12
            goto L_0x0169
        L_0x00b4:
            r9.startDefaults()
            r13 = r8 & 1
            r14 = 0
            if (r13 == 0) goto L_0x00d1
            boolean r13 = r9.getDefaultsInvalid()
            if (r13 == 0) goto L_0x00c3
            goto L_0x00d1
        L_0x00c3:
            r9.skipToGroupEnd()
            r1 = r32 & 8
            if (r1 == 0) goto L_0x00cc
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x00cc:
            r10 = r2
            r13 = r11
            r15 = r12
            r11 = r5
            goto L_0x010a
        L_0x00d1:
            if (r1 == 0) goto L_0x00da
            androidx.compose.ui.Alignment$Companion r1 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r1 = r1.getTopStart()
            goto L_0x00db
        L_0x00da:
            r1 = r2
        L_0x00db:
            if (r4 == 0) goto L_0x00e3
            r2 = 0
            long r4 = androidx.compose.ui.unit.IntOffsetKt.IntOffset(r2, r2)
            goto L_0x00e4
        L_0x00e3:
            r4 = r5
        L_0x00e4:
            if (r10 == 0) goto L_0x00e7
            r11 = r14
        L_0x00e7:
            r2 = r32 & 8
            if (r2 == 0) goto L_0x0106
            androidx.compose.ui.window.PopupProperties r2 = new androidx.compose.ui.window.PopupProperties
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 63
            r23 = 0
            r15 = r2
            r15.<init>(r16, r17, r18, r19, r20, r21, r22, r23)
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
            r10 = r1
            r13 = r11
            goto L_0x0109
        L_0x0106:
            r10 = r1
            r13 = r11
            r15 = r12
        L_0x0109:
            r11 = r4
        L_0x010a:
            r9.endDefaults()
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0119
            r1 = -1
            java.lang.String r2 = "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:184)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r3, r1, r2)
        L_0x0119:
            androidx.compose.ui.unit.IntOffset r0 = androidx.compose.ui.unit.IntOffset.m5587boximpl(r11)
            r1 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r9.startReplaceableGroup(r1)
            boolean r1 = r9.changed((java.lang.Object) r10)
            boolean r0 = r9.changed((java.lang.Object) r0)
            r0 = r0 | r1
            java.lang.Object r1 = r9.rememberedValue()
            if (r0 != 0) goto L_0x013a
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r1 != r0) goto L_0x0142
        L_0x013a:
            androidx.compose.ui.window.AlignmentOffsetPositionProvider r1 = new androidx.compose.ui.window.AlignmentOffsetPositionProvider
            r1.<init>(r10, r11, r14)
            r9.updateRememberedValue(r1)
        L_0x0142:
            r9.endReplaceableGroup()
            r0 = r1
            androidx.compose.ui.window.AlignmentOffsetPositionProvider r0 = (androidx.compose.ui.window.AlignmentOffsetPositionProvider) r0
            int r1 = r3 >> 3
            r2 = r1 & 112(0x70, float:1.57E-43)
            r3 = r1 & 896(0x380, float:1.256E-42)
            r2 = r2 | r3
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r5 = r2 | r1
            r6 = 0
            r1 = r13
            r2 = r15
            r3 = r29
            r4 = r9
            Popup(r0, r1, r2, r3, r4, r5, r6)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0165
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0165:
            r1 = r10
            r2 = r11
            r4 = r13
            r5 = r15
        L_0x0169:
            androidx.compose.runtime.ScopeUpdateScope r9 = r9.endRestartGroup()
            if (r9 != 0) goto L_0x0170
            goto L_0x017f
        L_0x0170:
            androidx.compose.ui.window.AndroidPopup_androidKt$Popup$1 r10 = new androidx.compose.ui.window.AndroidPopup_androidKt$Popup$1
            r0 = r10
            r6 = r29
            r7 = r31
            r8 = r32
            r0.<init>(r1, r2, r4, r5, r6, r7, r8)
            r9.updateScope(r10)
        L_0x017f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.window.AndroidPopup_androidKt.m5728PopupK5zGePQ(androidx.compose.ui.Alignment, long, kotlin.jvm.functions.Function0, androidx.compose.ui.window.PopupProperties, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    @ComposableInferredTarget(scheme = "[0[0]]")
    @Composable
    public static final void PopupTestTag(@NotNull String str, @NotNull Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Composer composer, int i11) {
        int i12;
        int i13;
        int i14;
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(function2, "content");
        Composer startRestartGroup = composer.startRestartGroup(-498879600);
        if ((i11 & 14) == 0) {
            if (startRestartGroup.changed((Object) str)) {
                i14 = 4;
            } else {
                i14 = 2;
            }
            i12 = i14 | i11;
        } else {
            i12 = i11;
        }
        if ((i11 & 112) == 0) {
            if (startRestartGroup.changed((Object) function2)) {
                i13 = 32;
            } else {
                i13 = 16;
            }
            i12 |= i13;
        }
        if ((i12 & 91) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-498879600, i12, -1, "androidx.compose.ui.window.PopupTestTag (AndroidPopup.android.kt:329)");
            }
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{LocalPopupTestTag.provides(str)}, function2, startRestartGroup, (i12 & 112) | 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new AndroidPopup_androidKt$PopupTestTag$1(str, function2, i11));
        }
    }

    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    @Composable
    private static final void SimpleStack(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i11) {
        composer.startReplaceableGroup(1406149896);
        AndroidPopup_androidKt$SimpleStack$1 androidPopup_androidKt$SimpleStack$1 = AndroidPopup_androidKt$SimpleStack$1.INSTANCE;
        composer.startReplaceableGroup(-1323940314);
        Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion = ComposeUiNode.Companion;
        Function0<ComposeUiNode> constructor = companion.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier);
        int i12 = (((((i11 << 3) & 112) | ((i11 >> 3) & 14)) << 9) & 7168) | 6;
        if (!(composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor);
        } else {
            composer.useNode();
        }
        composer.disableReusing();
        Composer r52 = Updater.m2536constructorimpl(composer);
        Updater.m2543setimpl(r52, androidPopup_androidKt$SimpleStack$1, companion.getSetMeasurePolicy());
        Updater.m2543setimpl(r52, density, companion.getSetDensity());
        Updater.m2543setimpl(r52, layoutDirection, companion.getSetLayoutDirection());
        Updater.m2543setimpl(r52, viewConfiguration, companion.getSetViewConfiguration());
        composer.enableReusing();
        materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer, Integer.valueOf((i12 >> 3) & 112));
        composer.startReplaceableGroup(2058660585);
        function2.invoke(composer, Integer.valueOf((i12 >> 9) & 14));
        composer.endReplaceableGroup();
        composer.endNode();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
    }

    @NotNull
    public static final ProvidableCompositionLocal<String> getLocalPopupTestTag() {
        return LocalPopupTestTag;
    }

    public static final boolean isFlagSecureEnabled(@NotNull View view) {
        WindowManager.LayoutParams layoutParams;
        Intrinsics.checkNotNullParameter(view, "<this>");
        ViewGroup.LayoutParams layoutParams2 = view.getRootView().getLayoutParams();
        if (layoutParams2 instanceof WindowManager.LayoutParams) {
            layoutParams = (WindowManager.LayoutParams) layoutParams2;
        } else {
            layoutParams = null;
        }
        if (layoutParams == null || (layoutParams.flags & 8192) == 0) {
            return false;
        }
        return true;
    }

    public static final boolean isPopupLayout(@NotNull View view, @Nullable String str) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (!(view instanceof PopupLayout) || (str != null && !Intrinsics.areEqual((Object) str, (Object) ((PopupLayout) view).getTestTag()))) {
            return false;
        }
        return true;
    }

    public static /* synthetic */ boolean isPopupLayout$default(View view, String str, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str = null;
        }
        return isPopupLayout(view, str);
    }

    /* access modifiers changed from: private */
    public static final IntRect toIntBounds(Rect rect) {
        return new IntRect(rect.left, rect.top, rect.right, rect.bottom);
    }
}
