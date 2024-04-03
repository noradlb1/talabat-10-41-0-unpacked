package buisnessmodels;

import android.content.Context;
import android.content.SharedPreferences;
import com.talabat.configuration.country.Country;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;

public class ShowCaseViewLogic {
    private static final String ADDRESSPAGE = "addressPage";
    private static final String CHECKOUTDOTCOM = "checkoutscanPage";
    private static final String HOME = "homeShowCase";
    private static final String INFORMAP = "informap";
    private static final String MAP_ON_BOARDING = "onMapBoardingPage";
    private static final String MCDFLOWTUT = "mcdtutpage";
    private static final String RESTAURANTLIST = "restaurantList";
    private static final String RESTAURANTMENU = "restaurantmenu";
    private static final String RESTAURANTSEARCH = "restaurantsearch";
    private static final String SHAKE = "shake";
    private static ShowCaseViewLogic showCaseViewLogic = new ShowCaseViewLogic();
    private boolean addressPage = false;
    private boolean checkoutDotComPage = false;
    private boolean homeScreen = false;
    private boolean informap = false;
    private boolean mapOnBoarding = false;
    private boolean mcdMapTutPage = false;
    private boolean menuPage = false;
    private boolean menuSearchPage = false;
    private boolean restaurantListPage = false;
    private boolean shake = false;

    public static ShowCaseViewLogic createInstance(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(GlobalConstants.PrefsConstants.getNAME(), 0);
        showCaseViewLogic.homeScreen = sharedPreferences.getBoolean(HOME, false);
        showCaseViewLogic.restaurantListPage = sharedPreferences.getBoolean(RESTAURANTLIST, false);
        showCaseViewLogic.addressPage = sharedPreferences.getBoolean(ADDRESSPAGE, false);
        showCaseViewLogic.shake = sharedPreferences.getBoolean(SHAKE, false);
        showCaseViewLogic.menuPage = sharedPreferences.getBoolean(RESTAURANTMENU, false);
        showCaseViewLogic.menuSearchPage = sharedPreferences.getBoolean(RESTAURANTSEARCH, false);
        showCaseViewLogic.informap = sharedPreferences.getBoolean(INFORMAP, false);
        showCaseViewLogic.checkoutDotComPage = sharedPreferences.getBoolean(CHECKOUTDOTCOM, false);
        showCaseViewLogic.mcdMapTutPage = sharedPreferences.getBoolean(MCDFLOWTUT, false);
        showCaseViewLogic.mapOnBoarding = sharedPreferences.getBoolean(MAP_ON_BOARDING, false);
        return showCaseViewLogic;
    }

    public static ShowCaseViewLogic getInstance() {
        return showCaseViewLogic;
    }

    public void saveToPrefs(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences(GlobalConstants.PrefsConstants.getNAME(), 0).edit();
        edit.putBoolean(HOME, showCaseViewLogic.homeScreen);
        edit.putBoolean(RESTAURANTLIST, showCaseViewLogic.restaurantListPage);
        edit.putBoolean(ADDRESSPAGE, showCaseViewLogic.addressPage);
        edit.putBoolean(ADDRESSPAGE, showCaseViewLogic.addressPage);
        edit.putBoolean(SHAKE, showCaseViewLogic.shake);
        edit.putBoolean(RESTAURANTMENU, showCaseViewLogic.menuPage);
        edit.putBoolean(RESTAURANTSEARCH, showCaseViewLogic.menuSearchPage);
        edit.putBoolean(CHECKOUTDOTCOM, showCaseViewLogic.checkoutDotComPage);
        edit.putBoolean(INFORMAP, showCaseViewLogic.informap);
        edit.putBoolean(MCDFLOWTUT, showCaseViewLogic.mcdMapTutPage);
        edit.putBoolean(MAP_ON_BOARDING, showCaseViewLogic.mapOnBoarding);
        edit.apply();
    }

    public void setInformap() {
        this.informap = true;
    }

    public void setMapOnBoarding() {
        this.mapOnBoarding = true;
    }

    public void setmcdMapTutPage() {
        this.mcdMapTutPage = true;
    }

    public boolean showAddressScreen() {
        if (GlobalDataModel.SelectedCountryId == Country.KUWAIT.getCountryId()) {
            return !this.addressPage;
        }
        return false;
    }

    public boolean showInformap() {
        return !this.informap;
    }

    public boolean showMcdTutPage() {
        return !this.mcdMapTutPage;
    }

    public boolean showOnBoarding() {
        return !this.mapOnBoarding;
    }
}
