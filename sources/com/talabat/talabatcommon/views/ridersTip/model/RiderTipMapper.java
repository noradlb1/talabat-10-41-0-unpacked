package com.talabat.talabatcommon.views.ridersTip.model;

import com.talabat.talabatcommon.extentions.FloatKt;
import com.talabat.talabatcommon.extentions.IntKt;
import com.talabat.talabatcommon.feature.ridersTip.model.RiderTipPaymentResponse;
import com.talabat.talabatcommon.feature.ridersTip.model.RiderTipPaymentResponseResult;
import com.talabat.talabatcommon.feature.ridersTip.model.RiderTipSuggestedAmountResponse;
import com.talabat.talabatcommon.feature.ridersTip.model.SuggestedAmountModel;
import com.talabat.talabatcommon.utils.DateUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/talabat/talabatcommon/views/ridersTip/model/RiderTipMapper;", "", "()V", "Companion", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RiderTipMapper {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\u0011¨\u0006\u0012"}, d2 = {"Lcom/talabat/talabatcommon/views/ridersTip/model/RiderTipMapper$Companion;", "", "()V", "isRiderTipWithinExpiryTime", "", "orderReceivedTime", "", "stringFormat", "expiryDay", "", "mapRiderTipPaymentResponseToDisplayModel", "Lcom/talabat/talabatcommon/views/ridersTip/model/RiderTipPaymentDisplayModel;", "response", "Lcom/talabat/talabatcommon/feature/ridersTip/model/RiderTipPaymentResponse;", "mapRidersTipSuggestedAmountToDisplayModel", "", "Lcom/talabat/talabatcommon/views/ridersTip/model/RidersTipSuggestedAmountDisplayModel;", "Lcom/talabat/talabatcommon/feature/ridersTip/model/RiderTipSuggestedAmountResponse;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean isRiderTipWithinExpiryTime(@NotNull String str, @NotNull String str2, int i11) {
            Intrinsics.checkNotNullParameter(str, "orderReceivedTime");
            Intrinsics.checkNotNullParameter(str2, "stringFormat");
            try {
                Date date = new Date();
                Date convertFromStringToDate = DateUtils.Companion.convertFromStringToDate(str, str2);
                if (convertFromStringToDate == null) {
                    return false;
                }
                if ((date.getTime() - convertFromStringToDate.getTime()) / ((long) 86400000) <= ((long) i11)) {
                    return true;
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }

        @NotNull
        public final RiderTipPaymentDisplayModel mapRiderTipPaymentResponseToDisplayModel(@Nullable RiderTipPaymentResponse riderTipPaymentResponse) {
            RiderTipPaymentResponseResult result;
            RiderTipPaymentDisplayModel riderTipPaymentDisplayModel = new RiderTipPaymentDisplayModel();
            if (!(riderTipPaymentResponse == null || (result = riderTipPaymentResponse.getResult()) == null)) {
                String message = result.getMessage();
                String str = "";
                if (message == null) {
                    message = str;
                }
                riderTipPaymentDisplayModel.setMessage(message);
                String walletTransactionId = result.getWalletTransactionId();
                if (walletTransactionId != null) {
                    str = walletTransactionId;
                }
                riderTipPaymentDisplayModel.setWalletTransactionId(str);
                riderTipPaymentDisplayModel.setWalletTransactionStatus(IntKt.orZero(result.getWalletTransactionStatus()));
            }
            return riderTipPaymentDisplayModel;
        }

        @NotNull
        public final List<RidersTipSuggestedAmountDisplayModel> mapRidersTipSuggestedAmountToDisplayModel(@Nullable RiderTipSuggestedAmountResponse riderTipSuggestedAmountResponse) {
            List<SuggestedAmountModel> result;
            ArrayList arrayList = new ArrayList();
            if (!(riderTipSuggestedAmountResponse == null || (result = riderTipSuggestedAmountResponse.getResult()) == null)) {
                for (SuggestedAmountModel suggestedAmountModel : result) {
                    Float f11 = null;
                    RidersTipSuggestedAmountDisplayModel ridersTipSuggestedAmountDisplayModel = new RidersTipSuggestedAmountDisplayModel(0.0f, 1, (DefaultConstructorMarker) null);
                    if (suggestedAmountModel != null) {
                        f11 = suggestedAmountModel.getAmount();
                    }
                    ridersTipSuggestedAmountDisplayModel.setAmount(FloatKt.orZero(f11));
                    arrayList.add(ridersTipSuggestedAmountDisplayModel);
                }
            }
            return arrayList;
        }
    }
}
