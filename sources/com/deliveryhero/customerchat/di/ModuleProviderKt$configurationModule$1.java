package com.deliveryhero.customerchat.di;

import com.deliveryhero.contract.configuration.ChatConfiguration;
import com.deliveryhero.contract.configuration.ChatFeatureCallbacks;
import com.deliveryhero.customerchat.configuration.ChatConfigProvider;
import com.deliveryhero.customerchat.telephony.repository.PushConfigRepository;
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
import org.koin.core.instance.SingleInstanceFactory;
import org.koin.core.module.Module;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.registry.ScopeRegistry;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lorg/koin/core/module/Module;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ModuleProviderKt$configurationModule$1 extends Lambda implements Function1<Module, Unit> {
    public static final ModuleProviderKt$configurationModule$1 INSTANCE = new ModuleProviderKt$configurationModule$1();

    public ModuleProviderKt$configurationModule$1() {
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
        Kind kind = Kind.Singleton;
        ScopeRegistry.Companion companion = ScopeRegistry.Companion;
        BeanDefinition beanDefinition = new BeanDefinition(companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ChatConfiguration.class), (Qualifier) null, r11, kind, CollectionsKt__CollectionsKt.emptyList());
        String indexKey = BeanDefinitionKt.indexKey(beanDefinition.getPrimaryType(), (Qualifier) null, companion.getRootScopeQualifier());
        SingleInstanceFactory singleInstanceFactory = new SingleInstanceFactory(beanDefinition);
        Module.saveMapping$default(module, indexKey, singleInstanceFactory, false, 4, (Object) null);
        if (module.getCreatedAtStart()) {
            module.getEagerInstances().add(singleInstanceFactory);
        }
        new Pair(module2, singleInstanceFactory);
        AnonymousClass2 r16 = AnonymousClass2.INSTANCE;
        BeanDefinition beanDefinition2 = new BeanDefinition(companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ChatFeatureCallbacks.class), (Qualifier) null, r16, kind, CollectionsKt__CollectionsKt.emptyList());
        String indexKey2 = BeanDefinitionKt.indexKey(beanDefinition2.getPrimaryType(), (Qualifier) null, companion.getRootScopeQualifier());
        SingleInstanceFactory singleInstanceFactory2 = new SingleInstanceFactory(beanDefinition2);
        Module.saveMapping$default(module, indexKey2, singleInstanceFactory2, false, 4, (Object) null);
        if (module.getCreatedAtStart()) {
            module.getEagerInstances().add(singleInstanceFactory2);
        }
        new Pair(module2, singleInstanceFactory2);
        AnonymousClass3 r162 = AnonymousClass3.INSTANCE;
        BeanDefinition beanDefinition3 = new BeanDefinition(companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(PushConfigRepository.class), (Qualifier) null, r162, kind, CollectionsKt__CollectionsKt.emptyList());
        String indexKey3 = BeanDefinitionKt.indexKey(beanDefinition3.getPrimaryType(), (Qualifier) null, companion.getRootScopeQualifier());
        SingleInstanceFactory singleInstanceFactory3 = new SingleInstanceFactory(beanDefinition3);
        Module.saveMapping$default(module, indexKey3, singleInstanceFactory3, false, 4, (Object) null);
        if (module.getCreatedAtStart()) {
            module.getEagerInstances().add(singleInstanceFactory3);
        }
        new Pair(module2, singleInstanceFactory3);
        AnonymousClass4 r163 = AnonymousClass4.INSTANCE;
        BeanDefinition beanDefinition4 = new BeanDefinition(companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ChatConfigProvider.class), (Qualifier) null, r163, kind, CollectionsKt__CollectionsKt.emptyList());
        String indexKey4 = BeanDefinitionKt.indexKey(beanDefinition4.getPrimaryType(), (Qualifier) null, companion.getRootScopeQualifier());
        SingleInstanceFactory singleInstanceFactory4 = new SingleInstanceFactory(beanDefinition4);
        Module.saveMapping$default(module, indexKey4, singleInstanceFactory4, false, 4, (Object) null);
        if (module.getCreatedAtStart()) {
            module.getEagerInstances().add(singleInstanceFactory4);
        }
        new Pair(module2, singleInstanceFactory4);
    }
}
