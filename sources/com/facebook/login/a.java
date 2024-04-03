package com.facebook.login;

import android.content.DialogInterface;
import com.facebook.login.DeviceAuthDialog;
import java.util.Date;

public final /* synthetic */ class a implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DeviceAuthDialog f33602b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f33603c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ DeviceAuthDialog.PermissionsLists f33604d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f33605e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Date f33606f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Date f33607g;

    public /* synthetic */ a(DeviceAuthDialog deviceAuthDialog, String str, DeviceAuthDialog.PermissionsLists permissionsLists, String str2, Date date, Date date2) {
        this.f33602b = deviceAuthDialog;
        this.f33603c = str;
        this.f33604d = permissionsLists;
        this.f33605e = str2;
        this.f33606f = date;
        this.f33607g = date2;
    }

    public final void onClick(DialogInterface dialogInterface, int i11) {
        DeviceAuthDialog.m8990presentConfirmation$lambda6(this.f33602b, this.f33603c, this.f33604d, this.f33605e, this.f33606f, this.f33607g, dialogInterface, i11);
    }
}
