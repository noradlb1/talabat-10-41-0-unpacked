package com.google.android.libraries.places.internal;

import androidx.annotation.Nullable;
import com.facebook.appevents.integrity.IntegrityManager;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.libraries.places.api.model.DayOfWeek;
import com.google.android.libraries.places.api.model.LocalTime;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.model.TimeOfWeek;
import com.google.android.libraries.places.internal.zzch;
import com.huawei.location.lite.common.log.logwrite.LogWriteConstants;
import com.talabat.darkstores.data.tracking.StoreInfoTrackingProvider;
import com.talabat.feature.nfvinvendorsearch.presentation.utils.Constants;
import com.talabat.feature.rating.presentation.ui.RatingReasonFragmentKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

final class zzce {
    private static final zzgg<String, Place.BusinessStatus> zza;
    private static final zzgg<String, Place.Type> zzb;

    static {
        zzgf zzgf = new zzgf();
        zzgf.zza("OPERATIONAL", Place.BusinessStatus.OPERATIONAL);
        zzgf.zza("CLOSED_TEMPORARILY", Place.BusinessStatus.CLOSED_TEMPORARILY);
        zzgf.zza("CLOSED_PERMANENTLY", Place.BusinessStatus.CLOSED_PERMANENTLY);
        zza = zzgf.zzb();
        zzgf zzgf2 = new zzgf();
        zzgf2.zza("accounting", Place.Type.ACCOUNTING);
        zzgf2.zza("administrative_area_level_1", Place.Type.ADMINISTRATIVE_AREA_LEVEL_1);
        zzgf2.zza("administrative_area_level_2", Place.Type.ADMINISTRATIVE_AREA_LEVEL_2);
        zzgf2.zza("administrative_area_level_3", Place.Type.ADMINISTRATIVE_AREA_LEVEL_3);
        zzgf2.zza("administrative_area_level_4", Place.Type.ADMINISTRATIVE_AREA_LEVEL_4);
        zzgf2.zza("administrative_area_level_5", Place.Type.ADMINISTRATIVE_AREA_LEVEL_5);
        zzgf2.zza("airport", Place.Type.AIRPORT);
        zzgf2.zza("amusement_park", Place.Type.AMUSEMENT_PARK);
        zzgf2.zza("aquarium", Place.Type.AQUARIUM);
        zzgf2.zza("archipelago", Place.Type.ARCHIPELAGO);
        zzgf2.zza("art_gallery", Place.Type.ART_GALLERY);
        zzgf2.zza("atm", Place.Type.ATM);
        zzgf2.zza("bakery", Place.Type.BAKERY);
        zzgf2.zza("bank", Place.Type.BANK);
        zzgf2.zza("bar", Place.Type.BAR);
        zzgf2.zza("beauty_salon", Place.Type.BEAUTY_SALON);
        zzgf2.zza("bicycle_store", Place.Type.BICYCLE_STORE);
        zzgf2.zza("book_store", Place.Type.BOOK_STORE);
        zzgf2.zza("bowling_alley", Place.Type.BOWLING_ALLEY);
        zzgf2.zza("bus_station", Place.Type.BUS_STATION);
        zzgf2.zza("cafe", Place.Type.CAFE);
        zzgf2.zza("campground", Place.Type.CAMPGROUND);
        zzgf2.zza("car_dealer", Place.Type.CAR_DEALER);
        zzgf2.zza("car_rental", Place.Type.CAR_RENTAL);
        zzgf2.zza("car_repair", Place.Type.CAR_REPAIR);
        zzgf2.zza("car_wash", Place.Type.CAR_WASH);
        zzgf2.zza("casino", Place.Type.CASINO);
        zzgf2.zza("cemetery", Place.Type.CEMETERY);
        zzgf2.zza("church", Place.Type.CHURCH);
        zzgf2.zza("city_hall", Place.Type.CITY_HALL);
        zzgf2.zza("clothing_store", Place.Type.CLOTHING_STORE);
        zzgf2.zza("colloquial_area", Place.Type.COLLOQUIAL_AREA);
        zzgf2.zza("continent", Place.Type.CONTINENT);
        zzgf2.zza("convenience_store", Place.Type.CONVENIENCE_STORE);
        zzgf2.zza("country", Place.Type.COUNTRY);
        zzgf2.zza("courthouse", Place.Type.COURTHOUSE);
        zzgf2.zza("dentist", Place.Type.DENTIST);
        zzgf2.zza("department_store", Place.Type.DEPARTMENT_STORE);
        zzgf2.zza("doctor", Place.Type.DOCTOR);
        zzgf2.zza("drugstore", Place.Type.DRUGSTORE);
        zzgf2.zza("electrician", Place.Type.ELECTRICIAN);
        zzgf2.zza("electronics_store", Place.Type.ELECTRONICS_STORE);
        zzgf2.zza("embassy", Place.Type.EMBASSY);
        zzgf2.zza("establishment", Place.Type.ESTABLISHMENT);
        zzgf2.zza("finance", Place.Type.FINANCE);
        zzgf2.zza("fire_station", Place.Type.FIRE_STATION);
        zzgf2.zza(LogWriteConstants.FLOOR, Place.Type.FLOOR);
        zzgf2.zza("florist", Place.Type.FLORIST);
        zzgf2.zza(RatingReasonFragmentKt.ARGUMENT_NAME_FOOD, Place.Type.FOOD);
        zzgf2.zza("funeral_home", Place.Type.FUNERAL_HOME);
        zzgf2.zza("furniture_store", Place.Type.FURNITURE_STORE);
        zzgf2.zza("gas_station", Place.Type.GAS_STATION);
        zzgf2.zza("general_contractor", Place.Type.GENERAL_CONTRACTOR);
        zzgf2.zza("geocode", Place.Type.GEOCODE);
        zzgf2.zza("grocery_or_supermarket", Place.Type.GROCERY_OR_SUPERMARKET);
        zzgf2.zza("gym", Place.Type.GYM);
        zzgf2.zza("hair_care", Place.Type.HAIR_CARE);
        zzgf2.zza("hardware_store", Place.Type.HARDWARE_STORE);
        zzgf2.zza(IntegrityManager.INTEGRITY_TYPE_HEALTH, Place.Type.HEALTH);
        zzgf2.zza("hindu_temple", Place.Type.HINDU_TEMPLE);
        zzgf2.zza("home_goods_store", Place.Type.HOME_GOODS_STORE);
        zzgf2.zza("hospital", Place.Type.HOSPITAL);
        zzgf2.zza("insurance_agency", Place.Type.INSURANCE_AGENCY);
        zzgf2.zza("intersection", Place.Type.INTERSECTION);
        zzgf2.zza("jewelry_store", Place.Type.JEWELRY_STORE);
        zzgf2.zza("laundry", Place.Type.LAUNDRY);
        zzgf2.zza("lawyer", Place.Type.LAWYER);
        zzgf2.zza("library", Place.Type.LIBRARY);
        zzgf2.zza("light_rail_station", Place.Type.LIGHT_RAIL_STATION);
        zzgf2.zza("liquor_store", Place.Type.LIQUOR_STORE);
        zzgf2.zza("local_government_office", Place.Type.LOCAL_GOVERNMENT_OFFICE);
        zzgf2.zza("locality", Place.Type.LOCALITY);
        zzgf2.zza("locksmith", Place.Type.LOCKSMITH);
        zzgf2.zza("lodging", Place.Type.LODGING);
        zzgf2.zza("meal_delivery", Place.Type.MEAL_DELIVERY);
        zzgf2.zza("meal_takeaway", Place.Type.MEAL_TAKEAWAY);
        zzgf2.zza("mosque", Place.Type.MOSQUE);
        zzgf2.zza("movie_rental", Place.Type.MOVIE_RENTAL);
        zzgf2.zza("movie_theater", Place.Type.MOVIE_THEATER);
        zzgf2.zza("moving_company", Place.Type.MOVING_COMPANY);
        zzgf2.zza("museum", Place.Type.MUSEUM);
        zzgf2.zza("natural_feature", Place.Type.NATURAL_FEATURE);
        zzgf2.zza("neighborhood", Place.Type.NEIGHBORHOOD);
        zzgf2.zza("night_club", Place.Type.NIGHT_CLUB);
        zzgf2.zza("painter", Place.Type.PAINTER);
        zzgf2.zza("park", Place.Type.PARK);
        zzgf2.zza("parking", Place.Type.PARKING);
        zzgf2.zza("pet_store", Place.Type.PET_STORE);
        zzgf2.zza(StoreInfoTrackingProvider.SHOP_TYPE_PHARMACY, Place.Type.PHARMACY);
        zzgf2.zza("physiotherapist", Place.Type.PHYSIOTHERAPIST);
        zzgf2.zza("place_of_worship", Place.Type.PLACE_OF_WORSHIP);
        zzgf2.zza("plumber", Place.Type.PLUMBER);
        zzgf2.zza("plus_code", Place.Type.PLUS_CODE);
        zzgf2.zza("point_of_interest", Place.Type.POINT_OF_INTEREST);
        zzgf2.zza("police", Place.Type.POLICE);
        zzgf2.zza("political", Place.Type.POLITICAL);
        zzgf2.zza("post_box", Place.Type.POST_BOX);
        zzgf2.zza("post_office", Place.Type.POST_OFFICE);
        zzgf2.zza("postal_code_prefix", Place.Type.POSTAL_CODE_PREFIX);
        zzgf2.zza("postal_code_suffix", Place.Type.POSTAL_CODE_SUFFIX);
        zzgf2.zza("postal_code", Place.Type.POSTAL_CODE);
        zzgf2.zza("postal_town", Place.Type.POSTAL_TOWN);
        zzgf2.zza("premise", Place.Type.PREMISE);
        zzgf2.zza("primary_school", Place.Type.PRIMARY_SCHOOL);
        zzgf2.zza("real_estate_agency", Place.Type.REAL_ESTATE_AGENCY);
        zzgf2.zza("restaurant", Place.Type.RESTAURANT);
        zzgf2.zza("roofing_contractor", Place.Type.ROOFING_CONTRACTOR);
        zzgf2.zza("room", Place.Type.ROOM);
        zzgf2.zza(Constants.ARG_ROUTE, Place.Type.ROUTE);
        zzgf2.zza("rv_park", Place.Type.RV_PARK);
        zzgf2.zza("school", Place.Type.SCHOOL);
        zzgf2.zza("secondary_school", Place.Type.SECONDARY_SCHOOL);
        zzgf2.zza("shoe_store", Place.Type.SHOE_STORE);
        zzgf2.zza("shopping_mall", Place.Type.SHOPPING_MALL);
        zzgf2.zza("spa", Place.Type.SPA);
        zzgf2.zza("stadium", Place.Type.STADIUM);
        zzgf2.zza("storage", Place.Type.STORAGE);
        zzgf2.zza("store", Place.Type.STORE);
        zzgf2.zza("street_address", Place.Type.STREET_ADDRESS);
        zzgf2.zza("street_number", Place.Type.STREET_NUMBER);
        zzgf2.zza("sublocality_level_1", Place.Type.SUBLOCALITY_LEVEL_1);
        zzgf2.zza("sublocality_level_2", Place.Type.SUBLOCALITY_LEVEL_2);
        zzgf2.zza("sublocality_level_3", Place.Type.SUBLOCALITY_LEVEL_3);
        zzgf2.zza("sublocality_level_4", Place.Type.SUBLOCALITY_LEVEL_4);
        zzgf2.zza("sublocality_level_5", Place.Type.SUBLOCALITY_LEVEL_5);
        zzgf2.zza("sublocality", Place.Type.SUBLOCALITY);
        zzgf2.zza("subpremise", Place.Type.SUBPREMISE);
        zzgf2.zza("subway_station", Place.Type.SUBWAY_STATION);
        zzgf2.zza("supermarket", Place.Type.SUPERMARKET);
        zzgf2.zza("synagogue", Place.Type.SYNAGOGUE);
        zzgf2.zza("taxi_stand", Place.Type.TAXI_STAND);
        zzgf2.zza("tourist_attraction", Place.Type.TOURIST_ATTRACTION);
        zzgf2.zza("town_square", Place.Type.TOWN_SQUARE);
        zzgf2.zza("train_station", Place.Type.TRAIN_STATION);
        zzgf2.zza("transit_station", Place.Type.TRANSIT_STATION);
        zzgf2.zza("travel_agency", Place.Type.TRAVEL_AGENCY);
        zzgf2.zza("university", Place.Type.UNIVERSITY);
        zzgf2.zza("veterinary_care", Place.Type.VETERINARY_CARE);
        zzgf2.zza("zoo", Place.Type.ZOO);
        zzb = zzgf2.zzb();
    }

