package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractLazyTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

public final class DeserializedTypeParameterDescriptor extends AbstractLazyTypeParameterDescriptor {
    @NotNull
    private final DeserializedAnnotations annotations;
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public final DeserializationContext f24915c;
    @NotNull
    private final ProtoBuf.TypeParameter proto;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DeserializedTypeParameterDescriptor(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r12, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter r13, int r14) {
        /*
            r11 = this;
            java.lang.String r0 = "c"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "proto"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            kotlin.reflect.jvm.internal.impl.storage.StorageManager r2 = r12.getStorageManager()
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r3 = r12.getContainingDeclaration()
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations$Companion r0 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r4 = r0.getEMPTY()
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver r0 = r12.getNameResolver()
            int r1 = r13.getName()
            kotlin.reflect.jvm.internal.impl.name.Name r5 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt.getName(r0, r1)
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlags r0 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlags.INSTANCE
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter$Variance r1 = r13.getVariance()
            java.lang.String r6 = "proto.variance"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r6)
            kotlin.reflect.jvm.internal.impl.types.Variance r6 = r0.variance((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter.Variance) r1)
            boolean r7 = r13.getReified()
            kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r9 = kotlin.reflect.jvm.internal.impl.descriptors.SourceElement.NO_SOURCE
            kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker$EMPTY r10 = kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker.EMPTY.INSTANCE
            r1 = r11
            r8 = r14
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r11.f24915c = r12
            r11.proto = r13
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedAnnotations r13 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedAnnotations
            kotlin.reflect.jvm.internal.impl.storage.StorageManager r12 = r12.getStorageManager()
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedTypeParameterDescriptor$annotations$1 r14 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedTypeParameterDescriptor$annotations$1
            r14.<init>(r11)
            r13.<init>(r12, r14)
            r11.annotations = r13
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedTypeParameterDescriptor.<init>(kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter, int):void");
    }

    @NotNull
    public List<KotlinType> b() {
        List<ProtoBuf.Type> upperBounds = ProtoTypeTableUtilKt.upperBounds(this.proto, this.f24915c.getTypeTable());
        if (upperBounds.isEmpty()) {
            return CollectionsKt__CollectionsJVMKt.listOf(DescriptorUtilsKt.getBuiltIns(this).getDefaultBound());
        }
        Iterable<ProtoBuf.Type> iterable = upperBounds;
        TypeDeserializer typeDeserializer = this.f24915c.getTypeDeserializer();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (ProtoBuf.Type type : iterable) {
            arrayList.add(typeDeserializer.type(type));
        }
        return arrayList;
    }

    @NotNull
    /* renamed from: c */
    public Void reportSupertypeLoopError(@NotNull KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "type");
        throw new IllegalStateException("There should be no cycles for deserialized type parameters, but found for: " + this);
    }

    @NotNull
    public final ProtoBuf.TypeParameter getProto() {
        return this.proto;
    }

    @NotNull
    public DeserializedAnnotations getAnnotations() {
        return this.annotations;
    }
}
