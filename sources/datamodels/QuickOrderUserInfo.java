package datamodels;

import JsonModels.parser.UniversalGson;
import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;

@Instrumented
public class QuickOrderUserInfo {
    public String email;
    public String firstName;
    public String lastName;
    public String mobileNumber;
    public String mobileNumberCountryCode;
    public String password;
    public String phoneNumber;

    public static boolean IsQuickOrderUSerinfoLastSelectedCountry(Context context) {
        if (GlobalDataModel.SelectedCountryId == context.getSharedPreferences(GlobalConstants.PrefsConstants.getNAME(), 0).getInt("lastquickordercountryID", 0)) {
            return false;
        }
        return true;
    }

    public static QuickOrderUserInfo getSavedQuickOrderUserData(Context context) {
        Object obj;
        SharedPreferences sharedPreferences = context.getSharedPreferences(GlobalConstants.PrefsConstants.getNAME(), 0);
        Gson gson = UniversalGson.INSTANCE.gson;
        if (!sharedPreferences.contains("" + GlobalDataModel.quickOrderUserId)) {
            return null;
        }
        try {
            String string = sharedPreferences.getString("" + GlobalDataModel.quickOrderUserId, "");
            Class cls = QuickOrderUserInfo.class;
            if (!(gson instanceof Gson)) {
                obj = gson.fromJson(string, cls);
            } else {
                obj = GsonInstrumentation.fromJson(gson, string, cls);
            }
            return (QuickOrderUserInfo) obj;
        } catch (Exception unused) {
            return null;
        }
    }

    public static QuickOrderUserInfo getSavedQuickOrderUserDataCountry(Context context) {
        Object obj;
        SharedPreferences sharedPreferences = context.getSharedPreferences(GlobalConstants.PrefsConstants.getNAME(), 0);
        Gson gson = UniversalGson.INSTANCE.gson;
        try {
            String string = sharedPreferences.getString("Sales_Froce" + GlobalDataModel.SelectedCountryId, "");
            Class cls = QuickOrderUserInfo.class;
            if (!(gson instanceof Gson)) {
                obj = gson.fromJson(string, cls);
            } else {
                obj = GsonInstrumentation.fromJson(gson, string, cls);
            }
            return (QuickOrderUserInfo) obj;
        } catch (Exception unused) {
            return null;
        }
    }
}
