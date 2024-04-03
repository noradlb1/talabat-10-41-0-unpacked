package com.talabat.core.flutter.channels.domain;

import android.app.Activity;
import android.os.Bundle;
import io.flutter.plugin.common.BinaryMessenger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J$\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000b\u001a\u00020\u0003H&¨\u0006\f"}, d2 = {"Lcom/talabat/core/flutter/channels/domain/PlatformChannel;", "", "onAttach", "", "binaryMessenger", "Lio/flutter/plugin/common/BinaryMessenger;", "onAttachWithActivity", "activity", "Landroid/app/Activity;", "arguments", "Landroid/os/Bundle;", "onDetach", "com_talabat_core_flutter-channels_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface PlatformChannel {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void onAttachWithActivity(@NotNull PlatformChannel platformChannel, @NotNull BinaryMessenger binaryMessenger, @NotNull Activity activity, @Nullable Bundle bundle) {
            Intrinsics.checkNotNullParameter(binaryMessenger, "binaryMessenger");
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        public static /* synthetic */ void onAttachWithActivity$default(PlatformChannel platformChannel, BinaryMessenger binaryMessenger, Activity activity, Bundle bundle, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 4) != 0) {
                    bundle = null;
                }
                platformChannel.onAttachWithActivity(binaryMessenger, activity, bundle);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onAttachWithActivity");
        }
    }

    void onAttach(@NotNull BinaryMessenger binaryMessenger);

    void onAttachWithActivity(@NotNull BinaryMessenger binaryMessenger, @NotNull Activity activity, @Nullable Bundle bundle);

    void onDetach();
}
