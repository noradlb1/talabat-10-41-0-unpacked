package dagger.android;

import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class DaggerDialogFragment_MembersInjector implements MembersInjector<DaggerDialogFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;

    public DaggerDialogFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider) {
        this.androidInjectorProvider = provider;
    }

    public static MembersInjector<DaggerDialogFragment> create(Provider<DispatchingAndroidInjector<Object>> provider) {
        return new DaggerDialogFragment_MembersInjector(provider);
    }

    @InjectedFieldSignature("dagger.android.DaggerDialogFragment.androidInjector")
    public static void injectAndroidInjector(DaggerDialogFragment daggerDialogFragment, DispatchingAndroidInjector<Object> dispatchingAndroidInjector) {
        daggerDialogFragment.f13829b = dispatchingAndroidInjector;
    }

    public void injectMembers(DaggerDialogFragment daggerDialogFragment) {
        injectAndroidInjector(daggerDialogFragment, this.androidInjectorProvider.get());
    }
}
