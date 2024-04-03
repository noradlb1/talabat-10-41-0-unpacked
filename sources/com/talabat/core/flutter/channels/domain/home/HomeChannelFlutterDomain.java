package com.talabat.core.flutter.channels.domain.home;

import android.app.Activity;
import android.os.Bundle;
import com.talabat.core.flutter.channels.domain.PlatformChannel;
import io.flutter.plugin.common.BinaryMessenger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/talabat/core/flutter/channels/domain/home/HomeChannelFlutterDomain;", "Lcom/talabat/core/flutter/channels/domain/PlatformChannel;", "refreshHome", "", "com_talabat_core_flutter-channels_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface HomeChannelFlutterDomain extends PlatformChannel {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void onAttachWithActivity(@NotNull HomeChannelFlutterDomain homeChannelFlutterDomain, @NotNull BinaryMessenger binaryMessenger, @NotNull Activity activity, @Nullable Bundle bundle) {
            Intrinsics.checkNotNullParameter(binaryMessenger, "binaryMessenger");
            Intrinsics.checkNotNullParameter(activity, "activity");
            PlatformChannel.DefaultImpls.onAttachWithActivity(homeChannelFlutterDomain, binaryMessenger, activity, bundle);
        }
    }

    void refreshHome();
}
