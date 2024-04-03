package com.google.android.gms.ads.identifier;

import android.util.Log;
import androidx.annotation.WorkerThread;
import com.google.android.gms.internal.ads_identifier.zzi;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.URLConnectionInstrumentation;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.commons.compress.archivers.tar.TarConstants;

@Instrumented
public final class zzc {
    @WorkerThread
    public static final void zza(String str) {
        HttpURLConnection httpURLConnection;
        try {
            zzi.zzb(TarConstants.VERSION_OFFSET);
            httpURLConnection = (HttpURLConnection) URLConnectionInstrumentation.openConnection(new URL(str).openConnection());
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode < 200 || responseCode >= 300) {
                StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 65);
                sb2.append("Received non-success response code ");
                sb2.append(responseCode);
                sb2.append(" from pinging URL: ");
                sb2.append(str);
                Log.w("HttpUrlPinger", sb2.toString());
            }
            httpURLConnection.disconnect();
            zzi.zza();
        } catch (IndexOutOfBoundsException e11) {
            String message = e11.getMessage();
            StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 32 + String.valueOf(message).length());
            sb3.append("Error while parsing ping URL: ");
            sb3.append(str);
            sb3.append(". ");
            sb3.append(message);
            Log.w("HttpUrlPinger", sb3.toString(), e11);
            zzi.zza();
        } catch (IOException | RuntimeException e12) {
            try {
                String message2 = e12.getMessage();
                StringBuilder sb4 = new StringBuilder(String.valueOf(str).length() + 27 + String.valueOf(message2).length());
                sb4.append("Error while pinging URL: ");
                sb4.append(str);
                sb4.append(". ");
                sb4.append(message2);
                Log.w("HttpUrlPinger", sb4.toString(), e12);
            } finally {
                zzi.zza();
            }
        } catch (Throwable th2) {
            httpURLConnection.disconnect();
            throw th2;
        }
    }
}
