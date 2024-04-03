package com.google.android.recaptcha.internal;

import android.net.TrafficStats;
import android.webkit.URLUtil;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.URLConnectionInstrumentation;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Instrumented
public final class zzaq implements zzap {
    @NotNull
    private final String zza;

    public zzaq(@NotNull String str) {
        this.zza = str;
    }

    private static final void zzb(byte[] bArr) {
        for (zzlo zzlo : zzlr.zzk(bArr).zzG()) {
            if (!CollectionsKt__CollectionsKt.listOf("INIT_TOTAL", "EXECUTE_TOTAL").contains(zzlo.zzj().name()) || !zzlo.zzS()) {
                zzlo.zzH();
                zzlo.zzI();
                zzlo.zzj().name();
                zzlo.zzT();
            } else {
                zzlo.zzH();
                zzlo.zzI();
                zzlo.zzj().name();
                zzlo.zzg().zzk();
                zzlo.zzg().zzf();
                zzlo.zzT();
            }
        }
    }

    public final boolean zza(@NotNull byte[] bArr) {
        HttpURLConnection httpURLConnection;
        try {
            TrafficStats.setThreadStatsTag((int) Thread.currentThread().getId());
            zzb(bArr);
            if (URLUtil.isHttpUrl(this.zza)) {
                URLConnection uRLConnection = (URLConnection) FirebasePerfUrlConnection.instrument(URLConnectionInstrumentation.openConnection(new URL(this.zza).openConnection()));
                Intrinsics.checkNotNull(uRLConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
                httpURLConnection = (HttpURLConnection) uRLConnection;
            } else if (URLUtil.isHttpsUrl(this.zza)) {
                URLConnection uRLConnection2 = (URLConnection) FirebasePerfUrlConnection.instrument(URLConnectionInstrumentation.openConnection(new URL(this.zza).openConnection()));
                Intrinsics.checkNotNull(uRLConnection2, "null cannot be cast to non-null type javax.net.ssl.HttpsURLConnection");
                httpURLConnection = (HttpsURLConnection) uRLConnection2;
            } else {
                throw new MalformedURLException("Recaptcha server url only allows using Http or Https.");
            }
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestProperty("Content-Type", "application/x-protobuffer");
            httpURLConnection.connect();
            httpURLConnection.getOutputStream().write(bArr);
            if (httpURLConnection.getResponseCode() == 200) {
                return true;
            }
            return false;
        } catch (Exception e11) {
            e11.getMessage();
            return false;
        }
    }
}
