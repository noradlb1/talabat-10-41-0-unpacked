package com.baseflow.permissionhandler;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;

public final class PermissionHandlerPlugin implements FlutterPlugin, ActivityAware {
    @Nullable
    private MethodCallHandlerImpl methodCallHandler;
    private MethodChannel methodChannel;
    private final PermissionManager permissionManager = new PermissionManager();
    @Nullable
    private ActivityPluginBinding pluginBinding;
    @Nullable
    private PluginRegistry.Registrar pluginRegistrar;

    private void deregisterListeners() {
        ActivityPluginBinding activityPluginBinding = this.pluginBinding;
        if (activityPluginBinding != null) {
            activityPluginBinding.removeActivityResultListener(this.permissionManager);
            this.pluginBinding.removeRequestPermissionsResultListener(this.permissionManager);
        }
    }

    private void registerListeners() {
        PluginRegistry.Registrar registrar = this.pluginRegistrar;
        if (registrar != null) {
            registrar.addActivityResultListener(this.permissionManager);
            this.pluginRegistrar.addRequestPermissionsResultListener(this.permissionManager);
            return;
        }
        ActivityPluginBinding activityPluginBinding = this.pluginBinding;
        if (activityPluginBinding != null) {
            activityPluginBinding.addActivityResultListener(this.permissionManager);
            this.pluginBinding.addRequestPermissionsResultListener(this.permissionManager);
        }
    }

    public static void registerWith(PluginRegistry.Registrar registrar) {
        PermissionHandlerPlugin permissionHandlerPlugin = new PermissionHandlerPlugin();
        permissionHandlerPlugin.pluginRegistrar = registrar;
        permissionHandlerPlugin.registerListeners();
        permissionHandlerPlugin.startListening(registrar.context(), registrar.messenger());
        if (registrar.activeContext() instanceof Activity) {
            permissionHandlerPlugin.startListeningToActivity(registrar.activity());
        }
    }

    private void startListening(Context context, BinaryMessenger binaryMessenger) {
        this.methodChannel = new MethodChannel(binaryMessenger, "flutter.baseflow.com/permissions/methods");
        MethodCallHandlerImpl methodCallHandlerImpl = new MethodCallHandlerImpl(context, new AppSettingsManager(), this.permissionManager, new ServiceManager());
        this.methodCallHandler = methodCallHandlerImpl;
        this.methodChannel.setMethodCallHandler(methodCallHandlerImpl);
    }

    private void startListeningToActivity(Activity activity) {
        MethodCallHandlerImpl methodCallHandlerImpl = this.methodCallHandler;
        if (methodCallHandlerImpl != null) {
            methodCallHandlerImpl.setActivity(activity);
        }
    }

    private void stopListening() {
        this.methodChannel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        this.methodChannel = null;
        this.methodCallHandler = null;
    }

    private void stopListeningToActivity() {
        MethodCallHandlerImpl methodCallHandlerImpl = this.methodCallHandler;
        if (methodCallHandlerImpl != null) {
            methodCallHandlerImpl.setActivity((Activity) null);
        }
    }

    public void onAttachedToActivity(@NonNull ActivityPluginBinding activityPluginBinding) {
        startListeningToActivity(activityPluginBinding.getActivity());
        this.pluginBinding = activityPluginBinding;
        registerListeners();
    }

    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        startListening(flutterPluginBinding.getApplicationContext(), flutterPluginBinding.getBinaryMessenger());
    }

    public void onDetachedFromActivity() {
        stopListeningToActivity();
        deregisterListeners();
    }

    public void onDetachedFromActivityForConfigChanges() {
        onDetachedFromActivity();
    }

    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        stopListening();
    }

    public void onReattachedToActivityForConfigChanges(@NonNull ActivityPluginBinding activityPluginBinding) {
        onAttachedToActivity(activityPluginBinding);
    }
}
