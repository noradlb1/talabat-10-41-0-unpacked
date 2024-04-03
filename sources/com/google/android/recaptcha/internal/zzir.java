package com.google.android.recaptcha.internal;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import net.bytebuddy.utility.JavaConstant;
import org.apache.commons.lang3.StringUtils;

final class zzir {
    private static final char[] zza;

    static {
        char[] cArr = new char[80];
        zza = cArr;
        Arrays.fill(cArr, ' ');
    }

    public static String zza(zzip zzip, String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("# ");
        sb2.append(str);
        zzd(zzip, sb2, 0);
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
                sb2.append(zzjr.zza(new zzff(((String) obj).getBytes(zzhn.zzb))));
                sb2.append('\"');
            } else if (obj instanceof zzfi) {
                sb2.append(": \"");
                sb2.append(zzjr.zza((zzfi) obj));
                sb2.append('\"');
            } else if (obj instanceof zzhf) {
                sb2.append(" {");
                zzd((zzhf) obj, sb2, i11 + 2);
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

    private static void zzd(zzip zzip, StringBuilder sb2, int i11) {
        int i12;
        boolean z11;
        Method method;
        Method method2;
        zzip zzip2 = zzip;
        StringBuilder sb3 = sb2;
        int i13 = i11;
        HashSet hashSet = new HashSet();
        HashMap hashMap = new HashMap();
        TreeMap treeMap = new TreeMap();
        Method[] declaredMethods = zzip.getClass().getDeclaredMethods();
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
                zzb(sb3, i13, substring.substring(0, substring.length() - 4), zzhf.zzy(method2, zzip2, new Object[0]));
            } else if (substring.endsWith("Map") && !substring.equals("Map") && (method = (Method) entry.getValue()) != null && method.getReturnType().equals(Map.class) && !method.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method.getModifiers())) {
                zzb(sb3, i13, substring.substring(0, substring.length() - 3), zzhf.zzy(method, zzip2, new Object[0]));
            } else if (hashSet.contains("set".concat(substring)) && (!substring.endsWith("Bytes") || !treeMap.containsKey("get".concat(String.valueOf(substring.substring(0, substring.length() - 5)))))) {
                Method method4 = (Method) entry.getValue();
                Method method5 = (Method) hashMap.get("has".concat(substring));
                if (method4 != null) {
                    Object zzy = zzhf.zzy(method4, zzip2, new Object[0]);
                    if (method5 == null) {
                        if (zzy instanceof Boolean) {
                            if (!((Boolean) zzy).booleanValue()) {
                            }
                        } else if (zzy instanceof Integer) {
                            if (((Integer) zzy).intValue() == 0) {
                            }
                        } else if (zzy instanceof Float) {
                            if (Float.floatToRawIntBits(((Float) zzy).floatValue()) == 0) {
                            }
                        } else if (!(zzy instanceof Double)) {
                            if (zzy instanceof String) {
                                z11 = zzy.equals("");
                            } else if (zzy instanceof zzfi) {
                                z11 = zzy.equals(zzfi.zzb);
                            } else if (zzy instanceof zzip) {
                                if (zzy == ((zzip) zzy).zzX()) {
                                }
                            } else if ((zzy instanceof Enum) && ((Enum) zzy).ordinal() == 0) {
                            }
                            if (z11) {
                            }
                        } else if (Double.doubleToRawLongBits(((Double) zzy).doubleValue()) == 0) {
                        }
                    } else if (!((Boolean) zzhf.zzy(method5, zzip2, new Object[0])).booleanValue()) {
                    }
                    zzb(sb3, i13, substring, zzy);
                }
            }
            i12 = 3;
        }
        if (zzip2 instanceof zzhb) {
            Iterator zzf = ((zzhb) zzip2).zzb.zzf();
            while (zzf.hasNext()) {
                Map.Entry entry2 = (Map.Entry) zzf.next();
                zzb(sb3, i13, "[" + ((zzhc) entry2.getKey()).zza + "]", entry2.getValue());
            }
        }
        zzjx zzjx = ((zzhf) zzip2).zzc;
        if (zzjx != null) {
            zzjx.zzi(sb3, i13);
        }
    }
}
