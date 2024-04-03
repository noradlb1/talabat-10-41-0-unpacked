package org.mockito.invocation;

import java.io.Serializable;
import java.lang.reflect.Method;
import org.mockito.mock.MockCreationSettings;

public interface InvocationFactory {

    public interface RealMethodBehavior<R> extends Serializable {
        R call() throws Throwable;
    }

    Invocation createInvocation(Object obj, MockCreationSettings mockCreationSettings, Method method, RealMethodBehavior realMethodBehavior, Object... objArr);
}
