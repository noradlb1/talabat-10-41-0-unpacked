package com.huawei.hms.maps;

import android.annotation.SuppressLint;
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
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.huawei.hms.common.Preconditions;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import com.huawei.hms.feature.dynamic.OnDelegateCreatedListener;
import com.huawei.hms.maps.auth.AuthClient;
import com.huawei.hms.maps.internal.HmsUtil;
import com.huawei.hms.maps.internal.ICreator;
import com.huawei.hms.maps.internal.IHuaweiMapDelegate;
import com.huawei.hms.maps.internal.IMapFragmentDelegate;
import com.huawei.hms.maps.internal.IOnMapReadyCallback;
import com.huawei.hms.maps.internal.mac;
import com.huawei.hms.maps.model.RuntimeRemoteException;
import com.huawei.hms.maps.provider.inhuawei.MapFragmentDelegate;
import com.huawei.hms.maps.utils.LogM;
import com.huawei.hms.maps.utils.MapClientUtil;
import com.huawei.hms.maps.utils.MapsAdvUtil;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.ArrayList;
import java.util.List;

@Instrumented
public class SupportMapFragment extends Fragment implements TraceFieldInterface {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f49356a = false;
    public Trace _nr_trace;

    /* renamed from: b  reason: collision with root package name */
    private final mac f49357b;

    public static class maa extends maa<mab> implements mac {

        /* renamed from: a  reason: collision with root package name */
        private final Fragment f49358a;

        /* renamed from: b  reason: collision with root package name */
        private final List<OnMapReadyCallback> f49359b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        private OnDelegateCreatedListener<mab> f49360c;

        /* renamed from: d  reason: collision with root package name */
        private Activity f49361d;

        /* renamed from: e  reason: collision with root package name */
        private HuaweiMapOptions f49362e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f49363f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f49364g = false;

        public maa(Fragment fragment) {
            this.f49358a = fragment;
        }

        public maa(Fragment fragment, boolean z11) {
            this.f49358a = fragment;
            this.f49363f = z11;
        }

        private boolean b() {
            return this.f49361d == null || this.f49360c == null || getDelegate() != null;
        }

        private void c() {
            if (!b()) {
                com.huawei.hms.maps.common.util.maa.a(this.f49361d.getApplicationContext());
                MapsInitializer.initialize(this.f49361d);
                int isHmsAvailable = HmsUtil.isHmsAvailable(this.f49361d);
                if (isHmsAvailable != 0) {
                    LogM.e("SupportMapFragment", "not load map hmsState = " + isHmsAvailable);
                    return;
                }
                MapClientIdentify.initApiKey(this.f49361d.getApplicationContext());
                if (TextUtils.isEmpty(MapClientIdentify.getAppId())) {
                    MapClientIdentify.setAppId(MapClientUtil.getAppId(this.f49361d.getApplicationContext()));
                }
                Bundle arguments = this.f49358a.getArguments();
                if (arguments != null && arguments.containsKey("HuaweiMapOptions")) {
                    this.f49362e = (HuaweiMapOptions) arguments.getParcelable("HuaweiMapOptions");
                }
                ICreator a11 = com.huawei.hms.maps.internal.mab.a((Context) this.f49361d);
                if (a11 == null) {
                    a((Context) this.f49361d);
                } else {
                    a(a11);
                }
            }
        }

        public IMapFragmentDelegate a(ICreator iCreator, Context context, HuaweiMapOptions huaweiMapOptions) {
            try {
                return this.f49363f ? iCreator.newTextureMapFragmentDelegate(ObjectWrapper.wrap(context), huaweiMapOptions) : iCreator.newMapFragmentDelegate(ObjectWrapper.wrap(context), huaweiMapOptions);
            } catch (RemoteException e11) {
                throw new RuntimeRemoteException(e11);
            }
        }

        public void a(Activity activity) {
            this.f49361d = activity;
        }

        public final void a(OnMapReadyCallback onMapReadyCallback) {
            if (getDelegate() != null) {
                ((mab) getDelegate()).a(onMapReadyCallback);
            } else {
                this.f49359b.add(onMapReadyCallback);
            }
        }

