package com.example.restaurant_list;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    ArrayList<String> list;
    RecyclerView rv;
    SimpleRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);

        list = new ArrayList<>();

        Button button = (Button) findViewById(R.id.button1);

        Toolbar tb = (Toolbar) findViewById(R.id.app_toolbar);
        tb.setTitle("Hello");
        setSupportActionBar(tb);

        View homeView = getLayoutInflater().inflate(R.layout.fragment_home, null);
        rv = (RecyclerView) homeView.findViewById(R.id.contents_recycler_view);
        rv.setLayoutManager(new LinearLayoutManager(this));
        adapter = new SimpleRecyclerAdapter(list);
        rv.setAdapter(adapter);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(navView, navController);

        View inflatedView = getLayoutInflater().inflate(R.layout.fragment_home, null);
        EditText editText = (EditText) inflatedView.findViewById(R.id.editText_home);
        editText.setOnEditorActionListener(new EditText.OnEditorActionListener(){
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent keyEvent){
                final boolean isEnterEvent = keyEvent != null && keyEvent.getKeyCode() == KeyEvent.KEYCODE_ENTER;
                final boolean isEnterUp = isEnterEvent && keyEvent.getAction() == KeyEvent.ACTION_UP;
                final boolean isEnterDown = isEnterEvent && keyEvent.getAction() == KeyEvent.ACTION_DOWN;
                if(actionId == EditorInfo.IME_ACTION_SEARCH || isEnterUp ){
                    changeListSize();
                }
                return true;
            }
        });
    }

    public void btnClick(View v){
        EditText editText = (EditText) findViewById(R.id.editText_home);
        String str = editText.getText().toString();
        int size = Integer.parseInt(str);
        TextView textView = (TextView) findViewById(R.id.text_home);
        textView.setText(str);
        list.clear();
        for(int i = 0; i < size; i ++){
            list.add("Text " + i);
        }
        adapter.notifyDataSetChanged();
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);

        AppBarLayout.LayoutParams params = (AppBarLayout.LayoutParams) collapsingToolbarLayout.getLayoutParams();
        if(size > 100){
            params.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS | AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL);
        }
        else{
            params.setScrollFlags(0);
        }
    }

    public void changeListSize(){
        EditText editText = (EditText) findViewById(R.id.editText_home);
        String str = editText.getText().toString();
        int size = Integer.parseInt(str);
        TextView textView = (TextView) findViewById(R.id.text_home);
        textView.setText(str);
        list.clear();
        for(int i = 0; i < size; i ++){
            list.add("Text " + i);
        }
        adapter.notifyDataSetChanged();
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);

        AppBarLayout.LayoutParams params = (AppBarLayout.LayoutParams) collapsingToolbarLayout.getLayoutParams();
        if(size > 100){
            params.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS | AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL);
        }
        else{
            params.setScrollFlags(0);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){
        switch (menuItem.getItemId()){
            case R.id.search_btn:
                Toast.makeText(getApplicationContext(), "hhh", Toast.LENGTH_LONG).show();
                return true;
            default:
                return true;
        }
    }
}
