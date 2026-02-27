from abc import ABC, abstractmethod

# Продукт
class Message(ABC):
    @abstractmethod
    def deliver(self): pass

class SlackMessage(Message):
    def deliver(self): print("Sending Slack message...")

class DiscordMessage(Message):
    def deliver(self): print("Sending Discord message...")

# Creator (Factory Method)
class Messenger(ABC):
    @abstractmethod
    def create_message(self) -> Message: pass

    def send(self):
        msg = self.create_message()
        msg.deliver()

class SlackMessenger(Messenger):
    def create_message(self): return SlackMessage()

class DiscordMessenger(Messenger):
    def create_message(self): return DiscordMessage()

# Употреба
if __name__ == "__main__":
    app = SlackMessenger()
    app.send()
