package com.adjust.sdk;

import android.net.Uri;
import com.newrelic.agent.android.instrumentation.Instrumented;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Instrumented
public final class AdjustLinkResolution {
    private static volatile ExecutorService executor = null;
    private static final String[] expectedUrlHostSuffixArray = {"adjust.com", "adj.st", "go.link"};
    private static final int maxRecursions = 10;

    public interface AdjustLinkResolutionCallback {
        void resolvedLinkCallback(Uri uri);
    }

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ URL f39912a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AdjustLinkResolutionCallback f39913b;

        public a(URL url, AdjustLinkResolutionCallback adjustLinkResolutionCallback) {
            this.f39912a = url;
            this.f39913b = adjustLinkResolutionCallback;
        }

        public final void run() {
            AdjustLinkResolution.requestAndResolve(this.f39912a, 0, this.f39913b);
        }
    }

    private AdjustLinkResolution() {
    }

    private static URL convertToHttps(URL url) {
        String externalForm;
        if (url == null || (externalForm = url.toExternalForm()) == null || !externalForm.startsWith("http:")) {
            return url;
        }
        try {
            return new URL("https:" + externalForm.substring(5));
        } catch (MalformedURLException unused) {
            return url;
        }
    }

    private static Uri convertToUri(URL url) {
        if (url == null) {
            return null;
        }
        return Uri.parse(url.toString());
    }

    private static boolean isTerminalUrl(String str) {
        return urlMatchesSuffix(str, expectedUrlHostSuffixArray);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002f, code lost:
        if (r1 != null) goto L_0x002a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void requestAndResolve(java.net.URL r4, int r5, com.adjust.sdk.AdjustLinkResolution.AdjustLinkResolutionCallback r6) {
        /*
            java.net.URL r4 = convertToHttps(r4)
            r0 = 0
            java.net.URLConnection r1 = r4.openConnection()     // Catch:{ all -> 0x002e }
            java.net.URLConnection r1 = com.newrelic.agent.android.instrumentation.URLConnectionInstrumentation.openConnection(r1)     // Catch:{ all -> 0x002e }
            java.lang.Object r1 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r1)     // Catch:{ all -> 0x002e }
            java.net.URLConnection r1 = (java.net.URLConnection) r1     // Catch:{ all -> 0x002e }
            java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{ all -> 0x002e }
            r2 = 0
            r1.setInstanceFollowRedirects(r2)     // Catch:{ all -> 0x002f }
            r1.connect()     // Catch:{ all -> 0x002f }
            java.lang.String r2 = "Location"
            java.lang.String r2 = r1.getHeaderField(r2)     // Catch:{ all -> 0x002f }
            if (r2 == 0) goto L_0x002a
            java.net.URL r3 = new java.net.URL     // Catch:{ all -> 0x002f }
            r3.<init>(r2)     // Catch:{ all -> 0x002f }
            r0 = r3
        L_0x002a:
            r1.disconnect()
            goto L_0x0032
        L_0x002e:
            r1 = r0
        L_0x002f:
            if (r1 == 0) goto L_0x0032
            goto L_0x002a
        L_0x0032:
            int r5 = r5 + 1
            resolveLink(r0, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adjust.sdk.AdjustLinkResolution.requestAndResolve(java.net.URL, int, com.adjust.sdk.AdjustLinkResolution$AdjustLinkResolutionCallback):void");
    }

    public static void resolveLink(String str, String[] strArr, AdjustLinkResolutionCallback adjustLinkResolutionCallback) {
        URL url;
        if (adjustLinkResolutionCallback != null) {
            if (str == null) {
                adjustLinkResolutionCallback.resolvedLinkCallback((Uri) null);
                return;
            }
            try {
                url = new URL(str);
            } catch (MalformedURLException unused) {
                url = null;
            }
            if (url == null) {
                adjustLinkResolutionCallback.resolvedLinkCallback((Uri) null);
            } else if (!urlMatchesSuffix(url.getHost(), strArr)) {
                adjustLinkResolutionCallback.resolvedLinkCallback(convertToUri(url));
            } else {
                if (executor == null) {
                    synchronized (expectedUrlHostSuffixArray) {
                        if (executor == null) {
                            executor = Executors.newSingleThreadExecutor();
                        }
                    }
                }
                executor.execute(new a(url, adjustLinkResolutionCallback));
            }
        }
    }

    private static void resolveLink(URL url, URL url2, int i11, AdjustLinkResolutionCallback adjustLinkResolutionCallback) {
        Uri convertToUri;
        if (url == null) {
            convertToUri = convertToUri(url2);
        } else if (!isTerminalUrl(url.getHost()) && i11 <= 10) {
            requestAndResolve(url, i11, adjustLinkResolutionCallback);
            return;
        } else {
            convertToUri = convertToUri(url);
        }
        adjustLinkResolutionCallback.resolvedLinkCallback(convertToUri);
    }

    private static boolean urlMatchesSuffix(String str, String[] strArr) {
        if (str == null || strArr == null) {
            return false;
        }
        for (String endsWith : strArr) {
            if (str.endsWith(endsWith)) {
                return true;
            }
        }
        return false;
    }
}
