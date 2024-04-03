package com.talabat.feature.darkstorescartlist.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/talabat/feature/darkstorescartlist/domain/model/CartListToast;", "", "()V", "FirstCartControl", "SecondCartControl", "SecondCartVariation1", "Lcom/talabat/feature/darkstorescartlist/domain/model/CartListToast$FirstCartControl;", "Lcom/talabat/feature/darkstorescartlist/domain/model/CartListToast$SecondCartControl;", "Lcom/talabat/feature/darkstorescartlist/domain/model/CartListToast$SecondCartVariation1;", "com_talabat_feature_darkstores-cart-list_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class CartListToast {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/feature/darkstorescartlist/domain/model/CartListToast$FirstCartControl;", "Lcom/talabat/feature/darkstorescartlist/domain/model/CartListToast;", "()V", "com_talabat_feature_darkstores-cart-list_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class FirstCartControl extends CartListToast {
        @NotNull
        public static final FirstCartControl INSTANCE = new FirstCartControl();

        private FirstCartControl() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/feature/darkstorescartlist/domain/model/CartListToast$SecondCartControl;", "Lcom/talabat/feature/darkstorescartlist/domain/model/CartListToast;", "()V", "com_talabat_feature_darkstores-cart-list_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class SecondCartControl extends CartListToast {
        @NotNull
        public static final SecondCartControl INSTANCE = new SecondCartControl();

        private SecondCartControl() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/feature/darkstorescartlist/domain/model/CartListToast$SecondCartVariation1;", "Lcom/talabat/feature/darkstorescartlist/domain/model/CartListToast;", "()V", "com_talabat_feature_darkstores-cart-list_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class SecondCartVariation1 extends CartListToast {
        @NotNull
        public static final SecondCartVariation1 INSTANCE = new SecondCartVariation1();

        private SecondCartVariation1() {
            super((DefaultConstructorMarker) null);
        }
    }

    private CartListToast() {
    }

    public /* synthetic */ CartListToast(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
