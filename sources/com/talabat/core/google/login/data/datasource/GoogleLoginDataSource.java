package com.talabat.core.google.login.data.datasource;

import com.talabat.core.google.login.data.dto.GoogleLoginDto;
import io.reactivex.Completable;
import io.reactivex.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&¨\u0006\r"}, d2 = {"Lcom/talabat/core/google/login/data/datasource/GoogleLoginDataSource;", "", "initialize", "", "requestIdToken", "", "login", "Lio/reactivex/Single;", "Lcom/talabat/core/google/login/data/dto/GoogleLoginDto;", "requestCode", "", "logout", "Lio/reactivex/Completable;", "com_talabat_core_social-login_google_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface GoogleLoginDataSource {
    void initialize(@NotNull String str);

    @NotNull
    Single<GoogleLoginDto> login(int i11);

    @NotNull
    Completable logout();
}
