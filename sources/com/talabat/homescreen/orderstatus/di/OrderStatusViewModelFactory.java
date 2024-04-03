package com.talabat.homescreen.orderstatus.di;

import android.content.Context;
import android.content.res.Resources;
import com.talabat.core.network.endpoint.MonolithEndPointProvider;
import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.fluid.homescreen.data.impl.HomeScreenTrackerImpl;
import com.talabat.fluid.homescreen.domain.tracking.LocationDataFactory;
import com.talabat.homescreen.network.apiweb.ApiWebApi;
import com.talabat.homescreen.orderstatus.data.impl.OrderStatusRepositoryImpl;
import com.talabat.homescreen.orderstatus.data.remote.OrderStatusesRemoteDataSource;
import com.talabat.homescreen.orderstatus.data.remote.impl.OrderStatusesRemoteDataSourceImpl;
import com.talabat.homescreen.orderstatus.domain.repository.OrderStatusRepository;
import com.talabat.homescreen.orderstatus.domain.usecase.business.impl.ObserveOrderStatusesUseCaseImpl;
import com.talabat.homescreen.orderstatus.domain.usecase.business.impl.TrackOrderStatusClickUseCaseImpl;
import com.talabat.homescreen.orderstatus.presentation.observability.OrderStatusUpdateTracker;
import com.talabat.homescreen.orderstatus.presentation.provider.impl.StringProviderImpl;
import com.talabat.homescreen.orderstatus.presentation.viewmodel.OrderStatusViewModel;
import com.talabat.talabatcore.platform.NetworkHandler;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tracking.gtm.TalabatFirebase;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\r"}, d2 = {"Lcom/talabat/homescreen/orderstatus/di/OrderStatusViewModelFactory;", "", "()V", "create", "Lcom/talabat/homescreen/orderstatus/presentation/viewmodel/OrderStatusViewModel;", "context", "Landroid/content/Context;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "createOrderStatusRepository", "Lcom/talabat/homescreen/orderstatus/domain/repository/OrderStatusRepository;", "createOrderStatusesRemoteDataSource", "Lcom/talabat/homescreen/orderstatus/data/remote/OrderStatusesRemoteDataSource;", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OrderStatusViewModelFactory {
    @NotNull
    public static final OrderStatusViewModelFactory INSTANCE = new OrderStatusViewModelFactory();

    private OrderStatusViewModelFactory() {
    }

    private final OrderStatusRepository createOrderStatusRepository(Context context) {
        OrderStatusesRemoteDataSource createOrderStatusesRemoteDataSource = createOrderStatusesRemoteDataSource(context);
        Scheduler io2 = Schedulers.io();
        Intrinsics.checkNotNullExpressionValue(io2, "io()");
        return new OrderStatusRepositoryImpl(createOrderStatusesRemoteDataSource, io2);
    }

    private final OrderStatusesRemoteDataSource createOrderStatusesRemoteDataSource(Context context) {
        return new OrderStatusesRemoteDataSourceImpl((ApiWebApi) new TalabatAPIBuilder().createApi(MonolithEndPointProvider.INSTANCE.getBaseUrl(), ApiWebApi.class), new NetworkHandler(context));
    }

    @NotNull
    public final OrderStatusViewModel create(@NotNull Context context, @NotNull IObservabilityManager iObservabilityManager) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
        ObserveOrderStatusesUseCaseImpl observeOrderStatusesUseCaseImpl = new ObserveOrderStatusesUseCaseImpl(createOrderStatusRepository(context));
        TrackOrderStatusClickUseCaseImpl trackOrderStatusClickUseCaseImpl = new TrackOrderStatusClickUseCaseImpl(new HomeScreenTrackerImpl(context, new TalabatFirebase(), (TalabatTracker) null, 4, (DefaultConstructorMarker) null), OrderStatusViewModelFactory$create$1.INSTANCE, new LocationDataFactory((Function0) null, (Function0) null, (Function0) null, (Function0) null, 15, (DefaultConstructorMarker) null));
        Scheduler mainThread = AndroidSchedulers.mainThread();
        Intrinsics.checkNotNullExpressionValue(mainThread, "mainThread()");
        Scheduler io2 = Schedulers.io();
        Intrinsics.checkNotNullExpressionValue(io2, "io()");
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
        return new OrderStatusViewModel(observeOrderStatusesUseCaseImpl, trackOrderStatusClickUseCaseImpl, mainThread, io2, new StringProviderImpl(resources), (OrderStatusUpdateTracker) null, iObservabilityManager, 32, (DefaultConstructorMarker) null);
    }
}
