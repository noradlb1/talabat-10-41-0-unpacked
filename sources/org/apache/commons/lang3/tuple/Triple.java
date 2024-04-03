package org.apache.commons.lang3.tuple;

import java.io.Serializable;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.builder.CompareToBuilder;

public abstract class Triple<L, M, R> implements Comparable<Triple<L, M, R>>, Serializable {
    private static final long serialVersionUID = 1;

    public static <L, M, R> Triple<L, M, R> of(L l11, M m11, R r11) {
        return new ImmutableTriple(l11, m11, r11);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Triple)) {
            return false;
        }
        Triple triple = (Triple) obj;
        if (!ObjectUtils.equals(getLeft(), triple.getLeft()) || !ObjectUtils.equals(getMiddle(), triple.getMiddle()) || !ObjectUtils.equals(getRight(), triple.getRight())) {
            return false;
        }
        return true;
    }

    public abstract L getLeft();

    public abstract M getMiddle();

    public abstract R getRight();

    public int hashCode() {
        int i11 = 0;
        int hashCode = (getLeft() == null ? 0 : getLeft().hashCode()) ^ (getMiddle() == null ? 0 : getMiddle().hashCode());
        if (getRight() != null) {
            i11 = getRight().hashCode();
        }
        return hashCode ^ i11;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append('(');
        sb2.append(getLeft());
        sb2.append(AbstractJsonLexerKt.COMMA);
        sb2.append(getMiddle());
        sb2.append(AbstractJsonLexerKt.COMMA);
        sb2.append(getRight());
        sb2.append(')');
        return sb2.toString();
    }

    public int compareTo(Triple<L, M, R> triple) {
        return new CompareToBuilder().append(getLeft(), (Object) triple.getLeft()).append(getMiddle(), (Object) triple.getMiddle()).append(getRight(), (Object) triple.getRight()).toComparison();
    }

    public String toString(String str) {
        return String.format(str, new Object[]{getLeft(), getMiddle(), getRight()});
    }
}
