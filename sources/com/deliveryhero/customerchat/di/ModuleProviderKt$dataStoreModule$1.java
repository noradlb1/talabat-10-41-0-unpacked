package com.deliveryhero.customerchat.di;

import com.deliveryhero.contract.configuration.PersistableChatConfiguration;
import com.deliveryhero.contract.datastore.ChatConfigurationDataStoreHelper;
import com.deliveryhero.contract.datastore.PersistableChatConfigurationSerializer;
import com.deliveryhero.customerchat.commons.encryption.CryptoManager;
import com.deliveryhero.customerchat.datastore.UserPropertiesDataStoreHelper;
import com.deliveryhero.customerchat.datastore.UserPropertiesSerializer;
import com.deliveryhero.customerchat.eventTracking.data.UserProperties;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.definition.BeanDefinitionKt;
import org.koin.core.definition.Kind;
import org.koin.core.instance.FactoryInstanceFactory;
import org.koin.core.instance.SingleInstanceFactory;
import org.koin.core.module.Module;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.qualifier.StringQualifier;
import org.koin.core.registry.ScopeRegistry;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lorg/koin/core/module/Module;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ModuleProviderKt$dataStoreModule$1 extends Lambda implements Function1<Module, Unit> {
    public static final ModuleProviderKt$dataStoreModule$1 INSTANCE = new ModuleProviderKt$dataStoreModule$1();

    public ModuleProviderKt$dataStoreModule$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Module) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Module module) {
        Module module2 = module;
        Intrinsics.checkNotNullParameter(module2, "$this$module");
        AnonymousClass1 r11 = AnonymousClass1.INSTANCE;
        ScopeRegistry.Companion companion = ScopeRegistry.Companion;
        StringQualifier rootScopeQualifier = companion.getRootScopeQualifier();
        Kind kind = Kind.Factory;
        StringQualifier stringQualifier = rootScopeQualifier;
        BeanDefinition beanDefinition = new BeanDefinition(stringQualifier, Reflection.getOrCreateKotlinClass(PersistableChatConfiguration.class), (Qualifier) null, r11, kind, CollectionsKt__CollectionsKt.emptyList());
        String indexKey = BeanDefinitionKt.indexKey(beanDefinition.getPrimaryType(), (Qualifier) null, rootScopeQualifier);
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(beanDefinition);
        Module.saveMapping$default(module, indexKey, factoryInstanceFactory, false, 4, (Object) null);
        new Pair(module2, factoryInstanceFactory);
        AnonymousClass2 r19 = AnonymousClass2.INSTANCE;
        StringQualifier rootScopeQualifier2 = companion.getRootScopeQualifier();
        StringQualifier stringQualifier2 = rootScopeQualifier2;
        BeanDefinition beanDefinition2 = new BeanDefinition(stringQualifier2, Reflection.getOrCreateKotlinClass(UserProperties.class), (Qualifier) null, r19, kind, CollectionsKt__CollectionsKt.emptyList());
        String indexKey2 = BeanDefinitionKt.indexKey(beanDefinition2.getPrimaryType(), (Qualifier) null, rootScopeQualifier2);
        FactoryInstanceFactory factoryInstanceFactory2 = new FactoryInstanceFactory(beanDefinition2);
        Module.saveMapping$default(module, indexKey2, factoryInstanceFactory2, false, 4, (Object) null);
        new Pair(module2, factoryInstanceFactory2);
        AnonymousClass3 r192 = AnonymousClass3.INSTANCE;
        Kind kind2 = Kind.Singleton;
        BeanDefinition beanDefinition3 = new BeanDefinition(companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(CryptoManager.class), (Qualifier) null, r192, kind2, CollectionsKt__CollectionsKt.emptyList());
        String indexKey3 = BeanDefinitionKt.indexKey(beanDefinition3.getPrimaryType(), (Qualifier) null, companion.getRootScopeQualifier());
        SingleInstanceFactory singleInstanceFactory = new SingleInstanceFactory(beanDefinition3);
        Module.saveMapping$default(module, indexKey3, singleInstanceFactory, false, 4, (Object) null);
        if (module.getCreatedAtStart()) {
            module.getEagerInstances().add(singleInstanceFactory);
        }
        new Pair(module2, singleInstanceFactory);
        AnonymousClass4 r24 = AnonymousClass4.INSTANCE;
        BeanDefinition beanDefinition4 = new BeanDefinition(companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(PersistableChatConfigurationSerializer.class), (Qualifier) null, r24, kind2, CollectionsKt__CollectionsKt.emptyList());
        String indexKey4 = BeanDefinitionKt.indexKey(beanDefinition4.getPrimaryType(), (Qualifier) null, companion.getRootScopeQualifier());
        SingleInstanceFactory singleInstanceFactory2 = new SingleInstanceFactory(beanDefinition4);
        Module.saveMapping$default(module, indexKey4, singleInstanceFactory2, false, 4, (Object) null);
        if (module.getCreatedAtStart()) {
            module.getEagerInstances().add(singleInstanceFactory2);
        }
        new Pair(module2, singleInstanceFactory2);
        AnonymousClass5 r242 = AnonymousClass5.INSTANCE;
        BeanDefinition beanDefinition5 = new BeanDefinition(companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(UserPropertiesSerializer.class), (Qualifier) null, r242, kind2, CollectionsKt__CollectionsKt.emptyList());
        String indexKey5 = BeanDefinitionKt.indexKey(beanDefinition5.getPrimaryType(), (Qualifier) null, companion.getRootScopeQualifier());
        SingleInstanceFactory singleInstanceFactory3 = new SingleInstanceFactory(beanDefinition5);
        Module.saveMapping$default(module, indexKey5, singleInstanceFactory3, false, 4, (Object) null);
        if (module.getCreatedAtStart()) {
            module.getEagerInstances().add(singleInstanceFactory3);
        }
        new Pair(module2, singleInstanceFactory3);
        AnonymousClass6 r243 = AnonymousClass6.INSTANCE;
        BeanDefinition beanDefinition6 = new BeanDefinition(companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ChatConfigurationDataStoreHelper.class), (Qualifier) null, r243, kind2, CollectionsKt__CollectionsKt.emptyList());
        String indexKey6 = BeanDefinitionKt.indexKey(beanDefinition6.getPrimaryType(), (Qualifier) null, companion.getRootScopeQualifier());
        SingleInstanceFactory singleInstanceFactory4 = new SingleInstanceFactory(beanDefinition6);
        Module.saveMapping$default(module, indexKey6, singleInstanceFactory4, false, 4, (Object) null);
        if (module.getCreatedAtStart()) {
            module.getEagerInstances().add(singleInstanceFactory4);
        }
        new Pair(module2, singleInstanceFactory4);
        AnonymousClass7 r244 = AnonymousClass7.INSTANCE;
        BeanDefinition beanDefinition7 = new BeanDefinition(companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(UserPropertiesDataStoreHelper.class), (Qualifier) null, r244, kind2, CollectionsKt__CollectionsKt.emptyList());
        String indexKey7 = BeanDefinitionKt.indexKey(beanDefinition7.getPrimaryType(), (Qualifier) null, companion.getRootScopeQualifier());
        SingleInstanceFactory singleInstanceFactory5 = new SingleInstanceFactory(beanDefinition7);
        Module.saveMapping$default(module, indexKey7, singleInstanceFactory5, false, 4, (Object) null);
        if (module.getCreatedAtStart()) {
            module.getEagerInstances().add(singleInstanceFactory5);
        }
        new Pair(module2, singleInstanceFactory5);
    }
}
