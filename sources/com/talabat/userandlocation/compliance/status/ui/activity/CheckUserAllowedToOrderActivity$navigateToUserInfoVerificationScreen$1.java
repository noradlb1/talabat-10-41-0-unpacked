package com.talabat.userandlocation.compliance.status.ui.activity;

import android.content.Intent;
import com.talabat.userandlocation.compliance.status.presentation.displaymodel.UserVerificationDisplayModel;
import com.talabat.userandlocation.compliance.verification.ui.fragment.ComplianceUserVerificationExtras;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroid/content/Intent;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class CheckUserAllowedToOrderActivity$navigateToUserInfoVerificationScreen$1 extends Lambda implements Function1<Intent, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ UserVerificationDisplayModel f12300g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CheckUserAllowedToOrderActivity$navigateToUserInfoVerificationScreen$1(UserVerificationDisplayModel userVerificationDisplayModel) {
        super(1);
        this.f12300g = userVerificationDisplayModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Intent) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "$this$null");
        intent.putExtra("extras", new ComplianceUserVerificationExtras(this.f12300g.getFirstName(), this.f12300g.getLastName(), this.f12300g.getDateOfBirth(), this.f12300g.getEmail(), this.f12300g.getMobileNumber(), ComplianceUserVerificationExtras.Mode.EXISTING_USER, true));
    }
}
