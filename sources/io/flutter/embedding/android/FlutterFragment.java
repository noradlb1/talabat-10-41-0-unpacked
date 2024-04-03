package io.flutter.embedding.android;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.feature.bnplcheckout.BNPLCheckoutFlutterBottomSheetKt;
import io.flutter.Log;
import io.flutter.embedding.android.FlutterActivityAndFragmentDelegate;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterShellArgs;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
import io.flutter.plugin.platform.PlatformPlugin;
import io.flutter.util.ViewUtils;
import java.util.ArrayList;
import java.util.List;

@Instrumented
public class FlutterFragment extends Fragment implements FlutterActivityAndFragmentDelegate.Host, ComponentCallbacks2, FlutterActivityAndFragmentDelegate.DelegateFactory, TraceFieldInterface {
    public static final int FLUTTER_VIEW_ID = ViewUtils.generateViewId(61938);
    private static final String TAG = "FlutterFragment";
    @VisibleForTesting
    @Nullable
    public FlutterActivityAndFragmentDelegate C;
    public Trace _nr_trace;
    @NonNull
    private FlutterActivityAndFragmentDelegate.DelegateFactory delegateFactory = this;
    private final OnBackPressedCallback onBackPressedCallback = new OnBackPressedCallback(true) {
        public void handleOnBackPressed() {
            FlutterFragment.this.onBackPressed();
        }
    };

    public @interface ActivityCallThrough {
    }

    public static class CachedEngineFragmentBuilder {
        private boolean destroyEngineWithFragment;
        private final String engineId;
        private final Class<? extends FlutterFragment> fragmentClass;
        private boolean handleDeeplinking;
        private RenderMode renderMode;
        private boolean shouldAttachEngineToActivity;
        private boolean shouldAutomaticallyHandleOnBackPressed;
        private boolean shouldDelayFirstAndroidViewDraw;
        private TransparencyMode transparencyMode;

        @NonNull
        public Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putString("cached_engine_id", this.engineId);
            bundle.putBoolean("destroy_engine_with_fragment", this.destroyEngineWithFragment);
            bundle.putBoolean("handle_deeplinking", this.handleDeeplinking);
            RenderMode renderMode2 = this.renderMode;
            if (renderMode2 == null) {
                renderMode2 = RenderMode.surface;
            }
            bundle.putString("flutterview_render_mode", renderMode2.name());
            TransparencyMode transparencyMode2 = this.transparencyMode;
            if (transparencyMode2 == null) {
                transparencyMode2 = TransparencyMode.transparent;
            }
            bundle.putString("flutterview_transparency_mode", transparencyMode2.name());
            bundle.putBoolean("should_attach_engine_to_activity", this.shouldAttachEngineToActivity);
            bundle.putBoolean(BNPLCheckoutFlutterBottomSheetKt.ARGS_SHOULD_AUTOMATICALLY_HANDLE_ON_BACK_PRESSED, this.shouldAutomaticallyHandleOnBackPressed);
            bundle.putBoolean("should_delay_first_android_view_draw", this.shouldDelayFirstAndroidViewDraw);
            return bundle;
        }

        @NonNull
        public <T extends FlutterFragment> T build() {
            try {
                T t11 = (FlutterFragment) this.fragmentClass.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                if (t11 != null) {
                    t11.setArguments(a());
                    return t11;
                }
                throw new RuntimeException("The FlutterFragment subclass sent in the constructor (" + this.fragmentClass.getCanonicalName() + ") does not match the expected return type.");
            } catch (Exception e11) {
                throw new RuntimeException("Could not instantiate FlutterFragment subclass (" + this.fragmentClass.getName() + ")", e11);
            }
        }

        @NonNull
        public CachedEngineFragmentBuilder destroyEngineWithFragment(boolean z11) {
            this.destroyEngineWithFragment = z11;
            return this;
        }

