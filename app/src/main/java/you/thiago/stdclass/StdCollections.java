package you.thiago.stdclass;

import android.content.Context;

import androidx.annotation.Nullable;

import java.util.ArrayList;

/**
 * ArrayList<StdObject> collections
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public abstract class StdCollections {

    public static final Integer NULL_INT_VALUES = -1;

    public static ArrayList<StdObject> getCountryState(final Context context, final boolean withEmptyValue) {
        ArrayList<StdObject> list = new ArrayList<>();

        if (withEmptyValue) {
            list.add(new StdObject(StdCollections.NULL_INT_VALUES, "", true));
        }

        return loadList(list, getMap(context, null, R.array.country_states_values, R.array.country_states_extras));
    }

    public static ArrayList<StdObject> getSkinColor(final Context context) {
        ArrayList<StdObject> list = new ArrayList<StdObject>() {{
            add(new StdObject(StdCollections.NULL_INT_VALUES, "", true));
        }};

        return loadList(list, getMap(context, R.array.skin_color_keys, R.array.skin_color_values));
    }

    public static ArrayList<StdObject> getMaritalStatus(final Context context) {
        ArrayList<StdObject> list = new ArrayList<StdObject>() {{
            add(new StdObject(StdCollections.NULL_INT_VALUES, "", true));
        }};

        return loadList(list, getMap(context, R.array.marital_status_keys, R.array.marital_status_values));
    }

    public static ArrayList<StdObject> getEducationLevel(final Context context) {
        ArrayList<StdObject> list = new ArrayList<StdObject>() {{
            add(new StdObject(StdCollections.NULL_INT_VALUES, "", true));
        }};

        return loadList(list, getMap(context, R.array.education_level_values));
    }

    public static ArrayList<StdObject> getChildrenNumber(final Context context) {
        ArrayList<StdObject> list = new ArrayList<StdObject>() {{
            add(new StdObject(StdCollections.NULL_INT_VALUES, "", true));
        }};

        return loadList(list, getMap(context, R.array.children_number_values));
    }

    public static ArrayList<StdObject> getMonthlyIncome(final Context context) {
        return loadList(new ArrayList<StdObject>(), getMap(context, R.array.monthly_income_keys, R.array.monthly_income_values));
    }

    public static ArrayList<StdObject> getFuelLevel(final Context context) {
        return loadList(new ArrayList<StdObject>(), getMap(context, R.array.fuel_level_values));
    }

    protected static ArrayList<StdObject> loadList(ArrayList<StdObject> list, ArrayList<StdObject> items) {
        for (StdObject item : items) {
            if (list.size() == 0) {
                item.setDefaultValue(true);
            }

            list.add(item);
        }

        return list;
    }

    protected static ArrayList<StdObject> getMap(String[] values) {
        ArrayList<StdObject> map = new ArrayList<>();

        for (int i = 0; i < values.length; ++i) {
            map.add(new StdObject(i, values[i]));
        }

        return map;
    }

    protected static ArrayList<StdObject> getMap(int[] keys, String[] values) {
        ArrayList<StdObject> map = new ArrayList<>();

        for (int i = 0; i < Math.min(keys.length, values.length); ++i) {
            map.add(new StdObject(keys[i], values[i]));
        }

        return map;
    }

    protected static ArrayList<StdObject> getMap(String[] values, String[] extras) {
        ArrayList<StdObject> map = new ArrayList<>();

        for (int i = 0; i < Math.min(values.length, extras.length); ++i) {
            map.add(new StdObject(i, values[i]).setExtra(extras[i]));
        }

        return map;
    }

    protected static ArrayList<StdObject> getMap(int[] keys, String[] values, String[] extras) {
        ArrayList<StdObject> map = new ArrayList<>();

        for (int i = 0; i < Math.min(keys.length, Math.min(values.length, extras.length)); ++i) {
            map.add(new StdObject(keys[i], values[i]).setExtra(extras[i]));
        }

        return map;
    }

    protected static ArrayList<StdObject> getMap(Context context, int valuesRes) {
        return getMap(context, null, valuesRes, null);
    }

    protected static ArrayList<StdObject> getMap(Context context, int keysRes, int valuesRes) {
        return getMap(context, keysRes, valuesRes, null);
    }

    protected static ArrayList<StdObject> getMap(Context context, @Nullable Integer keysRes, @Nullable Integer valuesRes, @Nullable Integer extraRes) {
        int[] keys = null;
        String[] values = null;
        String[] extras = null;

        if (keysRes != null) {
            keys = context.getResources().getIntArray(keysRes);
        }
        if (valuesRes != null) {
            values = context.getResources().getStringArray(valuesRes);
        }
        if (extraRes != null) {
            extras = context.getResources().getStringArray(extraRes);
        }

        if (values != null && keys != null && extraRes != null) {
            return getMap(keys, values, extras);
        } else if (values != null && keys != null) {
            return getMap(keys, values);
        } else if (values != null && extraRes != null) {
            return getMap(values, extras);
        } else if (values != null) {
            return getMap(values);
        }

        return new ArrayList<>();
    }
}
