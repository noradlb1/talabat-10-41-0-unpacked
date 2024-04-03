package tracking.deeplink;

import android.net.Uri;
import android.util.SparseArray;
import buisnessmodels.FilterEngine;
import com.talabat.configuration.location.Area;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.observabilityNew.domain.squads.menu.MenuScreenPerformanceParams;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatUtils;
import datamodels.Cuisine;
import datamodels.Restaurant;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import library.talabat.mvp.homemap.HomeMapConstants;

public class AppUrlResult {
    public static final int ALLRESTAURANTS = 106;
    public static final int BRANDSCREEN = 107;
    public static final int LISTING = 100;
    public static final int MENU = 105;
    public static Uri appLink = null;
    public static String areaId = "";
    public static boolean areasAvailable = false;
    public static String branchId = "";
    public static boolean countriesAvailable = false;
    public static String countryNameSlug = null;
    public static Matcher cuisineChecker = null;
    public static String cuisineId = "";
    public static Pattern cuisinePattern = null;
    public static SparseArray<Cuisine> cuisineSparseArray = null;
    public static final String cuisineTypePatternDefinition = "(\\?cuisinetype=)(\\d+)";
    public static boolean cuisinesAvailable = false;
    public static String currentRestaurantSlug = null;
    public static final int dataError = -200;
    public static boolean isAMP = false;
    public static boolean isAllRestaurants = false;
    private static boolean isBrandScreen = false;
    public static boolean isListing = false;
    public static boolean isMenu = false;
    public static boolean isValidUrl = false;
    public static Pattern listPattern = null;
    public static final String listPatternDefinition = "(/restaurants?)(/)(\\d+)(/)(\\d+)?(/)?(restaurants?/)?";
    public static Pattern menuPattern = null;
    public static final String menuPatternDefinition = "(/menu)(/)(\\d+)(/)((\\d+)(/))?";
    public static List<String> params = null;
    public static String selectedCountry = "";
    public static Matcher slugChecker = null;
    public static Pattern slugPattern = null;
    public static final String slugPatternDefinition = "((\\w+)(-))+(\\w+)?";
    public static SparseArray<String> stringSparseArray = null;
    public static Matcher validityChecker = null;
    public static Pattern validityPattern = null;
    public static final String validityPatternDefinition = "(/)(\\d+)(/)";

    public static boolean checkForRestaurants(String str, String str2) {
        if (TalabatUtils.isNullOrEmpty(str) || TalabatUtils.isNullOrEmpty(str2)) {
            currentRestaurantSlug = null;
            countryNameSlug = null;
            return false;
        }
        currentRestaurantSlug = str;
        if (str2.contains("/")) {
            str2 = str2.replace("/", "");
        }
        countryNameSlug = str2;
        return true;
    }

    public static int getAreaIdFromUrl(LocationConfigurationRepository locationConfigurationRepository) {
        try {
            String str = areaId;
            if (str != null && !str.isEmpty()) {
                return Integer.parseInt(areaId);
            }
            if (!TalabatUtils.isNullOrEmpty(obtainAreaFromSlug(locationConfigurationRepository))) {
                return Integer.parseInt(obtainAreaFromSlug(locationConfigurationRepository));
            }
            return dataError;
        } catch (Exception unused) {
        }
    }

    public static int getBranchIdFromUrl() {
        try {
            String str = branchId;
            if (str == null || str.isEmpty()) {
                return dataError;
            }
            return Integer.parseInt(branchId);
        } catch (Exception unused) {
            return dataError;
        }
    }

    public static int getCountryIdFromUrl() {
        if (selectedCountry.equals("KUWAIT")) {
            return 1;
        }
        if (selectedCountry.equals(HomeMapConstants.GEO_POLYGON_COUNTRY_KSA)) {
            return 2;
        }
        if (selectedCountry.equals("BAHRAIN")) {
            return 3;
        }
        if (selectedCountry.equals(HomeMapConstants.GEO_POLYGON_COUNTRY_UAE)) {
            return 4;
        }
        if (selectedCountry.equals("OMAN")) {
            return 5;
        }
        if (selectedCountry.equals("QATAR")) {
            return 6;
        }
        if (selectedCountry.equals("JORDAN")) {
            return 8;
        }
        if (selectedCountry.equals("EGYPT")) {
            return 9;
        }
        return dataError;
    }

    public static String getCountryNameForBrandScreen(Uri uri) {
        if (TalabatUtils.isArabic()) {
            if (uri.toString().toLowerCase().contains("/kw/") || uri.toString().toLowerCase().contains("/kuwait")) {
                return "/ar/kuwait/";
            }
            if (uri.toString().toLowerCase().contains("/oman")) {
                return "/ar/oman/";
            }
            if (uri.toString().toLowerCase().contains("/ksa") || uri.toString().toLowerCase().contains("/ksa/") || uri.toString().toLowerCase().contains("/sa/") || uri.toString().toLowerCase().contains("saudi")) {
                return "/ar/ksa/";
            }
            if (uri.toString().toLowerCase().contains("/qatar")) {
                return "/ar/qatar/";
            }
            if (uri.toString().toLowerCase().contains("/bahrain") || uri.toString().toLowerCase().contains("/bh/")) {
                return "/ar/bahrain/";
            }
            if (uri.toString().toLowerCase().contains("/uae") || uri.toString().toLowerCase().contains("/ae/")) {
                return "/ar/uae/";
            }
            if (uri.toString().toLowerCase().contains("/jordan")) {
                return "/ar/jordan/";
            }
            if (uri.toString().toLowerCase().contains("/egypt")) {
                return "/ar/egypt/";
            }
            return "";
        } else if (uri.toString().toLowerCase().contains("/kw/") || uri.toString().toLowerCase().contains("/kuwait")) {
            return "/kuwait/";
        } else {
            if (uri.toString().toLowerCase().contains("/oman")) {
                return "/oman/";
            }
            if (uri.toString().toLowerCase().contains("/ksa") || uri.toString().toLowerCase().contains("/ksa/") || uri.toString().toLowerCase().contains("/sa/") || uri.toString().toLowerCase().contains("saudi")) {
                return "/ksa/";
            }
            if (uri.toString().toLowerCase().contains("/qatar")) {
                return "/qatar/";
            }
            if (uri.toString().toLowerCase().contains("/bahrain") || uri.toString().toLowerCase().contains("/bh/")) {
                return "/bahrain/";
            }
            if (uri.toString().toLowerCase().contains("/uae") || uri.toString().toLowerCase().contains("/ae/")) {
                return "/uae/";
            }
            if (uri.toString().toLowerCase().contains("/jordan")) {
                return "/jordan/";
            }
            if (uri.toString().toLowerCase().contains("/egypt")) {
                return "/egypt/";
            }
            return "";
        }
    }

