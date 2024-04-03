package com.talabat.darkstores.common.view;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0005\b\t\n\u000b\f¨\u0006\r"}, d2 = {"Lcom/talabat/darkstores/common/view/ItemCounterAction;", "", "()V", "Add", "Close", "Open", "Remove", "Setup", "Lcom/talabat/darkstores/common/view/ItemCounterAction$Setup;", "Lcom/talabat/darkstores/common/view/ItemCounterAction$Add;", "Lcom/talabat/darkstores/common/view/ItemCounterAction$Remove;", "Lcom/talabat/darkstores/common/view/ItemCounterAction$Close;", "Lcom/talabat/darkstores/common/view/ItemCounterAction$Open;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class ItemCounterAction {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/darkstores/common/view/ItemCounterAction$Add;", "Lcom/talabat/darkstores/common/view/ItemCounterAction;", "()V", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Add extends ItemCounterAction {
        @NotNull
        public static final Add INSTANCE = new Add();

        private Add() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/darkstores/common/view/ItemCounterAction$Close;", "Lcom/talabat/darkstores/common/view/ItemCounterAction;", "()V", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Close extends ItemCounterAction {
        @NotNull
        public static final Close INSTANCE = new Close();

        private Close() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/darkstores/common/view/ItemCounterAction$Open;", "Lcom/talabat/darkstores/common/view/ItemCounterAction;", "()V", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Open extends ItemCounterAction {
        @NotNull
        public static final Open INSTANCE = new Open();

        private Open() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/darkstores/common/view/ItemCounterAction$Remove;", "Lcom/talabat/darkstores/common/view/ItemCounterAction;", "()V", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Remove extends ItemCounterAction {
        @NotNull
        public static final Remove INSTANCE = new Remove();

        private Remove() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/talabat/darkstores/common/view/ItemCounterAction$Setup;", "Lcom/talabat/darkstores/common/view/ItemCounterAction;", "quantity", "", "stock", "freeCount", "(III)V", "getFreeCount", "()I", "getQuantity", "getStock", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Setup extends ItemCounterAction {
        private final int freeCount;
        private final int quantity;
        private final int stock;

        public Setup(int i11, int i12, int i13) {
            super((DefaultConstructorMarker) null);
            this.quantity = i11;
            this.stock = i12;
            this.freeCount = i13;
        }

        public static /* synthetic */ Setup copy$default(Setup setup, int i11, int i12, int i13, int i14, Object obj) {
            if ((i14 & 1) != 0) {
                i11 = setup.quantity;
            }
            if ((i14 & 2) != 0) {
                i12 = setup.stock;
            }
            if ((i14 & 4) != 0) {
                i13 = setup.freeCount;
            }
            return setup.copy(i11, i12, i13);
        }

        public final int component1() {
            return this.quantity;
        }

        public final int component2() {
            return this.stock;
        }

        public final int component3() {
            return this.freeCount;
        }

        @NotNull
        public final Setup copy(int i11, int i12, int i13) {
            return new Setup(i11, i12, i13);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Setup)) {
                return false;
            }
            Setup setup = (Setup) obj;
            return this.quantity == setup.quantity && this.stock == setup.stock && this.freeCount == setup.freeCount;
        }

        public final int getFreeCount() {
            return this.freeCount;
        }

        public final int getQuantity() {
            return this.quantity;
        }

        public final int getStock() {
            return this.stock;
        }

        public int hashCode() {
            return (((this.quantity * 31) + this.stock) * 31) + this.freeCount;
        }

        @NotNull
        public String toString() {
            int i11 = this.quantity;
            int i12 = this.stock;
            int i13 = this.freeCount;
            return "Setup(quantity=" + i11 + ", stock=" + i12 + ", freeCount=" + i13 + ")";
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Setup(int i11, int i12, int i13, int i14, DefaultConstructorMarker defaultConstructorMarker) {
            this(i11, i12, (i14 & 4) != 0 ? 0 : i13);
        }
    }

    private ItemCounterAction() {
    }

    public /* synthetic */ ItemCounterAction(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
