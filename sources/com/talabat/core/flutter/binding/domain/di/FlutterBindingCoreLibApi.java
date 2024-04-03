package com.talabat.core.flutter.binding.domain.di;

import com.talabat.core.di.Api;
import com.talabat.core.flutter.binding.domain.DeeplinkEngineBindingRegistry;
import com.talabat.core.flutter.binding.domain.EngineBinding;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/talabat/core/flutter/binding/domain/di/FlutterBindingCoreLibApi;", "Lcom/talabat/core/di/Api;", "deeplinkEngineBindingRegistry", "Lcom/talabat/core/flutter/binding/domain/DeeplinkEngineBindingRegistry;", "getDeeplinkEngineBindingRegistry", "()Lcom/talabat/core/flutter/binding/domain/DeeplinkEngineBindingRegistry;", "registeredFlutterBindingModules", "", "Lcom/talabat/core/flutter/binding/domain/EngineBinding;", "getRegisteredFlutterBindingModules", "()Ljava/util/Set;", "com_talabat_core_flutter-binding_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface FlutterBindingCoreLibApi extends Api {
    @NotNull
    DeeplinkEngineBindingRegistry getDeeplinkEngineBindingRegistry();

    @NotNull
    Set<EngineBinding> getRegisteredFlutterBindingModules();
}
