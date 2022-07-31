package ca.lsuderman.worker;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkRequest;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class SingleWorker extends Worker {
    public SingleWorker (
            @NonNull Context context,
            @NonNull WorkerParameters params){
        super(context, params);
    }

    @NonNull
    @Override
    public Result doWork() {

        Log.d("Did it work?", "WORKED!!!");

        return Result.success();
    }

//    WorkRequest mySingleWorker =
//            new OneTimeWorkRequest.Builder(SingleWorker.class)
//                    .build();
}
