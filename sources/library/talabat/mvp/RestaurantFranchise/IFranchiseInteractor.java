package library.talabat.mvp.RestaurantFranchise;

import JsonModels.Request.FranchiseRestRequest;
import library.talabat.mvp.IGlobalInteractor;

public interface IFranchiseInteractor extends IGlobalInteractor {
    void getFranchiseBasedLoc(FranchiseRestRequest franchiseRestRequest);
}
