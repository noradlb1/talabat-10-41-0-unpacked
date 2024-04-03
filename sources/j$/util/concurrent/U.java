package j$.util.concurrent;

import java.security.PrivilegedAction;

final class U implements PrivilegedAction {
    U() {
    }

    public final Object run() {
        return Boolean.valueOf(Boolean.getBoolean("java.util.secureRandomSeed"));
    }
}
