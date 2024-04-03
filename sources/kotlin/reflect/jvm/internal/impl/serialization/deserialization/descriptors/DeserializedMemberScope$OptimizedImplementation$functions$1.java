package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope;
import org.jetbrains.annotations.NotNull;

public final class DeserializedMemberScope$OptimizedImplementation$functions$1 extends Lambda implements Function1<Name, Collection<? extends SimpleFunctionDescriptor>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DeserializedMemberScope.OptimizedImplementation f24908g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeserializedMemberScope$OptimizedImplementation$functions$1(DeserializedMemberScope.OptimizedImplementation optimizedImplementation) {
        super(1);
        this.f24908g = optimizedImplementation;
    }

    @NotNull
    public final Collection<SimpleFunctionDescriptor> invoke(@NotNull Name name2) {
        Intrinsics.checkNotNullParameter(name2, "it");
        return this.f24908g.computeFunctions(name2);
    }
}
