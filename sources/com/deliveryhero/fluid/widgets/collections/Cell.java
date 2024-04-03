package com.deliveryhero.fluid.widgets.collections;

import com.deliveryhero.fluid.content.Content;
import com.deliveryhero.fluid.values.LogicalPixel;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/deliveryhero/fluid/widgets/collections/Cell;", "Lcom/deliveryhero/fluid/content/Content;", "Size", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface Cell extends Content {

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0001\u0002\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/deliveryhero/fluid/widgets/collections/Cell$Size;", "", "Absolute", "Relative", "Lcom/deliveryhero/fluid/widgets/collections/Cell$Size$Absolute;", "Lcom/deliveryhero/fluid/widgets/collections/Cell$Size$Relative;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Size {

        @JvmInline
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b@\u0018\u00002\u00020\u0001B\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0001\u0002ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Lcom/deliveryhero/fluid/widgets/collections/Cell$Size$Absolute;", "Lcom/deliveryhero/fluid/widgets/collections/Cell$Size;", "value", "Lcom/deliveryhero/fluid/values/LogicalPixel;", "constructor-impl", "(Lcom/deliveryhero/fluid/values/LogicalPixel;)Lcom/deliveryhero/fluid/values/LogicalPixel;", "getValue", "()Lcom/deliveryhero/fluid/values/LogicalPixel;", "equals", "", "other", "", "equals-impl", "(Lcom/deliveryhero/fluid/values/LogicalPixel;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Lcom/deliveryhero/fluid/values/LogicalPixel;)I", "toString", "", "toString-impl", "(Lcom/deliveryhero/fluid/values/LogicalPixel;)Ljava/lang/String;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Absolute implements Size {
            @NotNull
            private final LogicalPixel value;

            private /* synthetic */ Absolute(LogicalPixel logicalPixel) {
                this.value = logicalPixel;
            }

            /* renamed from: box-impl  reason: not valid java name */
            public static final /* synthetic */ Absolute m8189boximpl(LogicalPixel logicalPixel) {
                return new Absolute(logicalPixel);
            }

            @NotNull
            /* renamed from: constructor-impl  reason: not valid java name */
            public static LogicalPixel m8190constructorimpl(@NotNull LogicalPixel logicalPixel) {
                Intrinsics.checkNotNullParameter(logicalPixel, "value");
                return logicalPixel;
            }

            /* renamed from: equals-impl  reason: not valid java name */
            public static boolean m8191equalsimpl(LogicalPixel logicalPixel, Object obj) {
                return (obj instanceof Absolute) && Intrinsics.areEqual((Object) logicalPixel, (Object) ((Absolute) obj).m8195unboximpl());
            }

            /* renamed from: equals-impl0  reason: not valid java name */
            public static final boolean m8192equalsimpl0(LogicalPixel logicalPixel, LogicalPixel logicalPixel2) {
                return Intrinsics.areEqual((Object) logicalPixel, (Object) logicalPixel2);
            }

            /* renamed from: hashCode-impl  reason: not valid java name */
            public static int m8193hashCodeimpl(LogicalPixel logicalPixel) {
                return logicalPixel.hashCode();
            }

            /* renamed from: toString-impl  reason: not valid java name */
            public static String m8194toStringimpl(LogicalPixel logicalPixel) {
                return "Absolute(value=" + logicalPixel + ')';
            }

            public boolean equals(Object obj) {
                return m8191equalsimpl(this.value, obj);
            }

            @NotNull
            public final LogicalPixel getValue() {
                return this.value;
            }

            public int hashCode() {
                return m8193hashCodeimpl(this.value);
            }

            public String toString() {
                return m8194toStringimpl(this.value);
            }

            /* renamed from: unbox-impl  reason: not valid java name */
            public final /* synthetic */ LogicalPixel m8195unboximpl() {
                return this.value;
            }
        }

        @JvmInline
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b@\u0018\u00002\u00020\u0001B\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0001\u0002ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Lcom/deliveryhero/fluid/widgets/collections/Cell$Size$Relative;", "Lcom/deliveryhero/fluid/widgets/collections/Cell$Size;", "value", "", "constructor-impl", "(F)F", "getValue", "()F", "equals", "", "other", "", "equals-impl", "(FLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(F)I", "toString", "", "toString-impl", "(F)Ljava/lang/String;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Relative implements Size {
            private final float value;

            private /* synthetic */ Relative(float f11) {
                this.value = f11;
            }

            /* renamed from: box-impl  reason: not valid java name */
            public static final /* synthetic */ Relative m8196boximpl(float f11) {
                return new Relative(f11);
            }

            /* renamed from: constructor-impl  reason: not valid java name */
            public static float m8197constructorimpl(float f11) {
                boolean z11 = false;
                if (0.0f <= f11 && f11 <= 1.0f) {
                    z11 = true;
                }
                if (z11) {
                    return f11;
                }
                throw new IllegalArgumentException((f11 + " is out of valid [0, 1] range.").toString());
            }

            /* renamed from: equals-impl  reason: not valid java name */
            public static boolean m8198equalsimpl(float f11, Object obj) {
                if (!(obj instanceof Relative)) {
                    return false;
                }
                return Intrinsics.areEqual((Object) Float.valueOf(f11), (Object) Float.valueOf(((Relative) obj).m8202unboximpl()));
            }

            /* renamed from: equals-impl0  reason: not valid java name */
            public static final boolean m8199equalsimpl0(float f11, float f12) {
                return Intrinsics.areEqual((Object) Float.valueOf(f11), (Object) Float.valueOf(f12));
            }

            /* renamed from: hashCode-impl  reason: not valid java name */
            public static int m8200hashCodeimpl(float f11) {
                return Float.floatToIntBits(f11);
            }

            /* renamed from: toString-impl  reason: not valid java name */
            public static String m8201toStringimpl(float f11) {
                return "Relative(value=" + f11 + ')';
            }

            public boolean equals(Object obj) {
                return m8198equalsimpl(this.value, obj);
            }

            public final float getValue() {
                return this.value;
            }

            public int hashCode() {
                return m8200hashCodeimpl(this.value);
            }

            public String toString() {
                return m8201toStringimpl(this.value);
            }

            /* renamed from: unbox-impl  reason: not valid java name */
            public final /* synthetic */ float m8202unboximpl() {
                return this.value;
            }
        }
    }
}
