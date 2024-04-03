package com.instabug.survey.announcements.ui.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.instabug.library.core.ui.InstabugBaseFragment;
import com.instabug.survey.announcements.models.c;
import com.instabug.survey.announcements.ui.activity.AnnouncementActivity;
import com.instabug.survey.ui.gestures.e;

public abstract class a extends InstabugBaseFragment {
    @Nullable
    public c G;
    @Nullable
    public RelativeLayout H;
    @Nullable
    public com.instabug.survey.announcements.models.a I;

    public void j0(View view, @Nullable Bundle bundle) {
        if (getActivity() instanceof AnnouncementActivity) {
            ((AnnouncementActivity) getActivity()).d(false);
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        if (getActivity() instanceof AnnouncementActivity) {
            this.I = ((AnnouncementActivity) getActivity()).e();
        }
        super.onCreate(bundle);
    }

    public void onDestroy() {
        this.H = null;
        e.a();
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
        e.b();
    }
}
