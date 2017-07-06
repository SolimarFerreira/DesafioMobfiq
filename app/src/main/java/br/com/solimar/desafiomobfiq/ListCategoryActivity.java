package br.com.solimar.desafiomobfiq;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.com.solimar.desafiomobfiq.fragments.ListCategoryFragment;
import br.com.solimar.desafiomobfiq.fragments.ListProductFragment;

public class ListCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new ListCategoryFragment())
                    .commit();
        }
    }
}
