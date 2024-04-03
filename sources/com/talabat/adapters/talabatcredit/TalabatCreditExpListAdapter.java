package com.talabat.adapters.talabatcredit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import buisnessmodels.TalabatFormatter;
import com.talabat.R;
import com.talabat.TalabatTextView;
import com.talabat.helpers.TalabatUtils;
import datamodels.TalabatCreditExpListBal;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0011\u001a\u00020\u0007H\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0007H\u0016J\u0018\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0007H\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/talabat/adapters/talabatcredit/TalabatCreditExpListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/talabat/adapters/talabatcredit/ViewHolder;", "talabatCreditExpItems", "Ljava/util/ArrayList;", "Ldatamodels/TalabatCreditExpListBal;", "nearestExpDay", "", "context", "Landroid/content/Context;", "(Ljava/util/ArrayList;ILandroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "getNearestExpDay", "()I", "getTalabatCreditExpItems", "()Ljava/util/ArrayList;", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TalabatCreditExpListAdapter extends RecyclerView.Adapter<ViewHolder> {
    @NotNull
    private final Context context;
    private final int nearestExpDay;
    @NotNull
    private final ArrayList<TalabatCreditExpListBal> talabatCreditExpItems;

    public TalabatCreditExpListAdapter(@NotNull ArrayList<TalabatCreditExpListBal> arrayList, int i11, @NotNull Context context2) {
        Intrinsics.checkNotNullParameter(arrayList, "talabatCreditExpItems");
        Intrinsics.checkNotNullParameter(context2, "context");
        this.talabatCreditExpItems = arrayList;
        this.nearestExpDay = i11;
        this.context = context2;
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    public int getItemCount() {
        return this.talabatCreditExpItems.size();
    }

    public final int getNearestExpDay() {
        return this.nearestExpDay;
    }

    @NotNull
    public final ArrayList<TalabatCreditExpListBal> getTalabatCreditExpItems() {
        return this.talabatCreditExpItems;
    }

    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i11) {
        String str;
        String str2;
        Integer expiryDays;
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        TalabatTextView tvExpListBal = viewHolder.getTvExpListBal();
        if (tvExpListBal != null) {
            TalabatFormatter instance = TalabatFormatter.getInstance();
            Float balance = this.talabatCreditExpItems.get(i11).getBalance();
            Intrinsics.checkNotNull(balance);
            String formattedCurrency = instance.getFormattedCurrency(balance.floatValue());
            tvExpListBal.setText(formattedCurrency);
        }
        Integer expiryDays2 = this.talabatCreditExpItems.get(i11).getExpiryDays();
        if (expiryDays2 != null && expiryDays2.intValue() == 0) {
            str2 = this.context.getResources().getString(R.string.Expires_holder);
            Intrinsics.checkNotNullExpressionValue(str2, "context.resources.getStr….R.string.Expires_holder)");
            str = this.context.getResources().getString(R.string.Exp_today_holder);
            Intrinsics.checkNotNullExpressionValue(str, "context.resources.getStr….string.Exp_today_holder)");
        } else if (expiryDays2 != null && expiryDays2.intValue() == 1) {
            str2 = this.context.getResources().getString(R.string.Expires_holder);
            Intrinsics.checkNotNullExpressionValue(str2, "context.resources.getStr….R.string.Expires_holder)");
            str = this.context.getResources().getString(R.string.Exp_tommarow_holder);
            Intrinsics.checkNotNullExpressionValue(str, "context.resources.getStr…ring.Exp_tommarow_holder)");
        } else {
            str2 = this.context.getResources().getString(R.string.Exp_in_holder);
            Intrinsics.checkNotNullExpressionValue(str2, "context.resources.getStr…n.R.string.Exp_in_holder)");
            str = this.context.getResources().getString(R.string.Exp_days_holder);
            Intrinsics.checkNotNullExpressionValue(str, "context.resources.getStr…R.string.Exp_days_holder)");
        }
        Integer expiryDays3 = this.talabatCreditExpItems.get(i11).getExpiryDays();
        int i12 = this.nearestExpDay;
        if (expiryDays3 != null && expiryDays3.intValue() == i12) {
            viewHolder.getContainer().setBackgroundResource(R.drawable.border_drawble);
            viewHolder.getTvExpListHolder().setTextColor(ContextCompat.getColor(this.context, R.color.tal_credit_yellow));
            TalabatTextView tvExpListBal2 = viewHolder.getTvExpListBal();
            if (tvExpListBal2 != null) {
                tvExpListBal2.setTextColor(ContextCompat.getColor(this.context, R.color.tal_credit_yellow));
            }
            viewHolder.getTalabatDot().setVisibility(0);
        } else {
            viewHolder.getContainer().setBackgroundResource(R.drawable.border_drawble_grey);
            viewHolder.getTvExpListHolder().setTextColor(ContextCompat.getColor(this.context, R.color.talabat_black));
            TalabatTextView tvExpListBal3 = viewHolder.getTvExpListBal();
            if (tvExpListBal3 != null) {
                tvExpListBal3.setTextColor(ContextCompat.getColor(this.context, R.color.talabat_black));
            }
            viewHolder.getTalabatDot().setVisibility(8);
        }
        Integer expiryDays4 = this.talabatCreditExpItems.get(i11).getExpiryDays();
        if ((expiryDays4 != null && expiryDays4.intValue() == 0) || ((expiryDays = this.talabatCreditExpItems.get(i11).getExpiryDays()) != null && expiryDays.intValue() == 1)) {
            TalabatTextView tvExpListHolder = viewHolder.getTvExpListHolder();
            if (tvExpListHolder != null) {
                tvExpListHolder.setText(TalabatUtils.fromHtml(str2 + "  <b> " + str + "</b>"));
                return;
            }
            return;
        }
        TalabatTextView tvExpListHolder2 = viewHolder.getTvExpListHolder();
        if (tvExpListHolder2 != null) {
            Integer expiryDays5 = this.talabatCreditExpItems.get(i11).getExpiryDays();
            tvExpListHolder2.setText(TalabatUtils.fromHtml(str2 + "  <b>" + expiryDays5 + " " + str + "</b>"));
        }
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.talabat_credit_exp_list, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.…_exp_list, parent, false)");
        return new ViewHolder(inflate);
    }
}
