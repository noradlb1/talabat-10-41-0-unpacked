package com.huawei.hms.maps;

import android.content.Context;
import com.huawei.hms.feature.dynamic.DeferredLifecycleHelper;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.feature.dynamic.LifecycleDelegate;
import com.huawei.hms.maps.internal.ICreator;
import com.huawei.hms.maps.internal.IDistanceCalculatorDelegate;
import com.huawei.hms.maps.internal.IMapAuthToProvider;
import com.huawei.hms.maps.internal.IMapClientIdentity;
import com.huawei.hms.maps.internal.IMapFragmentDelegate;
import com.huawei.hms.maps.internal.IMapViewDelegate;
import com.huawei.hms.maps.internal.IStreetViewPanoramaFragmentDelegate;
import com.huawei.hms.maps.internal.IStreetViewPanoramaViewDelegate;
import com.huawei.hms.maps.utils.DynamicUtil;
import com.huawei.hms.maps.utils.LogM;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

abstract class maa<T extends LifecycleDelegate> extends DeferredLifecycleHelper<T> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public boolean f49404a = false;

    /* renamed from: b  reason: collision with root package name */
    private Disposable f49405b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public ICreator f49406c = new ICreator.Stub() {
        public void init(IObjectWrapper iObjectWrapper, int i11) {
        }

        public void initAppContext(IObjectWrapper iObjectWrapper) {
        }

        public IDistanceCalculatorDelegate newDistanceCalculatorDelegate(IObjectWrapper iObjectWrapper) {
            return null;
        }

        public IMapAuthToProvider newMapAuthToProvider(IObjectWrapper iObjectWrapper) {
            return null;
        }

        public IMapClientIdentity newMapClientIdentity(IObjectWrapper iObjectWrapper) {
            return null;
        }

        public IMapFragmentDelegate newMapFragmentDelegate(IObjectWrapper iObjectWrapper, HuaweiMapOptions huaweiMapOptions) {
            return null;
        }

        public IMapViewDelegate newMapViewDelegate(IObjectWrapper iObjectWrapper, HuaweiMapOptions huaweiMapOptions) {
            return null;
        }

        public maf newPlaceDelegate(IObjectWrapper iObjectWrapper) {
            return null;
        }

        public IStreetViewPanoramaFragmentDelegate newStreetViewPanoramaFragmentDelegate(IObjectWrapper iObjectWrapper) {
            return null;
        }

        public IStreetViewPanoramaViewDelegate newStreetViewPanoramaViewDelegate(IObjectWrapper iObjectWrapper, StreetViewPanoramaOptions streetViewPanoramaOptions) {
            return null;
        }

        public IMapFragmentDelegate newTextureMapFragmentDelegate(IObjectWrapper iObjectWrapper, HuaweiMapOptions huaweiMapOptions) {
            return null;
        }

        public IMapViewDelegate newTextureMapViewDelegate(IObjectWrapper iObjectWrapper, HuaweiMapOptions huaweiMapOptions) {
            return null;
        }

        public IStreetViewPanoramaFragmentDelegate optStreetViewPanoramaFragmentDelegate(IObjectWrapper iObjectWrapper, StreetViewPanoramaOptions streetViewPanoramaOptions) {
            return null;
        }
    };

    /* renamed from: com.huawei.hms.maps.maa$maa  reason: collision with other inner class name */
    public class C0071maa implements Consumer<ICreator> {
        private C0071maa() {
        }

        /* renamed from: a */
        public void accept(ICreator iCreator) {
            maa.this.b();
            if (iCreator == null || iCreator == maa.this.f49406c) {
                boolean unused = maa.this.f49404a = false;
                LogM.e("AbsDeferredLifecycleHelper", "getCreator: creator == null, createdFlag = false");
                return;
            }
            LogM.i("AbsDeferredLifecycleHelper", "realCreateDelegate: start");
            maa.this.a(iCreator);
        }
    }

    public class mab implements Consumer<Throwable> {
        private mab() {
        }

        /* renamed from: a */
        public void accept(Throwable th2) {
            maa.this.b();
            boolean unused = maa.this.f49404a = false;
            LogM.e("AbsDeferredLifecycleHelper", "getCreator: throwable = " + th2.getMessage() + "; createdFlag = " + maa.this.f49404a);
        }
    }

    public static class mac implements Function<Observable<? extends Throwable>, Observable<?>> {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public int f49412a;

        private mac() {
            this.f49412a = 0;
        }

        public static /* synthetic */ int a(mac mac) {
            int i11 = mac.f49412a + 1;
            mac.f49412a = i11;
            return i11;
        }

        /* renamed from: a */
        public Observable<?> apply(Observable<? extends Throwable> observable) {
            return observable.flatMap(new Function<Throwable, ObservableSource<?>>() {
                /* renamed from: a */
                public ObservableSource<?> apply(@NonNull Throwable th2) {
                    if (mac.a(mac.this) > 3) {
                        return Observable.error(th2);
                    }
                    LogM.w("AbsDeferredLifecycleHelper", "get MapCreator failed, retry counter :" + mac.this.f49412a);
                    return Observable.timer(500, TimeUnit.MILLISECONDS);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void b() {
        Disposable disposable = this.f49405b;
        if (disposable != null && !disposable.isDisposed()) {
            this.f49405b.dispose();
            this.f49405b = null;
            LogM.d("AbsDeferredLifecycleHelper", "getCreator: disposable");
        }
    }

    public void a(final Context context) {
        if (!DynamicUtil.isAndroidN()) {
            LogM.i("AbsDeferredLifecycleHelper", "getCreator: createdFlag = " + this.f49404a);
            if (!this.f49404a) {
                this.f49404a = true;
                b();
                this.f49405b = Observable.fromCallable(new Callable<ICreator>() {
                    /* renamed from: a */
                    public ICreator call() {
                        ICreator c11 = com.huawei.hms.maps.internal.mab.c(context);
                        return c11 == null ? maa.this.f49406c : c11;
                    }
                }).subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).retryWhen(new mac()).subscribe(new C0071maa(), new mab());
                LogM.i("AbsDeferredLifecycleHelper", "getCreator: execute");
            }
        }
    }

    public abstract void a(ICreator iCreator);
}
