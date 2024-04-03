package library.talabat.mvp.login.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.mvp.login.data.api.response.DeliveryAreaDetails;
import library.talabat.mvp.login.data.api.response.DeliveryAreaDetailsResponse;
import library.talabat.mvp.login.data.api.response.Error;
import library.talabat.mvp.login.data.api.response.Result;
import library.talabat.mvp.login.domain.model.DeliveryAreaDetailsModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¨\u0006\u0004"}, d2 = {"map", "Llibrary/talabat/mvp/login/domain/model/DeliveryAreaDetailsModel;", "deliveryAreaDetailsResponse", "Llibrary/talabat/mvp/login/data/api/response/DeliveryAreaDetailsResponse;", "com_talabat_talabatlib_talabatlib"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class MappersKt {
    @NotNull
    public static final DeliveryAreaDetailsModel map(@Nullable DeliveryAreaDetailsResponse deliveryAreaDetailsResponse) {
        boolean z11;
        long j11;
        long j12;
        String str;
        long j13;
        long j14;
        long j15;
        long j16;
        long j17;
        long j18;
        long j19;
        long j21;
        long j22;
        long j23;
        long j24;
        DeliveryAreaDetails deliveryAreaDetails;
        Long chnid;
        DeliveryAreaDetails deliveryAreaDetails2;
        Long vndid;
        DeliveryAreaDetails deliveryAreaDetails3;
        Long mntxv;
        DeliveryAreaDetails deliveryAreaDetails4;
        Long mntxt;
        DeliveryAreaDetails deliveryAreaDetails5;
        Long dlvtm;
        DeliveryAreaDetails deliveryAreaDetails6;
        Long mnovl;
        DeliveryAreaDetails deliveryAreaDetails7;
        Long dlfev;
        DeliveryAreaDetails deliveryAreaDetails8;
        Long dlfet;
        DeliveryAreaDetails deliveryAreaDetails9;
        Long tstxv;
        DeliveryAreaDetails deliveryAreaDetails10;
        Long tstxt;
        DeliveryAreaDetails deliveryAreaDetails11;
        Long dlvst;
        DeliveryAreaDetails deliveryAreaDetails12;
        String pdvid;
        DeliveryAreaDetails deliveryAreaDetails13;
        Long dlvid;
        DeliveryAreaDetails deliveryAreaDetails14;
        Long cvgid;
        DeliveryAreaDetails deliveryAreaDetails15;
        Boolean istgo;
        String str2;
        String str3;
        String message;
        if (deliveryAreaDetailsResponse == null) {
            return DeliveryAreaDetailsModel.Unavailable.INSTANCE;
        }
        String str4 = "";
        if (Intrinsics.areEqual((Object) deliveryAreaDetailsResponse.getHasError(), (Object) Boolean.TRUE)) {
            Error error = deliveryAreaDetailsResponse.getError();
            if (error == null || (str2 = error.getErrorCode()) == null) {
                str2 = str4;
            }
            Error error2 = deliveryAreaDetailsResponse.getError();
            if (error2 == null || (str3 = error2.getTitle()) == null) {
                str3 = str4;
            }
            Error error3 = deliveryAreaDetailsResponse.getError();
            if (!(error3 == null || (message = error3.getMessage()) == null)) {
                str4 = message;
            }
            return new DeliveryAreaDetailsModel.Error(str2, str3, str4);
        }
        Result result = deliveryAreaDetailsResponse.getResult();
        if (result == null || (deliveryAreaDetails15 = result.getDeliveryAreaDetails()) == null || (istgo = deliveryAreaDetails15.getIstgo()) == null) {
            z11 = false;
        } else {
            z11 = istgo.booleanValue();
        }
        boolean z12 = z11;
        Result result2 = deliveryAreaDetailsResponse.getResult();
        if (result2 == null || (deliveryAreaDetails14 = result2.getDeliveryAreaDetails()) == null || (cvgid = deliveryAreaDetails14.getCvgid()) == null) {
            j11 = -1;
        } else {
            j11 = cvgid.longValue();
        }
        Result result3 = deliveryAreaDetailsResponse.getResult();
        if (result3 == null || (deliveryAreaDetails13 = result3.getDeliveryAreaDetails()) == null || (dlvid = deliveryAreaDetails13.getDlvid()) == null) {
            j12 = -1;
        } else {
            j12 = dlvid.longValue();
        }
        Result result4 = deliveryAreaDetailsResponse.getResult();
        if (result4 == null || (deliveryAreaDetails12 = result4.getDeliveryAreaDetails()) == null || (pdvid = deliveryAreaDetails12.getPdvid()) == null) {
            str = str4;
        } else {
            str = pdvid;
        }
        Result result5 = deliveryAreaDetailsResponse.getResult();
        if (result5 == null || (deliveryAreaDetails11 = result5.getDeliveryAreaDetails()) == null || (dlvst = deliveryAreaDetails11.getDlvst()) == null) {
            j13 = -1;
        } else {
            j13 = dlvst.longValue();
        }
        Result result6 = deliveryAreaDetailsResponse.getResult();
        if (result6 == null || (deliveryAreaDetails10 = result6.getDeliveryAreaDetails()) == null || (tstxt = deliveryAreaDetails10.getTstxt()) == null) {
            j14 = -1;
        } else {
            j14 = tstxt.longValue();
        }
        Result result7 = deliveryAreaDetailsResponse.getResult();
        if (result7 == null || (deliveryAreaDetails9 = result7.getDeliveryAreaDetails()) == null || (tstxv = deliveryAreaDetails9.getTstxv()) == null) {
            j15 = -1;
        } else {
            j15 = tstxv.longValue();
        }
        Result result8 = deliveryAreaDetailsResponse.getResult();
        if (result8 == null || (deliveryAreaDetails8 = result8.getDeliveryAreaDetails()) == null || (dlfet = deliveryAreaDetails8.getDlfet()) == null) {
            j16 = -1;
        } else {
            j16 = dlfet.longValue();
        }
        Result result9 = deliveryAreaDetailsResponse.getResult();
        if (result9 == null || (deliveryAreaDetails7 = result9.getDeliveryAreaDetails()) == null || (dlfev = deliveryAreaDetails7.getDlfev()) == null) {
            j17 = -1;
        } else {
            j17 = dlfev.longValue();
        }
        Result result10 = deliveryAreaDetailsResponse.getResult();
        if (result10 == null || (deliveryAreaDetails6 = result10.getDeliveryAreaDetails()) == null || (mnovl = deliveryAreaDetails6.getMnovl()) == null) {
            j18 = -1;
        } else {
            j18 = mnovl.longValue();
        }
        Result result11 = deliveryAreaDetailsResponse.getResult();
        if (result11 == null || (deliveryAreaDetails5 = result11.getDeliveryAreaDetails()) == null || (dlvtm = deliveryAreaDetails5.getDlvtm()) == null) {
            j19 = -1;
        } else {
            j19 = dlvtm.longValue();
        }
        Result result12 = deliveryAreaDetailsResponse.getResult();
        if (result12 == null || (deliveryAreaDetails4 = result12.getDeliveryAreaDetails()) == null || (mntxt = deliveryAreaDetails4.getMntxt()) == null) {
            j21 = -1;
        } else {
            j21 = mntxt.longValue();
        }
        Result result13 = deliveryAreaDetailsResponse.getResult();
        if (result13 == null || (deliveryAreaDetails3 = result13.getDeliveryAreaDetails()) == null || (mntxv = deliveryAreaDetails3.getMntxv()) == null) {
            j22 = -1;
        } else {
            j22 = mntxv.longValue();
        }
        Result result14 = deliveryAreaDetailsResponse.getResult();
        if (result14 == null || (deliveryAreaDetails2 = result14.getDeliveryAreaDetails()) == null || (vndid = deliveryAreaDetails2.getVndid()) == null) {
            j23 = -1;
        } else {
            j23 = vndid.longValue();
        }
        Result result15 = deliveryAreaDetailsResponse.getResult();
        if (result15 == null || (deliveryAreaDetails = result15.getDeliveryAreaDetails()) == null || (chnid = deliveryAreaDetails.getChnid()) == null) {
            j24 = -1;
        } else {
            j24 = chnid.longValue();
        }
        return new DeliveryAreaDetailsModel.Available(z12, j11, j12, str, j13, j14, j15, j16, j17, j18, j19, j21, j22, j23, j24);
    }
}
