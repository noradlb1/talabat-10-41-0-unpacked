package com.talabat.core.flutter.binding.data;

import com.talabat.core.flutter.binding.domain.EngineBinding;
import com.talabat.core.flutter.channels.domain.PlatformChannel;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.BinaryMessenger;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016R\"\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00078\u0004X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/talabat/core/flutter/binding/data/DeeplinkFlutterEngineBinding;", "Lcom/talabat/core/flutter/binding/domain/EngineBinding;", "Lio/flutter/embedding/engine/FlutterEngine;", "flutterEngine", "", "init", "destroy", "", "Lcom/talabat/core/flutter/channels/domain/PlatformChannel;", "flutterChannels", "Ljava/util/List;", "a", "()Ljava/util/List;", "<init>", "(Ljava/util/List;)V", "com_talabat_core_flutter-binding_data_data"}, k = 1, mv = {1, 6, 0})
public abstract class DeeplinkFlutterEngineBinding implements EngineBinding {
    @NotNull
    private final List<PlatformChannel> flutterChannels;

    public DeeplinkFlutterEngineBinding(@NotNull List<? extends PlatformChannel> list) {
        Intrinsics.checkNotNullParameter(list, "flutterChannels");
        this.flutterChannels = list;
    }

    @NotNull
    public final List<PlatformChannel> a() {
        return this.flutterChannels;
    }

    public void destroy() {
        for (PlatformChannel platformChannel : this.flutterChannels) {
            if (platformChannel != null) {
                platformChannel.onDetach();
            }
        }
    }

    public void init(@NotNull FlutterEngine flutterEngine) {
        Intrinsics.checkNotNullParameter(flutterEngine, "flutterEngine");
        for (PlatformChannel platformChannel : this.flutterChannels) {
            if (platformChannel != null) {
                BinaryMessenger binaryMessenger = flutterEngine.getDartExecutor().getBinaryMessenger();
                Intrinsics.checkNotNullExpressionValue(binaryMessenger, "flutterEngine.dartExecutor.binaryMessenger");
                platformChannel.onAttach(binaryMessenger);
            }
        }
    }
}
