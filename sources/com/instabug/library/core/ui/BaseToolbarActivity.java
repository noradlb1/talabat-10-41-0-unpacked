package com.instabug.library.core.ui;

import android.annotation.SuppressLint;
import android.view.ViewStub;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import com.instabug.library.R;
import com.instabug.library.settings.SettingsManager;

@SuppressLint({"UUF_UNUSED_PUBLIC_OR_PROTECTED_FIELD"})
public abstract class BaseToolbarActivity extends BaseFragmentActivity {
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    public Toolbar f34201j;

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.instabug_toolbar);
        this.f34201j = toolbar;
        if (toolbar != null) {
            toolbar.setBackgroundColor(SettingsManager.getInstance().getPrimaryColor());
            setSupportActionBar(toolbar);
            if (getSupportActionBar() != null) {
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            }
            toolbar.setNavigationIcon(R.drawable.ibg_core_ic_close);
        }
    }

    public abstract int N();

    public abstract void O();

    public int getLayout() {
        return R.layout.instabug_toolbar_activity;
    }

    public void initViews() {
        initToolbar();
        ViewStub viewStub = (ViewStub) findViewById(R.id.instabug_content);
        viewStub.setLayoutResource(N());
        viewStub.inflate();
        O();
    }
}
