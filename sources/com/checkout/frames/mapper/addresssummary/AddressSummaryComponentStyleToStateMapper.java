package com.checkout.frames.mapper.addresssummary;

import com.checkout.base.mapper.Mapper;
import com.checkout.frames.component.addresssummary.AddressSummaryComponentState;
import com.checkout.frames.style.component.addresssummary.AddressSummaryComponentStyle;
import com.checkout.frames.style.component.base.ButtonStyle;
import com.checkout.frames.style.component.base.TextLabelStyle;
import com.checkout.frames.view.InternalButtonState;
import com.checkout.frames.view.TextLabelState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B/\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00060\u0001\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0001¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0004\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00060\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/checkout/frames/mapper/addresssummary/AddressSummaryComponentStyleToStateMapper;", "Lcom/checkout/base/mapper/Mapper;", "Lcom/checkout/frames/style/component/addresssummary/AddressSummaryComponentStyle;", "Lcom/checkout/frames/component/addresssummary/AddressSummaryComponentState;", "textLabelStateMapper", "Lcom/checkout/frames/style/component/base/TextLabelStyle;", "Lcom/checkout/frames/view/TextLabelState;", "buttonStateMapper", "Lcom/checkout/frames/style/component/base/ButtonStyle;", "Lcom/checkout/frames/view/InternalButtonState;", "(Lcom/checkout/base/mapper/Mapper;Lcom/checkout/base/mapper/Mapper;)V", "map", "from", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AddressSummaryComponentStyleToStateMapper implements Mapper<AddressSummaryComponentStyle, AddressSummaryComponentState> {
    @NotNull
    private final Mapper<ButtonStyle, InternalButtonState> buttonStateMapper;
    @NotNull
    private final Mapper<TextLabelStyle, TextLabelState> textLabelStateMapper;

    public AddressSummaryComponentStyleToStateMapper(@NotNull Mapper<TextLabelStyle, TextLabelState> mapper, @NotNull Mapper<ButtonStyle, InternalButtonState> mapper2) {
        Intrinsics.checkNotNullParameter(mapper, "textLabelStateMapper");
        Intrinsics.checkNotNullParameter(mapper2, "buttonStateMapper");
        this.textLabelStateMapper = mapper;
        this.buttonStateMapper = mapper2;
    }

    @NotNull
    public AddressSummaryComponentState map(@NotNull AddressSummaryComponentStyle addressSummaryComponentStyle) {
        Intrinsics.checkNotNullParameter(addressSummaryComponentStyle, "from");
        return new AddressSummaryComponentState(this.textLabelStateMapper.map(addressSummaryComponentStyle.getTitleStyle()), this.textLabelStateMapper.map(addressSummaryComponentStyle.getSubTitleStyle()), this.textLabelStateMapper.map(addressSummaryComponentStyle.getSummarySectionStyle().getAddressTextStyle()), this.buttonStateMapper.map(addressSummaryComponentStyle.getSummarySectionStyle().getEditAddressButtonStyle()), this.buttonStateMapper.map(addressSummaryComponentStyle.getAddAddressButtonStyle()));
    }
}
