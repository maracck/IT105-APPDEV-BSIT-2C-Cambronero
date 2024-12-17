package com.example.tabexperiment;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {
    private String[] tabs = {"Top Stories", "Tech News", "Cooking"};

//    void setSupportActionBar (Toolbar toolbar) {
//
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Para sa toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // toolbar??

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Naming of tab layout labels in toolbar
        TabLayout tabLayout = findViewById(R.id.tab_layout);

        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_label1));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_label2));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_label3));
        // end?

        final ViewPager2 viewPager = findViewById(R.id.pager);
        final PageAdapter adapter = new PageAdapter(getSupportFragmentManager(), getLifecycle());
        viewPager.setAdapter(adapter);

        adapter.addFragment(new TabFragment1());
        adapter.addFragment(new TabFragment2());
        adapter.addFragment(new TabFragment3());


        viewPager.setAdapter(adapter);
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> tab.setText(tabs[position])).attach();


        // end of onCreate
    }



}