package com.talabat.core.facebook.login.data.datasource;

import com.talabat.core.facebook.login.data.dto.FacebookLoginDataRequestDto;
import com.talabat.core.facebook.login.data.dto.FacebookLoginResultDto;
import com.talabat.core.facebook.login.domain.FacebookPermission;
import com.talabat.core.facebook.login.domain.FacebookProfileData;
import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH&J\b\u0010\n\u001a\u00020\u0003H&J\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\bH&¨\u0006\u000f"}, d2 = {"Lcom/talabat/core/facebook/login/data/datasource/FacebookLoginDataSource;", "", "initialize", "", "login", "Lio/reactivex/Single;", "Lcom/talabat/core/facebook/login/data/dto/FacebookLoginResultDto;", "facebookPermissions", "", "Lcom/talabat/core/facebook/login/domain/FacebookPermission;", "logout", "requestData", "Lcom/talabat/core/facebook/login/data/dto/FacebookLoginDataRequestDto;", "data", "Lcom/talabat/core/facebook/login/domain/FacebookProfileData;", "com_talabat_core_social-login_facebook_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface FacebookLoginDataSource {
    void initialize();

    @NotNull
    Single<FacebookLoginResultDto> login(@NotNull List<? extends FacebookPermission> list);

    void logout();

    @NotNull
    Single<FacebookLoginDataRequestDto> requestData(@NotNull List<? extends FacebookProfileData> list);
}
