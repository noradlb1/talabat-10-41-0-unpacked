package com.adyen.checkout.ui.internal.sepadirectdebit;

import android.text.Editable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.adyen.checkout.util.internal.SimpleTextWatcher;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class IbanSuggestionsAdapter extends RecyclerView.Adapter<IbanSuggestionViewHolder> {
    /* access modifiers changed from: private */
    public final Map<String, CountryAdapter> mAdapters = new HashMap<String, CountryAdapter>() {
        {
            put("NL", new NetherlandsAdapter());
            put("DE", new GermanyAdapter());
        }
    };
    /* access modifiers changed from: private */
    public CountryAdapter mCurrentCountryAdapter;
    /* access modifiers changed from: private */
    public EditText mIbanEditText;
    private SimpleTextWatcher mIbanTextWatcher;
    /* access modifiers changed from: private */
    public Listener mListener;

    public interface Listener {
        void onSuggestionClick(@NonNull Suggestion suggestion);
    }

    public IbanSuggestionsAdapter(@NonNull EditText editText, @NonNull Listener listener) {
        AnonymousClass2 r02 = new SimpleTextWatcher() {
            public void afterTextChanged(Editable editable) {
                String str;
                String upperCase = editable.toString().replaceAll("\\s", "").toUpperCase(Locale.US);
                boolean z11 = false;
                if (upperCase.length() >= 2) {
                    str = upperCase.substring(0, 2);
                } else {
                    str = null;
                }
                CountryAdapter countryAdapter = (CountryAdapter) IbanSuggestionsAdapter.this.mAdapters.get(str);
                if (countryAdapter != IbanSuggestionsAdapter.this.mCurrentCountryAdapter) {
                    CountryAdapter unused = IbanSuggestionsAdapter.this.mCurrentCountryAdapter = countryAdapter;
                    z11 = true;
                }
                if (z11) {
                    IbanSuggestionsAdapter.this.notifyDataSetChanged();
                } else if (IbanSuggestionsAdapter.this.mCurrentCountryAdapter != null) {
                    IbanSuggestionsAdapter.this.mCurrentCountryAdapter.f(IbanSuggestionsAdapter.this.mIbanEditText, IbanSuggestionsAdapter.this);
                }
            }
        };
        this.mIbanTextWatcher = r02;
        this.mIbanEditText = editText;
        editText.addTextChangedListener(r02);
        this.mListener = listener;
    }

    public int getItemCount() {
        CountryAdapter countryAdapter = this.mCurrentCountryAdapter;
        if (countryAdapter != null) {
            return countryAdapter.getItemCount();
        }
        return 0;
    }

    public void onBindViewHolder(@NonNull IbanSuggestionViewHolder ibanSuggestionViewHolder, int i11) {
        this.mCurrentCountryAdapter.onBindViewHolder(ibanSuggestionViewHolder, i11);
    }

    @NonNull
    public IbanSuggestionViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i11) {
        final IbanSuggestionViewHolder onCreateViewHolder = this.mCurrentCountryAdapter.onCreateViewHolder(viewGroup, i11);
        onCreateViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Suggestion suggestion;
                int adapterPosition = onCreateViewHolder.getAdapterPosition();
                if (adapterPosition != -1) {
                    suggestion = IbanSuggestionsAdapter.this.mCurrentCountryAdapter.e().get(adapterPosition);
                } else {
                    suggestion = null;
                }
                if (suggestion != null) {
                    IbanSuggestionsAdapter.this.mListener.onSuggestionClick(suggestion);
                }
            }
        });
        return onCreateViewHolder;
    }
}
