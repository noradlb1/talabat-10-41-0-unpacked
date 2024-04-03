package com.google.android.gms.vision.text;

import android.graphics.Point;
import android.graphics.Rect;
import android.util.SparseArray;
import com.google.android.exoplayer2.C;
import com.google.android.gms.internal.vision.zzac;
import com.google.android.gms.internal.vision.zzw;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

public class TextBlock implements Text {
    private Point[] cornerPoints;
    private zzac[] zzea;
    private List<Line> zzeb;
    private String zzec;
    private Rect zzed;

    public TextBlock(SparseArray<zzac> sparseArray) {
        this.zzea = new zzac[sparseArray.size()];
        int i11 = 0;
        while (true) {
            zzac[] zzacArr = this.zzea;
            if (i11 < zzacArr.length) {
                zzacArr[i11] = sparseArray.valueAt(i11);
                i11++;
            } else {
                return;
            }
        }
    }

    public Rect getBoundingBox() {
        if (this.zzed == null) {
            this.zzed = zzc.zza((Text) this);
        }
        return this.zzed;
    }

    public List<? extends Text> getComponents() {
        if (this.zzea.length == 0) {
            return new ArrayList(0);
        }
        if (this.zzeb == null) {
            this.zzeb = new ArrayList(this.zzea.length);
            for (zzac line : this.zzea) {
                this.zzeb.add(new Line(line));
            }
        }
        return this.zzeb;
    }

    public Point[] getCornerPoints() {
        zzac[] zzacArr;
        TextBlock textBlock = this;
        if (textBlock.cornerPoints == null) {
            char c11 = 0;
            if (textBlock.zzea.length == 0) {
                textBlock.cornerPoints = new Point[0];
            } else {
                int i11 = Integer.MIN_VALUE;
                int i12 = 0;
                int i13 = Integer.MAX_VALUE;
                int i14 = Integer.MAX_VALUE;
                int i15 = Integer.MIN_VALUE;
                while (true) {
                    zzacArr = textBlock.zzea;
                    if (i12 >= zzacArr.length) {
                        break;
                    }
                    zzw zzw = zzacArr[i12].zzei;
                    zzw zzw2 = zzacArr[c11].zzei;
                    double sin = Math.sin(Math.toRadians((double) zzw2.zzeg));
                    double cos = Math.cos(Math.toRadians((double) zzw2.zzeg));
                    Point[] pointArr = new Point[4];
                    Point point = new Point(zzw.left, zzw.top);
                    pointArr[c11] = point;
                    point.offset(-zzw2.left, -zzw2.top);
                    Point point2 = pointArr[c11];
                    int i16 = point2.x;
                    int i17 = point2.y;
                    int i18 = i15;
                    int i19 = (int) ((((double) i16) * cos) + (((double) i17) * sin));
                    int i21 = (int) ((((double) (-i16)) * sin) + (((double) i17) * cos));
                    point2.x = i19;
                    point2.y = i21;
                    pointArr[1] = new Point(zzw.width + i19, i21);
                    pointArr[2] = new Point(zzw.width + i19, zzw.height + i21);
                    pointArr[3] = new Point(i19, i21 + zzw.height);
                    i15 = i18;
                    i13 = i13;
                    for (int i22 = 0; i22 < 4; i22++) {
                        Point point3 = pointArr[i22];
                        i13 = Math.min(i13, point3.x);
                        i11 = Math.max(i11, point3.x);
                        i14 = Math.min(i14, point3.y);
                        i15 = Math.max(i15, point3.y);
                    }
                    i12++;
                    c11 = 0;
                    textBlock = this;
                }
                int i23 = i15;
                zzw zzw3 = zzacArr[c11].zzei;
                int i24 = zzw3.left;
                int i25 = zzw3.top;
                double sin2 = Math.sin(Math.toRadians((double) zzw3.zzeg));
                double cos2 = Math.cos(Math.toRadians((double) zzw3.zzeg));
                int i26 = i13;
                int i27 = i23;
                Point[] pointArr2 = {new Point(i26, i14), new Point(i11, i14), new Point(i11, i27), new Point(i26, i27)};
                for (int i28 = 0; i28 < 4; i28++) {
                    Point point4 = pointArr2[i28];
                    int i29 = point4.x;
                    int i31 = point4.y;
                    Point point5 = point4;
                    point5.x = (int) ((((double) i29) * cos2) - (((double) i31) * sin2));
                    point5.y = (int) ((((double) i29) * sin2) + (((double) i31) * cos2));
                    point5.offset(i24, i25);
                }
                textBlock = this;
                textBlock.cornerPoints = pointArr2;
            }
        }
        return textBlock.cornerPoints;
    }

    public String getLanguage() {
        int i11;
        String str = this.zzec;
        if (str != null) {
            return str;
        }
        HashMap hashMap = new HashMap();
        for (zzac zzac : this.zzea) {
            if (hashMap.containsKey(zzac.zzec)) {
                i11 = ((Integer) hashMap.get(zzac.zzec)).intValue();
            } else {
                i11 = 0;
            }
            hashMap.put(zzac.zzec, Integer.valueOf(i11 + 1));
        }
        String str2 = (String) ((Map.Entry) Collections.max(hashMap.entrySet(), new zza(this))).getKey();
        this.zzec = str2;
        if (str2 == null || str2.isEmpty()) {
            this.zzec = C.LANGUAGE_UNDETERMINED;
        }
        return this.zzec;
    }

    public String getValue() {
        zzac[] zzacArr = this.zzea;
        if (zzacArr.length == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder(zzacArr[0].zzel);
        for (int i11 = 1; i11 < this.zzea.length; i11++) {
            sb2.append(StringUtils.LF);
            sb2.append(this.zzea[i11].zzel);
        }
        return sb2.toString();
    }
}
