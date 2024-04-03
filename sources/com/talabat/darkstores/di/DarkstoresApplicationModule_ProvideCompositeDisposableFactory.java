package com.talabat.darkstores.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import io.reactivex.disposables.CompositeDisposable;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class DarkstoresApplicationModule_ProvideCompositeDisposableFactory implements Factory<CompositeDisposable> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final DarkstoresApplicationModule_ProvideCompositeDisposableFactory INSTANCE = new DarkstoresApplicationModule_ProvideCompositeDisposableFactory();

        private InstanceHolder() {
        }
    }

    public static DarkstoresApplicationModule_ProvideCompositeDisposableFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static CompositeDisposable provideCompositeDisposable() {
        return (CompositeDisposable) Preconditions.checkNotNullFromProvides(DarkstoresApplicationModule.INSTANCE.provideCompositeDisposable());
    }

    public CompositeDisposable get() {
        return provideCompositeDisposable();
    }
}
