package com.talabat.userandlocation.login.ui;

import com.designsystem.ds_bottom_sheet.DSBottomSheet;
import com.talabat.userandlocation.login.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/designsystem/ds_bottom_sheet/DSBottomSheet;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class LoginOptionsBottomSheet$bottomSheet$2 extends Lambda implements Function0<DSBottomSheet> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LoginOptionsBottomSheet f12391g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LoginOptionsBottomSheet$bottomSheet$2(LoginOptionsBottomSheet loginOptionsBottomSheet) {
        super(0);
        this.f12391g = loginOptionsBottomSheet;
    }

    @NotNull
    public final DSBottomSheet invoke() {
        return DSBottomSheet.Companion.newInstance(this.f12391g, R.layout.layout_login_bottom_sheet);
    }
}
