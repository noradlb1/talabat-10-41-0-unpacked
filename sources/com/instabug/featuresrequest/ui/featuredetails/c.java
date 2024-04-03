package com.instabug.featuresrequest.ui.featuredetails;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.instabug.featuresrequest.R;
import com.instabug.featuresrequest.models.b;
import com.instabug.featuresrequest.models.g;
import com.instabug.featuresrequest.models.i;
import com.instabug.featuresrequest.models.j;
import com.instabug.featuresrequest.ui.base.featureslist.p;
import com.instabug.featuresrequest.ui.custom.d;
import com.instabug.featuresrequest.ui.custom.x;
import com.instabug.featuresrequest.ui.custom.y;
import com.instabug.featuresrequest.utils.a;
import com.instabug.featuresrequest.utils.f;
import com.instabug.featuresrequest.utils.h;
import com.instabug.featuresrequest.utils.n;
import com.instabug.library.core.ui.BaseContract;
import com.instabug.library.util.AttrResolver;
import java.util.ArrayList;

@SuppressLint({"ERADICATE_FIELD_NOT_INITIALIZED"})
public class c extends d implements d {
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f46743d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private com.instabug.featuresrequest.models.d f46744e;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public TextView f46745f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private TextView f46746g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private TextView f46747h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private TextView f46748i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private TextView f46749j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private TextView f46750k;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    public ImageView f46751l;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private TextView f46752m;
    @Nullable

    /* renamed from: n  reason: collision with root package name */
    private LinearLayout f46753n;
    @Nullable

    /* renamed from: o  reason: collision with root package name */
    private LinearLayout f46754o;
    @Nullable

    /* renamed from: p  reason: collision with root package name */
    private ListView f46755p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public boolean f46756q = false;
    @Nullable

    /* renamed from: r  reason: collision with root package name */
    private k f46757r;
    @NonNull

    /* renamed from: s  reason: collision with root package name */
    private ArrayList f46758s = new ArrayList();

    /* renamed from: t  reason: collision with root package name */
    private p f46759t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f46760u = false;

    /* access modifiers changed from: private */
    public /* synthetic */ void N() {
        com.instabug.featuresrequest.models.d dVar;
        this.f46760u = true;
        BaseContract.Presenter presenter = this.C;
        if (presenter != null && (dVar = this.f46744e) != null) {
            ((f) presenter).a(dVar);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O() {
        BaseContract.Presenter presenter = this.C;
        if (presenter != null) {
            ((f) presenter).a();
        }
    }

    public static c a(com.instabug.featuresrequest.models.d dVar, p pVar) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("key_feature", dVar);
        c cVar = new c();
        cVar.a(pVar);
        cVar.setArguments(bundle);
        return cVar;
    }

    private void a(p pVar) {
        this.f46759t = pVar;
    }

    private void c(com.instabug.featuresrequest.models.d dVar) {
        LinearLayout linearLayout = this.f46743d;
        if (linearLayout != null) {
            linearLayout.post(new b(this, dVar));
        }
    }

    public void F() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }

    public void P() {
        BaseContract.Presenter presenter;
        com.instabug.featuresrequest.models.d dVar = this.f46744e;
        if (dVar != null && (presenter = this.C) != null) {
            f fVar = (f) presenter;
            dVar.a(dVar.b() + 1);
            a(this.f46744e);
            fVar.a(this.f46744e.g());
            this.C = fVar;
        }
    }

    public void a(com.instabug.featuresrequest.models.d dVar) {
        String str;
        this.f46744e = dVar;
        TextView textView = this.f46746g;
        if (textView != null) {
            textView.setText(dVar.m());
        }
        if (this.f46752m != null) {
            if (dVar.e() == null || dVar.e().equalsIgnoreCase("null") || TextUtils.isEmpty(dVar.e())) {
                this.f46752m.setVisibility(8);
            } else {
                this.f46752m.setVisibility(0);
                n.a(this.f46752m, dVar.e(), getLocalizedString(R.string.feature_request_str_more), getLocalizedString(R.string.feature_request_str_less), !this.f46756q, new a(this));
            }
        }
        if (!(this.f46754o == null || this.f46743d == null)) {
            if (dVar.o()) {
                this.f46754o.setVisibility(8);
                this.f46743d.setEnabled(false);
            } else {
                this.f46754o.setVisibility(0);
                this.f46743d.setEnabled(true);
            }
        }
        if (getContext() != null) {
            TextView textView2 = this.f46748i;
            if (textView2 != null) {
                if (dVar.c() == null || dVar.c().equalsIgnoreCase("null") || TextUtils.isEmpty(dVar.c())) {
                    str = getLocalizedString(R.string.feature_request_owner_anonymous);
                } else {
                    str = getLocalizedString(R.string.feature_request_owner, dVar.c());
                }
                textView2.setText(str);
            }
            TextView textView3 = this.f46750k;
            if (textView3 != null) {
                textView3.setText(getLocalizedString(R.string.feature_request_comments_count, Integer.valueOf(dVar.b())));
            }
            h.a(dVar.l(), dVar.a(), this.f46747h, getContext());
            TextView textView4 = this.f46749j;
            if (textView4 != null) {
                textView4.setText(a.a(getContext(), dVar.d()));
            }
            c(dVar);
        }
    }

