package com.deliveryhero.customerchat.di;

import com.deliveryhero.chatsdk.provider.Provider;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.koin.core.module.Module;
import org.koin.dsl.ModuleKt;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0005\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u000e\u0010\f\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"analyticsModule", "Lorg/koin/core/module/Module;", "baseTelephonyModule", "configurationModule", "dataStoreModule", "gccChatSdkModule", "helpersModule", "imageModule", "modules", "", "getModules", "()Ljava/util/List;", "serviceModule", "uiModule", "customerchat_basicRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ModuleProviderKt {
    @NotNull
    private static final Module analyticsModule;
    @NotNull
    private static final Module baseTelephonyModule;
    @NotNull
    private static final Module configurationModule;
    @NotNull
    private static final Module dataStoreModule;
    @NotNull
    private static final Module gccChatSdkModule;
    @NotNull
    private static final Module helpersModule;
    @NotNull
    private static final Module imageModule;
    @NotNull
    private static final List<Module> modules;
    @NotNull
    private static final Module serviceModule;
    @NotNull
    private static final Module uiModule;

    static {
        Module module$default = ModuleKt.module$default(false, ModuleProviderKt$imageModule$1.INSTANCE, 1, (Object) null);
        imageModule = module$default;
        Module module$default2 = ModuleKt.module$default(false, ModuleProviderKt$gccChatSdkModule$1.INSTANCE, 1, (Object) null);
        gccChatSdkModule = module$default2;
        Module module$default3 = ModuleKt.module$default(false, ModuleProviderKt$analyticsModule$1.INSTANCE, 1, (Object) null);
        analyticsModule = module$default3;
        Module module$default4 = ModuleKt.module$default(false, ModuleProviderKt$serviceModule$1.INSTANCE, 1, (Object) null);
        serviceModule = module$default4;
        Module module$default5 = ModuleKt.module$default(false, ModuleProviderKt$helpersModule$1.INSTANCE, 1, (Object) null);
        helpersModule = module$default5;
        Module module$default6 = ModuleKt.module$default(false, ModuleProviderKt$uiModule$1.INSTANCE, 1, (Object) null);
        uiModule = module$default6;
        Module module$default7 = ModuleKt.module$default(false, ModuleProviderKt$configurationModule$1.INSTANCE, 1, (Object) null);
        configurationModule = module$default7;
        Module module$default8 = ModuleKt.module$default(false, ModuleProviderKt$dataStoreModule$1.INSTANCE, 1, (Object) null);
        dataStoreModule = module$default8;
        Module module$default9 = ModuleKt.module$default(false, ModuleProviderKt$baseTelephonyModule$1.INSTANCE, 1, (Object) null);
        baseTelephonyModule = module$default9;
        modules = CollectionsKt__CollectionsKt.listOf(module$default2, module$default, module$default6, module$default4, module$default7, module$default5, module$default3, module$default4, module$default8, module$default9, com.deliveryhero.customerchat.telephonyImpl.di.ModuleKt.getTelephonyModule(), Provider.INSTANCE.getNetworkModule());
    }

    @NotNull
    public static final List<Module> getModules() {
        return modules;
    }
}
