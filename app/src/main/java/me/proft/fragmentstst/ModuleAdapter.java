package me.proft.fragmentstst;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ModuleAdapter extends BaseAdapter {
    private Context context;
    private List<Module> modules;

    public ModuleAdapter(Context context, List<Module> modules) {
        this.context = context;
        this.modules = modules;
    }

    @Override
    public int getCount() {
        return modules.size();
    }

    @Override
    public Object getItem(int position) {
        return modules.get(position);
    }

    @Override
    public long getItemId(int position) {
        return modules.indexOf(getItem(position));
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        Module module = modules.get(position);

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.module_list_item, null);

            holder = new ViewHolder();
            holder.tvTitle = convertView.findViewById(R.id.tvTitle);
            holder.tvProgress = convertView.findViewById(R.id.tvProgress);
            holder.ivIcon = convertView.findViewById(R.id.ivIcon);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.tvTitle.setText(module.getTitle());
        holder.tvProgress.setText(module.getProgress().toString() + "%");
        holder.ivIcon.setImageResource(module.getIcon());

        return convertView;
    }

    private class ViewHolder {
        TextView tvTitle;
        TextView tvProgress;
        ImageView ivIcon;
    }
}