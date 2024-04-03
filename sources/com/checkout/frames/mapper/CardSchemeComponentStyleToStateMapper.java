package com.checkout.frames.mapper;

import com.checkout.base.mapper.Mapper;
import com.checkout.frames.component.cardscheme.CardSchemeComponentState;
import com.checkout.frames.style.component.CardSchemeComponentStyle;
import com.checkout.frames.style.component.base.TextLabelStyle;
import com.checkout.frames.view.TextLabelState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001b\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00060\u0001¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0016R\u001c\u0010\u0004\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00060\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/checkout/frames/mapper/CardSchemeComponentStyleToStateMapper;", "Lcom/checkout/base/mapper/Mapper;", "Lcom/checkout/frames/style/component/CardSchemeComponentStyle;", "Lcom/checkout/frames/component/cardscheme/CardSchemeComponentState;", "textLabelMapper", "Lcom/checkout/frames/style/component/base/TextLabelStyle;", "Lcom/checkout/frames/view/TextLabelState;", "(Lcom/checkout/base/mapper/Mapper;)V", "map", "from", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CardSchemeComponentStyleToStateMapper implements Mapper<CardSchemeComponentStyle, CardSchemeComponentState> {
    @NotNull
    private final Mapper<TextLabelStyle, TextLabelState> textLabelMapper;

    public CardSchemeComponentStyleToStateMapper(@NotNull Mapper<TextLabelStyle, TextLabelState> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "textLabelMapper");
        this.textLabelMapper = mapper;
    }

    @NotNull
    public CardSchemeComponentState map(@NotNull CardSchemeComponentStyle cardSchemeComponentStyle) {
        Intrinsics.checkNotNullParameter(cardSchemeComponentStyle, "from");
        return new CardSchemeComponentState(this.textLabelMapper.map(cardSchemeComponentStyle.getTitleStyle()));
    }
}
