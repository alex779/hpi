/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alex.taskone.exception;

/**
 *
 * @author hovercat
 */
public class ValidationException extends Exception {

    public ValidationException() {
    }

    public ValidationException(String message) {
        super(message);
    }
    
}
