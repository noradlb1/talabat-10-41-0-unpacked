package com.talabat.userandlocation.choosecountry.ui.fragment;

import android.view.View;
import android.widget.RelativeLayout;
import com.talabat.talabatcommon.views.TalabatImageView;
import com.talabat.talabatcommon.views.TalabatTextView;
import com.talabat.userandlocation.choosecountry.R;
import com.talabat.userandlocation.choosecountry.presentation.displaymodel.CountryDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Landroid/view/View;", "country", "Lcom/talabat/userandlocation/choosecountry/presentation/displaymodel/CountryDisplayModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ChooseCountryFragment$observeViewModel$6 extends Lambda implements Function2<View, CountryDisplayModel, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ChooseCountryFragment f12267g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChooseCountryFragment$observeViewModel$6(ChooseCountryFragment chooseCountryFragment) {
        super(2);
        this.f12267g = chooseCountryFragment;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m5891invoke$lambda0(ChooseCountryFragment chooseCountryFragment, CountryDisplayModel countryDisplayModel, View view) {
        Intrinsics.checkNotNullParameter(chooseCountryFragment, "this$0");
        Intrinsics.checkNotNullParameter(countryDisplayModel, "$country");
        chooseCountryFragment.getViewModel().onCountrySelected(countryDisplayModel.getId());
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((View) obj, (CountryDisplayModel) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull View view, @NotNull CountryDisplayModel countryDisplayModel) {
        Intrinsics.checkNotNullParameter(view, "$this$invoke");
        Intrinsics.checkNotNullParameter(countryDisplayModel, "country");
        ((TalabatTextView) view.findViewById(R.id.title)).setText(countryDisplayModel.getName());
        ((TalabatImageView) view.findViewById(R.id.image_tick)).setVisibility(countryDisplayModel.isSelected() ? 0 : 8);
        ((RelativeLayout) view.findViewById(R.id.item)).setOnClickListener(new a(this.f12267g, countryDisplayModel));
        if (countryDisplayModel.getImageRes() != -1) {
            ((TalabatImageView) view.findViewById(R.id.icon)).setImageResource(countryDisplayModel.getImageRes());
        }
    }
}
