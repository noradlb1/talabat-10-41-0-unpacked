package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzt;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzcng implements zzbrt<zzclh> {
    private static final Integer zzb(Map<String, String> map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt(map.get(str)));
        } catch (NumberFormatException unused) {
            String str2 = map.get(str);
            StringBuilder sb2 = new StringBuilder(str.length() + 39 + String.valueOf(str2).length());
            sb2.append("Precache invalid numeric parameter '");
            sb2.append(str);
            sb2.append("': ");
            sb2.append(str2);
            zzciz.zzj(sb2.toString());
            return null;
        }
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcnf zzcnf;
        zzcmx zzcmx;
        String str;
        Map map2 = map;
        zzclh zzclh = (zzclh) obj;
        if (zzciz.zzm(3)) {
            JSONObject jSONObject = new JSONObject((Map<?, ?>) map2);
            jSONObject.remove("google.afma.Notify_dt");
            zzciz.zze("Precache GMSG: ".concat(jSONObject.toString()));
        }
        zzcmy zzy = zzt.zzy();
        if (!map2.containsKey("abort")) {
            String str2 = (String) map2.get("src");
            Integer zzb = zzb(map2, "periodicReportIntervalMs");
            Integer zzb2 = zzb(map2, "exoPlayerRenderingIntervalMs");
            Integer zzb3 = zzb(map2, "exoPlayerIdleIntervalMs");
            zzclg zzclg = new zzclg((String) map2.get("flags"));
            boolean z11 = zzclg.zzn;
            if (str2 != null) {
                String[] strArr = {str2};
                String str3 = (String) map2.get("demuxed");
                if (str3 != null) {
                    try {
                        JSONArray jSONArray = new JSONArray(str3);
                        String[] strArr2 = new String[jSONArray.length()];
                        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                            strArr2[i11] = jSONArray.getString(i11);
                        }
                        strArr = strArr2;
                    } catch (JSONException unused) {
                        if (str3.length() != 0) {
                            str = "Malformed demuxed URL list for precache: ".concat(str3);
                        } else {
                            str = new String("Malformed demuxed URL list for precache: ");
                        }
                        zzciz.zzj(str);
                        strArr = null;
                    }
                }
                if (strArr == null) {
                    strArr = new String[]{str2};
                }
                if (z11) {
                    Iterator<zzcmx> it = zzy.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            zzcmx = null;
                            break;
                        }
                        zzcmx next = it.next();
                        if (next.zza == zzclh && str2.equals(next.zze())) {
                            zzcmx = next;
                            break;
                        }
                    }
                } else {
                    zzcmx = zzy.zza(zzclh);
                }
                if (zzcmx != null) {
                    zzciz.zzj("Precache task is already running.");
                    return;
                } else if (zzclh.zzm() == null) {
                    zzciz.zzj("Precache requires a dependency provider.");
                    return;
                } else {
                    Integer zzb4 = zzb(map2, "player");
                    if (zzb4 == null) {
                        zzb4 = 0;
                    }
                    if (zzb != null) {
                        zzclh.zzC(zzb.intValue());
                    }
                    if (zzb2 != null) {
                        zzclh.zzA(zzb2.intValue());
                    }
                    if (zzb3 != null) {
                        zzclh.zzz(zzb3.intValue());
                    }
                    int intValue = zzb4.intValue();
                    zzcmr zzcmr = zzclh.zzm().zzc;
                    if (intValue > 0) {
                        int zzs = zzcky.zzs();
                        if (zzs < zzclg.zzh) {
                            zzcnf = new zzcno(zzclh, zzclg);
                        } else if (zzs < zzclg.zzb) {
                            zzcnf = new zzcnl(zzclh, zzclg);
                        } else {
                            zzcnf = new zzcnj(zzclh);
                        }
                    } else {
                        zzcnf = new zzcni(zzclh);
                    }
                    new zzcmx(zzclh, zzcnf, str2, strArr).zzb();
                }
            } else {
                zzcmx zza = zzy.zza(zzclh);
                if (zza != null) {
                    zzcnf = zza.zzb;
                } else {
                    zzciz.zzj("Precache must specify a source.");
                    return;
                }
            }
            Integer zzb5 = zzb(map2, "minBufferMs");
            if (zzb5 != null) {
                zzcnf.zzp(zzb5.intValue());
            }
            Integer zzb6 = zzb(map2, "maxBufferMs");
            if (zzb6 != null) {
                zzcnf.zzo(zzb6.intValue());
            }
            Integer zzb7 = zzb(map2, "bufferForPlaybackMs");
            if (zzb7 != null) {
                zzcnf.zzh(zzb7.intValue());
            }
            Integer zzb8 = zzb(map2, "bufferForPlaybackAfterRebufferMs");
            if (zzb8 != null) {
                zzcnf.zzn(zzb8.intValue());
            }
        } else if (!zzy.zzd(zzclh)) {
            zzciz.zzj("Precache abort but no precache task running.");
        }
    }
}
