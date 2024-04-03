package androidx.navigation.compose;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.compose.runtime.saveable.SaveableStateHolderKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.compose.DialogNavigator;
import com.google.android.exoplayer2.RendererCapabilities;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004\u001a!\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tH\u0001¢\u0006\u0002\u0010\n\u001a%\u0010\u000b\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00070\f2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tH\u0001¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"DialogHost", "", "dialogNavigator", "Landroidx/navigation/compose/DialogNavigator;", "(Landroidx/navigation/compose/DialogNavigator;Landroidx/compose/runtime/Composer;I)V", "rememberVisibleList", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "Landroidx/navigation/NavBackStackEntry;", "transitionsInProgress", "", "(Ljava/util/Collection;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/snapshots/SnapshotStateList;", "PopulateVisibleList", "", "(Ljava/util/List;Ljava/util/Collection;Landroidx/compose/runtime/Composer;I)V", "navigation-compose_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class DialogHostKt {
    @Composable
    public static final void DialogHost(@NotNull DialogNavigator dialogNavigator, @Nullable Composer composer, int i11) {
        int i12;
        int i13;
        Intrinsics.checkNotNullParameter(dialogNavigator, "dialogNavigator");
        Composer startRestartGroup = composer.startRestartGroup(294589392);
        if ((i11 & 14) == 0) {
            if (startRestartGroup.changed((Object) dialogNavigator)) {
                i13 = 4;
            } else {
                i13 = 2;
            }
            i12 = i13 | i11;
        } else {
            i12 = i11;
        }
        if ((i12 & 11) != 2 || !startRestartGroup.getSkipping()) {
            SaveableStateHolder rememberSaveableStateHolder = SaveableStateHolderKt.rememberSaveableStateHolder(startRestartGroup, 0);
            State<List<NavBackStackEntry>> collectAsState = SnapshotStateKt.collectAsState(dialogNavigator.getBackStack$navigation_compose_release(), (CoroutineContext) null, startRestartGroup, 8, 1);
            SnapshotStateList<NavBackStackEntry> rememberVisibleList = rememberVisibleList(m9106DialogHost$lambda0(collectAsState), startRestartGroup, 8);
            PopulateVisibleList(rememberVisibleList, m9106DialogHost$lambda0(collectAsState), startRestartGroup, 64);
            for (NavBackStackEntry next : rememberVisibleList) {
                DialogNavigator.Destination destination = (DialogNavigator.Destination) next.getDestination();
                AndroidDialog_androidKt.Dialog(new DialogHostKt$DialogHost$1$1(dialogNavigator, next), destination.getDialogProperties$navigation_compose_release(), ComposableLambdaKt.composableLambda(startRestartGroup, 1129586364, true, new DialogHostKt$DialogHost$1$2(next, rememberSaveableStateHolder, dialogNavigator, destination)), startRestartGroup, RendererCapabilities.MODE_SUPPORT_MASK, 0);
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DialogHostKt$DialogHost$2(dialogNavigator, i11));
        }
    }

    /* renamed from: DialogHost$lambda-0  reason: not valid java name */
    private static final List<NavBackStackEntry> m9106DialogHost$lambda0(State<? extends List<NavBackStackEntry>> state) {
        return (List) state.getValue();
    }

    @Composable
    public static final void PopulateVisibleList(@NotNull List<NavBackStackEntry> list, @NotNull Collection<NavBackStackEntry> collection, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(collection, "transitionsInProgress");
        Composer startRestartGroup = composer.startRestartGroup(1537894851);
        for (NavBackStackEntry navBackStackEntry : collection) {
            EffectsKt.DisposableEffect((Object) navBackStackEntry.getLifecycle(), (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) new DialogHostKt$PopulateVisibleList$1$1(navBackStackEntry, list), startRestartGroup, 8);
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DialogHostKt$PopulateVisibleList$2(list, collection, i11));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0021, code lost:
        if (r0 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L_0x0023;
     */
    @org.jetbrains.annotations.NotNull
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.runtime.snapshots.SnapshotStateList<androidx.navigation.NavBackStackEntry> rememberVisibleList(@org.jetbrains.annotations.NotNull java.util.Collection<androidx.navigation.NavBackStackEntry> r4, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r5, int r6) {
        /*
            java.lang.String r6 = "transitionsInProgress"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r6)
            r6 = 467378629(0x1bdba1c5, float:3.6335052E-22)
            r5.startReplaceableGroup(r6)
            r6 = -3686930(0xffffffffffc7bdee, float:NaN)
            r5.startReplaceableGroup(r6)
            boolean r6 = r5.changed((java.lang.Object) r4)
            java.lang.Object r0 = r5.rememberedValue()
            if (r6 != 0) goto L_0x0023
            androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r6.getEmpty()
            if (r0 != r6) goto L_0x0059
        L_0x0023:
            androidx.compose.runtime.snapshots.SnapshotStateList r0 = androidx.compose.runtime.SnapshotStateKt.mutableStateListOf()
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.Iterator r4 = r4.iterator()
        L_0x0032:
            boolean r1 = r4.hasNext()
            if (r1 == 0) goto L_0x0053
            java.lang.Object r1 = r4.next()
            r2 = r1
            androidx.navigation.NavBackStackEntry r2 = (androidx.navigation.NavBackStackEntry) r2
            androidx.lifecycle.Lifecycle r2 = r2.getLifecycle()
            androidx.lifecycle.Lifecycle$State r2 = r2.getCurrentState()
            androidx.lifecycle.Lifecycle$State r3 = androidx.lifecycle.Lifecycle.State.STARTED
            boolean r2 = r2.isAtLeast(r3)
            if (r2 == 0) goto L_0x0032
            r6.add(r1)
            goto L_0x0032
        L_0x0053:
            r0.addAll(r6)
            r5.updateRememberedValue(r0)
        L_0x0059:
            r5.endReplaceableGroup()
            androidx.compose.runtime.snapshots.SnapshotStateList r0 = (androidx.compose.runtime.snapshots.SnapshotStateList) r0
            r5.endReplaceableGroup()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.compose.DialogHostKt.rememberVisibleList(java.util.Collection, androidx.compose.runtime.Composer, int):androidx.compose.runtime.snapshots.SnapshotStateList");
    }
}
