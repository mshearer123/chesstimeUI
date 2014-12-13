package com.shearer.matthew.chesstime;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;


public class NavigationDrawerFragment extends Fragment {


    public static final String ACCOUNT = "Account";
    public static final String GAMES = "Games";
    public static final String FRIENDS = "Friends";
    public static final String LEADERS = "Leaders";
    public static final String SETTINGS = "Settings";
    public static final String ABOUT = "About";
    public static final String HELP = "Help";


    private RecyclerView recyclerView;
    private NavigationListener listener;


    public static final String TAG = NavigationDrawerFragment.class.getName();

    public NavigationDrawerFragment() {

    }

    public static NavigationDrawerFragment newInstance(NavigationListener listener) {
        NavigationDrawerFragment instance = new NavigationDrawerFragment();
        instance.listener = listener;
        return instance;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // Select either the default item (0) or the last selected item.
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // Indicate that this fragment would like to influence the set of actions in the action bar.
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(
                R.layout.fragment_navigation_drawer, container, false);

        this.recyclerView = (RecyclerView) view.findViewById(R.id.navDrawerRecyclerView);
        this.recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        this.recyclerView.setLayoutManager(linearLayoutManager);

        String[] links = new String[10];
        links[0] = ACCOUNT;
        links[1] = GAMES;
        links[2] = FRIENDS;
        links[3] = LEADERS;
        links[4] = SETTINGS;
        links[5] = ABOUT;
        links[6] = HELP;

        NavAdapter adapter = new NavAdapter(links);
        recyclerView.setAdapter(adapter);
        return view;
    }


    public class NavAdapter extends RecyclerView.Adapter<NavAdapter.ViewHolder> {
        private String[] mDataset;


        public class ViewHolder extends RecyclerView.ViewHolder {

            public TextView titleTextView;

            public ViewHolder(View v) {
                super(v);
                titleTextView = (TextView) v.findViewById(R.id.nav_item_title);
            }
        }

        // Provide a suitable constructor (depends on the kind of dataset)
        public NavAdapter(String[] myDataset) {
            mDataset = myDataset;
        }

        // Create new views (invoked by the layout manager)
        @Override
        public NavAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                        int viewType) {
            // create a new view
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.nav_item, parent, false);

            ViewHolder vh = new ViewHolder(v);
            return vh;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {

            holder.titleTextView.setText(mDataset[position]);

        }


        @Override
        public int getItemCount() {
            return mDataset.length;
        }
    }

}
