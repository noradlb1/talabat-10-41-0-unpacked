package com.google.android.gms.internal.p002firebaseauthapi;

import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.annotation.Nullable;
import org.threeten.bp.Year;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzake  reason: invalid package */
public final class zzake {
    public static final zzajj zza;
    public static final zzajj zzb;
    public static final zzajj zzc;
    private static final ThreadLocal zzd = new zzakd();
    @Nullable
    private static final Method zze = zzc("now");
    @Nullable
    private static final Method zzf = zzc("getEpochSecond");
    @Nullable
    private static final Method zzg = zzc("getNano");

    static {
        zzaji zzc2 = zzajj.zzc();
        zzc2.zzb(-62135596800L);
        zzc2.zza(0);
        zza = (zzajj) zzc2.zzi();
        zzaji zzc3 = zzajj.zzc();
        zzc3.zzb(253402300799L);
        zzc3.zza(Year.MAX_VALUE);
        zzb = (zzajj) zzc3.zzi();
        zzaji zzc4 = zzajj.zzc();
        zzc4.zzb(0);
        zzc4.zza(0);
        zzc = (zzajj) zzc4.zzi();
    }

    public static zzajj zza(zzajj zzajj) {
        long zzb2 = zzajj.zzb();
        int i11 = (zzb2 > -62135596800L ? 1 : (zzb2 == -62135596800L ? 0 : -1));
        int zza2 = zzajj.zza();
        if (i11 >= 0 && zzb2 <= 253402300799L && zza2 >= 0 && zza2 < 1000000000) {
            return zzajj;
        }
        throw new IllegalArgumentException(String.format("Timestamp is not valid. See proto definition for valid values. Seconds (%s) must be in range [-62,135,596,800, +253,402,300,799]. Nanos (%s) must be in range [0, +999,999,999].", new Object[]{Long.valueOf(zzb2), Integer.valueOf(zza2)}));
    }

    public static zzajj zzb(String str) throws ParseException {
        String str2;
        int i11;
        int indexOf = str.indexOf(84);
        if (indexOf != -1) {
            int indexOf2 = str.indexOf(90, indexOf);
            if (indexOf2 == -1) {
                indexOf2 = str.indexOf(43, indexOf);
            }
            if (indexOf2 == -1) {
                indexOf2 = str.indexOf(45, indexOf);
            }
            if (indexOf2 != -1) {
                String substring = str.substring(0, indexOf2);
                int indexOf3 = substring.indexOf(46);
                if (indexOf3 != -1) {
                    String substring2 = substring.substring(0, indexOf3);
                    str2 = substring.substring(indexOf3 + 1);
                    substring = substring2;
                } else {
                    str2 = "";
                }
                long time = ((SimpleDateFormat) zzd.get()).parse(substring).getTime() / 1000;
                if (str2.isEmpty()) {
                    i11 = 0;
                } else {
                    i11 = 0;
                    for (int i12 = 0; i12 < 9; i12++) {
                        i11 *= 10;
                        if (i12 < str2.length()) {
                            if (str2.charAt(i12) < '0' || str2.charAt(i12) > '9') {
                                throw new ParseException("Invalid nanoseconds.", 0);
                            }
                            i11 += str2.charAt(i12) - '0';
                        }
                    }
                }
                if (str.charAt(indexOf2) != 'Z') {
                    String substring3 = str.substring(indexOf2 + 1);
                    int indexOf4 = substring3.indexOf(58);
                    if (indexOf4 != -1) {
                        long parseLong = ((Long.parseLong(substring3.substring(0, indexOf4)) * 60) + Long.parseLong(substring3.substring(indexOf4 + 1))) * 60;
                        if (str.charAt(indexOf2) == '+') {
                            time -= parseLong;
                        } else {
                            time += parseLong;
                        }
                    } else {
                        throw new ParseException("Invalid offset value: ".concat(substring3), 0);
                    }
                } else if (str.length() != indexOf2 + 1) {
                    throw new ParseException("Failed to parse timestamp: invalid trailing data \"" + str.substring(indexOf2) + "\"", 0);
                }
                if (i11 <= -1000000000 || i11 >= 1000000000) {
                    try {
                        time = zzbb.zza(time, (long) (i11 / 1000000000));
                        i11 %= 1000000000;
                    } catch (IllegalArgumentException e11) {
                        ParseException parseException = new ParseException("Failed to parse timestamp " + str + " Timestamp is out of range.", 0);
                        parseException.initCause(e11);
                        throw parseException;
                    }
                }
                if (i11 < 0) {
                    i11 += 1000000000;
                    time = zzbb.zzb(time, 1);
                }
                zzaji zzc2 = zzajj.zzc();
                zzc2.zzb(time);
                zzc2.zza(i11);
                zzajj zzajj = (zzajj) zzc2.zzi();
                zza(zzajj);
                return zzajj;
            }
            throw new ParseException("Failed to parse timestamp: missing valid timezone offset.", 0);
        }
        throw new ParseException("Failed to parse timestamp: invalid timestamp \"" + str + "\"", 0);
    }

    @Nullable
    private static Method zzc(String str) {
        try {
            return Class.forName("java.time.Instant").getMethod(str, new Class[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
