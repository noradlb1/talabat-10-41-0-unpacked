package org.apache.commons.lang3.builder;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;
import java.util.WeakHashMap;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.SystemUtils;

public abstract class ToStringStyle implements Serializable {
    public static final ToStringStyle DEFAULT_STYLE = new DefaultToStringStyle();
    public static final ToStringStyle MULTI_LINE_STYLE = new MultiLineToStringStyle();
    public static final ToStringStyle NO_FIELD_NAMES_STYLE = new NoFieldNameToStringStyle();
    private static final ThreadLocal<WeakHashMap<Object, Object>> REGISTRY = new ThreadLocal<>();
    public static final ToStringStyle SHORT_PREFIX_STYLE = new ShortPrefixToStringStyle();
    public static final ToStringStyle SIMPLE_STYLE = new SimpleToStringStyle();
    private static final long serialVersionUID = -2587890625525655916L;
    private boolean arrayContentDetail = true;
    private String arrayEnd = "}";
    private String arraySeparator = ",";
    private String arrayStart = "{";
    private String contentEnd = "]";
    private String contentStart = "[";
    private boolean defaultFullDetail = true;
    private String fieldNameValueSeparator = "=";
    private String fieldSeparator = ",";
    private boolean fieldSeparatorAtEnd = false;
    private boolean fieldSeparatorAtStart = false;
    private String nullText = "<null>";
    private String sizeEndText = ">";
    private String sizeStartText = "<size=";
    private String summaryObjectEndText = ">";
    private String summaryObjectStartText = "<";
    private boolean useClassName = true;
    private boolean useFieldNames = true;
    private boolean useIdentityHashCode = true;
    private boolean useShortClassName = false;

    public static final class DefaultToStringStyle extends ToStringStyle {
        private static final long serialVersionUID = 1;

        private Object readResolve() {
            return ToStringStyle.DEFAULT_STYLE;
        }
    }

    public static final class MultiLineToStringStyle extends ToStringStyle {
        private static final long serialVersionUID = 1;

        public MultiLineToStringStyle() {
            setContentStart("[");
            StringBuilder sb2 = new StringBuilder();
            String str = SystemUtils.LINE_SEPARATOR;
            sb2.append(str);
            sb2.append("  ");
            setFieldSeparator(sb2.toString());
            setFieldSeparatorAtStart(true);
            setContentEnd(str + "]");
        }

        private Object readResolve() {
            return ToStringStyle.MULTI_LINE_STYLE;
        }
    }

    public static final class NoFieldNameToStringStyle extends ToStringStyle {
        private static final long serialVersionUID = 1;

        public NoFieldNameToStringStyle() {
            setUseFieldNames(false);
        }

        private Object readResolve() {
            return ToStringStyle.NO_FIELD_NAMES_STYLE;
        }
    }

    public static final class ShortPrefixToStringStyle extends ToStringStyle {
        private static final long serialVersionUID = 1;

        public ShortPrefixToStringStyle() {
            setUseShortClassName(true);
            setUseIdentityHashCode(false);
        }

        private Object readResolve() {
            return ToStringStyle.SHORT_PREFIX_STYLE;
        }
    }

    public static final class SimpleToStringStyle extends ToStringStyle {
        private static final long serialVersionUID = 1;

        public SimpleToStringStyle() {
            setUseClassName(false);
            setUseIdentityHashCode(false);
            setUseFieldNames(false);
            setContentStart("");
            setContentEnd("");
        }

        private Object readResolve() {
            return ToStringStyle.SIMPLE_STYLE;
        }
    }

    public static Map<Object, Object> getRegistry() {
        return REGISTRY.get();
    }

    public static boolean isRegistered(Object obj) {
        Map<Object, Object> registry = getRegistry();
        if (registry == null || !registry.containsKey(obj)) {
            return false;
        }
        return true;
    }

    public static void register(Object obj) {
        if (obj != null) {
            if (getRegistry() == null) {
                REGISTRY.set(new WeakHashMap());
            }
            getRegistry().put(obj, (Object) null);
        }
    }

