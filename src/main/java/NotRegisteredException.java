public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String s) { //создадим контруктор который будет принимать сообщение об ошибке и передавать его в основной класс
        super(s);
    }
}
