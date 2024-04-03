package androidx.navigation.compose;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavGraph;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavHostController;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b\u001aL\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"NavHost", "", "navController", "Landroidx/navigation/NavHostController;", "graph", "Landroidx/navigation/NavGraph;", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/navigation/NavHostController;Landroidx/navigation/NavGraph;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "startDestination", "", "route", "builder", "Lkotlin/Function1;", "Landroidx/navigation/NavGraphBuilder;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/navigation/NavHostController;Ljava/lang/String;Landroidx/compose/ui/Modifier;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "navigation-compose_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class NavHostKt {
    @Composable
    public static final void NavHost(@NotNull NavHostController navHostController, @NotNull String str, @Nullable Modifier modifier, @Nullable String str2, @NotNull Function1<? super NavGraphBuilder, Unit> function1, @Nullable Composer composer, int i11, int i12) {
        String str3 = str;
        Function1<? super NavGraphBuilder, Unit> function12 = function1;
        NavHostController navHostController2 = navHostController;
        Intrinsics.checkNotNullParameter(navHostController, "navController");
        Intrinsics.checkNotNullParameter(str, "startDestination");
        Intrinsics.checkNotNullParameter(function12, "builder");
        Composer startRestartGroup = composer.startRestartGroup(141827520);
        Modifier modifier2 = (i12 & 4) != 0 ? Modifier.Companion : modifier;
        String str4 = (i12 & 8) != 0 ? null : str2;
        startRestartGroup.startReplaceableGroup(-3686095);
        boolean changed = startRestartGroup.changed((Object) str4) | startRestartGroup.changed((Object) str) | startRestartGroup.changed((Object) function12);
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navHostController.getNavigatorProvider(), str, str4);
            function12.invoke(navGraphBuilder);
            rememberedValue = navGraphBuilder.build();
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        NavHost(navHostController, (NavGraph) rememberedValue, modifier2, startRestartGroup, (i11 & 896) | 72, 0);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new NavHostKt$NavHost$2(navHostController, str, modifier2, str4, function1, i11, i12));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: NavHost$lambda-5  reason: not valid java name */
    public static final List<NavBackStackEntry> m9108NavHost$lambda5(State<? extends List<NavBackStackEntry>> state) {
        return (List) state.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: NavHost$lambda-7  reason: not valid java name */
    public static final boolean m9109NavHost$lambda7(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: NavHost$lambda-8  reason: not valid java name */
    public static final void m9110NavHost$lambda8(MutableState<Boolean> mutableState, boolean z11) {
        mutableState.setValue(Boolean.valueOf(z11));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: kotlinx.coroutines.flow.Flow} */
    /* JADX WARNING: type inference failed for: r1v11, types: [androidx.navigation.Navigator] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void NavHost(@org.jetbrains.annotations.NotNull androidx.navigation.NavHostController r10, @org.jetbrains.annotations.NotNull androidx.navigation.NavGraph r11, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r12, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r13, int r14, int r15) {
        /*
            java.lang.String r0 = "navController"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "graph"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r0 = -957014592(0xffffffffc6f51dc0, float:-31374.875)
            androidx.compose.runtime.Composer r13 = r13.startRestartGroup(r0)
            r0 = r15 & 4
            if (r0 == 0) goto L_0x0017
            androidx.compose.ui.Modifier$Companion r12 = androidx.compose.ui.Modifier.Companion
        L_0x0017:
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalLifecycleOwner()
            java.lang.Object r0 = r13.consume(r0)
            androidx.lifecycle.LifecycleOwner r0 = (androidx.lifecycle.LifecycleOwner) r0
            androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner r1 = androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner.INSTANCE
            r2 = 8
            androidx.lifecycle.ViewModelStoreOwner r1 = r1.getCurrent(r13, r2)
            if (r1 == 0) goto L_0x015e
            androidx.activity.compose.LocalOnBackPressedDispatcherOwner r3 = androidx.activity.compose.LocalOnBackPressedDispatcherOwner.INSTANCE
            androidx.activity.OnBackPressedDispatcherOwner r3 = r3.getCurrent(r13, r2)
            r8 = 0
            if (r3 == 0) goto L_0x0039
            androidx.activity.OnBackPressedDispatcher r3 = r3.getOnBackPressedDispatcher()
            goto L_0x003a
        L_0x0039:
            r3 = r8
        L_0x003a:
            r10.setLifecycleOwner(r0)
            androidx.lifecycle.ViewModelStore r0 = r1.getViewModelStore()
            java.lang.String r1 = "viewModelStoreOwner.viewModelStore"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r10.setViewModelStore(r0)
            if (r3 == 0) goto L_0x004f
            r10.setOnBackPressedDispatcher(r3)
        L_0x004f:
            androidx.navigation.compose.NavHostKt$NavHost$3 r0 = new androidx.navigation.compose.NavHostKt$NavHost$3
            r0.<init>(r10)
            androidx.compose.runtime.EffectsKt.DisposableEffect((java.lang.Object) r10, (kotlin.jvm.functions.Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult>) r0, (androidx.compose.runtime.Composer) r13, (int) r2)
            r10.setGraph((androidx.navigation.NavGraph) r11)
            r0 = 0
            androidx.compose.runtime.saveable.SaveableStateHolder r7 = androidx.compose.runtime.saveable.SaveableStateHolderKt.rememberSaveableStateHolder(r13, r0)
            androidx.navigation.NavigatorProvider r1 = r10.getNavigatorProvider()
            java.lang.String r2 = "composable"
            androidx.navigation.Navigator r1 = r1.getNavigator((java.lang.String) r2)
            boolean r2 = r1 instanceof androidx.navigation.compose.ComposeNavigator
            if (r2 == 0) goto L_0x0071
            androidx.navigation.compose.ComposeNavigator r1 = (androidx.navigation.compose.ComposeNavigator) r1
            r9 = r1
            goto L_0x0072
        L_0x0071:
            r9 = r8
        L_0x0072:
            if (r9 != 0) goto L_0x008a
            androidx.compose.runtime.ScopeUpdateScope r13 = r13.endRestartGroup()
            if (r13 != 0) goto L_0x007b
            goto L_0x0089
        L_0x007b:
            androidx.navigation.compose.NavHostKt$NavHost$composeNavigator$1 r6 = new androidx.navigation.compose.NavHostKt$NavHost$composeNavigator$1
            r0 = r6
            r1 = r10
            r2 = r11
            r3 = r12
            r4 = r14
            r5 = r15
            r0.<init>(r1, r2, r3, r4, r5)
            r13.updateScope(r6)
        L_0x0089:
            return
        L_0x008a:
            kotlinx.coroutines.flow.StateFlow r1 = r10.getVisibleEntries()
            r2 = -3686930(0xffffffffffc7bdee, float:NaN)
            r13.startReplaceableGroup(r2)
            boolean r1 = r13.changed((java.lang.Object) r1)
            java.lang.Object r2 = r13.rememberedValue()
            if (r1 != 0) goto L_0x00a6
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r2 != r1) goto L_0x00b2
        L_0x00a6:
            kotlinx.coroutines.flow.StateFlow r1 = r10.getVisibleEntries()
            androidx.navigation.compose.NavHostKt$NavHost$lambda-4$$inlined$map$1 r2 = new androidx.navigation.compose.NavHostKt$NavHost$lambda-4$$inlined$map$1
            r2.<init>(r1)
            r13.updateRememberedValue(r2)
        L_0x00b2:
            r13.endReplaceableGroup()
            r1 = r2
            kotlinx.coroutines.flow.Flow r1 = (kotlinx.coroutines.flow.Flow) r1
            java.util.List r2 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            r3 = 0
            r5 = 8
            r6 = 2
            r4 = r13
            androidx.compose.runtime.State r1 = androidx.compose.runtime.SnapshotStateKt.collectAsState(r1, r2, r3, r4, r5, r6)
            java.util.List r2 = m9108NavHost$lambda5(r1)
            java.lang.Object r2 = kotlin.collections.CollectionsKt___CollectionsKt.lastOrNull(r2)
            androidx.navigation.NavBackStackEntry r2 = (androidx.navigation.NavBackStackEntry) r2
            r3 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r13.startReplaceableGroup(r3)
            java.lang.Object r3 = r13.rememberedValue()
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r3 != r4) goto L_0x00eb
            java.lang.Boolean r3 = java.lang.Boolean.TRUE
            r4 = 2
            androidx.compose.runtime.MutableState r3 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r3, r8, r4, r8)
            r13.updateRememberedValue(r3)
        L_0x00eb:
            r13.endReplaceableGroup()
            androidx.compose.runtime.MutableState r3 = (androidx.compose.runtime.MutableState) r3
            r4 = 1822173528(0x6c9c2958, float:1.5103013E27)
            r13.startReplaceableGroup(r4)
            if (r2 == 0) goto L_0x0119
            java.lang.String r2 = r2.getId()
            r4 = 0
            androidx.navigation.compose.NavHostKt$NavHost$4 r5 = new androidx.navigation.compose.NavHostKt$NavHost$4
            r5.<init>(r3, r1, r9, r7)
            r1 = 1319254703(0x4ea23aaf, float:1.36087744E9)
            r3 = 1
            androidx.compose.runtime.internal.ComposableLambda r5 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r13, r1, r3, r5)
            int r1 = r14 >> 3
            r1 = r1 & 112(0x70, float:1.57E-43)
            r6 = r1 | 3072(0xc00, float:4.305E-42)
            r7 = 4
            r1 = r2
            r2 = r12
            r3 = r4
            r4 = r5
            r5 = r13
            androidx.compose.animation.CrossfadeKt.Crossfade(r1, r2, r3, r4, r5, r6, r7)
        L_0x0119:
            r13.endReplaceableGroup()
            androidx.navigation.NavigatorProvider r1 = r10.getNavigatorProvider()
            java.lang.String r2 = "dialog"
            androidx.navigation.Navigator r1 = r1.getNavigator((java.lang.String) r2)
            boolean r2 = r1 instanceof androidx.navigation.compose.DialogNavigator
            if (r2 == 0) goto L_0x012d
            r8 = r1
            androidx.navigation.compose.DialogNavigator r8 = (androidx.navigation.compose.DialogNavigator) r8
        L_0x012d:
            if (r8 != 0) goto L_0x0145
            androidx.compose.runtime.ScopeUpdateScope r13 = r13.endRestartGroup()
            if (r13 != 0) goto L_0x0136
            goto L_0x0144
        L_0x0136:
            androidx.navigation.compose.NavHostKt$NavHost$dialogNavigator$1 r6 = new androidx.navigation.compose.NavHostKt$NavHost$dialogNavigator$1
            r0 = r6
            r1 = r10
            r2 = r11
            r3 = r12
            r4 = r14
            r5 = r15
            r0.<init>(r1, r2, r3, r4, r5)
            r13.updateScope(r6)
        L_0x0144:
            return
        L_0x0145:
            androidx.navigation.compose.DialogHostKt.DialogHost(r8, r13, r0)
            androidx.compose.runtime.ScopeUpdateScope r13 = r13.endRestartGroup()
            if (r13 != 0) goto L_0x014f
            goto L_0x015d
        L_0x014f:
            androidx.navigation.compose.NavHostKt$NavHost$5 r6 = new androidx.navigation.compose.NavHostKt$NavHost$5
            r0 = r6
            r1 = r10
            r2 = r11
            r3 = r12
            r4 = r14
            r5 = r15
            r0.<init>(r1, r2, r3, r4, r5)
            r13.updateScope(r6)
        L_0x015d:
            return
        L_0x015e:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "NavHost requires a ViewModelStoreOwner to be provided via LocalViewModelStoreOwner"
            java.lang.String r11 = r11.toString()
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.compose.NavHostKt.NavHost(androidx.navigation.NavHostController, androidx.navigation.NavGraph, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }
}
