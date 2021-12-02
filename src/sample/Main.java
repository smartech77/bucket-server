package sample;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

//finished project

public class Main {

    public static void main(String[] args) throws SQLException, InterruptedException {

        listener listener1 = new listener(3333);
        listener listener2 = new listener(3334);
        listener listener3 = new listener(3335);
        listener listener4 = new listener(3336);
        listener listener5 = new listener(3337);
        listener listener6 = new listener(3338);
        listener listener7 = new listener(3339);


        SqlSearcherObject sql2 = new SqlSearcherObject();

        //these seed the database with some values, if they don't appear in Mysql workbench something isn't working properly.
        System.out.println(sql2.insertTF("Paloki"));
        System.out.println(sql2.insertCLT("Paloki", 1));
        System.out.println(sql2.insertEmployee("Paloki","Palokijevic"));
        System.out.println(sql2.insertCLIT("Paloki",1,1,1));
        System.out.println(sql2.insertEmployeeChecklist(1,1,"1",1,"1"));



        ArrayList<listener> listeners = new ArrayList<listener>();
        listeners.add(listener1);
        listeners.add(listener2);
        listeners.add(listener3);
        listeners.add(listener4);
        listeners.add(listener5);
        listeners.add(listener6);
        listeners.add(listener7);
        ThreadPoolExecutor ThreadPoolExecutor1 = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
        ThreadPoolExecutor1.submit(() -> {
            listener1.run();
        });
        ThreadPoolExecutor1.submit(() -> {
            listener2.run();
        });
        ThreadPoolExecutor1.submit(() -> {
            listener3.run();
        });
        ThreadPoolExecutor1.submit(() -> {
            listener4.run();
        });
        ThreadPoolExecutor1.submit(() -> {
            listener5.run();
        });
        ThreadPoolExecutor1.submit(() -> {
            listener6.run();
        });
        ThreadPoolExecutor1.submit(() -> {
            listener7.run();
        });



        while (1 > 0) {
            for (int i = 0; i < listeners.size(); i++) {
                System.out.println(listeners.get(i).socket1);
            }
            Thread.sleep(10000);
        }


    }
}

