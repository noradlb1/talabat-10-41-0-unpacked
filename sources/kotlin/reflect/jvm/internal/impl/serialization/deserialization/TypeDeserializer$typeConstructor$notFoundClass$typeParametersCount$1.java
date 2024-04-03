package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class TypeDeserializer$typeConstructor$notFoundClass$typeParametersCount$1 extends Lambda implements Function1<ProtoBuf.Type, ProtoBuf.Type> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TypeDeserializer f24863g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TypeDeserializer$typeConstructor$notFoundClass$typeParametersCount$1(TypeDeserializer typeDeserializer) {
        super(1);
        this.f24863g = typeDeserializer;
    }

    @Nullable
    public final ProtoBuf.Type invoke(@NotNull ProtoBuf.Type type) {
        Intrinsics.checkNotNullParameter(type, "it");
        return ProtoTypeTableUtilKt.outerType(type, this.f24863g.f24858c.getTypeTable());
    }
}
