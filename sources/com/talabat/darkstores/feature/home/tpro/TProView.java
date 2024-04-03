package com.talabat.darkstores.feature.home.tpro;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.designsystem.marshmallow.R;
import com.talabat.darkstores.databinding.TproViewBinding;
import com.talabat.talabatcommon.extension.ViewKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/talabat/darkstores/feature/home/tpro/TProView;", "Landroidx/cardview/widget/CardView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/talabat/darkstores/databinding/TproViewBinding;", "setContent", "", "showSubscribeButton", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TProView extends CardView {
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    @NotNull
    private final TproViewBinding binding;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TProView(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TProView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TProView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        TproViewBinding inflate = TproViewBinding.inflate(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.from(context), this)");
        this.binding = inflate;
        setCardElevation(0.0f);
        setRadius(getResources().getDimension(R.dimen.ds_xxxs));
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

    public final void setContent(boolean z11) {
        int i11;
        TextView textView = this.binding.txtSubscribe;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.txtSubscribe");
        int i12 = 0;
        if (z11) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        textView.setVisibility(i11);
        ImageView imageView = this.binding.imgArrow;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.imgArrow");
        if (!z11) {
            i12 = 8;
        }
        imageView.setVisibility(i12);
        if (z11) {
            this.binding.freeDeliveryText.setText(ViewKt.getString(this, com.talabat.localization.R.string.tpro_subscription_header_delivery_unsubscribed));
        } else {
            this.binding.freeDeliveryText.setText(ViewKt.getString(this, com.talabat.localization.R.string.tpro_subscription_header_delivery_subscribed));
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TProView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }
}
