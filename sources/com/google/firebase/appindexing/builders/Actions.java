package com.google.firebase.appindexing.builders;

import androidx.annotation.NonNull;
import com.google.firebase.appindexing.Action;

public final class Actions {
    @NonNull
    public static Action newView(@NonNull String str, @NonNull String str2) {
        Action.Builder builder = new Action.Builder(Action.Builder.VIEW_ACTION);
        builder.setObject(str, str2);
        return builder.build();
    }
}
