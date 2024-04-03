package com.checkout.frames.di.module;

import androidx.compose.ui.Modifier;
import com.checkout.base.mapper.Mapper;
import com.checkout.frames.style.component.base.ContainerStyle;
import com.checkout.frames.style.component.base.TextLabelStyle;
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
public final class StylesModule_Companion_ProvideTextLabelStyleToViewStyleMapperFactory implements Factory<Mapper<TextLabelStyle, TextLabelViewStyle>> {
    private final Provider<Mapper<ContainerStyle, Modifier>> containerMapperProvider;

    public StylesModule_Companion_ProvideTextLabelStyleToViewStyleMapperFactory(Provider<Mapper<ContainerStyle, Modifier>> provider) {
        this.containerMapperProvider = provider;
    }

    public static StylesModule_Companion_ProvideTextLabelStyleToViewStyleMapperFactory create(Provider<Mapper<ContainerStyle, Modifier>> provider) {
        return new StylesModule_Companion_ProvideTextLabelStyleToViewStyleMapperFactory(provider);
    }

    public static Mapper<TextLabelStyle, TextLabelViewStyle> provideTextLabelStyleToViewStyleMapper(Mapper<ContainerStyle, Modifier> mapper) {
        return (Mapper) Preconditions.checkNotNullFromProvides(StylesModule.Companion.provideTextLabelStyleToViewStyleMapper(mapper));
    }

    public Mapper<TextLabelStyle, TextLabelViewStyle> get() {
        return provideTextLabelStyleToViewStyleMapper(this.containerMapperProvider.get());
    }
}
