package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.utils.DFS;
import org.jetbrains.annotations.NotNull;

public final class JvmBuiltInsCustomizer$isMutabilityViolation$1<N> implements DFS.Neighbors {
    public static final JvmBuiltInsCustomizer$isMutabilityViolation$1<N> INSTANCE = new JvmBuiltInsCustomizer$isMutabilityViolation$1<>();

    @NotNull
    public final Iterable<CallableMemberDescriptor> getNeighbors(CallableMemberDescriptor callableMemberDescriptor) {
        return callableMemberDescriptor.getOriginal().getOverriddenDescriptors();
    }
}
