package com.study.boardserver.exception;

public class DuplicateIdException extends RuntimeException {

    public DuplicateIdException(String msg) {
        // 상위 객체에 msg를 넘기겠다.
        super(msg);
    }
}
