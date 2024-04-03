package com.instabug.library.core.plugin;

import android.net.Uri;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

public class PluginPromptOption implements Serializable {
    public static final int NO_ORDER = -1;
    @Nullable
    private String description;
    @DrawableRes
    private int icon;
    private int invocationMode;
    private boolean isInitialScreenshotRequired;
    private int notificationCount;
    @Nullable
    private OnInvocationListener onInvocationListener;
    private int order;
    @Nullable
    private PluginPromptOption parent;
    @PromptOptionIdentifier
    private int promptOptionIdentifier;
    @Nullable
    private ArrayList<PluginPromptOption> subOptions;
    @Nullable
    private String title;

    public interface OnInvocationListener {
        void onInvoke(@Nullable Uri uri, String... strArr);
    }

    public @interface PromptOptionIdentifier {
        public static final int ASK_QUESTION = 3;
        public static final int BUG_REPORT = 0;
        public static final int CHAT_LIST = 2;
        public static final int FEATURE_REQUEST = 5;
        public static final int FEEDBACK = 1;
    }

    public static class a implements Comparator, Serializable {
        /* renamed from: a */
        public int compare(PluginPromptOption pluginPromptOption, PluginPromptOption pluginPromptOption2) {
            return pluginPromptOption.getOrder() - pluginPromptOption2.getOrder();
        }
    }

    @Nullable
    public String getDescription() {
        return this.description;
    }

    @DrawableRes
    public int getIcon() {
        return this.icon;
    }

    public int getInvocationMode() {
        return this.invocationMode;
    }

    public int getNotificationCount() {
        return this.notificationCount;
    }

    public int getOrder() {
        return this.order;
    }

    @Nullable
    public PluginPromptOption getParent() {
        return this.parent;
    }

    @PromptOptionIdentifier
    public int getPromptOptionIdentifier() {
        return this.promptOptionIdentifier;
    }

    @Nullable
    public ArrayList<PluginPromptOption> getSubOptions() {
        return this.subOptions;
    }

    @Nullable
    public String getTitle() {
        return this.title;
    }

    public void invoke(@Nullable Uri uri, String... strArr) {
        OnInvocationListener onInvocationListener2 = this.onInvocationListener;
        if (onInvocationListener2 != null) {
            onInvocationListener2.onInvoke(uri, strArr);
        }
    }

    public boolean isInitialScreenshotRequired() {
        return this.isInitialScreenshotRequired;
    }

    public void setDescription(@Nullable String str) {
        this.description = str;
    }

    public void setIcon(@DrawableRes int i11) {
        this.icon = i11;
    }

    public void setInitialScreenshotRequired(boolean z11) {
        this.isInitialScreenshotRequired = z11;
    }

    public void setInvocationMode(int i11) {
        this.invocationMode = i11;
    }

    public void setNotificationCount(int i11) {
        if (i11 > 99) {
            this.notificationCount = 99;
        } else if (i11 < 0) {
            this.notificationCount = 0;
        } else {
            this.notificationCount = i11;
        }
    }

    public void setOnInvocationListener(@Nullable OnInvocationListener onInvocationListener2) {
        this.onInvocationListener = onInvocationListener2;
    }

    public void setOrder(int i11) {
        this.order = i11;
    }

    public void setParent(@Nullable PluginPromptOption pluginPromptOption) {
        if (pluginPromptOption != null) {
            this.parent = pluginPromptOption;
        }
    }

    public void setPromptOptionIdentifier(@PromptOptionIdentifier int i11) {
        this.promptOptionIdentifier = i11;
    }

    public void setSubOptions(@Nullable ArrayList<PluginPromptOption> arrayList) {
        this.subOptions = arrayList;
    }

    public void setTitle(@Nullable String str) {
        this.title = str;
    }

    public void invoke() {
        invoke((Uri) null, new String[0]);
    }
}
