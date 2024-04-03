package io.flutter.plugins.firebase.database;

import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.view.FlutterNativeView;

public class FirebaseDatabasePlugin implements FlutterPlugin {
    private MethodChannel channel;
    private MethodCallHandlerImpl methodCallHandler;

    /* access modifiers changed from: private */
    public void cleanup() {
        this.methodCallHandler.d();
        this.methodCallHandler = null;
        this.channel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
    }

    public static void registerWith(PluginRegistry.Registrar registrar) {
        FirebaseDatabasePlugin firebaseDatabasePlugin = new FirebaseDatabasePlugin();
        firebaseDatabasePlugin.setupMethodChannel(registrar.messenger());
        registrar.addViewDestroyListener(new PluginRegistry.ViewDestroyListener() {
            public boolean onViewDestroy(FlutterNativeView flutterNativeView) {
                FirebaseDatabasePlugin.this.cleanup();
                return false;
            }
        });
    }

    private void setupMethodChannel(BinaryMessenger binaryMessenger) {
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, "plugins.flutter.io/firebase_database");
        this.channel = methodChannel;
        MethodCallHandlerImpl methodCallHandlerImpl = new MethodCallHandlerImpl(methodChannel);
        this.methodCallHandler = methodCallHandlerImpl;
        this.channel.setMethodCallHandler(methodCallHandlerImpl);
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        setupMethodChannel(flutterPluginBinding.getBinaryMessenger());
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        cleanup();
    }
}
