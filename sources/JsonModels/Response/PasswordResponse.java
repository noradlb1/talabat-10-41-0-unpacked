package JsonModels.Response;

import com.google.gson.annotations.SerializedName;

public class PasswordResponse {
    @SerializedName("success")
    public boolean isSuccess;
    public String result;
}
