package leecode.SocketTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * ����* @author lee
 * ����* @date 2022/6/11 16:17
 */
public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 8080);) {

            System.out.println("connect!!");
            FileInputStream fileInputStream = new FileInputStream("pom.xml");
            OutputStream outputStream = socket.getOutputStream();
            byte[] bytes = new byte[1024*8];
            int i;
            while ((i = fileInputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, i);
            }
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
