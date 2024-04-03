package com.checkout.frames.di.module;

import androidx.compose.ui.Modifier;
import com.checkout.base.mapper.Mapper;
import com.checkout.frames.component.base.InputComponentState;
import com.checkout.frames.di.component.AddressSummaryViewModelSubComponent;
import com.checkout.frames.di.component.BillingFormViewModelSubComponent;
import com.checkout.frames.di.component.CardNumberViewModelSubComponent;
import com.checkout.frames.di.component.CountryPickerViewModelSubComponent;
import com.checkout.frames.di.component.CountryViewModelSubComponent;
import com.checkout.frames.di.component.CvvViewModelSubComponent;
import com.checkout.frames.di.component.ExpiryDateViewModelSubComponent;
import com.checkout.frames.di.component.PayButtonViewModelSubComponent;
import com.checkout.frames.di.screen.PaymentDetailsViewModelSubComponent;
import com.checkout.frames.mapper.ButtonStyleToInternalStateMapper;
import com.checkout.frames.mapper.ButtonStyleToInternalViewStyleMapper;
import com.checkout.frames.mapper.ContainerStyleToModifierMapper;
import com.checkout.frames.mapper.ImageStyleToClickableComposableImageMapper;
import com.checkout.frames.mapper.ImageStyleToComposableImageMapper;
import com.checkout.frames.mapper.ImageStyleToDynamicComposableImageMapper;
import com.checkout.frames.mapper.InputComponentStyleToStateMapper;
import com.checkout.frames.mapper.InputComponentStyleToViewStyleMapper;
import com.checkout.frames.mapper.InputFieldStyleToInputFieldStateMapper;
import com.checkout.frames.mapper.InputFieldStyleToViewStyleMapper;
import com.checkout.frames.mapper.TextLabelStyleToStateMapper;
import com.checkout.frames.mapper.TextLabelStyleToViewStyleMapper;
import com.checkout.frames.style.component.base.ButtonStyle;
import com.checkout.frames.style.component.base.ContainerStyle;
import com.checkout.frames.style.component.base.InputComponentStyle;
import com.checkout.frames.style.component.base.InputFieldStyle;
import com.checkout.frames.style.component.base.TextLabelStyle;
import com.checkout.frames.style.view.InputComponentViewStyle;
import com.checkout.frames.style.view.InputFieldViewStyle;
import com.checkout.frames.style.view.InternalButtonViewStyle;
import com.checkout.frames.style.view.TextLabelViewStyle;
import com.checkout.frames.view.InputFieldState;
import com.checkout.frames.view.InternalButtonState;
import com.checkout.frames.view.TextLabelState;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b!\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/checkout/frames/di/module/StylesModule;", "", "()V", "Companion", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Module(subcomponents = {CardNumberViewModelSubComponent.class, ExpiryDateViewModelSubComponent.class, CvvViewModelSubComponent.class, PaymentDetailsViewModelSubComponent.class, CountryViewModelSubComponent.class, CountryPickerViewModelSubComponent.class, BillingFormViewModelSubComponent.class, AddressSummaryViewModelSubComponent.class, PayButtonViewModelSubComponent.class})
public abstract class StylesModule {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0014\u0010\u0007\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\t0\u0004H\u0007J<\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\u00042\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r0\u00042\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u0004H\u0007J\u0014\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u0004H\u0007J\b\u0010\u0012\u001a\u00020\u0013H\u0007J\b\u0010\u0014\u001a\u00020\u0015H\u0007J\b\u0010\u0016\u001a\u00020\u0017H\u0007JP\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u00042\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r0\u00042\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u00042\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u0004H\u0007J>\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001f0\u00042\u0014\u0010 \u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\t0\u00042\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\"0\u0004H\u0007J\u001c\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\"0\u00042\u0006\u0010$\u001a\u00020\u0015H\u0007J(\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u00042\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r0\u0004H\u0007J\u001e\u0010&\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\t0\u00042\u0006\u0010$\u001a\u00020\u0015H\u0007J(\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r0\u00042\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u0004H\u0007¨\u0006("}, d2 = {"Lcom/checkout/frames/di/module/StylesModule$Companion;", "", "()V", "provideButtonStateMapper", "Lcom/checkout/base/mapper/Mapper;", "Lcom/checkout/frames/style/component/base/ButtonStyle;", "Lcom/checkout/frames/view/InternalButtonState;", "textLabelStateMapper", "Lcom/checkout/frames/style/component/base/TextLabelStyle;", "Lcom/checkout/frames/view/TextLabelState;", "provideButtonStyleMapper", "Lcom/checkout/frames/style/view/InternalButtonViewStyle;", "textLabelStyleMapper", "Lcom/checkout/frames/style/view/TextLabelViewStyle;", "containerMapper", "Lcom/checkout/frames/style/component/base/ContainerStyle;", "Landroidx/compose/ui/Modifier;", "provideContainerStyleToModifierMapper", "provideImageStyleToClickableComposableImageMapper", "Lcom/checkout/frames/mapper/ImageStyleToClickableComposableImageMapper;", "provideImageStyleToComposableImageMapper", "Lcom/checkout/frames/mapper/ImageStyleToComposableImageMapper;", "provideImageStyleToDynamicComposableImageMapper", "Lcom/checkout/frames/mapper/ImageStyleToDynamicComposableImageMapper;", "provideInputComponentStyleMapper", "Lcom/checkout/frames/style/component/base/InputComponentStyle;", "Lcom/checkout/frames/style/view/InputComponentViewStyle;", "inputFieldStyleMapper", "Lcom/checkout/frames/style/component/base/InputFieldStyle;", "Lcom/checkout/frames/style/view/InputFieldViewStyle;", "provideInputComponentStyleToStateMapper", "Lcom/checkout/frames/component/base/InputComponentState;", "textLabelMapper", "inputFieldStateMapper", "Lcom/checkout/frames/view/InputFieldState;", "provideInputFieldStyleToStateMapper", "imageMapper", "provideInputFieldStyleToViewStyleMapper", "provideTextLabelStyleToStateMapper", "provideTextLabelStyleToViewStyleMapper", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        @Provides
        public final Mapper<ButtonStyle, InternalButtonState> provideButtonStateMapper(@NotNull Mapper<TextLabelStyle, TextLabelState> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "textLabelStateMapper");
            return new ButtonStyleToInternalStateMapper(mapper);
        }

        @NotNull
        @Provides
        public final Mapper<ButtonStyle, InternalButtonViewStyle> provideButtonStyleMapper(@NotNull Mapper<TextLabelStyle, TextLabelViewStyle> mapper, @NotNull Mapper<ContainerStyle, Modifier> mapper2) {
            Intrinsics.checkNotNullParameter(mapper, "textLabelStyleMapper");
            Intrinsics.checkNotNullParameter(mapper2, "containerMapper");
            return new ButtonStyleToInternalViewStyleMapper(mapper2, mapper);
        }

        @NotNull
        @Provides
        public final Mapper<ContainerStyle, Modifier> provideContainerStyleToModifierMapper() {
            return new ContainerStyleToModifierMapper();
        }

        @NotNull
        @Provides
        public final ImageStyleToClickableComposableImageMapper provideImageStyleToClickableComposableImageMapper() {
            return new ImageStyleToClickableComposableImageMapper();
        }

        @NotNull
        @Provides
        public final ImageStyleToComposableImageMapper provideImageStyleToComposableImageMapper() {
            return new ImageStyleToComposableImageMapper();
        }

        @NotNull
        @Provides
        public final ImageStyleToDynamicComposableImageMapper provideImageStyleToDynamicComposableImageMapper() {
            return new ImageStyleToDynamicComposableImageMapper();
        }

        @NotNull
        @Provides
        public final Mapper<InputComponentStyle, InputComponentViewStyle> provideInputComponentStyleMapper(@NotNull Mapper<TextLabelStyle, TextLabelViewStyle> mapper, @NotNull Mapper<InputFieldStyle, InputFieldViewStyle> mapper2, @NotNull Mapper<ContainerStyle, Modifier> mapper3) {
            Intrinsics.checkNotNullParameter(mapper, "textLabelStyleMapper");
            Intrinsics.checkNotNullParameter(mapper2, "inputFieldStyleMapper");
            Intrinsics.checkNotNullParameter(mapper3, "containerMapper");
            return new InputComponentStyleToViewStyleMapper(mapper, mapper2, mapper3);
        }

        @NotNull
        @Provides
        public final Mapper<InputComponentStyle, InputComponentState> provideInputComponentStyleToStateMapper(@NotNull Mapper<TextLabelStyle, TextLabelState> mapper, @NotNull Mapper<InputFieldStyle, InputFieldState> mapper2) {
            Intrinsics.checkNotNullParameter(mapper, "textLabelMapper");
            Intrinsics.checkNotNullParameter(mapper2, "inputFieldStateMapper");
            return new InputComponentStyleToStateMapper(mapper, mapper2);
        }

        @NotNull
        @Provides
        public final Mapper<InputFieldStyle, InputFieldState> provideInputFieldStyleToStateMapper(@NotNull ImageStyleToComposableImageMapper imageStyleToComposableImageMapper) {
            Intrinsics.checkNotNullParameter(imageStyleToComposableImageMapper, "imageMapper");
            return new InputFieldStyleToInputFieldStateMapper(imageStyleToComposableImageMapper);
        }

        @NotNull
        @Provides
        public final Mapper<InputFieldStyle, InputFieldViewStyle> provideInputFieldStyleToViewStyleMapper(@NotNull Mapper<TextLabelStyle, TextLabelViewStyle> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "textLabelStyleMapper");
            return new InputFieldStyleToViewStyleMapper(mapper);
        }

        @NotNull
        @Provides
        public final Mapper<TextLabelStyle, TextLabelState> provideTextLabelStyleToStateMapper(@NotNull ImageStyleToComposableImageMapper imageStyleToComposableImageMapper) {
            Intrinsics.checkNotNullParameter(imageStyleToComposableImageMapper, "imageMapper");
            return new TextLabelStyleToStateMapper(imageStyleToComposableImageMapper);
        }

        @NotNull
        @Provides
        public final Mapper<TextLabelStyle, TextLabelViewStyle> provideTextLabelStyleToViewStyleMapper(@NotNull Mapper<ContainerStyle, Modifier> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "containerMapper");
            return new TextLabelStyleToViewStyleMapper(mapper);
        }
    }
}
