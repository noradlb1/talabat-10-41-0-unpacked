package io.flutter.plugins.webviewflutter;

import android.content.res.AssetManager;
import androidx.annotation.NonNull;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.PluginRegistry;
import java.io.IOException;

abstract class FlutterAssetManager {

    /* renamed from: a  reason: collision with root package name */
    public final AssetManager f14408a;

    public static class PluginBindingFlutterAssetManager extends FlutterAssetManager {

        /* renamed from: b  reason: collision with root package name */
        public final FlutterPlugin.FlutterAssets f14409b;

        public PluginBindingFlutterAssetManager(AssetManager assetManager, FlutterPlugin.FlutterAssets flutterAssets) {
            super(assetManager);
            this.f14409b = flutterAssets;
        }

        public String getAssetFilePathByName(String str) {
            return this.f14409b.getAssetFilePathByName(str);
        }
    }

    @Deprecated
    public static class RegistrarFlutterAssetManager extends FlutterAssetManager {

        /* renamed from: b  reason: collision with root package name */
        public final PluginRegistry.Registrar f14410b;

        public RegistrarFlutterAssetManager(AssetManager assetManager, PluginRegistry.Registrar registrar) {
            super(assetManager);
            this.f14410b = registrar;
        }

        public String getAssetFilePathByName(String str) {
            return this.f14410b.lookupKeyForAsset(str);
        }
    }

    public FlutterAssetManager(AssetManager assetManager) {
        this.f14408a = assetManager;
    }

    public abstract String getAssetFilePathByName(String str);

    public String[] list(@NonNull String str) throws IOException {
        return this.f14408a.list(str);
    }
}
