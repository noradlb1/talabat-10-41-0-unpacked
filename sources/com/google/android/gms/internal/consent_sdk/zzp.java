package com.google.android.gms.internal.consent_sdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.util.JsonReader;
import android.util.JsonWriter;
import android.util.Log;
import android.webkit.WebSettings;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.android.ump.ConsentDebugSettings;
import com.google.android.ump.ConsentInformation;
import com.google.android.ump.ConsentRequestParameters;
import com.huawei.wearengine.common.Constants;
import com.instabug.library.model.State;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.URLConnectionInstrumentation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.Executor;

@Instrumented
final class zzp {
    private final Application zza;
    private final zzab zzb;
    private final Handler zzc;
    private final Executor zzd;
    private final zzal zze;
    private final zzaz zzf;
    private final zzn zzg;
    private final zzz zzh;
    private final zze zzi;

    public zzp(Application application, zzab zzab, Handler handler, Executor executor, zzal zzal, zzaz zzaz, zzn zzn, zzz zzz, zze zze2) {
        this.zza = application;
        this.zzb = zzab;
        this.zzc = handler;
        this.zzd = executor;
        this.zze = zzal;
        this.zzf = zzaz;
        this.zzg = zzn;
        this.zzh = zzz;
        this.zzi = zze2;
    }

