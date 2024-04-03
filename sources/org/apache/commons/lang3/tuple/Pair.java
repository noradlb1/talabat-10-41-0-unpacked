package org.apache.commons.lang3.tuple;

import java.io.Serializable;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.builder.CompareToBuilder;

public abstract class Pair<L, R> implements Map.Entry<L, R>, Comparable<Pair<L, R>>, Serializable {
    private static final long serialVersionUID = 4954918890077093841L;

    public static <L, R> Pair<L, R> of(L l11, R r11) {
        return new ImmutablePair(l11, r11);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (!ObjectUtils.equals(getKey(), entry.getKey()) || !ObjectUtils.equals(getValue(), entry.getValue())) {
            return false;
        }
        return true;
    }

    public final L getKey() {
        return getLeft();
    }

    public abstract L getLeft();

    public abstract R getRight();

    public R getValue() {
        return getRight();
    }

    public int hashCode() {
        int i11 = 0;
        int hashCode = getKey() == null ? 0 : getKey().hashCode();
        if (getValue() != null) {
            i11 = getValue().hashCode();
        }
        return hashCode ^ i11;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append('(');
        sb2.append(getLeft());
        sb2.append(AbstractJsonLexerKt.COMMA);
        sb2.append(getRight());
        sb2.append(')');
        return sb2.toString();
    }

    public int compareTo(Pair<L, R> pair) {
        return new CompareToBuilder().append(getLeft(), (Object) pair.getLeft()).append(getRight(), (Object) pair.getRight()).toComparison();
    }

    public String toString(String str) {
        return String.format(str, new Object[]{getLeft(), getRight()});
    }
}
