package com.talabat.talabatlife.data.remote;

import com.talabat.talabatlife.data.remote.dto.FiltersResponseRemoteDto;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'¨\u0006\u0007"}, d2 = {"Lcom/talabat/talabatlife/data/remote/IFiltersRemoteDataSource;", "", "getFilters", "Lretrofit2/Call;", "Lcom/talabat/talabatlife/data/remote/dto/FiltersResponseRemoteDto;", "countryId", "", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IFiltersRemoteDataSource {
    @NotNull
    @GET("/api/v3/brands/country/{countryId}/filters")
    Call<FiltersResponseRemoteDto> getFilters(@Path("countryId") int i11);
}
