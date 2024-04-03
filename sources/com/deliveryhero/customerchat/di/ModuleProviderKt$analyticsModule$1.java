package com.deliveryhero.customerchat.di;

import com.deliveryhero.chatsdk.domain.TrackPushNotificationRepository;
import com.deliveryhero.chatsdk.network.http.TrackPushNotificationService;
import com.deliveryhero.customerchat.analytics.repository.AnalyticsRepository;
import com.deliveryhero.customerchat.analytics.service.AnalyticsService;
import com.deliveryhero.customerchat.eventTracking.Analytics;
import com.deliveryhero.customerchat.eventTracking.factory.CallEventsFactory;
import com.deliveryhero.customerchat.eventTracking.factory.ChatEventsFactory;
import com.deliveryhero.customerchat.eventTracking.factory.ImageEventsFactory;
import com.deliveryhero.customerchat.eventTracking.factory.LocationEventsFactory;
import com.deliveryhero.customerchat.eventTracking.factory.MessageEventsFactory;
import com.deliveryhero.customerchat.eventTracking.tracker.AnalyticsWrapper;
import com.deliveryhero.customerchat.eventTracking.tracker.CallEventsTracker;
import com.deliveryhero.customerchat.eventTracking.tracker.ChatEventsTracker;
import com.deliveryhero.customerchat.eventTracking.tracker.ImageEventsTracker;
import com.deliveryhero.customerchat.eventTracking.tracker.LocationEventsTracker;
import com.deliveryhero.customerchat.eventTracking.tracker.MessageEventsTracker;
import com.deliveryhero.customerchat.eventTracking.utils.DeviceUtils;
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
public final class ModuleProviderKt$analyticsModule$1 extends Lambda implements Function1<Module, Unit> {
    public static final ModuleProviderKt$analyticsModule$1 INSTANCE = new ModuleProviderKt$analyticsModule$1();

