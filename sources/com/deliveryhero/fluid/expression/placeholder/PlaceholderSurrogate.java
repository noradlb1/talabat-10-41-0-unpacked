package com.deliveryhero.fluid.expression.placeholder;

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

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001d\u001eB-\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\nJ\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J!\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cHÇ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/deliveryhero/fluid/expression/placeholder/PlaceholderSurrogate;", "", "seen1", "", "name", "", "type", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getType", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Serializable
@CoreContract.CreatedOn(version = CoreContract.Version.V1)
public final class PlaceholderSurrogate {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f30198name;
    @NotNull
    private final String type;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/deliveryhero/fluid/expression/placeholder/PlaceholderSurrogate$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/deliveryhero/fluid/expression/placeholder/PlaceholderSurrogate;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final KSerializer<PlaceholderSurrogate> serializer() {
            return PlaceholderSurrogate$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ PlaceholderSurrogate(int i11, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i11 & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i11, 3, PlaceholderSurrogate$$serializer.INSTANCE.getDescriptor());
        }
        this.f30198name = str;
        this.type = str2;
    }

    public static /* synthetic */ PlaceholderSurrogate copy$default(PlaceholderSurrogate placeholderSurrogate, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = placeholderSurrogate.f30198name;
        }
        if ((i11 & 2) != 0) {
            str2 = placeholderSurrogate.type;
        }
        return placeholderSurrogate.copy(str, str2);
    }

    @JvmStatic
    public static final void write$Self(@NotNull PlaceholderSurrogate placeholderSurrogate, @NotNull CompositeEncoder compositeEncoder, @NotNull SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(placeholderSurrogate, "self");
        Intrinsics.checkNotNullParameter(compositeEncoder, "output");
        Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
        compositeEncoder.encodeStringElement(serialDescriptor, 0, placeholderSurrogate.f30198name);
        compositeEncoder.encodeStringElement(serialDescriptor, 1, placeholderSurrogate.type);
    }

    @NotNull
    public final String component1() {
        return this.f30198name;
    }

    @NotNull
    public final String component2() {
        return this.type;
    }

    @NotNull
    public final PlaceholderSurrogate copy(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "type");
        return new PlaceholderSurrogate(str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlaceholderSurrogate)) {
            return false;
        }
        PlaceholderSurrogate placeholderSurrogate = (PlaceholderSurrogate) obj;
        return Intrinsics.areEqual((Object) this.f30198name, (Object) placeholderSurrogate.f30198name) && Intrinsics.areEqual((Object) this.type, (Object) placeholderSurrogate.type);
    }

    @NotNull
    public final String getName() {
        return this.f30198name;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        return (this.f30198name.hashCode() * 31) + this.type.hashCode();
    }

    @NotNull
    public String toString() {
        return "PlaceholderSurrogate(name=" + this.f30198name + ", type=" + this.type + ')';
    }

    public PlaceholderSurrogate(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "type");
        this.f30198name = str;
        this.type = str2;
    }
}
