package com.talabat.darkstores.di;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.room.Room;
import com.talabat.darkstores.data.recentsearches.local.RecentSearchesDao;
import com.talabat.darkstores.data.recentsearches.local.RecentSearchesDatabase;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\r"}, d2 = {"Lcom/talabat/darkstores/di/DarkstoresDatabaseModule;", "", "()V", "provideRecentSearchesDao", "Lcom/talabat/darkstores/data/recentsearches/local/RecentSearchesDao;", "database", "Lcom/talabat/darkstores/data/recentsearches/local/RecentSearchesDatabase;", "provideRecentSearchesDatabase", "context", "Landroid/content/Context;", "provideSharedPreferences", "Landroid/content/SharedPreferences;", "Companion", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class DarkstoresDatabaseModule {
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @Deprecated
    private static final String PREFERENCES_NAME = "darkstores_preferences";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/darkstores/di/DarkstoresDatabaseModule$Companion;", "", "()V", "PREFERENCES_NAME", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @NotNull
    @Reusable
    @Provides
    public final RecentSearchesDao provideRecentSearchesDao(@NotNull RecentSearchesDatabase recentSearchesDatabase) {
        Intrinsics.checkNotNullParameter(recentSearchesDatabase, "database");
        return recentSearchesDatabase.recentSearchesDao();
    }

    @NotNull
    @Provides
    public final RecentSearchesDatabase provideRecentSearchesDatabase(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        RecentSearchesDatabase build = Room.databaseBuilder(context, RecentSearchesDatabase.class, RecentSearchesDatabase.DATABASE_NAME).fallbackToDestructiveMigration().build();
        Intrinsics.checkNotNullExpressionValue(build, "databaseBuilder(\n       …on()\n            .build()");
        return build;
    }

    @NotNull
    @Provides
    public final SharedPreferences provideSharedPreferences(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFERENCES_NAME, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…xt.MODE_PRIVATE\n        )");
        return sharedPreferences;
    }
}
