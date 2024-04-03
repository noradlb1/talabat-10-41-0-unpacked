package io.flutter.embedding.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.Lifecycle;
import io.flutter.FlutterInjector;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterEngineCache;
import io.flutter.embedding.engine.FlutterShellArgs;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
import io.flutter.plugin.platform.PlatformPlugin;
import io.flutter.util.ViewUtils;
import java.util.Arrays;
import java.util.List;
import net.bytebuddy.description.type.TypeDescription;

class FlutterActivityAndFragmentDelegate implements ExclusiveAppComponent<Activity> {
    private static final int FLUTTER_SPLASH_VIEW_FALLBACK_ID = 486947586;
    private static final String FRAMEWORK_RESTORATION_BUNDLE_KEY = "framework";
    private static final String PLUGINS_RESTORATION_BUNDLE_KEY = "plugins";
    private static final String TAG = "FlutterActivityAndFragmentDelegate";
    @VisibleForTesting
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public FlutterView f14126a;
    @VisibleForTesting
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public ViewTreeObserver.OnPreDrawListener f14127b;
    @Nullable
    private FlutterEngine flutterEngine;
    @NonNull
    private final FlutterUiDisplayListener flutterUiDisplayListener = new FlutterUiDisplayListener() {
        public void onFlutterUiDisplayed() {
            FlutterActivityAndFragmentDelegate.this.host.onFlutterUiDisplayed();
            boolean unused = FlutterActivityAndFragmentDelegate.this.isFlutterUiDisplayed = true;
            boolean unused2 = FlutterActivityAndFragmentDelegate.this.isFirstFrameRendered = true;
        }

        public void onFlutterUiNoLongerDisplayed() {
            FlutterActivityAndFragmentDelegate.this.host.onFlutterUiNoLongerDisplayed();
            boolean unused = FlutterActivityAndFragmentDelegate.this.isFlutterUiDisplayed = false;
        }
    };
    /* access modifiers changed from: private */
    @NonNull
    public Host host;
    private boolean isAttached;
    /* access modifiers changed from: private */
    public boolean isFirstFrameRendered;
    private boolean isFlutterEngineFromHost;
    /* access modifiers changed from: private */
    public boolean isFlutterUiDisplayed;
    @Nullable
    private PlatformPlugin platformPlugin;
    private Integer previousVisibility;

    public interface DelegateFactory {
        FlutterActivityAndFragmentDelegate createDelegate(Host host);
    }

    public interface Host extends SplashScreenProvider, FlutterEngineProvider, FlutterEngineConfigurator, PlatformPlugin.PlatformPluginDelegate {
        void cleanUpFlutterEngine(@NonNull FlutterEngine flutterEngine);

        void configureFlutterEngine(@NonNull FlutterEngine flutterEngine);

        void detachFromFlutterEngine();

        @Nullable
        Activity getActivity();

        @NonNull
        String getAppBundlePath();

        @Nullable
        String getCachedEngineId();

        @NonNull
        Context getContext();

        @Nullable
        List<String> getDartEntrypointArgs();

        @NonNull
        String getDartEntrypointFunctionName();

        @Nullable
        String getDartEntrypointLibraryUri();

        ExclusiveAppComponent<Activity> getExclusiveAppComponent();

        @NonNull
        FlutterShellArgs getFlutterShellArgs();

        @Nullable
        String getInitialRoute();

        @NonNull
        Lifecycle getLifecycle();

        @NonNull
        RenderMode getRenderMode();

        @NonNull
        TransparencyMode getTransparencyMode();

        void onFlutterSurfaceViewCreated(@NonNull FlutterSurfaceView flutterSurfaceView);

        void onFlutterTextureViewCreated(@NonNull FlutterTextureView flutterTextureView);

        void onFlutterUiDisplayed();

        void onFlutterUiNoLongerDisplayed();

        @Nullable
        FlutterEngine provideFlutterEngine(@NonNull Context context);

        @Nullable
        PlatformPlugin providePlatformPlugin(@Nullable Activity activity, @NonNull FlutterEngine flutterEngine);

        @Nullable
        SplashScreen provideSplashScreen();

        boolean shouldAttachEngineToActivity();

        boolean shouldDestroyEngineWithHost();

