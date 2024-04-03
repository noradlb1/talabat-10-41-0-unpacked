package com.talabat.vendormenu.presentation.flutter.channels;

import com.talabat.vendormenu.presentation.flutter.PlumbingWork;
import com.talabat.vendormenu.presentation.flutter.dto.AddToBasketCallArguments;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/talabat/vendormenu/presentation/flutter/channels/VendorItemDetailsMethodChannelCallback;", "", "getVendorItemDetailsInfo", "", "", "onAddToBasketClicked", "", "args", "Lcom/talabat/vendormenu/presentation/flutter/dto/AddToBasketCallArguments;", "com_talabat_NewArchi_TalabatVendorMenu_TalabatVendorMenu"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PlumbingWork
public interface VendorItemDetailsMethodChannelCallback {
    @NotNull
    Map<String, Object> getVendorItemDetailsInfo();

    void onAddToBasketClicked(@NotNull AddToBasketCallArguments addToBasketCallArguments);
}
