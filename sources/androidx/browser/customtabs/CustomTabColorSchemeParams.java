package androidx.browser.customtabs;

import android.os.Bundle;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;

public final class CustomTabColorSchemeParams {
    @ColorInt
    @Nullable
    public final Integer navigationBarColor;
    @ColorInt
    @Nullable
    public final Integer navigationBarDividerColor;
    @ColorInt
    @Nullable
    public final Integer secondaryToolbarColor;
    @ColorInt
    @Nullable
    public final Integer toolbarColor;

    public static final class Builder {
        @ColorInt
        @Nullable
        private Integer mNavigationBarColor;
        @ColorInt
        @Nullable
        private Integer mNavigationBarDividerColor;
        @ColorInt
        @Nullable
        private Integer mSecondaryToolbarColor;
        @ColorInt
        @Nullable
        private Integer mToolbarColor;

        @NonNull
        public CustomTabColorSchemeParams build() {
            return new CustomTabColorSchemeParams(this.mToolbarColor, this.mSecondaryToolbarColor, this.mNavigationBarColor, this.mNavigationBarDividerColor);
        }

        @NonNull
        public Builder setNavigationBarColor(@ColorInt int i11) {
            this.mNavigationBarColor = Integer.valueOf(i11 | ViewCompat.MEASURED_STATE_MASK);
            return this;
        }

        @NonNull
        public Builder setNavigationBarDividerColor(@ColorInt int i11) {
            this.mNavigationBarDividerColor = Integer.valueOf(i11);
            return this;
        }

        @NonNull
        public Builder setSecondaryToolbarColor(@ColorInt int i11) {
            this.mSecondaryToolbarColor = Integer.valueOf(i11);
            return this;
        }

        @NonNull
        public Builder setToolbarColor(@ColorInt int i11) {
            this.mToolbarColor = Integer.valueOf(i11 | ViewCompat.MEASURED_STATE_MASK);
            return this;
        }
    }

    public CustomTabColorSchemeParams(@ColorInt @Nullable Integer num, @ColorInt @Nullable Integer num2, @ColorInt @Nullable Integer num3, @ColorInt @Nullable Integer num4) {
        this.toolbarColor = num;
        this.secondaryToolbarColor = num2;
        this.navigationBarColor = num3;
        this.navigationBarDividerColor = num4;
    }

    @NonNull
    public static CustomTabColorSchemeParams a(@Nullable Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle(0);
        }
        return new CustomTabColorSchemeParams((Integer) bundle.get(CustomTabsIntent.EXTRA_TOOLBAR_COLOR), (Integer) bundle.get(CustomTabsIntent.EXTRA_SECONDARY_TOOLBAR_COLOR), (Integer) bundle.get(CustomTabsIntent.EXTRA_NAVIGATION_BAR_COLOR), (Integer) bundle.get(CustomTabsIntent.EXTRA_NAVIGATION_BAR_DIVIDER_COLOR));
    }

    @NonNull
    public Bundle b() {
        Bundle bundle = new Bundle();
        Integer num = this.toolbarColor;
        if (num != null) {
            bundle.putInt(CustomTabsIntent.EXTRA_TOOLBAR_COLOR, num.intValue());
        }
        Integer num2 = this.secondaryToolbarColor;
        if (num2 != null) {
            bundle.putInt(CustomTabsIntent.EXTRA_SECONDARY_TOOLBAR_COLOR, num2.intValue());
        }
        Integer num3 = this.navigationBarColor;
        if (num3 != null) {
            bundle.putInt(CustomTabsIntent.EXTRA_NAVIGATION_BAR_COLOR, num3.intValue());
        }
        Integer num4 = this.navigationBarDividerColor;
        if (num4 != null) {
            bundle.putInt(CustomTabsIntent.EXTRA_NAVIGATION_BAR_DIVIDER_COLOR, num4.intValue());
        }
        return bundle;
    }

    @NonNull
    public CustomTabColorSchemeParams c(@NonNull CustomTabColorSchemeParams customTabColorSchemeParams) {
        Integer num = this.toolbarColor;
        if (num == null) {
            num = customTabColorSchemeParams.toolbarColor;
        }
        Integer num2 = this.secondaryToolbarColor;
        if (num2 == null) {
            num2 = customTabColorSchemeParams.secondaryToolbarColor;
        }
        Integer num3 = this.navigationBarColor;
        if (num3 == null) {
            num3 = customTabColorSchemeParams.navigationBarColor;
        }
        Integer num4 = this.navigationBarDividerColor;
        if (num4 == null) {
            num4 = customTabColorSchemeParams.navigationBarDividerColor;
        }
        return new CustomTabColorSchemeParams(num, num2, num3, num4);
    }
}
