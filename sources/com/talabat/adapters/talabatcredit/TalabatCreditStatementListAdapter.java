package com.talabat.adapters.talabatcredit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.R;
import com.talabat.TalabatTextView;
import com.talabat.helpers.TalabatUtils;
import datamodels.TalabatCreditStatementR;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000fH\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR!\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/talabat/adapters/talabatcredit/TalabatCreditStatementListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/talabat/adapters/talabatcredit/ViewHolderCreditList;", "talabatCreditStatementList", "Ljava/util/ArrayList;", "Ldatamodels/TalabatCreditStatementR;", "Lkotlin/collections/ArrayList;", "context", "Landroid/content/Context;", "(Ljava/util/ArrayList;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "getTalabatCreditStatementList", "()Ljava/util/ArrayList;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TalabatCreditStatementListAdapter extends RecyclerView.Adapter<ViewHolderCreditList> {
    @NotNull
    private final Context context;
    @NotNull
    private final ArrayList<TalabatCreditStatementR> talabatCreditStatementList;

    public TalabatCreditStatementListAdapter(@NotNull ArrayList<TalabatCreditStatementR> arrayList, @NotNull Context context2) {
        Intrinsics.checkNotNullParameter(arrayList, "talabatCreditStatementList");
        Intrinsics.checkNotNullParameter(context2, "context");
        this.talabatCreditStatementList = arrayList;
        this.context = context2;
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    public int getItemCount() {
        return this.talabatCreditStatementList.size();
    }

    @NotNull
    public final ArrayList<TalabatCreditStatementR> getTalabatCreditStatementList() {
        return this.talabatCreditStatementList;
    }

    public void onBindViewHolder(@NotNull ViewHolderCreditList viewHolderCreditList, int i11) {
        Intrinsics.checkNotNullParameter(viewHolderCreditList, "holder");
        TalabatTextView tvDateTxt = viewHolderCreditList.getTvDateTxt();
        if (tvDateTxt != null) {
            tvDateTxt.setText(this.talabatCreditStatementList.get(i11).dateStr);
        }
        TalabatTextView tvtimeTxt = viewHolderCreditList.getTvtimeTxt();
        if (tvtimeTxt != null) {
            tvtimeTxt.setText(this.talabatCreditStatementList.get(i11).timeStr);
        }
        TalabatTextView tvDetailsTxt = viewHolderCreditList.getTvDetailsTxt();
        if (tvDetailsTxt != null) {
            tvDetailsTxt.setText(this.talabatCreditStatementList.get(i11).details);
        }
        if (!TalabatUtils.isNullOrEmpty(this.talabatCreditStatementList.get(i11).getExpiryDetails())) {
            viewHolderCreditList.getTvExpDetailsTxt().setVisibility(0);
            TalabatTextView tvExpDetailsTxt = viewHolderCreditList.getTvExpDetailsTxt();
            if (tvExpDetailsTxt != null) {
                tvExpDetailsTxt.setText(this.talabatCreditStatementList.get(i11).getExpiryDetails());
            }
        } else {
            viewHolderCreditList.getTvExpDetailsTxt().setVisibility(8);
        }
        TalabatTextView tvExpDetailsTxt2 = viewHolderCreditList.getTvExpDetailsTxt();
        if (tvExpDetailsTxt2 != null) {
            tvExpDetailsTxt2.setText(this.talabatCreditStatementList.get(i11).getExpiryDetails());
        }
        TalabatTextView tvtoalTxt = viewHolderCreditList.getTvtoalTxt();
        if (tvtoalTxt != null) {
            tvtoalTxt.setText(TalabatCreditStatementListAdapterKt.getCurrencyFormattedText(this.talabatCreditStatementList.get(i11).total, false));
        }
        if (this.talabatCreditStatementList.get(i11).amount > 0.0f) {
            viewHolderCreditList.getTvAmountTxt().setTextColor(ContextCompat.getColor(this.context, R.color.talabat_green));
        } else {
            viewHolderCreditList.getTvAmountTxt().setTextColor(ContextCompat.getColor(this.context, R.color.discount_red));
        }
        viewHolderCreditList.getTvAmountTxt().setText(TalabatCreditStatementListAdapterKt.getCurrencyFormattedText(this.talabatCreditStatementList.get(i11).amount, true));
    }

    @NotNull
    public ViewHolderCreditList onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.talabat_credit_statement_list_item_r, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.…st_item_r, parent, false)");
        return new ViewHolderCreditList(inflate);
    }
}
