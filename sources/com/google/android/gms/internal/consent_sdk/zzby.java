package com.google.android.gms.internal.consent_sdk;

import android.util.JsonReader;
import androidx.annotation.Nullable;
import com.facebook.share.internal.ShareConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class zzby {
    public int zza = zzbu.zzg;
    @Nullable
    public String zzb;
    @Nullable
    public String zzc;
    @Nullable
    public String zzd;
    public List<String> zze = Collections.emptyList();
    public List<zzbx> zzf = Collections.emptyList();

    public static zzby zza(JsonReader jsonReader) throws IOException {
        zzby zzby = new zzby();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c11 = 65535;
            switch (nextName.hashCode()) {
                case -2001388947:
                    if (nextName.equals("consent_signal")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case -1938755376:
                    if (nextName.equals("error_message")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case -1851537225:
                    if (nextName.equals("consent_form_base_url")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case -1161803523:
                    if (nextName.equals("actions")) {
                        c11 = 3;
                        break;
                    }
                    break;
                case -986806987:
                    if (nextName.equals("request_info_keys")) {
                        c11 = 4;
                        break;
                    }
                    break;
                case -790907624:
                    if (nextName.equals("consent_form_payload")) {
                        c11 = 5;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    zzby.zza = zzbu.zzb(jsonReader);
                    break;
                case 1:
                    zzby.zzd = jsonReader.nextString();
                    break;
                case 2:
                    zzby.zzc = jsonReader.nextString();
                    break;
                case 3:
                    zzby.zzf = new ArrayList();
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        zzbx zzbx = new zzbx();
                        jsonReader.beginObject();
                        while (jsonReader.hasNext()) {
                            String nextName2 = jsonReader.nextName();
                            nextName2.hashCode();
                            if (nextName2.equals("args_json")) {
                                zzbx.zzb = jsonReader.nextString();
                            } else if (!nextName2.equals(ShareConstants.WEB_DIALOG_PARAM_ACTION_TYPE)) {
                                jsonReader.skipValue();
                            } else {
                                zzbx.zza = zzbu.zza(jsonReader);
                            }
                        }
                        jsonReader.endObject();
                        zzby.zzf.add(zzbx);
                    }
                    jsonReader.endArray();
                    break;
                case 4:
                    zzby.zze = new ArrayList();
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        zzby.zze.add(jsonReader.nextString());
                    }
                    jsonReader.endArray();
                    break;
                case 5:
                    zzby.zzb = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return zzby;
    }
}