    public void a(j jVar) {
        ListView listView = this.f46755p;
        if (listView != null) {
            this.f46758s = new ArrayList();
            this.f46757r = null;
            k kVar = new k(this.f46758s, this);
            this.f46757r = kVar;
            listView.setAdapter(kVar);
            this.f46758s.addAll(jVar.b());
            this.f46757r.notifyDataSetChanged();
            LinearLayout linearLayout = this.f46753n;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            listView.invalidate();
            f.a(listView);
        }
        this.f46755p = listView;
    }

    public void b(com.instabug.featuresrequest.models.d dVar) {
        c(dVar);
    }

    public void d() {
        LinearLayout linearLayout = this.f46753n;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
    }

    public int o0() {
        return R.layout.ib_fr_features_details_fragment;
    }

    public void onClick(View view) {
        if (view.getId() == R.id.tv_add_comment && getActivity() != null && this.f46744e != null) {
            getActivity().getSupportFragmentManager().beginTransaction().add(R.id.instabug_fragment_container, (Fragment) com.instabug.featuresrequest.ui.addcomment.f.a(this.f46744e.g())).addToBackStack("add_comment").commit();
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.f46744e = (com.instabug.featuresrequest.models.d) getArguments().getSerializable("key_feature");
        }
        this.C = new f(this);
    }

    public void onDestroy() {
        super.onDestroy();
        p pVar = this.f46759t;
        if (pVar != null && this.f46760u) {
            pVar.u();
        }
    }

    public String p0() {
        return getLocalizedString(R.string.feature_requests_details);
    }

    public y q0() {
        return new y(R.drawable.ibg_core_ic_back, R.string.feature_request_go_back, new oc.a(this), x.ICON);
    }

    public void r0(View view, @Nullable Bundle bundle) {
        com.instabug.featuresrequest.models.d dVar;
        RelativeLayout relativeLayout = this.G;
        f fVar = (f) this.C;
        if (relativeLayout != null) {
            this.f46743d = (LinearLayout) relativeLayout.findViewById(R.id.ib_feature_request_toolbar_vote_action_layout);
            this.f46745f = (TextView) relativeLayout.findViewById(R.id.ib_toolbar_vote_count);
            this.f46751l = (ImageView) relativeLayout.findViewById(R.id.ib_toolbar_vote_icon);
        }
        this.f46752m = (TextView) view.findViewById(R.id.ib_fr_tv_feature_details_desc);
        this.f46746g = (TextView) view.findViewById(R.id.ib_fr_details_title);
        this.f46747h = (TextView) view.findViewById(R.id.instabug_txt_feature_request_status);
        this.f46749j = (TextView) view.findViewById(R.id.ib_txt_feature_request_date);
        this.f46748i = (TextView) view.findViewById(R.id.ib_txt_feature_request_owner);
        TextView textView = (TextView) view.findViewById(R.id.tv_add_comment);
        this.f46750k = (TextView) view.findViewById(R.id.ib_features_request_comment_count);
        this.f46753n = (LinearLayout) view.findViewById(R.id.ib_fr_details_no_comments_layout);
        ImageView imageView = (ImageView) view.findViewById(R.id.ib_fr_details_no_comments_icon);
        this.f46755p = (ListView) view.findViewById(R.id.instabug_feature_details_comments_list);
        this.f46754o = (LinearLayout) view.findViewById(R.id.addCommentLayoutContainer);
        this.G = relativeLayout;
        if (!(imageView == null || getContext() == null)) {
            imageView.setColorFilter(AttrResolver.getColor(getContext(), R.attr.ib_fr_no_comments_icon_color));
        }
        if (textView != null) {
            textView.setOnClickListener(this);
        }
        k kVar = new k(this.f46758s, this);
        this.f46757r = kVar;
        ListView listView = this.f46755p;
        if (listView != null) {
            listView.setAdapter(kVar);
        }
        if (fVar != null && (dVar = this.f46744e) != null) {
            a(dVar);
            fVar.a(this.f46744e.g());
            this.C = fVar;
        }
    }

    public void t() {
        if (this.f46758s.size() > 0) {
            int i11 = 0;
            while (i11 < this.f46758s.size() - 1) {
                i iVar = (i) this.f46758s.get(i11);
                if (!(iVar instanceof g) || this.f46754o == null || this.f46743d == null) {
                    i11++;
                } else if (((g) iVar).c() == b.Completed) {
                    this.f46754o.setVisibility(8);
                    this.f46743d.setEnabled(false);
                    return;
                } else {
                    this.f46754o.setVisibility(0);
                    this.f46743d.setEnabled(true);
                    return;
                }
            }
        }
    }

    public void u() {
        this.H.add(new y(-1, R.string.ib_feature_rq_str_votes, new oc.b(this), x.VOTE));
    }

    public void w() {
        f.a(this.f46755p);
    }
}
