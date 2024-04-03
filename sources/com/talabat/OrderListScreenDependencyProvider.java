package com.talabat;

import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.mvp.orderlistscreen.IOrderListScreenPresenter;
import library.talabat.mvp.orderlistscreen.OrderListScreenPresenter;
import library.talabat.mvp.orderlistscreen.OrderListScreenView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/talabat/OrderListScreenDependencyProvider;", "", "()V", "mockedOrderListScreenPresenter", "Llibrary/talabat/mvp/orderlistscreen/IOrderListScreenPresenter;", "getMockedOrderListScreenPresenter", "()Llibrary/talabat/mvp/orderlistscreen/IOrderListScreenPresenter;", "setMockedOrderListScreenPresenter", "(Llibrary/talabat/mvp/orderlistscreen/IOrderListScreenPresenter;)V", "getOrderListPresenter", "appVersionProvider", "Lcom/talabat/configuration/discovery/AppVersionProvider;", "orderListScreenView", "Llibrary/talabat/mvp/orderlistscreen/OrderListScreenView;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "talabatExperiment", "Lcom/talabat/core/experiment/domain/ITalabatExperiment;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OrderListScreenDependencyProvider {
    @NotNull
    public static final OrderListScreenDependencyProvider INSTANCE = new OrderListScreenDependencyProvider();
    @Nullable
    private static IOrderListScreenPresenter mockedOrderListScreenPresenter;

    private OrderListScreenDependencyProvider() {
    }

    @JvmStatic
    @NotNull
    public static final IOrderListScreenPresenter getOrderListPresenter(@NotNull AppVersionProvider appVersionProvider, @NotNull OrderListScreenView orderListScreenView, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull ITalabatExperiment iTalabatExperiment) {
        Intrinsics.checkNotNullParameter(appVersionProvider, "appVersionProvider");
        Intrinsics.checkNotNullParameter(orderListScreenView, "orderListScreenView");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "talabatFeatureFlag");
        Intrinsics.checkNotNullParameter(iTalabatExperiment, "talabatExperiment");
        IOrderListScreenPresenter iOrderListScreenPresenter = mockedOrderListScreenPresenter;
        if (iOrderListScreenPresenter == null) {
            return new OrderListScreenPresenter(appVersionProvider, orderListScreenView, iTalabatFeatureFlag, iTalabatExperiment);
        }
        return iOrderListScreenPresenter;
    }

    @Nullable
    public final IOrderListScreenPresenter getMockedOrderListScreenPresenter() {
        return mockedOrderListScreenPresenter;
    }

    public final void setMockedOrderListScreenPresenter(@Nullable IOrderListScreenPresenter iOrderListScreenPresenter) {
        mockedOrderListScreenPresenter = iOrderListScreenPresenter;
    }
}
