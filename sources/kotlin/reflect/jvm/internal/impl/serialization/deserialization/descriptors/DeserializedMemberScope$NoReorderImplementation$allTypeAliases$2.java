package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope;
import org.jetbrains.annotations.NotNull;

public final class DeserializedMemberScope$NoReorderImplementation$allTypeAliases$2 extends Lambda implements Function0<List<? extends TypeAliasDescriptor>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DeserializedMemberScope.NoReorderImplementation f24891g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeserializedMemberScope$NoReorderImplementation$allTypeAliases$2(DeserializedMemberScope.NoReorderImplementation noReorderImplementation) {
        super(0);
        this.f24891g = noReorderImplementation;
    }

    @NotNull
    public final List<TypeAliasDescriptor> invoke() {
        return this.f24891g.computeTypeAliases();
    }
}