        boolean shouldDispatchAppLifecycleState();

        @Nullable
        boolean shouldHandleDeeplinking();

        boolean shouldRestoreAndSaveState();

        void updateSystemUiOverlays();
    }

    public FlutterActivityAndFragmentDelegate(@NonNull Host host2) {
        this.host = host2;
        this.isFirstFrameRendered = false;
    }

    private void delayFirstAndroidViewDraw(final FlutterView flutterView) {
        if (this.host.getRenderMode() == RenderMode.surface) {
            if (this.f14127b != null) {
                flutterView.getViewTreeObserver().removeOnPreDrawListener(this.f14127b);
            }
            this.f14127b = new ViewTreeObserver.OnPreDrawListener() {
                public boolean onPreDraw() {
                    if (FlutterActivityAndFragmentDelegate.this.isFlutterUiDisplayed && FlutterActivityAndFragmentDelegate.this.f14127b != null) {
                        flutterView.getViewTreeObserver().removeOnPreDrawListener(this);
                        FlutterActivityAndFragmentDelegate.this.f14127b = null;
                    }
                    return FlutterActivityAndFragmentDelegate.this.isFlutterUiDisplayed;
                }
            };
            flutterView.getViewTreeObserver().addOnPreDrawListener(this.f14127b);
            return;
        }
        throw new IllegalArgumentException("Cannot delay the first Android view draw when the render mode is not set to `RenderMode.surface`.");
    }

    private void doInitialFlutterViewRun() {
        String str;
        DartExecutor.DartEntrypoint dartEntrypoint;
        if (this.host.getCachedEngineId() == null && !this.flutterEngine.getDartExecutor().isExecutingDart()) {
            String initialRoute = this.host.getInitialRoute();
            if (initialRoute == null && (initialRoute = maybeGetInitialRouteFromIntent(this.host.getActivity().getIntent())) == null) {
                initialRoute = "/";
            }
            String dartEntrypointLibraryUri = this.host.getDartEntrypointLibraryUri();
            if (("Executing Dart entrypoint: " + this.host.getDartEntrypointFunctionName() + ", library uri: " + dartEntrypointLibraryUri) == null) {
                str = "\"\"";
            } else {
                str = dartEntrypointLibraryUri + ", and sending initial route: " + initialRoute;
            }
            Log.v(TAG, str);
            this.flutterEngine.getNavigationChannel().setInitialRoute(initialRoute);
            String appBundlePath = this.host.getAppBundlePath();
            if (appBundlePath == null || appBundlePath.isEmpty()) {
                appBundlePath = FlutterInjector.instance().flutterLoader().findAppBundlePath();
            }
            if (dartEntrypointLibraryUri == null) {
                dartEntrypoint = new DartExecutor.DartEntrypoint(appBundlePath, this.host.getDartEntrypointFunctionName());
            } else {
                dartEntrypoint = new DartExecutor.DartEntrypoint(appBundlePath, dartEntrypointLibraryUri, this.host.getDartEntrypointFunctionName());
            }
            this.flutterEngine.getDartExecutor().executeDartEntrypoint(dartEntrypoint, this.host.getDartEntrypointArgs());
        }
    }

    private void ensureAlive() {
        if (this.host == null) {
            throw new IllegalStateException("Cannot execute method on a destroyed FlutterActivityAndFragmentDelegate.");
        }
    }

    private String maybeGetInitialRouteFromIntent(Intent intent) {
        Uri data;
        String path;
        if (!this.host.shouldHandleDeeplinking() || (data = intent.getData()) == null || (path = data.getPath()) == null || path.isEmpty()) {
            return null;
        }
        if (data.getQuery() != null && !data.getQuery().isEmpty()) {
            path = path + TypeDescription.Generic.OfWildcardType.SYMBOL + data.getQuery();
        }
        if (data.getFragment() == null || data.getFragment().isEmpty()) {
            return path;
        }
        return path + "#" + data.getFragment();
    }

    public void A() {
        PlatformPlugin platformPlugin2 = this.platformPlugin;
        if (platformPlugin2 != null) {
            platformPlugin2.updateSystemUiOverlays();
        }
    }

