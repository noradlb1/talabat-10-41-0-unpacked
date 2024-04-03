package com.talabat.feature.darkstoresflutter.data.di;

import com.talabat.feature.darkstoresflutter.data.repository.DarkstoresCartFlutterRepositoryImpl;
import com.talabat.feature.darkstoresflutter.domain.channel.DarkstoreCartEventStreamHandler;
import com.talabat.feature.darkstoresflutter.domain.channel.DarkstoreCartEventStreamHandlerImpl;
import com.talabat.feature.darkstoresflutter.domain.channel.DarkstoresCartMethodCallHandler;
import com.talabat.feature.darkstoresflutter.domain.channel.DarkstoresCartMethodCallHandlerImpl;
import com.talabat.feature.darkstoresflutter.domain.repository.DarkstoresCartFlutterRepository;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH'J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH'¨\u0006\u000e"}, d2 = {"Lcom/talabat/feature/darkstoresflutter/data/di/DarkstoresFlutterCartModule;", "", "bindDarkstoreCartEventStreamHandler", "Lcom/talabat/feature/darkstoresflutter/domain/channel/DarkstoreCartEventStreamHandler;", "darkstoreCartEventHandlerImpl", "Lcom/talabat/feature/darkstoresflutter/domain/channel/DarkstoreCartEventStreamHandlerImpl;", "bindDarkstoresCartFlutterRepository", "Lcom/talabat/feature/darkstoresflutter/domain/repository/DarkstoresCartFlutterRepository;", "darkstoresCartFlutterRepositoryImpl", "Lcom/talabat/feature/darkstoresflutter/data/repository/DarkstoresCartFlutterRepositoryImpl;", "bindDarkstoresCartMethodCallHandler", "Lcom/talabat/feature/darkstoresflutter/domain/channel/DarkstoresCartMethodCallHandler;", "darkstoresCartMethodCallHandlerImpl", "Lcom/talabat/feature/darkstoresflutter/domain/channel/DarkstoresCartMethodCallHandlerImpl;", "com_talabat_feature_darkstores-flutter_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public interface DarkstoresFlutterCartModule {
    @NotNull
    @Binds
    DarkstoreCartEventStreamHandler bindDarkstoreCartEventStreamHandler(@NotNull DarkstoreCartEventStreamHandlerImpl darkstoreCartEventStreamHandlerImpl);

    @NotNull
    @Binds
    DarkstoresCartFlutterRepository bindDarkstoresCartFlutterRepository(@NotNull DarkstoresCartFlutterRepositoryImpl darkstoresCartFlutterRepositoryImpl);

    @NotNull
    @Binds
    DarkstoresCartMethodCallHandler bindDarkstoresCartMethodCallHandler(@NotNull DarkstoresCartMethodCallHandlerImpl darkstoresCartMethodCallHandlerImpl);
}
