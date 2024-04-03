package org.koin.androidx.scope;

import androidx.lifecycle.LifecycleOwner;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.koin.core.scope.Scope;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u001e\u0010\u0007\u001a\u00020\u0001*\u00020\u00028FX\u0004¢\u0006\f\u0012\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006\"\u001e\u0010\n\u001a\u00020\u0001*\u00020\u00028FX\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006¨\u0006\r"}, d2 = {"currentScope", "Lorg/koin/core/scope/Scope;", "Landroidx/lifecycle/LifecycleOwner;", "getCurrentScope$annotations", "(Landroidx/lifecycle/LifecycleOwner;)V", "getCurrentScope", "(Landroidx/lifecycle/LifecycleOwner;)Lorg/koin/core/scope/Scope;", "lifecycleScope", "getLifecycleScope$annotations", "getLifecycleScope", "scope", "getScope$annotations", "getScope", "koin-android_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class LifecycleOwnerExtKt {
    @NotNull
    public static final Scope getCurrentScope(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<this>");
        throw new IllegalStateException("Don't use scope on a lifecycle component. Use ScopeActivity or ScopeFragment instead".toString());
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use ScopeActivity or ScopeFragment instead", replaceWith = @ReplaceWith(expression = "lifecycleScope", imports = {}))
    public static /* synthetic */ void getCurrentScope$annotations(LifecycleOwner lifecycleOwner) {
    }

    @NotNull
    public static final Scope getLifecycleScope(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<this>");
        throw new IllegalStateException("Don't use scope on a lifecycle component. Use ScopeActivity or ScopeFragment instead".toString());
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use ScopeActivity or ScopeFragment instead", replaceWith = @ReplaceWith(expression = "lifecycleScope", imports = {}))
    public static /* synthetic */ void getLifecycleScope$annotations(LifecycleOwner lifecycleOwner) {
    }

    @NotNull
    public static final Scope getScope(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<this>");
        throw new IllegalStateException("Don't use scope on a lifecycle component. Use ScopeActivity or ScopeFragment instead".toString());
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use ScopeActivity or ScopeFragment instead", replaceWith = @ReplaceWith(expression = "lifecycleScope", imports = {}))
    public static /* synthetic */ void getScope$annotations(LifecycleOwner lifecycleOwner) {
    }
}
