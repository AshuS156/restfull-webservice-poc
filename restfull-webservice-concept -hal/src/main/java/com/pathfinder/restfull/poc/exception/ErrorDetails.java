package com.pathfinder.restfull.poc.exception;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails{

    private String errorMessage;
    private String errorDetails;

    public String getErrorMessage(){
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage){
        this.errorMessage = errorMessage;
    }

    public String getErrorDetails(){
        return errorDetails;
    }

    public void setErrorDetails(String errorDetails){
        this.errorDetails = errorDetails;
    }

    @Override
    public String toString() {
        return "ErrorDetails [errorMessage=" + errorMessage + ", errorDetails=" + errorDetails + "]";
    }


}