    public static <T> List<T> zza(@Nullable List<T> list) {
        return list != null ? list : new ArrayList();
    }

    @Nullable
    public static List<Place.Type> zzb(@Nullable List<String> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        boolean z11 = false;
        zzhb zzq = ((zzge) list).listIterator(0);
        while (zzq.hasNext()) {
            String str = (String) zzq.next();
            zzgg<String, Place.Type> zzgg = zzb;
            if (zzgg.containsKey(str)) {
                arrayList.add(zzgg.get(str));
            } else {
                z11 = true;
            }
        }
        if (z11) {
            arrayList.add(Place.Type.OTHER);
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x016f  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0179  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01d6  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01e1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.google.android.libraries.places.api.model.Place zzc(@androidx.annotation.Nullable com.google.android.libraries.places.internal.zzch r13, @androidx.annotation.Nullable java.util.List<java.lang.String> r14) throws com.google.android.gms.common.api.ApiException {
        /*
            com.google.android.libraries.places.api.model.Place$Builder r0 = com.google.android.libraries.places.api.model.Place.builder()
            r0.setAttributions(r14)
            if (r13 == 0) goto L_0x022d
            com.google.android.libraries.places.internal.zzge r14 = r13.zzd()
            r1 = 0
            r2 = 0
            if (r14 != 0) goto L_0x0013
            r14 = r2
            goto L_0x0062
        L_0x0013:
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            com.google.android.libraries.places.internal.zzhb r14 = r14.listIterator(r1)
        L_0x001c:
            boolean r4 = r14.hasNext()
            if (r4 == 0) goto L_0x005e
            java.lang.Object r4 = r14.next()
            com.google.android.libraries.places.internal.zzch$zza r4 = (com.google.android.libraries.places.internal.zzch.zza) r4
            if (r4 != 0) goto L_0x002c
            r4 = r2
            goto L_0x0043
        L_0x002c:
            java.lang.String r5 = r4.zzb()     // Catch:{ IllegalStateException -> 0x0049, NullPointerException -> 0x0047 }
            com.google.android.libraries.places.internal.zzge r6 = r4.zza()     // Catch:{ IllegalStateException -> 0x0049, NullPointerException -> 0x0047 }
            com.google.android.libraries.places.api.model.AddressComponent$Builder r5 = com.google.android.libraries.places.api.model.AddressComponent.builder(r5, r6)     // Catch:{ IllegalStateException -> 0x0049, NullPointerException -> 0x0047 }
            java.lang.String r4 = r4.zzc()     // Catch:{ IllegalStateException -> 0x0049, NullPointerException -> 0x0047 }
            r5.setShortName(r4)     // Catch:{ IllegalStateException -> 0x0049, NullPointerException -> 0x0047 }
            com.google.android.libraries.places.api.model.AddressComponent r4 = r5.build()     // Catch:{ IllegalStateException -> 0x0049, NullPointerException -> 0x0047 }
        L_0x0043:
            zzg(r3, r4)
            goto L_0x001c
        L_0x0047:
            r13 = move-exception
            goto L_0x004a
        L_0x0049:
            r13 = move-exception
        L_0x004a:
            r14 = 1
            java.lang.Object[] r14 = new java.lang.Object[r14]
            java.lang.String r13 = r13.getMessage()
            r14[r1] = r13
            java.lang.String r13 = "AddressComponent not properly defined (%s)."
            java.lang.String r13 = java.lang.String.format(r13, r14)
            com.google.android.gms.common.api.ApiException r13 = zzd(r13)
            throw r13
        L_0x005e:
            com.google.android.libraries.places.api.model.AddressComponents r14 = com.google.android.libraries.places.api.model.AddressComponents.newInstance(r3)
        L_0x0062:
            com.google.android.libraries.places.internal.zzch$zzb r3 = r13.zza()
            if (r3 == 0) goto L_0x0093
            com.google.android.libraries.places.internal.zzch$zzb$zza r4 = r3.zza()
            com.google.android.gms.maps.model.LatLng r4 = zze(r4)
            com.google.android.libraries.places.internal.zzch$zzb$zzb r3 = r3.zzb()
            if (r3 != 0) goto L_0x0078
        L_0x0076:
            r6 = r2
            goto L_0x0095
        L_0x0078:
            com.google.android.libraries.places.internal.zzch$zzb$zza r5 = r3.zzb()
            com.google.android.gms.maps.model.LatLng r5 = zze(r5)
            com.google.android.libraries.places.internal.zzch$zzb$zza r3 = r3.zza()
            com.google.android.gms.maps.model.LatLng r3 = zze(r3)
            if (r5 == 0) goto L_0x0076
            if (r3 != 0) goto L_0x008d
            goto L_0x0076
        L_0x008d:
            com.google.android.gms.maps.model.LatLngBounds r6 = new com.google.android.gms.maps.model.LatLngBounds
            r6.<init>(r5, r3)
            goto L_0x0095
        L_0x0093:
            r4 = r2
            r6 = r4
        L_0x0095:
            java.lang.String r3 = r13.zzr()
            if (r3 == 0) goto L_0x00a0
            android.net.Uri r3 = android.net.Uri.parse(r3)
            goto L_0x00a1
        L_0x00a0:
            r3 = r2
        L_0x00a1:
            java.lang.String r5 = r13.zzn()
            if (r5 == 0) goto L_0x00ae
            java.lang.String r7 = ".png"
            java.lang.String r5 = r5.concat(r7)
            goto L_0x00af
        L_0x00ae:
            r5 = r2
        L_0x00af:
            java.lang.String r7 = r13.zzm()
            if (r7 == 0) goto L_0x00be
            int r7 = android.graphics.Color.parseColor(r7)     // Catch:{ IllegalArgumentException -> 0x00be }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ IllegalArgumentException -> 0x00be }
            goto L_0x00bf
        L_0x00be:
            r7 = r2
        L_0x00bf:
            java.lang.String r8 = r13.zzl()
            r0.setAddress(r8)
            r0.setAddressComponents(r14)
            java.lang.String r14 = r13.zzk()
            com.google.android.libraries.places.internal.zzgg<java.lang.String, com.google.android.libraries.places.api.model.Place$BusinessStatus> r8 = zza
            java.lang.Object r14 = r8.getOrDefault(r14, r2)
            com.google.android.libraries.places.api.model.Place$BusinessStatus r14 = (com.google.android.libraries.places.api.model.Place.BusinessStatus) r14
            r0.setBusinessStatus(r14)
            java.lang.String r14 = r13.zzq()
            r0.setId(r14)
            r0.setLatLng(r4)
            java.lang.String r14 = r13.zzp()
            r0.setName(r14)
            java.lang.String r14 = r13.zzo()
            r0.setPhoneNumber(r14)
            com.google.android.libraries.places.internal.zzge r14 = r13.zze()
            if (r14 == 0) goto L_0x016f
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            com.google.android.libraries.places.internal.zzhb r14 = r14.listIterator(r1)
        L_0x00ff:
            boolean r8 = r14.hasNext()
            if (r8 == 0) goto L_0x0170
            java.lang.Object r8 = r14.next()
            com.google.android.libraries.places.internal.zzch$zzd r8 = (com.google.android.libraries.places.internal.zzch.zzd) r8
            if (r8 != 0) goto L_0x010f
            r8 = r2
            goto L_0x0164
        L_0x010f:
            java.lang.String r9 = r8.zzd()
            boolean r9 = android.text.TextUtils.isEmpty(r9)
            if (r9 != 0) goto L_0x0168
            java.lang.Integer r9 = r8.zzb()
            java.lang.Integer r10 = r8.zzc()
            java.lang.String r11 = r8.zzd()
            com.google.android.libraries.places.api.model.PhotoMetadata$Builder r11 = com.google.android.libraries.places.api.model.PhotoMetadata.builder(r11)
            com.google.android.libraries.places.internal.zzge r8 = r8.zza()
            if (r8 == 0) goto L_0x0145
            boolean r12 = r8.isEmpty()
            if (r12 == 0) goto L_0x0136
            goto L_0x0145
        L_0x0136:
            java.lang.String r12 = ", "
            com.google.android.libraries.places.internal.zzfh r12 = com.google.android.libraries.places.internal.zzfh.zzb(r12)
            com.google.android.libraries.places.internal.zzfh r12 = r12.zzc()
            java.lang.String r8 = r12.zze(r8)
            goto L_0x0147
        L_0x0145:
            java.lang.String r8 = ""
        L_0x0147:
            r11.setAttributions(r8)
            if (r9 != 0) goto L_0x014e
            r8 = r1
            goto L_0x0152
        L_0x014e:
            int r8 = r9.intValue()
        L_0x0152:
            r11.setHeight(r8)
            if (r10 != 0) goto L_0x0159
            r8 = r1
            goto L_0x015d
        L_0x0159:
            int r8 = r10.intValue()
        L_0x015d:
            r11.setWidth(r8)
            com.google.android.libraries.places.api.model.PhotoMetadata r8 = r11.build()
        L_0x0164:
            zzg(r4, r8)
            goto L_0x00ff
        L_0x0168:
            java.lang.String r13 = "Photo reference not provided for a PhotoMetadata result."
            com.google.android.gms.common.api.ApiException r13 = zzd(r13)
            throw r13
        L_0x016f:
            r4 = r2
        L_0x0170:
            r0.setPhotoMetadatas(r4)
            com.google.android.libraries.places.internal.zzch$zzc r14 = r13.zzb()
            if (r14 == 0) goto L_0x01d6
            com.google.android.libraries.places.api.model.OpeningHours$Builder r4 = com.google.android.libraries.places.api.model.OpeningHours.builder()
            com.google.android.libraries.places.internal.zzge r8 = r14.zza()
            if (r8 == 0) goto L_0x01be
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            com.google.android.libraries.places.internal.zzhb r1 = r8.listIterator(r1)
        L_0x018c:
            boolean r8 = r1.hasNext()
            if (r8 == 0) goto L_0x01bf
            java.lang.Object r8 = r1.next()
            com.google.android.libraries.places.internal.zzch$zzc$zza r8 = (com.google.android.libraries.places.internal.zzch.zzc.zza) r8
            if (r8 == 0) goto L_0x01b9
            com.google.android.libraries.places.api.model.Period$Builder r10 = com.google.android.libraries.places.api.model.Period.builder()
            com.google.android.libraries.places.internal.zzch$zzc$zzb r11 = r8.zzb()
            com.google.android.libraries.places.api.model.TimeOfWeek r11 = zzf(r11)
            r10.setOpen(r11)
            com.google.android.libraries.places.internal.zzch$zzc$zzb r8 = r8.zza()
            com.google.android.libraries.places.api.model.TimeOfWeek r8 = zzf(r8)
            r10.setClose(r8)
            com.google.android.libraries.places.api.model.Period r8 = r10.build()
            goto L_0x01ba
        L_0x01b9:
            r8 = r2
        L_0x01ba:
            zzg(r9, r8)
            goto L_0x018c
        L_0x01be:
            r9 = r2
        L_0x01bf:
            java.util.List r1 = zza(r9)
            r4.setPeriods(r1)
            com.google.android.libraries.places.internal.zzge r14 = r14.zzb()
            java.util.List r14 = zza(r14)
            r4.setWeekdayText(r14)
            com.google.android.libraries.places.api.model.OpeningHours r14 = r4.build()
            goto L_0x01d7
        L_0x01d6:
            r14 = r2
        L_0x01d7:
            r0.setOpeningHours(r14)
            com.google.android.libraries.places.internal.zzch$zze r14 = r13.zzc()
            if (r14 != 0) goto L_0x01e1
            goto L_0x01f7
        L_0x01e1:
            com.google.android.libraries.places.api.model.PlusCode$Builder r1 = com.google.android.libraries.places.api.model.PlusCode.builder()
            java.lang.String r2 = r14.zza()
            r1.setCompoundCode(r2)
            java.lang.String r14 = r14.zzb()
            r1.setGlobalCode(r14)
            com.google.android.libraries.places.api.model.PlusCode r2 = r1.build()
        L_0x01f7:
            r0.setPlusCode(r2)
            java.lang.Integer r14 = r13.zzh()
            r0.setPriceLevel(r14)
            java.lang.Double r14 = r13.zzg()
            r0.setRating(r14)
            com.google.android.libraries.places.internal.zzge r14 = r13.zzf()
            java.util.List r14 = zzb(r14)
            r0.setTypes(r14)
            java.lang.Integer r14 = r13.zzi()
            r0.setUserRatingsTotal(r14)
            java.lang.Integer r13 = r13.zzj()
            r0.setUtcOffsetMinutes(r13)
            r0.setViewport(r6)
            r0.setWebsiteUri(r3)
            r0.setIconUrl(r5)
            r0.setIconBackgroundColor(r7)
        L_0x022d:
            com.google.android.libraries.places.api.model.Place r13 = r0.build()
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzce.zzc(com.google.android.libraries.places.internal.zzch, java.util.List):com.google.android.libraries.places.api.model.Place");
    }

    private static ApiException zzd(String str) {
        String valueOf = String.valueOf(str);
        return new ApiException(new Status(8, valueOf.length() != 0 ? "Unexpected server error: ".concat(valueOf) : new String("Unexpected server error: ")));
    }

    @Nullable
    private static LatLng zze(@Nullable zzch.zzb.zza zza2) {
        if (zza2 == null || zza2.zza() == null || zza2.zzb() == null) {
            return null;
        }
        return new LatLng(zza2.zza().doubleValue(), zza2.zzb().doubleValue());
    }

    @Nullable
    private static TimeOfWeek zzf(@Nullable zzch.zzc.zzb zzb2) {
        boolean z11;
        boolean z12;
        DayOfWeek dayOfWeek;
        LocalTime localTime = null;
        if (zzb2 == null) {
            return null;
        }
        boolean z13 = true;
        if (zzb2.zza() != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        zzfm.zze(z11, "Unable to convert Pablo response to TimeOfWeek: The \"day\" field is missing.");
        if (zzb2.zzb() != null) {
            z12 = true;
        } else {
            z12 = false;
        }
        zzfm.zze(z12, "Unable to convert Pablo response to TimeOfWeek: The \"time\" field is missing.");
        switch (zzb2.zza().intValue()) {
            case 0:
                dayOfWeek = DayOfWeek.SUNDAY;
                break;
            case 1:
                dayOfWeek = DayOfWeek.MONDAY;
                break;
            case 2:
                dayOfWeek = DayOfWeek.TUESDAY;
                break;
            case 3:
                dayOfWeek = DayOfWeek.WEDNESDAY;
                break;
            case 4:
                dayOfWeek = DayOfWeek.THURSDAY;
                break;
            case 5:
                dayOfWeek = DayOfWeek.FRIDAY;
                break;
            case 6:
                dayOfWeek = DayOfWeek.SATURDAY;
                break;
            default:
                throw new IllegalArgumentException("pabloDayOfWeek can only be an integer between 0 and 6");
        }
        String zzb3 = zzb2.zzb();
        if (zzb3 != null) {
            String format = String.format("Unable to convert %s to LocalTime, must be of format \"hhmm\".", new Object[]{zzb3});
            if (zzb3.length() != 4) {
                z13 = false;
            }
            zzfm.zze(z13, format);
            try {
                localTime = LocalTime.newInstance(Integer.parseInt(zzb3.substring(0, 2)), Integer.parseInt(zzb3.substring(2, 4)));
            } catch (NumberFormatException e11) {
                throw new IllegalArgumentException(format, e11);
            }
        }
        return TimeOfWeek.newInstance(dayOfWeek, localTime);
    }

    private static <T> boolean zzg(Collection<T> collection, @Nullable T t11) {
        if (t11 != null) {
            return collection.add(t11);
        }
        return false;
    }
}
