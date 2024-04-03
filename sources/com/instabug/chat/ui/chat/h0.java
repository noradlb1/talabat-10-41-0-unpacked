package com.instabug.chat.ui.chat;

import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.instabug.chat.R;
import com.instabug.chat.model.g;
import com.instabug.chat.model.m;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.internal.media.AudioPlayer;
import com.instabug.library.util.BitmapUtils;
import com.instabug.library.util.Colorizer;
import com.instabug.library.util.InstabugDateFormatter;
import com.instabug.library.util.VideoManipulationUtils;
import com.instabug.library.util.threading.PoolProvider;
import com.instabug.library.view.ViewUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class h0 extends BaseAdapter {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final AudioPlayer f46215a;

    /* renamed from: b  reason: collision with root package name */
    private List f46216b;

    /* renamed from: c  reason: collision with root package name */
    private ColorFilter f46217c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Context f46218d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public ListView f46219e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public f0 f46220f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public boolean f46221g = true;

    public h0(List list, Context context, ListView listView, f0 f0Var) {
        this.f46216b = list;
        this.f46219e = listView;
        this.f46218d = context;
        this.f46220f = f0Var;
        this.f46215a = new AudioPlayer();
        this.f46217c = new PorterDuffColorFilter(InstabugCore.getPrimaryColor(), PorterDuff.Mode.SRC_IN);
    }

    private void a(g gVar, g0 g0Var) {
        if (gVar.e() != null && g0Var.f46205d != null) {
            BitmapUtils.loadBitmap(gVar.e(), g0Var.f46205d);
        } else if (!(gVar.h() == null || g0Var.f46205d == null)) {
            a(gVar.h(), g0Var.f46205d, true);
        }
        ImageView imageView = g0Var.f46205d;
        if (imageView != null) {
            imageView.setOnClickListener(new r(this, gVar));
        }
    }

    private void a(g0 g0Var, g gVar) {
        String str;
        TextView textView;
        ImageView imageView;
        if (g0Var != null && gVar.g() != null) {
            int i11 = e0.f46200a[gVar.g().ordinal()];
            if (i11 == 1) {
                if (gVar.j()) {
                    TextView textView2 = g0Var.f46204c;
                    if (textView2 != null) {
                        g0Var.f46204c.setBackgroundDrawable(Colorizer.getPrimaryColorTintedDrawable(textView2.getBackground()));
                    }
                } else {
                    LinearLayout linearLayout = g0Var.f46213l;
                    if (linearLayout != null) {
                        linearLayout.removeAllViews();
                    }
                    if (gVar.i()) {
                        c(gVar, g0Var);
                    }
                }
                TextView textView3 = g0Var.f46203b;
                if (textView3 != null) {
                    textView3.setText(InstabugDateFormatter.formatMessageDate(this.f46218d, gVar.c()));
                }
                if (!(gVar.a() == null || (textView = g0Var.f46204c) == null)) {
                    textView.setText(gVar.a());
                }
                if (g0Var.f46202a == null || gVar.f() == null) {
                    return;
                }
            } else if (i11 == 2) {
                if (gVar.j() && (imageView = g0Var.f46205d) != null) {
                    g0Var.f46205d.setBackgroundDrawable(Colorizer.getPrimaryColorTintedDrawable(imageView.getBackground()));
                }
                TextView textView4 = g0Var.f46203b;
                if (textView4 != null) {
                    textView4.setText(InstabugDateFormatter.formatMessageDate(this.f46218d, gVar.c()));
                }
                a(gVar, g0Var);
                if (g0Var.f46202a == null || gVar.f() == null) {
                    return;
                }
            } else if (i11 == 3) {
                if (gVar.j()) {
                    FrameLayout frameLayout = g0Var.f46206e;
                    if (frameLayout != null) {
                        g0Var.f46206e.setBackgroundDrawable(Colorizer.getPrimaryColorTintedDrawable(frameLayout.getBackground()));
                    }
                    ImageView imageView2 = g0Var.f46207f;
                    if (imageView2 != null) {
                        imageView2.setColorFilter(this.f46217c);
                    }
                }
                TextView textView5 = g0Var.f46203b;
                if (textView5 != null) {
                    textView5.setText(InstabugDateFormatter.formatMessageDate(this.f46218d, gVar.c()));
                }
                f(gVar, g0Var);
                if (g0Var.f46202a == null || gVar.f() == null) {
                    return;
                }
            } else if (i11 == 4) {
                if (gVar.j()) {
                    ImageView imageView3 = g0Var.f46210i;
                    if (imageView3 != null) {
                        g0Var.f46210i.setBackgroundDrawable(Colorizer.getPrimaryColorTintedDrawable(imageView3.getBackground()));
                    }
                    ImageView imageView4 = g0Var.f46209h;
                    if (imageView4 != null) {
                        imageView4.setColorFilter(this.f46217c);
                    }
                }
                TextView textView6 = g0Var.f46203b;
                if (textView6 != null) {
                    textView6.setText(InstabugDateFormatter.formatMessageDate(this.f46218d, gVar.c()));
                }
                e(gVar, g0Var);
                if (g0Var.f46202a != null && gVar.h() != null) {
                    str = gVar.h();
                    a(str, g0Var.f46202a, false);
                }
                return;
            } else {
                return;
            }
            str = gVar.f();
            a(str, g0Var.f46202a, false);
        }
    }

    private void a(String str, ImageView imageView, boolean z11) {
        PoolProvider.postIOTask(new d0(this, str, imageView, z11));
    }

    private void b(g gVar, g0 g0Var) {
        ProgressBar progressBar = g0Var.f46212k;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        ImageView imageView = g0Var.f46209h;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        FrameLayout frameLayout = g0Var.f46211j;
        if (frameLayout != null) {
            frameLayout.setOnClickListener(new u(this, gVar));
        }
        if (gVar.e() != null) {
            VideoManipulationUtils.extractFirstVideoFrame(gVar.e(), new v(this, g0Var));
        }
    }

    private void c(g gVar, g0 g0Var) {
        ArrayList b11 = gVar.b();
        if (b11 != null && b11.size() > 0) {
            for (int i11 = 0; i11 < b11.size(); i11++) {
                m mVar = (m) b11.get(i11);
                Button button = new Button(this.f46218d);
                button.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                button.setPadding(ViewUtils.convertDpToPx(this.f46218d, 8.0f), 0, ViewUtils.convertDpToPx(this.f46218d, 8.0f), 0);
                button.setText(mVar.a());
                button.setTextColor(ContextCompat.getColor(this.f46218d, 17170443));
                button.setBackgroundColor(InstabugCore.getPrimaryColor());
                button.setMaxEms(30);
                button.setMaxLines(1);
                button.setId(i11);
                button.setOnClickListener(new q(this, mVar));
                LinearLayout linearLayout = g0Var.f46213l;
                if (linearLayout != null) {
                    linearLayout.addView(button);
                }
            }
        }
    }

    private void d(g gVar, g0 g0Var) {
        if (gVar.h() != null) {
            PoolProvider.postIOTask(new a0(this, gVar, g0Var));
        }
    }

    private void e(g gVar, g0 g0Var) {
        if (gVar.e() != null) {
            b(gVar, g0Var);
        } else {
            d(gVar, g0Var);
        }
    }

    private void f(g gVar, g0 g0Var) {
        String h11 = gVar.h() != null ? gVar.h() : gVar.e();
        ProgressBar progressBar = g0Var.f46208g;
        if (progressBar != null && progressBar.getVisibility() == 0) {
            g0Var.f46208g.setVisibility(8);
        }
        ImageView imageView = g0Var.f46207f;
        if (imageView != null && imageView.getVisibility() == 8) {
            g0Var.f46207f.setVisibility(0);
        }
        FrameLayout frameLayout = g0Var.f46206e;
        if (frameLayout != null) {
            frameLayout.setOnClickListener(new s(this, gVar, h11, g0Var));
        }
        this.f46215a.addOnStopListener(new t(this, h11, gVar, g0Var));
    }

    /* renamed from: a */
    public g getItem(int i11) {
        return (g) this.f46216b.get(i11);
    }

    public void a(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((g) it.next()).g() == null) {
                it.remove();
            }
        }
        this.f46216b = list;
    }

    public int getCount() {
        return this.f46216b.size();
    }

    public long getItemId(int i11) {
        return (long) i11;
    }

    public int getItemViewType(int i11) {
        g a11 = getItem(i11);
        if (a11.g() == null) {
            return -1;
        }
        int i12 = e0.f46200a[a11.g().ordinal()];
        if (i12 == 1) {
            return a11.j() ^ true ? 1 : 0;
        }
        if (i12 == 2) {
            return a11.j() ? 2 : 3;
        }
        if (i12 == 3) {
            return a11.j() ? 4 : 5;
        }
        if (i12 != 4) {
            return -1;
        }
        return a11.j() ? 6 : 7;
    }

    public View getView(int i11, View view, ViewGroup viewGroup) {
        g0 g0Var;
        LayoutInflater layoutInflater;
        int i12;
        if (viewGroup == null) {
            return view;
        }
        int itemViewType = getItemViewType(i11);
        if (view == null) {
            switch (itemViewType) {
                case 1:
                    layoutInflater = LayoutInflater.from(viewGroup.getContext());
                    i12 = R.layout.instabug_message_list_item;
                    break;
                case 2:
                    layoutInflater = LayoutInflater.from(viewGroup.getContext());
                    i12 = R.layout.instabug_message_list_item_img_me;
                    break;
                case 3:
                    layoutInflater = LayoutInflater.from(viewGroup.getContext());
                    i12 = R.layout.instabug_message_list_item_img;
                    break;
                case 4:
                    layoutInflater = LayoutInflater.from(viewGroup.getContext());
                    i12 = R.layout.instabug_message_list_item_voice_me;
                    break;
                case 5:
                    layoutInflater = LayoutInflater.from(viewGroup.getContext());
                    i12 = R.layout.instabug_message_list_item_voice;
                    break;
                case 6:
                    layoutInflater = LayoutInflater.from(viewGroup.getContext());
                    i12 = R.layout.instabug_message_list_item_video_me;
                    break;
                case 7:
                    layoutInflater = LayoutInflater.from(viewGroup.getContext());
                    i12 = R.layout.instabug_message_list_item_video;
                    break;
                default:
                    layoutInflater = LayoutInflater.from(viewGroup.getContext());
                    i12 = R.layout.instabug_message_list_item_me;
                    break;
            }
            view = layoutInflater.inflate(i12, viewGroup, false);
            g0Var = new g0(view);
            view.setTag(g0Var);
        } else {
            g0Var = (g0) view.getTag();
        }
        try {
            a(g0Var, getItem(i11));
        } catch (Exception unused) {
        }
        return view;
    }

    public int getViewTypeCount() {
        return 8;
    }
}
