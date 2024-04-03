package com.talabat.darkstores.feature.product.views;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/darkstores/feature/product/views/CartButtonState;", "", "()V", "Empty", "NotEmpty", "Lcom/talabat/darkstores/feature/product/views/CartButtonState$Empty;", "Lcom/talabat/darkstores/feature/product/views/CartButtonState$NotEmpty;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class CartButtonState {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/darkstores/feature/product/views/CartButtonState$Empty;", "Lcom/talabat/darkstores/feature/product/views/CartButtonState;", "()V", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Empty extends CartButtonState {
        @NotNull
        public static final Empty INSTANCE = new Empty();

        private Empty() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\n\u000b\fB\u0017\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u0001\u0003\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/talabat/darkstores/feature/product/views/CartButtonState$NotEmpty;", "Lcom/talabat/darkstores/feature/product/views/CartButtonState;", "quantity", "", "isRemove", "", "(IZ)V", "()Z", "getQuantity", "()I", "Full", "More", "One", "Lcom/talabat/darkstores/feature/product/views/CartButtonState$NotEmpty$One;", "Lcom/talabat/darkstores/feature/product/views/CartButtonState$NotEmpty$More;", "Lcom/talabat/darkstores/feature/product/views/CartButtonState$NotEmpty$Full;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static abstract class NotEmpty extends CartButtonState {
        private final boolean isRemove;
        private final int quantity;

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/talabat/darkstores/feature/product/views/CartButtonState$NotEmpty$Full;", "Lcom/talabat/darkstores/feature/product/views/CartButtonState$NotEmpty;", "quantity", "", "isRemove", "", "(IZ)V", "()Z", "getQuantity", "()I", "component1", "component2", "copy", "equals", "other", "", "hashCode", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Full extends NotEmpty {
            private final boolean isRemove;
            private final int quantity;

            public Full(int i11, boolean z11) {
                super(i11, z11, (DefaultConstructorMarker) null);
                this.quantity = i11;
                this.isRemove = z11;
            }

            public static /* synthetic */ Full copy$default(Full full, int i11, boolean z11, int i12, Object obj) {
                if ((i12 & 1) != 0) {
                    i11 = full.getQuantity();
                }
                if ((i12 & 2) != 0) {
                    z11 = full.isRemove();
                }
                return full.copy(i11, z11);
            }

            public final int component1() {
                return getQuantity();
            }

            public final boolean component2() {
                return isRemove();
            }

            @NotNull
            public final Full copy(int i11, boolean z11) {
                return new Full(i11, z11);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Full)) {
                    return false;
                }
                Full full = (Full) obj;
                return getQuantity() == full.getQuantity() && isRemove() == full.isRemove();
            }

            public int getQuantity() {
                return this.quantity;
            }

            public int hashCode() {
                int quantity2 = getQuantity() * 31;
                boolean isRemove2 = isRemove();
                if (isRemove2) {
                    isRemove2 = true;
                }
                return quantity2 + (isRemove2 ? 1 : 0);
            }

            public boolean isRemove() {
                return this.isRemove;
            }

            @NotNull
            public String toString() {
                int quantity2 = getQuantity();
                boolean isRemove2 = isRemove();
                return "Full(quantity=" + quantity2 + ", isRemove=" + isRemove2 + ")";
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/talabat/darkstores/feature/product/views/CartButtonState$NotEmpty$More;", "Lcom/talabat/darkstores/feature/product/views/CartButtonState$NotEmpty;", "quantity", "", "isRemove", "", "(IZ)V", "()Z", "getQuantity", "()I", "component1", "component2", "copy", "equals", "other", "", "hashCode", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class More extends NotEmpty {
            private final boolean isRemove;
            private final int quantity;

            public More(int i11, boolean z11) {
                super(i11, z11, (DefaultConstructorMarker) null);
                this.quantity = i11;
                this.isRemove = z11;
            }

            public static /* synthetic */ More copy$default(More more, int i11, boolean z11, int i12, Object obj) {
                if ((i12 & 1) != 0) {
                    i11 = more.getQuantity();
                }
                if ((i12 & 2) != 0) {
                    z11 = more.isRemove();
                }
                return more.copy(i11, z11);
            }

            public final int component1() {
                return getQuantity();
            }

            public final boolean component2() {
                return isRemove();
            }

            @NotNull
            public final More copy(int i11, boolean z11) {
                return new More(i11, z11);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof More)) {
                    return false;
                }
                More more = (More) obj;
                return getQuantity() == more.getQuantity() && isRemove() == more.isRemove();
            }

            public int getQuantity() {
                return this.quantity;
            }

            public int hashCode() {
                int quantity2 = getQuantity() * 31;
                boolean isRemove2 = isRemove();
                if (isRemove2) {
                    isRemove2 = true;
                }
                return quantity2 + (isRemove2 ? 1 : 0);
            }

            public boolean isRemove() {
                return this.isRemove;
            }

            @NotNull
            public String toString() {
                int quantity2 = getQuantity();
                boolean isRemove2 = isRemove();
                return "More(quantity=" + quantity2 + ", isRemove=" + isRemove2 + ")";
            }
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0006\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u000f"}, d2 = {"Lcom/talabat/darkstores/feature/product/views/CartButtonState$NotEmpty$One;", "Lcom/talabat/darkstores/feature/product/views/CartButtonState$NotEmpty;", "isRemove", "", "(Z)V", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class One extends NotEmpty {
            private final boolean isRemove;

            public One(boolean z11) {
                super(1, z11, (DefaultConstructorMarker) null);
                this.isRemove = z11;
            }

            public static /* synthetic */ One copy$default(One one, boolean z11, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    z11 = one.isRemove();
                }
                return one.copy(z11);
            }

            public final boolean component1() {
                return isRemove();
            }

            @NotNull
            public final One copy(boolean z11) {
                return new One(z11);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof One) && isRemove() == ((One) obj).isRemove();
            }

            public int hashCode() {
                boolean isRemove2 = isRemove();
                if (isRemove2) {
                    return 1;
                }
                return isRemove2 ? 1 : 0;
            }

            public boolean isRemove() {
                return this.isRemove;
            }

            @NotNull
            public String toString() {
                boolean isRemove2 = isRemove();
                return "One(isRemove=" + isRemove2 + ")";
            }
        }

        private NotEmpty(int i11, boolean z11) {
            super((DefaultConstructorMarker) null);
            this.quantity = i11;
            this.isRemove = z11;
        }

        public /* synthetic */ NotEmpty(int i11, boolean z11, DefaultConstructorMarker defaultConstructorMarker) {
            this(i11, z11);
        }

        public int getQuantity() {
            return this.quantity;
        }

        public boolean isRemove() {
            return this.isRemove;
        }
    }

    private CartButtonState() {
    }

    public /* synthetic */ CartButtonState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
