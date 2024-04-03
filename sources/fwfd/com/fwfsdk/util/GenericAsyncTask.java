package fwfd.com.fwfsdk.util;

import android.os.AsyncTask;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.ArrayList;

@Instrumented
public abstract class GenericAsyncTask<T> {
    /* access modifiers changed from: private */
    public GenericAsyncTaskCallback callback;

    public interface GenericAsyncTaskCallback<T> {
        void onResult(T t11);
    }

    @Instrumented
    public class GenericProcessAsyncTask extends AsyncTask implements TraceFieldInterface {
        public Trace _nr_trace;

        private GenericProcessAsyncTask() {
        }

        public void _nr_setTrace(Trace trace) {
            try {
                this._nr_trace = trace;
            } catch (Exception unused) {
            }
        }

        public /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
            try {
                TraceMachine.enterMethod(this._nr_trace, "GenericAsyncTask$GenericProcessAsyncTask#doInBackground", (ArrayList<String>) null);
            } catch (NoSuchFieldError unused) {
                TraceMachine.enterMethod((Trace) null, "GenericAsyncTask$GenericProcessAsyncTask#doInBackground", (ArrayList<String>) null);
            }
            Object doInBackground = doInBackground((Void[]) objArr);
            TraceMachine.exitMethod();
            return doInBackground;
        }

        public void onPostExecute(T t11) {
            try {
                TraceMachine.enterMethod(this._nr_trace, "GenericAsyncTask$GenericProcessAsyncTask#onPostExecute", (ArrayList<String>) null);
            } catch (NoSuchFieldError unused) {
                TraceMachine.enterMethod((Trace) null, "GenericAsyncTask$GenericProcessAsyncTask#onPostExecute", (ArrayList<String>) null);
            }
            if (GenericAsyncTask.this.callback != null) {
                GenericAsyncTask.this.callback.onResult(t11);
            }
            TraceMachine.exitMethod();
        }

        public T doInBackground(Void... voidArr) {
            return GenericAsyncTask.this.doAsync();
        }
    }

    public GenericAsyncTask(GenericAsyncTaskCallback genericAsyncTaskCallback) {
        this.callback = genericAsyncTaskCallback;
    }

    public abstract T doAsync();

    public void start() {
        AsyncTaskInstrumentation.execute(new GenericProcessAsyncTask(), new Void[0]);
    }
}
