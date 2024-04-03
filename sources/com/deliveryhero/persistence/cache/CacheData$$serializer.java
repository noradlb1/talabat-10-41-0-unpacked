package com.deliveryhero.persistence.cache;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.json.JsonNames;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000*\u0004\b\u0001\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0004B\u0015\b\u0017\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\rHÖ\u0001¢\u0006\u0002\u0010\u000eJ\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u001f\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003HÖ\u0001J\u0018\u0010\u0017\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\rHÖ\u0001¢\u0006\u0002\u0010\u000eR\u0014\u0010\b\u001a\u00020\t8VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"com/deliveryhero/persistence/cache/CacheData.$serializer", "T", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/deliveryhero/persistence/cache/CacheData;", "()V", "typeSerial0", "Lkotlinx/serialization/KSerializer;", "(Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "typeParametersSerializers", "pandora-persistence_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class CacheData$$serializer<T> implements GeneratedSerializer<CacheData<T>> {
    public final /* synthetic */ SerialDescriptor descriptor;
    private final /* synthetic */ KSerializer<T> typeSerial0;

    private CacheData$$serializer() {
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.deliveryhero.persistence.cache.CacheData", this, 2);
        pluginGeneratedSerialDescriptor.addElement("data", false);
        pluginGeneratedSerialDescriptor.pushAnnotation(new JsonNames.Impl(new String[]{"data", "a"}));
        pluginGeneratedSerialDescriptor.addElement("expiryDateInSeconds", false);
        pluginGeneratedSerialDescriptor.pushAnnotation(new JsonNames.Impl(new String[]{"expiryDateInSeconds", "b"}));
        this.descriptor = pluginGeneratedSerialDescriptor;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: kotlinx.serialization.KSerializer<?>[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public kotlinx.serialization.KSerializer<?>[] childSerializers() {
        /*
            r3 = this;
            r0 = 2
            kotlinx.serialization.KSerializer[] r0 = new kotlinx.serialization.KSerializer[r0]
            r1 = 0
            kotlinx.serialization.KSerializer<T> r2 = r3.typeSerial0
            r0[r1] = r2
            r1 = 1
            kotlinx.serialization.internal.LongSerializer r2 = kotlinx.serialization.internal.LongSerializer.INSTANCE
            r0[r1] = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.persistence.cache.CacheData$$serializer.childSerializers():kotlinx.serialization.KSerializer[]");
    }

    @NotNull
    public CacheData<T> deserialize(@NotNull Decoder decoder) {
        long j11;
        T t11;
        int i11;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        if (beginStructure.decodeSequentially()) {
            t11 = beginStructure.decodeSerializableElement(descriptor2, 0, this.typeSerial0, null);
            j11 = beginStructure.decodeLongElement(descriptor2, 1);
            i11 = 3;
        } else {
            long j12 = 0;
            boolean z11 = true;
            T t12 = null;
            int i12 = 0;
            while (z11) {
                int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                if (decodeElementIndex == -1) {
                    z11 = false;
                } else if (decodeElementIndex == 0) {
                    t12 = beginStructure.decodeSerializableElement(descriptor2, 0, this.typeSerial0, t12);
                    i12 |= 1;
                } else if (decodeElementIndex == 1) {
                    j12 = beginStructure.decodeLongElement(descriptor2, 1);
                    i12 |= 2;
                } else {
                    throw new UnknownFieldException(decodeElementIndex);
                }
            }
            t11 = t12;
            i11 = i12;
            j11 = j12;
        }
        beginStructure.endStructure(descriptor2);
        return new CacheData(i11, t11, j11, (SerializationConstructorMarker) null);
    }

    @NotNull
    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    public void serialize(@NotNull Encoder encoder, @NotNull CacheData<T> cacheData) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(cacheData, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        CacheData.write$Self(cacheData, beginStructure, descriptor2, this.typeSerial0);
        beginStructure.endStructure(descriptor2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: kotlinx.serialization.KSerializer<?>[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public kotlinx.serialization.KSerializer<?>[] typeParametersSerializers() {
        /*
            r3 = this;
            r0 = 1
            kotlinx.serialization.KSerializer[] r0 = new kotlinx.serialization.KSerializer[r0]
            r1 = 0
            kotlinx.serialization.KSerializer<T> r2 = r3.typeSerial0
            r0[r1] = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.persistence.cache.CacheData$$serializer.typeParametersSerializers():kotlinx.serialization.KSerializer[]");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ CacheData$$serializer(KSerializer kSerializer) {
        this();
        Intrinsics.checkNotNullParameter(kSerializer, "typeSerial0");
        this.typeSerial0 = kSerializer;
    }
}
