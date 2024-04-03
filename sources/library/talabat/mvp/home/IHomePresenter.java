package library.talabat.mvp.home;

import com.google.android.gms.maps.model.LatLng;
import java.util.List;
import library.talabat.mvp.IGlobalPresenter;
import library.talabat.mvp.home.domain.model.ActiveCartInfo;

public interface IHomePresenter extends IGlobalPresenter {
    void LocationBasedAddressSelection(LatLng latLng);

    void basketSelection(ActiveCartInfo activeCartInfo);

    void checkOnboardingFlowExperiement();

    void fetchUserCurrentLocationFromAppStart(boolean z11);

    boolean ifShouldTrackHomeScreenValue(boolean z11, boolean z12, boolean z13);

    void onCreate(boolean z11, boolean z12, boolean z13);

    void onFlutterHomeAttached();

    void onUserAccountTabClicked();

    void onVerticalClicked(int i11, String str, List<Integer> list);

    void resetLocationAfterCountrySelection();

    void resetToolBarLocationTitle();

    void setCartView();

    void setToolBarLocation();

    void toolbarLocationSelection();

    void toolbarSearchSelection();

    void trackAddressSnappingWithoutGps();
}
