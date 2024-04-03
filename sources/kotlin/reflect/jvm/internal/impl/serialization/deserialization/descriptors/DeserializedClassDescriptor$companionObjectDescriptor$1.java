package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import org.jetbrains.annotations.Nullable;

public final class DeserializedClassDescriptor$companionObjectDescriptor$1 extends Lambda implements Function0<ClassDescriptor> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DeserializedClassDescriptor f24880g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeserializedClassDescriptor$companionObjectDescriptor$1(DeserializedClassDescriptor deserializedClassDescriptor) {
        super(0);
        this.f24880g = deserializedClassDescriptor;
    }

    @Nullable
    public final ClassDescriptor invoke() {
        return this.f24880g.computeCompanionObjectDescriptor();
    }
}
