package com.talabat.core.flutter.binding.data.dynamictrackingcache;

import android.app.Activity;
import android.os.Bundle;
import com.talabat.core.flutter.binding.data.DeeplinkFlutterEngineBinding;
import com.talabat.core.flutter.binding.domain.dynamictrackingcache.IDynamicTrackingCacheFlutterEngineBinding;
import com.talabat.core.flutter.channels.domain.PlatformChannel;
import com.talabat.core.flutter.channels.domain.dynamictrackingcache.DynamicTrackingCacheFlutterDomain;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.BinaryMessenger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\"\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/talabat/core/flutter/binding/data/dynamictrackingcache/DynamicTrackingCacheFlutterEngineBinding;", "Lcom/talabat/core/flutter/binding/data/DeeplinkFlutterEngineBinding;", "Lcom/talabat/core/flutter/binding/domain/dynamictrackingcache/IDynamicTrackingCacheFlutterEngineBinding;", "dynamicTrackingCacheFlutterDomain", "Lcom/talabat/core/flutter/channels/domain/dynamictrackingcache/DynamicTrackingCacheFlutterDomain;", "(Lcom/talabat/core/flutter/channels/domain/dynamictrackingcache/DynamicTrackingCacheFlutterDomain;)V", "init", "", "flutterEngine", "Lio/flutter/embedding/engine/FlutterEngine;", "activity", "Landroid/app/Activity;", "arguments", "Landroid/os/Bundle;", "com_talabat_core_flutter-binding_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DynamicTrackingCacheFlutterEngineBinding extends DeeplinkFlutterEngineBinding implements IDynamicTrackingCacheFlutterEngineBinding {
    public DynamicTrackingCacheFlutterEngineBinding(@Nullable DynamicTrackingCacheFlutterDomain dynamicTrackingCacheFlutterDomain) {
        super(CollectionsKt__CollectionsJVMKt.listOf(dynamicTrackingCacheFlutterDomain));
    }

    public void init(@NotNull FlutterEngine flutterEngine, @NotNull Activity activity, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(flutterEngine, "flutterEngine");
        Intrinsics.checkNotNullParameter(activity, "activity");
        for (PlatformChannel platformChannel : super.a()) {
            if (platformChannel != null) {
                BinaryMessenger binaryMessenger = flutterEngine.getDartExecutor().getBinaryMessenger();
                Intrinsics.checkNotNullExpressionValue(binaryMessenger, "flutterEngine.dartExecutor.binaryMessenger");
                platformChannel.onAttachWithActivity(binaryMessenger, activity, bundle);
            }
        }
    }

    public void init(@NotNull FlutterEngine flutterEngine) {
        Intrinsics.checkNotNullParameter(flutterEngine, "flutterEngine");
        for (PlatformChannel platformChannel : super.a()) {
            if (platformChannel != null) {
                BinaryMessenger binaryMessenger = flutterEngine.getDartExecutor().getBinaryMessenger();
                Intrinsics.checkNotNullExpressionValue(binaryMessenger, "flutterEngine.dartExecutor.binaryMessenger");
                platformChannel.onAttach(binaryMessenger);
            }
        }
    }
}
