package com.huawei.hms.flutter.map;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.huawei.hms.flutter.map.constants.Channel;
import com.huawei.hms.flutter.map.constants.Method;
import com.huawei.hms.flutter.map.logger.HMSLogger;
import com.huawei.hms.flutter.map.map.MapFactory;
import com.huawei.hms.flutter.map.utils.Convert;
import com.huawei.hms.flutter.map.utils.ToJson;
import com.huawei.hms.maps.MapsInitializer;
import com.huawei.hms.maps.common.util.CoordinateConverter;
import com.huawei.hms.maps.common.util.DistanceCalculator;
import com.huawei.hms.maps.model.LatLng;
import com.talabat.feature.nfvinvendorsearch.presentation.utils.Constants;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.embedding.engine.plugins.lifecycle.HiddenLifecycleReference;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class HmsMap implements Application.ActivityLifecycleCallbacks, FlutterPlugin, ActivityAware, DefaultLifecycleObserver, MethodChannel.MethodCallHandler {
    public static final int CREATED = 1;
    public static final int DESTROYED = 6;
    public static final int PAUSED = 4;
    public static final int RESUMED = 3;
    public static final int STARTED = 2;
    public static final int STOPPED = 5;
    private FlutterPlugin.FlutterPluginBinding flutterPluginBinding;
    private Lifecycle lifecycle;
    private MethodChannel mapUtils;
    private int registrarActivityHashCode;
    private final AtomicInteger state = new AtomicInteger(0);

    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (activity.hashCode() == this.registrarActivityHashCode) {
            this.state.set(1);
        }
    }

    public void onActivityDestroyed(Activity activity) {
        if (activity.hashCode() == this.registrarActivityHashCode) {
            activity.getApplication().unregisterActivityLifecycleCallbacks(this);
            this.state.set(6);
        }
    }

    public void onActivityPaused(Activity activity) {
        if (activity.hashCode() == this.registrarActivityHashCode) {
            this.state.set(4);
        }
    }

    public void onActivityResumed(Activity activity) {
        if (activity.hashCode() == this.registrarActivityHashCode) {
            this.state.set(3);
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        if (activity.hashCode() == this.registrarActivityHashCode) {
            this.state.set(2);
        }
    }

    public void onActivityStopped(Activity activity) {
        if (activity.hashCode() == this.registrarActivityHashCode) {
            this.state.set(5);
        }
    }

    public void onAttachedToActivity(@NonNull ActivityPluginBinding activityPluginBinding) {
        if (this.flutterPluginBinding != null) {
            activityPluginBinding.getActivity().getIntent().putExtra(Constants.ARG_BACKGROUND_MODE, "transparent");
            this.registrarActivityHashCode = activityPluginBinding.getActivity().hashCode();
            Lifecycle lifecycle2 = ((HiddenLifecycleReference) activityPluginBinding.getLifecycle()).getLifecycle();
            this.lifecycle = lifecycle2;
            lifecycle2.addObserver(this);
            this.flutterPluginBinding.getPlatformViewRegistry().registerViewFactory(Channel.CHANNEL, new MapFactory(this.state, this.flutterPluginBinding.getBinaryMessenger(), activityPluginBinding.getActivity(), this.lifecycle, (PluginRegistry.Registrar) null, activityPluginBinding.getActivity().hashCode()));
        }
    }

    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding2) {
        this.flutterPluginBinding = flutterPluginBinding2;
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding2.getBinaryMessenger(), Channel.MAP_UTILS);
        this.mapUtils = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    public void onCreate(@NonNull LifecycleOwner lifecycleOwner) {
        this.state.set(1);
    }

    public void onDestroy(@NonNull LifecycleOwner lifecycleOwner) {
        this.state.set(6);
    }

    public void onDetachedFromActivity() {
        Lifecycle lifecycle2 = this.lifecycle;
        if (lifecycle2 != null) {
            lifecycle2.removeObserver(this);
        }
    }

    public void onDetachedFromActivityForConfigChanges() {
        onDetachedFromActivity();
    }

    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding2) {
        this.flutterPluginBinding = null;
        this.mapUtils = null;
    }

    public void onMethodCall(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
        String str = methodCall.method;
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1200782323:
                if (str.equals(Method.SET_API_KEY)) {
                    c11 = 0;
                    break;
                }
                break;
            case -1014570030:
                if (str.equals(Method.INITIALIZE_MAP)) {
                    c11 = 1;
                    break;
                }
                break;
            case 613913777:
                if (str.equals(Method.CONVERT_COORDINATE)) {
                    c11 = 2;
                    break;
                }
                break;
            case 1559748721:
                if (str.equals(Method.DISTANCE_CALCULATOR)) {
                    c11 = 3;
                    break;
                }
                break;
            case 1682646477:
                if (str.equals(Method.SET_ACCESS_TOKEN)) {
                    c11 = 4;
                    break;
                }
                break;
            case 1751589566:
                if (str.equals(Method.DISABLE_LOGGER)) {
                    c11 = 5;
                    break;
                }
                break;
            case 1799983117:
                if (str.equals(Method.ENABLE_LOGGER)) {
                    c11 = 6;
                    break;
                }
                break;
            case 1851458018:
                if (str.equals(Method.CONVERT_COORDINATES)) {
                    c11 = 7;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                String convert = Convert.toString(methodCall.arguments);
                HMSLogger.getInstance(this.flutterPluginBinding.getApplicationContext()).startMethodExecutionTimer(Method.SET_API_KEY);
                MapsInitializer.setApiKey(convert);
                result.success(Boolean.TRUE);
                HMSLogger.getInstance(this.flutterPluginBinding.getApplicationContext()).sendSingleEvent(Method.SET_API_KEY);
                return;
            case 1:
                if (this.flutterPluginBinding != null) {
                    String convert2 = Convert.toString(methodCall.arguments);
                    HMSLogger.getInstance(this.flutterPluginBinding.getApplicationContext()).startMethodExecutionTimer(Method.INITIALIZE_MAP);
                    if (convert2 != null) {
                        MapsInitializer.initialize(this.flutterPluginBinding.getApplicationContext(), convert2);
                    } else {
                        MapsInitializer.initialize(this.flutterPluginBinding.getApplicationContext());
                    }
                    result.success(Boolean.TRUE);
                    HMSLogger.getInstance(this.flutterPluginBinding.getApplicationContext()).sendSingleEvent(Method.INITIALIZE_MAP);
                    return;
                }
                return;
            case 2:
                LatLng latLng = Convert.toLatLng(methodCall.arguments);
                HMSLogger.getInstance(this.flutterPluginBinding.getApplicationContext()).startMethodExecutionTimer(Method.CONVERT_COORDINATE);
                result.success(ToJson.latLng(new CoordinateConverter().convert(latLng)));
                HMSLogger.getInstance(this.flutterPluginBinding.getApplicationContext()).sendSingleEvent(Method.CONVERT_COORDINATE);
                return;
            case 3:
                if (this.flutterPluginBinding != null) {
                    List<LatLng> latLngStartEnd = Convert.toLatLngStartEnd(methodCall.arguments);
                    HMSLogger.getInstance(this.flutterPluginBinding.getApplicationContext()).startMethodExecutionTimer(Method.DISTANCE_CALCULATOR);
                    result.success(Double.valueOf(DistanceCalculator.computeDistanceBetween(latLngStartEnd.get(0), latLngStartEnd.get(1))));
                    HMSLogger.getInstance(this.flutterPluginBinding.getApplicationContext()).sendSingleEvent(Method.DISTANCE_CALCULATOR);
                    return;
                }
                return;
            case 4:
                String convert3 = Convert.toString(methodCall.arguments);
                HMSLogger.getInstance(this.flutterPluginBinding.getApplicationContext()).startMethodExecutionTimer(Method.SET_ACCESS_TOKEN);
                MapsInitializer.setAccessToken(convert3);
                result.success(Boolean.TRUE);
                HMSLogger.getInstance(this.flutterPluginBinding.getApplicationContext()).sendSingleEvent(Method.SET_ACCESS_TOKEN);
                return;
            case 5:
                FlutterPlugin.FlutterPluginBinding flutterPluginBinding2 = this.flutterPluginBinding;
                if (flutterPluginBinding2 != null) {
                    HMSLogger.getInstance(flutterPluginBinding2.getApplicationContext()).disableLogger();
                    return;
                }
                return;
            case 6:
                FlutterPlugin.FlutterPluginBinding flutterPluginBinding3 = this.flutterPluginBinding;
                if (flutterPluginBinding3 != null) {
                    HMSLogger.getInstance(flutterPluginBinding3.getApplicationContext()).enableLogger();
                    return;
                }
                return;
            case 7:
                LatLng[] latLngList = Convert.toLatLngList(methodCall.arguments);
                HMSLogger.getInstance(this.flutterPluginBinding.getApplicationContext()).startMethodExecutionTimer(Method.CONVERT_COORDINATES);
                result.success(ToJson.latLngList(new CoordinateConverter().convert(latLngList)));
                HMSLogger.getInstance(this.flutterPluginBinding.getApplicationContext()).sendSingleEvent(Method.CONVERT_COORDINATES);
                return;
            default:
                result.notImplemented();
                return;
        }
    }

    public void onPause(@NonNull LifecycleOwner lifecycleOwner) {
        this.state.set(4);
    }

    public void onReattachedToActivityForConfigChanges(@NonNull ActivityPluginBinding activityPluginBinding) {
        Lifecycle lifecycle2 = ((HiddenLifecycleReference) activityPluginBinding.getLifecycle()).getLifecycle();
        this.lifecycle = lifecycle2;
        lifecycle2.addObserver(this);
    }

    public void onResume(@NonNull LifecycleOwner lifecycleOwner) {
        this.state.set(3);
    }

    public void onStart(@NonNull LifecycleOwner lifecycleOwner) {
        this.state.set(2);
    }

    public void onStop(@NonNull LifecycleOwner lifecycleOwner) {
        this.state.set(5);
    }
}
