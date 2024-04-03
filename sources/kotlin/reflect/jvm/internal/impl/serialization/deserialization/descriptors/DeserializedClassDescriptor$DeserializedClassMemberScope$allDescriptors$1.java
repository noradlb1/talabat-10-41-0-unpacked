package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Collection;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import org.jetbrains.annotations.NotNull;

public final class DeserializedClassDescriptor$DeserializedClassMemberScope$allDescriptors$1 extends Lambda implements Function0<Collection<? extends DeclarationDescriptor>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DeserializedClassDescriptor.DeserializedClassMemberScope f24868g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeserializedClassDescriptor$DeserializedClassMemberScope$allDescriptors$1(DeserializedClassDescriptor.DeserializedClassMemberScope deserializedClassMemberScope) {
        super(0);
        this.f24868g = deserializedClassMemberScope;
    }

    @NotNull
    public final Collection<DeclarationDescriptor> invoke() {
        return this.f24868g.b(DescriptorKindFilter.ALL, MemberScope.Companion.getALL_NAME_FILTER(), NoLookupLocation.WHEN_GET_ALL_DESCRIPTORS);
    }
}
