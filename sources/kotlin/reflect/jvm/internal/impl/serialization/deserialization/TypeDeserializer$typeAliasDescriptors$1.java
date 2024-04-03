package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import org.jetbrains.annotations.Nullable;

public final class TypeDeserializer$typeAliasDescriptors$1 extends Lambda implements Function1<Integer, ClassifierDescriptor> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TypeDeserializer f24862g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TypeDeserializer$typeAliasDescriptors$1(TypeDeserializer typeDeserializer) {
        super(1);
        this.f24862g = typeDeserializer;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }

    @Nullable
    public final ClassifierDescriptor invoke(int i11) {
        return this.f24862g.computeTypeAliasDescriptor(i11);
    }
}
