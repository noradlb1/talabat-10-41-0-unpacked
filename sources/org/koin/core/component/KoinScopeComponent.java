package org.koin.core.component;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.scope.Scope;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0007H\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lorg/koin/core/component/KoinScopeComponent;", "Lorg/koin/core/component/KoinComponent;", "scope", "Lorg/koin/core/scope/Scope;", "getScope", "()Lorg/koin/core/scope/Scope;", "closeScope", "", "koin-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface KoinScopeComponent extends KoinComponent {

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class DefaultImpls {
        public static void closeScope(@NotNull KoinScopeComponent koinScopeComponent) {
            Intrinsics.checkNotNullParameter(koinScopeComponent, "this");
            if (koinScopeComponent.getScope().isNotClosed()) {
                koinScopeComponent.getScope().close();
            }
        }

        @NotNull
        public static Koin getKoin(@NotNull KoinScopeComponent koinScopeComponent) {
            Intrinsics.checkNotNullParameter(koinScopeComponent, "this");
            return KoinComponent.DefaultImpls.getKoin(koinScopeComponent);
        }
    }

    void closeScope();

    @NotNull
    Scope getScope();
}
