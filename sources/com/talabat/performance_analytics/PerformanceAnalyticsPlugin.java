package com.talabat.performance_analytics;

import android.content.Context;
import com.deliveryhero.performance.core.analytics.PerformanceTrackingManager;
import com.deliveryhero.performance.core.analytics.PerformanceTrackingManagerImpl;
import com.deliveryhero.performance.firebase.FirebasePerformanceProvider;
import com.facebook.internal.NativeProtocol;
import com.talabat.performance_analytics.PerformanceAnalyticsApi;
import com.talabat.performance_analytics.PerformanceAnalyticsAppStartupListenerApi;
import com.talabat.performance_analytics.PerformanceAnalyticsInitializerApi;
import com.talabat.performance_analytics.PerformanceAnalyticsScreenTrackerApi;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u000fH\u0016J \u0010\u0012\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/talabat/performance_analytics/PerformanceAnalyticsPlugin;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "Lcom/talabat/performance_analytics/PerformanceAnalyticsInitializerApi;", "()V", "context", "Landroid/content/Context;", "messenger", "Lio/flutter/plugin/common/BinaryMessenger;", "initialize", "", "params", "Lcom/talabat/performance_analytics/InitializeParams;", "onAttachedToEngine", "", "flutterPluginBinding", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "onDetachedFromEngine", "binding", "setUpHandlers", "performanceTrackingManager", "Lcom/deliveryhero/performance/core/analytics/PerformanceTrackingManager;", "performance_analytics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PerformanceAnalyticsPlugin implements FlutterPlugin, PerformanceAnalyticsInitializerApi {
    @Nullable
    private Context context;
    @Nullable
    private BinaryMessenger messenger;

    private final void setUpHandlers(Context context2, BinaryMessenger binaryMessenger, PerformanceTrackingManager performanceTrackingManager) {
        PerformanceAnalyticsAppStartupListenerApi.Companion.setUp(binaryMessenger, new PerformanceAnalyticsAppStartupListener(context2, performanceTrackingManager));
        PerformanceAnalyticsApi.Companion.setUp(binaryMessenger, new PerformanceAnalyticsImpl(performanceTrackingManager));
        PerformanceAnalyticsScreenTrackerApi.Companion.setUp(binaryMessenger, new PerformanceAnalyticsScreenTrackerImpl(performanceTrackingManager));
    }

    public boolean initialize(@NotNull InitializeParams initializeParams) {
        Context context2;
        Intrinsics.checkNotNullParameter(initializeParams, NativeProtocol.WEB_DIALOG_PARAMS);
        if (this.messenger == null || (context2 = this.context) == null) {
            PerformanceAnalyticsPluginKt.getLogTag();
            return false;
        }
        Intrinsics.checkNotNull(context2);
        FirebasePerformanceProvider.initialize(context2);
        PerformanceTrackingManagerImpl performanceTrackingManagerImpl = new PerformanceTrackingManagerImpl(CollectionsKt__CollectionsJVMKt.listOf(FirebasePerformanceProvider.getInstance()), new PerformanceAttributesProvider(initializeParams.getPerseusSessionId(), initializeParams.getPerseusClientId(), initializeParams.getFirebaseInstanceId()), new PerformanceTrackingManager.Params(true));
        Context context3 = this.context;
        Intrinsics.checkNotNull(context3);
        BinaryMessenger binaryMessenger = this.messenger;
        Intrinsics.checkNotNull(binaryMessenger);
        setUpHandlers(context3, binaryMessenger, performanceTrackingManagerImpl);
        return true;
    }

    public void onAttachedToEngine(@NotNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "flutterPluginBinding");
        this.context = flutterPluginBinding.getApplicationContext();
        this.messenger = flutterPluginBinding.getBinaryMessenger();
        PerformanceAnalyticsInitializerApi.Companion companion = PerformanceAnalyticsInitializerApi.Companion;
        BinaryMessenger binaryMessenger = flutterPluginBinding.getBinaryMessenger();
        Intrinsics.checkNotNullExpressionValue(binaryMessenger, "flutterPluginBinding.binaryMessenger");
        companion.setUp(binaryMessenger, this);
        PerformanceTrackingManager performanceTrackingManager = PerformanceAnalyticsPluginFacade.performanceTrackingManager;
        if (performanceTrackingManager != null) {
            Context applicationContext = flutterPluginBinding.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "flutterPluginBinding.applicationContext");
            BinaryMessenger binaryMessenger2 = flutterPluginBinding.getBinaryMessenger();
            Intrinsics.checkNotNullExpressionValue(binaryMessenger2, "flutterPluginBinding.binaryMessenger");
            setUpHandlers(applicationContext, binaryMessenger2, performanceTrackingManager);
        }
    }

    public void onDetachedFromEngine(@NotNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "binding");
        PerformanceAnalyticsAppStartupListenerApi.Companion companion = PerformanceAnalyticsAppStartupListenerApi.Companion;
        BinaryMessenger binaryMessenger = flutterPluginBinding.getBinaryMessenger();
        Intrinsics.checkNotNullExpressionValue(binaryMessenger, "binding.binaryMessenger");
        companion.setUp(binaryMessenger, (PerformanceAnalyticsAppStartupListenerApi) null);
        PerformanceAnalyticsInitializerApi.Companion companion2 = PerformanceAnalyticsInitializerApi.Companion;
        BinaryMessenger binaryMessenger2 = flutterPluginBinding.getBinaryMessenger();
        Intrinsics.checkNotNullExpressionValue(binaryMessenger2, "binding.binaryMessenger");
        companion2.setUp(binaryMessenger2, (PerformanceAnalyticsInitializerApi) null);
        PerformanceAnalyticsApi.Companion companion3 = PerformanceAnalyticsApi.Companion;
        BinaryMessenger binaryMessenger3 = flutterPluginBinding.getBinaryMessenger();
        Intrinsics.checkNotNullExpressionValue(binaryMessenger3, "binding.binaryMessenger");
        companion3.setUp(binaryMessenger3, (PerformanceAnalyticsApi) null);
        PerformanceAnalyticsScreenTrackerApi.Companion companion4 = PerformanceAnalyticsScreenTrackerApi.Companion;
        BinaryMessenger binaryMessenger4 = flutterPluginBinding.getBinaryMessenger();
        Intrinsics.checkNotNullExpressionValue(binaryMessenger4, "binding.binaryMessenger");
        companion4.setUp(binaryMessenger4, (PerformanceAnalyticsScreenTrackerApi) null);
        this.context = null;
        this.messenger = null;
    }
}
