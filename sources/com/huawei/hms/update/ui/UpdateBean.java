package com.huawei.hms.update.ui;

import java.io.Serializable;
import java.util.ArrayList;

public class UpdateBean implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private boolean f49899a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f49900b;

    /* renamed from: c  reason: collision with root package name */
    private String f49901c;

    /* renamed from: d  reason: collision with root package name */
    private int f49902d;

    /* renamed from: e  reason: collision with root package name */
    private String f49903e;

    /* renamed from: f  reason: collision with root package name */
    private String f49904f;

    /* renamed from: g  reason: collision with root package name */
    private ArrayList f49905g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f49906h = true;

    private static <T> T a(T t11) {
        return t11;
    }

    public String getClientAppId() {
        return (String) a(this.f49903e);
    }

    public String getClientAppName() {
        return (String) a(this.f49904f);
    }

    public String getClientPackageName() {
        return (String) a(this.f49901c);
    }

    public int getClientVersionCode() {
        return ((Integer) a(Integer.valueOf(this.f49902d))).intValue();
    }

    public boolean getResolutionInstallHMS() {
        return this.f49900b;
    }

    public ArrayList getTypeList() {
        return (ArrayList) a(this.f49905g);
    }

    public boolean isHmsOrApkUpgrade() {
        return ((Boolean) a(Boolean.valueOf(this.f49899a))).booleanValue();
    }

    public boolean isNeedConfirm() {
        return ((Boolean) a(Boolean.valueOf(this.f49906h))).booleanValue();
    }

    public void setClientAppId(String str) {
        this.f49903e = str;
    }

    public void setClientAppName(String str) {
        this.f49904f = str;
    }

    public void setClientPackageName(String str) {
        this.f49901c = str;
    }

    public void setClientVersionCode(int i11) {
        this.f49902d = i11;
    }

    public void setHmsOrApkUpgrade(boolean z11) {
        this.f49899a = z11;
    }

    public void setNeedConfirm(boolean z11) {
        this.f49906h = z11;
    }

    public void setResolutionInstallHMS(boolean z11) {
        this.f49900b = z11;
    }

    public void setTypeList(ArrayList arrayList) {
        this.f49905g = arrayList;
    }
}
