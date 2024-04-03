package com.talabat.core.flutter.channels.domain.home;

import android.os.Bundle;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0016\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000bH&J\b\u0010\f\u001a\u00020\u0005H&J$\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00052\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u000bH&J,\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000bH&J\u001a\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H&J\u001a\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H&J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H&J\"\u0010\u001b\u001a\u00020\u00032\u0018\u0010\u001c\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u000b0\u0007H&¨\u0006\u001d"}, d2 = {"Lcom/talabat/core/flutter/channels/domain/home/HomeChannelCallbackHandler;", "", "cacheEvent", "", "cacheKey", "", "resetWhen", "", "checkCacheEvent", "", "getAreaInfo", "", "getSelectedCountryCode", "handleClickFromFlutter", "action", "metadata", "handleUpdateNavBar", "shouldShowToolBar", "shouldShowWhiteToolBar", "configurations", "onHomeFlutterAttached", "homeChannelFlutterDomain", "Lcom/talabat/core/flutter/channels/domain/home/HomeChannelFlutterDomain;", "arguments", "Landroid/os/Bundle;", "onHomeFlutterDetached", "resetCacheEvent", "updateVerticals", "verticals", "com_talabat_core_flutter-channels_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface HomeChannelCallbackHandler {
    void cacheEvent(@NotNull String str, @NotNull List<String> list);

    boolean checkCacheEvent(@NotNull String str);

    @Nullable
    Map<String, Object> getAreaInfo();

    @NotNull
    String getSelectedCountryCode();

    void handleClickFromFlutter(@NotNull String str, @NotNull Map<String, ? extends Object> map);

    void handleUpdateNavBar(boolean z11, boolean z12, @NotNull Map<String, String> map);

    void onHomeFlutterAttached(@NotNull HomeChannelFlutterDomain homeChannelFlutterDomain, @Nullable Bundle bundle);

    void onHomeFlutterDetached(@NotNull HomeChannelFlutterDomain homeChannelFlutterDomain, @Nullable Bundle bundle);

    void resetCacheEvent(@NotNull String str);

    void updateVerticals(@NotNull List<? extends Map<String, ? extends Object>> list);
}
