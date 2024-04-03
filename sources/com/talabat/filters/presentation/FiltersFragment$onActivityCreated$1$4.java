package com.talabat.filters.presentation;

import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.talabat.filters.R;
import datamodels.filters.SelectableFilter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Landroid/view/View;", "item", "Ldatamodels/filters/SelectableFilter;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class FiltersFragment$onActivityCreated$1$4 extends Lambda implements Function2<View, SelectableFilter, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ FiltersViewModel f59622g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ FiltersFragment f59623h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FiltersFragment$onActivityCreated$1$4(FiltersViewModel filtersViewModel, FiltersFragment filtersFragment) {
        super(2);
        this.f59622g = filtersViewModel;
        this.f59623h = filtersFragment;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m10439invoke$lambda0(FiltersViewModel filtersViewModel, SelectableFilter selectableFilter, FiltersFragment filtersFragment, View view) {
        Intrinsics.checkNotNullParameter(filtersViewModel, "$this_with");
        Intrinsics.checkNotNullParameter(selectableFilter, "$item");
        Intrinsics.checkNotNullParameter(filtersFragment, "this$0");
        FiltersViewModelKt.onFilterClicked(filtersViewModel, selectableFilter);
        ((LinearLayout) filtersFragment._$_findCachedViewById(R.id.buttonsContainer)).setVisibility(0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((View) obj, (SelectableFilter) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull View view, @NotNull SelectableFilter selectableFilter) {
        Intrinsics.checkNotNullParameter(view, "$this$invoke");
        Intrinsics.checkNotNullParameter(selectableFilter, "item");
        ((TextView) view.findViewById(R.id.textView_filterName)).setText(selectableFilter.getFilter().getName());
        ((CheckBox) view.findViewById(R.id.switch_filter)).setChecked(selectableFilter.isOn());
        view.setOnClickListener(new b(this.f59622g, selectableFilter, this.f59623h));
    }
}
