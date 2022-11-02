package you.thiago.stdclass.enums;

import android.content.Context;

import java.util.ArrayList;

import you.thiago.stdclass.IStdObject;
import you.thiago.stdclass.R;
import you.thiago.stdclass.StdCollections;

/**
 * Base StdCollections (ArrayList<IStdObject>)
 */
@SuppressWarnings({"unused"})
public abstract class BaseStdCollections extends StdCollections {

    public static ArrayList<IStdObject> getCountryState(final Context context, final boolean withEmptyValue) {
        return loadList(getMap(context, null, R.array.country_states_values, R.array.country_states_extras), withEmptyValue);
    }

    public static ArrayList<IStdObject> getSkinColor(final Context context) {
        return loadList(getMap(context, R.array.skin_color_keys, R.array.skin_color_values), true);
    }

    public static ArrayList<IStdObject> getMaritalStatus(final Context context) {
        return loadList(getMap(context, R.array.marital_status_keys, R.array.marital_status_values), true);
    }

    public static ArrayList<IStdObject> getSexIdentity(final Context context) {
        return loadList(getMap(context, null, R.array.sex_identity_values, R.array.sex_identity_extras));
    }

    public static ArrayList<IStdObject> getSexualOrientation(final Context context) {
        return loadList(getMap(context, R.array.sexual_orientation_keys, R.array.sexual_orientation_values), false);
    }

    public static ArrayList<IStdObject> getSexGender(final Context context) {
        return loadList(getMap(context, R.array.sex_gender_keys, R.array.sex_gender_values), false);
    }

    public static ArrayList<IStdObject> getEducationLevel(final Context context) {
        return loadList(getMap(context, R.array.education_level_values), true);
    }

    public static ArrayList<IStdObject> getChildrenNumber(final Context context) {
        return loadList(getMap(context, R.array.children_number_values), true);
    }

    public static ArrayList<IStdObject> getMonthlyIncome(final Context context) {
        return loadList(getMap(context, R.array.monthly_income_keys, R.array.monthly_income_values));
    }

    public static ArrayList<IStdObject> getFuelLevel(final Context context) {
        return loadList(getMap(context, R.array.fuel_level_values));
    }

    public static ArrayList<IStdObject> getFuelType(final Context context) {
        return loadList(getMap(context, null, R.array.fuel_type_values, R.array.fuel_type_extras), true);
    }
}