    public void detachFromFlutterEngine() {
        if (!this.host.shouldDestroyEngineWithHost()) {
            this.host.detachFromFlutterEngine();
            return;
        }
        throw new AssertionError("The internal FlutterEngine created by " + this.host + " has been attached to by another activity. To persist a FlutterEngine beyond the ownership of this activity, explicitly create a FlutterEngine");
    }

    @Nullable
    public FlutterEngine e() {
        return this.flutterEngine;
    }

    public boolean f() {
        return this.isAttached;
    }

    public boolean g() {
        return this.isFlutterEngineFromHost;
    }

    public void h(int i11, int i12, Intent intent) {
        ensureAlive();
        if (this.flutterEngine != null) {
            Log.v(TAG, "Forwarding onActivityResult() to FlutterEngine:\nrequestCode: " + i11 + "\nresultCode: " + i12 + "\ndata: " + intent);
            this.flutterEngine.getActivityControlSurface().onActivityResult(i11, i12, intent);
            return;
        }
        Log.w(TAG, "onActivityResult() invoked before FlutterFragment was attached to an Activity.");
    }

    public void i(@NonNull Context context) {
        ensureAlive();
        if (this.flutterEngine == null) {
            z();
        }
        if (this.host.shouldAttachEngineToActivity()) {
            Log.v(TAG, "Attaching FlutterEngine to the Activity that owns this delegate.");
            this.flutterEngine.getActivityControlSurface().attachToActivity(this, this.host.getLifecycle());
        }
        Host host2 = this.host;
        this.platformPlugin = host2.providePlatformPlugin(host2.getActivity(), this.flutterEngine);
        this.host.configureFlutterEngine(this.flutterEngine);
        this.isAttached = true;
    }

    public void j() {
        ensureAlive();
        if (this.flutterEngine != null) {
            Log.v(TAG, "Forwarding onBackPressed() to FlutterEngine.");
            this.flutterEngine.getNavigationChannel().popRoute();
            return;
        }
        Log.w(TAG, "Invoked onBackPressed() before FlutterFragment was attached to an Activity.");
    }

    @NonNull
    public View k(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle, int i11, boolean z11) {
        Log.v(TAG, "Creating FlutterView.");
        ensureAlive();
        boolean z12 = true;
        if (this.host.getRenderMode() == RenderMode.surface) {
            Context context = this.host.getContext();
            if (this.host.getTransparencyMode() != TransparencyMode.transparent) {
                z12 = false;
            }
            FlutterSurfaceView flutterSurfaceView = new FlutterSurfaceView(context, z12);
            this.host.onFlutterSurfaceViewCreated(flutterSurfaceView);
            this.f14126a = new FlutterView(this.host.getContext(), flutterSurfaceView);
        } else {
            FlutterTextureView flutterTextureView = new FlutterTextureView(this.host.getContext());
            if (this.host.getTransparencyMode() != TransparencyMode.opaque) {
                z12 = false;
            }
            flutterTextureView.setOpaque(z12);
            this.host.onFlutterTextureViewCreated(flutterTextureView);
            this.f14126a = new FlutterView(this.host.getContext(), flutterTextureView);
        }
        this.f14126a.addOnFirstFrameRenderedListener(this.flutterUiDisplayListener);
        Log.v(TAG, "Attaching FlutterEngine to FlutterView.");
        this.f14126a.attachToFlutterEngine(this.flutterEngine);
        this.f14126a.setId(i11);
        SplashScreen provideSplashScreen = this.host.provideSplashScreen();
        if (provideSplashScreen != null) {
            Log.w(TAG, "A splash screen was provided to Flutter, but this is deprecated. See flutter.dev/go/android-splash-migration for migration steps.");
            FlutterSplashView flutterSplashView = new FlutterSplashView(this.host.getContext());
            flutterSplashView.setId(ViewUtils.generateViewId(FLUTTER_SPLASH_VIEW_FALLBACK_ID));
            flutterSplashView.displayFlutterViewWithSplash(this.f14126a, provideSplashScreen);
            return flutterSplashView;
        }
        if (z11) {
            delayFirstAndroidViewDraw(this.f14126a);
        }
        return this.f14126a;
    }

