package com.talabat.darkstores.data.recentsearches.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Database(entities = {SearchQueryRecord.class}, version = 1)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&¨\u0006\u0006"}, d2 = {"Lcom/talabat/darkstores/data/recentsearches/local/RecentSearchesDatabase;", "Landroidx/room/RoomDatabase;", "()V", "recentSearchesDao", "Lcom/talabat/darkstores/data/recentsearches/local/RecentSearchesDao;", "Companion", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class RecentSearchesDatabase extends RoomDatabase {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String DATABASE_NAME = "RecentSearches";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/darkstores/data/recentsearches/local/RecentSearchesDatabase$Companion;", "", "()V", "DATABASE_NAME", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @NotNull
    public abstract RecentSearchesDao recentSearchesDao();
}
