package org.koin.androidx.scope;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModelLazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
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

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B-\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\b¢\u0006\u0002\u0010\nJ\u001d\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00022\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0014H\u0002R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00060\u000fj\u0002`\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lorg/koin/androidx/scope/LifecycleViewModelScopeDelegate;", "Lkotlin/properties/ReadOnlyProperty;", "Landroidx/lifecycle/LifecycleOwner;", "Lorg/koin/core/scope/Scope;", "lifecycleOwner", "koinContext", "Lorg/koin/core/context/KoinContext;", "createScope", "Lkotlin/Function1;", "Lorg/koin/core/Koin;", "(Landroidx/lifecycle/LifecycleOwner;Lorg/koin/core/context/KoinContext;Lkotlin/jvm/functions/Function1;)V", "_scope", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "scopeId", "", "Lorg/koin/core/qualifier/QualifierValue;", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "koin-android_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class LifecycleViewModelScopeDelegate implements ReadOnlyProperty<LifecycleOwner, Scope> {
    /* access modifiers changed from: private */
    @Nullable
    public Scope _scope;
    @NotNull
    private final Function1<Koin, Scope> createScope;
    @NotNull
    private final KoinContext koinContext;
    @NotNull
    private final LifecycleOwner lifecycleOwner;
    @NotNull
    private final String scopeId;

    public LifecycleViewModelScopeDelegate(@NotNull LifecycleOwner lifecycleOwner2, @NotNull KoinContext koinContext2, @NotNull Function1<? super Koin, Scope> function1) {
        Intrinsics.checkNotNullParameter(lifecycleOwner2, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(koinContext2, "koinContext");
        Intrinsics.checkNotNullParameter(function1, "createScope");
        this.lifecycleOwner = lifecycleOwner2;
        this.koinContext = koinContext2;
        this.createScope = function1;
        String value = KoinScopeComponentKt.getScopeName(lifecycleOwner2).getValue();
        this.scopeId = value;
        boolean z11 = lifecycleOwner2 instanceof AppCompatActivity;
        Koin koin = koinContext2.get();
        final Logger logger = koin.getLogger();
        logger.debug("setup scope: " + this._scope + " for " + lifecycleOwner2);
        Scope scopeOrNull = koin.getScopeOrNull(value);
        this._scope = scopeOrNull == null ? function1.invoke(koin) : scopeOrNull;
        logger.debug("got scope: " + this._scope + " for " + lifecycleOwner2);
        lifecycleOwner2.getLifecycle().addObserver(new LifecycleObserver() {
            @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
            public final void onCreate(@NotNull LifecycleOwner lifecycleOwner) {
                Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
                Logger logger = logger;
                logger.debug("Attach ViewModel scope: " + this._scope + " to " + this.getLifecycleOwner());
                AppCompatActivity appCompatActivity = (AppCompatActivity) this.getLifecycleOwner();
                ScopeHandlerViewModel scopeHandlerViewModel = (ScopeHandlerViewModel) new ViewModelLazy(Reflection.getOrCreateKotlinClass(ScopeHandlerViewModel.class), new LifecycleViewModelScopeDelegate$3$onCreate$$inlined$viewModels$default$2(appCompatActivity), new LifecycleViewModelScopeDelegate$3$onCreate$$inlined$viewModels$default$1(appCompatActivity)).getValue();
                if (scopeHandlerViewModel.getScope() == null) {
                    scopeHandlerViewModel.setScope(this._scope);
                }
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
            Scope scopeOrNull = koin.getScopeOrNull(KoinScopeComponentKt.getScopeName(this.lifecycleOwner).getValue());
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
    public /* synthetic */ LifecycleViewModelScopeDelegate(final LifecycleOwner lifecycleOwner2, KoinContext koinContext2, Function1 function1, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(lifecycleOwner2, (i11 & 2) != 0 ? GlobalContext.INSTANCE : koinContext2, (i11 & 4) != 0 ? new Function1<Koin, Scope>() {
            @NotNull
            public final Scope invoke(@NotNull Koin koin) {
                Intrinsics.checkNotNullParameter(koin, "koin");
                return Koin.createScope$default(koin, KoinScopeComponentKt.getScopeName(lifecycleOwner2).getValue(), KoinScopeComponentKt.getScopeName(lifecycleOwner2), (Object) null, 4, (Object) null);
            }
        } : function1);
    }
}
