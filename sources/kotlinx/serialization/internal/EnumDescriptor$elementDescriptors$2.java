package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.StructureKind;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "invoke", "()[Lkotlinx/serialization/descriptors/SerialDescriptor;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class EnumDescriptor$elementDescriptors$2 extends Lambda implements Function0<SerialDescriptor[]> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f26411g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f26412h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ EnumDescriptor f26413i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EnumDescriptor$elementDescriptors$2(int i11, String str, EnumDescriptor enumDescriptor) {
        super(0);
        this.f26411g = i11;
        this.f26412h = str;
        this.f26413i = enumDescriptor;
    }

    @NotNull
    public final SerialDescriptor[] invoke() {
        int i11 = this.f26411g;
        SerialDescriptor[] serialDescriptorArr = new SerialDescriptor[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            serialDescriptorArr[i12] = SerialDescriptorsKt.buildSerialDescriptor$default(this.f26412h + '.' + this.f26413i.getElementName(i12), StructureKind.OBJECT.INSTANCE, new SerialDescriptor[0], (Function1) null, 8, (Object) null);
        }
        return serialDescriptorArr;
    }
}
