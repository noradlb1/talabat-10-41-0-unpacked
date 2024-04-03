package com.checkout.frames.di.module;

import androidx.compose.ui.Modifier;
import com.checkout.base.mapper.Mapper;
import com.checkout.frames.style.component.base.ContainerStyle;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class StylesModule_Companion_ProvideContainerStyleToModifierMapperFactory implements Factory<Mapper<ContainerStyle, Modifier>> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final StylesModule_Companion_ProvideContainerStyleToModifierMapperFactory INSTANCE = new StylesModule_Companion_ProvideContainerStyleToModifierMapperFactory();

        private InstanceHolder() {
        }
    }

    public static StylesModule_Companion_ProvideContainerStyleToModifierMapperFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static Mapper<ContainerStyle, Modifier> provideContainerStyleToModifierMapper() {
        return (Mapper) Preconditions.checkNotNullFromProvides(StylesModule.Companion.provideContainerStyleToModifierMapper());
    }

    public Mapper<ContainerStyle, Modifier> get() {
        return provideContainerStyleToModifierMapper();
    }
}
