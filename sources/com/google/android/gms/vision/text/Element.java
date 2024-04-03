package com.google.android.gms.vision.text;

import android.graphics.Point;
import android.graphics.Rect;
import com.google.android.gms.internal.vision.zzaj;
import java.util.ArrayList;
import java.util.List;

public class Element implements Text {
    private zzaj zzdx;

    public Element(zzaj zzaj) {
        this.zzdx = zzaj;
    }

    public Rect getBoundingBox() {
        return zzc.zza((Text) this);
    }

    public List<? extends Text> getComponents() {
        return new ArrayList();
    }

    public Point[] getCornerPoints() {
        return zzc.zza(this.zzdx.zzei);
    }

    public String getLanguage() {
        return this.zzdx.zzec;
    }

    public String getValue() {
        return this.zzdx.zzel;
    }
}
