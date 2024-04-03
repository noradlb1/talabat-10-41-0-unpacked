package com.google.android.gms.internal.ads;

import android.net.TrafficStats;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.URLConnectionInstrumentation;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.commons.compress.archivers.tar.TarConstants;

@Instrumented
public class zzcje implements zzcir {
    @Nullable
    private final String zza;

    public zzcje() {
        this.zza = null;
    }

    public zzcje(@Nullable String str) {
        this.zza = str;
    }

    @WorkerThread
    public void zza(String str) {
        String str2;
        HttpURLConnection httpURLConnection;
        try {
            if (ClientLibraryUtils.isPackageSide()) {
                TrafficStats.setThreadStatsTag(TarConstants.VERSION_OFFSET);
            }
            String valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                str2 = "Pinging URL: ".concat(valueOf);
            } else {
                str2 = new String("Pinging URL: ");
            }
            zzciz.zze(str2);
            httpURLConnection = (HttpURLConnection) URLConnectionInstrumentation.openConnection(new URL(str).openConnection());
            zzbgo.zzb();
            String str3 = this.zza;
            httpURLConnection.setConnectTimeout(60000);
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.setReadTimeout(60000);
            if (str3 != null) {
                httpURLConnection.setRequestProperty("User-Agent", str3);
            }
            httpURLConnection.setUseCaches(false);
            zzciy zzciy = new zzciy((String) null);
            zzciy.zzc(httpURLConnection, (byte[]) null);
            int responseCode = httpURLConnection.getResponseCode();
            zzciy.zze(httpURLConnection, responseCode);
            if (responseCode < 200 || responseCode >= 300) {
                StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 65);
                sb2.append("Received non-success response code ");
                sb2.append(responseCode);
                sb2.append(" from pinging URL: ");
                sb2.append(str);
                zzciz.zzj(sb2.toString());
            }
            httpURLConnection.disconnect();
            if (ClientLibraryUtils.isPackageSide()) {
                TrafficStats.clearThreadStatsTag();
            }
        } catch (IndexOutOfBoundsException e11) {
            String message = e11.getMessage();
            StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 32 + String.valueOf(message).length());
            sb3.append("Error while parsing ping URL: ");
            sb3.append(str);
            sb3.append(". ");
            sb3.append(message);
            zzciz.zzj(sb3.toString());
            if (ClientLibraryUtils.isPackageSide()) {
                TrafficStats.clearThreadStatsTag();
            }
        } catch (IOException | RuntimeException e12) {
            try {
                String message2 = e12.getMessage();
                StringBuilder sb4 = new StringBuilder(String.valueOf(str).length() + 27 + String.valueOf(message2).length());
                sb4.append("Error while pinging URL: ");
                sb4.append(str);
                sb4.append(". ");
                sb4.append(message2);
                zzciz.zzj(sb4.toString());
            } finally {
                if (ClientLibraryUtils.isPackageSide()) {
                    TrafficStats.clearThreadStatsTag();
                }
            }
        } catch (Throwable th2) {
            httpURLConnection.disconnect();
            throw th2;
        }
    }
}
