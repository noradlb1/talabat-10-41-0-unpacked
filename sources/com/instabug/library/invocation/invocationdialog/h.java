package com.instabug.library.invocation.invocationdialog;

import android.annotation.SuppressLint;
import android.graphics.PorterDuff;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.instabug.library.Instabug;
import com.instabug.library.R;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.AccessibilityUtils;
import com.instabug.library.util.InstabugAppData;
import ed.a;
import java.util.ArrayList;

public class h extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList f51300a = new ArrayList();

    public static void a(View view, int i11, int i12, int i13, int i14) {
        if (view != null && (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).setMargins(i11, i12, i13, i14);
            view.requestLayout();
        }
    }

    public int getCount() {
        return this.f51300a.size();
    }

    public long getItemId(int i11) {
        return (long) i11;
    }

    @SuppressLint({"ERADICATE_INCONSISTENT_SUBCLASS_RETURN_ANNOTATION"})
    @Nullable
    public View getView(int i11, View view, ViewGroup viewGroup) {
        g gVar;
        if (viewGroup == null) {
            return null;
        }
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ib_dialog_list_item, viewGroup, false);
            gVar = new g(view);
            view.setTag(gVar);
        } else {
            gVar = (g) view.getTag();
        }
        if ((viewGroup instanceof AbsListView) && AccessibilityUtils.isAccessibilityServiceEnabled()) {
            a aVar = new a(this, viewGroup, view, i11);
            View view2 = gVar.f51296a;
            if (view2 != null) {
                view2.setOnClickListener(aVar);
                ViewCompat.setImportantForAccessibility(gVar.f51296a, 1);
            }
        }
        a(gVar, getItem(i11));
        return view;
    }

    public boolean hasStableIds() {
        return true;
    }

    /* renamed from: a */
    public InstabugDialogItem getItem(int i11) {
        return (InstabugDialogItem) this.f51300a.get(i11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(ViewGroup viewGroup, View view, int i11, View view2) {
        ((AbsListView) viewGroup).performItemClick(view, i11, getItemId(i11));
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    private void a(g gVar, InstabugDialogItem instabugDialogItem) {
        TextView textView = gVar.f51298c;
        if (textView != null) {
            textView.setText(instabugDialogItem.getTitle());
        }
        if (gVar.f51299d != null) {
            if (TextUtils.isEmpty(instabugDialogItem.getDescription())) {
                gVar.f51299d.setVisibility(8);
            } else {
                gVar.f51299d.setVisibility(0);
                gVar.f51299d.setText(instabugDialogItem.getDescription());
                ViewCompat.setAccessibilityDelegate(gVar.f51299d, new f(this, instabugDialogItem));
            }
        }
        if (gVar.f51297b == null) {
            return;
        }
        if (instabugDialogItem.getResDrawable() != 0) {
            gVar.f51297b.setImageResource(instabugDialogItem.getResDrawable());
            gVar.f51297b.setVisibility(0);
            gVar.f51297b.getDrawable().setColorFilter(SettingsManager.getInstance().getPrimaryColor(), PorterDuff.Mode.SRC_IN);
            return;
        }
        gVar.f51297b.setVisibility(8);
        a((View) gVar.f51298c, 0, 0, 0, 0);
        a((View) gVar.f51299d, 0, 4, 0, 0);
    }

    /* access modifiers changed from: private */
    public String a(InstabugDialogItem instabugDialogItem) {
        int identifier = instabugDialogItem.getIdentifier();
        if (identifier == 0) {
            return String.format("Something in %s is broken or doesn't work as expected", new Object[]{a()});
        } else if (identifier == 1) {
            return String.format("New ideas or enhancements for %s", new Object[]{a()});
        } else if (identifier == 3) {
            return "Help, support and other inquiries";
        } else {
            if (identifier != 5) {
                return "";
            }
            return String.format("Request a new feature for %s", new Object[]{a()});
        }
    }

    private String a() {
        return Instabug.getApplicationContext() != null ? new InstabugAppData(Instabug.getApplicationContext()).getAppName() : "";
    }

    public void a(ArrayList arrayList) {
        this.f51300a = arrayList;
    }
}
