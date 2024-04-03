package com.instabug.library.bugreporting.model;

import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;

public class ReportCategory {
    private int icon;
    @Nullable
    private String label;

    private ReportCategory() {
    }

    public static ReportCategory getInstance() {
        return new ReportCategory();
    }

    public int getIcon() {
        return this.icon;
    }

    @Nullable
    public String getLabel() {
        return this.label;
    }

    public void setIcon(@DrawableRes int i11) {
        this.icon = i11;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public ReportCategory withIcon(@DrawableRes int i11) {
        this.icon = i11;
        return this;
    }

    public ReportCategory withLabel(@Nullable String str) {
        this.label = str;
        return this;
    }
}
