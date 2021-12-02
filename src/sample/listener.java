package sample;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;

public class listener implements Runnable {

    int socket1;

    SqlSearcherObject sql1 = new SqlSearcherObject();

    public listener() {
    }

    public listener(int socket) {
        this.socket1 = socket;

    }



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

    //this  filters what is received in the run method
    //and reacts accordingly


    public String filtertheneedful(String[] TcpMessage) throws SQLException {
     //   String[]Credentials = TcpMessage[2].split("aolaskjdfkjasdbf");

        if (TcpMessage[0].equals("deleteCLIT")) { return sql1.deleteCLIT(Integer.parseInt(TcpMessage[1])); }
        else if (TcpMessage[0].equals("deleteCLT")){ return sql1.deleteCLT(Integer.parseInt(TcpMessage[1])); }
        else if (TcpMessage[0].equals("deleteECL")){ return sql1.deleteECL(Integer.parseInt(TcpMessage[1]));  }
        else if (TcpMessage[0].equals("deleteEMP")){return sql1.deleteEMP(Integer.parseInt(TcpMessage[1]));}
        else if (TcpMessage[0].equals("deleteTF")){return sql1.deletetf(Integer.parseInt(TcpMessage[1]));}
        else if (TcpMessage[0].equals("pullCLIT")){return sql1.pullCLIT(Integer.parseInt(TcpMessage[1]));}
        else if (TcpMessage[0].equals("pullCLTnoITEMS")){return sql1.pullCLTnoITEMS(Integer.parseInt(TcpMessage[1]));}
        else if (TcpMessage[0].equals("pullEmployee")){return sql1.pullEmployee(Integer.parseInt(TcpMessage[1]));}
        else if (TcpMessage[0].equals("pullEmployeeCheckListECL")){return sql1.pullEmployeeCheckListECL(Integer.parseInt(TcpMessage[1]));}
        else if (TcpMessage[0].equals("pullTimeFrameTF")){return sql1.pullTimeFrameTF(Integer.parseInt(TcpMessage[1]));}

        else {

            String[]Payload = TcpMessage[3].split("0yormungandr0yormungandr0");

         if (TcpMessage[0].equals("insertCLIT")) {
                return sql1.insertCLIT(Payload[0],Integer.parseInt(Payload[1]),Integer.parseInt(Payload[2]),Integer.parseInt(Payload[3]) );
            } else if (TcpMessage[0].equals("insertCLT")) {
                return sql1.insertCLT(Payload[0],Integer.parseInt(Payload[1]));
            } else if (TcpMessage[0].equals("insertEmployee")) {
                return sql1.insertEmployee(Payload[0],Payload[0]);

            } else if (TcpMessage[0].equals("insertEmployeeChecklist")) {
                return sql1.insertEmployeeChecklist(Integer.parseInt(Payload[0]),Integer.parseInt(Payload[1]),Payload[2],Integer.parseInt(Payload[3]) , Payload[4]);
            } else if (TcpMessage[0].equals("insertTF")) {
                return sql1.insertTF(Payload[0]);
            } else if (TcpMessage[0].equals("updateCLIT")) {
                return sql1.updateCLIT(Payload[0],Integer.parseInt(Payload[1]),Integer.parseInt(Payload[2]));
            } else if (TcpMessage[0].equals("updateClt")) {
                return sql1.updateClt(Payload[0],Integer.parseInt(Payload[1]),Integer.parseInt(Payload[2]));
            } else if (TcpMessage[0].equals("updateEmployee")) {
                return sql1.updateEmployee(Payload[0],Payload[0], Integer.parseInt(Payload[0]));
            } else if (TcpMessage[0].equals("updateEmployeeChecklist")) {
                return sql1.updateEmployeeChecklist(Integer.parseInt(Payload[0]),Payload[1],Payload[2],Integer.parseInt(Payload[3]) );
            } else if (TcpMessage[0].equals("updateTF")) {
                return sql1.updateTF(Payload[0],Integer.parseInt(Payload[1]));
            }
        }

        {

        return " Did a thing ";
    }
    //}




    }}


