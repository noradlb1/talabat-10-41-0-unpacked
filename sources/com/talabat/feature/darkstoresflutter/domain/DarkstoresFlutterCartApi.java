package com.talabat.feature.darkstoresflutter.domain;

import com.talabat.core.di.Api;
import com.talabat.feature.darkstoresflutter.domain.channel.DarkstoreCartEventStreamHandler;
import com.talabat.feature.darkstoresflutter.domain.channel.DarkstoresCartMethodCallHandler;
import com.talabat.feature.darkstoresflutter.domain.usecase.NavigateToCheckoutUseCase;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/talabat/feature/darkstoresflutter/domain/DarkstoresFlutterCartApi;", "Lcom/talabat/core/di/Api;", "darkstoreCartEventHandler", "Lcom/talabat/feature/darkstoresflutter/domain/channel/DarkstoreCartEventStreamHandler;", "darkstoresCartMethodCallHandler", "Lcom/talabat/feature/darkstoresflutter/domain/channel/DarkstoresCartMethodCallHandler;", "navigateToCheckoutUseCase", "Lcom/talabat/feature/darkstoresflutter/domain/usecase/NavigateToCheckoutUseCase;", "com_talabat_feature_darkstores-flutter_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface DarkstoresFlutterCartApi extends Api {
    @NotNull
    DarkstoreCartEventStreamHandler darkstoreCartEventHandler();

    @NotNull
    DarkstoresCartMethodCallHandler darkstoresCartMethodCallHandler();

    @NotNull
    NavigateToCheckoutUseCase navigateToCheckoutUseCase();
}
