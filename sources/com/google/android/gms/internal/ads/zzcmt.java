package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Color;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.ads.internal.util.zzcl;
import com.google.android.gms.ads.internal.util.zze;
import com.huawei.hms.flutter.map.constants.Param;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public final class zzcmt implements zzbrt<zzclh> {
    private boolean zza;

    private static int zzb(Context context, Map<String, String> map, String str, int i11) {
        String str2 = map.get(str);
        if (str2 != null) {
            try {
                zzbgo.zzb();
                i11 = zzcis.zzs(context, Integer.parseInt(str2));
            } catch (NumberFormatException unused) {
                StringBuilder sb2 = new StringBuilder(str.length() + 34 + str2.length());
                sb2.append("Could not parse ");
                sb2.append(str);
                sb2.append(" in a video GMSG: ");
                sb2.append(str2);
                zzciz.zzj(sb2.toString());
            }
        }
        if (zze.zzc()) {
            StringBuilder sb3 = new StringBuilder(str.length() + 48 + String.valueOf(str2).length());
            sb3.append("Parse pixels for ");
            sb3.append(str);
            sb3.append(", got string ");
            sb3.append(str2);
            sb3.append(", int ");
            sb3.append(i11);
            sb3.append(RealDiscoveryConfigurationRepository.VERSION_DELIMETER);
            zze.zza(sb3.toString());
        }
        return i11;
    }

    private static void zzc(zzckv zzckv, Map<String, String> map) {
        String str = map.get("minBufferMs");
        String str2 = map.get("maxBufferMs");
        String str3 = map.get("bufferForPlaybackMs");
        String str4 = map.get("bufferForPlaybackAfterRebufferMs");
        String str5 = map.get("socketReceiveBufferSize");
        if (str != null) {
            try {
                zzckv.zzz(Integer.parseInt(str));
            } catch (NumberFormatException unused) {
                zzciz.zzj(String.format("Could not parse buffer parameters in loadControl video GMSG: (%s, %s)", new Object[]{str, str2}));
                return;
            }
        }
        if (str2 != null) {
            zzckv.zzy(Integer.parseInt(str2));
        }
        if (str3 != null) {
            zzckv.zzw(Integer.parseInt(str3));
        }
        if (str4 != null) {
            zzckv.zzx(Integer.parseInt(str4));
        }
        if (str5 != null) {
            zzckv.zzB(Integer.parseInt(str5));
        }
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        int i11;
        int i12;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        zzclh zzclh = (zzclh) obj;
        String str6 = (String) map.get(NativeProtocol.WEB_DIALOG_ACTION);
        if (str6 == null) {
            zzciz.zzj("Action missing from video GMSG.");
            return;
        }
        if (zzciz.zzm(3)) {
            JSONObject jSONObject = new JSONObject((Map<?, ?>) map);
            jSONObject.remove("google.afma.Notify_dt");
            String jSONObjectInstrumentation = JSONObjectInstrumentation.toString(jSONObject);
            StringBuilder sb2 = new StringBuilder(str6.length() + 13 + String.valueOf(jSONObjectInstrumentation).length());
            sb2.append("Video GMSG: ");
            sb2.append(str6);
            sb2.append(" ");
            sb2.append(jSONObjectInstrumentation);
            zzciz.zze(sb2.toString());
        }
        if ("background".equals(str6)) {
            String str7 = (String) map.get("color");
            if (TextUtils.isEmpty(str7)) {
                zzciz.zzj("Color parameter missing from background video GMSG.");
                return;
            }
            try {
                zzclh.setBackgroundColor(Color.parseColor(str7));
            } catch (IllegalArgumentException unused) {
                zzciz.zzj("Invalid color parameter in background video GMSG.");
            }
        } else if ("playerBackground".equals(str6)) {
            String str8 = (String) map.get("color");
            if (TextUtils.isEmpty(str8)) {
                zzciz.zzj("Color parameter missing from playerBackground video GMSG.");
                return;
            }
            try {
                zzclh.zzD(Color.parseColor(str8));
            } catch (IllegalArgumentException unused2) {
                zzciz.zzj("Invalid color parameter in playerBackground video GMSG.");
            }
        } else {
            int i13 = 0;
            if ("decoderProps".equals(str6)) {
                String str9 = (String) map.get("mimeTypes");
                if (str9 == null) {
                    zzciz.zzj("No MIME types specified for decoder properties inspection.");
                    HashMap hashMap = new HashMap();
                    hashMap.put("event", "decoderProps");
                    hashMap.put("error", "missingMimeTypes");
                    zzclh.zzd("onVideoEvent", hashMap);
                    return;
                }
                HashMap hashMap2 = new HashMap();
                String[] split = str9.split(",");
                int length = split.length;
                while (i13 < length) {
                    String str10 = split[i13];
                    hashMap2.put(str10, zzcl.zza(str10.trim()));
                    i13++;
                }
                HashMap hashMap3 = new HashMap();
                hashMap3.put("event", "decoderProps");
                hashMap3.put("mimeTypes", hashMap2);
                zzclh.zzd("onVideoEvent", hashMap3);
                return;
            }
            zzckw zzbx = zzclh.zzbx();
            if (zzbx == null) {
                zzciz.zzj("Could not get underlay container for a video GMSG.");
                return;
            }
            boolean equals = "new".equals(str6);
            boolean equals2 = "position".equals(str6);
            if (equals || equals2) {
                Context context = zzclh.getContext();
                int zzb = zzb(context, map, Param.X, 0);
                int zzb2 = zzb(context, map, Param.Y, 0);
                int zzb3 = zzb(context, map, "w", -1);
                zzblb zzblb = zzblj.zzcw;
                if (!((Boolean) zzbgq.zzc().zzb(zzblb)).booleanValue()) {
                    if (zze.zzc()) {
                        int zzj = zzclh.zzj();
                        StringBuilder sb3 = new StringBuilder(110);
                        sb3.append("Calculate width with original width ");
                        sb3.append(zzb3);
                        sb3.append(", videoHost.getVideoBoundingWidth() ");
                        sb3.append(zzj);
                        sb3.append(", x ");
                        sb3.append(zzb);
                        sb3.append(RealDiscoveryConfigurationRepository.VERSION_DELIMETER);
                        zze.zza(sb3.toString());
                    }
                    i11 = Math.min(zzb3, zzclh.zzj() - zzb);
                } else if (zzb3 == -1) {
                    i11 = zzclh.zzj();
                } else {
                    i11 = Math.min(zzb3, zzclh.zzj());
                }
                int zzb4 = zzb(context, map, "h", -1);
                if (!((Boolean) zzbgq.zzc().zzb(zzblb)).booleanValue()) {
                    if (zze.zzc()) {
                        int zzi = zzclh.zzi();
                        StringBuilder sb4 = new StringBuilder(113);
                        sb4.append("Calculate height with original height ");
                        sb4.append(zzb4);
                        sb4.append(", videoHost.getVideoBoundingHeight() ");
                        sb4.append(zzi);
                        sb4.append(", y ");
                        sb4.append(zzb2);
                        sb4.append(RealDiscoveryConfigurationRepository.VERSION_DELIMETER);
                        zze.zza(sb4.toString());
                    }
                    i12 = Math.min(zzb4, zzclh.zzi() - zzb2);
                } else if (zzb4 == -1) {
                    i12 = zzclh.zzi();
                } else {
                    i12 = Math.min(zzb4, zzclh.zzi());
                }
                int i14 = i12;
                try {
                    i13 = Integer.parseInt((String) map.get("player"));
                } catch (NumberFormatException unused3) {
                }
                int i15 = i13;
                boolean parseBoolean = Boolean.parseBoolean((String) map.get("spherical"));
                if (!equals || zzbx.zza() != null) {
                    zzbx.zzb(zzb, zzb2, i11, i14);
                    return;
                }
                zzbx.zzc(zzb, zzb2, i11, i14, i15, parseBoolean, new zzclg((String) map.get("flags")));
                zzckv zza2 = zzbx.zza();
                if (zza2 != null) {
                    zzc(zza2, map);
                    return;
                }
                return;
            }
            zzcpl zzs = zzclh.zzs();
            if (zzs != null) {
                if ("timeupdate".equals(str6)) {
                    String str11 = (String) map.get("currentTime");
                    if (str11 == null) {
                        zzciz.zzj("currentTime parameter missing from timeupdate video GMSG.");
                        return;
                    }
                    try {
                        zzs.zzt(Float.parseFloat(str11));
                        return;
                    } catch (NumberFormatException unused4) {
                        if (str11.length() != 0) {
                            str5 = "Could not parse currentTime parameter from timeupdate video GMSG: ".concat(str11);
                        } else {
                            str5 = new String("Could not parse currentTime parameter from timeupdate video GMSG: ");
                        }
                        zzciz.zzj(str5);
                        return;
                    }
                } else if ("skip".equals(str6)) {
                    zzs.zzu();
                    return;
                }
            }
            zzckv zza3 = zzbx.zza();
            if (zza3 == null) {
                HashMap hashMap4 = new HashMap();
                hashMap4.put("event", "no_video_view");
                zzclh.zzd("onVideoEvent", hashMap4);
            } else if ("click".equals(str6)) {
                Context context2 = zzclh.getContext();
                int zzb5 = zzb(context2, map, Param.X, 0);
                int zzb6 = zzb(context2, map, Param.Y, 0);
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, (float) zzb5, (float) zzb6, 0);
                zza3.zzv(obtain);
                obtain.recycle();
            } else if ("currentTime".equals(str6)) {
                String str12 = (String) map.get("time");
                if (str12 == null) {
                    zzciz.zzj("Time parameter missing from currentTime video GMSG.");
                    return;
                }
                try {
                    zza3.zzu((int) (Float.parseFloat(str12) * 1000.0f));
                } catch (NumberFormatException unused5) {
                    if (str12.length() != 0) {
                        str4 = "Could not parse time parameter from currentTime video GMSG: ".concat(str12);
                    } else {
                        str4 = new String("Could not parse time parameter from currentTime video GMSG: ");
                    }
                    zzciz.zzj(str4);
                }
            } else if ("hide".equals(str6)) {
                zza3.setVisibility(4);
            } else if ("load".equals(str6)) {
                zza3.zzp();
            } else if ("loadControl".equals(str6)) {
                zzc(zza3, map);
            } else if ("muted".equals(str6)) {
                if (Boolean.parseBoolean((String) map.get("muted"))) {
                    zza3.zzq();
                } else {
                    zza3.zzG();
                }
            } else if ("pause".equals(str6)) {
                zza3.zzs();
            } else if ("play".equals(str6)) {
                zza3.zzt();
            } else if ("show".equals(str6)) {
                zza3.setVisibility(0);
            } else if ("src".equals(str6)) {
                String str13 = (String) map.get("src");
                Integer num = null;
                if (map.containsKey("periodicReportIntervalMs")) {
                    try {
                        num = Integer.valueOf(Integer.parseInt((String) map.get("periodicReportIntervalMs")));
                    } catch (NumberFormatException unused6) {
                        zzciz.zzj("Video gmsg invalid numeric parameter 'periodicReportIntervalMs': ".concat(String.valueOf((String) map.get("periodicReportIntervalMs"))));
                    }
                }
                String[] strArr = {str13};
                String str14 = (String) map.get("demuxed");
                if (str14 != null) {
                    try {
                        JSONArray jSONArray = new JSONArray(str14);
                        String[] strArr2 = new String[jSONArray.length()];
                        for (int i16 = 0; i16 < jSONArray.length(); i16++) {
                            strArr2[i16] = jSONArray.getString(i16);
                        }
                        strArr = strArr2;
                    } catch (JSONException unused7) {
                        if (str14.length() != 0) {
                            str3 = "Malformed demuxed URL list for playback: ".concat(str14);
                        } else {
                            str3 = new String("Malformed demuxed URL list for playback: ");
                        }
                        zzciz.zzj(str3);
                        strArr = new String[]{str13};
                    }
                }
                if (num != null) {
                    zzclh.zzC(num.intValue());
                }
                zza3.zzC(str13, strArr);
            } else if ("touchMove".equals(str6)) {
                Context context3 = zzclh.getContext();
                zza3.zzF((float) zzb(context3, map, "dx", 0), (float) zzb(context3, map, "dy", 0));
                if (!this.zza) {
                    zzclh.zzw();
                    this.zza = true;
                }
            } else if ("volume".equals(str6)) {
                String str15 = (String) map.get("volume");
                if (str15 == null) {
                    zzciz.zzj("Level parameter missing from volume video GMSG.");
                    return;
                }
                try {
                    zza3.zzE(Float.parseFloat(str15));
                } catch (NumberFormatException unused8) {
                    if (str15.length() != 0) {
                        str2 = "Could not parse volume parameter from volume video GMSG: ".concat(str15);
                    } else {
                        str2 = new String("Could not parse volume parameter from volume video GMSG: ");
                    }
                    zzciz.zzj(str2);
                }
            } else if ("watermark".equals(str6)) {
                zza3.zzm();
            } else {
                if (str6.length() != 0) {
                    str = "Unknown video action: ".concat(str6);
                } else {
                    str = new String("Unknown video action: ");
                }
                zzciz.zzj(str);
            }
        }
    }
}
