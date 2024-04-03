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
import org.koin.core.instance.ScopedInstanceFactory;
import org.koin.core.module.Module;
import org.koin.core.qualifier.Qualifier;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a7\u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u0005*\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\b\u001a7\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u0005*\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\b¨\u0006\n"}, d2 = {"factory", "Lkotlin/Pair;", "Lorg/koin/core/module/Module;", "Lorg/koin/core/instance/InstanceFactory;", "R", "", "Lorg/koin/dsl/ScopeDSL;", "qualifier", "Lorg/koin/core/qualifier/Qualifier;", "scoped", "koin-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class ScopeSetExtKt {
    @KoinReflectAPI
    public static final /* synthetic */ <R> Pair<Module, InstanceFactory<R>> factory(ScopeDSL scopeDSL, Qualifier qualifier) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.needClassReification();
        ScopeSetExtKt$factory$1 scopeSetExtKt$factory$1 = new ScopeSetExtKt$factory$1();
        Module module = scopeDSL.getModule();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt__CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        BeanDefinition beanDefinition = new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier, scopeSetExtKt$factory$1, kind, emptyList);
        String indexKey = BeanDefinitionKt.indexKey(beanDefinition.getPrimaryType(), qualifier, scopeQualifier);
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(beanDefinition);
        Module.saveMapping$default(module, indexKey, factoryInstanceFactory, false, 4, (Object) null);
        return new Pair<>(module, factoryInstanceFactory);
    }

    public static /* synthetic */ Pair factory$default(ScopeDSL scopeDSL, Qualifier qualifier, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            qualifier = null;
        }
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.needClassReification();
        ScopeSetExtKt$factory$1 scopeSetExtKt$factory$1 = new ScopeSetExtKt$factory$1();
        Module module = scopeDSL.getModule();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt__CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        BeanDefinition beanDefinition = new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier, scopeSetExtKt$factory$1, kind, emptyList);
        String indexKey = BeanDefinitionKt.indexKey(beanDefinition.getPrimaryType(), qualifier, scopeQualifier);
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(beanDefinition);
        Module.saveMapping$default(module, indexKey, factoryInstanceFactory, false, 4, (Object) null);
        return new Pair(module, factoryInstanceFactory);
    }

    @KoinReflectAPI
    public static final /* synthetic */ <R> Pair<Module, InstanceFactory<R>> scoped(ScopeDSL scopeDSL, Qualifier qualifier) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.needClassReification();
        ScopeSetExtKt$scoped$1 scopeSetExtKt$scoped$1 = new ScopeSetExtKt$scoped$1();
        Kind kind = Kind.Scoped;
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        List emptyList = CollectionsKt__CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        BeanDefinition beanDefinition = new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier, scopeSetExtKt$scoped$1, kind, emptyList);
        String indexKey = BeanDefinitionKt.indexKey(beanDefinition.getPrimaryType(), qualifier, scopeDSL.getScopeQualifier());
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(beanDefinition);
        Module.saveMapping$default(scopeDSL.getModule(), indexKey, scopedInstanceFactory, false, 4, (Object) null);
        return new Pair<>(scopeDSL.getModule(), scopedInstanceFactory);
    }

    public static /* synthetic */ Pair scoped$default(ScopeDSL scopeDSL, Qualifier qualifier, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            qualifier = null;
        }
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.needClassReification();
        ScopeSetExtKt$scoped$1 scopeSetExtKt$scoped$1 = new ScopeSetExtKt$scoped$1();
        Kind kind = Kind.Scoped;
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        List emptyList = CollectionsKt__CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        BeanDefinition beanDefinition = new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier, scopeSetExtKt$scoped$1, kind, emptyList);
        String indexKey = BeanDefinitionKt.indexKey(beanDefinition.getPrimaryType(), qualifier, scopeDSL.getScopeQualifier());
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(beanDefinition);
        Module.saveMapping$default(scopeDSL.getModule(), indexKey, scopedInstanceFactory, false, 4, (Object) null);
        return new Pair(scopeDSL.getModule(), scopedInstanceFactory);
    }
}
