package com.talabat.core.flutter.binding.presentation;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.flutter.binding.domain.ActivityEngineBinding;
import com.talabat.core.flutter.binding.domain.DeeplinkEngineBindingRegistry;
import com.talabat.core.flutter.binding.domain.EngineBinding;
import com.talabat.core.fwfprojectskeys.domain.projects.platform.PlatformFeatureFlagsKeys;
import com.talabat.core.navigation.domain.screen.flutter.FlutterScreen;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.IScreenTracker;
import com.talabat.core.observabilityNew.domain.entity.ScreenTrackerParams;
import com.talabat.core.observabilityNew.domain.squads.menu.MenuScreenPerformanceParams;
import com.talabat.core.ui.di.AndroidComponentsKt;
import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020\u001dH\u0014J\b\u0010$\u001a\u00020\u001dH\u0016J\b\u0010%\u001a\u00020\u001dH\u0016J\u0010\u0010&\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020*H\u0016J\u0012\u0010+\u001a\u00020\u001d2\b\u0010,\u001a\u0004\u0018\u00010\"H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R!\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\t\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\t\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\t\u001a\u0004\b\u0019\u0010\u001a¨\u0006-"}, d2 = {"Lcom/talabat/core/flutter/binding/presentation/DeeplinkFlutterActivity;", "Lio/flutter/embedding/android/FlutterActivity;", "Lio/flutter/embedding/engine/FlutterEngine$EngineLifecycleListener;", "()V", "deeplinkEngineBindingRegistry", "Lcom/talabat/core/flutter/binding/domain/DeeplinkEngineBindingRegistry;", "getDeeplinkEngineBindingRegistry", "()Lcom/talabat/core/flutter/binding/domain/DeeplinkEngineBindingRegistry;", "deeplinkEngineBindingRegistry$delegate", "Lkotlin/Lazy;", "featuresBindingRegistry", "", "Lcom/talabat/core/flutter/binding/domain/EngineBinding;", "getFeaturesBindingRegistry", "()Ljava/util/Set;", "featuresBindingRegistry$delegate", "flutterScreenData", "Lcom/talabat/core/navigation/domain/screen/flutter/FlutterScreen$FlutterScreenData;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "getObservabilityManager", "()Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "observabilityManager$delegate", "screenTracker", "Lcom/talabat/core/observabilityNew/domain/IScreenTracker;", "getScreenTracker", "()Lcom/talabat/core/observabilityNew/domain/IScreenTracker;", "screenTracker$delegate", "cleanUpFlutterEngine", "", "flutterEngine", "Lio/flutter/embedding/engine/FlutterEngine;", "observeFlutterBehaviour", "explanation", "", "onDestroy", "onEngineWillDestroy", "onPreEngineRestart", "provideFlutterEngine", "context", "Landroid/content/Context;", "shouldDestroyEngineWithHost", "", "startFoodMenuTrace", "deeplink", "com_talabat_core_flutter-binding_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DeeplinkFlutterActivity extends FlutterActivity implements FlutterEngine.EngineLifecycleListener {
    @NotNull
    private final Lazy deeplinkEngineBindingRegistry$delegate;
    @NotNull
    private final Lazy featuresBindingRegistry$delegate;
    @Nullable
    private FlutterScreen.FlutterScreenData flutterScreenData;
    @NotNull
    private final Lazy observabilityManager$delegate;
    @NotNull
    private final Lazy screenTracker$delegate;

    public DeeplinkFlutterActivity() {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.deeplinkEngineBindingRegistry$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new DeeplinkFlutterActivity$deeplinkEngineBindingRegistry$2(this));
        this.featuresBindingRegistry$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new DeeplinkFlutterActivity$featuresBindingRegistry$2(this));
        this.observabilityManager$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new DeeplinkFlutterActivity$observabilityManager$2(this));
        this.screenTracker$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new DeeplinkFlutterActivity$screenTracker$2(this));
    }

    private final DeeplinkEngineBindingRegistry getDeeplinkEngineBindingRegistry() {
        return (DeeplinkEngineBindingRegistry) this.deeplinkEngineBindingRegistry$delegate.getValue();
    }

    private final Set<EngineBinding> getFeaturesBindingRegistry() {
        return (Set) this.featuresBindingRegistry$delegate.getValue();
    }

    private final IObservabilityManager getObservabilityManager() {
        return (IObservabilityManager) this.observabilityManager$delegate.getValue();
    }

    private final IScreenTracker getScreenTracker() {
        return (IScreenTracker) this.screenTracker$delegate.getValue();
    }

    private final void observeFlutterBehaviour(String str) {
        String str2;
        IObservabilityManager observabilityManager = getObservabilityManager();
        Pair[] pairArr = new Pair[3];
        FlutterScreen.FlutterScreenData flutterScreenData2 = this.flutterScreenData;
        if (flutterScreenData2 == null || (str2 = flutterScreenData2.getDeepLink()) == null) {
            str2 = "N/A";
        }
        pairArr[0] = TuplesKt.to("deeplink", str2);
        pairArr[1] = TuplesKt.to("instance_id", String.valueOf(System.identityHashCode(this)));
        pairArr[2] = TuplesKt.to("engine_id", String.valueOf(System.identityHashCode(b())));
        observabilityManager.trackUnExpectedScenario(str, MapsKt__MapsKt.mapOf(pairArr));
    }

    private final void startFoodMenuTrace(String str) {
        boolean z11 = false;
        if (str != null && StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "vendor-menu", false, 2, (Object) null)) {
            z11 = true;
        }
        if (z11) {
            try {
                Result.Companion companion = Result.Companion;
                getScreenTracker().startTrace(new ScreenTrackerParams(MenuScreenPerformanceParams.TRACE_NATIVE, MenuScreenPerformanceParams.SCREEN_NAME_DEEPLINK, MenuScreenPerformanceParams.SCREEN_TYPE));
                Result.m6329constructorimpl(Unit.INSTANCE);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.m6329constructorimpl(ResultKt.createFailure(th2));
            }
        }
    }

    /* JADX WARNING: type inference failed for: r1v5, types: [io.flutter.embedding.engine.plugins.FlutterPlugin] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void cleanUpFlutterEngine(@org.jetbrains.annotations.NotNull io.flutter.embedding.engine.FlutterEngine r5) {
        /*
            r4 = this;
            java.lang.String r0 = "flutterEngine"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            com.talabat.core.di.ApiContainer r0 = com.talabat.core.ui.di.AndroidComponentsKt.apiContainer((android.app.Activity) r4)
            java.lang.Class<com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi> r1 = com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi.class
            java.lang.Object r0 = r0.getFeature(r1)
            com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi r0 = (com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi) r0
            com.talabat.core.featureflag.domain.ITalabatFeatureFlag r0 = r0.getTalabatFeatureFlag()
            com.talabat.core.fwfprojectskeys.domain.projects.platform.PlatformFeatureFlagsKeys r1 = com.talabat.core.fwfprojectskeys.domain.projects.platform.PlatformFeatureFlagsKeys.EXTEND_ENGINES_DESTRUCTION
            r2 = 0
            boolean r0 = r0.getFeatureFlag(r1, r2)
            if (r0 == 0) goto L_0x006a
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x0060 }
            com.talabat.braze.BrazeReflectionTools.clearBrazeSdkAuthenticationErrorEventSubscribers(r4)     // Catch:{ all -> 0x0060 }
            io.flutter.embedding.engine.plugins.PluginRegistry r0 = r5.getPlugins()     // Catch:{ all -> 0x0060 }
            java.lang.Class<com.braze.brazeplugin.BrazePlugin> r1 = com.braze.brazeplugin.BrazePlugin.class
            io.flutter.embedding.engine.plugins.FlutterPlugin r0 = r0.get(r1)     // Catch:{ all -> 0x0060 }
            boolean r1 = r0 instanceof com.braze.brazeplugin.BrazePlugin     // Catch:{ all -> 0x0060 }
            r2 = 0
            if (r1 == 0) goto L_0x0035
            com.braze.brazeplugin.BrazePlugin r0 = (com.braze.brazeplugin.BrazePlugin) r0     // Catch:{ all -> 0x0060 }
            goto L_0x0036
        L_0x0035:
            r0 = r2
        L_0x0036:
            io.flutter.embedding.engine.plugins.PluginRegistry r1 = r5.getPlugins()     // Catch:{ all -> 0x0060 }
            java.lang.Class<io.flutter.plugins.webviewflutter.WebViewFlutterPlugin> r3 = io.flutter.plugins.webviewflutter.WebViewFlutterPlugin.class
            io.flutter.embedding.engine.plugins.FlutterPlugin r1 = r1.get(r3)     // Catch:{ all -> 0x0060 }
            boolean r3 = r1 instanceof io.flutter.plugins.webviewflutter.WebViewFlutterPlugin     // Catch:{ all -> 0x0060 }
            if (r3 == 0) goto L_0x0047
            r2 = r1
            io.flutter.plugins.webviewflutter.WebViewFlutterPlugin r2 = (io.flutter.plugins.webviewflutter.WebViewFlutterPlugin) r2     // Catch:{ all -> 0x0060 }
        L_0x0047:
            if (r2 == 0) goto L_0x0052
            io.flutter.plugins.webviewflutter.InstanceManager r1 = r2.getInstanceManager()     // Catch:{ all -> 0x0060 }
            if (r1 == 0) goto L_0x0052
            r1.stopFinalizationListener()     // Catch:{ all -> 0x0060 }
        L_0x0052:
            if (r0 == 0) goto L_0x0057
            r0.onDetachedFromActivity()     // Catch:{ all -> 0x0060 }
        L_0x0057:
            r5.removeEngineLifecycleListener(r4)     // Catch:{ all -> 0x0060 }
            kotlin.Unit r5 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0060 }
            kotlin.Result.m6329constructorimpl(r5)     // Catch:{ all -> 0x0060 }
            goto L_0x006a
        L_0x0060:
            r5 = move-exception
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Object r5 = kotlin.ResultKt.createFailure(r5)
            kotlin.Result.m6329constructorimpl(r5)
        L_0x006a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.core.flutter.binding.presentation.DeeplinkFlutterActivity.cleanUpFlutterEngine(io.flutter.embedding.engine.FlutterEngine):void");
    }

    public void onDestroy() {
        observeFlutterBehaviour("deeplink_flutter_activity_destroyed");
        DeeplinkEngineBindingRegistry.destroy$default(getDeeplinkEngineBindingRegistry(), false, 1, (Object) null);
        if (((FeatureFlagCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(FeatureFlagCoreLibApi.class)).getTalabatFeatureFlag().getFeatureFlag(PlatformFeatureFlagsKeys.EXTEND_ENGINES_DESTRUCTION, false)) {
            try {
                Result.Companion companion = Result.Companion;
                for (EngineBinding destroy : getFeaturesBindingRegistry()) {
                    destroy.destroy();
                }
                Result.m6329constructorimpl(Unit.INSTANCE);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.m6329constructorimpl(ResultKt.createFailure(th2));
            }
        }
        super.onDestroy();
    }

    public void onEngineWillDestroy() {
        observeFlutterBehaviour("deeplink_flutter_activity_engine_will_destroy");
    }

    public void onPreEngineRestart() {
        observeFlutterBehaviour("deeplink_flutter_activity_engine_restart");
    }

    @NotNull
    public FlutterEngine provideFlutterEngine(@NotNull Context context) {
        FlutterScreen.FlutterScreenData flutterScreenData2;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(context, "context");
        if (Build.VERSION.SDK_INT >= 33) {
            flutterScreenData2 = (FlutterScreen.FlutterScreenData) getIntent().getParcelableExtra("navigatorData", FlutterScreen.FlutterScreenData.class);
        } else {
            flutterScreenData2 = (FlutterScreen.FlutterScreenData) getIntent().getParcelableExtra("navigatorData");
        }
        this.flutterScreenData = flutterScreenData2;
        String str3 = null;
        if (flutterScreenData2 != null) {
            str = flutterScreenData2.getDeepLink();
        } else {
            str = null;
        }
        startFoodMenuTrace(str);
        FlutterScreen.FlutterScreenData flutterScreenData3 = this.flutterScreenData;
        if (flutterScreenData3 != null) {
            str3 = flutterScreenData3.getDeepLink();
        }
        Log.i("DeeplinkFlutterActivity", " provideFlutterEngine deeplink = " + str3);
        DeeplinkEngineBindingRegistry deeplinkEngineBindingRegistry = getDeeplinkEngineBindingRegistry();
        FlutterScreen.FlutterScreenData flutterScreenData4 = this.flutterScreenData;
        if (flutterScreenData4 == null || (str2 = flutterScreenData4.getDeepLink()) == null) {
            str2 = "";
        }
        FlutterEngine init = deeplinkEngineBindingRegistry.init(str2, this, getIntent().getExtras());
        init.addEngineLifecycleListener(this);
        for (EngineBinding engineBinding : getFeaturesBindingRegistry()) {
            if (engineBinding instanceof ActivityEngineBinding) {
                ((ActivityEngineBinding) engineBinding).init(init, this, getIntent().getExtras());
            } else {
                engineBinding.init(init);
            }
        }
        return init;
    }

    public boolean shouldDestroyEngineWithHost() {
        return ((FeatureFlagCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(FeatureFlagCoreLibApi.class)).getTalabatFeatureFlag().getFeatureFlag(PlatformFeatureFlagsKeys.DESTROY_ENGINE_WITH_ACTIVITY, false);
    }
}
