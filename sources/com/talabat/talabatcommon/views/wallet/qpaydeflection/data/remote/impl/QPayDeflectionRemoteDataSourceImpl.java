package com.talabat.talabatcommon.views.wallet.qpaydeflection.data.remote.impl;

import com.talabat.talabatcommon.views.wallet.qpaydeflection.data.remote.QPayDeflectionRemoteDataSource;
import com.talabat.talabatcommon.views.wallet.qpaydeflection.data.remote.api.QPayDeflectionApi;
import com.talabat.talabatcommon.views.wallet.qpaydeflection.data.remote.dto.QPayDeflectionBinsResponseDto;
import com.talabat.talabatcommon.views.wallet.qpaydeflection.data.remote.dto.QPayStatusResponseDto;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u0011\u0010\n\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/qpaydeflection/data/remote/impl/QPayDeflectionRemoteDataSourceImpl;", "Lcom/talabat/talabatcommon/views/wallet/qpaydeflection/data/remote/QPayDeflectionRemoteDataSource;", "qPayDeflectionApi", "Lcom/talabat/talabatcommon/views/wallet/qpaydeflection/data/remote/api/QPayDeflectionApi;", "(Lcom/talabat/talabatcommon/views/wallet/qpaydeflection/data/remote/api/QPayDeflectionApi;)V", "getBins", "Lcom/talabat/talabatcommon/views/wallet/qpaydeflection/data/remote/dto/QPayDeflectionBinsResponseDto;", "binsCsv", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isServiceDown", "Lcom/talabat/talabatcommon/views/wallet/qpaydeflection/data/remote/dto/QPayStatusResponseDto;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class QPayDeflectionRemoteDataSourceImpl implements QPayDeflectionRemoteDataSource {
    @NotNull
    private final QPayDeflectionApi qPayDeflectionApi;

    public QPayDeflectionRemoteDataSourceImpl(@NotNull QPayDeflectionApi qPayDeflectionApi2) {
        Intrinsics.checkNotNullParameter(qPayDeflectionApi2, "qPayDeflectionApi");
        this.qPayDeflectionApi = qPayDeflectionApi2;
    }

    @Nullable
    public Object getBins(@NotNull String str, @NotNull Continuation<? super QPayDeflectionBinsResponseDto> continuation) {
        return this.qPayDeflectionApi.getBins(str, continuation);
    }

    @Nullable
    public Object isServiceDown(@NotNull Continuation<? super QPayStatusResponseDto> continuation) {
        return this.qPayDeflectionApi.isServiceDown(continuation);
    }
}
