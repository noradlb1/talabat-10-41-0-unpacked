package org.mockito.internal.junit;

public class ExceptionFactory {
    private static final ExceptionFactoryImpl factory;

    public interface ExceptionFactoryImpl {
        AssertionError create(String str, String str2, String str3);
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:2:0x0008 */
    static {
        /*
            int r0 = org.opentest4j.AssertionFailedError.f63302b     // Catch:{ ClassNotFoundException -> 0x0008 }
            org.mockito.internal.junit.a r0 = new org.mockito.internal.junit.a     // Catch:{ ClassNotFoundException -> 0x0008 }
            r0.<init>()     // Catch:{ ClassNotFoundException -> 0x0008 }
            goto L_0x0011
        L_0x0008:
            int r0 = junit.framework.ComparisonFailure.f23716b     // Catch:{ ClassNotFoundException -> 0x0010 }
            org.mockito.internal.junit.b r0 = new org.mockito.internal.junit.b     // Catch:{ ClassNotFoundException -> 0x0010 }
            r0.<init>()     // Catch:{ ClassNotFoundException -> 0x0010 }
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            if (r0 != 0) goto L_0x0018
            org.mockito.internal.junit.c r0 = new org.mockito.internal.junit.c
            r0.<init>()
        L_0x0018:
            factory = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mockito.internal.junit.ExceptionFactory.<clinit>():void");
    }

    private ExceptionFactory() {
    }

    public static AssertionError createArgumentsAreDifferentException(String str, String str2, String str3) {
        return factory.create(str, str2, str3);
    }
}
