package qj;

import android.app.Activity;
import android.content.DialogInterface;
import com.talabat.darkstores.helper.DarkstoresDelegate;

public final /* synthetic */ class b implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f57270b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Activity f57271c;

    public /* synthetic */ b(boolean z11, Activity activity) {
        this.f57270b = z11;
        this.f57271c = activity;
    }

    public final void onClick(DialogInterface dialogInterface, int i11) {
        DarkstoresDelegate.Companion.m10098showStatusAlertForDarkstores$lambda1(this.f57270b, this.f57271c, dialogInterface, i11);
    }
}
