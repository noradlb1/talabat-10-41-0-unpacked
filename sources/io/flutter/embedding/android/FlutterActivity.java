package io.flutter.embedding.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.window.OnBackInvokedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.res.ResourcesCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.feature.nfvinvendorsearch.presentation.utils.Constants;
import io.flutter.Log;
import io.flutter.embedding.android.FlutterActivityAndFragmentDelegate;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterShellArgs;
import io.flutter.embedding.engine.plugins.util.GeneratedPluginRegister;
import io.flutter.plugin.platform.PlatformPlugin;
import io.flutter.util.ViewUtils;
import java.util.ArrayList;
import java.util.List;

@Instrumented
public class FlutterActivity extends Activity implements FlutterActivityAndFragmentDelegate.Host, LifecycleOwner, TraceFieldInterface {
    public static final int FLUTTER_VIEW_ID = ViewUtils.generateViewId(61938);
    private static final String TAG = "FlutterActivity";
    public Trace _nr_trace;
    @VisibleForTesting

    /* renamed from: b  reason: collision with root package name */
    public FlutterActivityAndFragmentDelegate f14124b;
    @NonNull
    private LifecycleRegistry lifecycle;
    private final OnBackInvokedCallback onBackInvokedCallback;

    public static class CachedEngineIntentBuilder {
        private final Class<? extends FlutterActivity> activityClass;
        private String backgroundMode = FlutterActivityLaunchConfigs.f14131a;
        private final String cachedEngineId;
        private boolean destroyEngineWithActivity = false;

        public CachedEngineIntentBuilder(@NonNull Class<? extends FlutterActivity> cls, @NonNull String str) {
            this.activityClass = cls;
            this.cachedEngineId = str;
        }

        @NonNull
        public CachedEngineIntentBuilder backgroundMode(@NonNull FlutterActivityLaunchConfigs.BackgroundMode backgroundMode2) {
            this.backgroundMode = backgroundMode2.name();
            return this;
        }

        @NonNull
        public Intent build(@NonNull Context context) {
            return new Intent(context, this.activityClass).putExtra("cached_engine_id", this.cachedEngineId).putExtra("destroy_engine_with_activity", this.destroyEngineWithActivity).putExtra(Constants.ARG_BACKGROUND_MODE, this.backgroundMode);
        }

        public CachedEngineIntentBuilder destroyEngineWithActivity(boolean z11) {
            this.destroyEngineWithActivity = z11;
            return this;
        }
    }

    public static class NewEngineIntentBuilder {
        private final Class<? extends FlutterActivity> activityClass;
        private String backgroundMode = FlutterActivityLaunchConfigs.f14131a;
        @Nullable
        private List<String> dartEntrypointArgs;
        private String initialRoute = "/";

        public NewEngineIntentBuilder(@NonNull Class<? extends FlutterActivity> cls) {
            this.activityClass = cls;
        }

        @NonNull
        public NewEngineIntentBuilder backgroundMode(@NonNull FlutterActivityLaunchConfigs.BackgroundMode backgroundMode2) {
            this.backgroundMode = backgroundMode2.name();
            return this;
        }

        @NonNull
        public Intent build(@NonNull Context context) {
            Intent putExtra = new Intent(context, this.activityClass).putExtra(Constants.ARG_ROUTE, this.initialRoute).putExtra(Constants.ARG_BACKGROUND_MODE, this.backgroundMode).putExtra("destroy_engine_with_activity", true);
            if (this.dartEntrypointArgs != null) {
                putExtra.putExtra("dart_entrypoint_args", new ArrayList(this.dartEntrypointArgs));
            }
            return putExtra;
        }

        @NonNull
        public NewEngineIntentBuilder dartEntrypointArgs(@Nullable List<String> list) {
            this.dartEntrypointArgs = list;
            return this;
        }

        @NonNull
        public NewEngineIntentBuilder initialRoute(@NonNull String str) {
            this.initialRoute = str;
            return this;
        }
    }

    public FlutterActivity() {
        AnonymousClass1 r02;
        if (Build.VERSION.SDK_INT >= 33) {
            r02 = new OnBackInvokedCallback() {
                public void onBackInvoked() {
                    FlutterActivity.this.onBackPressed();
                }
            };
        } else {
            r02 = null;
        }
        this.onBackInvokedCallback = r02;
        this.lifecycle = new LifecycleRegistry(this);
    }

