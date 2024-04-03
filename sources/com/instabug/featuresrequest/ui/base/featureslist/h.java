package com.instabug.featuresrequest.ui.base.featureslist;

import android.annotation.SuppressLint;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.instabug.featuresrequest.R;
import com.instabug.featuresrequest.listeners.a;
import com.instabug.featuresrequest.listeners.b;
import com.instabug.featuresrequest.models.d;
import com.instabug.featuresrequest.ui.featuredetails.c;
import com.instabug.featuresrequest.ui.newfeature.g;
import com.instabug.library.Feature;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.ui.BaseContract;
import com.instabug.library.core.ui.InstabugBaseFragment;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.InstabugSDKLogger;

@SuppressLint({"ERADICATE_FIELD_NOT_INITIALIZED"})
public abstract class h extends InstabugBaseFragment implements f, a, View.OnClickListener, b, p, SwipeRefreshLayout.OnRefreshListener {
    @Nullable
    public ListView G;
    public b H;
    public boolean I = false;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private ViewStub f46641c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private ViewStub f46642d;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private View f46643f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private ProgressBar f46644g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private LinearLayout f46645h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f46646i = false;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private SwipeRefreshLayout f46647j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public boolean f46648k = false;

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    private void L() {
        View view;
        ListView listView = this.G;
        n nVar = (n) this.C;
        if (getContext() != null && listView != null && nVar != null && (view = this.f46643f) != null) {
            try {
                if (this.f46646i) {
                    listView.removeFooterView(view);
                    listView.addFooterView(this.f46643f);
                } else {
                    View inflate = View.inflate(getContext(), R.layout.ib_fr_pull_to_refresh_footer_view, (ViewGroup) null);
                    this.f46643f = inflate;
                    if (inflate != null) {
                        this.f46644g = (ProgressBar) inflate.findViewById(R.id.ib_loadmore_progressbar);
                        this.f46645h = (LinearLayout) this.f46643f.findViewById(R.id.instabug_pbi_container);
                        ProgressBar progressBar = this.f46644g;
                        if (progressBar != null) {
                            progressBar.setVisibility(4);
                            this.f46644g.getIndeterminateDrawable().setColorFilter(SettingsManager.getInstance().getPrimaryColor(), PorterDuff.Mode.SRC_IN);
                        }
                        listView.addFooterView(this.f46643f);
                        nVar.b();
                        this.f46646i = true;
                    }
                }
            } catch (Exception e11) {
                InstabugSDKLogger.e("IBG-FR", "exception occurring while setting up the loadMore views", e11);
            } catch (Throwable th2) {
                this.G = listView;
                this.C = nVar;
                throw th2;
            }
            this.G = listView;
            this.C = nVar;
        }
    }

    private void M() {
        ListView listView = this.G;
        if (listView != null) {
            listView.setOnScrollListener(new g(this));
        }
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    private void N() {
        ListView listView = this.G;
        if (listView != null) {
            listView.setOnScrollListener((AbsListView.OnScrollListener) null);
        }
    }

    public void A() {
        if (this.G != null) {
            L();
            f();
        }
        ProgressBar progressBar = this.f46644g;
        BaseContract.Presenter presenter = this.C;
        if (!(presenter == null || progressBar == null)) {
            if (((n) presenter).c()) {
                progressBar.setVisibility(0);
            } else {
                N();
                progressBar.setVisibility(8);
            }
        }
        this.f46644g = progressBar;
        this.f46648k = false;
    }

    public void D() {
        ProgressBar progressBar = this.f46644g;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
    }

    public boolean I() {
        return this.I;
    }

    @NonNull
    public abstract n K();

    public void a() {
        if (getActivity() != null) {
            getActivity().getSupportFragmentManager().beginTransaction().add(R.id.instabug_fragment_container, (Fragment) new g()).addToBackStack("search_features").commit();
        }
    }

    public void a(@StringRes int i11) {
        if (getViewContext().getContext() != null) {
            Toast.makeText(getViewContext().getContext(), getLocalizedString(i11), 0).show();
        }
    }

    public void a(d dVar) {
        BaseContract.Presenter presenter = this.C;
        if (presenter != null) {
            ((n) presenter).a(dVar);
        }
    }

    public void a(Boolean bool) {
        ListView listView = this.G;
        if (listView != null) {
            listView.smoothScrollToPosition(0);
        }
        M();
        BaseContract.Presenter presenter = this.C;
        if (presenter != null) {
            ((n) presenter).k();
        }
    }

    public void b() {
        ViewStub viewStub = this.f46641c;
        if (viewStub != null) {
            viewStub.setVisibility(8);
        }
    }

    public void b(boolean z11) {
        SwipeRefreshLayout swipeRefreshLayout = this.f46647j;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setRefreshing(z11);
        }
    }

    public void c(int i11) {
        BaseContract.Presenter presenter = this.C;
        if (presenter != null) {
            ((n) presenter).a(i11);
        }
    }

    public void c(d dVar) {
        BaseContract.Presenter presenter = this.C;
        if (presenter != null) {
            ((n) presenter).b(dVar);
        }
    }

    public void c(String str) {
        if (str != null && getViewContext().getContext() != null) {
            Toast.makeText(getViewContext().getContext(), str, 0).show();
        }
    }

