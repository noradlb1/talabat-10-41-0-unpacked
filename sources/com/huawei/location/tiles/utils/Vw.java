package com.huawei.location.tiles.utils;

import java.util.ArrayList;
import java.util.List;

public class Vw {
    private List<d2> Vw = new ArrayList();

    /* renamed from: yn  reason: collision with root package name */
    private String f50264yn = "XXX-XXX-XXX";

    public boolean Vw(double d11, double d12) {
        boolean z11;
        if (this.Vw.size() < 3) {
            return false;
        }
        for (int i11 = 0; i11 < this.Vw.size(); i11++) {
            if (i11 != this.Vw.size() - 1) {
                double d13 = this.Vw.get(i11).Vw;
                double d14 = this.Vw.get(i11).f50265yn;
                int i12 = i11 + 1;
                if ((d11 - d13) * (d14 - this.Vw.get(i12).f50265yn) == (d13 - this.Vw.get(i12).Vw) * (d12 - d14)) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    return true;
                }
            }
        }
        return false;
    }

    public String yn() {
        return this.f50264yn;
    }

    public void yn(d2 d2Var) {
        this.Vw.add(d2Var);
    }

    public void yn(String str) {
        this.f50264yn = str;
    }

    public boolean yn(double d11, double d12) {
        double d13;
        double d14;
        double d15;
        double d16;
        if (this.Vw.size() < 3) {
            return false;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < this.Vw.size(); i12++) {
            if (i12 != this.Vw.size() - 1) {
                if (i12 == this.Vw.size() - 2) {
                    d16 = this.Vw.get(i12).Vw;
                    d15 = this.Vw.get(i12).f50265yn;
                    d14 = this.Vw.get(0).Vw;
                    d13 = this.Vw.get(0).f50265yn;
                } else {
                    d16 = this.Vw.get(i12).Vw;
                    d15 = this.Vw.get(i12).f50265yn;
                    int i13 = i12 + 1;
                    d14 = this.Vw.get(i13).Vw;
                    d13 = this.Vw.get(i13).f50265yn;
                }
                if ((d12 >= d15 && d12 < d13) || (d12 >= d13 && d12 < d15)) {
                    double d17 = d15 - d13;
                    if (Math.abs(d17) > 0.0d && d16 - (((d16 - d14) * (d15 - d12)) / d17) < d11) {
                        i11++;
                    }
                }
            }
        }
        if (i11 % 2 != 0) {
            return true;
        }
        return false;
    }
}
