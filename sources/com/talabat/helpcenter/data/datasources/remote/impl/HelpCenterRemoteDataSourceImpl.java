package com.talabat.helpcenter.data.datasources.remote.impl;

import com.talabat.helpcenter.data.datasources.remote.HelpCenterRemoteDataSource;
import com.talabat.helpcenter.data.datasources.remote.dto.GlobalHelpCenterConfigResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JE\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lcom/talabat/helpcenter/data/datasources/remote/impl/HelpCenterRemoteDataSourceImpl;", "Lcom/talabat/helpcenter/data/datasources/remote/HelpCenterRemoteDataSource;", "poeRetrofitService", "Lcom/talabat/helpcenter/data/datasources/remote/impl/PoeRetrofitService;", "(Lcom/talabat/helpcenter/data/datasources/remote/impl/PoeRetrofitService;)V", "getGlobalHelpCenterConfig", "Lcom/talabat/helpcenter/data/datasources/remote/dto/GlobalHelpCenterConfigResponse;", "orderId", "", "caseId", "language", "country", "", "appVersion", "appPlatform", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_TalabatHelpCenter_TalabatHelpCenter"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HelpCenterRemoteDataSourceImpl implements HelpCenterRemoteDataSource {
    @NotNull
    private final PoeRetrofitService poeRetrofitService;

    public HelpCenterRemoteDataSourceImpl(@NotNull PoeRetrofitService poeRetrofitService2) {
        Intrinsics.checkNotNullParameter(poeRetrofitService2, "poeRetrofitService");
        this.poeRetrofitService = poeRetrofitService2;
    }

    @Nullable
    public Object getGlobalHelpCenterConfig(@Nullable String str, @Nullable String str2, @NotNull String str3, int i11, @NotNull String str4, @NotNull String str5, @NotNull Continuation<? super GlobalHelpCenterConfigResponse> continuation) {
        return this.poeRetrofitService.getGlobalHelpCenterConfig(str, str2, str3, i11, str4, str5, continuation);
    }
}
