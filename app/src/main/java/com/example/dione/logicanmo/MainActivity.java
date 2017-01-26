package com.example.dione.logicanmo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //region declarations
    private ExpandableListView expandableListView;
    private ExpandableListAdapter expandableListAdapter;
    private List<String> expandableListTitle;
    private List<String> ascendingList = new ArrayList<String>();
    private List<String> descendingList = new ArrayList<String>();
    private List<String> ascendingDescendingList = new ArrayList<String>();
    private List<String> bubbleSortList = new ArrayList<String>();
    //endregion
    int input = 5;
    String result = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Logic Exercises");
        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);

        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();

        showAscendingStars(expandableListDetail);
        showDescendingStars(expandableListDetail);
        showAscendingDescendingStars(expandableListDetail);
        bubbleSort(expandableListDetail);
        expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());
        expandableListAdapter = new ExpandableListAdapter(this, expandableListTitle, expandableListDetail);
        expandableListView.setAdapter(expandableListAdapter);
    }

    //First Problem
    //OUTPUT
    //*
    //**
    //***
    //****
    //*****
    private void showAscendingStars(HashMap<String, List<String>> expandableListDetail) {
        result="";

        for (int i=0;i<=input;i++) {
            for (int j=0;j<i;j++) {
                result += "*";
            }
            result+="\n";
        }
        ascendingList.add(result);
        expandableListDetail.put("Ascending Order", ascendingList);
        Log.d("FIRST", result);

    }

    //Second Problem
    //OUTPUT
    //*****
    //****
    //***
    //**
    //*
    private void showDescendingStars(HashMap<String, List<String>> expandableListDetail) {
        result = "";

        for (int i=input;i>0;i--) {
            for (int j=0;j<i;j++) {
                result += "*";
            }
            result+="\n";
        }
        descendingList.add(result);
        expandableListDetail.put("Descending Order", descendingList);
        Log.d("SECOND", result);
    }

    //Third Problem
    //OUTPUT
    //*
    //**
    //***
    //****
    //*****
    //****
    //***
    //**
    //*
    private void showAscendingDescendingStars(HashMap<String, List<String>> expandableListDetail) {
        result = "";

        for (int i=0;i<input;i++) {
            for (int j=0;j<i;j++) {
                result +="*";
            }
            result+="\n";
        }
        for (int i=input;i>0;i--) {
            for (int j=0;j<i;j++){
                result+="*";
            }
            result+="\n";
        }
        ascendingDescendingList.add(result);
        expandableListDetail.put("Ascending/Descending Order", ascendingDescendingList);
        Log.d("THIRD", result);
    }

    //Fourth Problem
    //INPUT [55,66,77,1,3,4,6,11]
    //OUTPUT [1,3,4,6,11,55,66,77]
    private void bubbleSort(HashMap<String, List<String>> expandableListDetail) {
        int[] arrayToSort = {55,66,77,1,3,4,6,11};
        String header = "Array - " + Arrays.toString(arrayToSort);

        for (int i=arrayToSort.length-1;i>0;i--) {
            for (int j=i-1;j>=0;j--) {
                if (arrayToSort[i] < arrayToSort[j]){
                    int temp = arrayToSort[i];
                    arrayToSort[i] = arrayToSort[j];
                    arrayToSort[j] = temp;
                }
            }
        }
        for (int i=arrayToSort.length - 1;i>=0;i--) {
            Log.d("FOURTH", String.valueOf(arrayToSort[i]));
        }
        bubbleSortList.add(header);
        bubbleSortList.add("Sorted - " + Arrays.toString(arrayToSort));
        expandableListDetail.put("Bubble Sort", bubbleSortList);

    }
}
