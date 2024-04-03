package uv;

import android.view.View;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.views.AddVoucherCodeView;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f24127b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AddVoucherCodeView f24128c;

    public /* synthetic */ a(Function1 function1, AddVoucherCodeView addVoucherCodeView) {
        this.f24127b = function1;
        this.f24128c = addVoucherCodeView;
    }

    public final void onClick(View view) {
        AddVoucherCodeView.m5781setupAddVoucherCodeView$lambda0(this.f24127b, this.f24128c, view);
    }
}
