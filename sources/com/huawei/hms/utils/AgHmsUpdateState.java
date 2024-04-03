package com.huawei.hms.utils;

import com.huawei.hms.common.HmsCheckedState;
import com.huawei.hms.support.log.HMSLog;

public class AgHmsUpdateState {

    /* renamed from: c  reason: collision with root package name */
    private static final Object f49907c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private static volatile AgHmsUpdateState f49908d;

    /* renamed from: a  reason: collision with root package name */
    private HmsCheckedState f49909a = HmsCheckedState.UNCHECKED;

    /* renamed from: b  reason: collision with root package name */
    private int f49910b = 0;

    private AgHmsUpdateState() {
    }

    public static AgHmsUpdateState getInstance() {
        if (f49908d == null) {
            synchronized (f49907c) {
                if (f49908d == null) {
                    f49908d = new AgHmsUpdateState();
                }
            }
        }
        return f49908d;
    }

    public HmsCheckedState getCheckedState() {
        return this.f49909a;
    }

    public int getTargetVersionCode() {
        return this.f49910b;
    }

    public boolean isUpdateHms() {
        return getCheckedState() == HmsCheckedState.NEED_UPDATE && this.f49910b != 0;
    }

    public void resetUpdateState() {
        if (getCheckedState() == HmsCheckedState.NEED_UPDATE) {
            setCheckedState(HmsCheckedState.NOT_NEED_UPDATE);
            setTargetVersionCode(0);
        }
    }

    public void setCheckedState(HmsCheckedState hmsCheckedState) {
        if (hmsCheckedState == null) {
            HMSLog.e("AgHmsUpdateState", "para invalid: checkedState is null");
        } else {
            this.f49909a = hmsCheckedState;
        }
    }

    public void setTargetVersionCode(int i11) {
        this.f49910b = i11;
    }
}
