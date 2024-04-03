package com.talabat.homescreen.orderstatus.data.remote.impl;

import com.talabat.homescreen.orderstatus.data.model.OrderStatusData;
import com.talabat.talabatcommon.extentions.RxKt;
import com.talabat.talabatcore.exception.Failure;
import io.reactivex.SingleEmitter;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/talabat/talabatcore/exception/Failure;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class OrderStatusesRemoteDataSourceImpl$fetchOrderStatuses$1$1 extends Lambda implements Function1<Failure, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SingleEmitter<List<OrderStatusData>> f60968g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OrderStatusesRemoteDataSourceImpl$fetchOrderStatuses$1$1(SingleEmitter<List<OrderStatusData>> singleEmitter) {
        super(1);
        this.f60968g = singleEmitter;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Failure) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Failure failure) {
        Intrinsics.checkNotNullParameter(failure, "it");
        SingleEmitter<List<OrderStatusData>> singleEmitter = this.f60968g;
        Intrinsics.checkNotNullExpressionValue(singleEmitter, "emitter");
        RxKt.onErrorIfNotDisposed(singleEmitter, failure);
    }
}
