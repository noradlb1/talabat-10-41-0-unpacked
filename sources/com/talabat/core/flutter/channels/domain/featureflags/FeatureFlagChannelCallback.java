package com.talabat.core.flutter.channels.domain.featureflags;

import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0000\bf\u0018\u00002\u00020\u0001J)\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0002\u0010\bJ0\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000bH&¨\u0006\f"}, d2 = {"Lcom/talabat/core/flutter/channels/domain/featureflags/FeatureFlagChannelCallback;", "", "getFeatureFlag", "", "featureName", "", "projectName", "defaultValue", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Z", "getRemoteConfig", "remoteConfigName", "", "com_talabat_core_flutter-channels_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface FeatureFlagChannelCallback {
    boolean getFeatureFlag(@NotNull String str, @Nullable String str2, @Nullable Boolean bool);

    @NotNull
    Object getRemoteConfig(@NotNull String str, @Nullable String str2, @Nullable Map<String, ? extends Object> map);
}
