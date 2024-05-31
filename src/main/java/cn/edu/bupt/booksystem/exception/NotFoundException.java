package cn.edu.bupt.booksystem.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message){
        super(message);
    }
}
