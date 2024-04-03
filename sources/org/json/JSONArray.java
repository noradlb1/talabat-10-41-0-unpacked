package org.json;

import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Instrumented
public class JSONArray implements Iterable<Object> {
    private final ArrayList<Object> myArrayList;

    public JSONArray() {
        this.myArrayList = new ArrayList<>();
    }

    public Object get(int i11) throws JSONException {
        Object opt = opt(i11);
        if (opt != null) {
            return opt;
        }
        throw new JSONException("JSONArray[" + i11 + "] not found.");
    }

    public BigDecimal getBigDecimal(int i11) throws JSONException {
        try {
            return new BigDecimal(get(i11).toString());
        } catch (Exception e11) {
            throw new JSONException("JSONArray[" + i11 + "] could not convert to BigDecimal.", e11);
        }
    }

    public BigInteger getBigInteger(int i11) throws JSONException {
        try {
            return new BigInteger(get(i11).toString());
        } catch (Exception e11) {
            throw new JSONException("JSONArray[" + i11 + "] could not convert to BigInteger.", e11);
        }
    }

    public boolean getBoolean(int i11) throws JSONException {
        Object obj = get(i11);
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
        throw new JSONException("JSONArray[" + i11 + "] is not a boolean.");
    }

    public double getDouble(int i11) throws JSONException {
        Object obj = get(i11);
        try {
            if (obj instanceof Number) {
                return ((Number) obj).doubleValue();
            }
            return Double.parseDouble((String) obj);
        } catch (Exception e11) {
            throw new JSONException("JSONArray[" + i11 + "] is not a number.", e11);
        }
    }

    public <E extends Enum<E>> E getEnum(Class<E> cls, int i11) throws JSONException {
        E optEnum = optEnum(cls, i11);
        if (optEnum != null) {
            return optEnum;
        }
        throw new JSONException("JSONArray[" + i11 + "] is not an enum of type " + JSONObject.quote(cls.getSimpleName()) + RealDiscoveryConfigurationRepository.VERSION_DELIMETER);
    }

    public float getFloat(int i11) throws JSONException {
        Object obj = get(i11);
        try {
            if (obj instanceof Number) {
                return ((Number) obj).floatValue();
            }
            return Float.parseFloat(obj.toString());
        } catch (Exception e11) {
            throw new JSONException("JSONArray[" + i11 + "] is not a number.", e11);
        }
    }

    public int getInt(int i11) throws JSONException {
        Object obj = get(i11);
        try {
            if (obj instanceof Number) {
                return ((Number) obj).intValue();
            }
            return Integer.parseInt((String) obj);
        } catch (Exception e11) {
            throw new JSONException("JSONArray[" + i11 + "] is not a number.", e11);
        }
    }

    public JSONArray getJSONArray(int i11) throws JSONException {
        Object obj = get(i11);
        if (obj instanceof JSONArray) {
            return (JSONArray) obj;
        }
        throw new JSONException("JSONArray[" + i11 + "] is not a JSONArray.");
    }

    public JSONObject getJSONObject(int i11) throws JSONException {
        Object obj = get(i11);
        if (obj instanceof JSONObject) {
            return (JSONObject) obj;
        }
        throw new JSONException("JSONArray[" + i11 + "] is not a JSONObject.");
    }

    public long getLong(int i11) throws JSONException {
        Object obj = get(i11);
        try {
            if (obj instanceof Number) {
                return ((Number) obj).longValue();
            }
            return Long.parseLong((String) obj);
        } catch (Exception e11) {
            throw new JSONException("JSONArray[" + i11 + "] is not a number.", e11);
        }
    }

    public Number getNumber(int i11) throws JSONException {
        Object obj = get(i11);
        try {
            if (obj instanceof Number) {
                return (Number) obj;
            }
            return JSONObject.stringToNumber(obj.toString());
        } catch (Exception e11) {
            throw new JSONException("JSONArray[" + i11 + "] is not a number.", e11);
        }
    }

    public String getString(int i11) throws JSONException {
        Object obj = get(i11);
        if (obj instanceof String) {
            return (String) obj;
        }
        throw new JSONException("JSONArray[" + i11 + "] not a string.");
    }