    public static void unregister(Object obj) {
        Map<Object, Object> registry;
        if (obj != null && (registry = getRegistry()) != null) {
            registry.remove(obj);
            if (registry.isEmpty()) {
                REGISTRY.remove();
            }
        }
    }

    public void append(StringBuffer stringBuffer, String str, Object obj, Boolean bool) {
        appendFieldStart(stringBuffer, str);
        if (obj == null) {
            appendNullText(stringBuffer, str);
        } else {
            appendInternal(stringBuffer, str, obj, isFullDetail(bool));
        }
        appendFieldEnd(stringBuffer, str);
    }

    public void appendClassName(StringBuffer stringBuffer, Object obj) {
        if (this.useClassName && obj != null) {
            register(obj);
            if (this.useShortClassName) {
                stringBuffer.append(getShortClassName(obj.getClass()));
            } else {
                stringBuffer.append(obj.getClass().getName());
            }
        }
    }

    public void appendContentEnd(StringBuffer stringBuffer) {
        stringBuffer.append(this.contentEnd);
    }

    public void appendContentStart(StringBuffer stringBuffer) {
        stringBuffer.append(this.contentStart);
    }

    public void appendCyclicObject(StringBuffer stringBuffer, String str, Object obj) {
        ObjectUtils.identityToString(stringBuffer, obj);
    }

    public void appendDetail(StringBuffer stringBuffer, String str, Object obj) {
        stringBuffer.append(obj);
    }

    public void appendEnd(StringBuffer stringBuffer, Object obj) {
        if (!this.fieldSeparatorAtEnd) {
            removeLastFieldSeparator(stringBuffer);
        }
        appendContentEnd(stringBuffer);
        unregister(obj);
    }

    public void appendFieldEnd(StringBuffer stringBuffer, String str) {
        appendFieldSeparator(stringBuffer);
    }

    public void appendFieldSeparator(StringBuffer stringBuffer) {
        stringBuffer.append(this.fieldSeparator);
    }

    public void appendFieldStart(StringBuffer stringBuffer, String str) {
        if (this.useFieldNames && str != null) {
            stringBuffer.append(str);
            stringBuffer.append(this.fieldNameValueSeparator);
        }
    }

    public void appendIdentityHashCode(StringBuffer stringBuffer, Object obj) {
        if (isUseIdentityHashCode() && obj != null) {
            register(obj);
            stringBuffer.append('@');
            stringBuffer.append(Integer.toHexString(System.identityHashCode(obj)));
        }
    }

    public void appendInternal(StringBuffer stringBuffer, String str, Object obj, boolean z11) {
        if (!isRegistered(obj) || (obj instanceof Number) || (obj instanceof Boolean) || (obj instanceof Character)) {
            register(obj);
            try {
                if (obj instanceof Collection) {
                    if (z11) {
                        appendDetail(stringBuffer, str, (Collection<?>) (Collection) obj);
                    } else {
                        appendSummarySize(stringBuffer, str, ((Collection) obj).size());
                    }
                } else if (obj instanceof Map) {
                    if (z11) {
                        appendDetail(stringBuffer, str, (Map<?, ?>) (Map) obj);
                    } else {
                        appendSummarySize(stringBuffer, str, ((Map) obj).size());
                    }
                } else if (obj instanceof long[]) {
                    if (z11) {
                        appendDetail(stringBuffer, str, (long[]) obj);
                    } else {
                        appendSummary(stringBuffer, str, (long[]) obj);
                    }
                } else if (obj instanceof int[]) {
                    if (z11) {
                        appendDetail(stringBuffer, str, (int[]) obj);
                    } else {
                        appendSummary(stringBuffer, str, (int[]) obj);
                    }
                } else if (obj instanceof short[]) {
                    if (z11) {
                        appendDetail(stringBuffer, str, (short[]) obj);
                    } else {
                        appendSummary(stringBuffer, str, (short[]) obj);
                    }
                } else if (obj instanceof byte[]) {
                    if (z11) {
                        appendDetail(stringBuffer, str, (byte[]) obj);
                    } else {
                        appendSummary(stringBuffer, str, (byte[]) obj);
                    }
                } else if (obj instanceof char[]) {
                    if (z11) {
                        appendDetail(stringBuffer, str, (char[]) obj);
                    } else {
                        appendSummary(stringBuffer, str, (char[]) obj);
                    }
                } else if (obj instanceof double[]) {
                    if (z11) {
                        appendDetail(stringBuffer, str, (double[]) obj);
                    } else {
                        appendSummary(stringBuffer, str, (double[]) obj);
                    }
                } else if (obj instanceof float[]) {
                    if (z11) {
                        appendDetail(stringBuffer, str, (float[]) obj);
                    } else {
                        appendSummary(stringBuffer, str, (float[]) obj);
                    }
                } else if (obj instanceof boolean[]) {
                    if (z11) {
                        appendDetail(stringBuffer, str, (boolean[]) obj);
                    } else {
                        appendSummary(stringBuffer, str, (boolean[]) obj);
                    }
                } else if (obj.getClass().isArray()) {
                    if (z11) {
                        appendDetail(stringBuffer, str, (Object[]) obj);
                    } else {
                        appendSummary(stringBuffer, str, (Object[]) obj);
                    }
                } else if (z11) {
                    appendDetail(stringBuffer, str, obj);
                } else {
                    appendSummary(stringBuffer, str, obj);
                }
            } finally {
                unregister(obj);
            }
        } else {
            appendCyclicObject(stringBuffer, str, obj);
        }
    }

