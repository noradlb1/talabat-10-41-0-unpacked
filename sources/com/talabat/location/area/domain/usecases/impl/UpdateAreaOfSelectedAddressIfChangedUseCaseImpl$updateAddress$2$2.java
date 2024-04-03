package com.talabat.location.area.domain.usecases.impl;

import com.talabat.user.address.domain.repository.CustomerAddressesRepository;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/talabat/user/address/domain/repository/CustomerAddressesRepository$Result;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class UpdateAreaOfSelectedAddressIfChangedUseCaseImpl$updateAddress$2$2<T> implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Continuation<Unit> f61032b;

    public UpdateAreaOfSelectedAddressIfChangedUseCaseImpl$updateAddress$2$2(Continuation<? super Unit> continuation) {
        this.f61032b = continuation;
    }

    public final void accept(CustomerAddressesRepository.Result result) {
        Continuation<Unit> continuation = this.f61032b;
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.m6329constructorimpl(Unit.INSTANCE));
    }
}
