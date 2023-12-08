package com.epam.mjc.nio;

public class BufferUnderflowException extends RuntimeException{
    public BufferUnderflowException(BufferUnderflowException m){
        super(m);
    }
}
