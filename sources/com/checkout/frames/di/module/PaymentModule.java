package com.checkout.frames.di.module;

import com.checkout.base.model.CardScheme;
import com.checkout.frames.di.component.AddressSummaryViewModelSubComponent;
import com.checkout.frames.di.component.BillingFormViewModelSubComponent;
import com.checkout.frames.di.component.CardNumberViewModelSubComponent;
import com.checkout.frames.di.component.CardSchemeViewModelSubComponent;
import com.checkout.frames.di.component.CountryPickerViewModelSubComponent;
import com.checkout.frames.di.component.CountryViewModelSubComponent;
import com.checkout.frames.di.component.CvvViewModelSubComponent;
import com.checkout.frames.di.component.ExpiryDateViewModelSubComponent;
import com.checkout.frames.di.screen.PaymentDetailsViewModelSubComponent;
import com.checkout.frames.screen.manager.PaymentFormStateManager;
import com.checkout.frames.screen.manager.PaymentStateManager;
import dagger.Module;
import dagger.Provides;
import java.util.List;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0001\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/checkout/frames/di/module/PaymentModule;", "", "()V", "Companion", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Module(subcomponents = {CardNumberViewModelSubComponent.class, CvvViewModelSubComponent.class, ExpiryDateViewModelSubComponent.class, PaymentDetailsViewModelSubComponent.class, CountryViewModelSubComponent.class, CountryPickerViewModelSubComponent.class, BillingFormViewModelSubComponent.class, CardSchemeViewModelSubComponent.class, AddressSummaryViewModelSubComponent.class})
public final class PaymentModule {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0007¨\u0006\b"}, d2 = {"Lcom/checkout/frames/di/module/PaymentModule$Companion;", "", "()V", "paymentStateManager", "Lcom/checkout/frames/screen/manager/PaymentStateManager;", "supportedCardSchemes", "", "Lcom/checkout/base/model/CardScheme;", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Singleton
        @NotNull
        @Provides
        public final PaymentStateManager paymentStateManager(@NotNull List<? extends CardScheme> list) {
            Intrinsics.checkNotNullParameter(list, "supportedCardSchemes");
            return new PaymentFormStateManager(list);
        }
    }
}
