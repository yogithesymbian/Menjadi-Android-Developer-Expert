package id.scode.exercise04ReyclerView;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import id.scode.scholarshipexpertscodeidev.R;
import id.scode.submission.BookSubmission;

public class ListView extends AppCompatActivity {

    public RecyclerView rvCategory;
    public ArrayList<Presiden> list;
    public ArrayList<BookSubmission> listDua;

//    private ArrayList<Presiden> list = new ArrayList<Presiden>();

//    private String title = "Mode List";

    final String STATE_TITLE = "state_title";
    final String STATE_LIST = "state_list";
    final String STATE_MODE = "state_mode";

    public int mode;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        rvCategory = findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

//        list.addAll(PresidenData.getListData());
//
//        showRvCv();
        listDua = new ArrayList<>();

        list = new ArrayList<>();

        if (savedInstanceState == null)
        {
            setTitleBar("Mode List");
            list.addAll(PresidenData.getListData());
            showRvList();
            mode = R.id.action_list;
        }
        else
        {
            String stateTitle = savedInstanceState.getString(STATE_TITLE);
            ArrayList<Presiden> stateList = savedInstanceState.getParcelableArrayList(STATE_LIST);
            int stateMode = savedInstanceState.getInt(STATE_MODE);

            setTitleBar(stateTitle);
            list.addAll(stateList);
            setMode(stateMode);
        }
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
//        switch (item.getItemId())
//        {
//            case R.id.action_list:
//                Log.d("LIST","List Choose Clicked");
//                setTitleBar("List View");
//                showRvList();
//                break;
//            case R.id.action_grid:
//                Log.d("LIST","Grid Choose Clicked");
//                setTitleBar("Grid View");
//                showRvGrid();
//                break;
//            case R.id.action_cardview:
//                Log.d("LIST","CardView Choose Clicked");
//                setTitleBar("CardView");
//                showRvCv();
//                break;
//
//        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_TITLE, getSupportActionBar().getTitle().toString());
        outState.putParcelableArrayList(STATE_LIST, list);
        outState.putInt(STATE_MODE, mode);
    }

    public void setMode(int selectedMode)
    {
        String title = null;
        switch (selectedMode)
        {
            case R.id.action_list:
                title = "List Mode";
                showRvList();
                break;
            case R.id.action_grid:
                title = "Grid Mode";
                showRvGrid();
                break;
            case R.id.action_cardview:
                title = "CardView Mode";
                showRvCv();
                break;
        }
        mode = selectedMode;
        setTitleBar(title);
    }

    public void showRvList()
    {
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        AdapterListPresident adapterListPresident = new AdapterListPresident(this);
        adapterListPresident.setListPresident(list);
        rvCategory.setAdapter(adapterListPresident);

        //for clicked support with pojo
        ItemClickSupport.addTo(rvCategory).setmOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedPresident(list.get(position));
            }
        });
    }

    private void showRvGrid()
    {
        rvCategory.setLayoutManager(new GridLayoutManager(this,2));
        AdapterGridPresident adapterGridPresident = new AdapterGridPresident(this);
        adapterGridPresident.setListPresident(list);
        rvCategory.setAdapter(adapterGridPresident);

        //for clicked
        ItemClickSupport.addTo(rvCategory).setmOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedPresident(list.get(position));
            }
        });
    }

    private void showRvCv()
    {
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        AdapterCardView adapterCardView = new AdapterCardView(this);
        adapterCardView.setListPresident(list);
        rvCategory.setAdapter(adapterCardView);
        //for clicked
        ItemClickSupport.addTo(rvCategory).setmOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedPresident(list.get(position));
            }
        });
    }

    public void setTitleBar(String title)
    {
//        getSupportActionBar().setTitle(title);
        Objects.requireNonNull(getSupportActionBar()).setTitle(title);
    }

    public void showSelectedPresident(Presiden presiden)
    {
        Toast.makeText(this, "Kamu Memilih " +presiden.getName(), Toast.LENGTH_SHORT).show();
    }

}
