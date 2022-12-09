package com.djxc.study.web.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.*;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SocketDemo {
    public static void main(String[] args) throws IOException
    {
        try (Socket s = new Socket("time-A.timefreq.bldrdoc.gov", 13))
        {
            InputStream inStream = s.getInputStream();
            Scanner in = new Scanner(inStream);

            while (in.hasNextLine())
            {
                String line = in.nextLine();
                System.out.println(line);
            }
        }

        InetAddress address = InetAddress.getByName("time-A.timefreq.bldrdoc.gov");
        System.out.println(address);
        //createServer();
        mutilCline();
    }

    public static void createServer() throws IOException
    {
        ServerSocket s = new ServerSocket(8189);
        Socket incoming = s.accept();
        Response(incoming);
    }


    public static void Response(Socket incoming)
    {
        try
        {
            try
            {
                InputStream inStream = incoming.getInputStream();
                OutputStream outStream = incoming.getOutputStream();
                Scanner in = new Scanner(inStream);

                PrintWriter out = new PrintWriter(outStream, true);
                out.println("hello! Enter BYE to exit.");
                boolean done = false;
                while(!done && in.hasNextLine())
                {
                    String line = in.nextLine();
                    out.println("Echo: " + line);
                    if (line.trim().equals("BYE"))
                        done = true;
                }
            }
            finally{
                incoming.close();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    /**
     * 多个客户端的连接，每一个客户端开启一个线程
     */
    public static void mutilCline()
    {
        try
        {
            int i =1;
            ServerSocket server = new ServerSocket(8189);
            while(true)
            {
                Socket incoming = server.accept();
                System.out.println("Spawning " + i);
                Thread t = new Thread(new Runnable(){
                    public void run(){ Response(incoming);}
                });
                t.start();
                i++;
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public void testURL() {
        String urlName = "http://horstmann.com";
        try{
            URL url = new URL(urlName);
            URLConnection connection = url.openConnection();
            connection.connect();
            Map<String, List<String>> header = connection.getHeaderFields();
            for(Map.Entry<String, List<String>> entry : header.entrySet()){
                String key = entry.getKey();
                for (String value : entry.getValue()){
                    System.out.println(key + " : " + value);
                }
            }
            Scanner in = new Scanner(connection.getInputStream());
            for (int i=1; in.hasNextLine() && i<11; i++){
                System.out.println(in.nextLine());
            }
        }catch(Exception e){
            System.out.println(e);
        }

    }
}
