package dagger.android.support;

import android.content.Context;
import androidx.fragment.app.DialogFragment;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasAndroidInjector;
import javax.inject.Inject;

@Instrumented
public abstract class DaggerDialogFragment extends DialogFragment implements HasAndroidInjector, TraceFieldInterface {
    @Inject
    public DispatchingAndroidInjector<Object> C;
    public Trace _nr_trace;

    public void _nr_setTrace(Trace trace) {
        try {
            this._nr_trace = trace;
        } catch (Exception unused) {
        }
    }

    public AndroidInjector<Object> androidInjector() {
        return this.C;
    }

    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }
}
