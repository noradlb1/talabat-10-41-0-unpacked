package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Collection;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import org.jetbrains.annotations.NotNull;

public final class DeserializedClassDescriptor$sealedSubclasses$1 extends Lambda implements Function0<Collection<? extends ClassDescriptor>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DeserializedClassDescriptor f24883g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeserializedClassDescriptor$sealedSubclasses$1(DeserializedClassDescriptor deserializedClassDescriptor) {
        super(0);
        this.f24883g = deserializedClassDescriptor;
    }

    @NotNull
    public final Collection<ClassDescriptor> invoke() {
        return this.f24883g.computeSubclassesForSealedClass();
    }
}
