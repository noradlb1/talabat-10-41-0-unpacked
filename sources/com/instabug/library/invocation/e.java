package com.instabug.library.invocation;

import com.instabug.library.invocation.invoker.FloatingButtonInvoker;
import com.instabug.library.invocation.invoker.a;
import java.util.List;

public abstract class e {
    public static boolean a(int i11, int i12) {
        List<a> a11 = InvocationManager.getInstance().a();
        if (a11 == null) {
            return false;
        }
        synchronized (a11) {
            for (a next : a11) {
                if (next instanceof FloatingButtonInvoker) {
                    boolean contains = ((FloatingButtonInvoker) next).getButtonBounds().contains(i11, i12);
                    return contains;
                }
            }
            return false;
        }
    }
}
