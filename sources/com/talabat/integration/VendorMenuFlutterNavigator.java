package com.talabat.integration;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.deliveryhero.performance.core.screenmetric.performance.RichContentLoadTimeRecorder;
import com.talabat.R;
import com.talabat.busypopup.BusyPopupBottomSheet;
import com.talabat.helpers.BusyPopupDialogFragmentListener;
import com.talabat.talabatcommon.ports.VendorMenuFlutterNavigatorPort;
import com.talabat.talabatcommon.ports.dto.VendorBusyPopupCallArguments;
import com.tekartik.sqflite.Constant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/talabat/integration/VendorMenuFlutterNavigator;", "Lcom/talabat/talabatcommon/ports/VendorMenuFlutterNavigatorPort;", "()V", "navigateToBusyBottomSheet", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "arguments", "Lcom/talabat/talabatcommon/ports/dto/VendorBusyPopupCallArguments;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorMenuFlutterNavigator implements VendorMenuFlutterNavigatorPort {
    public void navigateToBusyBottomSheet(@NotNull FragmentActivity fragmentActivity, @NotNull VendorBusyPopupCallArguments vendorBusyPopupCallArguments) {
        String str;
        String str2;
        int i11;
        boolean z11;
        Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
        Intrinsics.checkNotNullParameter(vendorBusyPopupCallArguments, Constant.PARAM_SQL_ARGUMENTS);
        if (vendorBusyPopupCallArguments.isTGO()) {
            str = fragmentActivity.getResources().getString(R.string.shop_busy_main_text_tgo);
            Intrinsics.checkNotNullExpressionValue(str, "activity.getResources()\n….shop_busy_main_text_tgo)");
        } else {
            String string = fragmentActivity.getResources().getString(R.string.shop_busy_main_text_tmp);
            Intrinsics.checkNotNullExpressionValue(string, "activity.getResources()\n….shop_busy_main_text_tmp)");
            str = StringsKt__StringsJVMKt.replace$default(string, RichContentLoadTimeRecorder.DELIMETER, vendorBusyPopupCallArguments.getVendorName(), false, 4, (Object) null);
        }
        String str3 = str;
        if (vendorBusyPopupCallArguments.isTGO()) {
            str2 = fragmentActivity.getString(R.string.shop_busy_second_text_tgo);
            Intrinsics.checkNotNullExpressionValue(str2, "activity.getString(com.t…hop_busy_second_text_tgo)");
        } else {
            str2 = fragmentActivity.getString(R.string.shop_busy_second_text_tmp);
            Intrinsics.checkNotNullExpressionValue(str2, "activity.getString(com.t…hop_busy_second_text_tmp)");
        }
        String str4 = str2;
        BusyPopupBottomSheet.Companion companion = BusyPopupBottomSheet.Companion;
        Integer primaryCuisineId = vendorBusyPopupCallArguments.getPrimaryCuisineId();
        if (primaryCuisineId != null) {
            i11 = primaryCuisineId.intValue();
        } else {
            i11 = 0;
        }
        int verticalType = vendorBusyPopupCallArguments.getVerticalType();
        if (vendorBusyPopupCallArguments.getPrimaryCuisineId() != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        String string2 = fragmentActivity.getResources().getString(R.string.view_similar_restaurants);
        Intrinsics.checkNotNullExpressionValue(string2, "activity.getResources()\n…view_similar_restaurants)");
        BusyPopupBottomSheet newInstance = companion.newInstance(i11, verticalType, z11, 5, str3, str4, string2, new BusyPopupDialogFragmentListener(fragmentActivity));
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
        newInstance.showDialog(supportFragmentManager, "busy popup bottom sheet dialog");
    }
}
