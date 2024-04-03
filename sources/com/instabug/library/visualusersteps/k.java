package com.instabug.library.visualusersteps;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.view.menu.MenuItemImpl;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.internal.NavigationMenuItemView;
import com.google.android.material.tabs.TabLayout;
import com.instabug.library.util.BitmapUtils;
import com.instabug.library.util.StringUtility;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class k {

    /* renamed from: h  reason: collision with root package name */
    private static k f52168h;

    /* renamed from: a  reason: collision with root package name */
    private List f52169a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private List f52170b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private List f52171c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private List f52172d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private List f52173e = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public e f52174f = new e();

    /* renamed from: g  reason: collision with root package name */
    private StringBuilder f52175g = new StringBuilder();

    private k() {
        g();
    }

    public static k b() {
        if (f52168h == null) {
            f52168h = new k();
        }
        return f52168h;
    }

    private void d() {
        Collections.sort(this.f52169a, new f(this));
    }

    public void a(View view, j jVar) {
        String str;
        String str2;
        d c11 = y.d().c();
        g();
        if (l.c(view)) {
            a((Button) view, c11, jVar);
        } else if (l.k(view)) {
            a((TextView) view, c11, jVar);
        } else if (l.a(view)) {
            a((TabLayout) view, c11, jVar);
        } else if (l.g(view)) {
            a(view, c11, jVar);
        } else if (l.d(view)) {
            if (view.getParent() == null || !l.l((View) view.getParent())) {
                a((ImageButton) view, c11, jVar);
            } else {
                b((ImageButton) view, c11, jVar);
            }
        } else if (l.e(view)) {
            a((ImageView) view, c11, jVar);
        } else if (l.j(view)) {
            CompoundButton compoundButton = (CompoundButton) view;
            if (a(compoundButton)) {
                str2 = String.format("the switch \"%s\"", new Object[]{compoundButton.getText().toString()});
            } else if (a(view)) {
                str2 = String.format("the switch \"%s\"", new Object[]{view.getContentDescription().toString()});
            } else {
                str2 = "a switch";
            }
            this.f52174f.c(str2);
            jVar.a(c11, this.f52174f);
        } else if (l.i(view)) {
            SeekBar seekBar = (SeekBar) view;
            if (a(view)) {
                str = String.format("the slider \"%s\" to %d", new Object[]{view.getContentDescription().toString(), Integer.valueOf(seekBar.getProgress())});
            } else {
                str = String.format("a slider to %d", new Object[]{Integer.valueOf(seekBar.getProgress())});
            }
            this.f52174f.c(str);
            jVar.a(c11, this.f52174f);
        } else if (view instanceof ViewGroup) {
            a((ViewGroup) view, c11, jVar);
        } else {
            jVar.a(c11, this.f52174f);
        }
    }

    public void g() {
        this.f52170b = new ArrayList();
        this.f52169a = new ArrayList();
        this.f52171c = new ArrayList();
        this.f52172d = new ArrayList();
        this.f52173e = new ArrayList();
        this.f52175g = new StringBuilder();
        this.f52174f = new e();
    }

    public void h() {
        String a11;
        for (WeakReference weakReference : this.f52170b) {
            View view = (View) weakReference.get();
            if ((view instanceof TextView) && (a11 = a((TextView) view)) != null && !a11.isEmpty()) {
                int[] iArr = new int[2];
                view.getLocationOnScreen(iArr);
                int i11 = iArr[0];
                this.f52169a.add(new b(a11, (float) iArr[1], (float) i11));
            }
            if (this.f52169a.size() == 20) {
                return;
            }
        }
    }

    public void d(ViewGroup viewGroup) {
        a(viewGroup, this.f52171c);
        a(this.f52171c, this.f52172d);
        a(this.f52172d, this.f52173e);
        a(this.f52173e, (List) null);
    }

    private void b(ImageButton imageButton, @Nullable d dVar, j jVar) {
        String str;
        if (!VisualUserStepsHelper.a(imageButton)) {
            Drawable b11 = b(imageButton);
            if (b11 != null) {
                a(imageButton, b11, dVar, jVar);
            } else if (a((View) imageButton)) {
                str = String.format("the button \"%s\"", new Object[]{imageButton.getContentDescription()});
                this.f52174f.c(str);
                jVar.a(dVar, this.f52174f);
                this.f52174f.c(str);
                jVar.a(dVar, this.f52174f);
            }
        }
        str = "a button";
        this.f52174f.c(str);
        jVar.a(dVar, this.f52174f);
    }

    @VisibleForTesting
    public Drawable b(ImageButton imageButton) {
        return imageButton.getDrawable();
    }

    private boolean a(CompoundButton compoundButton) {
        return compoundButton.getText() != null && !TextUtils.isEmpty(compoundButton.getText().toString());
    }

    /* access modifiers changed from: private */
    public boolean a(View view) {
        return view.getContentDescription() != null && view.getContentDescription().length() > 0;
    }

    private void a(ViewGroup viewGroup, @Nullable d dVar, j jVar) {
        d(viewGroup);
        h();
        d();
        this.f52174f.c(a());
        jVar.a(dVar, this.f52174f);
    }

    private void a(List list, @Nullable List list2) {
        for (int i11 = 0; i11 < list.size() && this.f52170b.size() < 60; i11++) {
            ViewGroup viewGroup = (ViewGroup) ((WeakReference) list.get(i11)).get();
            if (viewGroup != null) {
                a(viewGroup, list2);
            }
        }
    }

    private void a(ViewGroup viewGroup, @Nullable List list) {
        for (int i11 = 0; i11 < viewGroup.getChildCount() && this.f52170b.size() < 60; i11++) {
            this.f52170b.add(new WeakReference(viewGroup.getChildAt(i11)));
            if ((viewGroup.getChildAt(i11) instanceof ViewGroup) && list != null) {
                list.add(new WeakReference((ViewGroup) viewGroup.getChildAt(i11)));
            }
        }
    }

    @Nullable
    private String a() {
        if (this.f52175g == null) {
            return null;
        }
        for (b c11 : this.f52169a) {
            String c12 = c11.c();
            boolean z11 = this.f52175g.length() > 0;
            int length = 500 - this.f52175g.length();
            if (z11) {
                length -= 3;
            }
            if (length <= 0) {
                break;
            }
            String trimString = StringUtility.trimString(c12, length);
            if (z11) {
                this.f52175g.append(" - ");
            }
            this.f52175g.append(trimString);
        }
        if (this.f52175g.length() <= 0) {
            return null;
        }
        return String.format("UI that contains \"%s\"", new Object[]{this.f52175g.toString()});
    }

    @Nullable
    private String a(TextView textView) {
        if (VisualUserStepsHelper.a(textView) || textView == null || textView.getText() == null || textView.getText().length() <= 0) {
            return null;
        }
        return textView.getText().toString();
    }

    private void a(ImageView imageView, @Nullable d dVar, j jVar) {
        String str;
        if (VisualUserStepsHelper.a(imageView) || !a((View) imageView)) {
            str = "an image";
        } else {
            str = String.format("the image \"%s\"", new Object[]{imageView.getContentDescription().toString()});
        }
        this.f52174f.c(str);
        jVar.a(dVar, this.f52174f);
    }

    private void a(TextView textView, @Nullable d dVar, j jVar) {
        String str;
        if (!VisualUserStepsHelper.a(textView)) {
            if (textView.getText() != null && textView.getText().length() > 0) {
                str = String.format("the label \"%s\"", new Object[]{StringUtility.trimString(textView.getText().toString(), 500)});
                this.f52174f.c(str);
                jVar.a(dVar, this.f52174f);
            } else if (a((View) textView)) {
                str = String.format("the button \"%s\"", new Object[]{StringUtility.trimString(textView.getContentDescription().toString(), 500)});
                this.f52174f.c(str);
                jVar.a(dVar, this.f52174f);
            }
        }
        str = "a label";
        this.f52174f.c(str);
        jVar.a(dVar, this.f52174f);
    }

    private void a(Button button, @Nullable d dVar, j jVar) {
        String str = "a button";
        if (VisualUserStepsHelper.a(button)) {
            this.f52174f.c(str);
            jVar.a(dVar, this.f52174f);
        } else if (button.getText() == null || button.getText().length() <= 0) {
            Drawable a11 = a(button);
            if (a11 == null || VisualUserStepsHelper.a(button)) {
                if (a((View) button)) {
                    str = String.format("the button \"%s\"", new Object[]{button.getContentDescription()});
                }
                this.f52174f.c(str);
                jVar.a(dVar, this.f52174f);
                return;
            }
            a(button, a11, dVar, jVar);
        } else {
            this.f52174f.c(String.format("the button \"%s\"", new Object[]{button.getText().toString()}));
            jVar.a(dVar, this.f52174f);
        }
    }

    private void a(ImageButton imageButton, @Nullable d dVar, j jVar) {
        String str;
        if (!VisualUserStepsHelper.a(imageButton)) {
            if (a((View) imageButton)) {
                str = String.format("the button \"%s\"", new Object[]{imageButton.getContentDescription()});
            } else {
                Drawable b11 = b(imageButton);
                if (b11 != null) {
                    a(imageButton, b11, dVar, jVar);
                } else if (a((View) imageButton)) {
                    str = String.format("the button \"%s\"", new Object[]{imageButton.getContentDescription()});
                }
            }
            this.f52174f.c(str);
            jVar.a(dVar, this.f52174f);
        }
        str = "a button";
        this.f52174f.c(str);
        jVar.a(dVar, this.f52174f);
    }

    private void a(TabLayout tabLayout, @Nullable d dVar, j jVar) {
        tabLayout.addOnTabSelectedListener((TabLayout.BaseOnTabSelectedListener) new g(this, tabLayout, jVar, dVar));
    }

    private void a(View view, @Nullable d dVar, j jVar) {
        MenuItemImpl menuItemImpl;
        if (view instanceof NavigationMenuItemView) {
            menuItemImpl = ((NavigationMenuItemView) view).getItemData();
        } else {
            menuItemImpl = view instanceof BottomNavigationItemView ? ((BottomNavigationItemView) view).getItemData() : null;
        }
        if (menuItemImpl == null) {
            jVar.a(dVar, this.f52174f);
        } else if (!TextUtils.isEmpty(menuItemImpl.getTitle())) {
            this.f52174f.c(String.format("the button \"%s\"", new Object[]{menuItemImpl.getTitle()}));
            jVar.a(dVar, this.f52174f);
        } else if (menuItemImpl.getIcon() != null && !VisualUserStepsHelper.a(view)) {
            a(view, menuItemImpl.getIcon(), dVar, jVar);
        } else if (!TextUtils.isEmpty(menuItemImpl.getContentDescription())) {
            this.f52174f.c(String.format("the button \"%s\"", new Object[]{menuItemImpl.getContentDescription()}));
            jVar.a(dVar, this.f52174f);
        } else {
            this.f52174f.c("a button");
            jVar.a(dVar, this.f52174f);
        }
    }

    private void a(View view, Drawable drawable, @Nullable d dVar, j jVar) {
        BitmapUtils.saveDrawableBitmap(drawable, System.currentTimeMillis(), new h(this, jVar, dVar, view));
    }

    /* access modifiers changed from: private */
    public void a(Drawable drawable, @Nullable d dVar, j jVar) {
        BitmapUtils.saveDrawableBitmap(drawable, System.currentTimeMillis(), new i(this, jVar, dVar));
    }

    @VisibleForTesting
    @Nullable
    public Drawable a(Button button) {
        Drawable[] compoundDrawables = button.getCompoundDrawables();
        Drawable drawable = null;
        if (compoundDrawables.length > 0) {
            int length = compoundDrawables.length;
            for (int i11 = 0; i11 < length; i11++) {
                drawable = compoundDrawables[i11];
                if (drawable != null) {
                    break;
                }
            }
        }
        return drawable;
    }
}
