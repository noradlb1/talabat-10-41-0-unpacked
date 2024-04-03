package org.mockito.internal.stubbing.answers;

import java.io.Serializable;
import org.mockito.internal.configuration.plugins.Plugins;
import org.mockito.mock.MockCreationSettings;

public class ThrowsExceptionForClassType extends AbstractThrowsException implements Serializable {
    private final Class<? extends Throwable> throwableClass;

    public ThrowsExceptionForClassType(Class<? extends Throwable> cls) {
        this.throwableClass = cls;
    }

    public Throwable a() {
        return (Throwable) Plugins.getInstantiatorProvider().getInstantiator((MockCreationSettings<?>) null).newInstance(this.throwableClass);
    }
}
