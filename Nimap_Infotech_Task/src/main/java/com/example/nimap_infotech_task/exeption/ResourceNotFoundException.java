package com.example.nimap_infotech_task.exeption;



@SuppressWarnings("serial")
public class ResourceNotFoundException extends RuntimeException {
	
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
