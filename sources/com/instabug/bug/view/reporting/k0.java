package com.instabug.bug.view.reporting;

import android.content.Intent;
import android.media.projection.MediaProjectionManager;
import android.os.Build;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.instabug.bug.view.disclaimer.a;
import com.instabug.bug.view.disclaimer.b;
import com.instabug.bug.view.visualusersteps.steppreview.d;
import com.instabug.bug.view.visualusersteps.visitedscreens.e;
import com.instabug.library.R;
import com.instabug.library.internal.InstabugMediaProjectionIntent;

abstract class k0 {
    @RequiresApi(api = 21)
    public static void a(@NonNull MediaProjectionManager mediaProjectionManager, x xVar) {
        if (xVar != null) {
            if (InstabugMediaProjectionIntent.getMediaProjectionIntent() != null) {
                xVar.X();
            } else {
                xVar.startActivityForResult(mediaProjectionManager.createScreenCaptureIntent(), 3890);
            }
        }
    }

    private static void a(FragmentManager fragmentManager, @IdRes int i11, Fragment fragment, @Nullable String str, boolean z11) {
        FragmentTransaction replace = fragmentManager.beginTransaction().replace(i11, fragment, str);
        if (z11) {
            replace.addToBackStack(str);
        }
        replace.commitAllowingStateLoss();
    }

    public static void b(FragmentManager fragmentManager, a aVar) {
        a(fragmentManager, R.id.instabug_fragment_container, b.a(aVar), "disclaimer_details", true);
    }

    public static void c(FragmentManager fragmentManager, @NonNull com.instabug.bug.view.visualusersteps.steppreview.b bVar) {
        a(fragmentManager, R.id.instabug_fragment_container, d.a(bVar), "visual_user_step_preview", true);
    }

    public static void d(FragmentManager fragmentManager, @Nullable String str) {
        a(fragmentManager, com.instabug.bug.R.id.instabug_fragment_container, com.instabug.bug.view.extrafields.d.a(str), "ExtraFieldsFragment", true);
    }

    public static void e(FragmentManager fragmentManager, @Nullable String str, boolean z11) {
        a(fragmentManager, com.instabug.bug.R.id.instabug_fragment_container, com.instabug.bug.view.reporting.askquestion.a.h(str), com.instabug.bug.view.reporting.askquestion.a.E, z11);
    }

    public static void f(FragmentManager fragmentManager, boolean z11) {
        a(fragmentManager, com.instabug.bug.R.id.instabug_fragment_container, com.instabug.bug.view.disclaimer.d.g(), "disclaimer", z11);
    }

    public static void g(x xVar, String str) {
        Intent intent;
        if (Build.VERSION.SDK_INT >= 24) {
            intent = new Intent("android.intent.action.OPEN_DOCUMENT");
            intent.addCategory("android.intent.category.OPENABLE");
        } else {
            intent = new Intent("android.intent.action.PICK");
        }
        intent.setType("*/*");
        intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/*", "video/*"});
        xVar.a(Intent.createChooser(intent, str), 3862);
    }

    public static void h(FragmentManager fragmentManager, String str) {
        a(fragmentManager, R.id.instabug_fragment_container, e.a(str), "visual_user_steps", true);
    }

    public static void i(FragmentManager fragmentManager, @Nullable String str, boolean z11) {
        a(fragmentManager, com.instabug.bug.R.id.instabug_fragment_container, com.instabug.bug.view.reporting.bugreporting.a.h(str), com.instabug.bug.view.reporting.bugreporting.a.E, z11);
    }

    public static void j(FragmentManager fragmentManager, @Nullable String str, boolean z11) {
        a(fragmentManager, com.instabug.bug.R.id.instabug_fragment_container, com.instabug.bug.view.reporting.feedback.a.h(str), com.instabug.bug.view.reporting.feedback.a.E, z11);
    }
}
