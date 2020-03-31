package you.thiago.stdclass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SuppressWarnings({"unused"})
public class StdArrayAdapter extends ArrayAdapter<StdObject> {

    private Context context;
    private List<StdObject> list;

    public StdArrayAdapter(@NonNull Context context, ArrayList<StdObject> list) {
        super(context, R.layout.simple_spinner_item_selected);

        this.context = context;
        this.list = list;

        setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    }

    public void setList(List<StdObject> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @NonNull
    @Override
    public StdObject getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        if (position > -1) {
            if (list.get(position) != null) {
                return list.get(position).getId();
            }
        }

        return -1;
    }

    public int getPositionById(int id) {
        for (StdObject item : list) {
            if (item.getId() == id) {
                return list.indexOf(item);
            }
        }

        return -1;
    }

    public int getPositionByName(String name) {
        for (StdObject item : list) {
            if (item.getName().equals(name)) {
                return list.indexOf(item);
            }
        }

        return -1;
    }

    public int getPositionByExtra(String extra) {
        for (StdObject item : list) {
            if (item.getExtra() != null && item.getExtra().equals(extra)) {
                return list.indexOf(item);
            }
        }

        return -1;
    }

    public int getDefaultPosition() {
        for (StdObject item : list) {
            if (item.isDefaultValue()) {
                return list.indexOf(item);
            }
        }

        return -1;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = Objects.requireNonNull(inflater).inflate(R.layout.simple_spinner_item_dialog, parent, false);

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
        View view = Objects.requireNonNull(inflater).inflate(R.layout.simple_spinner_item_selected, parent, false);

        return loadViewData(view, list.get(position));
    }

    private View loadViewData(View view, StdObject item) {
        TextView txtInfo = view.findViewById(R.id.txtSpinnerItem);
        txtInfo.setText(item.getName());

        return view;
    }

    public void setError(@NonNull Spinner spinner, String error) {
        if (spinner.getSelectedView() != null) {
            TextView item = spinner.getSelectedView().findViewById(R.id.txtSpinnerItem);

            if (error == null) {
                item.setError(null);
            } else {
                item.setError(error);
            }
        }
    }
}
