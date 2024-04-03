package com.talabat.sidemenu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.annotation.AnyRes;
import androidx.annotation.VisibleForTesting;
import com.talabat.configuration.country.Country;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import datamodels.JMenuSection;
import java.util.ArrayList;

public class SideMenuHeader {
    private Drawable drawable;
    @AnyRes
    private int icon_drawableId;
    private String imageUrl;
    private String link;
    private String ref;
    public ArrayList<SideMenuItem> subItems;
    private String title;

    public Drawable getDrawable() {
        return this.drawable;
    }

    public int getIconDrawableId(boolean z11) {
        int iconResource = SideMenuResource.getIconResource(this.ref, z11);
        this.icon_drawableId = iconResource;
        return iconResource;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getLink() {
        return this.link;
    }

    public String getRef() {
        return this.ref;
    }

    public String getTitle() {
        return this.title;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public void setLink(String str) {
        this.link = str;
    }

    @VisibleForTesting
    public void setRef(String str) {
        this.ref = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setValue(JMenuSection jMenuSection, Context context, Country country) {
        this.imageUrl = jMenuSection.icon;
        String str = jMenuSection.ref;
        this.ref = str;
        if (SideMenuResource.getStringResource(str, country) > 0) {
            this.title = context.getString(SideMenuResource.getStringResource(jMenuSection.ref, country));
        } else if (SideMenuResource.getStringResource(jMenuSection.ref, country) == -100) {
            this.title = "Campaign";
        } else if (GlobalDataModel.SelectedLanguage.equals(GlobalConstants.ARABIC)) {
            this.title = jMenuSection.nameAr;
            this.link = jMenuSection.urlAr;
        } else {
            this.title = jMenuSection.f13860name;
            this.link = jMenuSection.url;
        }
    }
}
