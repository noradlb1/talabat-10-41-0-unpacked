package com.google.android.gms.internal.p002firebaseauthapi;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.internal.zzai;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

@Instrumented
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaar  reason: invalid package */
public final class zzaar extends AsyncTask implements TraceFieldInterface {
    private static final Logger zza = new Logger("FirebaseAuth", "GetAuthDomainTask");
    public Trace _nr_trace;
    private final String zzb;
    private final String zzc;
    private final WeakReference zzd;
    private final Uri.Builder zze;
    private final String zzf;
    private final FirebaseApp zzg;

    public zzaar(String str, String str2, Intent intent, FirebaseApp firebaseApp, zzaat zzaat) {
        this.zzb = Preconditions.checkNotEmpty(str);
        this.zzg = (FirebaseApp) Preconditions.checkNotNull(firebaseApp);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(intent);
        String checkNotEmpty = Preconditions.checkNotEmpty(intent.getStringExtra("com.google.firebase.auth.KEY_API_KEY"));
        Uri.Builder buildUpon = Uri.parse(zzaat.zzc(checkNotEmpty)).buildUpon();
        buildUpon.appendPath("getProjectConfig").appendQueryParameter("key", checkNotEmpty).appendQueryParameter("androidPackageName", str).appendQueryParameter("sha1Cert", (String) Preconditions.checkNotNull(str2));
        this.zzc = buildUpon.build().toString();
        this.zzd = new WeakReference(zzaat);
        this.zze = zzaat.zzb(intent, str, str2);
        this.zzf = intent.getStringExtra("com.google.firebase.auth.KEY_CUSTOM_AUTH_DOMAIN");
    }

    private final void zza(zzaaq zzaaq) {
        String str;
        String str2;
        Uri.Builder builder;
        zzaat zzaat = (zzaat) this.zzd.get();
        if (zzaaq != null) {
            str2 = zzaaq.zzc();
            str = zzaaq.zzd();
        } else {
            str2 = null;
            str = null;
        }
        if (zzaat == null) {
            zza.e("An error has occurred: the handler reference has returned null.", new Object[0]);
        } else if (TextUtils.isEmpty(str2) || (builder = this.zze) == null) {
            zzaat.zze(this.zzb, zzai.zza(str));
        } else {
            builder.authority(str2);
            zzaat.zzf(this.zze.build(), this.zzb, FirebaseAuth.getInstance(this.zzg).zzE());
        }
    }