    public void d(d dVar) {
        if (getActivity() != null) {
            getActivity().getSupportFragmentManager().beginTransaction().add(R.id.instabug_fragment_container, (Fragment) c.a(dVar, this)).addToBackStack("feature_requests_details").commit();
        }
    }

    public void f() {
        b bVar = this.H;
        if (bVar != null) {
            bVar.notifyDataSetChanged();
        }
    }

    public void h() {
        if (getActivity() != null && this.f46643f != null && this.f46645h != null) {
            if (InstabugCore.getFeatureState(Feature.WHITE_LABELING) != Feature.State.ENABLED || SettingsManager.getInstance().isCustomBrandingEnabled()) {
                InstabugCore.handlePbiFooter(this.f46643f);
                InstabugCore.handlePbiFooterThemeColor(this.f46643f, R.color.pbi_footer_color_dark, R.color.pbi_footer_color_light);
                return;
            }
            this.f46645h.setVisibility(4);
        }
    }

    public void i() {
        ProgressBar progressBar = this.f46644g;
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
    }

    public int i0() {
        return R.layout.ib_fr_features_list_fragment;
    }

    public void j() {
        if (getActivity() != null) {
            c(getLocalizedString(R.string.feature_requests_error_state_sub_title));
        }
    }

    @CallSuper
    public void j0(View view, @Nullable Bundle bundle) {
        this.f46641c = (ViewStub) i(R.id.ib_empty_state_stub);
        this.f46642d = (ViewStub) i(R.id.error_state_stub);
        this.G = (ListView) i(R.id.features_request_list);
        M();
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) i(R.id.swipeRefreshLayout);
        this.f46647j = swipeRefreshLayout;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setColorSchemeColors(SettingsManager.getInstance().getPrimaryColor());
            this.f46647j.setOnRefreshListener(this);
            if (getArguments() != null) {
                this.I = getArguments().getBoolean("my_posts", false);
            }
            n nVar = (n) this.C;
            if (bundle == null || nVar == null) {
                nVar = K();
            } else {
                this.f46646i = false;
                if (bundle.getBoolean("empty_state") && nVar.a() == 0) {
                    o();
                }
                if (bundle.getBoolean("error_state") && nVar.a() == 0) {
                    x();
                }
                if (nVar.a() > 0) {
                    L();
                }
            }
            this.C = nVar;
            b bVar = new b(nVar, this);
            this.H = bVar;
            ListView listView = this.G;
            if (listView != null) {
                listView.setAdapter(bVar);
            }
        }
    }

    public void k() {
        ListView listView = this.G;
        if (listView != null) {
            listView.smoothScrollToPosition(0);
        }
        M();
        BaseContract.Presenter presenter = this.C;
        if (presenter != null) {
            ((n) presenter).k();
        }
    }

    public void l() {
        ViewStub viewStub = this.f46642d;
        if (viewStub != null) {
            viewStub.setVisibility(8);
        }
    }

    public void o() {
        ViewStub viewStub = this.f46641c;
        if (viewStub == null) {
            return;
        }
        if (viewStub.getParent() != null) {
            View inflate = this.f46641c.inflate();
            Button button = (Button) inflate.findViewById(R.id.ib_empty_state_action);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.ib_empty_state_icon);
            if (imageView != null) {
                imageView.setImageResource(R.drawable.ibg_fr_ic_features_empty_state);
            }
            com.instabug.featuresrequest.utils.b.a(button, SettingsManager.getInstance().getPrimaryColor());
            if (button != null) {
                button.setOnClickListener(this);
                return;
            }
            return;
        }
        this.f46641c.setVisibility(0);
    }

    public void onClick(View view) {
        int id2 = view.getId();
        BaseContract.Presenter presenter = this.C;
        if (presenter != null) {
            if (id2 == R.id.ib_empty_state_action) {
                ((n) presenter).e();
                return;
            }
            ViewStub viewStub = this.f46642d;
            if (viewStub != null && id2 == viewStub.getInflatedId()) {
                ((n) this.C).f();
            }
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
    }

    public void onDestroy() {
        super.onDestroy();
        BaseContract.Presenter presenter = this.C;
        if (presenter != null) {
            ((n) presenter).onDestroy();
        }
    }

    public void onRefresh() {
        M();
        BaseContract.Presenter presenter = this.C;
        if (presenter != null) {
            ((n) presenter).h();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        ViewStub viewStub = this.f46641c;
        boolean z11 = true;
        if (viewStub != null) {
            bundle.putBoolean("empty_state", viewStub.getParent() == null);
        }
        ViewStub viewStub2 = this.f46642d;
        if (viewStub2 != null) {
            if (viewStub2.getParent() != null) {
                z11 = false;
            }
            bundle.putBoolean("error_state", z11);
        }
    }

    public void u() {
        b bVar = this.H;
        if (bVar != null) {
            bVar.notifyDataSetChanged();
        }
    }

    public void v() {
        D();
    }

    public void x() {
        ViewStub viewStub = this.f46642d;
        if (viewStub == null) {
            return;
        }
        if (viewStub.getParent() != null) {
            this.f46642d.inflate().setOnClickListener(this);
        } else {
            this.f46642d.setVisibility(0);
        }
    }
}
