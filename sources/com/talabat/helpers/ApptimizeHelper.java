package com.talabat.helpers;

import com.talabat.core.experiment.data.TalabatExperiment;
import com.talabat.core.experiment.data.squads.TalabatExperimentConstants;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.helpers.GlobalDataModel;

@Deprecated
public class ApptimizeHelper {
    @Deprecated
    public static void enableGoogleSearchOptimization(boolean z11) {
        if (z11) {
            GlobalDataModel.Apptimize.CAN_SHOW_GOOGLE_AUTO_COMPLETE_WIDGET = false;
            GlobalDataModel.Apptimize.CAN_SHOW_CUSTOM_GOOGLE_AUTO_COMPLETE_WIDGET = true;
            return;
        }
        String stringVariant = TalabatExperiment.INSTANCE.getStringVariant(TalabatExperimentConstants.CAN_SHOW_CUSTOM_GOOGLE_SEARCH_WIDGET, "original", TalabatExperimentDataSourceStrategy.APPTIMIZE);
        stringVariant.hashCode();
        if (stringVariant.equals("DefaultGoogleWidget")) {
            GlobalDataModel.Apptimize.CAN_SHOW_GOOGLE_AUTO_COMPLETE_WIDGET = true;
            GlobalDataModel.Apptimize.CAN_SHOW_CUSTOM_GOOGLE_AUTO_COMPLETE_WIDGET = false;
        } else if (!stringVariant.equals("CustomGoogleWidget")) {
            GlobalDataModel.Apptimize.CAN_SHOW_GOOGLE_AUTO_COMPLETE_WIDGET = false;
            GlobalDataModel.Apptimize.CAN_SHOW_CUSTOM_GOOGLE_AUTO_COMPLETE_WIDGET = false;
        } else {
            GlobalDataModel.Apptimize.CAN_SHOW_GOOGLE_AUTO_COMPLETE_WIDGET = false;
            GlobalDataModel.Apptimize.CAN_SHOW_CUSTOM_GOOGLE_AUTO_COMPLETE_WIDGET = true;
        }
    }
}
