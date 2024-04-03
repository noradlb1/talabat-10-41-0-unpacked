package com.talabat.core.flutter.channels.impl.data.home;

import android.app.Activity;
import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import com.talabat.core.flutter.channels.domain.home.HomeChannelCallback;
import com.talabat.core.flutter.channels.domain.home.HomeChannelCallbackHandler;
import com.talabat.core.flutter.channels.domain.home.HomeChannelFlutterDomain;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0016\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0016J\b\u0010\u0010\u001a\u00020\bH\u0016J$\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\b2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J,\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\f2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J\"\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u001a\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010 \u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\"\u0010!\u001a\u00020\u00062\u0018\u0010\"\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000f0\u000e0\nH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/talabat/core/flutter/channels/impl/data/home/HomeChannelCallbackImpl;", "Lcom/talabat/core/flutter/channels/domain/home/HomeChannelCallback;", "()V", "homeChannelCallbackHandler", "Lcom/talabat/core/flutter/channels/domain/home/HomeChannelCallbackHandler;", "cacheEvent", "", "cacheKey", "", "resetWhen", "", "checkCacheEvent", "", "getAreaInfo", "", "", "getSelectedCountryCode", "handleClick", "action", "metadata", "handleUpdateNavBar", "shouldShowToolBar", "shouldShowWhiteToolBar", "configurations", "onAttached", "activity", "Landroid/app/Activity;", "homeChannelFlutterDomain", "Lcom/talabat/core/flutter/channels/domain/home/HomeChannelFlutterDomain;", "arguments", "Landroid/os/Bundle;", "onDetached", "resetCacheEvent", "updateVerticals", "verticals", "com_talabat_core_flutter-channels-impl_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HomeChannelCallbackImpl implements HomeChannelCallback {
    @Nullable
    private HomeChannelCallbackHandler homeChannelCallbackHandler;

    public void cacheEvent(@NotNull String str, @NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(str, "cacheKey");
        Intrinsics.checkNotNullParameter(list, "resetWhen");
        HomeChannelCallbackHandler homeChannelCallbackHandler2 = this.homeChannelCallbackHandler;
        if (homeChannelCallbackHandler2 != null) {
            homeChannelCallbackHandler2.cacheEvent(str, list);
        }
    }

    public boolean checkCacheEvent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "cacheKey");
        HomeChannelCallbackHandler homeChannelCallbackHandler2 = this.homeChannelCallbackHandler;
        if (homeChannelCallbackHandler2 != null) {
            return homeChannelCallbackHandler2.checkCacheEvent(str);
        }
        return false;
    }

    @Nullable
    public Map<String, Object> getAreaInfo() {
        HomeChannelCallbackHandler homeChannelCallbackHandler2 = this.homeChannelCallbackHandler;
        if (homeChannelCallbackHandler2 != null) {
            return homeChannelCallbackHandler2.getAreaInfo();
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.getSelectedCountryCode();
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getSelectedCountryCode() {
        /*
            r1 = this;
            com.talabat.core.flutter.channels.domain.home.HomeChannelCallbackHandler r0 = r1.homeChannelCallbackHandler
            if (r0 == 0) goto L_0x000a
            java.lang.String r0 = r0.getSelectedCountryCode()
            if (r0 != 0) goto L_0x000c
        L_0x000a:
            java.lang.String r0 = ""
        L_0x000c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.core.flutter.channels.impl.data.home.HomeChannelCallbackImpl.getSelectedCountryCode():java.lang.String");
    }

    public void handleClick(@NotNull String str, @NotNull Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, NativeProtocol.WEB_DIALOG_ACTION);
        Intrinsics.checkNotNullParameter(map, TtmlNode.TAG_METADATA);
        HomeChannelCallbackHandler homeChannelCallbackHandler2 = this.homeChannelCallbackHandler;
        if (homeChannelCallbackHandler2 != null) {
            homeChannelCallbackHandler2.handleClickFromFlutter(str, map);
        }
    }

    public void handleUpdateNavBar(boolean z11, boolean z12, @NotNull Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "configurations");
        HomeChannelCallbackHandler homeChannelCallbackHandler2 = this.homeChannelCallbackHandler;
        if (homeChannelCallbackHandler2 != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt__MapsJVMKt.mapCapacity(map.size()));
            for (Map.Entry entry : map.entrySet()) {
                linkedHashMap.put(entry.getKey(), entry.getValue().toString());
            }
            homeChannelCallbackHandler2.handleUpdateNavBar(z11, z12, linkedHashMap);
        }
    }

    public void onAttached(@NotNull Activity activity, @NotNull HomeChannelFlutterDomain homeChannelFlutterDomain, @Nullable Bundle bundle) {
        HomeChannelCallbackHandler homeChannelCallbackHandler2;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(homeChannelFlutterDomain, "homeChannelFlutterDomain");
        if (activity instanceof HomeChannelCallbackHandler) {
            homeChannelCallbackHandler2 = (HomeChannelCallbackHandler) activity;
        } else {
            homeChannelCallbackHandler2 = null;
        }
        this.homeChannelCallbackHandler = homeChannelCallbackHandler2;
        if (homeChannelCallbackHandler2 != null) {
            homeChannelCallbackHandler2.onHomeFlutterAttached(homeChannelFlutterDomain, bundle);
        }
    }

    public void onDetached(@NotNull HomeChannelFlutterDomain homeChannelFlutterDomain, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(homeChannelFlutterDomain, "homeChannelFlutterDomain");
        HomeChannelCallbackHandler homeChannelCallbackHandler2 = this.homeChannelCallbackHandler;
        if (homeChannelCallbackHandler2 != null) {
            homeChannelCallbackHandler2.onHomeFlutterDetached(homeChannelFlutterDomain, bundle);
        }
        this.homeChannelCallbackHandler = null;
    }

    public void resetCacheEvent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "resetWhen");
        HomeChannelCallbackHandler homeChannelCallbackHandler2 = this.homeChannelCallbackHandler;
        if (homeChannelCallbackHandler2 != null) {
            homeChannelCallbackHandler2.resetCacheEvent(str);
        }
    }

    public void updateVerticals(@NotNull List<? extends Map<String, ? extends Object>> list) {
        Intrinsics.checkNotNullParameter(list, "verticals");
        HomeChannelCallbackHandler homeChannelCallbackHandler2 = this.homeChannelCallbackHandler;
        if (homeChannelCallbackHandler2 != null) {
            homeChannelCallbackHandler2.updateVerticals(list);
        }
    }
}
