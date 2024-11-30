package com.example.lab5;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        SQLiteConnection lite; //dimiourgia basis dedomenwn
        lite = new SQLiteConnection(this);

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        GameList gList = new GameList(getAssets());

        TextView v = (TextView) findViewById(R.id.txt);
        Button b1 = (Button) findViewById(R.id.nextBtn);
        Button b2 = (Button) findViewById(R.id.showBtn);

        v.setText(gList.message());

        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                v.setText(gList.message());
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "The winner is: " + gList.winner(), Toast.LENGTH_LONG).show();

                lite.insert(gList.getTeam1(), gList.getTeam2(), gList.winner());
            }
        });


    }
}