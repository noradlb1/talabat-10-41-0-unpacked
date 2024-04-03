package qj;

import android.app.Activity;
import android.content.DialogInterface;
import com.talabat.darkstores.helper.DarkstoresDelegate;
import datamodels.Restaurant;

public final /* synthetic */ class a implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Activity f57259b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Restaurant f57260c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f57261d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ boolean f57262e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ int f57263f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f57264g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f57265h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f57266i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f57267j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f57268k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ String f57269l;

    public /* synthetic */ a(Activity activity, Restaurant restaurant, boolean z11, boolean z12, int i11, String str, String str2, String str3, String str4, String str5, String str6) {
        this.f57259b = activity;
        this.f57260c = restaurant;
        this.f57261d = z11;
        this.f57262e = z12;
        this.f57263f = i11;
        this.f57264g = str;
        this.f57265h = str2;
        this.f57266i = str3;
        this.f57267j = str4;
        this.f57268k = str5;
        this.f57269l = str6;
    }

    public final void onClick(DialogInterface dialogInterface, int i11) {
        DarkstoresDelegate.Companion.m10097showStatusAlertForDarkstores$lambda0(this.f57259b, this.f57260c, this.f57261d, this.f57262e, this.f57263f, this.f57264g, this.f57265h, this.f57266i, this.f57267j, this.f57268k, this.f57269l, dialogInterface, i11);
    }
}
