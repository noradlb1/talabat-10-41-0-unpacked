package com.google.android.gms.internal.icing;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import net.bytebuddy.utility.JavaConstant;
import org.apache.commons.lang3.StringUtils;

final class zzeg {
    public static String zza(zzee zzee, String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("# ");
        sb2.append(str);
        zzc(zzee, sb2, 0);
        return sb2.toString();
    }

    public static final void zzb(StringBuilder sb2, int i11, String str, Object obj) {
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
            int i12 = 0;
            for (int i13 = 0; i13 < i11; i13++) {
                sb2.append(' ');
            }
            sb2.append(str);
            if (obj instanceof String) {
                sb2.append(": \"");
                sb2.append(zzfb.zza(zzcf.zzj((String) obj)));
                sb2.append('\"');
            } else if (obj instanceof zzcf) {
                sb2.append(": \"");
                sb2.append(zzfb.zza((zzcf) obj));
                sb2.append('\"');
            } else if (obj instanceof zzda) {
                sb2.append(" {");
                zzc((zzda) obj, sb2, i11 + 2);
                sb2.append(StringUtils.LF);
                while (i12 < i11) {
                    sb2.append(' ');
                    i12++;
                }
                sb2.append("}");
            } else if (obj instanceof Map.Entry) {
                sb2.append(" {");
                Map.Entry entry = (Map.Entry) obj;
                int i14 = i11 + 2;
                zzb(sb2, i14, "key", entry.getKey());
                zzb(sb2, i14, "value", entry.getValue());
                sb2.append(StringUtils.LF);
                while (i12 < i11) {
                    sb2.append(' ');
                    i12++;
                }
                sb2.append("}");
            } else {
                sb2.append(": ");
                sb2.append(obj.toString());
            }
        }
    }

    private static void zzc(zzee zzee, StringBuilder sb2, int i11) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        boolean z11;
        String str6;
        String str7;
        String str8;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        TreeSet<String> treeSet = new TreeSet<>();
        for (Method method : zzee.getClass().getDeclaredMethods()) {
            hashMap2.put(method.getName(), method);
            if (method.getParameterTypes().length == 0) {
                hashMap.put(method.getName(), method);
                if (method.getName().startsWith("get")) {
                    treeSet.add(method.getName());
                }
            }
        }
        for (String str9 : treeSet) {
            if (str9.startsWith("get")) {
                str = str9.substring(3);
            } else {
                str = str9;
            }
            if (str.endsWith("List") && !str.endsWith("OrBuilderList") && !str.equals("List")) {
                String valueOf = String.valueOf(str.substring(0, 1).toLowerCase());
                String valueOf2 = String.valueOf(str.substring(1, str.length() - 4));
                if (valueOf2.length() != 0) {
                    str8 = valueOf.concat(valueOf2);
                } else {
                    str8 = new String(valueOf);
                }
                Method method2 = (Method) hashMap.get(str9);
                if (method2 != null && method2.getReturnType().equals(List.class)) {
                    zzb(sb2, i11, zzd(str8), zzda.zzs(method2, zzee, new Object[0]));
                }
            }
            if (str.endsWith("Map") && !str.equals("Map")) {
                String valueOf3 = String.valueOf(str.substring(0, 1).toLowerCase());
                String valueOf4 = String.valueOf(str.substring(1, str.length() - 3));
                if (valueOf4.length() != 0) {
                    str7 = valueOf3.concat(valueOf4);
                } else {
                    str7 = new String(valueOf3);
                }
                Method method3 = (Method) hashMap.get(str9);
                if (method3 != null && method3.getReturnType().equals(Map.class) && !method3.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method3.getModifiers())) {
                    zzb(sb2, i11, zzd(str7), zzda.zzs(method3, zzee, new Object[0]));
                }
            }
            if (str.length() != 0) {
                str2 = "set".concat(str);
            } else {
                str2 = new String("set");
            }
            if (((Method) hashMap2.get(str2)) != null) {
                if (str.endsWith("Bytes")) {
                    String valueOf5 = String.valueOf(str.substring(0, str.length() - 5));
                    if (valueOf5.length() != 0) {
                        str6 = "get".concat(valueOf5);
                    } else {
                        str6 = new String("get");
                    }
                    if (hashMap.containsKey(str6)) {
                    }
                }
                String valueOf6 = String.valueOf(str.substring(0, 1).toLowerCase());
                String valueOf7 = String.valueOf(str.substring(1));
                if (valueOf7.length() != 0) {
                    str3 = valueOf6.concat(valueOf7);
                } else {
                    str3 = new String(valueOf6);
                }
                if (str.length() != 0) {
                    str4 = "get".concat(str);
                } else {
                    str4 = new String("get");
                }
                Method method4 = (Method) hashMap.get(str4);
                if (str.length() != 0) {
                    str5 = "has".concat(str);
                } else {
                    str5 = new String("has");
                }
                Method method5 = (Method) hashMap.get(str5);
                if (method4 != null) {
                    Object zzs = zzda.zzs(method4, zzee, new Object[0]);
                    if (method5 == null) {
                        if (zzs instanceof Boolean) {
                            if (!((Boolean) zzs).booleanValue()) {
                            }
                        } else if (zzs instanceof Integer) {
                            if (((Integer) zzs).intValue() == 0) {
                            }
                        } else if (zzs instanceof Float) {
                            if (((Float) zzs).floatValue() == 0.0f) {
                            }
                        } else if (!(zzs instanceof Double)) {
                            if (zzs instanceof String) {
                                z11 = zzs.equals("");
                            } else if (zzs instanceof zzcf) {
                                z11 = zzs.equals(zzcf.zzb);
                            } else if (zzs instanceof zzee) {
                                if (zzs == ((zzee) zzs).zzm()) {
                                }
                            } else if ((zzs instanceof Enum) && ((Enum) zzs).ordinal() == 0) {
                            }
                            if (z11) {
                            }
                        } else if (((Double) zzs).doubleValue() == 0.0d) {
                        }
                    } else if (!((Boolean) zzda.zzs(method5, zzee, new Object[0])).booleanValue()) {
                    }
                    zzb(sb2, i11, zzd(str3), zzs);
                }
            }
        }
        if (!(zzee instanceof zzcy)) {
            zzfe zzfe = ((zzda) zzee).zzc;
            if (zzfe != null) {
                zzfe.zze(sb2, i11);
                return;
            }
            return;
        }
        zzcy zzcy = (zzcy) zzee;
        throw null;
    }

    private static final String zzd(String str) {
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 0; i11 < str.length(); i11++) {
            char charAt = str.charAt(i11);
            if (Character.isUpperCase(charAt)) {
                sb2.append(JavaConstant.Dynamic.DEFAULT_NAME);
            }
            sb2.append(Character.toLowerCase(charAt));
        }
        return sb2.toString();
    }
}
