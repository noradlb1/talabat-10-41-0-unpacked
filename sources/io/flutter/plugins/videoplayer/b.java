package io.flutter.plugins.videoplayer;

import io.flutter.embedding.engine.loader.FlutterLoader;
import io.flutter.plugins.videoplayer.VideoPlayerPlugin;

public final /* synthetic */ class b implements VideoPlayerPlugin.KeyForAssetFn {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FlutterLoader f14401a;

    public /* synthetic */ b(FlutterLoader flutterLoader) {
        this.f14401a = flutterLoader;
    }

    public final String get(String str) {
        return this.f14401a.getLookupKeyForAsset(str);
    }
}
