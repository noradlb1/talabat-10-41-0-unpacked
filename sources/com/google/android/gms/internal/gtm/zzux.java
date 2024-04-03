package com.google.android.gms.internal.gtm;

import androidx.webkit.ProxyConfig;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import net.bytebuddy.utility.JavaConstant;
import org.apache.commons.lang3.StringUtils;

public final class zzux {
    private static void zza(String str, Object obj, StringBuffer stringBuffer, StringBuffer stringBuffer2) throws IllegalAccessException, InvocationTargetException {
        String str2;
        String str3;
        int i11;
        if (obj == null) {
            return;
        }
        if (obj instanceof zzuw) {
            int length = stringBuffer.length();
            if (str != null) {
                stringBuffer2.append(stringBuffer);
                stringBuffer2.append(zzde(str));
                stringBuffer2.append(" <\n");
                stringBuffer.append("  ");
            }
            Class<?> cls = obj.getClass();
            for (Field field : cls.getFields()) {
                int modifiers = field.getModifiers();
                String name2 = field.getName();
                if (!"cachedSize".equals(name2) && (modifiers & 1) == 1 && (modifiers & 8) != 8 && !name2.startsWith(JavaConstant.Dynamic.DEFAULT_NAME) && !name2.endsWith(JavaConstant.Dynamic.DEFAULT_NAME)) {
                    Class<?> type = field.getType();
                    Object obj2 = field.get(obj);
                    if (!type.isArray() || type.getComponentType() == Byte.TYPE) {
                        zza(name2, obj2, stringBuffer, stringBuffer2);
                    } else {
                        if (obj2 == null) {
                            i11 = 0;
                        } else {
                            i11 = Array.getLength(obj2);
                        }
                        for (int i12 = 0; i12 < i11; i12++) {
                            zza(name2, Array.get(obj2, i12), stringBuffer, stringBuffer2);
                        }
                    }
                }
            }
            for (Method name3 : cls.getMethods()) {
                String name4 = name3.getName();
                if (name4.startsWith("set")) {
                    String substring = name4.substring(3);
                    try {
                        String valueOf = String.valueOf(substring);
                        if (valueOf.length() != 0) {
                            str2 = "has".concat(valueOf);
                        } else {
                            str2 = new String("has");
                        }
                        if (((Boolean) cls.getMethod(str2, new Class[0]).invoke(obj, new Object[0])).booleanValue()) {
                            String valueOf2 = String.valueOf(substring);
                            if (valueOf2.length() != 0) {
                                str3 = "get".concat(valueOf2);
                            } else {
                                str3 = new String("get");
                            }
                            zza(substring, cls.getMethod(str3, new Class[0]).invoke(obj, new Object[0]), stringBuffer, stringBuffer2);
                        }
                    } catch (NoSuchMethodException unused) {
                    }
                }
            }
            if (str != null) {
                stringBuffer.setLength(length);
                stringBuffer2.append(stringBuffer);
                stringBuffer2.append(">\n");
                return;
            }
            return;
        }
        String zzde = zzde(str);
        stringBuffer2.append(stringBuffer);
        stringBuffer2.append(zzde);
        stringBuffer2.append(": ");
        if (obj instanceof String) {
            String str4 = (String) obj;
            if (!str4.startsWith(ProxyConfig.MATCH_HTTP) && str4.length() > 200) {
                str4 = String.valueOf(str4.substring(0, 200)).concat("[...]");
            }
            int length2 = str4.length();
            StringBuilder sb2 = new StringBuilder(length2);
            for (int i13 = 0; i13 < length2; i13++) {
                char charAt = str4.charAt(i13);
                if (charAt < ' ' || charAt > '~' || charAt == '\"' || charAt == '\'') {
                    sb2.append(String.format("\\u%04x", new Object[]{Integer.valueOf(charAt)}));
                } else {
                    sb2.append(charAt);
                }
            }
            String sb3 = sb2.toString();
            stringBuffer2.append("\"");
            stringBuffer2.append(sb3);
            stringBuffer2.append("\"");
        } else if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            stringBuffer2.append('\"');
            for (byte b11 : bArr) {
                byte b12 = b11 & 255;
                if (b12 == 92 || b12 == 34) {
                    stringBuffer2.append('\\');
                    stringBuffer2.append((char) b12);
                } else if (b12 < 32 || b12 >= Byte.MAX_VALUE) {
                    stringBuffer2.append(String.format("\\%03o", new Object[]{Integer.valueOf(b12)}));
                } else {
                    stringBuffer2.append((char) b12);
                }
            }
            stringBuffer2.append('\"');
        } else {
            stringBuffer2.append(obj);
        }
        stringBuffer2.append(StringUtils.LF);
    }

    public static <T extends zzuw> String zzc(T t11) {
        if (t11 == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        try {
            zza((String) null, t11, new StringBuffer(), stringBuffer);
            return stringBuffer.toString();
        } catch (IllegalAccessException e11) {
            String valueOf = String.valueOf(e11.getMessage());
            if (valueOf.length() != 0) {
                return "Error printing proto: ".concat(valueOf);
            }
            return new String("Error printing proto: ");
        } catch (InvocationTargetException e12) {
            String valueOf2 = String.valueOf(e12.getMessage());
            if (valueOf2.length() != 0) {
                return "Error printing proto: ".concat(valueOf2);
            }
            return new String("Error printing proto: ");
        }
    }

    private static String zzde(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i11 = 0; i11 < str.length(); i11++) {
            char charAt = str.charAt(i11);
            if (i11 == 0) {
                stringBuffer.append(Character.toLowerCase(charAt));
            } else if (Character.isUpperCase(charAt)) {
                stringBuffer.append('_');
                stringBuffer.append(Character.toLowerCase(charAt));
            } else {
                stringBuffer.append(charAt);
            }
        }
        return stringBuffer.toString();
    }
}
