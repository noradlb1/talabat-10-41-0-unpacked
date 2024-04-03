package com.checkout.frames.di.module;

import com.checkout.validation.api.CardValidator;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class ValidationModule_Companion_ProvideCardValidatorFactory implements Factory<CardValidator> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final ValidationModule_Companion_ProvideCardValidatorFactory INSTANCE = new ValidationModule_Companion_ProvideCardValidatorFactory();

        private InstanceHolder() {
        }
    }

    public static ValidationModule_Companion_ProvideCardValidatorFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static CardValidator provideCardValidator() {
        return (CardValidator) Preconditions.checkNotNullFromProvides(ValidationModule.Companion.provideCardValidator());
    }

    public CardValidator get() {
        return provideCardValidator();
    }
}
