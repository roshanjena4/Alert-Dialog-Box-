package com.example.alertdialogbox;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.app.Dialog;
import android.content.DialogInterface;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    AlertDialog altNew;
    AlertDialog.Builder extDialog,accDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        For Alert Dialog box all required properties
        altNew = new AlertDialog.Builder(this).create();
        altNew.setTitle("New Group");
        altNew.setMessage("You are Creating new group");
        altNew.setIcon(R.drawable.baseline_group_add_24);
        altNew.setButton(Dialog.BUTTON_POSITIVE, "Proceed", (dialogInterface, i) -> Toast.makeText(MainActivity.this, "Thank You", Toast.LENGTH_SHORT).show());


//        For account dialog
        accDialog = new AlertDialog.Builder(this);
        accDialog.setTitle("Accounts");
        accDialog.setIcon(R.drawable.baseline_account_circle_24);
        accDialog.setMessage("DO you want to create new account");
        accDialog.setPositiveButton("Yes", (dialogInterface, i) -> Toast.makeText(MainActivity.this, "Account Created", Toast.LENGTH_SHORT).show());
        accDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Not Created", Toast.LENGTH_SHORT).show();
            }
        });
        accDialog.setNeutralButton("cancel", (dialogInterface, i) -> Toast.makeText(MainActivity.this, "Canceled", Toast.LENGTH_SHORT).show());


//        for exit dialog
        extDialog = new AlertDialog.Builder(this);
        extDialog.setTitle("Exit");
        extDialog.setIcon(R.drawable.baseline_exit_to_app_24);
        extDialog.setMessage("Do you want to exit from app");
        extDialog.setPositiveButton("Yes", (dialogInterface, i) -> System.exit(0));
        extDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Thank You stay in app", Toast.LENGTH_SHORT).show();
            }
        });
        extDialog.setNeutralButton("cancel", (dialogInterface, i) -> Toast.makeText(MainActivity.this, "Canceled", Toast.LENGTH_SHORT).show());


//      On back pressed



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater minflate = getMenuInflater();
        minflate.inflate(R.menu.opt_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int i = item.getItemId();
        if(i == R.id.grpnew)
        {
            altNew.show();
        }
        else if (i == R.id.account)
        {
            accDialog.show();
        }
        else
        {
            extDialog.show();
        }
        return super.onOptionsItemSelected(item);
    }


}