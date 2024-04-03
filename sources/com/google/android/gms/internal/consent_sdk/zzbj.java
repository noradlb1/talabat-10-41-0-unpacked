package com.google.android.gms.internal.consent_sdk;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.util.Base64;
import androidx.annotation.WorkerThread;
import com.braze.ui.actions.brazeactions.steps.StepData;
import com.facebook.internal.NativeProtocol;
import java.io.ByteArrayOutputStream;
import java.util.Locale;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

final class zzbj implements zzi {
    private final Application zza;
    private final zzbh zzb;
    private final Handler zzc;
    private final Executor zzd;
    private final zze zze;
    private final zzaj zzf;
    private final zzat zzg;

    public zzbj(Application application, zzbh zzbh, Handler handler, Executor executor, zze zze2, zzaj zzaj, zzat zzat) {
        this.zza = application;
        this.zzb = zzbh;
        this.zzc = handler;
        this.zzd = executor;
        this.zze = zze2;
        this.zzf = zzaj;
        this.zzg = zzat;
    }

    public final void zza(int i11, String str, String str2) {
        this.zzg.zza(new zzk(2, String.format(Locale.US, "WebResourceError(%d, %s): %s", new Object[]{Integer.valueOf(i11), str2, str})));
    }

    public final /* synthetic */ void zzb() {
        this.zzg.zza().zza("UMP_configureFormWithAppAssets", zza((Context) this.zza));
    }

    public final void zza(String str) {
        String valueOf = String.valueOf(str);
        if (valueOf.length() != 0) {
            "Receive consent action: ".concat(valueOf);
        }
        Uri parse = Uri.parse(str);
        String queryParameter = parse.getQueryParameter(NativeProtocol.WEB_DIALOG_ACTION);
        String queryParameter2 = parse.getQueryParameter(StepData.ARGS);
        this.zze.zza(queryParameter, queryParameter2, this, this.zzf);
    }

