package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Constructor;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;

public /* synthetic */ class ReflectJavaClass$constructors$2 extends FunctionReference implements Function1<Constructor<?>, ReflectJavaConstructor> {
    public static final ReflectJavaClass$constructors$2 INSTANCE = new ReflectJavaClass$constructors$2();

    public ReflectJavaClass$constructors$2() {
        super(1);
    }

    @NotNull
    public final String getName() {
        return MethodDescription.CONSTRUCTOR_INTERNAL_NAME;
    }

    @NotNull
    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(ReflectJavaConstructor.class);
    }

    @NotNull
    public final String getSignature() {
        return "<init>(Ljava/lang/reflect/Constructor;)V";
    }

    @NotNull
    public final ReflectJavaConstructor invoke(@NotNull Constructor<?> constructor) {
        Intrinsics.checkNotNullParameter(constructor, "p0");
        return new ReflectJavaConstructor(constructor);
    }
}
