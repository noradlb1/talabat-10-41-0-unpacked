package com.huawei.hms.maps;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
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
@TargetApi(11)
public class MapFragment extends Fragment implements TraceFieldInterface {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f49311a = false;
    public Trace _nr_trace;

    /* renamed from: b  reason: collision with root package name */
    private final mac f49312b;

    public static class maa extends maa<mab> implements mac {

        /* renamed from: a  reason: collision with root package name */
        private final Fragment f49313a;

        /* renamed from: b  reason: collision with root package name */
        private final List<OnMapReadyCallback> f49314b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        private OnDelegateCreatedListener<mab> f49315c;

        /* renamed from: d  reason: collision with root package name */
        private Activity f49316d;

        /* renamed from: e  reason: collision with root package name */
        private HuaweiMapOptions f49317e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f49318f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f49319g = false;

        public maa(Fragment fragment) {
            this.f49313a = fragment;
        }

        public maa(Fragment fragment, boolean z11) {
            this.f49313a = fragment;
            this.f49318f = z11;
        }

        private boolean b() {
            return this.f49316d == null || this.f49315c == null || getDelegate() != null;
        }

        private void c() {
            if (!b()) {
                com.huawei.hms.maps.common.util.maa.a(this.f49316d.getApplicationContext());
                MapsInitializer.initialize(this.f49316d);
                int isHmsAvailable = HmsUtil.isHmsAvailable(this.f49316d);
                if (isHmsAvailable != 0) {
                    LogM.e("MapFragment", "not load map hmsState = " + isHmsAvailable);
                    return;
                }
                MapClientIdentify.initApiKey(this.f49316d.getApplicationContext());
                if (TextUtils.isEmpty(MapClientIdentify.getAppId())) {
                    MapClientIdentify.setAppId(MapClientUtil.getAppId(this.f49316d.getApplicationContext()));
                }
                Bundle arguments = this.f49313a.getArguments();
                if (arguments != null && arguments.containsKey("HuaweiMapOptions")) {
                    this.f49317e = (HuaweiMapOptions) arguments.getParcelable("HuaweiMapOptions");
                }
                ICreator a11 = com.huawei.hms.maps.internal.mab.a((Context) this.f49316d);
                if (a11 == null) {
                    a((Context) this.f49316d);
                } else {
                    a(a11);
                }
            }
        }

        public IMapFragmentDelegate a(ICreator iCreator, Context context, HuaweiMapOptions huaweiMapOptions) {
            try {
                return this.f49318f ? iCreator.newTextureMapFragmentDelegate(ObjectWrapper.wrap(context), huaweiMapOptions) : iCreator.newMapFragmentDelegate(ObjectWrapper.wrap(context), huaweiMapOptions);
            } catch (RemoteException e11) {
                throw new RuntimeRemoteException(e11);
            }
        }

        public void a(Activity activity) {
            this.f49316d = activity;
        }

        public final void a(OnMapReadyCallback onMapReadyCallback) {
            if (getDelegate() != null) {
                ((mab) getDelegate()).a(onMapReadyCallback);
            } else {
                this.f49314b.add(onMapReadyCallback);
            }
        }

        public void a(ICreator iCreator) {
            LogM.i("MapFragment", "initDelegate: initDelegateFlag = " + this.f49319g);
            if (!this.f49319g) {
                this.f49319g = true;
                try {
                    MapClientIdentify mapClientIdentify = new MapClientIdentify();
                    Context d11 = com.huawei.hms.maps.internal.mab.d(this.f49316d);
                    iCreator.initAppContext(ObjectWrapper.wrap(this.f49316d));
                    mapClientIdentify.regestIdentity(this.f49316d, iCreator);
                    IMapFragmentDelegate a11 = d11 != null ? a(iCreator, d11, this.f49317e) : null;
                    if (a11 == null) {
                        LogM.w("MapFragment", "createDelegate: createDelegateRemote == null");
                        this.f49319g = false;
                        return;
                    }
                    a11.onAttach(ObjectWrapper.wrap(this.f49316d));
                    OnDelegateCreatedListener<mab> onDelegateCreatedListener = this.f49315c;
                    if (onDelegateCreatedListener != null) {
                        onDelegateCreatedListener.onDelegateCreated(new mab(this.f49313a, a11, this.f49316d));
                    }
                    for (OnMapReadyCallback a12 : this.f49314b) {
                        ((mab) getDelegate()).a(a12);
                    }
                    this.f49314b.clear();
                } catch (RemoteException e11) {
                    throw new RuntimeRemoteException(e11);
                }
            }
        }

