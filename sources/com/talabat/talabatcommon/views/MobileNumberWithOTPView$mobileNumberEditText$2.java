package com.talabat.talabatcommon.views;

import com.talabat.talabatcommon.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/talabat/talabatcommon/views/MobileNumberEditText;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class MobileNumberWithOTPView$mobileNumberEditText$2 extends Lambda implements Function0<MobileNumberEditText> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MobileNumberWithOTPView f11706g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MobileNumberWithOTPView$mobileNumberEditText$2(MobileNumberWithOTPView mobileNumberWithOTPView) {
        super(0);
        this.f11706g = mobileNumberWithOTPView;
    }

    public final MobileNumberEditText invoke() {
        return (MobileNumberEditText) this.f11706g.findViewById(R.id.edtMobileNumber);
    }
}
