package com.rpam.rd.autotasks;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public final class CatchEmAll {

    private static final String RESOURCE_MISSING_MESSAGE = "Resource is missing";
    private static final String RESOURCE_ERROR_MESSAGE = "Resource error";
    static Exception exception = new FileNotFoundException();

    private CatchEmAll() {
    }

    public static void riskyMethod() throws Exception {
        throw exception;
    }

    public static void main(String[] args) throws Exception {
        try {
            riskyMethod();
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(RESOURCE_MISSING_MESSAGE, e);
        } catch (IOException e) {
            throw new IllegalArgumentException(RESOURCE_ERROR_MESSAGE, e);
        } catch (ArithmeticException | NumberFormatException e) {
            System.err.print(e.getMessage());
        }
    }
}