        public void a(ICreator iCreator) {
            LogM.i("SupportMapFragment", "initDelegate: initDelegateFlag = " + this.f49364g);
            if (!this.f49364g) {
                this.f49364g = true;
                try {
                    MapClientIdentify mapClientIdentify = new MapClientIdentify();
                    Context d11 = com.huawei.hms.maps.internal.mab.d(this.f49361d);
                    iCreator.initAppContext(ObjectWrapper.wrap(this.f49361d));
                    mapClientIdentify.regestIdentity(this.f49361d, iCreator);
                    IMapFragmentDelegate a11 = d11 != null ? a(iCreator, d11, this.f49362e) : null;
                    if (a11 == null) {
                        LogM.w("SupportMapFragment", "innerCreateDelegate: supportMapFragmentDelegate is null");
                        this.f49364g = false;
                        return;
                    }
                    a11.onAttach(ObjectWrapper.wrap(this.f49361d));
                    OnDelegateCreatedListener<mab> onDelegateCreatedListener = this.f49360c;
                    if (onDelegateCreatedListener != null) {
                        onDelegateCreatedListener.onDelegateCreated(new mab(this.f49358a, a11, this.f49361d));
                    }
                    for (OnMapReadyCallback a12 : this.f49359b) {
                        ((mab) getDelegate()).a(a12);
                    }
                    this.f49359b.clear();
                } catch (RemoteException e11) {
                    throw new RuntimeRemoteException(e11);
                }
            }
        }

