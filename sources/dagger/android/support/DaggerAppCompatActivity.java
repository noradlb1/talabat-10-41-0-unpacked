package dagger.android.support;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.ContentView;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasAndroidInjector;
import java.util.ArrayList;
import javax.inject.Inject;

@Instrumented
public abstract class DaggerAppCompatActivity extends AppCompatActivity implements HasAndroidInjector, TraceFieldInterface {
    public Trace _nr_trace;
    @Inject

    /* renamed from: i  reason: collision with root package name */
    public DispatchingAndroidInjector<Object> f13831i;

    public DaggerAppCompatActivity() {
    }

    public void _nr_setTrace(Trace trace) {
        try {
            this._nr_trace = trace;
        } catch (Exception unused) {
        }
    }

    public AndroidInjector<Object> androidInjector() {
        return this.f13831i;
    }

    public void onCreate(@Nullable Bundle bundle) {
        TraceMachine.startTracing("DaggerAppCompatActivity");
        try {
            TraceMachine.enterMethod(this._nr_trace, "DaggerAppCompatActivity#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "DaggerAppCompatActivity#onCreate", (ArrayList<String>) null);
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

    @ContentView
    public DaggerAppCompatActivity(@LayoutRes int i11) {
        super(i11);
    }
}