    public void l() {
        Log.v(TAG, "onDestroyView()");
        ensureAlive();
        if (this.f14127b != null) {
            this.f14126a.getViewTreeObserver().removeOnPreDrawListener(this.f14127b);
            this.f14127b = null;
        }
        this.f14126a.detachFromFlutterEngine();
        this.f14126a.removeOnFirstFrameRenderedListener(this.flutterUiDisplayListener);
    }

    public void m() {
        Log.v(TAG, "onDetach()");
        ensureAlive();
        this.host.cleanUpFlutterEngine(this.flutterEngine);
        if (this.host.shouldAttachEngineToActivity()) {
            Log.v(TAG, "Detaching FlutterEngine from the Activity that owns this Fragment.");
            if (this.host.getActivity().isChangingConfigurations()) {
                this.flutterEngine.getActivityControlSurface().detachFromActivityForConfigChanges();
            } else {
                this.flutterEngine.getActivityControlSurface().detachFromActivity();
            }
        }
        PlatformPlugin platformPlugin2 = this.platformPlugin;
        if (platformPlugin2 != null) {
            platformPlugin2.destroy();
            this.platformPlugin = null;
        }
        if (this.host.shouldDispatchAppLifecycleState()) {
            this.flutterEngine.getLifecycleChannel().appIsDetached();
        }
        if (this.host.shouldDestroyEngineWithHost()) {
            this.flutterEngine.destroy();
            if (this.host.getCachedEngineId() != null) {
                FlutterEngineCache.getInstance().remove(this.host.getCachedEngineId());
            }
            this.flutterEngine = null;
        }
        this.isAttached = false;
    }

    public void n(@NonNull Intent intent) {
        ensureAlive();
        if (this.flutterEngine != null) {
            Log.v(TAG, "Forwarding onNewIntent() to FlutterEngine and sending pushRoute message.");
            this.flutterEngine.getActivityControlSurface().onNewIntent(intent);
            String maybeGetInitialRouteFromIntent = maybeGetInitialRouteFromIntent(intent);
            if (maybeGetInitialRouteFromIntent != null && !maybeGetInitialRouteFromIntent.isEmpty()) {
                this.flutterEngine.getNavigationChannel().pushRoute(maybeGetInitialRouteFromIntent);
                return;
            }
            return;
        }
        Log.w(TAG, "onNewIntent() invoked before FlutterFragment was attached to an Activity.");
    }

    public void o() {
        Log.v(TAG, "onPause()");
        ensureAlive();
        if (this.host.shouldDispatchAppLifecycleState()) {
            this.flutterEngine.getLifecycleChannel().appIsInactive();
        }
    }

    public void p() {
        Log.v(TAG, "onPostResume()");
        ensureAlive();
        if (this.flutterEngine != null) {
            A();
        } else {
            Log.w(TAG, "onPostResume() invoked before FlutterFragment was attached to an Activity.");
        }
    }

    public void q(int i11, @NonNull String[] strArr, @NonNull int[] iArr) {
        ensureAlive();
        if (this.flutterEngine != null) {
            Log.v(TAG, "Forwarding onRequestPermissionsResult() to FlutterEngine:\nrequestCode: " + i11 + "\npermissions: " + Arrays.toString(strArr) + "\ngrantResults: " + Arrays.toString(iArr));
            this.flutterEngine.getActivityControlSurface().onRequestPermissionsResult(i11, strArr, iArr);
            return;
        }
        Log.w(TAG, "onRequestPermissionResult() invoked before FlutterFragment was attached to an Activity.");
    }

    public void r(@Nullable Bundle bundle) {
        byte[] bArr;
        Bundle bundle2;
        Log.v(TAG, "onRestoreInstanceState. Giving framework and plugins an opportunity to restore state.");
        ensureAlive();
        if (bundle != null) {
            bundle2 = bundle.getBundle(PLUGINS_RESTORATION_BUNDLE_KEY);
            bArr = bundle.getByteArray(FRAMEWORK_RESTORATION_BUNDLE_KEY);
        } else {
            bundle2 = null;
            bArr = null;
        }
        if (this.host.shouldRestoreAndSaveState()) {
            this.flutterEngine.getRestorationChannel().setRestorationData(bArr);
        }
        if (this.host.shouldAttachEngineToActivity()) {
            this.flutterEngine.getActivityControlSurface().onRestoreInstanceState(bundle2);
        }
    }

