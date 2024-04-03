package com.talabat;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.components.gem.menu.GemComponentMenuFooterStrategy;
import com.talabat.components.gem.menu.GemMenuFooterStrategy;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0017J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0016J$\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0007H\u0016J\b\u0010\u0016\u001a\u00020\u0007H\u0016J\u001a\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u001a\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0007H\u0016J\b\u0010\u001e\u001a\u00020\u0007H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/talabat/GemFooterViewManager;", "Landroidx/fragment/app/Fragment;", "Lcom/talabat/components/gem/menu/GemMenuFooterStrategy;", "()V", "implementation", "Lcom/talabat/components/gem/menu/GemComponentMenuFooterStrategy;", "initialiseTimer", "", "onAttach", "activity", "Landroid/app/Activity;", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "bundle", "Landroid/os/Bundle;", "onDestroy", "onDetach", "onViewCreated", "v", "savedInstanceState", "refreshTimer", "timerText", "", "startTimer", "stopTimer", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GemFooterViewManager extends Fragment implements GemMenuFooterStrategy, TraceFieldInterface {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;
    @NotNull
    private final GemComponentMenuFooterStrategy implementation = new GemComponentMenuFooterStrategy();

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

    public void initialiseTimer() {
        this.implementation.initialiseTimer();
    }

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        this.implementation.onAttach(context);
    }

    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "GemFooterViewManager#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "GemFooterViewManager#onCreateView", (ArrayList<String>) null);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View onCreateView = this.implementation.onCreateView(layoutInflater, viewGroup, bundle);
        TraceMachine.exitMethod();
        return onCreateView;
    }

    public void onDestroy() {
        this.implementation.onDestroy();
        super.onDestroy();
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onDetach() {
        this.implementation.onDetach();
        super.onDetach();
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "v");
        super.onViewCreated(view, bundle);
        this.implementation.onViewCreated(view, bundle);
    }

    public void refreshTimer(@Nullable String str) {
        this.implementation.refreshTimer(str);
    }

    public void startTimer() {
        this.implementation.startTimer();
    }

    public void stopTimer() {
        this.implementation.stopTimer();
    }

    @SuppressLint({"MissingSuperCall"})
    public void onAttach(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onAttach(activity);
        this.implementation.onAttach(activity);
    }
}