    public void appendNullText(StringBuffer stringBuffer, String str) {
        stringBuffer.append(this.nullText);
    }

    public void appendStart(StringBuffer stringBuffer, Object obj) {
        if (obj != null) {
            appendClassName(stringBuffer, obj);
            appendIdentityHashCode(stringBuffer, obj);
            appendContentStart(stringBuffer);
            if (this.fieldSeparatorAtStart) {
                appendFieldSeparator(stringBuffer);
            }
        }
    }

    public void appendSummary(StringBuffer stringBuffer, String str, Object obj) {
        stringBuffer.append(this.summaryObjectStartText);
        stringBuffer.append(getShortClassName(obj.getClass()));
        stringBuffer.append(this.summaryObjectEndText);
    }

    public void appendSummarySize(StringBuffer stringBuffer, String str, int i11) {
        stringBuffer.append(this.sizeStartText);
        stringBuffer.append(i11);
        stringBuffer.append(this.sizeEndText);
    }

    public void appendSuper(StringBuffer stringBuffer, String str) {
        appendToString(stringBuffer, str);
    }

    public void appendToString(StringBuffer stringBuffer, String str) {
        int indexOf;
        int lastIndexOf;
        if (str != null && (indexOf = str.indexOf(this.contentStart) + this.contentStart.length()) != (lastIndexOf = str.lastIndexOf(this.contentEnd)) && indexOf >= 0 && lastIndexOf >= 0) {
            String substring = str.substring(indexOf, lastIndexOf);
            if (this.fieldSeparatorAtStart) {
                removeLastFieldSeparator(stringBuffer);
            }
            stringBuffer.append(substring);
            appendFieldSeparator(stringBuffer);
        }
    }

    public String getArrayEnd() {
        return this.arrayEnd;
    }

    public String getArraySeparator() {
        return this.arraySeparator;
    }

    public String getArrayStart() {
        return this.arrayStart;
    }

    public String getContentEnd() {
        return this.contentEnd;
    }

    public String getContentStart() {
        return this.contentStart;
    }

    public String getFieldNameValueSeparator() {
        return this.fieldNameValueSeparator;
    }

    public String getFieldSeparator() {
        return this.fieldSeparator;
    }

    public String getNullText() {
        return this.nullText;
    }

    public String getShortClassName(Class<?> cls) {
        return ClassUtils.getShortClassName(cls);
    }

    public String getSizeEndText() {
        return this.sizeEndText;
    }

    public String getSizeStartText() {
        return this.sizeStartText;
    }

    public String getSummaryObjectEndText() {
        return this.summaryObjectEndText;
    }

