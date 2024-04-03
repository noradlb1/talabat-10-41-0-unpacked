package com.checkout.frames.mapper.addresssummary;

import androidx.compose.ui.Modifier;
import com.checkout.base.mapper.Mapper;
import com.checkout.frames.style.component.addresssummary.AddressSummaryComponentStyle;
import com.checkout.frames.style.component.addresssummary.AddressSummarySectionStyle;
import com.checkout.frames.style.component.base.ButtonStyle;
import com.checkout.frames.style.component.base.ContainerStyle;
import com.checkout.frames.style.component.base.TextLabelStyle;
import com.checkout.frames.style.view.InternalButtonViewStyle;
import com.checkout.frames.style.view.TextLabelViewStyle;
import com.checkout.frames.style.view.addresssummary.AddressSummaryComponentViewStyle;
import com.checkout.frames.style.view.addresssummary.AddressSummarySectionViewStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001BU\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0001\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0001\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\u0001\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\u0001¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0002H\u0016R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/checkout/frames/mapper/addresssummary/AddressSummaryComponentStyleToViewStyleMapper;", "Lcom/checkout/base/mapper/Mapper;", "Lcom/checkout/frames/style/component/addresssummary/AddressSummaryComponentStyle;", "Lcom/checkout/frames/style/view/addresssummary/AddressSummaryComponentViewStyle;", "textLabelMapper", "Lcom/checkout/frames/style/component/base/TextLabelStyle;", "Lcom/checkout/frames/style/view/TextLabelViewStyle;", "buttonMapper", "Lcom/checkout/frames/style/component/base/ButtonStyle;", "Lcom/checkout/frames/style/view/InternalButtonViewStyle;", "summarySectionMapper", "Lcom/checkout/frames/style/component/addresssummary/AddressSummarySectionStyle;", "Lcom/checkout/frames/style/view/addresssummary/AddressSummarySectionViewStyle;", "containerMapper", "Lcom/checkout/frames/style/component/base/ContainerStyle;", "Landroidx/compose/ui/Modifier;", "(Lcom/checkout/base/mapper/Mapper;Lcom/checkout/base/mapper/Mapper;Lcom/checkout/base/mapper/Mapper;Lcom/checkout/base/mapper/Mapper;)V", "map", "from", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AddressSummaryComponentStyleToViewStyleMapper implements Mapper<AddressSummaryComponentStyle, AddressSummaryComponentViewStyle> {
    @NotNull
    private final Mapper<ButtonStyle, InternalButtonViewStyle> buttonMapper;
    @NotNull
    private final Mapper<ContainerStyle, Modifier> containerMapper;
    @NotNull
    private final Mapper<AddressSummarySectionStyle, AddressSummarySectionViewStyle> summarySectionMapper;
    @NotNull
    private final Mapper<TextLabelStyle, TextLabelViewStyle> textLabelMapper;

    public AddressSummaryComponentStyleToViewStyleMapper(@NotNull Mapper<TextLabelStyle, TextLabelViewStyle> mapper, @NotNull Mapper<ButtonStyle, InternalButtonViewStyle> mapper2, @NotNull Mapper<AddressSummarySectionStyle, AddressSummarySectionViewStyle> mapper3, @NotNull Mapper<ContainerStyle, Modifier> mapper4) {
        Intrinsics.checkNotNullParameter(mapper, "textLabelMapper");
        Intrinsics.checkNotNullParameter(mapper2, "buttonMapper");
        Intrinsics.checkNotNullParameter(mapper3, "summarySectionMapper");
        Intrinsics.checkNotNullParameter(mapper4, "containerMapper");
        this.textLabelMapper = mapper;
        this.buttonMapper = mapper2;
        this.summarySectionMapper = mapper3;
        this.containerMapper = mapper4;
    }

    @NotNull
    public AddressSummaryComponentViewStyle map(@NotNull AddressSummaryComponentStyle addressSummaryComponentStyle) {
        Intrinsics.checkNotNullParameter(addressSummaryComponentStyle, "from");
        TextLabelStyle titleStyle = addressSummaryComponentStyle.getTitleStyle();
        TextLabelViewStyle textLabelViewStyle = null;
        TextLabelViewStyle map = titleStyle != null ? this.textLabelMapper.map(titleStyle) : null;
        TextLabelStyle subTitleStyle = addressSummaryComponentStyle.getSubTitleStyle();
        if (subTitleStyle != null) {
            textLabelViewStyle = this.textLabelMapper.map(subTitleStyle);
        }
        return new AddressSummaryComponentViewStyle(map, textLabelViewStyle, this.buttonMapper.map(addressSummaryComponentStyle.getAddAddressButtonStyle()), this.summarySectionMapper.map(addressSummaryComponentStyle.getSummarySectionStyle()), this.containerMapper.map(addressSummaryComponentStyle.getContainerStyle()));
    }
}
