package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.StructureKind;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "T", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ObjectSerializer$descriptor$2 extends Lambda implements Function0<SerialDescriptor> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f26419g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ ObjectSerializer<T> f26420h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ObjectSerializer$descriptor$2(String str, ObjectSerializer<T> objectSerializer) {
        super(0);
        this.f26419g = str;
        this.f26420h = objectSerializer;
    }

    @NotNull
    public final SerialDescriptor invoke() {
        final ObjectSerializer<T> objectSerializer = this.f26420h;
        return SerialDescriptorsKt.buildSerialDescriptor(this.f26419g, StructureKind.OBJECT.INSTANCE, new SerialDescriptor[0], new Function1<ClassSerialDescriptorBuilder, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ClassSerialDescriptorBuilder) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull ClassSerialDescriptorBuilder classSerialDescriptorBuilder) {
                Intrinsics.checkNotNullParameter(classSerialDescriptorBuilder, "$this$buildSerialDescriptor");
                classSerialDescriptorBuilder.setAnnotations(objectSerializer._annotations);
            }
        });
    }
}