        public final void createDelegate(OnDelegateCreatedListener<mab> onDelegateCreatedListener) {
            if (!SupportMapFragment.b()) {
                this.f49360c = onDelegateCreatedListener;
                StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
                StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitAll().build());
                try {
                    c();
                } finally {
                    StrictMode.setThreadPolicy(threadPolicy);
                }
            }
        }
    }

    public static class mab extends mab implements mac {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final Fragment f49365a;

        /* renamed from: b  reason: collision with root package name */
        private IMapFragmentDelegate f49366b;

        /* renamed from: c  reason: collision with root package name */
        private Activity f49367c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f49368d = false;

        /* renamed from: e  reason: collision with root package name */
        private boolean f49369e = false;

        /* renamed from: f  reason: collision with root package name */
        private HuaweiMapOptions f49370f;

        /* renamed from: g  reason: collision with root package name */
        private final List<OnMapReadyCallback> f49371g = new ArrayList();

        public mab(Fragment fragment, IMapFragmentDelegate iMapFragmentDelegate, Activity activity) {
            this.f49366b = (IMapFragmentDelegate) Preconditions.checkNotNull(iMapFragmentDelegate);
            this.f49365a = (Fragment) Preconditions.checkNotNull(fragment);
            this.f49367c = activity;
        }

        public mab(Fragment fragment, boolean z11) {
            this.f49369e = z11;
            this.f49365a = (Fragment) Preconditions.checkNotNull(fragment);
        }

        private void a() {
            MapsInitializer.initialize(this.f49367c);
            MapFragmentDelegate mapFragmentDelegate = new MapFragmentDelegate(this.f49367c, this.f49370f, this.f49369e);
            this.f49366b = mapFragmentDelegate;
            try {
                mapFragmentDelegate.onAttach(ObjectWrapper.wrap(this.f49367c));
            } catch (RemoteException unused) {
                LogM.w("SupportMapFragment", "exception");
            }
            for (OnMapReadyCallback a11 : this.f49371g) {
                a(a11);
            }
            this.f49371g.clear();
        }

        private void b() {
            MapsInitializer.initialize((Context) null);
            MapClientIdentify.setAppContext((Context) null);
            com.huawei.hms.maps.internal.mab.a();
        }

        public void a(Activity activity) {
            this.f49367c = activity;
        }

        public final void a(final OnMapReadyCallback onMapReadyCallback) {
            IMapFragmentDelegate iMapFragmentDelegate = this.f49366b;
            if (iMapFragmentDelegate != null) {
                try {
                    iMapFragmentDelegate.getMapAsync(new IOnMapReadyCallback.Stub() {
                        public void onMapReady(IHuaweiMapDelegate iHuaweiMapDelegate) {
                            if (onMapReadyCallback != null) {
                                LogM.i("SupportMapFragment", "onMapReady: mapReadyCallback is not null");
                                if (MapsAdvUtil.containsMapsAdvance()) {
                                    LogM.i("SupportMapFragment", "onMapReady: fullsdk ");
                                    onMapReadyCallback.onMapReady(mab.this.a((com.huawei.hms.maps.provider.inhuawei.IHuaweiMapDelegate) iHuaweiMapDelegate));
                                } else {
                                    onMapReadyCallback.onMapReady(new HuaweiMap(iHuaweiMapDelegate));
                                }
                            } else {
                                LogM.w("SupportMapFragment", "onMapReady: mapReadyCallback is null");
                            }
                            if (mab.this.f49365a.getView() != null) {
                                mab.this.f49365a.getView().setBackground((Drawable) null);
                            }
                        }
                    });
                } catch (RemoteException e11) {
                    throw new RuntimeRemoteException(e11);
                }
            } else {
                this.f49371g.add(onMapReadyCallback);
            }
        }

        public final void onCreate(Bundle bundle) {
            try {
                Bundle a11 = mac.a(bundle);
                Bundle arguments = this.f49365a.getArguments();
                if (arguments != null && arguments.containsKey("HuaweiMapOptions")) {
                    HuaweiMapOptions huaweiMapOptions = (HuaweiMapOptions) arguments.getParcelable("HuaweiMapOptions");
                    this.f49370f = huaweiMapOptions;
                    mac.a(a11, "HuaweiMapOptions", huaweiMapOptions);
                }
                if (MapsAdvUtil.containsMapsBasic()) {
                    a();
                }
                this.f49366b.onCreate(a11);
            } catch (RemoteException e11) {
                throw new RuntimeRemoteException(e11);
            }
        }

        public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            return mad.a(this.f49367c, this.f49366b, layoutInflater, viewGroup, bundle);
        }

        public final void onDestroy() {
            try {
                this.f49366b.onDestroy();
                if (!this.f49368d) {
                    Activity activity = this.f49367c;
                    if (activity != null) {
                        if (activity.isFinishing()) {
                            LogM.d("SupportMapFragment", "clearResource in onDestroy method");
                            b();
                            return;
                        }
                    }
                    LogM.d("SupportMapFragment", "onDestroy: execute clearResource in onDestroy method, but activity is  running");
                }
            } catch (RemoteException e11) {
                throw new RuntimeRemoteException(e11);
            }
        }

        public final void onDestroyView() {
            try {
                this.f49366b.onDestroyView();
            } catch (RemoteException e11) {
                throw new RuntimeRemoteException(e11);
            }
        }

        public final void onInflate(Activity activity, Bundle bundle, Bundle bundle2) {
            if (bundle != null) {
                this.f49370f = (HuaweiMapOptions) bundle.getParcelable("HuaweiMapOptions");
                try {
                    if (MapsAdvUtil.containsMapsBasic()) {
                        a();
                    }
                    this.f49366b.onInflate(ObjectWrapper.wrap(activity), this.f49370f, mac.a(bundle2));
                } catch (RemoteException e11) {
                    throw new RuntimeRemoteException(e11);
                }
            } else {
                LogM.e("SupportMapFragment", "onInflate Bundle is null!");
            }
        }

        public final void onLowMemory() {
            try {
                this.f49366b.onLowMemory();
            } catch (RemoteException e11) {
                throw new RuntimeRemoteException(e11);
            }
        }

        public final void onPause() {
            try {
                this.f49366b.onPause();
                Activity activity = this.f49367c;
                if (activity != null && activity.isFinishing()) {
                    LogM.d("SupportMapFragment", "clearResource in onPause method");
                    b();
                    this.f49368d = true;
                }
            } catch (RemoteException e11) {
                throw new RuntimeRemoteException(e11);
            }
        }

        public final void onResume() {
            try {
                this.f49366b.onResume();
            } catch (RemoteException e11) {
                throw new RuntimeRemoteException(e11);
            }
        }

        public final void onSaveInstanceState(Bundle bundle) {
            try {
                this.f49366b.onSaveInstanceState(mac.a(bundle));
            } catch (RemoteException e11) {
                throw new RuntimeRemoteException(e11);
            }
        }

        public final void onStart() {
            try {
                this.f49366b.onStart();
            } catch (RemoteException e11) {
                throw new RuntimeRemoteException(e11);
            }
        }

        public final void onStop() {
            try {
                this.f49366b.onStop();
            } catch (RemoteException e11) {
                throw new RuntimeRemoteException(e11);
            }
        }
    }

    public SupportMapFragment() {
        if (!MapsInitializer.a()) {
            LogM.e("SupportMapFragment", "MapsInitializer is not initialized.");
            this.f49357b = null;
            return;
        }
        this.f49357b = MapsAdvUtil.containsMapsBasic() ? new mab(this, false) : new maa(this);
    }

    private static void a(boolean z11) {
        f49356a = z11;
    }

    /* access modifiers changed from: private */
    public static boolean b() {
        return f49356a;
    }

    public static SupportMapFragment newInstance() {
        return new SupportMapFragment();
    }

    public static SupportMapFragment newInstance(HuaweiMapOptions huaweiMapOptions) {
        LogM.i("SupportMapFragment", "SupportMapFragment construct");
        SupportMapFragment supportMapFragment = new SupportMapFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("HuaweiMapOptions", huaweiMapOptions);
        supportMapFragment.setArguments(bundle);
        return supportMapFragment;
    }

    public void getMapAsync(OnMapReadyCallback onMapReadyCallback) {
        LogM.d("SupportMapFragment", "getMapAsync: ");
        mac mac = this.f49357b;
        if (mac != null) {
            mac.a(onMapReadyCallback);
        }
    }

    public void onActivityCreated(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(SupportMapFragment.class.getClassLoader());
        }
        super.onActivityCreated(bundle);
    }

    public void onAttach(Activity activity) {
        LogM.d("SupportMapFragment", "onAttach");
        super.onAttach(activity);
        mac mac = this.f49357b;
        if (mac != null) {
            mac.a(activity);
        }
    }

    public void onCreate(Bundle bundle) {
        TraceMachine.startTracing("SupportMapFragment");
        try {
            TraceMachine.enterMethod(this._nr_trace, "SupportMapFragment#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "SupportMapFragment#onCreate", (ArrayList<String>) null);
        }
        super.onCreate(bundle);
        if (this.f49357b == null) {
            LogM.e("SupportMapFragment", "MapsInitializer is not initialized.");
        } else {
            a(true);
            com.huawei.hms.maps.internal.mab.e(getActivity());
            com.huawei.hms.maps.internal.mab.b(true);
            if (MapsAdvUtil.containsMapsBasic()) {
                com.huawei.hms.maps.common.util.maa.a(getActivity());
                AuthClient.getInstance().startAuth(getActivity());
            }
            this.f49357b.onCreate(bundle);
        }
        TraceMachine.exitMethod();
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView;
        try {
            TraceMachine.enterMethod(this._nr_trace, "SupportMapFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "SupportMapFragment#onCreateView", (ArrayList<String>) null);
        }
        LogM.d("SupportMapFragment", "onCreateView: ");
        if (this.f49357b == null) {
            LogM.e("SupportMapFragment", "MapsInitializer is not initialized.");
            onCreateView = new View(getActivity());
        } else {
            if (MapClientIdentify.getMapAuthStartTime() == 0) {
                MapClientIdentify.setMapAuthStartTime(System.currentTimeMillis());
            }
            onCreateView = this.f49357b.onCreateView(layoutInflater, viewGroup, bundle);
            onCreateView.setBackground(new mae().a(onCreateView));
            onCreateView.setClickable(true);
        }
        TraceMachine.exitMethod();
        return onCreateView;
    }

    public void onDestroy() {
        LogM.d("SupportMapFragment", "onDestroy");
        mac mac = this.f49357b;
        if (mac != null) {
            mac.onDestroy();
        }
        HmsUtil.setRepeatFlag(true);
        super.onDestroy();
    }

    public void onDestroyView() {
        LogM.d("SupportMapFragment", "onDestroyView");
        mac mac = this.f49357b;
        if (mac != null) {
            mac.onDestroyView();
        }
        super.onDestroyView();
    }

    public final void onEnterAmbient(Bundle bundle) {
        LogM.d("SupportMapFragment", "onEnterAmbient: ");
    }

    public final void onExitAmbient() {
        LogM.d("SupportMapFragment", "onExitAmbient: ");
    }

    @SuppressLint({"NewApi"})
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        LogM.d("SupportMapFragment", "onInflate");
        if (this.f49357b == null) {
            LogM.e("SupportMapFragment", "MapsInitializer is not initialized.");
            super.onInflate(activity, attributeSet, bundle);
            return;
        }
        MapClientIdentify.setMapAuthStartTime(System.currentTimeMillis());
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitAll().build());
        try {
            LogM.d("SupportMapFragment", "onInflate");
            super.onInflate(activity, attributeSet, bundle);
            HuaweiMapOptions createFromAttributes = HuaweiMapOptions.createFromAttributes(activity, attributeSet);
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("HuaweiMapOptions", createFromAttributes);
            if (getArguments() == null) {
                setArguments(bundle2);
            }
            this.f49357b.a(activity);
            this.f49357b.onInflate(activity, bundle2, bundle);
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public void onLowMemory() {
        LogM.d("SupportMapFragment", "onLowMemory");
        mac mac = this.f49357b;
        if (mac != null) {
            mac.onLowMemory();
        }
        super.onLowMemory();
    }

    public void onPause() {
        super.onPause();
        mac mac = this.f49357b;
        if (mac != null) {
            mac.onPause();
        }
    }

    public void onResume() {
        super.onResume();
        a(false);
        mac mac = this.f49357b;
        if (mac != null) {
            mac.onResume();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        LogM.d("SupportMapFragment", "onSaveInstanceState");
        if (bundle != null) {
            bundle.setClassLoader(SupportMapFragment.class.getClassLoader());
            super.onSaveInstanceState(bundle);
            mac mac = this.f49357b;
            if (mac != null) {
                mac.onSaveInstanceState(bundle);
            }
        }
    }

    public void onStart() {
        super.onStart();
        mac mac = this.f49357b;
        if (mac != null) {
            mac.onStart();
        }
    }

    public void onStop() {
        mac mac = this.f49357b;
        if (mac != null) {
            mac.onStop();
        }
        super.onStop();
    }

    public void setArguments(Bundle bundle) {
        super.setArguments(bundle);
    }
}
