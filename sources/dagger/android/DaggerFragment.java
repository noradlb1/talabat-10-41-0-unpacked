package dagger.android;

import android.app.Fragment;
import android.content.Context;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import javax.inject.Inject;

@Instrumented
@Deprecated
public abstract class DaggerFragment extends Fragment implements HasAndroidInjector, TraceFieldInterface {
    public Trace _nr_trace;
    @Inject

    /* renamed from: b  reason: collision with root package name */
    public DispatchingAndroidInjector<Object> f13830b;

    public void _nr_setTrace(Trace trace) {
        try {
            this._nr_trace = trace;
        } catch (Exception unused) {
        }
    }

    public AndroidInjector<Object> androidInjector() {
        return this.f13830b;
    }

    public void onAttach(Context context) {
        AndroidInjection.inject((Fragment) this);
        super.onAttach(context);
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }
}
