package fwfd.com.fwfsdk.util;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import fwfd.com.fwfsdk.model.dao.FWFDBDAO;
import fwfd.com.fwfsdk.model.db.FWFFeature;
import fwfd.com.fwfsdk.model.db.FWFFlagKey;
import fwfd.com.fwfsdk.model.db.FWFSDKInfo;

@Database(entities = {FWFFlagKey.class, FWFSDKInfo.class, FWFFeature.class}, exportSchema = false, version = 12)
@TypeConverters({FWFAnyConverter.class, FWFStringListConverter.class, FWFMapConverter.class})
public abstract class FWFDBRoom extends RoomDatabase {
    private static volatile FWFDBRoom INSTANCE;

    public static FWFDBRoom getDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (FWFDBRoom.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), FWFDBRoom.class, "FWF.db").fallbackToDestructiveMigration().build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract FWFDBDAO dao();
}
