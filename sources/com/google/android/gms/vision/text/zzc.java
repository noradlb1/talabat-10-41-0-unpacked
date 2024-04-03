package com.google.android.gms.vision.text;

import android.graphics.Point;
import android.graphics.Rect;
import com.google.android.gms.internal.vision.zzw;

final class zzc {
    public static Rect zza(Text text) {
        int i11 = Integer.MAX_VALUE;
        int i12 = Integer.MIN_VALUE;
        int i13 = Integer.MAX_VALUE;
        int i14 = Integer.MIN_VALUE;
        for (Point point : text.getCornerPoints()) {
            i11 = Math.min(i11, point.x);
            i14 = Math.max(i14, point.x);
            i13 = Math.min(i13, point.y);
            i12 = Math.max(i12, point.y);
        }
        return new Rect(i11, i13, i14, i12);
    }

    public static Point[] zza(zzw zzw) {
        Point[] pointArr = new Point[4];
        double sin = Math.sin(Math.toRadians((double) zzw.zzeg));
        double cos = Math.cos(Math.toRadians((double) zzw.zzeg));
        pointArr[0] = new Point(zzw.left, zzw.top);
        int i11 = zzw.width;
        pointArr[1] = new Point((int) (((double) zzw.left) + (((double) i11) * cos)), (int) (((double) zzw.top) + (((double) i11) * sin)));
        Point point = pointArr[1];
        int i12 = zzw.height;
        pointArr[2] = new Point((int) (((double) point.x) - (((double) i12) * sin)), (int) (((double) point.y) + (((double) i12) * cos)));
        Point point2 = pointArr[0];
        int i13 = point2.x;
        Point point3 = pointArr[2];
        int i14 = point3.x;
        Point point4 = pointArr[1];
        pointArr[3] = new Point(i13 + (i14 - point4.x), point2.y + (point3.y - point4.y));
        return pointArr;
    }
}
