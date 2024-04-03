package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import org.jetbrains.annotations.NotNull;

public final class DeserializedClassDescriptor$EnumEntryClassDescriptors$enumMemberNames$1 extends Lambda implements Function0<Set<? extends Name>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DeserializedClassDescriptor.EnumEntryClassDescriptors f24878g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeserializedClassDescriptor$EnumEntryClassDescriptors$enumMemberNames$1(DeserializedClassDescriptor.EnumEntryClassDescriptors enumEntryClassDescriptors) {
        super(0);
        this.f24878g = enumEntryClassDescriptors;
    }

    @NotNull
    public final Set<Name> invoke() {
        return this.f24878g.computeEnumMemberNames();
    }
}
