package com.talabat.fluid.homescreen.presentation.displaymodel;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/fluid/homescreen/presentation/displaymodel/HeaderColour;", "", "()V", "Custom", "White", "Lcom/talabat/fluid/homescreen/presentation/displaymodel/HeaderColour$White;", "Lcom/talabat/fluid/homescreen/presentation/displaymodel/HeaderColour$Custom;", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class HeaderColour {

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/talabat/fluid/homescreen/presentation/displaymodel/HeaderColour$Custom;", "Lcom/talabat/fluid/homescreen/presentation/displaymodel/HeaderColour;", "value", "", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Custom extends HeaderColour {
        @NotNull
        private final String value;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Custom(@NotNull String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "value");
            this.value = str;
        }

        public static /* synthetic */ Custom copy$default(Custom custom, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = custom.value;
            }
            return custom.copy(str);
        }

        @NotNull
        public final String component1() {
            return this.value;
        }

        @NotNull
        public final Custom copy(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "value");
            return new Custom(str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Custom) && Intrinsics.areEqual((Object) this.value, (Object) ((Custom) obj).value);
        }

        @NotNull
        public final String getValue() {
            return this.value;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        @NotNull
        public String toString() {
            String str = this.value;
            return "Custom(value=" + str + ")";
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/fluid/homescreen/presentation/displaymodel/HeaderColour$White;", "Lcom/talabat/fluid/homescreen/presentation/displaymodel/HeaderColour;", "()V", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class White extends HeaderColour {
        @NotNull
        public static final White INSTANCE = new White();

        private White() {
            super((DefaultConstructorMarker) null);
        }
    }

    private HeaderColour() {
    }

    public /* synthetic */ HeaderColour(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
