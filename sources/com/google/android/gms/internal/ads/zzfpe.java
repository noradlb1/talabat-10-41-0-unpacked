package com.google.android.gms.internal.ads;

import android.net.Network;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.newrelic.agent.android.instrumentation.Instrumented;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

@Instrumented
public final class zzfpe extends zzfos {
    private zzfqs<Integer> zza;
    private zzfqs<Integer> zzb;
    @Nullable
    private zzfpd zzc;
    @Nullable
    private HttpURLConnection zzd;

    public zzfpe() {
        this(zzfpb.zza, zzfpc.zza, (zzfpd) null);
    }

    public zzfpe(zzfqs<Integer> zzfqs, zzfqs<Integer> zzfqs2, @Nullable zzfpd zzfpd) {
        this.zza = zzfqs;
        this.zzb = zzfqs2;
        this.zzc = zzfpd;
    }

    public static /* synthetic */ Integer zzf() {
        return -1;
    }

    public static /* synthetic */ Integer zzg() {
        return -1;
    }

    public static void zzs(@Nullable HttpURLConnection httpURLConnection) {
        zzfot.zza();
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    public void close() {
        zzs(this.zzd);
    }

    public HttpURLConnection zzm() throws IOException {
        zzfot.zzb(this.zza.zza().intValue(), this.zzb.zza().intValue());
        zzfpd zzfpd = this.zzc;
        zzfpd.getClass();
        HttpURLConnection httpURLConnection = (HttpURLConnection) zzfpd.zza();
        this.zzd = httpURLConnection;
        return httpURLConnection;
    }

    public HttpURLConnection zzn(zzfpd zzfpd, int i11, int i12) throws IOException {
        this.zza = new zzfoz(i11);
        this.zzb = new zzfpa(i12);
        this.zzc = zzfpd;
        return zzm();
    }

    @RequiresApi(21)
    public HttpURLConnection zzo(@NonNull Network network, @NonNull URL url, int i11, int i12) throws IOException {
        this.zza = new zzfox(i11);
        this.zzb = new zzfoy(i12);
        this.zzc = new zzfou(network, url);
        return zzm();
    }

    public URLConnection zzr(@NonNull URL url, int i11) throws IOException {
        this.zza = new zzfow(i11);
        this.zzc = new zzfov(url);
        return zzm();
    }
}
