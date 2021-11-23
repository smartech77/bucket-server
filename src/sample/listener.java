package sample;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class listener implements Runnable {

    int socket1;

    SqlRobot sql1 = new SqlRobot();

    public listener() {
    }

    public listener(int socket) {
        this.socket1 = socket;

    }

    //adds a new game


    public void run() {
//this method listens to the socket


        try (ServerSocket ss = new ServerSocket(socket1)) {
            while (1 > 0) {
                System.out.println(socket1);

                Socket s = ss.accept();
                DataInputStream din = new DataInputStream(s.getInputStream());
                DataOutputStream dout = new DataOutputStream(s.getOutputStream());


                String Paloki = din.readUTF();
                String[] Palokiz = Paloki.split("spergzilion");

                dout.writeUTF(filtertheneedful(Palokiz));

                dout.flush();
                try {
                    s.close();
                    din.close();
                    dout.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        } catch (IOException | SQLException exc) {
            System.out.println(exc.getMessage());
        }


    }

    //this basically filters what is received in the run method
    //and reacts accordingly
    // 1mode 2creator 3payload 4extra payload

    public String filtertheneedful(String[] TcpMessage) throws SQLException {

        System.out.println(TcpMessage[0] + TcpMessage[1] + TcpMessage[2] + TcpMessage[3]);


        ///////////////
        {

        return " Did a thing ";
    }
    //}




    }}


