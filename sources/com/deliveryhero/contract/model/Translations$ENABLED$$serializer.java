package com.deliveryhero.contract.model;

import com.deliveryhero.contract.model.Translations;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/deliveryhero/contract/model/Translations.ENABLED.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/deliveryhero/contract/model/Translations$ENABLED;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class Translations$ENABLED$$serializer implements GeneratedSerializer<Translations.ENABLED> {
    @NotNull
    public static final Translations$ENABLED$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    static {
        Translations$ENABLED$$serializer translations$ENABLED$$serializer = new Translations$ENABLED$$serializer();
        INSTANCE = translations$ENABLED$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.deliveryhero.contract.model.Translations.ENABLED", translations$ENABLED$$serializer, 5);
        pluginGeneratedSerialDescriptor.addElement("supportedTranslationsList", false);
        pluginGeneratedSerialDescriptor.addElement("shouldShowOriginalWithTranslated", false);
        pluginGeneratedSerialDescriptor.addElement("supportedTranslations", false);
        pluginGeneratedSerialDescriptor.addElement("preferredLanguage", false);
        pluginGeneratedSerialDescriptor.addElement("showOriginalWithTranslated", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private Translations$ENABLED$$serializer() {
    }

    @NotNull
    public KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        BooleanSerializer booleanSerializer = BooleanSerializer.INSTANCE;
        return new KSerializer[]{new ArrayListSerializer(stringSerializer), booleanSerializer, new ArrayListSerializer(stringSerializer), stringSerializer, booleanSerializer};
    }

    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.deliveryhero.contract.model.Translations.ENABLED deserialize(@org.jetbrains.annotations.NotNull kotlinx.serialization.encoding.Decoder r17) {
        /*
            r16 = this;
            r0 = r17
            java.lang.String r1 = "decoder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            kotlinx.serialization.descriptors.SerialDescriptor r1 = r16.getDescriptor()
            kotlinx.serialization.encoding.CompositeDecoder r0 = r0.beginStructure(r1)
            boolean r2 = r0.decodeSequentially()
            r3 = 3
            r4 = 4
            r5 = 2
            r6 = 1
            r7 = 0
            r8 = 0
            if (r2 == 0) goto L_0x0042
            kotlinx.serialization.internal.ArrayListSerializer r2 = new kotlinx.serialization.internal.ArrayListSerializer
            kotlinx.serialization.internal.StringSerializer r9 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            r2.<init>(r9)
            java.lang.Object r2 = r0.decodeSerializableElement(r1, r7, r2, r8)
            boolean r6 = r0.decodeBooleanElement(r1, r6)
            kotlinx.serialization.internal.ArrayListSerializer r7 = new kotlinx.serialization.internal.ArrayListSerializer
            r7.<init>(r9)
            java.lang.Object r5 = r0.decodeSerializableElement(r1, r5, r7, r8)
            java.lang.String r3 = r0.decodeStringElement(r1, r3)
            boolean r4 = r0.decodeBooleanElement(r1, r4)
            r7 = 31
            r8 = r3
            r9 = r4
            r4 = r7
            goto L_0x009b
        L_0x0042:
            r13 = r6
            r2 = r7
            r9 = r2
            r10 = r8
            r11 = r10
            r12 = r11
            r8 = r9
        L_0x0049:
            if (r13 == 0) goto L_0x0095
            int r14 = r0.decodeElementIndex(r1)
            r15 = -1
            if (r14 == r15) goto L_0x0093
            if (r14 == 0) goto L_0x0085
            if (r14 == r6) goto L_0x007e
            if (r14 == r5) goto L_0x0070
            if (r14 == r3) goto L_0x0069
            if (r14 != r4) goto L_0x0063
            boolean r2 = r0.decodeBooleanElement(r1, r4)
            r9 = r9 | 16
            goto L_0x0049
        L_0x0063:
            kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
            r0.<init>((int) r14)
            throw r0
        L_0x0069:
            java.lang.String r12 = r0.decodeStringElement(r1, r3)
            r9 = r9 | 8
            goto L_0x0049
        L_0x0070:
            kotlinx.serialization.internal.ArrayListSerializer r14 = new kotlinx.serialization.internal.ArrayListSerializer
            kotlinx.serialization.internal.StringSerializer r15 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            r14.<init>(r15)
            java.lang.Object r11 = r0.decodeSerializableElement(r1, r5, r14, r11)
            r9 = r9 | 4
            goto L_0x0049
        L_0x007e:
            boolean r8 = r0.decodeBooleanElement(r1, r6)
            r9 = r9 | 2
            goto L_0x0049
        L_0x0085:
            kotlinx.serialization.internal.ArrayListSerializer r14 = new kotlinx.serialization.internal.ArrayListSerializer
            kotlinx.serialization.internal.StringSerializer r15 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            r14.<init>(r15)
            java.lang.Object r10 = r0.decodeSerializableElement(r1, r7, r14, r10)
            r9 = r9 | 1
            goto L_0x0049
        L_0x0093:
            r13 = r7
            goto L_0x0049
        L_0x0095:
            r6 = r8
            r4 = r9
            r5 = r11
            r8 = r12
            r9 = r2
            r2 = r10
        L_0x009b:
            r0.endStructure(r1)
            com.deliveryhero.contract.model.Translations$ENABLED r0 = new com.deliveryhero.contract.model.Translations$ENABLED
            r1 = r2
            java.util.List r1 = (java.util.List) r1
            r7 = r5
            java.util.List r7 = (java.util.List) r7
            r10 = 0
            r3 = r0
            r5 = r1
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.contract.model.Translations$ENABLED$$serializer.deserialize(kotlinx.serialization.encoding.Decoder):com.deliveryhero.contract.model.Translations$ENABLED");
    }

    @NotNull
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public void serialize(@NotNull Encoder encoder, @NotNull Translations.ENABLED enabled) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(enabled, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        Translations.ENABLED.write$Self(enabled, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @NotNull
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
