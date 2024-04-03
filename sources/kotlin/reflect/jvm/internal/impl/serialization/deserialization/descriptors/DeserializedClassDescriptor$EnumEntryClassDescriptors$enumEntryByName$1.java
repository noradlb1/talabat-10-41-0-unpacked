package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.EnumEntrySyntheticClassDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class DeserializedClassDescriptor$EnumEntryClassDescriptors$enumEntryByName$1 extends Lambda implements Function1<Name, ClassDescriptor> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DeserializedClassDescriptor.EnumEntryClassDescriptors f24874g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ DeserializedClassDescriptor f24875h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeserializedClassDescriptor$EnumEntryClassDescriptors$enumEntryByName$1(DeserializedClassDescriptor.EnumEntryClassDescriptors enumEntryClassDescriptors, DeserializedClassDescriptor deserializedClassDescriptor) {
        super(1);
        this.f24874g = enumEntryClassDescriptors;
        this.f24875h = deserializedClassDescriptor;
    }

    @Nullable
    public final ClassDescriptor invoke(@NotNull Name name2) {
        Intrinsics.checkNotNullParameter(name2, "name");
        ProtoBuf.EnumEntry enumEntry = (ProtoBuf.EnumEntry) this.f24874g.enumEntryProtos.get(name2);
        if (enumEntry == null) {
            return null;
        }
        DeserializedClassDescriptor deserializedClassDescriptor = this.f24875h;
        DeserializedClassDescriptor.EnumEntryClassDescriptors enumEntryClassDescriptors = this.f24874g;
        return EnumEntrySyntheticClassDescriptor.create(deserializedClassDescriptor.getC().getStorageManager(), deserializedClassDescriptor, name2, enumEntryClassDescriptors.enumMemberNames, new DeserializedAnnotations(deserializedClassDescriptor.getC().getStorageManager(), new DeserializedClassDescriptor$EnumEntryClassDescriptors$enumEntryByName$1$1$1(deserializedClassDescriptor, enumEntry)), SourceElement.NO_SOURCE);
    }
}
