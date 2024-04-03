package com.instabug.survey.ui.popup;

import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.instabug.library.ui.custom.InstabugAlertDialog;
import com.instabug.survey.models.Survey;
import xd.a;
import xd.b;
import xd.c;
import xd.d;

public class l extends n {
    /* access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface, int i11) {
        q qVar = this.G;
        if (qVar != null) {
            qVar.e();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(DialogInterface dialogInterface, int i11) {
        q qVar = this.G;
        if (qVar != null) {
            qVar.c();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(DialogInterface dialogInterface, int i11) {
        q qVar = this.G;
        if (qVar != null) {
            qVar.d();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(DialogInterface dialogInterface, int i11) {
        q qVar = this.G;
        if (qVar != null) {
            qVar.g();
        }
    }

    public static l h(Survey survey) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("KEY_SURVEY_ARGUMENT", survey);
        l lVar = new l();
        lVar.setArguments(bundle);
        return lVar;
    }

    public void a(@Nullable String str, @Nullable String str2, String str3, String str4) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            new InstabugAlertDialog.Builder(activity).setTitle(str).setMessage(str2).setCancellable(false).setPositiveButton(str3, new a(this)).setNegativeButton(str4, new b(this)).show();
        }
    }

    public void b(@Nullable String str, @Nullable String str2, String str3, String str4) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            new InstabugAlertDialog.Builder(activity).setTitle(str).setMessage(str2).setCancellable(false).setPositiveButton(str3, new c(this)).setNegativeButton(str4, new d(this)).show();
        }
    }
}
