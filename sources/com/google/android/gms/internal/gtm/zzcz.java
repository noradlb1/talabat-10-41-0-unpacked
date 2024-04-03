package com.google.android.gms.internal.gtm;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.checkout.frames.utils.constants.ExpiryDateConstantsKt;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.HttpUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.huawei.hms.framework.common.ContainerUtils;
import com.talabat.core.tracking.data.constant.ConstantsKt;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import com.talabat.userandlocation.compliance.status.data.impl.UserStatusRepositoryImplKt;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.CharCompanionObject;
import net.bytebuddy.description.type.TypeDescription;

@VisibleForTesting
public final class zzcz {
    private static final char[] zzact = {'0', ExpiryDateConstantsKt.EXPIRY_DATE_ZERO_POSITION_CHECK, '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static double zza(String str, double d11) {
        if (str == null) {
            return 100.0d;
        }
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException unused) {
            return 100.0d;
        }
    }

    public static Map<String, String> zzaf(String str) {
        String str2;
        HashMap hashMap = new HashMap();
        for (String split : str.split(ContainerUtils.FIELD_DELIMITER)) {
            String[] split2 = split.split("=", 3);
            String str3 = null;
            if (split2.length > 1) {
                String str4 = split2[0];
                if (TextUtils.isEmpty(split2[1])) {
                    str2 = null;
                } else {
                    str2 = split2[1];
                }
                hashMap.put(str4, str2);
                if (split2.length == 3 && !TextUtils.isEmpty(split2[1]) && !hashMap.containsKey(split2[1])) {
                    String str5 = split2[1];
                    if (!TextUtils.isEmpty(split2[2])) {
                        str3 = split2[2];
                    }
                    hashMap.put(str5, str3);
                }
            } else if (split2.length == 1 && split2[0].length() != 0) {
                hashMap.put(split2[0], (Object) null);
            }
        }
        return hashMap;
    }

    public static long zzag(String str) {
        if (str == null) {
            return 0;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public static String zzah(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.contains(TypeDescription.Generic.OfWildcardType.SYMBOL)) {
            String[] split = str.split("[\\?]");
            if (split.length > 1) {
                str = split[1];
            }
        }
        if (str.contains("%3D")) {
            try {
                str = URLDecoder.decode(str, "UTF-8");
            } catch (UnsupportedEncodingException unused) {
                return null;
            }
        } else if (!str.contains("=")) {
            return null;
        }
        Map<String, String> zzaf = zzaf(str);
        String[] strArr = {"dclid", ConstantsKt.DEEPLINK_UTM_SOURCE, "gclid", FirebaseAnalytics.Param.ACLID, ConstantsKt.DEEPLINK_UTM_CAMPAIGN, ConstantsKt.DEEPLINK_UTM_MEDIUM, ConstantsKt.DEEPLINK_UTM_TERM, ConstantsKt.DEEPLINK_UTM_CONTENT, ConstantsKt.DEEPLINK_UTM_ID, "anid", "gmob_t"};
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 0; i11 < 11; i11++) {
            if (!TextUtils.isEmpty(zzaf.get(strArr[i11]))) {
                if (sb2.length() > 0) {
                    sb2.append(ContainerUtils.FIELD_DELIMITER);
                }
                sb2.append(strArr[i11]);
                sb2.append("=");
                sb2.append(zzaf.get(strArr[i11]));
            }
        }
        return sb2.toString();
    }

    public static MessageDigest zzai(String str) {
        int i11 = 0;
        while (i11 < 2) {
            try {
                MessageDigest instance = MessageDigest.getInstance(str);
                if (instance != null) {
                    return instance;
                }
                i11++;
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return null;
    }

    public static boolean zzaj(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith("http:")) {
            return false;
        }
        return true;
    }

    public static boolean zzb(String str, boolean z11) {
        if (str == null || str.equalsIgnoreCase("true") || str.equalsIgnoreCase(UserStatusRepositoryImplKt.KEY_CALL_INVOKED) || str.equalsIgnoreCase("1") || (!str.equalsIgnoreCase("false") && !str.equalsIgnoreCase("no") && !str.equalsIgnoreCase("0"))) {
            return true;
        }
        return false;
    }

    public static String zzc(boolean z11) {
        return z11 ? "1" : "0";
    }

    public static void zzc(Map<String, String> map, String str, String str2) {
        if (str2 != null && TextUtils.isEmpty(map.get(str))) {
            map.put(str, str2);
        }
    }

    public static zzr zza(zzci zzci, String str) {
        Preconditions.checkNotNull(zzci);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        new HashMap();
        try {
            String valueOf = String.valueOf(str);
            Map<String, String> parse = HttpUtils.parse(new URI(valueOf.length() != 0 ? TypeDescription.Generic.OfWildcardType.SYMBOL.concat(valueOf) : new String(TypeDescription.Generic.OfWildcardType.SYMBOL)), "UTF-8");
            zzr zzr = new zzr();
            zzr.zzf(parse.get(ConstantsKt.DEEPLINK_UTM_CONTENT));
            zzr.zzd(parse.get(ConstantsKt.DEEPLINK_UTM_MEDIUM));
            zzr.setName(parse.get(ConstantsKt.DEEPLINK_UTM_CAMPAIGN));
            zzr.zzc(parse.get(ConstantsKt.DEEPLINK_UTM_SOURCE));
            zzr.zze(parse.get(ConstantsKt.DEEPLINK_UTM_TERM));
            zzr.zzg(parse.get(ConstantsKt.DEEPLINK_UTM_ID));
            zzr.zzh(parse.get("anid"));
            zzr.zzi(parse.get("gclid"));
            zzr.zzj(parse.get("dclid"));
            zzr.zzk(parse.get(FirebaseAnalytics.Param.ACLID));
            return zzr;
        } catch (URISyntaxException e11) {
            zzci.zzd("No valid campaign data found", e11);
            return null;
        }
    }

    public static boolean zzc(Context context, String str) {
        try {
            ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context, str), 0);
            if (serviceInfo == null || !serviceInfo.enabled) {
                return false;
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    public static void zzb(Map<String, String> map, String str, String str2) {
        if (str2 != null && !map.containsKey(str)) {
            map.put(str, str2);
        }
    }

    public static void zzb(Map<String, String> map, String str, boolean z11) {
        if (!map.containsKey(str)) {
            map.put(str, z11 ? "1" : "0");
        }
    }

    public static String zza(Locale locale) {
        if (locale == null) {
            return null;
        }
        String language = locale.getLanguage();
        if (TextUtils.isEmpty(language)) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(language.toLowerCase(locale));
        if (!TextUtils.isEmpty(locale.getCountry())) {
            sb2.append(SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE);
            sb2.append(locale.getCountry().toLowerCase(locale));
        }
        return sb2.toString();
    }

    public static void zza(Map<String, String> map, String str, Map<String, String> map2) {
        zzb(map, str, map2.get(str));
    }

    public static boolean zza(double d11, String str) {
        int i11;
        if (d11 > 0.0d && d11 < 100.0d) {
            if (!TextUtils.isEmpty(str)) {
                i11 = 0;
                for (int length = str.length() - 1; length >= 0; length--) {
                    char charAt = str.charAt(length);
                    i11 = ((i11 << 6) & CharCompanionObject.MAX_VALUE) + charAt + (charAt << 14);
                    int i12 = 266338304 & i11;
                    if (i12 != 0) {
                        i11 ^= i12 >> 21;
                    }
                }
            } else {
                i11 = 1;
            }
            if (((double) (i11 % 10000)) >= d11 * 100.0d) {
                return true;
            }
        }
        return false;
    }

    public static boolean zza(Context context, String str, boolean z11) {
        try {
            ActivityInfo receiverInfo = context.getPackageManager().getReceiverInfo(new ComponentName(context, str), 0);
            if (receiverInfo == null || !receiverInfo.enabled || (z11 && !receiverInfo.exported)) {
                return false;
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }
}
