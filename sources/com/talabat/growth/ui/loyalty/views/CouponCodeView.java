package com.talabat.growth.ui.loyalty.views;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.talabat.growth.databinding.ViewCouponCodeBinding;
import com.talabat.localization.R;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pr.a;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\r\u001a\u00020\u000eJ\u001e\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/talabat/growth/ui/loyalty/views/CouponCodeView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/talabat/growth/databinding/ViewCouponCodeBinding;", "getBinding", "()Lcom/talabat/growth/databinding/ViewCouponCodeBinding;", "copyCodeToClipboard", "", "updateUi", "couponTitle", "", "couponCode", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CouponCodeView extends FrameLayout {
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    @NotNull
    private final ViewCouponCodeBinding binding;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CouponCodeView(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CouponCodeView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CouponCodeView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        ViewCouponCodeBinding inflate = ViewCouponCodeBinding.inflate(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(\n            Lay…           true\n        )");
        this.binding = inflate;
    }

    public static /* synthetic */ void updateUi$default(CouponCodeView couponCodeView, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = null;
        }
        if ((i11 & 2) != 0) {
            str2 = null;
        }
        couponCodeView.updateUi(str, str2);
    }

    /* access modifiers changed from: private */
    /* renamed from: updateUi$lambda-4$lambda-3  reason: not valid java name */
    public static final void m10610updateUi$lambda4$lambda3(CouponCodeView couponCodeView, View view) {
        Intrinsics.checkNotNullParameter(couponCodeView, "this$0");
        couponCodeView.copyCodeToClipboard();
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

    public final void copyCodeToClipboard() {
        ClipboardManager clipboardManager = (ClipboardManager) getContext().getSystemService("clipboard");
        ClipData newPlainText = ClipData.newPlainText("couponCode", this.binding.couponCodeTextView.getText().toString());
        if (clipboardManager != null) {
            clipboardManager.setPrimaryClip(newPlainText);
            Toast.makeText(getContext(), getContext().getString(R.string.coupon_code_coppied_to_clipboard, new Object[]{this.binding.couponCodeTextView.getText().toString()}), 0).show();
        }
    }

    @NotNull
    public final ViewCouponCodeBinding getBinding() {
        return this.binding;
    }

    public final void updateUi(@Nullable String str, @Nullable String str2) {
        if (str != null) {
            if (!(!StringsKt__StringsJVMKt.isBlank(str))) {
                str = null;
            }
            if (str != null) {
                this.binding.couponTitleTextView.setVisibility(0);
                this.binding.couponTitleTextView.setText(str);
            }
        }
        if (str2 != null) {
            if (!(!StringsKt__StringsJVMKt.isBlank(str2))) {
                str2 = null;
            }
            if (str2 != null) {
                this.binding.couponCodeTextView.setVisibility(0);
                this.binding.couponCodeTextView.setText(str2);
                this.binding.couponCodeTextView.setOnClickListener(new a(this));
            }
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CouponCodeView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }
}
