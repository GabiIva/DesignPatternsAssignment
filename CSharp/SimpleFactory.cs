using System;

namespace DesignPatterns
{
    public interface INotification { void Send(string message); }

    public class EmailNotification : INotification {
        public void Send(string message) => Console.WriteLine($"Email: {message}");
    }

    public class SmsNotification : INotification {
        public void Send(string message) => Console.WriteLine($"SMS: {message}");
    }

    public static class NotificationFactory {
        public static INotification Create(string type) => type.ToLower() switch {
            "email" => new EmailNotification(),
            "sms" => new SmsNotification(),
            _ => throw new ArgumentException("Unknown notification type")
        };
    }

    class Program {
        static void Main() {
            var notification = NotificationFactory.Create("email");
            notification.Send("Hello from C# Simple Factory!");
        }
    }
}
