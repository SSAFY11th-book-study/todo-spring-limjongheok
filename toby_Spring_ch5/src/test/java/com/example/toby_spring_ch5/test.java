package com.example.toby_spring_ch5;

import com.example.toby_spring_ch5.toby_spring_ch6.BufferedReaderCallback;
import com.example.toby_spring_ch5.toby_spring_ch6.LineCallback;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class test {

    @Test
    public Integer fileReadTemplate(String filepath, BufferedReaderCallback callback) throws IOException{
        BufferedReader br = null;

        try{
            br = new BufferedReader(new FileReader(filepath));
            int ret = callback.doSomethingWithReader(br);
            return ret;
        }catch (IOException e){
            System.out.println(e.getMessage());
            throw  e;
        }finally {
            if(br!= null){
                try{
                    br.close();
                }catch (IOException e){
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public Integer calcSum(String filepath) throws IOException{
        BufferedReaderCallback sumCallBack = new BufferedReaderCallback() {
            @Override
            public Integer doSomethingWithReader(BufferedReader br) throws IOException {
                Integer sum = 0;
                String line = null;
                while((line = br.readLine()) != null){
                    sum += Integer.valueOf(line);
                }
                return sum;
            }
        };
        return fileReadTemplate(filepath,sumCallBack);
    }
    // 곱

    public Integer calcMultiply(String filepath) throws IOException{
        BufferedReaderCallback sumCallBack = new BufferedReaderCallback() {
            @Override
            public Integer doSomethingWithReader(BufferedReader br) throws IOException {
                Integer multiply = 1;
                String line = null;
                while((line = br.readLine()) != null){
                    multiply *= Integer.valueOf(line);
                }
                return multiply;
            }
        };
        return fileReadTemplate(filepath,sumCallBack);
    }

    public Integer lineReadTemplate(String filpath, LineCallback callback , int initVal) throws IOException{
        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader(filpath));
            Integer res = initVal;
            String line = null;
            while((line = br.readLine()) != null){
                res = callback.doSomethingWithLine(line,res);
            }
            return res;
        }catch (IOException e){
            System.out.println(e.getMessage());
            throw  e;
        }finally {
            if(br!= null){
                try{
                    br.close();
                }catch (IOException e){
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public Integer calcSum2(String filepath) throws IOException{
        LineCallback sumCallback = new LineCallback() {
            @Override
            public Integer doSomethingWithLine(String line, Integer value) {
                return value + Integer.valueOf(line);

            }
        };
        return lineReadTemplate(filepath,sumCallback,0);
    }

    public Integer calcMultply2(String filepath) throws IOException{
        LineCallback sumCallback = new LineCallback() {
            @Override
            public Integer doSomethingWithLine(String line, Integer value) {
                return value * Integer.valueOf(line);

            }
        };
        return lineReadTemplate(filepath,sumCallback,1);
    }

}
