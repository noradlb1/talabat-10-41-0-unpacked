package j$.util;

import java.security.PrivilegedAction;

public final /* synthetic */ class Z implements PrivilegedAction {
    public final Object run() {
        return Boolean.valueOf(Boolean.getBoolean("org.openjdk.java.util.stream.tripwire"));
    }
}
