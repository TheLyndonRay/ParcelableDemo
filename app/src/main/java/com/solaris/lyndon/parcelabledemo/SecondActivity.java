package com.solaris.lyndon.parcelabledemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // When we get the object out of the intent, use the getParcelableExtra() helper method
        MultiMissileAttackGun currentWeapon = getIntent().getParcelableExtra("currentWeapon");

        TextView missileCountView = (TextView)findViewById(R.id.missile_count);

        //Now that we have the object out of the intent, use the object's getters like normally
        missileCountView.setText(" " + String.valueOf(currentWeapon.getMissileCount()) + " missiles!");

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.second, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
