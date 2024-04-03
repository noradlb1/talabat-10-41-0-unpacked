package com.talabat.core.dispatcher.data.di;

import com.talabat.core.dispatcher.data.RealCoroutineDispatchersFactory;
import com.talabat.core.dispatcher.data.RealRxSchedulersFactory;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.dispatcher.domain.RxSchedulersFactory;
import dagger.Binds;
import dagger.Module;
import dagger.Reusable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\bH'¨\u0006\t"}, d2 = {"Lcom/talabat/core/dispatcher/data/di/DispatcherCoreLibModule;", "", "coroutineDispatchersFactory", "Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;", "real", "Lcom/talabat/core/dispatcher/data/RealCoroutineDispatchersFactory;", "rxSchedulersFactory", "Lcom/talabat/core/dispatcher/domain/RxSchedulersFactory;", "Lcom/talabat/core/dispatcher/data/RealRxSchedulersFactory;", "com_talabat_core_dispatcher_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public interface DispatcherCoreLibModule {
    @NotNull
    @Binds
    @Reusable
    CoroutineDispatchersFactory coroutineDispatchersFactory(@NotNull RealCoroutineDispatchersFactory realCoroutineDispatchersFactory);

    @NotNull
    @Binds
    @Reusable
    RxSchedulersFactory rxSchedulersFactory(@NotNull RealRxSchedulersFactory realRxSchedulersFactory);
}
