package com.google.android.gms.internal.ads;

import androidx.webkit.ProxyConfig;
import com.google.android.gms.ads.internal.zzt;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.URLConnectionInstrumentation;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

@Instrumented
public final /* synthetic */ class zzcnh implements zzfpd {
    public final /* synthetic */ String zza;

    public /* synthetic */ zzcnh(String str) {
        this.zza = str;
    }

    public final URLConnection zza() {
        String str;
        String str2;
        String str3 = this.zza;
        int i11 = zzcni.zzd;
        zzt.zzw();
        int intValue = ((Integer) zzbgq.zzc().zzb(zzblj.zzu)).intValue();
        URL url = new URL(str3);
        int i12 = 0;
        while (true) {
            i12++;
            if (i12 <= 20) {
                URLConnection openConnection = URLConnectionInstrumentation.openConnection(url.openConnection());
                openConnection.setConnectTimeout(intValue);
                openConnection.setReadTimeout(intValue);
                if (openConnection instanceof HttpURLConnection) {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
                    zzciy zzciy = new zzciy((String) null);
                    zzciy.zzc(httpURLConnection, (byte[]) null);
                    httpURLConnection.setInstanceFollowRedirects(false);
                    int responseCode = httpURLConnection.getResponseCode();
                    zzciy.zze(httpURLConnection, responseCode);
                    if (responseCode / 100 != 3) {
                        return httpURLConnection;
                    }
                    String headerField = httpURLConnection.getHeaderField("Location");
                    if (headerField != null) {
                        URL url2 = new URL(url, headerField);
                        String protocol = url2.getProtocol();
                        if (protocol == null) {
                            throw new IOException("Protocol is null");
                        } else if (protocol.equals(ProxyConfig.MATCH_HTTP) || protocol.equals("https")) {
                            if (headerField.length() != 0) {
                                str = "Redirecting to ".concat(headerField);
                            } else {
                                str = new String("Redirecting to ");
                            }
                            zzciz.zze(str);
                            httpURLConnection.disconnect();
                            url = url2;
                        } else {
                            if (protocol.length() != 0) {
                                str2 = "Unsupported scheme: ".concat(protocol);
                            } else {
                                str2 = new String("Unsupported scheme: ");
                            }
                            throw new IOException(str2);
                        }
                    } else {
                        throw new IOException("Missing Location header in redirect");
                    }
                } else {
                    throw new IOException("Invalid protocol.");
                }
            } else {
                throw new IOException("Too many redirects (20)");
            }
        }
    }
}
