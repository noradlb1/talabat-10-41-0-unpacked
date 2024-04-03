package io.flutter.embedding.android;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.feature.nfvinvendorsearch.presentation.utils.Constants;
import io.flutter.Log;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterShellArgs;
import io.flutter.embedding.engine.plugins.util.GeneratedPluginRegister;
import io.flutter.plugin.platform.PlatformPlugin;
import io.flutter.util.ViewUtils;
import java.util.ArrayList;
import java.util.List;

@Instrumented
public class FlutterFragmentActivity extends FragmentActivity implements SplashScreenProvider, FlutterEngineProvider, FlutterEngineConfigurator, TraceFieldInterface {
    public static final int FRAGMENT_CONTAINER_ID = ViewUtils.generateViewId(609893468);
    private static final String TAG = "FlutterFragmentActivity";
    private static final String TAG_FLUTTER_FRAGMENT = "flutter_fragment";
    public Trace _nr_trace;
    @Nullable
    private FlutterFragment flutterFragment;

    public static class CachedEngineIntentBuilder {
        private final Class<? extends FlutterFragmentActivity> activityClass;
        private String backgroundMode = FlutterActivityLaunchConfigs.f14131a;
        private final String cachedEngineId;
        private boolean destroyEngineWithActivity = false;

        public CachedEngineIntentBuilder(@NonNull Class<? extends FlutterFragmentActivity> cls, @NonNull String str) {
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
        private final Class<? extends FlutterFragmentActivity> activityClass;
        private String backgroundMode = FlutterActivityLaunchConfigs.f14131a;
        @Nullable
        private List<String> dartEntrypointArgs;
        private String initialRoute = "/";

        public NewEngineIntentBuilder(@NonNull Class<? extends FlutterFragmentActivity> cls) {
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

    private void configureStatusBarForFullscreenFlutterExperience() {
        Window window = getWindow();
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(1073741824);
        window.getDecorView().setSystemUiVisibility(PlatformPlugin.DEFAULT_SYSTEM_UI);
    }

    private void configureWindowForTransparency() {
        if (O() == FlutterActivityLaunchConfigs.BackgroundMode.transparent) {
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
    }

    @NonNull
    public static Intent createDefaultIntent(@NonNull Context context) {
        return withNewEngine().build(context);
    }

    @NonNull
    private View createFragmentContainer() {
        FrameLayout R = R(this);
        R.setId(FRAGMENT_CONTAINER_ID);
        R.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return R;
    }

    private void ensureFlutterFragmentCreated() {
        if (this.flutterFragment == null) {
            this.flutterFragment = S();
        }
        if (this.flutterFragment == null) {
            this.flutterFragment = N();
            getSupportFragmentManager().beginTransaction().add(FRAGMENT_CONTAINER_ID, (Fragment) this.flutterFragment, TAG_FLUTTER_FRAGMENT).commit();
        }
    }

    @Nullable
    private Drawable getSplashScreenFromManifest() {
        int i11;
        try {
            Bundle Q = Q();
            if (Q != null) {
                i11 = Q.getInt("io.flutter.embedding.android.SplashScreenDrawable");
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

    private void switchLaunchThemeForNormalTheme() {
        try {
            Bundle Q = Q();
            if (Q != null) {
                int i11 = Q.getInt("io.flutter.embedding.android.NormalTheme", -1);
                if (i11 != -1) {
                    setTheme(i11);
                    return;
                }
                return;
            }
            Log.v(TAG, "Using the launch theme as normal theme.");
        } catch (PackageManager.NameNotFoundException unused) {
            Log.e(TAG, "Could not read meta-data for FlutterFragmentActivity. Using the launch theme as normal theme.");
        }
    }

    @NonNull
    public static CachedEngineIntentBuilder withCachedEngine(@NonNull String str) {
        return new CachedEngineIntentBuilder(FlutterFragmentActivity.class, str);
    }

    @NonNull
    public static NewEngineIntentBuilder withNewEngine() {
        return new NewEngineIntentBuilder(FlutterFragmentActivity.class);
    }

    @NonNull
    public FlutterFragment N() {
        TransparencyMode transparencyMode;
        boolean z11;
        String str;
        FlutterActivityLaunchConfigs.BackgroundMode O = O();
        RenderMode renderMode = getRenderMode();
        if (O == FlutterActivityLaunchConfigs.BackgroundMode.opaque) {
            transparencyMode = TransparencyMode.opaque;
        } else {
            transparencyMode = TransparencyMode.transparent;
        }
        if (renderMode == RenderMode.surface) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (getCachedEngineId() != null) {
            Log.v(TAG, "Creating FlutterFragment with cached engine:\nCached engine ID: " + getCachedEngineId() + "\nWill destroy engine when Activity is destroyed: " + shouldDestroyEngineWithHost() + "\nBackground transparency mode: " + O + "\nWill attach FlutterEngine to Activity: " + shouldAttachEngineToActivity());
            return FlutterFragment.withCachedEngine(getCachedEngineId()).renderMode(renderMode).transparencyMode(transparencyMode).handleDeeplinking(Boolean.valueOf(shouldHandleDeeplinking())).shouldAttachEngineToActivity(shouldAttachEngineToActivity()).destroyEngineWithFragment(shouldDestroyEngineWithHost()).shouldDelayFirstAndroidViewDraw(z11).build();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Creating FlutterFragment with new engine:\nBackground transparency mode: ");
        sb2.append(O);
        sb2.append("\nDart entrypoint: ");
        sb2.append(getDartEntrypointFunctionName());
        sb2.append("\nDart entrypoint library uri: ");
        if (getDartEntrypointLibraryUri() != null) {
            str = getDartEntrypointLibraryUri();
        } else {
            str = "\"\"";
        }
        sb2.append(str);
        sb2.append("\nInitial route: ");
        sb2.append(getInitialRoute());
        sb2.append("\nApp bundle path: ");
        sb2.append(getAppBundlePath());
        sb2.append("\nWill attach FlutterEngine to Activity: ");
        sb2.append(shouldAttachEngineToActivity());
        Log.v(TAG, sb2.toString());
        return FlutterFragment.withNewEngine().dartEntrypoint(getDartEntrypointFunctionName()).dartLibraryUri(getDartEntrypointLibraryUri()).dartEntrypointArgs(getDartEntrypointArgs()).initialRoute(getInitialRoute()).appBundlePath(getAppBundlePath()).flutterShellArgs(FlutterShellArgs.fromIntent(getIntent())).handleDeeplinking(Boolean.valueOf(shouldHandleDeeplinking())).renderMode(renderMode).transparencyMode(transparencyMode).shouldAttachEngineToActivity(shouldAttachEngineToActivity()).shouldDelayFirstAndroidViewDraw(z11).build();
    }

    @NonNull
    public FlutterActivityLaunchConfigs.BackgroundMode O() {
        if (getIntent().hasExtra(Constants.ARG_BACKGROUND_MODE)) {
            return FlutterActivityLaunchConfigs.BackgroundMode.valueOf(getIntent().getStringExtra(Constants.ARG_BACKGROUND_MODE));
        }
        return FlutterActivityLaunchConfigs.BackgroundMode.opaque;
    }

    @Nullable
    public FlutterEngine P() {
        return this.flutterFragment.getFlutterEngine();
    }

    @Nullable
    public Bundle Q() throws PackageManager.NameNotFoundException {
        return getPackageManager().getActivityInfo(getComponentName(), 128).metaData;
    }

    @NonNull
    public FrameLayout R(Context context) {
        return new FrameLayout(context);
    }

    @VisibleForTesting
    public FlutterFragment S() {
        return (FlutterFragment) getSupportFragmentManager().findFragmentByTag(TAG_FLUTTER_FRAGMENT);
    }

    public void cleanUpFlutterEngine(@NonNull FlutterEngine flutterEngine) {
    }

    public void configureFlutterEngine(@NonNull FlutterEngine flutterEngine) {
        FlutterFragment flutterFragment2 = this.flutterFragment;
        if (flutterFragment2 == null || !flutterFragment2.i0()) {
            GeneratedPluginRegister.registerGeneratedPlugins(flutterEngine);
        }
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

    @Nullable
    public List<String> getDartEntrypointArgs() {
        return (List) getIntent().getSerializableExtra("dart_entrypoint_args");
    }

    @NonNull
    public String getDartEntrypointFunctionName() {
        String str;
        try {
            Bundle Q = Q();
            if (Q != null) {
                str = Q.getString("io.flutter.Entrypoint");
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
            Bundle Q = Q();
            if (Q != null) {
                return Q.getString("io.flutter.EntrypointUri");
            }
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public String getInitialRoute() {
        if (getIntent().hasExtra(Constants.ARG_ROUTE)) {
            return getIntent().getStringExtra(Constants.ARG_ROUTE);
        }
        try {
            Bundle Q = Q();
            if (Q != null) {
                return Q.getString("io.flutter.InitialRoute");
            }
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @NonNull
    public RenderMode getRenderMode() {
        if (O() == FlutterActivityLaunchConfigs.BackgroundMode.opaque) {
            return RenderMode.surface;
        }
        return RenderMode.texture;
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        this.flutterFragment.onActivityResult(i11, i12, intent);
    }

    public void onBackPressed() {
        this.flutterFragment.onBackPressed();
    }

    public void onCreate(@Nullable Bundle bundle) {
        TraceMachine.startTracing(TAG);
        try {
            TraceMachine.enterMethod(this._nr_trace, "FlutterFragmentActivity#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "FlutterFragmentActivity#onCreate", (ArrayList<String>) null);
        }
        switchLaunchThemeForNormalTheme();
        this.flutterFragment = S();
        super.onCreate(bundle);
        configureWindowForTransparency();
        setContentView(createFragmentContainer());
        configureStatusBarForFullscreenFlutterExperience();
        ensureFlutterFragmentCreated();
        TraceMachine.exitMethod();
    }

    public void onNewIntent(@NonNull Intent intent) {
        this.flutterFragment.onNewIntent(intent);
        super.onNewIntent(intent);
    }

    public void onPostResume() {
        super.onPostResume();
        this.flutterFragment.onPostResume();
    }

    public void onRequestPermissionsResult(int i11, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i11, strArr, iArr);
        this.flutterFragment.onRequestPermissionsResult(i11, strArr, iArr);
    }

    public void onStart() {
        super.onStart();
        ApplicationStateMonitor.getInstance().activityStarted();
    }

    public void onStop() {
        super.onStop();
        ApplicationStateMonitor.getInstance().activityStopped();
    }

    public void onTrimMemory(int i11) {
        super.onTrimMemory(i11);
        this.flutterFragment.onTrimMemory(i11);
    }

    public void onUserLeaveHint() {
        this.flutterFragment.onUserLeaveHint();
    }

    @Nullable
    public FlutterEngine provideFlutterEngine(@NonNull Context context) {
        return null;
    }

    @Nullable
    public SplashScreen provideSplashScreen() {
        Drawable splashScreenFromManifest = getSplashScreenFromManifest();
        if (splashScreenFromManifest != null) {
            return new DrawableSplashScreen(splashScreenFromManifest);
        }
        return null;
    }

    public boolean shouldAttachEngineToActivity() {
        return true;
    }

    public boolean shouldDestroyEngineWithHost() {
        return getIntent().getBooleanExtra("destroy_engine_with_activity", false);
    }

    @VisibleForTesting
    public boolean shouldHandleDeeplinking() {
        try {
            Bundle Q = Q();
            if (Q != null) {
                return Q.getBoolean("flutter_deeplinking_enabled");
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }
}
