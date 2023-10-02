import java.io.*;
import java.net.*;

public class tcpServerExp {
    public static void main(String argv[]) throws Exception {
        String clientSentence;
        String capitalizedSentence;
        ServerSocket welcomeSocket = new ServerSocket(1234); 
        // สร้าง ServerSocket และเชื่อมต่อไว้ที่พอร์ต 1234

        while (true) { 
            // ในรอบนี้เราจะรอรับการเชื่อมต่อจาก client และบริการทุกๆ client ที่เชื่อมต่อเข้ามา
            Socket connectionSocket = welcomeSocket.accept(); 
            // รอรับการเชื่อมต่อจาก client และสร้าง Socket เพื่อรับข้อมูลจาก client นั้น

            System.out.println("Connected to a client."); 
            // แสดงข้อความบอกว่าเราเชื่อมต่อกับ client แล้ว

            InetAddress clientAddress = connectionSocket.getInetAddress(); 
            // รับที่อยู่ IP ของ client
            String clientIP = clientAddress.getHostAddress(); 
            // แปลงที่อยู่ IP ให้อยู่ในรูปของ String
            System.out.println("Connected to a client with IP: " + clientIP); 
            // แสดงที่อยู่ IP ของ client

            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream())); 
            // สร้าง BufferedReader เพื่ออ่านข้อมูลจาก client
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream()); 
            // สร้าง DataOutputStream เพื่อส่งข้อมูลกลับไปยัง client

            clientSentence = inFromClient.readLine(); 
            // รับข้อความจาก client
            capitalizedSentence = clientSentence.toUpperCase() + "\n"; 
            // แปลงข้อความให้เป็นตัวอักษรใหญ่ทั้งหมด

            outToClient.writeBytes(capitalizedSentence); 
            // ส่งข้อความให้กับ client

            connectionSocket.close(); 
            // ปิดการเชื่อมต่อกับ client
            System.out.println("Connection closed with the client."); 
            // แสดงข้อความบอกว่าการเชื่อมต่อกับ client ถูกปิด
        }
    }
}

// ลำดับการทำงาน:

// 1.เราสร้าง ServerSocket และเชื่อมต่อไว้ที่พอร์ต 1234 เพื่อรอรับการเชื่อมต่อจาก client.

// 2.เราใช้ลูป while (true) เพื่อรอรับและบริการ client ที่เชื่อมต่อเข้ามา.

// 3.เมื่อมีการเชื่อมต่อจาก client เข้ามา (Socket connectionSocket = welcomeSocket.accept();), เราจะสร้าง Socket แยกต่างหากสำหรับการรับข้อมูลจาก client นั้น.

// 4.เราแสดงข้อความบอกว่าเราเชื่อมต่อกับ client และแสดงที่อยู่ IP ของ client.

// 5.เราสร้าง BufferedReader เพื่ออ่านข้อมูลจาก client และ DataOutputStream เพื่อส่งข้อมูลกลับไปยัง client.

// 6.เราอ่านข้อความจาก client และแปลงให้เป็นตัวอักษรใหญ่ทั้งหมด.

// 7.เราส่งข้อความให้กับ client.

// 8.เราปิดการเชื่อมต่อกับ client และแสดงข้อความบอกว่าการเชื่อมต่อถูกปิด.

// 9.แล้วเรากลับไปรอรับการเชื่อมต่อจาก client ถัดไป
