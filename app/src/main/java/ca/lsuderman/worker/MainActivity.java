package ca.lsuderman.worker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private Button btnSingleWorker, btnPeriodicWorker, btnNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // SINGLE WORKER
        btnSingleWorker = findViewById(R.id.btnSingleWorker);
        btnSingleWorker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WorkRequest myWorkRequest = new OneTimeWorkRequest.Builder(SingleWorker.class)
                        .setInitialDelay(5, TimeUnit.SECONDS)
                        .build();
                WorkManager.getInstance().enqueue(myWorkRequest);
            }
        });

        // PERIODIC WORKER
        btnPeriodicWorker = findViewById(R.id.btnPeriodicWorker);
        btnPeriodicWorker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PeriodicWorkRequest request =
                        new PeriodicWorkRequest.Builder(SingleWorker.class, 5, TimeUnit.SECONDS)
                                .build();
                WorkManager.getInstance().enqueue(request);
            }
        });

        // SINGLE WORKER WITH NOTIFICATION
        btnNotification = findViewById(R.id.btnNotification);
        btnNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WorkRequest request = OneTimeWorkRequest.from(NotificationWorker.class);
                WorkManager.getInstance().enqueue(request);
            }
        });
    }
}