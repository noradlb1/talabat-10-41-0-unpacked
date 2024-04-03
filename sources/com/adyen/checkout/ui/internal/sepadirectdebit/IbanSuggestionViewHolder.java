package com.adyen.checkout.ui.internal.sepadirectdebit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.adyen.checkout.ui.R;
import com.adyen.checkout.ui.internal.common.util.ThemeUtil;

public final class IbanSuggestionViewHolder extends RecyclerView.ViewHolder {
    private TextView mTextView;

    private IbanSuggestionViewHolder(@NonNull View view) {
        super(view);
        this.mTextView = (TextView) view.findViewById(R.id.textView_ibanSuggestion);
        ThemeUtil.applyPrimaryThemeColor(view.getContext(), this.mTextView.getBackground());
    }

    @NonNull
    public static IbanSuggestionViewHolder create(@NonNull ViewGroup viewGroup) {
        return new IbanSuggestionViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_iban_suggestion, viewGroup, false));
    }

    @NonNull
    public TextView getTextView() {
        return this.mTextView;
    }
}
