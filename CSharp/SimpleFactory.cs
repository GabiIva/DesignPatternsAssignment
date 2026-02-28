using System;

namespace DesignPatterns {
    public interface INotification { void Send(string msg); }

    public class EmailNotification : INotification {
        public void Send(string msg) => Console.WriteLine($"Email: {msg}");
    }

    public class SmsNotification : INotification {
        public void Send(string msg) => Console.WriteLine($"SMS: {msg}");
    }

    public static class NotificationFactory {
        
        public static INotification Create(string type) => type.ToLower() switch {
            "email" => new EmailNotification(),
            "sms" => new SmsNotification(),
            _ => throw new ArgumentException("Unknown type")
        };
    }

    class Program {
        static void Main() {
            var note = NotificationFactory.Create("email");
            note.Send("Hello from C# Simple Factory!");
        }
    }
}
