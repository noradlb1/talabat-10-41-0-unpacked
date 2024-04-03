package com.airbnb.lottie.network;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.URLConnectionInstrumentation;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

@Instrumented
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class DefaultLottieNetworkFetcher implements LottieNetworkFetcher {
    @NonNull
    public LottieFetchResult fetchSync(@NonNull String str) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(URLConnectionInstrumentation.openConnection(new URL(str).openConnection())));
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.connect();
        return new DefaultLottieFetchResult(httpURLConnection);
    }
}
