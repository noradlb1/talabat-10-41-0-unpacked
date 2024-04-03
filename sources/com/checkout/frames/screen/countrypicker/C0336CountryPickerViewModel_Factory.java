package com.checkout.frames.screen.countrypicker;

import androidx.compose.ui.Modifier;
import com.checkout.base.mapper.Mapper;
import com.checkout.frames.mapper.ImageStyleToDynamicComposableImageMapper;
import com.checkout.frames.screen.manager.PaymentStateManager;
import com.checkout.frames.style.component.base.ContainerStyle;
import com.checkout.frames.style.component.base.InputFieldStyle;
import com.checkout.frames.style.component.base.TextLabelStyle;
import com.checkout.frames.style.screen.CountryPickerStyle;
import com.checkout.frames.style.view.InputFieldViewStyle;
import com.checkout.frames.style.view.TextLabelViewStyle;
import com.checkout.frames.view.InputFieldState;
import com.checkout.frames.view.TextLabelState;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* renamed from: com.checkout.frames.screen.countrypicker.CountryPickerViewModel_Factory  reason: case insensitive filesystem */
public final class C0336CountryPickerViewModel_Factory implements Factory<CountryPickerViewModel> {
    private final Provider<Mapper<ContainerStyle, Modifier>> containerMapperProvider;
    private final Provider<ImageStyleToDynamicComposableImageMapper> imageMapperProvider;
    private final Provider<Mapper<InputFieldStyle, InputFieldState>> inputFieldStateMapperProvider;
    private final Provider<Mapper<InputFieldStyle, InputFieldViewStyle>> inputFieldStyleMapperProvider;
    private final Provider<PaymentStateManager> paymentStateManagerProvider;
    private final Provider<CountryPickerStyle> styleProvider;
    private final Provider<Mapper<TextLabelStyle, TextLabelState>> textLabelStateMapperProvider;
    private final Provider<Mapper<TextLabelStyle, TextLabelViewStyle>> textLabelStyleMapperProvider;

    public C0336CountryPickerViewModel_Factory(Provider<PaymentStateManager> provider, Provider<Mapper<InputFieldStyle, InputFieldViewStyle>> provider2, Provider<Mapper<InputFieldStyle, InputFieldState>> provider3, Provider<Mapper<TextLabelStyle, TextLabelViewStyle>> provider4, Provider<Mapper<TextLabelStyle, TextLabelState>> provider5, Provider<Mapper<ContainerStyle, Modifier>> provider6, Provider<ImageStyleToDynamicComposableImageMapper> provider7, Provider<CountryPickerStyle> provider8) {
        this.paymentStateManagerProvider = provider;
        this.inputFieldStyleMapperProvider = provider2;
        this.inputFieldStateMapperProvider = provider3;
        this.textLabelStyleMapperProvider = provider4;
        this.textLabelStateMapperProvider = provider5;
        this.containerMapperProvider = provider6;
        this.imageMapperProvider = provider7;
        this.styleProvider = provider8;
    }

    public static C0336CountryPickerViewModel_Factory create(Provider<PaymentStateManager> provider, Provider<Mapper<InputFieldStyle, InputFieldViewStyle>> provider2, Provider<Mapper<InputFieldStyle, InputFieldState>> provider3, Provider<Mapper<TextLabelStyle, TextLabelViewStyle>> provider4, Provider<Mapper<TextLabelStyle, TextLabelState>> provider5, Provider<Mapper<ContainerStyle, Modifier>> provider6, Provider<ImageStyleToDynamicComposableImageMapper> provider7, Provider<CountryPickerStyle> provider8) {
        return new C0336CountryPickerViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static CountryPickerViewModel newInstance(PaymentStateManager paymentStateManager, Mapper<InputFieldStyle, InputFieldViewStyle> mapper, Mapper<InputFieldStyle, InputFieldState> mapper2, Mapper<TextLabelStyle, TextLabelViewStyle> mapper3, Mapper<TextLabelStyle, TextLabelState> mapper4, Mapper<ContainerStyle, Modifier> mapper5, ImageStyleToDynamicComposableImageMapper imageStyleToDynamicComposableImageMapper, CountryPickerStyle countryPickerStyle) {
        return new CountryPickerViewModel(paymentStateManager, mapper, mapper2, mapper3, mapper4, mapper5, imageStyleToDynamicComposableImageMapper, countryPickerStyle);
    }

    public CountryPickerViewModel get() {
        return newInstance(this.paymentStateManagerProvider.get(), this.inputFieldStyleMapperProvider.get(), this.inputFieldStateMapperProvider.get(), this.textLabelStyleMapperProvider.get(), this.textLabelStateMapperProvider.get(), this.containerMapperProvider.get(), this.imageMapperProvider.get(), this.styleProvider.get());
    }
}
