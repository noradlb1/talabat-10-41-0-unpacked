package org.mockito.invocation;

import java.io.Serializable;
import java.lang.reflect.Method;
import org.mockito.NotExtensible;

@NotExtensible
public interface InvocationOnMock extends Serializable {
    Object callRealMethod() throws Throwable;

    <T> T getArgument(int i11);

    <T> T getArgument(int i11, Class<T> cls);

    Object[] getArguments();

    Method getMethod();

    Object getMock();
}
