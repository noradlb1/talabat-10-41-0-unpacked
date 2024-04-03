package com.instabug.survey.announcements.ui.activity;

import androidx.fragment.app.FragmentActivity;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.ui.BasePresenter;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.TimeUtils;
import com.instabug.survey.announcements.cache.e;
import com.instabug.survey.announcements.models.a;
import com.instabug.survey.announcements.settings.b;
import com.instabug.survey.callbacks.OnFinishCallback;
import com.instabug.survey.models.State;
import com.instabug.survey.settings.c;
import com.instabug.survey.ui.n;
import org.json.JSONException;

public class f extends BasePresenter {
    public f(c cVar) {
        super(cVar);
    }

    private void a(a aVar, String str) {
        OnFinishCallback h11 = c.h();
        if (h11 != null) {
            try {
                h11.onFinish(Long.toString(aVar.i()), State.SUBMITTED, com.instabug.survey.announcements.network.a.a(aVar, str));
            } catch (JSONException e11) {
                InstabugSDKLogger.e("IBG-Surveys", "Something went wrong during parsing Announcement object in onFinishCallback", e11);
            }
        }
    }

    private void b(a aVar) {
        e.b(aVar);
        if (b.b() != null) {
            b.b().b(TimeUtils.currentTimeMillis());
        }
        c cVar = (c) this.f34200f.get();
        if (cVar != null && cVar.getViewContext() != null) {
            InstabugCore.doOnBackground(new e(this, aVar, cVar));
        }
    }

    public void a(a aVar) {
        if (aVar != null) {
            aVar.x();
            a(aVar, State.DISMISSED);
            b(aVar);
        }
    }

    public void a(boolean z11) {
        FragmentActivity fragmentActivity;
        c cVar = (c) this.f34200f.get();
        if (cVar != null && cVar.getViewContext() != null && (fragmentActivity = (FragmentActivity) cVar.getViewContext()) != null) {
            int a11 = com.instabug.survey.common.f.a(fragmentActivity, n.SECONDARY);
            if (z11) {
                cVar.a(a11);
            } else {
                cVar.b(a11);
            }
        }
    }

    public void c(a aVar) {
        if (aVar != null) {
            aVar.y();
            a(aVar, State.SUBMITTED);
            b(aVar);
        }
    }
}
