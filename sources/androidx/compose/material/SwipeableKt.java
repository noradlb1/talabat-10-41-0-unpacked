package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aP\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\r2\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000f2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH\u0002\u001a$\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u00132\u0006\u0010\n\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\rH\u0002\u001aZ\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\b\b\u0000\u0010\u0002*\u00020\u00152\u0006\u0010\u0016\u001a\u0002H\u00022\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\u00182#\b\u0002\u0010\u0019\u001a\u001d\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u001e0\u001aH\u0007¢\u0006\u0002\u0010\u001f\u001aI\u0010 \u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\b\b\u0000\u0010\u0002*\u00020\u00152\u0006\u0010!\u001a\u0002H\u00022\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020#0\u001a2\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\u0018H\u0001¢\u0006\u0002\u0010$\u001a-\u0010%\u001a\u0004\u0018\u00010\t\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u0002H\u00020&2\u0006\u0010'\u001a\u0002H\u0002H\u0002¢\u0006\u0002\u0010(\u001a¹\u0001\u0010)\u001a\u00020*\"\u0004\b\u0000\u0010\u0002*\u00020*2\f\u0010'\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u0002H\u00020&2\u0006\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020\u001e2\b\b\u0002\u0010.\u001a\u00020\u001e2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010028\b\u0002\u0010\u000e\u001a2\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(1\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(2\u0012\u0004\u0012\u0002030\u000f2\n\b\u0002\u00104\u001a\u0004\u0018\u0001052\b\b\u0002\u0010\u0011\u001a\u000206H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b7\u00108\"*\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00038@X\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00069"}, d2 = {"PreUpPostDownNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "T", "Landroidx/compose/material/SwipeableState;", "getPreUpPostDownNestedScrollConnection$annotations", "(Landroidx/compose/material/SwipeableState;)V", "getPreUpPostDownNestedScrollConnection", "(Landroidx/compose/material/SwipeableState;)Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "computeTarget", "", "offset", "lastValue", "anchors", "", "thresholds", "Lkotlin/Function2;", "velocity", "velocityThreshold", "findBounds", "", "rememberSwipeableState", "", "initialValue", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "confirmStateChange", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "newValue", "", "(Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/SwipeableState;", "rememberSwipeableStateFor", "value", "onValueChange", "", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/SwipeableState;", "getOffset", "", "state", "(Ljava/util/Map;Ljava/lang/Object;)Ljava/lang/Float;", "swipeable", "Landroidx/compose/ui/Modifier;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "reverseDirection", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "from", "to", "Landroidx/compose/material/ThresholdConfig;", "resistance", "Landroidx/compose/material/ResistanceConfig;", "Landroidx/compose/ui/unit/Dp;", "swipeable-pPrIpRY", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material/SwipeableState;Ljava/util/Map;Landroidx/compose/foundation/gestures/Orientation;ZZLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/material/ResistanceConfig;F)Landroidx/compose/ui/Modifier;", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class SwipeableKt {
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x003f, code lost:
        if (r3 < r6.invoke(java.lang.Float.valueOf(r0), java.lang.Float.valueOf(r5)).floatValue()) goto L_0x0060;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005c, code lost:
        if (r3 > r6.invoke(java.lang.Float.valueOf(r5), java.lang.Float.valueOf(r0)).floatValue()) goto L_0x005e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final float computeTarget(float r3, float r4, java.util.Set<java.lang.Float> r5, kotlin.jvm.functions.Function2<? super java.lang.Float, ? super java.lang.Float, java.lang.Float> r6, float r7, float r8) {
        /*
            java.util.List r5 = findBounds(r3, r5)
            int r0 = r5.size()
            if (r0 == 0) goto L_0x006c
            r1 = 0
            r2 = 1
            if (r0 == r2) goto L_0x0062
            java.lang.Object r0 = r5.get(r1)
            java.lang.Number r0 = (java.lang.Number) r0
            float r0 = r0.floatValue()
            java.lang.Object r5 = r5.get(r2)
            java.lang.Number r5 = (java.lang.Number) r5
            float r5 = r5.floatValue()
            int r4 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r4 > 0) goto L_0x0042
            int r4 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r4 < 0) goto L_0x002b
            return r5
        L_0x002b:
            java.lang.Float r4 = java.lang.Float.valueOf(r0)
            java.lang.Float r7 = java.lang.Float.valueOf(r5)
            java.lang.Object r4 = r6.invoke(r4, r7)
            java.lang.Number r4 = (java.lang.Number) r4
            float r4 = r4.floatValue()
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 >= 0) goto L_0x005e
            goto L_0x0060
        L_0x0042:
            float r4 = -r8
            int r4 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r4 > 0) goto L_0x0048
            return r0
        L_0x0048:
            java.lang.Float r4 = java.lang.Float.valueOf(r5)
            java.lang.Float r7 = java.lang.Float.valueOf(r0)
            java.lang.Object r4 = r6.invoke(r4, r7)
            java.lang.Number r4 = (java.lang.Number) r4
            float r4 = r4.floatValue()
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 <= 0) goto L_0x0060
        L_0x005e:
            r4 = r5
            goto L_0x006c
        L_0x0060:
            r4 = r0
            goto L_0x006c
        L_0x0062:
            java.lang.Object r3 = r5.get(r1)
            java.lang.Number r3 = (java.lang.Number) r3
            float r4 = r3.floatValue()
        L_0x006c:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SwipeableKt.computeTarget(float, float, java.util.Set, kotlin.jvm.functions.Function2, float, float):float");
    }

    /* access modifiers changed from: private */
    public static final List<Float> findBounds(float f11, Set<Float> set) {
        boolean z11;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = set.iterator();
        while (true) {
            boolean z12 = true;
            if (!it.hasNext()) {
                break;
            }
            T next = it.next();
            if (((double) ((Number) next).floatValue()) > ((double) f11) + 0.001d) {
                z12 = false;
            }
            if (z12) {
                arrayList.add(next);
            }
        }
        Float maxOrNull = CollectionsKt.maxOrNull((Iterable) arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (T next2 : set) {
            if (((double) ((Number) next2).floatValue()) >= ((double) f11) - 0.001d) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                arrayList2.add(next2);
            }
        }
        Float minOrNull = CollectionsKt.minOrNull((Iterable) arrayList2);
        if (maxOrNull == null) {
            return CollectionsKt__CollectionsKt.listOfNotNull(minOrNull);
        }
        if (minOrNull == null) {
            return CollectionsKt__CollectionsJVMKt.listOf(maxOrNull);
        }
        if (Intrinsics.areEqual(maxOrNull, minOrNull)) {
            return CollectionsKt__CollectionsJVMKt.listOf(maxOrNull);
        }
        return CollectionsKt__CollectionsKt.listOf(maxOrNull, minOrNull);
    }

    /* access modifiers changed from: private */
    public static final <T> Float getOffset(Map<Float, ? extends T> map, T t11) {
        T t12;
        Iterator<T> it = map.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                t12 = null;
                break;
            }
            t12 = it.next();
            if (Intrinsics.areEqual(((Map.Entry) t12).getValue(), (Object) t11)) {
                break;
            }
        }
        Map.Entry entry = (Map.Entry) t12;
        if (entry != null) {
            return (Float) entry.getKey();
        }
        return null;
    }

    @NotNull
    public static final <T> NestedScrollConnection getPreUpPostDownNestedScrollConnection(@NotNull SwipeableState<T> swipeableState) {
        Intrinsics.checkNotNullParameter(swipeableState, "<this>");
        return new SwipeableKt$PreUpPostDownNestedScrollConnection$1(swipeableState);
    }

    @ExperimentalMaterialApi
    public static /* synthetic */ void getPreUpPostDownNestedScrollConnection$annotations(SwipeableState swipeableState) {
    }

    @ExperimentalMaterialApi
    @NotNull
    @Composable
    public static final <T> SwipeableState<T> rememberSwipeableState(@NotNull T t11, @Nullable AnimationSpec<Float> animationSpec, @Nullable Function1<? super T, Boolean> function1, @Nullable Composer composer, int i11, int i12) {
        Intrinsics.checkNotNullParameter(t11, "initialValue");
        composer.startReplaceableGroup(-1237755169);
        AnimationSpec animationSpec2 = animationSpec;
        if ((i12 & 2) != 0) {
            animationSpec2 = SwipeableDefaults.INSTANCE.getAnimationSpec();
        }
        Function1 function12 = function1;
        if ((i12 & 4) != 0) {
            function12 = SwipeableKt$rememberSwipeableState$1.INSTANCE;
        }
        SwipeableState<T> swipeableState = (SwipeableState) RememberSaveableKt.rememberSaveable(new Object[0], SwipeableState.Companion.Saver(animationSpec2, function12), (String) null, new SwipeableKt$rememberSwipeableState$2(t11, animationSpec2, function12), composer, 72, 4);
        composer.endReplaceableGroup();
        return swipeableState;
    }

    @ExperimentalMaterialApi
    @NotNull
    @Composable
    public static final <T> SwipeableState<T> rememberSwipeableStateFor(@NotNull T t11, @NotNull Function1<? super T, Unit> function1, @Nullable AnimationSpec<Float> animationSpec, @Nullable Composer composer, int i11, int i12) {
        Intrinsics.checkNotNullParameter(t11, "value");
        Intrinsics.checkNotNullParameter(function1, "onValueChange");
        composer.startReplaceableGroup(1156387078);
        if ((i12 & 4) != 0) {
            animationSpec = SwipeableDefaults.INSTANCE.getAnimationSpec();
        }
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.Companion;
        if (rememberedValue == companion.getEmpty()) {
            rememberedValue = new SwipeableState(t11, animationSpec, SwipeableKt$rememberSwipeableStateFor$swipeableState$1$1.INSTANCE);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        SwipeableState<T> swipeableState = (SwipeableState) rememberedValue;
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == companion.getEmpty()) {
            rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, (SnapshotMutationPolicy) null, 2, (Object) null);
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        MutableState mutableState = (MutableState) rememberedValue2;
        int i13 = i11 & 8;
        EffectsKt.LaunchedEffect(t11, mutableState.getValue(), new SwipeableKt$rememberSwipeableStateFor$1(t11, swipeableState, (Continuation<? super SwipeableKt$rememberSwipeableStateFor$1>) null), composer, (i11 & 14) | i13);
        EffectsKt.DisposableEffect((Object) swipeableState.getCurrentValue(), (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) new SwipeableKt$rememberSwipeableStateFor$2(t11, swipeableState, function1, mutableState), composer, i13);
        composer.endReplaceableGroup();
        return swipeableState;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: kotlin.jvm.functions.Function1<androidx.compose.ui.platform.InspectorInfo, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: androidx.compose.material.SwipeableKt$swipeable-pPrIpRY$$inlined$debugInspectorInfo$1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: androidx.compose.material.SwipeableKt$swipeable-pPrIpRY$$inlined$debugInspectorInfo$1} */
    /* JADX WARNING: type inference failed for: r1v6, types: [kotlin.jvm.functions.Function1] */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.compose.material.ExperimentalMaterialApi
    @org.jetbrains.annotations.NotNull
    /* renamed from: swipeable-pPrIpRY  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> androidx.compose.ui.Modifier m1394swipeablepPrIpRY(@org.jetbrains.annotations.NotNull androidx.compose.ui.Modifier r16, @org.jetbrains.annotations.NotNull androidx.compose.material.SwipeableState<T> r17, @org.jetbrains.annotations.NotNull java.util.Map<java.lang.Float, ? extends T> r18, @org.jetbrains.annotations.NotNull androidx.compose.foundation.gestures.Orientation r19, boolean r20, boolean r21, @org.jetbrains.annotations.Nullable androidx.compose.foundation.interaction.MutableInteractionSource r22, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super T, ? super T, ? extends androidx.compose.material.ThresholdConfig> r23, @org.jetbrains.annotations.Nullable androidx.compose.material.ResistanceConfig r24, float r25) {
        /*
            r0 = r16
            java.lang.String r1 = "$this$swipeable"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            java.lang.String r1 = "state"
            r12 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r1)
            java.lang.String r1 = "anchors"
            r13 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r1)
            java.lang.String r1 = "orientation"
            r14 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r1)
            java.lang.String r1 = "thresholds"
            r15 = r23
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r1)
            boolean r1 = androidx.compose.ui.platform.InspectableValueKt.isDebugInspectorInfoEnabled()
            if (r1 == 0) goto L_0x0042
            androidx.compose.material.SwipeableKt$swipeable-pPrIpRY$$inlined$debugInspectorInfo$1 r1 = new androidx.compose.material.SwipeableKt$swipeable-pPrIpRY$$inlined$debugInspectorInfo$1
            r2 = r1
            r3 = r17
            r4 = r18
            r5 = r19
            r6 = r20
            r7 = r21
            r8 = r22
            r9 = r23
            r10 = r24
            r11 = r25
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            goto L_0x0046
        L_0x0042:
            kotlin.jvm.functions.Function1 r1 = androidx.compose.ui.platform.InspectableValueKt.getNoInspectorInfo()
        L_0x0046:
            androidx.compose.material.SwipeableKt$swipeable$3 r11 = new androidx.compose.material.SwipeableKt$swipeable$3
            r2 = r11
            r3 = r18
            r4 = r17
            r5 = r19
            r6 = r20
            r7 = r22
            r8 = r21
            r9 = r24
            r10 = r23
            r12 = r11
            r11 = r25
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.ComposedModifierKt.composed(r0, r1, r12)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SwipeableKt.m1394swipeablepPrIpRY(androidx.compose.ui.Modifier, androidx.compose.material.SwipeableState, java.util.Map, androidx.compose.foundation.gestures.Orientation, boolean, boolean, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function2, androidx.compose.material.ResistanceConfig, float):androidx.compose.ui.Modifier");
    }

    /* renamed from: swipeable-pPrIpRY$default  reason: not valid java name */
    public static /* synthetic */ Modifier m1395swipeablepPrIpRY$default(Modifier modifier, SwipeableState swipeableState, Map map, Orientation orientation, boolean z11, boolean z12, MutableInteractionSource mutableInteractionSource, Function2 function2, ResistanceConfig resistanceConfig, float f11, int i11, Object obj) {
        boolean z13;
        boolean z14;
        MutableInteractionSource mutableInteractionSource2;
        SwipeableKt$swipeable$1 swipeableKt$swipeable$1;
        ResistanceConfig resistanceConfig2;
        float f12;
        int i12 = i11;
        if ((i12 & 8) != 0) {
            z13 = true;
        } else {
            z13 = z11;
        }
        if ((i12 & 16) != 0) {
            z14 = false;
        } else {
            z14 = z12;
        }
        if ((i12 & 32) != 0) {
            mutableInteractionSource2 = null;
        } else {
            mutableInteractionSource2 = mutableInteractionSource;
        }
        if ((i12 & 64) != 0) {
            swipeableKt$swipeable$1 = SwipeableKt$swipeable$1.INSTANCE;
        } else {
            swipeableKt$swipeable$1 = function2;
        }
        if ((i12 & 128) != 0) {
            resistanceConfig2 = SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, map.keySet(), 0.0f, 0.0f, 6, (Object) null);
        } else {
            resistanceConfig2 = resistanceConfig;
        }
        if ((i12 & 256) != 0) {
            f12 = SwipeableDefaults.INSTANCE.m1393getVelocityThresholdD9Ej5fM();
        } else {
            f12 = f11;
        }
        return m1394swipeablepPrIpRY(modifier, swipeableState, map, orientation, z13, z14, mutableInteractionSource2, swipeableKt$swipeable$1, resistanceConfig2, f12);
    }
}
