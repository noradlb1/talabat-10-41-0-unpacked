package bo.app;

import com.braze.ui.actions.brazeactions.steps.StepData;
import com.newrelic.agent.android.agentdata.HexAttribute;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015JE\u0010\t\u001a\u0004\u0018\u00010\b2\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u001e\u0010\u0007\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00020\u0006\"\b\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\t\u0010\nJA\u0010\f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u001e\u0010\u0007\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00020\u0006\"\b\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\f\u0010\rJ;\u0010\t\u001a\u0004\u0018\u00010\u00012\b\u0010\u000e\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000f\u001a\u00020\b2\u0016\u0010\u0010\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0006\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0004\b\t\u0010\u0011J?\u0010\t\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u001e\u0010\u0007\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00020\u0006\"\b\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\t\u0010\u0013¨\u0006\u0016"}, d2 = {"Lbo/app/n4;", "", "Ljava/lang/Class;", "clazz", "", "methodName", "", "parameterTypes", "Ljava/lang/reflect/Method;", "a", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", "className", "b", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", "receiver", "method", "args", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;)Z", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class n4 {

    /* renamed from: a  reason: collision with root package name */
    public static final n4 f39043a = new n4();

    private n4() {
    }

    @JvmStatic
    public static final Method a(Class<?> cls, String str, Class<?>... clsArr) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        Intrinsics.checkNotNullParameter(str, HexAttribute.HEX_ATTR_METHOD_NAME);
        Intrinsics.checkNotNullParameter(clsArr, "parameterTypes");
        try {
            return cls.getMethod(str, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    @JvmStatic
    public static final Method b(String str, String str2, Class<?>... clsArr) {
        Intrinsics.checkNotNullParameter(str, HexAttribute.HEX_ATTR_CLASS_NAME);
        Intrinsics.checkNotNullParameter(str2, HexAttribute.HEX_ATTR_METHOD_NAME);
        Intrinsics.checkNotNullParameter(clsArr, "parameterTypes");
        try {
            Class<?> cls = Class.forName(str);
            Intrinsics.checkNotNullExpressionValue(cls, "clazz");
            return a(cls, str2, (Class<?>[]) (Class[]) Arrays.copyOf(clsArr, clsArr.length));
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    @JvmStatic
    public static final Object a(Object obj, Method method, Object... objArr) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(objArr, StepData.ARGS);
        try {
            return method.invoke(obj, Arrays.copyOf(objArr, objArr.length));
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    @JvmStatic
    public static final boolean a(String str, String str2, Class<?>... clsArr) {
        Intrinsics.checkNotNullParameter(str, HexAttribute.HEX_ATTR_CLASS_NAME);
        Intrinsics.checkNotNullParameter(str2, HexAttribute.HEX_ATTR_METHOD_NAME);
        Intrinsics.checkNotNullParameter(clsArr, "parameterTypes");
        return b(str, str2, (Class[]) Arrays.copyOf(clsArr, clsArr.length)) != null;
    }
}
