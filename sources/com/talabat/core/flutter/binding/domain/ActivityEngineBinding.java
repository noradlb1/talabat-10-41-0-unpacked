package com.talabat.core.flutter.binding.domain;

import android.app.Activity;
import android.os.Bundle;
import io.flutter.embedding.engine.FlutterEngine;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, d2 = {"Lcom/talabat/core/flutter/binding/domain/ActivityEngineBinding;", "Lcom/talabat/core/flutter/binding/domain/EngineBinding;", "init", "", "flutterEngine", "Lio/flutter/embedding/engine/FlutterEngine;", "activity", "Landroid/app/Activity;", "arguments", "Landroid/os/Bundle;", "com_talabat_core_flutter-binding_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ActivityEngineBinding extends EngineBinding {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void init(@NotNull ActivityEngineBinding activityEngineBinding, @NotNull FlutterEngine flutterEngine, @NotNull Activity activity, @Nullable Bundle bundle) {
            Intrinsics.checkNotNullParameter(flutterEngine, "flutterEngine");
            Intrinsics.checkNotNullParameter(activity, "activity");
        }
    }

    void init(@NotNull FlutterEngine flutterEngine, @NotNull Activity activity, @Nullable Bundle bundle);
}
