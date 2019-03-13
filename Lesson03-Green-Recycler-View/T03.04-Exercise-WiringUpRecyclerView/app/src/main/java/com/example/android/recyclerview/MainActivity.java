/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.recyclerview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import static android.graphics.Color.BLUE;
import static android.graphics.Color.GREEN;

public class MainActivity extends AppCompatActivity {

    // TODO (1) Create a private static final int called NUM_LIST_ITEMS and set it equal to 100
    private static final int NUM_LIST_ITEMS = 10;

    // TODO (2) Create a GreenAdapter variable called mAdapter
    // TODO (3) Create a RecyclerView variable called mNumbersList
    GreenAdapter mAdapter;
    RecyclerView mNumbersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // TODO (4) Use findViewById to store a reference to the RecyclerView in mNumbersList

        // TODO (5) Create a LinearLayoutManager variable called layoutManager
        // TODO (6) Use setLayoutManager on mNumbersList with the LinearLayoutManager we created above

        // TODO (7) Use setHasFixedSize(true) to designate that the contents of the RecyclerView won't change an item's size

        // TODO (8) Store a new GreenAdapter in mAdapter and pass it NUM_LIST_ITEMS

        // TODO (9) Set the GreenAdapter you created on mNumbersList

        mNumbersList = (RecyclerView) findViewById(R.id.rv_numbers);
        LinearLayoutManager LayoutManager = new LinearLayoutManager(this);
        mNumbersList.setLayoutManager(LayoutManager);
        mNumbersList.setHasFixedSize(true);
        mAdapter = new GreenAdapter(NUM_LIST_ITEMS);
        mNumbersList.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.it_reset:
                ResetItems();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void ResetItems() {

        int childs = mNumbersList.getChildCount();
        for (int i = 0; i < childs; ++i) {
            GreenAdapter.NumberViewHolder nvh = (GreenAdapter.NumberViewHolder) mNumbersList.findViewHolderForAdapterPosition(i);
            nvh.myView.setBackgroundColor(BLUE - i * 2);
            nvh.listItemNumberView.setBackgroundColor(GREEN + i * 2);
        }
    }
}
