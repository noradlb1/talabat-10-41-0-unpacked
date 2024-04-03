package com.talabat.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.R;
import com.talabat.talabatcommon.views.ShimmerLayout;
import java.util.ArrayList;

@Instrumented
public class SkeletonFragment extends Fragment implements TraceFieldInterface {
    public ShimmerLayout C;
    public ShimmerLayout F;
    public ShimmerLayout G;
    public ShimmerLayout H;
    public ShimmerLayout I;
    public ShimmerLayout J;
    public ShimmerLayout K;
    public ShimmerLayout L;
    public Trace _nr_trace;

    public static SkeletonFragment getInstance() {
        return new SkeletonFragment();
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "SkeletonFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "SkeletonFragment#onCreateView", (ArrayList<String>) null);
        }
        View inflate = layoutInflater.inflate(R.layout.fragment_skeleton, viewGroup, false);
        this.C = (ShimmerLayout) inflate.findViewById(R.id.shimmer1);
        this.F = (ShimmerLayout) inflate.findViewById(R.id.shimmer2);
        this.G = (ShimmerLayout) inflate.findViewById(R.id.shimmer3);
        this.H = (ShimmerLayout) inflate.findViewById(R.id.shimmer4);
        this.I = (ShimmerLayout) inflate.findViewById(R.id.shimmer5);
        this.J = (ShimmerLayout) inflate.findViewById(R.id.shimmer6);
        this.K = (ShimmerLayout) inflate.findViewById(R.id.shimmer7);
        this.L = (ShimmerLayout) inflate.findViewById(R.id.shimmer8);
        this.C.startShimmerAnimation();
        this.F.startShimmerAnimation();
        this.G.startShimmerAnimation();
        this.H.startShimmerAnimation();
        this.I.startShimmerAnimation();
        this.J.startShimmerAnimation();
        this.K.startShimmerAnimation();
        this.L.startShimmerAnimation();
        TraceMachine.exitMethod();
        return inflate;
    }

    public void onDestroyView() {
        this.C.stopShimmerAnimation();
        this.F.stopShimmerAnimation();
        this.G.stopShimmerAnimation();
        this.H.stopShimmerAnimation();
        this.I.stopShimmerAnimation();
        this.J.stopShimmerAnimation();
        this.K.stopShimmerAnimation();
        this.L.stopShimmerAnimation();
        super.onDestroyView();
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }
}