    public boolean isEmpty() {
        return this.myArrayList.isEmpty();
    }

    public boolean isNull(int i11) {
        return JSONObject.NULL.equals(opt(i11));
    }

    public Iterator<Object> iterator() {
        return this.myArrayList.iterator();
    }

    public String join(String str) throws JSONException {
        int length = length();
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 0; i11 < length; i11++) {
            if (i11 > 0) {
                sb2.append(str);
            }
            sb2.append(JSONObject.valueToString(this.myArrayList.get(i11)));
        }
        return sb2.toString();
    }

    public int length() {
        return this.myArrayList.size();
    }

    public Object opt(int i11) {
        if (i11 < 0 || i11 >= length()) {
            return null;
        }
        return this.myArrayList.get(i11);
    }

    public BigDecimal optBigDecimal(int i11, BigDecimal bigDecimal) {
        Object opt = opt(i11);
        if (JSONObject.NULL.equals(opt)) {
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

    public BigInteger optBigInteger(int i11, BigInteger bigInteger) {
        Object opt = opt(i11);
        if (JSONObject.NULL.equals(opt)) {
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
            if (JSONObject.isDecimalNotation(obj)) {
                return new BigDecimal(obj).toBigInteger();
            }
            return new BigInteger(obj);
        } catch (Exception unused) {
            return bigInteger;
        }
    }

    public boolean optBoolean(int i11) {
        return optBoolean(i11, false);
    }

    public double optDouble(int i11) {
        return optDouble(i11, Double.NaN);
    }

    public <E extends Enum<E>> E optEnum(Class<E> cls, int i11) {
        return optEnum(cls, i11, (Enum) null);
    }

    public float optFloat(int i11) {
        return optFloat(i11, Float.NaN);
    }

    public int optInt(int i11) {
        return optInt(i11, 0);
    }

    public JSONArray optJSONArray(int i11) {
        Object opt = opt(i11);
        if (opt instanceof JSONArray) {
            return (JSONArray) opt;
        }
        return null;
    }

    public JSONObject optJSONObject(int i11) {
        Object opt = opt(i11);
        if (opt instanceof JSONObject) {
            return (JSONObject) opt;
        }
        return null;
    }

    public long optLong(int i11) {
        return optLong(i11, 0);
    }

    public Number optNumber(int i11) {
        return optNumber(i11, (Number) null);
    }

    public Object optQuery(String str) {
        return optQuery(new JSONPointer(str));
    }

    public String optString(int i11) {
        return optString(i11, "");
    }

    public JSONArray put(boolean z11) {
        return put((Object) z11 ? Boolean.TRUE : Boolean.FALSE);
    }

    public Object query(String str) {
        return query(new JSONPointer(str));
    }

    public Object remove(int i11) {
        if (i11 < 0 || i11 >= length()) {
            return null;
        }
        return this.myArrayList.remove(i11);
    }

    public boolean similar(Object obj) {
        if (!(obj instanceof JSONArray)) {
            return false;
        }
        int length = length();
        JSONArray jSONArray = (JSONArray) obj;
        if (length != jSONArray.length()) {
            return false;
        }
        for (int i11 = 0; i11 < length; i11++) {
            Object obj2 = this.myArrayList.get(i11);
            Object obj3 = jSONArray.myArrayList.get(i11);
            if (obj2 != obj3) {
                if (obj2 == null) {
                    return false;
                }
                if (obj2 instanceof JSONObject) {
                    if (!((JSONObject) obj2).similar(obj3)) {
                        return false;
                    }
                } else if (obj2 instanceof JSONArray) {
                    if (!((JSONArray) obj2).similar(obj3)) {
                        return false;
                    }
                } else if (!obj2.equals(obj3)) {
                    return false;
                }
            }
        }
        return true;
    }

    public JSONObject toJSONObject(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null || jSONArray.isEmpty() || isEmpty()) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(jSONArray.length());
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            jSONObject.put(jSONArray.getString(i11), opt(i11));
        }
        return jSONObject;
    }

    public List<Object> toList() {
        ArrayList arrayList = new ArrayList(this.myArrayList.size());
        Iterator<Object> it = this.myArrayList.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next == null || JSONObject.NULL.equals(next)) {
                arrayList.add((Object) null);
            } else if (next instanceof JSONArray) {
                arrayList.add(((JSONArray) next).toList());
            } else if (next instanceof JSONObject) {
                arrayList.add(((JSONObject) next).toMap());
            } else {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public String toString() {
        try {
            return JSONArrayInstrumentation.toString(this, 0);
        } catch (Exception unused) {
            return null;
        }
    }

    public Writer write(Writer writer) throws JSONException {
        return write(writer, 0, 0);
    }

    public boolean optBoolean(int i11, boolean z11) {
        try {
            return getBoolean(i11);
        } catch (Exception unused) {
            return z11;
        }
    }

    public double optDouble(int i11, double d11) {
        Object opt = opt(i11);
        if (JSONObject.NULL.equals(opt)) {
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

    public <E extends Enum<E>> E optEnum(Class<E> cls, int i11, E e11) {
        try {
            E opt = opt(i11);
            if (JSONObject.NULL.equals(opt)) {
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

    public float optFloat(int i11, float f11) {
        Object opt = opt(i11);
        if (JSONObject.NULL.equals(opt)) {
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

    public int optInt(int i11, int i12) {
        Object opt = opt(i11);
        if (JSONObject.NULL.equals(opt)) {
            return i12;
        }
        if (opt instanceof Number) {
            return ((Number) opt).intValue();
        }
        if (opt instanceof String) {
            try {
                return new BigDecimal(opt.toString()).intValue();
            } catch (Exception unused) {
            }
        }
        return i12;
    }

    public long optLong(int i11, long j11) {
        Object opt = opt(i11);
        if (JSONObject.NULL.equals(opt)) {
            return j11;
        }
        if (opt instanceof Number) {
            return ((Number) opt).longValue();
        }
        if (opt instanceof String) {
            try {
                return new BigDecimal(opt.toString()).longValue();
            } catch (Exception unused) {
            }
        }
        return j11;
    }

    public Number optNumber(int i11, Number number) {
        Object opt = opt(i11);
        if (JSONObject.NULL.equals(opt)) {
            return number;
        }
        if (opt instanceof Number) {
            return (Number) opt;
        }
        if (opt instanceof String) {
            try {
                return JSONObject.stringToNumber((String) opt);
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

    public String optString(int i11, String str) {
        Object opt = opt(i11);
        return JSONObject.NULL.equals(opt) ? str : opt.toString();
    }

    public JSONArray put(Collection<?> collection) {
        return put((Object) new JSONArray(collection));
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
        int i13;
        try {
            int length = length();
            writer.write(91);
            i13 = 0;
            if (length == 1) {
                JSONObject.writeValue(writer, this.myArrayList.get(0), i11, i12);
            } else if (length != 0) {
                int i14 = i12 + i11;
                boolean z11 = false;
                while (i13 < length) {
                    if (z11) {
                        writer.write(44);
                    }
                    if (i11 > 0) {
                        writer.write(10);
                    }
                    JSONObject.indent(writer, i14);
                    JSONObject.writeValue(writer, this.myArrayList.get(i13), i11, i14);
                    i13++;
                    z11 = true;
                }
                if (i11 > 0) {
                    writer.write(10);
                }
                JSONObject.indent(writer, i12);
            }
            writer.write(93);
            return writer;
        } catch (Exception e11) {
            throw new JSONException("Unable to write JSONArray value at index: " + i13, e11);
        } catch (Exception e12) {
            throw new JSONException("Unable to write JSONArray value at index: 0", e12);
        } catch (IOException e13) {
            throw new JSONException((Throwable) e13);
        }
    }

    public JSONArray(JSONTokener jSONTokener) throws JSONException {
        this();
        if (jSONTokener.nextClean() == '[') {
            char nextClean = jSONTokener.nextClean();
            if (nextClean == 0) {
                throw jSONTokener.syntaxError("Expected a ',' or ']'");
            } else if (nextClean != ']') {
                jSONTokener.back();
                while (true) {
                    if (jSONTokener.nextClean() == ',') {
                        jSONTokener.back();
                        this.myArrayList.add(JSONObject.NULL);
                    } else {
                        jSONTokener.back();
                        this.myArrayList.add(jSONTokener.nextValue());
                    }
                    char nextClean2 = jSONTokener.nextClean();
                    if (nextClean2 == 0) {
                        throw jSONTokener.syntaxError("Expected a ',' or ']'");
                    } else if (nextClean2 == ',') {
                        char nextClean3 = jSONTokener.nextClean();
                        if (nextClean3 == 0) {
                            throw jSONTokener.syntaxError("Expected a ',' or ']'");
                        } else if (nextClean3 != ']') {
                            jSONTokener.back();
                        } else {
                            return;
                        }
                    } else if (nextClean2 != ']') {
                        throw jSONTokener.syntaxError("Expected a ',' or ']'");
                    } else {
                        return;
                    }
                }
            }
        } else {
            throw jSONTokener.syntaxError("A JSONArray text must start with '['");
        }
    }

    public JSONArray put(double d11) throws JSONException {
        return put((Object) Double.valueOf(d11));
    }

    public JSONArray put(float f11) throws JSONException {
        return put((Object) Float.valueOf(f11));
    }

    public JSONArray put(int i11) {
        return put((Object) Integer.valueOf(i11));
    }

    public JSONArray put(long j11) {
        return put((Object) Long.valueOf(j11));
    }

    public JSONArray put(Map<?, ?> map) {
        return put((Object) new JSONObject(map));
    }

    public JSONArray put(Object obj) {
        JSONObject.testValidity(obj);
        this.myArrayList.add(obj);
        return this;
    }

    public JSONArray put(int i11, boolean z11) throws JSONException {
        return put(i11, (Object) z11 ? Boolean.TRUE : Boolean.FALSE);
    }

    public JSONArray put(int i11, Collection<?> collection) throws JSONException {
        return put(i11, (Object) new JSONArray(collection));
    }

    public JSONArray put(int i11, double d11) throws JSONException {
        return put(i11, (Object) Double.valueOf(d11));
    }

    public JSONArray put(int i11, float f11) throws JSONException {
        return put(i11, (Object) Float.valueOf(f11));
    }

    public JSONArray put(int i11, int i12) throws JSONException {
        return put(i11, (Object) Integer.valueOf(i12));
    }

    public JSONArray put(int i11, long j11) throws JSONException {
        return put(i11, (Object) Long.valueOf(j11));
    }

    public JSONArray put(int i11, Map<?, ?> map) throws JSONException {
        put(i11, (Object) new JSONObject(map));
        return this;
    }

    public JSONArray put(int i11, Object obj) throws JSONException {
        if (i11 < 0) {
            throw new JSONException("JSONArray[" + i11 + "] not found.");
        } else if (i11 < length()) {
            JSONObject.testValidity(obj);
            this.myArrayList.set(i11, obj);
            return this;
        } else if (i11 == length()) {
            return put(obj);
        } else {
            this.myArrayList.ensureCapacity(i11 + 1);
            while (i11 != length()) {
                this.myArrayList.add(JSONObject.NULL);
            }
            return put(obj);
        }
    }

    public JSONArray(String str) throws JSONException {
        this(new JSONTokener(str));
    }

    public JSONArray(Collection<?> collection) {
        if (collection == null) {
            this.myArrayList = new ArrayList<>();
            return;
        }
        this.myArrayList = new ArrayList<>(collection.size());
        for (Object wrap : collection) {
            this.myArrayList.add(JSONObject.wrap(wrap));
        }
    }

    public JSONArray(Object obj) throws JSONException {
        this();
        if (obj.getClass().isArray()) {
            int length = Array.getLength(obj);
            this.myArrayList.ensureCapacity(length);
            for (int i11 = 0; i11 < length; i11++) {
                put(JSONObject.wrap(Array.get(obj, i11)));
            }
            return;
        }
        throw new JSONException("JSONArray initial value should be a string or collection or array.");
    }
}
