package com.talabat.feature.activecarts.domain.di;

import com.talabat.core.di.Api;
import com.talabat.feature.activecarts.domain.channel.ActiveCartsMethodCallHandler;
import com.talabat.feature.activecarts.domain.usecase.GetQCommerceCartListUseCase;
import kotlin.Metadata;
import library.talabat.mvp.home.domain.GetActiveCartInfoUseCase;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/talabat/feature/activecarts/domain/di/ActiveCartsApi;", "Lcom/talabat/core/di/Api;", "activeCartsMethodCallHandler", "Lcom/talabat/feature/activecarts/domain/channel/ActiveCartsMethodCallHandler;", "getActiveCartInfoUseCase", "Llibrary/talabat/mvp/home/domain/GetActiveCartInfoUseCase;", "getQCommerceCartListUseCase", "Lcom/talabat/feature/activecarts/domain/usecase/GetQCommerceCartListUseCase;", "com_talabat_feature_active-carts_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ActiveCartsApi extends Api {
    @NotNull
    ActiveCartsMethodCallHandler activeCartsMethodCallHandler();

    @NotNull
    GetActiveCartInfoUseCase getActiveCartInfoUseCase();

    @NotNull
    GetQCommerceCartListUseCase getQCommerceCartListUseCase();
}
