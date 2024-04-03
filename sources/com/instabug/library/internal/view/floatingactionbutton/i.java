package com.instabug.library.internal.view.floatingactionbutton;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import com.instabug.library.R;

public abstract class i extends d {
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    public h f51272m;
    @Nullable

    /* renamed from: n  reason: collision with root package name */
    private Paint f51273n;
    @Nullable

    /* renamed from: o  reason: collision with root package name */
    private String f51274o;

    /* renamed from: p  reason: collision with root package name */
    private float f51275p;

    public i(Context context) {
        this(context, (AttributeSet) null);
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public void a(@Nullable String str, boolean z11) {
        if (z11) {
            this.f51274o = str;
            invalidate();
            return;
        }
        super.setText(str);
    }

    public Drawable getIconDrawable() {
        float f11;
        float f12;
        if (getSize() == 0) {
            f12 = j(R.dimen.instabug_fab_size_normal);
            f11 = j(R.dimen.instabug_fab_icon_size_normal);
        } else {
            f12 = j(R.dimen.instabug_fab_size_mini);
            f11 = j(R.dimen.instabug_fab_icon_size_mini);
        }
        ShapeDrawable shapeDrawable = new ShapeDrawable(new g(this, j(R.dimen.instabug_fab_circle_icon_stroke), f11 / 2.0f, f12));
        shapeDrawable.getPaint().setAntiAlias(true);
        return shapeDrawable;
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public void h(Context context, @Nullable AttributeSet attributeSet) {
        super.h(context, attributeSet);
        Paint paint = new Paint(1);
        this.f51273n = paint;
        paint.setColor(-1);
        this.f51273n.setTextAlign(Paint.Align.CENTER);
        this.f51273n.setTextSize(context.getResources().getDimension(R.dimen.instabug_fab_text_size));
        this.f51275p = j(R.dimen.instabug_fab_circle_icon_stroke);
        setTypeface(ResourcesCompat.getFont(context, R.font.ibg_video_icon));
        a("", false);
        setTextColor(-1);
        setGravity(17);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f51274o != null && this.f51273n != null) {
            canvas.drawText(this.f51274o, (float) (canvas.getWidth() / 2), (float) ((int) (((((float) canvas.getHeight()) / 2.0f) - ((this.f51273n.descent() + this.f51273n.ascent()) / 2.0f)) - this.f51275p)), this.f51273n);
        }
    }

    public void setRecordingState(h hVar) {
        this.f51272m = hVar;
        g();
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public i(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
