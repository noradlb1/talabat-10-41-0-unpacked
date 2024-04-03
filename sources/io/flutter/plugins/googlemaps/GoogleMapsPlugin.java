package io.flutter.plugins.googlemaps;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.embedding.engine.plugins.lifecycle.FlutterLifecycleAdapter;
import io.flutter.plugin.common.PluginRegistry;

public class GoogleMapsPlugin implements FlutterPlugin, ActivityAware {
    private static final String VIEW_TYPE = "plugins.flutter.io/google_maps";
    /* access modifiers changed from: private */
    @Nullable
    public Lifecycle lifecycle;

    public static final class ProxyLifecycleProvider implements Application.ActivityLifecycleCallbacks, LifecycleOwner, LifecycleProvider {
        private final LifecycleRegistry lifecycle;
        private final int registrarActivityHashCode;

        @NonNull
        public Lifecycle getLifecycle() {
            return this.lifecycle;
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (activity.hashCode() == this.registrarActivityHashCode) {
                this.lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
            }
        }

        public void onActivityDestroyed(Activity activity) {
            if (activity.hashCode() == this.registrarActivityHashCode) {
                activity.getApplication().unregisterActivityLifecycleCallbacks(this);
                this.lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
            }
        }

        public void onActivityPaused(Activity activity) {
            if (activity.hashCode() == this.registrarActivityHashCode) {
                this.lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
            }
        }

        public void onActivityResumed(Activity activity) {
            if (activity.hashCode() == this.registrarActivityHashCode) {
                this.lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
            }
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
            if (activity.hashCode() == this.registrarActivityHashCode) {
                this.lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_START);
            }
        }

        public void onActivityStopped(Activity activity) {
            if (activity.hashCode() == this.registrarActivityHashCode) {
                this.lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
            }
        }

        private ProxyLifecycleProvider(Activity activity) {
            this.lifecycle = new LifecycleRegistry(this);
            this.registrarActivityHashCode = activity.hashCode();
            activity.getApplication().registerActivityLifecycleCallbacks(this);
        }
    }

    public static void registerWith(PluginRegistry.Registrar registrar) {
        final Activity activity = registrar.activity();
        if (activity != null) {
            if (activity instanceof LifecycleOwner) {
                registrar.platformViewRegistry().registerViewFactory(VIEW_TYPE, new GoogleMapFactory(registrar.messenger(), new LifecycleProvider() {
                    public Lifecycle getLifecycle() {
                        return ((LifecycleOwner) activity).getLifecycle();
                    }
                }));
            } else {
                registrar.platformViewRegistry().registerViewFactory(VIEW_TYPE, new GoogleMapFactory(registrar.messenger(), new ProxyLifecycleProvider(activity)));
            }
        }
    }

    public void onAttachedToActivity(ActivityPluginBinding activityPluginBinding) {
        this.lifecycle = FlutterLifecycleAdapter.getActivityLifecycle(activityPluginBinding);
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        flutterPluginBinding.getPlatformViewRegistry().registerViewFactory(VIEW_TYPE, new GoogleMapFactory(flutterPluginBinding.getBinaryMessenger(), new LifecycleProvider() {
            @Nullable
            public Lifecycle getLifecycle() {
                return GoogleMapsPlugin.this.lifecycle;
            }
        }));
    }

    public void onDetachedFromActivity() {
        this.lifecycle = null;
    }

    public void onDetachedFromActivityForConfigChanges() {
        onDetachedFromActivity();
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
    }

    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding) {
        onAttachedToActivity(activityPluginBinding);
    }
}
