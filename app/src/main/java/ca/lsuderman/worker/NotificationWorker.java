package ca.lsuderman.worker;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class NotificationWorker extends Worker {

    public NotificationWorker (
            @NonNull Context context,
            @NonNull WorkerParameters params) {
        super(context, params);
    }

        @NonNull
        @Override
        public Result doWork(){
            NotificationHelper notificationHelper = new NotificationHelper();
            notificationHelper.setContext(getApplicationContext());
            notificationHelper.createNotification();

            return Result.success();
        }


}
