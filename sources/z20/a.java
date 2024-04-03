package z20;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExecutableInvoker;

public final /* synthetic */ class a {
    public static Object a(ExecutableInvoker executableInvoker, Constructor constructor) {
        return executableInvoker.invoke(constructor, (Object) null);
    }

    public static Object b(ExecutableInvoker executableInvoker, Method method) {
        return executableInvoker.invoke(method, (Object) null);
    }
}
