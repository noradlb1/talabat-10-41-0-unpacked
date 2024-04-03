package com.appboy.ui.activities;

import android.os.Bundle;
import com.appboy.ui.R;
import com.braze.ui.activities.BrazeBaseFragmentActivity;

public class AppboyFeedActivity extends BrazeBaseFragmentActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.com_appboy_feed_activity);
    }
}
