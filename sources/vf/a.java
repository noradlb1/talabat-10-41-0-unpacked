package vf;

import android.app.Activity;
import android.content.DialogInterface;
import com.talabat.collectiondetails.helpers.DarkstoresDelegate;
import datamodels.Restaurant;

public final /* synthetic */ class a implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Activity f57892b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Restaurant f57893c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f57894d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ boolean f57895e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ int f57896f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f57897g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f57898h;

    public /* synthetic */ a(Activity activity, Restaurant restaurant, boolean z11, boolean z12, int i11, String str, String str2) {
        this.f57892b = activity;
        this.f57893c = restaurant;
        this.f57894d = z11;
        this.f57895e = z12;
        this.f57896f = i11;
        this.f57897g = str;
        this.f57898h = str2;
    }

    public final void onClick(DialogInterface dialogInterface, int i11) {
        DarkstoresDelegate.Companion.m9541showStatusAlertForDarkstores$lambda0(this.f57892b, this.f57893c, this.f57894d, this.f57895e, this.f57896f, this.f57897g, this.f57898h, dialogInterface, i11);
    }
}
