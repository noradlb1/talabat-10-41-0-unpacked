package com.talabat.talabatlife.data.remote;

import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.talabatlife.data.remote.dto.FiltersResponseRemoteDto;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/talabat/talabatlife/data/remote/FiltersRemoteDataSource;", "Lcom/talabat/talabatlife/data/remote/IFiltersRemoteDataSource;", "apiBuilder", "Lcom/talabat/core/network/network/TalabatAPIBuilder;", "baseUrl", "", "(Lcom/talabat/core/network/network/TalabatAPIBuilder;Ljava/lang/String;)V", "getFilters", "Lretrofit2/Call;", "Lcom/talabat/talabatlife/data/remote/dto/FiltersResponseRemoteDto;", "countryId", "", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FiltersRemoteDataSource implements IFiltersRemoteDataSource {
    @NotNull
    private final TalabatAPIBuilder apiBuilder;
    @NotNull
    private final String baseUrl;

    public FiltersRemoteDataSource(@NotNull TalabatAPIBuilder talabatAPIBuilder, @NotNull String str) {
        Intrinsics.checkNotNullParameter(talabatAPIBuilder, "apiBuilder");
        Intrinsics.checkNotNullParameter(str, "baseUrl");
        this.apiBuilder = talabatAPIBuilder;
        this.baseUrl = str;
    }

    @NotNull
    public Call<FiltersResponseRemoteDto> getFilters(int i11) {
        return ((IFiltersRemoteDataSource) this.apiBuilder.createApi(this.baseUrl, IFiltersRemoteDataSource.class)).getFilters(i11);
    }
}