    private void configureStatusBarForFullscreenFlutterExperience() {
        Window window = getWindow();
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(1073741824);
        window.getDecorView().setSystemUiVisibility(PlatformPlugin.DEFAULT_SYSTEM_UI);
    }

    private void configureWindowForTransparency() {
        if (a() == FlutterActivityLaunchConfigs.BackgroundMode.transparent) {
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
    }

    @NonNull
    public static Intent createDefaultIntent(@NonNull Context context) {
        return withNewEngine().build(context);
    }

    @NonNull
    private View createFlutterView() {
        boolean z11;
        FlutterActivityAndFragmentDelegate flutterActivityAndFragmentDelegate = this.f14124b;
        int i11 = FLUTTER_VIEW_ID;
        if (getRenderMode() == RenderMode.surface) {
            z11 = true;
        } else {
            z11 = false;
        }
        return flutterActivityAndFragmentDelegate.k((LayoutInflater) null, (ViewGroup) null, (Bundle) null, i11, z11);
    }

    @Nullable
    private Drawable getSplashScreenFromManifest() {
        int i11;
        try {
            Bundle c11 = c();
            if (c11 != null) {
                i11 = c11.getInt("io.flutter.embedding.android.SplashScreenDrawable");
            } else {
                i11 = 0;
            }
            if (i11 != 0) {
                return ResourcesCompat.getDrawable(getResources(), i11, getTheme());
            }
            return null;
        } catch (Resources.NotFoundException e11) {
            Log.e(TAG, "Splash screen not found. Ensure the drawable exists and that it's valid.");
            throw e11;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private boolean isDebuggable() {
        return (getApplicationInfo().flags & 2) != 0;
    }

    private boolean stillAttachedForEvent(String str) {
        FlutterActivityAndFragmentDelegate flutterActivityAndFragmentDelegate = this.f14124b;
        if (flutterActivityAndFragmentDelegate == null) {
            Log.w(TAG, "FlutterActivity " + hashCode() + " " + str + " called after release.");
            return false;
        } else if (flutterActivityAndFragmentDelegate.f()) {
            return true;
        } else {
            Log.w(TAG, "FlutterActivity " + hashCode() + " " + str + " called after detach.");
            return false;
        }
    }

    private void switchLaunchThemeForNormalTheme() {
        try {
            Bundle c11 = c();
            if (c11 != null) {
                int i11 = c11.getInt("io.flutter.embedding.android.NormalTheme", -1);
                if (i11 != -1) {
                    setTheme(i11);
                    return;
                }
                return;
            }
            Log.v(TAG, "Using the launch theme as normal theme.");
        } catch (PackageManager.NameNotFoundException unused) {
            Log.e(TAG, "Could not read meta-data for FlutterActivity. Using the launch theme as normal theme.");
        }
    }

    public static CachedEngineIntentBuilder withCachedEngine(@NonNull String str) {
        return new CachedEngineIntentBuilder(FlutterActivity.class, str);
    }

    @NonNull
    public static NewEngineIntentBuilder withNewEngine() {
        return new NewEngineIntentBuilder(FlutterActivity.class);
    }

    @NonNull
    public FlutterActivityLaunchConfigs.BackgroundMode a() {
        if (getIntent().hasExtra(Constants.ARG_BACKGROUND_MODE)) {
            return FlutterActivityLaunchConfigs.BackgroundMode.valueOf(getIntent().getStringExtra(Constants.ARG_BACKGROUND_MODE));
        }
        return FlutterActivityLaunchConfigs.BackgroundMode.opaque;
    }

    @Nullable
    public FlutterEngine b() {
        return this.f14124b.e();
    }

    @Nullable
    public Bundle c() throws PackageManager.NameNotFoundException {
        return getPackageManager().getActivityInfo(getComponentName(), 128).metaData;
    }

    public void cleanUpFlutterEngine(@NonNull FlutterEngine flutterEngine) {
    }

    public void configureFlutterEngine(@NonNull FlutterEngine flutterEngine) {
        if (!this.f14124b.g()) {
            GeneratedPluginRegister.registerGeneratedPlugins(flutterEngine);
        }
    }

    public void detachFromFlutterEngine() {
        Log.w(TAG, "FlutterActivity " + this + " connection to the engine " + b() + " evicted by another attaching activity");
        FlutterActivityAndFragmentDelegate flutterActivityAndFragmentDelegate = this.f14124b;
        if (flutterActivityAndFragmentDelegate != null) {
            flutterActivityAndFragmentDelegate.l();
            this.f14124b.m();
        }
    }

    @NonNull
    public Activity getActivity() {
        return this;
    }

    @NonNull
    public String getAppBundlePath() {
        String dataString;
        if (!isDebuggable() || !"android.intent.action.RUN".equals(getIntent().getAction()) || (dataString = getIntent().getDataString()) == null) {
            return null;
        }
        return dataString;
    }

    @Nullable
    public String getCachedEngineId() {
        return getIntent().getStringExtra("cached_engine_id");
    }

    @NonNull
    public Context getContext() {
        return this;
    }

    @Nullable
    public List<String> getDartEntrypointArgs() {
        return (List) getIntent().getSerializableExtra("dart_entrypoint_args");
    }

    @NonNull
    public String getDartEntrypointFunctionName() {
        String str;
        try {
            Bundle c11 = c();
            if (c11 != null) {
                str = c11.getString("io.flutter.Entrypoint");
            } else {
                str = null;
            }
            if (str != null) {
                return str;
            }
            return "main";
        } catch (PackageManager.NameNotFoundException unused) {
            return "main";
        }
    }

    @Nullable
    public String getDartEntrypointLibraryUri() {
        try {
            Bundle c11 = c();
            if (c11 != null) {
                return c11.getString("io.flutter.EntrypointUri");
            }
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public ExclusiveAppComponent<Activity> getExclusiveAppComponent() {
        return this.f14124b;
    }

    @NonNull
    public FlutterShellArgs getFlutterShellArgs() {
        return FlutterShellArgs.fromIntent(getIntent());
    }

    public String getInitialRoute() {
        if (getIntent().hasExtra(Constants.ARG_ROUTE)) {
            return getIntent().getStringExtra(Constants.ARG_ROUTE);
        }
        try {
            Bundle c11 = c();
            if (c11 != null) {
                return c11.getString("io.flutter.InitialRoute");
            }
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @NonNull
    public Lifecycle getLifecycle() {
        return this.lifecycle;
    }

    @NonNull
    public RenderMode getRenderMode() {
        return a() == FlutterActivityLaunchConfigs.BackgroundMode.opaque ? RenderMode.surface : RenderMode.texture;
    }

    @NonNull
    public TransparencyMode getTransparencyMode() {
        if (a() == FlutterActivityLaunchConfigs.BackgroundMode.opaque) {
            return TransparencyMode.opaque;
        }
        return TransparencyMode.transparent;
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        if (stillAttachedForEvent("onActivityResult")) {
            this.f14124b.h(i11, i12, intent);
        }
    }

    public void onBackPressed() {
        if (stillAttachedForEvent("onBackPressed")) {
            this.f14124b.j();
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        TraceMachine.startTracing(TAG);
        try {
            TraceMachine.enterMethod(this._nr_trace, "FlutterActivity#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "FlutterActivity#onCreate", (ArrayList<String>) null);
        }
        switchLaunchThemeForNormalTheme();
        super.onCreate(bundle);
        FlutterActivityAndFragmentDelegate flutterActivityAndFragmentDelegate = new FlutterActivityAndFragmentDelegate(this);
        this.f14124b = flutterActivityAndFragmentDelegate;
        flutterActivityAndFragmentDelegate.i(this);
        this.f14124b.r(bundle);
        this.lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        registerOnBackInvokedCallback();
        configureWindowForTransparency();
        setContentView(createFlutterView());
        configureStatusBarForFullscreenFlutterExperience();
        TraceMachine.exitMethod();
    }

    public void onDestroy() {
        super.onDestroy();
        if (stillAttachedForEvent("onDestroy")) {
            this.f14124b.l();
            this.f14124b.m();
        }
        release();
        this.lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
    }

    public void onFlutterSurfaceViewCreated(@NonNull FlutterSurfaceView flutterSurfaceView) {
    }

    public void onFlutterTextureViewCreated(@NonNull FlutterTextureView flutterTextureView) {
    }

    public void onFlutterUiDisplayed() {
        if (Build.VERSION.SDK_INT >= 29) {
            reportFullyDrawn();
        }
    }

    public void onFlutterUiNoLongerDisplayed() {
    }

    public void onNewIntent(@NonNull Intent intent) {
        super.onNewIntent(intent);
        if (stillAttachedForEvent("onNewIntent")) {
            this.f14124b.n(intent);
        }
    }

    public void onPause() {
        super.onPause();
        if (stillAttachedForEvent("onPause")) {
            this.f14124b.o();
        }
        this.lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    }

    public void onPostResume() {
        super.onPostResume();
        if (stillAttachedForEvent("onPostResume")) {
            this.f14124b.p();
        }
    }

    public void onRequestPermissionsResult(int i11, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (stillAttachedForEvent("onRequestPermissionsResult")) {
            this.f14124b.q(i11, strArr, iArr);
        }
    }

    public void onResume() {
        super.onResume();
        this.lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        if (stillAttachedForEvent("onResume")) {
            this.f14124b.s();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (stillAttachedForEvent("onSaveInstanceState")) {
            this.f14124b.t(bundle);
        }
    }

    public void onStart() {
        ApplicationStateMonitor.getInstance().activityStarted();
        super.onStart();
        this.lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_START);
        if (stillAttachedForEvent("onStart")) {
            this.f14124b.u();
        }
    }

    public void onStop() {
        ApplicationStateMonitor.getInstance().activityStopped();
        super.onStop();
        if (stillAttachedForEvent("onStop")) {
            this.f14124b.v();
        }
        this.lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
    }

    public void onTrimMemory(int i11) {
        super.onTrimMemory(i11);
        if (stillAttachedForEvent("onTrimMemory")) {
            this.f14124b.w(i11);
        }
    }

    public void onUserLeaveHint() {
        if (stillAttachedForEvent("onUserLeaveHint")) {
            this.f14124b.x();
        }
    }

    public boolean popSystemNavigator() {
        return false;
    }

    @Nullable
    public FlutterEngine provideFlutterEngine(@NonNull Context context) {
        return null;
    }

    @Nullable
    public PlatformPlugin providePlatformPlugin(@Nullable Activity activity, @NonNull FlutterEngine flutterEngine) {
        return new PlatformPlugin(getActivity(), flutterEngine.getPlatformChannel(), this);
    }

    @Nullable
    public SplashScreen provideSplashScreen() {
        Drawable splashScreenFromManifest = getSplashScreenFromManifest();
        if (splashScreenFromManifest != null) {
            return new DrawableSplashScreen(splashScreenFromManifest);
        }
        return null;
    }

    @VisibleForTesting
    public void registerOnBackInvokedCallback() {
        if (Build.VERSION.SDK_INT >= 33) {
            getOnBackInvokedDispatcher().registerOnBackInvokedCallback(0, this.onBackInvokedCallback);
        }
    }

    @VisibleForTesting
    public void release() {
        unregisterOnBackInvokedCallback();
        FlutterActivityAndFragmentDelegate flutterActivityAndFragmentDelegate = this.f14124b;
        if (flutterActivityAndFragmentDelegate != null) {
            flutterActivityAndFragmentDelegate.y();
            this.f14124b = null;
        }
    }

    public boolean shouldAttachEngineToActivity() {
        return true;
    }

    public boolean shouldDestroyEngineWithHost() {
        boolean booleanExtra = getIntent().getBooleanExtra("destroy_engine_with_activity", false);
        if (getCachedEngineId() != null || this.f14124b.g()) {
            return booleanExtra;
        }
        return getIntent().getBooleanExtra("destroy_engine_with_activity", true);
    }

    public boolean shouldDispatchAppLifecycleState() {
        return true;
    }

    public boolean shouldHandleDeeplinking() {
        try {
            Bundle c11 = c();
            if (c11 != null) {
                return c11.getBoolean("flutter_deeplinking_enabled");
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public boolean shouldRestoreAndSaveState() {
        if (getIntent().hasExtra("enable_state_restoration")) {
            return getIntent().getBooleanExtra("enable_state_restoration", false);
        }
        if (getCachedEngineId() != null) {
            return false;
        }
        return true;
    }

    @VisibleForTesting
    public void unregisterOnBackInvokedCallback() {
        if (Build.VERSION.SDK_INT >= 33) {
            getOnBackInvokedDispatcher().unregisterOnBackInvokedCallback(this.onBackInvokedCallback);
        }
    }

    public void updateSystemUiOverlays() {
        FlutterActivityAndFragmentDelegate flutterActivityAndFragmentDelegate = this.f14124b;
        if (flutterActivityAndFragmentDelegate != null) {
            flutterActivityAndFragmentDelegate.A();
        }
    }
}
