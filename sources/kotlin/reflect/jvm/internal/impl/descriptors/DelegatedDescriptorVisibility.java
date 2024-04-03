package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.implementation.MethodDelegation;
import org.jetbrains.annotations.NotNull;

public abstract class DelegatedDescriptorVisibility extends DescriptorVisibility {
    @NotNull
    private final Visibility delegate;

    public DelegatedDescriptorVisibility(@NotNull Visibility visibility) {
        Intrinsics.checkNotNullParameter(visibility, MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX);
        this.delegate = visibility;
    }

    @NotNull
    public Visibility getDelegate() {
        return this.delegate;
    }

    @NotNull
    public String getInternalDisplayName() {
        return getDelegate().getInternalDisplayName();
    }

    @NotNull
    public DescriptorVisibility normalize() {
        DescriptorVisibility descriptorVisibility = DescriptorVisibilities.toDescriptorVisibility(getDelegate().normalize());
        Intrinsics.checkNotNullExpressionValue(descriptorVisibility, "toDescriptorVisibility(delegate.normalize())");
        return descriptorVisibility;
    }
}
