package com.instabug.library.invocation.invocationdialog;

import android.annotation.SuppressLint;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import com.instabug.library.core.plugin.PluginPromptOption;
import java.io.Serializable;
import java.util.ArrayList;

public class InstabugDialogItem implements Serializable {
    private int badgeCount;
    @Nullable
    private String description;
    private int identifier;
    private boolean isInitialScreenshotRequired;
    private int order;
    @Nullable
    private InstabugDialogItem parent;
    @DrawableRes
    private int resDrawable;
    @Nullable
    private ArrayList<InstabugDialogItem> subItems;
    @Nullable
    private String title;

    public InstabugDialogItem() {
    }

    @SuppressLint({"ERADICATE_INCONSISTENT_SUBCLASS_PARAMETER_ANNOTATION"})
    public boolean equals(Object obj) {
        if (!(obj instanceof InstabugDialogItem)) {
            return super.equals(obj);
        }
        if (this.identifier == ((InstabugDialogItem) obj).identifier) {
            return true;
        }
        return false;
    }

    public int getBadgeCount() {
        return this.badgeCount;
    }

    @Nullable
    public String getDescription() {
        return this.description;
    }

    @PluginPromptOption.PromptOptionIdentifier
    public int getIdentifier() {
        return this.identifier;
    }

    public int getOrder() {
        return this.order;
    }

    @Nullable
    public InstabugDialogItem getParent() {
        return this.parent;
    }

    public int getResDrawable() {
        return this.resDrawable;
    }

    @Nullable
    public ArrayList<InstabugDialogItem> getSubItems() {
        return this.subItems;
    }

    @Nullable
    public String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int i11 = ((((((((this.badgeCount + 403) * 31) + this.resDrawable) * 31) + (this.isInitialScreenshotRequired ? 1 : 0)) * 31) + this.order) * 31) + this.identifier;
        String str = this.title;
        if (str != null) {
            i11 = (i11 * 31) + str.hashCode();
        }
        String str2 = this.description;
        if (str2 != null) {
            return (i11 * 31) + str2.hashCode();
        }
        return i11;
    }

    public boolean isInitialScreenshotRequired() {
        return this.isInitialScreenshotRequired;
    }

    public void setBadge(int i11) {
        this.badgeCount = i11;
    }

    public void setDescription(@Nullable String str) {
        this.description = str;
    }

    public void setIdentifier(@PluginPromptOption.PromptOptionIdentifier int i11) {
        this.identifier = i11;
    }

    public void setInitialScreenshotRequired(boolean z11) {
        this.isInitialScreenshotRequired = z11;
    }

    public void setOrder(int i11) {
        this.order = i11;
    }

    public void setParent(@Nullable InstabugDialogItem instabugDialogItem) {
        if (instabugDialogItem != null) {
            this.parent = instabugDialogItem;
        }
    }

    public void setResDrawable(int i11) {
        this.resDrawable = i11;
    }

    public void setSubItems(@Nullable ArrayList<InstabugDialogItem> arrayList) {
        this.subItems = arrayList;
    }

    public void setTitle(@Nullable String str) {
        this.title = str;
    }

    public InstabugDialogItem(@Nullable String str, int i11, int i12, boolean z11) {
        this.title = str;
        this.badgeCount = i11;
        this.resDrawable = i12;
        this.isInitialScreenshotRequired = z11;
    }
}
