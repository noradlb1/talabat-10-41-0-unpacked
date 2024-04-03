package dagger.android;

import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class DaggerActivity_MembersInjector implements MembersInjector<DaggerActivity> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;

    public DaggerActivity_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider) {
        this.androidInjectorProvider = provider;
    }

    public static MembersInjector<DaggerActivity> create(Provider<DispatchingAndroidInjector<Object>> provider) {
        return new DaggerActivity_MembersInjector(provider);
    }

    @InjectedFieldSignature("dagger.android.DaggerActivity.androidInjector")
    public static void injectAndroidInjector(DaggerActivity daggerActivity, DispatchingAndroidInjector<Object> dispatchingAndroidInjector) {
        daggerActivity.f13827b = dispatchingAndroidInjector;
    }

    public void injectMembers(DaggerActivity daggerActivity) {
        injectAndroidInjector(daggerActivity, this.androidInjectorProvider.get());
    }
}
