package itdelivery.com.itdelivery;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class HomeActivity extends AppCompatActivity {

    ListView lvCarne;
    ListView lvQueijo;
    ListView lvVegetal;
    ListView lvComplemento;
    ListView lvBebida;

    Ingrediente[] carneItens;
    Ingrediente[] queijoItens;
    Ingrediente[] vegetalItens;
    Ingrediente[] complementoItens;
    Ingrediente[] bebidaItens;

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        for (int i = 0; i < tabLayout.getTabCount(); i++) {

            switch (i) {
                case 0:
                    tabLayout.getTabAt(0).setIcon(R.drawable.tab_icon_0);
                case 1:
                    tabLayout.getTabAt(1).setIcon(R.drawable.tab_icon_1);
                case 2:
                    tabLayout.getTabAt(2).setIcon(R.drawable.tab_icon_2);
                case 3:
                    tabLayout.getTabAt(3).setIcon(R.drawable.tab_icon_3);
                case 4:
                    tabLayout.getTabAt(4).setIcon(R.drawable.tab_icon_4);
                case 5:
                    tabLayout.getTabAt(5).setIcon(R.drawable.tab_icon_5);
            }

        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Pedido Finalizado com sucesso!", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();

                Intent intent = new Intent(HomeActivity.this, PedidoActivity.class);
                startActivity(intent);

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            Intent intent = new Intent(HomeActivity.this, SobreActivity.class);
            startActivity(intent);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            if (getArguments().getInt(ARG_SECTION_NUMBER) == 1) {
                View rootView = inflater.inflate(R.layout.fragment_massa, container, false);
                return rootView;
            } else if (getArguments().getInt(ARG_SECTION_NUMBER) == 2) {
                View rootView = inflater.inflate(R.layout.fragment_carne, container, false);
                return rootView;
            } else if (getArguments().getInt(ARG_SECTION_NUMBER) == 3) {
                View rootView = inflater.inflate(R.layout.fragment_queijo, container, false);
                return rootView;
            } else if (getArguments().getInt(ARG_SECTION_NUMBER) == 4) {
                View rootView = inflater.inflate(R.layout.fragment_complemento, container, false);
                return rootView;
            } else if (getArguments().getInt(ARG_SECTION_NUMBER) == 5) {
                View rootView = inflater.inflate(R.layout.fragment_vegetal, container, false);
                return rootView;
            } else if (getArguments().getInt(ARG_SECTION_NUMBER) == 6) {
                View rootView = inflater.inflate(R.layout.fragment_bebida, container, false);
                return rootView;
            } else {
                View rootView = inflater.inflate(R.layout.activity_home, container, false);
                return rootView;
            }

        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

//            if (position == 0) {
//                return new MassaFragment();
//            } else if (position == 1) {
//                return new CarneFragment();
//            } else if (position == 2) {
//                return new QueijoFragment();
//            } else if (position == 3) {
//                return new VegetalFragment();
//            } else if (position == 4) {
//                return new ComplementoFragment();
//            } else if (position == 5) {
//                return new BebidaFragment();
//            } else {
//                return null;
//            }

            // getItem is called to instantiate the fragment for the given page.

            // Return a PlaceholderFragment (defined as a static inner class below).
             return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 6 total pages.
            return 6;
        }


        /**@Override public CharSequence getPageTitle(int position) {
        switch (position) {
        case 0:
        return "Massas";
        case 1:
        return "Carnes";
        case 2:
        return "Queijos";
        case 3:
        return "Outros";
        case 4:
        return "Vegetais";
        case 5:
        return "Bebidas";
        }
        return null;
        }*/
    }

    @Override
    protected void onResume() {

        if(getIntent().getBooleanExtra("SAIR", false)){
            finish();
        }
        super.onResume();
    }

    //    @Override
//    public void onBackPressed() {
//
//        Intent intent = new Intent(HomeActivity.this, NovoLoginActivity.class);
//        startActivity(intent);
//
//    }
}
