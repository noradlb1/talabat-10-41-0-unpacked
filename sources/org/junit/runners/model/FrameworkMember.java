package org.junit.runners.model;

import java.lang.reflect.Modifier;
import java.util.List;
import org.junit.runners.model.FrameworkMember;

public abstract class FrameworkMember<T extends FrameworkMember<T>> implements Annotatable {
    public abstract int a();

    public boolean b(List<T> list) {
        for (T isShadowedBy : list) {
            if (isShadowedBy(isShadowedBy)) {
                return true;
            }
        }
        return false;
    }

    public abstract Class<?> getDeclaringClass();

    public abstract String getName();

    public abstract Class<?> getType();

    public boolean isPublic() {
        return Modifier.isPublic(a());
    }

    public abstract boolean isShadowedBy(T t11);

    public boolean isStatic() {
        return Modifier.isStatic(a());
    }
}