    @WorkerThread
    private final zzby zzb(zzbn zzbn) throws IOException {
        JsonWriter jsonWriter;
        JsonReader jsonReader;
        HttpURLConnection httpURLConnection = (HttpURLConnection) URLConnectionInstrumentation.openConnection(new URL("https://fundingchoicesmessages.google.com/a/consent").openConnection());
        httpURLConnection.setRequestProperty("User-Agent", WebSettings.getDefaultUserAgent(this.zza));
        httpURLConnection.setConnectTimeout(10000);
        httpURLConnection.setReadTimeout(30000);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(httpURLConnection.getOutputStream(), "UTF-8");
        try {
            jsonWriter = new JsonWriter(outputStreamWriter);
            jsonWriter.beginObject();
            String str = zzbn.zza;
            if (str != null) {
                jsonWriter.name("admob_app_id");
                jsonWriter.value(str);
            }
            String str2 = zzbn.zzb;
            if (str2 != null) {
                jsonWriter.name("adid");
                jsonWriter.value(str2);
            }
            zzbr zzbr = zzbn.zzc;
            if (zzbr != null) {
                jsonWriter.name(DeviceRequestsHelper.DEVICE_INFO_PARAM);
                jsonWriter.beginObject();
                int i11 = zzbr.zza;
                if (i11 != zzbu.zza) {
                    jsonWriter.name("os_type");
                    zzbu.zza(i11, jsonWriter);
                }
                String str3 = zzbr.zzb;
                if (str3 != null) {
                    jsonWriter.name(DeviceRequestsHelper.DEVICE_INFO_MODEL);
                    jsonWriter.value(str3);
                }
                Integer num = zzbr.zzc;
                if (num != null) {
                    jsonWriter.name("android_api_level");
                    jsonWriter.value(num);
                }
                jsonWriter.endObject();
            }
            String str4 = zzbn.zzd;
            if (str4 != null) {
                jsonWriter.name("publisher_privacy_policy_url");
                jsonWriter.value(str4);
            }
            String str5 = zzbn.zze;
            if (str5 != null) {
                jsonWriter.name("language_code");
                jsonWriter.value(str5);
            }
            String str6 = zzbn.zzf;
            if (str6 != null) {
                jsonWriter.name("country_code_if_unknown_region");
                jsonWriter.value(str6);
            }
            Boolean bool = zzbn.zzg;
            if (bool != null) {
                jsonWriter.name("opt_out_if_unknown_region");
                jsonWriter.value(bool.booleanValue());
            }
            Boolean bool2 = zzbn.zzh;
            if (bool2 != null) {
                jsonWriter.name("tag_for_under_age_of_consent");
                jsonWriter.value(bool2.booleanValue());
            }
            Boolean bool3 = zzbn.zzi;
            if (bool3 != null) {
                jsonWriter.name("is_lat");
                jsonWriter.value(bool3.booleanValue());
            }
            Map<String, String> map = zzbn.zzj;
            if (!map.isEmpty()) {
                jsonWriter.name("stored_infos_map");
                jsonWriter.beginObject();
                for (Map.Entry next : map.entrySet()) {
                    jsonWriter.name((String) next.getKey());
                    jsonWriter.value((String) next.getValue());
                }
                jsonWriter.endObject();
            }
            zzbt zzbt = zzbn.zzk;
            if (zzbt != null) {
                jsonWriter.name("screen_info");
                jsonWriter.beginObject();
                Integer num2 = zzbt.zza;
                if (num2 != null) {
                    jsonWriter.name("width");
                    jsonWriter.value(num2);
                }
                Integer num3 = zzbt.zzb;
                if (num3 != null) {
                    jsonWriter.name("height");
                    jsonWriter.value(num3);
                }
                Double d11 = zzbt.zzc;
                if (d11 != null) {
                    jsonWriter.name(State.KEY_DENSITY);
                    jsonWriter.value(d11);
                }
                List<zzbw> list = zzbt.zzd;
                if (!list.isEmpty()) {
                    jsonWriter.name("screen_insets");
                    jsonWriter.beginArray();
                    for (zzbw next2 : list) {
                        jsonWriter.beginObject();
                        Integer num4 = next2.zza;
                        if (num4 != null) {
                            jsonWriter.name(ViewHierarchyConstants.DIMENSION_TOP_KEY);
                            jsonWriter.value(num4);
                        }
                        Integer num5 = next2.zzb;
                        if (num5 != null) {
                            jsonWriter.name("left");
                            jsonWriter.value(num5);
                        }
                        Integer num6 = next2.zzc;
                        if (num6 != null) {
                            jsonWriter.name(TtmlNode.RIGHT);
                            jsonWriter.value(num6);
                        }
                        Integer num7 = next2.zzd;
                        if (num7 != null) {
                            jsonWriter.name("bottom");
                            jsonWriter.value(num7);
                        }
                        jsonWriter.endObject();
                    }
                    jsonWriter.endArray();
                }
                jsonWriter.endObject();
            }
            zzbp zzbp = zzbn.zzl;
            if (zzbp != null) {
                jsonWriter.name("app_info");
                jsonWriter.beginObject();
                String str7 = zzbp.zza;
                if (str7 != null) {
                    jsonWriter.name(Constants.PACKAGE_NAME);
                    jsonWriter.value(str7);
                }
                String str8 = zzbp.zzb;
                if (str8 != null) {
                    jsonWriter.name("publisher_display_name");
                    jsonWriter.value(str8);
                }
                String str9 = zzbp.zzc;
                if (str9 != null) {
                    jsonWriter.name("version");
                    jsonWriter.value(str9);
                }
                jsonWriter.endObject();
            }
            zzbv zzbv = zzbn.zzm;
            if (zzbv != null) {
                jsonWriter.name("sdk_info");
                jsonWriter.beginObject();
                String str10 = zzbv.zza;
                if (str10 != null) {
                    jsonWriter.name("version");
                    jsonWriter.value(str10);
                }
                jsonWriter.endObject();
            }
            List<zzbs> list2 = zzbn.zzn;
            if (!list2.isEmpty()) {
                jsonWriter.name("debug_params");
                jsonWriter.beginArray();
                for (zzbs zza2 : list2) {
                    zza2.zza(jsonWriter);
                }
                jsonWriter.endArray();
            }
            jsonWriter.endObject();
            jsonWriter.close();
            outputStreamWriter.close();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                String headerField = httpURLConnection.getHeaderField("x-ump-using-header");
                if (headerField != null) {
                    zzby zza3 = zzby.zza(new JsonReader(new StringReader(headerField)));
                    zza3.zzb = new Scanner(httpURLConnection.getInputStream()).useDelimiter("\\A").next();
                    return zza3;
                }
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8"));
                try {
                    bufferedReader.readLine();
                    jsonReader = new JsonReader(bufferedReader);
                    zzby zza4 = zzby.zza(jsonReader);
                    jsonReader.close();
                    bufferedReader.close();
                    return zza4;
                } catch (Throwable th2) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable th3) {
                        zzcj.zza(th2, th3);
                    }
                    throw th2;
                }
            } else {
                String next3 = new Scanner(httpURLConnection.getErrorStream()).useDelimiter("\\A").next();
                StringBuilder sb2 = new StringBuilder(String.valueOf(next3).length() + 31);
                sb2.append("Http error code - ");
                sb2.append(responseCode);
                sb2.append(".\n");
                sb2.append(next3);
                throw new IOException(sb2.toString());
            }
            throw th;
            throw th;
        } catch (Throwable th4) {
            try {
                outputStreamWriter.close();
            } catch (Throwable th5) {
                zzcj.zza(th4, th5);
            }
            throw th4;
        }
    }

    public final void zza(@Nullable Activity activity, ConsentRequestParameters consentRequestParameters, ConsentInformation.OnConsentInfoUpdateSuccessListener onConsentInfoUpdateSuccessListener, ConsentInformation.OnConsentInfoUpdateFailureListener onConsentInfoUpdateFailureListener) {
        this.zzd.execute(new zzs(this, activity, consentRequestParameters, onConsentInfoUpdateSuccessListener, onConsentInfoUpdateFailureListener));
    }

    @WorkerThread
    private final zzby zza(zzbn zzbn) throws zzk {
        try {
            return zzb(zzbn);
        } catch (SocketTimeoutException e11) {
            throw new zzk(4, "The server timed out.", e11);
        } catch (IOException e12) {
            throw new zzk(2, "Error making request.", e12);
        }
    }

    public final /* synthetic */ void zza(ConsentInformation.OnConsentInfoUpdateSuccessListener onConsentInfoUpdateSuccessListener) {
        Handler handler = this.zzc;
        onConsentInfoUpdateSuccessListener.getClass();
        handler.post(zzu.zza(onConsentInfoUpdateSuccessListener));
    }

    public final /* synthetic */ void zzb(Activity activity, ConsentRequestParameters consentRequestParameters, ConsentInformation.OnConsentInfoUpdateSuccessListener onConsentInfoUpdateSuccessListener, ConsentInformation.OnConsentInfoUpdateFailureListener onConsentInfoUpdateFailureListener) {
        try {
            ConsentDebugSettings consentDebugSettings = consentRequestParameters.getConsentDebugSettings();
            if (consentDebugSettings == null || !consentDebugSettings.isTestDevice()) {
                String zza2 = zzbz.zza((Context) this.zza);
                StringBuilder sb2 = new StringBuilder(String.valueOf(zza2).length() + 95);
                sb2.append("Use new ConsentDebugSettings.Builder().addTestDeviceHashedId(\"");
                sb2.append(zza2);
                sb2.append("\") to set this as a debug device.");
                Log.i("UserMessagingPlatform", sb2.toString());
            }
            zzy zza3 = new zzaa(this.zzh, zza(this.zzg.zza(activity, consentRequestParameters))).zza();
            this.zze.zza(zza3.zza);
            this.zze.zzb(zza3.zzb);
            this.zzf.zza(zza3.zzc);
            this.zzi.zza().execute(new zzr(this, onConsentInfoUpdateSuccessListener));
        } catch (zzk e11) {
            this.zzc.post(new zzt(onConsentInfoUpdateFailureListener, e11));
        } catch (RuntimeException e12) {
            String valueOf = String.valueOf(Log.getStackTraceString(e12));
            this.zzc.post(new zzw(onConsentInfoUpdateFailureListener, new zzk(1, valueOf.length() != 0 ? "Caught exception when trying to request consent info update: ".concat(valueOf) : new String("Caught exception when trying to request consent info update: "))));
        }
    }
}
