package org.koin.androidx.scope;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.koin.core.Koin;
import org.koin.core.component.KoinScopeComponentKt;
import org.koin.core.scope.Scope;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lorg/koin/core/Koin;", "koin", "Lorg/koin/core/scope/Scope;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class FragmentExtKt$fragmentScope$1 extends Lambda implements Function1<Koin, Scope> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Fragment f62648g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FragmentExtKt$fragmentScope$1(Fragment fragment) {
        super(1);
        this.f62648g = fragment;
    }

    @NotNull
    public final Scope invoke(@NotNull Koin koin) {
        Intrinsics.checkNotNullParameter(koin, "koin");
        Scope createScope$default = Koin.createScope$default(koin, KoinScopeComponentKt.getScopeId(this.f62648g), KoinScopeComponentKt.getScopeName(this.f62648g), (Object) null, 4, (Object) null);
        FragmentActivity activity = this.f62648g.getActivity();
        Scope scopeOrNull = activity == null ? null : ComponentActivityExtKt.getScopeOrNull(activity);
        if (scopeOrNull != null) {
            createScope$default.linkTo(scopeOrNull);
        }
        return createScope$default;
    }
}
