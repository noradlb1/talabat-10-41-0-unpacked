package j$.time.format;

import j$.util.concurrent.ConcurrentHashMap;
import net.bytebuddy.jar.asm.Opcodes;

public final class y {

    /* renamed from: a  reason: collision with root package name */
    public static final y f28403a = new y();

    static {
        new ConcurrentHashMap(16, 0.75f, 2);
    }

    private y() {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        ((y) obj).getClass();
        return true;
    }

    public final int hashCode() {
        return Opcodes.INVOKEVIRTUAL;
    }

    public final String toString() {
        return "DecimalStyle[0+-.]";
    }
}
