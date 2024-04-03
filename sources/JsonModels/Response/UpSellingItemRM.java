package JsonModels.Response;

import com.google.gson.annotations.SerializedName;
import datamodels.MenuItem;
import java.util.ArrayList;

public class UpSellingItemRM {
    public boolean iqd;
    @SerializedName("usil")
    public ArrayList<MenuItem> upsellingItems;
}
