package com.instabug.featuresrequest.ui.featuresmain;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.instabug.featuresrequest.R;
import com.instabug.featuresrequest.listeners.c;
import com.instabug.featuresrequest.settings.a;
import com.instabug.featuresrequest.ui.custom.d;
import com.instabug.featuresrequest.ui.custom.x;
import com.instabug.featuresrequest.ui.custom.y;
import com.instabug.featuresrequest.ui.featuresmain.mainallfeatures.b;
import com.instabug.featuresrequest.ui.newfeature.g;
import com.instabug.featuresrequest.utils.i;
import com.instabug.library.Instabug;
import com.instabug.library.InstabugColorTheme;
import com.instabug.library.InstabugCustomTextPlaceHolder;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.PlaceHolderUtils;
import java.util.ArrayList;
import java.util.Iterator;

@SuppressLint({"ERADICATE_FIELD_NOT_INITIALIZED"})
public class f extends d implements a, c {
    @Nullable
    public TabLayout I;
    public Boolean J = Boolean.FALSE;

    /* renamed from: e  reason: collision with root package name */
    private h f46784e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private LinearLayout f46785f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private ViewPager f46786g;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public Button f46787h;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public int f46788j = 1;

    /* renamed from: k  reason: collision with root package name */
    private ArrayList f46789k;

    /* renamed from: l  reason: collision with root package name */
    private b f46790l;

    /* renamed from: m  reason: collision with root package name */
    private com.instabug.featuresrequest.ui.featuresmain.mainmyfeatures.b f46791m;

    private void N() {
        int i11;
        TabLayout tabLayout = this.I;
        if (this.f46785f != null && tabLayout != null) {
            if (Instabug.getTheme() == InstabugColorTheme.InstabugColorThemeLight) {
                this.f46785f.setBackgroundColor(SettingsManager.getInstance().getPrimaryColor());
                i11 = SettingsManager.getInstance().getPrimaryColor();
            } else {
                LinearLayout linearLayout = this.f46785f;
                Resources resources = getResources();
                int i12 = R.color.ib_fr_toolbar_dark_color;
                linearLayout.setBackgroundColor(resources.getColor(i12));
                i11 = getResources().getColor(i12);
            }
            tabLayout.setBackgroundColor(i11);
            this.I = tabLayout;
        }
    }

    private void O() {
        int i11;
        Button button;
        if (getContext() != null) {
            LinearLayout linearLayout = (LinearLayout) i(R.id.sortingActionsLayoutRoot);
            ImageView imageView = (ImageView) i(R.id.imgSortActions);
            if (imageView != null) {
                imageView.setImageDrawable(AppCompatResources.getDrawable(getContext(), R.drawable.ibg_fr_ic_sort));
            }
            this.f46787h = (Button) i(R.id.btnSortActions);
            if (linearLayout != null) {
                linearLayout.setOnClickListener(this);
            }
            if (this.f46787h != null) {
                if (this.J.booleanValue()) {
                    button = this.f46787h;
                    i11 = R.string.sort_by_top_rated;
                } else {
                    button = this.f46787h;
                    i11 = R.string.sort_by_recently_updated;
                }
                button.setText(i.a(getLocalizedString(i11)));
            }
        }
    }

    private void P() {
        TabLayout tabLayout = (TabLayout) i(R.id.tab_layout);
        LinearLayout linearLayout = (LinearLayout) i(R.id.tabsContainer);
        ViewPager viewPager = (ViewPager) i(R.id.pager);
        if (tabLayout != null && linearLayout != null && viewPager != null) {
            tabLayout.addTab(tabLayout.newTab().setText((CharSequence) getLocalizedString(R.string.features_rq_main_fragment_tab1)));
            tabLayout.addTab(tabLayout.newTab().setText((CharSequence) getLocalizedString(R.string.features_rq_main_fragment_tab2)));
            tabLayout.setBackgroundColor(SettingsManager.getInstance().getPrimaryColor());
            tabLayout.setTabMode(0);
            linearLayout.setBackgroundColor(SettingsManager.getInstance().getPrimaryColor());
            viewPager.setAdapter(this.f46784e);
            viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
            tabLayout.addOnTabSelectedListener((TabLayout.BaseOnTabSelectedListener) new d(this, viewPager));
            this.I = tabLayout;
            this.f46785f = linearLayout;
            this.f46786g = viewPager;
        }
    }

