package com.talabat.cuisines.presentation;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.talabat.cuisines.R;
import com.talabat.cuisines.domain.SelectableCuisine;
import com.talabat.talabatcommon.extentions.BroadcastsKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.extensions.LayoutContainer;
import org.jetbrains.annotations.NotNull;
import uh.a;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B#\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\u0010\nJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/talabat/cuisines/presentation/CuisineMultipleSelectionViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lkotlinx/android/extensions/LayoutContainer;", "Lcom/talabat/cuisines/presentation/CuisineHolder;", "containerView", "Landroid/view/View;", "isAllCuisinesItemUseCase", "Lkotlin/Function1;", "", "", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;)V", "getContainerView", "()Landroid/view/View;", "()Lkotlin/jvm/functions/Function1;", "bind", "", "model", "Lcom/talabat/cuisines/domain/SelectableCuisine;", "com_talabat_Components_cuisines_cuisines"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CuisineMultipleSelectionViewHolder extends RecyclerView.ViewHolder implements LayoutContainer, CuisineHolder {
    @NotNull
    private final View containerView;
    @NotNull
    private final Function1<Integer, Boolean> isAllCuisinesItemUseCase;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CuisineMultipleSelectionViewHolder(View view, Function1 function1, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, (i11 & 2) != 0 ? AnonymousClass1.INSTANCE : function1);
    }

    /* access modifiers changed from: private */
    /* renamed from: bind$lambda-1$lambda-0  reason: not valid java name */
    public static final void m9616bind$lambda1$lambda0(SelectableCuisine selectableCuisine, View view) {
        Intrinsics.checkNotNullParameter(selectableCuisine, "$model");
        BroadcastsKt.sendBroadcast(CuisinesAdapterKt.ACTION_CUISINE_CLICKED, TuplesKt.to(CuisinesAdapterKt.EXTRA_CUISINE, selectableCuisine));
    }

    public void bind(@NotNull SelectableCuisine selectableCuisine) {
        String str;
        Intrinsics.checkNotNullParameter(selectableCuisine, DeviceRequestsHelper.DEVICE_INFO_MODEL);
        View containerView2 = getContainerView();
        TextView textView = (TextView) containerView2.findViewById(R.id.cuisineName);
        if (this.isAllCuisinesItemUseCase.invoke(Integer.valueOf(selectableCuisine.getCuisine().f13848id)).booleanValue()) {
            str = containerView2.getContext().getString(com.talabat.localization.R.string.all_cuisines);
        } else {
            str = selectableCuisine.getCuisine().f13849name;
        }
        textView.setText(str);
        ((CheckBox) containerView2.findViewById(R.id.cuisineCheckBox)).setChecked(selectableCuisine.isOn());
        containerView2.setOnClickListener(new a(selectableCuisine));
    }

    @NotNull
    public View getContainerView() {
        return this.containerView;
    }

    @NotNull
    public final Function1<Integer, Boolean> isAllCuisinesItemUseCase() {
        return this.isAllCuisinesItemUseCase;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CuisineMultipleSelectionViewHolder(@NotNull View view, @NotNull Function1<? super Integer, Boolean> function1) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "containerView");
        Intrinsics.checkNotNullParameter(function1, "isAllCuisinesItemUseCase");
        this.containerView = view;
        this.isAllCuisinesItemUseCase = function1;
    }
}
