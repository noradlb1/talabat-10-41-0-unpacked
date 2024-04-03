package com.deliveryhero.customerchat.di;

import com.deliveryhero.chatui.data.CameraImageRepository;
import com.deliveryhero.chatui.data.datasource.ImageFileProvider;
import com.deliveryhero.chatui.data.datasource.MediaStoreProvider;
import com.deliveryhero.chatui.domain.UploadImageUseCase;
import com.deliveryhero.chatui.domain.imageselection.ImageSelectionUseCases;
import com.deliveryhero.chatui.domain.imageselection.usecase.CacheGalleryImageUseCase;
import com.deliveryhero.chatui.domain.imageselection.usecase.GetCameraImageUriUseCase;
import com.deliveryhero.chatui.domain.imageselection.usecase.GetImagePathUseCase;
import com.deliveryhero.chatui.domain.imageselection.usecase.ImageSizeUseCase;
import com.deliveryhero.chatui.view.chatroom.navigator.ImageSelectionNavigator;
import com.deliveryhero.chatui.view.chatroom.navigator.MapNavigator;
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
public final class ModuleProviderKt$imageModule$1 extends Lambda implements Function1<Module, Unit> {
    public static final ModuleProviderKt$imageModule$1 INSTANCE = new ModuleProviderKt$imageModule$1();

