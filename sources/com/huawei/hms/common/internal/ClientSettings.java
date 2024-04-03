package com.huawei.hms.common.internal;

import android.app.Activity;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import java.lang.ref.WeakReference;
import java.util.List;

public class ClientSettings {

    /* renamed from: a  reason: collision with root package name */
    private String f48160a;

    /* renamed from: b  reason: collision with root package name */
    private String f48161b;

    /* renamed from: c  reason: collision with root package name */
    private List<Scope> f48162c;

    /* renamed from: d  reason: collision with root package name */
    private String f48163d;

    /* renamed from: e  reason: collision with root package name */
    private List<String> f48164e;

    /* renamed from: f  reason: collision with root package name */
    private String f48165f;

    /* renamed from: g  reason: collision with root package name */
    private SubAppInfo f48166g;

    /* renamed from: h  reason: collision with root package name */
    private WeakReference<Activity> f48167h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f48168i;

    /* renamed from: j  reason: collision with root package name */
    private String f48169j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f48170k;

    public ClientSettings(String str, String str2, List<Scope> list, String str3, List<String> list2) {
        this.f48160a = str;
        this.f48161b = str2;
        this.f48162c = list;
        this.f48163d = str3;
        this.f48164e = list2;
    }

    public List<String> getApiName() {
        return this.f48164e;
    }

    public String getAppID() {
        return this.f48163d;
    }

    public String getClientClassName() {
        return this.f48161b;
    }

    public String getClientPackageName() {
        return this.f48160a;
    }

    public Activity getCpActivity() {
        WeakReference<Activity> weakReference = this.f48167h;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public String getCpID() {
        return this.f48165f;
    }

    public String getInnerHmsPkg() {
        return this.f48169j;
    }

    public List<Scope> getScopes() {
        return this.f48162c;
    }

    public SubAppInfo getSubAppID() {
        return this.f48166g;
    }

    public boolean isHasActivity() {
        return this.f48168i;
    }

    public boolean isUseInnerHms() {
        return this.f48170k;
    }

    public void setApiName(List<String> list) {
        this.f48164e = list;
    }

    public void setAppID(String str) {
        this.f48163d = str;
    }

    public void setClientClassName(String str) {
        this.f48161b = str;
    }

    public void setClientPackageName(String str) {
        this.f48160a = str;
    }

    public void setCpActivity(Activity activity) {
        this.f48167h = new WeakReference<>(activity);
        this.f48168i = true;
    }

    public void setCpID(String str) {
        this.f48165f = str;
    }

    public void setInnerHmsPkg(String str) {
        this.f48169j = str;
    }

    public void setScopes(List<Scope> list) {
        this.f48162c = list;
    }

    public void setSubAppId(SubAppInfo subAppInfo) {
        this.f48166g = subAppInfo;
    }

    public void setUseInnerHms(boolean z11) {
        this.f48170k = z11;
    }

    public ClientSettings(String str, String str2, List<Scope> list, String str3, List<String> list2, SubAppInfo subAppInfo) {
        this(str, str2, list, str3, list2);
        this.f48166g = subAppInfo;
    }
}
