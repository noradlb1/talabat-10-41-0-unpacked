package com.talabat.fragments;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.materialedittext.MaterialEditText;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.R;
import com.talabat.adapters.PlacesAutoCompleteAdapter;
import com.talabat.authentication.aaa.di.SecretCoreLibApi;
import com.talabat.authentication.aaa.secrets.SecretProvider;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.di.map.DaggerCustomAutoCompleteFragmentComponent;
import com.talabat.helpers.TalabatUtils;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mq.a;
import mq.b;
import mq.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\t\u0018\u0000 @2\u00020\u00012\u00020\u0002:\u0002@AB\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010$\u001a\u00020%J\u0010\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020(H\u0016J\u0006\u0010)\u001a\u00020%J\u0006\u0010*\u001a\u00020%J\u000e\u0010+\u001a\u00020%2\u0006\u0010,\u001a\u00020\u0005J\u0010\u0010-\u001a\u00020%2\u0006\u0010.\u001a\u00020\fH\u0016J\u0010\u0010/\u001a\u00020%2\u0006\u00100\u001a\u000201H\u0016J\u0012\u00102\u001a\u00020%2\b\u00103\u001a\u0004\u0018\u000104H\u0016J&\u00105\u001a\u0004\u0018\u00010\u00052\u0006\u00106\u001a\u0002072\b\u0010\u0007\u001a\u0004\u0018\u0001082\b\u00103\u001a\u0004\u0018\u000104H\u0016J\b\u00109\u001a\u00020%H\u0016J\b\u0010:\u001a\u00020%H\u0016J\b\u0010;\u001a\u00020%H\u0016J\u0010\u0010<\u001a\u00020%2\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010=\u001a\u00020%H\u0002J\n\u0010>\u001a\u00020\u001b*\u00020?R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0004\n\u0002\u0010\u001cR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001e\u001a\u00020\u001f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006B"}, d2 = {"Lcom/talabat/fragments/CustomAutoCompleteFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/talabat/adapters/PlacesAutoCompleteAdapter$ClickListener;", "()V", "backView", "Landroid/view/View;", "clearView", "container", "filterTextWatcher", "com/talabat/fragments/CustomAutoCompleteFragment$filterTextWatcher$1", "Lcom/talabat/fragments/CustomAutoCompleteFragment$filterTextWatcher$1;", "isFoceKeyBroad", "", "isFromCart", "isStartAutoComplete", "keyboradIsShown", "listCardView", "listener", "Lcom/talabat/fragments/CustomAutoCompleteFragment$OnFragmentInteractionListener;", "mAutoCompleteAdapter", "Lcom/talabat/adapters/PlacesAutoCompleteAdapter;", "mPlaceRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "mSearchEd", "Lcom/materialedittext/MaterialEditText;", "noResultView", "originalMode", "", "Ljava/lang/Integer;", "searchContainer", "secretProvider", "Lcom/talabat/authentication/aaa/secrets/SecretProvider;", "getSecretProvider", "()Lcom/talabat/authentication/aaa/secrets/SecretProvider;", "setSecretProvider", "(Lcom/talabat/authentication/aaa/secrets/SecretProvider;)V", "clearText", "", "click", "place", "Lcom/google/android/libraries/places/api/model/Place;", "forceFocus", "hideKeyBoard", "initView", "view", "noResultFound", "isNoResultFound", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "Landroid/view/ViewGroup;", "onDestroy", "onDetach", "onPause", "setHeaderBg", "setHintView", "getSoftInputMode", "Landroid/view/Window;", "Companion", "OnFragmentInteractionListener", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CustomAutoCompleteFragment extends Fragment implements PlacesAutoCompleteAdapter.ClickListener, TraceFieldInterface {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;
    @Nullable
    private View backView;
    /* access modifiers changed from: private */
    @Nullable
    public View clearView;
    @Nullable
    private View container;
    @NotNull
    private final CustomAutoCompleteFragment$filterTextWatcher$1 filterTextWatcher = new CustomAutoCompleteFragment$filterTextWatcher$1(this);
    private boolean isFoceKeyBroad;
    private boolean isFromCart;
    /* access modifiers changed from: private */
    public boolean isStartAutoComplete;
    private boolean keyboradIsShown = true;
    /* access modifiers changed from: private */
    @Nullable
    public View listCardView;
    @Nullable
    private OnFragmentInteractionListener listener;
    /* access modifiers changed from: private */
    @Nullable
    public PlacesAutoCompleteAdapter mAutoCompleteAdapter;
    /* access modifiers changed from: private */
    @Nullable
    public RecyclerView mPlaceRecyclerView;
    @Nullable
    private MaterialEditText mSearchEd;
    @Nullable
    private View noResultView;
    @Nullable
    private Integer originalMode;
    @Nullable
    private View searchContainer;
    @Inject
    public SecretProvider secretProvider;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¨\u0006\b"}, d2 = {"Lcom/talabat/fragments/CustomAutoCompleteFragment$Companion;", "", "()V", "newInstance", "Lcom/talabat/fragments/CustomAutoCompleteFragment;", "param1", "", "param2", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final CustomAutoCompleteFragment newInstance(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "param1");
            Intrinsics.checkNotNullParameter(str2, "param2");
            CustomAutoCompleteFragment customAutoCompleteFragment = new CustomAutoCompleteFragment();
            Bundle bundle = new Bundle();
            bundle.putString("param1", str);
            bundle.putString("param2", str2);
            customAutoCompleteFragment.setArguments(bundle);
            return customAutoCompleteFragment;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/talabat/fragments/CustomAutoCompleteFragment$OnFragmentInteractionListener;", "", "onBackClickListener", "", "onFragmentInteraction", "place", "Lcom/google/android/libraries/places/api/model/Place;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnFragmentInteractionListener {
        void onBackClickListener();

        void onFragmentInteraction(@NotNull Place place);
    }

    /* access modifiers changed from: private */
    /* renamed from: initView$lambda-0  reason: not valid java name */
    public static final void m10479initView$lambda0(CustomAutoCompleteFragment customAutoCompleteFragment, View view, boolean z11) {
        Intrinsics.checkNotNullParameter(customAutoCompleteFragment, "this$0");
        if (z11) {
            customAutoCompleteFragment.keyboradIsShown = true;
            customAutoCompleteFragment.isStartAutoComplete = true;
            return;
        }
        customAutoCompleteFragment.keyboradIsShown = false;
    }

    /* access modifiers changed from: private */
    /* renamed from: initView$lambda-1  reason: not valid java name */
    public static final void m10480initView$lambda1(CustomAutoCompleteFragment customAutoCompleteFragment, View view) {
        Intrinsics.checkNotNullParameter(customAutoCompleteFragment, "this$0");
        MaterialEditText materialEditText = customAutoCompleteFragment.mSearchEd;
        if (materialEditText != null) {
            materialEditText.setText("");
        }
        OnFragmentInteractionListener onFragmentInteractionListener = customAutoCompleteFragment.listener;
        if (onFragmentInteractionListener != null) {
            onFragmentInteractionListener.onBackClickListener();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initView$lambda-2  reason: not valid java name */
    public static final void m10481initView$lambda2(CustomAutoCompleteFragment customAutoCompleteFragment, View view) {
        Intrinsics.checkNotNullParameter(customAutoCompleteFragment, "this$0");
        MaterialEditText materialEditText = customAutoCompleteFragment.mSearchEd;
        if (materialEditText != null) {
            materialEditText.setText("");
        }
        customAutoCompleteFragment.setHintView();
    }

    @JvmStatic
    @NotNull
    public static final CustomAutoCompleteFragment newInstance(@NotNull String str, @NotNull String str2) {
        return Companion.newInstance(str, str2);
    }

    private final void setHeaderBg(boolean z11) {
        if (z11) {
            View view = this.searchContainer;
            if (view != null) {
                view.setBackgroundResource(R.drawable.edittext_boarder);
                return;
            }
            return;
        }
        View view2 = this.container;
        if (view2 != null) {
            Context context = getContext();
            Intrinsics.checkNotNull(context);
            view2.setBackground(ContextCompat.getDrawable(context, R.drawable.home_map_gradient));
        }
    }

    private final void setHintView() {
        MaterialEditText materialEditText = this.mSearchEd;
        if (materialEditText != null) {
            materialEditText.setHint(getResources().getString(R.string.map_seach_hint));
        }
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

    public final void clearText() {
        Editable editable;
        MaterialEditText materialEditText = this.mSearchEd;
        if (materialEditText != null) {
            editable = materialEditText.getText();
        } else {
            editable = null;
        }
        if (!TalabatUtils.isNullOrEmpty(String.valueOf(editable))) {
            MaterialEditText materialEditText2 = this.mSearchEd;
            if (materialEditText2 != null) {
                materialEditText2.setText("");
            }
            MaterialEditText materialEditText3 = this.mSearchEd;
            if (materialEditText3 != null) {
                materialEditText3.clearFocus();
            }
        }
    }

    public void click(@NotNull Place place) {
        Window window;
        Intrinsics.checkNotNullParameter(place, "place");
        MaterialEditText materialEditText = this.mSearchEd;
        if (materialEditText != null) {
            materialEditText.clearFocus();
        }
        this.isStartAutoComplete = false;
        MaterialEditText materialEditText2 = this.mSearchEd;
        if (materialEditText2 != null) {
            materialEditText2.setText(place.getName());
        }
        OnFragmentInteractionListener onFragmentInteractionListener = this.listener;
        if (onFragmentInteractionListener != null) {
            onFragmentInteractionListener.onFragmentInteraction(place);
        }
        this.keyboradIsShown = true;
        hideKeyBoard();
        if (this.isFoceKeyBroad) {
            try {
                Integer num = this.originalMode;
                if (num != null) {
                    int intValue = num.intValue();
                    FragmentActivity activity = getActivity();
                    if (activity != null && (window = activity.getWindow()) != null) {
                        window.setSoftInputMode(intValue);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public final void forceFocus() {
        Integer num;
        Window window;
        Window window2;
        MaterialEditText materialEditText = this.mSearchEd;
        if (materialEditText != null) {
            materialEditText.requestFocus();
        }
        try {
            FragmentActivity activity = getActivity();
            if (activity == null || (window2 = activity.getWindow()) == null) {
                num = null;
            } else {
                num = Integer.valueOf(getSoftInputMode(window2));
            }
            this.originalMode = num;
            FragmentActivity activity2 = getActivity();
            if (activity2 != null && (window = activity2.getWindow()) != null) {
                window.setSoftInputMode(4);
            }
        } catch (Exception unused) {
        }
    }

    @NotNull
    public final SecretProvider getSecretProvider() {
        SecretProvider secretProvider2 = this.secretProvider;
        if (secretProvider2 != null) {
            return secretProvider2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("secretProvider");
        return null;
    }

    public final int getSoftInputMode(@NotNull Window window) {
        Intrinsics.checkNotNullParameter(window, "<this>");
        return window.getAttributes().softInputMode;
    }

    public final void hideKeyBoard() {
        if (this.keyboradIsShown) {
            try {
                FragmentActivity activity = getActivity();
                Intrinsics.checkNotNull(activity);
                Object systemService = activity.getSystemService("input_method");
                if (systemService != null) {
                    View view = getView();
                    Intrinsics.checkNotNull(view);
                    ((InputMethodManager) systemService).hideSoftInputFromWindow(view.getWindowToken(), 0);
                    this.keyboradIsShown = false;
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            } catch (Exception unused) {
            }
        }
    }

    public final void initView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.places_recycler_view);
        if (recyclerView != null) {
            this.mPlaceRecyclerView = recyclerView;
            this.listCardView = view.findViewById(R.id.list_view);
            MaterialEditText materialEditText = (MaterialEditText) view.findViewById(R.id.ed_search_location);
            if (materialEditText != null) {
                this.mSearchEd = materialEditText;
                this.backView = view.findViewById(R.id.custom_back_map);
                this.clearView = view.findViewById(R.id.search_clear);
                this.noResultView = view.findViewById(R.id.no_search_result_found);
                this.container = view.findViewById(R.id.container);
                this.searchContainer = view.findViewById(R.id.edit_text_container);
                setHeaderBg(this.isFromCart);
                setHintView();
                MaterialEditText materialEditText2 = this.mSearchEd;
                if (materialEditText2 != null) {
                    materialEditText2.addTextChangedListener(this.filterTextWatcher);
                }
                Context context = getContext();
                Intrinsics.checkNotNull(context);
                this.mAutoCompleteAdapter = new PlacesAutoCompleteAdapter(context, this.isFromCart);
                RecyclerView recyclerView2 = this.mPlaceRecyclerView;
                if (recyclerView2 != null) {
                    recyclerView2.setLayoutManager(new LinearLayoutManager(getContext()));
                }
                PlacesAutoCompleteAdapter placesAutoCompleteAdapter = this.mAutoCompleteAdapter;
                if (placesAutoCompleteAdapter != null) {
                    placesAutoCompleteAdapter.setClickListener(this);
                }
                RecyclerView recyclerView3 = this.mPlaceRecyclerView;
                if (recyclerView3 != null) {
                    recyclerView3.setAdapter(this.mAutoCompleteAdapter);
                }
                PlacesAutoCompleteAdapter placesAutoCompleteAdapter2 = this.mAutoCompleteAdapter;
                if (placesAutoCompleteAdapter2 != null) {
                    placesAutoCompleteAdapter2.notifyDataSetChanged();
                }
                MaterialEditText materialEditText3 = this.mSearchEd;
                if (materialEditText3 != null) {
                    materialEditText3.setOnFocusChangeListener(new a(this));
                }
                View view2 = this.backView;
                if (view2 != null) {
                    view2.setOnClickListener(new b(this));
                }
                View view3 = this.clearView;
                if (view3 != null) {
                    view3.setOnClickListener(new c(this));
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.materialedittext.MaterialEditText");
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
    }

    public void noResultFound(boolean z11) {
        if (z11) {
            View view = this.noResultView;
            if (view != null) {
                view.setVisibility(0);
                return;
            }
            return;
        }
        View view2 = this.noResultView;
        if (view2 != null) {
            view2.setVisibility(8);
        }
    }

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            this.listener = (OnFragmentInteractionListener) context;
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        TraceMachine.startTracing("CustomAutoCompleteFragment");
        try {
            TraceMachine.enterMethod(this._nr_trace, "CustomAutoCompleteFragment#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "CustomAutoCompleteFragment#onCreate", (ArrayList<String>) null);
        }
        super.onCreate(bundle);
        DaggerCustomAutoCompleteFragmentComponent.factory().create((SecretCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(SecretCoreLibApi.class)).inject(this);
        Places.initialize(requireContext(), getSecretProvider().getGoogleApiKey());
        TraceMachine.exitMethod();
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "CustomAutoCompleteFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "CustomAutoCompleteFragment#onCreateView", (ArrayList<String>) null);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_custom_auto_complete, viewGroup, false);
        if (getArguments() != null) {
            Bundle arguments = getArguments();
            Intrinsics.checkNotNull(arguments);
            this.isFromCart = arguments.getBoolean("isFromCart", false);
            Bundle arguments2 = getArguments();
            Intrinsics.checkNotNull(arguments2);
            this.isFoceKeyBroad = arguments2.getBoolean("isFroForceFocus", false);
        }
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        initView(inflate);
        if (this.isFoceKeyBroad) {
            forceFocus();
        }
        TraceMachine.exitMethod();
        return inflate;
    }

    public void onDestroy() {
        Window window;
        super.onDestroy();
        try {
            Integer num = this.originalMode;
            if (num != null) {
                int intValue = num.intValue();
                FragmentActivity activity = getActivity();
                if (activity != null && (window = activity.getWindow()) != null) {
                    window.setSoftInputMode(intValue);
                }
            }
        } catch (Exception unused) {
        }
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onDetach() {
        super.onDetach();
        this.listener = null;
    }

    public void onPause() {
        Window window;
        super.onPause();
        try {
            Integer num = this.originalMode;
            if (num != null) {
                int intValue = num.intValue();
                FragmentActivity activity = getActivity();
                if (activity != null && (window = activity.getWindow()) != null) {
                    window.setSoftInputMode(intValue);
                }
            }
        } catch (Exception unused) {
        }
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public final void setSecretProvider(@NotNull SecretProvider secretProvider2) {
        Intrinsics.checkNotNullParameter(secretProvider2, "<set-?>");
        this.secretProvider = secretProvider2;
    }
}
