package org.koin.dsl;

import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.core.annotation.KoinReflectAPI;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.definition.BeanDefinitionKt;
import org.koin.core.definition.Kind;
import org.koin.core.instance.FactoryInstanceFactory;
import org.koin.core.instance.InstanceFactory;
import org.koin.core.instance.SingleInstanceFactory;
import org.koin.core.module.Module;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.qualifier.StringQualifier;
import org.koin.core.registry.ScopeRegistry;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u001a7\u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u0005*\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\b\u001aA\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u0005*\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\nH\b¨\u0006\u000b"}, d2 = {"factory", "Lkotlin/Pair;", "Lorg/koin/core/module/Module;", "Lorg/koin/core/instance/InstanceFactory;", "T", "", "qualifier", "Lorg/koin/core/qualifier/Qualifier;", "single", "createOnStart", "", "koin-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class ModuleExtKt {
    @KoinReflectAPI
    public static final /* synthetic */ <T> Pair<Module, InstanceFactory<T>> factory(Module module, Qualifier qualifier) {
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.needClassReification();
        ModuleExtKt$factory$1 moduleExtKt$factory$1 = new ModuleExtKt$factory$1();
        StringQualifier rootScopeQualifier = ScopeRegistry.Companion.getRootScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt__CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "T");
        BeanDefinition beanDefinition = new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier, moduleExtKt$factory$1, kind, emptyList);
        String indexKey = BeanDefinitionKt.indexKey(beanDefinition.getPrimaryType(), qualifier, rootScopeQualifier);
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(beanDefinition);
        Module.saveMapping$default(module, indexKey, factoryInstanceFactory, false, 4, (Object) null);
        return new Pair<>(module, factoryInstanceFactory);
    }

    public static /* synthetic */ Pair factory$default(Module module, Qualifier qualifier, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            qualifier = null;
        }
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.needClassReification();
        ModuleExtKt$factory$1 moduleExtKt$factory$1 = new ModuleExtKt$factory$1();
        StringQualifier rootScopeQualifier = ScopeRegistry.Companion.getRootScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt__CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "T");
        BeanDefinition beanDefinition = new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier, moduleExtKt$factory$1, kind, emptyList);
        String indexKey = BeanDefinitionKt.indexKey(beanDefinition.getPrimaryType(), qualifier, rootScopeQualifier);
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(beanDefinition);
        Module.saveMapping$default(module, indexKey, factoryInstanceFactory, false, 4, (Object) null);
        return new Pair(module, factoryInstanceFactory);
    }

    @KoinReflectAPI
    public static final /* synthetic */ <T> Pair<Module, InstanceFactory<T>> single(Module module, Qualifier qualifier, boolean z11) {
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.needClassReification();
        ModuleExtKt$single$1 moduleExtKt$single$1 = new ModuleExtKt$single$1();
        Kind kind = Kind.Singleton;
        ScopeRegistry.Companion companion = ScopeRegistry.Companion;
        StringQualifier rootScopeQualifier = companion.getRootScopeQualifier();
        List emptyList = CollectionsKt__CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "T");
        BeanDefinition beanDefinition = new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier, moduleExtKt$single$1, kind, emptyList);
        String indexKey = BeanDefinitionKt.indexKey(beanDefinition.getPrimaryType(), qualifier, companion.getRootScopeQualifier());
        SingleInstanceFactory singleInstanceFactory = new SingleInstanceFactory(beanDefinition);
        Module.saveMapping$default(module, indexKey, singleInstanceFactory, false, 4, (Object) null);
        if (z11 || module.getCreatedAtStart()) {
            module.getEagerInstances().add(singleInstanceFactory);
        }
        return new Pair<>(module, singleInstanceFactory);
    }

    public static /* synthetic */ Pair single$default(Module module, Qualifier qualifier, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            qualifier = null;
        }
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.needClassReification();
        ModuleExtKt$single$1 moduleExtKt$single$1 = new ModuleExtKt$single$1();
        Kind kind = Kind.Singleton;
        ScopeRegistry.Companion companion = ScopeRegistry.Companion;
        StringQualifier rootScopeQualifier = companion.getRootScopeQualifier();
        List emptyList = CollectionsKt__CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "T");
        BeanDefinition beanDefinition = new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier, moduleExtKt$single$1, kind, emptyList);
        String indexKey = BeanDefinitionKt.indexKey(beanDefinition.getPrimaryType(), qualifier, companion.getRootScopeQualifier());
        SingleInstanceFactory singleInstanceFactory = new SingleInstanceFactory(beanDefinition);
        Module.saveMapping$default(module, indexKey, singleInstanceFactory, false, 4, (Object) null);
        if (z11 || module.getCreatedAtStart()) {
            module.getEagerInstances().add(singleInstanceFactory);
        }
        return new Pair(module, singleInstanceFactory);
    }
}
