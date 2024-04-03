package org.koin.core.component;

import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.koin.core.qualifier.TypeQualifier;
import org.koin.core.scope.Scope;
import org.koin.ext.KClassExtKt;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a%\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0002H\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006\u001a\u001f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0002H\u0002¢\u0006\u0002\u0010\t\u001a\u0019\u0010\n\u001a\u00020\u000b\"\b\b\u0000\u0010\u0002*\u00020\u0005*\u0002H\u0002¢\u0006\u0002\u0010\f\u001a\u0019\u0010\r\u001a\u00020\u000e\"\b\b\u0000\u0010\u0002*\u00020\u0005*\u0002H\u0002¢\u0006\u0002\u0010\u000f\u001a\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0002H\u0002¢\u0006\u0002\u0010\u0011\u001a\u001f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\b\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0002H\u0002¢\u0006\u0002\u0010\t¨\u0006\u0013"}, d2 = {"createScope", "Lorg/koin/core/scope/Scope;", "T", "Lorg/koin/core/component/KoinScopeComponent;", "source", "", "(Lorg/koin/core/component/KoinScopeComponent;Ljava/lang/Object;)Lorg/koin/core/scope/Scope;", "getOrCreateScope", "Lkotlin/Lazy;", "(Lorg/koin/core/component/KoinScopeComponent;)Lkotlin/Lazy;", "getScopeId", "", "(Ljava/lang/Object;)Ljava/lang/String;", "getScopeName", "Lorg/koin/core/qualifier/TypeQualifier;", "(Ljava/lang/Object;)Lorg/koin/core/qualifier/TypeQualifier;", "getScopeOrNull", "(Lorg/koin/core/component/KoinScopeComponent;)Lorg/koin/core/scope/Scope;", "newScope", "koin-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class KoinScopeComponentKt {
    @NotNull
    public static final <T extends KoinScopeComponent> Scope createScope(@NotNull T t11, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(t11, "<this>");
        return t11.getKoin().createScope(getScopeId(t11), getScopeName(t11), obj);
    }

    public static /* synthetic */ Scope createScope$default(KoinScopeComponent koinScopeComponent, Object obj, int i11, Object obj2) {
        if ((i11 & 1) != 0) {
            obj = null;
        }
        return createScope(koinScopeComponent, obj);
    }

    @NotNull
    public static final <T extends KoinScopeComponent> Lazy<Scope> getOrCreateScope(@NotNull T t11) {
        Intrinsics.checkNotNullParameter(t11, "<this>");
        return LazyKt__LazyJVMKt.lazy(new KoinScopeComponentKt$getOrCreateScope$1(t11));
    }

    @NotNull
    public static final <T> String getScopeId(@NotNull T t11) {
        Intrinsics.checkNotNullParameter(t11, "<this>");
        return KClassExtKt.getFullName(Reflection.getOrCreateKotlinClass(t11.getClass())) + '@' + t11.hashCode();
    }

    @NotNull
    public static final <T> TypeQualifier getScopeName(@NotNull T t11) {
        Intrinsics.checkNotNullParameter(t11, "<this>");
        return new TypeQualifier(Reflection.getOrCreateKotlinClass(t11.getClass()));
    }

    @Nullable
    public static final <T extends KoinScopeComponent> Scope getScopeOrNull(@NotNull T t11) {
        Intrinsics.checkNotNullParameter(t11, "<this>");
        return t11.getKoin().getScopeOrNull(getScopeId(t11));
    }

    @NotNull
    public static final <T extends KoinScopeComponent> Lazy<Scope> newScope(@NotNull T t11) {
        Intrinsics.checkNotNullParameter(t11, "<this>");
        return LazyKt__LazyJVMKt.lazy(new KoinScopeComponentKt$newScope$1(t11));
    }
}
