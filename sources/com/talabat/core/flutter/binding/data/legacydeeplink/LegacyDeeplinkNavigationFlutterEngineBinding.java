package com.talabat.core.flutter.binding.data.legacydeeplink;

import android.app.Activity;
import android.os.Bundle;
import com.talabat.core.flutter.binding.data.DeeplinkFlutterEngineBinding;
import com.talabat.core.flutter.binding.domain.ActivityEngineBinding;
import com.talabat.core.flutter.binding.domain.legacydeeplink.ILegacyDeeplinkNavigationFlutterEngineBinding;
import com.talabat.core.flutter.channels.domain.PlatformChannel;
import com.talabat.core.flutter.channels.domain.legacydeeplink.LegacyDeeplinkNavigationFlutterDomain;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.BinaryMessenger;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0011\b\u0007\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\"\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016¨\u0006\u000f"}, d2 = {"Lcom/talabat/core/flutter/binding/data/legacydeeplink/LegacyDeeplinkNavigationFlutterEngineBinding;", "Lcom/talabat/core/flutter/binding/data/DeeplinkFlutterEngineBinding;", "Lcom/talabat/core/flutter/binding/domain/ActivityEngineBinding;", "Lcom/talabat/core/flutter/binding/domain/legacydeeplink/ILegacyDeeplinkNavigationFlutterEngineBinding;", "legacyDeeplinkNavigationFlutterDomain", "Lcom/talabat/core/flutter/channels/domain/legacydeeplink/LegacyDeeplinkNavigationFlutterDomain;", "(Lcom/talabat/core/flutter/channels/domain/legacydeeplink/LegacyDeeplinkNavigationFlutterDomain;)V", "init", "", "flutterEngine", "Lio/flutter/embedding/engine/FlutterEngine;", "activity", "Landroid/app/Activity;", "arguments", "Landroid/os/Bundle;", "com_talabat_core_flutter-binding_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LegacyDeeplinkNavigationFlutterEngineBinding extends DeeplinkFlutterEngineBinding implements ActivityEngineBinding, ILegacyDeeplinkNavigationFlutterEngineBinding {
    @Inject
    public LegacyDeeplinkNavigationFlutterEngineBinding(@Nullable LegacyDeeplinkNavigationFlutterDomain legacyDeeplinkNavigationFlutterDomain) {
        super(CollectionsKt__CollectionsJVMKt.listOf(legacyDeeplinkNavigationFlutterDomain));
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
}
