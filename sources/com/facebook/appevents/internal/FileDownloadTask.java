package com.facebook.appevents.internal;

import android.os.AsyncTask;
import androidx.annotation.VisibleForTesting;
import com.braze.ui.actions.brazeactions.steps.StepData;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.URLConnectionInstrumentation;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Instrumented
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0001\u0012B\u001d\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ%\u0010\u000b\u001a\u00020\u00042\u0016\u0010\f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\r\"\u0004\u0018\u00010\u0002H\u0017¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004H\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/facebook/appevents/internal/FileDownloadTask;", "Landroid/os/AsyncTask;", "", "Ljava/lang/Void;", "", "uriStr", "destFile", "Ljava/io/File;", "onSuccess", "Lcom/facebook/appevents/internal/FileDownloadTask$Callback;", "(Ljava/lang/String;Ljava/io/File;Lcom/facebook/appevents/internal/FileDownloadTask$Callback;)V", "doInBackground", "args", "", "([Ljava/lang/String;)Ljava/lang/Boolean;", "onPostExecute", "", "isSuccess", "Callback", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class FileDownloadTask extends AsyncTask implements TraceFieldInterface {
    public Trace _nr_trace;
    @NotNull
    private final File destFile;
    @NotNull
    private final Callback onSuccess;
    @NotNull
    private final String uriStr;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/facebook/appevents/internal/FileDownloadTask$Callback;", "", "onComplete", "", "file", "Ljava/io/File;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface Callback {
        void onComplete(@NotNull File file);
    }

    public FileDownloadTask(@NotNull String str, @NotNull File file, @NotNull Callback callback) {
        Intrinsics.checkNotNullParameter(str, "uriStr");
        Intrinsics.checkNotNullParameter(file, "destFile");
        Intrinsics.checkNotNullParameter(callback, "onSuccess");
        this.uriStr = str;
        this.destFile = file;
        this.onSuccess = callback;
    }

    public void _nr_setTrace(Trace trace) {
        try {
            this._nr_trace = trace;
        } catch (Exception unused) {
        }
    }

    public /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "FileDownloadTask#doInBackground", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "FileDownloadTask#doInBackground", (ArrayList<String>) null);
        }
        Boolean doInBackground = doInBackground((String[]) objArr);
        TraceMachine.exitMethod();
        return doInBackground;
    }

    public /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "FileDownloadTask#onPostExecute", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "FileDownloadTask#onPostExecute", (ArrayList<String>) null);
        }
        onPostExecute(((Boolean) obj).booleanValue());
        TraceMachine.exitMethod();
    }

    @NotNull
    @VisibleForTesting(otherwise = 4)
    public Boolean doInBackground(@NotNull String... strArr) {
        Intrinsics.checkNotNullParameter(strArr, StepData.ARGS);
        try {
            URL url = new URL(this.uriStr);
            int contentLength = ((URLConnection) FirebasePerfUrlConnection.instrument(URLConnectionInstrumentation.openConnection(url.openConnection()))).getContentLength();
            DataInputStream dataInputStream = new DataInputStream(FirebasePerfUrlConnection.openStream(url));
            byte[] bArr = new byte[contentLength];
            dataInputStream.readFully(bArr);
            dataInputStream.close();
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(this.destFile));
            dataOutputStream.write(bArr);
            dataOutputStream.flush();
            dataOutputStream.close();
            return Boolean.TRUE;
        } catch (Exception unused) {
            return Boolean.FALSE;
        }
    }

    public void onPostExecute(boolean z11) {
        if (z11) {
            this.onSuccess.onComplete(this.destFile);
        }
    }
}
