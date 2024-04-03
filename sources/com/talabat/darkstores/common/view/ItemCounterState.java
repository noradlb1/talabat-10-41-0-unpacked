package com.talabat.darkstores.common.view;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0004\u0011\u0012\u0013\u0014B\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0006R\u0012\u0010\f\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0006R\u0012\u0010\r\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\nR\u0012\u0010\u000f\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\n\u0001\u0004\u0015\u0016\u0017\u0018¨\u0006\u0019"}, d2 = {"Lcom/talabat/darkstores/common/view/ItemCounterState;", "", "()V", "canAdd", "", "getCanAdd", "()Z", "freeCount", "", "getFreeCount", "()I", "isRemove", "isSetUp", "quantity", "getQuantity", "stock", "getStock", "Collapsed", "Empty", "Expanded", "Invisible", "Lcom/talabat/darkstores/common/view/ItemCounterState$Invisible;", "Lcom/talabat/darkstores/common/view/ItemCounterState$Empty;", "Lcom/talabat/darkstores/common/view/ItemCounterState$Expanded;", "Lcom/talabat/darkstores/common/view/ItemCounterState$Collapsed;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class ItemCounterState {

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0014\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\fR\u0014\u0010\b\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/talabat/darkstores/common/view/ItemCounterState$Collapsed;", "Lcom/talabat/darkstores/common/view/ItemCounterState;", "quantity", "", "stock", "freeCount", "isRemove", "", "isSetUp", "(IIIZZ)V", "getFreeCount", "()I", "()Z", "getQuantity", "getStock", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Collapsed extends ItemCounterState {
        private final int freeCount;
        private final boolean isRemove;
        private final boolean isSetUp;
        private final int quantity;
        private final int stock;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Collapsed(int i11, int i12, int i13, boolean z11, boolean z12, int i14, DefaultConstructorMarker defaultConstructorMarker) {
            this(i11, i12, i13, (i14 & 8) != 0 ? false : z11, (i14 & 16) != 0 ? false : z12);
        }

        public static /* synthetic */ Collapsed copy$default(Collapsed collapsed, int i11, int i12, int i13, boolean z11, boolean z12, int i14, Object obj) {
            if ((i14 & 1) != 0) {
                i11 = collapsed.getQuantity();
            }
            if ((i14 & 2) != 0) {
                i12 = collapsed.getStock();
            }
            int i15 = i12;
            if ((i14 & 4) != 0) {
                i13 = collapsed.getFreeCount();
            }
            int i16 = i13;
            if ((i14 & 8) != 0) {
                z11 = collapsed.isRemove();
            }
            boolean z13 = z11;
            if ((i14 & 16) != 0) {
                z12 = collapsed.isSetUp();
            }
            return collapsed.copy(i11, i15, i16, z13, z12);
        }

        public final int component1() {
            return getQuantity();
        }

        public final int component2() {
            return getStock();
        }

        public final int component3() {
            return getFreeCount();
        }

        public final boolean component4() {
            return isRemove();
        }

        public final boolean component5() {
            return isSetUp();
        }

        @NotNull
        public final Collapsed copy(int i11, int i12, int i13, boolean z11, boolean z12) {
            return new Collapsed(i11, i12, i13, z11, z12);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Collapsed)) {
                return false;
            }
            Collapsed collapsed = (Collapsed) obj;
            return getQuantity() == collapsed.getQuantity() && getStock() == collapsed.getStock() && getFreeCount() == collapsed.getFreeCount() && isRemove() == collapsed.isRemove() && isSetUp() == collapsed.isSetUp();
        }

        public int getFreeCount() {
            return this.freeCount;
        }

        public int getQuantity() {
            return this.quantity;
        }

        public int getStock() {
            return this.stock;
        }

        public int hashCode() {
            int quantity2 = ((((getQuantity() * 31) + getStock()) * 31) + getFreeCount()) * 31;
            boolean isRemove2 = isRemove();
            boolean z11 = true;
            if (isRemove2) {
                isRemove2 = true;
            }
            int i11 = (quantity2 + (isRemove2 ? 1 : 0)) * 31;
            boolean isSetUp2 = isSetUp();
            if (!isSetUp2) {
                z11 = isSetUp2;
            }
            return i11 + (z11 ? 1 : 0);
        }

        public boolean isRemove() {
            return this.isRemove;
        }

        public boolean isSetUp() {
            return this.isSetUp;
        }

        @NotNull
        public String toString() {
            int quantity2 = getQuantity();
            int stock2 = getStock();
            int freeCount2 = getFreeCount();
            boolean isRemove2 = isRemove();
            boolean isSetUp2 = isSetUp();
            return "Collapsed(quantity=" + quantity2 + ", stock=" + stock2 + ", freeCount=" + freeCount2 + ", isRemove=" + isRemove2 + ", isSetUp=" + isSetUp2 + ")";
        }

        public Collapsed(int i11, int i12, int i13, boolean z11, boolean z12) {
            super((DefaultConstructorMarker) null);
            this.quantity = i11;
            this.stock = i12;
            this.freeCount = i13;
            this.isRemove = z11;
            this.isSetUp = z12;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u000bR\u0014\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u000bR\u0014\u0010\f\u001a\u00020\u0003XD¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/talabat/darkstores/common/view/ItemCounterState$Empty;", "Lcom/talabat/darkstores/common/view/ItemCounterState;", "stock", "", "freeCount", "isRemove", "", "isSetUp", "(IIZZ)V", "getFreeCount", "()I", "()Z", "quantity", "getQuantity", "getStock", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Empty extends ItemCounterState {
        private final int freeCount;
        private final boolean isRemove;
        private final boolean isSetUp;
        private final int quantity;
        private final int stock;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Empty(int i11, int i12, boolean z11, boolean z12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
            this(i11, i12, (i13 & 4) != 0 ? false : z11, (i13 & 8) != 0 ? false : z12);
        }

        public static /* synthetic */ Empty copy$default(Empty empty, int i11, int i12, boolean z11, boolean z12, int i13, Object obj) {
            if ((i13 & 1) != 0) {
                i11 = empty.getStock();
            }
            if ((i13 & 2) != 0) {
                i12 = empty.getFreeCount();
            }
            if ((i13 & 4) != 0) {
                z11 = empty.isRemove();
            }
            if ((i13 & 8) != 0) {
                z12 = empty.isSetUp();
            }
            return empty.copy(i11, i12, z11, z12);
        }

        public final int component1() {
            return getStock();
        }

        public final int component2() {
            return getFreeCount();
        }

        public final boolean component3() {
            return isRemove();
        }

        public final boolean component4() {
            return isSetUp();
        }

        @NotNull
        public final Empty copy(int i11, int i12, boolean z11, boolean z12) {
            return new Empty(i11, i12, z11, z12);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Empty)) {
                return false;
            }
            Empty empty = (Empty) obj;
            return getStock() == empty.getStock() && getFreeCount() == empty.getFreeCount() && isRemove() == empty.isRemove() && isSetUp() == empty.isSetUp();
        }

        public int getFreeCount() {
            return this.freeCount;
        }

        public int getQuantity() {
            return this.quantity;
        }

        public int getStock() {
            return this.stock;
        }

        public int hashCode() {
            int stock2 = ((getStock() * 31) + getFreeCount()) * 31;
            boolean isRemove2 = isRemove();
            boolean z11 = true;
            if (isRemove2) {
                isRemove2 = true;
            }
            int i11 = (stock2 + (isRemove2 ? 1 : 0)) * 31;
            boolean isSetUp2 = isSetUp();
            if (!isSetUp2) {
                z11 = isSetUp2;
            }
            return i11 + (z11 ? 1 : 0);
        }

        public boolean isRemove() {
            return this.isRemove;
        }

        public boolean isSetUp() {
            return this.isSetUp;
        }

        @NotNull
        public String toString() {
            int stock2 = getStock();
            int freeCount2 = getFreeCount();
            boolean isRemove2 = isRemove();
            boolean isSetUp2 = isSetUp();
            return "Empty(stock=" + stock2 + ", freeCount=" + freeCount2 + ", isRemove=" + isRemove2 + ", isSetUp=" + isSetUp2 + ")";
        }

        public Empty(int i11, int i12, boolean z11, boolean z12) {
            super((DefaultConstructorMarker) null);
            this.stock = i11;
            this.freeCount = i12;
            this.isRemove = z11;
            this.isSetUp = z12;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/darkstores/common/view/ItemCounterState$Expanded;", "Lcom/talabat/darkstores/common/view/ItemCounterState;", "()V", "More", "One", "Lcom/talabat/darkstores/common/view/ItemCounterState$Expanded$One;", "Lcom/talabat/darkstores/common/view/ItemCounterState$Expanded$More;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static abstract class Expanded extends ItemCounterState {

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0014\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\fR\u0014\u0010\b\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/talabat/darkstores/common/view/ItemCounterState$Expanded$More;", "Lcom/talabat/darkstores/common/view/ItemCounterState$Expanded;", "quantity", "", "stock", "freeCount", "isRemove", "", "isSetUp", "(IIIZZ)V", "getFreeCount", "()I", "()Z", "getQuantity", "getStock", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class More extends Expanded {
            private final int freeCount;
            private final boolean isRemove;
            private final boolean isSetUp;
            private final int quantity;
            private final int stock;

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ More(int i11, int i12, int i13, boolean z11, boolean z12, int i14, DefaultConstructorMarker defaultConstructorMarker) {
                this(i11, i12, i13, (i14 & 8) != 0 ? false : z11, (i14 & 16) != 0 ? false : z12);
            }

            public static /* synthetic */ More copy$default(More more, int i11, int i12, int i13, boolean z11, boolean z12, int i14, Object obj) {
                if ((i14 & 1) != 0) {
                    i11 = more.getQuantity();
                }
                if ((i14 & 2) != 0) {
                    i12 = more.getStock();
                }
                int i15 = i12;
                if ((i14 & 4) != 0) {
                    i13 = more.getFreeCount();
                }
                int i16 = i13;
                if ((i14 & 8) != 0) {
                    z11 = more.isRemove();
                }
                boolean z13 = z11;
                if ((i14 & 16) != 0) {
                    z12 = more.isSetUp();
                }
                return more.copy(i11, i15, i16, z13, z12);
            }

            public final int component1() {
                return getQuantity();
            }

            public final int component2() {
                return getStock();
            }

            public final int component3() {
                return getFreeCount();
            }

            public final boolean component4() {
                return isRemove();
            }

            public final boolean component5() {
                return isSetUp();
            }

            @NotNull
            public final More copy(int i11, int i12, int i13, boolean z11, boolean z12) {
                return new More(i11, i12, i13, z11, z12);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof More)) {
                    return false;
                }
                More more = (More) obj;
                return getQuantity() == more.getQuantity() && getStock() == more.getStock() && getFreeCount() == more.getFreeCount() && isRemove() == more.isRemove() && isSetUp() == more.isSetUp();
            }

            public int getFreeCount() {
                return this.freeCount;
            }

            public int getQuantity() {
                return this.quantity;
            }

            public int getStock() {
                return this.stock;
            }

            public int hashCode() {
                int quantity2 = ((((getQuantity() * 31) + getStock()) * 31) + getFreeCount()) * 31;
                boolean isRemove2 = isRemove();
                boolean z11 = true;
                if (isRemove2) {
                    isRemove2 = true;
                }
                int i11 = (quantity2 + (isRemove2 ? 1 : 0)) * 31;
                boolean isSetUp2 = isSetUp();
                if (!isSetUp2) {
                    z11 = isSetUp2;
                }
                return i11 + (z11 ? 1 : 0);
            }

            public boolean isRemove() {
                return this.isRemove;
            }

            public boolean isSetUp() {
                return this.isSetUp;
            }

            @NotNull
            public String toString() {
                int quantity2 = getQuantity();
                int stock2 = getStock();
                int freeCount2 = getFreeCount();
                boolean isRemove2 = isRemove();
                boolean isSetUp2 = isSetUp();
                return "More(quantity=" + quantity2 + ", stock=" + stock2 + ", freeCount=" + freeCount2 + ", isRemove=" + isRemove2 + ", isSetUp=" + isSetUp2 + ")";
            }

            public More(int i11, int i12, int i13, boolean z11, boolean z12) {
                super((DefaultConstructorMarker) null);
                this.quantity = i11;
                this.stock = i12;
                this.freeCount = i13;
                this.isRemove = z11;
                this.isSetUp = z12;
            }
        }

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u000bR\u0014\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u000bR\u0014\u0010\f\u001a\u00020\u0003XD¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/talabat/darkstores/common/view/ItemCounterState$Expanded$One;", "Lcom/talabat/darkstores/common/view/ItemCounterState$Expanded;", "stock", "", "freeCount", "isRemove", "", "isSetUp", "(IIZZ)V", "getFreeCount", "()I", "()Z", "quantity", "getQuantity", "getStock", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class One extends Expanded {
            private final int freeCount;
            private final boolean isRemove;
            private final boolean isSetUp;
            private final int quantity;
            private final int stock;

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ One(int i11, int i12, boolean z11, boolean z12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
                this(i11, i12, (i13 & 4) != 0 ? false : z11, (i13 & 8) != 0 ? false : z12);
            }

            public static /* synthetic */ One copy$default(One one, int i11, int i12, boolean z11, boolean z12, int i13, Object obj) {
                if ((i13 & 1) != 0) {
                    i11 = one.getStock();
                }
                if ((i13 & 2) != 0) {
                    i12 = one.getFreeCount();
                }
                if ((i13 & 4) != 0) {
                    z11 = one.isRemove();
                }
                if ((i13 & 8) != 0) {
                    z12 = one.isSetUp();
                }
                return one.copy(i11, i12, z11, z12);
            }

            public final int component1() {
                return getStock();
            }

            public final int component2() {
                return getFreeCount();
            }

            public final boolean component3() {
                return isRemove();
            }

            public final boolean component4() {
                return isSetUp();
            }

            @NotNull
            public final One copy(int i11, int i12, boolean z11, boolean z12) {
                return new One(i11, i12, z11, z12);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof One)) {
                    return false;
                }
                One one = (One) obj;
                return getStock() == one.getStock() && getFreeCount() == one.getFreeCount() && isRemove() == one.isRemove() && isSetUp() == one.isSetUp();
            }

            public int getFreeCount() {
                return this.freeCount;
            }

            public int getQuantity() {
                return this.quantity;
            }

            public int getStock() {
                return this.stock;
            }

            public int hashCode() {
                int stock2 = ((getStock() * 31) + getFreeCount()) * 31;
                boolean isRemove2 = isRemove();
                boolean z11 = true;
                if (isRemove2) {
                    isRemove2 = true;
                }
                int i11 = (stock2 + (isRemove2 ? 1 : 0)) * 31;
                boolean isSetUp2 = isSetUp();
                if (!isSetUp2) {
                    z11 = isSetUp2;
                }
                return i11 + (z11 ? 1 : 0);
            }

            public boolean isRemove() {
                return this.isRemove;
            }

            public boolean isSetUp() {
                return this.isSetUp;
            }

            @NotNull
            public String toString() {
                int stock2 = getStock();
                int freeCount2 = getFreeCount();
                boolean isRemove2 = isRemove();
                boolean isSetUp2 = isSetUp();
                return "One(stock=" + stock2 + ", freeCount=" + freeCount2 + ", isRemove=" + isRemove2 + ", isSetUp=" + isSetUp2 + ")";
            }

            public One(int i11, int i12, boolean z11, boolean z12) {
                super((DefaultConstructorMarker) null);
                this.stock = i11;
                this.freeCount = i12;
                this.isRemove = z11;
                this.isSetUp = z12;
                this.quantity = 1;
            }
        }

        private Expanded() {
            super((DefaultConstructorMarker) null);
        }

        public /* synthetic */ Expanded(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\tR\u0014\u0010\n\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/talabat/darkstores/common/view/ItemCounterState$Invisible;", "Lcom/talabat/darkstores/common/view/ItemCounterState;", "()V", "freeCount", "", "getFreeCount", "()I", "isRemove", "", "()Z", "isSetUp", "quantity", "getQuantity", "stock", "getStock", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Invisible extends ItemCounterState {
        @NotNull
        public static final Invisible INSTANCE = new Invisible();
        private static final int freeCount = 0;
        private static final boolean isRemove = false;
        private static final boolean isSetUp = false;
        private static final int quantity = -1;

        private Invisible() {
            super((DefaultConstructorMarker) null);
        }

        public int getFreeCount() {
            return freeCount;
        }

        public int getQuantity() {
            return quantity;
        }

        public int getStock() {
            return -1;
        }

        public boolean isRemove() {
            return isRemove;
        }

        public boolean isSetUp() {
            return isSetUp;
        }
    }

    private ItemCounterState() {
    }

    public /* synthetic */ ItemCounterState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final boolean getCanAdd() {
        return getStock() > getQuantity();
    }

    public abstract int getFreeCount();

    public abstract int getQuantity();

    public abstract int getStock();

    public abstract boolean isRemove();

    public abstract boolean isSetUp();
}
