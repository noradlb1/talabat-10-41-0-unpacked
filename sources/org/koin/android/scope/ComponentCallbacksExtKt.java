package org.koin.android.scope;

import android.content.ComponentCallbacks;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.koin.android.ext.android.ComponentCallbackExtKt;
import org.koin.core.component.KoinScopeComponentKt;
import org.koin.core.scope.Scope;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a%\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0002H\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006\u001a\u001f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0002H\u0002¢\u0006\u0002\u0010\t\u001a\u001b\u0010\n\u001a\u0004\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0002H\u0002¢\u0006\u0002\u0010\u000b\u001a\u001f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\b\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0002H\u0002¢\u0006\u0002\u0010\t¨\u0006\r"}, d2 = {"createScope", "Lorg/koin/core/scope/Scope;", "T", "Landroid/content/ComponentCallbacks;", "source", "", "(Landroid/content/ComponentCallbacks;Ljava/lang/Object;)Lorg/koin/core/scope/Scope;", "getOrCreateScope", "Lkotlin/Lazy;", "(Landroid/content/ComponentCallbacks;)Lkotlin/Lazy;", "getScopeOrNull", "(Landroid/content/ComponentCallbacks;)Lorg/koin/core/scope/Scope;", "newScope", "koin-android_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class ComponentCallbacksExtKt {
    @NotNull
    public static final <T extends ComponentCallbacks> Scope createScope(@NotNull T t11, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(t11, "<this>");
        return ComponentCallbackExtKt.getKoin(t11).createScope(KoinScopeComponentKt.getScopeId(t11), KoinScopeComponentKt.getScopeName(t11), obj);
    }

    public static /* synthetic */ Scope createScope$default(ComponentCallbacks componentCallbacks, Object obj, int i11, Object obj2) {
        if ((i11 & 1) != 0) {
            obj = null;
        }
        return createScope(componentCallbacks, obj);
    }

    @NotNull
    public static final <T extends ComponentCallbacks> Lazy<Scope> getOrCreateScope(@NotNull T t11) {
        Intrinsics.checkNotNullParameter(t11, "<this>");
        return LazyKt__LazyJVMKt.lazy(new ComponentCallbacksExtKt$getOrCreateScope$1(t11));
    }

    @Nullable
    public static final <T extends ComponentCallbacks> Scope getScopeOrNull(@NotNull T t11) {
        Intrinsics.checkNotNullParameter(t11, "<this>");
        return ComponentCallbackExtKt.getKoin(t11).getScopeOrNull(KoinScopeComponentKt.getScopeId(t11));
    }

    @NotNull
    public static final <T extends ComponentCallbacks> Lazy<Scope> newScope(@NotNull T t11) {
        Intrinsics.checkNotNullParameter(t11, "<this>");
        return LazyKt__LazyJVMKt.lazy(new ComponentCallbacksExtKt$newScope$1(t11));
    }
}
