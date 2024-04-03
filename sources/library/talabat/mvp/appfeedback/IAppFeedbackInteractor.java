package library.talabat.mvp.appfeedback;

import datamodels.AppFeedbackRM;
import library.talabat.mvp.IGlobalInteractor;

public interface IAppFeedbackInteractor extends IGlobalInteractor {
    void sendFeedbackRequest(AppFeedbackRM appFeedbackRM);
}
