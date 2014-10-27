package com.example.macbook.theapp;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 * Created by macbook on 10/24/14.
 */
public class AppendableObjectOutPutStream extends ObjectOutputStream {

    public AppendableObjectOutPutStream(OutputStream out) throws IOException {
        super(out);
    }

    @Override
    protected void writeStreamHeader() throws IOException {

    }
}
