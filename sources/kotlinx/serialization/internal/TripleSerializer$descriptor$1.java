package kotlinx.serialization.internal;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004*\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "A", "B", "C", "Lkotlinx/serialization/descriptors/ClassSerialDescriptorBuilder;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TripleSerializer$descriptor$1 extends Lambda implements Function1<ClassSerialDescriptorBuilder, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TripleSerializer<A, B, C> f26434g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TripleSerializer$descriptor$1(TripleSerializer<A, B, C> tripleSerializer) {
        super(1);
        this.f26434g = tripleSerializer;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ClassSerialDescriptorBuilder) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull ClassSerialDescriptorBuilder classSerialDescriptorBuilder) {
        Intrinsics.checkNotNullParameter(classSerialDescriptorBuilder, "$this$buildClassSerialDescriptor");
        ClassSerialDescriptorBuilder classSerialDescriptorBuilder2 = classSerialDescriptorBuilder;
        ClassSerialDescriptorBuilder.element$default(classSerialDescriptorBuilder2, "first", this.f26434g.aSerializer.getDescriptor(), (List) null, false, 12, (Object) null);
        ClassSerialDescriptorBuilder.element$default(classSerialDescriptorBuilder2, "second", this.f26434g.bSerializer.getDescriptor(), (List) null, false, 12, (Object) null);
        ClassSerialDescriptorBuilder.element$default(classSerialDescriptorBuilder2, "third", this.f26434g.cSerializer.getDescriptor(), (List) null, false, 12, (Object) null);
    }
}
