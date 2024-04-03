package com.instabug.featuresrequest.models;

public enum b {
    Open(0),
    Planned(1),
    InProgress(2),
    Completed(3),
    MaybeLater(4);
    

    /* renamed from: a  reason: collision with root package name */
    private int f46533a;

    private b(int i11) {
        this.f46533a = i11;
    }

    public int a() {
        return this.f46533a;
    }
}
