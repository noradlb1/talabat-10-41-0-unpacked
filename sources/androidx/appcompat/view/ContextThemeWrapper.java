package androidx.appcompat.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.StyleRes;
import androidx.appcompat.R;

public class ContextThemeWrapper extends ContextWrapper {
    private static Configuration sEmptyConfig;
    private LayoutInflater mInflater;
    private Configuration mOverrideConfiguration;
    private Resources mResources;
    private Resources.Theme mTheme;
    private int mThemeResource;

    @RequiresApi(17)
    public static class Api17Impl {
        private Api17Impl() {
        }

        @DoNotInline
        public static Context a(ContextThemeWrapper contextThemeWrapper, Configuration configuration) {
            return contextThemeWrapper.createConfigurationContext(configuration);
        }
    }

    public ContextThemeWrapper() {
        super((Context) null);
    }

    private Resources getResourcesInternal() {
        if (this.mResources == null) {
            Configuration configuration = this.mOverrideConfiguration;
            if (configuration == null || (Build.VERSION.SDK_INT >= 26 && isEmptyConfiguration(configuration))) {
                this.mResources = super.getResources();
            } else {
                this.mResources = Api17Impl.a(this, this.mOverrideConfiguration).getResources();
            }
        }
        return this.mResources;
    }

    private void initializeTheme() {
        boolean z11;
        if (this.mTheme == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            this.mTheme = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.mTheme.setTo(theme);
            }
        }
        a(this.mTheme, this.mThemeResource, z11);
    }

    @RequiresApi(26)
    private static boolean isEmptyConfiguration(Configuration configuration) {
        if (configuration == null) {
            return true;
        }
        if (sEmptyConfig == null) {
            Configuration configuration2 = new Configuration();
            configuration2.fontScale = 0.0f;
            sEmptyConfig = configuration2;
        }
        return configuration.equals(sEmptyConfig);
    }

    public void a(Resources.Theme theme, int i11, boolean z11) {
        theme.applyStyle(i11, true);
    }

    public void applyOverrideConfiguration(Configuration configuration) {
        if (this.mResources != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        } else if (this.mOverrideConfiguration == null) {
            this.mOverrideConfiguration = new Configuration(configuration);
        } else {
            throw new IllegalStateException("Override configuration has already been set");
        }
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    public Resources getResources() {
        return getResourcesInternal();
    }

    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.mInflater == null) {
            this.mInflater = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.mInflater;
    }

    public Resources.Theme getTheme() {
        Resources.Theme theme = this.mTheme;
        if (theme != null) {
            return theme;
        }
        if (this.mThemeResource == 0) {
            this.mThemeResource = R.style.Theme_AppCompat_Light;
        }
        initializeTheme();
        return this.mTheme;
    }

    public int getThemeResId() {
        return this.mThemeResource;
    }

    public void setTheme(int i11) {
        if (this.mThemeResource != i11) {
            this.mThemeResource = i11;
            initializeTheme();
        }
    }

    public ContextThemeWrapper(Context context, @StyleRes int i11) {
        super(context);
        this.mThemeResource = i11;
    }

    public ContextThemeWrapper(Context context, Resources.Theme theme) {
        super(context);
        this.mTheme = theme;
    }
}
