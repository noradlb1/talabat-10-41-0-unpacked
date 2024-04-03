package com.talabat.darkstores.di;

import com.talabat.darkstores.di.qualifier.IoScheduler;
import com.talabat.darkstores.di.qualifier.UiScheduler;
import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007¨\u0006\u0006"}, d2 = {"Lcom/talabat/darkstores/di/DarkstoresSchedulersModule;", "", "()V", "provideIoScheduler", "Lio/reactivex/Scheduler;", "provideMainScheduler", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class DarkstoresSchedulersModule {
    @NotNull
    public static final DarkstoresSchedulersModule INSTANCE = new DarkstoresSchedulersModule();

    private DarkstoresSchedulersModule() {
    }

    @IoScheduler
    @NotNull
    @Provides
    public final Scheduler provideIoScheduler() {
        Scheduler io2 = Schedulers.io();
        Intrinsics.checkNotNullExpressionValue(io2, "io()");
        return io2;
    }

    @NotNull
    @UiScheduler
    @Provides
    public final Scheduler provideMainScheduler() {
        Scheduler mainThread = AndroidSchedulers.mainThread();
        Intrinsics.checkNotNullExpressionValue(mainThread, "mainThread()");
        return mainThread;
    }
}
