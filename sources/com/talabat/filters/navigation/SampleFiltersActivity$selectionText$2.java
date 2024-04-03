package com.talabat.filters.navigation;

import datamodels.filters.SelectableSortType;
import datamodels.filters.SortType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Ldatamodels/filters/SelectableSortType;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SampleFiltersActivity$selectionText$2 extends Lambda implements Function1<SelectableSortType, CharSequence> {
    public static final SampleFiltersActivity$selectionText$2 INSTANCE = new SampleFiltersActivity$selectionText$2();

    public SampleFiltersActivity$selectionText$2() {
        super(1);
    }

    @NotNull
    public final CharSequence invoke(@NotNull SelectableSortType selectableSortType) {
        Intrinsics.checkNotNullParameter(selectableSortType, "it");
        SortType type = selectableSortType.getType();
        boolean isOn = selectableSortType.isOn();
        return type + "|" + isOn;
    }
}
