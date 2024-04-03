package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.common.net.HttpHeaders;
import j$.util.DesugarTimeZone;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

public final class zzahp {
    public static long zza(String str) {
        try {
            return zzd("EEE, dd MMM yyyy HH:mm:ss zzz").parse(str).getTime();
        } catch (ParseException e11) {
            if ("0".equals(str) || "-1".equals(str)) {
                zzahe.zzd("Unable to parse dateStr: %s, falling back to 0", str);
                return 0;
            }
            zzahe.zzc(e11, "Unable to parse dateStr: %s, falling back to 0", str);
            return 0;
        }
    }

    @Nullable
    public static zzagb zzb(zzago zzago) {
        long j11;
        long j12;
        long j13;
        boolean z11;
        long j14;
        long j15;
        long j16;
        long j17;
        long j18;
        zzago zzago2 = zzago;
        long currentTimeMillis = System.currentTimeMillis();
        Map<String, String> map = zzago2.zzc;
        if (map == null) {
            return null;
        }
        String str = map.get(HttpHeaders.DATE);
        if (str != null) {
            j11 = zza(str);
        } else {
            j11 = 0;
        }
        String str2 = map.get("Cache-Control");
        int i11 = 0;
        if (str2 != null) {
            String[] split = str2.split(",", 0);
            z11 = false;
            j13 = 0;
            j12 = 0;
            while (i11 < split.length) {
                String trim = split[i11].trim();
                if (trim.equals("no-cache") || trim.equals("no-store")) {
                    return null;
                }
                if (trim.startsWith("max-age=")) {
                    try {
                        j13 = Long.parseLong(trim.substring(8));
                    } catch (Exception unused) {
                    }
                } else if (trim.startsWith("stale-while-revalidate=")) {
                    j12 = Long.parseLong(trim.substring(23));
                } else if (trim.equals("must-revalidate") || trim.equals("proxy-revalidate")) {
                    z11 = true;
                }
                i11++;
            }
            i11 = 1;
        } else {
            z11 = false;
            j13 = 0;
            j12 = 0;
        }
        String str3 = map.get(HttpHeaders.EXPIRES);
        if (str3 != null) {
            j14 = zza(str3);
        } else {
            j14 = 0;
        }
        String str4 = map.get(HttpHeaders.LAST_MODIFIED);
        if (str4 != null) {
            j15 = zza(str4);
        } else {
            j15 = 0;
        }
        String str5 = map.get(HttpHeaders.ETAG);
        if (i11 != 0) {
            j17 = currentTimeMillis + (j13 * 1000);
            if (z11) {
                j18 = j17;
            } else {
                Long.signum(j12);
                j18 = (j12 * 1000) + j17;
            }
            j16 = j18;
        } else {
            j16 = 0;
            if (j11 <= 0 || j14 < j11) {
                j17 = 0;
            } else {
                j17 = currentTimeMillis + (j14 - j11);
                j16 = j17;
            }
        }
        zzagb zzagb = new zzagb();
        zzagb.zza = zzago2.zzb;
        zzagb.zzb = str5;
        zzagb.zzf = j17;
        zzagb.zze = j16;
        zzagb.zzc = j11;
        zzagb.zzd = j15;
        zzagb.zzg = map;
        zzagb.zzh = zzago2.zzd;
        return zzagb;
    }

    public static String zzc(long j11) {
        return zzd("EEE, dd MMM yyyy HH:mm:ss 'GMT'").format(new Date(j11));
    }

    private static SimpleDateFormat zzd(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.US);
        simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }
}
