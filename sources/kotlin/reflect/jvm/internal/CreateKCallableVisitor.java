package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorVisitorEmptyBodies;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0010\u0018\u00002\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J!\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0002\u0010\u000bJ!\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\b\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lkotlin/reflect/jvm/internal/CreateKCallableVisitor;", "Lkotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorVisitorEmptyBodies;", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;)V", "visitFunctionDescriptor", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "data", "(Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;Lkotlin/Unit;)Lkotlin/reflect/jvm/internal/KCallableImpl;", "visitPropertyDescriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "(Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;Lkotlin/Unit;)Lkotlin/reflect/jvm/internal/KCallableImpl;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class CreateKCallableVisitor extends DeclarationDescriptorVisitorEmptyBodies<KCallableImpl<?>, Unit> {
    @NotNull
    private final KDeclarationContainerImpl container;

    public CreateKCallableVisitor(@NotNull KDeclarationContainerImpl kDeclarationContainerImpl) {
        Intrinsics.checkNotNullParameter(kDeclarationContainerImpl, TtmlNode.RUBY_CONTAINER);
        this.container = kDeclarationContainerImpl;
    }

    @NotNull
    public KCallableImpl<?> visitFunctionDescriptor(@NotNull FunctionDescriptor functionDescriptor, @NotNull Unit unit) {
        Intrinsics.checkNotNullParameter(functionDescriptor, "descriptor");
        Intrinsics.checkNotNullParameter(unit, "data");
        return new KFunctionImpl(this.container, functionDescriptor);
    }

    @NotNull
    public KCallableImpl<?> visitPropertyDescriptor(@NotNull PropertyDescriptor propertyDescriptor, @NotNull Unit unit) {
        Intrinsics.checkNotNullParameter(propertyDescriptor, "descriptor");
        Intrinsics.checkNotNullParameter(unit, "data");
        int i11 = 0;
        int i12 = propertyDescriptor.getDispatchReceiverParameter() != null ? 1 : 0;
        if (propertyDescriptor.getExtensionReceiverParameter() != null) {
            i11 = 1;
        }
        int i13 = i12 + i11;
        if (propertyDescriptor.isVar()) {
            if (i13 == 0) {
                return new KMutableProperty0Impl(this.container, propertyDescriptor);
            }
            if (i13 == 1) {
                return new KMutableProperty1Impl(this.container, propertyDescriptor);
            }
            if (i13 == 2) {
                return new KMutableProperty2Impl(this.container, propertyDescriptor);
            }
        } else if (i13 == 0) {
            return new KProperty0Impl(this.container, propertyDescriptor);
        } else {
            if (i13 == 1) {
                return new KProperty1Impl(this.container, propertyDescriptor);
            }
            if (i13 == 2) {
                return new KProperty2Impl(this.container, propertyDescriptor);
            }
        }
        throw new KotlinReflectionInternalError("Unsupported property: " + propertyDescriptor);
    }
}
