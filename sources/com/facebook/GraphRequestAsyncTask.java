package com.facebook;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import androidx.annotation.VisibleForTesting;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u0000 #2\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001:\u0001#B\u001b\b\u0016\u0012\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007¢\u0006\u0002\u0010\bB\u0015\b\u0016\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\t¢\u0006\u0002\u0010\nB\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u000b¢\u0006\u0002\u0010\fB%\b\u0016\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007¢\u0006\u0002\u0010\u000fB\u001f\b\u0016\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\t¢\u0006\u0002\u0010\u0010B\u0017\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u0005\u001a\u00020\u000b¢\u0006\u0002\u0010\u0011J)\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0012\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0006\"\u00020\u0002H\u0017¢\u0006\u0002\u0010\u001cJ\u0016\u0010\u001d\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0014J\b\u0010 \u001a\u00020\u001eH\u0017J\b\u0010!\u001a\u00020\"H\u0016R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0004¢\u0006\u0002\n\u0000R.\u0010\u0015\u001a\n\u0018\u00010\u0013j\u0004\u0018\u0001`\u00142\u000e\u0010\u0012\u001a\n\u0018\u00010\u0013j\u0004\u0018\u0001`\u0014@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006$"}, d2 = {"Lcom/facebook/GraphRequestAsyncTask;", "Landroid/os/AsyncTask;", "Ljava/lang/Void;", "", "Lcom/facebook/GraphResponse;", "requests", "", "Lcom/facebook/GraphRequest;", "([Lcom/facebook/GraphRequest;)V", "", "(Ljava/util/Collection;)V", "Lcom/facebook/GraphRequestBatch;", "(Lcom/facebook/GraphRequestBatch;)V", "connection", "Ljava/net/HttpURLConnection;", "(Ljava/net/HttpURLConnection;[Lcom/facebook/GraphRequest;)V", "(Ljava/net/HttpURLConnection;Ljava/util/Collection;)V", "(Ljava/net/HttpURLConnection;Lcom/facebook/GraphRequestBatch;)V", "<set-?>", "Ljava/lang/Exception;", "Lkotlin/Exception;", "exception", "getException", "()Ljava/lang/Exception;", "getRequests", "()Lcom/facebook/GraphRequestBatch;", "doInBackground", "params", "([Ljava/lang/Void;)Ljava/util/List;", "onPostExecute", "", "result", "onPreExecute", "toString", "", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class GraphRequestAsyncTask extends AsyncTask implements TraceFieldInterface {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = GraphRequestAsyncTask.class.getCanonicalName();
    public Trace _nr_trace;
    @Nullable
    private final HttpURLConnection connection;
    @Nullable
    private Exception exception;
    @NotNull
    private final GraphRequestBatch requests;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/facebook/GraphRequestAsyncTask$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public GraphRequestAsyncTask(@Nullable HttpURLConnection httpURLConnection, @NotNull GraphRequestBatch graphRequestBatch) {
        Intrinsics.checkNotNullParameter(graphRequestBatch, "requests");
        this.connection = httpURLConnection;
        this.requests = graphRequestBatch;
    }

    public void _nr_setTrace(Trace trace) {
        try {
            this._nr_trace = trace;
        } catch (Exception unused) {
        }
    }

    public /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "GraphRequestAsyncTask#doInBackground", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "GraphRequestAsyncTask#doInBackground", (ArrayList<String>) null);
        }
        List<GraphResponse> doInBackground = doInBackground((Void[]) objArr);
        TraceMachine.exitMethod();
        return doInBackground;
    }

    @Nullable
    public final Exception getException() {
        return this.exception;
    }

    @NotNull
    public final GraphRequestBatch getRequests() {
        return this.requests;
    }

    public /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "GraphRequestAsyncTask#onPostExecute", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "GraphRequestAsyncTask#onPostExecute", (ArrayList<String>) null);
        }
        onPostExecute((List<GraphResponse>) (List) obj);
        TraceMachine.exitMethod();
    }

    @VisibleForTesting(otherwise = 4)
    public void onPreExecute() {
        Handler handler;
        super.onPreExecute();
        if (FacebookSdk.isDebugEnabled()) {
            Utility utility = Utility.INSTANCE;
            String str = TAG;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("execute async task: %s", Arrays.copyOf(new Object[]{this}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
            Utility.logd(str, format);
        }
        if (this.requests.getCallbackHandler() == null) {
            if (Thread.currentThread() instanceof HandlerThread) {
                handler = new Handler();
            } else {
                handler = new Handler(Looper.getMainLooper());
            }
            this.requests.setCallbackHandler(handler);
        }
    }

    @NotNull
    public String toString() {
        String str = "{RequestAsyncTask: " + " connection: " + this.connection + ", requests: " + this.requests + "}";
        Intrinsics.checkNotNullExpressionValue(str, "StringBuilder()\n        .append(\"{RequestAsyncTask: \")\n        .append(\" connection: \")\n        .append(connection)\n        .append(\", requests: \")\n        .append(requests)\n        .append(\"}\")\n        .toString()");
        return str;
    }

    @VisibleForTesting(otherwise = 4)
    @Nullable
    public List<GraphResponse> doInBackground(@NotNull Void... voidArr) {
        Intrinsics.checkNotNullParameter(voidArr, NativeProtocol.WEB_DIALOG_PARAMS);
        try {
            HttpURLConnection httpURLConnection = this.connection;
            if (httpURLConnection == null) {
                return this.requests.executeAndWait();
            }
            return GraphRequest.Companion.executeConnectionAndWait(httpURLConnection, this.requests);
        } catch (Exception e11) {
            this.exception = e11;
            return null;
        }
    }

    public void onPostExecute(@NotNull List<GraphResponse> list) {
        Intrinsics.checkNotNullParameter(list, "result");
        super.onPostExecute(list);
        Exception exc = this.exception;
        if (exc != null) {
            Utility utility = Utility.INSTANCE;
            String str = TAG;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("onPostExecute: exception encountered during request: %s", Arrays.copyOf(new Object[]{exc.getMessage()}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
            Utility.logd(str, format);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GraphRequestAsyncTask(@NotNull GraphRequest... graphRequestArr) {
        this((HttpURLConnection) null, new GraphRequestBatch((GraphRequest[]) Arrays.copyOf(graphRequestArr, graphRequestArr.length)));
        Intrinsics.checkNotNullParameter(graphRequestArr, "requests");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GraphRequestAsyncTask(@NotNull Collection<GraphRequest> collection) {
        this((HttpURLConnection) null, new GraphRequestBatch(collection));
        Intrinsics.checkNotNullParameter(collection, "requests");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GraphRequestAsyncTask(@NotNull GraphRequestBatch graphRequestBatch) {
        this((HttpURLConnection) null, graphRequestBatch);
        Intrinsics.checkNotNullParameter(graphRequestBatch, "requests");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GraphRequestAsyncTask(@Nullable HttpURLConnection httpURLConnection, @NotNull GraphRequest... graphRequestArr) {
        this(httpURLConnection, new GraphRequestBatch((GraphRequest[]) Arrays.copyOf(graphRequestArr, graphRequestArr.length)));
        Intrinsics.checkNotNullParameter(graphRequestArr, "requests");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GraphRequestAsyncTask(@Nullable HttpURLConnection httpURLConnection, @NotNull Collection<GraphRequest> collection) {
        this(httpURLConnection, new GraphRequestBatch(collection));
        Intrinsics.checkNotNullParameter(collection, "requests");
    }
}
