package com.checkout.frames.di.module;

import com.checkout.base.mapper.Mapper;
import com.checkout.base.usecase.UseCase;
import com.checkout.frames.component.base.InputComponentState;
import com.checkout.frames.component.billingaddressfields.BillingAddressInputComponentState;
import com.checkout.frames.component.billingaddressfields.BillingAddressInputComponentsContainerState;
import com.checkout.frames.mapper.billingaddressdetails.BillingAddressInputComponentStyleToStateMapper;
import com.checkout.frames.mapper.billingaddressdetails.BillingAddressInputComponentStyleToViewStyleMapper;
import com.checkout.frames.screen.billingaddress.usecase.BillingAddressInputComponentStateUseCase;
import com.checkout.frames.screen.billingaddress.usecase.BillingAddressInputComponentStyleUseCase;
import com.checkout.frames.style.component.base.InputComponentStyle;
import com.checkout.frames.style.component.billingformdetails.BillingAddressInputComponentStyle;
import com.checkout.frames.style.screen.BillingAddressDetailsStyle;
import com.checkout.frames.style.view.BillingAddressInputComponentViewStyle;
import com.checkout.frames.style.view.InputComponentViewStyle;
import com.checkout.frames.style.view.billingformdetails.BillingAddressInputComponentsViewContainerStyle;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0001\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/checkout/frames/di/module/BillingAddressDetailsModule;", "", "()V", "Companion", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Module
public final class BillingAddressDetailsModule {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0004H\u0007J(\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0007J(\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00100\u00042\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00120\u0004H\u0007J(\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00140\u000b2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00100\u0004H\u0007¨\u0006\u0016"}, d2 = {"Lcom/checkout/frames/di/module/BillingAddressDetailsModule$Companion;", "", "()V", "provideBillingAddressInputComponentsStateMapper", "Lcom/checkout/base/mapper/Mapper;", "Lcom/checkout/frames/style/component/billingformdetails/BillingAddressInputComponentStyle;", "Lcom/checkout/frames/component/billingaddressfields/BillingAddressInputComponentState;", "inputComponentStateMapper", "Lcom/checkout/frames/style/component/base/InputComponentStyle;", "Lcom/checkout/frames/component/base/InputComponentState;", "provideBillingAddressInputComponentsStateUseCase", "Lcom/checkout/base/usecase/UseCase;", "Lcom/checkout/frames/style/screen/BillingAddressDetailsStyle;", "Lcom/checkout/frames/component/billingaddressfields/BillingAddressInputComponentsContainerState;", "billingAddressInputComponentStateMapper", "provideBillingAddressInputComponentsStyleMapper", "Lcom/checkout/frames/style/view/BillingAddressInputComponentViewStyle;", "inputComponentStyleMapper", "Lcom/checkout/frames/style/view/InputComponentViewStyle;", "provideBillingAddressInputComponentsStyleUseCase", "Lcom/checkout/frames/style/view/billingformdetails/BillingAddressInputComponentsViewContainerStyle;", "billingAddressInputComponentStyleMapper", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        @Provides
        public final Mapper<BillingAddressInputComponentStyle, BillingAddressInputComponentState> provideBillingAddressInputComponentsStateMapper(@NotNull Mapper<InputComponentStyle, InputComponentState> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "inputComponentStateMapper");
            return new BillingAddressInputComponentStyleToStateMapper(mapper);
        }

        @NotNull
        @Provides
        public final UseCase<BillingAddressDetailsStyle, BillingAddressInputComponentsContainerState> provideBillingAddressInputComponentsStateUseCase(@NotNull Mapper<BillingAddressInputComponentStyle, BillingAddressInputComponentState> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "billingAddressInputComponentStateMapper");
            return new BillingAddressInputComponentStateUseCase(mapper);
        }

        @NotNull
        @Provides
        public final Mapper<BillingAddressInputComponentStyle, BillingAddressInputComponentViewStyle> provideBillingAddressInputComponentsStyleMapper(@NotNull Mapper<InputComponentStyle, InputComponentViewStyle> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "inputComponentStyleMapper");
            return new BillingAddressInputComponentStyleToViewStyleMapper(mapper);
        }

        @NotNull
        @Provides
        public final UseCase<BillingAddressDetailsStyle, BillingAddressInputComponentsViewContainerStyle> provideBillingAddressInputComponentsStyleUseCase(@NotNull Mapper<BillingAddressInputComponentStyle, BillingAddressInputComponentViewStyle> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "billingAddressInputComponentStyleMapper");
            return new BillingAddressInputComponentStyleUseCase(mapper);
        }
    }
}
