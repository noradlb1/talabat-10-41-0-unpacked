package kotlinx.serialization.internal;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.StructureKind;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T", "", "Lkotlinx/serialization/descriptors/ClassSerialDescriptorBuilder;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class EnumSerializer$descriptor$1 extends Lambda implements Function1<ClassSerialDescriptorBuilder, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ EnumSerializer<T> f26414g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f26415h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EnumSerializer$descriptor$1(EnumSerializer<T> enumSerializer, String str) {
        super(1);
        this.f26414g = enumSerializer;
        this.f26415h = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ClassSerialDescriptorBuilder) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull ClassSerialDescriptorBuilder classSerialDescriptorBuilder) {
        Intrinsics.checkNotNullParameter(classSerialDescriptorBuilder, "$this$buildSerialDescriptor");
        Enum[] access$getValues$p = this.f26414g.values;
        String str = this.f26415h;
        for (Enum enumR : access$getValues$p) {
            ClassSerialDescriptorBuilder.element$default(classSerialDescriptorBuilder, enumR.name(), SerialDescriptorsKt.buildSerialDescriptor$default(str + '.' + enumR.name(), StructureKind.OBJECT.INSTANCE, new SerialDescriptor[0], (Function1) null, 8, (Object) null), (List) null, false, 12, (Object) null);
        }
    }
}
