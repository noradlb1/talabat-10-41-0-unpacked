package com.talabat.darkstores.feature.home.viewholder;

import android.view.View;
import android.widget.Button;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.darkstores.feature.home.TproSubscriptionInfoData;
import com.talabat.feature.tpro.presentation.R;
import gj.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/talabat/darkstores/feature/home/viewholder/TproSubscriptionHeaderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "subscribe", "Landroid/widget/Button;", "getSubscribe", "()Landroid/widget/Button;", "bind", "", "item", "Lcom/talabat/darkstores/feature/home/TproSubscriptionInfoData;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TproSubscriptionHeaderViewHolder extends RecyclerView.ViewHolder {
    @NotNull
    private final Button subscribe;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TproSubscriptionHeaderViewHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = this.itemView.findViewById(R.id.subscribe_button);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.subscribe_button)");
        this.subscribe = (Button) findViewById;
    }

    /* access modifiers changed from: private */
    /* renamed from: bind$lambda-0  reason: not valid java name */
    public static final void m9980bind$lambda0(TproSubscriptionInfoData tproSubscriptionInfoData, View view) {
        Intrinsics.checkNotNullParameter(tproSubscriptionInfoData, "$item");
        tproSubscriptionInfoData.getOnTproSubscriptionClicked().invoke();
    }

    public final void bind(@NotNull TproSubscriptionInfoData tproSubscriptionInfoData) {
        int i11;
        Intrinsics.checkNotNullParameter(tproSubscriptionInfoData, "item");
        Button button = this.subscribe;
        if (tproSubscriptionInfoData.getShowSubscribeButton()) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        button.setVisibility(i11);
        this.subscribe.setOnClickListener(new d(tproSubscriptionInfoData));
    }

    @NotNull
    public final Button getSubscribe() {
        return this.subscribe;
    }
}
