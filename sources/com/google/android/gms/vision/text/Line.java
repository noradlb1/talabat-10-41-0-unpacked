package com.google.android.gms.vision.text;

import android.graphics.Point;
import android.graphics.Rect;
import com.google.android.gms.internal.vision.zzac;
import com.google.android.gms.internal.vision.zzaj;
import java.util.ArrayList;
import java.util.List;

public class Line implements Text {
    private zzac zzdy;
    private List<Element> zzdz;

    public Line(zzac zzac) {
        this.zzdy = zzac;
    }

    public float getAngle() {
        return this.zzdy.zzei.zzeg;
    }

    public Rect getBoundingBox() {
        return zzc.zza((Text) this);
    }

    public List<? extends Text> getComponents() {
        if (this.zzdy.zzeh.length == 0) {
            return new ArrayList(0);
        }
        if (this.zzdz == null) {
            this.zzdz = new ArrayList(this.zzdy.zzeh.length);
            for (zzaj element : this.zzdy.zzeh) {
                this.zzdz.add(new Element(element));
            }
        }
        return this.zzdz;
    }

    public Point[] getCornerPoints() {
        return zzc.zza(this.zzdy.zzei);
    }

    public String getLanguage() {
        return this.zzdy.zzec;
    }

    public String getValue() {
        return this.zzdy.zzel;
    }

    public boolean isVertical() {
        return this.zzdy.zzen;
    }
}
