package library.talabat.mvp.login.data.repository.impl;

import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.mvp.login.data.MappersKt;
import library.talabat.mvp.login.data.api.DeliveryAreaDetailsApi;
import library.talabat.mvp.login.data.api.response.DeliveryAreaDetailsResponse;
import library.talabat.mvp.login.domain.model.DeliveryAreaDetailsModel;
import library.talabat.mvp.login.domain.repository.DeliveryAreaDetailsRepository;
import org.jetbrains.annotations.NotNull;
import q10.a;
import q10.b;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J&\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Llibrary/talabat/mvp/login/data/repository/impl/DeliveryAreaDetailsRepositoryImpl;", "Llibrary/talabat/mvp/login/domain/repository/DeliveryAreaDetailsRepository;", "deliveryAreaDetailsApi", "Llibrary/talabat/mvp/login/data/api/DeliveryAreaDetailsApi;", "(Llibrary/talabat/mvp/login/data/api/DeliveryAreaDetailsApi;)V", "getDeliveryAreaDetails", "Lio/reactivex/Single;", "Llibrary/talabat/mvp/login/domain/model/DeliveryAreaDetailsModel;", "vendorId", "", "latitude", "", "longitude", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DeliveryAreaDetailsRepositoryImpl implements DeliveryAreaDetailsRepository {
    @NotNull
    private final DeliveryAreaDetailsApi deliveryAreaDetailsApi;

    public DeliveryAreaDetailsRepositoryImpl(@NotNull DeliveryAreaDetailsApi deliveryAreaDetailsApi2) {
        Intrinsics.checkNotNullParameter(deliveryAreaDetailsApi2, "deliveryAreaDetailsApi");
        this.deliveryAreaDetailsApi = deliveryAreaDetailsApi2;
    }

    /* access modifiers changed from: private */
    /* renamed from: getDeliveryAreaDetails$lambda-0  reason: not valid java name */
    public static final DeliveryAreaDetailsModel m7901getDeliveryAreaDetails$lambda0(DeliveryAreaDetailsResponse deliveryAreaDetailsResponse) {
        Intrinsics.checkNotNullParameter(deliveryAreaDetailsResponse, "it");
        return MappersKt.map(deliveryAreaDetailsResponse);
    }

    /* access modifiers changed from: private */
    /* renamed from: getDeliveryAreaDetails$lambda-1  reason: not valid java name */
    public static final DeliveryAreaDetailsModel m7902getDeliveryAreaDetails$lambda1(Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "it");
        String message = th2.getMessage();
        if (message == null) {
            message = "";
        }
        return new DeliveryAreaDetailsModel.Error("", "An error occurred while calling API", message);
    }

    @NotNull
    public Single<DeliveryAreaDetailsModel> getDeliveryAreaDetails(long j11, double d11, double d12) {
        Single<R> onErrorReturn = this.deliveryAreaDetailsApi.getDeliveryAreaDetails(j11, d11, d12).map(new a()).onErrorReturn(new b());
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "deliveryAreaDetailsApi.g…          )\n            }");
        return onErrorReturn;
    }
}
