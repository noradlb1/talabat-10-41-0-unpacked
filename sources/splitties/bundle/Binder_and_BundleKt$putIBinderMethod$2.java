package splitties.bundle;

import android.os.Bundle;
import android.os.IBinder;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n"}, d2 = {"Ljava/lang/reflect/Method;", "kotlin.jvm.PlatformType", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class Binder_and_BundleKt$putIBinderMethod$2 extends Lambda implements Function0<Method> {
    public static final Binder_and_BundleKt$putIBinderMethod$2 INSTANCE = new Binder_and_BundleKt$putIBinderMethod$2();

    public Binder_and_BundleKt$putIBinderMethod$2() {
        super(0);
    }

    public final Method invoke() {
        Method method = Bundle.class.getMethod("putIBinder", new Class[]{String.class, IBinder.class});
        method.setAccessible(true);
        return method;
    }
}
