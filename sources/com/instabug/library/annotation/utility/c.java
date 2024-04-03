package com.instabug.library.annotation.utility;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.ArrayList;
import java.util.List;

public abstract class c {
    public static void a(Canvas canvas, PointF pointF, PointF pointF2, Paint paint) {
        canvas.drawLine(pointF.x, pointF.y, pointF2.x, pointF2.y, paint);
    }

    public static double b(double[] dArr, double[] dArr2, double[] dArr3) {
        return Math.abs(a(dArr, dArr2, dArr3) / a(dArr, dArr2));
    }

    public static float a(float f11, float f12, float f13, float f14) {
        return (float) Math.toDegrees(Math.atan2((double) (f12 - f14), (double) (f11 - f13)));
    }

    public static void a(float f11, float f12, PointF pointF, PointF pointF2) {
        double d11 = (double) f11;
        double d12 = (((double) f12) * 3.141592653589793d) / 180.0d;
        pointF2.x = ((float) (Math.cos(d12) * d11)) + pointF.x;
        pointF2.y = ((float) (d11 * Math.sin(d12))) + pointF.y;
    }

    public static PointF a(float f11, float f12, PointF pointF) {
        PointF pointF2 = new PointF();
        a(f11, f12, pointF, pointF2);
        return pointF2;
    }

    public static PointF a(float f11, float f12, float f13, PointF pointF) {
        PointF pointF2 = pointF;
        double d11 = (((double) f13) * 3.141592653589793d) / 180.0d;
        double sin = Math.sin(d11);
        double cos = Math.cos(d11);
        double d12 = (double) (pointF2.x - f11);
        double d13 = (double) (pointF2.y - f12);
        pointF2.x = ((float) ((d12 * cos) - (d13 * sin))) + f11;
        pointF2.y = ((float) ((d12 * sin) + (d13 * cos))) + f12;
        return pointF2;
    }

    public static double a(double[] dArr, double[] dArr2, double[] dArr3) {
        double[] dArr4 = {dArr2[0] - dArr[0], dArr2[1] - dArr[1]};
        double d11 = dArr3[0] - dArr[0];
        return (dArr4[0] * (dArr3[1] - dArr[1])) - (dArr4[1] * d11);
    }

    public static double a(double[] dArr, double[] dArr2) {
        double d11 = dArr[0] - dArr2[0];
        double d12 = dArr[1] - dArr2[1];
        return Math.sqrt((d11 * d11) + (d12 * d12));
    }

    public static double a(PointF pointF, PointF pointF2, PointF pointF3) {
        return b(new double[]{(double) pointF.x, (double) pointF.y}, new double[]{(double) pointF2.x, (double) pointF2.y}, new double[]{(double) pointF3.x, (double) pointF3.y});
    }

    public static PointF a(PointF pointF, PointF pointF2) {
        PointF pointF3 = new PointF();
        pointF3.x = (pointF.x + pointF2.x) / 2.0f;
        pointF3.y = (pointF.y + pointF2.y) / 2.0f;
        return pointF3;
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public static List a(Path path) {
        ArrayList arrayList = new ArrayList();
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        float[] fArr = new float[2];
        int i11 = 0;
        while (true) {
            float f11 = (float) i11;
            if (f11 >= length) {
                return arrayList;
            }
            pathMeasure.getPosTan(f11, fArr, (float[]) null);
            arrayList.add(new PointF(fArr[0], fArr[1]));
            i11++;
        }
    }
}
