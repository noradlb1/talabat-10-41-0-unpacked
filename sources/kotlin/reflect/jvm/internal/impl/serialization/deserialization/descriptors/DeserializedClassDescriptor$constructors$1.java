package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Collection;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import org.jetbrains.annotations.NotNull;

public final class DeserializedClassDescriptor$constructors$1 extends Lambda implements Function0<Collection<? extends ClassConstructorDescriptor>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DeserializedClassDescriptor f24881g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeserializedClassDescriptor$constructors$1(DeserializedClassDescriptor deserializedClassDescriptor) {
        super(0);
        this.f24881g = deserializedClassDescriptor;
    }

    @NotNull
    public final Collection<ClassConstructorDescriptor> invoke() {
        return this.f24881g.computeConstructors();
    }
}