        @NonNull
        public CachedEngineFragmentBuilder handleDeeplinking(@NonNull Boolean bool) {
            this.handleDeeplinking = bool.booleanValue();
            return this;
        }

        @NonNull
        public CachedEngineFragmentBuilder renderMode(@NonNull RenderMode renderMode2) {
            this.renderMode = renderMode2;
            return this;
        }

        @NonNull
        public CachedEngineFragmentBuilder shouldAttachEngineToActivity(boolean z11) {
            this.shouldAttachEngineToActivity = z11;
            return this;
        }

        @NonNull
        public CachedEngineFragmentBuilder shouldAutomaticallyHandleOnBackPressed(boolean z11) {
            this.shouldAutomaticallyHandleOnBackPressed = z11;
            return this;
        }

        @NonNull
        public CachedEngineFragmentBuilder shouldDelayFirstAndroidViewDraw(@NonNull boolean z11) {
            this.shouldDelayFirstAndroidViewDraw = z11;
            return this;
        }

        @NonNull
        public CachedEngineFragmentBuilder transparencyMode(@NonNull TransparencyMode transparencyMode2) {
            this.transparencyMode = transparencyMode2;
            return this;
        }

        private CachedEngineFragmentBuilder(@NonNull String str) {
            this((Class<? extends FlutterFragment>) FlutterFragment.class, str);
        }

