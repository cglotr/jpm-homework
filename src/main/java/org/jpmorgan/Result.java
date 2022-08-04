package org.jpmorgan;

public class Result<T> {
    private T data;
    private String error;

    public Result(T data) {
        this.data = data;
    }

    public Result(String error) {
        this.error = error;
    }

    public boolean isError() {
        return error != null;
    }

    public String error() {
        return error;
    }

    public T data() {
        return data;
    }
}
