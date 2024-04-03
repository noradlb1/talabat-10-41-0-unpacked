package io.flutter.plugins.videoplayer;

import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugins.videoplayer.VideoPlayerPlugin;

public final /* synthetic */ class e implements VideoPlayerPlugin.KeyForAssetAndPackageName {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PluginRegistry.Registrar f14404a;

    public /* synthetic */ e(PluginRegistry.Registrar registrar) {
        this.f14404a = registrar;
    }

    public final String get(String str, String str2) {
        return this.f14404a.lookupKeyForAsset(str, str2);
    }
}
