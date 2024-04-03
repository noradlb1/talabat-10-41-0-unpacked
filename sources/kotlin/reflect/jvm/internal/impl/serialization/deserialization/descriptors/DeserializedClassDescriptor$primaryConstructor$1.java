package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import org.jetbrains.annotations.Nullable;

public final class DeserializedClassDescriptor$primaryConstructor$1 extends Lambda implements Function0<ClassConstructorDescriptor> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DeserializedClassDescriptor f24882g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeserializedClassDescriptor$primaryConstructor$1(DeserializedClassDescriptor deserializedClassDescriptor) {
        super(0);
        this.f24882g = deserializedClassDescriptor;
    }

    @Nullable
    public final ClassConstructorDescriptor invoke() {
        return this.f24882g.computePrimaryConstructor();
    }
}
