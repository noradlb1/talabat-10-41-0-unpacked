package zr;

import android.content.Context;
import android.content.DialogInterface;
import com.talabat.helpers.HelpCenterScreenUtils;

public final /* synthetic */ class f implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f63104b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f63105c;

    public /* synthetic */ f(String str, Context context) {
        this.f63104b = str;
        this.f63105c = context;
    }

    public final void onClick(DialogInterface dialogInterface, int i11) {
        HelpCenterScreenUtils.m10624startCall$lambda0(this.f63104b, this.f63105c, dialogInterface, i11);
    }
}
