package kotlinx.serialization.descriptors;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptorKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SerialDescriptorImpl$_hashCode$2 extends Lambda implements Function0<Integer> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SerialDescriptorImpl f26404g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SerialDescriptorImpl$_hashCode$2(SerialDescriptorImpl serialDescriptorImpl) {
        super(0);
        this.f26404g = serialDescriptorImpl;
    }

    @NotNull
    public final Integer invoke() {
        SerialDescriptorImpl serialDescriptorImpl = this.f26404g;
        return Integer.valueOf(PluginGeneratedSerialDescriptorKt.hashCodeImpl(serialDescriptorImpl, serialDescriptorImpl.typeParametersDescriptors));
    }
}