        public final void createDelegate(OnDelegateCreatedListener<mab> onDelegateCreatedListener) {
            if (!MapFragment.b()) {
                this.f49315c = onDelegateCreatedListener;
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
        public final Fragment f49320a;

        /* renamed from: b  reason: collision with root package name */
        private IMapFragmentDelegate f49321b;

        /* renamed from: c  reason: collision with root package name */
        private Activity f49322c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f49323d = false;

        /* renamed from: e  reason: collision with root package name */
        private HuaweiMapOptions f49324e;

        /* renamed from: f  reason: collision with root package name */
        private final List<OnMapReadyCallback> f49325f = new ArrayList();

        public mab(Fragment fragment) {
            this.f49320a = (Fragment) Preconditions.checkNotNull(fragment);
        }

        public mab(Fragment fragment, IMapFragmentDelegate iMapFragmentDelegate, Activity activity) {
            this.f49321b = (IMapFragmentDelegate) Preconditions.checkNotNull(iMapFragmentDelegate);
            this.f49320a = (Fragment) Preconditions.checkNotNull(fragment);
            this.f49322c = activity;
        }

        private void a() {
            MapsInitializer.initialize(this.f49322c);
            MapFragmentDelegate mapFragmentDelegate = new MapFragmentDelegate(this.f49322c, this.f49324e);
            this.f49321b = mapFragmentDelegate;
            try {
                mapFragmentDelegate.onAttach(ObjectWrapper.wrap(this.f49322c));
            } catch (RemoteException unused) {
                LogM.e("MapFragment", "delegate onAttach RemoteException.");
            }
            for (OnMapReadyCallback a11 : this.f49325f) {
                a(a11);
            }
            this.f49325f.clear();
        }

        private void b() {
            MapsInitializer.initialize((Context) null);
            MapClientIdentify.setAppContext((Context) null);
            com.huawei.hms.maps.internal.mab.a();
        }

        public void a(Activity activity) {
            this.f49322c = activity;
        }

        public final void a(final OnMapReadyCallback onMapReadyCallback) {
            IMapFragmentDelegate iMapFragmentDelegate = this.f49321b;
            if (iMapFragmentDelegate != null) {
                try {
                    iMapFragmentDelegate.getMapAsync(new IOnMapReadyCallback.Stub() {
                        public void onMapReady(IHuaweiMapDelegate iHuaweiMapDelegate) {
                            if (onMapReadyCallback != null) {
                                LogM.i("MapFragment", "onMapReady: mapReadyCallback is not null");
                                if (MapsAdvUtil.containsMapsAdvance()) {
                                    LogM.i("MapFragment", "onMapReady: fullsdk ");
                                    onMapReadyCallback.onMapReady(mab.this.a((com.huawei.hms.maps.provider.inhuawei.IHuaweiMapDelegate) iHuaweiMapDelegate));
                                } else {
                                    onMapReadyCallback.onMapReady(new HuaweiMap(iHuaweiMapDelegate));
                                }
                            } else {
                                LogM.w("MapFragment", "onMapReady: mapReadyCallback is null");
                            }
                            if (mab.this.f49320a.getView() != null) {
                                mab.this.f49320a.getView().setBackground((Drawable) null);
                            }
                        }
                    });
                } catch (RemoteException e11) {
                    throw new RuntimeRemoteException(e11);
                }
            } else {
                this.f49325f.add(onMapReadyCallback);
            }
        }

        public final void onCreate(Bundle bundle) {
            try {
                Bundle a11 = mac.a(bundle);
                Bundle arguments = this.f49320a.getArguments();
                if (arguments != null && arguments.containsKey("HuaweiMapOptions")) {
                    HuaweiMapOptions huaweiMapOptions = (HuaweiMapOptions) arguments.getParcelable("HuaweiMapOptions");
                    this.f49324e = huaweiMapOptions;
                    mac.a(a11, "HuaweiMapOptions", huaweiMapOptions);
                }
                if (MapsAdvUtil.containsMapsBasic()) {
                    a();
                }
                this.f49321b.onCreate(a11);
            } catch (RemoteException e11) {
                throw new RuntimeRemoteException(e11);
            }
        }

        public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            return mad.a(this.f49322c, this.f49321b, layoutInflater, viewGroup, bundle);
        }

        public final void onDestroy() {
            try {
                this.f49321b.onDestroy();
                if (!this.f49323d) {
                    Activity activity = this.f49322c;
                    if (activity != null) {
                        if (activity.isFinishing()) {
                            LogM.d("MapFragment", "clearResource in onDestroy method");
                            b();
                            return;
                        }
                    }
                    LogM.d("MapFragment", "onDestroy: execute clearResource in onDestroy method, but activity is  running");
                }
            } catch (RemoteException e11) {
                throw new RuntimeRemoteException(e11);
            }
        }

        public final void onDestroyView() {
            try {
                this.f49321b.onDestroyView();
            } catch (RemoteException e11) {
                throw new RuntimeRemoteException(e11);
            }
        }

        public final void onInflate(Activity activity, Bundle bundle, Bundle bundle2) {
            if (bundle != null) {
                this.f49324e = (HuaweiMapOptions) bundle.getParcelable("HuaweiMapOptions");
                if (MapsAdvUtil.containsMapsBasic()) {
                    a();
                }
                try {
                    this.f49321b.onInflate(ObjectWrapper.wrap(activity), this.f49324e, mac.a(bundle2));
                } catch (RemoteException e11) {
                    throw new RuntimeRemoteException(e11);
                }
            } else {
                LogM.e("MapFragment", "onInflate Bundle is null!");
            }
        }

        public final void onLowMemory() {
            try {
                this.f49321b.onLowMemory();
            } catch (RemoteException e11) {
                throw new RuntimeRemoteException(e11);
            }
        }

        public final void onPause() {
            try {
                this.f49321b.onPause();
                Activity activity = this.f49322c;
                if (activity != null && activity.isFinishing()) {
                    LogM.d("MapFragment", "clearResource in onPause method");
                    b();
                    this.f49323d = true;
                }
            } catch (RemoteException e11) {
                throw new RuntimeRemoteException(e11);
            }
        }

        public final void onResume() {
            try {
                this.f49321b.onResume();
            } catch (RemoteException e11) {
                throw new RuntimeRemoteException(e11);
            }
        }

        public final void onSaveInstanceState(Bundle bundle) {
            try {
                this.f49321b.onSaveInstanceState(mac.a(bundle));
            } catch (RemoteException e11) {
                throw new RuntimeRemoteException(e11);
            }
        }

        public final void onStart() {
            try {
                this.f49321b.onStart();
            } catch (RemoteException e11) {
                throw new RuntimeRemoteException(e11);
            }
        }

        public final void onStop() {
            try {
                this.f49321b.onStop();
            } catch (RemoteException e11) {
                throw new RuntimeRemoteException(e11);
            }
        }
    }

