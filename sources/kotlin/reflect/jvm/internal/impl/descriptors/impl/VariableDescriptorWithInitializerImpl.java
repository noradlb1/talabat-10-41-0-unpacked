package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class VariableDescriptorWithInitializerImpl extends VariableDescriptorImpl {

    /* renamed from: d  reason: collision with root package name */
    public NullableLazyValue<ConstantValue<?>> f24561d;

    /* renamed from: e  reason: collision with root package name */
    public Function0<NullableLazyValue<ConstantValue<?>>> f24562e;
    private final boolean isVar;

    private static /* synthetic */ void $$$reportNull$$$0(int i11) {
        Object[] objArr = new Object[3];
        if (i11 == 1) {
            objArr[0] = "annotations";
        } else if (i11 == 2) {
            objArr[0] = "name";
        } else if (i11 == 3) {
            objArr[0] = "source";
        } else if (i11 == 4 || i11 == 5) {
            objArr[0] = "compileTimeInitializerFactory";
        } else {
            objArr[0] = "containingDeclaration";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorWithInitializerImpl";
        if (i11 == 4) {
            objArr[2] = "setCompileTimeInitializerFactory";
        } else if (i11 != 5) {
            objArr[2] = MethodDescription.CONSTRUCTOR_INTERNAL_NAME;
        } else {
            objArr[2] = "setCompileTimeInitializer";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VariableDescriptorWithInitializerImpl(@NotNull DeclarationDescriptor declarationDescriptor, @NotNull Annotations annotations, @NotNull Name name2, @Nullable KotlinType kotlinType, boolean z11, @NotNull SourceElement sourceElement) {
        super(declarationDescriptor, annotations, name2, kotlinType, sourceElement);
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(0);
        }
        if (annotations == null) {
            $$$reportNull$$$0(1);
        }
        if (name2 == null) {
            $$$reportNull$$$0(2);
        }
        if (sourceElement == null) {
            $$$reportNull$$$0(3);
        }
        this.isVar = z11;
    }

    @Nullable
    public ConstantValue<?> getCompileTimeInitializer() {
        NullableLazyValue<ConstantValue<?>> nullableLazyValue = this.f24561d;
        if (nullableLazyValue != null) {
            return (ConstantValue) nullableLazyValue.invoke();
        }
        return null;
    }

    public boolean isVar() {
        return this.isVar;
    }

    public void setCompileTimeInitializer(@Nullable NullableLazyValue<ConstantValue<?>> nullableLazyValue, @NotNull Function0<NullableLazyValue<ConstantValue<?>>> function0) {
        if (function0 == null) {
            $$$reportNull$$$0(5);
        }
        this.f24562e = function0;
        if (nullableLazyValue == null) {
            nullableLazyValue = function0.invoke();
        }
        this.f24561d = nullableLazyValue;
    }

    public void setCompileTimeInitializerFactory(@NotNull Function0<NullableLazyValue<ConstantValue<?>>> function0) {
        if (function0 == null) {
            $$$reportNull$$$0(4);
        }
        setCompileTimeInitializer((NullableLazyValue<ConstantValue<?>>) null, function0);
    }
}
