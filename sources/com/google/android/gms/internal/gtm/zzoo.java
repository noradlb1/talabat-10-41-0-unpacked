package com.google.android.gms.internal.gtm;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public final class zzoo {
    public static Map<String, Object> zza(Bundle bundle) {
        HashMap hashMap = new HashMap();
        for (String next : bundle.keySet()) {
            Object obj = bundle.get(next);
            if (obj instanceof Bundle) {
                hashMap.put(next, zza((Bundle) obj));
            } else if (obj instanceof List) {
                hashMap.put(next, zzf((List) obj));
            } else {
                hashMap.put(next, obj);
            }
        }
        return hashMap;
    }

    private static List<Object> zzf(List<Object> list) {
        ArrayList arrayList = new ArrayList();
        for (Object next : list) {
            if (next instanceof Bundle) {
                arrayList.add(zza((Bundle) next));
            } else if (next instanceof List) {
                arrayList.add(zzf((List) next));
            } else {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public static Object zzj(zzoa<?> zzoa) {
        if (zzoa == null || zzoa == zzog.zzaul) {
            return null;
        }
        if (zzoa instanceof zzod) {
            return (Boolean) ((zzod) zzoa).value();
        }
        if (zzoa instanceof zzoe) {
            zzoe zzoe = (zzoe) zzoa;
            double doubleValue = ((Double) zzoe.value()).doubleValue();
            if (Double.isInfinite(doubleValue) || doubleValue - Math.floor(doubleValue) >= 1.0E-5d) {
                return ((Double) zzoe.value()).toString();
            }
            return Integer.valueOf((int) doubleValue);
        } else if (zzoa instanceof zzom) {
            return (String) ((zzom) zzoa).value();
        } else {
            if (zzoa instanceof zzoh) {
                ArrayList arrayList = new ArrayList();
                for (zzoa zzoa2 : (List) ((zzoh) zzoa).value()) {
                    Object zzj = zzj(zzoa2);
                    if (zzj == null) {
                        zzev.zzav(String.format("Failure to convert a list element to object: %s (%s)", new Object[]{zzoa2, zzoa2.getClass().getCanonicalName()}));
                        return null;
                    }
                    arrayList.add(zzj);
                }
                return arrayList;
            } else if (zzoa instanceof zzok) {
                HashMap hashMap = new HashMap();
                for (Map.Entry entry : ((Map) ((zzok) zzoa).value()).entrySet()) {
                    Object zzj2 = zzj((zzoa) entry.getValue());
                    if (zzj2 == null) {
                        zzev.zzav(String.format("Failure to convert a map's value to object: %s (%s)", new Object[]{entry.getValue(), ((zzoa) entry.getValue()).getClass().getCanonicalName()}));
                        return null;
                    }
                    hashMap.put((String) entry.getKey(), zzj2);
                }
                return hashMap;
            } else {
                String valueOf = String.valueOf(zzoa.getClass());
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 49);
                sb2.append("Converting to Object from unknown abstract type: ");
                sb2.append(valueOf);
                zzev.zzav(sb2.toString());
                return null;
            }
        }
    }

    public static Bundle zzk(Map<String, zzoa<?>> map) {
        if (map == null) {
            return null;
        }
        Bundle bundle = new Bundle(map.size());
        for (Map.Entry next : map.entrySet()) {
            if (next.getValue() instanceof zzom) {
                bundle.putString((String) next.getKey(), (String) ((zzom) next.getValue()).value());
            } else if (next.getValue() instanceof zzod) {
                bundle.putBoolean((String) next.getKey(), ((Boolean) ((zzod) next.getValue()).value()).booleanValue());
            } else if (next.getValue() instanceof zzoe) {
                bundle.putDouble((String) next.getKey(), ((Double) ((zzoe) next.getValue()).value()).doubleValue());
            } else if (next.getValue() instanceof zzok) {
                bundle.putBundle((String) next.getKey(), zzk((Map<String, zzoa<?>>) (Map) ((zzok) next.getValue()).value()));
            } else {
                throw new IllegalArgumentException(String.format("Invalid param type for key '%s'. Only boolean, double and string types and maps of thereof are supported.", new Object[]{next.getKey()}));
            }
        }
        return bundle;
    }

    public static boolean zzl(zzoa zzoa) {
        if ((zzoa instanceof zzod) || (zzoa instanceof zzoe) || (zzoa instanceof zzom) || zzoa == zzog.zzaul || zzoa == zzog.zzaum) {
            return true;
        }
        return false;
    }

    public static boolean zzm(zzoa zzoa) {
        if (zzoa == zzog.zzauk || zzoa == zzog.zzauj) {
            return true;
        }
        if (!(zzoa instanceof zzog) || !((zzog) zzoa).zzmh()) {
            return false;
        }
        return true;
    }

    public static zzoa<?> zzq(@Nullable Object obj) {
        if (obj == null) {
            return zzog.zzaul;
        }
        if (obj instanceof zzoa) {
            return (zzoa) obj;
        }
        if (obj instanceof Boolean) {
            return new zzod((Boolean) obj);
        }
        if (obj instanceof Short) {
            return new zzoe(Double.valueOf(((Short) obj).doubleValue()));
        }
        if (obj instanceof Integer) {
            return new zzoe(Double.valueOf(((Integer) obj).doubleValue()));
        }
        if (obj instanceof Long) {
            return new zzoe(Double.valueOf(((Long) obj).doubleValue()));
        }
        if (obj instanceof Float) {
            return new zzoe(Double.valueOf(((Float) obj).doubleValue()));
        }
        if (obj instanceof Double) {
            return new zzoe((Double) obj);
        }
        if (obj instanceof Byte) {
            return new zzom(obj.toString());
        }
        if (obj instanceof Character) {
            return new zzom(obj.toString());
        }
        if (obj instanceof String) {
            return new zzom((String) obj);
        }
        if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            for (Object zzq : (List) obj) {
                arrayList.add(zzq(zzq));
            }
            return new zzoh(arrayList);
        } else if (obj instanceof Map) {
            HashMap hashMap = new HashMap();
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                Preconditions.checkArgument(entry.getKey() instanceof String);
                hashMap.put((String) entry.getKey(), zzq(entry.getValue()));
            }
            return new zzok(hashMap);
        } else if (obj instanceof Bundle) {
            HashMap hashMap2 = new HashMap();
            Bundle bundle = (Bundle) obj;
            for (String next : bundle.keySet()) {
                hashMap2.put(next, zzq(bundle.get(next)));
            }
            return new zzok(hashMap2);
        } else {
            String valueOf = String.valueOf(obj.getClass());
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 20);
            sb2.append("Type not supported: ");
            sb2.append(valueOf);
            throw new UnsupportedOperationException(sb2.toString());
        }
    }

    public static zzoa zza(zzfl zzfl, zzoa zzoa) {
        Preconditions.checkNotNull(zzoa);
        if (!zzl(zzoa) && !(zzoa instanceof zzof) && !(zzoa instanceof zzoh) && !(zzoa instanceof zzok)) {
            if (zzoa instanceof zzol) {
                zzoa = zza(zzfl, (zzol) zzoa);
            } else {
                throw new UnsupportedOperationException("Attempting to evaluate unknown type");
            }
        }
        if (zzoa == null) {
            throw new IllegalArgumentException("AbstractType evaluated to Java null");
        } else if (!(zzoa instanceof zzol)) {
            return zzoa;
        } else {
            throw new IllegalArgumentException("AbstractType evaluated to illegal type Statement.");
        }
    }

    public static zzoa zzk(zzoa<?> zzoa) {
        if (!(zzoa instanceof zzok)) {
            return zzoa;
        }
        HashSet<String> hashSet = new HashSet<>();
        Map map = (Map) ((zzok) zzoa).value();
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getValue() == zzog.zzaum) {
                hashSet.add((String) entry.getKey());
            }
        }
        for (String remove : hashSet) {
            map.remove(remove);
        }
        return zzoa;
    }

    public static zzog zza(zzfl zzfl, List<zzoa<?>> list) {
        for (zzoa next : list) {
            Preconditions.checkArgument(next instanceof zzol);
            zzoa zza = zza(zzfl, next);
            if (zzm(zza)) {
                return (zzog) zza;
            }
        }
        return zzog.zzaum;
    }

    public static zzoa zza(zzfl zzfl, zzol zzol) {
        String zzmj = zzol.zzmj();
        List<zzoa<?>> zzmk = zzol.zzmk();
        zzoa<?> zzca = zzfl.zzca(zzmj);
        if (zzca == null) {
            StringBuilder sb2 = new StringBuilder(String.valueOf(zzmj).length() + 28);
            sb2.append("Function '");
            sb2.append(zzmj);
            sb2.append("' is not supported");
            throw new UnsupportedOperationException(sb2.toString());
        } else if (zzca instanceof zzof) {
            return ((zzgz) ((zzof) zzca).value()).zzb(zzfl, (zzoa[]) zzmk.toArray(new zzoa[zzmk.size()]));
        } else {
            StringBuilder sb3 = new StringBuilder(String.valueOf(zzmj).length() + 29);
            sb3.append("Function '");
            sb3.append(zzmj);
            sb3.append("' is not a function");
            throw new UnsupportedOperationException(sb3.toString());
        }
    }
}
