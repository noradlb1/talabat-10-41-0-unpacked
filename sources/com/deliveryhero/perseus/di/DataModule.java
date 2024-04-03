package com.deliveryhero.perseus.di;

import androidx.work.WorkManager;
import com.deliveryhero.perseus.core.deviceinfo.DeviceInfoProvider;
import com.deliveryhero.perseus.core.session.AppSessionManager;
import com.deliveryhero.perseus.core.session.ClientIdProvider;
import com.deliveryhero.perseus.data.local.PerseusConfigLocalDataStoreImpl;
import com.deliveryhero.perseus.data.local.PerseusHitsLocalDataStoreImpl;
import com.deliveryhero.perseus.data.local.PerseusUserLocalDataStore;
import com.deliveryhero.perseus.data.local.db.entity.HitEventFactory;
import com.deliveryhero.perseus.data.remote.PerseusHitsRemoteDataStoreImpl;
import com.deliveryhero.perseus.hits.usecase.PerseusHitsRequestProviderImpl;
import com.deliveryhero.perseus.repository.PerseusHitsRepository;
import java.util.Calendar;
import kotlin.Lazy;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\u0006\u0010\u001c\u001a\u00020\u001dR\u001b\u0010\u0003\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8FX\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000e\u001a\u00020\u000f8FX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\b\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\u00148FX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\b\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001e"}, d2 = {"Lcom/deliveryhero/perseus/di/DataModule;", "", "()V", "perseusConfigLocalDataStore", "Lcom/deliveryhero/perseus/data/local/PerseusConfigLocalDataStoreImpl;", "getPerseusConfigLocalDataStore", "()Lcom/deliveryhero/perseus/data/local/PerseusConfigLocalDataStoreImpl;", "perseusConfigLocalDataStore$delegate", "Lkotlin/Lazy;", "perseusHitsRepository", "Lcom/deliveryhero/perseus/repository/PerseusHitsRepository;", "getPerseusHitsRepository", "()Lcom/deliveryhero/perseus/repository/PerseusHitsRepository;", "perseusHitsRepository$delegate", "perseusUserLocalDataStore", "Lcom/deliveryhero/perseus/data/local/PerseusUserLocalDataStore;", "getPerseusUserLocalDataStore", "()Lcom/deliveryhero/perseus/data/local/PerseusUserLocalDataStore;", "perseusUserLocalDataStore$delegate", "workManager", "Landroidx/work/WorkManager;", "getWorkManager", "()Landroidx/work/WorkManager;", "workManager$delegate", "getPerseusHitsLocalDataStore", "Lcom/deliveryhero/perseus/data/local/PerseusHitsLocalDataStoreImpl;", "getPerseusHitsRemoteDataStore", "Lcom/deliveryhero/perseus/data/remote/PerseusHitsRemoteDataStoreImpl;", "getPerseusHitsRequestProvider", "Lcom/deliveryhero/perseus/hits/usecase/PerseusHitsRequestProviderImpl;", "perseus_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DataModule {
    @NotNull
    public static final DataModule INSTANCE = new DataModule();
    @NotNull
    private static final Lazy perseusConfigLocalDataStore$delegate = LazyKt__LazyJVMKt.lazy(DataModule$perseusConfigLocalDataStore$2.INSTANCE);
    @NotNull
    private static final Lazy perseusHitsRepository$delegate = LazyKt__LazyJVMKt.lazy(DataModule$perseusHitsRepository$2.INSTANCE);
    @NotNull
    private static final Lazy perseusUserLocalDataStore$delegate = LazyKt__LazyJVMKt.lazy(DataModule$perseusUserLocalDataStore$2.INSTANCE);
    @NotNull
    private static final Lazy workManager$delegate = LazyKt__LazyJVMKt.lazy(DataModule$workManager$2.INSTANCE);

    private DataModule() {
    }

    /* access modifiers changed from: private */
    public final PerseusHitsRemoteDataStoreImpl getPerseusHitsRemoteDataStore() {
        return new PerseusHitsRemoteDataStoreImpl(NetworkModule.INSTANCE.getPerseusHitsApi(), CoreModule.INSTANCE.getPerseusConfigProvider());
    }

    @NotNull
    public final PerseusConfigLocalDataStoreImpl getPerseusConfigLocalDataStore() {
        return (PerseusConfigLocalDataStoreImpl) perseusConfigLocalDataStore$delegate.getValue();
    }

    @NotNull
    public final PerseusHitsLocalDataStoreImpl getPerseusHitsLocalDataStore() {
        return new PerseusHitsLocalDataStoreImpl(DatabaseModule.INSTANCE.getTrackingDatabase(), CoreModule.INSTANCE.getPerseusConfigProvider());
    }

    @NotNull
    public final PerseusHitsRepository getPerseusHitsRepository() {
        return (PerseusHitsRepository) perseusHitsRepository$delegate.getValue();
    }

    @NotNull
    public final PerseusHitsRequestProviderImpl getPerseusHitsRequestProvider() {
        CoreModule coreModule = CoreModule.INSTANCE;
        AppSessionManager appSessionManager = coreModule.getAppSessionManager();
        ClientIdProvider clientIdProvider = coreModule.getClientIdProvider();
        DeviceInfoProvider deviceInfoProvider = coreModule.getDeviceInfoProvider();
        Calendar clock = DatabaseModule.INSTANCE.clock();
        return new PerseusHitsRequestProviderImpl(appSessionManager, clientIdProvider, coreModule.getPerseusConfigProvider(), new HitEventFactory(), deviceInfoProvider, clock);
    }

    @NotNull
    public final PerseusUserLocalDataStore getPerseusUserLocalDataStore() {
        return (PerseusUserLocalDataStore) perseusUserLocalDataStore$delegate.getValue();
    }

    @NotNull
    public final WorkManager getWorkManager() {
        return (WorkManager) workManager$delegate.getValue();
    }
}
