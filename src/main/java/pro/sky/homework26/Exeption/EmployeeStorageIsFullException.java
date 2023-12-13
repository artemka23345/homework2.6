package pro.sky.homework26.Exeption;

public class EmployeeStorageIsFullException extends Exception {
    public EmployeeStorageIsFullException(String message) {
        super(message);
    }
}