    public static String getCuisineIdFromUrl(Uri uri) {
        if (uri.toString().toLowerCase().contains("?cuisinetype=")) {
            Pattern compile = Pattern.compile(cuisineTypePatternDefinition);
            cuisinePattern = compile;
            Matcher matcher = compile.matcher(uri.toString().toLowerCase());
            cuisineChecker = matcher;
            if (matcher.find()) {
                return cuisineChecker.group(2);
            }
        }
        return null;
    }

    public static int getRestaurantIdFromUrl() {
        try {
            String str = branchId;
            if (str != null && !str.isEmpty()) {
                int parseInt = Integer.parseInt(branchId);
                for (Restaurant restaurant : GlobalDataModel.restaurants) {
                    if (restaurant.getBranchId() == parseInt) {
                        return restaurant.getId();
                    }
                }
            }
        } catch (Exception unused) {
        }
        return dataError;
    }

    public static SparseArray<String> getSlugFromUrl() {
        try {
            SparseArray<String> sparseArray = stringSparseArray;
            if (sparseArray != null) {
                return sparseArray;
            }
            return null;
        } catch (Exception unused) {
        }
    }

    public static int getUrlType() {
        if (!isValidUrl) {
            return dataError;
        }
        if (isListing) {
            return 100;
        }
        if (isMenu) {
            return 105;
        }
        if (isAllRestaurants) {
            return 106;
        }
        if (isBrandScreen) {
            return 107;
        }
        return dataError;
    }

    public static String obtainAreaFromSlug(LocationConfigurationRepository locationConfigurationRepository) {
        int i11 = 0;
        for (int i12 = 0; i12 < appLink.getPathSegments().size(); i12++) {
            Matcher matcher = slugPattern.matcher(params.get(i12));
            slugChecker = matcher;
            if (matcher.find()) {
                stringSparseArray.put(i11, slugChecker.group(0));
                List<Area> areas = locationConfigurationRepository.areas();
                GlobalDataModel.SelectedAreaName = "";
                GlobalDataModel.SelectedAreaId = dataError;
                GlobalDataModel.SelectedCityId = dataError;
                GlobalDataModel.SelectedCityName = "";
                for (Area next : areas) {
                    if (slugChecker.group(0).toLowerCase().contains(next.getAreaName().toLowerCase())) {
                        String valueOf = String.valueOf(next.getId());
                        areaId = valueOf;
                        return valueOf;
                    }
                }
                i11++;
            }
        }
        return "";
    }

    public static void obtainCuisineFromUrl() {
        if (!TalabatUtils.isNullOrEmpty(cuisineId) && GlobalDataModel.cuisines != null) {
            int parseInt = Integer.parseInt(cuisineId);
            int i11 = 0;
            while (true) {
                Cuisine[] cuisineArr = GlobalDataModel.cuisines;
                if (i11 >= cuisineArr.length) {
                    break;
                }
                if (cuisineArr[i11].getId() == parseInt) {
                    Cuisine cuisine = new Cuisine();
                    cuisine.f13848id = GlobalDataModel.cuisines[i11].getId();
                    cuisine.f13849name = GlobalDataModel.cuisines[i11].getName();
                    cuisineSparseArray.put(cuisine.f13848id, cuisine);
                }
                i11++;
            }
        }
        int i12 = 0;
        for (int i13 = 0; i13 < appLink.getPathSegments().size(); i13++) {
            Matcher matcher = slugPattern.matcher(params.get(i13));
            slugChecker = matcher;
            if (matcher.find()) {
                stringSparseArray.put(i12, slugChecker.group(0));
                if (GlobalDataModel.cuisines != null) {
                    for (int i14 = 0; i14 < GlobalDataModel.cuisines.length; i14++) {
                        if (slugChecker.group(0).contains(GlobalDataModel.cuisines[i14].getName())) {
                            Cuisine cuisine2 = new Cuisine();
                            cuisine2.f13848id = GlobalDataModel.cuisines[i14].getId();
                            cuisine2.f13849name = GlobalDataModel.cuisines[i14].getName();
                            cuisineSparseArray.put(cuisine2.f13848id, cuisine2);
                        }
                    }
                }
                i12++;
            }
        }
        if (cuisineSparseArray != null) {
            FilterEngine filterEngine = new FilterEngine();
            filterEngine.setSelectedCuisines(cuisineSparseArray);
            GlobalDataModel.filterEngine = filterEngine;
        }
    }

