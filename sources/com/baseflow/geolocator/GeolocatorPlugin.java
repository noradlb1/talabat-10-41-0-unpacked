package com.baseflow.geolocator;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baseflow.geolocator.GeolocatorLocationService;
import com.baseflow.geolocator.location.GeolocationManager;
import com.baseflow.geolocator.location.LocationAccuracyManager;
import com.baseflow.geolocator.permission.PermissionManager;
import io.flutter.Log;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.PluginRegistry;

public class GeolocatorPlugin implements FlutterPlugin, ActivityAware {
    private static final String TAG = "FlutterGeolocator";
    /* access modifiers changed from: private */
    @Nullable
    public GeolocatorLocationService foregroundLocationService;
    private final GeolocationManager geolocationManager = new GeolocationManager();
    private final LocationAccuracyManager locationAccuracyManager = new LocationAccuracyManager();
    @Nullable
    private LocationServiceHandlerImpl locationServiceHandler;
    @Nullable
    private MethodCallHandlerImpl methodCallHandler;
    private final PermissionManager permissionManager = new PermissionManager();
    @Nullable
    private ActivityPluginBinding pluginBinding;
    @Nullable
    private PluginRegistry.Registrar pluginRegistrar;
    private final ServiceConnection serviceConnection = new ServiceConnection() {
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.d(GeolocatorPlugin.TAG, "Geolocator foreground service connected");
            if (iBinder instanceof GeolocatorLocationService.LocalBinder) {
                GeolocatorPlugin.this.initialize(((GeolocatorLocationService.LocalBinder) iBinder).getLocationService());
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            Log.d(GeolocatorPlugin.TAG, "Geolocator foreground service disconnected");
            if (GeolocatorPlugin.this.foregroundLocationService != null) {
                GeolocatorPlugin.this.foregroundLocationService.setActivity((Activity) null);
                GeolocatorLocationService unused = GeolocatorPlugin.this.foregroundLocationService = null;
            }
        }
    };
    @Nullable
    private StreamHandlerImpl streamHandler;

    private void bindForegroundService(Context context) {
        context.bindService(new Intent(context, GeolocatorLocationService.class), this.serviceConnection, 1);
    }

    private void deregisterListeners() {
        ActivityPluginBinding activityPluginBinding = this.pluginBinding;
        if (activityPluginBinding != null) {
            activityPluginBinding.removeActivityResultListener(this.geolocationManager);
            this.pluginBinding.removeRequestPermissionsResultListener(this.permissionManager);
        }
    }

    private void dispose() {
        Log.d(TAG, "Disposing Geolocator services");
        MethodCallHandlerImpl methodCallHandlerImpl = this.methodCallHandler;
        if (methodCallHandlerImpl != null) {
            methodCallHandlerImpl.j();
            this.methodCallHandler.h((Activity) null);
            this.methodCallHandler = null;
        }
        StreamHandlerImpl streamHandlerImpl = this.streamHandler;
        if (streamHandlerImpl != null) {
            streamHandlerImpl.d();
            this.streamHandler.setForegroundLocationService((GeolocatorLocationService) null);
            this.streamHandler = null;
        }
        LocationServiceHandlerImpl locationServiceHandlerImpl = this.locationServiceHandler;
        if (locationServiceHandlerImpl != null) {
            locationServiceHandlerImpl.a((Context) null);
            this.locationServiceHandler.c();
            this.locationServiceHandler = null;
        }
        GeolocatorLocationService geolocatorLocationService = this.foregroundLocationService;
        if (geolocatorLocationService != null) {
            geolocatorLocationService.setActivity((Activity) null);
        }
    }

    /* access modifiers changed from: private */
    public void initialize(GeolocatorLocationService geolocatorLocationService) {
        Log.d(TAG, "Initializing Geolocator services");
        this.foregroundLocationService = geolocatorLocationService;
        geolocatorLocationService.flutterEngineConnected();
        StreamHandlerImpl streamHandlerImpl = this.streamHandler;
        if (streamHandlerImpl != null) {
            streamHandlerImpl.setForegroundLocationService(geolocatorLocationService);
        }
    }

    private void registerListeners() {
        PluginRegistry.Registrar registrar = this.pluginRegistrar;
        if (registrar != null) {
            registrar.addActivityResultListener(this.geolocationManager);
            this.pluginRegistrar.addRequestPermissionsResultListener(this.permissionManager);
            return;
        }
        ActivityPluginBinding activityPluginBinding = this.pluginBinding;
        if (activityPluginBinding != null) {
            activityPluginBinding.addActivityResultListener(this.geolocationManager);
            this.pluginBinding.addRequestPermissionsResultListener(this.permissionManager);
        }
    }

