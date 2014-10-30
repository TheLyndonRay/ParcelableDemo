package com.solaris.lyndon.parcelabledemo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Lyndon on 10/29/2014.
 */
public class MultiMissileAttackGun implements Parcelable{

    protected int missileCount;

    public MultiMissileAttackGun(int missileCount){
        this.missileCount = missileCount;
    }

    // BEGIN THE REQUIRED PARCELABLE METHODS!

    /* This has to be private according to the API.
     * This is technically the Parcel constructor for your object.
     * Invoked by method createFromParcel(Parcel source) of object CREATOR */
    private MultiMissileAttackGun (Parcel in) {
        this.missileCount = in.readInt();
    }

    /* The creator of the ListItem Parcelable
     * Makes use of the private parcel Constructor
     * just above this. Some people call these the
     * "house keeping methods" for Parcelables*/
    public static final Parcelable.Creator<MultiMissileAttackGun> CREATOR = new Parcelable.Creator<MultiMissileAttackGun>(){

        //This is a mandatory override, NO CLUE WHAT IT'S REALLY DOING BUT YOU NEED IT!
        @Override
        public MultiMissileAttackGun createFromParcel(Parcel source){
            return new MultiMissileAttackGun(source);
        }

        //Same thing here, need it!
        @Override
        public MultiMissileAttackGun[] newArray(int size){
            return new MultiMissileAttackGun[size];
        }
    }; // This is an inline variable with anon methods so gotta put the semi-colon

    // Another method I don't know a thing about. BUT YOU NEED IT
    @Override
    public int describeContents(){
        return 0;
    }

    // Used for writing your fields to a parcel, is not the constructor but works like it
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(missileCount);
    }

    public int getMissileCount(){
        return missileCount;
    }

}
