package cn.itcast.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(reason="发生了自定义的异常", code=HttpStatus.INTERNAL_SERVER_ERROR)
public class MyException extends Exception{
	private static final long serialVersionUID = -6338525742557323248L;
}
