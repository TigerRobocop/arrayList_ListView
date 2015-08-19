package com.training.lsouza.arraylistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.editText_nameInput)
    EditText mTxt_nameInput;
    @Bind(R.id.listView_Names)
    ListView mListView_names;

    ArrayList<String> mArr_names;
    ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mArr_names = new ArrayList<>();

        if (savedInstanceState != null){
            mArr_names = savedInstanceState.getStringArrayList("LIST_NAMES");
        }
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mArr_names);

        mListView_names.setAdapter(mAdapter);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putStringArrayList("LIST_NAMES", mArr_names);
    }

    public void btnAddName_click(View view) {
        //gets value entered into the input
        String nameEntered = mTxt_nameInput.getText().toString();

        //add string into local arrayList
        mArr_names.add(nameEntered);

        //refresh adapter/listview
        mAdapter.notifyDataSetChanged();

        //clear txt input
        mTxt_nameInput.setText("");

    }
}
