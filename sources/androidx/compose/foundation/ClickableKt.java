package androidx.compose.foundation;

import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000d\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a<\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\bH\u0001ø\u0001\u0000¢\u0006\u0002\u0010\n\u001aW\u0010\u000b\u001a\u00020\f*\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\b\u0017\u001aE\u0010\u000b\u001a\u00020\f*\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\b\u0018\u001a\u0001\u0010\u0019\u001a\u00020\f*\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00122\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00162\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00162\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u0016H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\b\u001d\u001aw\u0010\u0019\u001a\u00020\f*\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00122\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00162\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00162\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u0016H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\b\u001e\u001a©\u0001\u0010\u001f\u001a\u00020\f*\u00020\f2\u0006\u0010 \u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010!\u001a\u00020\"2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\b2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00122\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00162\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u0016H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\b&\u001aQ\u0010'\u001a\u00020\u0001*\u00020(2\u0006\u0010)\u001a\u00020%2\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0012\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00160$H@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b+\u0010,\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006-"}, d2 = {"PressedInteractionSourceDisposableEffect", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "pressedInteraction", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "currentKeyPressInteractions", "", "Landroidx/compose/ui/input/key/Key;", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/MutableState;Ljava/util/Map;Landroidx/compose/runtime/Composer;I)V", "clickable", "Landroidx/compose/ui/Modifier;", "indication", "Landroidx/compose/foundation/Indication;", "enabled", "", "onClickLabel", "", "role", "Landroidx/compose/ui/semantics/Role;", "onClick", "Lkotlin/Function0;", "clickable-O2vRcR0", "clickable-XHw0xAI", "combinedClickable", "onLongClickLabel", "onLongClick", "onDoubleClick", "combinedClickable-XVZzFYc", "combinedClickable-cJG_KMw", "genericClickableWithoutGesture", "gestureModifiers", "indicationScope", "Lkotlinx/coroutines/CoroutineScope;", "keyClickOffset", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/geometry/Offset;", "genericClickableWithoutGesture-bdNGguI", "handlePressInteraction", "Landroidx/compose/foundation/gestures/PressGestureScope;", "pressPoint", "delayPressInteraction", "handlePressInteraction-EPk0efs", "(Landroidx/compose/foundation/gestures/PressGestureScope;JLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/State;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ClickableKt {
    @Composable
    public static final void PressedInteractionSourceDisposableEffect(@NotNull MutableInteractionSource mutableInteractionSource, @NotNull MutableState<PressInteraction.Press> mutableState, @NotNull Map<Key, PressInteraction.Press> map, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(mutableInteractionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(mutableState, "pressedInteraction");
        Intrinsics.checkNotNullParameter(map, "currentKeyPressInteractions");
        Composer startRestartGroup = composer.startRestartGroup(1297229208);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1297229208, i11, -1, "androidx.compose.foundation.PressedInteractionSourceDisposableEffect (Clickable.kt:409)");
        }
        EffectsKt.DisposableEffect((Object) mutableInteractionSource, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) new ClickableKt$PressedInteractionSourceDisposableEffect$1(mutableState, map, mutableInteractionSource), startRestartGroup, i11 & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ClickableKt$PressedInteractionSourceDisposableEffect$2(mutableInteractionSource, mutableState, map, i11));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: kotlin.jvm.functions.Function1<androidx.compose.ui.platform.InspectorInfo, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: androidx.compose.foundation.ClickableKt$clickable-O2vRcR0$$inlined$debugInspectorInfo$1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: androidx.compose.foundation.ClickableKt$clickable-O2vRcR0$$inlined$debugInspectorInfo$1} */
    /* JADX WARNING: type inference failed for: r0v4, types: [kotlin.jvm.functions.Function1] */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    /* renamed from: clickable-O2vRcR0  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.ui.Modifier m193clickableO2vRcR0(@org.jetbrains.annotations.NotNull androidx.compose.ui.Modifier r9, @org.jetbrains.annotations.NotNull androidx.compose.foundation.interaction.MutableInteractionSource r10, @org.jetbrains.annotations.Nullable androidx.compose.foundation.Indication r11, boolean r12, @org.jetbrains.annotations.Nullable java.lang.String r13, @org.jetbrains.annotations.Nullable androidx.compose.ui.semantics.Role r14, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<kotlin.Unit> r15) {
        /*
            java.lang.String r0 = "$this$clickable"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "interactionSource"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "onClick"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            boolean r0 = androidx.compose.ui.platform.InspectableValueKt.isDebugInspectorInfoEnabled()
            if (r0 == 0) goto L_0x0022
            androidx.compose.foundation.ClickableKt$clickable-O2vRcR0$$inlined$debugInspectorInfo$1 r0 = new androidx.compose.foundation.ClickableKt$clickable-O2vRcR0$$inlined$debugInspectorInfo$1
            r1 = r0
            r2 = r12
            r3 = r13
            r4 = r14
            r5 = r15
            r6 = r11
            r7 = r10
            r1.<init>(r2, r3, r4, r5, r6, r7)
            goto L_0x0026
        L_0x0022:
            kotlin.jvm.functions.Function1 r0 = androidx.compose.ui.platform.InspectableValueKt.getNoInspectorInfo()
        L_0x0026:
            androidx.compose.foundation.ClickableKt$clickable$4 r8 = new androidx.compose.foundation.ClickableKt$clickable$4
            r1 = r8
            r2 = r15
            r3 = r12
            r4 = r10
            r5 = r11
            r6 = r13
            r7 = r14
            r1.<init>(r2, r3, r4, r5, r6, r7)
            androidx.compose.ui.Modifier r9 = androidx.compose.ui.ComposedModifierKt.composed(r9, r0, r8)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.ClickableKt.m193clickableO2vRcR0(androidx.compose.ui.Modifier, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.foundation.Indication, boolean, java.lang.String, androidx.compose.ui.semantics.Role, kotlin.jvm.functions.Function0):androidx.compose.ui.Modifier");
    }

    /* renamed from: clickable-O2vRcR0$default  reason: not valid java name */
    public static /* synthetic */ Modifier m194clickableO2vRcR0$default(Modifier modifier, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z11, String str, Role role, Function0 function0, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            z11 = true;
        }
        return m193clickableO2vRcR0(modifier, mutableInteractionSource, indication, z11, (i11 & 8) != 0 ? null : str, (i11 & 16) != 0 ? null : role, function0);
    }

    @NotNull
    /* renamed from: clickable-XHw0xAI  reason: not valid java name */
    public static final Modifier m195clickableXHw0xAI(@NotNull Modifier modifier, boolean z11, @Nullable String str, @Nullable Role role, @NotNull Function0<Unit> function0) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(modifier, "$this$clickable");
        Intrinsics.checkNotNullParameter(function0, "onClick");
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            function1 = new ClickableKt$clickableXHw0xAI$$inlined$debugInspectorInfo$1(z11, str, role, function0);
        } else {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return ComposedModifierKt.composed(modifier, function1, new ClickableKt$clickable$2(z11, str, role, function0));
    }

    /* renamed from: clickable-XHw0xAI$default  reason: not valid java name */
    public static /* synthetic */ Modifier m196clickableXHw0xAI$default(Modifier modifier, boolean z11, String str, Role role, Function0 function0, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = true;
        }
        if ((i11 & 2) != 0) {
            str = null;
        }
        if ((i11 & 4) != 0) {
            role = null;
        }
        return m195clickableXHw0xAI(modifier, z11, str, role, function0);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: kotlin.jvm.functions.Function1<androidx.compose.ui.platform.InspectorInfo, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: androidx.compose.foundation.ClickableKt$combinedClickable-XVZzFYc$$inlined$debugInspectorInfo$1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: androidx.compose.foundation.ClickableKt$combinedClickable-XVZzFYc$$inlined$debugInspectorInfo$1} */
    /* JADX WARNING: type inference failed for: r1v4, types: [kotlin.jvm.functions.Function1] */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    @androidx.compose.foundation.ExperimentalFoundationApi
    /* renamed from: combinedClickable-XVZzFYc  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.ui.Modifier m197combinedClickableXVZzFYc(@org.jetbrains.annotations.NotNull androidx.compose.ui.Modifier r15, @org.jetbrains.annotations.NotNull androidx.compose.foundation.interaction.MutableInteractionSource r16, @org.jetbrains.annotations.Nullable androidx.compose.foundation.Indication r17, boolean r18, @org.jetbrains.annotations.Nullable java.lang.String r19, @org.jetbrains.annotations.Nullable androidx.compose.ui.semantics.Role r20, @org.jetbrains.annotations.Nullable java.lang.String r21, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function0<kotlin.Unit> r22, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function0<kotlin.Unit> r23, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<kotlin.Unit> r24) {
        /*
            r0 = r15
            java.lang.String r1 = "$this$combinedClickable"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r1)
            java.lang.String r1 = "interactionSource"
            r12 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r1)
            java.lang.String r1 = "onClick"
            r13 = r24
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r1)
            boolean r1 = androidx.compose.ui.platform.InspectableValueKt.isDebugInspectorInfoEnabled()
            if (r1 == 0) goto L_0x0033
            androidx.compose.foundation.ClickableKt$combinedClickable-XVZzFYc$$inlined$debugInspectorInfo$1 r1 = new androidx.compose.foundation.ClickableKt$combinedClickable-XVZzFYc$$inlined$debugInspectorInfo$1
            r2 = r1
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r24
            r7 = r23
            r8 = r22
            r9 = r21
            r10 = r17
            r11 = r16
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            goto L_0x0037
        L_0x0033:
            kotlin.jvm.functions.Function1 r1 = androidx.compose.ui.platform.InspectableValueKt.getNoInspectorInfo()
        L_0x0037:
            androidx.compose.foundation.ClickableKt$combinedClickable$4 r14 = new androidx.compose.foundation.ClickableKt$combinedClickable$4
            r2 = r14
            r3 = r24
            r4 = r22
            r5 = r23
            r6 = r18
            r7 = r16
            r8 = r17
            r9 = r19
            r10 = r20
            r11 = r21
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.ComposedModifierKt.composed(r15, r1, r14)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.ClickableKt.m197combinedClickableXVZzFYc(androidx.compose.ui.Modifier, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.foundation.Indication, boolean, java.lang.String, androidx.compose.ui.semantics.Role, java.lang.String, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0):androidx.compose.ui.Modifier");
    }

    /* renamed from: combinedClickable-XVZzFYc$default  reason: not valid java name */
    public static /* synthetic */ Modifier m198combinedClickableXVZzFYc$default(Modifier modifier, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z11, String str, Role role, String str2, Function0 function0, Function0 function02, Function0 function03, int i11, Object obj) {
        int i12 = i11;
        return m197combinedClickableXVZzFYc(modifier, mutableInteractionSource, indication, (i12 & 4) != 0 ? true : z11, (i12 & 8) != 0 ? null : str, (i12 & 16) != 0 ? null : role, (i12 & 32) != 0 ? null : str2, (i12 & 64) != 0 ? null : function0, (i12 & 128) != 0 ? null : function02, function03);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: kotlin.jvm.functions.Function1<androidx.compose.ui.platform.InspectorInfo, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: androidx.compose.foundation.ClickableKt$combinedClickable-cJG_KMw$$inlined$debugInspectorInfo$1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: androidx.compose.foundation.ClickableKt$combinedClickable-cJG_KMw$$inlined$debugInspectorInfo$1} */
    /* JADX WARNING: type inference failed for: r1v3, types: [kotlin.jvm.functions.Function1] */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    @androidx.compose.foundation.ExperimentalFoundationApi
    /* renamed from: combinedClickable-cJG_KMw  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.ui.Modifier m199combinedClickablecJG_KMw(@org.jetbrains.annotations.NotNull androidx.compose.ui.Modifier r12, boolean r13, @org.jetbrains.annotations.Nullable java.lang.String r14, @org.jetbrains.annotations.Nullable androidx.compose.ui.semantics.Role r15, @org.jetbrains.annotations.Nullable java.lang.String r16, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function0<kotlin.Unit> r17, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function0<kotlin.Unit> r18, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<kotlin.Unit> r19) {
        /*
            r0 = r12
            java.lang.String r1 = "$this$combinedClickable"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r1)
            java.lang.String r1 = "onClick"
            r10 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r1)
            boolean r1 = androidx.compose.ui.platform.InspectableValueKt.isDebugInspectorInfoEnabled()
            if (r1 == 0) goto L_0x0025
            androidx.compose.foundation.ClickableKt$combinedClickable-cJG_KMw$$inlined$debugInspectorInfo$1 r1 = new androidx.compose.foundation.ClickableKt$combinedClickable-cJG_KMw$$inlined$debugInspectorInfo$1
            r2 = r1
            r3 = r13
            r4 = r14
            r5 = r15
            r6 = r19
            r7 = r18
            r8 = r17
            r9 = r16
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            goto L_0x0029
        L_0x0025:
            kotlin.jvm.functions.Function1 r1 = androidx.compose.ui.platform.InspectableValueKt.getNoInspectorInfo()
        L_0x0029:
            androidx.compose.foundation.ClickableKt$combinedClickable$2 r11 = new androidx.compose.foundation.ClickableKt$combinedClickable$2
            r2 = r11
            r3 = r13
            r4 = r14
            r5 = r15
            r6 = r16
            r7 = r17
            r8 = r18
            r9 = r19
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.ComposedModifierKt.composed(r12, r1, r11)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.ClickableKt.m199combinedClickablecJG_KMw(androidx.compose.ui.Modifier, boolean, java.lang.String, androidx.compose.ui.semantics.Role, java.lang.String, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0):androidx.compose.ui.Modifier");
    }

    /* renamed from: combinedClickable-cJG_KMw$default  reason: not valid java name */
    public static /* synthetic */ Modifier m200combinedClickablecJG_KMw$default(Modifier modifier, boolean z11, String str, Role role, String str2, Function0 function0, Function0 function02, Function0 function03, int i11, Object obj) {
        return m199combinedClickablecJG_KMw(modifier, (i11 & 1) != 0 ? true : z11, (i11 & 2) != 0 ? null : str, (i11 & 4) != 0 ? null : role, (i11 & 8) != 0 ? null : str2, (i11 & 16) != 0 ? null : function0, (i11 & 32) != 0 ? null : function02, function03);
    }

    @NotNull
    /* renamed from: genericClickableWithoutGesture-bdNGguI  reason: not valid java name */
    public static final Modifier m201genericClickableWithoutGesturebdNGguI(@NotNull Modifier modifier, @NotNull Modifier modifier2, @NotNull MutableInteractionSource mutableInteractionSource, @Nullable Indication indication, @NotNull CoroutineScope coroutineScope, @NotNull Map<Key, PressInteraction.Press> map, @NotNull State<Offset> state, boolean z11, @Nullable String str, @Nullable Role role, @Nullable String str2, @Nullable Function0<Unit> function0, @NotNull Function0<Unit> function02) {
        Modifier modifier3 = modifier2;
        MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
        boolean z12 = z11;
        Modifier modifier4 = modifier;
        Intrinsics.checkNotNullParameter(modifier, "$this$genericClickableWithoutGesture");
        Intrinsics.checkNotNullParameter(modifier2, "gestureModifiers");
        Intrinsics.checkNotNullParameter(mutableInteractionSource2, "interactionSource");
        Intrinsics.checkNotNullParameter(coroutineScope, "indicationScope");
        Intrinsics.checkNotNullParameter(map, "currentKeyPressInteractions");
        Intrinsics.checkNotNullParameter(state, "keyClickOffset");
        Intrinsics.checkNotNullParameter(function02, "onClick");
        return FocusableKt.focusableInNonTouchMode(HoverableKt.hoverable(IndicationKt.indication(genericClickableWithoutGesture_bdNGguI$detectPressAndClickFromKey(genericClickableWithoutGesture_bdNGguI$clickSemantics(modifier, role, str, function0, str2, z11, function02), z11, map, state, coroutineScope, function02, mutableInteractionSource), mutableInteractionSource2, indication), mutableInteractionSource2, z12), z12, mutableInteractionSource2).then(modifier2);
    }

    /* renamed from: genericClickableWithoutGesture-bdNGguI$default  reason: not valid java name */
    public static /* synthetic */ Modifier m202genericClickableWithoutGesturebdNGguI$default(Modifier modifier, Modifier modifier2, MutableInteractionSource mutableInteractionSource, Indication indication, CoroutineScope coroutineScope, Map map, State state, boolean z11, String str, Role role, String str2, Function0 function0, Function0 function02, int i11, Object obj) {
        int i12 = i11;
        return m201genericClickableWithoutGesturebdNGguI(modifier, modifier2, mutableInteractionSource, indication, coroutineScope, map, state, (i12 & 64) != 0 ? true : z11, (i12 & 128) != 0 ? null : str, (i12 & 256) != 0 ? null : role, (i12 & 512) != 0 ? null : str2, (i12 & 1024) != 0 ? null : function0, function02);
    }

    private static final Modifier genericClickableWithoutGesture_bdNGguI$clickSemantics(Modifier modifier, Role role, String str, Function0<Unit> function0, String str2, boolean z11, Function0<Unit> function02) {
        return SemanticsModifierKt.semantics(modifier, true, new ClickableKt$genericClickableWithoutGesture$clickSemantics$1(role, str, function0, str2, z11, function02));
    }

    private static final Modifier genericClickableWithoutGesture_bdNGguI$detectPressAndClickFromKey(Modifier modifier, boolean z11, Map<Key, PressInteraction.Press> map, State<Offset> state, CoroutineScope coroutineScope, Function0<Unit> function0, MutableInteractionSource mutableInteractionSource) {
        return KeyInputModifierKt.onKeyEvent(modifier, new ClickableKt$genericClickableWithoutGesture$detectPressAndClickFromKey$1(z11, map, state, coroutineScope, function0, mutableInteractionSource));
    }

    @Nullable
    /* renamed from: handlePressInteraction-EPk0efs  reason: not valid java name */
    public static final Object m203handlePressInteractionEPk0efs(@NotNull PressGestureScope pressGestureScope, long j11, @NotNull MutableInteractionSource mutableInteractionSource, @NotNull MutableState<PressInteraction.Press> mutableState, @NotNull State<? extends Function0<Boolean>> state, @NotNull Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new ClickableKt$handlePressInteraction$2(pressGestureScope, j11, mutableInteractionSource, mutableState, state, (Continuation<? super ClickableKt$handlePressInteraction$2>) null), continuation);
        return coroutineScope == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }
}
