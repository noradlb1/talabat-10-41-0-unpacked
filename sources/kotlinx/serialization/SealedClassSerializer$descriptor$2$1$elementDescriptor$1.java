package kotlinx.serialization;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T", "", "Lkotlinx/serialization/descriptors/ClassSerialDescriptorBuilder;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SealedClassSerializer$descriptor$2$1$elementDescriptor$1 extends Lambda implements Function1<ClassSerialDescriptorBuilder, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ KSerializer<? extends T>[] f26403g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SealedClassSerializer$descriptor$2$1$elementDescriptor$1(KSerializer<? extends T>[] kSerializerArr) {
        super(1);
        this.f26403g = kSerializerArr;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ClassSerialDescriptorBuilder) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull ClassSerialDescriptorBuilder classSerialDescriptorBuilder) {
        Intrinsics.checkNotNullParameter(classSerialDescriptorBuilder, "$this$buildSerialDescriptor");
        for (KSerializer<? extends T> descriptor : this.f26403g) {
            SerialDescriptor descriptor2 = descriptor.getDescriptor();
            ClassSerialDescriptorBuilder.element$default(classSerialDescriptorBuilder, descriptor2.getSerialName(), descriptor2, (List) null, false, 12, (Object) null);
        }
    }
}
