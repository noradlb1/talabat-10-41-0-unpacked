package com.talabat.adapters;

import JsonModels.Response.rateOrders.RateReason;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.R;
import com.talabat.TalabatTextView;
import java.util.ArrayList;
import xe.d;

public class RateReasonsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<RateReason> f55178i;

    /* renamed from: j  reason: collision with root package name */
    public Context f55179j;

    /* renamed from: k  reason: collision with root package name */
    public ArrayList<RateReason> f55180k = new ArrayList<>();

    public class RateReasonViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: h  reason: collision with root package name */
        public CheckBox f55181h;

        /* renamed from: i  reason: collision with root package name */
        public TalabatTextView f55182i;

        public RateReasonViewHolder(View view) {
            super(view);
            this.f55181h = (CheckBox) view.findViewById(R.id.reason_checkbox);
            this.f55182i = (TalabatTextView) view.findViewById(R.id.reason_text);
        }
    }

    public RateReasonsAdapter(Context context, ArrayList<RateReason> arrayList) {
        this.f55178i = arrayList;
        this.f55179j = context;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onBindViewHolder$1(RateReason rateReason, CompoundButton compoundButton, boolean z11) {
        if (z11) {
            this.f55180k.add(rateReason);
        } else {
            this.f55180k.remove(rateReason);
        }
    }

    public ArrayList<RateReason> getCheckedRateReasons() {
        return this.f55180k;
    }

    public int getItemCount() {
        return this.f55178i.size();
    }

    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i11) {
        RateReasonViewHolder rateReasonViewHolder = (RateReasonViewHolder) viewHolder;
        RateReason rateReason = this.f55178i.get(i11);
        rateReasonViewHolder.f55182i.setText(rateReason.getRatingReason());
        rateReasonViewHolder.f55181h.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
        rateReasonViewHolder.f55181h.setChecked(this.f55180k.contains(rateReason));
        rateReasonViewHolder.itemView.setOnClickListener(new c(rateReasonViewHolder));
        rateReasonViewHolder.f55181h.setOnCheckedChangeListener(new d(this, rateReason));
    }

    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i11) {
        return new RateReasonViewHolder(LayoutInflater.from(this.f55179j).inflate(R.layout.item_rate_reason, viewGroup, false));
    }
}
