package org.mockito.internal.util.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;
import org.mockito.internal.configuration.plugins.Plugins;
import org.mockito.plugins.MemberAccessor;

public class BeanPropertySetter {
    private static final String SET_PREFIX = "set";
    private final Field field;
    private final boolean reportNoSetterFound;
    private final Object target;

    public BeanPropertySetter(Object obj, Field field2, boolean z11) {
        this.field = field2;
        this.target = obj;
        this.reportNoSetterFound = z11;
    }

    private void reportNoSetterFound() {
        if (this.reportNoSetterFound) {
            throw new RuntimeException("Problems setting value on object: [" + this.target + "] for property : [" + this.field.getName() + "], setter not found");
        }
    }

    private String setterName(String str) {
        StringBuilder sb2 = new StringBuilder(SET_PREFIX);
        sb2.append(str.substring(0, 1).toUpperCase(Locale.ENGLISH));
        sb2.append(str, 1, str.length());
        return sb2.toString();
    }

    public boolean set(Object obj) {
        MemberAccessor memberAccessor = Plugins.getMemberAccessor();
        Method method = null;
        try {
            method = this.target.getClass().getMethod(setterName(this.field.getName()), new Class[]{this.field.getType()});
            memberAccessor.invoke(method, this.target, obj);
            return true;
        } catch (InvocationTargetException e11) {
            throw new RuntimeException("Setter '" + method + "' of '" + this.target + "' with value '" + obj + "' threw exception : '" + e11.getTargetException() + "'", e11);
        } catch (IllegalAccessException e12) {
            throw new RuntimeException("Access not authorized on field '" + this.field + "' of object '" + this.target + "' with value: '" + obj + "'", e12);
        } catch (NoSuchMethodException unused) {
            reportNoSetterFound();
            reportNoSetterFound();
            return false;
        }
    }

    public BeanPropertySetter(Object obj, Field field2) {
        this(obj, field2, false);
    }
}
