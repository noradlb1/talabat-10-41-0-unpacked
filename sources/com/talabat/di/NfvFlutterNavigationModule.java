package com.talabat.di;

import dagger.Binds;
import dagger.Module;
import dagger.Reusable;
import kotlin.Metadata;
import library.talabat.mvp.home.IsNfvFlutterNavigationUsecase;
import library.talabat.mvp.home.IsNfvFlutterNavigationUsecaseImpl;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\ba\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'¨\u0006\u0006"}, d2 = {"Lcom/talabat/di/NfvFlutterNavigationModule;", "", "provideIsNfvFlutterNavigationUsecaseImpl", "Llibrary/talabat/mvp/home/IsNfvFlutterNavigationUsecase;", "impl", "Llibrary/talabat/mvp/home/IsNfvFlutterNavigationUsecaseImpl;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public interface NfvFlutterNavigationModule {
    @NotNull
    @Binds
    @Reusable
    IsNfvFlutterNavigationUsecase provideIsNfvFlutterNavigationUsecaseImpl(@NotNull IsNfvFlutterNavigationUsecaseImpl isNfvFlutterNavigationUsecaseImpl);
}
