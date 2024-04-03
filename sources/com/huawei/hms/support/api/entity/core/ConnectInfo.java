package com.huawei.hms.support.api.entity.core;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.api.entity.auth.Scope;
import java.util.List;

public class ConnectInfo implements IMessageEntity {
    @Packed

    /* renamed from: a  reason: collision with root package name */
    private List<String> f49830a;
    @Packed

    /* renamed from: b  reason: collision with root package name */
    private List<Scope> f49831b;
    @Packed

    /* renamed from: c  reason: collision with root package name */
    private String f49832c;
    @Packed

    /* renamed from: d  reason: collision with root package name */
    private String f49833d;

    public ConnectInfo() {
    }

    public List<String> getApiNameList() {
        return this.f49830a;
    }

    public String getFingerprint() {
        return this.f49832c;
    }

    public List<Scope> getScopeList() {
        return this.f49831b;
    }

    public String getSubAppID() {
        return this.f49833d;
    }

    public void setApiNameList(List<String> list) {
        this.f49830a = list;
    }

    public void setFingerprint(String str) {
        this.f49832c = str;
    }

    public void setScopeList(List<Scope> list) {
        this.f49831b = list;
    }

    public void setSubAppID(String str) {
        this.f49833d = str;
    }

    public ConnectInfo(List<String> list, List<Scope> list2, String str, String str2) {
        this.f49830a = list;
        this.f49831b = list2;
        this.f49832c = str;
        this.f49833d = str2;
    }
}
