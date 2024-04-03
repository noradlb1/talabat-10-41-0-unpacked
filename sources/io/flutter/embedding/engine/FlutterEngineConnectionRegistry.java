package io.flutter.embedding.engine;

import android.app.Activity;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import io.flutter.Log;
import io.flutter.embedding.android.ExclusiveAppComponent;
import io.flutter.embedding.engine.loader.FlutterLoader;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.PluginRegistry;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityControlSurface;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.embedding.engine.plugins.broadcastreceiver.BroadcastReceiverAware;
import io.flutter.embedding.engine.plugins.broadcastreceiver.BroadcastReceiverControlSurface;
import io.flutter.embedding.engine.plugins.broadcastreceiver.BroadcastReceiverPluginBinding;
import io.flutter.embedding.engine.plugins.contentprovider.ContentProviderAware;
import io.flutter.embedding.engine.plugins.contentprovider.ContentProviderControlSurface;
import io.flutter.embedding.engine.plugins.contentprovider.ContentProviderPluginBinding;
import io.flutter.embedding.engine.plugins.lifecycle.HiddenLifecycleReference;
import io.flutter.embedding.engine.plugins.service.ServiceAware;
import io.flutter.embedding.engine.plugins.service.ServiceControlSurface;
import io.flutter.embedding.engine.plugins.service.ServicePluginBinding;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.util.TraceSection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class FlutterEngineConnectionRegistry implements PluginRegistry, ActivityControlSurface, ServiceControlSurface, BroadcastReceiverControlSurface, ContentProviderControlSurface {
    private static final String TAG = "FlutterEngineCxnRegstry";
    @NonNull
    private final Map<Class<? extends FlutterPlugin>, ActivityAware> activityAwarePlugins = new HashMap();
    @Nullable
    private FlutterEngineActivityPluginBinding activityPluginBinding;
    @Nullable
    private BroadcastReceiver broadcastReceiver;
    @NonNull
    private final Map<Class<? extends FlutterPlugin>, BroadcastReceiverAware> broadcastReceiverAwarePlugins = new HashMap();
    @Nullable
    private FlutterEngineBroadcastReceiverPluginBinding broadcastReceiverPluginBinding;
    @Nullable
    private ContentProvider contentProvider;
    @NonNull
    private final Map<Class<? extends FlutterPlugin>, ContentProviderAware> contentProviderAwarePlugins = new HashMap();
    @Nullable
    private FlutterEngineContentProviderPluginBinding contentProviderPluginBinding;
    @Nullable
    private ExclusiveAppComponent<Activity> exclusiveActivity;
    @NonNull
    private final FlutterEngine flutterEngine;
    private boolean isWaitingForActivityReattachment = false;
    @NonNull
    private final FlutterPlugin.FlutterPluginBinding pluginBinding;
    @NonNull
    private final Map<Class<? extends FlutterPlugin>, FlutterPlugin> plugins = new HashMap();
    @Nullable

    /* renamed from: service  reason: collision with root package name */
    private Service f14166service;
    @NonNull
    private final Map<Class<? extends FlutterPlugin>, ServiceAware> serviceAwarePlugins = new HashMap();
    @Nullable
    private FlutterEngineServicePluginBinding servicePluginBinding;

    public static class DefaultFlutterAssets implements FlutterPlugin.FlutterAssets {

        /* renamed from: a  reason: collision with root package name */
        public final FlutterLoader f14167a;

        public String getAssetFilePathByName(@NonNull String str) {
            return this.f14167a.getLookupKeyForAsset(str);
        }

        public String getAssetFilePathBySubpath(@NonNull String str) {
            return this.f14167a.getLookupKeyForAsset(str);
        }

        private DefaultFlutterAssets(@NonNull FlutterLoader flutterLoader) {
            this.f14167a = flutterLoader;
        }

        public String getAssetFilePathByName(@NonNull String str, @NonNull String str2) {
            return this.f14167a.getLookupKeyForAsset(str, str2);
        }

        public String getAssetFilePathBySubpath(@NonNull String str, @NonNull String str2) {
            return this.f14167a.getLookupKeyForAsset(str, str2);
        }
    }

    public static class FlutterEngineActivityPluginBinding implements ActivityPluginBinding {
        @NonNull
        private final Activity activity;
        @NonNull
        private final HiddenLifecycleReference hiddenLifecycleReference;
        @NonNull
        private final Set<PluginRegistry.ActivityResultListener> onActivityResultListeners = new HashSet();
        @NonNull
        private final Set<PluginRegistry.NewIntentListener> onNewIntentListeners = new HashSet();
        @NonNull
        private final Set<PluginRegistry.RequestPermissionsResultListener> onRequestPermissionsResultListeners = new HashSet();
        @NonNull
        private final Set<ActivityPluginBinding.OnSaveInstanceStateListener> onSaveInstanceStateListeners = new HashSet();
        @NonNull
        private final Set<PluginRegistry.UserLeaveHintListener> onUserLeaveHintListeners = new HashSet();

        public FlutterEngineActivityPluginBinding(@NonNull Activity activity2, @NonNull Lifecycle lifecycle) {
            this.activity = activity2;
            this.hiddenLifecycleReference = new HiddenLifecycleReference(lifecycle);
        }

        public boolean a(int i11, int i12, @Nullable Intent intent) {
            Iterator it = new HashSet(this.onActivityResultListeners).iterator();
            while (true) {
                boolean z11 = false;
                while (true) {
                    if (!it.hasNext()) {
                        return z11;
                    }
                    if (((PluginRegistry.ActivityResultListener) it.next()).onActivityResult(i11, i12, intent) || z11) {
                        z11 = true;
                    }
                }
            }
        }

        public void addActivityResultListener(@NonNull PluginRegistry.ActivityResultListener activityResultListener) {
            this.onActivityResultListeners.add(activityResultListener);
        }

        public void addOnNewIntentListener(@NonNull PluginRegistry.NewIntentListener newIntentListener) {
            this.onNewIntentListeners.add(newIntentListener);
        }

        public void addOnSaveStateListener(@NonNull ActivityPluginBinding.OnSaveInstanceStateListener onSaveInstanceStateListener) {
            this.onSaveInstanceStateListeners.add(onSaveInstanceStateListener);
        }

        public void addOnUserLeaveHintListener(@NonNull PluginRegistry.UserLeaveHintListener userLeaveHintListener) {
            this.onUserLeaveHintListeners.add(userLeaveHintListener);
        }

        public void addRequestPermissionsResultListener(@NonNull PluginRegistry.RequestPermissionsResultListener requestPermissionsResultListener) {
            this.onRequestPermissionsResultListeners.add(requestPermissionsResultListener);
        }

        public void b(@Nullable Intent intent) {
            for (PluginRegistry.NewIntentListener onNewIntent : this.onNewIntentListeners) {
                onNewIntent.onNewIntent(intent);
            }
        }

        public boolean c(int i11, @NonNull String[] strArr, @NonNull int[] iArr) {
            Iterator<PluginRegistry.RequestPermissionsResultListener> it = this.onRequestPermissionsResultListeners.iterator();
            while (true) {
                boolean z11 = false;
                while (true) {
                    if (!it.hasNext()) {
                        return z11;
                    }
                    if (it.next().onRequestPermissionsResult(i11, strArr, iArr) || z11) {
                        z11 = true;
                    }
                }
            }
        }

        public void d(@Nullable Bundle bundle) {
            for (ActivityPluginBinding.OnSaveInstanceStateListener onRestoreInstanceState : this.onSaveInstanceStateListeners) {
                onRestoreInstanceState.onRestoreInstanceState(bundle);
            }
        }

        public void e(@NonNull Bundle bundle) {
            for (ActivityPluginBinding.OnSaveInstanceStateListener onSaveInstanceState : this.onSaveInstanceStateListeners) {
                onSaveInstanceState.onSaveInstanceState(bundle);
            }
        }

        public void f() {
            for (PluginRegistry.UserLeaveHintListener onUserLeaveHint : this.onUserLeaveHintListeners) {
                onUserLeaveHint.onUserLeaveHint();
            }
        }

        @NonNull
        public Activity getActivity() {
            return this.activity;
        }

        @NonNull
        public Object getLifecycle() {
            return this.hiddenLifecycleReference;
        }

        public void removeActivityResultListener(@NonNull PluginRegistry.ActivityResultListener activityResultListener) {
            this.onActivityResultListeners.remove(activityResultListener);
        }

        public void removeOnNewIntentListener(@NonNull PluginRegistry.NewIntentListener newIntentListener) {
            this.onNewIntentListeners.remove(newIntentListener);
        }

        public void removeOnSaveStateListener(@NonNull ActivityPluginBinding.OnSaveInstanceStateListener onSaveInstanceStateListener) {
            this.onSaveInstanceStateListeners.remove(onSaveInstanceStateListener);
        }

        public void removeOnUserLeaveHintListener(@NonNull PluginRegistry.UserLeaveHintListener userLeaveHintListener) {
            this.onUserLeaveHintListeners.remove(userLeaveHintListener);
        }

        public void removeRequestPermissionsResultListener(@NonNull PluginRegistry.RequestPermissionsResultListener requestPermissionsResultListener) {
            this.onRequestPermissionsResultListeners.remove(requestPermissionsResultListener);
        }
    }

    public static class FlutterEngineBroadcastReceiverPluginBinding implements BroadcastReceiverPluginBinding {
        @NonNull
        private final BroadcastReceiver broadcastReceiver;

        public FlutterEngineBroadcastReceiverPluginBinding(@NonNull BroadcastReceiver broadcastReceiver2) {
            this.broadcastReceiver = broadcastReceiver2;
        }

        @NonNull
        public BroadcastReceiver getBroadcastReceiver() {
            return this.broadcastReceiver;
        }
    }

    public static class FlutterEngineContentProviderPluginBinding implements ContentProviderPluginBinding {
        @NonNull
        private final ContentProvider contentProvider;

        public FlutterEngineContentProviderPluginBinding(@NonNull ContentProvider contentProvider2) {
            this.contentProvider = contentProvider2;
        }

        @NonNull
        public ContentProvider getContentProvider() {
            return this.contentProvider;
        }
    }

    public static class FlutterEngineServicePluginBinding implements ServicePluginBinding {
        @Nullable
        private final HiddenLifecycleReference hiddenLifecycleReference;
        @NonNull
        private final Set<ServiceAware.OnModeChangeListener> onModeChangeListeners = new HashSet();
        @NonNull

        /* renamed from: service  reason: collision with root package name */
        private final Service f14168service;

        public FlutterEngineServicePluginBinding(@NonNull Service service2, @Nullable Lifecycle lifecycle) {
            HiddenLifecycleReference hiddenLifecycleReference2;
            this.f14168service = service2;
            if (lifecycle != null) {
                hiddenLifecycleReference2 = new HiddenLifecycleReference(lifecycle);
            } else {
                hiddenLifecycleReference2 = null;
            }
            this.hiddenLifecycleReference = hiddenLifecycleReference2;
        }

        public void a() {
            for (ServiceAware.OnModeChangeListener onMoveToBackground : this.onModeChangeListeners) {
                onMoveToBackground.onMoveToBackground();
            }
        }

        public void addOnModeChangeListener(@NonNull ServiceAware.OnModeChangeListener onModeChangeListener) {
            this.onModeChangeListeners.add(onModeChangeListener);
        }

        public void b() {
            for (ServiceAware.OnModeChangeListener onMoveToForeground : this.onModeChangeListeners) {
                onMoveToForeground.onMoveToForeground();
            }
        }

        @Nullable
        public Object getLifecycle() {
            return this.hiddenLifecycleReference;
        }

        @NonNull
        public Service getService() {
            return this.f14168service;
        }

        public void removeOnModeChangeListener(@NonNull ServiceAware.OnModeChangeListener onModeChangeListener) {
            this.onModeChangeListeners.remove(onModeChangeListener);
        }
    }

    public FlutterEngineConnectionRegistry(@NonNull Context context, @NonNull FlutterEngine flutterEngine2, @NonNull FlutterLoader flutterLoader) {
        this.flutterEngine = flutterEngine2;
        this.pluginBinding = new FlutterPlugin.FlutterPluginBinding(context, flutterEngine2, flutterEngine2.getDartExecutor(), flutterEngine2.getRenderer(), flutterEngine2.getPlatformViewsController().getRegistry(), new DefaultFlutterAssets(flutterLoader));
    }

    private void attachToActivityInternal(@NonNull Activity activity, @NonNull Lifecycle lifecycle) {
        boolean z11;
        this.activityPluginBinding = new FlutterEngineActivityPluginBinding(activity, lifecycle);
        if (activity.getIntent() != null) {
            z11 = activity.getIntent().getBooleanExtra(FlutterShellArgs.ARG_KEY_ENABLE_SOFTWARE_RENDERING, false);
        } else {
            z11 = false;
        }
        this.flutterEngine.getPlatformViewsController().setSoftwareRendering(z11);
        this.flutterEngine.getPlatformViewsController().attach(activity, this.flutterEngine.getRenderer(), this.flutterEngine.getDartExecutor());
        for (ActivityAware next : this.activityAwarePlugins.values()) {
            if (this.isWaitingForActivityReattachment) {
                next.onReattachedToActivityForConfigChanges(this.activityPluginBinding);
            } else {
                next.onAttachedToActivity(this.activityPluginBinding);
            }
        }
        this.isWaitingForActivityReattachment = false;
    }

    private Activity attachedActivity() {
        ExclusiveAppComponent<Activity> exclusiveAppComponent = this.exclusiveActivity;
        if (exclusiveAppComponent != null) {
            return exclusiveAppComponent.getAppComponent();
        }
        return null;
    }

    private void detachFromActivityInternal() {
        this.flutterEngine.getPlatformViewsController().detach();
        this.exclusiveActivity = null;
        this.activityPluginBinding = null;
    }

    private void detachFromAppComponent() {
        if (isAttachedToActivity()) {
            detachFromActivity();
        } else if (isAttachedToService()) {
            detachFromService();
        } else if (isAttachedToBroadcastReceiver()) {
            detachFromBroadcastReceiver();
        } else if (isAttachedToContentProvider()) {
            detachFromContentProvider();
        }
    }

    private boolean isAttachedToActivity() {
        return this.exclusiveActivity != null;
    }

    private boolean isAttachedToBroadcastReceiver() {
        return this.broadcastReceiver != null;
    }

    private boolean isAttachedToContentProvider() {
        return this.contentProvider != null;
    }

    private boolean isAttachedToService() {
        return this.f14166service != null;
    }

    public void add(@NonNull FlutterPlugin flutterPlugin) {
        TraceSection.begin("FlutterEngineConnectionRegistry#add " + flutterPlugin.getClass().getSimpleName());
        try {
            if (has(flutterPlugin.getClass())) {
                Log.w(TAG, "Attempted to register plugin (" + flutterPlugin + ") but it was already registered with this FlutterEngine (" + this.flutterEngine + ").");
                return;
            }
            Log.v(TAG, "Adding plugin: " + flutterPlugin);
            this.plugins.put(flutterPlugin.getClass(), flutterPlugin);
            flutterPlugin.onAttachedToEngine(this.pluginBinding);
            if (flutterPlugin instanceof ActivityAware) {
                ActivityAware activityAware = (ActivityAware) flutterPlugin;
                this.activityAwarePlugins.put(flutterPlugin.getClass(), activityAware);
                if (isAttachedToActivity()) {
                    activityAware.onAttachedToActivity(this.activityPluginBinding);
                }
            }
            if (flutterPlugin instanceof ServiceAware) {
                ServiceAware serviceAware = (ServiceAware) flutterPlugin;
                this.serviceAwarePlugins.put(flutterPlugin.getClass(), serviceAware);
                if (isAttachedToService()) {
                    serviceAware.onAttachedToService(this.servicePluginBinding);
                }
            }
            if (flutterPlugin instanceof BroadcastReceiverAware) {
                BroadcastReceiverAware broadcastReceiverAware = (BroadcastReceiverAware) flutterPlugin;
                this.broadcastReceiverAwarePlugins.put(flutterPlugin.getClass(), broadcastReceiverAware);
                if (isAttachedToBroadcastReceiver()) {
                    broadcastReceiverAware.onAttachedToBroadcastReceiver(this.broadcastReceiverPluginBinding);
                }
            }
            if (flutterPlugin instanceof ContentProviderAware) {
                ContentProviderAware contentProviderAware = (ContentProviderAware) flutterPlugin;
                this.contentProviderAwarePlugins.put(flutterPlugin.getClass(), contentProviderAware);
                if (isAttachedToContentProvider()) {
                    contentProviderAware.onAttachedToContentProvider(this.contentProviderPluginBinding);
                }
            }
            TraceSection.end();
        } finally {
            TraceSection.end();
        }
    }

    public void attachToActivity(@NonNull ExclusiveAppComponent<Activity> exclusiveAppComponent, @NonNull Lifecycle lifecycle) {
        TraceSection.begin("FlutterEngineConnectionRegistry#attachToActivity");
        try {
            ExclusiveAppComponent<Activity> exclusiveAppComponent2 = this.exclusiveActivity;
            if (exclusiveAppComponent2 != null) {
                exclusiveAppComponent2.detachFromFlutterEngine();
            }
            detachFromAppComponent();
            this.exclusiveActivity = exclusiveAppComponent;
            attachToActivityInternal(exclusiveAppComponent.getAppComponent(), lifecycle);
        } finally {
            TraceSection.end();
        }
    }

    public void attachToBroadcastReceiver(@NonNull BroadcastReceiver broadcastReceiver2, @NonNull Lifecycle lifecycle) {
        TraceSection.begin("FlutterEngineConnectionRegistry#attachToBroadcastReceiver");
        try {
            detachFromAppComponent();
            this.broadcastReceiver = broadcastReceiver2;
            this.broadcastReceiverPluginBinding = new FlutterEngineBroadcastReceiverPluginBinding(broadcastReceiver2);
            for (BroadcastReceiverAware onAttachedToBroadcastReceiver : this.broadcastReceiverAwarePlugins.values()) {
                onAttachedToBroadcastReceiver.onAttachedToBroadcastReceiver(this.broadcastReceiverPluginBinding);
            }
        } finally {
            TraceSection.end();
        }
    }

    public void attachToContentProvider(@NonNull ContentProvider contentProvider2, @NonNull Lifecycle lifecycle) {
        TraceSection.begin("FlutterEngineConnectionRegistry#attachToContentProvider");
        try {
            detachFromAppComponent();
            this.contentProvider = contentProvider2;
            this.contentProviderPluginBinding = new FlutterEngineContentProviderPluginBinding(contentProvider2);
            for (ContentProviderAware onAttachedToContentProvider : this.contentProviderAwarePlugins.values()) {
                onAttachedToContentProvider.onAttachedToContentProvider(this.contentProviderPluginBinding);
            }
        } finally {
            TraceSection.end();
        }
    }

    public void attachToService(@NonNull Service service2, @Nullable Lifecycle lifecycle, boolean z11) {
        TraceSection.begin("FlutterEngineConnectionRegistry#attachToService");
        try {
            detachFromAppComponent();
            this.f14166service = service2;
            this.servicePluginBinding = new FlutterEngineServicePluginBinding(service2, lifecycle);
            for (ServiceAware onAttachedToService : this.serviceAwarePlugins.values()) {
                onAttachedToService.onAttachedToService(this.servicePluginBinding);
            }
        } finally {
            TraceSection.end();
        }
    }

    public void destroy() {
        Log.v(TAG, "Destroying.");
        detachFromAppComponent();
        removeAll();
    }

    public void detachFromActivity() {
        if (isAttachedToActivity()) {
            TraceSection.begin("FlutterEngineConnectionRegistry#detachFromActivity");
            try {
                for (ActivityAware onDetachedFromActivity : this.activityAwarePlugins.values()) {
                    onDetachedFromActivity.onDetachedFromActivity();
                }
                detachFromActivityInternal();
            } finally {
                TraceSection.end();
            }
        } else {
            Log.e(TAG, "Attempted to detach plugins from an Activity when no Activity was attached.");
        }
    }

    public void detachFromActivityForConfigChanges() {
        if (isAttachedToActivity()) {
            TraceSection.begin("FlutterEngineConnectionRegistry#detachFromActivityForConfigChanges");
            try {
                this.isWaitingForActivityReattachment = true;
                for (ActivityAware onDetachedFromActivityForConfigChanges : this.activityAwarePlugins.values()) {
                    onDetachedFromActivityForConfigChanges.onDetachedFromActivityForConfigChanges();
                }
                detachFromActivityInternal();
            } finally {
                TraceSection.end();
            }
        } else {
            Log.e(TAG, "Attempted to detach plugins from an Activity when no Activity was attached.");
        }
    }

    public void detachFromBroadcastReceiver() {
        if (isAttachedToBroadcastReceiver()) {
            TraceSection.begin("FlutterEngineConnectionRegistry#detachFromBroadcastReceiver");
            try {
                for (BroadcastReceiverAware onDetachedFromBroadcastReceiver : this.broadcastReceiverAwarePlugins.values()) {
                    onDetachedFromBroadcastReceiver.onDetachedFromBroadcastReceiver();
                }
            } finally {
                TraceSection.end();
            }
        } else {
            Log.e(TAG, "Attempted to detach plugins from a BroadcastReceiver when no BroadcastReceiver was attached.");
        }
    }

    public void detachFromContentProvider() {
        if (isAttachedToContentProvider()) {
            TraceSection.begin("FlutterEngineConnectionRegistry#detachFromContentProvider");
            try {
                for (ContentProviderAware onDetachedFromContentProvider : this.contentProviderAwarePlugins.values()) {
                    onDetachedFromContentProvider.onDetachedFromContentProvider();
                }
            } finally {
                TraceSection.end();
            }
        } else {
            Log.e(TAG, "Attempted to detach plugins from a ContentProvider when no ContentProvider was attached.");
        }
    }

    public void detachFromService() {
        if (isAttachedToService()) {
            TraceSection.begin("FlutterEngineConnectionRegistry#detachFromService");
            try {
                for (ServiceAware onDetachedFromService : this.serviceAwarePlugins.values()) {
                    onDetachedFromService.onDetachedFromService();
                }
                this.f14166service = null;
                this.servicePluginBinding = null;
            } finally {
                TraceSection.end();
            }
        } else {
            Log.e(TAG, "Attempted to detach plugins from a Service when no Service was attached.");
        }
    }

    public FlutterPlugin get(@NonNull Class<? extends FlutterPlugin> cls) {
        return this.plugins.get(cls);
    }

    public boolean has(@NonNull Class<? extends FlutterPlugin> cls) {
        return this.plugins.containsKey(cls);
    }

    public boolean onActivityResult(int i11, int i12, @Nullable Intent intent) {
        if (isAttachedToActivity()) {
            TraceSection.begin("FlutterEngineConnectionRegistry#onActivityResult");
            try {
                return this.activityPluginBinding.a(i11, i12, intent);
            } finally {
                TraceSection.end();
            }
        } else {
            Log.e(TAG, "Attempted to notify ActivityAware plugins of onActivityResult, but no Activity was attached.");
            return false;
        }
    }

    public void onMoveToBackground() {
        if (isAttachedToService()) {
            TraceSection.begin("FlutterEngineConnectionRegistry#onMoveToBackground");
            try {
                this.servicePluginBinding.a();
            } finally {
                TraceSection.end();
            }
        }
    }

    public void onMoveToForeground() {
        if (isAttachedToService()) {
            TraceSection.begin("FlutterEngineConnectionRegistry#onMoveToForeground");
            try {
                this.servicePluginBinding.b();
            } finally {
                TraceSection.end();
            }
        }
    }

    public void onNewIntent(@NonNull Intent intent) {
        if (isAttachedToActivity()) {
            TraceSection.begin("FlutterEngineConnectionRegistry#onNewIntent");
            try {
                this.activityPluginBinding.b(intent);
            } finally {
                TraceSection.end();
            }
        } else {
            Log.e(TAG, "Attempted to notify ActivityAware plugins of onNewIntent, but no Activity was attached.");
        }
    }

    public boolean onRequestPermissionsResult(int i11, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (isAttachedToActivity()) {
            TraceSection.begin("FlutterEngineConnectionRegistry#onRequestPermissionsResult");
            try {
                return this.activityPluginBinding.c(i11, strArr, iArr);
            } finally {
                TraceSection.end();
            }
        } else {
            Log.e(TAG, "Attempted to notify ActivityAware plugins of onRequestPermissionsResult, but no Activity was attached.");
            return false;
        }
    }

    public void onRestoreInstanceState(@Nullable Bundle bundle) {
        if (isAttachedToActivity()) {
            TraceSection.begin("FlutterEngineConnectionRegistry#onRestoreInstanceState");
            try {
                this.activityPluginBinding.d(bundle);
            } finally {
                TraceSection.end();
            }
        } else {
            Log.e(TAG, "Attempted to notify ActivityAware plugins of onRestoreInstanceState, but no Activity was attached.");
        }
    }

    public void onSaveInstanceState(@NonNull Bundle bundle) {
        if (isAttachedToActivity()) {
            TraceSection.begin("FlutterEngineConnectionRegistry#onSaveInstanceState");
            try {
                this.activityPluginBinding.e(bundle);
            } finally {
                TraceSection.end();
            }
        } else {
            Log.e(TAG, "Attempted to notify ActivityAware plugins of onSaveInstanceState, but no Activity was attached.");
        }
    }

    public void onUserLeaveHint() {
        if (isAttachedToActivity()) {
            TraceSection.begin("FlutterEngineConnectionRegistry#onUserLeaveHint");
            try {
                this.activityPluginBinding.f();
            } finally {
                TraceSection.end();
            }
        } else {
            Log.e(TAG, "Attempted to notify ActivityAware plugins of onUserLeaveHint, but no Activity was attached.");
        }
    }

    public void remove(@NonNull Class<? extends FlutterPlugin> cls) {
        FlutterPlugin flutterPlugin = this.plugins.get(cls);
        if (flutterPlugin != null) {
            TraceSection.begin("FlutterEngineConnectionRegistry#remove " + cls.getSimpleName());
            try {
                if (flutterPlugin instanceof ActivityAware) {
                    if (isAttachedToActivity()) {
                        ((ActivityAware) flutterPlugin).onDetachedFromActivity();
                    }
                    this.activityAwarePlugins.remove(cls);
                }
                if (flutterPlugin instanceof ServiceAware) {
                    if (isAttachedToService()) {
                        ((ServiceAware) flutterPlugin).onDetachedFromService();
                    }
                    this.serviceAwarePlugins.remove(cls);
                }
                if (flutterPlugin instanceof BroadcastReceiverAware) {
                    if (isAttachedToBroadcastReceiver()) {
                        ((BroadcastReceiverAware) flutterPlugin).onDetachedFromBroadcastReceiver();
                    }
                    this.broadcastReceiverAwarePlugins.remove(cls);
                }
                if (flutterPlugin instanceof ContentProviderAware) {
                    if (isAttachedToContentProvider()) {
                        ((ContentProviderAware) flutterPlugin).onDetachedFromContentProvider();
                    }
                    this.contentProviderAwarePlugins.remove(cls);
                }
                flutterPlugin.onDetachedFromEngine(this.pluginBinding);
                this.plugins.remove(cls);
            } finally {
                TraceSection.end();
            }
        }
    }

    public void removeAll() {
        remove((Set<Class<? extends FlutterPlugin>>) new HashSet(this.plugins.keySet()));
        this.plugins.clear();
    }

    public void remove(@NonNull Set<Class<? extends FlutterPlugin>> set) {
        for (Class<? extends FlutterPlugin> remove : set) {
            remove(remove);
        }
    }

    public void add(@NonNull Set<FlutterPlugin> set) {
        for (FlutterPlugin add : set) {
            add(add);
        }
    }
}
