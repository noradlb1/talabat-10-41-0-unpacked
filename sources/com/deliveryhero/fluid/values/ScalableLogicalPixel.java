package com.deliveryhero.fluid.values;

import com.deliveryhero.fluid.versioning.CoreContract;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001c\u001dB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B!\b\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0006¢\u0006\u0002\u0010\nJ\t\u0010\r\u001a\u00020\u0006HÆ\u0003J\u0013\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J!\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bHÇ\u0001R\u0011\u0010\u0002\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/deliveryhero/fluid/values/ScalableLogicalPixel;", "", "value", "", "(I)V", "seen1", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IFLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(F)V", "getValue", "()F", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Serializable
@CoreContract.CreatedOn(version = CoreContract.Version.V1)
public final class ScalableLogicalPixel {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final ScalableLogicalPixel DEFAULT = new ScalableLogicalPixel(12.0f);
    private final float value;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\bHÆ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/deliveryhero/fluid/values/ScalableLogicalPixel$Companion;", "", "()V", "DEFAULT", "Lcom/deliveryhero/fluid/values/ScalableLogicalPixel;", "getDEFAULT", "()Lcom/deliveryhero/fluid/values/ScalableLogicalPixel;", "serializer", "Lkotlinx/serialization/KSerializer;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ScalableLogicalPixel getDEFAULT() {
            return ScalableLogicalPixel.DEFAULT;
        }

        @NotNull
        public final KSerializer<ScalableLogicalPixel> serializer() {
            return ScalableLogicalPixel$$serializer.INSTANCE;
        }
    }

    public ScalableLogicalPixel(float f11) {
        this.value = f11;
    }

    public static /* synthetic */ ScalableLogicalPixel copy$default(ScalableLogicalPixel scalableLogicalPixel, float f11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = scalableLogicalPixel.value;
        }
        return scalableLogicalPixel.copy(f11);
    }

    @JvmStatic
    public static final void write$Self(@NotNull ScalableLogicalPixel scalableLogicalPixel, @NotNull CompositeEncoder compositeEncoder, @NotNull SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(scalableLogicalPixel, "self");
        Intrinsics.checkNotNullParameter(compositeEncoder, "output");
        Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
        compositeEncoder.encodeFloatElement(serialDescriptor, 0, scalableLogicalPixel.value);
    }

    public final float component1() {
        return this.value;
    }

    @NotNull
    public final ScalableLogicalPixel copy(float f11) {
        return new ScalableLogicalPixel(f11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ScalableLogicalPixel) && Intrinsics.areEqual((Object) Float.valueOf(this.value), (Object) Float.valueOf(((ScalableLogicalPixel) obj).value));
    }

    public final float getValue() {
        return this.value;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.value);
    }

    @NotNull
    public String toString() {
        return "ScalableLogicalPixel(value=" + this.value + ')';
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ ScalableLogicalPixel(int i11, float f11, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i11 & 1)) {
            PluginExceptionsKt.throwMissingFieldException(i11, 1, ScalableLogicalPixel$$serializer.INSTANCE.getDescriptor());
        }
        this.value = f11;
    }

    public ScalableLogicalPixel(int i11) {
        this((float) i11);
    }
}
