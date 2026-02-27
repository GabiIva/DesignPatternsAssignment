interface Message { void deliver(); }

class SlackMessage implements Message {
    public void deliver() { System.out.println("Изпращане в Slack..."); }
}

class DiscordMessage implements Message {
    public void deliver() { System.out.println("Изпращане в Discord..."); }
}

abstract class Messenger {
    public abstract Message createMessage(); 
    public void send() {
        Message msg = createMessage();
        msg.deliver();
    }
}

class SlackMessenger extends Messenger {
    public Message createMessage() { return new SlackMessage(); }
}

class DiscordMessenger extends Messenger {
    public Message createMessage() { return new DiscordMessage(); }
}

public class MessengerApp {
    public static void main(String[] args) {
        Messenger app = new SlackMessenger();
        app.send();
    }
}
