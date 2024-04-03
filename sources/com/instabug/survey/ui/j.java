package com.instabug.survey.ui;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.survey.R;
import com.instabug.survey.models.Survey;
import com.instabug.survey.settings.c;
import com.instabug.survey.ui.popup.k;
import com.instabug.survey.ui.popup.l;
import com.instabug.survey.ui.survey.mcq.partial.b;
import com.instabug.survey.ui.survey.nps.partial.a;

public abstract class j {
    public static void a(@Nullable FragmentManager fragmentManager, Fragment fragment, int i11, int i12) {
        if (fragmentManager != null) {
            fragmentManager.beginTransaction().setCustomAnimations(i11, i12).replace(R.id.instabug_fragment_container, fragment).commit();
        } else if (fragment != null) {
            InstabugSDKLogger.e("IBG-Surveys", "couldn't navigate to fragment " + fragment.getTag() + " fragmentManager is null");
        }
    }

    public static void a(FragmentManager fragmentManager, Survey survey) {
        a(fragmentManager, survey, R.anim.instabug_anim_flyin_from_bottom, R.anim.instabug_anim_flyout_to_bottom);
    }

    public static void a(FragmentManager fragmentManager, Survey survey, int i11, int i12) {
        if (survey.getQuestions().get(0).f() == 0) {
            d(fragmentManager, survey, i11, i12);
        } else if (survey.getQuestions().get(0).f() == 1) {
            b(fragmentManager, survey, i11, i12);
        } else if (survey.getQuestions().get(0).f() == 2) {
            e(fragmentManager, survey, i11, i12);
        } else if (survey.getQuestions().get(0).f() == 3) {
            c(fragmentManager, survey, i11, i12);
        } else if (survey.getQuestions().get(0).f() == 5) {
            f(fragmentManager, survey, i11, i12);
        }
    }

    public static void b(FragmentManager fragmentManager, Survey survey) {
        a(fragmentManager, survey, 0, 0);
    }

    private static void b(FragmentManager fragmentManager, Survey survey, int i11, int i12) {
        a(fragmentManager, (Fragment) b.i(survey), i11, i12);
    }

    private static void c(FragmentManager fragmentManager, Survey survey, int i11, int i12) {
        a(fragmentManager, (Fragment) a.i(survey), i11, i12);
    }

    private static void d(FragmentManager fragmentManager, Survey survey, int i11, int i12) {
        a(fragmentManager, (Fragment) com.instabug.survey.ui.survey.text.partial.a.i(survey), i11, i12);
    }

    private static void e(FragmentManager fragmentManager, Survey survey, int i11, int i12) {
        a(fragmentManager, (Fragment) com.instabug.survey.ui.survey.starrating.partial.a.i(survey), i11, i12);
    }

    private static void f(FragmentManager fragmentManager, Survey survey, int i11, int i12) {
        a(fragmentManager, c.n() ? k.h(survey) : l.h(survey), i11, i12);
    }
}
