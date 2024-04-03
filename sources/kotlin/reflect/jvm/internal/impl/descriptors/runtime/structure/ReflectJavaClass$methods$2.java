package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Method;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;

public /* synthetic */ class ReflectJavaClass$methods$2 extends FunctionReference implements Function1<Method, ReflectJavaMethod> {
    public static final ReflectJavaClass$methods$2 INSTANCE = new ReflectJavaClass$methods$2();

    public ReflectJavaClass$methods$2() {
        super(1);
    }

    @NotNull
    public final String getName() {
        return MethodDescription.CONSTRUCTOR_INTERNAL_NAME;
    }

    @NotNull
    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(ReflectJavaMethod.class);
    }

    @NotNull
    public final String getSignature() {
        return "<init>(Ljava/lang/reflect/Method;)V";
    }

    @NotNull
    public final ReflectJavaMethod invoke(@NotNull Method method) {
        Intrinsics.checkNotNullParameter(method, "p0");
        return new ReflectJavaMethod(method);
    }
}
