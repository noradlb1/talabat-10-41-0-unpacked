package com.google.android.gms.analytics;

import android.net.Uri;
import android.text.TextUtils;
import com.apptimize.av;
import com.deliveryhero.chatsdk.util.PushNotificationParser;
import com.facebook.appevents.UserDataStore;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zzaa;
import com.google.android.gms.internal.gtm.zzab;
import com.google.android.gms.internal.gtm.zzac;
import com.google.android.gms.internal.gtm.zzam;
import com.google.android.gms.internal.gtm.zzao;
import com.google.android.gms.internal.gtm.zzap;
import com.google.android.gms.internal.gtm.zzas;
import com.google.android.gms.internal.gtm.zzcd;
import com.google.android.gms.internal.gtm.zzcz;
import com.google.android.gms.internal.gtm.zzq;
import com.google.android.gms.internal.gtm.zzr;
import com.google.android.gms.internal.gtm.zzs;
import com.google.android.gms.internal.gtm.zzt;
import com.google.android.gms.internal.gtm.zzu;
import com.google.android.gms.internal.gtm.zzv;
import com.google.android.gms.internal.gtm.zzw;
import com.google.android.gms.internal.gtm.zzx;
import com.google.android.gms.internal.gtm.zzy;
import com.google.android.gms.internal.gtm.zzz;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.huawei.hms.flutter.map.constants.Param;
import com.huawei.hms.framework.common.ContainerUtils;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public final class zzb extends zzam implements zzo {
    private static DecimalFormat zzrf;
    private final zzap zzrb;
    private final String zzrg;
    private final Uri zzrh;

    public zzb(zzap zzap, String str) {
        this(zzap, str, true, false);
    }

    private static void zza(Map<String, String> map, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            map.put(str, str2);
        }
    }

    public static Uri zzb(String str) {
        Preconditions.checkNotEmpty(str);
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("uri");
        builder.authority("google-analytics.com");
        builder.path(str);
        return builder.build();
    }

    @VisibleForTesting
    private static Map<String, String> zzc(zzg zzg) {
        String str;
        String str2;
        HashMap hashMap = new HashMap();
        zzu zzu = (zzu) zzg.zza(zzu.class);
        if (zzu != null) {
            for (Map.Entry next : zzu.zzbm().entrySet()) {
                Object value = next.getValue();
                String str3 = null;
                if (value != null) {
                    if (value instanceof String) {
                        String str4 = (String) value;
                        if (!TextUtils.isEmpty(str4)) {
                            str3 = str4;
                        }
                    } else if (value instanceof Double) {
                        Double d11 = (Double) value;
                        if (d11.doubleValue() != 0.0d) {
                            str3 = zza(d11.doubleValue());
                        }
                    } else if (!(value instanceof Boolean)) {
                        str3 = String.valueOf(value);
                    } else if (value != Boolean.FALSE) {
                        str3 = "1";
                    }
                }
                if (str3 != null) {
                    hashMap.put((String) next.getKey(), str3);
                }
            }
        }
        zzz zzz = (zzz) zzg.zza(zzz.class);
        if (zzz != null) {
            zza((Map<String, String>) hashMap, "t", zzz.zzbs());
            zza((Map<String, String>) hashMap, "cid", zzz.zzbt());
            zza((Map<String, String>) hashMap, PushNotificationParser.PUSH_ID_KEY, zzz.zzbu());
            zza((Map<String, String>) hashMap, "sc", zzz.zzbx());
            zza((Map<String, String>) hashMap, "sf", zzz.zzbz());
            zza((Map<String, String>) hashMap, "ni", zzz.zzby());
            zza((Map<String, String>) hashMap, "adid", zzz.zzbv());
            zza((Map<String, String>) hashMap, "ate", zzz.zzbw());
        }
        zzaa zzaa = (zzaa) zzg.zza(zzaa.class);
        if (zzaa != null) {
            zza((Map<String, String>) hashMap, "cd", zzaa.zzca());
            zza((Map<String, String>) hashMap, "a", (double) zzaa.zzcb());
            zza((Map<String, String>) hashMap, "dr", zzaa.zzcc());
        }
        zzx zzx = (zzx) zzg.zza(zzx.class);
        if (zzx != null) {
            zza((Map<String, String>) hashMap, "ec", zzx.zzbr());
            zza((Map<String, String>) hashMap, "ea", zzx.getAction());
            zza((Map<String, String>) hashMap, "el", zzx.getLabel());
            zza((Map<String, String>) hashMap, "ev", (double) zzx.getValue());
        }
        zzr zzr = (zzr) zzg.zza(zzr.class);
        if (zzr != null) {
            zza((Map<String, String>) hashMap, "cn", zzr.getName());
            zza((Map<String, String>) hashMap, "cs", zzr.getSource());
            zza((Map<String, String>) hashMap, "cm", zzr.zzbd());
            zza((Map<String, String>) hashMap, "ck", zzr.zzbe());
            zza((Map<String, String>) hashMap, "cc", zzr.zzbf());
            zza((Map<String, String>) hashMap, "ci", zzr.getId());
            zza((Map<String, String>) hashMap, "anid", zzr.zzbg());
            zza((Map<String, String>) hashMap, "gclid", zzr.zzbh());
            zza((Map<String, String>) hashMap, "dclid", zzr.zzbi());
            zza((Map<String, String>) hashMap, FirebaseAnalytics.Param.ACLID, zzr.zzbj());
        }
        zzy zzy = (zzy) zzg.zza(zzy.class);
        if (zzy != null) {
            zza((Map<String, String>) hashMap, "exd", zzy.zzuq);
            zza((Map<String, String>) hashMap, "exf", zzy.zzur);
        }
        zzab zzab = (zzab) zzg.zza(zzab.class);
        if (zzab != null) {
            zza((Map<String, String>) hashMap, "sn", zzab.zzvh);
            zza((Map<String, String>) hashMap, "sa", zzab.zzvi);
            zza((Map<String, String>) hashMap, UserDataStore.STATE, zzab.zzvj);
        }
        zzac zzac = (zzac) zzg.zza(zzac.class);
        if (zzac != null) {
            zza((Map<String, String>) hashMap, "utv", zzac.zzvk);
            zza((Map<String, String>) hashMap, "utt", (double) zzac.zzvl);
            zza((Map<String, String>) hashMap, "utc", zzac.mCategory);
            zza((Map<String, String>) hashMap, "utl", zzac.zzvm);
        }
        zzs zzs = (zzs) zzg.zza(zzs.class);
        if (zzs != null) {
            for (Map.Entry next2 : zzs.zzbk().entrySet()) {
                String zze = zzd.zze(((Integer) next2.getKey()).intValue());
                if (!TextUtils.isEmpty(zze)) {
                    hashMap.put(zze, (String) next2.getValue());
                }
            }
        }
        zzt zzt = (zzt) zzg.zza(zzt.class);
        if (zzt != null) {
            for (Map.Entry next3 : zzt.zzbl().entrySet()) {
                String zzg2 = zzd.zzg(((Integer) next3.getKey()).intValue());
                if (!TextUtils.isEmpty(zzg2)) {
                    hashMap.put(zzg2, zza(((Double) next3.getValue()).doubleValue()));
                }
            }
        }
        zzw zzw = (zzw) zzg.zza(zzw.class);
        if (zzw != null) {
            ProductAction zzbn = zzw.zzbn();
            if (zzbn != null) {
                for (Map.Entry next4 : zzbn.build().entrySet()) {
                    if (((String) next4.getKey()).startsWith(ContainerUtils.FIELD_DELIMITER)) {
                        hashMap.put(((String) next4.getKey()).substring(1), (String) next4.getValue());
                    } else {
                        hashMap.put((String) next4.getKey(), (String) next4.getValue());
                    }
                }
            }
            int i11 = 1;
            for (Promotion zzn : zzw.zzbq()) {
                hashMap.putAll(zzn.zzn(zzd.zzk(i11)));
                i11++;
            }
            int i12 = 1;
            for (Product zzn2 : zzw.zzbo()) {
                hashMap.putAll(zzn2.zzn(zzd.zzi(i12)));
                i12++;
            }
            int i13 = 1;
            for (Map.Entry next5 : zzw.zzbp().entrySet()) {
                String zzn3 = zzd.zzn(i13);
                int i14 = 1;
                for (Product product : (List) next5.getValue()) {
                    String valueOf = String.valueOf(zzn3);
                    String valueOf2 = String.valueOf(zzd.zzl(i14));
                    if (valueOf2.length() != 0) {
                        str2 = valueOf.concat(valueOf2);
                    } else {
                        str2 = new String(valueOf);
                    }
                    hashMap.putAll(product.zzn(str2));
                    i14++;
                }
                if (!TextUtils.isEmpty((CharSequence) next5.getKey())) {
                    String valueOf3 = String.valueOf(zzn3);
                    if ("nm".length() != 0) {
                        str = valueOf3.concat("nm");
                    } else {
                        str = new String(valueOf3);
                    }
                    hashMap.put(str, (String) next5.getKey());
                }
                i13++;
            }
        }
        zzv zzv = (zzv) zzg.zza(zzv.class);
        if (zzv != null) {
            zza((Map<String, String>) hashMap, "ul", zzv.getLanguage());
            zza((Map<String, String>) hashMap, "sd", (double) zzv.zzuk);
            zza(hashMap, "sr", zzv.zzul, zzv.zzum);
            zza(hashMap, "vp", zzv.zzun, zzv.zzuo);
        }
        zzq zzq = (zzq) zzg.zza(zzq.class);
        if (zzq != null) {
            zza((Map<String, String>) hashMap, "an", zzq.zzaz());
            zza((Map<String, String>) hashMap, "aid", zzq.zzbb());
            zza((Map<String, String>) hashMap, "aiid", zzq.zzbc());
            zza((Map<String, String>) hashMap, av.f41238a, zzq.zzba());
        }
        return hashMap;
    }

    public final Uri zzae() {
        return this.zzrh;
    }

    private zzb(zzap zzap, String str, boolean z11, boolean z12) {
        super(zzap);
        Preconditions.checkNotEmpty(str);
        this.zzrb = zzap;
        this.zzrg = str;
        this.zzrh = zzb(str);
    }

    private static String zza(double d11) {
        if (zzrf == null) {
            zzrf = new DecimalFormat("0.######");
        }
        return zzrf.format(d11);
    }

    private static void zza(Map<String, String> map, String str, double d11) {
        if (d11 != 0.0d) {
            map.put(str, zza(d11));
        }
    }

    private static void zza(Map<String, String> map, String str, boolean z11) {
        if (z11) {
            map.put(str, "1");
        }
    }

    public final void zzb(zzg zzg) {
        Preconditions.checkNotNull(zzg);
        Preconditions.checkArgument(zzg.zzan(), "Can't deliver not submitted measurement");
        Preconditions.checkNotMainThread("deliver should be called on worker thread");
        zzg zzai = zzg.zzai();
        zzz zzz = (zzz) zzai.zzb(zzz.class);
        if (TextUtils.isEmpty(zzz.zzbs())) {
            zzco().zza(zzc(zzai), "Ignoring measurement without type");
        } else if (TextUtils.isEmpty(zzz.zzbt())) {
            zzco().zza(zzc(zzai), "Ignoring measurement without client id");
        } else if (!this.zzrb.zzde().getAppOptOut()) {
            double zzbz = zzz.zzbz();
            if (zzcz.zza(zzbz, zzz.zzbt())) {
                zzb("Sampling enabled. Hit sampled out. sampling rate", Double.valueOf(zzbz));
                return;
            }
            Map<String, String> zzc = zzc(zzai);
            zzc.put("v", "1");
            zzc.put("_v", zzao.zzwe);
            zzc.put("tid", this.zzrg);
            if (this.zzrb.zzde().isDryRunEnabled()) {
                StringBuilder sb2 = new StringBuilder();
                for (Map.Entry next : zzc.entrySet()) {
                    if (sb2.length() != 0) {
                        sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                    }
                    sb2.append((String) next.getKey());
                    sb2.append("=");
                    sb2.append((String) next.getValue());
                }
                zzc("Dry run is enabled. GoogleAnalytics would have sent", sb2.toString());
                return;
            }
            HashMap hashMap = new HashMap();
            zzcz.zzb((Map<String, String>) hashMap, PushNotificationParser.PUSH_ID_KEY, zzz.zzbu());
            zzq zzq = (zzq) zzg.zza(zzq.class);
            if (zzq != null) {
                zzcz.zzb((Map<String, String>) hashMap, "an", zzq.zzaz());
                zzcz.zzb((Map<String, String>) hashMap, "aid", zzq.zzbb());
                zzcz.zzb((Map<String, String>) hashMap, av.f41238a, zzq.zzba());
                zzcz.zzb((Map<String, String>) hashMap, "aiid", zzq.zzbc());
            }
            zzc.put("_s", String.valueOf(zzcs().zza(new zzas(0, zzz.zzbt(), this.zzrg, !TextUtils.isEmpty(zzz.zzbv()), 0, hashMap))));
            zzcs().zza(new zzcd(zzco(), zzc, zzg.zzal(), true));
        }
    }

    private static void zza(Map<String, String> map, String str, int i11, int i12) {
        if (i11 > 0 && i12 > 0) {
            StringBuilder sb2 = new StringBuilder(23);
            sb2.append(i11);
            sb2.append(Param.X);
            sb2.append(i12);
            map.put(str, sb2.toString());
        }
    }
}
