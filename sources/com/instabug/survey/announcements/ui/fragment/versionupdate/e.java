package com.instabug.survey.announcements.ui.fragment.versionupdate;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import com.instabug.library.ui.custom.InstabugAlertDialog;
import com.instabug.survey.R;
import com.instabug.survey.announcements.models.c;
import com.instabug.survey.announcements.ui.activity.AnnouncementActivity;
import com.instabug.survey.announcements.ui.activity.b;
import com.instabug.survey.announcements.ui.activity.d;
import com.instabug.survey.announcements.ui.fragment.a;
import java.util.Iterator;

public class e extends a implements a {

    /* renamed from: d  reason: collision with root package name */
    private f f52289d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private b f52290e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private AlertDialog f52291f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private DialogInterface.OnClickListener f52292g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private DialogInterface.OnClickListener f52293h;

    public static e b(c cVar) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("announcement_item", cVar);
        e eVar = new e();
        eVar.setArguments(bundle);
        return eVar;
    }

    public void a(String str) {
        b bVar = this.f52290e;
        if (getContext() != null && this.I != null && bVar != null) {
            d.a(getContext(), str);
            bVar.b(this.I);
        }
    }

    public void a(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        this.f52292g = new d(this);
        if (getActivity() != null) {
            this.f52291f = new InstabugAlertDialog.Builder(getActivity()).setTitle(str).setMessage(str2).setCancellable(false).setPositiveButton(str3, this.f52292g).setPositiveButtonAccessibilityContentDescription("").setNegativeButtonAccessibilityContentDescription("").show();
        }
    }

    public void b() {
        com.instabug.survey.announcements.models.a aVar = this.I;
        if (aVar != null && aVar.c() != null && this.f52290e != null) {
            if (this.I.c() != null) {
                Iterator it = this.I.c().iterator();
                while (it.hasNext()) {
                    c cVar = (c) it.next();
                    if (cVar.f() != null) {
                        cVar.a((String) cVar.f().get(1));
                    }
                }
            }
            this.f52290e.a(this.I);
        }
    }

    public void c(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        this.f52292g = new b(this);
        this.f52293h = new c(this);
        if (getActivity() != null) {
            this.f52291f = new InstabugAlertDialog.Builder(getActivity()).setTitle(str).setMessage(str2).setCancellable(false).setPositiveButton(str3, this.f52292g).setNegativeButton(str4, this.f52293h).setNegativeButtonAccessibilityContentDescription("").setPositiveButtonAccessibilityContentDescription("").show();
        }
    }

    public void d() {
        b bVar = this.f52290e;
        if (getContext() != null && this.I != null && bVar != null) {
            com.instabug.survey.utils.e.b(getContext());
            bVar.b(this.I);
        }
    }

    public void e() {
        com.instabug.survey.announcements.models.a aVar = this.I;
        if (aVar != null && this.G != null) {
            if (aVar.c() != null) {
                Iterator it = this.I.c().iterator();
                while (it.hasNext()) {
                    c cVar = (c) it.next();
                    if (cVar.f() != null) {
                        cVar.a((String) cVar.f().get(0));
                    }
                }
            }
            if (this.G.f() != null) {
                c cVar2 = this.G;
                cVar2.a((String) cVar2.f().get(0));
            }
            this.f52289d.a(this.G, this.I);
        }
    }

    public int i0() {
        return R.layout.instabug_dialog_version_update_announce;
    }

    public void j0(View view, @Nullable Bundle bundle) {
        super.j0(view, bundle);
        this.H = (RelativeLayout) view.findViewById(R.id.instabug_announcement_dialog_container);
        c cVar = this.G;
        if (cVar != null) {
            this.f52289d.d(cVar);
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            this.f52290e = (AnnouncementActivity) context;
        } catch (ClassCastException unused) {
            throw new ClassCastException(context.toString() + " must implement AnnouncementActivity");
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        if (getArguments() != null) {
            this.G = (c) getArguments().getSerializable("announcement_item");
        }
        this.f52289d = new f(this);
    }

    public void onDestroy() {
        AlertDialog alertDialog = this.f52291f;
        if (alertDialog != null) {
            if (alertDialog.isShowing()) {
                this.f52291f.cancel();
            }
            this.f52291f.setOnCancelListener((DialogInterface.OnCancelListener) null);
            this.f52291f.setOnShowListener((DialogInterface.OnShowListener) null);
            this.f52292g = null;
            this.f52293h = null;
            this.f52291f = null;
        }
        f fVar = this.f52289d;
        if (fVar != null) {
            fVar.onDestroy();
        }
        super.onDestroy();
    }

    public void onDetach() {
        this.f52290e = null;
        super.onDetach();
    }

    public void onPause() {
        super.onPause();
        AlertDialog alertDialog = this.f52291f;
        if (alertDialog != null && alertDialog.isShowing()) {
            this.f52291f.cancel();
        }
    }

    public void onResume() {
        super.onResume();
        if (getActivity() != null && (getActivity() instanceof AnnouncementActivity)) {
            ((AnnouncementActivity) getActivity()).e(false);
        }
        AlertDialog alertDialog = this.f52291f;
        if (alertDialog != null && !alertDialog.isShowing() && getActivity() != null) {
            this.f52291f.show();
        }
    }
}
