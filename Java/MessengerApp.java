interface Message {
    void deliver();
}

class SlackMessage implements Message {
    @Override
    public void deliver() {
        System.out.println("Изпращане на съобщение в Slack...");
    }
}

class DiscordMessage implements Message {
    @Override
    public void deliver() {
        System.out.println("Изпращане на съобщение в Discord...");
    }
}

abstract class Messenger {
   public abstract Message createMessage();

    public void send() {
        Message msg = createMessage();
        msg.deliver();
    }
}

class SlackMessenger extends Messenger {
    @Override
    public Message createMessage() {
        return new SlackMessage();
    }
}

class DiscordMessenger extends Messenger {
    @Override
    public Message createMessage() {
        return new DiscordMessage();
    }
}

public class MessengerApp {
    public static void main(String[] args) {
        Messenger myApp = new SlackMessenger();
        myApp.send(); 
        
        Messenger myOtherApp = new DiscordMessenger();
        myOtherApp.send(); 
    }
}
