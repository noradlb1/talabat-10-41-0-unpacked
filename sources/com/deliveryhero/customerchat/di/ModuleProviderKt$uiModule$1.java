package com.deliveryhero.customerchat.di;

import com.deliveryhero.chatui.data.event.EventHandler;
import com.deliveryhero.chatui.view.chatroom.ChatViewModel;
import com.deliveryhero.chatui.view.chatroom.connectivity.ConnectivityMonitor;
import com.deliveryhero.chatui.view.chatroom.mapper.ChatMessageViewModelMapper;
import com.deliveryhero.chatui.view.root.CustomerChatViewModel;
import com.deliveryhero.chatui.view.util.PermissionModule;
import com.deliveryhero.chatui.view.util.StylingProvider;
import com.deliveryhero.customerchat.commons.ChatPreferences;
import com.deliveryhero.customerchat.fwf.FWFService;
import com.deliveryhero.customerchat.fwf.FeatureFlagProvider;
import com.deliveryhero.customerchat.service.ChannelService;
import com.deliveryhero.customerchat.telephony.util.dispatcher.Dispatcher;
import com.deliveryhero.customerchat.view.util.AttributeUtils;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
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
public final class ModuleProviderKt$uiModule$1 extends Lambda implements Function1<Module, Unit> {
    public static final ModuleProviderKt$uiModule$1 INSTANCE = new ModuleProviderKt$uiModule$1();

