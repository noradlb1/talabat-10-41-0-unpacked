package com.talabat.feature.pickup.presentation;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResultCaller;
import androidx.core.view.ViewGroupKt;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rn.m;

@Instrumented
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000f"}, d2 = {"Lcom/talabat/feature/pickup/presentation/ValuePropFragment;", "Landroidx/fragment/app/Fragment;", "()V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "Companion", "com_talabat_feature_pickup_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ValuePropFragment extends Fragment implements TraceFieldInterface {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String TAG = "ValuePropFragment";
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/feature/pickup/presentation/ValuePropFragment$Companion;", "", "()V", "TAG", "", "com_talabat_feature_pickup_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-0  reason: not valid java name */
    public static final void m10256onViewCreated$lambda0(ValuePropFragment valuePropFragment, View view) {
        ActivityResultCaller activityResultCaller;
        FragmentManager supportFragmentManager;
        Intrinsics.checkNotNullParameter(valuePropFragment, "this$0");
        FragmentActivity activity = valuePropFragment.getActivity();
        DialogFragment dialogFragment = null;
        if (activity == null || (supportFragmentManager = activity.getSupportFragmentManager()) == null) {
            activityResultCaller = null;
        } else {
            activityResultCaller = supportFragmentManager.findFragmentByTag(TAG);
        }
        if (activityResultCaller instanceof DialogFragment) {
            dialogFragment = (DialogFragment) activityResultCaller;
        }
        if (dialogFragment != null) {
            dialogFragment.dismiss();
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

    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "ValuePropFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "ValuePropFragment#onCreateView", (ArrayList<String>) null);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_pickup_value_prop, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…e_prop, container, false)");
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

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        KeyEvent.Callback callback;
        Sequence<View> children;
        View view2;
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.closeBtn);
        Fragment parentFragment = getParentFragment();
        ViewGroup viewGroup = null;
        if (parentFragment != null) {
            callback = parentFragment.getView();
        } else {
            callback = null;
        }
        if (callback instanceof ViewGroup) {
            viewGroup = (ViewGroup) callback;
        }
        if (!(viewGroup == null || (children = ViewGroupKt.getChildren(viewGroup)) == null || (view2 = (View) SequencesKt___SequencesKt.firstOrNull(children)) == null)) {
            view2.setPadding(0, 0, 0, 0);
        }
        findViewById.setOnClickListener(new m(this));
    }
}
