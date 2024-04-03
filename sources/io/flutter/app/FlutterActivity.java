package io.flutter.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import io.flutter.app.FlutterActivityDelegate;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.view.FlutterNativeView;
import io.flutter.view.FlutterView;
import java.util.ArrayList;

@Instrumented
@Deprecated
public class FlutterActivity extends Activity implements FlutterView.Provider, PluginRegistry, FlutterActivityDelegate.ViewFactory, TraceFieldInterface {
    private static final String TAG = "FlutterActivity";
    public Trace _nr_trace;
    private final FlutterActivityDelegate delegate;
    private final FlutterActivityEvents eventDelegate;
    private final PluginRegistry pluginRegistry;
    private final FlutterView.Provider viewProvider;

    public FlutterActivity() {
        FlutterActivityDelegate flutterActivityDelegate = new FlutterActivityDelegate(this, this);
        this.delegate = flutterActivityDelegate;
        this.eventDelegate = flutterActivityDelegate;
        this.viewProvider = flutterActivityDelegate;
        this.pluginRegistry = flutterActivityDelegate;
    }

    public FlutterNativeView createFlutterNativeView() {
        return null;
    }

    public FlutterView createFlutterView(Context context) {
        return null;
    }

    public FlutterView getFlutterView() {
        return this.viewProvider.getFlutterView();
    }

    public final boolean hasPlugin(String str) {
        return this.pluginRegistry.hasPlugin(str);
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        if (!this.eventDelegate.onActivityResult(i11, i12, intent)) {
            super.onActivityResult(i11, i12, intent);
        }
    }

    public void onBackPressed() {
        if (!this.eventDelegate.onBackPressed()) {
            super.onBackPressed();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.eventDelegate.onConfigurationChanged(configuration);
    }

    public void onCreate(Bundle bundle) {
        TraceMachine.startTracing(TAG);
        try {
            TraceMachine.enterMethod(this._nr_trace, "FlutterActivity#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "FlutterActivity#onCreate", (ArrayList<String>) null);
        }
        super.onCreate(bundle);
        this.eventDelegate.onCreate(bundle);
        TraceMachine.exitMethod();
    }

    public void onDestroy() {
        this.eventDelegate.onDestroy();
        super.onDestroy();
    }

    public void onLowMemory() {
        this.eventDelegate.onLowMemory();
    }

    public void onNewIntent(Intent intent) {
        this.eventDelegate.onNewIntent(intent);
    }

    public void onPause() {
        super.onPause();
        this.eventDelegate.onPause();
    }

    public void onPostResume() {
        super.onPostResume();
        this.eventDelegate.onPostResume();
    }

    public void onRequestPermissionsResult(int i11, @NonNull String[] strArr, @NonNull int[] iArr) {
        this.eventDelegate.onRequestPermissionsResult(i11, strArr, iArr);
    }

    public void onResume() {
        super.onResume();
        this.eventDelegate.onResume();
    }

    public void onStart() {
        ApplicationStateMonitor.getInstance().activityStarted();
        super.onStart();
        this.eventDelegate.onStart();
    }

    public void onStop() {
        ApplicationStateMonitor.getInstance().activityStopped();
        this.eventDelegate.onStop();
        super.onStop();
    }

    public void onTrimMemory(int i11) {
        this.eventDelegate.onTrimMemory(i11);
    }

    public void onUserLeaveHint() {
        this.eventDelegate.onUserLeaveHint();
    }

    public final PluginRegistry.Registrar registrarFor(String str) {
        return this.pluginRegistry.registrarFor(str);
    }

    public boolean retainFlutterNativeView() {
        return false;
    }

    public final <T> T valuePublishedByPlugin(String str) {
        return this.pluginRegistry.valuePublishedByPlugin(str);
    }
}
