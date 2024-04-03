package com.google.android.gms.internal.clearcut;

import androidx.webkit.ProxyConfig;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import net.bytebuddy.utility.JavaConstant;
import org.apache.commons.lang3.StringUtils;

public final class zzga {
    public static <T extends zzfz> String zza(T t11) {
        if (t11 == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        try {
            zza((String) null, t11, new StringBuffer(), stringBuffer);
            return stringBuffer.toString();
        } catch (IllegalAccessException e11) {
            String valueOf = String.valueOf(e11.getMessage());
            return valueOf.length() != 0 ? "Error printing proto: ".concat(valueOf) : new String("Error printing proto: ");
        } catch (InvocationTargetException e12) {
            String valueOf2 = String.valueOf(e12.getMessage());
            return valueOf2.length() != 0 ? "Error printing proto: ".concat(valueOf2) : new String("Error printing proto: ");
        }
    }

    private static void zza(String str, Object obj, StringBuffer stringBuffer, StringBuffer stringBuffer2) throws IllegalAccessException, InvocationTargetException {
        if (obj == null) {
            return;
        }
        if (obj instanceof zzfz) {
            int length = stringBuffer.length();
            if (str != null) {
                stringBuffer2.append(stringBuffer);
                stringBuffer2.append(zzl(str));
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
                        int length2 = obj2 == null ? 0 : Array.getLength(obj2);
                        for (int i11 = 0; i11 < length2; i11++) {
                            zza(name2, Array.get(obj2, i11), stringBuffer, stringBuffer2);
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
                        if (((Boolean) cls.getMethod(valueOf.length() != 0 ? "has".concat(valueOf) : new String("has"), new Class[0]).invoke(obj, new Object[0])).booleanValue()) {
                            String valueOf2 = String.valueOf(substring);
                            zza(substring, cls.getMethod(valueOf2.length() != 0 ? "get".concat(valueOf2) : new String("get"), new Class[0]).invoke(obj, new Object[0]), stringBuffer, stringBuffer2);
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
        String zzl = zzl(str);
        stringBuffer2.append(stringBuffer);
        stringBuffer2.append(zzl);
        stringBuffer2.append(": ");
        if (obj instanceof String) {
            String str2 = (String) obj;
            if (!str2.startsWith(ProxyConfig.MATCH_HTTP) && str2.length() > 200) {
                str2 = String.valueOf(str2.substring(0, 200)).concat("[...]");
            }
            int length3 = str2.length();
            StringBuilder sb2 = new StringBuilder(length3);
            for (int i12 = 0; i12 < length3; i12++) {
                char charAt = str2.charAt(i12);
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
                } else if (b12 < 32 || b12 >= Byte.MAX_VALUE) {
                    stringBuffer2.append(String.format("\\%03o", new Object[]{Integer.valueOf(b12)}));
                }
                stringBuffer2.append((char) b12);
            }
            stringBuffer2.append('\"');
        } else {
            stringBuffer2.append(obj);
        }
        stringBuffer2.append(StringUtils.LF);
    }

    private static String zzl(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i11 = 0; i11 < str.length(); i11++) {
            char charAt = str.charAt(i11);
            if (i11 != 0) {
                if (Character.isUpperCase(charAt)) {
                    stringBuffer.append('_');
                }
                stringBuffer.append(charAt);
            }
            charAt = Character.toLowerCase(charAt);
            stringBuffer.append(charAt);
        }
        return stringBuffer.toString();
    }
}
