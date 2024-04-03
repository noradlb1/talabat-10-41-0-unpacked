package org.junit.platform.commons.util;

import java.util.ArrayList;
import java.util.List;
import mb.a;
import org.apiguardian.api.API;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

@API(since = "1.0", status = API.Status.INTERNAL)
public class ToStringBuilder {
    private final String typeName;
    private final List<String> values;

    public ToStringBuilder(Object obj) {
        this(Preconditions.notNull(obj, "Object must not be null").getClass().getSimpleName());
    }

    private String toString(Object obj) {
        if (!(obj instanceof CharSequence)) {
            return StringUtils.nullSafeToString(obj);
        }
        return "'" + obj + "'";
    }

    public ToStringBuilder append(String str, Object obj) {
        Preconditions.notBlank(str, "Name must not be null or blank");
        List<String> list = this.values;
        list.add(str + " = " + toString(obj));
        return this;
    }

    public ToStringBuilder(Class<?> cls) {
        this(((Class) Preconditions.notNull(cls, "Class must not be null")).getSimpleName());
    }

    public String toString() {
        return this.typeName + " [" + a.a(IndicativeSentencesGeneration.DEFAULT_SEPARATOR, this.values) + "]";
    }

    @API(since = "1.7", status = API.Status.INTERNAL)
    public ToStringBuilder(String str) {
        this.values = new ArrayList();
        this.typeName = (String) Preconditions.notNull(str, "Type name must not be null");
    }
}
