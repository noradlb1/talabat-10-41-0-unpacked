package com.talabat.fluttercore.mappers;

import com.talabat.core.fwfprojectskeys.domain.FWFProjectName;
import com.talabat.core.observabilityNew.domain.squads.menu.MenuScreenPerformanceParams;
import com.talabat.feature.tmart.growth.data.TMartGrowthReminderRepository;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/fluttercore/mappers/FWFProjectNameMapper;", "", "()V", "getFwfProjectFromProjectName", "Lcom/talabat/core/fwfprojectskeys/domain/FWFProjectName;", "projectName", "", "com_talabat_NewArchi_TalabatFlutterCore_TalabatFlutterCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FWFProjectNameMapper {
    @NotNull
    public static final FWFProjectNameMapper INSTANCE = new FWFProjectNameMapper();

    private FWFProjectNameMapper() {
    }

    @NotNull
    public final FWFProjectName getFwfProjectFromProjectName(@Nullable String str) {
        if (str != null) {
            switch (str.hashCode()) {
                case -1713710573:
                    if (str.equals("logistics")) {
                        return FWFProjectName.LOGISTICS;
                    }
                    break;
                case -906336856:
                    if (str.equals("search")) {
                        return FWFProjectName.SEARCH;
                    }
                    break;
                case -237572747:
                    if (str.equals("killSwitchFlags")) {
                        return FWFProjectName.KILL_SWITCH_FLAGS;
                    }
                    break;
                case 111174:
                    if (str.equals(TMartGrowthReminderRepository.POE_SCREEN_TYPE)) {
                        return FWFProjectName.POE;
                    }
                    break;
                case 2989078:
                    if (str.equals("adex")) {
                        return FWFProjectName.ADEX;
                    }
                    break;
                case 3208415:
                    if (str.equals("home")) {
                        return FWFProjectName.HOME_PAGE;
                    }
                    break;
                case 3347807:
                    if (str.equals(MenuScreenPerformanceParams.SCREEN_TYPE)) {
                        return FWFProjectName.MENU;
                    }
                    break;
                case 3599307:
                    if (str.equals("user")) {
                        return FWFProjectName.USER;
                    }
                    break;
                case 694085126:
                    if (str.equals("vendorList")) {
                        return FWFProjectName.VENDOR_LIST;
                    }
                    break;
                case 1234314708:
                    if (str.equals("ordering")) {
                        return FWFProjectName.ORDERING;
                    }
                    break;
                case 1378307692:
                    if (str.equals("qCommerce")) {
                        return FWFProjectName.Q_COMMERCE;
                    }
                    break;
                case 1518655347:
                    if (str.equals("ecosystems")) {
                        return FWFProjectName.ECOSYSTEMS;
                    }
                    break;
                case 1874684019:
                    if (str.equals("platform")) {
                        return FWFProjectName.PLATFORM;
                    }
                    break;
            }
        }
        return FWFProjectName.DEFAULT;
    }
}
