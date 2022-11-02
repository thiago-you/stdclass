package you.thiago.stdclass;

import android.content.Context;

import androidx.annotation.Nullable;

import java.util.ArrayList;

/**
 * Generate Standard Collections (ArrayList<IStdObject>)
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public abstract class StdCollections {

    public static final Integer NULL_INT_VALUES = -1;

    protected static ArrayList<IStdObject> loadList(ArrayList<IStdObject> items) {
        return loadList(new ArrayList<>(), items, false);
    }

    protected static ArrayList<IStdObject> loadList(ArrayList<IStdObject> items, boolean useEmptyDefaultValue) {
        return loadList(new ArrayList<>(), items, useEmptyDefaultValue);
    }

    protected static ArrayList<IStdObject> loadList(ArrayList<IStdObject> list, ArrayList<IStdObject> items) {
        return loadList(list, items, false);
    }

    protected static ArrayList<IStdObject> loadList(ArrayList<IStdObject> list, ArrayList<IStdObject> items, boolean useEmptyDefaultValue) {
        if (useEmptyDefaultValue) {
            list.add(0, new StdObject(NULL_INT_VALUES, "", true));
        }

        for (IStdObject item : items) {
            if (list.size() == 0) {
                item.setDefaultValue(true);
            }

            list.add(item);
        }

        return list;
    }

    protected static ArrayList<IStdObject> getMap(String[] values) {
        ArrayList<IStdObject> map = new ArrayList<>();

        for (int i = 0; i < values.length; ++i) {
            map.add(new StdObject(i, values[i]));
        }

        return map;
    }

    protected static ArrayList<IStdObject> getMap(int[] keys, String[] values) {
        ArrayList<IStdObject> map = new ArrayList<>();

        for (int i = 0; i < Math.min(keys.length, values.length); ++i) {
            map.add(new StdObject(keys[i], values[i]));
        }

        return map;
    }

    protected static ArrayList<IStdObject> getMap(String[] values, String[] extras) {
        ArrayList<IStdObject> map = new ArrayList<>();

        for (int i = 0; i < Math.min(values.length, extras.length); ++i) {
            map.add(new StdObject(i, values[i]).setExtra(extras[i]));
        }

        return map;
    }

    protected static ArrayList<IStdObject> getMap(int[] keys, String[] values, String[] extras) {
        ArrayList<IStdObject> map = new ArrayList<>();

        for (int i = 0; i < Math.min(keys.length, Math.min(values.length, extras.length)); ++i) {
            map.add(new StdObject(keys[i], values[i]).setExtra(extras[i]));
        }

        return map;
    }

    protected static ArrayList<IStdObject> getMap(Context context, int valuesRes) {
        return getMap(context, null, valuesRes, null);
    }

    protected static ArrayList<IStdObject> getMap(Context context, int keysRes, int valuesRes) {
        return getMap(context, keysRes, valuesRes, null);
    }

    protected static ArrayList<IStdObject> getMap(Context context, @Nullable Integer keysRes, @Nullable Integer valuesRes, @Nullable Integer extraRes) {
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
