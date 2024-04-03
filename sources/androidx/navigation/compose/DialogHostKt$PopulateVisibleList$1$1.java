package androidx.navigation.compose;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.navigation.NavBackStackEntry;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class DialogHostKt$PopulateVisibleList$1$1 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ NavBackStackEntry f36377g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ List<NavBackStackEntry> f36378h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DialogHostKt$PopulateVisibleList$1$1(NavBackStackEntry navBackStackEntry, List<NavBackStackEntry> list) {
        super(1);
        this.f36377g = navBackStackEntry;
        this.f36378h = list;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m9107invoke$lambda0(List list, NavBackStackEntry navBackStackEntry, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(list, "$this_PopulateVisibleList");
        Intrinsics.checkNotNullParameter(navBackStackEntry, "$entry");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event == Lifecycle.Event.ON_START && !list.contains(navBackStackEntry)) {
            list.add(navBackStackEntry);
        }
        if (event == Lifecycle.Event.ON_STOP) {
            list.remove(navBackStackEntry);
        }
    }

    @NotNull
    public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
        Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
        a aVar = new a(this.f36378h, this.f36377g);
        this.f36377g.getLifecycle().addObserver(aVar);
        return new DialogHostKt$PopulateVisibleList$1$1$invoke$$inlined$onDispose$1(this.f36377g, aVar);
    }
}
