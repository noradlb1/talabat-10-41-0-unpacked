package com.instabug.survey.ui.custom;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import com.instabug.library.Feature;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.survey.R;

public class NpsView extends e {
    @Nullable
    private Typeface G;

    public NpsView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        try {
            this.G = ResourcesCompat.getFont(context, R.font.instabug_custom_font);
        } catch (Resources.NotFoundException unused) {
            InstabugSDKLogger.d("IBG-Surveys", "NPS: font typeface not overridden");
        }
    }

    public NpsView(Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        try {
            this.G = ResourcesCompat.getFont(context, R.font.instabug_custom_font);
        } catch (Resources.NotFoundException unused) {
            InstabugSDKLogger.d("IBG-Surveys", "NPS: font typeface not overridden");
        }
    }

    public NpsView(Context context, @Nullable AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        try {
            this.G = ResourcesCompat.getFont(context, R.font.instabug_custom_font);
        } catch (Resources.NotFoundException unused) {
            InstabugSDKLogger.d("IBG-Surveys", "NPS: font typeface not overridden");
        }
    }

    public void d() {
        this.f52451j.clear();
        int width = getWidth();
        int i11 = this.f52458q;
        this.f52459r = (width - (i11 * 2)) / this.f52445d;
        int i12 = this.f52444c;
        int i13 = i11;
        for (int i14 = 0; i14 < this.f52445d; i14++) {
            i13 += this.f52459r;
            this.f52451j.add(new Rect(i11, 0, i13, i12));
            i11 += this.f52459r;
        }
    }

    public void f(Canvas canvas) {
        Typeface typeface;
        int width = (getWidth() - (this.f52458q * 2)) / this.f52445d;
        int round = (int) (((float) Math.round(((double) this.f52460s) / 1.3d)) + e.a(getContext(), 8.0f));
        this.f52462u.setColor(getNumbersColor());
        this.f52462u.setTextSize(this.E);
        this.f52462u.setStyle(Paint.Style.FILL);
        this.f52462u.setFakeBoldText(true);
        if (!InstabugCore.isFeatureEnabled(Feature.CUSTOM_FONT) || (typeface = this.G) == null) {
            this.f52462u.setTypeface(Typeface.defaultFromStyle(0));
        } else {
            this.f52462u.setTypeface(typeface);
        }
        int i11 = (width / 2) + this.f52458q;
        float measureText = this.f52462u.measureText("9", 0, 1) / 2.0f;
        int i12 = (int) (((float) i11) - measureText);
        if (this.f52450i) {
            for (int i13 = this.f52445d - 1; i13 >= 0; i13--) {
                if (i13 == 10) {
                    i12 = (int) (((float) ((int) (((float) i12) + measureText))) - (this.f52462u.measureText("10", 0, 2) / 2.0f));
                }
                canvas.drawText(String.valueOf(i13), (float) i12, (float) round, this.f52462u);
                i12 += width;
            }
            return;
        }
        for (int i14 = 0; i14 < this.f52445d; i14++) {
            if (i14 == 10) {
                i12 = (int) (((float) ((int) (((float) i12) + measureText))) - (this.f52462u.measureText("10", 0, 2) / 2.0f));
            }
            canvas.drawText(String.valueOf(i14), (float) i12, (float) round, this.f52462u);
            i12 += width;
        }
    }

    public void g(Canvas canvas) {
        this.f52467z.rewind();
        this.f52467z.moveTo((float) this.f52458q, (float) ((int) Math.floor(((double) this.f52460s) / 1.7d)));
        this.f52467z.lineTo((float) this.f52458q, (float) this.f52460s);
        this.f52467z.lineTo((float) (getWidth() - this.f52458q), (float) this.f52460s);
        this.f52467z.lineTo((float) (getWidth() - this.f52458q), (float) ((int) Math.floor(((double) this.f52460s) / 1.7d)));
        this.f52467z.close();
        this.f52463v.setStyle(Paint.Style.FILL);
        this.f52463v.setColor(getCirclesRectColor());
        this.f52463v.setPathEffect(this.D);
        canvas.drawPath(this.f52467z, this.f52463v);
    }

    public void h(Canvas canvas) {
        if (this.f52446e != -1) {
            this.B.reset();
            this.f52464w.setColor(getIndicatorViewBackgroundColor());
            int i11 = ((Rect) this.f52451j.get(this.f52446e)).left;
            int i12 = ((Rect) this.f52451j.get(this.f52446e)).right;
            int i13 = this.f52459r;
            int i14 = this.f52461t;
            if (i13 > i14) {
                int i15 = (i13 - i14) / 2;
                i11 += i15;
                i12 -= i15;
            }
            float f11 = (float) i11;
            this.B.moveTo(f11, ((float) this.f52460s) / 1.7f);
            this.B.lineTo(f11, (float) this.f52460s);
            float f12 = (float) i12;
            this.B.lineTo(f12, (float) this.f52460s);
            this.B.lineTo(f12, ((float) this.f52460s) / 1.7f);
            this.B.close();
            canvas.drawPath(this.B, this.f52464w);
            float f13 = ((float) this.f52460s) / 1.3f;
            float a11 = e.a(getContext(), 4.0f);
            if (((float) (((Rect) this.f52451j.get(this.f52446e)).right - ((Rect) this.f52451j.get(this.f52446e)).left)) > ((float) this.f52460s) / 1.7f) {
                a11 /= 1.5f;
            }
            this.f52465x.setColor(getIndicatorViewCircleColor());
            canvas.drawCircle((float) (i11 + ((i12 - i11) / 2)), f13 + e.a(getContext(), 4.0f), a11, this.f52465x);
        }
    }

    public boolean i() {
        return true;
    }

    public boolean j() {
        return true;
    }
}
