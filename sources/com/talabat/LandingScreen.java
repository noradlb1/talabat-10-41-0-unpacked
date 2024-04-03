package com.talabat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.splashscreen.SplashScreen;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.observability.localTracer.PointOfInterest;
import com.talabat.observability.localTracer.PointOfInterestReporter;
import com.talabat.observability.localTracer.SectionOfInterest;
import com.talabat.observability.performance.PerformanceTracker;
import com.talabat.observability.tracker.TimeTrackerImplementation;
import com.talabat.observability.tracker.TimeTrackerKt;
import com.talabat.splash.presentation.ui.SplashActivity;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014J\b\u0010\u0007\u001a\u00020\u0004H\u0014¨\u0006\t"}, d2 = {"Lcom/talabat/LandingScreen;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "Companion", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LandingScreen extends AppCompatActivity implements TraceFieldInterface {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String TIME_EVENT_LANDING_SCREEN = "TIME_EVENT_LANDING_SCREEN";
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/LandingScreen$Companion;", "", "()V", "TIME_EVENT_LANDING_SCREEN", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i11) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i11));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i11);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i11), findViewById);
        return findViewById;
    }

    public void onCreate(@Nullable Bundle bundle) {
        TraceMachine.startTracing("LandingScreen");
        try {
            TraceMachine.enterMethod(this._nr_trace, "LandingScreen#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "LandingScreen#onCreate", (ArrayList<String>) null);
        }
        PointOfInterestReporter.INSTANCE.startTraceLog(SectionOfInterest.LANDING_SCREEN, PointOfInterest.TOTAL_TIME);
        TimeTrackerImplementation.startTracking$default(TimeTrackerKt.getTimeTracker(), TIME_EVENT_LANDING_SCREEN, 0, 2, (Object) null);
        super.onCreate(bundle);
        getWindow().setFlags(512, 512);
        SplashScreen.Companion.installSplashScreen(this);
        TraceMachine.exitMethod();
    }

    public void onStart() {
        ApplicationStateMonitor.getInstance().activityStarted();
        super.onStart();
        PerformanceTracker performanceTracker = PerformanceTracker.INSTANCE;
        performanceTracker.startTrace("landingScreenTrace");
        Intent intent = new Intent(this, SplashActivity.class);
        if (getIntent() != null) {
            intent.setData(getIntent().getData());
        }
        startActivity(intent);
        finish();
        TimeTrackerImplementation.stopTracking$default(TimeTrackerKt.getTimeTracker(), TIME_EVENT_LANDING_SCREEN, 0, 2, (Object) null);
        performanceTracker.stopTrace("landingScreenTrace");
        PointOfInterestReporter.INSTANCE.endTraceLog(SectionOfInterest.LANDING_SCREEN, PointOfInterest.TOTAL_TIME);
    }

    public void onStop() {
        super.onStop();
        ApplicationStateMonitor.getInstance().activityStopped();
    }
}