    public static void registerWith(PluginRegistry.Registrar registrar) {
        GeolocatorPlugin geolocatorPlugin = new GeolocatorPlugin();
        geolocatorPlugin.pluginRegistrar = registrar;
        geolocatorPlugin.registerListeners();
        MethodCallHandlerImpl methodCallHandlerImpl = new MethodCallHandlerImpl(geolocatorPlugin.permissionManager, geolocatorPlugin.geolocationManager, geolocatorPlugin.locationAccuracyManager);
        methodCallHandlerImpl.i(registrar.context(), registrar.messenger());
        methodCallHandlerImpl.h(registrar.activity());
        new StreamHandlerImpl(geolocatorPlugin.permissionManager).c(registrar.context(), registrar.messenger());
        LocationServiceHandlerImpl locationServiceHandlerImpl = new LocationServiceHandlerImpl();
        locationServiceHandlerImpl.b(registrar.context(), registrar.messenger());
        locationServiceHandlerImpl.a(registrar.activeContext());
        geolocatorPlugin.bindForegroundService(registrar.activeContext());
    }

    private void unbindForegroundService(Context context) {
        GeolocatorLocationService geolocatorLocationService = this.foregroundLocationService;
        if (geolocatorLocationService != null) {
            geolocatorLocationService.flutterEngineDisconnected();
        }
        context.unbindService(this.serviceConnection);
    }

    public void onAttachedToActivity(@NonNull ActivityPluginBinding activityPluginBinding) {
        Log.d(TAG, "Attaching Geolocator to activity");
        this.pluginBinding = activityPluginBinding;
        registerListeners();
        MethodCallHandlerImpl methodCallHandlerImpl = this.methodCallHandler;
        if (methodCallHandlerImpl != null) {
            methodCallHandlerImpl.h(activityPluginBinding.getActivity());
        }
        StreamHandlerImpl streamHandlerImpl = this.streamHandler;
        if (streamHandlerImpl != null) {
            streamHandlerImpl.setActivity(activityPluginBinding.getActivity());
        }
        GeolocatorLocationService geolocatorLocationService = this.foregroundLocationService;
        if (geolocatorLocationService != null) {
            geolocatorLocationService.setActivity(this.pluginBinding.getActivity());
        }
    }

    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        MethodCallHandlerImpl methodCallHandlerImpl = new MethodCallHandlerImpl(this.permissionManager, this.geolocationManager, this.locationAccuracyManager);
        this.methodCallHandler = methodCallHandlerImpl;
        methodCallHandlerImpl.i(flutterPluginBinding.getApplicationContext(), flutterPluginBinding.getBinaryMessenger());
        StreamHandlerImpl streamHandlerImpl = new StreamHandlerImpl(this.permissionManager);
        this.streamHandler = streamHandlerImpl;
        streamHandlerImpl.c(flutterPluginBinding.getApplicationContext(), flutterPluginBinding.getBinaryMessenger());
        LocationServiceHandlerImpl locationServiceHandlerImpl = new LocationServiceHandlerImpl();
        this.locationServiceHandler = locationServiceHandlerImpl;
        locationServiceHandlerImpl.a(flutterPluginBinding.getApplicationContext());
        this.locationServiceHandler.b(flutterPluginBinding.getApplicationContext(), flutterPluginBinding.getBinaryMessenger());
        bindForegroundService(flutterPluginBinding.getApplicationContext());
    }

    public void onDetachedFromActivity() {
        Log.d(TAG, "Detaching Geolocator from activity");
        deregisterListeners();
        MethodCallHandlerImpl methodCallHandlerImpl = this.methodCallHandler;
        if (methodCallHandlerImpl != null) {
            methodCallHandlerImpl.h((Activity) null);
        }
        StreamHandlerImpl streamHandlerImpl = this.streamHandler;
        if (streamHandlerImpl != null) {
            streamHandlerImpl.setActivity((Activity) null);
        }
        GeolocatorLocationService geolocatorLocationService = this.foregroundLocationService;
        if (geolocatorLocationService != null) {
            geolocatorLocationService.setActivity((Activity) null);
        }
        if (this.pluginBinding != null) {
            this.pluginBinding = null;
        }
    }

    public void onDetachedFromActivityForConfigChanges() {
        onDetachedFromActivity();
    }

    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        unbindForegroundService(flutterPluginBinding.getApplicationContext());
        dispose();
    }

    public void onReattachedToActivityForConfigChanges(@NonNull ActivityPluginBinding activityPluginBinding) {
        onAttachedToActivity(activityPluginBinding);
    }
}
