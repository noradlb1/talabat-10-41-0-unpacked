package com.talabat.talabatcommon.ports;

import androidx.fragment.app.FragmentActivity;
import com.talabat.talabatcommon.ports.dto.VendorBusyPopupCallArguments;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/talabat/talabatcommon/ports/VendorMenuFlutterNavigatorPort;", "", "navigateToBusyBottomSheet", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "arguments", "Lcom/talabat/talabatcommon/ports/dto/VendorBusyPopupCallArguments;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface VendorMenuFlutterNavigatorPort {
    void navigateToBusyBottomSheet(@NotNull FragmentActivity fragmentActivity, @NotNull VendorBusyPopupCallArguments vendorBusyPopupCallArguments);
}
