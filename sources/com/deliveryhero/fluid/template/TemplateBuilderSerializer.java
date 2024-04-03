package com.deliveryhero.fluid.template;

import com.deliveryhero.fluid.template.data.TemplateUiDataBuilder;
import com.deliveryhero.fluid.widgets.WidgetModelBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0002H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00050\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/deliveryhero/fluid/template/TemplateBuilderSerializer;", "Lkotlinx/serialization/KSerializer;", "Lcom/deliveryhero/fluid/template/TemplateBuilder;", "()V", "delegateSerializer", "Lcom/deliveryhero/fluid/widgets/WidgetModelBuilder;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "builder", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TemplateBuilderSerializer implements KSerializer<TemplateBuilder> {
    @NotNull
    private final KSerializer<WidgetModelBuilder> delegateSerializer;
    @NotNull
    private final SerialDescriptor descriptor;

    public TemplateBuilderSerializer() {
        KSerializer<WidgetModelBuilder> serializer = WidgetModelBuilder.Companion.serializer();
        this.delegateSerializer = serializer;
        this.descriptor = SerialDescriptorsKt.SerialDescriptor("Template", serializer.getDescriptor());
    }

    @NotNull
    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    @NotNull
    public TemplateBuilder deserialize(@NotNull Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        WidgetModelBuilder widgetModelBuilder = (WidgetModelBuilder) decoder.decodeSerializableValue(this.delegateSerializer);
        String id$core_release = widgetModelBuilder.getId$core_release();
        Intrinsics.checkNotNull(id$core_release);
        String hash$core_release = widgetModelBuilder.getHash$core_release();
        Intrinsics.checkNotNull(hash$core_release);
        return new TemplateBuilder(id$core_release, hash$core_release, widgetModelBuilder, (TemplateUiDataBuilder) null, 8, (DefaultConstructorMarker) null);
    }

    public void serialize(@NotNull Encoder encoder, @NotNull TemplateBuilder templateBuilder) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(templateBuilder, "builder");
        encoder.encodeSerializableValue(this.delegateSerializer, templateBuilder.getWidget());
    }
}
