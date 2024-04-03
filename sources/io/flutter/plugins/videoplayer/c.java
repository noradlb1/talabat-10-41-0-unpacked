package io.flutter.plugins.videoplayer;

import io.flutter.embedding.engine.loader.FlutterLoader;
import io.flutter.plugins.videoplayer.VideoPlayerPlugin;

public final /* synthetic */ class c implements VideoPlayerPlugin.KeyForAssetAndPackageName {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FlutterLoader f14402a;

    public /* synthetic */ c(FlutterLoader flutterLoader) {
        this.f14402a = flutterLoader;
    }

    public final String get(String str, String str2) {
        return this.f14402a.getLookupKeyForAsset(str, str2);
    }
}
