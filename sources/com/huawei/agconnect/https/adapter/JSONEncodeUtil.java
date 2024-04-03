package com.huawei.agconnect.https.adapter;

import com.huawei.agconnect.https.h;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Collection;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONException;

public final class JSONEncodeUtil {
    boolean expectObjectNull;
    boolean useAnnotation;

    public JSONEncodeUtil() {
        this(true);
    }

    public JSONEncodeUtil(boolean z11) {
        this.expectObjectNull = false;
        this.useAnnotation = z11;
    }

    public JSONEncodeUtil(boolean z11, boolean z12) {
        this.useAnnotation = z11;
        this.expectObjectNull = z12;
    }

    private void accessible(final Field field) {
        if (!field.isAccessible()) {
            AccessController.doPrivileged(new PrivilegedAction() {
                public Object run() {
                    field.setAccessible(true);
                    return null;
                }
            });
        }
    }

    private String addJsonArrayEnding(StringBuilder sb2) {
        if (sb2.length() == 1) {
            sb2.append(AbstractJsonLexerKt.END_LIST);
        } else {
            sb2.setCharAt(sb2.length() - 1, AbstractJsonLexerKt.END_LIST);
        }
        return sb2.toString();
    }

    private String array2Json(Object[] objArr) throws JSONException {
        StringBuilder sb2 = new StringBuilder(objArr.length << 4);
        sb2.append('[');
        for (Object json : objArr) {
            sb2.append(toJson(json));
            sb2.append(AbstractJsonLexerKt.COMMA);
        }
        return addJsonArrayEnding(sb2);
    }

    private String baseTypeArray2Json(Object obj) {
        if (obj instanceof int[]) {
            return intArray2Json((int[]) obj);
        }
        if (obj instanceof boolean[]) {
            return booleanArray2Json((boolean[]) obj);
        }
        if (obj instanceof long[]) {
            return longArray2Json((long[]) obj);
        }
        if (obj instanceof float[]) {
            return floatArray2Json((float[]) obj);
        }
        if (obj instanceof double[]) {
            return doubleArray2Json((double[]) obj);
        }
        if (obj instanceof short[]) {
            return shortArray2Json((short[]) obj);
        }
        if (obj instanceof byte[]) {
            return byteArray2Json((byte[]) obj);
        }
        return null;
    }

    private String boolean2Json(Boolean bool) {
        return bool.toString();
    }

    private String booleanArray2Json(boolean[] zArr) {
        StringBuilder sb2 = new StringBuilder(zArr.length << 4);
        sb2.append('[');
        for (boolean append : zArr) {
            sb2.append(append);
            sb2.append(AbstractJsonLexerKt.COMMA);
        }
        return addJsonArrayEnding(sb2);
    }

    private String byteArray2Json(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder(bArr.length << 4);
        sb2.append('[');
        for (byte b11 : bArr) {
            sb2.append(Byte.toString(b11));
            sb2.append(AbstractJsonLexerKt.COMMA);
        }
        return addJsonArrayEnding(sb2);
    }

    private String collection2Json(Collection<Object> collection) throws JSONException {
        return toJson(collection.toArray(new Object[0]));
    }

    private String doubleArray2Json(double[] dArr) {
        StringBuilder sb2 = new StringBuilder(dArr.length << 4);
        sb2.append('[');
        for (double append : dArr) {
            sb2.append(append);
            sb2.append(AbstractJsonLexerKt.COMMA);
        }
        return addJsonArrayEnding(sb2);
    }

    private String floatArray2Json(float[] fArr) {
        StringBuilder sb2 = new StringBuilder(fArr.length << 4);
        sb2.append('[');
        for (float append : fArr) {
            sb2.append(append);
            sb2.append(AbstractJsonLexerKt.COMMA);
        }
        return addJsonArrayEnding(sb2);
    }

    private String getKey(Field field) {
        if (this.useAnnotation) {
            Class cls = com.huawei.agconnect.https.annotation.Field.class;
            if (!field.isAnnotationPresent(cls)) {
                return "";
            }
            String value = ((com.huawei.agconnect.https.annotation.Field) field.getAnnotation(cls)).value();
            if (!h.a(value)) {
                return value;
            }
        }
        return field.getName();
    }

    private String intArray2Json(int[] iArr) {
        StringBuilder sb2 = new StringBuilder(iArr.length << 4);
        sb2.append('[');
        for (int append : iArr) {
            sb2.append(append);
            sb2.append(AbstractJsonLexerKt.COMMA);
        }
        return addJsonArrayEnding(sb2);
    }

