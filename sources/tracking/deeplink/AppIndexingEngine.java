package tracking.deeplink;

public class AppIndexingEngine {
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static tracking.deeplink.WebAppMapping generateData(java.lang.String r9) {
        /*
            tracking.deeplink.WebAppMapping r0 = new tracking.deeplink.WebAppMapping
            r0.<init>()
            boolean r1 = com.talabat.helpers.TalabatUtils.isArabic()
            java.lang.String r2 = "https://www.talabat.com/"
            if (r1 == 0) goto L_0x001e
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r2)
            java.lang.String r2 = "ar/"
            r1.append(r2)
            java.lang.String r2 = r1.toString()
        L_0x001e:
            boolean r1 = com.talabat.helpers.TalabatUtils.isNullOrEmpty((java.lang.String) r9)
            if (r1 != 0) goto L_0x01db
            int r1 = r9.hashCode()
            switch(r1) {
                case -971088374: goto L_0x004a;
                case 422993613: goto L_0x0040;
                case 2044182833: goto L_0x0036;
                case 2144628203: goto L_0x002c;
                default: goto L_0x002b;
            }
        L_0x002b:
            goto L_0x0054
        L_0x002c:
            java.lang.String r1 = "Restaurant List Screen"
            boolean r9 = r9.equals(r1)
            if (r9 == 0) goto L_0x0054
            r9 = 3
            goto L_0x0055
        L_0x0036:
            java.lang.String r1 = "Branding Screen"
            boolean r9 = r9.equals(r1)
            if (r9 == 0) goto L_0x0054
            r9 = 1
            goto L_0x0055
        L_0x0040:
            java.lang.String r1 = "Home Screen"
            boolean r9 = r9.equals(r1)
            if (r9 == 0) goto L_0x0054
            r9 = 0
            goto L_0x0055
        L_0x004a:
            java.lang.String r1 = "Restaurant Menu Screen"
            boolean r9 = r9.equals(r1)
            if (r9 == 0) goto L_0x0054
            r9 = 2
            goto L_0x0055
        L_0x0054:
            r9 = -1
        L_0x0055:
            if (r9 == 0) goto L_0x0059
            goto L_0x01db
        L_0x0059:
            boolean r9 = com.talabat.helpers.TalabatUtils.isArabic()
            java.lang.String r1 = "bahrain"
            java.lang.String r3 = "uae"
            java.lang.String r4 = "qatar"
            java.lang.String r5 = "oman"
            java.lang.String r6 = "ksa"
            java.lang.String r7 = "kuwait"
            if (r9 == 0) goto L_0x0125
            int r9 = com.talabat.helpers.GlobalDataModel.SelectedCountryId
            com.talabat.configuration.country.Country r8 = com.talabat.configuration.country.Country.KUWAIT
            int r8 = r8.getCountryId()
            if (r9 != r8) goto L_0x008a
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r2)
            r9.append(r7)
            java.lang.String r2 = r9.toString()
            java.lang.String r9 = "اطلب الطعام اون لاين من مطاعم توصيل في الكويت | طلبات"
            java.lang.String r1 = "طلبات دوت كوم هو الموقع الأول لتوصيل الطعام في الكويت. اكتشف تشكيلة واسعة من المطاعم في الكويت التي تقدم البيتزا، البرجر، الياباني، الفطور، الصيني و المزيد | طلبات "
            goto L_0x01de
        L_0x008a:
            int r9 = com.talabat.helpers.GlobalDataModel.SelectedCountryId
            com.talabat.configuration.country.Country r7 = com.talabat.configuration.country.Country.KSA
            int r7 = r7.getCountryId()
            if (r9 != r7) goto L_0x00a9
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r2)
            r9.append(r6)
            java.lang.String r2 = r9.toString()
            java.lang.String r9 = "اطلب الطعام اون لاين من مطاعم التوصيل في السعودية | طلبات"
            java.lang.String r1 = ".طلبات دوت كوم هو الموقع الأول لتوصيل الطعام في الرياض, جدة و المزيد من المدن الأخرى في السعودية. اكتشف تشكيلة واسعة من المطاعم التي تقدم الصيني، اللبناني، البرجر، الهندي، الايطالي و المزيد | طلبات"
            goto L_0x01de
        L_0x00a9:
            int r9 = com.talabat.helpers.GlobalDataModel.SelectedCountryId
            com.talabat.configuration.country.Country r6 = com.talabat.configuration.country.Country.OMAN
            int r6 = r6.getCountryId()
            if (r9 != r6) goto L_0x00c8
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r2)
            r9.append(r5)
            java.lang.String r2 = r9.toString()
            java.lang.String r9 = "اطلب الطعام اون لاين من مطاعم توصيل في عُمان | طلبات"
            java.lang.String r1 = "طلبات دوت كوم هو الموقع الأول لتوصيل الطعام في عُمان. اكتشف تشكيلة واسعة من المطاعم في مسقط، صلالة و المزيد من المدن الأخرى التي تقدم الفطور، البرجر، البيتزا، الصيني و المزيد | طلبات"
            goto L_0x01de
        L_0x00c8:
            int r9 = com.talabat.helpers.GlobalDataModel.SelectedCountryId
            com.talabat.configuration.country.Country r5 = com.talabat.configuration.country.Country.QATAR
            int r5 = r5.getCountryId()
            if (r9 != r5) goto L_0x00e7
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r2)
            r9.append(r4)
            java.lang.String r2 = r9.toString()
            java.lang.String r9 = "اطلب الطعام اون لاين من مطاعم توصيل في قطر | طلبات"
            java.lang.String r1 = ".طلبات دوت كوم هو الموقع الأول لتوصيل الطعام الدوحة، الدحيل و المزيد من المدن الأخرى في قطر. اكتشف تشكيلة واسعة من المطاعم التي تقدم الفطور، البرجر، الهندي، اللبناني و المزيد | طلبات"
            goto L_0x01de
        L_0x00e7:
            int r9 = com.talabat.helpers.GlobalDataModel.SelectedCountryId
            com.talabat.configuration.country.Country r4 = com.talabat.configuration.country.Country.UAE
            int r4 = r4.getCountryId()
            if (r9 != r4) goto L_0x0106
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r2)
            r9.append(r3)
            java.lang.String r2 = r9.toString()
            java.lang.String r9 = "اطلب الطعام اون لاين من مطاعم التوصيل في الامارات | طلبات"
            java.lang.String r1 = "طلبات دوت كوم هو الموقع الأول لتوصيل الطعام في دبي, أبوظبي و المزيد من المدن الأخرى في الامارات. اكتشف تشكيلة واسعة من المطاعم التي تقدم البرجر، البيتزا، السمك، اللبناني و و المزيد | طلبات"
            goto L_0x01de
        L_0x0106:
            int r9 = com.talabat.helpers.GlobalDataModel.SelectedCountryId
            com.talabat.configuration.country.Country r3 = com.talabat.configuration.country.Country.BAHRAIN
            int r3 = r3.getCountryId()
            if (r9 != r3) goto L_0x01db
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r2)
            r9.append(r1)
            java.lang.String r2 = r9.toString()
            java.lang.String r9 = "اطلب الطعام اون لاين من مطاعم توصيل في البحرين | طلبات"
            java.lang.String r1 = "طلبات دوت كوم هو الموقع الأول لتوصيل الطعام في البحرين. اكتشف تشكيلة واسعة من المطاعم التي تقدم اللبناني، الفطور، الايطالي، البيتزا و المزيد | طلبات"
            goto L_0x01de
        L_0x0125:
            int r9 = com.talabat.helpers.GlobalDataModel.SelectedCountryId
            com.talabat.configuration.country.Country r8 = com.talabat.configuration.country.Country.KUWAIT
            int r8 = r8.getCountryId()
            if (r9 != r8) goto L_0x0144
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r2)
            r9.append(r7)
            java.lang.String r2 = r9.toString()
            java.lang.String r9 = "Order food online from delivery restaurants in Kuwait | Talabat"
            java.lang.String r1 = "Talabat is the number one online food delivery in Kuwait. Find a wide variety of restaurants in Kuwait offering Japanese, breakfast, Chinese, burger and more. | Talabat "
            goto L_0x01de
        L_0x0144:
            int r9 = com.talabat.helpers.GlobalDataModel.SelectedCountryId
            com.talabat.configuration.country.Country r7 = com.talabat.configuration.country.Country.KSA
            int r7 = r7.getCountryId()
            if (r9 != r7) goto L_0x0163
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r2)
            r9.append(r6)
            java.lang.String r2 = r9.toString()
            java.lang.String r9 = "Order food online from delivery restaurants in KSA | Talabat"
            java.lang.String r1 = "Talabat is the number one online food delivery in Riyadh, Jeddah and many other cities in Saudi Arabia. Find a wide variety of restaurants offering Chinese, burger, Indian, Italian and more. | Talabat "
            goto L_0x01de
        L_0x0163:
            int r9 = com.talabat.helpers.GlobalDataModel.SelectedCountryId
            com.talabat.configuration.country.Country r6 = com.talabat.configuration.country.Country.OMAN
            int r6 = r6.getCountryId()
            if (r9 != r6) goto L_0x0181
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r2)
            r9.append(r5)
            java.lang.String r2 = r9.toString()
            java.lang.String r9 = "Order food online from delivery restaurants in Oman | Talabat"
            java.lang.String r1 = "Talabat is the number one online food delivery in Oman. Find a wide variety of restaurants in Muscat, Salalah and many other cities offering breakfast, burger, pizza, Chinese and more. | Talabat"
            goto L_0x01de
        L_0x0181:
            int r9 = com.talabat.helpers.GlobalDataModel.SelectedCountryId
            com.talabat.configuration.country.Country r5 = com.talabat.configuration.country.Country.QATAR
            int r5 = r5.getCountryId()
            if (r9 != r5) goto L_0x019f
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r2)
            r9.append(r4)
            java.lang.String r2 = r9.toString()
            java.lang.String r9 = "Order food online from delivery restaurants in Qatar | Talabat"
            java.lang.String r1 = "Talabat is the number one online food delivery in Doha, Duhail and many other cities in Qatar. Find a wide variety of restaurants offering breakfast, burger, Indian, Lebanese and more. | Talabat"
            goto L_0x01de
        L_0x019f:
            int r9 = com.talabat.helpers.GlobalDataModel.SelectedCountryId
            com.talabat.configuration.country.Country r4 = com.talabat.configuration.country.Country.UAE
            int r4 = r4.getCountryId()
            if (r9 != r4) goto L_0x01bd
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r2)
            r9.append(r3)
            java.lang.String r2 = r9.toString()
            java.lang.String r9 = "Order food online from delivery restaurants in UAE | Talabat"
            java.lang.String r1 = "Talabat is the number one online food delivery in Dubai, Abu Dhabi and many other cities in UAE. Find a wide variety of restaurants offering burger, pizza, Chinese and more. | Talabat"
            goto L_0x01de
        L_0x01bd:
            int r9 = com.talabat.helpers.GlobalDataModel.SelectedCountryId
            com.talabat.configuration.country.Country r3 = com.talabat.configuration.country.Country.BAHRAIN
            int r3 = r3.getCountryId()
            if (r9 != r3) goto L_0x01db
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r2)
            r9.append(r1)
            java.lang.String r2 = r9.toString()
            java.lang.String r9 = "Order food online from delivery restaurants in Bahrain | Talabat"
            java.lang.String r1 = "Talabat is the number one online food delivery in Bahrain. Find a wide variety of restaurants in Adliya, Manama, Muharraq and many other cities offering Lebanese, breakfast, Italian, pizza and more. | Talabat"
            goto L_0x01de
        L_0x01db:
            java.lang.String r9 = ""
            r1 = r9
        L_0x01de:
            android.net.Uri r2 = android.net.Uri.parse(r2)     // Catch:{ Exception -> 0x01e9 }
            r0.webUrl = r2     // Catch:{ Exception -> 0x01e9 }
            r0.webTitle = r9     // Catch:{ Exception -> 0x01e9 }
            r0.webDescription = r1     // Catch:{ Exception -> 0x01e9 }
            return r0
        L_0x01e9:
            r9 = 0
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: tracking.deeplink.AppIndexingEngine.generateData(java.lang.String):tracking.deeplink.WebAppMapping");
    }
}
