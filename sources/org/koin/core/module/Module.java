package org.koin.core.module;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.definition.BeanDefinitionKt;
import org.koin.core.definition.Kind;
import org.koin.core.instance.FactoryInstanceFactory;
import org.koin.core.instance.InstanceFactory;
import org.koin.core.instance.SingleInstanceFactory;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.qualifier.StringQualifier;
import org.koin.core.qualifier.TypeQualifier;
import org.koin.core.registry.ScopeRegistry;
import org.koin.core.scope.Scope;
import org.koin.dsl.ScopeDSL;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J]\u0010\u001f\u001a\u0014\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u0002H!0\u00150 \"\u0006\b\u0000\u0010!\u0018\u00012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u001c2)\b\b\u0010#\u001a#\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u0002H!0$j\b\u0012\u0004\u0012\u0002H!`'¢\u0006\u0002\b(H\bø\u0001\u0000Je\u0010\u001f\u001a\u0014\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u0002H!0\u00150 \"\u0006\b\u0000\u0010!\u0018\u00012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u001c2)\b\b\u0010#\u001a#\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u0002H!0$j\b\u0012\u0004\u0012\u0002H!`'¢\u0006\u0002\b(2\u0006\u0010)\u001a\u00020\u001cH\bø\u0001\u0000J\u001d\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00000+2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00000+H\u0002J\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00000+2\u0006\u0010-\u001a\u00020\u0000H\u0002J*\u0010.\u001a\u00020/2\n\u00100\u001a\u00060\u0013j\u0002`\u00142\n\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030\u00152\b\b\u0002\u00101\u001a\u00020\u0003H\u0001J'\u00102\u001a\u00020/2\u0006\u0010\"\u001a\u00020\u001c2\u0017\u00103\u001a\u0013\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020/04¢\u0006\u0002\b(J-\u00102\u001a\u00020/\"\u0006\b\u0000\u0010!\u0018\u00012\u0017\u00103\u001a\u0013\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020/04¢\u0006\u0002\b(H\bø\u0001\u0000Jg\u00106\u001a\u0014\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u0002H!0\u00150 \"\u0006\b\u0000\u0010!\u0018\u00012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\u0002\u001a\u00020\u00032)\b\b\u0010#\u001a#\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u0002H!0$j\b\u0012\u0004\u0012\u0002H!`'¢\u0006\u0002\b(H\bø\u0001\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006RT\u0010\u000b\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\bj\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t`\n2\u001e\u0010\u0007\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\bj\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t`\n@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0006RH\u0010\u0011\u001a.\u0012\b\u0012\u00060\u0013j\u0002`\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u0012j\u0016\u0012\b\u0012\u00060\u0013j\u0002`\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0015`\u00168\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR,\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u001c0\bj\b\u0012\u0004\u0012\u00020\u001c`\n8\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\r\u0002\u0007\n\u0005\b20\u0001¨\u00067"}, d2 = {"Lorg/koin/core/module/Module;", "", "createdAtStart", "", "(Z)V", "getCreatedAtStart", "()Z", "<set-?>", "Ljava/util/HashSet;", "Lorg/koin/core/instance/SingleInstanceFactory;", "Lkotlin/collections/HashSet;", "eagerInstances", "getEagerInstances", "()Ljava/util/HashSet;", "setEagerInstances$koin_core", "(Ljava/util/HashSet;)V", "isLoaded", "mappings", "Ljava/util/HashMap;", "", "Lorg/koin/core/definition/IndexKey;", "Lorg/koin/core/instance/InstanceFactory;", "Lkotlin/collections/HashMap;", "getMappings$annotations", "()V", "getMappings", "()Ljava/util/HashMap;", "scopes", "Lorg/koin/core/qualifier/Qualifier;", "getScopes$annotations", "getScopes", "factory", "Lkotlin/Pair;", "T", "qualifier", "definition", "Lkotlin/Function2;", "Lorg/koin/core/scope/Scope;", "Lorg/koin/core/parameter/ParametersHolder;", "Lorg/koin/core/definition/Definition;", "Lkotlin/ExtensionFunctionType;", "scopeQualifier", "plus", "", "modules", "module", "saveMapping", "", "mapping", "allowOverride", "scope", "scopeSet", "Lkotlin/Function1;", "Lorg/koin/dsl/ScopeDSL;", "single", "koin-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class Module {
    private final boolean createdAtStart;
    @NotNull
    private HashSet<SingleInstanceFactory<?>> eagerInstances;
    @NotNull
    private final HashMap<String, InstanceFactory<?>> mappings;
    @NotNull
    private final HashSet<Qualifier> scopes;

    public Module() {
        this(false, 1, (DefaultConstructorMarker) null);
    }

    public Module(boolean z11) {
        this.createdAtStart = z11;
        this.eagerInstances = new HashSet<>();
        this.mappings = new HashMap<>();
        this.scopes = new HashSet<>();
    }

    public static /* synthetic */ Pair factory$default(Module module, Qualifier qualifier, Function2 function2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            qualifier = null;
        }
        Intrinsics.checkNotNullParameter(function2, "definition");
        StringQualifier rootScopeQualifier = ScopeRegistry.Companion.getRootScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt__CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "T");
        BeanDefinition beanDefinition = new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier, function2, kind, emptyList);
        String indexKey = BeanDefinitionKt.indexKey(beanDefinition.getPrimaryType(), qualifier, rootScopeQualifier);
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(beanDefinition);
        saveMapping$default(module, indexKey, factoryInstanceFactory, false, 4, (Object) null);
        return new Pair(module, factoryInstanceFactory);
    }

    @PublishedApi
    public static /* synthetic */ void getMappings$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getScopes$annotations() {
    }

    public static /* synthetic */ void saveMapping$default(Module module, String str, InstanceFactory instanceFactory, boolean z11, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            z11 = false;
        }
        module.saveMapping(str, instanceFactory, z11);
    }

    public static /* synthetic */ Pair single$default(Module module, Qualifier qualifier, boolean z11, Function2 function2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            qualifier = null;
        }
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        Intrinsics.checkNotNullParameter(function2, "definition");
        Kind kind = Kind.Singleton;
        ScopeRegistry.Companion companion = ScopeRegistry.Companion;
        StringQualifier rootScopeQualifier = companion.getRootScopeQualifier();
        List emptyList = CollectionsKt__CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "T");
        BeanDefinition beanDefinition = new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier, function2, kind, emptyList);
        String indexKey = BeanDefinitionKt.indexKey(beanDefinition.getPrimaryType(), qualifier, companion.getRootScopeQualifier());
        SingleInstanceFactory singleInstanceFactory = new SingleInstanceFactory(beanDefinition);
        saveMapping$default(module, indexKey, singleInstanceFactory, false, 4, (Object) null);
        if (z11 || module.getCreatedAtStart()) {
            module.getEagerInstances().add(singleInstanceFactory);
        }
        return new Pair(module, singleInstanceFactory);
    }

    public final /* synthetic */ <T> Pair<Module, InstanceFactory<T>> factory(Qualifier qualifier, Function2<? super Scope, ? super ParametersHolder, ? extends T> function2) {
        Intrinsics.checkNotNullParameter(function2, "definition");
        StringQualifier rootScopeQualifier = ScopeRegistry.Companion.getRootScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt__CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "T");
        BeanDefinition beanDefinition = new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier, function2, kind, emptyList);
        String indexKey = BeanDefinitionKt.indexKey(beanDefinition.getPrimaryType(), qualifier, rootScopeQualifier);
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(beanDefinition);
        saveMapping$default(this, indexKey, factoryInstanceFactory, false, 4, (Object) null);
        return new Pair<>(this, factoryInstanceFactory);
    }

    public final boolean getCreatedAtStart() {
        return this.createdAtStart;
    }

    @NotNull
    public final HashSet<SingleInstanceFactory<?>> getEagerInstances() {
        return this.eagerInstances;
    }

    @NotNull
    public final HashMap<String, InstanceFactory<?>> getMappings() {
        return this.mappings;
    }

    @NotNull
    public final HashSet<Qualifier> getScopes() {
        return this.scopes;
    }

    public final boolean isLoaded() {
        return this.mappings.size() > 0;
    }

    @NotNull
    public final List<Module> plus(@NotNull Module module) {
        Intrinsics.checkNotNullParameter(module, "module");
        return CollectionsKt__CollectionsKt.listOf(this, module);
    }

    @PublishedApi
    public final void saveMapping(@NotNull String str, @NotNull InstanceFactory<?> instanceFactory, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "mapping");
        Intrinsics.checkNotNullParameter(instanceFactory, "factory");
        if (!z11 && this.mappings.containsKey(str)) {
            ModuleKt.overrideError(instanceFactory, str);
        }
        this.mappings.put(str, instanceFactory);
    }

    public final void scope(@NotNull Qualifier qualifier, @NotNull Function1<? super ScopeDSL, Unit> function1) {
        Intrinsics.checkNotNullParameter(qualifier, "qualifier");
        Intrinsics.checkNotNullParameter(function1, "scopeSet");
        function1.invoke(new ScopeDSL(qualifier, this));
        this.scopes.add(qualifier);
    }

    public final void setEagerInstances$koin_core(@NotNull HashSet<SingleInstanceFactory<?>> hashSet) {
        Intrinsics.checkNotNullParameter(hashSet, "<set-?>");
        this.eagerInstances = hashSet;
    }

    public final /* synthetic */ <T> Pair<Module, InstanceFactory<T>> single(Qualifier qualifier, boolean z11, Function2<? super Scope, ? super ParametersHolder, ? extends T> function2) {
        Intrinsics.checkNotNullParameter(function2, "definition");
        Kind kind = Kind.Singleton;
        ScopeRegistry.Companion companion = ScopeRegistry.Companion;
        StringQualifier rootScopeQualifier = companion.getRootScopeQualifier();
        List emptyList = CollectionsKt__CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "T");
        BeanDefinition beanDefinition = new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier, function2, kind, emptyList);
        String indexKey = BeanDefinitionKt.indexKey(beanDefinition.getPrimaryType(), qualifier, companion.getRootScopeQualifier());
        SingleInstanceFactory singleInstanceFactory = new SingleInstanceFactory(beanDefinition);
        saveMapping$default(this, indexKey, singleInstanceFactory, false, 4, (Object) null);
        if (z11 || getCreatedAtStart()) {
            getEagerInstances().add(singleInstanceFactory);
        }
        return new Pair<>(this, singleInstanceFactory);
    }

    @NotNull
    public final List<Module> plus(@NotNull List<Module> list) {
        Intrinsics.checkNotNullParameter(list, "modules");
        return CollectionsKt___CollectionsKt.plus(CollectionsKt__CollectionsJVMKt.listOf(this), list);
    }

    public final /* synthetic */ <T> void scope(Function1<? super ScopeDSL, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "scopeSet");
        Intrinsics.reifiedOperationMarker(4, "T");
        TypeQualifier typeQualifier = new TypeQualifier(Reflection.getOrCreateKotlinClass(Object.class));
        function1.invoke(new ScopeDSL(typeQualifier, this));
        getScopes().add(typeQualifier);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Module(boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? false : z11);
    }

    @PublishedApi
    public final /* synthetic */ <T> Pair<Module, InstanceFactory<T>> factory(Qualifier qualifier, Function2<? super Scope, ? super ParametersHolder, ? extends T> function2, Qualifier qualifier2) {
        Intrinsics.checkNotNullParameter(function2, "definition");
        Intrinsics.checkNotNullParameter(qualifier2, "scopeQualifier");
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt__CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "T");
        BeanDefinition beanDefinition = new BeanDefinition(qualifier2, Reflection.getOrCreateKotlinClass(Object.class), qualifier, function2, kind, emptyList);
        String indexKey = BeanDefinitionKt.indexKey(beanDefinition.getPrimaryType(), qualifier, qualifier2);
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(beanDefinition);
        saveMapping$default(this, indexKey, factoryInstanceFactory, false, 4, (Object) null);
        return new Pair<>(this, factoryInstanceFactory);
    }

    public static /* synthetic */ Pair factory$default(Module module, Qualifier qualifier, Function2 function2, Qualifier qualifier2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            qualifier = null;
        }
        Intrinsics.checkNotNullParameter(function2, "definition");
        Intrinsics.checkNotNullParameter(qualifier2, "scopeQualifier");
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt__CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "T");
        BeanDefinition beanDefinition = new BeanDefinition(qualifier2, Reflection.getOrCreateKotlinClass(Object.class), qualifier, function2, kind, emptyList);
        String indexKey = BeanDefinitionKt.indexKey(beanDefinition.getPrimaryType(), qualifier, qualifier2);
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(beanDefinition);
        saveMapping$default(module, indexKey, factoryInstanceFactory, false, 4, (Object) null);
        return new Pair(module, factoryInstanceFactory);
    }
}
