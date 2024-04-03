package org.mockito.internal.util.collections;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.mockito.internal.util.MockUtil;

public class HashCodeAndEqualsMockWrapper {
    private final Object mockInstance;

    public HashCodeAndEqualsMockWrapper(Object obj) {
        this.mockInstance = obj;
    }

    public static HashCodeAndEqualsMockWrapper of(Object obj) {
        return new HashCodeAndEqualsMockWrapper(obj);
    }

    private String typeInstanceString() {
        return this.mockInstance.getClass().getSimpleName() + "(" + System.identityHashCode(this.mockInstance) + ")";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HashCodeAndEqualsMockWrapper)) {
            return false;
        }
        if (this.mockInstance == ((HashCodeAndEqualsMockWrapper) obj).mockInstance) {
            return true;
        }
        return false;
    }

    public Object get() {
        return this.mockInstance;
    }

    public int hashCode() {
        return System.identityHashCode(this.mockInstance);
    }

    public String toString() {
        Object obj;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("HashCodeAndEqualsMockWrapper{mockInstance=");
        if (MockUtil.isMock(this.mockInstance)) {
            obj = MockUtil.getMockName(this.mockInstance);
        } else {
            obj = typeInstanceString();
        }
        sb2.append(obj);
        sb2.append(AbstractJsonLexerKt.END_OBJ);
        return sb2.toString();
    }
}
