package org.koin.androidx.scope;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.koin.core.Koin;
import org.koin.core.component.KoinScopeComponentKt;
import org.koin.core.context.GlobalContext;
import org.koin.core.context.KoinContext;
import org.koin.core.logger.Logger;
import org.koin.core.scope.Scope;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002B-\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\t¢\u0006\u0002\u0010\u000bJ\u001d\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00032\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0012H\u0002R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lorg/koin/androidx/scope/LifecycleScopeDelegate;", "T", "Lkotlin/properties/ReadOnlyProperty;", "Landroidx/lifecycle/LifecycleOwner;", "Lorg/koin/core/scope/Scope;", "lifecycleOwner", "koinContext", "Lorg/koin/core/context/KoinContext;", "createScope", "Lkotlin/Function1;", "Lorg/koin/core/Koin;", "(Landroidx/lifecycle/LifecycleOwner;Lorg/koin/core/context/KoinContext;Lkotlin/jvm/functions/Function1;)V", "_scope", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "koin-android_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class LifecycleScopeDelegate<T> implements ReadOnlyProperty<LifecycleOwner, Scope> {
    /* access modifiers changed from: private */
    @Nullable
    public Scope _scope;
    @NotNull
    private final Function1<Koin, Scope> createScope;
    @NotNull
    private final KoinContext koinContext;
    @NotNull
    private final LifecycleOwner lifecycleOwner;

    public LifecycleScopeDelegate(@NotNull LifecycleOwner lifecycleOwner2, @NotNull KoinContext koinContext2, @NotNull Function1<? super Koin, Scope> function1) {
        Intrinsics.checkNotNullParameter(lifecycleOwner2, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(koinContext2, "koinContext");
        Intrinsics.checkNotNullParameter(function1, "createScope");
        this.lifecycleOwner = lifecycleOwner2;
        this.koinContext = koinContext2;
        this.createScope = function1;
        Koin koin = koinContext2.get();
        final Logger logger = koin.getLogger();
        logger.debug("setup scope: " + this._scope + " for " + lifecycleOwner2);
        Scope scopeOrNull = koin.getScopeOrNull(KoinScopeComponentKt.getScopeId(lifecycleOwner2));
        this._scope = scopeOrNull == null ? function1.invoke(koin) : scopeOrNull;
        logger.debug("got scope: " + this._scope + " for " + lifecycleOwner2);
        lifecycleOwner2.getLifecycle().addObserver(new LifecycleObserver() {
            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
            public final void onDestroy(@NotNull LifecycleOwner lifecycleOwner) {
                Scope access$get_scope$p;
                Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
                Logger logger = logger;
                logger.debug("Closing scope: " + this._scope + " for " + this.getLifecycleOwner());
                Scope access$get_scope$p2 = this._scope;
                boolean z11 = false;
                if (access$get_scope$p2 != null && !access$get_scope$p2.getClosed()) {
                    z11 = true;
                }
                if (z11 && (access$get_scope$p = this._scope) != null) {
                    access$get_scope$p.close();
                }
                this._scope = null;
            }
        });
    }

    @NotNull
    public final LifecycleOwner getLifecycleOwner() {
        return this.lifecycleOwner;
    }

    @NotNull
    public Scope getValue(@NotNull LifecycleOwner lifecycleOwner2, @NotNull KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(lifecycleOwner2, "thisRef");
        Intrinsics.checkNotNullParameter(kProperty, "property");
        Scope scope = this._scope;
        if (scope != null) {
            Intrinsics.checkNotNull(scope);
            return scope;
        } else if (LifecycleScopeDelegateKt.isActive(lifecycleOwner2)) {
            Koin koin = this.koinContext.get();
            Scope scopeOrNull = koin.getScopeOrNull(KoinScopeComponentKt.getScopeId(lifecycleOwner2));
            if (scopeOrNull == null) {
                scopeOrNull = this.createScope.invoke(koin);
            }
            this._scope = scopeOrNull;
            Logger logger = koin.getLogger();
            logger.debug("got scope: " + this._scope + " for " + this.lifecycleOwner);
            Scope scope2 = this._scope;
            Intrinsics.checkNotNull(scope2);
            return scope2;
        } else {
            throw new IllegalStateException(("can't get Scope for " + this.lifecycleOwner + " - LifecycleOwner is not Active").toString());
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LifecycleScopeDelegate(final LifecycleOwner lifecycleOwner2, KoinContext koinContext2, Function1 function1, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(lifecycleOwner2, (i11 & 2) != 0 ? GlobalContext.INSTANCE : koinContext2, (i11 & 4) != 0 ? new Function1<Koin, Scope>() {
            @NotNull
            public final Scope invoke(@NotNull Koin koin) {
                Intrinsics.checkNotNullParameter(koin, "koin");
                return koin.createScope(KoinScopeComponentKt.getScopeId(lifecycleOwner2), KoinScopeComponentKt.getScopeName(lifecycleOwner2), lifecycleOwner2);
            }
        } : function1);
    }
}
