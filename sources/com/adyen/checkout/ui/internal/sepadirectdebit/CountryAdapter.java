package com.adyen.checkout.ui.internal.sepadirectdebit;

import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.adyen.checkout.ui.internal.common.util.recyclerview.SimpleDiffCallback;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public abstract class CountryAdapter extends RecyclerView.Adapter<IbanSuggestionViewHolder> {
    private List<Suggestion> mSuggestions = new ArrayList();

    @NonNull
    public abstract List<Suggestion> a(@NonNull EditText editText, @NonNull String str);

    @NonNull
    public List<Suggestion> e() {
        return this.mSuggestions;
    }

    public void f(@NonNull EditText editText, @NonNull RecyclerView.Adapter adapter) {
        List<Suggestion> a11 = a(editText, editText.getText().toString().replaceAll("\\s", "").toUpperCase(Locale.US));
        DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new SimpleDiffCallback(this.mSuggestions, a11));
        this.mSuggestions = a11;
        calculateDiff.dispatchUpdatesTo(adapter);
    }

    public int getItemCount() {
        return this.mSuggestions.size();
    }

    public void onBindViewHolder(@NonNull IbanSuggestionViewHolder ibanSuggestionViewHolder, int i11) {
        ibanSuggestionViewHolder.getTextView().setText(this.mSuggestions.get(i11).getName());
    }

    @NonNull
    public IbanSuggestionViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i11) {
        return IbanSuggestionViewHolder.create(viewGroup);
    }
}
