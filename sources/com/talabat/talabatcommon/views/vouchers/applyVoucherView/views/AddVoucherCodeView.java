package com.talabat.talabatcommon.views.vouchers.applyVoucherView.views;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.talabat.talabatcommon.R;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import uv.a;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\r\u0010\u000b\u001a\u00020\fH\u0000¢\u0006\u0002\b\rJ\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\fH\u0002J!\u0010\u0011\u001a\u00020\f2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\f0\u0013H\u0000¢\u0006\u0002\b\u0014J\b\u0010\u0015\u001a\u00020\fH\u0002¨\u0006\u0016"}, d2 = {"Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/views/AddVoucherCodeView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "clearCode", "", "clearCode$com_talabat_NewArchi_TalabatCommon_TalabatCommon", "getVoucherCode", "", "handleVoucherCodeSubmitButton", "setupAddVoucherCodeView", "submitVoucherCodeBlock", "Lkotlin/Function1;", "setupAddVoucherCodeView$com_talabat_NewArchi_TalabatCommon_TalabatCommon", "setupUi", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AddVoucherCodeView extends FrameLayout {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AddVoucherCodeView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R.layout.add_voucher_code_view, this, true);
        setupUi();
    }

    private final String getVoucherCode() {
        return ((EditText) _$_findCachedViewById(R.id.voucherCodeEditText)).getText().toString();
    }

    private final void handleVoucherCodeSubmitButton() {
        ((EditText) _$_findCachedViewById(R.id.voucherCodeEditText)).addTextChangedListener(new AddVoucherCodeView$handleVoucherCodeSubmitButton$1(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: setupAddVoucherCodeView$lambda-0  reason: not valid java name */
    public static final void m5781setupAddVoucherCodeView$lambda0(Function1 function1, AddVoucherCodeView addVoucherCodeView, View view) {
        Context context;
        Intrinsics.checkNotNullParameter(function1, "$submitVoucherCodeBlock");
        Intrinsics.checkNotNullParameter(addVoucherCodeView, "this$0");
        if (!(view == null || (context = view.getContext()) == null)) {
            AddVoucherCodeViewKt.hideKeyboard(context, view);
        }
        function1.invoke(addVoucherCodeView.getVoucherCode());
    }

    private final void setupUi() {
        handleVoucherCodeSubmitButton();
        ((EditText) _$_findCachedViewById(R.id.voucherCodeEditText)).setFilters(new InputFilter[]{new InputFilter.AllCaps()});
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i11) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i11));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i11);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i11), findViewById);
        return findViewById;
    }

    public final void clearCode$com_talabat_NewArchi_TalabatCommon_TalabatCommon() {
        ((EditText) _$_findCachedViewById(R.id.voucherCodeEditText)).setText("");
    }

    public final void setupAddVoucherCodeView$com_talabat_NewArchi_TalabatCommon_TalabatCommon(@NotNull Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "submitVoucherCodeBlock");
        int i11 = R.id.voucherCodeSubmitButton;
        ((TextView) _$_findCachedViewById(i11)).setOnClickListener(new a(function1, this));
        Editable text = ((EditText) _$_findCachedViewById(R.id.voucherCodeEditText)).getText();
        Intrinsics.checkNotNullExpressionValue(text, "voucherCodeEditText.text");
        if (StringsKt__StringsJVMKt.isBlank(text)) {
            ((TextView) _$_findCachedViewById(i11)).setClickable(false);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AddVoucherCodeView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R.layout.add_voucher_code_view, this, true);
        setupUi();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AddVoucherCodeView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R.layout.add_voucher_code_view, this, true);
        setupUi();
    }
}
