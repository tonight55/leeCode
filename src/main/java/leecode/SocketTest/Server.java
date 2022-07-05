package leecode.SocketTest;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 　　* @author lee
 * 　　* @date 2022/6/11 16:14
 */
public class Server {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8080)) {
            Socket accept = server.accept();
            File file = new File("nwt/text.txt");
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            InputStream inputStream = accept.getInputStream();
            byte[] bytes = new byte[1024*8];
            int i;
            while ((i = inputStream.read(bytes)) != -1) {
                fileOutputStream.write(bytes, 0, i);
            }
            fileOutputStream.flush();
            accept.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
