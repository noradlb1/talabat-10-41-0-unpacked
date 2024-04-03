package kotlinx.serialization.internal;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "K", "V", "Lkotlinx/serialization/descriptors/ClassSerialDescriptorBuilder;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class MapEntrySerializer$descriptor$1 extends Lambda implements Function1<ClassSerialDescriptorBuilder, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ KSerializer<K> f26417g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ KSerializer<V> f26418h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MapEntrySerializer$descriptor$1(KSerializer<K> kSerializer, KSerializer<V> kSerializer2) {
        super(1);
        this.f26417g = kSerializer;
        this.f26418h = kSerializer2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ClassSerialDescriptorBuilder) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull ClassSerialDescriptorBuilder classSerialDescriptorBuilder) {
        Intrinsics.checkNotNullParameter(classSerialDescriptorBuilder, "$this$buildSerialDescriptor");
        ClassSerialDescriptorBuilder classSerialDescriptorBuilder2 = classSerialDescriptorBuilder;
        ClassSerialDescriptorBuilder.element$default(classSerialDescriptorBuilder2, "key", this.f26417g.getDescriptor(), (List) null, false, 12, (Object) null);
        ClassSerialDescriptorBuilder.element$default(classSerialDescriptorBuilder2, "value", this.f26418h.getDescriptor(), (List) null, false, 12, (Object) null);
    }
}
