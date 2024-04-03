package com.instabug.survey.announcements.ui.fragment.whatsnew;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.ui.BackPressHandler;
import com.instabug.survey.R;
import com.instabug.survey.announcements.models.c;
import com.instabug.survey.announcements.ui.activity.AnnouncementActivity;
import com.instabug.survey.announcements.ui.custom.DynamicRelativeLayout;
import com.instabug.survey.announcements.ui.fragment.a;
import java.util.Iterator;
import org.jetbrains.annotations.NotNull;

public class d extends a implements View.OnTouchListener, View.OnClickListener, a, BackPressHandler {
    @VisibleForTesting
    @Nullable
    public b J;
    @VisibleForTesting
    @Nullable
    public RecyclerView K;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public Button f52300f;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public TextView f52301g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private e f52302h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private AnnouncementActivity f52303i;

    public static d b(c cVar) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("announcement_item", cVar);
        d dVar = new d();
        dVar.setArguments(bundle);
        return dVar;
    }

    public void a(c cVar) {
        if (getActivity() != null) {
            this.J = new b(getActivity(), cVar);
            RecyclerView recyclerView = this.K;
            if (recyclerView != null) {
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                recyclerView.setAdapter(this.J);
            }
            TextView textView = this.f52301g;
            if (textView != null) {
                textView.setText(cVar.g() != null ? cVar.g() : "");
                this.f52301g.setTextColor(InstabugCore.getPrimaryColor());
            }
            if (this.f52300f != null && cVar.f() != null && cVar.f().size() > 0) {
                String str = (String) cVar.f().get(0);
                this.f52300f.setText(str);
                this.f52300f.setContentDescription(str);
                this.f52300f.setBackgroundColor(InstabugCore.getPrimaryColor());
                this.f52300f.setOnClickListener(this);
            }
        }
    }

    public void b() {
        com.instabug.survey.announcements.models.a aVar = this.I;
        if (aVar != null && aVar.c() != null) {
            Iterator it = this.I.c().iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                if (cVar.f() != null) {
                    cVar.a((String) cVar.f().get(0));
                }
            }
            AnnouncementActivity announcementActivity = this.f52303i;
            if (announcementActivity != null) {
                announcementActivity.b(this.I);
            }
        }
    }

    public void c() {
        com.instabug.survey.announcements.models.a aVar;
        AnnouncementActivity announcementActivity = this.f52303i;
        if (announcementActivity != null && (aVar = this.I) != null) {
            announcementActivity.a(aVar);
        }
    }

    public int i0() {
        return R.layout.instabug_dialog_whats_new_announce;
    }

    public void j0(View view, @Nullable Bundle bundle) {
        super.j0(view, bundle);
        this.f52301g = (TextView) view.findViewById(R.id.instabug_announcement_title);
        this.K = (RecyclerView) view.findViewById(R.id.instabug_announcement_features_grid_view);
        this.f52300f = (Button) view.findViewById(R.id.instabug_btn_submit);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.instabug_announcement_dialog_container);
        this.H = relativeLayout;
        if (relativeLayout instanceof DynamicRelativeLayout) {
            relativeLayout.setOnTouchListener(this);
            this.H.getViewTreeObserver().addOnGlobalLayoutListener(new c(this));
        }
        if (getArguments() != null) {
            this.G = (c) getArguments().getSerializable("announcement_item");
        }
        e eVar = new e(this);
        this.f52302h = eVar;
        c cVar = this.G;
        if (cVar != null) {
            eVar.a(cVar);
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            this.f52303i = (AnnouncementActivity) context;
        } catch (ClassCastException unused) {
            throw new ClassCastException(context.toString() + " must implement AnnouncementActivity");
        }
    }

    public boolean onBackPress() {
        return true;
    }

    public void onClick(View view) {
        if (view.getId() == R.id.instabug_btn_submit) {
            b();
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
    }

    public void onDetach() {
        this.f52303i = null;
        super.onDetach();
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        e eVar = this.f52302h;
        if (eVar == null) {
            return true;
        }
        eVar.a(view, motionEvent);
        return true;
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        view.setFocusableInTouchMode(true);
    }
}