    public static void obtainDataFromSlug(LocationConfigurationRepository locationConfigurationRepository) {
        int i11 = 0;
        for (int i12 = 0; i12 < appLink.getPathSegments().size(); i12++) {
            Matcher matcher = slugPattern.matcher(params.get(i12));
            slugChecker = matcher;
            if (matcher.find()) {
                stringSparseArray.put(i11, slugChecker.group(0));
                if (TalabatUtils.isNullOrEmpty(areaId)) {
                    for (Area next : locationConfigurationRepository.areas()) {
                        if (slugChecker.group(0).toLowerCase().contains(next.getAreaName().toLowerCase())) {
                            GlobalDataModel.SelectedAreaName = "";
                            GlobalDataModel.SelectedAreaId = dataError;
                            GlobalDataModel.SelectedCityId = dataError;
                            GlobalDataModel.SelectedCityName = "";
                            areaId = String.valueOf(next.getId());
                        }
                    }
                }
                if (GlobalDataModel.cuisines != null) {
                    for (int i13 = 0; i13 < GlobalDataModel.cuisines.length; i13++) {
                        if (slugChecker.group(0).contains(GlobalDataModel.cuisines[i13].getName())) {
                            Cuisine cuisine = new Cuisine();
                            cuisine.f13848id = GlobalDataModel.cuisines[i13].getId();
                            cuisine.f13849name = GlobalDataModel.cuisines[i13].getName();
                            cuisineSparseArray.put(cuisine.f13848id, cuisine);
                        }
                    }
                }
                if (!slugChecker.group(0).toLowerCase().contains(MenuScreenPerformanceParams.SCREEN_TYPE) && slugChecker.group(0).toLowerCase().contains("restaurant")) {
                    isAllRestaurants = false;
                    isMenu = false;
                    isAMP = false;
                    isListing = true;
                    isValidUrl = true;
                }
                i11++;
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:140|(2:142|143)|144|145|(1:149)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:144:0x0448 */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x026e A[Catch:{ Exception -> 0x04f4 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean processUrl(android.net.Uri r9) {
        /*
            java.lang.String r0 = "/"
            java.lang.String r1 = "(/)(\\d+)(/)"
            resetProcessor()     // Catch:{ Exception -> 0x04f4 }
            appLink = r9     // Catch:{ Exception -> 0x04f4 }
            android.util.SparseArray r9 = new android.util.SparseArray     // Catch:{ Exception -> 0x04f4 }
            r9.<init>()     // Catch:{ Exception -> 0x04f4 }
            stringSparseArray = r9     // Catch:{ Exception -> 0x04f4 }
            android.util.SparseArray r9 = new android.util.SparseArray     // Catch:{ Exception -> 0x04f4 }
            r9.<init>()     // Catch:{ Exception -> 0x04f4 }
            cuisineSparseArray = r9     // Catch:{ Exception -> 0x04f4 }
            android.net.Uri r9 = appLink     // Catch:{ Exception -> 0x04f4 }
            java.util.List r9 = r9.getPathSegments()     // Catch:{ Exception -> 0x04f4 }
            params = r9     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r9 = "(/restaurants?)(/)(\\d+)(/)(\\d+)?(/)?(restaurants?/)?"
            java.util.regex.Pattern r9 = java.util.regex.Pattern.compile(r9)     // Catch:{ Exception -> 0x04f4 }
            listPattern = r9     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r9 = "(/menu)(/)(\\d+)(/)((\\d+)(/))?"
            java.util.regex.Pattern r9 = java.util.regex.Pattern.compile(r9)     // Catch:{ Exception -> 0x04f4 }
            menuPattern = r9     // Catch:{ Exception -> 0x04f4 }
            java.util.regex.Pattern r9 = java.util.regex.Pattern.compile(r1)     // Catch:{ Exception -> 0x04f4 }
            validityPattern = r9     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r9 = "((\\w+)(-))+(\\w+)?"
            java.util.regex.Pattern r9 = java.util.regex.Pattern.compile(r9)     // Catch:{ Exception -> 0x04f4 }
            slugPattern = r9     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r9 = "(\\?cuisinetype=)(\\d+)"
            java.util.regex.Pattern r9 = java.util.regex.Pattern.compile(r9)     // Catch:{ Exception -> 0x04f4 }
            cuisinePattern = r9     // Catch:{ Exception -> 0x04f4 }
            java.util.regex.Pattern r9 = validityPattern     // Catch:{ Exception -> 0x04f4 }
            android.net.Uri r2 = appLink     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x04f4 }
            java.util.regex.Matcher r9 = r9.matcher(r2)     // Catch:{ Exception -> 0x04f4 }
            validityChecker = r9     // Catch:{ Exception -> 0x04f4 }
            java.util.regex.Pattern r9 = slugPattern     // Catch:{ Exception -> 0x04f4 }
            android.net.Uri r2 = appLink     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x04f4 }
            java.util.regex.Matcher r9 = r9.matcher(r2)     // Catch:{ Exception -> 0x04f4 }
            slugChecker = r9     // Catch:{ Exception -> 0x04f4 }
            android.net.Uri r9 = appLink     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r9 = r9.toLowerCase()     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r2 = "?cuisinetype="
            boolean r9 = r9.contains(r2)     // Catch:{ Exception -> 0x04f4 }
            r2 = 2
            if (r9 == 0) goto L_0x0094
            java.util.regex.Pattern r9 = cuisinePattern     // Catch:{ Exception -> 0x04f4 }
            android.net.Uri r3 = appLink     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r3 = r3.toLowerCase()     // Catch:{ Exception -> 0x04f4 }
            java.util.regex.Matcher r9 = r9.matcher(r3)     // Catch:{ Exception -> 0x04f4 }
            cuisineChecker = r9     // Catch:{ Exception -> 0x04f4 }
            boolean r9 = r9.find()     // Catch:{ Exception -> 0x04f4 }
            if (r9 == 0) goto L_0x0094
            java.util.regex.Matcher r9 = cuisineChecker     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r9 = r9.group(r2)     // Catch:{ Exception -> 0x04f4 }
            cuisineId = r9     // Catch:{ Exception -> 0x04f4 }
        L_0x0094:
            android.net.Uri r9 = appLink     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r9 = r9.toLowerCase()     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r3 = "/restaurants/"
            boolean r9 = r9.contains(r3)     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r3 = "aid="
            java.lang.String r4 = "/restaurant/"
            java.lang.String r5 = "/menu/"
            r6 = 1
            r7 = 0
            if (r9 == 0) goto L_0x00b9
            isAllRestaurants = r7     // Catch:{ Exception -> 0x04f4 }
            isMenu = r7     // Catch:{ Exception -> 0x04f4 }
            isListing = r6     // Catch:{ Exception -> 0x04f4 }
            isValidUrl = r6     // Catch:{ Exception -> 0x04f4 }
            isAMP = r7     // Catch:{ Exception -> 0x04f4 }
            goto L_0x0119
        L_0x00b9:
            android.net.Uri r9 = appLink     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r9 = r9.toLowerCase()     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r8 = "/restaurants"
            boolean r9 = r9.contains(r8)     // Catch:{ Exception -> 0x04f4 }
            if (r9 == 0) goto L_0x00d6
            isValidUrl = r6     // Catch:{ Exception -> 0x04f4 }
            isAllRestaurants = r6     // Catch:{ Exception -> 0x04f4 }
            isListing = r7     // Catch:{ Exception -> 0x04f4 }
            isMenu = r7     // Catch:{ Exception -> 0x04f4 }
            isAMP = r7     // Catch:{ Exception -> 0x04f4 }
            goto L_0x0119
        L_0x00d6:
            android.net.Uri r9 = appLink     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r9 = r9.toLowerCase()     // Catch:{ Exception -> 0x04f4 }
            boolean r9 = r9.contains(r5)     // Catch:{ Exception -> 0x04f4 }
            if (r9 != 0) goto L_0x010f
            android.net.Uri r9 = appLink     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r9 = r9.toLowerCase()     // Catch:{ Exception -> 0x04f4 }
            boolean r9 = r9.contains(r4)     // Catch:{ Exception -> 0x04f4 }
            if (r9 == 0) goto L_0x00f7
            goto L_0x010f
        L_0x00f7:
            android.net.Uri r9 = appLink     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r9 = r9.toLowerCase()     // Catch:{ Exception -> 0x04f4 }
            boolean r9 = r9.contains(r3)     // Catch:{ Exception -> 0x04f4 }
            if (r9 == 0) goto L_0x010c
            isValidUrl = r6     // Catch:{ Exception -> 0x04f4 }
            isAMP = r6     // Catch:{ Exception -> 0x04f4 }
            goto L_0x0119
        L_0x010c:
            isValidUrl = r6     // Catch:{ Exception -> 0x04f4 }
            goto L_0x0119
        L_0x010f:
            isValidUrl = r6     // Catch:{ Exception -> 0x04f4 }
            isListing = r7     // Catch:{ Exception -> 0x04f4 }
            isMenu = r6     // Catch:{ Exception -> 0x04f4 }
            isAMP = r7     // Catch:{ Exception -> 0x04f4 }
            isAllRestaurants = r7     // Catch:{ Exception -> 0x04f4 }
        L_0x0119:
            android.net.Uri r9 = appLink     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r9 = r9.toLowerCase()     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r8 = "/kw/"
            boolean r9 = r9.contains(r8)     // Catch:{ Exception -> 0x04f4 }
            if (r9 != 0) goto L_0x0266
            android.net.Uri r9 = appLink     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r9 = r9.toLowerCase()     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r8 = "/kuwait"
            boolean r9 = r9.contains(r8)     // Catch:{ Exception -> 0x04f4 }
            if (r9 == 0) goto L_0x013f
            goto L_0x0266
        L_0x013f:
            android.net.Uri r9 = appLink     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r9 = r9.toLowerCase()     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r8 = "/oman"
            boolean r9 = r9.contains(r8)     // Catch:{ Exception -> 0x04f4 }
            if (r9 == 0) goto L_0x0157
            java.lang.String r9 = "OMAN"
            selectedCountry = r9     // Catch:{ Exception -> 0x04f4 }
            goto L_0x026a
        L_0x0157:
            android.net.Uri r9 = appLink     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r9 = r9.toLowerCase()     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r8 = "/ksa"
            boolean r9 = r9.contains(r8)     // Catch:{ Exception -> 0x04f4 }
            if (r9 != 0) goto L_0x0261
            android.net.Uri r9 = appLink     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r9 = r9.toLowerCase()     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r8 = "/ksa/"
            boolean r9 = r9.contains(r8)     // Catch:{ Exception -> 0x04f4 }
            if (r9 != 0) goto L_0x0261
            android.net.Uri r9 = appLink     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r9 = r9.toLowerCase()     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r8 = "/sa/"
            boolean r9 = r9.contains(r8)     // Catch:{ Exception -> 0x04f4 }
            if (r9 != 0) goto L_0x0261
            android.net.Uri r9 = appLink     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r9 = r9.toLowerCase()     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r8 = "saudi"
            boolean r9 = r9.contains(r8)     // Catch:{ Exception -> 0x04f4 }
            if (r9 == 0) goto L_0x01a1
            goto L_0x0261
        L_0x01a1:
            android.net.Uri r9 = appLink     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r9 = r9.toLowerCase()     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r8 = "/qatar"
            boolean r9 = r9.contains(r8)     // Catch:{ Exception -> 0x04f4 }
            if (r9 == 0) goto L_0x01b9
            java.lang.String r9 = "QATAR"
            selectedCountry = r9     // Catch:{ Exception -> 0x04f4 }
            goto L_0x026a
        L_0x01b9:
            android.net.Uri r9 = appLink     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r9 = r9.toLowerCase()     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r8 = "/bahrain"
            boolean r9 = r9.contains(r8)     // Catch:{ Exception -> 0x04f4 }
            if (r9 != 0) goto L_0x025c
            android.net.Uri r9 = appLink     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r9 = r9.toLowerCase()     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r8 = "/bh/"
            boolean r9 = r9.contains(r8)     // Catch:{ Exception -> 0x04f4 }
            if (r9 == 0) goto L_0x01df
            goto L_0x025c
        L_0x01df:
            android.net.Uri r9 = appLink     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r9 = r9.toLowerCase()     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r8 = "/uae"
            boolean r9 = r9.contains(r8)     // Catch:{ Exception -> 0x04f4 }
            if (r9 != 0) goto L_0x0257
            android.net.Uri r9 = appLink     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r9 = r9.toLowerCase()     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r8 = "/ae/"
            boolean r9 = r9.contains(r8)     // Catch:{ Exception -> 0x04f4 }
            if (r9 == 0) goto L_0x0204
            goto L_0x0257
        L_0x0204:
            android.net.Uri r9 = appLink     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r9 = r9.toLowerCase()     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r8 = "/jordan"
            boolean r9 = r9.contains(r8)     // Catch:{ Exception -> 0x04f4 }
            if (r9 != 0) goto L_0x0252
            android.net.Uri r9 = appLink     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r9 = r9.toLowerCase()     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r8 = "/jo/"
            boolean r9 = r9.contains(r8)     // Catch:{ Exception -> 0x04f4 }
            if (r9 == 0) goto L_0x0229
            goto L_0x0252
        L_0x0229:
            android.net.Uri r9 = appLink     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r9 = r9.toLowerCase()     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r8 = "/egypt"
            boolean r9 = r9.contains(r8)     // Catch:{ Exception -> 0x04f4 }
            if (r9 != 0) goto L_0x024d
            android.net.Uri r9 = appLink     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r9 = r9.toLowerCase()     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r8 = "/eg/"
            boolean r9 = r9.contains(r8)     // Catch:{ Exception -> 0x04f4 }
            if (r9 == 0) goto L_0x026a
        L_0x024d:
            java.lang.String r9 = "EGYPT"
            selectedCountry = r9     // Catch:{ Exception -> 0x04f4 }
            goto L_0x026a
        L_0x0252:
            java.lang.String r9 = "JORDAN"
            selectedCountry = r9     // Catch:{ Exception -> 0x04f4 }
            goto L_0x026a
        L_0x0257:
            java.lang.String r9 = "UAE"
            selectedCountry = r9     // Catch:{ Exception -> 0x04f4 }
            goto L_0x026a
        L_0x025c:
            java.lang.String r9 = "BAHRAIN"
            selectedCountry = r9     // Catch:{ Exception -> 0x04f4 }
            goto L_0x026a
        L_0x0261:
            java.lang.String r9 = "KSA"
            selectedCountry = r9     // Catch:{ Exception -> 0x04f4 }
            goto L_0x026a
        L_0x0266:
            java.lang.String r9 = "KUWAIT"
            selectedCountry = r9     // Catch:{ Exception -> 0x04f4 }
        L_0x026a:
            boolean r9 = isValidUrl     // Catch:{ Exception -> 0x04f4 }
            if (r9 == 0) goto L_0x04f1
            boolean r9 = isListing     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r8 = ""
            if (r9 == 0) goto L_0x02bc
            java.util.regex.Matcher r9 = validityChecker     // Catch:{ Exception -> 0x04f4 }
            boolean r9 = r9.find()     // Catch:{ Exception -> 0x04f4 }
            if (r9 == 0) goto L_0x037c
            java.lang.String r9 = "(restaurants)"
            java.util.regex.Pattern r9 = java.util.regex.Pattern.compile(r9)     // Catch:{ Exception -> 0x04f4 }
            android.net.Uri r4 = appLink     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r4 = r4.toLowerCase()     // Catch:{ Exception -> 0x04f4 }
            java.util.regex.Matcher r9 = r9.matcher(r4)     // Catch:{ Exception -> 0x04f4 }
            boolean r9 = r9.find()     // Catch:{ Exception -> 0x04f4 }
            if (r9 == 0) goto L_0x037c
            isAMP = r7     // Catch:{ Exception -> 0x04f4 }
            isMenu = r7     // Catch:{ Exception -> 0x04f4 }
            isListing = r6     // Catch:{ Exception -> 0x04f4 }
            java.util.regex.Pattern r9 = java.util.regex.Pattern.compile(r1)     // Catch:{ Exception -> 0x04f4 }
            android.net.Uri r1 = appLink     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r1 = r1.toLowerCase()     // Catch:{ Exception -> 0x04f4 }
            java.util.regex.Matcher r9 = r9.matcher(r1)     // Catch:{ Exception -> 0x04f4 }
            boolean r1 = r9.find()     // Catch:{ Exception -> 0x04f4 }
            if (r1 == 0) goto L_0x037c
            java.lang.String r9 = r9.group(r2)     // Catch:{ Exception -> 0x04f4 }
            areaId = r9     // Catch:{ Exception -> 0x04f4 }
            goto L_0x037c
        L_0x02bc:
            boolean r9 = isMenu     // Catch:{ Exception -> 0x04f4 }
            if (r9 == 0) goto L_0x032e
            java.util.regex.Matcher r9 = validityChecker     // Catch:{ Exception -> 0x04f4 }
            boolean r9 = r9.find()     // Catch:{ Exception -> 0x04f4 }
            if (r9 == 0) goto L_0x037c
            isMenu = r6     // Catch:{ Exception -> 0x04f4 }
            isAMP = r7     // Catch:{ Exception -> 0x04f4 }
            isListing = r7     // Catch:{ Exception -> 0x04f4 }
            areaId = r8     // Catch:{ Exception -> 0x04f4 }
            android.net.Uri r9 = appLink     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r9 = r9.toLowerCase()     // Catch:{ Exception -> 0x04f4 }
            boolean r9 = r9.contains(r5)     // Catch:{ Exception -> 0x04f4 }
            if (r9 == 0) goto L_0x02e3
            java.lang.String r9 = "(menu)"
            goto L_0x02f7
        L_0x02e3:
            android.net.Uri r9 = appLink     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r9 = r9.toLowerCase()     // Catch:{ Exception -> 0x04f4 }
            boolean r9 = r9.contains(r4)     // Catch:{ Exception -> 0x04f4 }
            if (r9 == 0) goto L_0x02f6
            java.lang.String r9 = "(restaurant)"
            goto L_0x02f7
        L_0x02f6:
            r9 = r8
        L_0x02f7:
            java.util.regex.Pattern r9 = java.util.regex.Pattern.compile(r9)     // Catch:{ Exception -> 0x04f4 }
            android.net.Uri r4 = appLink     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r4 = r4.toLowerCase()     // Catch:{ Exception -> 0x04f4 }
            java.util.regex.Matcher r9 = r9.matcher(r4)     // Catch:{ Exception -> 0x04f4 }
            boolean r9 = r9.find()     // Catch:{ Exception -> 0x04f4 }
            if (r9 == 0) goto L_0x037c
            java.util.regex.Pattern r9 = java.util.regex.Pattern.compile(r1)     // Catch:{ Exception -> 0x04f4 }
            android.net.Uri r1 = appLink     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r1 = r1.toLowerCase()     // Catch:{ Exception -> 0x04f4 }
            java.util.regex.Matcher r9 = r9.matcher(r1)     // Catch:{ Exception -> 0x04f4 }
            boolean r1 = r9.find()     // Catch:{ Exception -> 0x04f4 }
            if (r1 == 0) goto L_0x037c
            java.lang.String r9 = r9.group(r2)     // Catch:{ Exception -> 0x04f4 }
            branchId = r9     // Catch:{ Exception -> 0x04f4 }
            goto L_0x037c
        L_0x032e:
            android.net.Uri r9 = appLink     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r9 = getCountryNameForBrandScreen(r9)     // Catch:{ Exception -> 0x04f4 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x04f4 }
            r1.<init>()     // Catch:{ Exception -> 0x04f4 }
            r1.append(r9)     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r4 = "((\\w+)+((-)+(\\w+)?)?)"
            r1.append(r4)     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x04f4 }
            java.util.regex.Pattern r1 = java.util.regex.Pattern.compile(r1)     // Catch:{ Exception -> 0x04f4 }
            android.net.Uri r4 = appLink     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r4 = r4.toLowerCase()     // Catch:{ Exception -> 0x04f4 }
            java.util.regex.Matcher r1 = r1.matcher(r4)     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r4 = areaId     // Catch:{ Exception -> 0x04f4 }
            com.talabat.helpers.TalabatUtils.isNullOrEmpty((java.lang.String) r4)     // Catch:{ Exception -> 0x04f4 }
            boolean r4 = r1.find()     // Catch:{ Exception -> 0x04f4 }
            if (r4 == 0) goto L_0x037a
            int r4 = r1.groupCount()     // Catch:{ Exception -> 0x04f4 }
            if (r4 <= 0) goto L_0x037c
            java.lang.String r1 = r1.group(r6)     // Catch:{ Exception -> 0x04f4 }
            boolean r9 = checkForRestaurants(r1, r9)     // Catch:{ Exception -> 0x04f4 }
            if (r9 == 0) goto L_0x0375
            isBrandScreen = r6     // Catch:{ Exception -> 0x04f4 }
            goto L_0x037c
        L_0x0375:
            isBrandScreen = r7     // Catch:{ Exception -> 0x04f4 }
            isValidUrl = r7     // Catch:{ Exception -> 0x04f4 }
            goto L_0x037c
        L_0x037a:
            isValidUrl = r7     // Catch:{ Exception -> 0x04f4 }
        L_0x037c:
            android.net.Uri r9 = appLink     // Catch:{ Exception -> 0x04f4 }
            if (r9 == 0) goto L_0x039f
            java.util.regex.Pattern r1 = listPattern     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r9 = r9.toLowerCase()     // Catch:{ Exception -> 0x04f4 }
            java.util.regex.Matcher r9 = r1.matcher(r9)     // Catch:{ Exception -> 0x04f4 }
            java.util.regex.Pattern r1 = menuPattern     // Catch:{ Exception -> 0x04f4 }
            android.net.Uri r4 = appLink     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r4 = r4.toLowerCase()     // Catch:{ Exception -> 0x04f4 }
            java.util.regex.Matcher r1 = r1.matcher(r4)     // Catch:{ Exception -> 0x04f4 }
            goto L_0x03a1
        L_0x039f:
            r9 = 0
            r1 = r9
        L_0x03a1:
            boolean r4 = isListing     // Catch:{ Exception -> 0x04f4 }
            r5 = 4
            if (r4 == 0) goto L_0x0412
            java.lang.String r0 = areaId     // Catch:{ Exception -> 0x04f4 }
            boolean r0 = com.talabat.helpers.TalabatUtils.isNullOrEmpty((java.lang.String) r0)     // Catch:{ Exception -> 0x04f4 }
            if (r0 != 0) goto L_0x03b6
            java.lang.String r0 = cuisineId     // Catch:{ Exception -> 0x04f4 }
            boolean r0 = com.talabat.helpers.TalabatUtils.isNullOrEmpty((java.lang.String) r0)     // Catch:{ Exception -> 0x04f4 }
            if (r0 == 0) goto L_0x04f1
        L_0x03b6:
            boolean r0 = r9.find()     // Catch:{ Exception -> 0x04f4 }
            if (r0 == 0) goto L_0x04f1
            isMenu = r7     // Catch:{ Exception -> 0x04f4 }
            isListing = r6     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r0 = "(/)(\\d+)(/)(\\d+)?(/)?"
            java.util.regex.Pattern r0 = java.util.regex.Pattern.compile(r0)     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r9 = r9.group()     // Catch:{ Exception -> 0x04f4 }
            java.util.regex.Matcher r9 = r0.matcher(r9)     // Catch:{ Exception -> 0x04f4 }
            boolean r0 = r9.find()     // Catch:{ Exception -> 0x04f4 }
            if (r0 == 0) goto L_0x04f1
            java.lang.String r0 = r9.group(r2)     // Catch:{ Exception -> 0x04f4 }
            if (r0 == 0) goto L_0x03f2
            java.lang.String r0 = r9.group(r2)     // Catch:{ Exception -> 0x04f4 }
            boolean r0 = r0.isEmpty()     // Catch:{ Exception -> 0x04f4 }
            if (r0 != 0) goto L_0x03f2
            java.lang.String r0 = areaId     // Catch:{ Exception -> 0x04f4 }
            boolean r0 = com.talabat.helpers.TalabatUtils.isNullOrEmpty((java.lang.String) r0)     // Catch:{ Exception -> 0x04f4 }
            if (r0 == 0) goto L_0x03f2
            java.lang.String r0 = r9.group(r2)     // Catch:{ Exception -> 0x04f4 }
            areaId = r0     // Catch:{ Exception -> 0x04f4 }
        L_0x03f2:
            java.lang.String r0 = r9.group(r5)     // Catch:{ Exception -> 0x04f4 }
            if (r0 == 0) goto L_0x04f1
            java.lang.String r0 = r9.group(r5)     // Catch:{ Exception -> 0x04f4 }
            boolean r0 = r0.isEmpty()     // Catch:{ Exception -> 0x04f4 }
            if (r0 != 0) goto L_0x04f1
            java.lang.String r0 = cuisineId     // Catch:{ Exception -> 0x04f4 }
            boolean r0 = com.talabat.helpers.TalabatUtils.isNullOrEmpty((java.lang.String) r0)     // Catch:{ Exception -> 0x04f4 }
            if (r0 == 0) goto L_0x04f1
            java.lang.String r9 = r9.group(r5)     // Catch:{ Exception -> 0x04f4 }
            cuisineId = r9     // Catch:{ Exception -> 0x04f4 }
            goto L_0x04f1
        L_0x0412:
            boolean r9 = isMenu     // Catch:{ Exception -> 0x04f4 }
            if (r9 == 0) goto L_0x04f1
            android.net.Uri r9 = appLink     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r9 = r9.toLowerCase()     // Catch:{ Exception -> 0x04f4 }
            boolean r9 = r9.contains(r3)     // Catch:{ Exception -> 0x04f4 }
            if (r9 == 0) goto L_0x0487
            isMenu = r6     // Catch:{ Exception -> 0x04f4 }
            isAMP = r6     // Catch:{ Exception -> 0x04f4 }
            isListing = r7     // Catch:{ Exception -> 0x04f4 }
            android.net.Uri r9 = appLink     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r9 = r9.getQuery()     // Catch:{ Exception -> 0x04f4 }
            boolean r9 = com.talabat.helpers.TalabatUtils.isNullOrEmpty((java.lang.String) r9)     // Catch:{ Exception -> 0x04f4 }
            if (r9 != 0) goto L_0x0448
            android.net.Uri r9 = appLink     // Catch:{ Exception -> 0x0448 }
            java.lang.String r9 = r9.getQuery()     // Catch:{ Exception -> 0x0448 }
            java.lang.String r3 = "="
            java.lang.String[] r9 = r9.split(r3)     // Catch:{ Exception -> 0x0448 }
            r9 = r9[r6]     // Catch:{ Exception -> 0x0448 }
            areaId = r9     // Catch:{ Exception -> 0x0448 }
        L_0x0448:
            android.net.Uri r9 = appLink     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r9 = getCountryNameForBrandScreen(r9)     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r9 = r9.replace(r0, r8)     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r3 = "(\\w+)+((-)(\\w+))*"
            java.util.regex.Pattern r3 = java.util.regex.Pattern.compile(r3)     // Catch:{ Exception -> 0x04f4 }
            android.net.Uri r4 = appLink     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r4 = r4.toLowerCase()     // Catch:{ Exception -> 0x04f4 }
            android.net.Uri r8 = appLink     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x04f4 }
            int r0 = r8.lastIndexOf(r0)     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r0 = r4.substring(r0)     // Catch:{ Exception -> 0x04f4 }
            java.util.regex.Matcher r0 = r3.matcher(r0)     // Catch:{ Exception -> 0x04f4 }
            boolean r3 = r0.find()     // Catch:{ Exception -> 0x04f4 }
            if (r3 == 0) goto L_0x0487
            int r3 = r0.groupCount()     // Catch:{ Exception -> 0x04f4 }
            if (r3 <= 0) goto L_0x0487
            java.lang.String r0 = r0.group(r7)     // Catch:{ Exception -> 0x04f4 }
            checkForRestaurants(r0, r9)     // Catch:{ Exception -> 0x04f4 }
        L_0x0487:
            java.lang.String r9 = areaId     // Catch:{ Exception -> 0x04f4 }
            boolean r9 = com.talabat.helpers.TalabatUtils.isNullOrEmpty((java.lang.String) r9)     // Catch:{ Exception -> 0x04f4 }
            if (r9 != 0) goto L_0x0497
            java.lang.String r9 = branchId     // Catch:{ Exception -> 0x04f4 }
            boolean r9 = com.talabat.helpers.TalabatUtils.isNullOrEmpty((java.lang.String) r9)     // Catch:{ Exception -> 0x04f4 }
            if (r9 == 0) goto L_0x04f1
        L_0x0497:
            boolean r9 = r1.find()     // Catch:{ Exception -> 0x04f4 }
            if (r9 == 0) goto L_0x04f1
            isMenu = r6     // Catch:{ Exception -> 0x04f4 }
            isListing = r7     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r9 = "(/)(\\d+)(/)(\\d+)(/)"
            java.util.regex.Pattern r9 = java.util.regex.Pattern.compile(r9)     // Catch:{ Exception -> 0x04f4 }
            java.lang.String r0 = r1.group()     // Catch:{ Exception -> 0x04f4 }
            java.util.regex.Matcher r9 = r9.matcher(r0)     // Catch:{ Exception -> 0x04f4 }
            boolean r0 = r9.find()     // Catch:{ Exception -> 0x04f4 }
            if (r0 == 0) goto L_0x04f1
            java.lang.String r0 = r9.group(r2)     // Catch:{ Exception -> 0x04f4 }
            if (r0 == 0) goto L_0x04d3
            java.lang.String r0 = r9.group(r2)     // Catch:{ Exception -> 0x04f4 }
            boolean r0 = r0.isEmpty()     // Catch:{ Exception -> 0x04f4 }
            if (r0 != 0) goto L_0x04d3
            java.lang.String r0 = areaId     // Catch:{ Exception -> 0x04f4 }
            boolean r0 = com.talabat.helpers.TalabatUtils.isNullOrEmpty((java.lang.String) r0)     // Catch:{ Exception -> 0x04f4 }
            if (r0 == 0) goto L_0x04d3
            java.lang.String r0 = r9.group(r2)     // Catch:{ Exception -> 0x04f4 }
            areaId = r0     // Catch:{ Exception -> 0x04f4 }
        L_0x04d3:
            java.lang.String r0 = r9.group(r5)     // Catch:{ Exception -> 0x04f4 }
            if (r0 == 0) goto L_0x04f1
            java.lang.String r0 = r9.group(r5)     // Catch:{ Exception -> 0x04f4 }
            boolean r0 = r0.isEmpty()     // Catch:{ Exception -> 0x04f4 }
            if (r0 != 0) goto L_0x04f1
            java.lang.String r0 = branchId     // Catch:{ Exception -> 0x04f4 }
            boolean r0 = com.talabat.helpers.TalabatUtils.isNullOrEmpty((java.lang.String) r0)     // Catch:{ Exception -> 0x04f4 }
            if (r0 == 0) goto L_0x04f1
            java.lang.String r9 = r9.group(r5)     // Catch:{ Exception -> 0x04f4 }
            branchId = r9     // Catch:{ Exception -> 0x04f4 }
        L_0x04f1:
            boolean r9 = isValidUrl     // Catch:{ Exception -> 0x04f4 }
            return r9
        L_0x04f4:
            r9 = move-exception
            r9.getMessage()
            boolean r9 = isValidUrl
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: tracking.deeplink.AppUrlResult.processUrl(android.net.Uri):boolean");
    }

    private static void resetProcessor() {
        selectedCountry = "";
        areaId = "";
        cuisineId = "";
        branchId = "";
        isListing = false;
        isAllRestaurants = false;
        isMenu = false;
        isAMP = false;
        isValidUrl = false;
        listPattern = null;
        menuPattern = null;
        validityPattern = null;
        slugPattern = null;
        cuisinePattern = null;
        validityChecker = null;
        cuisineChecker = null;
        slugChecker = null;
        countriesAvailable = false;
        areasAvailable = false;
        cuisinesAvailable = false;
        currentRestaurantSlug = "";
        countryNameSlug = "";
        isBrandScreen = false;
    }

    public static SparseArray<Cuisine> getCuisineIdFromUrl() {
        try {
            SparseArray<Cuisine> sparseArray = cuisineSparseArray;
            if (sparseArray != null) {
                return sparseArray;
            }
            return null;
        } catch (Exception unused) {
        }
    }
}
