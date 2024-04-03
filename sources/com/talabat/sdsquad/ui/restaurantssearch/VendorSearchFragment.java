package com.talabat.sdsquad.ui.restaurantssearch;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.sdsquad.R;
import com.talabat.sdsquad.ui.restaurantssearch.globalsearch.GlobalSearchFragment;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import ju.a;
import ju.b;
import ju.c;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J$\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\fXD¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\fXD¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/talabat/sdsquad/ui/restaurantssearch/VendorSearchFragment;", "Landroidx/fragment/app/Fragment;", "()V", "areaId", "", "getAreaId", "()I", "cityId", "getCityId", "countryId", "getCountryId", "latitude", "", "getLatitude", "()Ljava/lang/String;", "longitude", "getLongitude", "viewModel", "Lcom/talabat/sdsquad/ui/restaurantssearch/VendorSearchViewModel;", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "Companion", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorSearchFragment extends Fragment implements TraceFieldInterface {
    @NotNull
    private static final String ARG_AREA_ID = "areaId";
    @NotNull
    private static final String ARG_CITY_ID = "cityId";
    @NotNull
    private static final String ARG_COLLECTION_ID = "collectionId";
    @NotNull
    private static final String ARG_COUNTRY_ID = "countryId";
    @NotNull
    private static final String ARG_LATITUDE = "latitude";
    @NotNull
    private static final String ARG_LONGITUDE = "longitude";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;
    private final int areaId;
    private final int cityId;
    private final int countryId;
    @NotNull
    private final String latitude = "";
    @NotNull
    private final String longitude = "";
    private VendorSearchViewModel viewModel;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J<\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/talabat/sdsquad/ui/restaurantssearch/VendorSearchFragment$Companion;", "", "()V", "ARG_AREA_ID", "", "ARG_CITY_ID", "ARG_COLLECTION_ID", "ARG_COUNTRY_ID", "ARG_LATITUDE", "ARG_LONGITUDE", "newInstance", "Lcom/talabat/sdsquad/ui/restaurantssearch/VendorSearchFragment;", "latitude", "longitude", "areaId", "", "cityId", "countryId", "collectionId", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ VendorSearchFragment newInstance$default(Companion companion, String str, String str2, int i11, int i12, int i13, int i14, int i15, Object obj) {
            if ((i15 & 32) != 0) {
                i14 = 0;
            }
            return companion.newInstance(str, str2, i11, i12, i13, i14);
        }

        @NotNull
        public final VendorSearchFragment newInstance(@Nullable String str, @Nullable String str2, int i11, int i12, int i13, int i14) {
            new VendorSearchFragment();
            VendorSearchFragment vendorSearchFragment = new VendorSearchFragment();
            Bundle bundle = new Bundle();
            if (str == null) {
                str = "";
            }
            bundle.putString("latitude", str);
            if (str2 == null) {
                str2 = "";
            }
            bundle.putString("longitude", str2);
            bundle.putInt("countryId", i13);
            bundle.putInt("areaId", i11);
            bundle.putInt("cityId", i12);
            bundle.putInt("collectionId", i14);
            vendorSearchFragment.setArguments(bundle);
            return vendorSearchFragment;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onActivityCreated$lambda-0  reason: not valid java name */
    public static final void m10828onActivityCreated$lambda0(VendorSearchFragment vendorSearchFragment, View view) {
        Intrinsics.checkNotNullParameter(vendorSearchFragment, "this$0");
        FragmentActivity activity = vendorSearchFragment.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onActivityCreated$lambda-1  reason: not valid java name */
    public static final void m10829onActivityCreated$lambda1(VendorSearchFragment vendorSearchFragment, View view) {
        Intrinsics.checkNotNullParameter(vendorSearchFragment, "this$0");
        ((EditText) vendorSearchFragment._$_findCachedViewById(R.id.searchEdt)).setText("");
    }

    /* access modifiers changed from: private */
    /* renamed from: onActivityCreated$lambda-2  reason: not valid java name */
    public static final boolean m10830onActivityCreated$lambda2(VendorSearchFragment vendorSearchFragment, String str, String str2, int i11, int i12, int i13, int i14, TextView textView, int i15, KeyEvent keyEvent) {
        VendorSearchFragment vendorSearchFragment2 = vendorSearchFragment;
        Intrinsics.checkNotNullParameter(vendorSearchFragment, "this$0");
        String str3 = str;
        Intrinsics.checkNotNullParameter(str, "$latitude");
        String str4 = str2;
        Intrinsics.checkNotNullParameter(str2, "$longitude");
        if (i15 != 3) {
            return false;
        }
        vendorSearchFragment.getChildFragmentManager().beginTransaction().replace(R.id.vendorSearchContainer, GlobalSearchFragment.Companion.newInstance(((EditText) vendorSearchFragment._$_findCachedViewById(R.id.searchEdt)).getText().toString(), str, str2, i11, i12, i13, i14)).commitNow();
        return true;
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i11) {
        View findViewById;
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i11));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null || (findViewById = view2.findViewById(i11)) == null) {
            return null;
        }
        map.put(Integer.valueOf(i11), findViewById);
        return findViewById;
    }

    public final int getAreaId() {
        return this.areaId;
    }

    public final int getCityId() {
        return this.cityId;
    }

    public final int getCountryId() {
        return this.countryId;
    }

    @NotNull
    public final String getLatitude() {
        return this.latitude;
    }

    @NotNull
    public final String getLongitude() {
        return this.longitude;
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        String str;
        String str2;
        String str3;
        int i11;
        int i12;
        int i13;
        int i14;
        super.onActivityCreated(bundle);
        this.viewModel = (VendorSearchViewModel) ViewModelProviders.of((Fragment) this).get(VendorSearchViewModel.class);
        Bundle arguments = getArguments();
        String str4 = null;
        if (arguments != null) {
            str = arguments.getString("latitude");
        } else {
            str = null;
        }
        if (str == null) {
            str2 = "";
        } else {
            str2 = str;
        }
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            str4 = arguments2.getString("longitude");
        }
        if (str4 == null) {
            str3 = "";
        } else {
            str3 = str4;
        }
        Bundle arguments3 = getArguments();
        if (arguments3 != null) {
            i11 = arguments3.getInt("countryId");
        } else {
            i11 = 0;
        }
        Bundle arguments4 = getArguments();
        if (arguments4 != null) {
            i12 = arguments4.getInt("cityId");
        } else {
            i12 = 0;
        }
        Bundle arguments5 = getArguments();
        if (arguments5 != null) {
            i13 = arguments5.getInt("areaId");
        } else {
            i13 = 0;
        }
        Bundle arguments6 = getArguments();
        if (arguments6 != null) {
            i14 = arguments6.getInt("collectionId");
        } else {
            i14 = 0;
        }
        ((TextView) _$_findCachedViewById(R.id.cancelBtn)).setOnClickListener(new a(this));
        ((ImageView) _$_findCachedViewById(R.id.clearBtn)).setOnClickListener(new b(this));
        int i15 = R.id.searchEdt;
        String str5 = str2;
        String str6 = str3;
        int i16 = i13;
        int i17 = i12;
        int i18 = i12;
        VendorSearchFragment$onActivityCreated$3 vendorSearchFragment$onActivityCreated$3 = r0;
        int i19 = i11;
        int i21 = i11;
        EditText editText = (EditText) _$_findCachedViewById(i15);
        int i22 = i14;
        VendorSearchFragment$onActivityCreated$3 vendorSearchFragment$onActivityCreated$32 = new VendorSearchFragment$onActivityCreated$3(this, str5, str6, i16, i17, i19, i22);
        editText.addTextChangedListener(vendorSearchFragment$onActivityCreated$3);
        ((EditText) _$_findCachedViewById(i15)).setOnEditorActionListener(new c(this, str5, str6, i16, i18, i21, i22));
    }

    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "VendorSearchFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "VendorSearchFragment#onCreateView", (ArrayList<String>) null);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_restaurants_search, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…search, container, false)");
        TraceMachine.exitMethod();
        return inflate;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }
}
