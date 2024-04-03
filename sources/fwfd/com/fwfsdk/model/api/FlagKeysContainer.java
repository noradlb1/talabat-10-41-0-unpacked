package fwfd.com.fwfsdk.model.api;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class FlagKeysContainer {
    @SerializedName("result")
    private List<FlagKey> flagKeys;

    public FlagKeysContainer(List<FlagKey> list) {
        this.flagKeys = list;
    }

    public List<FlagKey> getFlagKeys() {
        return this.flagKeys;
    }

    public List<String> getKeys() {
        ArrayList arrayList = new ArrayList();
        for (FlagKey key : this.flagKeys) {
            arrayList.add(key.getKey());
        }
        return arrayList;
    }

    public void setFlagKeys(List<FlagKey> list) {
        this.flagKeys = list;
    }

    public FlagKeysContainer() {
    }
}