    public void s() {
        Log.v(TAG, "onResume()");
        ensureAlive();
        if (this.host.shouldDispatchAppLifecycleState()) {
            this.flutterEngine.getLifecycleChannel().appIsResumed();
        }
    }

    public void t(@Nullable Bundle bundle) {
        Log.v(TAG, "onSaveInstanceState. Giving framework and plugins an opportunity to save state.");
        ensureAlive();
        if (this.host.shouldRestoreAndSaveState()) {
            bundle.putByteArray(FRAMEWORK_RESTORATION_BUNDLE_KEY, this.flutterEngine.getRestorationChannel().getRestorationData());
        }
        if (this.host.shouldAttachEngineToActivity()) {
            Bundle bundle2 = new Bundle();
            this.flutterEngine.getActivityControlSurface().onSaveInstanceState(bundle2);
            bundle.putBundle(PLUGINS_RESTORATION_BUNDLE_KEY, bundle2);
        }
    }

    public void u() {
        Log.v(TAG, "onStart()");
        ensureAlive();
        doInitialFlutterViewRun();
        Integer num = this.previousVisibility;
        if (num != null) {
            this.f14126a.setVisibility(num.intValue());
        }
    }

    public void v() {
        Log.v(TAG, "onStop()");
        ensureAlive();
        if (this.host.shouldDispatchAppLifecycleState()) {
            this.flutterEngine.getLifecycleChannel().appIsPaused();
        }
        this.previousVisibility = Integer.valueOf(this.f14126a.getVisibility());
        this.f14126a.setVisibility(8);
    }

    public void w(int i11) {
        boolean z11;
        ensureAlive();
        FlutterEngine flutterEngine2 = this.flutterEngine;
        if (flutterEngine2 != null) {
            if (!this.isFirstFrameRendered || i11 < 10) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11) {
                flutterEngine2.getDartExecutor().notifyLowMemoryWarning();
                this.flutterEngine.getSystemChannel().sendMemoryPressureWarning();
            }
            this.flutterEngine.getRenderer().onTrimMemory(i11);
        }
    }

    public void x() {
        ensureAlive();
        if (this.flutterEngine != null) {
            Log.v(TAG, "Forwarding onUserLeaveHint() to FlutterEngine.");
            this.flutterEngine.getActivityControlSurface().onUserLeaveHint();
            return;
        }
        Log.w(TAG, "onUserLeaveHint() invoked before FlutterFragment was attached to an Activity.");
    }

    public void y() {
        this.host = null;
        this.flutterEngine = null;
        this.f14126a = null;
        this.platformPlugin = null;
    }

    @VisibleForTesting
    public void z() {
        Log.v(TAG, "Setting up FlutterEngine.");
        String cachedEngineId = this.host.getCachedEngineId();
        if (cachedEngineId != null) {
            FlutterEngine flutterEngine2 = FlutterEngineCache.getInstance().get(cachedEngineId);
            this.flutterEngine = flutterEngine2;
            this.isFlutterEngineFromHost = true;
            if (flutterEngine2 == null) {
                throw new IllegalStateException("The requested cached FlutterEngine did not exist in the FlutterEngineCache: '" + cachedEngineId + "'");
            }
            return;
        }
        Host host2 = this.host;
        FlutterEngine provideFlutterEngine = host2.provideFlutterEngine(host2.getContext());
        this.flutterEngine = provideFlutterEngine;
        if (provideFlutterEngine != null) {
            this.isFlutterEngineFromHost = true;
            return;
        }
        Log.v(TAG, "No preferred FlutterEngine was provided. Creating a new FlutterEngine for this FlutterFragment.");
        this.flutterEngine = new FlutterEngine(this.host.getContext(), this.host.getFlutterShellArgs().toArray(), false, this.host.shouldRestoreAndSaveState());
        this.isFlutterEngineFromHost = false;
    }

    @NonNull
    public Activity getAppComponent() {
        Activity activity = this.host.getActivity();
        if (activity != null) {
            return activity;
        }
        throw new AssertionError("FlutterActivityAndFragmentDelegate's getAppComponent should only be queried after onAttach, when the host's activity should always be non-null");
    }
}
