package com.jakewharton.rxbinding3.widget;

import android.widget.AutoCompleteTextView;
import androidx.annotation.CheckResult;
import io.reactivex.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"com/jakewharton/rxbinding3/widget/RxAutoCompleteTextView__AutoCompleteTextViewItemClickEventObservableKt"}, k = 4, mv = {1, 1, 15})
public final class RxAutoCompleteTextView {
    @CheckResult
    @NotNull
    public static final Observable<AdapterViewItemClickEvent> itemClickEvents(@NotNull AutoCompleteTextView autoCompleteTextView) {
        return RxAutoCompleteTextView__AutoCompleteTextViewItemClickEventObservableKt.itemClickEvents(autoCompleteTextView);
    }
}
