package com.huawei.hms.maps;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.huawei.hms.maps.SupportMapFragment;
import com.huawei.hms.maps.auth.AuthClient;
import com.huawei.hms.maps.common.util.maa;
import com.huawei.hms.maps.internal.HmsUtil;
import com.huawei.hms.maps.utils.LogM;
import com.huawei.hms.maps.utils.MapsAdvUtil;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.ArrayList;

@Instrumented
public class TextureSupportMapFragment extends Fragment implements TraceFieldInterface {
    public Trace _nr_trace;

    /* renamed from: a  reason: collision with root package name */
    private final mac f49375a;

    public TextureSupportMapFragment() {
        if (!MapsInitializer.a()) {
            LogM.e("TextureSupportFragment", "MapsInitializer is not initialized.");
            this.f49375a = null;
            return;
        }
        this.f49375a = MapsAdvUtil.containsMapsBasic() ? new SupportMapFragment.mab(this, true) : new SupportMapFragment.maa(this, true);
    }

    public static TextureSupportMapFragment newInstance() {
        return new TextureSupportMapFragment();
    }

    public static TextureSupportMapFragment newInstance(HuaweiMapOptions huaweiMapOptions) {
        LogM.i("TextureSupportFragment", "TextureSupportMapFragment construct");
        Bundle bundle = new Bundle();
        bundle.putParcelable("HuaweiMapOptions", huaweiMapOptions);
        TextureSupportMapFragment textureSupportMapFragment = new TextureSupportMapFragment();
        textureSupportMapFragment.setArguments(bundle);
        return textureSupportMapFragment;
    }

    public void getMapAsync(OnMapReadyCallback onMapReadyCallback) {
        LogM.d("TextureSupportFragment", "getMapAsync: ");
        mac mac = this.f49375a;
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
        LogM.d("TextureSupportFragment", "onAttach");
        super.onAttach(activity);
        mac mac = this.f49375a;
        if (mac != null) {
            mac.a(activity);
        }
    }

    public void onCreate(Bundle bundle) {
        TraceMachine.startTracing("TextureSupportMapFragment");
        try {
            TraceMachine.enterMethod(this._nr_trace, "TextureSupportMapFragment#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "TextureSupportMapFragment#onCreate", (ArrayList<String>) null);
        }
        super.onCreate(bundle);
        if (this.f49375a == null) {
            LogM.e("TextureSupportFragment", "MapsInitializer is not initialized.");
        } else {
            if (MapsAdvUtil.containsMapsBasic()) {
                maa.a(getActivity());
                AuthClient.getInstance().startAuth(getActivity());
            }
            this.f49375a.onCreate(bundle);
        }
        TraceMachine.exitMethod();
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView;
        try {
            TraceMachine.enterMethod(this._nr_trace, "TextureSupportMapFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "TextureSupportMapFragment#onCreateView", (ArrayList<String>) null);
        }
        LogM.d("TextureSupportFragment", "onCreateView: ");
        if (this.f49375a == null) {
            LogM.e("TextureSupportFragment", "MapsInitializer is not initialized.");
            onCreateView = new View(getActivity());
        } else {
            if (MapClientIdentify.getMapAuthStartTime() == 0) {
                MapClientIdentify.setMapAuthStartTime(System.currentTimeMillis());
            }
            onCreateView = this.f49375a.onCreateView(layoutInflater, viewGroup, bundle);
            onCreateView.setBackground(new mae().a(onCreateView));
            onCreateView.setClickable(true);
        }
        TraceMachine.exitMethod();
        return onCreateView;
    }

    public void onDestroy() {
        LogM.d("TextureSupportFragment", "onDestroy");
        mac mac = this.f49375a;
        if (mac != null) {
            mac.onDestroy();
        }
        HmsUtil.setRepeatFlag(true);
        super.onDestroy();
    }

    public void onDestroyView() {
        LogM.d("TextureSupportFragment", "onDestroyView");
        mac mac = this.f49375a;
        if (mac != null) {
            mac.onDestroyView();
        }
        super.onDestroyView();
    }

    public final void onEnterAmbient(Bundle bundle) {
        LogM.d("TextureSupportFragment", "onEnterAmbient: ");
    }

    public final void onExitAmbient() {
        LogM.d("TextureSupportFragment", "onExitAmbient: ");
    }

    @SuppressLint({"NewApi"})
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        LogM.d("TextureSupportFragment", "onInflate");
        if (this.f49375a == null) {
            LogM.e("TextureSupportFragment", "MapsInitializer is not initialized.");
            super.onInflate(activity, attributeSet, bundle);
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitAll().build());
        try {
            LogM.d("TextureSupportFragment", "onInflate");
            super.onInflate(activity, attributeSet, bundle);
            HuaweiMapOptions createFromAttributes = HuaweiMapOptions.createFromAttributes(activity, attributeSet);
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("HuaweiMapOptions", createFromAttributes);
            if (getArguments() == null) {
                setArguments(bundle2);
            }
            this.f49375a.a(activity);
            this.f49375a.onInflate(activity, bundle2, bundle);
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public void onLowMemory() {
        LogM.d("TextureSupportFragment", "onLowMemory");
        mac mac = this.f49375a;
        if (mac != null) {
            mac.onLowMemory();
        }
        super.onLowMemory();
    }

    public void onPause() {
        super.onPause();
        mac mac = this.f49375a;
        if (mac != null) {
            mac.onPause();
        }
    }

    public void onResume() {
        super.onResume();
        mac mac = this.f49375a;
        if (mac != null) {
            mac.onResume();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        LogM.d("TextureSupportFragment", "onSaveInstanceState");
        if (bundle != null) {
            bundle.setClassLoader(SupportMapFragment.class.getClassLoader());
            super.onSaveInstanceState(bundle);
            mac mac = this.f49375a;
            if (mac != null) {
                mac.onSaveInstanceState(bundle);
            }
        }
    }

    public void onStart() {
        super.onStart();
        mac mac = this.f49375a;
        if (mac != null) {
            mac.onStart();
        }
    }

    public void onStop() {
        mac mac = this.f49375a;
        if (mac != null) {
            mac.onStop();
        }
        super.onStop();
    }

    public void setArguments(Bundle bundle) {
        super.setArguments(bundle);
    }
}
