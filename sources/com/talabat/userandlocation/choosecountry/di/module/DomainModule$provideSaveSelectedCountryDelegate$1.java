package com.talabat.userandlocation.choosecountry.di.module;

import android.content.Context;
import android.content.SharedPreferences;
import com.talabat.configuration.MutableConfigurationLocalRepository;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.userandlocation.choosecountry.domain.entity.CountryVO;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "country", "Lcom/talabat/userandlocation/choosecountry/domain/entity/CountryVO;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class DomainModule$provideSaveSelectedCountryDelegate$1 extends Lambda implements Function1<CountryVO, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MutableConfigurationLocalRepository f12214g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Context f12215h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DomainModule$provideSaveSelectedCountryDelegate$1(MutableConfigurationLocalRepository mutableConfigurationLocalRepository, Context context) {
        super(1);
        this.f12214g = mutableConfigurationLocalRepository;
        this.f12215h = context;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((CountryVO) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull CountryVO countryVO) {
        Intrinsics.checkNotNullParameter(countryVO, "country");
        GlobalDataModel.launchRxNextEventOnCountryId(countryVO.getId());
        this.f12214g.setSelectedCountry(countryVO.getId());
        GlobalDataModel.SelectedCountryName = countryVO.getName();
        GlobalDataModel.SelectedAreaId = 0;
        GlobalDataModel.SelectedAreaName = "";
        GlobalDataModel.SelectedCityId = 0;
        GlobalDataModel.SelectedCityName = "";
        GlobalDataModel.cuisines = null;
        GlobalDataModel.filterEngine = null;
        SharedPreferences.Editor edit = this.f12215h.getSharedPreferences(GlobalConstants.PrefsConstants.getNAME(), 0).edit();
        edit.putInt(GlobalConstants.PrefsConstants.COUNTRY_ID, countryVO.getId());
        edit.putString(GlobalConstants.PrefsConstants.COUNTRY_NAME, countryVO.getName());
        edit.putString(GlobalConstants.PrefsConstants.CITY_NAME, "");
        edit.putString(GlobalConstants.PrefsConstants.AREA_NAME, GlobalDataModel.SelectedAreaName);
        edit.putInt(GlobalConstants.PrefsConstants.CITY_ID, GlobalDataModel.SelectedCityId);
        edit.putInt(GlobalConstants.PrefsConstants.AREA_ID, GlobalDataModel.SelectedAreaId);
        edit.apply();
    }
}
