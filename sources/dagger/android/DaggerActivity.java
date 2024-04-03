package dagger.android;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.ArrayList;
import javax.inject.Inject;

@Instrumented
public abstract class DaggerActivity extends Activity implements HasAndroidInjector, TraceFieldInterface {
    public Trace _nr_trace;
    @Inject

    /* renamed from: b  reason: collision with root package name */
    public DispatchingAndroidInjector<Object> f13827b;

    public void _nr_setTrace(Trace trace) {
        try {
            this._nr_trace = trace;
        } catch (Exception unused) {
        }
    }

    public AndroidInjector<Object> androidInjector() {
        return this.f13827b;
    }

    public void onCreate(@Nullable Bundle bundle) {
        TraceMachine.startTracing("DaggerActivity");
        try {
            TraceMachine.enterMethod(this._nr_trace, "DaggerActivity#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "DaggerActivity#onCreate", (ArrayList<String>) null);
        }
        AndroidInjection.inject((Activity) this);
        super.onCreate(bundle);
        TraceMachine.exitMethod();
    }

    public void onStart() {
        super.onStart();
        ApplicationStateMonitor.getInstance().activityStarted();
    }

    public void onStop() {
        super.onStop();
        ApplicationStateMonitor.getInstance().activityStopped();
    }
}