        public CachedEngineFragmentBuilder(@NonNull Class<? extends FlutterFragment> cls, @NonNull String str) {
            this.destroyEngineWithFragment = false;
            this.handleDeeplinking = false;
            this.renderMode = RenderMode.surface;
            this.transparencyMode = TransparencyMode.transparent;
            this.shouldAttachEngineToActivity = true;
            this.shouldAutomaticallyHandleOnBackPressed = false;
            this.shouldDelayFirstAndroidViewDraw = false;
            this.fragmentClass = cls;
            this.engineId = str;
        }
    }

    public FlutterFragment() {
        setArguments(new Bundle());
    }

    @NonNull
    public static FlutterFragment createDefault() {
        return new NewEngineFragmentBuilder().build();
    }

    private boolean stillAttachedForEvent(String str) {
        FlutterActivityAndFragmentDelegate flutterActivityAndFragmentDelegate = this.C;
        if (flutterActivityAndFragmentDelegate == null) {
            Log.w(TAG, "FlutterFragment " + hashCode() + " " + str + " called after release.");
            return false;
        } else if (flutterActivityAndFragmentDelegate.f()) {
            return true;
        } else {
            Log.w(TAG, "FlutterFragment " + hashCode() + " " + str + " called after detach.");
            return false;
        }
    }

    @NonNull
    public static CachedEngineFragmentBuilder withCachedEngine(@NonNull String str) {
        return new CachedEngineFragmentBuilder(str);
    }

    @NonNull
    public static NewEngineFragmentBuilder withNewEngine() {
        return new NewEngineFragmentBuilder();
    }

    public void cleanUpFlutterEngine(@NonNull FlutterEngine flutterEngine) {
        FragmentActivity activity = getActivity();
        if (activity instanceof FlutterEngineConfigurator) {
            ((FlutterEngineConfigurator) activity).cleanUpFlutterEngine(flutterEngine);
        }
    }

    public void configureFlutterEngine(@NonNull FlutterEngine flutterEngine) {
        FragmentActivity activity = getActivity();
        if (activity instanceof FlutterEngineConfigurator) {
            ((FlutterEngineConfigurator) activity).configureFlutterEngine(flutterEngine);
        }
    }

    public FlutterActivityAndFragmentDelegate createDelegate(FlutterActivityAndFragmentDelegate.Host host) {
        return new FlutterActivityAndFragmentDelegate(host);
    }

    public void detachFromFlutterEngine() {
        Log.w(TAG, "FlutterFragment " + this + " connection to the engine " + getFlutterEngine() + " evicted by another attaching activity");
        FlutterActivityAndFragmentDelegate flutterActivityAndFragmentDelegate = this.C;
        if (flutterActivityAndFragmentDelegate != null) {
            flutterActivityAndFragmentDelegate.l();
            this.C.m();
        }
    }

    @Nullable
    public /* bridge */ /* synthetic */ Activity getActivity() {
        return super.getActivity();
    }

    @NonNull
    public String getAppBundlePath() {
        return getArguments().getString("app_bundle_path");
    }

    @Nullable
    public String getCachedEngineId() {
        return getArguments().getString("cached_engine_id", (String) null);
    }

    @Nullable
    public List<String> getDartEntrypointArgs() {
        return getArguments().getStringArrayList("dart_entrypoint_args");
    }

    @NonNull
    public String getDartEntrypointFunctionName() {
        return getArguments().getString("dart_entrypoint", "main");
    }

    @Nullable
    public String getDartEntrypointLibraryUri() {
        return getArguments().getString("dart_entrypoint_uri");
    }

    public ExclusiveAppComponent<Activity> getExclusiveAppComponent() {
        return this.C;
    }

    @Nullable
    public FlutterEngine getFlutterEngine() {
        return this.C.e();
    }

    @NonNull
    public FlutterShellArgs getFlutterShellArgs() {
        String[] stringArray = getArguments().getStringArray("initialization_args");
        if (stringArray == null) {
            stringArray = new String[0];
        }
        return new FlutterShellArgs(stringArray);
    }

    @Nullable
    public String getInitialRoute() {
        return getArguments().getString("initial_route");
    }

    @NonNull
    public RenderMode getRenderMode() {
        return RenderMode.valueOf(getArguments().getString("flutterview_render_mode", RenderMode.surface.name()));
    }

    @NonNull
    public TransparencyMode getTransparencyMode() {
        return TransparencyMode.valueOf(getArguments().getString("flutterview_transparency_mode", TransparencyMode.transparent.name()));
    }

    public boolean i0() {
        return this.C.g();
    }

    @VisibleForTesting
    @NonNull
    public boolean j0() {
        return getArguments().getBoolean("should_delay_first_android_view_draw");
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        if (stillAttachedForEvent("onActivityResult")) {
            this.C.h(i11, i12, intent);
        }
    }

    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        FlutterActivityAndFragmentDelegate createDelegate = this.delegateFactory.createDelegate(this);
        this.C = createDelegate;
        createDelegate.i(context);
        if (getArguments().getBoolean(BNPLCheckoutFlutterBottomSheetKt.ARGS_SHOULD_AUTOMATICALLY_HANDLE_ON_BACK_PRESSED, false)) {
            requireActivity().getOnBackPressedDispatcher().addCallback(this, this.onBackPressedCallback);
        }
        context.registerComponentCallbacks(this);
    }

    @ActivityCallThrough
    public void onBackPressed() {
        if (stillAttachedForEvent("onBackPressed")) {
            this.C.j();
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        TraceMachine.startTracing(TAG);
        try {
            TraceMachine.enterMethod(this._nr_trace, "FlutterFragment#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "FlutterFragment#onCreate", (ArrayList<String>) null);
        }
        super.onCreate(bundle);
        this.C.r(bundle);
        TraceMachine.exitMethod();
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "FlutterFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "FlutterFragment#onCreateView", (ArrayList<String>) null);
        }
        View k11 = this.C.k(layoutInflater, viewGroup, bundle, FLUTTER_VIEW_ID, j0());
        TraceMachine.exitMethod();
        return k11;
    }

    public void onDestroyView() {
        super.onDestroyView();
        if (stillAttachedForEvent("onDestroyView")) {
            this.C.l();
        }
    }

    public void onDetach() {
        getContext().unregisterComponentCallbacks(this);
        super.onDetach();
        FlutterActivityAndFragmentDelegate flutterActivityAndFragmentDelegate = this.C;
        if (flutterActivityAndFragmentDelegate != null) {
            flutterActivityAndFragmentDelegate.m();
            this.C.y();
            this.C = null;
            return;
        }
        Log.v(TAG, "FlutterFragment " + this + " onDetach called after release.");
    }

    public void onFlutterSurfaceViewCreated(@NonNull FlutterSurfaceView flutterSurfaceView) {
    }

    public void onFlutterTextureViewCreated(@NonNull FlutterTextureView flutterTextureView) {
    }

    public void onFlutterUiDisplayed() {
        FragmentActivity activity = getActivity();
        if (activity instanceof FlutterUiDisplayListener) {
            ((FlutterUiDisplayListener) activity).onFlutterUiDisplayed();
        }
    }

    public void onFlutterUiNoLongerDisplayed() {
        FragmentActivity activity = getActivity();
        if (activity instanceof FlutterUiDisplayListener) {
            ((FlutterUiDisplayListener) activity).onFlutterUiNoLongerDisplayed();
        }
    }

    @ActivityCallThrough
    public void onNewIntent(@NonNull Intent intent) {
        if (stillAttachedForEvent("onNewIntent")) {
            this.C.n(intent);
        }
    }

    public void onPause() {
        super.onPause();
        if (stillAttachedForEvent("onPause")) {
            this.C.o();
        }
    }

    @ActivityCallThrough
    public void onPostResume() {
        if (stillAttachedForEvent("onPostResume")) {
            this.C.p();
        }
    }

    @ActivityCallThrough
    public void onRequestPermissionsResult(int i11, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (stillAttachedForEvent("onRequestPermissionsResult")) {
            this.C.q(i11, strArr, iArr);
        }
    }

    public void onResume() {
        super.onResume();
        if (stillAttachedForEvent("onResume")) {
            this.C.s();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (stillAttachedForEvent("onSaveInstanceState")) {
            this.C.t(bundle);
        }
    }

    public void onStart() {
        super.onStart();
        if (stillAttachedForEvent("onStart")) {
            this.C.u();
        }
    }

    public void onStop() {
        super.onStop();
        if (stillAttachedForEvent("onStop")) {
            this.C.v();
        }
    }

    public void onTrimMemory(int i11) {
        if (stillAttachedForEvent("onTrimMemory")) {
            this.C.w(i11);
        }
    }

    @ActivityCallThrough
    public void onUserLeaveHint() {
        if (stillAttachedForEvent("onUserLeaveHint")) {
            this.C.x();
        }
    }

    public boolean popSystemNavigator() {
        FragmentActivity activity;
        if (!getArguments().getBoolean(BNPLCheckoutFlutterBottomSheetKt.ARGS_SHOULD_AUTOMATICALLY_HANDLE_ON_BACK_PRESSED, false) || (activity = getActivity()) == null) {
            return false;
        }
        this.onBackPressedCallback.setEnabled(false);
        activity.getOnBackPressedDispatcher().onBackPressed();
        this.onBackPressedCallback.setEnabled(true);
        return true;
    }

    @Nullable
    public FlutterEngine provideFlutterEngine(@NonNull Context context) {
        FragmentActivity activity = getActivity();
        if (!(activity instanceof FlutterEngineProvider)) {
            return null;
        }
        Log.v(TAG, "Deferring to attached Activity to provide a FlutterEngine.");
        return ((FlutterEngineProvider) activity).provideFlutterEngine(getContext());
    }

    @Nullable
    public PlatformPlugin providePlatformPlugin(@Nullable Activity activity, @NonNull FlutterEngine flutterEngine) {
        if (activity != null) {
            return new PlatformPlugin(getActivity(), flutterEngine.getPlatformChannel(), this);
        }
        return null;
    }

    @Nullable
    public SplashScreen provideSplashScreen() {
        FragmentActivity activity = getActivity();
        if (activity instanceof SplashScreenProvider) {
            return ((SplashScreenProvider) activity).provideSplashScreen();
        }
        return null;
    }

    public boolean shouldAttachEngineToActivity() {
        return getArguments().getBoolean("should_attach_engine_to_activity");
    }

    public boolean shouldDestroyEngineWithHost() {
        boolean z11 = getArguments().getBoolean("destroy_engine_with_fragment", false);
        if (getCachedEngineId() != null || this.C.g()) {
            return z11;
        }
        return getArguments().getBoolean("destroy_engine_with_fragment", true);
    }

    public boolean shouldDispatchAppLifecycleState() {
        return true;
    }

    public boolean shouldHandleDeeplinking() {
        return getArguments().getBoolean("handle_deeplinking");
    }

    public boolean shouldRestoreAndSaveState() {
        if (getArguments().containsKey("enable_state_restoration")) {
            return getArguments().getBoolean("enable_state_restoration");
        }
        if (getCachedEngineId() != null) {
            return false;
        }
        return true;
    }

    public void updateSystemUiOverlays() {
        FlutterActivityAndFragmentDelegate flutterActivityAndFragmentDelegate = this.C;
        if (flutterActivityAndFragmentDelegate != null) {
            flutterActivityAndFragmentDelegate.A();
        }
    }

    public static class NewEngineFragmentBuilder {
        private String appBundlePath;
        private String dartEntrypoint;
        private List<String> dartEntrypointArgs;
        private String dartLibraryUri;
        private final Class<? extends FlutterFragment> fragmentClass;
        private boolean handleDeeplinking;
        private String initialRoute;
        private RenderMode renderMode;
        private FlutterShellArgs shellArgs;
        private boolean shouldAttachEngineToActivity;
        private boolean shouldAutomaticallyHandleOnBackPressed;
        private boolean shouldDelayFirstAndroidViewDraw;
        private TransparencyMode transparencyMode;

        public NewEngineFragmentBuilder() {
            this.dartEntrypoint = "main";
            this.dartLibraryUri = null;
            this.initialRoute = "/";
            this.handleDeeplinking = false;
            this.appBundlePath = null;
            this.shellArgs = null;
            this.renderMode = RenderMode.surface;
            this.transparencyMode = TransparencyMode.transparent;
            this.shouldAttachEngineToActivity = true;
            this.shouldAutomaticallyHandleOnBackPressed = false;
            this.shouldDelayFirstAndroidViewDraw = false;
            this.fragmentClass = FlutterFragment.class;
        }

        @NonNull
        public Bundle a() {
            ArrayList arrayList;
            Bundle bundle = new Bundle();
            bundle.putString("initial_route", this.initialRoute);
            bundle.putBoolean("handle_deeplinking", this.handleDeeplinking);
            bundle.putString("app_bundle_path", this.appBundlePath);
            bundle.putString("dart_entrypoint", this.dartEntrypoint);
            bundle.putString("dart_entrypoint_uri", this.dartLibraryUri);
            if (this.dartEntrypointArgs != null) {
                arrayList = new ArrayList(this.dartEntrypointArgs);
            } else {
                arrayList = null;
            }
            bundle.putStringArrayList("dart_entrypoint_args", arrayList);
            FlutterShellArgs flutterShellArgs = this.shellArgs;
            if (flutterShellArgs != null) {
                bundle.putStringArray("initialization_args", flutterShellArgs.toArray());
            }
            RenderMode renderMode2 = this.renderMode;
            if (renderMode2 == null) {
                renderMode2 = RenderMode.surface;
            }
            bundle.putString("flutterview_render_mode", renderMode2.name());
            TransparencyMode transparencyMode2 = this.transparencyMode;
            if (transparencyMode2 == null) {
                transparencyMode2 = TransparencyMode.transparent;
            }
            bundle.putString("flutterview_transparency_mode", transparencyMode2.name());
            bundle.putBoolean("should_attach_engine_to_activity", this.shouldAttachEngineToActivity);
            bundle.putBoolean("destroy_engine_with_fragment", true);
            bundle.putBoolean(BNPLCheckoutFlutterBottomSheetKt.ARGS_SHOULD_AUTOMATICALLY_HANDLE_ON_BACK_PRESSED, this.shouldAutomaticallyHandleOnBackPressed);
            bundle.putBoolean("should_delay_first_android_view_draw", this.shouldDelayFirstAndroidViewDraw);
            return bundle;
        }

        @NonNull
        public NewEngineFragmentBuilder appBundlePath(@NonNull String str) {
            this.appBundlePath = str;
            return this;
        }

        @NonNull
        public <T extends FlutterFragment> T build() {
            try {
                T t11 = (FlutterFragment) this.fragmentClass.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                if (t11 != null) {
                    t11.setArguments(a());
                    return t11;
                }
                throw new RuntimeException("The FlutterFragment subclass sent in the constructor (" + this.fragmentClass.getCanonicalName() + ") does not match the expected return type.");
            } catch (Exception e11) {
                throw new RuntimeException("Could not instantiate FlutterFragment subclass (" + this.fragmentClass.getName() + ")", e11);
            }
        }

        @NonNull
        public NewEngineFragmentBuilder dartEntrypoint(@NonNull String str) {
            this.dartEntrypoint = str;
            return this;
        }

        @NonNull
        public NewEngineFragmentBuilder dartEntrypointArgs(@NonNull List<String> list) {
            this.dartEntrypointArgs = list;
            return this;
        }

        @NonNull
        public NewEngineFragmentBuilder dartLibraryUri(@NonNull String str) {
            this.dartLibraryUri = str;
            return this;
        }

        @NonNull
        public NewEngineFragmentBuilder flutterShellArgs(@NonNull FlutterShellArgs flutterShellArgs) {
            this.shellArgs = flutterShellArgs;
            return this;
        }

        @NonNull
        public NewEngineFragmentBuilder handleDeeplinking(@NonNull Boolean bool) {
            this.handleDeeplinking = bool.booleanValue();
            return this;
        }

        @NonNull
        public NewEngineFragmentBuilder initialRoute(@NonNull String str) {
            this.initialRoute = str;
            return this;
        }

        @NonNull
        public NewEngineFragmentBuilder renderMode(@NonNull RenderMode renderMode2) {
            this.renderMode = renderMode2;
            return this;
        }

        @NonNull
        public NewEngineFragmentBuilder shouldAttachEngineToActivity(boolean z11) {
            this.shouldAttachEngineToActivity = z11;
            return this;
        }

        @NonNull
        public NewEngineFragmentBuilder shouldAutomaticallyHandleOnBackPressed(boolean z11) {
            this.shouldAutomaticallyHandleOnBackPressed = z11;
            return this;
        }

        @NonNull
        public NewEngineFragmentBuilder shouldDelayFirstAndroidViewDraw(boolean z11) {
            this.shouldDelayFirstAndroidViewDraw = z11;
            return this;
        }

        @NonNull
        public NewEngineFragmentBuilder transparencyMode(@NonNull TransparencyMode transparencyMode2) {
            this.transparencyMode = transparencyMode2;
            return this;
        }

        public NewEngineFragmentBuilder(@NonNull Class<? extends FlutterFragment> cls) {
            this.dartEntrypoint = "main";
            this.dartLibraryUri = null;
            this.initialRoute = "/";
            this.handleDeeplinking = false;
            this.appBundlePath = null;
            this.shellArgs = null;
            this.renderMode = RenderMode.surface;
            this.transparencyMode = TransparencyMode.transparent;
            this.shouldAttachEngineToActivity = true;
            this.shouldAutomaticallyHandleOnBackPressed = false;
            this.shouldDelayFirstAndroidViewDraw = false;
            this.fragmentClass = cls;
        }
    }
}
