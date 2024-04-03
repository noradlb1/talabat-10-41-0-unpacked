package com.instabug.featuresrequest.ui.featuredetails;

import com.instabug.featuresrequest.models.d;

class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d f46741b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ c f46742c;

    public b(c cVar, d dVar) {
        this.f46742c = cVar;
        this.f46741b = dVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x015a  */
    /* JADX WARNING: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r7 = this;
            com.instabug.featuresrequest.ui.featuredetails.c r0 = r7.f46742c
            boolean r0 = r0.isAdded()
            if (r0 == 0) goto L_0x0163
            com.instabug.featuresrequest.ui.featuredetails.c r0 = r7.f46742c
            boolean r0 = r0.isRemoving()
            if (r0 != 0) goto L_0x0163
            com.instabug.featuresrequest.ui.featuredetails.c r0 = r7.f46742c
            android.content.Context r0 = r0.getContext()
            if (r0 == 0) goto L_0x0163
            com.instabug.featuresrequest.ui.featuredetails.c r0 = r7.f46742c
            android.widget.LinearLayout r0 = r0.f46743d
            if (r0 == 0) goto L_0x0163
            com.instabug.featuresrequest.ui.featuredetails.c r0 = r7.f46742c
            android.widget.TextView r0 = r0.f46745f
            com.instabug.featuresrequest.ui.featuredetails.c r1 = r7.f46742c
            android.widget.ImageView r1 = r1.f46751l
            if (r1 == 0) goto L_0x0163
            if (r0 == 0) goto L_0x0163
            com.instabug.featuresrequest.ui.featuredetails.c r1 = r7.f46742c
            android.widget.ImageView r1 = r1.f46751l
            int r2 = com.instabug.featuresrequest.R.drawable.ibg_fr_ic_vote_arrow_white
            r1.setImageResource(r2)
            com.instabug.featuresrequest.ui.featuredetails.c r1 = r7.f46742c
            android.widget.LinearLayout r1 = r1.f46743d
            android.graphics.drawable.Drawable r1 = r1.getBackground()
            android.graphics.drawable.GradientDrawable r1 = (android.graphics.drawable.GradientDrawable) r1
            com.instabug.featuresrequest.ui.featuredetails.c r2 = r7.f46742c
            int r3 = com.instabug.featuresrequest.R.string.feature_request_votes_count
            r4 = 1
            java.lang.Object[] r4 = new java.lang.Object[r4]
            com.instabug.featuresrequest.models.d r5 = r7.f46741b
            int r5 = r5.i()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r6 = 0
            r4[r6] = r5
            java.lang.String r2 = r2.getLocalizedString(r3, r4)
            r0.setText(r2)
            com.instabug.library.InstabugColorTheme r2 = com.instabug.library.Instabug.getTheme()
            com.instabug.library.InstabugColorTheme r3 = com.instabug.library.InstabugColorTheme.InstabugColorThemeLight
            r4 = 17170445(0x106000d, float:2.461195E-38)
            r5 = 1073741824(0x40000000, float:2.0)
            r6 = 17170443(0x106000b, float:2.4611944E-38)
            if (r2 != r3) goto L_0x00c1
            com.instabug.featuresrequest.models.d r2 = r7.f46741b
            boolean r2 = r2.p()
            if (r2 == 0) goto L_0x009d
            com.instabug.featuresrequest.ui.featuredetails.c r2 = r7.f46742c
            android.content.Context r2 = r2.getContext()
            int r2 = com.instabug.library.view.ViewUtils.convertDpToPx(r2, r5)
            com.instabug.featuresrequest.ui.featuredetails.c r3 = r7.f46742c
            android.content.Context r3 = r3.getContext()
            int r3 = androidx.core.content.ContextCompat.getColor(r3, r6)
            r1.setStroke(r2, r3)
            com.instabug.featuresrequest.ui.featuredetails.c r2 = r7.f46742c
            android.content.Context r2 = r2.getContext()
            int r2 = androidx.core.content.ContextCompat.getColor(r2, r6)
            goto L_0x012a
        L_0x009d:
            com.instabug.featuresrequest.ui.featuredetails.c r2 = r7.f46742c
            android.content.Context r2 = r2.getContext()
            int r2 = com.instabug.library.view.ViewUtils.convertDpToPx(r2, r5)
            com.instabug.featuresrequest.ui.featuredetails.c r3 = r7.f46742c
            android.content.Context r3 = r3.getContext()
            int r5 = com.instabug.featuresrequest.R.color.ib_fr_toolbar_vote_btn_stroke_color
            int r3 = androidx.core.content.ContextCompat.getColor(r3, r5)
            r1.setStroke(r2, r3)
            com.instabug.featuresrequest.ui.featuredetails.c r2 = r7.f46742c
            android.content.Context r2 = r2.getContext()
            int r2 = androidx.core.content.ContextCompat.getColor(r2, r4)
            goto L_0x00e6
        L_0x00c1:
            com.instabug.featuresrequest.models.d r2 = r7.f46741b
            boolean r2 = r2.p()
            if (r2 == 0) goto L_0x010b
            com.instabug.featuresrequest.ui.featuredetails.c r2 = r7.f46742c
            android.content.Context r2 = r2.getContext()
            int r2 = com.instabug.library.view.ViewUtils.convertDpToPx(r2, r5)
            com.instabug.library.settings.SettingsManager r3 = com.instabug.library.settings.SettingsManager.getInstance()
            int r3 = r3.getPrimaryColor()
            r1.setStroke(r2, r3)
            com.instabug.library.settings.SettingsManager r2 = com.instabug.library.settings.SettingsManager.getInstance()
            int r2 = r2.getPrimaryColor()
        L_0x00e6:
            r1.setColor(r2)
            com.instabug.featuresrequest.ui.featuredetails.c r2 = r7.f46742c
            android.content.Context r2 = r2.getContext()
            int r2 = androidx.core.content.ContextCompat.getColor(r2, r6)
            r0.setTextColor(r2)
            com.instabug.featuresrequest.ui.featuredetails.c r2 = r7.f46742c
            android.widget.ImageView r2 = r2.f46751l
            android.graphics.drawable.Drawable r2 = r2.getDrawable()
            com.instabug.featuresrequest.ui.featuredetails.c r3 = r7.f46742c
            android.content.Context r3 = r3.getContext()
            int r3 = androidx.core.content.ContextCompat.getColor(r3, r6)
            goto L_0x014a
        L_0x010b:
            com.instabug.featuresrequest.ui.featuredetails.c r2 = r7.f46742c
            android.content.Context r2 = r2.getContext()
            int r2 = com.instabug.library.view.ViewUtils.convertDpToPx(r2, r5)
            com.instabug.library.settings.SettingsManager r3 = com.instabug.library.settings.SettingsManager.getInstance()
            int r3 = r3.getPrimaryColor()
            r1.setStroke(r2, r3)
            com.instabug.featuresrequest.ui.featuredetails.c r2 = r7.f46742c
            android.content.Context r2 = r2.getContext()
            int r2 = androidx.core.content.ContextCompat.getColor(r2, r4)
        L_0x012a:
            r1.setColor(r2)
            com.instabug.library.settings.SettingsManager r2 = com.instabug.library.settings.SettingsManager.getInstance()
            int r2 = r2.getPrimaryColor()
            r0.setTextColor(r2)
            com.instabug.featuresrequest.ui.featuredetails.c r2 = r7.f46742c
            android.widget.ImageView r2 = r2.f46751l
            android.graphics.drawable.Drawable r2 = r2.getDrawable()
            com.instabug.library.settings.SettingsManager r3 = com.instabug.library.settings.SettingsManager.getInstance()
            int r3 = r3.getPrimaryColor()
        L_0x014a:
            androidx.core.graphics.drawable.DrawableCompat.setTint(r2, r3)
            com.instabug.featuresrequest.ui.featuredetails.c r2 = r7.f46742c
            android.widget.TextView unused = r2.f46745f = r0
            com.instabug.featuresrequest.ui.featuredetails.c r0 = r7.f46742c
            android.widget.LinearLayout r0 = r0.f46743d
            if (r0 == 0) goto L_0x0163
            com.instabug.featuresrequest.ui.featuredetails.c r0 = r7.f46742c
            android.widget.LinearLayout r0 = r0.f46743d
            r0.setBackground(r1)
        L_0x0163:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.featuresrequest.ui.featuredetails.b.run():void");
    }
}
