package org.koin.core.registry;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.koin.core.Koin;
import org.koin.core.annotation.KoinInternalApi;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.definition.BeanDefinitionKt;
import org.koin.core.definition.Kind;
import org.koin.core.instance.InstanceContext;
import org.koin.core.instance.InstanceFactory;
import org.koin.core.instance.ScopedInstanceFactory;
import org.koin.core.instance.SingleInstanceFactory;
import org.koin.core.logger.Level;
import org.koin.core.logger.Logger;
import org.koin.core.module.Module;
import org.koin.core.module.ModuleKt;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;
import org.koin.mp.KoinPlatformTools;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\r\u0010\u0014\u001a\u00020\u0015H\u0000¢\u0006\u0002\b\u0016J\r\u0010\u0017\u001a\u00020\u0015H\u0000¢\u0006\u0002\b\u0018J(\u0010\u0019\u001a\u00020\u00152\u001e\u0010\f\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e0\rj\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e`\u000fH\u0002JP\u0010\u001a\u001a\u00020\u0015\"\u0006\b\u0000\u0010\u001b\u0018\u00012\u0006\u0010\u001c\u001a\u0002H\u001b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0012\b\u0002\u0010\u001f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030!0 2\b\b\u0002\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001eH\b¢\u0006\u0002\u0010%J\u0015\u0010&\u001a\u00020\u00152\u0006\u0010'\u001a\u00020(H\u0000¢\u0006\u0002\b)J-\u0010*\u001a\b\u0012\u0004\u0012\u0002H\u001b0 \"\u0004\b\u0000\u0010\u001b2\n\u0010+\u001a\u0006\u0012\u0002\b\u00030!2\u0006\u0010,\u001a\u00020-H\u0000¢\u0006\u0002\b.J\u0018\u0010/\u001a\u00020\u00152\u0006\u00100\u001a\u0002012\u0006\u0010\"\u001a\u00020#H\u0002J#\u00102\u001a\u00020\u00152\f\u00103\u001a\b\u0012\u0004\u0012\u0002010 2\u0006\u0010\"\u001a\u00020#H\u0000¢\u0006\u0002\b4J1\u00105\u001a\b\u0012\u0002\b\u0003\u0018\u00010\t2\n\u0010+\u001a\u0006\u0012\u0002\b\u00030!2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010$\u001a\u00020\u001eH\u0000¢\u0006\u0002\b6J=\u00107\u001a\u0004\u0018\u0001H\u001b\"\u0004\b\u0000\u0010\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\u0010+\u001a\u0006\u0012\u0002\b\u00030!2\u0006\u0010$\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020-H\u0000¢\u0006\u0004\b8\u00109J2\u0010:\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020#2\n\u0010;\u001a\u00060\u0007j\u0002`\b2\n\u0010<\u001a\u0006\u0012\u0002\b\u00030\t2\b\b\u0002\u0010=\u001a\u00020#H\u0007J\u0006\u0010>\u001a\u00020?J\u0010\u0010@\u001a\u00020\u00152\u0006\u00100\u001a\u000201H\u0002J\u001b\u0010A\u001a\u00020\u00152\f\u00103\u001a\b\u0012\u0004\u0012\u0002010 H\u0000¢\u0006\u0002\bBR\"\u0010\u0005\u001a\u0016\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR&\u0010\f\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e0\rj\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e`\u000fX\u0004¢\u0006\u0002\n\u0000R%\u0010\u0010\u001a\u0016\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006C"}, d2 = {"Lorg/koin/core/registry/InstanceRegistry;", "", "_koin", "Lorg/koin/core/Koin;", "(Lorg/koin/core/Koin;)V", "_instances", "", "", "Lorg/koin/core/definition/IndexKey;", "Lorg/koin/core/instance/InstanceFactory;", "get_koin", "()Lorg/koin/core/Koin;", "eagerInstances", "Ljava/util/HashSet;", "Lorg/koin/core/instance/SingleInstanceFactory;", "Lkotlin/collections/HashSet;", "instances", "", "getInstances", "()Ljava/util/Map;", "close", "", "close$koin_core", "createAllEagerInstances", "createAllEagerInstances$koin_core", "createEagerInstances", "declareInstance", "T", "instance", "qualifier", "Lorg/koin/core/qualifier/Qualifier;", "secondaryTypes", "", "Lkotlin/reflect/KClass;", "allowOverride", "", "scopeQualifier", "(Ljava/lang/Object;Lorg/koin/core/qualifier/Qualifier;Ljava/util/List;ZLorg/koin/core/qualifier/Qualifier;)V", "dropScopeInstances", "scope", "Lorg/koin/core/scope/Scope;", "dropScopeInstances$koin_core", "getAll", "clazz", "instanceContext", "Lorg/koin/core/instance/InstanceContext;", "getAll$koin_core", "loadModule", "module", "Lorg/koin/core/module/Module;", "loadModules", "modules", "loadModules$koin_core", "resolveDefinition", "resolveDefinition$koin_core", "resolveInstance", "resolveInstance$koin_core", "(Lorg/koin/core/qualifier/Qualifier;Lkotlin/reflect/KClass;Lorg/koin/core/qualifier/Qualifier;Lorg/koin/core/instance/InstanceContext;)Ljava/lang/Object;", "saveMapping", "mapping", "factory", "logWarning", "size", "", "unloadModule", "unloadModules", "unloadModules$koin_core", "koin-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class InstanceRegistry {
    @NotNull
    private final Map<String, InstanceFactory<?>> _instances = KoinPlatformTools.INSTANCE.safeHashMap();
    @NotNull
    private final Koin _koin;
    @NotNull
    private final HashSet<SingleInstanceFactory<?>> eagerInstances = new HashSet<>();

    public InstanceRegistry(@NotNull Koin koin) {
        Intrinsics.checkNotNullParameter(koin, "_koin");
        this._koin = koin;
    }

    private final void createEagerInstances(HashSet<SingleInstanceFactory<?>> hashSet) {
        if (!hashSet.isEmpty()) {
            if (this._koin.getLogger().isAt(Level.DEBUG)) {
                this._koin.getLogger().debug("Creating eager instances ...");
            }
            Koin koin = this._koin;
            InstanceContext instanceContext = new InstanceContext(koin, koin.getScopeRegistry().getRootScope(), (ParametersHolder) null, 4, (DefaultConstructorMarker) null);
            for (SingleInstanceFactory singleInstanceFactory : hashSet) {
                singleInstanceFactory.get(instanceContext);
            }
        }
    }

    public static /* synthetic */ void declareInstance$default(InstanceRegistry instanceRegistry, Object obj, Qualifier qualifier, List list, boolean z11, Qualifier qualifier2, int i11, Object obj2) {
        Qualifier qualifier3;
        List list2;
        boolean z12;
        if ((i11 & 2) != 0) {
            qualifier3 = null;
        } else {
            qualifier3 = qualifier;
        }
        if ((i11 & 4) != 0) {
            list2 = CollectionsKt__CollectionsKt.emptyList();
        } else {
            list2 = list;
        }
        if ((i11 & 8) != 0) {
            z12 = true;
        } else {
            z12 = z11;
        }
        Intrinsics.checkNotNullParameter(list2, "secondaryTypes");
        Intrinsics.checkNotNullParameter(qualifier2, "scopeQualifier");
        Kind kind = Kind.Scoped;
        Intrinsics.needClassReification();
        Object obj3 = obj;
        InstanceRegistry$declareInstance$def$1 instanceRegistry$declareInstance$def$1 = new InstanceRegistry$declareInstance$def$1(obj);
        Intrinsics.reifiedOperationMarker(4, "T");
        BeanDefinition beanDefinition = new BeanDefinition(qualifier2, Reflection.getOrCreateKotlinClass(Object.class), qualifier3, instanceRegistry$declareInstance$def$1, kind, list2);
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(beanDefinition);
        saveMapping$default(instanceRegistry, z12, BeanDefinitionKt.indexKey(beanDefinition.getPrimaryType(), beanDefinition.getQualifier(), beanDefinition.getScopeQualifier()), scopedInstanceFactory, false, 8, (Object) null);
        for (KClass indexKey : beanDefinition.getSecondaryTypes()) {
            saveMapping$default(instanceRegistry, z12, BeanDefinitionKt.indexKey(indexKey, beanDefinition.getQualifier(), beanDefinition.getScopeQualifier()), scopedInstanceFactory, false, 8, (Object) null);
        }
    }

    private final void loadModule(Module module, boolean z11) {
        for (Map.Entry next : module.getMappings().entrySet()) {
            saveMapping$default(this, z11, (String) next.getKey(), (InstanceFactory) next.getValue(), false, 8, (Object) null);
        }
    }

    public static /* synthetic */ void saveMapping$default(InstanceRegistry instanceRegistry, boolean z11, String str, InstanceFactory instanceFactory, boolean z12, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            z12 = true;
        }
        instanceRegistry.saveMapping(z11, str, instanceFactory, z12);
    }

    private final void unloadModule(Module module) {
        Set<String> keySet = module.getMappings().keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "module.mappings.keys");
        for (String str : keySet) {
            if (this._instances.containsKey(str)) {
                InstanceFactory instanceFactory = this._instances.get(str);
                if (instanceFactory != null) {
                    instanceFactory.dropAll();
                }
                this._instances.remove(str);
            }
        }
    }

    public final void close$koin_core() {
        for (Map.Entry next : this._instances.entrySet()) {
            String str = (String) next.getKey();
            ((InstanceFactory) next.getValue()).dropAll();
        }
        this._instances.clear();
    }

    public final void createAllEagerInstances$koin_core() {
        createEagerInstances(this.eagerInstances);
        this.eagerInstances.clear();
    }

    @PublishedApi
    public final /* synthetic */ <T> void declareInstance(T t11, Qualifier qualifier, List<? extends KClass<?>> list, boolean z11, Qualifier qualifier2) {
        List<? extends KClass<?>> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "secondaryTypes");
        Qualifier qualifier3 = qualifier2;
        Intrinsics.checkNotNullParameter(qualifier3, "scopeQualifier");
        Kind kind = Kind.Scoped;
        Intrinsics.needClassReification();
        T t12 = t11;
        InstanceRegistry$declareInstance$def$1 instanceRegistry$declareInstance$def$1 = new InstanceRegistry$declareInstance$def$1(t11);
        Intrinsics.reifiedOperationMarker(4, "T");
        BeanDefinition beanDefinition = new BeanDefinition(qualifier3, Reflection.getOrCreateKotlinClass(Object.class), qualifier, instanceRegistry$declareInstance$def$1, kind, list2);
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(beanDefinition);
        saveMapping$default(this, z11, BeanDefinitionKt.indexKey(beanDefinition.getPrimaryType(), beanDefinition.getQualifier(), beanDefinition.getScopeQualifier()), scopedInstanceFactory, false, 8, (Object) null);
        for (KClass indexKey : beanDefinition.getSecondaryTypes()) {
            saveMapping$default(this, z11, BeanDefinitionKt.indexKey(indexKey, beanDefinition.getQualifier(), beanDefinition.getScopeQualifier()), scopedInstanceFactory, false, 8, (Object) null);
        }
    }

    public final void dropScopeInstances$koin_core(@NotNull Scope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        ArrayList<ScopedInstanceFactory> arrayList = new ArrayList<>();
        for (Object next : this._instances.values()) {
            if (next instanceof ScopedInstanceFactory) {
                arrayList.add(next);
            }
        }
        for (ScopedInstanceFactory drop : arrayList) {
            drop.drop(scope);
        }
    }

    @NotNull
    public final <T> List<T> getAll$koin_core(@NotNull KClass<?> kClass, @NotNull InstanceContext instanceContext) {
        boolean z11;
        Intrinsics.checkNotNullParameter(kClass, "clazz");
        Intrinsics.checkNotNullParameter(instanceContext, "instanceContext");
        ArrayList arrayList = new ArrayList();
        for (Object next : this._instances.values()) {
            if (Intrinsics.areEqual((Object) ((InstanceFactory) next).getBeanDefinition().getScopeQualifier(), (Object) instanceContext.getScope().getScopeQualifier())) {
                arrayList.add(next);
            }
        }
        ArrayList<InstanceFactory> arrayList2 = new ArrayList<>();
        for (Object next2 : arrayList) {
            InstanceFactory instanceFactory = (InstanceFactory) next2;
            if (Intrinsics.areEqual((Object) instanceFactory.getBeanDefinition().getPrimaryType(), (Object) kClass) || instanceFactory.getBeanDefinition().getSecondaryTypes().contains(kClass)) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                arrayList2.add(next2);
            }
        }
        ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10));
        for (InstanceFactory instanceFactory2 : arrayList2) {
            arrayList3.add(instanceFactory2.get(instanceContext));
        }
        return arrayList3;
    }

    @NotNull
    public final Map<String, InstanceFactory<?>> getInstances() {
        return this._instances;
    }

    @NotNull
    public final Koin get_koin() {
        return this._koin;
    }

    public final void loadModules$koin_core(@NotNull List<Module> list, boolean z11) {
        Intrinsics.checkNotNullParameter(list, "modules");
        for (Module module : list) {
            loadModule(module, z11);
            this.eagerInstances.addAll(module.getEagerInstances());
        }
    }

    @Nullable
    public final InstanceFactory<?> resolveDefinition$koin_core(@NotNull KClass<?> kClass, @Nullable Qualifier qualifier, @NotNull Qualifier qualifier2) {
        Intrinsics.checkNotNullParameter(kClass, "clazz");
        Intrinsics.checkNotNullParameter(qualifier2, "scopeQualifier");
        return this._instances.get(BeanDefinitionKt.indexKey(kClass, qualifier, qualifier2));
    }

    @Nullable
    public final <T> T resolveInstance$koin_core(@Nullable Qualifier qualifier, @NotNull KClass<?> kClass, @NotNull Qualifier qualifier2, @NotNull InstanceContext instanceContext) {
        Intrinsics.checkNotNullParameter(kClass, "clazz");
        Intrinsics.checkNotNullParameter(qualifier2, "scopeQualifier");
        Intrinsics.checkNotNullParameter(instanceContext, "instanceContext");
        InstanceFactory<?> resolveDefinition$koin_core = resolveDefinition$koin_core(kClass, qualifier, qualifier2);
        if (resolveDefinition$koin_core == null) {
            return null;
        }
        return resolveDefinition$koin_core.get(instanceContext);
    }

    @KoinInternalApi
    public final void saveMapping(boolean z11, @NotNull String str, @NotNull InstanceFactory<?> instanceFactory, boolean z12) {
        Intrinsics.checkNotNullParameter(str, "mapping");
        Intrinsics.checkNotNullParameter(instanceFactory, "factory");
        if (this._instances.containsKey(str)) {
            if (!z11) {
                ModuleKt.overrideError(instanceFactory, str);
            } else if (z12) {
                Logger logger = this._koin.getLogger();
                logger.info("Override Mapping '" + str + "' with " + instanceFactory.getBeanDefinition());
            }
        }
        if (this._koin.getLogger().isAt(Level.DEBUG) && z12) {
            Logger logger2 = this._koin.getLogger();
            logger2.debug("add mapping '" + str + "' for " + instanceFactory.getBeanDefinition());
        }
        this._instances.put(str, instanceFactory);
    }

    public final int size() {
        return this._instances.size();
    }

    public final void unloadModules$koin_core(@NotNull List<Module> list) {
        Intrinsics.checkNotNullParameter(list, "modules");
        for (Module unloadModule : list) {
            unloadModule(unloadModule);
        }
    }
}
