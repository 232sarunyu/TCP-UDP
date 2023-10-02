import java.io.*;
import java.net.*;

public class udpServerExp {
    public static void main(String args[]) throws Exception {
        DatagramSocket serverSocket = new DatagramSocket(1234);
        // สร้าง DatagramSocket สำหรับรับข้อมูลผ่าน UDP ที่พอร์ต 1234

        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];
        // สร้าง buffer สำหรับข้อมูลที่จะรับและส่ง

        while (true) {
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            // รอรับ DatagramPacket จาก UDP client

            InetAddress clientAddress = receivePacket.getAddress(); // รับ IP Address ของ client
            int clientPort = receivePacket.getPort(); // รับพอร์ตของ client
            String sentence = new String(receivePacket.getData());
            // แปลงข้อมูลที่รับมาเป็น String

            System.out.println("Connected to a client from IP: " + clientAddress.getHostAddress());
            // แสดงข้อมูลเกี่ยวกับการเชื่อมต่อกับ client

            String capitalizedSentence = sentence.toUpperCase();
            // แปลงข้อความที่รับมาเป็นตัวพิมพ์ใหญ่ทั้งหมด

            sendData = capitalizedSentence.getBytes();
            // แปลงข้อมูลที่จะส่งกลับไปเป็น byte array

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
            // สร้าง DatagramPacket เพื่อส่งข้อมูลกลับไปยัง client

            serverSocket.send(sendPacket);
            // ส่ง DatagramPacket กลับไปยัง client
        }
    }
}

// กระบวนการทำงาน:

// 1.สร้าง DatagramSocket สำหรับการรอรับข้อมูลผ่าน UDP ที่พอร์ต 1234.

// 2.สร้าง buffer สำหรับข้อมูลที่จะรับและส่ง.

// 3.เข้าสู่ลูปไม้มีที่สิ้นสุดเพื่อรอรับ DatagramPacket จาก UDP client.

// 4.รอรับ DatagramPacket จาก UDP client และแสดงข้อมูลเกี่ยวกับการเชื่อมต่อกับ client แสดง IP Address ของ client.

// 5.แปลงข้อความที่รับมาเป็นตัวพิมพ์ใหญ่ทั้งหมด.

// 6.แปลงข้อมูลที่จะส่งกลับไปเป็น byte array.

// 7.สร้าง DatagramPacket เพื่อส่งข้อมูลกลับไปยัง client ที่ส่งข้อมูลมา.

// 8.ส่ง DatagramPacket กลับไปยัง client.

// 9.ทำขั้นตอนที่ 4-8 ในลูปตลอดเวลาเพื่อรอรับและส่งข้อมูลไป-กลับกับ UDP client.

