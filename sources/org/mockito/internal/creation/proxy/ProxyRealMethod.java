package org.mockito.internal.creation.proxy;

import java.lang.reflect.Method;
import org.mockito.internal.invocation.RealMethod;

interface ProxyRealMethod {
    RealMethod resolve(Object obj, Method method, Object[] objArr);
}
