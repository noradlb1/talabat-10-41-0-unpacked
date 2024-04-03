package ue;

import android.content.Intent;
import com.talabat.userandlocation.compliance.verification.ui.fragment.ComplianceUserVerificationExtras;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class u9 implements Function1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f57776b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f57777c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f57778d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f57779e;

    public /* synthetic */ u9(String str, String str2, String str3, String str4) {
        this.f57776b = str;
        this.f57777c = str2;
        this.f57778d = str3;
        this.f57779e = str4;
    }

    public final Object invoke(Object obj) {
        return ((Intent) obj).putExtra("extras", new ComplianceUserVerificationExtras(this.f57776b, this.f57777c, this.f57778d, this.f57779e));
    }
}
