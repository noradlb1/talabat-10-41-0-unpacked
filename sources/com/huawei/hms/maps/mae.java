package com.huawei.hms.maps;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.hms.maps.utils.LogM;

public class mae {
    public Drawable a(final View view) {
        return new Drawable() {

            /* renamed from: c  reason: collision with root package name */
            private final Paint f49416c;

            {
                Paint paint = new Paint();
                this.f49416c = paint;
                paint.setStyle(Paint.Style.STROKE);
                paint.setStrokeJoin(Paint.Join.MITER);
                paint.setStrokeCap(Paint.Cap.BUTT);
                paint.setColor(-4342596);
                paint.setAntiAlias(true);
            }

            public void draw(@NonNull Canvas canvas) {
                int width = view.getWidth();
                int height = view.getHeight();
                LogM.d("MapBackground", "drawBackground: h = " + height + "; w = " + width);
                double d11 = (double) 96;
                float f11 = (float) (0.23d * d11);
                float f12 = (float) (d11 * 0.89d);
                float f13 = (float) height;
                float f14 = (float) 96;
                int i11 = (int) ((f13 - f11) / f14);
                for (int i12 = 0; i12 <= i11; i12++) {
                    float f15 = ((float) (i12 * 96)) + f11;
                    canvas.drawLine(0.0f, f15, (float) width, f15, this.f49416c);
                }
                int i13 = (int) ((((float) width) - f12) / f14);
                for (int i14 = 0; i14 <= i13; i14++) {
                    float f16 = ((float) (i14 * 96)) + f12;
                    canvas.drawLine(f16, 0.0f, f16, f13, this.f49416c);
                }
            }

            public int getOpacity() {
                return -3;
            }

            public void setAlpha(int i11) {
            }

            public void setColorFilter(@Nullable ColorFilter colorFilter) {
            }
        };
    }
}
