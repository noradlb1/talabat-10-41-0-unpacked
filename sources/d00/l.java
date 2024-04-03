package d00;

import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugins.videoplayer.VideoPlayerPlugin;
import io.flutter.view.FlutterNativeView;

public final /* synthetic */ class l implements PluginRegistry.ViewDestroyListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VideoPlayerPlugin f13826b;

    public /* synthetic */ l(VideoPlayerPlugin videoPlayerPlugin) {
        this.f13826b = videoPlayerPlugin;
    }

    public final boolean onViewDestroy(FlutterNativeView flutterNativeView) {
        return this.f13826b.onDestroy();
    }
}
