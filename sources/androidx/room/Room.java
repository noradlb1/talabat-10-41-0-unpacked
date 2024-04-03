package androidx.room;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.room.RoomDatabase;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;

public class Room {
    private static final String CURSOR_CONV_SUFFIX = "_CursorConverter";
    public static final String MASTER_TABLE_NAME = "room_master_table";

    @NonNull
    public static <T extends RoomDatabase> RoomDatabase.Builder<T> databaseBuilder(@NonNull Context context, @NonNull Class<T> cls, @NonNull String str) {
        if (str != null && str.trim().length() != 0) {
            return new RoomDatabase.Builder<>(context, cls, str);
        }
        throw new IllegalArgumentException("Cannot build a database with null or empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder");
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static <T, C> T getGeneratedImplementation(@NonNull Class<C> cls, @NonNull String str) {
        String str2;
        String name2 = cls.getPackage().getName();
        String canonicalName = cls.getCanonicalName();
        if (!name2.isEmpty()) {
            canonicalName = canonicalName.substring(name2.length() + 1);
        }
        String str3 = canonicalName.replace('.', '_') + str;
        try {
            if (name2.isEmpty()) {
                str2 = str3;
            } else {
                str2 = name2 + RealDiscoveryConfigurationRepository.VERSION_DELIMETER + str3;
            }
            return Class.forName(str2, true, cls.getClassLoader()).newInstance();
        } catch (ClassNotFoundException unused) {
            throw new RuntimeException("cannot find implementation for " + cls.getCanonicalName() + ". " + str3 + " does not exist");
        } catch (IllegalAccessException unused2) {
            throw new RuntimeException("Cannot access the constructor" + cls.getCanonicalName());
        } catch (InstantiationException unused3) {
            throw new RuntimeException("Failed to create an instance of " + cls.getCanonicalName());
        }
    }

    @NonNull
    public static <T extends RoomDatabase> RoomDatabase.Builder<T> inMemoryDatabaseBuilder(@NonNull Context context, @NonNull Class<T> cls) {
        return new RoomDatabase.Builder<>(context, cls, (String) null);
    }
}
