package com.instabug.bug.view.visualusersteps.visitedscreens;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.instabug.bug.R;
import com.instabug.bug.model.f;
import com.instabug.library.InstabugCustomTextPlaceHolder;
import com.instabug.library.util.PlaceHolderUtils;

@SuppressLint({"ERADICATE_FIELD_NOT_INITIALIZED"})
public class b extends RecyclerView.ViewHolder implements View.OnClickListener {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f45961a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public final TextView f45962b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final ImageView f45963c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final TextView f45964d;

    /* renamed from: e  reason: collision with root package name */
    private final d f45965e;

    /* renamed from: f  reason: collision with root package name */
    private f f45966f;

    /* renamed from: g  reason: collision with root package name */
    private String f45967g;

    public b(@NonNull View view, d dVar) {
        super(view);
        this.f45962b = (TextView) view.findViewById(R.id.ib_bug_repro_step_title);
        this.f45964d = (TextView) view.findViewById(R.id.ib_bug_repro_step_sub_title);
        this.f45963c = (ImageView) view.findViewById(R.id.ib_bug_repro_step_screenshot);
        this.f45961a = (ImageView) view.findViewById(R.id.ib_bug_repro_step_delete);
        this.f45965e = dVar;
    }

    @NonNull
    private String a(String str) {
        ImageView imageView = this.f45961a;
        if (imageView == null) {
            return "";
        }
        return imageView.getContext().getString(R.string.ibg_bug_visited_screen_delete_btn_content_description, new Object[]{this.f45967g, str});
    }

    public void b(f fVar) {
        this.f45966f = fVar;
        this.f45967g = String.format("%s%s", new Object[]{PlaceHolderUtils.getPlaceHolder(this.itemView.getContext(), InstabugCustomTextPlaceHolder.Key.REPRO_STEPS_LIST_ITEM_NUMBERING_TITLE, R.string.IBGReproStepsListItemName), Integer.valueOf(fVar.b())});
        String a11 = fVar.a() != null ? fVar.a() : "";
        TextView textView = this.f45962b;
        if (textView != null) {
            textView.setText(this.f45967g);
        }
        TextView textView2 = this.f45964d;
        if (textView2 != null) {
            textView2.setText(a11);
        }
        ImageView imageView = this.f45963c;
        if (imageView != null) {
            imageView.setImageBitmap(fVar.c());
        }
        this.itemView.setOnClickListener(this);
        if (this.f45961a != null) {
            this.f45961a.setContentDescription(a(a11));
            this.f45961a.setOnClickListener(this);
        }
    }

    public void onClick(View view) {
        if (view == this.itemView) {
            this.f45965e.b(new com.instabug.bug.view.visualusersteps.steppreview.b(this.f45967g, this.f45966f.e(), this.f45966f.a() != null ? this.f45966f.a() : this.f45967g));
        } else if (view.getId() == R.id.ib_bug_repro_step_delete) {
            this.f45965e.a(getAdapterPosition(), this.f45966f);
        }
    }
}
