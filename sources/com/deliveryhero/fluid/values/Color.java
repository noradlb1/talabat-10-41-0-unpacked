package com.deliveryhero.fluid.values;

import androidx.core.view.ViewCompat;
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

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 %2\u00020\u0001:\u0002$%B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B!\b\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB\r\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\u000bJ\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\u0013\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001J\b\u0010\u001c\u001a\u00020\u0003H\u0016J!\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#HÇ\u0001R\u0011\u0010\f\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0010\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0012\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\u0014\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000e¨\u0006&"}, d2 = {"Lcom/deliveryhero/fluid/values/Color;", "", "colorHex", "", "(Ljava/lang/String;)V", "seen1", "", "argb", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(I)V", "alpha", "getAlpha", "()I", "getArgb", "blue", "getBlue", "green", "getGreen", "red", "getRed", "component1", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Serializable
@CoreContract.CreatedOn(version = CoreContract.Version.V1)
public final class Color {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final Color OPAQUE_BLACK = new Color((int) ViewCompat.MEASURED_STATE_MASK);
    /* access modifiers changed from: private */
    @NotNull
    public static final Color OPAQUE_WHITE = new Color(-1);
    /* access modifiers changed from: private */
    @NotNull
    public static final Color TRANSPARENT = new Color(0);
    private final int argb;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010HÆ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/deliveryhero/fluid/values/Color$Companion;", "", "()V", "OPAQUE_BLACK", "Lcom/deliveryhero/fluid/values/Color;", "getOPAQUE_BLACK", "()Lcom/deliveryhero/fluid/values/Color;", "OPAQUE_WHITE", "getOPAQUE_WHITE", "TRANSPARENT", "getTRANSPARENT", "fromStringToInt", "", "colorHex", "", "serializer", "Lkotlinx/serialization/KSerializer;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final int fromStringToInt(String str) throws IllegalArgumentException, NumberFormatException, IndexOutOfBoundsException {
            boolean z11 = true;
            String substring = str.substring(1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            long parseLong = Long.parseLong(substring, CharsKt__CharJVMKt.checkRadix(16));
            if (str.length() == 7) {
                parseLong |= -16777216;
            } else {
                if (str.length() != 9) {
                    z11 = false;
                }
                if (!z11) {
                    throw new IllegalArgumentException(("Unknown color: " + str).toString());
                }
            }
            return (int) parseLong;
        }

        @NotNull
        public final Color getOPAQUE_BLACK() {
            return Color.OPAQUE_BLACK;
        }

        @NotNull
        public final Color getOPAQUE_WHITE() {
            return Color.OPAQUE_WHITE;
        }

        @NotNull
        public final Color getTRANSPARENT() {
            return Color.TRANSPARENT;
        }

        @NotNull
        public final KSerializer<Color> serializer() {
            return Color$$serializer.INSTANCE;
        }
    }

    public Color(int i11) {
        this.argb = i11;
    }

    public static /* synthetic */ Color copy$default(Color color, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = color.argb;
        }
        return color.copy(i11);
    }

    @JvmStatic
    public static final void write$Self(@NotNull Color color, @NotNull CompositeEncoder compositeEncoder, @NotNull SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(color, "self");
        Intrinsics.checkNotNullParameter(compositeEncoder, "output");
        Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
        compositeEncoder.encodeIntElement(serialDescriptor, 0, color.argb);
    }

    public final int component1() {
        return this.argb;
    }

    @NotNull
    public final Color copy(int i11) {
        return new Color(i11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Color) && this.argb == ((Color) obj).argb;
    }

    public final int getAlpha() {
        return this.argb >>> 24;
    }

    public final int getArgb() {
        return this.argb;
    }

    public final int getBlue() {
        return this.argb & 255;
    }

    public final int getGreen() {
        return (this.argb >> 8) & 255;
    }

    public final int getRed() {
        return (this.argb >> 16) & 255;
    }

    public int hashCode() {
        return this.argb;
    }

    @NotNull
    public String toString() {
        Color$toString$toHexString$1 color$toString$toHexString$1 = Color$toString$toHexString$1.INSTANCE;
        return '#' + ((String) color$toString$toHexString$1.invoke(Integer.valueOf(getAlpha()))) + ((String) color$toString$toHexString$1.invoke(Integer.valueOf(getRed()))) + ((String) color$toString$toHexString$1.invoke(Integer.valueOf(getGreen()))) + ((String) color$toString$toHexString$1.invoke(Integer.valueOf(getBlue())));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ Color(int i11, int i12, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i11 & 1)) {
            PluginExceptionsKt.throwMissingFieldException(i11, 1, Color$$serializer.INSTANCE.getDescriptor());
        }
        this.argb = i12;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Color(@NotNull String str) throws IllegalArgumentException, NumberFormatException, IndexOutOfBoundsException {
        this(Companion.fromStringToInt(str));
        Intrinsics.checkNotNullParameter(str, "colorHex");
    }
}
