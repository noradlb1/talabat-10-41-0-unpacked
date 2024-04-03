package j$.util.concurrent;

import java.util.concurrent.atomic.AtomicReference;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

public abstract /* synthetic */ class J {
    public static /* synthetic */ boolean a(AtomicReference atomicReference, Object obj) {
        while (!atomicReference.compareAndSet((Object) null, obj)) {
            if (atomicReference.get() != null) {
                return false;
            }
        }
        return true;
    }

    static String b(Object obj, Object obj2) {
        String str;
        String obj3;
        String str2 = "null";
        if (obj == null || (str = obj.toString()) == null) {
            str = str2;
        }
        int length = str.length();
        if (!(obj2 == null || (obj3 = obj2.toString()) == null)) {
            str2 = obj3;
        }
        int length2 = str2.length();
        char[] cArr = new char[(length + length2 + 1)];
        str.getChars(0, length, cArr, 0);
        cArr[length] = SignatureVisitor.INSTANCEOF;
        str2.getChars(0, length2, cArr, length + 1);
        return new String(cArr);
    }
}
