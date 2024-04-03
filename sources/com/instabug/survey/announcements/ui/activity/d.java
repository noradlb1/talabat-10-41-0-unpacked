package com.instabug.survey.announcements.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.util.LocaleUtils;
import com.instabug.library.util.URLUtil;
import com.instabug.survey.R;
import com.instabug.survey.announcements.models.a;
import com.instabug.survey.announcements.models.c;
import com.instabug.survey.announcements.ui.fragment.versionupdate.e;

public abstract class d {
    public static void a(Context context, String str) {
        if (context != null) {
            String resolve = URLUtil.resolve(str);
            if (resolve != null) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(resolve));
                if (intent.resolveActivity(context.getPackageManager()) != null) {
                    context.startActivity(intent);
                    return;
                }
            }
            b(context, LocaleUtils.getLocaleStringResource(InstabugCore.getLocale(context), R.string.ib_announcement_redirect_error, context));
        }
    }

    public static void a(FragmentManager fragmentManager, Fragment fragment, int i11, int i12) {
        fragmentManager.beginTransaction().setCustomAnimations(i11, i12).replace(R.id.instabug_fragment_container, fragment).commit();
    }

    public static void a(FragmentManager fragmentManager, a aVar) {
        int p11 = aVar.p();
        if (p11 == 100) {
            a(fragmentManager, aVar, R.anim.instabug_anim_flyin_from_bottom, R.anim.instabug_anim_flyout_to_bottom);
        } else if (p11 == 101) {
            b(fragmentManager, aVar);
        }
    }

    private static void a(FragmentManager fragmentManager, a aVar, int i11, int i12) {
        if (aVar.c() != null) {
            a(fragmentManager, (Fragment) com.instabug.survey.announcements.ui.fragment.whatsnew.d.b((c) aVar.c().get(0)), i11, i12);
        }
    }

    private static void b(Context context, String str) {
        Toast.makeText(context, str, 0).show();
    }

    private static void b(FragmentManager fragmentManager, a aVar) {
        if (aVar.c() != null) {
            a(fragmentManager, (Fragment) e.b((c) aVar.c().get(0)), 0, 0);
        }
    }
}