    public ModuleProviderKt$analyticsModule$1() {
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
        BeanDefinition beanDefinition = new BeanDefinition(companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(AnalyticsService.class), (Qualifier) null, r11, kind, CollectionsKt__CollectionsKt.emptyList());
        String indexKey = BeanDefinitionKt.indexKey(beanDefinition.getPrimaryType(), (Qualifier) null, companion.getRootScopeQualifier());
        SingleInstanceFactory singleInstanceFactory = new SingleInstanceFactory(beanDefinition);
        Module.saveMapping$default(module, indexKey, singleInstanceFactory, false, 4, (Object) null);
        if (module.getCreatedAtStart()) {
            module.getEagerInstances().add(singleInstanceFactory);
        }
        new Pair(module2, singleInstanceFactory);
        AnonymousClass2 r16 = AnonymousClass2.INSTANCE;
        BeanDefinition beanDefinition2 = new BeanDefinition(companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(AnalyticsRepository.class), (Qualifier) null, r16, kind, CollectionsKt__CollectionsKt.emptyList());
        String indexKey2 = BeanDefinitionKt.indexKey(beanDefinition2.getPrimaryType(), (Qualifier) null, companion.getRootScopeQualifier());
        SingleInstanceFactory singleInstanceFactory2 = new SingleInstanceFactory(beanDefinition2);
        Module.saveMapping$default(module, indexKey2, singleInstanceFactory2, false, 4, (Object) null);
        if (module.getCreatedAtStart()) {
            module.getEagerInstances().add(singleInstanceFactory2);
        }
        new Pair(module2, singleInstanceFactory2);
        AnonymousClass3 r162 = AnonymousClass3.INSTANCE;
        BeanDefinition beanDefinition3 = new BeanDefinition(companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(Analytics.class), (Qualifier) null, r162, kind, CollectionsKt__CollectionsKt.emptyList());
        String indexKey3 = BeanDefinitionKt.indexKey(beanDefinition3.getPrimaryType(), (Qualifier) null, companion.getRootScopeQualifier());
        SingleInstanceFactory singleInstanceFactory3 = new SingleInstanceFactory(beanDefinition3);
        Module.saveMapping$default(module, indexKey3, singleInstanceFactory3, false, 4, (Object) null);
        if (module.getCreatedAtStart()) {
            module.getEagerInstances().add(singleInstanceFactory3);
        }
        new Pair(module2, singleInstanceFactory3);
        AnonymousClass4 r13 = AnonymousClass4.INSTANCE;
        StringQualifier rootScopeQualifier = companion.getRootScopeQualifier();
        Kind kind2 = Kind.Factory;
        StringQualifier stringQualifier = rootScopeQualifier;
        BeanDefinition beanDefinition4 = new BeanDefinition(stringQualifier, Reflection.getOrCreateKotlinClass(DeviceUtils.class), (Qualifier) null, r13, kind2, CollectionsKt__CollectionsKt.emptyList());
        String indexKey4 = BeanDefinitionKt.indexKey(beanDefinition4.getPrimaryType(), (Qualifier) null, rootScopeQualifier);
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(beanDefinition4);
        Module.saveMapping$default(module, indexKey4, factoryInstanceFactory, false, 4, (Object) null);
        new Pair(module2, factoryInstanceFactory);
        AnonymousClass5 r25 = AnonymousClass5.INSTANCE;
        StringQualifier rootScopeQualifier2 = companion.getRootScopeQualifier();
        StringQualifier stringQualifier2 = rootScopeQualifier2;
        Kind kind3 = kind2;
        BeanDefinition beanDefinition5 = new BeanDefinition(stringQualifier2, Reflection.getOrCreateKotlinClass(ChatEventsFactory.class), (Qualifier) null, r25, kind3, CollectionsKt__CollectionsKt.emptyList());
        String indexKey5 = BeanDefinitionKt.indexKey(beanDefinition5.getPrimaryType(), (Qualifier) null, rootScopeQualifier2);
        FactoryInstanceFactory factoryInstanceFactory2 = new FactoryInstanceFactory(beanDefinition5);
        Module.saveMapping$default(module, indexKey5, factoryInstanceFactory2, false, 4, (Object) null);
        new Pair(module2, factoryInstanceFactory2);
        AnonymousClass6 r252 = AnonymousClass6.INSTANCE;
        StringQualifier rootScopeQualifier3 = companion.getRootScopeQualifier();
        StringQualifier stringQualifier3 = rootScopeQualifier3;
        BeanDefinition beanDefinition6 = new BeanDefinition(stringQualifier3, Reflection.getOrCreateKotlinClass(ImageEventsFactory.class), (Qualifier) null, r252, kind3, CollectionsKt__CollectionsKt.emptyList());
        String indexKey6 = BeanDefinitionKt.indexKey(beanDefinition6.getPrimaryType(), (Qualifier) null, rootScopeQualifier3);
        FactoryInstanceFactory factoryInstanceFactory3 = new FactoryInstanceFactory(beanDefinition6);
        Module.saveMapping$default(module, indexKey6, factoryInstanceFactory3, false, 4, (Object) null);
        new Pair(module2, factoryInstanceFactory3);
        AnonymousClass7 r253 = AnonymousClass7.INSTANCE;
        StringQualifier rootScopeQualifier4 = companion.getRootScopeQualifier();
        StringQualifier stringQualifier4 = rootScopeQualifier4;
        BeanDefinition beanDefinition7 = new BeanDefinition(stringQualifier4, Reflection.getOrCreateKotlinClass(LocationEventsFactory.class), (Qualifier) null, r253, kind3, CollectionsKt__CollectionsKt.emptyList());
        String indexKey7 = BeanDefinitionKt.indexKey(beanDefinition7.getPrimaryType(), (Qualifier) null, rootScopeQualifier4);
        FactoryInstanceFactory factoryInstanceFactory4 = new FactoryInstanceFactory(beanDefinition7);
        Module.saveMapping$default(module, indexKey7, factoryInstanceFactory4, false, 4, (Object) null);
        new Pair(module2, factoryInstanceFactory4);
        AnonymousClass8 r254 = AnonymousClass8.INSTANCE;
        StringQualifier rootScopeQualifier5 = companion.getRootScopeQualifier();
        StringQualifier stringQualifier5 = rootScopeQualifier5;
        BeanDefinition beanDefinition8 = new BeanDefinition(stringQualifier5, Reflection.getOrCreateKotlinClass(MessageEventsFactory.class), (Qualifier) null, r254, kind3, CollectionsKt__CollectionsKt.emptyList());
        String indexKey8 = BeanDefinitionKt.indexKey(beanDefinition8.getPrimaryType(), (Qualifier) null, rootScopeQualifier5);
        FactoryInstanceFactory factoryInstanceFactory5 = new FactoryInstanceFactory(beanDefinition8);
        Module.saveMapping$default(module, indexKey8, factoryInstanceFactory5, false, 4, (Object) null);
        new Pair(module2, factoryInstanceFactory5);
        AnonymousClass9 r255 = AnonymousClass9.INSTANCE;
        StringQualifier rootScopeQualifier6 = companion.getRootScopeQualifier();
        StringQualifier stringQualifier6 = rootScopeQualifier6;
        BeanDefinition beanDefinition9 = new BeanDefinition(stringQualifier6, Reflection.getOrCreateKotlinClass(CallEventsFactory.class), (Qualifier) null, r255, kind3, CollectionsKt__CollectionsKt.emptyList());
        String indexKey9 = BeanDefinitionKt.indexKey(beanDefinition9.getPrimaryType(), (Qualifier) null, rootScopeQualifier6);
        FactoryInstanceFactory factoryInstanceFactory6 = new FactoryInstanceFactory(beanDefinition9);
        Module.saveMapping$default(module, indexKey9, factoryInstanceFactory6, false, 4, (Object) null);
        new Pair(module2, factoryInstanceFactory6);
        AnonymousClass10 r256 = AnonymousClass10.INSTANCE;
        StringQualifier rootScopeQualifier7 = companion.getRootScopeQualifier();
        StringQualifier stringQualifier7 = rootScopeQualifier7;
        BeanDefinition beanDefinition10 = new BeanDefinition(stringQualifier7, Reflection.getOrCreateKotlinClass(ChatEventsTracker.class), (Qualifier) null, r256, kind3, CollectionsKt__CollectionsKt.emptyList());
        String indexKey10 = BeanDefinitionKt.indexKey(beanDefinition10.getPrimaryType(), (Qualifier) null, rootScopeQualifier7);
        FactoryInstanceFactory factoryInstanceFactory7 = new FactoryInstanceFactory(beanDefinition10);
        Module.saveMapping$default(module, indexKey10, factoryInstanceFactory7, false, 4, (Object) null);
        new Pair(module2, factoryInstanceFactory7);
        AnonymousClass11 r257 = AnonymousClass11.INSTANCE;
        StringQualifier rootScopeQualifier8 = companion.getRootScopeQualifier();
        StringQualifier stringQualifier8 = rootScopeQualifier8;
        BeanDefinition beanDefinition11 = new BeanDefinition(stringQualifier8, Reflection.getOrCreateKotlinClass(ImageEventsTracker.class), (Qualifier) null, r257, kind3, CollectionsKt__CollectionsKt.emptyList());
        String indexKey11 = BeanDefinitionKt.indexKey(beanDefinition11.getPrimaryType(), (Qualifier) null, rootScopeQualifier8);
        FactoryInstanceFactory factoryInstanceFactory8 = new FactoryInstanceFactory(beanDefinition11);
        Module.saveMapping$default(module, indexKey11, factoryInstanceFactory8, false, 4, (Object) null);
        new Pair(module2, factoryInstanceFactory8);
        AnonymousClass12 r258 = AnonymousClass12.INSTANCE;
        StringQualifier rootScopeQualifier9 = companion.getRootScopeQualifier();
        StringQualifier stringQualifier9 = rootScopeQualifier9;
        BeanDefinition beanDefinition12 = new BeanDefinition(stringQualifier9, Reflection.getOrCreateKotlinClass(LocationEventsTracker.class), (Qualifier) null, r258, kind3, CollectionsKt__CollectionsKt.emptyList());
        String indexKey12 = BeanDefinitionKt.indexKey(beanDefinition12.getPrimaryType(), (Qualifier) null, rootScopeQualifier9);
        FactoryInstanceFactory factoryInstanceFactory9 = new FactoryInstanceFactory(beanDefinition12);
        Module.saveMapping$default(module, indexKey12, factoryInstanceFactory9, false, 4, (Object) null);
        new Pair(module2, factoryInstanceFactory9);
        AnonymousClass13 r259 = AnonymousClass13.INSTANCE;
        StringQualifier rootScopeQualifier10 = companion.getRootScopeQualifier();
        StringQualifier stringQualifier10 = rootScopeQualifier10;
        BeanDefinition beanDefinition13 = new BeanDefinition(stringQualifier10, Reflection.getOrCreateKotlinClass(MessageEventsTracker.class), (Qualifier) null, r259, kind3, CollectionsKt__CollectionsKt.emptyList());
        String indexKey13 = BeanDefinitionKt.indexKey(beanDefinition13.getPrimaryType(), (Qualifier) null, rootScopeQualifier10);
        FactoryInstanceFactory factoryInstanceFactory10 = new FactoryInstanceFactory(beanDefinition13);
        Module.saveMapping$default(module, indexKey13, factoryInstanceFactory10, false, 4, (Object) null);
        new Pair(module2, factoryInstanceFactory10);
        AnonymousClass14 r2510 = AnonymousClass14.INSTANCE;
        StringQualifier rootScopeQualifier11 = companion.getRootScopeQualifier();
        StringQualifier stringQualifier11 = rootScopeQualifier11;
        BeanDefinition beanDefinition14 = new BeanDefinition(stringQualifier11, Reflection.getOrCreateKotlinClass(CallEventsTracker.class), (Qualifier) null, r2510, kind3, CollectionsKt__CollectionsKt.emptyList());
        String indexKey14 = BeanDefinitionKt.indexKey(beanDefinition14.getPrimaryType(), (Qualifier) null, rootScopeQualifier11);
        FactoryInstanceFactory factoryInstanceFactory11 = new FactoryInstanceFactory(beanDefinition14);
        Module.saveMapping$default(module, indexKey14, factoryInstanceFactory11, false, 4, (Object) null);
        new Pair(module2, factoryInstanceFactory11);
        AnonymousClass15 r2511 = AnonymousClass15.INSTANCE;
        StringQualifier rootScopeQualifier12 = companion.getRootScopeQualifier();
        StringQualifier stringQualifier12 = rootScopeQualifier12;
        BeanDefinition beanDefinition15 = new BeanDefinition(stringQualifier12, Reflection.getOrCreateKotlinClass(AnalyticsWrapper.class), (Qualifier) null, r2511, kind3, CollectionsKt__CollectionsKt.emptyList());
        String indexKey15 = BeanDefinitionKt.indexKey(beanDefinition15.getPrimaryType(), (Qualifier) null, rootScopeQualifier12);
        FactoryInstanceFactory factoryInstanceFactory12 = new FactoryInstanceFactory(beanDefinition15);
        Module.saveMapping$default(module, indexKey15, factoryInstanceFactory12, false, 4, (Object) null);
        new Pair(module2, factoryInstanceFactory12);
        AnonymousClass16 r163 = AnonymousClass16.INSTANCE;
        BeanDefinition beanDefinition16 = new BeanDefinition(companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(TrackPushNotificationRepository.class), (Qualifier) null, r163, kind, CollectionsKt__CollectionsKt.emptyList());
        String indexKey16 = BeanDefinitionKt.indexKey(beanDefinition16.getPrimaryType(), (Qualifier) null, companion.getRootScopeQualifier());
        SingleInstanceFactory singleInstanceFactory4 = new SingleInstanceFactory(beanDefinition16);
        Module.saveMapping$default(module, indexKey16, singleInstanceFactory4, false, 4, (Object) null);
        if (module.getCreatedAtStart()) {
            module.getEagerInstances().add(singleInstanceFactory4);
        }
        new Pair(module2, singleInstanceFactory4);
        AnonymousClass17 r2512 = AnonymousClass17.INSTANCE;
        StringQualifier rootScopeQualifier13 = companion.getRootScopeQualifier();
        StringQualifier stringQualifier13 = rootScopeQualifier13;
        BeanDefinition beanDefinition17 = new BeanDefinition(stringQualifier13, Reflection.getOrCreateKotlinClass(TrackPushNotificationService.class), (Qualifier) null, r2512, kind2, CollectionsKt__CollectionsKt.emptyList());
        String indexKey17 = BeanDefinitionKt.indexKey(beanDefinition17.getPrimaryType(), (Qualifier) null, rootScopeQualifier13);
        FactoryInstanceFactory factoryInstanceFactory13 = new FactoryInstanceFactory(beanDefinition17);
        Module.saveMapping$default(module, indexKey17, factoryInstanceFactory13, false, 4, (Object) null);
        new Pair(module2, factoryInstanceFactory13);
    }
}
