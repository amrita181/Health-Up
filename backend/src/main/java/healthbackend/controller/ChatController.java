package healthbackend.controller;

import java.util.Map;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    @PostMapping({"/chat", "/chat/"})
    public Map<String, String> chat(@RequestBody Map<String, String> body) {
        String msg = body.getOrDefault("message", "").toLowerCase().trim();
        String reply;

        if (msg.isEmpty()) {
            reply = "Please type a question about diet, workout or BMI.";
        } else if (msg.contains("hello") || msg.contains("hi") || msg.contains("hey")) {
            reply = "Hi! I am Healthchef. Ask me about diet, workouts, BMI, water or sleep.";
        } else if (msg.contains("bmi")) {
            reply = "BMI = weight (kg) / height (m) squared. Below 18.5 is underweight, 18.5 to 24.9 is normal, 25 to 29.9 is overweight and 30+ is obese. Use the Body Analysis page for your plan.";
        } else if (msg.contains("fat") || msg.contains("weight loss") || msg.contains("lose")) {
            reply = "For fat loss: eat in a small calorie deficit, take enough protein, walk 8-10k steps daily, do strength training 3 times a week and sleep 7-8 hours.";
        } else if (msg.contains("muscle") || msg.contains("gain")) {
            reply = "For muscle gain: eat a small calorie surplus, 1.6-2 g protein per kg body weight, train each muscle twice a week with progressive overload and rest well.";
        } else if (msg.contains("diet") || msg.contains("food") || msg.contains("eat") || msg.contains("protein")) {
            reply = "A balanced plate: half vegetables and fruits, a quarter protein (dal, eggs, paneer, chicken) and a quarter whole grains. Limit junk food and sugary drinks.";
        } else if (msg.contains("workout") || msg.contains("exercise") || msg.contains("gym")) {
            reply = "A simple routine: walking or jogging 30 minutes, push-ups, squats and planks 3 sets each, 4 to 5 days a week. Warm up first and stretch after.";
        } else if (msg.contains("water") || msg.contains("hydrat")) {
            reply = "Aim for about 2 to 3 litres of water daily. Drink more if you exercise or the weather is hot.";
        } else if (msg.contains("sleep")) {
            reply = "Adults need 7 to 8 hours of sleep. Keep a fixed bedtime and avoid screens an hour before sleeping.";
        } else {
            reply = "I can help with diet, workouts, BMI, water and sleep. Try asking: 'How can I lose fat?' or 'What is a good workout?'";
        }

        return Map.of("reply", reply);
    }
}
