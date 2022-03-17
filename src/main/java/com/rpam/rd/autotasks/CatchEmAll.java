package com.rpam.rd.autotasks;

import java.io.FileNotFoundException;
import java.io.IOException;

public final class CatchEmAll {

    private static final String IO_EXCEPTION_STATUS = "IOException";
    private static final String FNF_EXCEPTION_STATUS = "FileNotFoundException";
    private static final String ARITHMETIC_EXCEPTION_STATUS = "ArithmeticException";
    private static final String NFE_EXCEPTION_STATUS = "NumberFormatException";
    private static final String RESOURCE_MISSING_MESSAGE = "Resource is missing";
    private static final String RESOURCE_ERROR_MESSAGE = "Resource error";
    public static Exception exception = null;

    private CatchEmAll() {
    }

    public static void riskyMethod() throws Exception {
        if (exception != null) {
            throw exception;
        }
    }



    public static void main(String[] args) {
        setException(args);
        printMessage();
    }

    public static void setException(String[] args) {
        if (args.length > 0) {
            switch (args[0]) {
                case IO_EXCEPTION_STATUS:
                    exception = new IOException(IO_EXCEPTION_STATUS);
                    break;
                case FNF_EXCEPTION_STATUS:
                    exception = new FileNotFoundException(FNF_EXCEPTION_STATUS);
                    break;
                case ARITHMETIC_EXCEPTION_STATUS:
                    exception = new ArithmeticException(ARITHMETIC_EXCEPTION_STATUS);
                    break;
                case NFE_EXCEPTION_STATUS:
                    exception = new NumberFormatException(ARITHMETIC_EXCEPTION_STATUS);
                    break;
                default:
                    break;
            }
        }
    }

    public static void printMessage() {
        try {
            riskyMethod();
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(RESOURCE_MISSING_MESSAGE, e);
        } catch (IOException e) {
            throw new IllegalArgumentException(RESOURCE_ERROR_MESSAGE, e);
        } catch (ArithmeticException | NumberFormatException e) {
            System.err.print(e.getMessage());
        } catch (Exception e) {
            doNothing();
        }
    }

    private static void doNothing() {
        //response to any other exceptions
    }

}

