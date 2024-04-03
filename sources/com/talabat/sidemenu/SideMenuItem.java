package com.talabat.sidemenu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.talabat.configuration.country.Country;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import datamodels.JMenuItem;

public class SideMenuItem {
    public static final int CAMPAIGN = -100;
    private Drawable drawable;
    private int icon_drawableId;
    private String imageUrl;
    private String ref;
    private String title;
    private String url;

    public int getDisplayName(String str, Country country) {
        return SideMenuResource.getStringResource(str, country);
    }

    public Drawable getDrawable() {
        return this.drawable;
    }

    public int getIconDrawableId(boolean z11) {
        return SideMenuResource.getIconResource(this.ref, z11);
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getLink() {
        return this.url;
    }

    public String getRef() {
        return this.ref;
    }

    public String getTitle() {
        return this.title;
    }

    public void setDrawable(Drawable drawable2) {
        this.drawable = drawable2;
    }

    public void setIconDrawableId(int i11) {
        this.icon_drawableId = i11;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public void setLink(String str) {
        this.url = str;
    }

    public void setRef(String str) {
        this.ref = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setValue(JMenuItem jMenuItem, Context context, Country country) {
        this.imageUrl = jMenuItem.icon;
        String str = jMenuItem.ref;
        this.ref = str;
        if (getDisplayName(str, country) > 0) {
            this.title = context.getString(getDisplayName(jMenuItem.ref, country));
        } else if (getDisplayName(jMenuItem.ref, country) == -100) {
            this.title = "Campaign";
        } else if (GlobalDataModel.SelectedLanguage.equals(GlobalConstants.ARABIC)) {
            this.title = jMenuItem.titleAr;
        } else {
            this.title = jMenuItem.title;
        }
    }
}
