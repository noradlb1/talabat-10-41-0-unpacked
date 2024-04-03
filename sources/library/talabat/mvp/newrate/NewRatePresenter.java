package library.talabat.mvp.newrate;

import java.util.ArrayList;

public class NewRatePresenter implements INewRatePresenter {
    private INewRateInteractor mInteractor;
    /* access modifiers changed from: private */
    public INewRateView mView;

    public NewRatePresenter(INewRateView iNewRateView, INewRateInteractor iNewRateInteractor) {
        this.mInteractor = iNewRateInteractor;
        this.mView = iNewRateView;
    }

    public void onDestroy() {
        INewRateInteractor iNewRateInteractor = this.mInteractor;
        if (iNewRateInteractor != null) {
            iNewRateInteractor.unregister();
        }
    }

    public void submitRate(String str, String str2, String str3, String str4, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        this.mInteractor.submitRate(str, str2, str3, str4, arrayList, arrayList2);
        this.mInteractor.setListener(new INewRateListener() {
            public void rateFailed() {
                if (NewRatePresenter.this.mView != null) {
                    NewRatePresenter.this.mView.rateFailed();
                }
            }

            public void rateSucceded(int i11, float f11) {
                if (NewRatePresenter.this.mView != null) {
                    NewRatePresenter.this.mView.rateSucceded(i11, f11);
                }
            }
        });
    }
}
