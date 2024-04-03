package com.instabug.featuresrequest.ui.featuredetails;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.instabug.featuresrequest.R;

public class j {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public final RelativeLayout f46771a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f46772b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final TextView f46773c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final TextView f46774d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public final TextView f46775e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public final TextView f46776f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public final TextView f46777g;

    public j(View view) {
        this.f46772b = (ImageView) view.findViewById(R.id.instabug_feature_requests_comment_avatar);
        this.f46773c = (TextView) view.findViewById(R.id.instabug_feature_requests_comment_username);
        this.f46774d = (TextView) view.findViewById(R.id.instabug_feature_requests_comment_date);
        this.f46775e = (TextView) view.findViewById(R.id.instabug_feature_feature_details_comment);
        this.f46771a = (RelativeLayout) view.findViewById(R.id.instabug_feature_request_admin_comment_layout);
        this.f46776f = (TextView) view.findViewById(R.id.instabug_feature_request_new_status);
        this.f46777g = (TextView) view.findViewById(R.id.instabug_feature_request_new_status_date);
    }
}
