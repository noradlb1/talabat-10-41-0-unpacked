package com.checkout.frames.di.module;

import androidx.compose.ui.Modifier;
import com.checkout.base.mapper.Mapper;
import com.checkout.frames.style.component.base.ContainerStyle;
import com.checkout.frames.style.component.base.InputComponentStyle;
import com.checkout.frames.style.component.base.InputFieldStyle;
import com.checkout.frames.style.component.base.TextLabelStyle;
import com.checkout.frames.style.view.InputComponentViewStyle;
import com.checkout.frames.style.view.InputFieldViewStyle;
import com.checkout.frames.style.view.TextLabelViewStyle;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class StylesModule_Companion_ProvideInputComponentStyleMapperFactory implements Factory<Mapper<InputComponentStyle, InputComponentViewStyle>> {
    private final Provider<Mapper<ContainerStyle, Modifier>> containerMapperProvider;
    private final Provider<Mapper<InputFieldStyle, InputFieldViewStyle>> inputFieldStyleMapperProvider;
    private final Provider<Mapper<TextLabelStyle, TextLabelViewStyle>> textLabelStyleMapperProvider;

    public StylesModule_Companion_ProvideInputComponentStyleMapperFactory(Provider<Mapper<TextLabelStyle, TextLabelViewStyle>> provider, Provider<Mapper<InputFieldStyle, InputFieldViewStyle>> provider2, Provider<Mapper<ContainerStyle, Modifier>> provider3) {
        this.textLabelStyleMapperProvider = provider;
        this.inputFieldStyleMapperProvider = provider2;
        this.containerMapperProvider = provider3;
    }

    public static StylesModule_Companion_ProvideInputComponentStyleMapperFactory create(Provider<Mapper<TextLabelStyle, TextLabelViewStyle>> provider, Provider<Mapper<InputFieldStyle, InputFieldViewStyle>> provider2, Provider<Mapper<ContainerStyle, Modifier>> provider3) {
        return new StylesModule_Companion_ProvideInputComponentStyleMapperFactory(provider, provider2, provider3);
    }

    public static Mapper<InputComponentStyle, InputComponentViewStyle> provideInputComponentStyleMapper(Mapper<TextLabelStyle, TextLabelViewStyle> mapper, Mapper<InputFieldStyle, InputFieldViewStyle> mapper2, Mapper<ContainerStyle, Modifier> mapper3) {
        return (Mapper) Preconditions.checkNotNullFromProvides(StylesModule.Companion.provideInputComponentStyleMapper(mapper, mapper2, mapper3));
    }

    public Mapper<InputComponentStyle, InputComponentViewStyle> get() {
        return provideInputComponentStyleMapper(this.textLabelStyleMapperProvider.get(), this.inputFieldStyleMapperProvider.get(), this.containerMapperProvider.get());
    }
}
