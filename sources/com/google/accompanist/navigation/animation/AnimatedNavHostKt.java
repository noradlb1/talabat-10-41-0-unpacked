package com.google.accompanist.navigation.animation;

import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.ExperimentalAnimationApi;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavGraph;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavHostController;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aµ\u0001\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\u001f\b\u0002\u0010 \u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0002\b\u00072\u001f\b\u0002\u0010!\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\r0\u0003¢\u0006\u0002\b\u00072\u001f\b\u0002\u0010\"\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0002\b\u00072\u001f\b\u0002\u0010#\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\r0\u0003¢\u0006\u0002\b\u0007H\u0007¢\u0006\u0002\u0010$\u001aÚ\u0001\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u00022\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00022\u001f\b\u0002\u0010 \u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0002\b\u00072\u001f\b\u0002\u0010!\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\r0\u0003¢\u0006\u0002\b\u00072\u001f\b\u0002\u0010\"\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0002\b\u00072\u001f\b\u0002\u0010#\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\r0\u0003¢\u0006\u0002\b\u00072\u0017\u0010'\u001a\u0013\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00170\u0003¢\u0006\u0002\b\u0007H\u0007¢\u0006\u0002\u0010)\"E\u0010\u0000\u001a+\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u001f\u0012\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0003¢\u0006\u0002\b\u00070\u00018\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"E\u0010\f\u001a+\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u001f\u0012\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u0003¢\u0006\u0002\b\u00070\u00018\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000b\"E\u0010\u0010\u001a+\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u001f\u0012\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0003¢\u0006\u0002\b\u00070\u00018\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\t\u001a\u0004\b\u0012\u0010\u000b\"E\u0010\u0013\u001a+\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u001f\u0012\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u0003¢\u0006\u0002\b\u00070\u00018\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\t\u001a\u0004\b\u0015\u0010\u000b¨\u0006*"}, d2 = {"enterTransitions", "", "", "Lkotlin/Function1;", "Landroidx/compose/animation/AnimatedContentScope;", "Landroidx/navigation/NavBackStackEntry;", "Landroidx/compose/animation/EnterTransition;", "Lkotlin/ExtensionFunctionType;", "getEnterTransitions$annotations", "()V", "getEnterTransitions", "()Ljava/util/Map;", "exitTransitions", "Landroidx/compose/animation/ExitTransition;", "getExitTransitions$annotations", "getExitTransitions", "popEnterTransitions", "getPopEnterTransitions$annotations", "getPopEnterTransitions", "popExitTransitions", "getPopExitTransitions$annotations", "getPopExitTransitions", "AnimatedNavHost", "", "navController", "Landroidx/navigation/NavHostController;", "graph", "Landroidx/navigation/NavGraph;", "modifier", "Landroidx/compose/ui/Modifier;", "contentAlignment", "Landroidx/compose/ui/Alignment;", "enterTransition", "exitTransition", "popEnterTransition", "popExitTransition", "(Landroidx/navigation/NavHostController;Landroidx/navigation/NavGraph;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "startDestination", "route", "builder", "Landroidx/navigation/NavGraphBuilder;", "(Landroidx/navigation/NavHostController;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "navigation-animation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class AnimatedNavHostKt {
    @NotNull
    private static final Map<String, Function1<AnimatedContentScope<NavBackStackEntry>, EnterTransition>> enterTransitions = new LinkedHashMap();
    @NotNull
    private static final Map<String, Function1<AnimatedContentScope<NavBackStackEntry>, ExitTransition>> exitTransitions = new LinkedHashMap();
    @NotNull
    private static final Map<String, Function1<AnimatedContentScope<NavBackStackEntry>, EnterTransition>> popEnterTransitions = new LinkedHashMap();
    @NotNull
    private static final Map<String, Function1<AnimatedContentScope<NavBackStackEntry>, ExitTransition>> popExitTransitions = new LinkedHashMap();

    @ExperimentalAnimationApi
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void AnimatedNavHost(@NotNull NavHostController navHostController, @NotNull String str, @Nullable Modifier modifier, @Nullable Alignment alignment, @Nullable String str2, @Nullable Function1<? super AnimatedContentScope<NavBackStackEntry>, ? extends EnterTransition> function1, @Nullable Function1<? super AnimatedContentScope<NavBackStackEntry>, ? extends ExitTransition> function12, @Nullable Function1<? super AnimatedContentScope<NavBackStackEntry>, ? extends EnterTransition> function13, @Nullable Function1<? super AnimatedContentScope<NavBackStackEntry>, ? extends ExitTransition> function14, @NotNull Function1<? super NavGraphBuilder, Unit> function15, @Nullable Composer composer, int i11, int i12) {
        int i13;
        Function1<? super AnimatedContentScope<NavBackStackEntry>, ? extends EnterTransition> function16;
        int i14;
        Function1<? super AnimatedContentScope<NavBackStackEntry>, ? extends ExitTransition> function17;
        String str3 = str;
        Function1<? super NavGraphBuilder, Unit> function18 = function15;
        int i15 = i12;
        Intrinsics.checkNotNullParameter(navHostController, "navController");
        Intrinsics.checkNotNullParameter(str3, "startDestination");
        Intrinsics.checkNotNullParameter(function18, "builder");
        Composer startRestartGroup = composer.startRestartGroup(1786657914);
        Modifier modifier2 = (i15 & 4) != 0 ? Modifier.Companion : modifier;
        Alignment center = (i15 & 8) != 0 ? Alignment.Companion.getCenter() : alignment;
        String str4 = (i15 & 16) != 0 ? null : str2;
        Function1<? super AnimatedContentScope<NavBackStackEntry>, ? extends EnterTransition> function19 = (i15 & 32) != 0 ? AnimatedNavHostKt$AnimatedNavHost$1.INSTANCE : function1;
        Function1<? super AnimatedContentScope<NavBackStackEntry>, ? extends ExitTransition> function110 = (i15 & 64) != 0 ? AnimatedNavHostKt$AnimatedNavHost$2.INSTANCE : function12;
        if ((i15 & 128) != 0) {
            i13 = i11 & -29360129;
            function16 = function19;
        } else {
            function16 = function13;
            i13 = i11;
        }
        if ((i15 & 256) != 0) {
            i14 = i13 & -234881025;
            function17 = function110;
        } else {
            i14 = i13;
            function17 = function14;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1786657914, i14, -1, "com.google.accompanist.navigation.animation.AnimatedNavHost (AnimatedNavHost.kt:73)");
        }
        startRestartGroup.startReplaceableGroup(1618982084);
        boolean changed = startRestartGroup.changed((Object) str4) | startRestartGroup.changed((Object) str3) | startRestartGroup.changed((Object) function18);
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navHostController.getNavigatorProvider(), str3, str4);
            function18.invoke(navGraphBuilder);
            rememberedValue = navGraphBuilder.build();
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        int i16 = i14 >> 3;
        AnimatedNavHost(navHostController, (NavGraph) rememberedValue, modifier2, center, function19, function110, function16, function17, startRestartGroup, (i14 & 896) | 72 | (i14 & 7168) | (57344 & i16) | (458752 & i16) | (3670016 & i16) | (i16 & 29360128), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new AnimatedNavHostKt$AnimatedNavHost$4(navHostController, str, modifier2, center, str4, function19, function110, function16, function17, function15, i11, i12));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: AnimatedNavHost$lambda-5  reason: not valid java name */
    public static final List<NavBackStackEntry> m9019AnimatedNavHost$lambda5(State<? extends List<NavBackStackEntry>> state) {
        return (List) state.getValue();
    }

    @NotNull
    public static final Map<String, Function1<AnimatedContentScope<NavBackStackEntry>, EnterTransition>> getEnterTransitions() {
        return enterTransitions;
    }

    @ExperimentalAnimationApi
    public static /* synthetic */ void getEnterTransitions$annotations() {
    }

    @NotNull
    public static final Map<String, Function1<AnimatedContentScope<NavBackStackEntry>, ExitTransition>> getExitTransitions() {
        return exitTransitions;
    }

    @ExperimentalAnimationApi
    public static /* synthetic */ void getExitTransitions$annotations() {
    }

    @NotNull
    public static final Map<String, Function1<AnimatedContentScope<NavBackStackEntry>, EnterTransition>> getPopEnterTransitions() {
        return popEnterTransitions;
    }

    @ExperimentalAnimationApi
    public static /* synthetic */ void getPopEnterTransitions$annotations() {
    }

    @NotNull
    public static final Map<String, Function1<AnimatedContentScope<NavBackStackEntry>, ExitTransition>> getPopExitTransitions() {
        return popExitTransitions;
    }

    @ExperimentalAnimationApi
    public static /* synthetic */ void getPopExitTransitions$annotations() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v7, resolved type: kotlinx.coroutines.flow.Flow} */
    /* JADX WARNING: type inference failed for: r0v11, types: [androidx.navigation.Navigator] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    @androidx.compose.animation.ExperimentalAnimationApi
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void AnimatedNavHost(@org.jetbrains.annotations.NotNull androidx.navigation.NavHostController r21, @org.jetbrains.annotations.NotNull androidx.navigation.NavGraph r22, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r23, @org.jetbrains.annotations.Nullable androidx.compose.ui.Alignment r24, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function1<? super androidx.compose.animation.AnimatedContentScope<androidx.navigation.NavBackStackEntry>, ? extends androidx.compose.animation.EnterTransition> r25, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function1<? super androidx.compose.animation.AnimatedContentScope<androidx.navigation.NavBackStackEntry>, ? extends androidx.compose.animation.ExitTransition> r26, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function1<? super androidx.compose.animation.AnimatedContentScope<androidx.navigation.NavBackStackEntry>, ? extends androidx.compose.animation.EnterTransition> r27, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function1<? super androidx.compose.animation.AnimatedContentScope<androidx.navigation.NavBackStackEntry>, ? extends androidx.compose.animation.ExitTransition> r28, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r29, int r30, int r31) {
        /*
            r1 = r21
            r10 = r31
            java.lang.String r0 = "navController"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "graph"
            r2 = r22
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            r0 = -1872959790(0xffffffff905ce6d2, float:-4.3565167E-29)
            r3 = r29
            androidx.compose.runtime.Composer r3 = r3.startRestartGroup(r0)
            r4 = r10 & 4
            if (r4 == 0) goto L_0x0020
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            goto L_0x0022
        L_0x0020:
            r4 = r23
        L_0x0022:
            r5 = r10 & 8
            if (r5 == 0) goto L_0x002d
            androidx.compose.ui.Alignment$Companion r5 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r5 = r5.getCenter()
            goto L_0x002f
        L_0x002d:
            r5 = r24
        L_0x002f:
            r6 = r10 & 16
            if (r6 == 0) goto L_0x0036
            com.google.accompanist.navigation.animation.AnimatedNavHostKt$AnimatedNavHost$5 r6 = com.google.accompanist.navigation.animation.AnimatedNavHostKt$AnimatedNavHost$5.INSTANCE
            goto L_0x0038
        L_0x0036:
            r6 = r25
        L_0x0038:
            r7 = r10 & 32
            if (r7 == 0) goto L_0x003f
            com.google.accompanist.navigation.animation.AnimatedNavHostKt$AnimatedNavHost$6 r7 = com.google.accompanist.navigation.animation.AnimatedNavHostKt$AnimatedNavHost$6.INSTANCE
            goto L_0x0041
        L_0x003f:
            r7 = r26
        L_0x0041:
            r8 = r10 & 64
            if (r8 == 0) goto L_0x004d
            r8 = -3670017(0xffffffffffc7ffff, float:NaN)
            r8 = r30 & r8
            r9 = r8
            r8 = r6
            goto L_0x0051
        L_0x004d:
            r8 = r27
            r9 = r30
        L_0x0051:
            r11 = r10 & 128(0x80, float:1.794E-43)
            if (r11 == 0) goto L_0x005c
            r11 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r9 = r9 & r11
            r11 = r9
            r9 = r7
            goto L_0x005f
        L_0x005c:
            r11 = r9
            r9 = r28
        L_0x005f:
            boolean r12 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r12 == 0) goto L_0x006b
            r12 = -1
            java.lang.String r13 = "com.google.accompanist.navigation.animation.AnimatedNavHost (AnimatedNavHost.kt:117)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r11, r12, r13)
        L_0x006b:
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalLifecycleOwner()
            java.lang.Object r0 = r3.consume(r0)
            androidx.lifecycle.LifecycleOwner r0 = (androidx.lifecycle.LifecycleOwner) r0
            androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner r12 = androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner.INSTANCE
            r13 = 8
            androidx.lifecycle.ViewModelStoreOwner r12 = r12.getCurrent(r3, r13)
            if (r12 == 0) goto L_0x029e
            androidx.activity.compose.LocalOnBackPressedDispatcherOwner r14 = androidx.activity.compose.LocalOnBackPressedDispatcherOwner.INSTANCE
            androidx.activity.OnBackPressedDispatcherOwner r13 = r14.getCurrent(r3, r13)
            r20 = 0
            if (r13 == 0) goto L_0x008e
            androidx.activity.OnBackPressedDispatcher r13 = r13.getOnBackPressedDispatcher()
            goto L_0x0090
        L_0x008e:
            r13 = r20
        L_0x0090:
            r1.setLifecycleOwner(r0)
            androidx.lifecycle.ViewModelStore r0 = r12.getViewModelStore()
            java.lang.String r12 = "viewModelStoreOwner.viewModelStore"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r12)
            r1.setViewModelStore(r0)
            if (r13 == 0) goto L_0x00a4
            r1.setOnBackPressedDispatcher(r13)
        L_0x00a4:
            r21.setGraph((androidx.navigation.NavGraph) r22)
            r0 = 0
            androidx.compose.runtime.saveable.SaveableStateHolder r12 = androidx.compose.runtime.saveable.SaveableStateHolderKt.rememberSaveableStateHolder(r3, r0)
            androidx.navigation.NavigatorProvider r13 = r21.getNavigatorProvider()
            java.lang.String r14 = "animatedComposable"
            androidx.navigation.Navigator r13 = r13.getNavigator((java.lang.String) r14)
            boolean r14 = r13 instanceof com.google.accompanist.navigation.animation.AnimatedComposeNavigator
            if (r14 == 0) goto L_0x00be
            com.google.accompanist.navigation.animation.AnimatedComposeNavigator r13 = (com.google.accompanist.navigation.animation.AnimatedComposeNavigator) r13
            r15 = r13
            goto L_0x00c0
        L_0x00be:
            r15 = r20
        L_0x00c0:
            if (r15 != 0) goto L_0x00ea
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x00cb
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00cb:
            androidx.compose.runtime.ScopeUpdateScope r11 = r3.endRestartGroup()
            if (r11 != 0) goto L_0x00d2
            goto L_0x00e9
        L_0x00d2:
            com.google.accompanist.navigation.animation.AnimatedNavHostKt$AnimatedNavHost$composeNavigator$1 r12 = new com.google.accompanist.navigation.animation.AnimatedNavHostKt$AnimatedNavHost$composeNavigator$1
            r0 = r12
            r1 = r21
            r2 = r22
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r9
            r9 = r30
            r10 = r31
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r11.updateScope(r12)
        L_0x00e9:
            return
        L_0x00ea:
            kotlinx.coroutines.flow.StateFlow r13 = r21.getVisibleEntries()
            r14 = 1157296644(0x44faf204, float:2007.563)
            r3.startReplaceableGroup(r14)
            boolean r13 = r3.changed((java.lang.Object) r13)
            java.lang.Object r14 = r3.rememberedValue()
            if (r13 != 0) goto L_0x0106
            androidx.compose.runtime.Composer$Companion r13 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r13 = r13.getEmpty()
            if (r14 != r13) goto L_0x0112
        L_0x0106:
            kotlinx.coroutines.flow.StateFlow r13 = r21.getVisibleEntries()
            com.google.accompanist.navigation.animation.AnimatedNavHostKt$AnimatedNavHost$lambda-4$$inlined$map$1 r14 = new com.google.accompanist.navigation.animation.AnimatedNavHostKt$AnimatedNavHost$lambda-4$$inlined$map$1
            r14.<init>(r13)
            r3.updateRememberedValue(r14)
        L_0x0112:
            r3.endReplaceableGroup()
            r13 = r14
            kotlinx.coroutines.flow.Flow r13 = (kotlinx.coroutines.flow.Flow) r13
            java.util.List r14 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            r16 = 0
            r17 = 8
            r18 = 2
            r23 = r13
            r24 = r14
            r25 = r16
            r26 = r3
            r27 = r17
            r28 = r18
            androidx.compose.runtime.State r14 = androidx.compose.runtime.SnapshotStateKt.collectAsState(r23, r24, r25, r26, r27, r28)
            java.util.List r13 = m9019AnimatedNavHost$lambda5(r14)
            java.lang.Object r13 = kotlin.collections.CollectionsKt___CollectionsKt.lastOrNull(r13)
            androidx.navigation.NavBackStackEntry r13 = (androidx.navigation.NavBackStackEntry) r13
            r0 = 92481947(0x583299b, float:1.2334464E-35)
            r3.startReplaceableGroup(r0)
            if (r13 == 0) goto L_0x0230
            r0 = 1618982084(0x607fb4c4, float:7.370227E19)
            r3.startReplaceableGroup(r0)
            boolean r16 = r3.changed((java.lang.Object) r15)
            boolean r17 = r3.changed((java.lang.Object) r8)
            r16 = r16 | r17
            boolean r17 = r3.changed((java.lang.Object) r6)
            r16 = r16 | r17
            java.lang.Object r0 = r3.rememberedValue()
            if (r16 != 0) goto L_0x0168
            androidx.compose.runtime.Composer$Companion r16 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r16.getEmpty()
            if (r0 != r1) goto L_0x0170
        L_0x0168:
            com.google.accompanist.navigation.animation.AnimatedNavHostKt$AnimatedNavHost$finalEnter$1$1 r0 = new com.google.accompanist.navigation.animation.AnimatedNavHostKt$AnimatedNavHost$finalEnter$1$1
            r0.<init>(r15, r8, r6)
            r3.updateRememberedValue(r0)
        L_0x0170:
            r3.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r1 = 1618982084(0x607fb4c4, float:7.370227E19)
            r3.startReplaceableGroup(r1)
            boolean r1 = r3.changed((java.lang.Object) r15)
            boolean r16 = r3.changed((java.lang.Object) r9)
            r1 = r1 | r16
            boolean r16 = r3.changed((java.lang.Object) r7)
            r1 = r1 | r16
            java.lang.Object r2 = r3.rememberedValue()
            if (r1 != 0) goto L_0x0199
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r2 != r1) goto L_0x01a1
        L_0x0199:
            com.google.accompanist.navigation.animation.AnimatedNavHostKt$AnimatedNavHost$finalExit$1$1 r2 = new com.google.accompanist.navigation.animation.AnimatedNavHostKt$AnimatedNavHost$finalExit$1$1
            r2.<init>(r15, r9, r7)
            r3.updateRememberedValue(r2)
        L_0x01a1:
            r3.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            java.lang.String r1 = "entry"
            r10 = 56
            r25 = r15
            r15 = 0
            androidx.compose.animation.core.Transition r1 = androidx.compose.animation.core.TransitionKt.updateTransition(r13, (java.lang.String) r1, (androidx.compose.runtime.Composer) r3, (int) r10, (int) r15)
            r10 = 1618982084(0x607fb4c4, float:7.370227E19)
            r3.startReplaceableGroup(r10)
            boolean r10 = r3.changed((java.lang.Object) r14)
            boolean r13 = r3.changed((java.lang.Object) r0)
            r10 = r10 | r13
            boolean r13 = r3.changed((java.lang.Object) r2)
            r10 = r10 | r13
            java.lang.Object r13 = r3.rememberedValue()
            if (r10 != 0) goto L_0x01d3
            androidx.compose.runtime.Composer$Companion r10 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r10 = r10.getEmpty()
            if (r13 != r10) goto L_0x01db
        L_0x01d3:
            com.google.accompanist.navigation.animation.AnimatedNavHostKt$AnimatedNavHost$7$1 r13 = new com.google.accompanist.navigation.animation.AnimatedNavHostKt$AnimatedNavHost$7$1
            r13.<init>(r0, r2, r14)
            r3.updateRememberedValue(r13)
        L_0x01db:
            r3.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r13 = (kotlin.jvm.functions.Function1) r13
            com.google.accompanist.navigation.animation.AnimatedNavHostKt$AnimatedNavHost$8 r15 = com.google.accompanist.navigation.animation.AnimatedNavHostKt$AnimatedNavHost$8.INSTANCE
            com.google.accompanist.navigation.animation.AnimatedNavHostKt$AnimatedNavHost$9 r0 = new com.google.accompanist.navigation.animation.AnimatedNavHostKt$AnimatedNavHost$9
            r0.<init>(r12, r14)
            r2 = 1242637642(0x4a11254a, float:2378066.5)
            r10 = 1
            androidx.compose.runtime.internal.ComposableLambda r16 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r3, r2, r10, r0)
            int r0 = r11 >> 3
            r0 = r0 & 112(0x70, float:1.57E-43)
            r2 = 221184(0x36000, float:3.09945E-40)
            r0 = r0 | r2
            r2 = r11 & 7168(0x1c00, float:1.0045E-41)
            r18 = r0 | r2
            r19 = 0
            r11 = r1
            r12 = r4
            r0 = r14
            r14 = r5
            r2 = r25
            r17 = r3
            androidx.compose.animation.AnimatedContentKt.AnimatedContent(r11, r12, r13, r14, r15, r16, r17, r18, r19)
            java.lang.Object r10 = r1.getCurrentState()
            java.lang.Object r1 = r1.getTargetState()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r1)
            if (r1 == 0) goto L_0x0230
            java.util.List r0 = m9019AnimatedNavHost$lambda5(r0)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0220:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0230
            java.lang.Object r1 = r0.next()
            androidx.navigation.NavBackStackEntry r1 = (androidx.navigation.NavBackStackEntry) r1
            r2.markTransitionComplete$navigation_animation_release(r1)
            goto L_0x0220
        L_0x0230:
            r3.endReplaceableGroup()
            androidx.navigation.NavigatorProvider r0 = r21.getNavigatorProvider()
            java.lang.String r1 = "dialog"
            androidx.navigation.Navigator r0 = r0.getNavigator((java.lang.String) r1)
            boolean r1 = r0 instanceof androidx.navigation.compose.DialogNavigator
            if (r1 == 0) goto L_0x0245
            r20 = r0
            androidx.navigation.compose.DialogNavigator r20 = (androidx.navigation.compose.DialogNavigator) r20
        L_0x0245:
            r0 = r20
            if (r0 != 0) goto L_0x0271
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0252
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0252:
            androidx.compose.runtime.ScopeUpdateScope r11 = r3.endRestartGroup()
            if (r11 != 0) goto L_0x0259
            goto L_0x0270
        L_0x0259:
            com.google.accompanist.navigation.animation.AnimatedNavHostKt$AnimatedNavHost$dialogNavigator$1 r12 = new com.google.accompanist.navigation.animation.AnimatedNavHostKt$AnimatedNavHost$dialogNavigator$1
            r0 = r12
            r1 = r21
            r2 = r22
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r9
            r9 = r30
            r10 = r31
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r11.updateScope(r12)
        L_0x0270:
            return
        L_0x0271:
            int r1 = androidx.navigation.compose.DialogNavigator.$stable
            androidx.navigation.compose.DialogHostKt.DialogHost(r0, r3, r1)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x027f
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x027f:
            androidx.compose.runtime.ScopeUpdateScope r11 = r3.endRestartGroup()
            if (r11 != 0) goto L_0x0286
            goto L_0x029d
        L_0x0286:
            com.google.accompanist.navigation.animation.AnimatedNavHostKt$AnimatedNavHost$11 r12 = new com.google.accompanist.navigation.animation.AnimatedNavHostKt$AnimatedNavHost$11
            r0 = r12
            r1 = r21
            r2 = r22
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r9
            r9 = r30
            r10 = r31
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r11.updateScope(r12)
        L_0x029d:
            return
        L_0x029e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "NavHost requires a ViewModelStoreOwner to be provided via LocalViewModelStoreOwner"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.accompanist.navigation.animation.AnimatedNavHostKt.AnimatedNavHost(androidx.navigation.NavHostController, androidx.navigation.NavGraph, androidx.compose.ui.Modifier, androidx.compose.ui.Alignment, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }
}
