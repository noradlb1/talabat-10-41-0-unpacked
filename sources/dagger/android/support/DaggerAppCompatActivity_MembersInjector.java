package dagger.android.support;

import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class DaggerAppCompatActivity_MembersInjector implements MembersInjector<DaggerAppCompatActivity> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;

    public DaggerAppCompatActivity_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider) {
        this.androidInjectorProvider = provider;
    }

    public static MembersInjector<DaggerAppCompatActivity> create(Provider<DispatchingAndroidInjector<Object>> provider) {
        return new DaggerAppCompatActivity_MembersInjector(provider);
    }

    @InjectedFieldSignature("dagger.android.support.DaggerAppCompatActivity.androidInjector")
    public static void injectAndroidInjector(DaggerAppCompatActivity daggerAppCompatActivity, DispatchingAndroidInjector<Object> dispatchingAndroidInjector) {
        daggerAppCompatActivity.f13831i = dispatchingAndroidInjector;
    }

    public void injectMembers(DaggerAppCompatActivity daggerAppCompatActivity) {
        injectAndroidInjector(daggerAppCompatActivity, this.androidInjectorProvider.get());
    }
}
