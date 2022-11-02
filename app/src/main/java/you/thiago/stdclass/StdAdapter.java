package you.thiago.stdclass;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Objects;

@SuppressWarnings({"unused"})
public class StdAdapter extends ArrayAdapter<IStdObject> {

    protected Context context;
    protected ArrayList<? extends IStdObject> list;

    @LayoutRes
    private final int layoutRes;

    @LayoutRes
    private int spinnerItemSelectedRes = R.layout.simple_spinner_item_selected;

    @LayoutRes
    private int spinnerItemRes = R.layout.simple_spinner_item_dialog;

    @LayoutRes
    private int spinnerDropdownRes = android.R.layout.simple_spinner_dropdown_item;

    public StdAdapter(@NonNull Context context, @LayoutRes int resource, ArrayList<? extends IStdObject> list) {
        super(context, resource);

        this.list = list;
        this.context = context;
        this.layoutRes = resource;

        setDropDownViewResource(spinnerDropdownRes);
    }

    public StdAdapter(@NonNull Context context, ArrayList<? extends IStdObject> list) {
        super(context, R.layout.simple_spinner_item_selected);

        this.list = list;
        this.context = context;
        this.layoutRes = spinnerItemSelectedRes;

        setDropDownViewResource(spinnerDropdownRes);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public IStdObject getItem(int position) {
        if (position > -1 && position < list.size()) {
            return list.get(position);
        }

        return null;
    }

    @Override
    public long getItemId(int position) {
        if (position > -1 && position < list.size()) {
            if (list.get(position) != null) {
                return list.get(position).getId();
            }
        }

        return -1;
    }

    public int getPositionById(int id) {
        for (IStdObject item : list) {
            if (item.getId() == id) {
                return list.indexOf(item);
            }
        }

        return -1;
    }

    public int getPositionByName(String name) {
        for (IStdObject item : list) {
            if (item.getName().equals(name)) {
                return list.indexOf(item);
            }
        }

        return -1;
    }

    public int getPositionByExtra(String extra) {
        for (IStdObject item : list) {
            if (item.getExtra() != null && item.getExtra().equals(extra)) {
                return list.indexOf(item);
            }
        }

        return -1;
    }

    public int getDefaultPosition() {
        for (IStdObject item : list) {
            if (item.isDefaultValue()) {
                return list.indexOf(item);
            }
        }

        return -1;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = Objects.requireNonNull(inflater).inflate(spinnerItemRes, parent, false);

        return loadViewData(view, list.get(position));
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getView(position, parent);
    }

    @NonNull
    private View getView(int position, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = Objects.requireNonNull(inflater).inflate(layoutRes, parent, false);

        return loadViewData(view, list.get(position));
    }

    private View loadViewData(View view, IStdObject item) {
        TextView txtInfo = view.findViewById(R.id.txtSpinnerItem);
        txtInfo.setText(item.getName());

        return view;
    }

    public void setError(@NonNull Spinner spinner, String error) {
        if (spinner.getSelectedView() != null) {
            TextView item = spinner.getSelectedView().findViewById(R.id.txtSpinnerItem);
            item.setError(error);
        }
    }

    public void setError(@NonNull Spinner spinner, String error, Drawable icon) {
        if (spinner.getSelectedView() != null) {
            TextView item = spinner.getSelectedView().findViewById(R.id.txtSpinnerItem);
            item.setError(error, icon);
        }
    }

    public void setSpinnerItemSelectedRes(@LayoutRes int spinnerItemSelectedRes) {
        this.spinnerItemSelectedRes = spinnerItemSelectedRes;
    }

    public void setSpinnerDropdownRes(@LayoutRes int spinnerDropdownRes) {
        this.spinnerDropdownRes = spinnerDropdownRes;
    }

    public void setSpinnerItemRes(@LayoutRes int spinnerItemRes) {
        this.spinnerItemRes = spinnerItemRes;
    }
}
