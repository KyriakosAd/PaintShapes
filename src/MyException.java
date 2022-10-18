class MyException extends Exception {
    MyException(String cause) {
        super(cause);
    }

    @Override
    public String toString() {
        return "MyException: " + super.toString();
    }
}