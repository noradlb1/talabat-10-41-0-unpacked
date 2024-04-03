package com.visa.checkout;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.http.SslError;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.c.c.d;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.ArrayList;

@Instrumented
public class l extends Activity implements TraceFieldInterface {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static int f261 = 1;

    /* renamed from: ˎ  reason: contains not printable characters */
    private static int f262;

    /* renamed from: ॱ  reason: contains not printable characters */
    private static int[] f263 = {230161111, -701121464, 1804360812, -1761551513, -281502208, 1865880950, 1259233535, -1051589266, 1679007823, -1951120569, 1267517477, -43963370, 75169441, -1216511979, -66053826, 394911529, 352013203, 663432599};
    public Trace _nr_trace;

    /* renamed from: ˋ  reason: contains not printable characters */
    private String f264;

    /* renamed from: ˏ  reason: contains not printable characters */
    private BroadcastReceiver f265 = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            l.m6207(l.this);
        }
    };

    /* renamed from: ˊ  reason: contains not printable characters */
    public static /* synthetic */ void m6207(l lVar) {
        int i11 = f261 + 93;
        f262 = i11 % 128;
        int i12 = i11 % 2;
        lVar.m6208(false);
        int i13 = f261 + 89;
        f262 = i13 % 128;
        int i14 = i13 % 2;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m6208(boolean z11) {
        boolean z12;
        Intent intent = new Intent(m6209(new int[]{508750984, 826516681, -2081387085, 334895803, 1340558376, 1032532271, 1004399178, -442146386, 739183183, 92976781, 165757244, -771530557, 1211537051, 667697165}, 25).intern());
        intent.putExtra(m6209(new int[]{-2069544534, 1377872411, -1403314976, -1015056099, 547625558, -726945807}, 9).intern(), z11);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
        finish();
        int i11 = f262 + 51;
        f261 = i11 % 128;
        if (i11 % 2 == 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z12) {
            throw null;
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static String m6209(int[] iArr, int i11) {
        char c11;
        int i12 = f261 + 55;
        f262 = i12 % 128;
        int i13 = i12 % 2;
        char[] cArr = new char[4];
        char[] cArr2 = new char[(iArr.length << 1)];
        int[] iArr2 = (int[]) f263.clone();
        int i14 = f261 + 81;
        f262 = i14 % 128;
        int i15 = i14 % 2;
        int i16 = 0;
        while (true) {
            if (i16 < iArr.length) {
                c11 = 27;
            } else {
                c11 = 10;
            }
            if (c11 != 27) {
                return new String(cArr2, 0, i11);
            }
            int i17 = f261 + 19;
            f262 = i17 % 128;
            int i18 = i17 % 2;
            int i19 = iArr[i16];
            cArr[0] = (char) (i19 >> 16);
            cArr[1] = (char) i19;
            int i21 = iArr[i16 + 1];
            cArr[2] = (char) (i21 >> 16);
            cArr[3] = (char) i21;
            d.m9228(cArr, iArr2, false);
            int i22 = i16 << 1;
            cArr2[i22] = cArr[0];
            cArr2[i22 + 1] = cArr[1];
            cArr2[i22 + 2] = cArr[2];
            cArr2[i22 + 3] = cArr[3];
            i16 += 2;
        }
    }

    public void onBackPressed() {
        int i11 = f262 + 39;
        f261 = i11 % 128;
        if (i11 % 2 == 0) {
            m6208(false);
        } else {
            m6208(true);
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public void onCreate(Bundle bundle) {
        char c11;
        TraceMachine.startTracing("l");
        try {
            TraceMachine.enterMethod(this._nr_trace, "l#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "l#onCreate", (ArrayList<String>) null);
        }
        super.onCreate(bundle);
        WebView webView = new WebView(this);
        webView.addJavascriptInterface(this, m6209(new int[]{-781808187, -43717273, 104363671, 1927632971, 1623494367, -504698722}, 11).intern());
        setContentView(webView);
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            int i11 = f261 + 117;
            f262 = i11 % 128;
            if (i11 % 2 != 0) {
                c11 = '1';
            } else {
                c11 = 'E';
            }
            if (c11 != '1') {
                TraceMachine.exitMethod();
                return;
            }
            throw null;
        }
        String intern = m6209(new int[]{-192123856, -1970849014, 1370695844, 215682279, -104456048, -411347049, 1825705250, -1387428529, -957510422, 58244812, 1068195154, 748473342, 588951432, -1491848373, 1838368126, 380895874, 1923264145, 1245191645, -432435115, -1212457278, 547625558, -726945807}, 41).intern();
        String string = extras.getString(m6209(new int[]{-1372407301, 1719191270, -34904515, 1667699065, 985550204, -799547636, -578667845, 967956668}, 15).intern());
        this.f264 = string;
        if (string != null) {
            webView.getSettings().setJavaScriptEnabled(true);
            webView.setWebViewClient(new WebViewClient() {
                public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                    super.onReceivedSslError(webView, sslErrorHandler, sslError);
                }
            });
            webView.loadUrl(intern);
            LocalBroadcastManager.getInstance(this).registerReceiver(this.f265, new IntentFilter(m6209(new int[]{-51660199, 967229017, -67368164, -277293293, 1494939838, -478831129, 1860831000, 405271556, 1995581051, 82875391, -1172152981, -1313265826}, 23).intern()));
            int i12 = f262 + 33;
            f261 = i12 % 128;
            int i13 = i12 % 2;
            TraceMachine.exitMethod();
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
        TraceMachine.exitMethod();
        throw illegalArgumentException;
    }

    public void onDestroy() {
        int i11 = f261 + 23;
        f262 = i11 % 128;
        int i12 = i11 % 2;
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.f265);
        super.onDestroy();
        int i13 = f262 + 107;
        f261 = i13 % 128;
        int i14 = i13 % 2;
    }

    public void onStart() {
        boolean z11;
        ApplicationStateMonitor.getInstance().activityStarted();
        int i11 = f261 + 53;
        f262 = i11 % 128;
        if (i11 % 2 != 0) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (!z11) {
            super.onStart();
            VisaCheckoutSdk.setAlreadyLaunched(this.f264);
            int i12 = 6 / 0;
        } else {
            super.onStart();
            VisaCheckoutSdk.setAlreadyLaunched(this.f264);
        }
        int i13 = f261 + 71;
        f262 = i13 % 128;
        int i14 = i13 % 2;
    }

    public void onStop() {
        char c11;
        ApplicationStateMonitor.getInstance().activityStopped();
        int i11 = f262 + 83;
        f261 = i11 % 128;
        if (i11 % 2 == 0) {
            c11 = '6';
        } else {
            c11 = 'K';
        }
        if (c11 == 'K') {
            VisaCheckoutSdk.clearAlreadyLaunchedIds();
            super.onStop();
            return;
        }
        VisaCheckoutSdk.clearAlreadyLaunchedIds();
        super.onStop();
        throw null;
    }

    @JavascriptInterface
    public void spinnerCloseMessage() {
        int i11 = f262 + 87;
        f261 = i11 % 128;
        if (i11 % 2 == 0) {
        }
        m6208(true);
    }
}