    public MapFragment() {
        if (!MapsInitializer.a()) {
            LogM.e("MapFragment", "MapsInitializer is not initialized.");
            this.f49312b = null;
            return;
        }
        this.f49312b = MapsAdvUtil.containsMapsBasic() ? new mab(this) : new maa(this);
    }

    private static void a(boolean z11) {
        f49311a = z11;
    }

    /* access modifiers changed from: private */
    public static boolean b() {
        return f49311a;
    }

    public static MapFragment newInstance() {
        return new MapFragment();
    }

    public static MapFragment newInstance(HuaweiMapOptions huaweiMapOptions) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("HuaweiMapOptions", huaweiMapOptions);
        MapFragment mapFragment = new MapFragment();
        mapFragment.setArguments(bundle);
        return mapFragment;
    }

    public void getMapAsync(OnMapReadyCallback onMapReadyCallback) {
        LogM.d("MapFragment", "getMapAsync: ");
        mac mac = this.f49312b;
        if (mac != null) {
            mac.a(onMapReadyCallback);
        }
    }

    public void onActivityCreated(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(MapFragment.class.getClassLoader());
        }
        super.onActivityCreated(bundle);
    }

    public void onAttach(Activity activity) {
        LogM.d("MapFragment", "onAttach: ");
        mac mac = this.f49312b;
        if (mac != null) {
            mac.a(activity);
        }
        super.onAttach(activity);
    }

    public void onCreate(Bundle bundle) {
        TraceMachine.startTracing("MapFragment");
        try {
            TraceMachine.enterMethod(this._nr_trace, "MapFragment#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "MapFragment#onCreate", (ArrayList<String>) null);
        }
        LogM.d("MapFragment", "onCreate: ");
        super.onCreate(bundle);
        if (this.f49312b == null) {
            LogM.e("MapFragment", "MapsInitializer is not initialized.");
        } else {
            a(true);
            if (MapsAdvUtil.containsMapsBasic()) {
                com.huawei.hms.maps.common.util.maa.a(getActivity());
                AuthClient.getInstance().startAuth(getActivity());
            }
            com.huawei.hms.maps.internal.mab.e(getActivity());
            com.huawei.hms.maps.internal.mab.b(true);
            this.f49312b.onCreate(bundle);
        }
        TraceMachine.exitMethod();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView;
        try {
            TraceMachine.enterMethod(this._nr_trace, "MapFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "MapFragment#onCreateView", (ArrayList<String>) null);
        }
        LogM.d("MapFragment", "onCreateView: ");
        if (this.f49312b == null) {
            LogM.e("MapFragment", "MapsInitializer is not initialized.");
            onCreateView = new View(getActivity());
        } else {
            if (MapClientIdentify.getMapAuthStartTime() == 0) {
                MapClientIdentify.setMapAuthStartTime(System.currentTimeMillis());
            }
            onCreateView = this.f49312b.onCreateView(layoutInflater, viewGroup, bundle);
            onCreateView.setBackground(new mae().a(onCreateView));
            onCreateView.setClickable(true);
        }
        TraceMachine.exitMethod();
        return onCreateView;
    }

    public void onDestroy() {
        LogM.d("MapFragment", "onDestroy: ");
        mac mac = this.f49312b;
        if (mac != null) {
            mac.onDestroy();
        }
        HmsUtil.setRepeatFlag(true);
        super.onDestroy();
    }

    public void onDestroyView() {
        mac mac = this.f49312b;
        if (mac != null) {
            mac.onDestroyView();
        }
        super.onDestroyView();
    }

    public final void onEnterAmbient(Bundle bundle) {
        LogM.d("MapFragment", "onEnterAmbient: ");
    }

    public final void onExitAmbient() {
        LogM.d("MapFragment", "onExitAmbient: ");
    }

    @SuppressLint({"NewApi"})
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        LogM.d("MapFragment", "onInflate: ");
        if (this.f49312b == null) {
            super.onInflate(activity, attributeSet, bundle);
            return;
        }
        MapClientIdentify.setMapAuthStartTime(System.currentTimeMillis());
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitAll().build());
        try {
            HuaweiMapOptions createFromAttributes = HuaweiMapOptions.createFromAttributes(activity, attributeSet);
            super.onInflate(activity, attributeSet, bundle);
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("HuaweiMapOptions", createFromAttributes);
            if (getArguments() == null) {
                setArguments(bundle2);
            }
            this.f49312b.a(activity);
            this.f49312b.onInflate(activity, bundle2, bundle);
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public void onLowMemory() {
        LogM.d("MapFragment", "onLowMemory: ");
        mac mac = this.f49312b;
        if (mac != null) {
            mac.onLowMemory();
        }
        super.onLowMemory();
    }

    public void onPause() {
        LogM.d("MapFragment", "onPause: ");
        mac mac = this.f49312b;
        if (mac != null) {
            mac.onPause();
        }
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        a(false);
        mac mac = this.f49312b;
        if (mac != null) {
            mac.onResume();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        LogM.d("MapFragment", "onSaveInstanceState: ");
        if (bundle != null) {
            bundle.setClassLoader(MapFragment.class.getClassLoader());
            super.onSaveInstanceState(bundle);
            mac mac = this.f49312b;
            if (mac != null) {
                mac.onSaveInstanceState(bundle);
            }
        }
    }

    public void onStart() {
        super.onStart();
        mac mac = this.f49312b;
        if (mac != null) {
            mac.onStart();
        }
    }

    public void onStop() {
        mac mac = this.f49312b;
        if (mac != null) {
            mac.onStop();
        }
        super.onStop();
    }

    public void setArguments(Bundle bundle) {
        super.setArguments(bundle);
    }
}
