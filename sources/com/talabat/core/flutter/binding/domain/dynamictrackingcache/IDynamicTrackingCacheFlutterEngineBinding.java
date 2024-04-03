package com.talabat.core.flutter.binding.domain.dynamictrackingcache;

import android.app.Activity;
import android.os.Bundle;
import com.talabat.core.flutter.binding.domain.ActivityEngineBinding;
import io.flutter.embedding.engine.FlutterEngine;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/talabat/core/flutter/binding/domain/dynamictrackingcache/IDynamicTrackingCacheFlutterEngineBinding;", "Lcom/talabat/core/flutter/binding/domain/ActivityEngineBinding;", "com_talabat_core_flutter-binding_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IDynamicTrackingCacheFlutterEngineBinding extends ActivityEngineBinding {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void init(@NotNull IDynamicTrackingCacheFlutterEngineBinding iDynamicTrackingCacheFlutterEngineBinding, @NotNull FlutterEngine flutterEngine, @NotNull Activity activity, @Nullable Bundle bundle) {
            Intrinsics.checkNotNullParameter(flutterEngine, "flutterEngine");
            Intrinsics.checkNotNullParameter(activity, "activity");
            ActivityEngineBinding.DefaultImpls.init(iDynamicTrackingCacheFlutterEngineBinding, flutterEngine, activity, bundle);
        }
    }
}
