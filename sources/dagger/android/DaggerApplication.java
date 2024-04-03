package dagger.android;

import android.app.Application;
import com.google.errorprone.annotations.ForOverride;
import javax.inject.Inject;

public abstract class DaggerApplication extends Application implements HasAndroidInjector {
    @Inject

    /* renamed from: b  reason: collision with root package name */
    public volatile DispatchingAndroidInjector<Object> f13828b;

    private void injectIfNecessary() {
        if (this.f13828b == null) {
            synchronized (this) {
                if (this.f13828b == null) {
                    a().inject(this);
                    if (this.f13828b == null) {
                        throw new IllegalStateException("The AndroidInjector returned from applicationInjector() did not inject the DaggerApplication");
                    }
                }
            }
        }
    }

    @ForOverride
    public abstract AndroidInjector<? extends DaggerApplication> a();

    public AndroidInjector<Object> androidInjector() {
        injectIfNecessary();
        return this.f13828b;
    }

    public void onCreate() {
        super.onCreate();
        injectIfNecessary();
    }
}
