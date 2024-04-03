package j$.util;

import java.security.AccessController;

abstract class a0 {

    /* renamed from: a  reason: collision with root package name */
    static final boolean f28601a = ((Boolean) AccessController.doPrivileged(new Z())).booleanValue();

    static void a(Class cls, String str) {
        throw new UnsupportedOperationException(cls + " tripwire tripped but logging not supported: " + str);
    }
}
