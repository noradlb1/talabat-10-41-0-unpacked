package com.checkout.frames.mapper.billingaddressdetails;

import com.checkout.base.mapper.Mapper;
import com.checkout.frames.style.component.base.InputComponentStyle;
import com.checkout.frames.style.component.billingformdetails.BillingAddressInputComponentStyle;
import com.checkout.frames.style.view.BillingAddressInputComponentViewStyle;
import com.checkout.frames.style.view.InputComponentViewStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0001¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/checkout/frames/mapper/billingaddressdetails/BillingAddressInputComponentStyleToViewStyleMapper;", "Lcom/checkout/base/mapper/Mapper;", "Lcom/checkout/frames/style/component/billingformdetails/BillingAddressInputComponentStyle;", "Lcom/checkout/frames/style/view/BillingAddressInputComponentViewStyle;", "inputComponentStyleMapper", "Lcom/checkout/frames/style/component/base/InputComponentStyle;", "Lcom/checkout/frames/style/view/InputComponentViewStyle;", "(Lcom/checkout/base/mapper/Mapper;)V", "map", "from", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BillingAddressInputComponentStyleToViewStyleMapper implements Mapper<BillingAddressInputComponentStyle, BillingAddressInputComponentViewStyle> {
    @NotNull
    private final Mapper<InputComponentStyle, InputComponentViewStyle> inputComponentStyleMapper;

    public BillingAddressInputComponentStyleToViewStyleMapper(@NotNull Mapper<InputComponentStyle, InputComponentViewStyle> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "inputComponentStyleMapper");
        this.inputComponentStyleMapper = mapper;
    }

    @NotNull
    public BillingAddressInputComponentViewStyle map(@NotNull BillingAddressInputComponentStyle billingAddressInputComponentStyle) {
        Intrinsics.checkNotNullParameter(billingAddressInputComponentStyle, "from");
        return new BillingAddressInputComponentViewStyle(billingAddressInputComponentStyle.getAddressFieldName(), this.inputComponentStyleMapper.map(billingAddressInputComponentStyle.getInputComponentStyle()));
    }
}
