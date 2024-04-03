package com.google.android.gms.tagmanager;

import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zzl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@VisibleForTesting
public final class zzgj {
    private static final Object zzalo = null;
    private static Long zzalp = new Long(0);
    private static Double zzalq = new Double(0.0d);
    private static zzgi zzalr = zzgi.zzm(0);
    private static String zzals = new String("");
    private static Boolean zzalt = new Boolean(false);
    private static List<Object> zzalu = new ArrayList(0);
    private static Map<Object, Object> zzalv = new HashMap();
    private static zzl zzalw = zzi(zzals);

    private static double getDouble(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).doubleValue();
        }
        zzdi.zzav("getDouble received non-Number");
        return 0.0d;
    }

    public static zzl zzbp(String str) {
        zzl zzl = new zzl();
        zzl.type = 5;
        zzl.zzqr = str;
        return zzl;
    }

    private static zzgi zzbq(String str) {
        try {
            return zzgi.zzbo(str);
        } catch (NumberFormatException unused) {
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 33);
            sb2.append("Failed to convert '");
            sb2.append(str);
            sb2.append("' to a number.");
            zzdi.zzav(sb2.toString());
            return zzalr;
        }
    }

    public static String zzc(zzl zzl) {
        return zzh(zzh(zzl));
    }

    public static zzgi zzd(zzl zzl) {
        Object zzh = zzh(zzl);
        if (zzh instanceof zzgi) {
            return (zzgi) zzh;
        }
        if (zzk(zzh)) {
            return zzgi.zzm(zzl(zzh));
        }
        if (zzj(zzh)) {
            return zzgi.zza(Double.valueOf(getDouble(zzh)));
        }
        return zzbq(zzh(zzh));
    }

    public static Long zze(zzl zzl) {
        Object zzh = zzh(zzl);
        if (zzk(zzh)) {
            return Long.valueOf(zzl(zzh));
        }
        zzgi zzbq = zzbq(zzh(zzh));
        if (zzbq == zzalr) {
            return zzalp;
        }
        return Long.valueOf(zzbq.longValue());
    }

    public static Double zzf(zzl zzl) {
        Object zzh = zzh(zzl);
        if (zzj(zzh)) {
            return Double.valueOf(getDouble(zzh));
        }
        zzgi zzbq = zzbq(zzh(zzh));
        if (zzbq == zzalr) {
            return zzalq;
        }
        return Double.valueOf(zzbq.doubleValue());
    }

    public static Boolean zzg(zzl zzl) {
        Object zzh = zzh(zzl);
        if (zzh instanceof Boolean) {
            return (Boolean) zzh;
        }
        String zzh2 = zzh(zzh);
        if ("true".equalsIgnoreCase(zzh2)) {
            return Boolean.TRUE;
        }
        if ("false".equalsIgnoreCase(zzh2)) {
            return Boolean.FALSE;
        }
        return zzalt;
    }

    private static String zzh(Object obj) {
        return obj == null ? zzals : obj.toString();
    }

    public static zzl zzi(Object obj) {
        String str;
        String str2;
        zzl zzl = new zzl();
        if (obj instanceof zzl) {
            return (zzl) obj;
        }
        boolean z11 = false;
        if (obj instanceof String) {
            zzl.type = 1;
            zzl.string = (String) obj;
        } else if (obj instanceof List) {
            zzl.type = 2;
            List<Object> list = (List) obj;
            ArrayList arrayList = new ArrayList(list.size());
            boolean z12 = false;
            for (Object zzi : list) {
                zzl zzi2 = zzi(zzi);
                zzl zzl2 = zzalw;
                if (zzi2 == zzl2) {
                    return zzl2;
                }
                if (z12 || zzi2.zzqw) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                arrayList.add(zzi2);
            }
            zzl.zzqn = (zzl[]) arrayList.toArray(new zzl[0]);
            z11 = z12;
        } else if (obj instanceof Map) {
            zzl.type = 3;
            Set<Map.Entry> entrySet = ((Map) obj).entrySet();
            ArrayList arrayList2 = new ArrayList(entrySet.size());
            ArrayList arrayList3 = new ArrayList(entrySet.size());
            boolean z13 = false;
            for (Map.Entry entry : entrySet) {
                zzl zzi3 = zzi(entry.getKey());
                zzl zzi4 = zzi(entry.getValue());
                zzl zzl3 = zzalw;
                if (zzi3 == zzl3 || zzi4 == zzl3) {
                    return zzl3;
                }
                if (z13 || zzi3.zzqw || zzi4.zzqw) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                arrayList2.add(zzi3);
                arrayList3.add(zzi4);
            }
            zzl.zzqo = (zzl[]) arrayList2.toArray(new zzl[0]);
            zzl.zzqp = (zzl[]) arrayList3.toArray(new zzl[0]);
            z11 = z13;
        } else if (zzj(obj)) {
            zzl.type = 1;
            zzl.string = obj.toString();
        } else if (zzk(obj)) {
            zzl.type = 6;
            zzl.zzqs = zzl(obj);
        } else if (obj instanceof Boolean) {
            zzl.type = 8;
            zzl.zzqt = ((Boolean) obj).booleanValue();
        } else {
            if (obj == null) {
                str = "null";
            } else {
                str = obj.getClass().toString();
            }
            String valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                str2 = "Converting to Value from unknown object type: ".concat(valueOf);
            } else {
                str2 = new String("Converting to Value from unknown object type: ");
            }
            zzdi.zzav(str2);
            return zzalw;
        }
        zzl.zzqw = z11;
        return zzl;
    }

    private static boolean zzj(Object obj) {
        if ((obj instanceof Double) || (obj instanceof Float)) {
            return true;
        }
        if (!(obj instanceof zzgi) || !((zzgi) obj).zzju()) {
            return false;
        }
        return true;
    }

    public static Object zzjw() {
        return null;
    }

    public static Long zzjx() {
        return zzalp;
    }

    public static Double zzjy() {
        return zzalq;
    }

    public static Boolean zzjz() {
        return zzalt;
    }

    private static boolean zzk(Object obj) {
        if ((obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long)) {
            return true;
        }
        if (!(obj instanceof zzgi) || !((zzgi) obj).zzjv()) {
            return false;
        }
        return true;
    }

    public static zzgi zzka() {
        return zzalr;
    }

    public static String zzkb() {
        return zzals;
    }

    public static zzl zzkc() {
        return zzalw;
    }

    private static long zzl(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).longValue();
        }
        zzdi.zzav("getInt64 received non-Number");
        return 0;
    }

    public static Object zzh(zzl zzl) {
        if (zzl == null) {
            return null;
        }
        int i11 = zzl.type;
        int i12 = 0;
        switch (i11) {
            case 1:
                return zzl.string;
            case 2:
                ArrayList arrayList = new ArrayList(zzl.zzqn.length);
                zzl[] zzlArr = zzl.zzqn;
                int length = zzlArr.length;
                while (i12 < length) {
                    Object zzh = zzh(zzlArr[i12]);
                    if (zzh == null) {
                        return null;
                    }
                    arrayList.add(zzh);
                    i12++;
                }
                return arrayList;
            case 3:
                if (zzl.zzqo.length != zzl.zzqp.length) {
                    String valueOf = String.valueOf(zzl.toString());
                    zzdi.zzav(valueOf.length() != 0 ? "Converting an invalid value to object: ".concat(valueOf) : new String("Converting an invalid value to object: "));
                    return null;
                }
                HashMap hashMap = new HashMap(zzl.zzqp.length);
                while (true) {
                    zzl[] zzlArr2 = zzl.zzqo;
                    if (i12 >= zzlArr2.length) {
                        return hashMap;
                    }
                    Object zzh2 = zzh(zzlArr2[i12]);
                    Object zzh3 = zzh(zzl.zzqp[i12]);
                    if (zzh2 == null || zzh3 == null) {
                        return null;
                    }
                    hashMap.put(zzh2, zzh3);
                    i12++;
                }
                return null;
            case 4:
                zzdi.zzav("Trying to convert a macro reference to object");
                return null;
            case 5:
                zzdi.zzav("Trying to convert a function id to object");
                return null;
            case 6:
                return Long.valueOf(zzl.zzqs);
            case 7:
                StringBuilder sb2 = new StringBuilder();
                zzl[] zzlArr3 = zzl.zzqu;
                int length2 = zzlArr3.length;
                while (i12 < length2) {
                    String zzh4 = zzh(zzh(zzlArr3[i12]));
                    if (zzh4 == zzals) {
                        return null;
                    }
                    sb2.append(zzh4);
                    i12++;
                }
                return sb2.toString();
            case 8:
                return Boolean.valueOf(zzl.zzqt);
            default:
                StringBuilder sb3 = new StringBuilder(46);
                sb3.append("Failed to convert a value of type: ");
                sb3.append(i11);
                zzdi.zzav(sb3.toString());
                return null;
        }
    }
}
