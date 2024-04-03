package org.json;

import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

@Instrumented
public class JSONObject {
    public static final Object NULL = new Null();
    private final Map<String, Object> map;

    public static final class Null {
        private Null() {
        }

        public final Object clone() {
            return this;
        }

        public boolean equals(Object obj) {
            return obj == null || obj == this;
        }

        public int hashCode() {
            return 0;
        }

        public String toString() {
            return "null";
        }
    }

    public JSONObject() {
        this.map = new HashMap();
    }

    public static String doubleToString(double d11) {
        if (Double.isInfinite(d11) || Double.isNaN(d11)) {
            return "null";
        }
        String d12 = Double.toString(d11);
        if (d12.indexOf(46) <= 0 || d12.indexOf(101) >= 0 || d12.indexOf(69) >= 0) {
            return d12;
        }
        while (d12.endsWith("0")) {
            d12 = d12.substring(0, d12.length() - 1);
        }
        if (d12.endsWith(RealDiscoveryConfigurationRepository.VERSION_DELIMETER)) {
            return d12.substring(0, d12.length() - 1);
        }
        return d12;
    }

    private static <A extends Annotation> A getAnnotation(Method method, Class<A> cls) {
        if (!(method == null || cls == null)) {
            if (method.isAnnotationPresent(cls)) {
                return method.getAnnotation(cls);
            }
            Class<?> declaringClass = method.getDeclaringClass();
            if (declaringClass.getSuperclass() == null) {
                return null;
            }
            Class[] interfaces = declaringClass.getInterfaces();
            int length = interfaces.length;
            int i11 = 0;
            while (i11 < length) {
                try {
                    return getAnnotation(interfaces[i11].getMethod(method.getName(), method.getParameterTypes()), cls);
                } catch (NoSuchMethodException | SecurityException unused) {
                    i11++;
                }
            }
            try {
                return getAnnotation(declaringClass.getSuperclass().getMethod(method.getName(), method.getParameterTypes()), cls);
            } catch (NoSuchMethodException | SecurityException unused2) {
            }
        }
        return null;
    }

    private static int getAnnotationDepth(Method method, Class<? extends Annotation> cls) {
        if (!(method == null || cls == null)) {
            if (method.isAnnotationPresent(cls)) {
                return 1;
            }
            Class<?> declaringClass = method.getDeclaringClass();
            if (declaringClass.getSuperclass() == null) {
                return -1;
            }
            Class[] interfaces = declaringClass.getInterfaces();
            int length = interfaces.length;
            int i11 = 0;
            while (i11 < length) {
                try {
                    int annotationDepth = getAnnotationDepth(interfaces[i11].getMethod(method.getName(), method.getParameterTypes()), cls);
                    if (annotationDepth > 0) {
                        return annotationDepth + 1;
                    }
                    i11++;
                } catch (NoSuchMethodException | SecurityException unused) {
                }
            }
            try {
                int annotationDepth2 = getAnnotationDepth(declaringClass.getSuperclass().getMethod(method.getName(), method.getParameterTypes()), cls);
                if (annotationDepth2 > 0) {
                    return annotationDepth2 + 1;
                }
            } catch (NoSuchMethodException | SecurityException unused2) {
            }
        }
        return -1;
    }

    private String getKeyNameFromMethod(Method method) {
        String str;
        int annotationDepth;
        int annotationDepth2 = getAnnotationDepth(method, JSONPropertyIgnore.class);
        Class<JSONPropertyName> cls = JSONPropertyName.class;
        if (annotationDepth2 > 0 && ((annotationDepth = getAnnotationDepth(method, cls)) < 0 || annotationDepth2 <= annotationDepth)) {
            return null;
        }
        JSONPropertyName jSONPropertyName = (JSONPropertyName) getAnnotation(method, cls);
        if (jSONPropertyName != null && jSONPropertyName.value() != null && !jSONPropertyName.value().isEmpty()) {
            return jSONPropertyName.value();
        }
        String name2 = method.getName();
        if (name2.startsWith("get") && name2.length() > 3) {
            str = name2.substring(3);
        } else if (!name2.startsWith("is") || name2.length() <= 2) {
            return null;
        } else {
            str = name2.substring(2);
        }
        if (Character.isLowerCase(str.charAt(0))) {
            return null;
        }
        if (str.length() == 1) {
            return str.toLowerCase(Locale.ROOT);
        }
        if (Character.isUpperCase(str.charAt(1))) {
            return str;
        }
        return str.substring(0, 1).toLowerCase(Locale.ROOT) + str.substring(1);
    }

    public static String[] getNames(JSONObject jSONObject) {
        if (jSONObject.isEmpty()) {
            return null;
        }
        return (String[]) jSONObject.keySet().toArray(new String[jSONObject.length()]);
    }

    public static final void indent(Writer writer, int i11) throws IOException {
        for (int i12 = 0; i12 < i11; i12++) {
            writer.write(32);
        }
    }

