package org.apache.commons.lang3.builder;

final class IDKey {

    /* renamed from: id  reason: collision with root package name */
    private final int f27840id;
    private final Object value;

    public IDKey(Object obj) {
        this.f27840id = System.identityHashCode(obj);
        this.value = obj;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof IDKey)) {
            return false;
        }
        IDKey iDKey = (IDKey) obj;
        if (this.f27840id == iDKey.f27840id && this.value == iDKey.value) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f27840id;
    }
}
