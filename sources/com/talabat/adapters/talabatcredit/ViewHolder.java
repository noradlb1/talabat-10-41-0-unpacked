package com.talabat.adapters.talabatcredit;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.R;
import com.talabat.TalabatTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0019\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010\u000f0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0012\u001a\n \u0007*\u0004\u0018\u00010\u000f0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/talabat/adapters/talabatcredit/ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "container", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "getContainer", "()Landroid/widget/RelativeLayout;", "talabatDot", "Landroid/widget/ImageView;", "getTalabatDot", "()Landroid/widget/ImageView;", "tvExpListBal", "Lcom/talabat/TalabatTextView;", "getTvExpListBal", "()Lcom/talabat/TalabatTextView;", "tvExpListHolder", "getTvExpListHolder", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ViewHolder extends RecyclerView.ViewHolder {
    private final RelativeLayout container;
    private final ImageView talabatDot;
    private final TalabatTextView tvExpListBal;
    private final TalabatTextView tvExpListHolder;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ViewHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.tvExpListBal = (TalabatTextView) view.findViewById(R.id.tal_credit_exp_text);
        this.tvExpListHolder = (TalabatTextView) view.findViewById(R.id.expires_holder_text);
        this.container = (RelativeLayout) view.findViewById(R.id.container);
        this.talabatDot = (ImageView) view.findViewById(R.id.yellow_dot);
    }

    public final RelativeLayout getContainer() {
        return this.container;
    }

    public final ImageView getTalabatDot() {
        return this.talabatDot;
    }

    public final TalabatTextView getTvExpListBal() {
        return this.tvExpListBal;
    }

    public final TalabatTextView getTvExpListHolder() {
        return this.tvExpListHolder;
    }
}
