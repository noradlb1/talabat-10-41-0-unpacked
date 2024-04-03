package kotlinx.serialization;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Typography;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.SerialKind;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "T", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SealedClassSerializer$descriptor$2 extends Lambda implements Function0<SerialDescriptor> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f26398g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ SealedClassSerializer<T> f26399h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ KSerializer<? extends T>[] f26400i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SealedClassSerializer$descriptor$2(String str, SealedClassSerializer<T> sealedClassSerializer, KSerializer<? extends T>[] kSerializerArr) {
        super(0);
        this.f26398g = str;
        this.f26399h = sealedClassSerializer;
        this.f26400i = kSerializerArr;
    }

    @NotNull
    public final SerialDescriptor invoke() {
        final SealedClassSerializer<T> sealedClassSerializer = this.f26399h;
        final KSerializer<? extends T>[] kSerializerArr = this.f26400i;
        return SerialDescriptorsKt.buildSerialDescriptor(this.f26398g, PolymorphicKind.SEALED.INSTANCE, new SerialDescriptor[0], new Function1<ClassSerialDescriptorBuilder, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ClassSerialDescriptorBuilder) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull ClassSerialDescriptorBuilder classSerialDescriptorBuilder) {
                Intrinsics.checkNotNullParameter(classSerialDescriptorBuilder, "$this$buildSerialDescriptor");
                ClassSerialDescriptorBuilder.element$default(classSerialDescriptorBuilder, "type", BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE).getDescriptor(), (List) null, false, 12, (Object) null);
                ClassSerialDescriptorBuilder.element$default(classSerialDescriptorBuilder, "value", SerialDescriptorsKt.buildSerialDescriptor("kotlinx.serialization.Sealed<" + sealedClassSerializer.getBaseClass().getSimpleName() + Typography.greater, SerialKind.CONTEXTUAL.INSTANCE, new SerialDescriptor[0], new SealedClassSerializer$descriptor$2$1$elementDescriptor$1(kSerializerArr)), (List) null, false, 12, (Object) null);
                classSerialDescriptorBuilder.setAnnotations(sealedClassSerializer._annotations);
            }
        });
    }
}
