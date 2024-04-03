package com.mr.flutter.plugin.filepicker;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.facebook.share.internal.ShareConstants;
import com.google.android.exoplayer2.util.MimeTypes;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.embedding.engine.plugins.lifecycle.FlutterLifecycleAdapter;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import java.util.ArrayList;
import java.util.HashMap;

public class FilePickerPlugin implements MethodChannel.MethodCallHandler, FlutterPlugin, ActivityAware {
    private static final String CHANNEL = "miguelruivo.flutter.plugins.filepicker";
    private static final String EVENT_CHANNEL = "miguelruivo.flutter.plugins.filepickerevent";
    private static final String TAG = "FilePicker";
    private static String fileType = null;
    private static boolean isMultipleSelection = false;
    private static boolean withData = false;
    private Activity activity;
    private ActivityPluginBinding activityBinding;
    private Application application;
    private MethodChannel channel;
    /* access modifiers changed from: private */
    public FilePickerDelegate delegate;
    private Lifecycle lifecycle;
    private LifeCycleObserver observer;
    private FlutterPlugin.FlutterPluginBinding pluginBinding;

    public class LifeCycleObserver implements Application.ActivityLifecycleCallbacks, DefaultLifecycleObserver {
        private final Activity thisActivity;

        public LifeCycleObserver(Activity activity) {
            this.thisActivity = activity;
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
            if (this.thisActivity == activity && activity.getApplicationContext() != null) {
                ((Application) activity.getApplicationContext()).unregisterActivityLifecycleCallbacks(this);
            }
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }

        public void onCreate(@NonNull LifecycleOwner lifecycleOwner) {
        }

        public void onDestroy(@NonNull LifecycleOwner lifecycleOwner) {
            onActivityDestroyed(this.thisActivity);
        }

        public void onPause(@NonNull LifecycleOwner lifecycleOwner) {
        }

        public void onResume(@NonNull LifecycleOwner lifecycleOwner) {
        }

        public void onStart(@NonNull LifecycleOwner lifecycleOwner) {
        }

        public void onStop(@NonNull LifecycleOwner lifecycleOwner) {
            onActivityStopped(this.thisActivity);
        }
    }

    public static class MethodResultWrapper implements MethodChannel.Result {
        private final Handler handler = new Handler(Looper.getMainLooper());
        /* access modifiers changed from: private */
        public final MethodChannel.Result methodResult;

        public MethodResultWrapper(MethodChannel.Result result) {
            this.methodResult = result;
        }

        public void error(final String str, final String str2, final Object obj) {
            this.handler.post(new Runnable() {
                public void run() {
                    MethodResultWrapper.this.methodResult.error(str, str2, obj);
                }
            });
        }

        public void notImplemented() {
            this.handler.post(new Runnable() {
                public void run() {
                    MethodResultWrapper.this.methodResult.notImplemented();
                }
            });
        }

        public void success(final Object obj) {
            this.handler.post(new Runnable() {
                public void run() {
                    MethodResultWrapper.this.methodResult.success(obj);
                }
            });
        }
    }

    public static void registerWith(PluginRegistry.Registrar registrar) {
        Application application2;
        if (registrar.activity() != null) {
            Activity activity2 = registrar.activity();
            if (registrar.context() != null) {
                application2 = (Application) registrar.context().getApplicationContext();
            } else {
                application2 = null;
            }
            new FilePickerPlugin().setup(registrar.messenger(), application2, activity2, registrar, (ActivityPluginBinding) null);
        }
    }

    private static String resolveType(String str) {
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1349088399:
                if (str.equals("custom")) {
                    c11 = 0;
                    break;
                }
                break;
            case 96748:
                if (str.equals("any")) {
                    c11 = 1;
                    break;
                }
                break;
            case 99469:
                if (str.equals("dir")) {
                    c11 = 2;
                    break;
                }
                break;
            case 93166550:
                if (str.equals(MimeTypes.BASE_TYPE_AUDIO)) {
                    c11 = 3;
                    break;
                }
                break;
            case 100313435:
                if (str.equals("image")) {
                    c11 = 4;
                    break;
                }
                break;
            case 103772132:
                if (str.equals(ShareConstants.WEB_DIALOG_PARAM_MEDIA)) {
                    c11 = 5;
                    break;
                }
                break;
            case 112202875:
                if (str.equals("video")) {
                    c11 = 6;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
            case 1:
                return "*/*";
            case 2:
                return "dir";
            case 3:
                return "audio/*";
            case 4:
                return "image/*";
            case 5:
                return "image/*,video/*";
            case 6:
                return "video/*";
            default:
                return null;
        }
    }

