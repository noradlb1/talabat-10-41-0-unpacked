package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.URLConnectionInstrumentation;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import org.json.JSONException;

@Instrumented
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabx  reason: invalid package */
public final class zzabx {
    public static void zza(String str, zzabu zzabu, Type type, zzabd zzabd) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) URLConnectionInstrumentation.openConnection(new URL(str).openConnection());
            httpURLConnection.setConnectTimeout(60000);
            zzabd.zza(httpURLConnection);
            zzc(httpURLConnection, zzabu, type);
        } catch (SocketTimeoutException unused) {
            zzabu.zza("TIMEOUT");
        } catch (UnknownHostException unused2) {
            zzabu.zza("<<Network Error>>");
        } catch (IOException e11) {
            zzabu.zza(e11.getMessage());
        }
    }

    public static void zzb(String str, zzaaz zzaaz, zzabu zzabu, Type type, zzabd zzabd) {
        BufferedOutputStream bufferedOutputStream;
        try {
            Preconditions.checkNotNull(zzaaz);
            HttpURLConnection httpURLConnection = (HttpURLConnection) URLConnectionInstrumentation.openConnection(new URL(str).openConnection());
            httpURLConnection.setDoOutput(true);
            byte[] bytes = zzaaz.zza().getBytes(Charset.defaultCharset());
            int length = bytes.length;
            httpURLConnection.setFixedLengthStreamingMode(length);
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.setConnectTimeout(60000);
            zzabd.zza(httpURLConnection);
            bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream(), length);
            bufferedOutputStream.write(bytes, 0, length);
            bufferedOutputStream.close();
            zzc(httpURLConnection, zzabu, type);
            return;
        } catch (SocketTimeoutException unused) {
            zzabu.zza("TIMEOUT");
            return;
        } catch (UnknownHostException unused2) {
            zzabu.zza("<<Network Error>>");
            return;
        } catch (IOException | NullPointerException | JSONException e11) {
            zzabu.zza(e11.getMessage());
            return;
        } catch (Throwable th2) {
            zzabw.zza(th, th2);
        }
        throw th;
    }

    private static void zzc(HttpURLConnection httpURLConnection, zzabu zzabu, Type type) {
        InputStream inputStream;
        BufferedReader bufferedReader;
        try {
            int responseCode = httpURLConnection.getResponseCode();
            if (zzd(responseCode)) {
                inputStream = httpURLConnection.getInputStream();
            } else {
                inputStream = httpURLConnection.getErrorStream();
            }
            StringBuilder sb2 = new StringBuilder();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb2.append(readLine);
            }
            bufferedReader.close();
            String sb3 = sb2.toString();
            if (!zzd(responseCode)) {
                zzabu.zza((String) zzaay.zza(sb3, String.class));
            } else {
                zzabu.zzb((zzaba) zzaay.zza(sb3, type));
            }
            httpURLConnection.disconnect();
            return;
        } catch (SocketTimeoutException unused) {
            zzabu.zza("TIMEOUT");
            httpURLConnection.disconnect();
            return;
        } catch (zzyq | IOException e11) {
            try {
                zzabu.zza(e11.getMessage());
                return;
            } finally {
                httpURLConnection.disconnect();
            }
        } catch (Throwable th2) {
            zzabw.zza(th, th2);
        }
        throw th;
    }

    private static final boolean zzd(int i11) {
        return i11 >= 200 && i11 < 300;
    }
}
