package com.instabug.library.sessionV3.providers;

import com.instabug.library.model.UserAttributes;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface g {
    @NotNull
    String a(@Nullable UserAttributes userAttributes);

    @NotNull
    String a(@NotNull List list);

    @NotNull
    String b(@Nullable UserAttributes userAttributes);

    @NotNull
    String b(@NotNull List list);

    @Nullable
    String f();

    @NotNull
    String getUuid();

    @NotNull
    List j();

    @Nullable
    String l();

    boolean m();

    @Nullable
    UserAttributes n();
}
