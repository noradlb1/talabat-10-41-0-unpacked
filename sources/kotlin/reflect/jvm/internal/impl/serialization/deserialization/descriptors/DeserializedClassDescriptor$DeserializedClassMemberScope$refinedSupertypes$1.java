package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Collection;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

public final class DeserializedClassDescriptor$DeserializedClassMemberScope$refinedSupertypes$1 extends Lambda implements Function0<Collection<? extends KotlinType>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DeserializedClassDescriptor.DeserializedClassMemberScope f24870g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeserializedClassDescriptor$DeserializedClassMemberScope$refinedSupertypes$1(DeserializedClassDescriptor.DeserializedClassMemberScope deserializedClassMemberScope) {
        super(0);
        this.f24870g = deserializedClassMemberScope;
    }

    @NotNull
    public final Collection<KotlinType> invoke() {
        return this.f24870g.kotlinTypeRefiner.refineSupertypes(this.f24870g.getClassDescriptor());
    }
}
