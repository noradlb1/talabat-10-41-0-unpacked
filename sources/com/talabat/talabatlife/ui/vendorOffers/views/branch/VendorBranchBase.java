package com.talabat.talabatlife.ui.vendorOffers.views.branch;

import android.content.Context;
import android.view.View;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.talabat.localization.R;
import com.talabat.talabatcommon.extension.ViewKt;
import com.talabat.talabatlife.ui.vendorOffers.model.VendorBranchDisplayModel;
import com.talabat.talabatnavigation.NavigatorImplicitIntents;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import pw.a;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0007H\u0002J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, d2 = {"Lcom/talabat/talabatlife/ui/vendorOffers/views/branch/VendorBranchBase;", "", "getDistance", "", "itemView", "Landroid/view/View;", "distanceInMeters", "", "roundOff", "distance", "setMapsOnClickListener", "", "view", "model", "Lcom/talabat/talabatlife/ui/vendorOffers/model/VendorBranchDisplayModel;", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface VendorBranchBase {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        @NotNull
        public static String getDistance(@NotNull VendorBranchBase vendorBranchBase, @NotNull View view, double d11) {
            Intrinsics.checkNotNullParameter(view, "itemView");
            if (d11 < 1000.0d) {
                String roundOff = roundOff(vendorBranchBase, d11);
                String string = ViewKt.getString(view, R.string.meters);
                return roundOff + " " + string;
            }
            String roundOff2 = roundOff(vendorBranchBase, d11 / ((double) 1000));
            String string2 = ViewKt.getString(view, R.string.kilo_meters);
            return roundOff2 + " " + string2;
        }

        private static String roundOff(VendorBranchBase vendorBranchBase, double d11) {
            DecimalFormat decimalFormat = new DecimalFormat("#.#");
            decimalFormat.setRoundingMode(RoundingMode.FLOOR);
            String format = decimalFormat.format(d11);
            Intrinsics.checkNotNullExpressionValue(format, "DecimalFormat(DECIMAL_FO… FLOOR }.format(distance)");
            return format;
        }

        public static void setMapsOnClickListener(@NotNull VendorBranchBase vendorBranchBase, @NotNull View view, @NotNull VendorBranchDisplayModel vendorBranchDisplayModel) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(vendorBranchDisplayModel, DeviceRequestsHelper.DEVICE_INFO_MODEL);
            view.setOnClickListener(new a(view, vendorBranchDisplayModel));
        }

        /* access modifiers changed from: private */
        /* renamed from: setMapsOnClickListener$lambda-2  reason: not valid java name */
        public static void m5867setMapsOnClickListener$lambda2(View view, VendorBranchDisplayModel vendorBranchDisplayModel, View view2) {
            Intrinsics.checkNotNullParameter(view, "$view");
            Intrinsics.checkNotNullParameter(vendorBranchDisplayModel, "$model");
            Context context = view.getContext();
            if (context != null) {
                NavigatorImplicitIntents.Companion.loadMaps(context, vendorBranchDisplayModel.getLatitude(), vendorBranchDisplayModel.getLongitude());
            }
        }
    }

    @NotNull
    String getDistance(@NotNull View view, double d11);

    void setMapsOnClickListener(@NotNull View view, @NotNull VendorBranchDisplayModel vendorBranchDisplayModel);
}
