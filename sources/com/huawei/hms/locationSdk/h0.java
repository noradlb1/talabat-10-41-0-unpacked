package com.huawei.hms.locationSdk;

import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.TaskApiCall;

public abstract class h0<ClientT extends AnyClient, ResultT> extends TaskApiCall<ClientT, ResultT> {

    /* renamed from: a  reason: collision with root package name */
    public final String f49189a;

    public h0(String str, String str2, String str3) {
        super(str, str2);
        this.f49189a = str3;
    }

    public h0(String str, String str2, String str3, String str4) {
        super(str, str2, str4);
        this.f49189a = str3;
    }

    public boolean a(int i11) {
        return i11 >= 8 && ((i11 >> 3) & 1) == 1;
    }
}
