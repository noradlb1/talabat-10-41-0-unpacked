package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Field;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;

public /* synthetic */ class ReflectJavaClass$fields$2 extends FunctionReference implements Function1<Field, ReflectJavaField> {
    public static final ReflectJavaClass$fields$2 INSTANCE = new ReflectJavaClass$fields$2();

    public ReflectJavaClass$fields$2() {
        super(1);
    }

    @NotNull
    public final String getName() {
        return MethodDescription.CONSTRUCTOR_INTERNAL_NAME;
    }

    @NotNull
    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(ReflectJavaField.class);
    }

    @NotNull
    public final String getSignature() {
        return "<init>(Ljava/lang/reflect/Field;)V";
    }

    @NotNull
    public final ReflectJavaField invoke(@NotNull Field field) {
        Intrinsics.checkNotNullParameter(field, "p0");
        return new ReflectJavaField(field);
    }
}
