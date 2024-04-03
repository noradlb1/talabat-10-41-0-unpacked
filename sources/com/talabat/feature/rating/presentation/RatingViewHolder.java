package com.talabat.feature.rating.presentation;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.talabat.feature.rating.domain.model.RatingReasonsData;
import com.talabat.talabatcommon.R;
import com.talabat.talabatcommon.views.darkstores.lookingGlass.adapter.HeadlinesAdapterKt;
import com.talabat.talabatcore.BaseViewHolder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import vn.a;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0016\u0010\t\u001a\u00020\u00072\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000b¨\u0006\f"}, d2 = {"Lcom/talabat/feature/rating/presentation/RatingViewHolder;", "Lcom/talabat/talabatcore/BaseViewHolder;", "Lcom/talabat/feature/rating/domain/model/RatingReasonsData;", "parent", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "populate", "", "model", "setOnClickListener", "itemClickListener", "Lkotlin/Function0;", "com_talabat_feature_rating_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RatingViewHolder extends BaseViewHolder<RatingReasonsData> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RatingViewHolder(@NotNull ViewGroup viewGroup) {
        super(viewGroup, R.layout.item_rating_reasons);
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
    }

    /* access modifiers changed from: private */
    /* renamed from: setOnClickListener$lambda-1  reason: not valid java name */
    public static final void m10258setOnClickListener$lambda1(Function0 function0, View view) {
        Intrinsics.checkNotNullParameter(function0, "$itemClickListener");
        function0.invoke();
    }

    public final void setOnClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "itemClickListener");
        this.itemView.setOnClickListener(new a(function0));
    }

    public void populate(@NotNull RatingReasonsData ratingReasonsData) {
        Intrinsics.checkNotNullParameter(ratingReasonsData, DeviceRequestsHelper.DEVICE_INFO_MODEL);
        View view = this.itemView;
        int i11 = R.id.chipView;
        ((TextView) view.findViewById(i11)).setText(ratingReasonsData.getText());
        if (ratingReasonsData.isSelected()) {
            view.setBackgroundResource(R.drawable.rating_reason_selected);
            ((TextView) view.findViewById(i11)).setTextColor(HeadlinesAdapterKt.getColor(R.color.white));
            return;
        }
        ((TextView) view.findViewById(i11)).setTextColor(HeadlinesAdapterKt.getColor(R.color.neutral_70));
        view.setBackgroundResource(R.drawable.rating_reason_not_selected);
    }
}
