package org.koin.core.registry;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.koin.core.Koin;
import org.koin.core.annotation.KoinInternalApi;
import org.koin.core.error.ScopeAlreadyCreatedException;
import org.koin.core.logger.Logger;
import org.koin.core.module.Module;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.qualifier.QualifierKt;
import org.koin.core.qualifier.StringQualifier;
import org.koin.core.scope.Scope;
import org.koin.mp.KoinPlatformTools;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\u0018\u0000 )2\u00020\u0001:\u0001)B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\r\u0010\u0017\u001a\u00020\u0018H\u0000¢\u0006\u0002\b\u0019J\b\u0010\u001a\u001a\u00020\u0018H\u0002J(\u0010\u001b\u001a\u00020\r2\n\u0010\u001c\u001a\u00060\u000bj\u0002`\f2\u0006\u0010\u001d\u001a\u00020\u00072\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u0001J\u0015\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\rH\u0000¢\u0006\u0002\b!J\u0019\u0010\u001f\u001a\u00020\u00182\n\u0010\u001c\u001a\u00060\u000bj\u0002`\fH\u0000¢\u0006\u0002\b!J\u0016\u0010\"\u001a\u0004\u0018\u00010\r2\n\u0010\u001c\u001a\u00060\u000bj\u0002`\fH\u0001J\u0010\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020%H\u0002J\u0014\u0010&\u001a\u00020\u00182\f\u0010'\u001a\b\u0012\u0004\u0012\u00020%0(R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\b\u0012\u00060\u000bj\u0002`\f\u0012\u0004\u0012\u00020\r0\nX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u00020\r8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u00148F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006*"}, d2 = {"Lorg/koin/core/registry/ScopeRegistry;", "", "_koin", "Lorg/koin/core/Koin;", "(Lorg/koin/core/Koin;)V", "_scopeDefinitions", "Ljava/util/HashSet;", "Lorg/koin/core/qualifier/Qualifier;", "Lkotlin/collections/HashSet;", "_scopes", "", "", "Lorg/koin/core/scope/ScopeID;", "Lorg/koin/core/scope/Scope;", "rootScope", "getRootScope$annotations", "()V", "getRootScope", "()Lorg/koin/core/scope/Scope;", "scopeDefinitions", "", "getScopeDefinitions", "()Ljava/util/Set;", "close", "", "close$koin_core", "closeAllScopes", "createScope", "scopeId", "qualifier", "source", "deleteScope", "scope", "deleteScope$koin_core", "getScopeOrNull", "loadModule", "module", "Lorg/koin/core/module/Module;", "loadScopes", "modules", "", "Companion", "koin-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ScopeRegistry {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String ROOT_SCOPE_ID = "_";
    /* access modifiers changed from: private */
    @NotNull
    public static final StringQualifier rootScopeQualifier = QualifierKt._q("_");
    @NotNull
    private final Koin _koin;
    @NotNull
    private final HashSet<Qualifier> _scopeDefinitions;
    @NotNull
    private final Map<String, Scope> _scopes;
    @NotNull
    private final Scope rootScope;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u00020\u00068\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\u0002\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lorg/koin/core/registry/ScopeRegistry$Companion;", "", "()V", "ROOT_SCOPE_ID", "", "rootScopeQualifier", "Lorg/koin/core/qualifier/StringQualifier;", "getRootScopeQualifier$annotations", "getRootScopeQualifier", "()Lorg/koin/core/qualifier/StringQualifier;", "koin-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @PublishedApi
        public static /* synthetic */ void getRootScopeQualifier$annotations() {
        }

        @NotNull
        public final StringQualifier getRootScopeQualifier() {
            return ScopeRegistry.rootScopeQualifier;
        }
    }

    public ScopeRegistry(@NotNull Koin koin) {
        Intrinsics.checkNotNullParameter(koin, "_koin");
        this._koin = koin;
        HashSet<Qualifier> hashSet = new HashSet<>();
        this._scopeDefinitions = hashSet;
        Map<String, Scope> safeHashMap = KoinPlatformTools.INSTANCE.safeHashMap();
        this._scopes = safeHashMap;
        Scope scope = new Scope(rootScopeQualifier, "_", true, koin);
        this.rootScope = scope;
        hashSet.add(scope.getScopeQualifier());
        safeHashMap.put(scope.getId(), scope);
    }

    private final void closeAllScopes() {
        for (Scope close : this._scopes.values()) {
            close.close();
        }
    }

    public static /* synthetic */ Scope createScope$default(ScopeRegistry scopeRegistry, String str, Qualifier qualifier, Object obj, int i11, Object obj2) {
        if ((i11 & 4) != 0) {
            obj = null;
        }
        return scopeRegistry.createScope(str, qualifier, obj);
    }

    @KoinInternalApi
    public static /* synthetic */ void getRootScope$annotations() {
    }

    private final void loadModule(Module module) {
        this._scopeDefinitions.addAll(module.getScopes());
    }

    public final void close$koin_core() {
        closeAllScopes();
        this._scopes.clear();
        this._scopeDefinitions.clear();
    }

    @NotNull
    @PublishedApi
    public final Scope createScope(@NotNull String str, @NotNull Qualifier qualifier, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(str, "scopeId");
        Intrinsics.checkNotNullParameter(qualifier, "qualifier");
        if (!this._scopeDefinitions.contains(qualifier)) {
            Logger logger = this._koin.getLogger();
            logger.info("Warning: Scope '" + qualifier + "' not defined. Creating it");
            this._scopeDefinitions.add(qualifier);
        }
        if (!this._scopes.containsKey(str)) {
            Scope scope = new Scope(qualifier, str, false, this._koin, 4, (DefaultConstructorMarker) null);
            if (obj != null) {
                scope.set_source(obj);
            }
            scope.linkTo(this.rootScope);
            this._scopes.put(str, scope);
            return scope;
        }
        throw new ScopeAlreadyCreatedException("Scope with id '" + str + "' is already created");
    }

    public final void deleteScope$koin_core(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "scopeId");
        Scope scope = this._scopes.get(str);
        if (scope != null) {
            deleteScope$koin_core(scope);
        }
    }

    @NotNull
    public final Scope getRootScope() {
        return this.rootScope;
    }

    @NotNull
    public final Set<Qualifier> getScopeDefinitions() {
        return this._scopeDefinitions;
    }

    @Nullable
    @PublishedApi
    public final Scope getScopeOrNull(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "scopeId");
        return this._scopes.get(str);
    }

    public final void loadScopes(@NotNull List<Module> list) {
        Intrinsics.checkNotNullParameter(list, "modules");
        for (Module loadModule : list) {
            loadModule(loadModule);
        }
    }

    public final void deleteScope$koin_core(@NotNull Scope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        this._koin.getInstanceRegistry().dropScopeInstances$koin_core(scope);
        this._scopes.remove(scope.getId());
    }
}
