package com.solaris.lyndon.parcelabledemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.Random;


public class MainActivity extends Activity {

    protected MultiMissileAttackGun currentWeapon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button createWeaponButton = (Button)findViewById(R.id.create);
        ButtonEventHandler eventHandler = new ButtonEventHandler();
        createWeaponButton.setOnClickListener(eventHandler);

    }

    protected MultiMissileAttackGun createNewMultiMissileAttackGun(){

        Random rand = new Random();
        MultiMissileAttackGun newWeapon = new MultiMissileAttackGun(rand.nextInt(9999) + 1);

        return newWeapon;
    }

    class ButtonEventHandler implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.create){
                currentWeapon = createNewMultiMissileAttackGun();
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);

                /* The magic of putting an object into an intent is that the
                 * Parcelable methods in the object's class get called automatically
                 * if they're present. If your class didn't implement Parcelable, placing
                 * the object into an intent would cause a compiler error
                 */
                intent.putExtra("currentWeapon", currentWeapon);
                startActivity(intent);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
