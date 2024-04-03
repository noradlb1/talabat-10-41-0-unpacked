package com.talabat;

import com.facebook.AccessToken;
import com.talabat.LoginScreen;
import com.talabat.user.status.domain.repository.IsUserRegisteredRepository;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class p implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoginScreen.AnonymousClass7.AnonymousClass1 f56671b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f56672c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ AccessToken f56673d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f56674e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ String f56675f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f56676g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f56677h;

    public /* synthetic */ p(LoginScreen.AnonymousClass7.AnonymousClass1 r12, String str, AccessToken accessToken, String str2, String str3, String str4, String str5) {
        this.f56671b = r12;
        this.f56672c = str;
        this.f56673d = accessToken;
        this.f56674e = str2;
        this.f56675f = str3;
        this.f56676g = str4;
        this.f56677h = str5;
    }

    public final void accept(Object obj) {
        this.f56671b.lambda$onCompleted$0(this.f56672c, this.f56673d, this.f56674e, this.f56675f, this.f56676g, this.f56677h, (IsUserRegisteredRepository.Status) obj);
    }
}