    private String longArray2Json(long[] jArr) {
        StringBuilder sb2 = new StringBuilder(jArr.length << 4);
        sb2.append('[');
        for (long append : jArr) {
            sb2.append(append);
            sb2.append(AbstractJsonLexerKt.COMMA);
        }
        return addJsonArrayEnding(sb2);
    }

    private String map2Json(Map<String, Object> map) throws JSONException {
        if (map.isEmpty()) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(map.size() << 4);
        sb2.append(AbstractJsonLexerKt.BEGIN_OBJ);
        for (Map.Entry next : map.entrySet()) {
            Object value = next.getValue();
            sb2.append('\"');
            sb2.append(next.getKey());
            sb2.append('\"');
            sb2.append(AbstractJsonLexerKt.COLON);
            sb2.append(toJson(value));
            sb2.append(AbstractJsonLexerKt.COMMA);
        }
        sb2.setCharAt(sb2.length() - 1, AbstractJsonLexerKt.END_OBJ);
        return sb2.toString();
    }

    private String number2Json(Number number) {
        return number.toString();
    }

    private String obj2Json(Object obj) throws JSONException {
        if (obj == null) {
            return "{}";
        }
        Class<?> cls = obj.getClass();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(AbstractJsonLexerKt.BEGIN_OBJ);
        do {
            for (Field field : cls.getDeclaredFields()) {
                if (field.getType() != cls) {
                    String key = getKey(field);
                    if (!h.a(key)) {
                        accessible(field);
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(toJson(key));
                        sb3.append(AbstractJsonLexerKt.COLON);
                        try {
                            Object obj2 = field.get(obj);
                            if (!this.expectObjectNull || obj2 != null) {
                                sb3.append(toJson(obj2));
                                sb3.append(AbstractJsonLexerKt.COMMA);
                                sb2.append(sb3);
                            }
                        } catch (IllegalAccessException unused) {
                            sb3.append("null");
                        }
                    }
                }
            }
            cls = cls.getSuperclass();
        } while (cls != Object.class);
        if (sb2.length() == 1) {
            return obj.toString();
        }
        sb2.setCharAt(sb2.length() - 1, AbstractJsonLexerKt.END_OBJ);
        return sb2.toString();
    }

    private String shortArray2Json(short[] sArr) {
        StringBuilder sb2 = new StringBuilder(sArr.length << 4);
        sb2.append('[');
        for (short append : sArr) {
            sb2.append(append);
            sb2.append(AbstractJsonLexerKt.COMMA);
        }
        return addJsonArrayEnding(sb2);
    }

    private String string2Json(String str) {
        String str2;
        StringBuilder sb2 = new StringBuilder(str.length() + 20);
        sb2.append('\"');
        for (int i11 = 0; i11 < str.length(); i11++) {
            char charAt = str.charAt(i11);
            if (charAt == 12) {
                str2 = "\\f";
            } else if (charAt == 13) {
                str2 = "\\r";
            } else if (charAt == '\"') {
                str2 = "\\\"";
            } else if (charAt == '/') {
                str2 = "\\/";
            } else if (charAt != '\\') {
                switch (charAt) {
                    case 8:
                        str2 = "\\b";
                        break;
                    case 9:
                        str2 = "\\t";
                        break;
                    case 10:
                        str2 = "\\n";
                        break;
                    default:
                        sb2.append(charAt);
                        continue;
                }
            } else {
                str2 = "\\\\";
            }
            sb2.append(str2);
        }
        sb2.append('\"');
        return sb2.toString();
    }

    public String toJson(Object obj) throws JSONException {
        if (obj == null) {
            return "null";
        }
        if (obj instanceof String) {
            return string2Json((String) obj);
        }
        if (obj instanceof Boolean) {
            return boolean2Json((Boolean) obj);
        }
        if (obj instanceof Number) {
            return number2Json((Number) obj);
        }
        if (obj instanceof Map) {
            return map2Json((Map) obj);
        }
        if (obj instanceof Collection) {
            return collection2Json((Collection) obj);
        }
        if (obj instanceof Object[]) {
            return array2Json((Object[]) obj);
        }
        String baseTypeArray2Json = baseTypeArray2Json(obj);
        return baseTypeArray2Json != null ? baseTypeArray2Json : obj2Json(obj);
    }
}
