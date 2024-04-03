package com.huawei.hms.maps;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.huawei.hms.common.Preconditions;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import com.huawei.hms.feature.dynamic.OnDelegateCreatedListener;
import com.huawei.hms.maps.auth.AuthClient;
import com.huawei.hms.maps.internal.HmsUtil;
import com.huawei.hms.maps.internal.ICreator;
import com.huawei.hms.maps.internal.IHuaweiMapDelegate;
import com.huawei.hms.maps.internal.IMapViewDelegate;
import com.huawei.hms.maps.internal.IOnMapReadyCallback;
import com.huawei.hms.maps.internal.mac;
import com.huawei.hms.maps.model.RuntimeRemoteException;
import com.huawei.hms.maps.provider.inhuawei.MapViewDelegate;
import com.huawei.hms.maps.utils.LogM;
import com.huawei.hms.maps.utils.MapClientUtil;
import com.huawei.hms.maps.utils.MapsAdvUtil;
import java.util.ArrayList;
import java.util.List;

public class MapView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    protected MapLifecycleDelegate f49328a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f49329b;

    public static class maa extends maa<mab> implements MapLifecycleDelegate {

        /* renamed from: a  reason: collision with root package name */
        private final ViewGroup f49330a;

        /* renamed from: b  reason: collision with root package name */
        private final Context f49331b;

        /* renamed from: c  reason: collision with root package name */
        private OnDelegateCreatedListener<mab> f49332c;

        /* renamed from: d  reason: collision with root package name */
        private final HuaweiMapOptions f49333d;

        /* renamed from: e  reason: collision with root package name */
        private final List<OnMapReadyCallback> f49334e = new ArrayList();

        /* renamed from: f  reason: collision with root package name */
        private boolean f49335f = false;

        public maa(ViewGroup viewGroup, Context context, HuaweiMapOptions huaweiMapOptions) {
            this.f49330a = viewGroup;
            this.f49331b = context;
            this.f49333d = huaweiMapOptions;
        }

        public IMapViewDelegate a(ICreator iCreator, Context context, HuaweiMapOptions huaweiMapOptions) {
            if (MapsAdvUtil.containsMapsBasic()) {
                return new MapViewDelegate(context, huaweiMapOptions);
            }
            try {
                LogM.i("MapView", "createDelegate: createMapViewDelegateRemote");
                return iCreator.newMapViewDelegate(ObjectWrapper.wrap(context), huaweiMapOptions);
            } catch (RemoteException e11) {
                throw new RuntimeRemoteException(e11);
            }
        }

        public void a(ICreator iCreator) {
            LogM.i("MapView", "createDelegate: initDelegateFlag = " + this.f49335f);
            if (!this.f49335f) {
                this.f49335f = true;
                try {
                    MapClientIdentify mapClientIdentify = new MapClientIdentify();
                    Context d11 = com.huawei.hms.maps.internal.mab.d(this.f49331b);
                    iCreator.initAppContext(ObjectWrapper.wrap(this.f49331b));
                    mapClientIdentify.regestIdentity(this.f49331b, iCreator);
                    IMapViewDelegate a11 = d11 != null ? a(iCreator, d11, this.f49333d) : null;
                    if (a11 == null) {
                        LogM.w("MapView", "createDelegate: mapReadyCallbacks: mapViewDelegate is null");
                        this.f49335f = false;
                        return;
                    }
                    LogM.i("MapView", "createDelegate: sdk MapView constructor mIMapViewDelegate:" + a11);
                    a11.setActivity(ObjectWrapper.wrap(this.f49331b));
                    OnDelegateCreatedListener<mab> onDelegateCreatedListener = this.f49332c;
                    if (onDelegateCreatedListener != null) {
                        onDelegateCreatedListener.onDelegateCreated(new mab(this.f49330a, this.f49331b, a11));
                    }
                    LogM.i("MapView", "createDelegate: mapReadyCallbacks.size = " + this.f49334e.size());
                    for (OnMapReadyCallback mapAsync : this.f49334e) {
                        ((mab) getDelegate()).getMapAsync(mapAsync);
                    }
                    this.f49334e.clear();
                } catch (RemoteException e11) {
                    throw new RuntimeRemoteException(e11);
                }
            }
        }

        public void createDelegate(OnDelegateCreatedListener<mab> onDelegateCreatedListener) {
            StringBuilder sb2;
            com.huawei.hms.maps.common.util.maa.a(this.f49331b);
            this.f49332c = onDelegateCreatedListener;
            if (onDelegateCreatedListener == null || getDelegate() != null) {
                sb2 = new StringBuilder();
                sb2.append("createDelegate: onDelegateCreatedListener = ");
                sb2.append(onDelegateCreatedListener);
                sb2.append("; getDelegate = ");
                sb2.append(getDelegate());
            } else {
                MapsInitializer.initialize(this.f49331b);
                int isHmsAvailable = HmsUtil.isHmsAvailable(this.f49331b);
                if (isHmsAvailable != 0) {
                    sb2 = new StringBuilder();
                    sb2.append("not load map hmsState = ");
                    sb2.append(isHmsAvailable);
                } else {
                    MapClientIdentify.initApiKey(this.f49331b);
                    if (TextUtils.isEmpty(MapClientIdentify.getAppId())) {
                        MapClientIdentify.setAppId(MapClientUtil.getAppId(this.f49331b));
                    }
                    ICreator a11 = com.huawei.hms.maps.internal.mab.a(this.f49331b);
                    if (a11 == null) {
                        LogM.e("MapView", "createDelegate: creator == null");
                        a(this.f49331b);
                        return;
                    }
                    LogM.e("MapView", "createDelegate: innerCreateDelegate creator = " + a11);
                    a(a11);
                    return;
                }
            }
            LogM.e("MapView", sb2.toString());
        }

        public final void getMapAsync(OnMapReadyCallback onMapReadyCallback) {
            LogM.i("MapView", "getMapAsync: getDelegate = " + getDelegate());
            if (getDelegate() == null) {
                this.f49334e.add(onMapReadyCallback);
                LogM.i("MapView", "getMapAsync: mapReadyCallbacks.size = " + this.f49334e.size());
                return;
            }
            ((mab) getDelegate()).getMapAsync(onMapReadyCallback);
        }
    }

    public static class mab extends mab implements MapLifecycleDelegate {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public ViewGroup f49336a;

        /* renamed from: b  reason: collision with root package name */
        private IMapViewDelegate f49337b;

        /* renamed from: c  reason: collision with root package name */
        private View f49338c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f49339d = false;

        /* renamed from: e  reason: collision with root package name */
        private Context f49340e;

        public mab(ViewGroup viewGroup, Context context, IMapViewDelegate iMapViewDelegate) {
            this.f49336a = (ViewGroup) Preconditions.checkNotNull(viewGroup);
            this.f49337b = (IMapViewDelegate) Preconditions.checkNotNull(iMapViewDelegate);
            this.f49340e = context;
            MapsInitializer.initialize(context);
        }

        private void a() {
            Activity findActivity = HmsUtil.findActivity(MapClientIdentify.getAppContext());
            if (findActivity != null && findActivity.isFinishing()) {
                MapsInitializer.initialize((Context) null);
                MapClientIdentify.setAppContext((Context) null);
                com.huawei.hms.maps.internal.mab.a();
                this.f49339d = true;
            }
        }

        public void getMapAsync(final OnMapReadyCallback onMapReadyCallback) {
            try {
                this.f49337b.getMapAsync(new IOnMapReadyCallback.Stub() {
                    public void onMapReady(IHuaweiMapDelegate iHuaweiMapDelegate) {
                        if (onMapReadyCallback != null) {
                            LogM.i("MapView", "onMapReady: mapReadyCallback is not null");
                            if (MapsAdvUtil.containsMapsAdvance()) {
                                LogM.i("MapView", "onMapReady: fullsdk ");
                                onMapReadyCallback.onMapReady(mab.this.a((com.huawei.hms.maps.provider.inhuawei.IHuaweiMapDelegate) iHuaweiMapDelegate));
                            } else {
                                onMapReadyCallback.onMapReady(new HuaweiMap(iHuaweiMapDelegate));
                            }
                        } else {
                            LogM.w("MapView", "onMapReady: mapReadyCallback is null");
                        }
                        if (mab.this.f49336a != null) {
                            mab.this.f49336a.setBackground((Drawable) null);
                        }
                    }
                });
            } catch (RemoteException e11) {
                throw new RuntimeRemoteException(e11);
            }
        }

        public void onCreate(Bundle bundle) {
            try {
                this.f49337b.onCreate(mac.a(bundle));
                this.f49337b.setActivity(ObjectWrapper.wrap(this.f49340e));
                this.f49338c = !MapsAdvUtil.containsMapsBasic() ? (View) ObjectWrapper.unwrap(this.f49337b.getView()) : this.f49337b.getMapView();
                this.f49336a.removeAllViews();
                this.f49336a.addView(this.f49338c);
            } catch (RemoteException e11) {
                throw new RuntimeRemoteException(e11);
            }
        }

        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            throw new UnsupportedOperationException("onCreateView prohibited on MapViewDelegate");
        }

        public void onDestroy() {
            try {
                this.f49337b.onDestroy();
                if (!this.f49339d) {
                    a();
                    LogM.d("MapView", this.f49339d ? "clearResource in onDestroy method" : "onDestroy: execute clearResource in onDestroy method, but activity is  running");
                }
            } catch (RemoteException e11) {
                throw new RuntimeRemoteException(e11);
            }
        }

        public void onDestroyView() {
            throw new UnsupportedOperationException("onDestroyView prohibited on MapViewDelegate");
        }

        public final void onInflate(Activity activity, Bundle bundle, Bundle bundle2) {
            throw new UnsupportedOperationException("onInflate prohibited on MapViewDelegate");
        }

        public void onLowMemory() {
            try {
                this.f49337b.onLowMemory();
            } catch (RemoteException e11) {
                throw new RuntimeRemoteException(e11);
            }
        }

        public void onPause() {
            try {
                LogM.d("MapView", "MapView:onResume");
                this.f49337b.onPause();
                if (MapClientIdentify.getAppContext() instanceof Activity) {
                    a();
                    if (this.f49339d) {
                        LogM.d("MapView", "clearResource in onPause method");
                    }
                }
            } catch (RemoteException e11) {
                throw new RuntimeRemoteException(e11);
            }
        }

        public void onResume() {
            try {
                LogM.d("MapView", "MapView:onResume");
                this.f49337b.onResume();
            } catch (RemoteException e11) {
                throw new RuntimeRemoteException(e11);
            }
        }

        public void onSaveInstanceState(Bundle bundle) {
            try {
                this.f49337b.onSaveInstanceState(mac.a(bundle));
            } catch (RemoteException e11) {
                throw new RuntimeRemoteException(e11);
            }
        }

        public void onStart() {
            try {
                this.f49337b.onStart();
            } catch (RemoteException e11) {
                throw new RuntimeRemoteException(e11);
            }
        }

        public void onStop() {
            try {
                this.f49337b.onStop();
            } catch (RemoteException e11) {
                throw new RuntimeRemoteException(e11);
            }
        }
    }

    public MapView(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    public MapView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MapView(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, false);
    }

    public MapView(Context context, AttributeSet attributeSet, int i11, boolean z11) {
        super(context, attributeSet, i11);
        this.f49329b = z11;
        a(context, attributeSet != null ? HuaweiMapOptions.createFromAttributes(context, attributeSet) : null);
    }

    public MapView(Context context, HuaweiMapOptions huaweiMapOptions) {
        this(context, huaweiMapOptions, false);
    }

    public MapView(Context context, HuaweiMapOptions huaweiMapOptions, boolean z11) {
        super(context);
        this.f49329b = z11;
        a(context, huaweiMapOptions);
    }

    private void a(Context context, HuaweiMapOptions huaweiMapOptions) {
        MapLifecycleDelegate mapLifecycleDelegate;
        LogM.d("MapView", "initMapView: ");
        if (!MapsInitializer.a()) {
            LogM.e("MapView", "MapsInitializer is not initialized.");
            this.f49328a = null;
            return;
        }
        if (MapClientIdentify.getMapAuthStartTime() == 0) {
            MapClientIdentify.setMapAuthStartTime(System.currentTimeMillis());
        }
        if (!this.f49329b) {
            if (MapsAdvUtil.containsMapsBasic()) {
                com.huawei.hms.maps.common.util.maa.a(context);
                AuthClient.getInstance().startAuth(context);
                mapLifecycleDelegate = new mab(this, context, new MapViewDelegate(context, huaweiMapOptions));
            } else {
                mapLifecycleDelegate = new maa(this, context, huaweiMapOptions);
            }
            this.f49328a = mapLifecycleDelegate;
        }
        setClickable(true);
        setBackground(new mae().a(this));
    }

    public void getMapAsync(OnMapReadyCallback onMapReadyCallback) {
        LogM.d("MapView", "getMapAsync: ");
        MapLifecycleDelegate mapLifecycleDelegate = this.f49328a;
        if (mapLifecycleDelegate != null) {
            mapLifecycleDelegate.getMapAsync(onMapReadyCallback);
        }
    }

    public void onCreate(Bundle bundle) {
        if (this.f49328a == null) {
            LogM.e("MapView", "MapsInitializer is not initialized.");
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitAll().build());
        MapClientIdentify.setMapAuthStartTime(System.currentTimeMillis());
        com.huawei.hms.maps.internal.mab.e(getContext());
        com.huawei.hms.maps.internal.mab.b(true);
        try {
            this.f49328a.onCreate(bundle);
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public void onDestroy() {
        MapLifecycleDelegate mapLifecycleDelegate = this.f49328a;
        if (mapLifecycleDelegate != null) {
            mapLifecycleDelegate.onDestroy();
        }
        HmsUtil.setRepeatFlag(true);
    }

    public final void onEnterAmbient(Bundle bundle) {
        LogM.d("MapView", "onEnterAmbient");
    }

    public final void onExitAmbient() {
        LogM.d("MapView", "onExitAmbient");
    }

    public final void onLowMemory() {
        MapLifecycleDelegate mapLifecycleDelegate = this.f49328a;
        if (mapLifecycleDelegate != null) {
            mapLifecycleDelegate.onLowMemory();
        }
    }

    public void onPause() {
        LogM.d("MapView", "onPause");
        MapLifecycleDelegate mapLifecycleDelegate = this.f49328a;
        if (mapLifecycleDelegate != null) {
            mapLifecycleDelegate.onPause();
        }
    }

    public void onResume() {
        MapLifecycleDelegate mapLifecycleDelegate = this.f49328a;
        if (mapLifecycleDelegate != null) {
            mapLifecycleDelegate.onResume();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        MapLifecycleDelegate mapLifecycleDelegate = this.f49328a;
        if (mapLifecycleDelegate != null) {
            mapLifecycleDelegate.onSaveInstanceState(bundle);
        }
    }

    public void onStart() {
        MapLifecycleDelegate mapLifecycleDelegate = this.f49328a;
        if (mapLifecycleDelegate != null) {
            mapLifecycleDelegate.onStart();
        }
    }

    public void onStop() {
        MapLifecycleDelegate mapLifecycleDelegate = this.f49328a;
        if (mapLifecycleDelegate != null) {
            mapLifecycleDelegate.onStop();
        }
    }
}
