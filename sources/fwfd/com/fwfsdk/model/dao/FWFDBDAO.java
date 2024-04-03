package fwfd.com.fwfsdk.model.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import fwfd.com.fwfsdk.model.db.FWFFeature;
import fwfd.com.fwfsdk.model.db.FWFFlagId;
import fwfd.com.fwfsdk.model.db.FWFFlagKey;
import fwfd.com.fwfsdk.model.db.FWFSDKInfo;
import java.util.List;

@Dao
public abstract class FWFDBDAO {
    @Query("DELETE FROM FWFFlagKey WHERE token = :accessToken")
    public abstract void deleteAllFlagKeys(String str);

    @Query("DELETE FROM FWFFeature")
    public abstract void deleteAllFlagRecords();

    @Query("DELETE FROM FWFFeature WHERE accessToken = :accessToken")
    public abstract void deleteAllFlagsFromEnvironment(String str);

    @Transaction
    public void deleteAndInsertNewFlagKeys(List<FWFFlagKey> list, String str) {
        deleteAllFlagKeys(str);
        insertFlagKeys(list);
    }

    @Query("SELECT * FROM FWFFeature WHERE abTest = 1")
    public abstract List<FWFFeature> getAllExperiments();

    @Query("SELECT `key`, accessToken, date FROM FWFFeature WHERE relevantContext LIKE :userAttribute AND subscribe = 1")
    public abstract List<FWFFlagId> getAllFlagKeysByRelevantContext(String str);

    @Query("SELECT * FROM FWFFeature")
    public abstract List<FWFFeature> getAllFlags();

    @Query("SELECT * FROM FWFFeature WHERE accessToken = :accessToken")
    public abstract List<FWFFeature> getAllFlagsFromEnvironment(String str);

    @Query("SELECT * FROM FWFFeature WHERE `key` = :flagKey AND accessToken = :accessToken LIMIT 1")
    public abstract FWFFeature getFlagById(String str, String str2);

    @Query("SELECT * FROM FWFFlagKey WHERE token = :accessToken")
    public abstract List<FWFFlagKey> getFlagKeys(String str);

    @Query("SELECT * FROM FWFFeature WHERE `key` IN (:flagKeys) AND accessToken = :accessToken")
    public abstract List<FWFFeature> getFlagsById(List<String> list, String str);

    @Query("SELECT * FROM FWFSDKInfo ORDER BY versionNumber DESC LIMIT 1")
    public abstract FWFSDKInfo getLastSDKInfo();

    @Query("SELECT `key`, accessToken, date FROM FWFFeature WHERE accessToken = :accessToken ORDER BY date DESC LIMIT 1")
    public abstract FWFFlagId getOldestUpdatedFlagFromEnvironment(String str);

    @Query("SELECT `key`, accessToken, date FROM FWFFeature WHERE subscribe = 1")
    public abstract List<FWFFlagId> getSubscribedFlagIds();

    @Insert(onConflict = 1)
    public abstract void insertFlag(FWFFeature fWFFeature);

    @Insert(onConflict = 1)
    public abstract void insertFlagKeys(List<FWFFlagKey> list);

    @Insert(onConflict = 1)
    public abstract void insertFlags(List<FWFFeature> list);

    @Insert(onConflict = 5)
    public abstract void insertSDKInfo(FWFSDKInfo fWFSDKInfo);
}