    public final Executor zza() {
        Handler handler = this.zzc;
        handler.getClass();
        return zzbm.zza(handler);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    @androidx.annotation.UiThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(java.lang.String r7, org.json.JSONObject r8) {
        /*
            r6 = this;
            r7.hashCode()
            int r0 = r7.hashCode()
            r1 = 3
            r2 = 2
            r3 = 0
            r4 = 1
            r5 = -1
            switch(r0) {
                case -1370505102: goto L_0x0032;
                case -278739366: goto L_0x0027;
                case 150940456: goto L_0x001c;
                case 1671672458: goto L_0x0011;
                default: goto L_0x000f;
            }
        L_0x000f:
            r7 = r5
            goto L_0x003c
        L_0x0011:
            java.lang.String r0 = "dismiss"
            boolean r7 = r7.equals(r0)
            if (r7 != 0) goto L_0x001a
            goto L_0x000f
        L_0x001a:
            r7 = r1
            goto L_0x003c
        L_0x001c:
            java.lang.String r0 = "browser"
            boolean r7 = r7.equals(r0)
            if (r7 != 0) goto L_0x0025
            goto L_0x000f
        L_0x0025:
            r7 = r2
            goto L_0x003c
        L_0x0027:
            java.lang.String r0 = "configure_app_assets"
            boolean r7 = r7.equals(r0)
            if (r7 != 0) goto L_0x0030
            goto L_0x000f
        L_0x0030:
            r7 = r4
            goto L_0x003c
        L_0x0032:
            java.lang.String r0 = "load_complete"
            boolean r7 = r7.equals(r0)
            if (r7 != 0) goto L_0x003b
            goto L_0x000f
        L_0x003b:
            r7 = r3
        L_0x003c:
            switch(r7) {
                case 0: goto L_0x00f5;
                case 1: goto L_0x00ea;
                case 2: goto L_0x00a0;
                case 3: goto L_0x0040;
                default: goto L_0x003f;
            }
        L_0x003f:
            return r3
        L_0x0040:
            java.lang.String r7 = "status"
            java.lang.String r7 = r8.optString(r7)
            r7.hashCode()
            int r8 = r7.hashCode()
            switch(r8) {
                case -954325659: goto L_0x007d;
                case -258041904: goto L_0x0072;
                case 429411856: goto L_0x0067;
                case 467888915: goto L_0x005c;
                case 1666911234: goto L_0x0051;
                default: goto L_0x0050;
            }
        L_0x0050:
            goto L_0x0087
        L_0x0051:
            java.lang.String r8 = "non_personalized"
            boolean r7 = r7.equals(r8)
            if (r7 != 0) goto L_0x005a
            goto L_0x0087
        L_0x005a:
            r5 = 4
            goto L_0x0087
        L_0x005c:
            java.lang.String r8 = "CONSENT_SIGNAL_PERSONALIZED_ADS"
            boolean r7 = r7.equals(r8)
            if (r7 != 0) goto L_0x0065
            goto L_0x0087
        L_0x0065:
            r5 = r1
            goto L_0x0087
        L_0x0067:
            java.lang.String r8 = "CONSENT_SIGNAL_SUFFICIENT"
            boolean r7 = r7.equals(r8)
            if (r7 != 0) goto L_0x0070
            goto L_0x0087
        L_0x0070:
            r5 = r2
            goto L_0x0087
        L_0x0072:
            java.lang.String r8 = "personalized"
            boolean r7 = r7.equals(r8)
            if (r7 != 0) goto L_0x007b
            goto L_0x0087
        L_0x007b:
            r5 = r4
            goto L_0x0087
        L_0x007d:
            java.lang.String r8 = "CONSENT_SIGNAL_NON_PERSONALIZED_ADS"
            boolean r7 = r7.equals(r8)
            if (r7 != 0) goto L_0x0086
            goto L_0x0087
        L_0x0086:
            r5 = r3
        L_0x0087:
            switch(r5) {
                case 0: goto L_0x0099;
                case 1: goto L_0x009a;
                case 2: goto L_0x0097;
                case 3: goto L_0x009a;
                case 4: goto L_0x0099;
                default: goto L_0x008a;
            }
        L_0x008a:
            com.google.android.gms.internal.consent_sdk.zzat r7 = r6.zzg
            com.google.android.gms.internal.consent_sdk.zzk r8 = new com.google.android.gms.internal.consent_sdk.zzk
            java.lang.String r0 = "We are getting something wrong with the webview."
            r8.<init>(r4, r0)
            r7.zzb(r8)
            goto L_0x009f
        L_0x0097:
            r2 = r3
            goto L_0x009a
        L_0x0099:
            r2 = r4
        L_0x009a:
            com.google.android.gms.internal.consent_sdk.zzat r7 = r6.zzg
            r7.zza((int) r1, (int) r2)
        L_0x009f:
            return r4
        L_0x00a0:
            java.lang.String r7 = "url"
            java.lang.String r7 = r8.optString(r7)
            android.text.TextUtils.isEmpty(r7)
            android.net.Uri r8 = android.net.Uri.parse(r7)
            java.lang.String r0 = r8.getScheme()
            if (r0 != 0) goto L_0x00c2
            java.lang.String r0 = java.lang.String.valueOf(r7)
            int r1 = r0.length()
            if (r1 == 0) goto L_0x00c2
            java.lang.String r1 = "Action[browser]: empty scheme: "
            r1.concat(r0)
        L_0x00c2:
            android.content.Intent r0 = new android.content.Intent     // Catch:{ ActivityNotFoundException -> 0x00cf }
            java.lang.String r1 = "android.intent.action.VIEW"
            r0.<init>(r1, r8)     // Catch:{ ActivityNotFoundException -> 0x00cf }
            com.google.android.gms.internal.consent_sdk.zzbh r8 = r6.zzb     // Catch:{ ActivityNotFoundException -> 0x00cf }
            r8.startActivity(r0)     // Catch:{ ActivityNotFoundException -> 0x00cf }
            goto L_0x00e9
        L_0x00cf:
            r8 = move-exception
            java.lang.String r7 = java.lang.String.valueOf(r7)
            int r0 = r7.length()
            java.lang.String r1 = "Action[browser]: can not open url: "
            if (r0 == 0) goto L_0x00e1
            java.lang.String r7 = r1.concat(r7)
            goto L_0x00e6
        L_0x00e1:
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1)
        L_0x00e6:
            com.google.android.gms.internal.consent_sdk.zzca.zza(r7, r8)
        L_0x00e9:
            return r4
        L_0x00ea:
            java.util.concurrent.Executor r7 = r6.zzd
            com.google.android.gms.internal.consent_sdk.zzbl r8 = new com.google.android.gms.internal.consent_sdk.zzbl
            r8.<init>(r6)
            r7.execute(r8)
            return r4
        L_0x00f5:
            com.google.android.gms.internal.consent_sdk.zzat r7 = r6.zzg
            r7.zzb()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.consent_sdk.zzbj.zza(java.lang.String, org.json.JSONObject):boolean");
    }

    @WorkerThread
    private static JSONObject zza(Context context) {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING, (Object) context.getPackageManager().getApplicationLabel(context.getApplicationInfo()).toString());
            Drawable applicationIcon = context.getPackageManager().getApplicationIcon(context.getApplicationInfo());
            if (applicationIcon == null) {
                str = null;
            } else {
                Bitmap createBitmap = Bitmap.createBitmap(applicationIcon.getIntrinsicWidth(), applicationIcon.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                applicationIcon.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                applicationIcon.draw(canvas);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                createBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                String valueOf = String.valueOf(Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0));
                str = valueOf.length() != 0 ? "data:image/png;base64,".concat(valueOf) : new String("data:image/png;base64,");
            }
            jSONObject.put("app_icon", (Object) str);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
