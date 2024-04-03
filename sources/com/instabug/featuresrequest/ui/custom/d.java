package com.instabug.featuresrequest.ui.custom;

import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import com.instabug.featuresrequest.R;
import com.instabug.library.core.ui.InstabugBaseFragment;
import java.util.ArrayList;

public abstract class d extends InstabugBaseFragment implements View.OnClickListener {
    @Nullable
    public RelativeLayout G;
    public ArrayList H = new ArrayList();
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private LinearLayout f46702c;

    @Nullable
    public View a(View view, String str) {
        ArrayList arrayList = new ArrayList();
        view.findViewsWithText(arrayList, str, 2);
        if (arrayList.size() > 0) {
            return (View) arrayList.get(0);
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: android.widget.ImageView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: android.widget.TextView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v19, resolved type: android.widget.ImageView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v20, resolved type: android.widget.ImageView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v21, resolved type: android.widget.LinearLayout} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(@androidx.annotation.Nullable android.os.Bundle r6) {
        /*
            r5 = this;
            android.content.Context r6 = r5.getContext()
            if (r6 != 0) goto L_0x0007
            return
        L_0x0007:
            int r6 = com.instabug.featuresrequest.R.id.ib_fr_toolbar_main
            android.view.View r6 = r5.i(r6)
            android.widget.RelativeLayout r6 = (android.widget.RelativeLayout) r6
            if (r6 == 0) goto L_0x0035
            com.instabug.library.InstabugColorTheme r0 = com.instabug.library.Instabug.getTheme()
            com.instabug.library.InstabugColorTheme r1 = com.instabug.library.InstabugColorTheme.InstabugColorThemeLight
            if (r0 != r1) goto L_0x001e
            int r0 = com.instabug.library.core.InstabugCore.getPrimaryColor()
            goto L_0x0028
        L_0x001e:
            android.content.Context r0 = r5.getContext()
            int r1 = com.instabug.featuresrequest.R.color.ib_fr_toolbar_dark_color
            int r0 = androidx.core.content.ContextCompat.getColor(r0, r1)
        L_0x0028:
            r6.setBackgroundColor(r0)
            int r0 = com.instabug.featuresrequest.R.id.ib_toolbar_action_btns_layout
            android.view.View r0 = r6.findViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            r5.f46702c = r0
        L_0x0035:
            r5.G = r6
            int r6 = com.instabug.featuresrequest.R.id.instabug_btn_toolbar_left
            android.view.View r6 = r5.i(r6)
            android.widget.ImageButton r6 = (android.widget.ImageButton) r6
            if (r6 == 0) goto L_0x0063
            android.content.Context r0 = r5.getContext()
            boolean r0 = com.instabug.library.util.LocaleHelper.isRTL((android.content.Context) r0)
            if (r0 == 0) goto L_0x0050
            r0 = 1127481344(0x43340000, float:180.0)
            r6.setRotation(r0)
        L_0x0050:
            com.instabug.featuresrequest.ui.custom.y r0 = r5.q0()
            int r1 = r0.a()
            r6.setImageResource(r1)
            nc.a r1 = new nc.a
            r1.<init>(r0)
            r6.setOnClickListener(r1)
        L_0x0063:
            java.util.ArrayList r6 = r5.H
            r6.clear()
            r5.u()
            java.util.ArrayList r6 = r5.H
            java.util.Iterator r6 = r6.iterator()
        L_0x0071:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L_0x012b
            java.lang.Object r0 = r6.next()
            com.instabug.featuresrequest.ui.custom.y r0 = (com.instabug.featuresrequest.ui.custom.y) r0
            int[] r1 = com.instabug.featuresrequest.ui.custom.c.f46701a
            com.instabug.featuresrequest.ui.custom.x r2 = r0.d()
            int r2 = r2.ordinal()
            r1 = r1[r2]
            r2 = 1
            r3 = 0
            if (r1 == r2) goto L_0x0103
            r2 = 2
            if (r1 == r2) goto L_0x00cc
            r2 = 3
            if (r1 == r2) goto L_0x0094
            goto L_0x0071
        L_0x0094:
            android.content.Context r1 = r5.getContext()
            android.view.LayoutInflater r1 = android.view.LayoutInflater.from(r1)
            int r2 = com.instabug.featuresrequest.R.layout.ib_fr_toolbar_action_vote_button
            android.view.View r1 = r1.inflate(r2, r3)
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
            int r2 = com.instabug.featuresrequest.R.id.ib_toolbar_vote_count
            android.view.View r2 = r1.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            int r3 = com.instabug.featuresrequest.R.id.ib_feature_request_toolbar_vote_action_layout
            android.view.View r3 = r1.findViewById(r3)
            com.instabug.featuresrequest.ui.custom.IbFrRippleView r3 = (com.instabug.featuresrequest.ui.custom.IbFrRippleView) r3
            if (r2 == 0) goto L_0x00bd
            int r4 = r0.c()
            r2.setText(r4)
        L_0x00bd:
            if (r3 == 0) goto L_0x00c7
            nc.b r2 = new nc.b
            r2.<init>(r0)
            r3.setOnClickListener(r2)
        L_0x00c7:
            android.widget.LinearLayout r0 = r5.f46702c
            if (r0 == 0) goto L_0x0071
            goto L_0x0126
        L_0x00cc:
            android.content.Context r1 = r5.getContext()
            android.view.LayoutInflater r1 = android.view.LayoutInflater.from(r1)
            int r2 = com.instabug.featuresrequest.R.layout.ib_fr_toolbar_action_text_view
            android.view.View r1 = r1.inflate(r2, r3)
            android.widget.TextView r1 = (android.widget.TextView) r1
            int r2 = r0.c()
            r1.setText(r2)
            android.content.Context r2 = r5.getContext()
            android.content.res.Resources r2 = r2.getResources()
            int r3 = r0.c()
            java.lang.CharSequence r2 = r2.getText(r3)
            r1.setContentDescription(r2)
            nc.c r2 = new nc.c
            r2.<init>(r0)
            r1.setOnClickListener(r2)
            android.widget.LinearLayout r0 = r5.f46702c
            if (r0 == 0) goto L_0x0071
            goto L_0x0126
        L_0x0103:
            android.content.Context r1 = r5.getContext()
            android.view.LayoutInflater r1 = android.view.LayoutInflater.from(r1)
            int r2 = com.instabug.featuresrequest.R.layout.ib_fr_toolbar_action_icon_view
            android.view.View r1 = r1.inflate(r2, r3)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            int r2 = r0.a()
            r1.setImageResource(r2)
            nc.d r2 = new nc.d
            r2.<init>(r0)
            r1.setOnClickListener(r2)
            android.widget.LinearLayout r0 = r5.f46702c
            if (r0 == 0) goto L_0x0071
        L_0x0126:
            r0.addView(r1)
            goto L_0x0071
        L_0x012b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.featuresrequest.ui.custom.d.a(android.os.Bundle):void");
    }

    public void c(@Nullable String str) {
        TextView textView;
        if (this.F != null && (textView = (TextView) i(R.id.instabug_fragment_title)) != null && str != null) {
            textView.setText(str);
        }
    }

    @Nullable
    public View d(@StringRes int i11) {
        String string = getContext() != null ? getContext().getResources().getString(i11) : "";
        LinearLayout linearLayout = this.f46702c;
        if (linearLayout != null) {
            return a((View) linearLayout, string);
        }
        return null;
    }

    public int i0() {
        return R.layout.ib_fr_toolbar_fragment;
    }

    @CallSuper
    public void j0(View view, @Nullable Bundle bundle) {
        a(bundle);
        ViewStub viewStub = (ViewStub) i(R.id.instabug_content);
        if (viewStub != null) {
            viewStub.setLayoutResource(o0());
            viewStub.inflate();
        }
        r0(view, bundle);
        c(p0());
    }

    @LayoutRes
    public abstract int o0();

    @Nullable
    public abstract String p0();

    public abstract y q0();

    public abstract void r0(View view, @Nullable Bundle bundle);

    public abstract void u();
}
