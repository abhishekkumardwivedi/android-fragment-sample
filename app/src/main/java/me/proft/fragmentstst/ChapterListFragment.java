package me.proft.fragmentstst;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;


public class ChapterListFragment extends ListFragment {
    ChapterAdapter adapter;
    private ChapterListListener listener;

    ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.chapter_list_fragment, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adapter = new ChapterAdapter(getActivity(), Chapter.items);
        setListAdapter(adapter);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        getActivity().getMenuInflater().inflate(R.menu.chapter_list_menu, menu);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.listener = (ChapterListListener) activity;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Chapter item = Chapter.items.get(position);

        Toast.makeText(getActivity(), item.getTitle(), Toast.LENGTH_SHORT).show();

        if (listener != null) {
            listener.itemClicked(position);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle item selection
        switch (item.getItemId()) {
            case R.id.some_item:
                Toast.makeText(getActivity(), "Some action", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    static interface ChapterListListener {
        void itemClicked(int pos);
    }

}