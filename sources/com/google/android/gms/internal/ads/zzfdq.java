package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import android.util.JsonToken;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.zzby;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import org.json.JSONException;

public final class zzfdq {
    public final List<String> zza;
    public final String zzb;
    public final int zzc;
    public final String zzd;
    public final int zze;
    public final long zzf;
    public final boolean zzg;
    public final String zzh;
    @Nullable
    public final zzfdp zzi;

    public zzfdq(JsonReader jsonReader) throws IllegalStateException, IOException, JSONException, NumberFormatException {
        List<String> emptyList = Collections.emptyList();
        jsonReader.beginObject();
        String str = "";
        boolean z11 = false;
        long j11 = 0;
        zzfdp zzfdp = null;
        String str2 = str;
        String str3 = str2;
        int i11 = 0;
        int i12 = 0;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if ("nofill_urls".equals(nextName)) {
                emptyList = zzby.zzd(jsonReader);
            } else if ("refresh_interval".equals(nextName)) {
                i11 = jsonReader.nextInt();
            } else if ("gws_query_id".equals(nextName)) {
                str = jsonReader.nextString();
            } else if ("analytics_query_ad_event_id".equals(nextName)) {
                str2 = jsonReader.nextString();
            } else if ("is_idless".equals(nextName)) {
                z11 = jsonReader.nextBoolean();
            } else if ("response_code".equals(nextName)) {
                i12 = jsonReader.nextInt();
            } else if ("latency".equals(nextName)) {
                j11 = jsonReader.nextLong();
            } else {
                if (((Boolean) zzbgq.zzc().zzb(zzblj.zzgc)).booleanValue() && "public_error".equals(nextName) && jsonReader.peek() == JsonToken.BEGIN_OBJECT) {
                    zzfdp = new zzfdp(jsonReader);
                } else if ("bidding_data".equals(nextName)) {
                    str3 = jsonReader.nextString();
                } else {
                    jsonReader.skipValue();
                }
            }
        }
        jsonReader.endObject();
        this.zza = emptyList;
        this.zzc = i11;
        this.zzb = str;
        this.zzd = str2;
        this.zze = i12;
        this.zzf = j11;
        this.zzi = zzfdp;
        this.zzg = z11;
        this.zzh = str3;
    }
}
