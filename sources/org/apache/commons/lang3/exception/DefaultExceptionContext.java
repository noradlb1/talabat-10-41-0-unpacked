package org.apache.commons.lang3.exception;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

public class DefaultExceptionContext implements ExceptionContext, Serializable {
    private static final long serialVersionUID = 20110706;
    private final List<Pair<String, Object>> contextValues = new ArrayList();

    public List<Pair<String, Object>> getContextEntries() {
        return this.contextValues;
    }

    public Set<String> getContextLabels() {
        HashSet hashSet = new HashSet();
        for (Pair<String, Object> key : this.contextValues) {
            hashSet.add(key.getKey());
        }
        return hashSet;
    }

    public List<Object> getContextValues(String str) {
        ArrayList arrayList = new ArrayList();
        for (Pair next : this.contextValues) {
            if (StringUtils.equals(str, (CharSequence) next.getKey())) {
                arrayList.add(next.getValue());
            }
        }
        return arrayList;
    }

    public Object getFirstContextValue(String str) {
        for (Pair next : this.contextValues) {
            if (StringUtils.equals(str, (CharSequence) next.getKey())) {
                return next.getValue();
            }
        }
        return null;
    }

    public String getFormattedExceptionMessage(String str) {
        String str2;
        StringBuilder sb2 = new StringBuilder(256);
        if (str != null) {
            sb2.append(str);
        }
        if (this.contextValues.size() > 0) {
            if (sb2.length() > 0) {
                sb2.append(10);
            }
            sb2.append("Exception Context:\n");
            int i11 = 0;
            for (Pair next : this.contextValues) {
                sb2.append("\t[");
                i11++;
                sb2.append(i11);
                sb2.append(AbstractJsonLexerKt.COLON);
                sb2.append((String) next.getKey());
                sb2.append("=");
                Object value = next.getValue();
                if (value == null) {
                    sb2.append("null");
                } else {
                    try {
                        str2 = value.toString();
                    } catch (Exception e11) {
                        str2 = "Exception thrown on toString(): " + ExceptionUtils.getStackTrace(e11);
                    }
                    sb2.append(str2);
                }
                sb2.append("]\n");
            }
            sb2.append("---------------------------------");
        }
        return sb2.toString();
    }

    public DefaultExceptionContext addContextValue(String str, Object obj) {
        this.contextValues.add(new ImmutablePair(str, obj));
        return this;
    }

    public DefaultExceptionContext setContextValue(String str, Object obj) {
        Iterator<Pair<String, Object>> it = this.contextValues.iterator();
        while (it.hasNext()) {
            if (StringUtils.equals(str, (CharSequence) it.next().getKey())) {
                it.remove();
            }
        }
        addContextValue(str, obj);
        return this;
    }
}