    public ModuleProviderKt$imageModule$1() {
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
        BeanDefinition beanDefinition = new BeanDefinition(companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(MediaStoreProvider.class), (Qualifier) null, r11, kind, CollectionsKt__CollectionsKt.emptyList());
        String indexKey = BeanDefinitionKt.indexKey(beanDefinition.getPrimaryType(), (Qualifier) null, companion.getRootScopeQualifier());
        SingleInstanceFactory singleInstanceFactory = new SingleInstanceFactory(beanDefinition);
        Module.saveMapping$default(module, indexKey, singleInstanceFactory, false, 4, (Object) null);
        if (module.getCreatedAtStart()) {
            module.getEagerInstances().add(singleInstanceFactory);
        }
        new Pair(module2, singleInstanceFactory);
        AnonymousClass2 r16 = AnonymousClass2.INSTANCE;
        BeanDefinition beanDefinition2 = new BeanDefinition(companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ImageFileProvider.class), (Qualifier) null, r16, kind, CollectionsKt__CollectionsKt.emptyList());
        String indexKey2 = BeanDefinitionKt.indexKey(beanDefinition2.getPrimaryType(), (Qualifier) null, companion.getRootScopeQualifier());
        SingleInstanceFactory singleInstanceFactory2 = new SingleInstanceFactory(beanDefinition2);
        Module.saveMapping$default(module, indexKey2, singleInstanceFactory2, false, 4, (Object) null);
        if (module.getCreatedAtStart()) {
            module.getEagerInstances().add(singleInstanceFactory2);
        }
        new Pair(module2, singleInstanceFactory2);
        AnonymousClass3 r162 = AnonymousClass3.INSTANCE;
        BeanDefinition beanDefinition3 = new BeanDefinition(companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(CameraImageRepository.class), (Qualifier) null, r162, kind, CollectionsKt__CollectionsKt.emptyList());
        String indexKey3 = BeanDefinitionKt.indexKey(beanDefinition3.getPrimaryType(), (Qualifier) null, companion.getRootScopeQualifier());
        SingleInstanceFactory singleInstanceFactory3 = new SingleInstanceFactory(beanDefinition3);
        Module.saveMapping$default(module, indexKey3, singleInstanceFactory3, false, 4, (Object) null);
        if (module.getCreatedAtStart()) {
            module.getEagerInstances().add(singleInstanceFactory3);
        }
        new Pair(module2, singleInstanceFactory3);
        AnonymousClass4 r163 = AnonymousClass4.INSTANCE;
        BeanDefinition beanDefinition4 = new BeanDefinition(companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(GetCameraImageUriUseCase.class), (Qualifier) null, r163, kind, CollectionsKt__CollectionsKt.emptyList());
        String indexKey4 = BeanDefinitionKt.indexKey(beanDefinition4.getPrimaryType(), (Qualifier) null, companion.getRootScopeQualifier());
        SingleInstanceFactory singleInstanceFactory4 = new SingleInstanceFactory(beanDefinition4);
        Module.saveMapping$default(module, indexKey4, singleInstanceFactory4, false, 4, (Object) null);
        if (module.getCreatedAtStart()) {
            module.getEagerInstances().add(singleInstanceFactory4);
        }
        new Pair(module2, singleInstanceFactory4);
        AnonymousClass5 r164 = AnonymousClass5.INSTANCE;
        BeanDefinition beanDefinition5 = new BeanDefinition(companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(CacheGalleryImageUseCase.class), (Qualifier) null, r164, kind, CollectionsKt__CollectionsKt.emptyList());
        String indexKey5 = BeanDefinitionKt.indexKey(beanDefinition5.getPrimaryType(), (Qualifier) null, companion.getRootScopeQualifier());
        SingleInstanceFactory singleInstanceFactory5 = new SingleInstanceFactory(beanDefinition5);
        Module.saveMapping$default(module, indexKey5, singleInstanceFactory5, false, 4, (Object) null);
        if (module.getCreatedAtStart()) {
            module.getEagerInstances().add(singleInstanceFactory5);
        }
        new Pair(module2, singleInstanceFactory5);
        AnonymousClass6 r165 = AnonymousClass6.INSTANCE;
        BeanDefinition beanDefinition6 = new BeanDefinition(companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(GetImagePathUseCase.class), (Qualifier) null, r165, kind, CollectionsKt__CollectionsKt.emptyList());
        String indexKey6 = BeanDefinitionKt.indexKey(beanDefinition6.getPrimaryType(), (Qualifier) null, companion.getRootScopeQualifier());
        SingleInstanceFactory singleInstanceFactory6 = new SingleInstanceFactory(beanDefinition6);
        Module.saveMapping$default(module, indexKey6, singleInstanceFactory6, false, 4, (Object) null);
        if (module.getCreatedAtStart()) {
            module.getEagerInstances().add(singleInstanceFactory6);
        }
        new Pair(module2, singleInstanceFactory6);
        AnonymousClass7 r13 = AnonymousClass7.INSTANCE;
        StringQualifier rootScopeQualifier = companion.getRootScopeQualifier();
        Kind kind2 = Kind.Factory;
        StringQualifier stringQualifier = rootScopeQualifier;
        BeanDefinition beanDefinition7 = new BeanDefinition(stringQualifier, Reflection.getOrCreateKotlinClass(ImageSizeUseCase.class), (Qualifier) null, r13, kind2, CollectionsKt__CollectionsKt.emptyList());
        String indexKey7 = BeanDefinitionKt.indexKey(beanDefinition7.getPrimaryType(), (Qualifier) null, rootScopeQualifier);
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(beanDefinition7);
        Module.saveMapping$default(module, indexKey7, factoryInstanceFactory, false, 4, (Object) null);
        new Pair(module2, factoryInstanceFactory);
        AnonymousClass8 r166 = AnonymousClass8.INSTANCE;
        BeanDefinition beanDefinition8 = new BeanDefinition(companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ImageSelectionUseCases.class), (Qualifier) null, r166, kind, CollectionsKt__CollectionsKt.emptyList());
        String indexKey8 = BeanDefinitionKt.indexKey(beanDefinition8.getPrimaryType(), (Qualifier) null, companion.getRootScopeQualifier());
        SingleInstanceFactory singleInstanceFactory7 = new SingleInstanceFactory(beanDefinition8);
        Module.saveMapping$default(module, indexKey8, singleInstanceFactory7, false, 4, (Object) null);
        if (module.getCreatedAtStart()) {
            module.getEagerInstances().add(singleInstanceFactory7);
        }
        new Pair(module2, singleInstanceFactory7);
        AnonymousClass9 r25 = AnonymousClass9.INSTANCE;
        StringQualifier rootScopeQualifier2 = companion.getRootScopeQualifier();
        StringQualifier stringQualifier2 = rootScopeQualifier2;
        Kind kind3 = kind2;
        BeanDefinition beanDefinition9 = new BeanDefinition(stringQualifier2, Reflection.getOrCreateKotlinClass(UploadImageUseCase.class), (Qualifier) null, r25, kind3, CollectionsKt__CollectionsKt.emptyList());
        String indexKey9 = BeanDefinitionKt.indexKey(beanDefinition9.getPrimaryType(), (Qualifier) null, rootScopeQualifier2);
        FactoryInstanceFactory factoryInstanceFactory2 = new FactoryInstanceFactory(beanDefinition9);
        Module.saveMapping$default(module, indexKey9, factoryInstanceFactory2, false, 4, (Object) null);
        new Pair(module2, factoryInstanceFactory2);
        AnonymousClass10 r252 = AnonymousClass10.INSTANCE;
        StringQualifier rootScopeQualifier3 = companion.getRootScopeQualifier();
        StringQualifier stringQualifier3 = rootScopeQualifier3;
        BeanDefinition beanDefinition10 = new BeanDefinition(stringQualifier3, Reflection.getOrCreateKotlinClass(ImageSelectionNavigator.class), (Qualifier) null, r252, kind3, CollectionsKt__CollectionsKt.emptyList());
        String indexKey10 = BeanDefinitionKt.indexKey(beanDefinition10.getPrimaryType(), (Qualifier) null, rootScopeQualifier3);
        FactoryInstanceFactory factoryInstanceFactory3 = new FactoryInstanceFactory(beanDefinition10);
        Module.saveMapping$default(module, indexKey10, factoryInstanceFactory3, false, 4, (Object) null);
        new Pair(module2, factoryInstanceFactory3);
        AnonymousClass11 r253 = AnonymousClass11.INSTANCE;
        StringQualifier rootScopeQualifier4 = companion.getRootScopeQualifier();
        StringQualifier stringQualifier4 = rootScopeQualifier4;
        BeanDefinition beanDefinition11 = new BeanDefinition(stringQualifier4, Reflection.getOrCreateKotlinClass(MapNavigator.class), (Qualifier) null, r253, kind3, CollectionsKt__CollectionsKt.emptyList());
        String indexKey11 = BeanDefinitionKt.indexKey(beanDefinition11.getPrimaryType(), (Qualifier) null, rootScopeQualifier4);
        FactoryInstanceFactory factoryInstanceFactory4 = new FactoryInstanceFactory(beanDefinition11);
        Module.saveMapping$default(module, indexKey11, factoryInstanceFactory4, false, 4, (Object) null);
        new Pair(module2, factoryInstanceFactory4);
    }
}
