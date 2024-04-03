package com.talabat.splash.data.repositories;

import com.talabat.splash.core.exception.Failure;
import com.talabat.splash.core.functional.Either;
import com.talabat.splash.domain.model.AppInfoRequestModel;
import com.talabat.splash.domain.model.AppInfoResponseWrapper;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\tH&J\b\u0010\u000b\u001a\u00020\tH&¨\u0006\f"}, d2 = {"Lcom/talabat/splash/data/repositories/AppInfoRepository;", "", "getAppInfo", "Lcom/talabat/splash/core/functional/Either;", "Lcom/talabat/splash/core/exception/Failure;", "Lcom/talabat/splash/domain/model/AppInfoResponseWrapper;", "appInfoRequestModel", "Lcom/talabat/splash/domain/model/AppInfoRequestModel;", "getAppLanguage", "", "retriveSavedPreferences", "setInitalAppPreferences", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Deprecated(message = "Implementation is tightly coupled with Splash functionality and is not reusable", replaceWith = @ReplaceWith(expression = "com.talabat.userandlocation.appinfo.domain.repo.AppInfoRepository", imports = {}))
public interface AppInfoRepository {
    @NotNull
    Either<Failure, AppInfoResponseWrapper> getAppInfo(@NotNull AppInfoRequestModel appInfoRequestModel);

    boolean getAppLanguage();

    boolean retriveSavedPreferences();

    boolean setInitalAppPreferences();
}
