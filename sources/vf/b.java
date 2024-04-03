package vf;

import android.app.Activity;
import android.content.DialogInterface;
import com.talabat.collectiondetails.helpers.DarkstoresDelegate;

public final /* synthetic */ class b implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f57899b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Activity f57900c;

    public /* synthetic */ b(boolean z11, Activity activity) {
        this.f57899b = z11;
        this.f57900c = activity;
    }

    public final void onClick(DialogInterface dialogInterface, int i11) {
        DarkstoresDelegate.Companion.m9542showStatusAlertForDarkstores$lambda1(this.f57899b, this.f57900c, dialogInterface, i11);
    }
}
