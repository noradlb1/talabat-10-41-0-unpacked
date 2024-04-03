package dagger.android.support;

import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class DaggerFragment_MembersInjector implements MembersInjector<DaggerFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;

    public DaggerFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider) {
        this.androidInjectorProvider = provider;
    }

    public static MembersInjector<DaggerFragment> create(Provider<DispatchingAndroidInjector<Object>> provider) {
        return new DaggerFragment_MembersInjector(provider);
    }

    @InjectedFieldSignature("dagger.android.support.DaggerFragment.androidInjector")
    public static void injectAndroidInjector(DaggerFragment daggerFragment, DispatchingAndroidInjector<Object> dispatchingAndroidInjector) {
        daggerFragment.C = dispatchingAndroidInjector;
    }

    public void injectMembers(DaggerFragment daggerFragment) {
        injectAndroidInjector(daggerFragment, this.androidInjectorProvider.get());
    }
}
