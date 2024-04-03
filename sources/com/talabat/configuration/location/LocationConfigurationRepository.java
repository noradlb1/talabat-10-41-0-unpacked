package com.talabat.configuration.location;

import com.talabat.configuration.country.Country;
import com.talabat.domain.address.Address;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H&J\u001f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u0006\u0010\u0007\u001a\u00020\bH¦@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH&J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0003H&J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\bH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\rH&J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Lcom/talabat/configuration/location/LocationConfigurationRepository;", "", "addresses", "", "Lcom/talabat/domain/address/Address;", "areas", "Lcom/talabat/configuration/location/Area;", "countryId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "config", "Lcom/talabat/configuration/location/LocationConfig;", "countries", "Lcom/talabat/configuration/location/Country;", "getCountryById", "id", "selectedCountry", "shouldEnableCountry", "", "country", "Lcom/talabat/configuration/country/Country;", "com_talabat_core_configuration_remote_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface LocationConfigurationRepository {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        @Nullable
        public static Country getCountryById(@NotNull LocationConfigurationRepository locationConfigurationRepository, int i11) {
            Object obj;
            boolean z11;
            Iterator it = locationConfigurationRepository.countries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((Country) obj).getCountry().getCountryId() == i11) {
                    z11 = true;
                    continue;
                } else {
                    z11 = false;
                    continue;
                }
                if (z11) {
                    break;
                }
            }
            return (Country) obj;
        }

        public static boolean shouldEnableCountry(@NotNull LocationConfigurationRepository locationConfigurationRepository, @NotNull Country country) {
            boolean z11;
            Intrinsics.checkNotNullParameter(country, "country");
            Iterable<Country> countries = locationConfigurationRepository.countries();
            if ((countries instanceof Collection) && ((Collection) countries).isEmpty()) {
                return false;
            }
            for (Country country2 : countries) {
                if (country2.getCountry().getCountryId() == country.getCountryId()) {
                    z11 = true;
                    continue;
                } else {
                    z11 = false;
                    continue;
                }
                if (z11) {
                    return true;
                }
            }
            return false;
        }
    }

    @NotNull
    List<Address> addresses();

    @Nullable
    Object areas(int i11, @NotNull Continuation<? super List<Area>> continuation);

    @NotNull
    List<Area> areas();

    @NotNull
    LocationConfig config();

    @NotNull
    List<Country> countries();

    @Nullable
    Country getCountryById(int i11);

    @Nullable
    Country selectedCountry();

    boolean shouldEnableCountry(@NotNull Country country);
}
