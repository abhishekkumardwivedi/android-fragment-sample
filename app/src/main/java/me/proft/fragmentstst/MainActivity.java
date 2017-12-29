package me.proft.fragmentstst;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements ChapterListFragment.ChapterListListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            Chapter.generate();

            // set list fragment
            ChapterListFragment frg = new ChapterListFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.flChapterList, frg).commit();

            // set detail fragment
            if (findViewById(R.id.flChapterDetail) != null) {
                Bundle arguments = new Bundle();
                arguments.putInt(ModuleListFragment.ARG_ITEM_POS, 0);
                ModuleListFragment fragment = new ModuleListFragment();
                fragment.setArguments(arguments);
                getSupportFragmentManager().beginTransaction().add(R.id.flChapterDetail, fragment).commit();
            }
        }
    }

    @Override
    public void itemClicked(int pos) {
        // replace fragment
        Bundle arguments = new Bundle();
        arguments.putInt(ModuleListFragment.ARG_ITEM_POS, pos);
        ModuleListFragment fragment = new ModuleListFragment();
        fragment.setArguments(arguments);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.flChapterList, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }

}
