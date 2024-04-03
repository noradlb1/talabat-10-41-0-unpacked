package com.github.droibit.flutter.plugins.customtabs;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import androidx.annotation.AnimRes;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.browser.customtabs.CustomTabsIntent;
import com.droibit.android.customtabs.launcher.CustomTabsFallback;
import com.droibit.android.customtabs.launcher.CustomTabsLauncher;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@RestrictTo({RestrictTo.Scope.LIBRARY})
class CustomTabsFactory {
    private static final String KEY_ANIMATION_END_ENTER = "endEnter";
    private static final String KEY_ANIMATION_END_EXIT = "endExit";
    private static final String KEY_ANIMATION_START_ENTER = "startEnter";
    private static final String KEY_ANIMATION_START_EXIT = "startExit";
    private static final String KEY_EXTRA_CUSTOM_TABS = "extraCustomTabs";
    private static final String KEY_HEADERS = "headers";
    private static final String KEY_OPTIONS_ANIMATIONS = "animations";
    private static final String KEY_OPTIONS_DEFAULT_SHARE_MENU_ITEM = "enableDefaultShare";
    private static final String KEY_OPTIONS_ENABLE_INSTANT_APPS = "enableInstantApps";
    private static final String KEY_OPTIONS_ENABLE_URL_BAR_HIDING = "enableUrlBarHiding";
    private static final String KEY_OPTIONS_SHOW_PAGE_TITLE = "showPageTitle";
    private static final String KEY_OPTIONS_TOOLBAR_COLOR = "toolbarColor";
    private static final Pattern animationIdentifierPattern = Pattern.compile("^.+:.+/");
    private final Context context;

    public CustomTabsFactory(@NonNull Context context2) {
        this.context = context2;
    }

    private void applyAnimations(@NonNull CustomTabsIntent.Builder builder, @NonNull Map<String, String> map) {
        int i11;
        int i12;
        int i13;
        int i14;
        if (map.containsKey(KEY_ANIMATION_START_ENTER)) {
            i11 = resolveAnimationIdentifierIfNeeded(map.get(KEY_ANIMATION_START_ENTER));
        } else {
            i11 = -1;
        }
        if (map.containsKey(KEY_ANIMATION_START_EXIT)) {
            i12 = resolveAnimationIdentifierIfNeeded(map.get(KEY_ANIMATION_START_EXIT));
        } else {
            i12 = -1;
        }
        if (map.containsKey(KEY_ANIMATION_END_ENTER)) {
            i13 = resolveAnimationIdentifierIfNeeded(map.get(KEY_ANIMATION_END_ENTER));
        } else {
            i13 = -1;
        }
        if (map.containsKey(KEY_ANIMATION_END_EXIT)) {
            i14 = resolveAnimationIdentifierIfNeeded(map.get(KEY_ANIMATION_END_EXIT));
        } else {
            i14 = -1;
        }
        if (!(i11 == -1 || i12 == -1)) {
            builder.setStartAnimations(this.context, i11, i12);
        }
        if (i13 != -1 && i14 != -1) {
            builder.setExitAnimations(this.context, i13, i14);
        }
    }

    private void onPostBuild(@NonNull Intent intent, @NonNull Map<String, Object> map) {
        if (map.containsKey("headers")) {
            Bundle bundle = new Bundle();
            for (Map.Entry entry : ((Map) map.get("headers")).entrySet()) {
                bundle.putString((String) entry.getKey(), (String) entry.getValue());
            }
            intent.putExtra("com.android.browser.headers", bundle);
        }
    }

    @AnimRes
    private int resolveAnimationIdentifierIfNeeded(@NonNull String str) {
        if (animationIdentifierPattern.matcher(str).find()) {
            return this.context.getResources().getIdentifier(str, (String) null, (String) null);
        }
        return this.context.getResources().getIdentifier(str, "anim", this.context.getPackageName());
    }

    @NonNull
    public CustomTabsFallback a(@NonNull Map<String, Object> map) {
        List list;
        if (map.containsKey(KEY_EXTRA_CUSTOM_TABS)) {
            list = (List) map.get(KEY_EXTRA_CUSTOM_TABS);
        } else {
            list = null;
        }
        if (list == null || list.isEmpty()) {
            return new CustomTabsLauncher.LaunchNonChromeCustomTabs(this.context);
        }
        return new CustomTabsLauncher.LaunchNonChromeCustomTabs((List<String>) list);
    }

    @NonNull
    public CustomTabsIntent b(@NonNull Map<String, Object> map) {
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        if (map.containsKey(KEY_OPTIONS_TOOLBAR_COLOR)) {
            builder.setToolbarColor(Color.parseColor((String) map.get(KEY_OPTIONS_TOOLBAR_COLOR)));
        }
        if (map.containsKey(KEY_OPTIONS_ENABLE_URL_BAR_HIDING) && ((Boolean) map.get(KEY_OPTIONS_ENABLE_URL_BAR_HIDING)).booleanValue()) {
            builder.enableUrlBarHiding();
        }
        if (map.containsKey(KEY_OPTIONS_DEFAULT_SHARE_MENU_ITEM) && ((Boolean) map.get(KEY_OPTIONS_DEFAULT_SHARE_MENU_ITEM)).booleanValue()) {
            builder.addDefaultShareMenuItem();
        }
        if (map.containsKey(KEY_OPTIONS_SHOW_PAGE_TITLE)) {
            builder.setShowTitle(((Boolean) map.get(KEY_OPTIONS_SHOW_PAGE_TITLE)).booleanValue());
        }
        if (map.containsKey(KEY_OPTIONS_ENABLE_INSTANT_APPS)) {
            builder.setInstantAppsEnabled(((Boolean) map.get(KEY_OPTIONS_ENABLE_INSTANT_APPS)).booleanValue());
        }
        if (map.containsKey(KEY_OPTIONS_ANIMATIONS)) {
            applyAnimations(builder, (Map) map.get(KEY_OPTIONS_ANIMATIONS));
        }
        CustomTabsIntent build = builder.build();
        onPostBuild(build.intent, map);
        return build;
    }
}
