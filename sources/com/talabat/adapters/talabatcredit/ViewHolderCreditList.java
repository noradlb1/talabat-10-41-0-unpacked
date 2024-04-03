package com.talabat.adapters.talabatcredit;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.R;
import com.talabat.TalabatTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0019\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0019\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u0019\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\tR\u0019\u0010\u0010\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\tR\u0019\u0010\u0012\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/talabat/adapters/talabatcredit/ViewHolderCreditList;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "tvAmountTxt", "Lcom/talabat/TalabatTextView;", "kotlin.jvm.PlatformType", "getTvAmountTxt", "()Lcom/talabat/TalabatTextView;", "tvDateTxt", "getTvDateTxt", "tvDetailsTxt", "getTvDetailsTxt", "tvExpDetailsTxt", "getTvExpDetailsTxt", "tvtimeTxt", "getTvtimeTxt", "tvtoalTxt", "getTvtoalTxt", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ViewHolderCreditList extends RecyclerView.ViewHolder {
    private final TalabatTextView tvAmountTxt;
    private final TalabatTextView tvDateTxt;
    private final TalabatTextView tvDetailsTxt;
    private final TalabatTextView tvExpDetailsTxt;
    private final TalabatTextView tvtimeTxt;
    private final TalabatTextView tvtoalTxt;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ViewHolderCreditList(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.tvDateTxt = (TalabatTextView) view.findViewById(R.id.date_text);
        this.tvtimeTxt = (TalabatTextView) view.findViewById(R.id.time_text);
        this.tvDetailsTxt = (TalabatTextView) view.findViewById(R.id.tal_credit_status_txt);
        this.tvAmountTxt = (TalabatTextView) view.findViewById(R.id.credit_amount_txt);
        this.tvExpDetailsTxt = (TalabatTextView) view.findViewById(R.id.credit_exp_details_txt);
        this.tvtoalTxt = (TalabatTextView) view.findViewById(R.id.credit_total_txt);
    }

    public final TalabatTextView getTvAmountTxt() {
        return this.tvAmountTxt;
    }

    public final TalabatTextView getTvDateTxt() {
        return this.tvDateTxt;
    }

    public final TalabatTextView getTvDetailsTxt() {
        return this.tvDetailsTxt;
    }

    public final TalabatTextView getTvExpDetailsTxt() {
        return this.tvExpDetailsTxt;
    }

    public final TalabatTextView getTvtimeTxt() {
        return this.tvtimeTxt;
    }

    public final TalabatTextView getTvtoalTxt() {
        return this.tvtoalTxt;
    }
}