    public String getSummaryObjectStartText() {
        return this.summaryObjectStartText;
    }

    public boolean isArrayContentDetail() {
        return this.arrayContentDetail;
    }

    public boolean isDefaultFullDetail() {
        return this.defaultFullDetail;
    }

    public boolean isFieldSeparatorAtEnd() {
        return this.fieldSeparatorAtEnd;
    }

    public boolean isFieldSeparatorAtStart() {
        return this.fieldSeparatorAtStart;
    }

    public boolean isFullDetail(Boolean bool) {
        if (bool == null) {
            return this.defaultFullDetail;
        }
        return bool.booleanValue();
    }

    public boolean isUseClassName() {
        return this.useClassName;
    }

    public boolean isUseFieldNames() {
        return this.useFieldNames;
    }

    public boolean isUseIdentityHashCode() {
        return this.useIdentityHashCode;
    }

    public boolean isUseShortClassName() {
        return this.useShortClassName;
    }

    public void reflectionAppendArrayDetail(StringBuffer stringBuffer, String str, Object obj) {
        stringBuffer.append(this.arrayStart);
        int length = Array.getLength(obj);
        for (int i11 = 0; i11 < length; i11++) {
            Object obj2 = Array.get(obj, i11);
            if (i11 > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            if (obj2 == null) {
                appendNullText(stringBuffer, str);
            } else {
                appendInternal(stringBuffer, str, obj2, this.arrayContentDetail);
            }
        }
        stringBuffer.append(this.arrayEnd);
    }

    public void removeLastFieldSeparator(StringBuffer stringBuffer) {
        int length = stringBuffer.length();
        int length2 = this.fieldSeparator.length();
        if (length > 0 && length2 > 0 && length >= length2) {
            boolean z11 = false;
            int i11 = 0;
            while (true) {
                if (i11 >= length2) {
                    z11 = true;
                    break;
                } else if (stringBuffer.charAt((length - 1) - i11) != this.fieldSeparator.charAt((length2 - 1) - i11)) {
                    break;
                } else {
                    i11++;
                }
            }
            if (z11) {
                stringBuffer.setLength(length - length2);
            }
        }
    }

    public void setArrayContentDetail(boolean z11) {
        this.arrayContentDetail = z11;
    }

    public void setArrayEnd(String str) {
        if (str == null) {
            str = "";
        }
        this.arrayEnd = str;
    }

    public void setArraySeparator(String str) {
        if (str == null) {
            str = "";
        }
        this.arraySeparator = str;
    }

    public void setArrayStart(String str) {
        if (str == null) {
            str = "";
        }
        this.arrayStart = str;
    }

    public void setContentEnd(String str) {
        if (str == null) {
            str = "";
        }
        this.contentEnd = str;
    }

    public void setContentStart(String str) {
        if (str == null) {
            str = "";
        }
        this.contentStart = str;
    }

    public void setDefaultFullDetail(boolean z11) {
        this.defaultFullDetail = z11;
    }

    public void setFieldNameValueSeparator(String str) {
        if (str == null) {
            str = "";
        }
        this.fieldNameValueSeparator = str;
    }

    public void setFieldSeparator(String str) {
        if (str == null) {
            str = "";
        }
        this.fieldSeparator = str;
    }

    public void setFieldSeparatorAtEnd(boolean z11) {
        this.fieldSeparatorAtEnd = z11;
    }

    public void setFieldSeparatorAtStart(boolean z11) {
        this.fieldSeparatorAtStart = z11;
    }

    public void setNullText(String str) {
        if (str == null) {
            str = "";
        }
        this.nullText = str;
    }

    public void setSizeEndText(String str) {
        if (str == null) {
            str = "";
        }
        this.sizeEndText = str;
    }

    public void setSizeStartText(String str) {
        if (str == null) {
            str = "";
        }
        this.sizeStartText = str;
    }

    public void setSummaryObjectEndText(String str) {
        if (str == null) {
            str = "";
        }
        this.summaryObjectEndText = str;
    }

    public void setSummaryObjectStartText(String str) {
        if (str == null) {
            str = "";
        }
        this.summaryObjectStartText = str;
    }

    public void setUseClassName(boolean z11) {
        this.useClassName = z11;
    }

    public void setUseFieldNames(boolean z11) {
        this.useFieldNames = z11;
    }

    public void setUseIdentityHashCode(boolean z11) {
        this.useIdentityHashCode = z11;
    }

    public void setUseShortClassName(boolean z11) {
        this.useShortClassName = z11;
    }

    public void appendDetail(StringBuffer stringBuffer, String str, Collection<?> collection) {
        stringBuffer.append(collection);
    }

    public void appendDetail(StringBuffer stringBuffer, String str, Map<?, ?> map) {
        stringBuffer.append(map);
    }

    public void appendDetail(StringBuffer stringBuffer, String str, long j11) {
        stringBuffer.append(j11);
    }

    public void appendSummary(StringBuffer stringBuffer, String str, Object[] objArr) {
        appendSummarySize(stringBuffer, str, objArr.length);
    }

    public void append(StringBuffer stringBuffer, String str, long j11) {
        appendFieldStart(stringBuffer, str);
        appendDetail(stringBuffer, str, j11);
        appendFieldEnd(stringBuffer, str);
    }

    public void appendDetail(StringBuffer stringBuffer, String str, int i11) {
        stringBuffer.append(i11);
    }

    public void appendSummary(StringBuffer stringBuffer, String str, long[] jArr) {
        appendSummarySize(stringBuffer, str, jArr.length);
    }

    public void appendDetail(StringBuffer stringBuffer, String str, short s11) {
        stringBuffer.append(s11);
    }

    public void appendSummary(StringBuffer stringBuffer, String str, int[] iArr) {
        appendSummarySize(stringBuffer, str, iArr.length);
    }

    public void appendDetail(StringBuffer stringBuffer, String str, byte b11) {
        stringBuffer.append(b11);
    }

    public void appendSummary(StringBuffer stringBuffer, String str, short[] sArr) {
        appendSummarySize(stringBuffer, str, sArr.length);
    }

    public void append(StringBuffer stringBuffer, String str, int i11) {
        appendFieldStart(stringBuffer, str);
        appendDetail(stringBuffer, str, i11);
        appendFieldEnd(stringBuffer, str);
    }

    public void appendDetail(StringBuffer stringBuffer, String str, char c11) {
        stringBuffer.append(c11);
    }

    public void appendSummary(StringBuffer stringBuffer, String str, byte[] bArr) {
        appendSummarySize(stringBuffer, str, bArr.length);
    }

    public void appendDetail(StringBuffer stringBuffer, String str, double d11) {
        stringBuffer.append(d11);
    }

    public void appendSummary(StringBuffer stringBuffer, String str, char[] cArr) {
        appendSummarySize(stringBuffer, str, cArr.length);
    }

    public void appendDetail(StringBuffer stringBuffer, String str, float f11) {
        stringBuffer.append(f11);
    }

    public void appendSummary(StringBuffer stringBuffer, String str, double[] dArr) {
        appendSummarySize(stringBuffer, str, dArr.length);
    }

    public void append(StringBuffer stringBuffer, String str, short s11) {
        appendFieldStart(stringBuffer, str);
        appendDetail(stringBuffer, str, s11);
        appendFieldEnd(stringBuffer, str);
    }

    public void appendDetail(StringBuffer stringBuffer, String str, boolean z11) {
        stringBuffer.append(z11);
    }

    public void appendSummary(StringBuffer stringBuffer, String str, float[] fArr) {
        appendSummarySize(stringBuffer, str, fArr.length);
    }

    public void appendDetail(StringBuffer stringBuffer, String str, Object[] objArr) {
        stringBuffer.append(this.arrayStart);
        for (int i11 = 0; i11 < objArr.length; i11++) {
            Object obj = objArr[i11];
            if (i11 > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            if (obj == null) {
                appendNullText(stringBuffer, str);
            } else {
                appendInternal(stringBuffer, str, obj, this.arrayContentDetail);
            }
        }
        stringBuffer.append(this.arrayEnd);
    }

    public void appendSummary(StringBuffer stringBuffer, String str, boolean[] zArr) {
        appendSummarySize(stringBuffer, str, zArr.length);
    }

    public void append(StringBuffer stringBuffer, String str, byte b11) {
        appendFieldStart(stringBuffer, str);
        appendDetail(stringBuffer, str, b11);
        appendFieldEnd(stringBuffer, str);
    }

    public void append(StringBuffer stringBuffer, String str, char c11) {
        appendFieldStart(stringBuffer, str);
        appendDetail(stringBuffer, str, c11);
        appendFieldEnd(stringBuffer, str);
    }

    public void appendDetail(StringBuffer stringBuffer, String str, long[] jArr) {
        stringBuffer.append(this.arrayStart);
        for (int i11 = 0; i11 < jArr.length; i11++) {
            if (i11 > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            appendDetail(stringBuffer, str, jArr[i11]);
        }
        stringBuffer.append(this.arrayEnd);
    }

    public void append(StringBuffer stringBuffer, String str, double d11) {
        appendFieldStart(stringBuffer, str);
        appendDetail(stringBuffer, str, d11);
        appendFieldEnd(stringBuffer, str);
    }

    public void append(StringBuffer stringBuffer, String str, float f11) {
        appendFieldStart(stringBuffer, str);
        appendDetail(stringBuffer, str, f11);
        appendFieldEnd(stringBuffer, str);
    }

    public void appendDetail(StringBuffer stringBuffer, String str, int[] iArr) {
        stringBuffer.append(this.arrayStart);
        for (int i11 = 0; i11 < iArr.length; i11++) {
            if (i11 > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            appendDetail(stringBuffer, str, iArr[i11]);
        }
        stringBuffer.append(this.arrayEnd);
    }

    public void append(StringBuffer stringBuffer, String str, boolean z11) {
        appendFieldStart(stringBuffer, str);
        appendDetail(stringBuffer, str, z11);
        appendFieldEnd(stringBuffer, str);
    }

    public void append(StringBuffer stringBuffer, String str, Object[] objArr, Boolean bool) {
        appendFieldStart(stringBuffer, str);
        if (objArr == null) {
            appendNullText(stringBuffer, str);
        } else if (isFullDetail(bool)) {
            appendDetail(stringBuffer, str, objArr);
        } else {
            appendSummary(stringBuffer, str, objArr);
        }
        appendFieldEnd(stringBuffer, str);
    }

    public void appendDetail(StringBuffer stringBuffer, String str, short[] sArr) {
        stringBuffer.append(this.arrayStart);
        for (int i11 = 0; i11 < sArr.length; i11++) {
            if (i11 > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            appendDetail(stringBuffer, str, sArr[i11]);
        }
        stringBuffer.append(this.arrayEnd);
    }

    public void appendDetail(StringBuffer stringBuffer, String str, byte[] bArr) {
        stringBuffer.append(this.arrayStart);
        for (int i11 = 0; i11 < bArr.length; i11++) {
            if (i11 > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            appendDetail(stringBuffer, str, bArr[i11]);
        }
        stringBuffer.append(this.arrayEnd);
    }

    public void append(StringBuffer stringBuffer, String str, long[] jArr, Boolean bool) {
        appendFieldStart(stringBuffer, str);
        if (jArr == null) {
            appendNullText(stringBuffer, str);
        } else if (isFullDetail(bool)) {
            appendDetail(stringBuffer, str, jArr);
        } else {
            appendSummary(stringBuffer, str, jArr);
        }
        appendFieldEnd(stringBuffer, str);
    }

    public void appendDetail(StringBuffer stringBuffer, String str, char[] cArr) {
        stringBuffer.append(this.arrayStart);
        for (int i11 = 0; i11 < cArr.length; i11++) {
            if (i11 > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            appendDetail(stringBuffer, str, cArr[i11]);
        }
        stringBuffer.append(this.arrayEnd);
    }

    public void append(StringBuffer stringBuffer, String str, int[] iArr, Boolean bool) {
        appendFieldStart(stringBuffer, str);
        if (iArr == null) {
            appendNullText(stringBuffer, str);
        } else if (isFullDetail(bool)) {
            appendDetail(stringBuffer, str, iArr);
        } else {
            appendSummary(stringBuffer, str, iArr);
        }
        appendFieldEnd(stringBuffer, str);
    }

    public void appendDetail(StringBuffer stringBuffer, String str, double[] dArr) {
        stringBuffer.append(this.arrayStart);
        for (int i11 = 0; i11 < dArr.length; i11++) {
            if (i11 > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            appendDetail(stringBuffer, str, dArr[i11]);
        }
        stringBuffer.append(this.arrayEnd);
    }

    public void append(StringBuffer stringBuffer, String str, short[] sArr, Boolean bool) {
        appendFieldStart(stringBuffer, str);
        if (sArr == null) {
            appendNullText(stringBuffer, str);
        } else if (isFullDetail(bool)) {
            appendDetail(stringBuffer, str, sArr);
        } else {
            appendSummary(stringBuffer, str, sArr);
        }
        appendFieldEnd(stringBuffer, str);
    }

    public void appendDetail(StringBuffer stringBuffer, String str, float[] fArr) {
        stringBuffer.append(this.arrayStart);
        for (int i11 = 0; i11 < fArr.length; i11++) {
            if (i11 > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            appendDetail(stringBuffer, str, fArr[i11]);
        }
        stringBuffer.append(this.arrayEnd);
    }

    public void append(StringBuffer stringBuffer, String str, byte[] bArr, Boolean bool) {
        appendFieldStart(stringBuffer, str);
        if (bArr == null) {
            appendNullText(stringBuffer, str);
        } else if (isFullDetail(bool)) {
            appendDetail(stringBuffer, str, bArr);
        } else {
            appendSummary(stringBuffer, str, bArr);
        }
        appendFieldEnd(stringBuffer, str);
    }

    public void appendDetail(StringBuffer stringBuffer, String str, boolean[] zArr) {
        stringBuffer.append(this.arrayStart);
        for (int i11 = 0; i11 < zArr.length; i11++) {
            if (i11 > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            appendDetail(stringBuffer, str, zArr[i11]);
        }
        stringBuffer.append(this.arrayEnd);
    }

    public void append(StringBuffer stringBuffer, String str, char[] cArr, Boolean bool) {
        appendFieldStart(stringBuffer, str);
        if (cArr == null) {
            appendNullText(stringBuffer, str);
        } else if (isFullDetail(bool)) {
            appendDetail(stringBuffer, str, cArr);
        } else {
            appendSummary(stringBuffer, str, cArr);
        }
        appendFieldEnd(stringBuffer, str);
    }

    public void append(StringBuffer stringBuffer, String str, double[] dArr, Boolean bool) {
        appendFieldStart(stringBuffer, str);
        if (dArr == null) {
            appendNullText(stringBuffer, str);
        } else if (isFullDetail(bool)) {
            appendDetail(stringBuffer, str, dArr);
        } else {
            appendSummary(stringBuffer, str, dArr);
        }
        appendFieldEnd(stringBuffer, str);
    }

    public void append(StringBuffer stringBuffer, String str, float[] fArr, Boolean bool) {
        appendFieldStart(stringBuffer, str);
        if (fArr == null) {
            appendNullText(stringBuffer, str);
        } else if (isFullDetail(bool)) {
            appendDetail(stringBuffer, str, fArr);
        } else {
            appendSummary(stringBuffer, str, fArr);
        }
        appendFieldEnd(stringBuffer, str);
    }

    public void append(StringBuffer stringBuffer, String str, boolean[] zArr, Boolean bool) {
        appendFieldStart(stringBuffer, str);
        if (zArr == null) {
            appendNullText(stringBuffer, str);
        } else if (isFullDetail(bool)) {
            appendDetail(stringBuffer, str, zArr);
        } else {
            appendSummary(stringBuffer, str, zArr);
        }
        appendFieldEnd(stringBuffer, str);
    }
}
