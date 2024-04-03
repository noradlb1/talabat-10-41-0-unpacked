package com.instabug.survey.announcements.ui.fragment.whatsnew;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.instabug.library.util.BitmapUtils;
import com.instabug.survey.R;
import com.instabug.survey.announcements.models.c;
import com.instabug.survey.announcements.models.e;
import org.jetbrains.annotations.NotNull;

public class b extends RecyclerView.Adapter {

    /* renamed from: a  reason: collision with root package name */
    private final LayoutInflater f52294a;

    /* renamed from: b  reason: collision with root package name */
    private c f52295b;

    public class a extends RecyclerView.ViewHolder {
        @Nullable

        /* renamed from: h  reason: collision with root package name */
        public TextView f52296h;
        @Nullable

        /* renamed from: i  reason: collision with root package name */
        public TextView f52297i;
        @Nullable

        /* renamed from: j  reason: collision with root package name */
        public ImageView f52298j;

        public a(@NonNull b bVar, View view) {
            super(view);
            this.f52296h = (TextView) view.findViewById(R.id.new_feature_title);
            this.f52297i = (TextView) view.findViewById(R.id.new_feature_description);
            this.f52298j = (ImageView) view.findViewById(R.id.new_feature_img);
        }
    }

    public b(Activity activity, c cVar) {
        this.f52294a = LayoutInflater.from(activity);
        this.f52295b = cVar;
    }

    @Nullable
    private e a(int i11) {
        if (this.f52295b.e() == null) {
            return null;
        }
        return (e) this.f52295b.e().get(i11);
    }

    private void a(@NonNull a aVar, int i11) {
        c cVar;
        if (a(i11) != null && (cVar = this.f52295b) != null) {
            if (cVar.j()) {
                ImageView imageView = aVar.f52298j;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    return;
                }
                return;
            }
            String a11 = com.instabug.survey.announcements.cache.e.a(this.f52295b.d(), a(i11).c());
            ImageView imageView2 = aVar.f52298j;
            if (imageView2 == null) {
                return;
            }
            if (a11 != null) {
                BitmapUtils.loadBitmapWithFallback(a11, imageView2, R.drawable.ibg_survey_ic_star_icon_placholder);
            } else {
                imageView2.setImageResource(R.drawable.ibg_survey_ic_star_icon_placholder);
            }
        }
    }

    private void c(@NonNull a aVar, int i11) {
        if (a(i11) != null) {
            TextView textView = aVar.f52296h;
            String str = "";
            if (textView != null) {
                textView.setText(a(i11).d() != null ? a(i11).d() : str);
            }
            TextView textView2 = aVar.f52297i;
            if (textView2 != null) {
                if (a(i11).a() != null) {
                    str = a(i11).a();
                }
                textView2.setText(str);
            }
        }
    }

    @NotNull
    /* renamed from: a */
    public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i11) {
        return new a(this, this.f52294a.inflate(R.layout.instabug_announcement_new_feature_item, viewGroup, false));
    }

    /* renamed from: b */
    public void onBindViewHolder(@NonNull a aVar, int i11) {
        c(aVar, i11);
        a(aVar, i11);
    }

    public int getItemCount() {
        c cVar = this.f52295b;
        if (cVar == null || cVar.e() == null) {
            return 0;
        }
        return this.f52295b.e().size();
    }

    public long getItemId(int i11) {
        return (long) i11;
    }
}
