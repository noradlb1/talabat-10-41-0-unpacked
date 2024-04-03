package com.huawei.location.logic;

import android.location.Location;
import com.huawei.hms.location.LocationRequest;
import java.io.Serializable;
import java.util.List;

public class E5 implements Serializable {
    private long FB;
    private List<Location> LW;
    private int Vw;

    /* renamed from: yn  reason: collision with root package name */
    private String f50160yn;

    public E5() {
    }

    public E5(String str, int i11, long j11, List<Location> list, LocationRequest locationRequest) {
        this.f50160yn = str;
        this.Vw = i11;
        this.FB = j11;
        this.LW = list;
    }

    public int FB() {
        return this.Vw;
    }

    public String LW() {
        return this.f50160yn;
    }

    public long Vw() {
        return this.FB;
    }

    public List<Location> yn() {
        return this.LW;
    }

    public void yn(long j11) {
        this.FB = j11;
    }

    public void yn(String str) {
        this.f50160yn = str;
    }

    public void yn(List<Location> list) {
        List<Location> list2 = this.LW;
        if (list2 == null) {
            this.LW = list;
        } else {
            list2.addAll(list);
        }
    }
}
