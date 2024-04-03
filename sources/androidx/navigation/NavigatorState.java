package androidx.navigation;

import android.os.Bundle;
import androidx.annotation.CallSuper;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH&J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0006H\u0016J\u0010\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u0006H\u0017J\u0018\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u0010H\u0016J\u0018\u0010#\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u0010H\u0016J\u0010\u0010$\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u0006H\u0016J\u0010\u0010%\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u0006H\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\b0\u0004X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\f¨\u0006&"}, d2 = {"Landroidx/navigation/NavigatorState;", "", "()V", "_backStack", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Landroidx/navigation/NavBackStackEntry;", "_transitionsInProgress", "", "backStack", "Lkotlinx/coroutines/flow/StateFlow;", "getBackStack", "()Lkotlinx/coroutines/flow/StateFlow;", "backStackLock", "Ljava/util/concurrent/locks/ReentrantLock;", "isNavigating", "", "()Z", "setNavigating", "(Z)V", "transitionsInProgress", "getTransitionsInProgress", "createBackStackEntry", "destination", "Landroidx/navigation/NavDestination;", "arguments", "Landroid/os/Bundle;", "markTransitionComplete", "", "entry", "onLaunchSingleTop", "backStackEntry", "pop", "popUpTo", "saveState", "popWithTransition", "push", "pushWithTransition", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class NavigatorState {
    @NotNull
    private final MutableStateFlow<List<NavBackStackEntry>> _backStack;
    @NotNull
    private final MutableStateFlow<Set<NavBackStackEntry>> _transitionsInProgress;
    @NotNull
    private final StateFlow<List<NavBackStackEntry>> backStack;
    @NotNull
    private final ReentrantLock backStackLock = new ReentrantLock(true);
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    private boolean isNavigating;
    @NotNull
    private final StateFlow<Set<NavBackStackEntry>> transitionsInProgress;

    public NavigatorState() {
        MutableStateFlow<List<NavBackStackEntry>> MutableStateFlow = StateFlowKt.MutableStateFlow(CollectionsKt__CollectionsKt.emptyList());
        this._backStack = MutableStateFlow;
        MutableStateFlow<Set<NavBackStackEntry>> MutableStateFlow2 = StateFlowKt.MutableStateFlow(SetsKt__SetsKt.emptySet());
        this._transitionsInProgress = MutableStateFlow2;
        this.backStack = FlowKt.asStateFlow(MutableStateFlow);
        this.transitionsInProgress = FlowKt.asStateFlow(MutableStateFlow2);
    }

    @NotNull
    public abstract NavBackStackEntry createBackStackEntry(@NotNull NavDestination navDestination, @Nullable Bundle bundle);

    @NotNull
    public final StateFlow<List<NavBackStackEntry>> getBackStack() {
        return this.backStack;
    }

    @NotNull
    public final StateFlow<Set<NavBackStackEntry>> getTransitionsInProgress() {
        return this.transitionsInProgress;
    }

    public final boolean isNavigating() {
        return this.isNavigating;
    }

    public void markTransitionComplete(@NotNull NavBackStackEntry navBackStackEntry) {
        Intrinsics.checkNotNullParameter(navBackStackEntry, "entry");
        MutableStateFlow<Set<NavBackStackEntry>> mutableStateFlow = this._transitionsInProgress;
        mutableStateFlow.setValue(SetsKt___SetsKt.minus(mutableStateFlow.getValue(), navBackStackEntry));
    }

    @CallSuper
    public void onLaunchSingleTop(@NotNull NavBackStackEntry navBackStackEntry) {
        Intrinsics.checkNotNullParameter(navBackStackEntry, "backStackEntry");
        MutableStateFlow<List<NavBackStackEntry>> mutableStateFlow = this._backStack;
        mutableStateFlow.setValue(CollectionsKt___CollectionsKt.plus(CollectionsKt___CollectionsKt.minus(mutableStateFlow.getValue(), CollectionsKt___CollectionsKt.last(this._backStack.getValue())), navBackStackEntry));
    }

    public void pop(@NotNull NavBackStackEntry navBackStackEntry, boolean z11) {
        Intrinsics.checkNotNullParameter(navBackStackEntry, "popUpTo");
        ReentrantLock reentrantLock = this.backStackLock;
        reentrantLock.lock();
        try {
            MutableStateFlow<List<NavBackStackEntry>> mutableStateFlow = this._backStack;
            ArrayList arrayList = new ArrayList();
            Iterator it = mutableStateFlow.getValue().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (!(!Intrinsics.areEqual((Object) (NavBackStackEntry) next, (Object) navBackStackEntry))) {
                    break;
                }
                arrayList.add(next);
            }
            mutableStateFlow.setValue(arrayList);
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    public void popWithTransition(@NotNull NavBackStackEntry navBackStackEntry, boolean z11) {
        Object obj;
        boolean z12;
        Intrinsics.checkNotNullParameter(navBackStackEntry, "popUpTo");
        MutableStateFlow<Set<NavBackStackEntry>> mutableStateFlow = this._transitionsInProgress;
        mutableStateFlow.setValue(SetsKt___SetsKt.plus(mutableStateFlow.getValue(), navBackStackEntry));
        List value = this.backStack.getValue();
        ListIterator listIterator = value.listIterator(value.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                obj = null;
                break;
            }
            obj = listIterator.previous();
            NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) obj;
            if (Intrinsics.areEqual((Object) navBackStackEntry2, (Object) navBackStackEntry) || this.backStack.getValue().lastIndexOf(navBackStackEntry2) >= this.backStack.getValue().lastIndexOf(navBackStackEntry)) {
                z12 = false;
                continue;
            } else {
                z12 = true;
                continue;
            }
            if (z12) {
                break;
            }
        }
        NavBackStackEntry navBackStackEntry3 = (NavBackStackEntry) obj;
        if (navBackStackEntry3 != null) {
            MutableStateFlow<Set<NavBackStackEntry>> mutableStateFlow2 = this._transitionsInProgress;
            mutableStateFlow2.setValue(SetsKt___SetsKt.plus(mutableStateFlow2.getValue(), navBackStackEntry3));
        }
        pop(navBackStackEntry, z11);
    }

    public void push(@NotNull NavBackStackEntry navBackStackEntry) {
        Intrinsics.checkNotNullParameter(navBackStackEntry, "backStackEntry");
        ReentrantLock reentrantLock = this.backStackLock;
        reentrantLock.lock();
        try {
            MutableStateFlow<List<NavBackStackEntry>> mutableStateFlow = this._backStack;
            mutableStateFlow.setValue(CollectionsKt___CollectionsKt.plus(mutableStateFlow.getValue(), navBackStackEntry));
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    public void pushWithTransition(@NotNull NavBackStackEntry navBackStackEntry) {
        Intrinsics.checkNotNullParameter(navBackStackEntry, "backStackEntry");
        NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) CollectionsKt___CollectionsKt.lastOrNull(this.backStack.getValue());
        if (navBackStackEntry2 != null) {
            MutableStateFlow<Set<NavBackStackEntry>> mutableStateFlow = this._transitionsInProgress;
            mutableStateFlow.setValue(SetsKt___SetsKt.plus(mutableStateFlow.getValue(), navBackStackEntry2));
        }
        MutableStateFlow<Set<NavBackStackEntry>> mutableStateFlow2 = this._transitionsInProgress;
        mutableStateFlow2.setValue(SetsKt___SetsKt.plus(mutableStateFlow2.getValue(), navBackStackEntry));
        push(navBackStackEntry);
    }

    public final void setNavigating(boolean z11) {
        this.isNavigating = z11;
    }
}