    private static byte[] zzb(InputStream inputStream, int i11) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[128];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } finally {
            byteArrayOutputStream.close();
        }
    }

    public void _nr_setTrace(Trace trace) {
        try {
            this._nr_trace = trace;
        } catch (Exception unused) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00d4, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        zza.w("Error parsing error message from response body in getErrorMessageFromBody. ".concat(r0.toString()), new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0105, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0106, code lost:
        zza.e("ConversionException encountered: ".concat(java.lang.String.valueOf(r0.getMessage())), new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x011c, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x011d, code lost:
        zza.e("Null pointer encountered: ".concat(java.lang.String.valueOf(r0.getMessage())), new java.lang.Object[0]);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0082 A[Catch:{ IOException -> 0x0133, NullPointerException -> 0x011c, zzyq -> 0x0105 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0105 A[ExcHandler: zzyq (r0v9 'e' com.google.android.gms.internal.firebase-auth-api.zzyq A[CUSTOM_DECLARE]), Splitter:B:9:0x001f] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x011c A[ExcHandler: NullPointerException (r0v5 'e' java.lang.NullPointerException A[CUSTOM_DECLARE]), Splitter:B:9:0x001f] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0149 A[EDGE_INSN: B:40:0x0149->B:38:0x0149 ?: BREAK  , SYNTHETIC] */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* bridge */ /* synthetic */ java.lang.Object doInBackground(java.lang.Object[] r8) {
        /*
            r7 = this;
            java.lang.String r0 = "zzaar#doInBackground"
            r1 = 0
            com.newrelic.agent.android.tracing.Trace r2 = r7._nr_trace     // Catch:{ NoSuchFieldError -> 0x0009 }
            com.newrelic.agent.android.tracing.TraceMachine.enterMethod(r2, r0, r1)     // Catch:{ NoSuchFieldError -> 0x0009 }
            goto L_0x000c
        L_0x0009:
            com.newrelic.agent.android.tracing.TraceMachine.enterMethod(r1, r0, r1)     // Catch:{ NoSuchFieldError -> 0x0009 }
        L_0x000c:
            java.lang.Void[] r8 = (java.lang.Void[]) r8
            java.lang.String r8 = r7.zzf
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 != 0) goto L_0x001e
            java.lang.String r8 = r7.zzf
            com.google.android.gms.internal.firebase-auth-api.zzaaq r1 = com.google.android.gms.internal.p002firebaseauthapi.zzaaq.zza(r8)
            goto L_0x0149
        L_0x001e:
            r8 = 0
            java.net.URL r0 = new java.net.URL     // Catch:{ IOException -> 0x0133, NullPointerException -> 0x011c, zzyq -> 0x0105 }
            java.lang.String r2 = r7.zzc     // Catch:{ IOException -> 0x0133, NullPointerException -> 0x011c, zzyq -> 0x0105 }
            r0.<init>(r2)     // Catch:{ IOException -> 0x0133, NullPointerException -> 0x011c, zzyq -> 0x0105 }
            java.lang.ref.WeakReference r2 = r7.zzd     // Catch:{ IOException -> 0x0133, NullPointerException -> 0x011c, zzyq -> 0x0105 }
            java.lang.Object r2 = r2.get()     // Catch:{ IOException -> 0x0133, NullPointerException -> 0x011c, zzyq -> 0x0105 }
            com.google.android.gms.internal.firebase-auth-api.zzaat r2 = (com.google.android.gms.internal.p002firebaseauthapi.zzaat) r2     // Catch:{ IOException -> 0x0133, NullPointerException -> 0x011c, zzyq -> 0x0105 }
            java.net.HttpURLConnection r0 = r2.zzd(r0)     // Catch:{ IOException -> 0x0133, NullPointerException -> 0x011c, zzyq -> 0x0105 }
            java.lang.String r3 = "Content-Type"
            java.lang.String r4 = "application/json; charset=UTF-8"
            r0.addRequestProperty(r3, r4)     // Catch:{ IOException -> 0x0133, NullPointerException -> 0x011c, zzyq -> 0x0105 }
            r3 = 60000(0xea60, float:8.4078E-41)
            r0.setConnectTimeout(r3)     // Catch:{ IOException -> 0x0133, NullPointerException -> 0x011c, zzyq -> 0x0105 }
            com.google.android.gms.internal.firebase-auth-api.zzabd r3 = new com.google.android.gms.internal.firebase-auth-api.zzabd     // Catch:{ IOException -> 0x0133, NullPointerException -> 0x011c, zzyq -> 0x0105 }
            android.content.Context r2 = r2.zza()     // Catch:{ IOException -> 0x0133, NullPointerException -> 0x011c, zzyq -> 0x0105 }
            com.google.firebase.FirebaseApp r4 = r7.zzg     // Catch:{ IOException -> 0x0133, NullPointerException -> 0x011c, zzyq -> 0x0105 }
            com.google.android.gms.internal.firebase-auth-api.zzabb r5 = com.google.android.gms.internal.p002firebaseauthapi.zzabb.zza()     // Catch:{ IOException -> 0x0133, NullPointerException -> 0x011c, zzyq -> 0x0105 }
            java.lang.String r5 = r5.zzb()     // Catch:{ IOException -> 0x0133, NullPointerException -> 0x011c, zzyq -> 0x0105 }
            r3.<init>(r2, r4, r5)     // Catch:{ IOException -> 0x0133, NullPointerException -> 0x011c, zzyq -> 0x0105 }
            r3.zza(r0)     // Catch:{ IOException -> 0x0133, NullPointerException -> 0x011c, zzyq -> 0x0105 }
            int r2 = r0.getResponseCode()     // Catch:{ IOException -> 0x0133, NullPointerException -> 0x011c, zzyq -> 0x0105 }
            r3 = 200(0xc8, float:2.8E-43)
            r4 = 128(0x80, float:1.794E-43)
            if (r2 != r3) goto L_0x009e
            com.google.android.gms.internal.firebase-auth-api.zzado r2 = new com.google.android.gms.internal.firebase-auth-api.zzado     // Catch:{ IOException -> 0x0133, NullPointerException -> 0x011c, zzyq -> 0x0105 }
            r2.<init>()     // Catch:{ IOException -> 0x0133, NullPointerException -> 0x011c, zzyq -> 0x0105 }
            java.lang.String r3 = new java.lang.String     // Catch:{ IOException -> 0x0133, NullPointerException -> 0x011c, zzyq -> 0x0105 }
            java.io.InputStream r0 = r0.getInputStream()     // Catch:{ IOException -> 0x0133, NullPointerException -> 0x011c, zzyq -> 0x0105 }
            byte[] r0 = zzb(r0, r4)     // Catch:{ IOException -> 0x0133, NullPointerException -> 0x011c, zzyq -> 0x0105 }
            r3.<init>(r0)     // Catch:{ IOException -> 0x0133, NullPointerException -> 0x011c, zzyq -> 0x0105 }
            r2.zzb(r3)     // Catch:{ IOException -> 0x0133, NullPointerException -> 0x011c, zzyq -> 0x0105 }
            java.util.List r0 = r2.zzc()     // Catch:{ IOException -> 0x0133, NullPointerException -> 0x011c, zzyq -> 0x0105 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ IOException -> 0x0133, NullPointerException -> 0x011c, zzyq -> 0x0105 }
        L_0x007c:
            boolean r2 = r0.hasNext()     // Catch:{ IOException -> 0x0133, NullPointerException -> 0x011c, zzyq -> 0x0105 }
            if (r2 == 0) goto L_0x0149
            java.lang.Object r2 = r0.next()     // Catch:{ IOException -> 0x0133, NullPointerException -> 0x011c, zzyq -> 0x0105 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ IOException -> 0x0133, NullPointerException -> 0x011c, zzyq -> 0x0105 }
            java.lang.String r3 = "firebaseapp.com"
            boolean r3 = r2.endsWith(r3)     // Catch:{ IOException -> 0x0133, NullPointerException -> 0x011c, zzyq -> 0x0105 }
            if (r3 != 0) goto L_0x0098
            java.lang.String r3 = "web.app"
            boolean r3 = r2.endsWith(r3)     // Catch:{ IOException -> 0x0133, NullPointerException -> 0x011c, zzyq -> 0x0105 }
            if (r3 == 0) goto L_0x007c
        L_0x0098:
            com.google.android.gms.internal.firebase-auth-api.zzaaq r1 = com.google.android.gms.internal.p002firebaseauthapi.zzaaq.zza(r2)     // Catch:{ IOException -> 0x0133, NullPointerException -> 0x011c, zzyq -> 0x0105 }
            goto L_0x0149
        L_0x009e:
            int r3 = r0.getResponseCode()     // Catch:{ IOException -> 0x00d4, NullPointerException -> 0x011c, zzyq -> 0x0105 }
            r5 = 400(0x190, float:5.6E-43)
            if (r3 < r5) goto L_0x00d2
            java.io.InputStream r0 = r0.getErrorStream()     // Catch:{ IOException -> 0x00d4, NullPointerException -> 0x011c, zzyq -> 0x0105 }
            if (r0 != 0) goto L_0x00c0
            java.lang.String r0 = "Could not retrieve the authDomain for this project but did not receive an error response from the network request. Please try again."
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00d4, NullPointerException -> 0x011c, zzyq -> 0x0105 }
            r3.<init>()     // Catch:{ IOException -> 0x00d4, NullPointerException -> 0x011c, zzyq -> 0x0105 }
            java.lang.String r4 = "WEB_INTERNAL_ERROR:"
            r3.append(r4)     // Catch:{ IOException -> 0x00d4, NullPointerException -> 0x011c, zzyq -> 0x0105 }
            r3.append(r0)     // Catch:{ IOException -> 0x00d4, NullPointerException -> 0x011c, zzyq -> 0x0105 }
            java.lang.String r0 = r3.toString()     // Catch:{ IOException -> 0x00d4, NullPointerException -> 0x011c, zzyq -> 0x0105 }
            goto L_0x00e7
        L_0x00c0:
            java.lang.String r3 = new java.lang.String     // Catch:{ IOException -> 0x00d4, NullPointerException -> 0x011c, zzyq -> 0x0105 }
            byte[] r0 = zzb(r0, r4)     // Catch:{ IOException -> 0x00d4, NullPointerException -> 0x011c, zzyq -> 0x0105 }
            r3.<init>(r0)     // Catch:{ IOException -> 0x00d4, NullPointerException -> 0x011c, zzyq -> 0x0105 }
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            java.lang.Object r0 = com.google.android.gms.internal.p002firebaseauthapi.zzaay.zza(r3, r0)     // Catch:{ IOException -> 0x00d4, NullPointerException -> 0x011c, zzyq -> 0x0105 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ IOException -> 0x00d4, NullPointerException -> 0x011c, zzyq -> 0x0105 }
            goto L_0x00e7
        L_0x00d2:
            r0 = r1
            goto L_0x00e7
        L_0x00d4:
            r0 = move-exception
            com.google.android.gms.common.logging.Logger r3 = zza     // Catch:{ IOException -> 0x0133, NullPointerException -> 0x011c, zzyq -> 0x0105 }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x0133, NullPointerException -> 0x011c, zzyq -> 0x0105 }
            java.lang.String r4 = "Error parsing error message from response body in getErrorMessageFromBody. "
            java.lang.String r0 = r4.concat(r0)     // Catch:{ IOException -> 0x0133, NullPointerException -> 0x011c, zzyq -> 0x0105 }
            java.lang.Object[] r4 = new java.lang.Object[r8]     // Catch:{ IOException -> 0x0133, NullPointerException -> 0x011c, zzyq -> 0x0105 }
            r3.w(r0, r4)     // Catch:{ IOException -> 0x0133, NullPointerException -> 0x011c, zzyq -> 0x0105 }
            goto L_0x00d2
        L_0x00e7:
            com.google.android.gms.common.logging.Logger r3 = zza     // Catch:{ IOException -> 0x0133, NullPointerException -> 0x011c, zzyq -> 0x0105 }
            java.lang.String r4 = "Error getting project config. Failed with %s %s"
            r5 = 2
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ IOException -> 0x0133, NullPointerException -> 0x011c, zzyq -> 0x0105 }
            r5[r8] = r0     // Catch:{ IOException -> 0x0133, NullPointerException -> 0x011c, zzyq -> 0x0105 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ IOException -> 0x0133, NullPointerException -> 0x011c, zzyq -> 0x0105 }
            r6 = 1
            r5[r6] = r2     // Catch:{ IOException -> 0x0133, NullPointerException -> 0x011c, zzyq -> 0x0105 }
            java.lang.String r2 = java.lang.String.format(r4, r5)     // Catch:{ IOException -> 0x0133, NullPointerException -> 0x011c, zzyq -> 0x0105 }
            java.lang.Object[] r4 = new java.lang.Object[r8]     // Catch:{ IOException -> 0x0133, NullPointerException -> 0x011c, zzyq -> 0x0105 }
            r3.e(r2, r4)     // Catch:{ IOException -> 0x0133, NullPointerException -> 0x011c, zzyq -> 0x0105 }
            com.google.android.gms.internal.firebase-auth-api.zzaaq r1 = com.google.android.gms.internal.p002firebaseauthapi.zzaaq.zzb(r0)     // Catch:{ IOException -> 0x0133, NullPointerException -> 0x011c, zzyq -> 0x0105 }
            goto L_0x0149
        L_0x0105:
            r0 = move-exception
            com.google.android.gms.common.logging.Logger r2 = zza
            java.lang.String r0 = r0.getMessage()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.Object[] r8 = new java.lang.Object[r8]
            java.lang.String r3 = "ConversionException encountered: "
            java.lang.String r0 = r3.concat(r0)
            r2.e(r0, r8)
            goto L_0x0149
        L_0x011c:
            r0 = move-exception
            com.google.android.gms.common.logging.Logger r2 = zza
            java.lang.String r0 = r0.getMessage()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.Object[] r8 = new java.lang.Object[r8]
            java.lang.String r3 = "Null pointer encountered: "
            java.lang.String r0 = r3.concat(r0)
            r2.e(r0, r8)
            goto L_0x0149
        L_0x0133:
            r0 = move-exception
            com.google.android.gms.common.logging.Logger r2 = zza
            java.lang.String r0 = r0.getMessage()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.Object[] r8 = new java.lang.Object[r8]
            java.lang.String r3 = "IOException occurred: "
            java.lang.String r0 = r3.concat(r0)
            r2.e(r0, r8)
        L_0x0149:
            com.newrelic.agent.android.tracing.TraceMachine.exitMethod()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzaar.doInBackground(java.lang.Object[]):java.lang.Object");
    }

    public final /* synthetic */ void onCancelled(Object obj) {
        zzaaq zzaaq = (zzaaq) obj;
        zza((zzaaq) null);
    }

    public final /* synthetic */ void onPostExecute(Object obj) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "zzaar#onPostExecute", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "zzaar#onPostExecute", (ArrayList<String>) null);
        }
        zza((zzaaq) obj);
        TraceMachine.exitMethod();
    }
}
