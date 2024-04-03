package com.talabat.talabatlife.ui.vendorOffers;

import android.content.Context;
import com.talabat.talabatcommon.extentions.SafeLetKt;
import com.talabat.talabatlife.ui.vendorList.model.VendorDisplayModel;
import com.talabat.talabatlife.ui.vendorOffers.model.VendorBranchListDisplayModel;
import com.talabat.talabatlife.ui.vendorOffers.model.VendorOfferDisplayModel;
import com.talabat.talabatlife.ui.vendorOffers.model.VendorOfferListDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/talabat/talabatlife/ui/vendorOffers/VendorOffersAnalytics;", "", "()V", "Companion", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorOffersAnalytics {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ,\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\nH\u0002¨\u0006\u0011"}, d2 = {"Lcom/talabat/talabatlife/ui/vendorOffers/VendorOffersAnalytics$Companion;", "", "()V", "fireOfferTrackingEvent", "", "context", "Landroid/content/Context;", "vendorDisplayModel", "Lcom/talabat/talabatlife/ui/vendorList/model/VendorDisplayModel;", "offerListDisplayModel", "Lcom/talabat/talabatlife/ui/vendorOffers/model/VendorOfferListDisplayModel;", "branchListDisplayModel", "Lcom/talabat/talabatlife/ui/vendorOffers/model/VendorBranchListDisplayModel;", "fireQRTrackingEvent", "getOffersNames", "", "offers", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final String getOffersNames(VendorOfferListDisplayModel vendorOfferListDisplayModel) {
            boolean z11;
            String str = "";
            for (VendorOfferDisplayModel vendorOfferDisplayModel : vendorOfferListDisplayModel.getOfferList()) {
                if (str.length() > 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    str = str + IndicativeSentencesGeneration.DEFAULT_SEPARATOR;
                }
                str = str + vendorOfferDisplayModel.getTitle();
            }
            return str;
        }

        public final void fireOfferTrackingEvent(@Nullable Context context, @Nullable VendorDisplayModel vendorDisplayModel, @Nullable VendorOfferListDisplayModel vendorOfferListDisplayModel, @Nullable VendorBranchListDisplayModel vendorBranchListDisplayModel) {
            if (context != null) {
                Unit unit = (Unit) SafeLetKt.safeLet(vendorDisplayModel, vendorOfferListDisplayModel, vendorBranchListDisplayModel, VendorOffersAnalytics$Companion$fireOfferTrackingEvent$1$1.INSTANCE);
            }
        }

        public final void fireQRTrackingEvent(@NotNull Context context, @Nullable VendorDisplayModel vendorDisplayModel, @Nullable VendorOfferListDisplayModel vendorOfferListDisplayModel, @Nullable VendorBranchListDisplayModel vendorBranchListDisplayModel) {
            Intrinsics.checkNotNullParameter(context, "context");
            Unit unit = (Unit) SafeLetKt.safeLet(vendorDisplayModel, vendorOfferListDisplayModel, vendorBranchListDisplayModel, VendorOffersAnalytics$Companion$fireQRTrackingEvent$1$1.INSTANCE);
        }
    }
}
