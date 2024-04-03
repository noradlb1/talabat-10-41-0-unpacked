package com.deliveryhero.customerchat.di;

import com.deliveryhero.customerchat.commons.ChatUtils;
import com.deliveryhero.customerchat.eventTracking.utils.EventUtils;
import com.deliveryhero.customerchat.helpers.dateProvider.DateProvider;
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
import org.koin.core.module.Module;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.qualifier.StringQualifier;
import org.koin.core.registry.ScopeRegistry;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lorg/koin/core/module/Module;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ModuleProviderKt$helpersModule$1 extends Lambda implements Function1<Module, Unit> {
    public static final ModuleProviderKt$helpersModule$1 INSTANCE = new ModuleProviderKt$helpersModule$1();

    public ModuleProviderKt$helpersModule$1() {
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
        BeanDefinition beanDefinition = new BeanDefinition(stringQualifier, Reflection.getOrCreateKotlinClass(DateProvider.class), (Qualifier) null, r11, kind, CollectionsKt__CollectionsKt.emptyList());
        String indexKey = BeanDefinitionKt.indexKey(beanDefinition.getPrimaryType(), (Qualifier) null, rootScopeQualifier);
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(beanDefinition);
        Module.saveMapping$default(module, indexKey, factoryInstanceFactory, false, 4, (Object) null);
        new Pair(module2, factoryInstanceFactory);
        AnonymousClass2 r19 = AnonymousClass2.INSTANCE;
        StringQualifier rootScopeQualifier2 = companion.getRootScopeQualifier();
        StringQualifier stringQualifier2 = rootScopeQualifier2;
        Kind kind2 = kind;
        BeanDefinition beanDefinition2 = new BeanDefinition(stringQualifier2, Reflection.getOrCreateKotlinClass(ChatUtils.class), (Qualifier) null, r19, kind2, CollectionsKt__CollectionsKt.emptyList());
        String indexKey2 = BeanDefinitionKt.indexKey(beanDefinition2.getPrimaryType(), (Qualifier) null, rootScopeQualifier2);
        FactoryInstanceFactory factoryInstanceFactory2 = new FactoryInstanceFactory(beanDefinition2);
        Module.saveMapping$default(module, indexKey2, factoryInstanceFactory2, false, 4, (Object) null);
        new Pair(module2, factoryInstanceFactory2);
        AnonymousClass3 r192 = AnonymousClass3.INSTANCE;
        StringQualifier rootScopeQualifier3 = companion.getRootScopeQualifier();
        StringQualifier stringQualifier3 = rootScopeQualifier3;
        BeanDefinition beanDefinition3 = new BeanDefinition(stringQualifier3, Reflection.getOrCreateKotlinClass(EventUtils.class), (Qualifier) null, r192, kind2, CollectionsKt__CollectionsKt.emptyList());
        String indexKey3 = BeanDefinitionKt.indexKey(beanDefinition3.getPrimaryType(), (Qualifier) null, rootScopeQualifier3);
        FactoryInstanceFactory factoryInstanceFactory3 = new FactoryInstanceFactory(beanDefinition3);
        Module.saveMapping$default(module, indexKey3, factoryInstanceFactory3, false, 4, (Object) null);
        new Pair(module2, factoryInstanceFactory3);
    }
}
