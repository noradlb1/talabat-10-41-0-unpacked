package dagger.android;

import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class DaggerApplication_MembersInjector implements MembersInjector<DaggerApplication> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;

    public DaggerApplication_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider) {
        this.androidInjectorProvider = provider;
    }

    public static MembersInjector<DaggerApplication> create(Provider<DispatchingAndroidInjector<Object>> provider) {
        return new DaggerApplication_MembersInjector(provider);
    }

    @InjectedFieldSignature("dagger.android.DaggerApplication.androidInjector")
    public static void injectAndroidInjector(DaggerApplication daggerApplication, DispatchingAndroidInjector<Object> dispatchingAndroidInjector) {
        daggerApplication.f13828b = dispatchingAndroidInjector;
    }

    public void injectMembers(DaggerApplication daggerApplication) {
        injectAndroidInjector(daggerApplication, this.androidInjectorProvider.get());
    }
}
