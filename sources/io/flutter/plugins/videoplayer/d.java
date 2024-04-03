package io.flutter.plugins.videoplayer;

import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugins.videoplayer.VideoPlayerPlugin;

public final /* synthetic */ class d implements VideoPlayerPlugin.KeyForAssetFn {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PluginRegistry.Registrar f14403a;

    public /* synthetic */ d(PluginRegistry.Registrar registrar) {
        this.f14403a = registrar;
    }

    public final String get(String str) {
        return this.f14403a.lookupKeyForAsset(str);
    }
}
