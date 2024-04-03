package com.checkout.frames.di.module;

import com.checkout.base.mapper.Mapper;
import com.checkout.frames.style.component.base.InputFieldStyle;
import com.checkout.frames.style.component.base.TextLabelStyle;
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
public final class StylesModule_Companion_ProvideInputFieldStyleToViewStyleMapperFactory implements Factory<Mapper<InputFieldStyle, InputFieldViewStyle>> {
    private final Provider<Mapper<TextLabelStyle, TextLabelViewStyle>> textLabelStyleMapperProvider;

    public StylesModule_Companion_ProvideInputFieldStyleToViewStyleMapperFactory(Provider<Mapper<TextLabelStyle, TextLabelViewStyle>> provider) {
        this.textLabelStyleMapperProvider = provider;
    }

    public static StylesModule_Companion_ProvideInputFieldStyleToViewStyleMapperFactory create(Provider<Mapper<TextLabelStyle, TextLabelViewStyle>> provider) {
        return new StylesModule_Companion_ProvideInputFieldStyleToViewStyleMapperFactory(provider);
    }

    public static Mapper<InputFieldStyle, InputFieldViewStyle> provideInputFieldStyleToViewStyleMapper(Mapper<TextLabelStyle, TextLabelViewStyle> mapper) {
        return (Mapper) Preconditions.checkNotNullFromProvides(StylesModule.Companion.provideInputFieldStyleToViewStyleMapper(mapper));
    }

    public Mapper<InputFieldStyle, InputFieldViewStyle> get() {
        return provideInputFieldStyleToViewStyleMapper(this.textLabelStyleMapperProvider.get());
    }
}
