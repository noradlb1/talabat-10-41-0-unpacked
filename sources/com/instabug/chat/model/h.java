package com.instabug.chat.model;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;

public class h implements Comparator, Serializable {

    /* renamed from: a  reason: collision with root package name */
    private int f46045a;

    public h() {
        this.f46045a = 2;
    }

    public h(int i11) {
        this.f46045a = i11;
    }

    /* renamed from: a */
    public int compare(k kVar, k kVar2) {
        if (kVar == null || kVar2 == null) {
            return 0;
        }
        int i11 = this.f46045a;
        if (i11 != 1) {
            if (i11 != 2) {
                throw new IllegalStateException("Message comparator wasn't provided comparison messageIssueType");
            }
        } else if (!(kVar.d() == null || kVar2.d() == null)) {
            return kVar.d().compareTo(kVar2.d());
        }
        return new Date(kVar.i()).compareTo(new Date(kVar2.i()));
    }
}
