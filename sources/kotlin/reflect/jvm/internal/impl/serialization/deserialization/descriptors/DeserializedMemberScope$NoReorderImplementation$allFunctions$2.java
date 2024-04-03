package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope;
import org.jetbrains.annotations.NotNull;

public final class DeserializedMemberScope$NoReorderImplementation$allFunctions$2 extends Lambda implements Function0<List<? extends SimpleFunctionDescriptor>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DeserializedMemberScope.NoReorderImplementation f24889g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeserializedMemberScope$NoReorderImplementation$allFunctions$2(DeserializedMemberScope.NoReorderImplementation noReorderImplementation) {
        super(0);
        this.f24889g = noReorderImplementation;
    }

    @NotNull
    public final List<SimpleFunctionDescriptor> invoke() {
        return CollectionsKt___CollectionsKt.plus(this.f24889g.getDeclaredFunctions(), this.f24889g.computeAllNonDeclaredFunctions());
    }
}
