package com.jakir.showrateusdialogeveryfriday;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.jakir.rateusdialog.Rate_Dialog;
import com.jakir.rateusdialog.Rate_DialogHelper;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Check if the rate dialog should be shown
        if (Rate_DialogHelper.shouldShowRateDialog(this, Calendar.SUNDAY)) {
            showRateDialog();
        }
    }

    private void showRateDialog() {
        Rate_Dialog rate_dialog = new Rate_Dialog(this);
        rate_dialog.show();

        Rate_DialogHelper.saveRateDialogShown(this); // Save that the dialog was shown
    }
}