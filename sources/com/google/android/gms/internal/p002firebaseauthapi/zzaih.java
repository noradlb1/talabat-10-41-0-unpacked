package com.google.android.gms.internal.p002firebaseauthapi;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import net.bytebuddy.utility.JavaConstant;
import org.apache.commons.lang3.StringUtils;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaih  reason: invalid package */
final class zzaih {
    private static final char[] zza;

    static {
        char[] cArr = new char[80];
        zza = cArr;
        Arrays.fill(cArr, ' ');
    }

    public static String zza(zzaif zzaif, String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("# ");
        sb2.append(str);
        zzd(zzaif, sb2, 0);
        return sb2.toString();
    }

    public static void zzb(StringBuilder sb2, int i11, String str, Object obj) {
        if (obj instanceof List) {
            for (Object zzb : (List) obj) {
                zzb(sb2, i11, str, zzb);
            }
        } else if (obj instanceof Map) {
            for (Map.Entry zzb2 : ((Map) obj).entrySet()) {
                zzb(sb2, i11, str, zzb2);
            }
        } else {
            sb2.append(10);
            zzc(i11, sb2);
            if (!str.isEmpty()) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(Character.toLowerCase(str.charAt(0)));
                for (int i12 = 1; i12 < str.length(); i12++) {
                    char charAt = str.charAt(i12);
                    if (Character.isUpperCase(charAt)) {
                        sb3.append(JavaConstant.Dynamic.DEFAULT_NAME);
                    }
                    sb3.append(Character.toLowerCase(charAt));
                }
                str = sb3.toString();
            }
            sb2.append(str);
            if (obj instanceof String) {
                sb2.append(": \"");
                sb2.append(zzajg.zza(new zzafs(((String) obj).getBytes(zzahg.zzb))));
                sb2.append('\"');
            } else if (obj instanceof zzafv) {
                sb2.append(": \"");
                sb2.append(zzajg.zza((zzafv) obj));
                sb2.append('\"');
            } else if (obj instanceof zzaha) {
                sb2.append(" {");
                zzd((zzaha) obj, sb2, i11 + 2);
                sb2.append(StringUtils.LF);
                zzc(i11, sb2);
                sb2.append("}");
            } else if (obj instanceof Map.Entry) {
                sb2.append(" {");
                Map.Entry entry = (Map.Entry) obj;
                int i13 = i11 + 2;
                zzb(sb2, i13, "key", entry.getKey());
                zzb(sb2, i13, "value", entry.getValue());
                sb2.append(StringUtils.LF);
                zzc(i11, sb2);
                sb2.append("}");
            } else {
                sb2.append(": ");
                sb2.append(obj);
            }
        }
    }

    private static void zzc(int i11, StringBuilder sb2) {
        while (i11 > 0) {
            int i12 = 80;
            if (i11 <= 80) {
                i12 = i11;
            }
            sb2.append(zza, 0, i12);
            i11 -= i12;
        }
    }

    private static void zzd(zzaif zzaif, StringBuilder sb2, int i11) {
        int i12;
        boolean z11;
        Method method;
        Method method2;
        zzaif zzaif2 = zzaif;
        StringBuilder sb3 = sb2;
        int i13 = i11;
        HashSet hashSet = new HashSet();
        HashMap hashMap = new HashMap();
        TreeMap treeMap = new TreeMap();
        Method[] declaredMethods = zzaif.getClass().getDeclaredMethods();
        int length = declaredMethods.length;
        int i14 = 0;
        while (true) {
            i12 = 3;
            if (i14 >= length) {
                break;
            }
            Method method3 = declaredMethods[i14];
            if (!Modifier.isStatic(method3.getModifiers()) && method3.getName().length() >= 3) {
                if (method3.getName().startsWith("set")) {
                    hashSet.add(method3.getName());
                } else if (Modifier.isPublic(method3.getModifiers()) && method3.getParameterTypes().length == 0) {
                    if (method3.getName().startsWith("has")) {
                        hashMap.put(method3.getName(), method3);
                    } else if (method3.getName().startsWith("get")) {
                        treeMap.put(method3.getName(), method3);
                    }
                }
            }
            i14++;
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            String substring = ((String) entry.getKey()).substring(i12);
            if (substring.endsWith("List") && !substring.endsWith("OrBuilderList") && !substring.equals("List") && (method2 = (Method) entry.getValue()) != null && method2.getReturnType().equals(List.class)) {
                zzb(sb3, i13, substring.substring(0, substring.length() - 4), zzaha.zzD(method2, zzaif2, new Object[0]));
            } else if (substring.endsWith("Map") && !substring.equals("Map") && (method = (Method) entry.getValue()) != null && method.getReturnType().equals(Map.class) && !method.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method.getModifiers())) {
                zzb(sb3, i13, substring.substring(0, substring.length() - 3), zzaha.zzD(method, zzaif2, new Object[0]));
            } else if (hashSet.contains("set".concat(substring)) && (!substring.endsWith("Bytes") || !treeMap.containsKey("get".concat(String.valueOf(substring.substring(0, substring.length() - 5)))))) {
                Method method4 = (Method) entry.getValue();
                Method method5 = (Method) hashMap.get("has".concat(substring));
                if (method4 != null) {
                    Object zzD = zzaha.zzD(method4, zzaif2, new Object[0]);
                    if (method5 == null) {
                        if (zzD instanceof Boolean) {
                            if (!((Boolean) zzD).booleanValue()) {
                            }
                        } else if (zzD instanceof Integer) {
                            if (((Integer) zzD).intValue() == 0) {
                            }
                        } else if (zzD instanceof Float) {
                            if (Float.floatToRawIntBits(((Float) zzD).floatValue()) == 0) {
                            }
                        } else if (!(zzD instanceof Double)) {
                            if (zzD instanceof String) {
                                z11 = zzD.equals("");
                            } else if (zzD instanceof zzafv) {
                                z11 = zzD.equals(zzafv.zzb);
                            } else if (zzD instanceof zzaif) {
                                if (zzD == ((zzaif) zzD).zzM()) {
                                }
                            } else if ((zzD instanceof Enum) && ((Enum) zzD).ordinal() == 0) {
                            }
                            if (z11) {
                            }
                        } else if (Double.doubleToRawLongBits(((Double) zzD).doubleValue()) == 0) {
                        }
                    } else if (!((Boolean) zzaha.zzD(method5, zzaif2, new Object[0])).booleanValue()) {
                    }
                    zzb(sb3, i13, substring, zzD);
                }
            }
            i12 = 3;
        }
        if (!(zzaif2 instanceof zzagx)) {
            zzajm zzajm = ((zzaha) zzaif2).zzc;
            if (zzajm != null) {
                zzajm.zzi(sb3, i13);
                return;
            }
            return;
        }
        zzagx zzagx = (zzagx) zzaif2;
        throw null;
    }
}
