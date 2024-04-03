package com.talabat.feature.address.data.remote.impl;

import com.talabat.feature.address.data.remote.AddCustomerAddressException;
import com.talabat.feature.address.data.remote.AddressDtoMapper;
import com.talabat.feature.address.data.remote.AddressRemoteDataSource;
import com.talabat.feature.address.data.remote.DeleteCustomerAddressException;
import com.talabat.feature.address.data.remote.UpdateCustomerAddressException;
import com.talabat.feature.address.data.remote.api.AddressApi;
import com.talabat.feature.address.data.remote.dto.AddAddressDto;
import com.talabat.feature.address.data.remote.dto.AddressPayload;
import com.talabat.feature.address.data.remote.dto.UpdateAddressDto;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import javax.inject.Inject;
import kl.a;
import kl.b;
import kl.c;
import kl.d;
import kl.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/talabat/feature/address/data/remote/impl/AddressRemoteDataSourceImpl;", "Lcom/talabat/feature/address/data/remote/AddressRemoteDataSource;", "addressApi", "Lcom/talabat/feature/address/data/remote/api/AddressApi;", "addressDtoMapper", "Lcom/talabat/feature/address/data/remote/AddressDtoMapper;", "(Lcom/talabat/feature/address/data/remote/api/AddressApi;Lcom/talabat/feature/address/data/remote/AddressDtoMapper;)V", "addAddress", "Lio/reactivex/Single;", "Lcom/talabat/feature/address/data/remote/dto/AddAddressDto;", "addressPayload", "Lcom/talabat/feature/address/data/remote/dto/AddressPayload;", "deleteAddress", "Lio/reactivex/Completable;", "id", "", "updateAddress", "Lcom/talabat/feature/address/data/remote/dto/UpdateAddressDto;", "com_talabat_feature_address_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AddressRemoteDataSourceImpl implements AddressRemoteDataSource {
    @NotNull
    private final AddressApi addressApi;
    @NotNull
    private final AddressDtoMapper addressDtoMapper;

    @Inject
    public AddressRemoteDataSourceImpl(@NotNull AddressApi addressApi2, @NotNull AddressDtoMapper addressDtoMapper2) {
        Intrinsics.checkNotNullParameter(addressApi2, "addressApi");
        Intrinsics.checkNotNullParameter(addressDtoMapper2, "addressDtoMapper");
        this.addressApi = addressApi2;
        this.addressDtoMapper = addressDtoMapper2;
    }

    /* access modifiers changed from: private */
    /* renamed from: addAddress$lambda-0  reason: not valid java name */
    public static final SingleSource m10137addAddress$lambda0(Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "e");
        return Single.error((Throwable) new AddCustomerAddressException(th2));
    }

    /* access modifiers changed from: private */
    /* renamed from: deleteAddress$lambda-2  reason: not valid java name */
    public static final CompletableSource m10138deleteAddress$lambda2(Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "e");
        return Completable.error((Throwable) new DeleteCustomerAddressException(th2));
    }

    /* access modifiers changed from: private */
    /* renamed from: updateAddress$lambda-1  reason: not valid java name */
    public static final SingleSource m10139updateAddress$lambda1(Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "e");
        return Single.error((Throwable) new UpdateCustomerAddressException(th2));
    }

    @NotNull
    public Single<AddAddressDto> addAddress(@NotNull AddressPayload addressPayload) {
        Intrinsics.checkNotNullParameter(addressPayload, "addressPayload");
        Single<R> onErrorResumeNext = this.addressApi.addAddress(this.addressDtoMapper.mapToAddressBody(addressPayload)).map(new d(this.addressDtoMapper)).onErrorResumeNext(new e());
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "addressApi\n            .…merAddressException(e)) }");
        return onErrorResumeNext;
    }

    @NotNull
    public Completable deleteAddress(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        Completable onErrorResumeNext = this.addressApi.deleteAddress(str).onErrorResumeNext(new c());
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "addressApi\n            .…merAddressException(e)) }");
        return onErrorResumeNext;
    }

    @NotNull
    public Single<UpdateAddressDto> updateAddress(@NotNull String str, @NotNull AddressPayload addressPayload) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(addressPayload, "addressPayload");
        Single<R> onErrorResumeNext = this.addressApi.updateAddress(str, this.addressDtoMapper.mapToAddressBody(addressPayload)).map(new a(this.addressDtoMapper)).onErrorResumeNext(new b());
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "addressApi\n            .…merAddressException(e)) }");
        return onErrorResumeNext;
    }
}
