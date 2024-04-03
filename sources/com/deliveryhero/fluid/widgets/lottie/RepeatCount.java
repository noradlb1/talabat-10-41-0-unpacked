package com.deliveryhero.fluid.widgets.lottie;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u000f2\u00020\u0001:\u0003\u000f\u0010\u0011B\u0019\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0007J!\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eHÇ\u0001\u0001\u0002\u0012\u0013¨\u0006\u0014"}, d2 = {"Lcom/deliveryhero/fluid/widgets/lottie/RepeatCount;", "", "seen1", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "()V", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "Companion", "Finite", "Infinite", "Lcom/deliveryhero/fluid/widgets/lottie/RepeatCount$Infinite;", "Lcom/deliveryhero/fluid/widgets/lottie/RepeatCount$Finite;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Serializable
public abstract class RepeatCount {
    /* access modifiers changed from: private */
    @NotNull
    public static final Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, RepeatCount$Companion$$cachedSerializer$delegate$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/deliveryhero/fluid/widgets/lottie/RepeatCount$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/deliveryhero/fluid/widgets/lottie/RepeatCount;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final /* synthetic */ Lazy get$cachedSerializer$delegate() {
            return RepeatCount.$cachedSerializer$delegate;
        }

        @NotNull
        public final KSerializer<RepeatCount> serializer() {
            return (KSerializer) get$cachedSerializer$delegate().getValue();
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/deliveryhero/fluid/widgets/lottie/RepeatCount$Finite;", "Lcom/deliveryhero/fluid/widgets/lottie/RepeatCount;", "value", "", "(I)V", "getValue", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Finite extends RepeatCount {
        private final int value;

        public Finite(int i11) {
            super((DefaultConstructorMarker) null);
            this.value = i11;
        }

        public static /* synthetic */ Finite copy$default(Finite finite, int i11, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i11 = finite.value;
            }
            return finite.copy(i11);
        }

        public final int component1() {
            return this.value;
        }

        @NotNull
        public final Finite copy(int i11) {
            return new Finite(i11);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Finite) && this.value == ((Finite) obj).value;
        }

        public final int getValue() {
            return this.value;
        }

        public int hashCode() {
            return this.value;
        }

        @NotNull
        public String toString() {
            return "Finite(value=" + this.value + ')';
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/deliveryhero/fluid/widgets/lottie/RepeatCount$Infinite;", "Lcom/deliveryhero/fluid/widgets/lottie/RepeatCount;", "()V", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Infinite extends RepeatCount {
        @NotNull
        public static final Infinite INSTANCE = new Infinite();

        private Infinite() {
            super((DefaultConstructorMarker) null);
        }
    }

    private RepeatCount() {
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ RepeatCount(int i11, SerializationConstructorMarker serializationConstructorMarker) {
    }

    public /* synthetic */ RepeatCount(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    public static final void write$Self(@NotNull RepeatCount repeatCount, @NotNull CompositeEncoder compositeEncoder, @NotNull SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(repeatCount, "self");
        Intrinsics.checkNotNullParameter(compositeEncoder, "output");
        Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
    }
}