    public void Q() {
        ViewPager viewPager = this.f46786g;
        if (viewPager != null) {
            viewPager.setCurrentItem(1);
        }
        ((b) this.f46784e.getItem(0)).onRefresh();
        ((com.instabug.featuresrequest.ui.featuresmain.mainmyfeatures.b) this.f46784e.getItem(1)).onRefresh();
    }

    public void a() {
        if (getActivity() != null) {
            getActivity().getSupportFragmentManager().beginTransaction().add(R.id.instabug_fragment_container, (Fragment) new g()).addToBackStack("search_features").commit();
        }
    }

    @TargetApi(11)
    public void a(View view) {
        if (getContext() != null) {
            PopupMenu popupMenu = new PopupMenu(Instabug.getTheme() == InstabugColorTheme.InstabugColorThemeLight ? new ContextThemeWrapper(getContext(), R.style.IbFrPopupMenuOverlapAnchorLight) : new ContextThemeWrapper(getContext(), R.style.IbFrPopupMenuOverlapAnchorDark), view, 5);
            popupMenu.getMenuInflater().inflate(R.menu.ib_fr_sorting_actions_pop_up, popupMenu.getMenu());
            popupMenu.getMenu().getItem(this.f46788j).setChecked(true);
            popupMenu.setOnMenuItemClickListener(new e(this));
            popupMenu.show();
        }
    }

    public Fragment c(int i11) {
        if (i11 != 1) {
            if (this.f46790l == null) {
                b c11 = b.c(this.J.booleanValue());
                this.f46790l = c11;
                this.f46789k.add(c11);
            }
            return this.f46790l;
        }
        if (this.f46791m == null) {
            com.instabug.featuresrequest.ui.featuresmain.mainmyfeatures.b c12 = com.instabug.featuresrequest.ui.featuresmain.mainmyfeatures.b.c(this.J.booleanValue());
            this.f46791m = c12;
            this.f46789k.add(c12);
        }
        return this.f46791m;
    }

    public void c(boolean z11) {
        Iterator it = this.f46789k.iterator();
        while (it.hasNext()) {
            ((com.instabug.featuresrequest.listeners.b) it.next()).a(Boolean.valueOf(z11));
        }
    }

    public void m() {
        finishActivity();
    }

    public int o0() {
        return R.layout.ib_fr_features_main_fragment;
    }

    @SuppressLint({"STARVATION"})
    public void onClick(View view) {
        if (view.getId() == R.id.sortingActionsLayoutRoot) {
            a(view);
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        boolean z11 = true;
        setRetainInstance(true);
        this.C = new g(this);
        this.f46789k = new ArrayList();
        int c11 = a.c();
        this.f46788j = c11;
        if (c11 != 0) {
            z11 = false;
        }
        this.J = Boolean.valueOf(z11);
    }

    public void onDestroy() {
        super.onDestroy();
        this.f46789k = null;
    }

    @Nullable
    public String p0() {
        return PlaceHolderUtils.getPlaceHolder(InstabugCustomTextPlaceHolder.Key.FEATURES_REQUEST, getLocalizedString(R.string.instabug_str_features_request_header));
    }

    public y q0() {
        return new y(R.drawable.ibg_core_ic_close, R.string.close, new b(this), x.ICON);
    }

    public void r0(View view, @Nullable Bundle bundle) {
        this.f46784e = new h(getChildFragmentManager(), this);
        P();
        O();
        N();
    }

    public void u() {
        this.H.add(new y(R.drawable.ibg_fr_ic_add_white_36dp, -1, new c(this), x.ICON));
    }
}
