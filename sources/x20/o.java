package x20;

import java.lang.reflect.Method;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.platform.commons.util.ClassUtils;
import org.junit.platform.commons.util.Preconditions;
import org.junit.platform.commons.util.ReflectionUtils;

public final /* synthetic */ class o {
    public static DisplayNameGenerator a(Class<?> cls) {
        Preconditions.notNull(cls, "Class must not be null");
        Preconditions.condition(DisplayNameGenerator.class.isAssignableFrom(cls), "Class must be a DisplayNameGenerator implementation");
        if (cls == DisplayNameGenerator.Standard.class) {
            return DisplayNameGenerator.Standard.f57104a;
        }
        if (cls == DisplayNameGenerator.Simple.class) {
            return DisplayNameGenerator.Simple.f57103b;
        }
        if (cls == DisplayNameGenerator.ReplaceUnderscores.class) {
            return DisplayNameGenerator.ReplaceUnderscores.f57102c;
        }
        if (cls == DisplayNameGenerator.IndicativeSentences.class) {
            return DisplayNameGenerator.IndicativeSentences.f57101a;
        }
        return (DisplayNameGenerator) ReflectionUtils.newInstance(cls, new Object[0]);
    }

    public static String b(Method method) {
        Preconditions.notNull(method, "Method must not be null");
        return '(' + ClassUtils.nullSafeToString(new n(), method.getParameterTypes()) + ')';
    }
}
