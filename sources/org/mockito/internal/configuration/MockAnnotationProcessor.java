package org.mockito.internal.configuration;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import org.mockito.Mock;
import org.mockito.MockSettings;
import org.mockito.MockedConstruction;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.internal.util.StringUtil;
import org.mockito.internal.util.Supplier;
import u30.d;

public class MockAnnotationProcessor implements FieldAnnotationProcessor<Mock> {
    public static Class<?> a(Type type, String str, String str2) {
        if (type instanceof ParameterizedType) {
            Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
            if (actualTypeArguments.length == 1) {
                Type type2 = actualTypeArguments[0];
                if (type2 instanceof Class) {
                    return (Class) type2;
                }
            }
        }
        throw new MockitoException(StringUtil.join("Mockito cannot infer a static mock from a raw type for " + str, "", "Instead of @Mock " + str2 + " you need to specify a parameterized type", "For example, if you would like to mock Sample.class, specify", "", "@Mock " + str2 + "<Sample>", "", "as the type parameter. If the type is itself parameterized, it should be specified as raw type."));
    }

    public static Object processAnnotationForMock(Mock mock, Class<?> cls, Supplier<Type> supplier, String str) {
        MockSettings withSettings = Mockito.withSettings();
        if (mock.extraInterfaces().length > 0) {
            withSettings.extraInterfaces(mock.extraInterfaces());
        }
        if ("".equals(mock.name())) {
            withSettings.name(str);
        } else {
            withSettings.name(mock.name());
        }
        if (mock.serializable()) {
            withSettings.serializable();
        }
        if (mock.stubOnly()) {
            withSettings.stubOnly();
        }
        if (mock.lenient()) {
            withSettings.lenient();
        }
        withSettings.defaultAnswer(mock.answer());
        Class<MockedStatic> cls2 = MockedStatic.class;
        if (cls == cls2) {
            return Mockito.mockStatic(a(supplier.get(), str, cls2.getSimpleName()), withSettings);
        }
        Class<MockedConstruction> cls3 = MockedConstruction.class;
        if (cls == cls3) {
            return Mockito.mockConstruction(a(supplier.get(), str, cls3.getSimpleName()), withSettings);
        }
        return Mockito.mock(cls, withSettings);
    }

    public Object process(Mock mock, Field field) {
        return processAnnotationForMock(mock, field.getType(), new d(field), field.getName());
    }
}
