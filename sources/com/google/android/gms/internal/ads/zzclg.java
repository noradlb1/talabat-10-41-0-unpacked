package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

public final class zzclg {
    public final boolean zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final String zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final int zzi;
    public final boolean zzj;
    public final int zzk;
    public final boolean zzl;
    public final boolean zzm;
    public final boolean zzn;

    public zzclg(String str) {
        String str2;
        JSONObject jSONObject = null;
        if (str != null) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException unused) {
            }
        }
        this.zza = zza(jSONObject, "aggressive_media_codec_release", zzblj.zzD);
        this.zzb = zzb(jSONObject, "byte_buffer_precache_limit", zzblj.zzj);
        this.zzc = zzb(jSONObject, "exo_cache_buffer_size", zzblj.zzr);
        this.zzd = zzb(jSONObject, "exo_connect_timeout_millis", zzblj.zzf);
        zzblb zzblb = zzblj.zze;
        if (jSONObject != null) {
            try {
                str2 = jSONObject.getString("exo_player_version");
            } catch (JSONException unused2) {
            }
            this.zze = str2;
            this.zzf = zzb(jSONObject, "exo_read_timeout_millis", zzblj.zzg);
            this.zzg = zzb(jSONObject, "load_check_interval_bytes", zzblj.zzh);
            this.zzh = zzb(jSONObject, "player_precache_limit", zzblj.zzi);
            this.zzi = zzb(jSONObject, "socket_receive_buffer_size", zzblj.zzk);
            this.zzj = zza(jSONObject, "use_cache_data_source", zzblj.zzcO);
            this.zzk = zzb(jSONObject, "min_retry_count", zzblj.zzl);
            this.zzl = zza(jSONObject, "treat_load_exception_as_non_fatal", zzblj.zzo);
            this.zzm = zza(jSONObject, "using_official_simple_exo_player", zzblj.zzbs);
            this.zzn = zza(jSONObject, "enable_multiple_video_playback", zzblj.zzbt);
        }
        str2 = (String) zzbgq.zzc().zzb(zzblb);
        this.zze = str2;
        this.zzf = zzb(jSONObject, "exo_read_timeout_millis", zzblj.zzg);
        this.zzg = zzb(jSONObject, "load_check_interval_bytes", zzblj.zzh);
        this.zzh = zzb(jSONObject, "player_precache_limit", zzblj.zzi);
        this.zzi = zzb(jSONObject, "socket_receive_buffer_size", zzblj.zzk);
        this.zzj = zza(jSONObject, "use_cache_data_source", zzblj.zzcO);
        this.zzk = zzb(jSONObject, "min_retry_count", zzblj.zzl);
        this.zzl = zza(jSONObject, "treat_load_exception_as_non_fatal", zzblj.zzo);
        this.zzm = zza(jSONObject, "using_official_simple_exo_player", zzblj.zzbs);
        this.zzn = zza(jSONObject, "enable_multiple_video_playback", zzblj.zzbt);
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [com.google.android.gms.internal.ads.zzblb<java.lang.Boolean>, com.google.android.gms.internal.ads.zzblb] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final boolean zza(org.json.JSONObject r1, java.lang.String r2, com.google.android.gms.internal.ads.zzblb<java.lang.Boolean> r3) {
        /*
            com.google.android.gms.internal.ads.zzblh r0 = com.google.android.gms.internal.ads.zzbgq.zzc()
            java.lang.Object r3 = r0.zzb(r3)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r1 == 0) goto L_0x0014
            boolean r3 = r1.getBoolean(r2)     // Catch:{ JSONException -> 0x0014 }
        L_0x0014:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzclg.zza(org.json.JSONObject, java.lang.String, com.google.android.gms.internal.ads.zzblb):boolean");
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.google.android.gms.internal.ads.zzblb<java.lang.Integer>, com.google.android.gms.internal.ads.zzblb] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final int zzb(org.json.JSONObject r0, java.lang.String r1, com.google.android.gms.internal.ads.zzblb<java.lang.Integer> r2) {
        /*
            if (r0 == 0) goto L_0x0007
            int r0 = r0.getInt(r1)     // Catch:{ JSONException -> 0x0007 }
            return r0
        L_0x0007:
            com.google.android.gms.internal.ads.zzblh r0 = com.google.android.gms.internal.ads.zzbgq.zzc()
            java.lang.Object r0 = r0.zzb(r2)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzclg.zzb(org.json.JSONObject, java.lang.String, com.google.android.gms.internal.ads.zzblb):int");
    }
}
