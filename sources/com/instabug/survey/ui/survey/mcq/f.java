package com.instabug.survey.ui.survey.mcq;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.instabug.library.util.AccessibilityUtils;
import com.instabug.library.util.AttrResolver;
import com.instabug.library.util.DrawableUtils;
import com.instabug.survey.R;
import com.instabug.survey.models.b;
import zd.a;

public abstract class f extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private final LayoutInflater f52573a;

    /* renamed from: b  reason: collision with root package name */
    private d f52574b;

    /* renamed from: c  reason: collision with root package name */
    private b f52575c;

    /* renamed from: d  reason: collision with root package name */
    private int f52576d = -1;

    /* renamed from: e  reason: collision with root package name */
    public Context f52577e;

    public f(Activity activity, b bVar, d dVar) {
        this.f52577e = activity;
        this.f52573a = LayoutInflater.from(activity);
        this.f52575c = bVar;
        a(bVar);
        this.f52574b = dVar;
    }

    private View.OnClickListener a(String str, int i11) {
        return new a(this, i11, str);
    }

    /* access modifiers changed from: private */
    public String a(Resources resources, int i11, String str, int i12) {
        return resources.getString(R.string.ib_msq_item_description, new Object[]{Integer.valueOf(i11), Integer.valueOf(getCount()), getItem(i12), str});
    }

    private void a(int i11, @NonNull LinearLayout linearLayout, boolean z11) {
        ViewCompat.setAccessibilityDelegate(linearLayout, new c(this, i11, z11));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(int i11, String str, View view) {
        b(i11);
        AccessibilityUtils.sendTextEvent(str + " " + view.getResources().getString(R.string.ib_selected));
        this.f52574b.a(view, str);
    }

    private void a(b bVar) {
        if (bVar.d() != null) {
            int i11 = 0;
            while (i11 < bVar.d().size()) {
                if (bVar.a() == null || !bVar.a().equals(bVar.d().get(i11))) {
                    i11++;
                } else {
                    this.f52576d = i11;
                    return;
                }
            }
        }
    }

    private void b(int i11) {
        this.f52576d = i11;
        notifyDataSetChanged();
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void d(com.instabug.survey.ui.survey.mcq.e r4) {
        /*
            r3 = this;
            com.instabug.library.InstabugColorTheme r0 = com.instabug.library.core.InstabugCore.getTheme()
            com.instabug.library.InstabugColorTheme r1 = com.instabug.library.InstabugColorTheme.InstabugColorThemeLight
            if (r0 != r1) goto L_0x0013
            android.widget.LinearLayout r0 = r4.f52570a
            if (r0 == 0) goto L_0x0024
            int r1 = r3.b((com.instabug.survey.ui.survey.mcq.e) r4)
            r2 = 25
            goto L_0x001d
        L_0x0013:
            android.widget.LinearLayout r0 = r4.f52570a
            if (r0 == 0) goto L_0x0024
            int r1 = r3.b((com.instabug.survey.ui.survey.mcq.e) r4)
            r2 = 50
        L_0x001d:
            int r1 = androidx.core.graphics.ColorUtils.setAlphaComponent(r1, r2)
            com.instabug.library.util.DrawableUtils.setColor(r0, r1)
        L_0x0024:
            android.widget.TextView r0 = r4.f52571b
            if (r0 == 0) goto L_0x002f
            int r1 = r3.e(r4)
            r0.setTextColor(r1)
        L_0x002f:
            r3.h(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.survey.ui.survey.mcq.f.d(com.instabug.survey.ui.survey.mcq.e):void");
    }

    private void f(e eVar) {
        TextView textView;
        LinearLayout linearLayout = eVar.f52570a;
        if (linearLayout != null) {
            DrawableUtils.setColor(linearLayout, g(eVar));
        }
        Context context = this.f52577e;
        if (!(context == null || (textView = eVar.f52571b) == null)) {
            textView.setTextColor(AttrResolver.resolveAttributeColor(context, R.attr.instabug_survey_mcq_text_color));
        }
        i(eVar);
    }

    @Nullable
    public String a() {
        int i11 = this.f52576d;
        if (i11 == -1) {
            return null;
        }
        return getItem(i11);
    }

    /* renamed from: a */
    public String getItem(int i11) {
        return this.f52575c.d() == null ? "null" : (String) this.f52575c.d().get(i11);
    }

    public void a(@Nullable String str) {
        if (str != null && !str.isEmpty()) {
            for (int i11 = 0; i11 < getCount(); i11++) {
                if (str.equalsIgnoreCase(getItem(i11))) {
                    this.f52576d = i11;
                    return;
                }
            }
        }
    }

    public abstract int b(e eVar);

    public abstract int e(e eVar);

    public abstract int g(e eVar);

    public int getCount() {
        b bVar = this.f52575c;
        if (bVar == null || bVar.d() == null) {
            return 0;
        }
        return this.f52575c.d().size();
    }

    public long getItemId(int i11) {
        return (long) i11;
    }

    public View getView(int i11, View view, ViewGroup viewGroup) {
        View view2;
        e eVar;
        TextView textView;
        if (view == null) {
            eVar = new e();
            view2 = this.f52573a.inflate(R.layout.instabug_survey_mcq_item, (ViewGroup) null);
            eVar.f52570a = (LinearLayout) view2.findViewById(R.id.mcq_item);
            eVar.f52571b = (TextView) view2.findViewById(R.id.survey_optional_answer_textview);
            eVar.f52572c = (ImageView) view2.findViewById(R.id.selector_img);
            view2.setTag(eVar);
        } else {
            view2 = view;
            eVar = (e) view.getTag();
        }
        if (!(this.f52575c.d() == null || (textView = eVar.f52571b) == null)) {
            textView.setText((CharSequence) this.f52575c.d().get(i11));
        }
        boolean z11 = i11 == this.f52576d;
        if (z11) {
            d(eVar);
        } else {
            f(eVar);
        }
        if (!(this.f52574b == null || this.f52575c.d() == null)) {
            LinearLayout linearLayout = eVar.f52570a;
            if (linearLayout != null) {
                linearLayout.setOnClickListener(a((String) this.f52575c.d().get(i11), i11));
                a(i11, eVar.f52570a, z11);
            }
            TextView textView2 = eVar.f52571b;
            if (textView2 != null) {
                textView2.setOnClickListener(a((String) this.f52575c.d().get(i11), i11));
                ViewCompat.setImportantForAccessibility(eVar.f52571b, 2);
            }
            ImageView imageView = eVar.f52572c;
            if (imageView != null) {
                imageView.setOnClickListener(a((String) this.f52575c.d().get(i11), i11));
                ViewCompat.setImportantForAccessibility(eVar.f52572c, 2);
            }
        }
        return view2;
    }

    public abstract void h(e eVar);

    public abstract void i(e eVar);
}
