package com.adyen.checkout.ui.internal.common.activity;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;

public abstract class CheckoutDetailsActivity extends CheckoutSessionActivity {
    public void onPostCreate(@Nullable Bundle bundle) {
        super.onPostCreate(bundle);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    public boolean onSupportNavigateUp() {
        super.onSupportNavigateUp();
        onBackPressed();
        return true;
    }
}
