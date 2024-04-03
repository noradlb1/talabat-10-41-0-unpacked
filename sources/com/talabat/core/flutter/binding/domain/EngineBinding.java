package com.talabat.core.flutter.binding.domain;

import io.flutter.embedding.engine.FlutterEngine;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/talabat/core/flutter/binding/domain/EngineBinding;", "", "destroy", "", "init", "flutterEngine", "Lio/flutter/embedding/engine/FlutterEngine;", "com_talabat_core_flutter-binding_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface EngineBinding {
    void destroy();

    void init(@NotNull FlutterEngine flutterEngine);
}
