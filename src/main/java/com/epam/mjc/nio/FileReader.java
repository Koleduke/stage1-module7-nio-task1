package com.epam.mjc.nio;

import java.io.File;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


public class FileReader {
    private String nameR;
    private Integer ageR;
    private String emailR;
    private Long phoneR;
    public Profile getDataFromFile(File file) {
        StringBuilder input = new StringBuilder();
        try(RandomAccessFile aFile = new RandomAccessFile(file,"r");
            FileChannel inChannel = aFile.getChannel();)
        {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while (inChannel.read(buffer)>0){
                buffer.flip();
                for(int i =0;i<buffer.limit();i++){
                    input.append ((char)buffer.get());
                }
                buffer.clear();
            }
        } catch (IOException e) {
            throw new StudentNotFoundException(e);
        } catch (BufferUnderflowException e) {

            throw new BufferUnderflowException(e);
        }
        String[] sentences = input.toString().split("\n");
        for (int i = 0; i<sentences.length;i++ ){
            String[] sentences1 = sentences[i].split("\\s+");
            if(i==0){
                nameR = sentences1[1];}
            if(i==1){
                ageR = Integer.valueOf(sentences1[1]);}
            if(i==2){
                emailR = sentences1[1];}
            if(i==3){
                phoneR = Long.valueOf(sentences1[1]);}
        }
        return new Profile(nameR,ageR,emailR,phoneR);
    }
}
