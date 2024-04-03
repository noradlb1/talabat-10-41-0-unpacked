package com.google.android.gms.internal.ads;

import android.content.Context;
import android.provider.Settings;
import android.util.JsonWriter;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.tekartik.sqflite.Constant;
import java.io.IOException;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public final class zzciy {
    public static final /* synthetic */ int zza = 0;
    private static final Object zzb = new Object();
    @GuardedBy("lock")
    private static boolean zzc = false;
    @GuardedBy("lock")
    private static boolean zzd = false;
    private static final Clock zze = DefaultClock.getInstance();
    private static final Set<String> zzf = new HashSet(Arrays.asList(new String[0]));
    private final List<String> zzg;

    public zzciy() {
        this((String) null);
    }

    public static /* synthetic */ void zza(String str, String str2, Map map, byte[] bArr, JsonWriter jsonWriter) throws IOException {
        jsonWriter.name(NativeProtocol.WEB_DIALOG_PARAMS).beginObject();
        jsonWriter.name("firstline").beginObject();
        jsonWriter.name("uri").value(str);
        jsonWriter.name("verb").value(str2);
        jsonWriter.endObject();
        zzs(jsonWriter, map);
        if (bArr != null) {
            jsonWriter.name("body").value(Base64Utils.encode(bArr));
        }
        jsonWriter.endObject();
    }

    public static /* synthetic */ void zzb(int i11, Map map, JsonWriter jsonWriter) throws IOException {
        jsonWriter.name(NativeProtocol.WEB_DIALOG_PARAMS).beginObject();
        jsonWriter.name("firstline").beginObject();
        jsonWriter.name(Constant.PARAM_ERROR_CODE).value((long) i11);
        jsonWriter.endObject();
        zzs(jsonWriter, map);
        jsonWriter.endObject();
    }

    public static void zzi() {
        synchronized (zzb) {
            zzc = false;
            zzd = false;
            zzciz.zzj("Ad debug logging enablement is out of date.");
        }
    }

    public static void zzj(boolean z11) {
        synchronized (zzb) {
            zzc = true;
            zzd = z11;
        }
    }

    public static boolean zzk(Context context) {
        if (!zzbmu.zza.zze().booleanValue()) {
            return false;
        }
        try {
            if (Settings.Global.getInt(context.getContentResolver(), "development_settings_enabled", 0) != 0) {
                return true;
            }
            return false;
        } catch (Exception e11) {
            zzciz.zzk("Fail to determine debug setting.", e11);
            return false;
        }
    }

    public static boolean zzl() {
        boolean z11;
        synchronized (zzb) {
            z11 = false;
            if (zzc && zzd) {
                z11 = true;
            }
        }
        return z11;
    }

    public static boolean zzm() {
        boolean z11;
        synchronized (zzb) {
            z11 = zzc;
        }
        return z11;
    }

    private static synchronized void zzn(String str) {
        String str2;
        synchronized (zzciy.class) {
            zzciz.zzi("GMA Debug BEGIN");
            int i11 = 0;
            while (i11 < str.length()) {
                int i12 = i11 + 4000;
                String valueOf = String.valueOf(str.substring(i11, Math.min(i12, str.length())));
                if (valueOf.length() != 0) {
                    str2 = "GMA Debug CONTENT ".concat(valueOf);
                } else {
                    str2 = new String("GMA Debug CONTENT ");
                }
                zzciz.zzi(str2);
                i11 = i12;
            }
            zzciz.zzi("GMA Debug FINISH");
        }
    }

    private final void zzo(String str, zzcix zzcix) {
        StringWriter stringWriter = new StringWriter();
        JsonWriter jsonWriter = new JsonWriter(stringWriter);
        try {
            jsonWriter.beginObject();
            jsonWriter.name("timestamp").value(zze.currentTimeMillis());
            jsonWriter.name("event").value(str);
            jsonWriter.name("components").beginArray();
            for (String value : this.zzg) {
                jsonWriter.value(value);
            }
            jsonWriter.endArray();
            zzcix.zza(jsonWriter);
            jsonWriter.endObject();
            jsonWriter.flush();
            jsonWriter.close();
        } catch (IOException e11) {
            zzciz.zzh("unable to log", e11);
        }
        zzn(stringWriter.toString());
    }

    private final void zzp(@Nullable String str) {
        zzo("onNetworkRequestError", new zzciu(str));
    }

    private final void zzq(String str, String str2, @Nullable Map<String, ?> map, @Nullable byte[] bArr) {
        zzo("onNetworkRequest", new zzciv(str, str2, map, bArr));
    }

    private final void zzr(@Nullable Map<String, ?> map, int i11) {
        zzo("onNetworkResponse", new zzcit(i11, map));
    }

    private static void zzs(JsonWriter jsonWriter, @Nullable Map<String, ?> map) throws IOException {
        if (map != null) {
            jsonWriter.name(InstabugDbContract.NetworkLogEntry.COLUMN_HEADERS).beginArray();
            Iterator<Map.Entry<String, ?>> it = map.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry next = it.next();
                String str = (String) next.getKey();
                if (!zzf.contains(str)) {
                    if (!(next.getValue() instanceof List)) {
                        if (!(next.getValue() instanceof String)) {
                            zzciz.zzg("Connection headers should be either Map<String, String> or Map<String, List<String>>");
                            break;
                        }
                        jsonWriter.beginObject();
                        jsonWriter.name("name").value(str);
                        jsonWriter.name("value").value((String) next.getValue());
                        jsonWriter.endObject();
                    } else {
                        for (String value : (List) next.getValue()) {
                            jsonWriter.beginObject();
                            jsonWriter.name("name").value(str);
                            jsonWriter.name("value").value(value);
                            jsonWriter.endObject();
                        }
                    }
                }
            }
            jsonWriter.endArray();
        }
    }

    public final void zzc(HttpURLConnection httpURLConnection, @Nullable byte[] bArr) {
        HashMap hashMap;
        if (zzl()) {
            if (httpURLConnection.getRequestProperties() == null) {
                hashMap = null;
            } else {
                hashMap = new HashMap(httpURLConnection.getRequestProperties());
            }
            zzq(new String(httpURLConnection.getURL().toString()), new String(httpURLConnection.getRequestMethod()), hashMap, bArr);
        }
    }

    public final void zzd(String str, String str2, @Nullable Map<String, ?> map, @Nullable byte[] bArr) {
        if (zzl()) {
            zzq(str, "GET", map, bArr);
        }
    }

    public final void zze(HttpURLConnection httpURLConnection, int i11) {
        HashMap hashMap;
        String str;
        if (zzl()) {
            String str2 = null;
            if (httpURLConnection.getHeaderFields() == null) {
                hashMap = null;
            } else {
                hashMap = new HashMap(httpURLConnection.getHeaderFields());
            }
            zzr(hashMap, i11);
            if (i11 < 200 || i11 >= 300) {
                try {
                    str2 = httpURLConnection.getResponseMessage();
                } catch (IOException e11) {
                    String valueOf = String.valueOf(e11.getMessage());
                    if (valueOf.length() != 0) {
                        str = "Can not get error message from error HttpURLConnection\n".concat(valueOf);
                    } else {
                        str = new String("Can not get error message from error HttpURLConnection\n");
                    }
                    zzciz.zzj(str);
                }
                zzp(str2);
            }
        }
    }

    public final void zzf(@Nullable Map<String, ?> map, int i11) {
        if (zzl()) {
            zzr(map, i11);
            if (i11 < 200 || i11 >= 300) {
                zzp((String) null);
            }
        }
    }

    public final void zzg(@Nullable String str) {
        if (zzl() && str != null) {
            zzh(str.getBytes());
        }
    }

    public final void zzh(byte[] bArr) {
        zzo("onNetworkResponseBody", new zzciw(bArr));
    }

    public zzciy(@Nullable String str) {
        List<String> list;
        if (!zzl()) {
            list = new ArrayList<>();
        } else {
            String[] strArr = new String[1];
            String valueOf = String.valueOf(UUID.randomUUID().toString());
            strArr[0] = valueOf.length() != 0 ? "network_request_".concat(valueOf) : new String("network_request_");
            list = Arrays.asList(strArr);
        }
        this.zzg = list;
    }
}
