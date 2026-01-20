package co.gistech.libs.countrieskit;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Ahmad R Musa <bzu.ahmad@gmail.com>.
 */

public class LibCK {

    private static String[] countryCodes = new String[]{
            "ad", "ae", "af", "ag", "ai", "al", "am", "ao", "ar", "as", "at", "au", "aw", "ax", "az", //
            "ba", "bb", "bd", "be", "bf", "bg", "bh", "bi", "bj", "bl", "bm", "bn", "bo", "br", "bs", "bt", "bv", "bw", "by", "bz", //
            "ca", "cc", "cd", "cf", "cg", "ch", "ci", "ck", "cl", "cm", "cn", "co", "cr", "cu", "cv", "cw", "cx", "cy", "cz", //
            "de", "dj", "dk", "dm", "do", "dz", //
            "ec", "ee", "eg", "er", "es", "et", //
            "fi", "fj", "fk", "fm", "fo", "fr", //
            "ga", "gb", "gd", "ge", "gf", "gg", "gh", "gi", "gl", "gm", "gn", "gp", "gq", "gr", "gs", "gt", "gu", "gw", "gy", //
            "hk", "hm", "hn", "hr", "ht", "hu", //
            "id", "ie", "il", "im", "in", "io", "iq", "ir", "is", "it", //
            "je", "jm", "jo", "jp", //
            "ke", "kg", "kh", "ki", "km", "kn", "kp", "kr", "kw", "ky", "kz", //
            "la", "lb", "lc", "li", "lk", "lr", "ls", "lt", "lu", "lv", "ly", //
            "ma", "mc", "md", "me", "mg", "mh", "mk", "ml", "mm", "mn", "mo", "mp", "mq", "mr", "ms", "mt", "mu", "mv", "mw", "mx", "my", "mz", //
            "na", "nc", "ne", "nf", "ng", "ni", "nl", "no", "np", "nr", "nu", "nz", //
            "om", //
            "pa", "pe", "pf", "pg", "ph", "pk", "pl", "pm", "pn", "pr", "ps", "pt", "pw", "py", //
            "qa", //
            "re", "ro", "rs", "ru", "rw", //
            "sa", "sb", "sc", "sd", "se", "sg", "si", "sj", "sk", "sl", "sm", "sn", "so", "sr", "ss", "st", "sv", "sx", "sy", "sz", //
            "tc", "td", "tf", "tg", "th", "tj", "tk", "tl", "tm", "tn", "to", "tr", "tt", "tv", "tw", "tz", //
            "ua", "ug", "um", "us", "uy", "uz", //
            "va", "vc", "ve", "vg", "vi", "vn", "vu", //
            "wf", "ws", //
            "xk", //
            "ye", "yt", //
            "za", "zm", "zw" //
    };

    public static String[] availableCountryCodesArray() {
        return countryCodes;
    }

    public static Set<String> availableCountryCodesSet() {
        return new HashSet<String>(Arrays.asList(countryCodes));
    }

    public static List<String> availableCountryCodesList() {
        return Arrays.asList(countryCodes);
    }


    /**
     * This Method Will Apply The passed Context Theme on the returned Drawable
     *
     * @param context
     * @param countryCode
     * @return
     */
    public static Drawable getCompatFlagDrawable(Context context, String countryCode) {

        if (context == null)
            throw new IllegalArgumentException("Parameter 'context' can not be null");
        if (countryCode == null || !availableCountryCodesSet().contains(countryCode))
            return null;

        Resources res = context.getResources();
        if (countryCode.equals("do")) {
            countryCode = "_do";
        }
        int resourceId = res.getIdentifier(countryCode, "drawable", context.getPackageName());

        return ContextCompat.getDrawable(context, resourceId);
    }

    /**
     * This Method Will NOT Apply The passed Context Theme on the returned Drawable
     *
     * @param context
     * @param countryCode
     * @return
     */
    public static Drawable getFlagDrawable(Context context, String countryCode) {
        if (context == null)
            throw new IllegalArgumentException("Parameter 'context' can not be null");
        if (countryCode == null || !availableCountryCodesSet().contains(countryCode))
            return null;

        String cc = countryCode;
        if (cc.equals("do")) {
            cc = "_do";
        }
        Resources res = context.getResources();
        int resourceId = res.getIdentifier(cc, "drawable", context.getPackageName());

        // no theme is applied to the drawable
        return ResourcesCompat.getDrawable(res, resourceId, null);
    }


    /**
     * Returns the @{@link Country} by its @countryCode
     *
     * @param context
     * @param countryCode
     * @return
     */
    public static Country getCountryByCode(Context context, String countryCode) {
        if (context == null)
            throw new IllegalArgumentException("Parameter 'context' can not be null");
        if (countryCode == null || !availableCountryCodesSet().contains(countryCode))
            return null;

        String cc = countryCode;
        if (cc.equals("do")) {
            cc = "_do";
        }

        Resources res = context.getResources();
        Country country = new Country();
        country.setCountryCode(countryCode);

        int countryNameResourceId = res.getIdentifier(cc, "string", context.getPackageName());
        country.setCountryName(context.getString(countryNameResourceId));


        int flagResourceId = res.getIdentifier(cc, "drawable", context.getPackageName());
        country.setFlagResId(flagResourceId);


        return country;
    }

    public static String getCountryNameByCode(Context context, String countryCode) {
        if (context == null)
            throw new IllegalArgumentException("Parameter 'context' can not be null");
        if (countryCode == null || !availableCountryCodesSet().contains(countryCode))
            return null;

        Resources res = context.getResources();
        String cc = countryCode;
        if (cc.equals("do")) {
            cc = "_do";
        }

        int countryNameResourceId = res.getIdentifier(cc, "string", context.getPackageName());

        return context.getString(countryNameResourceId);

    }

    /**
     * Fills and Returns a List of  All Countries
     *
     * @param context
     * @return
     */
    public static List<Country> getCountriesList(Context context) {
        List<Country> countriesList = new ArrayList<Country>();
        Resources res = context.getResources();

        for (String countryCode : countryCodes) {
            Country country = new Country();
            country.setCountryCode(countryCode);

            if (countryCode.equals("do")) {
                countryCode = "_do";
            }
            int countryNameResourceId = res.getIdentifier(countryCode, "string", context.getPackageName());


            country.setCountryName(context.getString(countryNameResourceId));


            int flagResourceId = res.getIdentifier(countryCode, "drawable", context.getPackageName());
            country.setFlagResId(flagResourceId);
            countriesList.add(country);
        }

        return countriesList;
    }
}
