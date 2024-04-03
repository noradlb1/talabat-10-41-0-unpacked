package com.talabat.fragments;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.talabat.R;
import com.talabat.helpers.GlobalDataModel;
import io.supercharge.shimmerlayout.ShimmerLayout;

public class SkeletonLinearLayout extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    public ShimmerLayout f59817b;

    /* renamed from: c  reason: collision with root package name */
    public ShimmerLayout f59818c;

    /* renamed from: d  reason: collision with root package name */
    public ShimmerLayout f59819d;

    /* renamed from: e  reason: collision with root package name */
    public ShimmerLayout f59820e;

    /* renamed from: f  reason: collision with root package name */
    public ShimmerLayout f59821f;

    /* renamed from: g  reason: collision with root package name */
    public ShimmerLayout f59822g;

    /* renamed from: h  reason: collision with root package name */
    public ShimmerLayout f59823h;

    /* renamed from: i  reason: collision with root package name */
    public ShimmerLayout f59824i;

    public SkeletonLinearLayout(Context context) {
        super(context);
        initView(LayoutInflater.from(getContext()).inflate(R.layout.fragment_skeleton, this));
    }

    private void initView(View view) {
        this.f59817b = (ShimmerLayout) view.findViewById(R.id.shimmer1);
        this.f59818c = (ShimmerLayout) view.findViewById(R.id.shimmer2);
        this.f59819d = (ShimmerLayout) view.findViewById(R.id.shimmer3);
        this.f59820e = (ShimmerLayout) view.findViewById(R.id.shimmer4);
        this.f59821f = (ShimmerLayout) view.findViewById(R.id.shimmer5);
        this.f59822g = (ShimmerLayout) view.findViewById(R.id.shimmer6);
        this.f59823h = (ShimmerLayout) view.findViewById(R.id.shimmer7);
        this.f59824i = (ShimmerLayout) view.findViewById(R.id.shimmer8);
        if (GlobalDataModel.SelectedLanguage.equals("en-US")) {
            this.f59817b.setAnimationReversed(false);
            this.f59818c.setAnimationReversed(false);
            this.f59819d.setAnimationReversed(false);
            this.f59820e.setAnimationReversed(false);
            this.f59821f.setAnimationReversed(false);
            this.f59822g.setAnimationReversed(false);
            this.f59823h.setAnimationReversed(false);
            this.f59824i.setAnimationReversed(false);
            return;
        }
        this.f59817b.setAnimationReversed(true);
        this.f59818c.setAnimationReversed(true);
        this.f59819d.setAnimationReversed(true);
        this.f59820e.setAnimationReversed(true);
        this.f59821f.setAnimationReversed(true);
        this.f59822g.setAnimationReversed(true);
        this.f59823h.setAnimationReversed(true);
        this.f59824i.setAnimationReversed(true);
    }

    public SkeletonLinearLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(LayoutInflater.from(getContext()).inflate(R.layout.fragment_skeleton, this));
    }

    public SkeletonLinearLayout(Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        initView(LayoutInflater.from(getContext()).inflate(R.layout.fragment_skeleton, this));
    }
}
