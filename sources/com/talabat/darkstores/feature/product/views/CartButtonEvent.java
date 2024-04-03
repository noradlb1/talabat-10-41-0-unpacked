package com.talabat.darkstores.feature.product.views;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/talabat/darkstores/feature/product/views/CartButtonEvent;", "", "()V", "Add", "Remove", "Setup", "Lcom/talabat/darkstores/feature/product/views/CartButtonEvent$Setup;", "Lcom/talabat/darkstores/feature/product/views/CartButtonEvent$Add;", "Lcom/talabat/darkstores/feature/product/views/CartButtonEvent$Remove;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class CartButtonEvent {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/darkstores/feature/product/views/CartButtonEvent$Add;", "Lcom/talabat/darkstores/feature/product/views/CartButtonEvent;", "()V", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Add extends CartButtonEvent {
        @NotNull
        public static final Add INSTANCE = new Add();

        private Add() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/darkstores/feature/product/views/CartButtonEvent$Remove;", "Lcom/talabat/darkstores/feature/product/views/CartButtonEvent;", "()V", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Remove extends CartButtonEvent {
        @NotNull
        public static final Remove INSTANCE = new Remove();

        private Remove() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/talabat/darkstores/feature/product/views/CartButtonEvent$Setup;", "Lcom/talabat/darkstores/feature/product/views/CartButtonEvent;", "quantity", "", "stock", "(II)V", "getQuantity", "()I", "getStock", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Setup extends CartButtonEvent {
        private final int quantity;
        private final int stock;

        public Setup(int i11, int i12) {
            super((DefaultConstructorMarker) null);
            this.quantity = i11;
            this.stock = i12;
        }

        public static /* synthetic */ Setup copy$default(Setup setup, int i11, int i12, int i13, Object obj) {
            if ((i13 & 1) != 0) {
                i11 = setup.quantity;
            }
            if ((i13 & 2) != 0) {
                i12 = setup.stock;
            }
            return setup.copy(i11, i12);
        }

        public final int component1() {
            return this.quantity;
        }

        public final int component2() {
            return this.stock;
        }

        @NotNull
        public final Setup copy(int i11, int i12) {
            return new Setup(i11, i12);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Setup)) {
                return false;
            }
            Setup setup = (Setup) obj;
            return this.quantity == setup.quantity && this.stock == setup.stock;
        }

        public final int getQuantity() {
            return this.quantity;
        }

        public final int getStock() {
            return this.stock;
        }

        public int hashCode() {
            return (this.quantity * 31) + this.stock;
        }

        @NotNull
        public String toString() {
            int i11 = this.quantity;
            int i12 = this.stock;
            return "Setup(quantity=" + i11 + ", stock=" + i12 + ")";
        }
    }

    private CartButtonEvent() {
    }

    public /* synthetic */ CartButtonEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
