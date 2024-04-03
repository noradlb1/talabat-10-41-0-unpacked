package com.instabug.library.annotation.recognition;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.instabug.library.annotation.utility.c;
import java.util.ArrayList;
import java.util.List;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private static List f34129a;

    /* renamed from: b  reason: collision with root package name */
    private static List f34130b;

    public static Path a() {
        PointF pointF = new PointF(0.0f, 14.0f);
        PointF pointF2 = new PointF(28.0f, 14.0f);
        float a11 = c.a(pointF2.x, pointF2.y, pointF.x, pointF.y);
        PointF a12 = c.a(9.0f, 225.0f + a11, pointF2);
        PointF a13 = c.a(9.0f, a11 + 135.0f, pointF2);
        Path path = new Path();
        path.moveTo(pointF.x, pointF.y);
        path.lineTo(pointF2.x, pointF2.y);
        path.moveTo(a12.x, a12.y);
        path.lineTo(pointF2.x, pointF2.y);
        path.lineTo(a13.x, a13.y);
        return path;
    }

    @Nullable
    public static List a(e eVar) {
        if (eVar == e.RECT) {
            List list = f34129a;
            if (list != null) {
                return list;
            }
            f34129a = new ArrayList();
        } else if (eVar == e.OVAL) {
            List list2 = f34130b;
            if (list2 != null) {
                return list2;
            }
            f34130b = new ArrayList();
        }
        RectF rectF = new RectF(0.0f, 0.0f, 28.0f, 28.0f);
        for (int i11 = 0; i11 < 12; i11++) {
            d dVar = new d();
            rectF.left += 1.0f;
            rectF.right -= 1.0f;
            if (eVar == e.RECT) {
                dVar.f34134a.addRect(rectF, Path.Direction.CW);
                f34129a.add(dVar);
            } else if (eVar == e.OVAL) {
                dVar.f34134a.addOval(rectF, Path.Direction.CW);
                f34130b.add(dVar);
            }
            dVar.f34135b = rectF.left / 28.0f;
        }
        if (eVar == e.RECT) {
            return f34129a;
        }
        if (eVar == e.OVAL) {
            return f34130b;
        }
        return null;
    }
}
