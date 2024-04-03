package androidx.navigation;

import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/viewmodel/CreationExtras;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 176)
public final class NavGraphViewModelLazyKt$navGraphViewModels$7 extends Lambda implements Function0<CreationExtras> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function0<CreationExtras> f36341g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Lazy<NavBackStackEntry> f36342h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavGraphViewModelLazyKt$navGraphViewModels$7(Function0<? extends CreationExtras> function0, Lazy<NavBackStackEntry> lazy) {
        super(0);
        this.f36341g = function0;
        this.f36342h = lazy;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.invoke();
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.lifecycle.viewmodel.CreationExtras invoke() {
        /*
            r1 = this;
            kotlin.jvm.functions.Function0<androidx.lifecycle.viewmodel.CreationExtras> r0 = r1.f36341g
            if (r0 == 0) goto L_0x000c
            java.lang.Object r0 = r0.invoke()
            androidx.lifecycle.viewmodel.CreationExtras r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0
            if (r0 != 0) goto L_0x0016
        L_0x000c:
            kotlin.Lazy<androidx.navigation.NavBackStackEntry> r0 = r1.f36342h
            androidx.navigation.NavBackStackEntry r0 = androidx.navigation.NavGraphViewModelLazyKt.m9101navGraphViewModels$lambda3(r0)
            androidx.lifecycle.viewmodel.CreationExtras r0 = r0.getDefaultViewModelCreationExtras()
        L_0x0016:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavGraphViewModelLazyKt$navGraphViewModels$7.invoke():androidx.lifecycle.viewmodel.CreationExtras");
    }
}