    public static boolean isDecimalNotation(String str) {
        if (str.indexOf(46) > -1 || str.indexOf(101) > -1 || str.indexOf(69) > -1 || "-0".equals(str)) {
            return true;
        }
        return false;
    }

    private boolean isValidMethodName(String str) {
        if ("getClass".equals(str) || "getDeclaringClass".equals(str)) {
            return false;
        }
        return true;
    }

    public static String numberToString(Number number) throws JSONException {
        if (number != null) {
            testValidity(number);
            String obj = number.toString();
            if (obj.indexOf(46) <= 0 || obj.indexOf(101) >= 0 || obj.indexOf(69) >= 0) {
                return obj;
            }
            while (obj.endsWith("0")) {
                obj = obj.substring(0, obj.length() - 1);
            }
            if (obj.endsWith(RealDiscoveryConfigurationRepository.VERSION_DELIMETER)) {
                return obj.substring(0, obj.length() - 1);
            }
            return obj;
        }
        throw new JSONException("Null pointer");
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:33:? A[ExcHandler: IllegalAccessException | IllegalArgumentException | InvocationTargetException (unused java.lang.Throwable), SYNTHETIC, Splitter:B:30:0x006f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void populateMap(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Class r0 = r9.getClass()
            java.lang.ClassLoader r1 = r0.getClassLoader()
            r2 = 0
            if (r1 == 0) goto L_0x000d
            r1 = 1
            goto L_0x000e
        L_0x000d:
            r1 = r2
        L_0x000e:
            if (r1 == 0) goto L_0x0015
            java.lang.reflect.Method[] r0 = r0.getMethods()
            goto L_0x0019
        L_0x0015:
            java.lang.reflect.Method[] r0 = r0.getDeclaredMethods()
        L_0x0019:
            int r1 = r0.length
            r3 = r2
        L_0x001b:
            if (r3 >= r1) goto L_0x0077
            r4 = r0[r3]
            int r5 = r4.getModifiers()
            boolean r6 = java.lang.reflect.Modifier.isPublic(r5)
            if (r6 == 0) goto L_0x0074
            boolean r5 = java.lang.reflect.Modifier.isStatic(r5)
            if (r5 != 0) goto L_0x0074
            java.lang.Class[] r5 = r4.getParameterTypes()
            int r5 = r5.length
            if (r5 != 0) goto L_0x0074
            boolean r5 = r4.isBridge()
            if (r5 != 0) goto L_0x0074
            java.lang.Class r5 = r4.getReturnType()
            java.lang.Class r6 = java.lang.Void.TYPE
            if (r5 == r6) goto L_0x0074
            java.lang.String r5 = r4.getName()
            boolean r5 = r8.isValidMethodName(r5)
            if (r5 == 0) goto L_0x0074
            java.lang.String r5 = r8.getKeyNameFromMethod(r4)
            if (r5 == 0) goto L_0x0074
            boolean r6 = r5.isEmpty()
            if (r6 != 0) goto L_0x0074
            java.lang.Object[] r6 = new java.lang.Object[r2]     // Catch:{  }
            java.lang.Object r4 = r4.invoke(r9, r6)     // Catch:{  }
            if (r4 == 0) goto L_0x0074
            java.util.Map<java.lang.String, java.lang.Object> r6 = r8.map     // Catch:{  }
            java.lang.Object r7 = wrap(r4)     // Catch:{  }
            r6.put(r5, r7)     // Catch:{  }
            boolean r5 = r4 instanceof java.io.Closeable     // Catch:{  }
            if (r5 == 0) goto L_0x0074
            java.io.Closeable r4 = (java.io.Closeable) r4     // Catch:{ IllegalAccessException | IllegalArgumentException | InvocationTargetException -> 0x0074, IllegalAccessException | IllegalArgumentException | InvocationTargetException -> 0x0074, IllegalAccessException | IllegalArgumentException | InvocationTargetException -> 0x0074 }
            r4.close()     // Catch:{ IllegalAccessException | IllegalArgumentException | InvocationTargetException -> 0x0074, IllegalAccessException | IllegalArgumentException | InvocationTargetException -> 0x0074, IllegalAccessException | IllegalArgumentException | InvocationTargetException -> 0x0074 }
        L_0x0074:
            int r3 = r3 + 1
            goto L_0x001b
        L_0x0077:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.json.JSONObject.populateMap(java.lang.Object):void");
    }

    public static String quote(String str) {
        String obj;
        StringWriter stringWriter = new StringWriter();
        synchronized (stringWriter.getBuffer()) {
            try {
                obj = quote(str, stringWriter).toString();
            } catch (IOException unused) {
                return "";
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return obj;
    }

    public static Number stringToNumber(String str) throws NumberFormatException {
        char charAt = str.charAt(0);
        if ((charAt < '0' || charAt > '9') && charAt != '-') {
            throw new NumberFormatException("val [" + str + "] is not a valid number.");
        } else if (!isDecimalNotation(str)) {
            BigInteger bigInteger = new BigInteger(str);
            if (bigInteger.bitLength() <= 31) {
                return Integer.valueOf(bigInteger.intValue());
            }
            if (bigInteger.bitLength() <= 63) {
                return Long.valueOf(bigInteger.longValue());
            }
            return bigInteger;
        } else if (str.length() > 14) {
            return new BigDecimal(str);
        } else {
            Double valueOf = Double.valueOf(str);
            if (valueOf.isInfinite() || valueOf.isNaN()) {
                return new BigDecimal(str);
            }
            return valueOf;
        }
    }

    public static Object stringToValue(String str) {
        if (str.equals("")) {
            return str;
        }
        if (str.equalsIgnoreCase("true")) {
            return Boolean.TRUE;
        }
        if (str.equalsIgnoreCase("false")) {
            return Boolean.FALSE;
        }
        if (str.equalsIgnoreCase("null")) {
            return NULL;
        }
        char charAt = str.charAt(0);
        if ((charAt >= '0' && charAt <= '9') || charAt == '-') {
            try {
                if (isDecimalNotation(str)) {
                    Double valueOf = Double.valueOf(str);
                    if (valueOf.isInfinite() || valueOf.isNaN()) {
                        return str;
                    }
                    return valueOf;
                }
                Long valueOf2 = Long.valueOf(str);
                if (str.equals(valueOf2.toString())) {
                    if (valueOf2.longValue() == ((long) valueOf2.intValue())) {
                        return Integer.valueOf(valueOf2.intValue());
                    }
                    return valueOf2;
                }
            } catch (Exception unused) {
            }
        }
        return str;
    }

    public static void testValidity(Object obj) throws JSONException {
        if (obj == null) {
            return;
        }
        if (obj instanceof Double) {
            Double d11 = (Double) obj;
            if (d11.isInfinite() || d11.isNaN()) {
                throw new JSONException("JSON does not allow non-finite numbers.");
            }
        } else if (obj instanceof Float) {
            Float f11 = (Float) obj;
            if (f11.isInfinite() || f11.isNaN()) {
                throw new JSONException("JSON does not allow non-finite numbers.");
            }
        }
    }

    public static String valueToString(Object obj) throws JSONException {
        return JSONWriter.valueToString(obj);
    }

    public static Object wrap(Object obj) {
        String str;
        if (obj == null) {
            try {
                return NULL;
            } catch (Exception unused) {
                return null;
            }
        } else if ((obj instanceof JSONObject) || (obj instanceof JSONArray) || NULL.equals(obj) || (obj instanceof JSONString) || (obj instanceof Byte) || (obj instanceof Character) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Boolean) || (obj instanceof Float) || (obj instanceof Double) || (obj instanceof String) || (obj instanceof BigInteger) || (obj instanceof BigDecimal)) {
            return obj;
        } else {
            if (obj instanceof Enum) {
                return obj;
            }
            if (obj instanceof Collection) {
                return new JSONArray((Collection<?>) (Collection) obj);
            }
            if (obj.getClass().isArray()) {
                return new JSONArray(obj);
            }
            if (obj instanceof Map) {
                return new JSONObject((Map<?, ?>) (Map) obj);
            }
            Package packageR = obj.getClass().getPackage();
            if (packageR != null) {
                str = packageR.getName();
            } else {
                str = "";
            }
            if (!str.startsWith("java.") && !str.startsWith("javax.")) {
                if (obj.getClass().getClassLoader() != null) {
                    return new JSONObject(obj);
                }
            }
            return obj.toString();
        }
    }

    public static final Writer writeValue(Writer writer, Object obj, int i11, int i12) throws JSONException, IOException {
        String str;
        if (obj == null || obj.equals((Object) null)) {
            writer.write("null");
        } else if (obj instanceof JSONString) {
            try {
                String jSONString = ((JSONString) obj).toJSONString();
                if (jSONString != null) {
                    str = jSONString.toString();
                } else {
                    str = quote(obj.toString());
                }
                writer.write(str);
            } catch (Exception e11) {
                throw new JSONException((Throwable) e11);
            }
        } else if (obj instanceof Number) {
            String numberToString = numberToString((Number) obj);
            try {
                new BigDecimal(numberToString);
                writer.write(numberToString);
            } catch (NumberFormatException unused) {
                quote(numberToString, writer);
            }
        } else if (obj instanceof Boolean) {
            writer.write(obj.toString());
        } else if (obj instanceof Enum) {
            writer.write(quote(((Enum) obj).name()));
        } else if (obj instanceof JSONObject) {
            ((JSONObject) obj).write(writer, i11, i12);
        } else if (obj instanceof JSONArray) {
            ((JSONArray) obj).write(writer, i11, i12);
        } else if (obj instanceof Map) {
            new JSONObject((Map<?, ?>) (Map) obj).write(writer, i11, i12);
        } else if (obj instanceof Collection) {
            new JSONArray((Collection<?>) (Collection) obj).write(writer, i11, i12);
        } else if (obj.getClass().isArray()) {
            new JSONArray(obj).write(writer, i11, i12);
        } else {
            quote(obj.toString(), writer);
        }
        return writer;
    }

    public JSONObject accumulate(String str, Object obj) throws JSONException {
        testValidity(obj);
        Object opt = opt(str);
        if (opt == null) {
            if (obj instanceof JSONArray) {
                obj = new JSONArray().put(obj);
            }
            put(str, obj);
        } else if (opt instanceof JSONArray) {
            ((JSONArray) opt).put(obj);
        } else {
            put(str, (Object) new JSONArray().put(opt).put(obj));
        }
        return this;
    }

    public JSONObject append(String str, Object obj) throws JSONException {
        testValidity(obj);
        Object opt = opt(str);
        if (opt == null) {
            put(str, (Object) new JSONArray().put(obj));
        } else if (opt instanceof JSONArray) {
            put(str, (Object) ((JSONArray) opt).put(obj));
        } else {
            throw new JSONException("JSONObject[" + str + "] is not a JSONArray.");
        }
        return this;
    }

    public Set<Map.Entry<String, Object>> entrySet() {
        return this.map.entrySet();
    }

    public Object get(String str) throws JSONException {
        if (str != null) {
            Object opt = opt(str);
            if (opt != null) {
                return opt;
            }
            throw new JSONException("JSONObject[" + quote(str) + "] not found.");
        }
        throw new JSONException("Null key.");
    }

    public BigDecimal getBigDecimal(String str) throws JSONException {
        Object obj = get(str);
        if (obj instanceof BigDecimal) {
            return (BigDecimal) obj;
        }
        try {
            return new BigDecimal(obj.toString());
        } catch (Exception e11) {
            throw new JSONException("JSONObject[" + quote(str) + "] could not be converted to BigDecimal.", e11);
        }
    }

    public BigInteger getBigInteger(String str) throws JSONException {
        try {
            return new BigInteger(get(str).toString());
        } catch (Exception e11) {
            throw new JSONException("JSONObject[" + quote(str) + "] could not be converted to BigInteger.", e11);
        }
    }

    public boolean getBoolean(String str) throws JSONException {
        Object obj = get(str);
        if (obj.equals(Boolean.FALSE)) {
            return false;
        }
        boolean z11 = obj instanceof String;
        if (z11 && ((String) obj).equalsIgnoreCase("false")) {
            return false;
        }
        if (obj.equals(Boolean.TRUE)) {
            return true;
        }
        if (z11 && ((String) obj).equalsIgnoreCase("true")) {
            return true;
        }
        throw new JSONException("JSONObject[" + quote(str) + "] is not a Boolean.");
    }

    public double getDouble(String str) throws JSONException {
        Object obj = get(str);
        try {
            if (obj instanceof Number) {
                return ((Number) obj).doubleValue();
            }
            return Double.parseDouble(obj.toString());
        } catch (Exception e11) {
            throw new JSONException("JSONObject[" + quote(str) + "] is not a number.", e11);
        }
    }

    public <E extends Enum<E>> E getEnum(Class<E> cls, String str) throws JSONException {
        E optEnum = optEnum(cls, str);
        if (optEnum != null) {
            return optEnum;
        }
        throw new JSONException("JSONObject[" + quote(str) + "] is not an enum of type " + quote(cls.getSimpleName()) + RealDiscoveryConfigurationRepository.VERSION_DELIMETER);
    }

    public float getFloat(String str) throws JSONException {
        Object obj = get(str);
        try {
            if (obj instanceof Number) {
                return ((Number) obj).floatValue();
            }
            return Float.parseFloat(obj.toString());
        } catch (Exception e11) {
            throw new JSONException("JSONObject[" + quote(str) + "] is not a number.", e11);
        }
    }

    public int getInt(String str) throws JSONException {
        Object obj = get(str);
        try {
            if (obj instanceof Number) {
                return ((Number) obj).intValue();
            }
            return Integer.parseInt((String) obj);
        } catch (Exception e11) {
            throw new JSONException("JSONObject[" + quote(str) + "] is not an int.", e11);
        }
    }

    public JSONArray getJSONArray(String str) throws JSONException {
        Object obj = get(str);
        if (obj instanceof JSONArray) {
            return (JSONArray) obj;
        }
        throw new JSONException("JSONObject[" + quote(str) + "] is not a JSONArray.");
    }

    public JSONObject getJSONObject(String str) throws JSONException {
        Object obj = get(str);
        if (obj instanceof JSONObject) {
            return (JSONObject) obj;
        }
        throw new JSONException("JSONObject[" + quote(str) + "] is not a JSONObject.");
    }

    public long getLong(String str) throws JSONException {
        Object obj = get(str);
        try {
            if (obj instanceof Number) {
                return ((Number) obj).longValue();
            }
            return Long.parseLong((String) obj);
        } catch (Exception e11) {
            throw new JSONException("JSONObject[" + quote(str) + "] is not a long.", e11);
        }
    }

    public Number getNumber(String str) throws JSONException {
        Object obj = get(str);
        try {
            if (obj instanceof Number) {
                return (Number) obj;
            }
            return stringToNumber(obj.toString());
        } catch (Exception e11) {
            throw new JSONException("JSONObject[" + quote(str) + "] is not a number.", e11);
        }
    }

    public String getString(String str) throws JSONException {
        Object obj = get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        throw new JSONException("JSONObject[" + quote(str) + "] not a string.");
    }

    public boolean has(String str) {
        return this.map.containsKey(str);
    }

    public JSONObject increment(String str) throws JSONException {
        Object opt = opt(str);
        if (opt == null) {
            put(str, 1);
        } else if (opt instanceof BigInteger) {
            put(str, (Object) ((BigInteger) opt).add(BigInteger.ONE));
        } else if (opt instanceof BigDecimal) {
            put(str, (Object) ((BigDecimal) opt).add(BigDecimal.ONE));
        } else if (opt instanceof Integer) {
            put(str, ((Integer) opt).intValue() + 1);
        } else if (opt instanceof Long) {
            put(str, ((Long) opt).longValue() + 1);
        } else if (opt instanceof Double) {
            put(str, ((Double) opt).doubleValue() + 1.0d);
        } else if (opt instanceof Float) {
            put(str, ((Float) opt).floatValue() + 1.0f);
        } else {
            throw new JSONException("Unable to increment [" + quote(str) + "].");
        }
        return this;
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    public boolean isNull(String str) {
        return NULL.equals(opt(str));
    }

    public Set<String> keySet() {
        return this.map.keySet();
    }

    public Iterator<String> keys() {
        return keySet().iterator();
    }

    public int length() {
        return this.map.size();
    }

    public JSONArray names() {
        if (this.map.isEmpty()) {
            return null;
        }
        return new JSONArray((Collection<?>) this.map.keySet());
    }

    public Object opt(String str) {
        if (str == null) {
            return null;
        }
        return this.map.get(str);
    }

    public BigDecimal optBigDecimal(String str, BigDecimal bigDecimal) {
        Object opt = opt(str);
        if (NULL.equals(opt)) {
            return bigDecimal;
        }
        if (opt instanceof BigDecimal) {
            return (BigDecimal) opt;
        }
        if (opt instanceof BigInteger) {
            return new BigDecimal((BigInteger) opt);
        }
        if ((opt instanceof Double) || (opt instanceof Float)) {
            return new BigDecimal(((Number) opt).doubleValue());
        }
        if ((opt instanceof Long) || (opt instanceof Integer) || (opt instanceof Short) || (opt instanceof Byte)) {
            return new BigDecimal(((Number) opt).longValue());
        }
        try {
            return new BigDecimal(opt.toString());
        } catch (Exception unused) {
            return bigDecimal;
        }
    }

    public BigInteger optBigInteger(String str, BigInteger bigInteger) {
        Object opt = opt(str);
        if (NULL.equals(opt)) {
            return bigInteger;
        }
        if (opt instanceof BigInteger) {
            return (BigInteger) opt;
        }
        if (opt instanceof BigDecimal) {
            return ((BigDecimal) opt).toBigInteger();
        }
        if ((opt instanceof Double) || (opt instanceof Float)) {
            return new BigDecimal(((Number) opt).doubleValue()).toBigInteger();
        }
        if ((opt instanceof Long) || (opt instanceof Integer) || (opt instanceof Short) || (opt instanceof Byte)) {
            return BigInteger.valueOf(((Number) opt).longValue());
        }
        try {
            String obj = opt.toString();
            if (isDecimalNotation(obj)) {
                return new BigDecimal(obj).toBigInteger();
            }
            return new BigInteger(obj);
        } catch (Exception unused) {
            return bigInteger;
        }
    }

    public boolean optBoolean(String str) {
        return optBoolean(str, false);
    }

    public double optDouble(String str) {
        return optDouble(str, Double.NaN);
    }

    public <E extends Enum<E>> E optEnum(Class<E> cls, String str) {
        return optEnum(cls, str, (Enum) null);
    }

    public float optFloat(String str) {
        return optFloat(str, Float.NaN);
    }

    public int optInt(String str) {
        return optInt(str, 0);
    }

    public JSONArray optJSONArray(String str) {
        Object opt = opt(str);
        if (opt instanceof JSONArray) {
            return (JSONArray) opt;
        }
        return null;
    }

    public JSONObject optJSONObject(String str) {
        Object opt = opt(str);
        if (opt instanceof JSONObject) {
            return (JSONObject) opt;
        }
        return null;
    }

    public long optLong(String str) {
        return optLong(str, 0);
    }

    public Number optNumber(String str) {
        return optNumber(str, (Number) null);
    }

    public Object optQuery(String str) {
        return optQuery(new JSONPointer(str));
    }

    public String optString(String str) {
        return optString(str, "");
    }

    public JSONObject put(String str, boolean z11) throws JSONException {
        return put(str, (Object) z11 ? Boolean.TRUE : Boolean.FALSE);
    }

    public JSONObject putOnce(String str, Object obj) throws JSONException {
        if (str == null || obj == null) {
            return this;
        }
        if (opt(str) == null) {
            return put(str, obj);
        }
        throw new JSONException("Duplicate key \"" + str + "\"");
    }

    public JSONObject putOpt(String str, Object obj) throws JSONException {
        return (str == null || obj == null) ? this : put(str, obj);
    }

    public Object query(String str) {
        return query(new JSONPointer(str));
    }

    public Object remove(String str) {
        return this.map.remove(str);
    }

    public boolean similar(Object obj) {
        try {
            if (!(obj instanceof JSONObject) || !keySet().equals(((JSONObject) obj).keySet())) {
                return false;
            }
            for (Map.Entry next : entrySet()) {
                Object value = next.getValue();
                Object obj2 = ((JSONObject) obj).get((String) next.getKey());
                if (value != obj2) {
                    if (value == null) {
                        return false;
                    }
                    if (value instanceof JSONObject) {
                        if (!((JSONObject) value).similar(obj2)) {
                            return false;
                        }
                    } else if (value instanceof JSONArray) {
                        if (!((JSONArray) value).similar(obj2)) {
                            return false;
                        }
                    } else if (!value.equals(obj2)) {
                        return false;
                    }
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public JSONArray toJSONArray(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null || jSONArray.isEmpty()) {
            return null;
        }
        JSONArray jSONArray2 = new JSONArray();
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            jSONArray2.put(opt(jSONArray.getString(i11)));
        }
        return jSONArray2;
    }

    public Map<String, Object> toMap() {
        Object obj;
        HashMap hashMap = new HashMap();
        for (Map.Entry next : entrySet()) {
            if (next.getValue() == null || NULL.equals(next.getValue())) {
                obj = null;
            } else if (next.getValue() instanceof JSONObject) {
                obj = ((JSONObject) next.getValue()).toMap();
            } else if (next.getValue() instanceof JSONArray) {
                obj = ((JSONArray) next.getValue()).toList();
            } else {
                obj = next.getValue();
            }
            hashMap.put(next.getKey(), obj);
        }
        return hashMap;
    }

    public String toString() {
        try {
            return JSONObjectInstrumentation.toString(this, 0);
        } catch (Exception unused) {
            return null;
        }
    }

    public Writer write(Writer writer) throws JSONException {
        return write(writer, 0, 0);
    }

    public boolean optBoolean(String str, boolean z11) {
        Object opt = opt(str);
        if (NULL.equals(opt)) {
            return z11;
        }
        if (opt instanceof Boolean) {
            return ((Boolean) opt).booleanValue();
        }
        try {
            return getBoolean(str);
        } catch (Exception unused) {
            return z11;
        }
    }

    public double optDouble(String str, double d11) {
        Object opt = opt(str);
        if (NULL.equals(opt)) {
            return d11;
        }
        if (opt instanceof Number) {
            return ((Number) opt).doubleValue();
        }
        if (opt instanceof String) {
            try {
                return Double.parseDouble((String) opt);
            } catch (Exception unused) {
            }
        }
        return d11;
    }

    public <E extends Enum<E>> E optEnum(Class<E> cls, String str, E e11) {
        try {
            E opt = opt(str);
            if (NULL.equals(opt)) {
                return e11;
            }
            if (cls.isAssignableFrom(opt.getClass())) {
                return (Enum) opt;
            }
            return Enum.valueOf(cls, opt.toString());
        } catch (IllegalArgumentException | NullPointerException unused) {
            return e11;
        }
    }

    public float optFloat(String str, float f11) {
        Object opt = opt(str);
        if (NULL.equals(opt)) {
            return f11;
        }
        if (opt instanceof Number) {
            return ((Number) opt).floatValue();
        }
        if (opt instanceof String) {
            try {
                return Float.parseFloat((String) opt);
            } catch (Exception unused) {
            }
        }
        return f11;
    }

    public int optInt(String str, int i11) {
        Object opt = opt(str);
        if (NULL.equals(opt)) {
            return i11;
        }
        if (opt instanceof Number) {
            return ((Number) opt).intValue();
        }
        if (opt instanceof String) {
            try {
                return new BigDecimal((String) opt).intValue();
            } catch (Exception unused) {
            }
        }
        return i11;
    }

    public long optLong(String str, long j11) {
        Object opt = opt(str);
        if (NULL.equals(opt)) {
            return j11;
        }
        if (opt instanceof Number) {
            return ((Number) opt).longValue();
        }
        if (opt instanceof String) {
            try {
                return new BigDecimal((String) opt).longValue();
            } catch (Exception unused) {
            }
        }
        return j11;
    }

    public Number optNumber(String str, Number number) {
        Object opt = opt(str);
        if (NULL.equals(opt)) {
            return number;
        }
        if (opt instanceof Number) {
            return (Number) opt;
        }
        if (opt instanceof String) {
            try {
                return stringToNumber((String) opt);
            } catch (Exception unused) {
            }
        }
        return number;
    }

    public Object optQuery(JSONPointer jSONPointer) {
        try {
            return jSONPointer.queryFrom(this);
        } catch (JSONPointerException unused) {
            return null;
        }
    }

    public String optString(String str, String str2) {
        Object opt = opt(str);
        return NULL.equals(opt) ? str2 : opt.toString();
    }

    public JSONObject put(String str, Collection<?> collection) throws JSONException {
        return put(str, (Object) new JSONArray(collection));
    }

    public Object query(JSONPointer jSONPointer) {
        return jSONPointer.queryFrom(this);
    }

    public String toString(int i11) throws JSONException {
        String obj;
        StringWriter stringWriter = new StringWriter();
        synchronized (stringWriter.getBuffer()) {
            obj = write(stringWriter, i11, 0).toString();
        }
        return obj;
    }

    public Writer write(Writer writer, int i11, int i12) throws JSONException {
        String str;
        String str2;
        try {
            int length = length();
            writer.write(123);
            if (length == 1) {
                Map.Entry next = entrySet().iterator().next();
                str2 = (String) next.getKey();
                writer.write(quote(str2));
                writer.write(58);
                if (i11 > 0) {
                    writer.write(32);
                }
                writeValue(writer, next.getValue(), i11, i12);
            } else if (length != 0) {
                int i13 = i12 + i11;
                boolean z11 = false;
                for (Map.Entry next2 : entrySet()) {
                    if (z11) {
                        writer.write(44);
                    }
                    if (i11 > 0) {
                        writer.write(10);
                    }
                    indent(writer, i13);
                    str = (String) next2.getKey();
                    writer.write(quote(str));
                    writer.write(58);
                    if (i11 > 0) {
                        writer.write(32);
                    }
                    writeValue(writer, next2.getValue(), i11, i13);
                    z11 = true;
                }
                if (i11 > 0) {
                    writer.write(10);
                }
                indent(writer, i12);
            }
            writer.write(125);
            return writer;
        } catch (Exception e11) {
            throw new JSONException("Unable to write JSONObject value for key: " + str, e11);
        } catch (Exception e12) {
            throw new JSONException("Unable to write JSONObject value for key: " + str2, e12);
        } catch (IOException e13) {
            throw new JSONException((Throwable) e13);
        }
    }

    public JSONObject(JSONObject jSONObject, String[] strArr) {
        this(strArr.length);
        for (int i11 = 0; i11 < strArr.length; i11++) {
            try {
                String str = strArr[i11];
                putOnce(str, jSONObject.opt(str));
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0004, code lost:
        r4 = r4.getClass().getFields();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String[] getNames(java.lang.Object r4) {
        /*
            r0 = 0
            if (r4 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.lang.Class r4 = r4.getClass()
            java.lang.reflect.Field[] r4 = r4.getFields()
            int r1 = r4.length
            if (r1 != 0) goto L_0x0010
            return r0
        L_0x0010:
            java.lang.String[] r0 = new java.lang.String[r1]
            r2 = 0
        L_0x0013:
            if (r2 >= r1) goto L_0x0020
            r3 = r4[r2]
            java.lang.String r3 = r3.getName()
            r0[r2] = r3
            int r2 = r2 + 1
            goto L_0x0013
        L_0x0020:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.json.JSONObject.getNames(java.lang.Object):java.lang.String[]");
    }

    public JSONObject put(String str, double d11) throws JSONException {
        return put(str, (Object) Double.valueOf(d11));
    }

    public JSONObject put(String str, float f11) throws JSONException {
        return put(str, (Object) Float.valueOf(f11));
    }

    public JSONObject put(String str, int i11) throws JSONException {
        return put(str, (Object) Integer.valueOf(i11));
    }

    public JSONObject(JSONTokener jSONTokener) throws JSONException {
        this();
        if (jSONTokener.nextClean() == '{') {
            while (true) {
                char nextClean = jSONTokener.nextClean();
                if (nextClean == 0) {
                    throw jSONTokener.syntaxError("A JSONObject text must end with '}'");
                } else if (nextClean != '}') {
                    jSONTokener.back();
                    String obj = jSONTokener.nextValue().toString();
                    if (jSONTokener.nextClean() == ':') {
                        if (obj != null) {
                            if (opt(obj) == null) {
                                Object nextValue = jSONTokener.nextValue();
                                if (nextValue != null) {
                                    put(obj, nextValue);
                                }
                            } else {
                                throw jSONTokener.syntaxError("Duplicate key \"" + obj + "\"");
                            }
                        }
                        char nextClean2 = jSONTokener.nextClean();
                        if (nextClean2 == ',' || nextClean2 == ';') {
                            if (jSONTokener.nextClean() != '}') {
                                jSONTokener.back();
                            } else {
                                return;
                            }
                        } else if (nextClean2 != '}') {
                            throw jSONTokener.syntaxError("Expected a ',' or '}'");
                        } else {
                            return;
                        }
                    } else {
                        throw jSONTokener.syntaxError("Expected a ':' after a key");
                    }
                } else {
                    return;
                }
            }
        } else {
            throw jSONTokener.syntaxError("A JSONObject text must begin with '{'");
        }
    }

    public static Writer quote(String str, Writer writer) throws IOException {
        if (str == null || str.isEmpty()) {
            writer.write("\"\"");
            return writer;
        }
        int length = str.length();
        writer.write(34);
        int i11 = 0;
        char c11 = 0;
        while (i11 < length) {
            char charAt = str.charAt(i11);
            if (charAt == 12) {
                writer.write("\\f");
            } else if (charAt != 13) {
                if (charAt != '\"') {
                    if (charAt != '/') {
                        if (charAt != '\\') {
                            switch (charAt) {
                                case 8:
                                    writer.write("\\b");
                                    break;
                                case 9:
                                    writer.write("\\t");
                                    break;
                                case 10:
                                    writer.write("\\n");
                                    break;
                                default:
                                    if (charAt >= ' ' && ((charAt < 128 || charAt >= 160) && (charAt < 8192 || charAt >= 8448))) {
                                        writer.write(charAt);
                                        break;
                                    } else {
                                        writer.write("\\u");
                                        String hexString = Integer.toHexString(charAt);
                                        writer.write("0000", 0, 4 - hexString.length());
                                        writer.write(hexString);
                                        break;
                                    }
                            }
                        }
                    } else {
                        if (c11 == '<') {
                            writer.write(92);
                        }
                        writer.write(charAt);
                    }
                }
                writer.write(92);
                writer.write(charAt);
            } else {
                writer.write("\\r");
            }
            i11++;
            c11 = charAt;
        }
        writer.write(34);
        return writer;
    }

    public JSONObject put(String str, long j11) throws JSONException {
        return put(str, (Object) Long.valueOf(j11));
    }

    public JSONObject put(String str, Map<?, ?> map2) throws JSONException {
        return put(str, (Object) new JSONObject(map2));
    }

    public JSONObject put(String str, Object obj) throws JSONException {
        if (str != null) {
            if (obj != null) {
                testValidity(obj);
                this.map.put(str, obj);
            } else {
                remove(str);
            }
            return this;
        }
        throw new NullPointerException("Null key.");
    }

    public JSONObject(Map<?, ?> map2) {
        if (map2 == null) {
            this.map = new HashMap();
            return;
        }
        this.map = new HashMap(map2.size());
        for (Map.Entry next : map2.entrySet()) {
            if (next.getKey() != null) {
                Object value = next.getValue();
                if (value != null) {
                    this.map.put(String.valueOf(next.getKey()), wrap(value));
                }
            } else {
                throw new NullPointerException("Null key.");
            }
        }
    }

    public JSONObject(Object obj) {
        this();
        populateMap(obj);
    }

    public JSONObject(Object obj, String[] strArr) {
        this(strArr.length);
        Class<?> cls = obj.getClass();
        for (String str : strArr) {
            try {
                putOpt(str, cls.getField(str).get(obj));
            } catch (Exception unused) {
            }
        }
    }

    public JSONObject(String str) throws JSONException {
        this(new JSONTokener(str));
    }

    public JSONObject(String str, Locale locale) throws JSONException {
        this();
        ResourceBundle bundle = ResourceBundle.getBundle(str, locale, Thread.currentThread().getContextClassLoader());
        Enumeration<String> keys = bundle.getKeys();
        while (keys.hasMoreElements()) {
            String nextElement = keys.nextElement();
            if (nextElement != null) {
                String str2 = nextElement;
                String[] split = str2.split("\\.");
                int length = split.length - 1;
                JSONObject jSONObject = this;
                for (int i11 = 0; i11 < length; i11++) {
                    String str3 = split[i11];
                    JSONObject optJSONObject = jSONObject.optJSONObject(str3);
                    if (optJSONObject == null) {
                        optJSONObject = new JSONObject();
                        jSONObject.put(str3, (Object) optJSONObject);
                    }
                    jSONObject = optJSONObject;
                }
                jSONObject.put(split[length], (Object) bundle.getString(str2));
            }
        }
    }

    public JSONObject(int i11) {
        this.map = new HashMap(i11);
    }
}