    public ModuleProviderKt$uiModule$1() {
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
        BeanDefinition beanDefinition = new BeanDefinition(companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(EventHandler.class), (Qualifier) null, r11, kind, CollectionsKt__CollectionsKt.emptyList());
        String indexKey = BeanDefinitionKt.indexKey(beanDefinition.getPrimaryType(), (Qualifier) null, companion.getRootScopeQualifier());
        SingleInstanceFactory singleInstanceFactory = new SingleInstanceFactory(beanDefinition);
        Module.saveMapping$default(module, indexKey, singleInstanceFactory, false, 4, (Object) null);
        if (module.getCreatedAtStart()) {
            module.getEagerInstances().add(singleInstanceFactory);
        }
        new Pair(module2, singleInstanceFactory);
        AnonymousClass2 r16 = AnonymousClass2.INSTANCE;
        BeanDefinition beanDefinition2 = new BeanDefinition(companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ChatPreferences.class), (Qualifier) null, r16, kind, CollectionsKt__CollectionsKt.emptyList());
        String indexKey2 = BeanDefinitionKt.indexKey(beanDefinition2.getPrimaryType(), (Qualifier) null, companion.getRootScopeQualifier());
        SingleInstanceFactory singleInstanceFactory2 = new SingleInstanceFactory(beanDefinition2);
        Module.saveMapping$default(module, indexKey2, singleInstanceFactory2, false, 4, (Object) null);
        if (module.getCreatedAtStart()) {
            module.getEagerInstances().add(singleInstanceFactory2);
        }
        new Pair(module2, singleInstanceFactory2);
        AnonymousClass3 r162 = AnonymousClass3.INSTANCE;
        BeanDefinition beanDefinition3 = new BeanDefinition(companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(PermissionModule.class), (Qualifier) null, r162, kind, CollectionsKt__CollectionsKt.emptyList());
        String indexKey3 = BeanDefinitionKt.indexKey(beanDefinition3.getPrimaryType(), (Qualifier) null, companion.getRootScopeQualifier());
        SingleInstanceFactory singleInstanceFactory3 = new SingleInstanceFactory(beanDefinition3);
        Module.saveMapping$default(module, indexKey3, singleInstanceFactory3, false, 4, (Object) null);
        if (module.getCreatedAtStart()) {
            module.getEagerInstances().add(singleInstanceFactory3);
        }
        new Pair(module2, singleInstanceFactory3);
        AnonymousClass4 r163 = AnonymousClass4.INSTANCE;
        BeanDefinition beanDefinition4 = new BeanDefinition(companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(Dispatcher.class), (Qualifier) null, r163, kind, CollectionsKt__CollectionsKt.emptyList());
        String indexKey4 = BeanDefinitionKt.indexKey(beanDefinition4.getPrimaryType(), (Qualifier) null, companion.getRootScopeQualifier());
        SingleInstanceFactory singleInstanceFactory4 = new SingleInstanceFactory(beanDefinition4);
        Module.saveMapping$default(module, indexKey4, singleInstanceFactory4, false, 4, (Object) null);
        if (module.getCreatedAtStart()) {
            module.getEagerInstances().add(singleInstanceFactory4);
        }
        new Pair(module2, singleInstanceFactory4);
        AnonymousClass5 r164 = AnonymousClass5.INSTANCE;
        BeanDefinition beanDefinition5 = new BeanDefinition(companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(FeatureFlagProvider.class), (Qualifier) null, r164, kind, CollectionsKt__CollectionsKt.emptyList());
        String indexKey5 = BeanDefinitionKt.indexKey(beanDefinition5.getPrimaryType(), (Qualifier) null, companion.getRootScopeQualifier());
        SingleInstanceFactory singleInstanceFactory5 = new SingleInstanceFactory(beanDefinition5);
        Module.saveMapping$default(module, indexKey5, singleInstanceFactory5, false, 4, (Object) null);
        if (module.getCreatedAtStart()) {
            module.getEagerInstances().add(singleInstanceFactory5);
        }
        new Pair(module2, singleInstanceFactory5);
        AnonymousClass6 r13 = AnonymousClass6.INSTANCE;
        StringQualifier rootScopeQualifier = companion.getRootScopeQualifier();
        Kind kind2 = Kind.Factory;
        StringQualifier stringQualifier = rootScopeQualifier;
        BeanDefinition beanDefinition6 = new BeanDefinition(stringQualifier, Reflection.getOrCreateKotlinClass(FWFService.class), (Qualifier) null, r13, kind2, CollectionsKt__CollectionsKt.emptyList());
        String indexKey6 = BeanDefinitionKt.indexKey(beanDefinition6.getPrimaryType(), (Qualifier) null, rootScopeQualifier);
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(beanDefinition6);
        Module.saveMapping$default(module, indexKey6, factoryInstanceFactory, false, 4, (Object) null);
        new Pair(module2, factoryInstanceFactory);
        AnonymousClass7 r25 = AnonymousClass7.INSTANCE;
        StringQualifier rootScopeQualifier2 = companion.getRootScopeQualifier();
        StringQualifier stringQualifier2 = rootScopeQualifier2;
        Kind kind3 = kind2;
        BeanDefinition beanDefinition7 = new BeanDefinition(stringQualifier2, Reflection.getOrCreateKotlinClass(ChannelService.class), (Qualifier) null, r25, kind3, CollectionsKt__CollectionsKt.emptyList());
        String indexKey7 = BeanDefinitionKt.indexKey(beanDefinition7.getPrimaryType(), (Qualifier) null, rootScopeQualifier2);
        FactoryInstanceFactory factoryInstanceFactory2 = new FactoryInstanceFactory(beanDefinition7);
        Module.saveMapping$default(module, indexKey7, factoryInstanceFactory2, false, 4, (Object) null);
        new Pair(module2, factoryInstanceFactory2);
        AnonymousClass8 r252 = AnonymousClass8.INSTANCE;
        StringQualifier rootScopeQualifier3 = companion.getRootScopeQualifier();
        StringQualifier stringQualifier3 = rootScopeQualifier3;
        BeanDefinition beanDefinition8 = new BeanDefinition(stringQualifier3, Reflection.getOrCreateKotlinClass(ChatMessageViewModelMapper.class), (Qualifier) null, r252, kind3, CollectionsKt__CollectionsKt.emptyList());
        String indexKey8 = BeanDefinitionKt.indexKey(beanDefinition8.getPrimaryType(), (Qualifier) null, rootScopeQualifier3);
        FactoryInstanceFactory factoryInstanceFactory3 = new FactoryInstanceFactory(beanDefinition8);
        Module.saveMapping$default(module, indexKey8, factoryInstanceFactory3, false, 4, (Object) null);
        new Pair(module2, factoryInstanceFactory3);
        AnonymousClass9 r253 = AnonymousClass9.INSTANCE;
        StringQualifier rootScopeQualifier4 = companion.getRootScopeQualifier();
        StringQualifier stringQualifier4 = rootScopeQualifier4;
        BeanDefinition beanDefinition9 = new BeanDefinition(stringQualifier4, Reflection.getOrCreateKotlinClass(ConnectivityMonitor.class), (Qualifier) null, r253, kind3, CollectionsKt__CollectionsKt.emptyList());
        String indexKey9 = BeanDefinitionKt.indexKey(beanDefinition9.getPrimaryType(), (Qualifier) null, rootScopeQualifier4);
        FactoryInstanceFactory factoryInstanceFactory4 = new FactoryInstanceFactory(beanDefinition9);
        Module.saveMapping$default(module, indexKey9, factoryInstanceFactory4, false, 4, (Object) null);
        new Pair(module2, factoryInstanceFactory4);
        AnonymousClass10 r165 = AnonymousClass10.INSTANCE;
        BeanDefinition beanDefinition10 = new BeanDefinition(companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(StylingProvider.class), (Qualifier) null, r165, kind, CollectionsKt__CollectionsKt.emptyList());
        String indexKey10 = BeanDefinitionKt.indexKey(beanDefinition10.getPrimaryType(), (Qualifier) null, companion.getRootScopeQualifier());
        SingleInstanceFactory singleInstanceFactory6 = new SingleInstanceFactory(beanDefinition10);
        Module.saveMapping$default(module, indexKey10, singleInstanceFactory6, false, 4, (Object) null);
        if (module.getCreatedAtStart()) {
            module.getEagerInstances().add(singleInstanceFactory6);
        }
        new Pair(module2, singleInstanceFactory6);
        AnonymousClass11 r166 = AnonymousClass11.INSTANCE;
        BeanDefinition beanDefinition11 = new BeanDefinition(companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(AttributeUtils.class), (Qualifier) null, r166, kind, CollectionsKt__CollectionsKt.emptyList());
        String indexKey11 = BeanDefinitionKt.indexKey(beanDefinition11.getPrimaryType(), (Qualifier) null, companion.getRootScopeQualifier());
        SingleInstanceFactory singleInstanceFactory7 = new SingleInstanceFactory(beanDefinition11);
        Module.saveMapping$default(module, indexKey11, singleInstanceFactory7, false, 4, (Object) null);
        if (module.getCreatedAtStart()) {
            module.getEagerInstances().add(singleInstanceFactory7);
        }
        new Pair(module2, singleInstanceFactory7);
        AnonymousClass12 r167 = AnonymousClass12.INSTANCE;
        BeanDefinition beanDefinition12 = new BeanDefinition(companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(CoroutineScope.class), (Qualifier) null, r167, kind, CollectionsKt__CollectionsKt.emptyList());
        String indexKey12 = BeanDefinitionKt.indexKey(beanDefinition12.getPrimaryType(), (Qualifier) null, companion.getRootScopeQualifier());
        SingleInstanceFactory singleInstanceFactory8 = new SingleInstanceFactory(beanDefinition12);
        Module.saveMapping$default(module, indexKey12, singleInstanceFactory8, false, 4, (Object) null);
        if (module.getCreatedAtStart()) {
            module.getEagerInstances().add(singleInstanceFactory8);
        }
        new Pair(module2, singleInstanceFactory8);
        AnonymousClass13 r254 = AnonymousClass13.INSTANCE;
        StringQualifier rootScopeQualifier5 = companion.getRootScopeQualifier();
        StringQualifier stringQualifier5 = rootScopeQualifier5;
        Kind kind4 = kind2;
        BeanDefinition beanDefinition13 = new BeanDefinition(stringQualifier5, Reflection.getOrCreateKotlinClass(ChatViewModel.class), (Qualifier) null, r254, kind4, CollectionsKt__CollectionsKt.emptyList());
        String indexKey13 = BeanDefinitionKt.indexKey(beanDefinition13.getPrimaryType(), (Qualifier) null, rootScopeQualifier5);
        FactoryInstanceFactory factoryInstanceFactory5 = new FactoryInstanceFactory(beanDefinition13);
        Module.saveMapping$default(module, indexKey13, factoryInstanceFactory5, false, 4, (Object) null);
        new Pair(module2, factoryInstanceFactory5);
        AnonymousClass14 r255 = AnonymousClass14.INSTANCE;
        StringQualifier rootScopeQualifier6 = companion.getRootScopeQualifier();
        StringQualifier stringQualifier6 = rootScopeQualifier6;
        BeanDefinition beanDefinition14 = new BeanDefinition(stringQualifier6, Reflection.getOrCreateKotlinClass(CustomerChatViewModel.class), (Qualifier) null, r255, kind4, CollectionsKt__CollectionsKt.emptyList());
        String indexKey14 = BeanDefinitionKt.indexKey(beanDefinition14.getPrimaryType(), (Qualifier) null, rootScopeQualifier6);
        FactoryInstanceFactory factoryInstanceFactory6 = new FactoryInstanceFactory(beanDefinition14);
        Module.saveMapping$default(module, indexKey14, factoryInstanceFactory6, false, 4, (Object) null);
        new Pair(module2, factoryInstanceFactory6);
    }
}
