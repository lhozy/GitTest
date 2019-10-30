package com.lh.t2;

import java.io.*;

public class ReadWrite {
    public static void main(String[] args) throws IOException {
        //mothed1();
        mothed2();


    }
    private static void mothed2() throws IOException {
        BufferedReader br =new BufferedReader(new FileReader("c:\\t.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("s2.txt"));
        String line = null;
        while((line = br.readLine()) != null){
            System.out.println(line);
            bw.write(line);
            //bw.append(line);
            bw.newLine();
        }
        bw.close();
        br.close();
    }

    private static void mothed1() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("c:\\t.txt"),"GBK"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Project02\\s1.txt")));
        String readLine ;

        while ((readLine = br.readLine()) != null){
            System.out.println(readLine);
            bw.write(readLine);
            bw.newLine();
        }
        br.close();
        bw.close();
    }
}