    private void setup(BinaryMessenger binaryMessenger, Application application2, Activity activity2, PluginRegistry.Registrar registrar, ActivityPluginBinding activityPluginBinding) {
        this.activity = activity2;
        this.application = application2;
        this.delegate = new FilePickerDelegate(activity2);
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, CHANNEL);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
        new EventChannel(binaryMessenger, EVENT_CHANNEL).setStreamHandler(new EventChannel.StreamHandler() {
            public void onCancel(Object obj) {
                FilePickerPlugin.this.delegate.setEventHandler((EventChannel.EventSink) null);
            }

            public void onListen(Object obj, EventChannel.EventSink eventSink) {
                FilePickerPlugin.this.delegate.setEventHandler(eventSink);
            }
        });
        LifeCycleObserver lifeCycleObserver = new LifeCycleObserver(activity2);
        this.observer = lifeCycleObserver;
        if (registrar != null) {
            application2.registerActivityLifecycleCallbacks(lifeCycleObserver);
            registrar.addActivityResultListener(this.delegate);
            registrar.addRequestPermissionsResultListener(this.delegate);
            return;
        }
        activityPluginBinding.addActivityResultListener(this.delegate);
        activityPluginBinding.addRequestPermissionsResultListener(this.delegate);
        Lifecycle activityLifecycle = FlutterLifecycleAdapter.getActivityLifecycle(activityPluginBinding);
        this.lifecycle = activityLifecycle;
        activityLifecycle.addObserver(this.observer);
    }

    private void tearDown() {
        this.activityBinding.removeActivityResultListener(this.delegate);
        this.activityBinding.removeRequestPermissionsResultListener(this.delegate);
        this.activityBinding = null;
        LifeCycleObserver lifeCycleObserver = this.observer;
        if (lifeCycleObserver != null) {
            this.lifecycle.removeObserver(lifeCycleObserver);
            this.application.unregisterActivityLifecycleCallbacks(this.observer);
        }
        this.lifecycle = null;
        this.delegate.setEventHandler((EventChannel.EventSink) null);
        this.delegate = null;
        this.channel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        this.channel = null;
        this.application = null;
    }

    public void onAttachedToActivity(ActivityPluginBinding activityPluginBinding) {
        this.activityBinding = activityPluginBinding;
        setup(this.pluginBinding.getBinaryMessenger(), (Application) this.pluginBinding.getApplicationContext(), this.activityBinding.getActivity(), (PluginRegistry.Registrar) null, this.activityBinding);
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.pluginBinding = flutterPluginBinding;
    }

    public void onDetachedFromActivity() {
        tearDown();
    }

    public void onDetachedFromActivityForConfigChanges() {
        onDetachedFromActivity();
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.pluginBinding = null;
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        String[] strArr;
        String str;
        if (this.activity == null) {
            result.error("no_activity", "file picker plugin requires a foreground activity", (Object) null);
            return;
        }
        MethodResultWrapper methodResultWrapper = new MethodResultWrapper(result);
        HashMap hashMap = (HashMap) methodCall.arguments;
        String str2 = methodCall.method;
        if (str2 == null || !str2.equals("clear")) {
            String resolveType = resolveType(methodCall.method);
            fileType = resolveType;
            if (resolveType == null) {
                methodResultWrapper.notImplemented();
            } else if (resolveType != "dir") {
                isMultipleSelection = ((Boolean) hashMap.get("allowMultipleSelection")).booleanValue();
                withData = ((Boolean) hashMap.get("withData")).booleanValue();
                strArr = FileUtils.getMimeTypes((ArrayList) hashMap.get("allowedExtensions"));
                str = methodCall.method;
                if (str == null && !str.equals("custom") && (strArr == null || strArr.length == 0)) {
                    methodResultWrapper.error(TAG, "Unsupported filter. Make sure that you are only using the extension without the dot, (ie., jpg instead of .jpg). This could also have happened because you are using an unsupported file extension.  If the problem persists, you may want to consider using FileType.all instead.", (Object) null);
                    return;
                } else {
                    this.delegate.startFileExplorer(fileType, isMultipleSelection, withData, strArr, methodResultWrapper);
                    return;
                }
            }
            strArr = null;
            str = methodCall.method;
            if (str == null && !str.equals("custom")) {
            }
            this.delegate.startFileExplorer(fileType, isMultipleSelection, withData, strArr, methodResultWrapper);
            return;
        }
        methodResultWrapper.success(Boolean.valueOf(FileUtils.clearCache(this.activity.getApplicationContext())));
    }

    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding) {
        onAttachedToActivity(activityPluginBinding);
    }
}
