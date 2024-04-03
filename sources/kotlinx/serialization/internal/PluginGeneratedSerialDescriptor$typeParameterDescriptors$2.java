package kotlinx.serialization.internal;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "invoke", "()[Lkotlinx/serialization/descriptors/SerialDescriptor;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class PluginGeneratedSerialDescriptor$typeParameterDescriptors$2 extends Lambda implements Function0<SerialDescriptor[]> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ PluginGeneratedSerialDescriptor f26427g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PluginGeneratedSerialDescriptor$typeParameterDescriptors$2(PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor) {
        super(0);
        this.f26427g = pluginGeneratedSerialDescriptor;
    }

    @NotNull
    public final SerialDescriptor[] invoke() {
        ArrayList arrayList;
        KSerializer[] typeParametersSerializers;
        GeneratedSerializer access$getGeneratedSerializer$p = this.f26427g.generatedSerializer;
        if (access$getGeneratedSerializer$p == null || (typeParametersSerializers = access$getGeneratedSerializer$p.typeParametersSerializers()) == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList(typeParametersSerializers.length);
            for (KSerializer descriptor : typeParametersSerializers) {
                arrayList.add(descriptor.getDescriptor());
            }
        }
        return Platform_commonKt.compactArray(arrayList);
    }
}
