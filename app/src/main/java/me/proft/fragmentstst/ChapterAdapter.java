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

public class ChapterAdapter extends BaseAdapter {
    private Context context;
    private List<Chapter> chapters;

    public ChapterAdapter(Context context, List<Chapter> chapters) {
        this.context = context;
        this.chapters = chapters;
    }

    @Override
    public int getCount() {
        return chapters.size();
    }

    @Override
    public Object getItem(int position) {
        return chapters.get(position);
    }

    @Override
    public long getItemId(int position) {
        return chapters.indexOf(getItem(position));
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        Chapter chapter = chapters.get(position);

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.chapter_list_item, null);

            holder = new ViewHolder();
            holder.tvTitle = convertView.findViewById(R.id.tvTitle);
            holder.tvProgress = convertView.findViewById(R.id.tvProgress);
            holder.ivIcon = convertView.findViewById(R.id.ivIcon);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.tvTitle.setText(chapter.getTitle());
        holder.tvProgress.setText(chapter.getProgress().toString() + "%");
        holder.ivIcon.setImageResource(chapter.getIcon());

        return convertView;
    }

    private class ViewHolder {
        TextView tvTitle;
        TextView tvProgress;
        ImageView ivIcon;
    }
}