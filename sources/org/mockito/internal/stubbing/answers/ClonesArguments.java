package org.mockito.internal.stubbing.answers;

import java.lang.reflect.Array;
import org.mockito.internal.configuration.plugins.Plugins;
import org.mockito.internal.stubbing.defaultanswers.ReturnsEmptyValues;
import org.mockito.internal.util.reflection.LenientCopyTool;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.mock.MockCreationSettings;
import org.mockito.stubbing.Answer;

public class ClonesArguments implements Answer<Object> {
    public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
        Object[] arguments = invocationOnMock.getArguments();
        for (int i11 = 0; i11 < arguments.length; i11++) {
            Object obj = arguments[i11];
            if (obj != null) {
                if (obj.getClass().isArray()) {
                    int length = Array.getLength(obj);
                    Object newInstance = Array.newInstance(obj.getClass().getComponentType(), length);
                    for (int i12 = 0; i12 < length; i12++) {
                        Array.set(newInstance, i12, Array.get(obj, i12));
                    }
                    arguments[i11] = newInstance;
                } else {
                    Object newInstance2 = Plugins.getInstantiatorProvider().getInstantiator((MockCreationSettings<?>) null).newInstance(obj.getClass());
                    new LenientCopyTool().copyToRealObject(obj, newInstance2);
                    arguments[i11] = newInstance2;
                }
            }
        }
        return new ReturnsEmptyValues().answer(invocationOnMock);
    }
}
