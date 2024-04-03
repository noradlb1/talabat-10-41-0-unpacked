package com.checkout.frames.di.component;

import com.checkout.frames.component.cardnumber.CardNumberViewModel;
import com.checkout.frames.style.component.CardNumberComponentStyle;
import dagger.BindsInstance;
import dagger.Subcomponent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\ba\u0018\u00002\u00020\u0001:\u0001\u0006R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/checkout/frames/di/component/CardNumberViewModelSubComponent;", "", "cardNumberViewModel", "Lcom/checkout/frames/component/cardnumber/CardNumberViewModel;", "getCardNumberViewModel", "()Lcom/checkout/frames/component/cardnumber/CardNumberViewModel;", "Builder", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Subcomponent
public interface CardNumberViewModelSubComponent {

    @Subcomponent.Builder
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005H'¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/checkout/frames/di/component/CardNumberViewModelSubComponent$Builder;", "", "build", "Lcom/checkout/frames/di/component/CardNumberViewModelSubComponent;", "style", "Lcom/checkout/frames/style/component/CardNumberComponentStyle;", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface Builder {
        @NotNull
        CardNumberViewModelSubComponent build();

        @NotNull
        @BindsInstance
        Builder style(@NotNull CardNumberComponentStyle cardNumberComponentStyle);
    }

    @NotNull
    CardNumberViewModel getCardNumberViewModel();
}
