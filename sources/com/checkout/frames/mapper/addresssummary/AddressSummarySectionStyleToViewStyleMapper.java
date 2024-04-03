package com.checkout.frames.mapper.addresssummary;

import androidx.compose.ui.Modifier;
import com.checkout.base.mapper.Mapper;
import com.checkout.frames.style.component.addresssummary.AddressSummarySectionStyle;
import com.checkout.frames.style.component.base.ButtonStyle;
import com.checkout.frames.style.component.base.ContainerStyle;
import com.checkout.frames.style.component.base.DividerStyle;
import com.checkout.frames.style.component.base.TextLabelStyle;
import com.checkout.frames.style.view.DividerViewStyle;
import com.checkout.frames.style.view.InternalButtonViewStyle;
import com.checkout.frames.style.view.TextLabelViewStyle;
import com.checkout.frames.style.view.addresssummary.AddressSummarySectionViewStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001BU\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0001\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0001\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\u0001\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\u0001¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0002H\u0016R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/checkout/frames/mapper/addresssummary/AddressSummarySectionStyleToViewStyleMapper;", "Lcom/checkout/base/mapper/Mapper;", "Lcom/checkout/frames/style/component/addresssummary/AddressSummarySectionStyle;", "Lcom/checkout/frames/style/view/addresssummary/AddressSummarySectionViewStyle;", "textLabelMapper", "Lcom/checkout/frames/style/component/base/TextLabelStyle;", "Lcom/checkout/frames/style/view/TextLabelViewStyle;", "dividerMapper", "Lcom/checkout/frames/style/component/base/DividerStyle;", "Lcom/checkout/frames/style/view/DividerViewStyle;", "buttonMapper", "Lcom/checkout/frames/style/component/base/ButtonStyle;", "Lcom/checkout/frames/style/view/InternalButtonViewStyle;", "containerMapper", "Lcom/checkout/frames/style/component/base/ContainerStyle;", "Landroidx/compose/ui/Modifier;", "(Lcom/checkout/base/mapper/Mapper;Lcom/checkout/base/mapper/Mapper;Lcom/checkout/base/mapper/Mapper;Lcom/checkout/base/mapper/Mapper;)V", "map", "from", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AddressSummarySectionStyleToViewStyleMapper implements Mapper<AddressSummarySectionStyle, AddressSummarySectionViewStyle> {
    @NotNull
    private final Mapper<ButtonStyle, InternalButtonViewStyle> buttonMapper;
    @NotNull
    private final Mapper<ContainerStyle, Modifier> containerMapper;
    @NotNull
    private final Mapper<DividerStyle, DividerViewStyle> dividerMapper;
    @NotNull
    private final Mapper<TextLabelStyle, TextLabelViewStyle> textLabelMapper;

    public AddressSummarySectionStyleToViewStyleMapper(@NotNull Mapper<TextLabelStyle, TextLabelViewStyle> mapper, @NotNull Mapper<DividerStyle, DividerViewStyle> mapper2, @NotNull Mapper<ButtonStyle, InternalButtonViewStyle> mapper3, @NotNull Mapper<ContainerStyle, Modifier> mapper4) {
        Intrinsics.checkNotNullParameter(mapper, "textLabelMapper");
        Intrinsics.checkNotNullParameter(mapper2, "dividerMapper");
        Intrinsics.checkNotNullParameter(mapper3, "buttonMapper");
        Intrinsics.checkNotNullParameter(mapper4, "containerMapper");
        this.textLabelMapper = mapper;
        this.dividerMapper = mapper2;
        this.buttonMapper = mapper3;
        this.containerMapper = mapper4;
    }

    @NotNull
    public AddressSummarySectionViewStyle map(@NotNull AddressSummarySectionStyle addressSummarySectionStyle) {
        Intrinsics.checkNotNullParameter(addressSummarySectionStyle, "from");
        return new AddressSummarySectionViewStyle(this.textLabelMapper.map(addressSummarySectionStyle.getAddressTextStyle()), addressSummarySectionStyle.getDividerStyle() != null ? this.dividerMapper.map(addressSummarySectionStyle.getDividerStyle()) : null, this.buttonMapper.map(addressSummarySectionStyle.getEditAddressButtonStyle()), this.containerMapper.map(addressSummarySectionStyle.getContainerStyle()));
    }
}
