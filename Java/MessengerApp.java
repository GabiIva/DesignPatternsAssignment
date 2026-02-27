interface MyMessage {
    void deliver();
}

class ViberMessage implements MyMessage {
    @Override
    public void deliver() {
        System.out.println("Изпращане на съобщение през Viber...");
    }
}

class MessengerMessage implements MyMessage {
    @Override
    public void deliver() {
        System.out.println("Изпращане на съобщение през Facebook Messenger...");
    }
}

abstract class MessageService {
    public abstract MyMessage createMessage();

    public void sendMessage() {
        MyMessage msg = createMessage();
        msg.deliver();
    }
}

class ViberService extends MessageService {
    @Override
    public MyMessage createMessage() {
        return new ViberMessage();
    }
}

class MessengerService extends MessageService {
    @Override
    public MyMessage createMessage() {
        return new MessengerMessage();
    }
}

public class MessengerApp {
    public static void main(String[] args) {
        MessageService service = new ViberService();
        service.sendMessage();
        
        MessageService secondService = new MessengerService();
        secondService.sendMessage();
    }
}
