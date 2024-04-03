package com.google.android.material.datepicker;

import androidx.fragment.app.Fragment;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import java.util.LinkedHashSet;

@Instrumented
abstract class PickerFragment extends Fragment implements TraceFieldInterface {
    public Trace _nr_trace;
    protected final LinkedHashSet<OnSelectionChangedListener<Object>> onSelectionChangedListeners = new LinkedHashSet<>();

    public void _nr_setTrace(Trace trace) {
        try {
            this._nr_trace = trace;
        } catch (Exception unused) {
        }
    }

    public boolean addOnSelectionChangedListener(OnSelectionChangedListener<Object> onSelectionChangedListener) {
        return this.onSelectionChangedListeners.add(onSelectionChangedListener);
    }

    public void clearOnSelectionChangedListeners() {
        this.onSelectionChangedListeners.clear();
    }

    public abstract DateSelector<Object> getDateSelector();

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public boolean removeOnSelectionChangedListener(OnSelectionChangedListener<Object> onSelectionChangedListener) {
        return this.onSelectionChangedListeners.remove(onSelectionChangedListener);
    }
}
