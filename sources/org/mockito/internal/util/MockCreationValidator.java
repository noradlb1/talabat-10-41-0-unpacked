package org.mockito.internal.util;

import java.util.Collection;
import org.mockito.internal.exceptions.Reporter;
import org.mockito.mock.SerializableMode;
import org.mockito.plugins.MockMaker;

public class MockCreationValidator {
    public void validateConstructorUse(boolean z11, SerializableMode serializableMode) {
        if (z11 && serializableMode == SerializableMode.ACROSS_CLASSLOADERS) {
            throw Reporter.usingConstructorWithFancySerializable(serializableMode);
        }
    }

    public void validateDelegatedInstance(Class<?> cls, Object obj) {
        if (cls != null && obj != null && obj.getClass().isAssignableFrom(cls)) {
            throw Reporter.mockedTypeIsInconsistentWithDelegatedInstanceType(cls, obj);
        }
    }

    public void validateExtraInterfaces(Class<?> cls, Collection<Class<?>> collection) {
        if (collection != null) {
            for (Class<?> cls2 : collection) {
                if (cls == cls2) {
                    throw Reporter.extraInterfacesCannotContainMockedType(cls);
                }
            }
        }
    }

    public void validateMockedType(Class<?> cls, Object obj) {
        if (cls != null && obj != null && !cls.equals(obj.getClass())) {
            throw Reporter.mockedTypeIsInconsistentWithSpiedInstanceType(cls, obj);
        }
    }

    public void validateType(Class<?> cls) {
        MockMaker.TypeMockability typeMockabilityOf = MockUtil.typeMockabilityOf(cls);
        if (!typeMockabilityOf.mockable()) {
            throw Reporter.cannotMockClass(cls, typeMockabilityOf.nonMockableReason());
        }
    }
}
